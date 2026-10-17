package cloud.sin0.wc.web;

import cloud.sin0.wc.auth.Csrf;
import cloud.sin0.wc.auth.SessionUser;
import cloud.sin0.wc.client.FormusClient.CallContext;
import cloud.sin0.wc.client.FileAnswer;
import cloud.sin0.wc.client.Locales;
import cloud.sin0.wc.client.Upload;
import cloud.sin0.wc.config.AppConfig;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.http.HttpCookie;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.MultiPart;
import org.eclipse.jetty.http.MultiPartFormData;
import org.eclipse.jetty.io.content.InputStreamContentSource;
import org.eclipse.jetty.io.Content;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.Session;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.Fields;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Everything the handler needs about one request/response pair. Not thread-safe; one instance per request. */
public final class Ctx {

    public static final ObjectMapper JSON = new ObjectMapper();
    public static final String LANG_COOKIE = "fb_lang";
    /** Changes with every start of the server, so a deployed JAR is never served with a browser-cached older script or stylesheet. */
    public static final String ASSET_VERSION = Long.toString(System.currentTimeMillis() / 1000L, 36);

    /** Body larger than the configured limit. */
    public static final class TooLargeException extends IOException {
        public TooLargeException(long limit) {
            super("Body exceeds " + limit + " bytes");
        }
    }

    public final Request request;
    public final Response response;
    public final Callback callback;
    public final AppConfig cfg;
    public final ViewRenderer views;
    /** Added to every {@link #model()} of this request by the handler: navigation, home, footer, flash texts of the application. */
    public final Map<String, Object> shared = new LinkedHashMap<>();
    public final SessionUser user;
    public final String lang;
    private Fields query;

    public Ctx(Request request, Response response, Callback callback, AppConfig cfg, ViewRenderer views) {
        this.request = request;
        this.response = response;
        this.callback = callback;
        this.cfg = cfg;
        this.views = views;
        Session s = request.getSession(false);
        this.user = s == null ? null : SessionUser.from(s::getAttribute);
        this.lang = resolveLang();
    }

    // ------------------------------------------------------------------------------------------ request data

    public String path() {
        return Request.getPathInContext(request);
    }

    public String method() {
        return request.getMethod();
    }

    public String query(String name) {
        if (query == null) {
            query = Request.extractQueryParameters(request);
        }
        Fields.Field f = query.get(name);
        return f == null ? null : f.getValue();
    }

    public String header(String name) {
        return request.getHeaders().get(name);
    }

    public String cookie(String name) {
        List<HttpCookie> cookies = Request.getCookies(request);
        if (cookies != null) {
            for (HttpCookie c : cookies) {
                if (name.equals(c.getName())) {
                    return c.getValue();
                }
            }
        }
        return null;
    }

    public String ip() {
        return ClientInfo.ip(request, cfg.trustProxy());
    }

    /**
     * True when the browser is loading this page into a frame ({@code Sec-Fetch-Dest: iframe}, sent by the browser itself on every navigation of
     * the frame, redirects included): the layout then leaves out its own top bar and footer, because the page lives inside a shell that has them.
     */
    public boolean embedded() {
        return "iframe".equalsIgnoreCase(header("Sec-Fetch-Dest"));
    }

    public boolean wantsJson() {
        String accept = header("Accept");
        String type = header("Content-Type");
        return (accept != null && accept.contains("application/json")) || (type != null && type.contains("application/json"));
    }

    /** Reads the body as UTF-8 text, refusing anything over {@code max} bytes (Content-Length or streamed). */
    public String body(int max) throws IOException {
        long declared = request.getLength();
        if (declared > max) {
            throw new TooLargeException(max);
        }
        try (InputStream in = Content.Source.asInputStream(request)) {
            byte[] buf = in.readNBytes(max + 1);
            if (buf.length > max) {
                throw new TooLargeException(max);
            }
            return new String(buf, StandardCharsets.UTF_8);
        }
    }

