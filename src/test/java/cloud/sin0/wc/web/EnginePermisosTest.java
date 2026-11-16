package cloud.sin0.wc.web;

import cloud.sin0.wc.config.AppConfig;
import cloud.sin0.wc.testing.StubFormusWs;
import cloud.sin0.wc.testing.TestHttp;
import com.formuscmp.formus.response.ResponseResource;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Properties;

import static cloud.sin0.wc.testing.StubFormusWs.data;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The only authorization the engine has: the effective permisos of the signed-in user. There is no mode, no module list, no role that passes by itself (staff and administrators need grants
 * like anybody else), and a denial always wins. The public routes stay open with no session and with a user that has no grants.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EnginePermisosTest {

    StubFormusWs backend;
    Server server;
    String base;

    @BeforeAll
    void start() throws Exception {
        backend = new StubFormusWs();
        Properties p = new Properties();
        p.setProperty("fb.port", "0");
        p.setProperty("fb.devLogin", "true");
        p.setProperty("fb.microservice.url", backend.url());
        server = WebClientServer.build(new AppConfig(p, Map.of()), new ViewRenderer(), new WebClientEngineTest.TestApp());
        server.start();
        base = "http://localhost:" + ((ServerConnector) server.getConnectors()[0]).getLocalPort();
        backend.on("usuario/identificar", rr -> {
            String user = rr.getParameters().get("username").toString();
            String permisos = user.startsWith("lector") ? "inventario:producto:leer" : user.startsWith("gerente") ? "inventario,-inventario:producto:eliminar" : user.startsWith("root") ? "*" : "";
            return data("uuid", "u1", "rol", user.startsWith("staff") || user.startsWith("root") ? "staff" : "solicitante", "permisos", permisos);
        });
        backend.on("form:producto/detalle", rr -> new ResponseResource());
        backend.on("form:producto/eliminar", rr -> new ResponseResource());
    }

    @AfterAll
    void stop() throws Exception {
        server.stop();
        backend.stop();
    }

    TestHttp signIn(String email) throws Exception {
        TestHttp b = new TestHttp(base);
        String csrf = TestHttp.csrf(b.get("/login").body());
        HttpResponse<String> r = b.postForm("/auth/dev/login", Map.of("_csrf", csrf, "email", email, "next", ""));
        assertEquals(302, r.statusCode(), r.body());
        return b;
    }

    @Test
    void theEngineHasNoAuthorizationSettingsAtAll() {
        assertEquals(0, java.util.Arrays.stream(AppConfig.class.getMethods())
                .filter(m -> java.util.Set.of("authorizationMode", "authorizationByPermisos", "userModules", "deniedResources", "deniedCommands").contains(m.getName())).count(),
                "no mode, no module list, no configurable denied lists");
    }

    @Test
    void aUserWithoutGrantsAndAStaffWithoutGrantsAreRefusedAndAReaderOnlyReads() throws Exception {
        assertEquals(403, signIn("ana@example.com").get("/inventario/form/producto/1.0/detalle").statusCode());
        assertEquals(403, signIn("staff.boss@example.com").get("/inventario/form/producto/1.0/detalle").statusCode(), "the role staff passes nowhere by itself");
        TestHttp lector = signIn("lector@example.com");
        assertEquals(200, lector.get("/inventario/form/producto/1.0/detalle").statusCode());
        assertEquals(403, lector.get("/inventario/form/producto/1.0/eliminar").statusCode());
    }

    @Test
    void aDenialWinsOverAGrantAndStarGrantsEverythingExceptTheProtocolCommands() throws Exception {
        TestHttp gerente = signIn("gerente@example.com");
        assertEquals(200, gerente.get("/inventario/form/producto/1.0/detalle").statusCode());
        assertEquals(403, gerente.get("/inventario/form/producto/1.0/eliminar").statusCode(), "the denial wins");
        TestHttp root = signIn("root@example.com");
        assertEquals(200, root.get("/inventario/form/producto/1.0/eliminar").statusCode());
        assertEquals(403, root.get("/inventario/form/producto/1.0/webhook").statusCode(), "identity and webhook commands are never run through the pipeline");
        assertEquals(403, root.get("/inventario/form/producto/1.0/identificar").statusCode());
    }

    @Test
    void publicRoutesStayOpenForAnonymousAndForAUserWithoutGrants() throws Exception {
        TestHttp anonymous = new TestHttp(base);
        assertEquals(200, anonymous.get("/health").statusCode());
        assertEquals(200, anonymous.get("/login").statusCode());
        assertEquals(200, anonymous.get("/hello").statusCode(), "the application's public routes");
        assertTrue(anonymous.get("/hello").body().contains("anonymous"));
        assertTrue(anonymous.get("/auth/dev/login").statusCode() != 403, "the auth endpoints are not behind the policy");
        TestHttp user = signIn("ana@example.com");
        assertEquals(200, user.get("/health").statusCode());
        assertEquals(200, user.get("/hello").statusCode());
    }

    @Test
    void theNavigationShowsAnItemOnlyToWhoCanItAndPublicItemsToEverybody() throws Exception {
        String ana = signIn("ana@example.com").get("/mine").body();
        assertTrue(ana.contains("Existencias"), "an item with no permiso is public");
        assertFalse(ana.contains("Administración"), "an item that needs a permiso is hidden from whoever lacks it");
        String root = signIn("root@example.com").get("/mine").body();
        assertTrue(root.contains("Administración"), "whoever can the permiso sees it");
        String staffWithoutGrants = signIn("staff.boss@example.com").get("/mine").body();
        assertFalse(staffWithoutGrants.contains("Administración"), "the role staff shows nothing by itself");
    }

    @Test
    void thePageExposesThePermisosToTheScriptsAndAPlainNavItemIsPublic() throws Exception {
        String body = signIn("gerente@example.com").get("/mine").body();
        assertTrue(body.contains("data-permisos=\"inventario,-inventario:producto:eliminar\""), "the effective permisos reach FB.can");
        NavItem plain = new NavItem("k", "Es", "En", "/x");
        assertNull(plain.permiso(), "a plain item is public");
        assertEquals("case:studio:leer", plain.withPermiso("case:studio:leer").permiso());
    }
}
