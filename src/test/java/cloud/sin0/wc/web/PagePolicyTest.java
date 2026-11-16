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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** An application may ask for more than the default security headers for ONE page; an application that asks for nothing changes nothing. */
class PagePolicyTest {

    StubFormusWs backend;
    Server server;

    String start(WebClientApp app) throws Exception {
        backend = new StubFormusWs();
        Properties p = new Properties();
        p.setProperty("fb.port", "0");
        p.setProperty("fb.devLogin", "true");
        p.setProperty("fb.microservice.url", backend.url());
        server = WebClientServer.build(new AppConfig(p, Map.of()), new ViewRenderer(), app);
        server.start();
        return "http://localhost:" + ((ServerConnector) server.getConnectors()[0]).getLocalPort();
    }

    @AfterEach
    void stop() throws Exception {
        if (server != null) server.stop();
        if (backend != null) backend.stop();
    }

    static HttpResponse<String> get(String base, String path) throws Exception {
        return new TestHttp(base).send("GET", path, null, null, Map.of());
    }

    @Test
    void withoutAPolicyEveryPageKeepsTheDefaultHeaders() throws Exception {
        String base = start(new WebClientApp() { });
        HttpResponse<String> r = get(base, "/login");
        String csp = r.headers().firstValue("Content-Security-Policy").orElse("");
        assertEquals(SecurityHeadersHandler.CSP, csp);
        assertFalse(csp.contains("connect-src"));
        assertEquals("camera=(), microphone=(), geolocation=()", r.headers().firstValue("Permissions-Policy").orElse(""));
    }

    @Test
    void aPageThatAsksGetsItsSourcesAndTheMicrophoneAndOnlyThatPage() throws Exception {
        String base = start(new WebClientApp() {
            @Override public PagePolicy pagePolicy(String path) {
                return "/login".equals(path) ? new PagePolicy("https://*.provider.example wss://*.provider.example", "https://sdk.provider.example", true) : null;
            }
        });
        HttpResponse<String> asked = get(base, "/login");
        String csp = asked.headers().firstValue("Content-Security-Policy").orElse("");
        assertTrue(csp.contains("connect-src 'self' https://*.provider.example wss://*.provider.example;"), csp);
        assertTrue(csp.contains("media-src 'self' blob: https://sdk.provider.example;"), csp);
        assertTrue(csp.contains("script-src 'self' 'unsafe-inline'") && csp.contains("object-src 'none'") && csp.contains("form-action 'self'") && csp.endsWith("frame-ancestors 'none'"), "the rest is what every page has: " + csp);
        assertEquals("camera=(), microphone=(self), geolocation=()", asked.headers().firstValue("Permissions-Policy").orElse(""), "the camera stays off");
        assertEquals("DENY", asked.headers().firstValue("X-Frame-Options").orElse(""));

        HttpResponse<String> other = get(base, "/health");
        assertEquals(SecurityHeadersHandler.CSP, other.headers().firstValue("Content-Security-Policy").orElse(""), "any other page is untouched");
        assertEquals("camera=(), microphone=(), geolocation=()", other.headers().firstValue("Permissions-Policy").orElse(""));
    }

    @Test
    void aPolicyWithoutMicrophoneOrSourcesStillClosesTheOthers() throws Exception {
        String base = start(new WebClientApp() {
            @Override public PagePolicy pagePolicy(String path) { return new PagePolicy("", "", false); }
        });
        HttpResponse<String> r = get(base, "/login");
        assertTrue(r.headers().firstValue("Content-Security-Policy").orElse("").contains("connect-src 'self'; media-src 'self' blob:;"));
        assertEquals("camera=(), microphone=(), geolocation=()", r.headers().firstValue("Permissions-Policy").orElse(""));
    }

    @Test
    void aSourceThatCouldOpenThePolicyIsRefusedWhenItIsMade() {
        for (String malo : new String[] { "https://a.example; script-src *", "https://a.example, b", "'unsafe-eval'", "https://a.example\r\nX: y", "https://a\"b" }) {
            assertThrows(IllegalArgumentException.class, () -> new PagePolicy(malo, "", false), malo);
            assertThrows(IllegalArgumentException.class, () -> new PagePolicy("", malo, false), malo);
        }
        assertEquals("", new PagePolicy(null, null, false).connectSrc());
    }
}
