package cloud.sin0.wc.web;

import cloud.sin0.wc.config.AppConfig;
import cloud.sin0.wc.testing.StubFormusWs;
import cloud.sin0.wc.testing.TestHttp;
import com.formuscmp.formus.response.ResponseResource;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Properties;

import static cloud.sin0.wc.testing.StubFormusWs.data;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** {@code fb.client.authorization=permisos}: the generic pipeline authorizes non-staff users by the permisos the backend answers at sign-in. */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PermisosPolicyTest {

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
        p.setProperty("fb.client.authorization", "permisos");
        p.setProperty("fb.client.userModules", "ventas");   // ignored in permisos mode
        server = WebClientServer.build(new AppConfig(p, Map.of()), new ViewRenderer(), new WebClientEngineTest.TestApp());
        server.start();
        base = "http://localhost:" + ((ServerConnector) server.getConnectors()[0]).getLocalPort();
    }

    @AfterAll
    void stop() throws Exception {
        server.stop();
        backend.stop();
    }

    @BeforeEach
    void defaults() {
        backend.reset();
        backend.on("usuario/identificar", rr -> {
            String user = rr.getParameters().get("username").toString();
            return data("uuid", "u1", "rol", user.startsWith("staff") ? "staff" : "solicitante",
                    "permisos", user.startsWith("lector") ? "inventario:producto:leer" : user.startsWith("gerente") ? "inventario, -inventario:producto:eliminar" : "");
        });
        backend.on("form:producto/detalle", rr -> new ResponseResource());
        backend.on("form:producto/guardar", rr -> new ResponseResource());
        backend.on("form:producto/eliminar", rr -> new ResponseResource());
    }

    TestHttp signIn(String email) throws Exception {
        TestHttp b = new TestHttp(base);
        String csrf = TestHttp.csrf(b.get("/login").body());
        HttpResponse<String> r = b.postForm("/auth/dev/login", Map.of("_csrf", csrf, "email", email, "next", ""));
        assertEquals(302, r.statusCode(), r.body());
        return b;
    }

    @Test
    void aUserWithoutPermisosIsRefusedEverywhere() throws Exception {
        TestHttp user = signIn("ana@example.com");
        assertEquals(403, user.get("/inventario/form/producto/1.0/detalle").statusCode());
        assertEquals(403, user.get("/ventas/form/pedido/1.0/nuevo").statusCode(), "userModules does not apply in permisos mode");
        assertEquals(0, backend.calls("form:producto/detalle").size());
    }

    @Test
    void readOnlyPermisosAllowReadingButNotWriting() throws Exception {
        TestHttp user = signIn("lector@example.com");
        assertEquals(200, user.get("/inventario/form/producto/1.0/detalle").statusCode());
        assertEquals(403, user.get("/inventario/form/producto/1.0/eliminar").statusCode());
        assertEquals(403, user.get("/ventas/form/pedido/1.0/detalle").statusCode());
    }

    @Test
    void aDenialInsideAGrantedModuleAndStaffBypass() throws Exception {
        TestHttp gerente = signIn("gerente@example.com");
        assertEquals(200, gerente.get("/inventario/form/producto/1.0/detalle").statusCode());
        assertEquals(403, gerente.get("/inventario/form/producto/1.0/eliminar").statusCode());
        assertEquals(200, signIn("staff.boss@example.com").get("/inventario/form/producto/1.0/eliminar").statusCode());
    }
}
