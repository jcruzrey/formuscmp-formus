package cloud.sin0.wc.web;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ViewResolverTest {

    private final ViewResolver resolver = new ViewResolver(new ViewRenderer(null));

    @Test
    void aViewIsTheTemplatePathWithoutItsLocale() {
        for (String locale : new String[]{"es_MX", "en_US"}) {
            assertEquals("form/html/tablero.ftl", resolver.resolve("/form/html/tablero_" + locale + ".ftl"));
            assertEquals("default/form.ftl", resolver.resolve("/default/form_" + locale + ".ftl"));
        }
    }

    @Test
    void anExactTemplatePathWinsAndUnknownOrHostileViewsResolveToNothing() {
        assertEquals("login.ftl", resolver.resolve("login.ftl"), "exact path under templates/");
        assertEquals("login.ftl", resolver.resolve("/login_es_MX.ftl"), "locale suffix stripped");
        assertNull(resolver.resolve("/form/html/vista_es_MX.ftl"), "no template of that name: the caller keeps its default");
        assertNull(resolver.resolve("/form/html/tablero.ftl.bak"));
        assertNull(resolver.resolve(null));
        assertNull(resolver.resolve("  "));
        assertNull(resolver.resolve("/../../etc/passwd"));
        assertNull(resolver.resolve("/form\\\\html/tablero_es_MX.ftl"));
    }

    @Test
    void aTemplatesDirectoryOverridesTheClasspathWithoutHidingTheEngine(@org.junit.jupiter.api.io.TempDir java.nio.file.Path dir) throws Exception {
        java.nio.file.Files.createDirectories(dir.resolve("form/html"));
        java.nio.file.Files.writeString(dir.resolve("form/html/solo.ftl"), "SOLO");
        ViewResolver r = new ViewResolver(new ViewRenderer(dir.toString()));
        assertEquals("form/html/solo.ftl", r.resolve("/form/html/solo_es_MX.ftl"), "from the directory");
        assertEquals("default/form.ftl", r.resolve("/default/form_es_MX.ftl"), "the engine's own templates still load");
    }
}
