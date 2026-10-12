package cloud.sin0.wc.web;

import cloud.sin0.wc.auth.Csrf;
import cloud.sin0.wc.client.Command;
import cloud.sin0.wc.client.FormusClient;
import com.formuscmp.formus.response.ResponseResource;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.util.Fields;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The page of ANY formus-ws command, with no application code: the address names the operation, the engine runs it and the answer's
 * {@code view} names the template. A new model, command or view works by itself:
 * <ol>
 * <li>policy check ({@link AccessPolicy});</li>
 * <li>parameters: the query on GET, the body (form or JSON, CSRF checked) on POST; {@code uuid}, {@code puuid} and {@code page} also go to
 * the request's top-level fields, which is where formus-ws reads them;</li>
 * <li>JSON when the client asks for it ({@code Accept: application/json}); otherwise HTML: the template of {@code ResponseResource.getView()},
 * else the built-in {@code default/form.ftl} / {@code default/basket.ftl}, else {@code generic.ftl}.</li>
 * </ol>
 * The template receives the standard model of {@link Pages#resultModel}.
 */
public final class CommandPipeline {

    private static final Logger LOG = LoggerFactory.getLogger(CommandPipeline.class);

    private final cloud.sin0.wc.config.AppConfig cfg;
    private final Pages pages;
    private final AccessPolicy policy;

    public CommandPipeline(cloud.sin0.wc.config.AppConfig cfg, Pages pages, AccessPolicy policy) {
        this.cfg = cfg;
        this.pages = pages;
        this.policy = policy;
    }

    public void run(Ctx c, Coords k) throws Exception {
        if (!policy.allows(c, k)) {
            LOG.warn("Command {} refused for {}", k.path(), c.user == null ? "anonymous" : c.user.email());
            pages.fail(c, 403, "forbidden", null);
            return;
        }
        boolean get = "GET".equals(c.method());
        if (!get && !"POST".equals(c.method())) {
            pages.methodNotAllowed(c);
            return;
        }
        Map<String, Object> params = new LinkedHashMap<>();
        if (get) {
            for (Fields.Field f : Request.extractQueryParameters(c.request)) {
                params.put(f.getName(), f.getValue());
            }
        } else {
            params = c.params(cfg.maxBodyBytes());
            if (!c.csrfOk(Pages.str(params.get(Csrf.FIELD)))) {
                pages.fail(c, 403, "csrf", null);
                return;
            }
        }
        params.remove(Csrf.FIELD);
        params.remove("format");
        params.remove("lang");
        String uuid = Pages.str(params.get("uuid")), puuid = Pages.str(params.get("puuid"));
        Integer page = null;
        if (params.containsKey("page")) {
            page = Pages.intParam(Pages.str(params.remove("page")), 1, 1, 100_000);
        }

        FormusClient.Call call = pages.call(c, new Command(k.module(), k.type(), k.name(), k.command())).target(k.module(), k.version()).params(params);
        if (!uuid.isBlank()) call.uuid(uuid);
        if (!puuid.isBlank()) call.puuid(puuid);
        if (page != null) call.page(page);
        ResponseResource r = call.execute();
        boolean failed = FormusClient.hasErrors(r);

        if (c.wantsJson()) {
            Map<String, Object> out = new LinkedHashMap<>();
            out.put("ok", !failed);
            out.put("data", Pages.dataOf(r));
            out.put("messages", Pages.messages(r));
            out.put("fieldErrors", Pages.fieldErrors(r));
            out.put("view", r.getView());
            out.put("resource", r.getResource());
            c.json(failed ? 422 : 200, out);
            return;
        }
        String fallback = failed ? "generic.ftl" : "basket".equals(k.type()) ? "default/basket.ftl" : "form".equals(k.type()) ? "default/form.ftl" : "generic.ftl";
        pages.page(c, failed ? 422 : 200, r, fallback, pages.resultModel(c, r, k));
    }
}
