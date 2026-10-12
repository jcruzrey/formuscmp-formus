package cloud.sin0.wc.web;

import cloud.sin0.wc.client.Command;
import cloud.sin0.wc.client.FormusClient;
import com.formuscmp.common.exception.ErrorMessage;
import com.formuscmp.formus.button.Button;
import com.formuscmp.formus.resource.Resource;
import com.formuscmp.formus.response.ResponseResource;
import org.eclipse.jetty.server.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * What every page needs: the backend call carrying the caller's identity, the standard model of an answer, the template chosen by the
 * answer's view, and the error pages. Applications use it from their {@link Route}s; the generic pipeline uses it for every command.
 */
public final class Pages {

    private static final Logger LOG = LoggerFactory.getLogger(Pages.class);

    private final FormusClient client;
    private final ViewResolver resolver;

    public Pages(FormusClient client, ViewResolver resolver) {
        this.client = client;
        this.resolver = resolver;
    }

    // ---------------------------------------------------------------------------------------------------- backend

    /** A call to formus-ws carrying the caller's identity; the backend enforces scoping with it. */
    public FormusClient.Call call(Ctx c, Command command) {
        FormusClient.Call call = client.call(command, c.callContext());
        if (c.user != null) {
            call.param("username", c.user.email()).param("userId", c.user.id()).param("role", c.user.role());
        }
        return call;
    }

    // ---------------------------------------------------------------------------------------------------- model

    /**
     * The model a template of this answer can rely on: {@code resource}, {@code resources} (list), {@code data}, {@code errorMessages},
     * {@code view}, plus everything {@link Ctx#model()} carries (user, lang, brand, navigation, csrfToken...).
     */
    public Map<String, Object> backendModel(Ctx c, ResponseResource r) {
        Map<String, Object> m = c.model();
        m.put("resource", r.getResource());
        m.put("resources", r.getResources() == null ? List.of() : new ArrayList<>(r.getResources().values()));
        m.put("data", dataOf(r));
        m.put("errorMessages", messages(r));
        m.put("view", r.getView());
        return m;
    }

    /**
     * {@link #backendModel} plus what a page of the generic pipeline needs: {@code coords} (the operation that ran), {@code fieldErrors},
     * {@code buttons} (visible methods with the address each posts to), {@code formModel} (escaped JSON for the shared renderer, forms),
     * {@code columns} / {@code rows} / {@code pageInfo} (baskets) and {@code query}. A custom view template gets all of it for free.
     */
    public Map<String, Object> resultModel(Ctx c, ResponseResource r, Coords k) {
        Map<String, Object> m = backendModel(c, r);
        Map<String, Object> coords = new LinkedHashMap<>();
        coords.put("module", k.module());
        coords.put("type", k.type());
        coords.put("name", k.name());
        coords.put("version", k.version());
        coords.put("command", k.command());
        coords.put("path", k.path());
        m.put("coords", coords);
        m.put("fieldErrors", fieldErrors(r));
        m.put("query", queryParams(c));
        Resource res = r.getResource();
        if ("basket".equals(k.type())) {
            Resource form = r.getResources() == null ? null : r.getResources().get("form." + k.module() + "." + k.name());
            Resource of = form != null ? form : res;
            if (of != null) {
                List<Map<String, Object>> columns = BasketView.columnsOf(of);
                m.put("columns", columns);
                Map<String, Object> page = BasketView.pageOf(r, k.module(), k.name());
                m.put("rows", page.get("rows"));
                m.put("pageInfo", page);
                m.put("basketResource", of);
            }
        } else if (res != null) {
            List<Map<String, Object>> buttons = new ArrayList<>();
            if (res.getMethods() != null) {
                for (Button b : res.getMethods()) {
                    if (b != null && !b.isHidden() && b.getName() != null) {
                        Map<String, Object> bm = new LinkedHashMap<>();
                        String command = b.getCommandName() == null || b.getCommandName().isBlank() ? b.getName() : b.getCommandName();
                        bm.put("name", b.getName());
                        bm.put("label", b.getLabel() == null || b.getLabel().isBlank() ? b.getName() : b.getLabel());
                        bm.put("css", b.getCss() == null ? "" : b.getCss());
                        bm.put("command", command);
                        bm.put("action", k.path(command));
                        buttons.add(bm);
                    }
                }
            }
            m.put("buttons", buttons);
            if (res.getModel() != null && !res.getModel().isEmpty()) {
                try {
                    m.put("formModel", Ctx.scriptJson(Ctx.JSON.writeValueAsString(new PlatformFormMapper(Ctx.JSON).toBuilderModel(Ctx.JSON.valueToTree(res)))));
                } catch (Exception e) {
                    LOG.warn("The form model of {} could not be built: {}", k.path(), e.getMessage());
                }
            }
        }
        return m;
    }

