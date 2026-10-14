package cloud.sin0.wc.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/** formus-ws runs {@code <command>_<locale>.groovy}: an English call must carry the English command name, a Spanish one the Spanish name. */
class LocalesTest {

    @Test
    void anEnglishCallCarriesTheEnglishCommandName() {
        assertEquals("new", Locales.command("nuevo", "en_US"));
        assertEquals("save", Locales.command("guardar", "en_US"));
        assertEquals("detail", Locales.command("detalle", "en_US"));
        assertEquals("update", Locales.command("actualizar", "en_US"));
        assertEquals("delete", Locales.command("eliminar", "en_US"));
        assertEquals("search", Locales.command("buscar", "en_US"));
        assertEquals("view", Locales.command("ver", "en_US"));
        assertEquals("importasset", Locales.command("importarasset", "en_US"));
        assertEquals("reverse", Locales.command("reversa", "en_US"));
        assertEquals("flush", Locales.command("vertir", "en_US"));
    }

    @Test
    void aSpanishCallKeepsTheSpanishNameAndAnEnglishNameIsBroughtBack() {
        assertEquals("nuevo", Locales.command("nuevo", "es_MX"));
        assertEquals("guardar", Locales.command("guardar", "es_MX"));
        assertEquals("guardar", Locales.command("save", "es_MX"), "a link built from an English resource followed in a Spanish session");
        assertEquals("detalle", Locales.command("detail", "es_MX"));
        assertEquals("nuevo", Locales.command("nuevo", null));
    }

    @Test
    void namesThatAreTheSameInBothLanguagesOrUnknownAreNotTouched() {
        for (String locale : new String[] { "es_MX", "en_US" }) {
            assertEquals("identificar", Locales.command("identificar", locale));
            assertEquals("login", Locales.command("login", locale));
            assertEquals("cronologia", Locales.command("cronologia", locale));
            assertEquals("algo-nuevo-que-no-existe", Locales.command("algo-nuevo-que-no-existe", locale));
        }
        assertEquals("new", Locales.command("new", "en_US"));
        assertEquals("new", Locales.command("new", "es_MX"), "new is also a Spanish launcher name");
        assertNull(Locales.command(null, "en_US"));
        assertEquals("", Locales.command("", "en_US"));
    }

    @Test
    void translatingTwiceChangesNothing() {
        for (String es : new String[] { "guardar", "detalle", "actualizar", "eliminar", "buscar", "ver", "cancelar", "confirmar", "vaciar" }) {
            String en = Locales.command(es, "en_US");
            assertEquals(en, Locales.command(en, "en_US"), es);
            assertEquals(es, Locales.command(en, "es_MX"), es + " round trip");
        }
        // nuevo -> new does not come back: new_es_MX is a launcher of its own in ten folders (different from nuevo_es_MX), so new is left alone in Spanish
        assertEquals("new", Locales.command("nuevo", "en_US"));
        assertEquals("new", Locales.command(Locales.command("nuevo", "en_US"), "en_US"));
    }
}
