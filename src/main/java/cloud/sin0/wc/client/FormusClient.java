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

        public ResponseResource execute() { return FormusClient.this.execute(this); }
    }

    private ResponseResource execute(Call c) {
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
        HttpRequest req = HttpRequest.newBuilder(URI.create(operation))
                .timeout(Duration.ofMillis(config.backendTimeoutMs()))
                .header("Content-Type", "application/json")
                .header("X-Request-Id", correlationId)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> res;
        try {
            res = http.send(req, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new BackendException("Petición interrumpida", correlationId, e);
        } catch (Exception e) {
            LOG.error("[{}] formus-ws unreachable at {} for {}/{}/{}", correlationId, url, c.command.resourceType(), c.command.resourceName(), c.command.name(), e);
            throw new BackendException("No se pudo comunicar con el servicio", correlationId, e);
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
        return parsed;
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
