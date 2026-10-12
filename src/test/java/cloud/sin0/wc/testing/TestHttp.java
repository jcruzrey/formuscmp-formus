package cloud.sin0.wc.testing;

import java.io.ByteArrayOutputStream;
import java.net.CookieManager;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** A browser-like client: keeps cookies, never follows redirects (tests assert them), builds form/multipart bodies. */
public class TestHttp {

    public record Part(String name, String fileName, String contentType, byte[] bytes) {
        public static Part field(String name, String value) { return new Part(name, null, null, value.getBytes(StandardCharsets.UTF_8)); }

        public static Part file(String name, String fileName, String contentType, byte[] bytes) { return new Part(name, fileName, contentType, bytes); }
    }

    private final String base;
    private final HttpClient http = HttpClient.newBuilder().cookieHandler(new CookieManager()).followRedirects(HttpClient.Redirect.NEVER).build();

    public TestHttp(String base) {
        this.base = base;
    }

    public HttpResponse<String> get(String path) throws Exception {
        return http.send(HttpRequest.newBuilder(URI.create(base + path)).GET().build(), HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> getWithLanguage(String path, String acceptLanguage) throws Exception {
        return http.send(HttpRequest.newBuilder(URI.create(base + path)).header("Accept-Language", acceptLanguage).GET().build(), HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<byte[]> getBytes(String path) throws Exception {
        return http.send(HttpRequest.newBuilder(URI.create(base + path)).GET().build(), HttpResponse.BodyHandlers.ofByteArray());
    }

    public HttpResponse<String> postForm(String path, Map<String, String> fields) throws Exception {
        StringBuilder sb = new StringBuilder();
        fields.forEach((k, v) -> {
            if (sb.length() > 0) sb.append('&');
            sb.append(URLEncoder.encode(k, StandardCharsets.UTF_8)).append('=').append(URLEncoder.encode(v, StandardCharsets.UTF_8));
        });
        return http.send(HttpRequest.newBuilder(URI.create(base + path))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(sb.toString())).build(), HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> postMultipart(String path, List<Part> parts) throws Exception {
        String boundary = "----test" + System.nanoTime();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        for (Part p : parts) {
            out.writeBytes(("--" + boundary + "\r\n").getBytes(StandardCharsets.UTF_8));
            String disp = "Content-Disposition: form-data; name=\"" + p.name() + "\"" + (p.fileName() != null ? "; filename=\"" + p.fileName() + "\"" : "");
            out.writeBytes((disp + "\r\n").getBytes(StandardCharsets.UTF_8));
            if (p.contentType() != null) {
                out.writeBytes(("Content-Type: " + p.contentType() + "\r\n").getBytes(StandardCharsets.UTF_8));
            }
            out.writeBytes("\r\n".getBytes(StandardCharsets.UTF_8));
            out.writeBytes(p.bytes());
            out.writeBytes("\r\n".getBytes(StandardCharsets.UTF_8));
        }
        out.writeBytes(("--" + boundary + "--\r\n").getBytes(StandardCharsets.UTF_8));
        return http.send(HttpRequest.newBuilder(URI.create(base + path))
                .header("Content-Type", "multipart/form-data; boundary=" + boundary)
                .POST(HttpRequest.BodyPublishers.ofByteArray(out.toByteArray())).build(), HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> send(String method, String path, String contentType, String body, Map<String, String> headers) throws Exception {
        HttpRequest.Builder b = HttpRequest.newBuilder(URI.create(base + path));
        if (contentType != null) b.header("Content-Type", contentType);
        headers.forEach(b::header);
        b.method(method, body == null ? HttpRequest.BodyPublishers.noBody() : HttpRequest.BodyPublishers.ofString(body));
        return http.send(b.build(), HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> postJson(String path, String json, Map<String, String> headers) throws Exception {
        return send("POST", path, "application/json", json, headers);
    }

    public HttpResponse<String> getJson(String path) throws Exception {
        return send("GET", path, null, null, Map.of("Accept", "application/json"));
    }

    public static String location(HttpResponse<?> r) {
        return r.headers().firstValue("Location").orElse("");
    }

    private static final Pattern CSRF = Pattern.compile("name=\"_csrf\" value=\"([^\"]+)\"");

    /** The CSRF token embedded in a rendered page. */
    public static String csrf(String html) {
        Matcher m = CSRF.matcher(html);
        if (!m.find()) {
            throw new AssertionError("no _csrf field in page");
        }
        return m.group(1);
    }

    public static List<Part> parts(Part... p) {
        return new ArrayList<>(List.of(p));
    }
}
