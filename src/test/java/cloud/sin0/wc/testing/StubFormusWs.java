package cloud.sin0.wc.testing;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formuscmp.common.exception.ErrorMessage;
import com.formuscmp.formus.request.RequestResource;
import com.formuscmp.formus.response.ResponseResource;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.io.Content;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.concurrent.ConcurrentHashMap;

/** A fake formus-ws: records every RequestResource and answers per "resourceName/commandName". */
public class StubFormusWs {

    private final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private final Server server = new Server(0);
    private final Map<String, Function<RequestResource, ResponseResource>> routes = new HashMap<>();
    private final List<RequestResource> calls = Collections.synchronizedList(new ArrayList<>());
    private volatile int forcedStatus = 0;
    private final List<Upload> uploads = Collections.synchronizedList(new ArrayList<>());
    private final List<String> uploadTokens = Collections.synchronizedList(new ArrayList<>());
    private final Map<String, StoredFile> files = new ConcurrentHashMap<>();
    private final java.util.concurrent.atomic.AtomicInteger gzipped = new java.util.concurrent.atomic.AtomicInteger();
    private final java.util.concurrent.atomic.AtomicInteger notModified = new java.util.concurrent.atomic.AtomicInteger();

    /** A file part the stub received (multipart relay from the engine). */
    public record Upload(String field, String filename, String contentType, byte[] bytes) { }

    /** A file the stub sends back when a route answers with {@code ResponseResource.attachment}. */
    public record StoredFile(String contentType, String filename, byte[] bytes, boolean gzip) {
        public StoredFile(String contentType, String filename, byte[] bytes) { this(contentType, filename, bytes, false); }
    }