    /** JSON object body or application/x-www-form-urlencoded; repeated form keys become lists. */
    public Map<String, Object> params(int max) throws IOException {
        String raw = body(max);
        Map<String, Object> out = new LinkedHashMap<>();
        if (raw.isBlank()) {
            return out;
        }
        String type = header("Content-Type");
        if (type != null && type.toLowerCase().contains("application/json")) {
            return JSON.readValue(raw, new TypeReference<LinkedHashMap<String, Object>>() { });
        }
        for (String pair : raw.split("&")) {
            if (pair.isEmpty()) {
                continue;
            }
            int eq = pair.indexOf('=');
            String k = URLDecoder.decode(eq >= 0 ? pair.substring(0, eq) : pair, StandardCharsets.UTF_8);
            String v = eq >= 0 ? URLDecoder.decode(pair.substring(eq + 1), StandardCharsets.UTF_8) : "";
            Object prev = out.get(k);
            if (prev == null) {
                out.put(k, v);
            } else if (prev instanceof List<?> l) {
                @SuppressWarnings("unchecked") List<Object> list = (List<Object>) l;
                list.add(v);
            } else {
                List<Object> list = new ArrayList<>();
                list.add(prev);
                list.add(v);
                out.put(k, list);
            }
        }
        return out;
    }

    // ------------------------------------------------------------------------------------------ file uploads

    /** The fields and files of a multipart post; closing it deletes the temporary files. */
    public record Posted(Map<String, Object> params, List<Upload> uploads) implements java.io.Closeable {
        @Override
        public void close() {
            for (Upload u : uploads) {
                try { Files.deleteIfExists(u.path()); } catch (IOException ignored) { /* left to the temp-dir cleanup */ }
            }
        }
    }

    public boolean isMultipart() {
        String type = header("Content-Type");
        return type != null && type.toLowerCase().startsWith("multipart/form-data");
    }

    /**
     * Reads a {@code multipart/form-data} post: text parts become parameters (repeated names become lists, like a urlencoded form), file parts
     * are written to temporary files (never held in memory) and listed as {@link Upload}s. A browser's empty file input (no file chosen) is
     * ignored. Over {@code maxFile} for one file or {@code maxRequest} for the whole post: {@link TooLargeException}.
     */
    public Posted multipart(long maxFile, long maxRequest) throws IOException {
        long declared = request.getLength();
        if (declared > maxRequest) throw new TooLargeException(maxRequest);
        String boundary = MultiPart.extractBoundary(header("Content-Type"));
        if (boundary == null) throw new IOException("multipart post without boundary");
        Path dir = Files.createDirectories(Path.of(System.getProperty("java.io.tmpdir"), "fwc-upload"));
        MultiPartFormData.Parser parser = new MultiPartFormData.Parser(boundary);
        parser.setMaxLength(maxRequest);
        parser.setMaxFileSize(maxFile);
        parser.setMaxMemoryFileSize(256 * 1024);
        parser.setFilesDirectory(dir);
        MultiPartFormData.Parts parts;
        try {
            parts = parser.parse(request).get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("interrupted while reading the upload", e);
        } catch (ExecutionException e) {
            throw new TooLargeException(maxFile < maxRequest ? maxFile : maxRequest);
        }
        Map<String, Object> out = new LinkedHashMap<>();
        List<Upload> uploads = new ArrayList<>();
        try {
            for (MultiPart.Part p : parts) {
                String file = p.getFileName();
                if (file == null) {
                    String v = p.getContentAsString(StandardCharsets.UTF_8);
                    Object prev = out.get(p.getName());
                    if (prev == null) out.put(p.getName(), v);
                    else if (prev instanceof List<?> l) {
                        @SuppressWarnings("unchecked") List<Object> list = (List<Object>) l;
                        list.add(v);
                    } else {
                        List<Object> list = new ArrayList<>();
                        list.add(prev);
                        list.add(v);
                        out.put(p.getName(), list);
                    }
                } else if (!file.isEmpty() && p.getLength() != 0) {
                    Path tmp = Files.createTempFile(dir, "up-", ".tmp");
                    p.writeTo(tmp);
                    String type = p.getHeaders().get(HttpHeader.CONTENT_TYPE);
                    uploads.add(new Upload(p.getName(), file, type, tmp, Files.size(tmp)));
                }
            }
        } catch (RuntimeException | IOException e) {
            new Posted(out, uploads).close();
            throw e;
        } finally {
            parts.close();
        }
        return new Posted(out, uploads);
    }

