package cloud.sin0.wc.client;

import cloud.sin0.wc.config.AppConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formuscmp.common.exception.ErrorMessage;
import com.formuscmp.formus.request.RequestResource;
import com.formuscmp.formus.response.ResponseResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * The only class that talks to formus-ws (rule: all backend access goes through here). Same protocol as
 * formuscmp-web-case's FormusMicroserviceClient.execute: POST a {@link RequestResource} as JSON; routing is
 * by body fields only. A non-2xx answer whose body is a parseable ResponseResource carrying
 * {@code errorMessages} is RETURNED (business error to render); only transport problems throw.
 */
public class FormusClient {

    private static final Logger LOG = LoggerFactory.getLogger(FormusClient.class);

    /** Per-call data taken from the inbound HTTP request. */
    /** A library name is part of a Redis key: letters, digits, underscore and hyphen only. */
    public static final java.util.regex.Pattern LIBRARY = java.util.regex.Pattern.compile("^[A-Za-z0-9_-]{1,20}$");

    /** {@code library}: the signed-in user's asset library; blank = the configured one. */
    public record CallContext(String locale, String baseUri, String sessionId, String library) {
        public static CallContext none() { return new CallContext("es_MX", null, null, null); }
    }

    private final AppConfig config;
    private final HttpClient http;
    /** Last answers of {@link Call#cacheable()} calls: operation + parameters -> ETag and body text. Small and bounded. */
    private final Map<String, CachedAnswer> cache = java.util.Collections.synchronizedMap(new java.util.LinkedHashMap<>(16, 0.75f, true) {
        @Override protected boolean removeEldestEntry(Map.Entry<String, CachedAnswer> e) { return size() > 32; }
    });

