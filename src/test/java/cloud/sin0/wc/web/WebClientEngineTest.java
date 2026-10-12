package cloud.sin0.wc.web;

import cloud.sin0.wc.config.AppConfig;
import cloud.sin0.wc.testing.StubFormusWs;
import cloud.sin0.wc.testing.TestHttp;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formuscmp.formus.button.Button;
import com.formuscmp.formus.field.Field;
import com.formuscmp.formus.resource.Resource;
import com.formuscmp.formus.response.ResponseResource;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static cloud.sin0.wc.testing.StubFormusWs.data;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The engine with NO application code beyond a few routes: a brand-new model (module inventario, resource producto) is served by the
 * generic pipeline, its answer's view picks the template, and the application hooks (routes, navigation, policy) behave as documented.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WebClientEngineTest {

    static final ObjectMapper OM = new ObjectMapper();

    /** The smallest application: a public page, a signed-in page, a route that intercepts one command, a menu. */
    static final class TestApp implements WebClientApp {
        @Override public String home() { return "/mine"; }
        @Override public boolean protectedPath(String path) { return "/mine".equals(path); }
        @Override public List<Route> publicRoutes() {
            return List.of(c -> {
                if (!"/hello".equals(c.path())) return false;
                c.write(200, "text/plain", "hello " + (c.user == null ? "anonymous" : c.user.email()));
                return true;
            });
        }
        @Override public List<Route> routes() {
            return List.of(c -> {
                if ("/mine".equals(c.path())) {
                    c.html(200, "form/html/tablero.ftl", pagesModel(c));
                    return true;
                }
                Coords k = Coords.parse(c.path());
                if (k != null && "interceptado".equals(k.command())) {
                    c.write(200, "text/plain", "ROUTE " + k.path());
                    return true;
                }
                return false;
            });
        }
        @Override public List<NavItem> navigation() {
            return List.of(new NavItem("stock", "Existencias", "Stock", "/inventario/basket/producto/1.0/nuevo"),
                    new NavItem("admin", "Administración", "Admin", "/admin/basket/x/1.0/nuevo", true));
        }
        @Override public List<NavItem> userMenu() {
            return List.of(NavItem.group("Recursos", "Resources", new NavItem("stock", "Existencias del menú", "Stock in the menu", "/inventario/basket/producto/1.0/nuevo"),
                            new NavItem("admin", "Administración del menú", "Admin in the menu", "/admin/basket/x/1.0/nuevo", true)),
                    NavItem.heading("Cuenta", "Account"), new NavItem("profile", "Perfil", "Profile", "/perfil"));
        }
        @Override public Map<String, String[]> flashMessages() { return Map.of("ok", new String[]{"Listo", "Done"}); }
        @Override public Map<String, String> footer(boolean en) { return Map.of("text", "Hecho por", "note", "© test"); }

        private Map<String, Object> pagesModel(Ctx c) {
            Map<String, Object> m = c.model();
            m.put("resource", null);
            m.put("data", Map.of());
            m.put("coords", Map.of("command", "mine"));
            m.put("buttons", List.of());
            return m;
        }
    }

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
        p.setProperty("fb.client.userModules", "inventario");
        p.setProperty("fb.brand.name", "Mi Cliente");
        server = WebClientServer.build(new AppConfig(p, Map.of()), new ViewRenderer(), new TestApp());
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
        backend.on("usuario/identificar", rr -> data("uuid", "u1", "rol", rr.getParameters().get("username").toString().startsWith("staff") ? "staff" : "solicitante"));
        backend.on("form:producto/nuevo", rr -> producto(null));
    }

    TestHttp signIn(String email) throws Exception {
        TestHttp b = new TestHttp(base);
        String csrf = TestHttp.csrf(b.get("/login").body());
        HttpResponse<String> r = b.postForm("/auth/dev/login", Map.of("_csrf", csrf, "email", email, "next", ""));
        assertEquals(302, r.statusCode(), r.body());
        return b;
    }

    static ResponseResource producto(String view) {
        Resource r = new Resource();
        r.setName("producto");
        r.setModule("inventario");
        r.setTitle("Producto");
        r.setInstruction("Captura un producto");
        r.setView(view);
        Field nombre = new Field();
        nombre.setName("nombre");
        nombre.setFieldName("nombre");
        nombre.setComponentType("texto");
        nombre.setLabel("Nombre");
        nombre.setRequired(true);
        nombre.setShowInBasket(true);
        Field precio = new Field();
        precio.setName("precio");
        precio.setFieldName("precio");
        precio.setComponentType("numero");
        precio.setLabel("Precio");
        r.setModel(new ArrayList<>(List.of(nombre, precio)));
        Button guardar = new Button();
        guardar.setName("guardar");
        guardar.setCommandName("guardar");
        guardar.setLabel("Guardar");
        guardar.setCss("btn btn-primary");
        guardar.setComponentType("botonjs");
        Button oculto = new Button();
        oculto.setName("detalle");
        oculto.setCommandName("detalle");
        oculto.setHidden(true);
        r.setMethods(new ArrayList<>(List.of(guardar, oculto)));
        ResponseResource out = new ResponseResource();
        out.setResource(r);
        out.setView(view);
        return out;
    }

    // ------------------------------------------------------------------------------------------------ a brand-new model, no code

    @Test
    void aNewFormIsAPageWithTheDefaultView() throws Exception {
        HttpResponse<String> r = signIn("ana@example.com").get("/inventario/form/producto/1.0/nuevo");
        assertEquals(200, r.statusCode(), r.body());
        String html = r.body();
        assertTrue(html.contains("id=\"fcForm\"") && html.contains("<h1>Producto</h1>") && html.contains("Captura un producto"));
        assertTrue(html.contains("\"name\":\"nombre\"") && html.contains("\"name\":\"precio\""), "the shared renderer gets the fields");
        assertTrue(html.contains("formaction=\"/inventario/form/producto/1.0/guardar\""), "the button posts to its own command's address");
        assertFalse(html.contains("data-command=\"detalle\""), "hidden buttons are not drawn");
        var call = backend.calls("form:producto/nuevo").get(0);
        assertEquals("inventario", call.getModule());
        assertEquals("form", call.getResourceType());
        assertEquals("1.0", call.getVersion());
        assertEquals("nuevo", call.getCommandName());
        assertEquals("es_MX", call.getLocale());
        assertEquals("ana@example.com", call.getParameters().get("username"), "the caller's identity travels with every call");
    }

    @Test
    void thePostedButtonRunsItsCommandAndTheAnswersViewNamesTheTemplate() throws Exception {
        backend.on("form:producto/guardar", rr -> {
            ResponseResource r = producto("/form/html/tablero_es_MX.ftl");
            r.setData(new HashMap<>(Map.of("total", 7)));
            return r;
        });
        TestHttp b = signIn("ana@example.com");
        String csrf = TestHttp.csrf(b.get("/inventario/form/producto/1.0/nuevo").body());
        HttpResponse<String> r = b.postForm("/inventario/form/producto/1.0/guardar", Map.of("_csrf", csrf, "nombre", "Mesa", "uuid", "p-1"));
        assertEquals(200, r.statusCode(), r.body());
        assertTrue(r.body().contains("TABLERO:Producto|7|guardar|1"), "the custom template named by the view got the standard model: " + r.body());
        var call = backend.calls("form:producto/guardar").get(0);
        assertEquals("Mesa", call.getParameters().get("nombre"));
        assertFalse(call.getParameters().containsKey("_csrf"));
        assertEquals("p-1", call.getUuid(), "uuid also goes to the request's top-level field, where formus-ws reads it");
        assertEquals("p-1", call.getParameters().get("uuid"));
    }

    @Test
    void aViewWithoutATemplateFallsBackToTheDefaultView() throws Exception {
        backend.on("form:producto/nuevo", rr -> producto("/form/html/inexistente_es_MX.ftl"));
        HttpResponse<String> r = signIn("ana@example.com").get("/inventario/form/producto/1.0/nuevo");
        assertEquals(200, r.statusCode());
        assertTrue(r.body().contains("id=\"fcForm\""));
    }

    @Test
    void refusedValidationKeepsTheValuesAndShowsTheFieldErrors() throws Exception {
        backend.on("form:producto/guardar", rr -> {
            ResponseResource r = producto(null);   // generic commands answer HTTP 200 with the error on the field
            r.getResource().getModel().get(0).setError("Campo requerido");
            r.getResource().getModel().get(0).setValue("");
            return r;
        });
        TestHttp b = signIn("ana@example.com");
        String csrf = TestHttp.csrf(b.get("/inventario/form/producto/1.0/nuevo").body());
        HttpResponse<String> r = b.postForm("/inventario/form/producto/1.0/guardar", Map.of("_csrf", csrf));
        assertEquals(200, r.statusCode());
        assertTrue(r.body().contains("Campo requerido"), "the field error reaches the page: " + r.body());
    }

    @Test
    void aNewBasketIsATableWithFiltersAndPaging() throws Exception {
        backend.on("basket:producto/nuevo", rr -> {
            ResponseResource out = producto(null);
            Map<String, Object> page = new HashMap<>();
            page.put("number", 2);
            page.put("pages", 3);
            page.put("totalRows", 25);
            page.put("pageData", List.of(Map.of("nombre", "Mesa", "precio", 99), Map.of("nombre", "Silla", "precio", 10)));
            out.setData(new HashMap<>(Map.of("basket.inventario.producto", List.of(), "PAGE.basket.inventario.producto", page)));
            return out;
        });
        HttpResponse<String> r = signIn("ana@example.com").get("/inventario/basket/producto/1.0/nuevo?nombre=Mesa&page=2");
        assertEquals(200, r.statusCode(), r.body());
        String html = r.body();
        assertTrue(html.contains("Mesa") && html.contains("Silla") && html.contains("25 registros"), html);
        assertTrue(html.contains("name=\"nombre\"") && html.contains("value=\"Mesa\""), "a filter per shown column keeps its value");
        assertTrue(html.contains("href=\"/inventario/basket/producto/1.0/nuevo?nombre=Mesa&amp;page=3\"") || html.contains("nombre=Mesa&amp;page=3"), "paging keeps the filters");
        var call = backend.calls("basket:producto/nuevo").get(0);
        assertEquals(2, call.getPageNumber());
        assertEquals("Mesa", call.getParameters().get("nombre"));
        assertFalse(call.getParameters().containsKey("page"));
    }

    @Test
    void jsonCallersGetTheAnswerAsData() throws Exception {
        backend.on("form:producto/guardar", rr -> {
            ResponseResource r = producto("/form/html/tablero_es_MX.ftl");
            r.setData(new HashMap<>(Map.of("total", 3)));
            return r;
        });
        TestHttp b = signIn("ana@example.com");
        String csrf = TestHttp.csrf(b.get("/inventario/form/producto/1.0/nuevo").body());
        HttpResponse<String> r = b.postJson("/inventario/form/producto/1.0/guardar", "{\"nombre\":\"Mesa\"}", Map.of("X-CSRF-Token", csrf));
        assertEquals(200, r.statusCode(), r.body());
        JsonNode j = OM.readTree(r.body());
        assertTrue(j.path("ok").asBoolean());
        assertEquals(3, j.path("data").path("total").asInt());
        assertEquals("/form/html/tablero_es_MX.ftl", j.path("view").asText());
        assertEquals("Producto", j.path("resource").path("title").asText());
    }

    @Test
    void backendErrorsAre422WithTheirMessages() throws Exception {
        backend.on("form:producto/nuevo", rr -> StubFormusWs.error(404, "Requested resource was not found !"));
        HttpResponse<String> r = signIn("ana@example.com").get("/inventario/form/producto/1.0/nuevo");
        assertEquals(422, r.statusCode());
        assertTrue(r.body().contains("Requested resource was not found"));
    }

    // ------------------------------------------------------------------------------------------------ access

    @Test
    void anonymousVisitorsGoToLoginAndApiCallersGet401() throws Exception {
        TestHttp b = new TestHttp(base);
        HttpResponse<String> r = b.get("/inventario/form/producto/1.0/nuevo");
        assertEquals(303, r.statusCode());
        assertTrue(TestHttp.location(r).startsWith("/login?next="));
        assertEquals(303, b.get("/mine").statusCode(), "an application path declared protected");
        assertEquals(401, b.getJson("/inventario/form/producto/1.0/nuevo").statusCode());
        assertEquals(401, b.postJson("/inventario/form/producto/1.0/guardar", "{}", Map.of()).statusCode());
        assertEquals(404, b.get("/nothing-here").statusCode());
        assertTrue(backend.calls().isEmpty(), "nothing reaches the backend");
    }

    @Test
    void thePolicyDeniesByConfigurationAndByModule() throws Exception {
        TestHttp user = signIn("ana@example.com");
        assertEquals(403, user.get("/directorio/form/usuario/1.0/nuevo").statusCode(), "denied resource");
        assertEquals(403, user.get("/inventario/form/producto/1.0/webhook").statusCode(), "denied command");
        assertEquals(403, user.get("/ventas/form/pedido/1.0/nuevo").statusCode(), "a module outside fb.client.userModules");
        backend.on("form:pedido/nuevo", rr -> producto(null));
        assertEquals(200, signIn("staff.boss@example.com").get("/ventas/form/pedido/1.0/nuevo").statusCode(), "staff run every module");
        assertEquals(1, backend.calls("form:pedido/nuevo").size());
    }

    @Test
    void csrfIsRequiredOnPosts() throws Exception {
        TestHttp b = signIn("ana@example.com");
        assertEquals(403, b.postForm("/inventario/form/producto/1.0/guardar", Map.of("nombre", "x")).statusCode());
        assertTrue(backend.calls("form:producto/guardar").isEmpty());
    }

    // ------------------------------------------------------------------------------------------------ application hooks

    @Test
    void applicationRoutesComeFirstAndRawCommandsSkipThem() throws Exception {
        TestHttp b = signIn("ana@example.com");
        assertEquals("ROUTE /inventario/form/producto/1.0/interceptado", b.get("/inventario/form/producto/1.0/interceptado").body());
        assertTrue(backend.calls("form:producto/interceptado").isEmpty());
        backend.on("form:producto/interceptado", rr -> producto(null));
        assertEquals(200, b.get("/inventario/form/producto/1.0/interceptado.do").statusCode());
        assertEquals(1, backend.calls("form:producto/interceptado").size(), "the .do address is the raw command: the pipeline, not the route");
    }

    @Test
    void publicRoutesNeedNoSessionAndSeeTheUserWhenThereIsOne() throws Exception {
        assertEquals("hello anonymous", new TestHttp(base).get("/hello").body());
        assertEquals("hello ana@example.com", signIn("ana@example.com").get("/hello").body());
    }

    @Test
    void theUserMenuHasCollapsibleGroupsHeadingsAndPlainLinks() throws Exception {
        String es = signIn("ana@example.com").get("/mine").body();
        int group = es.indexOf("<details class=\"menu-group\"");
        assertTrue(group > 0 && es.contains("<summary>Recursos<i class=\"bi bi-chevron-down\""), "Recursos is a collapsible group");
        assertFalse(es.substring(group, group + 40).contains(" open"), "closed unless the current page is one of its children");
        String inside = es.substring(group, es.indexOf("</details>", group));
        assertTrue(inside.contains(">Existencias del menú</a>") && !inside.contains("Administración del menú"), "children are links inside the group; staffOnly ones are hidden");
        assertTrue(es.indexOf("</details>", group) < es.indexOf("Cuenta</div>") && es.indexOf("Cuenta</div>") < es.indexOf(">Perfil</a>"), "a heading and a plain link follow the group");
        assertFalse(es.contains("<a href=\"\""), "no empty links");
        assertFalse(es.substring(es.indexOf("<nav class=\"nav-pills\""), es.indexOf("</nav>")).contains("Recursos"), "groups never appear in the top bar");

        String en = signIn("ana@example.com").get("/mine?lang=en").body();
        assertTrue(en.contains("<summary>Resources<i") && en.contains("Stock in the menu") && en.contains(">Account</div>"));
        String staff = signIn("staff.boss@example.com").get("/mine?lang=en").body();
        assertTrue(staff.contains("Admin in the menu"), "staff see the staffOnly child");
    }

    @Test
    void theApplicationsNavigationBrandAndFooterAreInTheLayout() throws Exception {
        String user = signIn("ana@example.com").get("/mine").body();
        assertTrue(user.contains("Mi Cliente") && user.contains("Existencias"));
        assertFalse(user.contains("Administración"), "staffOnly items are hidden from regular users");
        assertTrue(user.contains("Hecho por") && user.contains("© test"));
        String staff = signIn("staff.boss@example.com").get("/mine?lang=en").body();
        assertTrue(staff.contains("Admin") && staff.contains("Stock"), "labels follow the language");
    }

    @Test
    void healthLoginAndBothStaticTreesAreServed() throws Exception {
        TestHttp b = new TestHttp(base);
        assertEquals("{\"status\":\"ok\"}", b.get("/health").body());
        assertEquals(200, b.get("/login").statusCode());
        assertTrue(b.get("/login").body().contains("Mi Cliente"));
        assertEquals(200, b.get("/static/css/fb.css").statusCode(), "the engine's design system");
        assertEquals(200, b.get("/static/js/fwc-form.js").statusCode());
        assertEquals(200, b.get("/static/test.txt").statusCode(), "the application's own static files, merged");
        assertEquals("/mine", TestHttp.location(signIn("ana@example.com").get("/login")), "a signed-in user is sent home");
    }
}