    /** Sends a file answered by formus-ws to the browser: same type, {@code attachment} disposition, range and length, streamed. */
    public void stream(FileAnswer f) {
        response.setStatus(f.status());
        response.getHeaders().put(HttpHeader.CONTENT_TYPE, f.contentType());
        response.getHeaders().put(HttpHeader.CONTENT_DISPOSITION, f.disposition());
        response.getHeaders().put("X-Content-Type-Options", "nosniff");
        response.getHeaders().put(HttpHeader.CACHE_CONTROL, "private, no-store");
        response.getHeaders().put(HttpHeader.ACCEPT_RANGES, "bytes");
        if (f.contentRange() != null) response.getHeaders().put(HttpHeader.CONTENT_RANGE, f.contentRange());
        if (f.length() >= 0) response.getHeaders().put(HttpHeader.CONTENT_LENGTH, f.length());
        Content.copy(new InputStreamContentSource(f.body()), response, Callback.from(
                () -> { closeQuietly(f); callback.succeeded(); },
                t -> { closeQuietly(f); callback.failed(t); }));
    }

    private static void closeQuietly(FileAnswer f) {
        try { f.close(); } catch (IOException ignored) { /* nothing to do */ }
    }

    // ------------------------------------------------------------------------------------------ session, csrf, language

    public Session session(boolean create) {
        return request.getSession(create);
    }

    public String csrfToken() {
        Session s = session(false);
        return s == null ? "" : Csrf.token(s::getAttribute, s::setAttribute);
    }

    /** Valid when the session token equals the {@code X-CSRF-Token} header or the given submitted form value. */
    public boolean csrfOk(String submittedField) {
        Session s = session(false);
        if (s == null) {
            return false;
        }
        String candidate = header("X-CSRF-Token");
        if (candidate == null || candidate.isBlank()) {
            candidate = submittedField;
        }
        return Csrf.matches(s::getAttribute, candidate);
    }

    private String resolveLang() {
        String q = query("lang");
        if (q != null && (q.equals("es") || q.equals("en"))) {
            Response.addCookie(response, HttpCookie.build(LANG_COOKIE, q).path("/").maxAge(365L * 24 * 3600)
                    .sameSite(HttpCookie.SameSite.LAX).secure(cfg.cookieSecure()).build());
            return q;
        }
        String c = cookie(LANG_COOKIE);
        if (c != null) {
            return Locales.siteLang(c);
        }
        return "es";
    }

    public void setCookie(String name, String value, long maxAgeSeconds, boolean httpOnly) {
        Response.addCookie(response, HttpCookie.build(name, value).path("/").maxAge(maxAgeSeconds).httpOnly(httpOnly)
                .sameSite(HttpCookie.SameSite.LAX).secure(cfg.cookieSecure()).build());
    }

    public void flash(String kind, String text) {
        Session s = session(true);
        s.setAttribute("flash.kind", kind);
        s.setAttribute("flash.text", text);
    }

    public CallContext callContext() {
        String locale = Locales.forBackend(lang, cfg.backendEnLocale());
        Session s = session(false);
        return new CallContext(locale, baseUri(), s == null ? null : s.getId(), user == null ? null : user.library());
    }