    private record CachedAnswer(String etag, String body) { }
    private final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public FormusClient(AppConfig config) {
        this.config = config;
        this.http = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(3)).build();
    }

    /** Fluent call description. */
    public Call call(Command command, CallContext ctx) {
        return new Call(command, ctx);
    }

    public final class Call {
        private final Command command;
        private final CallContext ctx;
        private final Map<String, Object> params = new HashMap<>();
        private String uuid, puuid, module, version;
        private Integer page;
        private final java.util.List<Upload> uploads = new java.util.ArrayList<>();
        private String range;
        private boolean cacheable;

        private Call(Command command, CallContext ctx) {
            this.command = command;
            this.ctx = ctx;
        }

        /** Null and blank strings are not sent. */
        public Call param(String k, Object v) {
            if (v != null && !(v instanceof String str && str.isBlank())) params.put(k, v);
            return this;
        }

        public Call params(Map<String, ?> m) { if (m != null) m.forEach(this::param); return this; }

        public Call uuid(String v) { this.uuid = v; return this; }

        public Call puuid(String v) { this.puuid = v; return this; }

        public Call page(Integer v) { this.page = v; return this; }

        /** Overrides the configured module/version (generic /{module}/.../{version}/{command}.do route). */
        public Call target(String module, String version) { this.module = module; this.version = version; return this; }

        /** Sends this file with the call (the request becomes multipart/form-data). */
        public Call attach(Upload u) { if (u != null) uploads.add(u); return this; }

        public Call attach(java.util.Collection<Upload> all) { if (all != null) all.forEach(this::attach); return this; }

        /** Forwards a {@code Range} header, for a command that answers with a file. */
        public Call range(String v) { this.range = v == null || v.isBlank() ? null : v; return this; }

        /**
         * Keeps the answer and revalidates it next time: the call sends the last ETag as {@code If-None-Match} and formus-ws answers 304 when
         * nothing changed, so the (large) body is not sent again. Only for reads (lists, catalogs); a call with uploads is never cached.
         */
        public Call cacheable() { this.cacheable = true; return this; }

        /** The JSON answer. A file answer is a {@link BackendException} here: use {@link #executeAny()} where a command may send one. */
        public ResponseResource execute() {
            Answer a = FormusClient.this.send(this);
            if (a.file() != null) {
                try { a.file().close(); } catch (Exception ignored) { /* nothing to do */ }
                throw new BackendException("El servicio devolvió un archivo; use executeAny()", null, null);
            }
            return a.json();
        }

        /** The JSON answer or, when the command sent one, the file. */
        public Answer executeAny() { return FormusClient.this.send(this); }
    }

    /** What formus-ws answered: the JSON envelope, or a file (exactly one is non-null). */
    public record Answer(ResponseResource json, FileAnswer file) { }

    private Answer send(Call c) {
        String url = config.backendUrl();
        if (url == null || url.isBlank()) {
            throw new BackendException("formus-ws URL is not configured (fb.microservice.url)", null, null);
        }
        RequestResource rr = new RequestResource();
        rr.setAssetLibrary(c.ctx != null && c.ctx.library() != null && LIBRARY.matcher(c.ctx.library()).matches() ? c.ctx.library() : config.assetLibrary());
        // precedence: explicit target() > the command's own module > configured module
        rr.setModule(c.module != null ? c.module : c.command.module() != null ? c.command.module() : config.module());
        rr.setVersion(c.version != null ? c.version : config.version());
        rr.setOrigin(config.origin());
        rr.setResourceType(c.command.resourceType());
        rr.setResourceName(c.command.resourceName());
        rr.setCommandName(Locales.command(c.command.name(), c.ctx == null ? null : c.ctx.locale()));
        rr.setFormat("html");
        rr.setParameters(new HashMap<>(c.params));
        rr.setUuid(c.uuid);
        rr.setPuuid(c.puuid);
        rr.setPageNumber(c.page);
        String correlationId = UUID.randomUUID().toString();
        rr.setCorrelationId(correlationId);
        if (c.ctx != null) {
            rr.setLocale(c.ctx.locale());
            rr.setBaseUri(c.ctx.baseUri());
            rr.setSessionId(c.ctx.sessionId());
        }

        String body;
        try {
            body = mapper.writeValueAsString(rr);
        } catch (Exception e) {
            throw new BackendException("No se pudo preparar la petición", correlationId, e);
        }

        String operation = endpoint(url, rr);
        LOG.info("[{}] formus-ws {}", correlationId, operation);   // the exact operation of openapi.yaml this page call maps to
        HttpRequest.Builder rb = HttpRequest.newBuilder(URI.create(operation))
                .timeout(Duration.ofMillis(config.backendTimeoutMs()))
                .header("Accept-Encoding", "gzip")   // formus-ws compresses its JSON when asked; files and old servers are unaffected
                .header("X-Request-Id", correlationId);
        if (c.uploads.isEmpty()) {
            rb.header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(body));
        } else {
            String boundary = "----fwc" + UUID.randomUUID().toString().replace("-", "");
            rb.header("Content-Type", "multipart/form-data; boundary=" + boundary).POST(multipart(boundary, body, c.uploads, correlationId));
            String token = config.uploadToken();
            if (token != null && !token.isBlank()) rb.header("X-Upload-Token", token);
            LOG.info("[{}] formus-ws upload of {} file(s)", correlationId, c.uploads.size());
        }
        if (c.range != null) rb.header("Range", c.range);
        String cacheKey = null;
        CachedAnswer cached = null;
        if (c.cacheable && c.uploads.isEmpty()) {
            cacheKey = operation + "|" + rr.getAssetLibrary() + "|" + rr.getLocale() + "|" + rr.getUuid() + "|" + rr.getPuuid() + "|" + rr.getPageNumber() + "|"
                    + new java.util.TreeMap<>(rr.getParameters());
            cached = cache.get(cacheKey);
            if (cached != null) rb.header("If-None-Match", cached.etag());
        }
        HttpRequest req = rb.build();

        HttpResponse<InputStream> raw;
        try {
            raw = http.send(req, HttpResponse.BodyHandlers.ofInputStream());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new BackendException("Petición interrumpida", correlationId, e);
        } catch (Exception e) {
            LOG.error("[{}] formus-ws unreachable at {} for {}/{}/{}", correlationId, url, c.command.resourceType(), c.command.resourceName(), c.command.name(), e);
            throw new BackendException("No se pudo comunicar con el servicio", correlationId, e);
        }
        String disposition = raw.headers().firstValue("Content-Disposition").orElse("");
        if (raw.statusCode() / 100 == 2 && disposition.toLowerCase(java.util.Locale.ROOT).startsWith("attachment")) {
            // formus-ws sends files as stored; if some server in between compressed one anyway, the browser must still get the file itself
            boolean zipped = "gzip".equalsIgnoreCase(raw.headers().firstValue("Content-Encoding").orElse(""));
            InputStream bytes;
            try {
                bytes = zipped ? new java.util.zip.GZIPInputStream(raw.body()) : raw.body();
            } catch (Exception e) {
                throw new BackendException("No se pudo leer el archivo recibido", correlationId, e);
            }
            return new Answer(null, new FileAnswer(raw.statusCode(), raw.headers().firstValue("Content-Type").orElse("application/octet-stream"), disposition,
                    raw.headers().firstValue("Content-Range").orElse(null), zipped ? -1 : raw.headers().firstValueAsLong("Content-Length").orElse(-1), bytes));
        }
        HttpResponse<String> res;
        try (InputStream in = "gzip".equalsIgnoreCase(raw.headers().firstValue("Content-Encoding").orElse("")) ? new java.util.zip.GZIPInputStream(raw.body()) : raw.body()) {
            res = new SimpleResponse(raw.statusCode(), new String(in.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8));
        } catch (Exception e) {
            LOG.error("[{}] formus-ws answer could not be read from {}", correlationId, url, e);
            throw new BackendException("No se pudo comunicar con el servicio", correlationId, e);
        }

        if (res.statusCode() == 304 && cached != null) {
            LOG.info("[{}] formus-ws 304: using the answer kept from the last call", correlationId);
            res = new SimpleResponse(200, cached.body());
        } else if (cacheKey != null && res.statusCode() == 200) {
            String etag = raw.headers().firstValue("ETag").orElse(null);
            if (etag != null) cache.put(cacheKey, new CachedAnswer(etag, res.body()));
        }
        boolean ok = res.statusCode() / 100 == 2;
        ResponseResource parsed;
        try {
            parsed = mapper.readValue(res.body(), ResponseResource.class);
        } catch (Exception e) {
            LOG.error("[{}] formus-ws answered {} with an unparseable body for {}/{}", correlationId, res.statusCode(), c.command.resourceName(), c.command.name());
            throw new BackendException("El servicio devolvió una respuesta no válida (HTTP " + res.statusCode() + ")", correlationId, e);
        }
        if (!ok && !hasErrors(parsed)) {
            LOG.error("[{}] formus-ws answered {} without error detail", correlationId, res.statusCode());
            throw new BackendException("El servicio devolvió HTTP " + res.statusCode(), correlationId, null);
        }
        if (!ok) {
            LOG.warn("[{}] {}/{} -> {} {}", correlationId, c.command.resourceName(), c.command.name(), res.statusCode(), parsed.getErrorMessages());
        }
        return new Answer(parsed, null);
    }

    /** The status and text of an answer already read (the part of HttpResponse the rest of {@link #send} uses). */
    private record SimpleResponse(int statusCode, String body) implements HttpResponse<String> {
        public HttpRequest request() { return null; }
        public java.util.Optional<HttpResponse<String>> previousResponse() { return java.util.Optional.empty(); }
        public java.net.http.HttpHeaders headers() { return java.net.http.HttpHeaders.of(Map.of(), (a, b) -> true); }
        public java.util.Optional<javax.net.ssl.SSLSession> sslSession() { return java.util.Optional.empty(); }
        public URI uri() { return null; }
        public HttpClient.Version version() { return HttpClient.Version.HTTP_1_1; }
    }

    /** {@code multipart/form-data}: part "request" is the JSON, then one part per file, streamed from their temporary files. */
    private static HttpRequest.BodyPublisher multipart(String boundary, String json, List<Upload> uploads, String correlationId) {
        List<HttpRequest.BodyPublisher> parts = new java.util.ArrayList<>();
        parts.add(HttpRequest.BodyPublishers.ofString("--" + boundary + "\r\nContent-Disposition: form-data; name=\"request\"\r\n"
                + "Content-Type: application/json; charset=UTF-8\r\n\r\n" + json + "\r\n"));
        for (Upload u : uploads) {
            String type = u.contentType() == null || u.contentType().isBlank() || u.contentType().matches(".*[\\r\\n].*") ? "application/octet-stream" : u.contentType();
            parts.add(HttpRequest.BodyPublishers.ofString("--" + boundary + "\r\nContent-Disposition: form-data; name=\"" + headerValue(u.field())
                    + "\"; filename=\"" + headerValue(u.filename()) + "\"\r\nContent-Type: " + type + "\r\n\r\n"));
            try {
                parts.add(HttpRequest.BodyPublishers.ofFile(u.path()));
            } catch (FileNotFoundException e) {
                throw new BackendException("No se pudo leer el archivo recibido", correlationId, e);
            }
            parts.add(HttpRequest.BodyPublishers.ofString("\r\n"));
        }
        parts.add(HttpRequest.BodyPublishers.ofString("--" + boundary + "--\r\n"));
        return HttpRequest.BodyPublishers.concat(parts.toArray(new HttpRequest.BodyPublisher[0]));
    }

    /** A value inside a quoted multipart header: no quote, CR or LF. */
    private static String headerValue(String v) {
        return v == null ? "" : v.replaceAll("[\"\\r\\n]", "_");
    }

    private static final String API_ROOT = "/api/v1/formus";

    /**
     * Operation URL per openapi.yaml: {@code {root}/{module}/{resourceType}/{resourceName}/{version}/{commandName}}. formus-ws routes
     * by the body, but the path is what shows in logs and proxies, so it must describe the call. The configured URL is the root; an
     * older value that already ends in a command path (".../api/v1/formus/case/basket/form/1.0/nuevo") is cut back to the root.
     */
    static String endpoint(String configured, RequestResource rr) {
        String root = configured.trim();
        int i = root.indexOf(API_ROOT);
        root = i >= 0 ? root.substring(0, i + API_ROOT.length()) : root.replaceAll("/+$", "");
        return root + "/" + String.join("/", rr.getModule(), rr.getResourceType(), rr.getResourceName(), rr.getVersion(), rr.getCommandName());
    }

    public static boolean hasErrors(ResponseResource r) {
        List<ErrorMessage> e = r == null ? null : r.getErrorMessages();
        return e != null && !e.isEmpty();
    }
}
