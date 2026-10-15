package cloud.sin0.wc.web;

import cloud.sin0.wc.auth.DevLoginServlet;
import cloud.sin0.wc.auth.FacebookProvider;
import cloud.sin0.wc.auth.GoogleProvider;
import cloud.sin0.wc.auth.LoginFlow;
import cloud.sin0.wc.auth.LogoutServlet;
import cloud.sin0.wc.auth.OAuthCallbackServlet;
import cloud.sin0.wc.auth.OAuthLoginServlet;
import cloud.sin0.wc.auth.OAuthProvider;
import cloud.sin0.wc.auth.SsoDisabledServlet;
import cloud.sin0.wc.auth.UserIdentifier;
import cloud.sin0.wc.client.FormusClient;
import cloud.sin0.wc.config.AppConfig;
import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.http.HttpCookie;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Wiring of a web client: static files at /static (the engine's and the application's, merged), a servlet context for the SSO controllers
 * under /auth, and {@link WebClientHandler} inserted into the context's SessionHandler. An application's {@code main} is one line:
 * {@code WebClientServer.run(new MyApp())}. {@link #build} is reusable by tests (ephemeral port, stub backend).
 */
public final class WebClientServer {

    private static final Logger LOG = LoggerFactory.getLogger(WebClientServer.class);

    private WebClientServer() { }

    public static void run(WebClientApp app) {
        AppConfig cfg = AppConfig.load();
        try {
            Server server = build(cfg, new ViewRenderer(), app);
            server.start();
            LOG.info("{} listening on port {}", cfg.brand(), ((ServerConnector) server.getConnectors()[0]).getLocalPort());
            server.join();
        } catch (Exception e) {
            LOG.error("Failed to start server", e);
            System.exit(1);
        }
    }

    public static Server build(AppConfig cfg, ViewRenderer views, WebClientApp app) {
        Server server = new Server(cfg.port());
        server.setStopAtShutdown(true);
        server.setStopTimeout(5000);

        app.templateVariables().forEach(views::setSharedVariable);
        FormusClient client = new FormusClient(cfg);

        ServletContextHandler servlets = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servlets.setContextPath("/");
        var sessions = servlets.getSessionHandler();
        sessions.setHttpOnly(true);
        sessions.setSameSite(HttpCookie.SameSite.LAX);
        sessions.setSecureRequestOnly(cfg.cookieSecure());
        sessions.setMaxInactiveInterval(cfg.sessionTimeoutMinutes() * 60);

        LoginFlow flow = new LoginFlow(new UserIdentifier(client, cfg), app.home());
        OAuthProvider google = new GoogleProvider(cfg.google());
        OAuthProvider facebook = new FacebookProvider(cfg.facebook());
        register(servlets, google, flow);
        register(servlets, facebook, flow);
        servlets.addServlet(new ServletHolder(new LogoutServlet()), "/auth/logout");
        if (cfg.devLogin()) {
            LOG.warn("DEV LOGIN is enabled (/auth/dev/login). Never enable it with COOKIE_SECURE=true / in production.");
            servlets.addServlet(new ServletHolder(new DevLoginServlet(flow)), "/auth/dev/login");
        } else {
            servlets.addServlet(new ServletHolder(new SsoDisabledServlet()), "/auth/dev/login");
        }

        sessions.insertHandler(new WebClientHandler(cfg, views, client, app, google.enabled(), facebook.enabled()));

        ResourceHandler staticFiles = new ResourceHandler();
        staticFiles.setBaseResource(staticResources(server));
        staticFiles.setDirAllowed(false);
        ContextHandler staticContext = new ContextHandler(staticFiles, "/static");

        server.setHandler(new SecurityHeadersHandler(new Handler.Sequence(staticContext, servlets), cfg.cookieSecure()));
        return server;
    }

    /** Every {@code static/} directory of the classpath (the engine's jar and the application's) as one tree; the classpath lists the application first, so its files win. */
    private static Resource staticResources(Server server) {
        try {
            List<URL> urls = Collections.list(WebClientServer.class.getClassLoader().getResources("static/"));
            ResourceFactory factory = ResourceFactory.of(server);
            List<Resource> found = new ArrayList<>();
            for (URL u : urls) {
                found.add(factory.newResource(u.toURI()));
            }
            return found.size() == 1 ? found.get(0) : ResourceFactory.combine(found);
        } catch (Exception e) {
            throw new IllegalStateException("Cannot locate the static resources", e);
        }
    }

    private static void register(ServletContextHandler ctx, OAuthProvider p, LoginFlow flow) {
        String base = "/auth/" + p.id();
        if (p.enabled()) {
            LOG.info("{} SSO enabled", p.id());
            ctx.addServlet(new ServletHolder(new OAuthLoginServlet(p)), base + "/login");
            ctx.addServlet(new ServletHolder(new OAuthCallbackServlet(p, flow)), base + "/callback");
        } else {
            LOG.warn("{} SSO disabled: credentials are not configured", p.id());
            ctx.addServlet(new ServletHolder(new SsoDisabledServlet()), base + "/login");
            ctx.addServlet(new ServletHolder(new SsoDisabledServlet()), base + "/callback");
        }
    }
}
