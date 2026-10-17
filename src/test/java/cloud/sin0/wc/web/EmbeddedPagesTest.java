package cloud.sin0.wc.web;

import cloud.sin0.wc.config.AppConfig;
import cloud.sin0.wc.testing.StubFormusWs;
import cloud.sin0.wc.testing.TestHttp;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** A page framed by a shell (an IDE with editors in tabs) leaves out its own chrome, and only an application that asks for it may be framed, and only by itself. */
class EmbeddedPagesTest {

    StubFormusWs backend;
    Server server;

    String start(boolean sameOriginFrames) throws Exception {
        backend = new StubFormusWs();
        Properties p = new Properties();
        p.setProperty("fb.port", "0");
        p.setProperty("fb.devLogin", "true");
        p.setProperty("fb.microservice.url", backend.url());
        p.setProperty("fb.footer.text", "Hecho por");
        server = WebClientServer.build(new AppConfig(p, Map.of()), new ViewRenderer(), new WebClientApp() {
            @Override public boolean allowSameOriginFrames() { return sameOriginFrames; }
            @Override public Map<String, String> footer(boolean en) { return Map.of("text", "Hecho por", "note", "© test"); }
        });
        server.start();
        return "http://localhost:" + ((ServerConnector) server.getConnectors()[0]).getLocalPort();
    }

    @AfterEach
    void stop() throws Exception {
        if (server != null) server.stop();
        if (backend != null) backend.stop();
    }

    @Test
    void aPageLoadedIntoAFrameHasNoTopBarNoFooterAndTheEmbeddedClass() throws Exception {
        String base = start(true);
        TestHttp b = new TestHttp(base);
        HttpResponse<String> normal = b.send("GET", "/login", null, null, Map.of());
        assertEquals(200, normal.statusCode());
        assertTrue(normal.body().contains("class=\"topbar\""), "a normal visit keeps the site's top bar");
        assertTrue(normal.body().contains("class=\"footer\""), "and its footer");
        assertFalse(normal.body().contains("embedded"));

        HttpResponse<String> framed = b.send("GET", "/login", null, null, Map.of("Sec-Fetch-Dest", "iframe"));
        assertEquals(200, framed.statusCode());
        assertFalse(framed.body().contains("class=\"topbar\""), "the shell has its own top bar");
        assertFalse(framed.body().contains("class=\"footer\""));
        assertTrue(framed.body().contains("<body class=\"embedded\""), "the page tells its CSS it is embedded: " + framed.body().substring(framed.body().indexOf("<body"), framed.body().indexOf("<body") + 60));
        assertTrue(framed.body().contains("fb-app.js"), "scripts and styles are untouched");
    }

    @Test
    void otherKindsOfRequestAreNotEmbedded() throws Exception {
        String base = start(true);
        TestHttp b = new TestHttp(base);
        for (String dest : new String[] {"document", "empty", "script", "image", ""}) {
            assertTrue(b.send("GET", "/login", null, null, dest.isEmpty() ? Map.of() : Map.of("Sec-Fetch-Dest", dest)).body().contains("class=\"topbar\""), "dest=" + dest);
        }
    }

    @Test
    void byDefaultNoPageCanBeFramedByAnyone() throws Exception {
        String base = start(false);
        HttpResponse<String> r = new TestHttp(base).send("GET", "/login", null, null, Map.of());
        assertEquals("DENY", r.headers().firstValue("X-Frame-Options").orElse(""));
        assertTrue(r.headers().firstValue("Content-Security-Policy").orElse("").contains("frame-ancestors 'none'"));
    }

    @Test
    void anApplicationThatAsksForItLetsOnlyItsOwnOriginFrameItsPages() throws Exception {
        String base = start(true);
        HttpResponse<String> r = new TestHttp(base).send("GET", "/login", null, null, Map.of());
        assertEquals("SAMEORIGIN", r.headers().firstValue("X-Frame-Options").orElse(""));
        String csp = r.headers().firstValue("Content-Security-Policy").orElse("");
        assertTrue(csp.contains("frame-ancestors 'self'") && !csp.contains("frame-ancestors 'none'") && !csp.contains("frame-ancestors *"), csp);
        assertTrue(csp.contains("default-src 'self'") && csp.contains("object-src 'none'"), "the rest of the policy is unchanged: " + csp);
    }
}