    /** Configured public origin, else the request's own (only trustworthy in dev, see BASE_URL). */
    public String baseUri() {
        String configured = cfg.baseUrl();
        if (configured != null && !configured.isBlank()) {
            return configured.endsWith("/") ? configured.substring(0, configured.length() - 1) : configured;
        }
        var uri = request.getHttpURI();
        return uri.getScheme() == null || uri.getAuthority() == null ? "" : uri.getScheme() + "://" + uri.getAuthority();
    }

    public Map<String, Object> model() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("lang", lang);
        m.put("csrfToken", csrfToken());
        m.put("brand", cfg.brand());
        m.put("brandLogo", cfg.brandLogo());
        m.put("assetV", ASSET_VERSION);
        m.put("embedded", embedded());
        if (user != null) {
            m.put("user", user.toModel());
            m.put("isStaff", user.isStaff());
        }
        Session s = session(false);
        if (s != null && s.getAttribute("flash.text") != null) {
            Map<String, Object> f = new LinkedHashMap<>();
            f.put("kind", s.getAttribute("flash.kind"));
            f.put("text", s.getAttribute("flash.text"));
            m.put("flash", f);
            s.removeAttribute("flash.kind");
            s.removeAttribute("flash.text");
        }
        m.putAll(shared);
        return m;
    }

    // ------------------------------------------------------------------------------------------ responses

    public void html(int status, String template, Map<String, Object> model) throws IOException {
        String name = views.exists(template) ? template : "_pending.ftl";
        if (!name.equals(template)) {
            model.put("pendingTemplate", template);
            model.put("pendingJson", pendingJson(model));
        }
        StringWriter w = new StringWriter();
        views.render(name, model, w);
        response.getHeaders().put(HttpHeader.CACHE_CONTROL, "no-store");
        write(status, "text/html; charset=UTF-8", w.toString());
    }

    private static String pendingJson(Map<String, Object> model) {
        try {
            Map<String, Object> copy = new LinkedHashMap<>(model);
            copy.remove("csrfToken");
            return JSON.writerWithDefaultPrettyPrinter().writeValueAsString(copy);
        } catch (Exception e) {
            return "(model not serialisable: " + e.getMessage() + ")";
        }
    }

    public void json(int status, Object body) throws IOException {
        response.getHeaders().put(HttpHeader.CACHE_CONTROL, "no-store");
        write(status, "application/json; charset=UTF-8", JSON.writeValueAsString(body));
    }

    /** Sends {@code body} as a downloaded CSV file called {@code fileName} (UTF-8). */
    public void csv(String fileName, String body) {
        response.getHeaders().put(HttpHeader.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName.replaceAll("[^A-Za-z0-9._-]", "_") + "\"");
        response.getHeaders().put("X-Content-Type-Options", "nosniff");
        response.getHeaders().put(HttpHeader.CACHE_CONTROL, "private, no-store");
        write(200, "text/csv; charset=UTF-8", body);
    }

    public void write(int status, String contentType, String body) {
        response.setStatus(status);
        response.getHeaders().put(HttpHeader.CONTENT_TYPE, contentType);
        response.write(true, BufferUtil.toBuffer(body, StandardCharsets.UTF_8), callback);
    }

    public void redirect(String location) {
        Response.sendRedirect(request, response, callback, 303, location, false);
    }

    public void redirectToLogin(boolean withNext) {
        String target = request.getHttpURI().getPathQuery();
        redirect(withNext && target != null ? "/login?next=" + enc(target) : "/login");
    }

    /**
     * Makes a JSON string safe to print inside {@code <script type="application/json">}: {@code </script>} and
     * {@code <!--} can no longer end or confuse the element, and the two JS line separators stay escaped.
     * The result is still valid JSON; templates print it with {@code ?no_esc}.
     */
    public static String scriptJson(String json) {
        return json.replace("<", "\\u003c").replace(">", "\\u003e").replace("&", "\\u0026")
                .replace("\u2028", "\\u2028").replace("\u2029", "\\u2029");
    }

    public static String enc(String s) {
        return URLEncoder.encode(s, StandardCharsets.UTF_8);
    }
}
