package cloud.sin0.wc.web;

import cloud.sin0.wc.config.AppConfig;
import cloud.sin0.wc.testing.StubFormusWs;
import cloud.sin0.wc.testing.TestHttp;
import cloud.sin0.wc.testing.TestHttp.Part;
import com.formuscmp.formus.button.Button;
import com.formuscmp.formus.field.Field;
import com.formuscmp.formus.file.Attachment;
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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;

import static cloud.sin0.wc.testing.StubFormusWs.data;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Files through the generic pipeline: a file field is drawn, a multipart post is relayed to formus-ws, a file answer is sent to the browser. */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WebClientUploadTest {

    static final byte[] PDF = "%PDF-1.4 contrato".getBytes(StandardCharsets.ISO_8859_1);
    static final Path TMP = Path.of(System.getProperty("java.io.tmpdir"), "fwc-upload");

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
        p.setProperty("fb.limit.uploadBytes", "1000");
        p.setProperty("fb.limit.uploadRequestBytes", "5000");
        p.setProperty("fb.upload.token", "s3cret");
        server = WebClientServer.build(new AppConfig(p, Map.of()), new ViewRenderer(), new WebClientApp() { });
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
        backend.on("usuario/identificar", rr -> data("uuid", "u1", "rol", "solicitante"));
        backend.on("form:documento/nuevo", rr -> documento());
        backend.on("form:documento/guardar", rr -> documento());
    }

    TestHttp signIn() throws Exception {
        TestHttp b = new TestHttp(base);
        String csrf = TestHttp.csrf(b.get("/login").body());
        assertEquals(302, b.postForm("/auth/dev/login", Map.of("_csrf", csrf, "email", "ana@example.com", "next", "")).statusCode());
        return b;
    }

    static ResponseResource documento() {
        Resource r = new Resource();
        r.setName("documento");
        r.setModule("inventario");
        r.setTitle("Documento");
        Field nombre = new Field();
        nombre.setName("nombre");
        nombre.setFieldName("nombre");
        nombre.setComponentType("texto");
        nombre.setLabel("Nombre");
        Field contrato = new Field();
        contrato.setName("contrato");
        contrato.setFieldName("contrato");
        contrato.setComponentType("archivo");
        contrato.setLabel("Contrato");
        r.setModel(new ArrayList<>(List.of(nombre, contrato)));
        Button guardar = new Button();
        guardar.setName("guardar");
        guardar.setCommandName("guardar");
        guardar.setLabel("Guardar");
        guardar.setComponentType("botonjs");
        r.setMethods(new ArrayList<>(List.of(guardar)));
        ResponseResource out = new ResponseResource();
        out.setResource(r);
        return out;
    }

    String csrfOf(TestHttp b) throws Exception {
        return TestHttp.csrf(b.get("/inventario/form/documento/1.0/nuevo").body());
    }

    static long leftoverTempFiles() throws Exception {
        if (!Files.isDirectory(TMP)) return 0;
        try (Stream<Path> s = Files.list(TMP)) {
            return s.count();
        }
    }

    @Test
    void aPlatformFileFieldIsDrawnAsAFileInputAndMakesTheFormMultipart() throws Exception {
        String html = signIn().get("/inventario/form/documento/1.0/nuevo").body();
        assertTrue(html.contains("\"type\":\"file\"") && html.contains("\"name\":\"contrato\""), "the field reaches the renderer as type file");
        assertTrue(html.contains("fwc-form.js"));
        String js = new String(Files.readAllBytes(Path.of("src/main/resources/static/js/fwc-form.js")), StandardCharsets.UTF_8);
        assertTrue(js.contains("input[type=file]") && js.contains("multipart/form-data"), "the form script switches the enctype when a file input is drawn");
    }

    @Test
    void aMultipartPostIsRelayedToFormusWsWithItsFileAndFields() throws Exception {
        TestHttp b = signIn();
        String csrf = csrfOf(b);
        HttpResponse<String> r = b.postMultipart("/inventario/form/documento/1.0/guardar", TestHttp.parts(
                Part.field("_csrf", csrf), Part.field("nombre", "Contrato Acme"), Part.file("contrato", "contrato.pdf", "application/pdf", PDF)));
        assertEquals(200, r.statusCode(), r.body());
        var call = backend.calls("form:documento/guardar").get(0);
        assertEquals("Contrato Acme", call.getParameters().get("nombre"));
        assertEquals("ana@example.com", call.getParameters().get("username"), "identity travels with an upload too");
        assertFalse(call.getParameters().containsKey("_csrf"));
        assertEquals(1, backend.uploads().size());
        var up = backend.uploads().get(0);
        assertEquals("contrato", up.field());
        assertEquals("contrato.pdf", up.filename());
        assertEquals("application/pdf", up.contentType());
        assertArrayEquals(PDF, up.bytes(), "the bytes arrive untouched");
        assertEquals(List.of("s3cret"), backend.uploadTokens(), "the shared token goes with the relay");
    }

    @Test
    void temporaryFilesAreDeletedAfterTheRelay() throws Exception {
        TestHttp b = signIn();
        String csrf = csrfOf(b);
        long before = leftoverTempFiles();
        b.postMultipart("/inventario/form/documento/1.0/guardar", TestHttp.parts(Part.field("_csrf", csrf), Part.file("contrato", "c.pdf", "application/pdf", PDF)));
        assertEquals(before, leftoverTempFiles());
    }

    @Test
    void anUploadWithoutTheCsrfTokenIsRefusedAndNeverReachesTheBackend() throws Exception {
        TestHttp b = signIn();
        HttpResponse<String> r = b.postMultipart("/inventario/form/documento/1.0/guardar", TestHttp.parts(
                Part.field("nombre", "x"), Part.file("contrato", "c.pdf", "application/pdf", PDF)));
        assertEquals(403, r.statusCode());
        assertTrue(backend.calls("form:documento/guardar").isEmpty());
        assertTrue(backend.uploads().isEmpty());
    }

    @Test
    void anAnonymousUploadIsNotAccepted() throws Exception {
        TestHttp anon = new TestHttp(base);
        HttpResponse<String> r = anon.postMultipart("/inventario/form/documento/1.0/guardar", TestHttp.parts(
                Part.file("contrato", "c.pdf", "application/pdf", PDF)));
        assertTrue(r.statusCode() == 302 || r.statusCode() == 401 || r.statusCode() == 403, "status " + r.statusCode());
        assertTrue(backend.uploads().isEmpty());
    }

    @Test
    void aFileOverTheLimitIs413AndNothingIsRelayed() throws Exception {
        TestHttp b = signIn();
        String csrf = csrfOf(b);
        HttpResponse<String> r = b.postMultipart("/inventario/form/documento/1.0/guardar", TestHttp.parts(
                Part.field("_csrf", csrf), Part.file("contrato", "big.pdf", "application/pdf", new byte[2000])));
        assertEquals(413, r.statusCode(), r.body());
        assertTrue(backend.calls("form:documento/guardar").isEmpty());
        assertEquals(0, leftoverTempFiles());
    }

    @Test
    void anEmptyFileInputIsIgnoredAndTheCallStaysPlainJson() throws Exception {
        TestHttp b = signIn();
        String csrf = csrfOf(b);
        HttpResponse<String> r = b.postMultipart("/inventario/form/documento/1.0/guardar", TestHttp.parts(
                Part.field("_csrf", csrf), Part.field("nombre", "Sin archivo"), Part.file("contrato", "", "application/octet-stream", new byte[0])));
        assertEquals(200, r.statusCode(), r.body());
        assertTrue(backend.uploads().isEmpty(), "no multipart relay without a file");
        assertEquals("Sin archivo", backend.calls("form:documento/guardar").get(0).getParameters().get("nombre"));
        assertTrue(backend.uploadTokens().isEmpty());
    }

    @Test
    void anOrdinaryUrlencodedPostStillWorks() throws Exception {
        TestHttp b = signIn();
        String csrf = csrfOf(b);
        assertEquals(200, b.postForm("/inventario/form/documento/1.0/guardar", Map.of("_csrf", csrf, "nombre", "Normal")).statusCode());
        assertEquals("Normal", backend.calls("form:documento/guardar").get(0).getParameters().get("nombre"));
        assertTrue(backend.uploads().isEmpty());
    }

    @Test
    void aCommandThatAnswersWithAFileIsSentToTheBrowserWithRangeSupport() throws Exception {
        String id = "00000000-0000-0000-0000-000000000001";
        backend.file(id, "application/pdf", "contrato.pdf", PDF);
        backend.on("form:documento/descargar", rr -> {
            ResponseResource r = new ResponseResource();
            Attachment a = new Attachment();
            a.setStorageId(id);
            r.setAttachment(a);
            return r;
        });
        TestHttp b = signIn();
        HttpResponse<byte[]> full = b.getBytes("/inventario/form/documento/1.0/descargar?uuid=x", Map.of());
        assertEquals(200, full.statusCode());
        assertArrayEquals(PDF, full.body());
        assertEquals("application/pdf", full.headers().firstValue("Content-Type").orElse(""));
        assertTrue(full.headers().firstValue("Content-Disposition").orElse("").startsWith("attachment"));
        assertEquals("nosniff", full.headers().firstValue("X-Content-Type-Options").orElse(""));

        HttpResponse<byte[]> part = b.getBytes("/inventario/form/documento/1.0/descargar?uuid=x", Map.of("Range", "bytes=1-3"));
        assertEquals(206, part.statusCode());
        assertEquals("PDF", new String(part.body(), StandardCharsets.ISO_8859_1));
        assertEquals("bytes 1-3/" + PDF.length, part.headers().firstValue("Content-Range").orElse(""));
    }
}