    /** All query parameters of the request (first value each), for pages that keep filters in their links. */
    public static Map<String, Object> queryParams(Ctx c) {
        Map<String, Object> out = new LinkedHashMap<>();
        for (org.eclipse.jetty.util.Fields.Field f : Request.extractQueryParameters(c.request)) {
            if (out.size() < 60) {
                out.put(f.getName(), f.getValue());
            }
        }
        return out;
    }

    // ---------------------------------------------------------------------------------------------------- rendering

    /**
     * Renders {@code model} with the template the formus-ws answer asks for ({@code r.getView()}, resolved by {@link ViewResolver}), or
     * {@code defaultTemplate} when the answer carries no usable view (an error, or a view this client has no template for).
     */
    public void page(Ctx c, int status, ResponseResource r, String defaultTemplate, Map<String, Object> model) throws IOException {
        c.html(status, templateFor(r, defaultTemplate), model);
    }

    /** The template for an answer: its view when a local template exists and the answer has no errors, else the default. */
    public String templateFor(ResponseResource r, String defaultTemplate) {
        if (r != null && !FormusClient.hasErrors(r)) {
            String viewed = resolver.resolve(r.getView());
            if (viewed != null) {
                return viewed;
            }
            if (r.getView() != null && !r.getView().isBlank()) {
                LOG.debug("view '{}' has no local template; using {}", r.getView(), defaultTemplate);
            }
        }
        return defaultTemplate;
    }

    // ---------------------------------------------------------------------------------------------------- errors

    public void fail(Ctx c, int status, String code, String correlationId) throws IOException {
        if (c.wantsJson()) {
            c.json(status, Map.of("ok", false, "error", code));
            return;
        }
        Map<String, Object> m = c.model();
        m.put("status", status);
        m.put("code", code);
        m.put("correlationId", correlationId == null ? "" : correlationId);
        c.html(status, status == 404 ? "not-found.ftl" : "error.ftl", m);
    }

    public void notFound(Ctx c) throws IOException {
        fail(c, 404, "not_found", null);
    }

    public void methodNotAllowed(Ctx c) throws IOException {
        c.response.getHeaders().put("Allow", "GET, POST");
        fail(c, 405, "method_not_allowed", null);
    }

    public void methodOrNotFound(Ctx c, boolean pathMatched) throws IOException {
        if (pathMatched) methodNotAllowed(c); else notFound(c);
    }

    // ---------------------------------------------------------------------------------------------------- small helpers

    public static Map<String, Object> dataOf(ResponseResource r) {
        return r.getData() == null ? Map.of() : r.getData();
    }

    public static List<String> messages(ResponseResource r) {
        List<String> out = new ArrayList<>();
        if (r.getErrorMessages() != null) {
            for (ErrorMessage e : r.getErrorMessages()) {
                String text = e.getApplicationMessage() != null && !e.getApplicationMessage().isBlank() ? e.getApplicationMessage() : e.getMessage();
                out.add(text == null ? "error" : text);
            }
        }
        return out;
    }

    /**
     * Field messages of an answer: {@code data.errors} plus the {@code error} the platform writes on the model's fields. The generic commands
     * report validation as HTTP 200 with those (openapi.yaml section 5), so an answer without errorMessages can still be a refusal.
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> fieldErrors(ResponseResource r) {
        Map<String, String> out = new LinkedHashMap<>();
        Object e = r.getData() == null ? null : r.getData().get("errors");
        if (e instanceof Map<?, ?> map) {
            ((Map<Object, Object>) map).forEach((k, v) -> out.put(String.valueOf(k), String.valueOf(v)));
        }
        if (r.getResource() != null && r.getResource().getModel() != null) {
            r.getResource().getModel().forEach(f -> {
                if (f.getError() != null && !f.getError().isBlank() && f.getFieldName() != null) {
                    out.putIfAbsent(f.getFieldName(), f.getError());
                }
            });
        }
        return out;
    }

    /** The listed query parameters (blank when absent) so list templates can keep filters in their paging links. */
    public static Map<String, Object> queryEcho(Ctx c, String... names) {
        Map<String, Object> out = new LinkedHashMap<>();
        for (String n : names) {
            String v = c.query(n);
            out.put(n, v == null ? "" : v);
        }
        return out;
    }

    public static String str(Object o) {
        return o == null ? "" : o.toString();
    }

    public static int intParam(String raw, int def, int min, int max) {
        try {
            return Math.max(min, Math.min(max, Integer.parseInt(raw)));
        } catch (RuntimeException e) {
            return def;
        }
    }
}
