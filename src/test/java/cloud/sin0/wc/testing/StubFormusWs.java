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

/** A fake formus-ws: records every RequestResource and answers per "resourceName/commandName". */
public class StubFormusWs {

    private final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private final Server server = new Server(0);
    private final Map<String, Function<RequestResource, ResponseResource>> routes = new HashMap<>();
    private final List<RequestResource> calls = Collections.synchronizedList(new ArrayList<>());
    private volatile int forcedStatus = 0;

    public StubFormusWs() throws Exception {
        server.setHandler(new Handler.Abstract() {
            @Override
            public boolean handle(Request request, Response response, Callback callback) throws Exception {
                String body = Content.Source.asString(request, StandardCharsets.UTF_8);
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
                response.setStatus(status);
                response.getHeaders().put(HttpHeader.CONTENT_TYPE, "application/json");
                response.write(true, BufferUtil.toBuffer(mapper.writeValueAsString(out), StandardCharsets.UTF_8), callback);
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
