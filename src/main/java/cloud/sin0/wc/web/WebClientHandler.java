package cloud.sin0.wc.web;

import cloud.sin0.wc.auth.Redirects;
import cloud.sin0.wc.client.BackendException;
import cloud.sin0.wc.client.FormusClient;
import cloud.sin0.wc.config.AppConfig;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * THE page handler of a web client, inserted into the servlet context's SessionHandler (SSO controllers under /auth and static files are
 * served elsewhere). Order of a request:
 * <ol>
 * <li>engine pages: {@code /health}, {@code /login};</li>
 * <li>the application's public routes (home, public forms, webhooks);</li>
 * <li>anything else needs a session: anonymous visitors go to /login (401 JSON for API callers);</li>
 * <li>the application's routes, then, for an operation address ({@link Coords}), the {@link CommandPipeline};</li>
 * <li>404.</li>
 * </ol>
 * It holds no HTML and no business rules.
 */
public class WebClientHandler extends Handler.Wrapper {

    private static final Logger LOG = LoggerFactory.getLogger(WebClientHandler.class);
    private static final Set<String> LOGIN_ERRORS = Set.of("session", "denied", "state", "provider", "noemail", "identify");

    private final AppConfig cfg;
    private final ViewRenderer views;
    private final WebClientApp app;
    private final Pages pages;
    private final CommandPipeline pipeline;
    private final List<Route> publicRoutes;
    private final List<Route> routes;
    private final boolean googleEnabled;
    private final boolean facebookEnabled;

    public WebClientHandler(AppConfig cfg, ViewRenderer views, FormusClient client, WebClientApp app, boolean googleEnabled, boolean facebookEnabled) {
        this.cfg = cfg;
        this.views = views;
        this.app = app;
        ViewResolver resolver = new ViewResolver(views);
        this.pages = new Pages(client, resolver);
        app.init(new WebClientContext(cfg, views, resolver, client, pages));
        this.pipeline = new CommandPipeline(cfg, pages, app.policy(cfg));
        this.publicRoutes = app.publicRoutes();
        this.routes = app.routes();
        this.googleEnabled = googleEnabled;
        this.facebookEnabled = facebookEnabled;
    }

    @Override
    public boolean handle(Request request, Response response, Callback callback) throws Exception {
        String path = Request.getPathInContext(request);
        if (path.startsWith("/auth/") || path.startsWith("/static/")) {
            return super.handle(request, response, callback);
        }
        Ctx c = new Ctx(request, response, callback, cfg, views);
        decorate(c);
        try {
            dispatch(c, path);
        } catch (Ctx.TooLargeException e) {
            LOG.warn("Oversized body on {} {}", request.getMethod(), path);
            pages.fail(c, 413, "too_large", null);
        } catch (BackendException e) {
            LOG.error("[{}] backend failure on {} {}: {}", e.correlationId(), request.getMethod(), path, e.getMessage());
            pages.fail(c, 502, "backend", e.correlationId());
        } catch (IOException e) {
            LOG.warn("Bad request on {} {}: {}", request.getMethod(), path, e.getMessage());
            pages.fail(c, 400, "bad_request", null);
        } catch (Exception e) {
            LOG.error("Unhandled error on {} {}", request.getMethod(), path, e);
            pages.fail(c, 500, "server", null);
        }
        return true;
    }

    /** Navigation, brand and footer of the application, in the request's language, for every template of this request. */
    private void decorate(Ctx c) {
        boolean en = "en".equals(c.lang);
        Map<String, Object> shared = c.shared;
        shared.put("home", app.home());
        shared.put("navItems", items(app.navigation(), en));
        shared.put("menuItems", items(app.userMenu(), en));
        Map<String, Object> flash = new LinkedHashMap<>();
        app.flashMessages().forEach((code, text) -> flash.put(code, en ? text[1] : text[0]));
        shared.put("flashMessages", flash);
        Map<String, String> footer = app.footer(en);
        footer.forEach((k, v) -> shared.put("footer" + Character.toUpperCase(k.charAt(0)) + k.substring(1), v));
    }

    private static List<Map<String, Object>> items(List<NavItem> in, boolean en) {
        List<Map<String, Object>> out = new java.util.ArrayList<>();
        for (NavItem n : in) {
            Map<String, Object> m = new LinkedHashMap<>();
            m.put("key", n.key());
            m.put("label", en ? n.en() : n.es());
            m.put("href", n.href());
            m.put("staffOnly", n.staffOnly());
            if (!n.children().isEmpty()) {
                m.put("children", items(n.children(), en));
            }
            out.add(m);
        }
        return out;
    }

    private void dispatch(Ctx c, String path) throws Exception {
        boolean get = "GET".equals(c.method());
        if ("/health".equals(path)) {
            if (get) c.json(200, Map.of("status", "ok")); else pages.methodNotAllowed(c);
            return;
        }
        if ("/login".equals(path)) {
            if (get) loginPage(c); else pages.methodNotAllowed(c);
            return;
        }
        for (Route r : publicRoutes) {
            if (r.handle(c)) {
                return;
            }
        }
        Coords k = Coords.parse(path);
        if (k == null && !app.protectedPath(path)) {
            if ("/".equals(path) && get) {
                c.redirect(c.user == null ? "/login" : app.home());
            } else {
                pages.notFound(c);
            }
            return;
        }
        if (c.user == null) {
            if (c.wantsJson() || !get) {
                c.json(401, Map.of("ok", false, "error", "unauthenticated"));
            } else {
                c.redirectToLogin(true);
            }
            return;
        }
        if (k == null || !k.raw()) {
            for (Route r : routes) {
                if (r.handle(c)) {
                    return;
                }
            }
        }
        if (k != null) {
            pipeline.run(c, k);
        } else {
            pages.notFound(c);
        }
    }

    private void loginPage(Ctx c) throws IOException {
        if (c.user != null) {
            c.redirect(app.home());
            return;
        }
        c.session(true);   // dev login needs a session-bound CSRF token
        Map<String, Object> m = c.model();
        Map<String, Object> providers = new LinkedHashMap<>();
        providers.put("google", googleEnabled);
        providers.put("facebook", facebookEnabled);
        providers.put("dev", cfg.devLogin());
        m.put("providers", providers);
        m.put("next", Redirects.sanitizeNext(c.query("next"), ""));
        String e = c.query("e");
        if (e != null && LOGIN_ERRORS.contains(e)) {
            m.put("errorCode", e);
        }
        c.html(200, "login.ftl", m);
    }
}