    public StubFormusWs() throws Exception {
        server.setHandler(new Handler.Abstract() {
            @Override
            public boolean handle(Request request, Response response, Callback callback) throws Exception {
                // ISO-8859-1 keeps every byte, so a file part survives; the JSON is decoded as UTF-8 afterwards
                String latin = Content.Source.asString(request, StandardCharsets.ISO_8859_1);
                String type = request.getHeaders().get(HttpHeader.CONTENT_TYPE);
                String body;
                if (type != null && type.toLowerCase().startsWith("multipart/form-data")) {
                    String boundary = type.substring(type.indexOf("boundary=") + 9).trim();
                    body = parseMultipart(latin, boundary);
                    uploadTokens.add(request.getHeaders().get("X-Upload-Token"));
                } else {
                    body = new String(latin.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                }
                RequestResource rr = mapper.readValue(body, RequestResource.class);
                calls.add(rr);
                if (forcedStatus > 0) {
                    response.setStatus(forcedStatus);
                    response.getHeaders().put(HttpHeader.CONTENT_TYPE, "text/plain");
                    response.write(true, BufferUtil.toBuffer("boom", StandardCharsets.UTF_8), callback);
                    return true;
                }
                // "type:name/command" (e.g. "basket:form/nuevo") wins over "name/command": the platform's catalog and a stored form share a name
                Function<RequestResource, ResponseResource> fn = routes.get(rr.getResourceType() + ":" + rr.getResourceName() + "/" + rr.getCommandName());
                if (fn == null) {
                    fn = routes.get(rr.getResourceName() + "/" + rr.getCommandName());
                }
                ResponseResource out;
                int status = 200;
                if (fn == null) {
                    out = error(404, "No stub for " + rr.getResourceName() + "/" + rr.getCommandName());
                    status = 404;
                } else {
                    out = fn.apply(rr);
                    if (out.getErrorMessages() != null && !out.getErrorMessages().isEmpty()) {
                        status = out.getErrorMessages().get(0).getStatus() > 0 ? out.getErrorMessages().get(0).getStatus() : 422;
                    }
                }
                if (status == 200 && out.getAttachment() != null && files.containsKey(out.getAttachment().getStorageId())) {
                    StoredFile f = files.get(out.getAttachment().getStorageId());
                    byte[] all = f.bytes();
                    byte[] sent = all;
                    String range = request.getHeaders().get(HttpHeader.RANGE);
                    if (range != null && range.startsWith("bytes=")) {
                        String[] r = range.substring(6).split("-", -1);
                        int from = Integer.parseInt(r[0]);
                        int to = r[1].isEmpty() ? all.length - 1 : Math.min(all.length - 1, Integer.parseInt(r[1]));
                        sent = java.util.Arrays.copyOfRange(all, from, to + 1);
                        response.setStatus(206);
                        response.getHeaders().put(HttpHeader.CONTENT_RANGE, "bytes " + from + "-" + to + "/" + all.length);
                    } else {
                        response.setStatus(200);
                    }
                    response.getHeaders().put(HttpHeader.CONTENT_TYPE, f.contentType());
                    response.getHeaders().put(HttpHeader.CONTENT_DISPOSITION, "attachment; filename=\"" + f.filename() + "\"");
                    if (f.gzip()) {   // a misbehaving server in the middle that compresses the file
                        java.io.ByteArrayOutputStream z = new java.io.ByteArrayOutputStream();
                        try (java.util.zip.GZIPOutputStream g = new java.util.zip.GZIPOutputStream(z)) { g.write(sent); }
                        sent = z.toByteArray();
                        response.getHeaders().put(HttpHeader.CONTENT_ENCODING, "gzip");
                    }
                    response.write(true, java.nio.ByteBuffer.wrap(sent), callback);
                    return true;
                }
                String json = mapper.writeValueAsString(out);
                if (status == 200) {
                    // like formus-ws: a validator on successful answers, and 304 when the caller already has them
                    String etag = "W/\"" + Integer.toHexString(json.hashCode()) + "\"";
                    response.getHeaders().put(HttpHeader.ETAG, etag);
                    if (etag.equals(request.getHeaders().get(HttpHeader.IF_NONE_MATCH))) {
                        notModified.incrementAndGet();
                        response.setStatus(304);
                        callback.succeeded();
                        return true;
                    }
                }
                response.setStatus(status);
                response.getHeaders().put(HttpHeader.CONTENT_TYPE, "application/json");
                byte[] payload = json.getBytes(StandardCharsets.UTF_8);
                String accepts = request.getHeaders().get(HttpHeader.ACCEPT_ENCODING);
                if (accepts != null && accepts.contains("gzip") && payload.length > 512) {
                    java.io.ByteArrayOutputStream zipped = new java.io.ByteArrayOutputStream();
                    try (java.util.zip.GZIPOutputStream z = new java.util.zip.GZIPOutputStream(zipped)) { z.write(payload); }
                    payload = zipped.toByteArray();
                    response.getHeaders().put(HttpHeader.CONTENT_ENCODING, "gzip");
                    gzipped.incrementAndGet();
                }
                response.write(true, java.nio.ByteBuffer.wrap(payload), callback);
                return true;
            }
        });
        server.start();
    }

    public String url() {
        return "http://localhost:" + ((ServerConnector) server.getConnectors()[0]).getLocalPort() + "/api/v1/formus/visa";
    }

    public void on(String resourceCommand, Function<RequestResource, ResponseResource> fn) {
        routes.put(resourceCommand, fn);
    }

    public void reset() {
        routes.clear();
        calls.clear();
        uploads.clear();
        uploadTokens.clear();
        notModified.set(0);
        forcedStatus = 0;
    }

    /** Every call answers this HTTP status with a non-JSON body (simulates a broken backend). */
    public void breakWith(int status) { this.forcedStatus = status; }

    public List<RequestResource> calls() { return new ArrayList<>(calls); }

    public List<RequestResource> calls(String resourceCommand) {
        List<RequestResource> out = new ArrayList<>();
        for (RequestResource r : calls()) {
            if ((r.getResourceName() + "/" + r.getCommandName()).equals(resourceCommand)
                    || (r.getResourceType() + ":" + r.getResourceName() + "/" + r.getCommandName()).equals(resourceCommand)) {
                out.add(r);
            }
        }
        return out;
    }

    public void stop() throws Exception { server.stop(); }

    /** How many answers the stub compressed because the caller sent Accept-Encoding: gzip. */
    public int gzippedCount() { return gzipped.get(); }

    /** How many calls were answered 304 because they carried the current ETag. */
    public int notModifiedCount() { return notModified.get(); }

    /** Files received through multipart calls, in order. */
    public List<Upload> uploads() { return new ArrayList<>(uploads); }

    /** The {@code X-Upload-Token} of each multipart call (null when absent). */
    public List<String> uploadTokens() { return new ArrayList<>(uploadTokens); }

    /** Registers a file a route can send back by setting the answer's attachment storage id. */
    public void file(String storageId, String contentType, String filename, byte[] bytes) {
        files.put(storageId, new StoredFile(contentType, filename, bytes));
    }

    /** Like {@link #file} but the stub sends it gzip-compressed with Content-Encoding: gzip. */
    public void fileGzipped(String storageId, String contentType, String filename, byte[] bytes) {
        files.put(storageId, new StoredFile(contentType, filename, bytes, true));
    }

    /** Returns the JSON of the "request" part and records the file parts. */
    private String parseMultipart(String latin, String boundary) {
        String json = "{}";
        for (String part : latin.split("--" + java.util.regex.Pattern.quote(boundary))) {
            int split = part.indexOf("\r\n\r\n");
            if (split < 0) continue;
            String head = part.substring(0, split);
            String content = part.substring(split + 4);
            if (content.endsWith("\r\n")) content = content.substring(0, content.length() - 2);
            String name = headerParam(head, "name");
            String filename = headerParam(head, "filename");
            if (filename == null && "request".equals(name)) {
                json = new String(content.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            } else if (filename != null) {
                String ct = null;
                for (String line : head.split("\r\n")) if (line.toLowerCase().startsWith("content-type:")) ct = line.substring(13).trim();
                uploads.add(new Upload(name, filename, ct, content.getBytes(StandardCharsets.ISO_8859_1)));
            }
        }
        return json;
    }

    private static String headerParam(String head, String key) {
        java.util.regex.Matcher m = java.util.regex.Pattern.compile("[; ]" + key + "=\"([^\"]*)\"").matcher(head);
        return m.find() ? m.group(1) : null;
    }

    // ---- response builders
    public static ResponseResource data(Object... kv) {
        ResponseResource r = new ResponseResource();
        Map<String, Object> d = new HashMap<>();
        for (int i = 0; i < kv.length; i += 2) {
            d.put((String) kv[i], kv[i + 1]);
        }
        r.setData(d);
        return r;
    }

    public static ResponseResource error(int status, String message) {
        ResponseResource r = new ResponseResource();
        ErrorMessage e = new ErrorMessage();
        e.setStatus(status);
        e.setMessage(message);
        r.setErrorMessages(List.of(e));
        return r;
    }

    public static ResponseResource error(int status, String message, Map<String, String> fieldErrors) {
        ResponseResource r = error(status, message);
        r.setData(new HashMap<>(Map.of("errors", fieldErrors)));
        return r;
    }
}
