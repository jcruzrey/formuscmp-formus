package cloud.sin0.wc.auth;

import cloud.sin0.wc.web.Coords;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PermisosTest {

    private static Coords form(String module, String name, String command) {
        return new Coords(module, "form", name, "1.0", command, false);
    }

    private static Coords basket(String module, String name, String command) {
        return new Coords(module, "basket", name, "1.0", command, false);
    }

    @Test
    void emptyOrMissingListRefusesEverything() {
        assertFalse(Permisos.of(null).allows(form("inventario", "producto", "nuevo")));
        assertFalse(Permisos.of("  , ,").allows(basket("inventario", "producto", "nuevo")));
        assertTrue(Permisos.of("").isEmpty());
    }

    @Test
    void aModuleGrantsEveryResourceAndActionOfThatModuleOnly() {
        Permisos p = Permisos.of("inventario");
        assertTrue(p.allows(form("inventario", "producto", "eliminar")));
        assertTrue(p.allows(basket("inventario", "almacen", "nuevo")));
        assertFalse(p.allows(form("ventas", "pedido", "nuevo")));
    }

    @Test
    void crudVerbsAreDerivedFromTheCommand() {
        Permisos p = Permisos.of("inventario:producto:leer, ventas:pedido:crear, ventas:pedido:actualizar");
        assertTrue(p.allows(form("inventario", "producto", "detalle")));
        assertTrue(p.allows(basket("inventario", "producto", "nuevo")), "a basket's nuevo is its list");
        assertFalse(p.allows(form("inventario", "producto", "nuevo")), "a form's nuevo is creating");
        assertFalse(p.allows(form("inventario", "producto", "guardar")));
        assertTrue(p.allows(form("ventas", "pedido", "nuevo")));
        assertTrue(p.allows(form("ventas", "pedido", "guardar")));
        assertTrue(p.allows(form("ventas", "pedido", "actualizar")));
        assertFalse(p.allows(form("ventas", "pedido", "eliminar")));
        assertFalse(p.allows(form("ventas", "pedido", "detalle")), "reading was not granted on ventas");
    }

    @Test
    void wildcardsAndExactCommandNames() {
        Permisos p = Permisos.of("directorio:*:leer, inventario:producto:vertir");
        assertTrue(p.allows(form("directorio", "cliente", "ver")));
        assertFalse(p.allows(form("directorio", "cliente", "guardar")));
        assertTrue(p.allows(form("inventario", "producto", "vertir")), "an exact command has no CRUD verb");
        assertFalse(p.allows(form("inventario", "producto", "reversa")));
        assertTrue(Permisos.of("*").allows(form("x", "y", "z")));
    }

    @Test
    void aDenialAlwaysWinsWhateverTheOrder() {
        Permisos p = Permisos.of("inventario:producto:eliminar, inventario, -inventario:producto:eliminar");
        assertFalse(p.allows(form("inventario", "producto", "eliminar")));
        assertTrue(p.allows(form("inventario", "producto", "guardar")));
        assertFalse(Permisos.of("-inventario:producto, inventario").allows(basket("inventario", "producto", "nuevo")));
    }

    @Test
    void caseAndSpacesDoNotMatterAndMalformedTokensAreInert() {
        Permisos p = Permisos.of(" Inventario : Producto : LEER , a:b:c:d , -");
        assertTrue(p.allows(form("inventario", "producto", "detalle")));
        assertFalse(p.allows(form("a", "b", "c")), "four segments is malformed: it grants nothing");
    }

    // ------------------------------------------------------------------------------------------ the sample users of the owner

    private static final String JOSE = "directorio:*:leer,inventario,-inventario:producto:eliminar,solicitud:*:leer,solicitud:*:crear";
    private static final String PALOMA = "directorio:*:leer,reservacion:*:leer,reservacion:*:crear";

    private static boolean allowed(String list, String path) {
        return Permisos.of(list).allows(Coords.parse(path));
    }

    @Test
    void theSampleUsersGetTheContrastTheOwnerExpects() {
        // jose reaches inventario but not its eliminar
        assertTrue(allowed(JOSE, "/inventario/basket/producto/1.0/nuevo"));
        assertTrue(allowed(JOSE, "/inventario/form/producto/1.0/nuevo"));
        assertFalse(allowed(JOSE, "/inventario/form/producto/1.0/eliminar"));
        assertTrue(allowed(JOSE, "/inventario/form/almacen/1.0/eliminar"), "only the producto resource is denied its eliminar");
        assertTrue(allowed(JOSE, "/directorio/basket/cliente/1.0/nuevo"));
        assertFalse(allowed(JOSE, "/directorio/form/cliente/1.0/nuevo"), "a form's nuevo is creating, directorio is read-only");
        assertFalse(allowed(JOSE, "/ventas/form/pedido/1.0/nuevo"));
        // paloma reaches only the directorio list (and reservacion)
        assertFalse(allowed(PALOMA, "/inventario/basket/producto/1.0/nuevo"));
        assertFalse(allowed(PALOMA, "/inventario/form/producto/1.0/eliminar"));
        assertTrue(allowed(PALOMA, "/directorio/basket/cliente/1.0/nuevo"));
        assertFalse(allowed(PALOMA, "/directorio/form/cliente/1.0/nuevo"));
        assertFalse(allowed(PALOMA, "/ventas/form/pedido/1.0/nuevo"));
        // staff (`*`) is let through by the caller; as a list `*` grants everything
        assertTrue(allowed("*", "/ventas/form/pedido/1.0/nuevo"));
    }

    @Test
    void normalizeWritesTheCanonicalListAndRejectsWhatCannotBeRead() {
        assertEquals(JOSE, Permisos.normalize(" Directorio:*:Leer , inventario,\n -inventario:producto:eliminar,solicitud:*:leer,solicitud:*:crear,inventario "));
        assertEquals("inventario,inventario:producto,*", Permisos.normalize("inventario:*:*, inventario:producto:*, *:*:*"), "trailing wildcards are dropped");
        assertEquals("-inventario", Permisos.normalize("-inventario:*"));
        assertEquals("", Permisos.normalize(null));
        assertEquals("", Permisos.normalize("  , ,"));
        for (String bad : new String[] {"a:b:c:d", ":producto", "inve ntario", "inventario;drop", "--x", "-", "a:b c", "<b>"}) {
            assertNull(Permisos.normalize(bad), bad);
        }
        for (String list : new String[] {JOSE, PALOMA, "*", "-a:b:c"}) {
            assertEquals(list, Permisos.normalize(list), "an already canonical list does not change");
            assertEquals(allowed(list, "/inventario/form/producto/1.0/eliminar"), allowed(Permisos.normalize(list), "/inventario/form/producto/1.0/eliminar"));
        }
        assertEquals(allowed("inventario:*:*", "/inventario/form/producto/1.0/eliminar"), allowed(Permisos.normalize("inventario:*:*"), "/inventario/form/producto/1.0/eliminar"),
                "normalizing never changes what a list allows");
    }

    @Test
    void theVocabularyTheEditorIsGivenIsTheOneTheCheckUses() {
        java.util.Map<String, java.util.List<String>> v = Permisos.vocabulary();
        assertEquals(java.util.List.of("leer", "crear", "actualizar", "eliminar"), new java.util.ArrayList<>(v.keySet()));
        assertEquals("leer", Permisos.basketVerb());
        for (java.util.Map.Entry<String, java.util.List<String>> verb : v.entrySet()) {
            for (String command : verb.getValue()) {
                assertTrue(Permisos.of("x:y:" + verb.getKey()).allows(form("x", "y", command)), command + " is covered by " + verb.getKey());
            }
        }
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, () -> v.put("otro", java.util.List.of()));
    }
}
