package cloud.sin0.wc.client;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * The locale sent to formus-ws. formus-ws has command scripts for {@code es_MX} and {@code en_US}, but keeps one
 * resource list per locale in Redis that is only loaded once a call for that locale loads the menus. Sending
 * {@code en_US} before that list exists makes every call fail with "Requested resource ... was not found"
 * (seen with {@code identificar}). So English is forwarded only when {@code fb.microservice.enLocale=true}
 * (tasks.md T3.8); otherwise everything goes as {@code es_MX} and the page language is handled by the site's own bundles.
 *
 * <p>formus-ws runs the script named {@code <command>_<locale>.groovy}, so an English call must carry the English command name
 * ({@code nuevo} is {@code new}, {@code guardar} is {@code save}, ...): {@link #command(String, String)} translates it.
 */
public final class Locales {

    public static final String DEFAULT = "es_MX";
    public static final String ENGLISH = "en_US";

    /** Spanish command -> English command; the launcher of an English call is {@code <english command>_en_US.groovy}. Words that are the same in both languages (identificar, login, ai, new...) are not listed. */
    private static final Map<String, String> TO_ENGLISH = Map.ofEntries(
            Map.entry("nuevo", "new"),
            Map.entry("guardar", "save"),
            Map.entry("detalle", "detail"),
            Map.entry("actualizar", "update"),
            Map.entry("eliminar", "delete"),
            Map.entry("buscar", "search"),
            Map.entry("ver", "view"),
            Map.entry("documentacion", "documentation"),
            Map.entry("copiarforma", "copyform"),
            Map.entry("creartabla", "createtable"),
            Map.entry("importarasset", "importasset"),
            Map.entry("reversa", "reverse"),
            Map.entry("vertir", "flush"),
            Map.entry("probar", "test"),
            Map.entry("agendar", "schedule"),
            Map.entry("reagendar", "reschedule"),
            Map.entry("cambiar", "change"),
            Map.entry("cambiarstatus", "changestatus"),
            Map.entry("cancelar", "cancel"),
            Map.entry("confirmar", "confirm"),
            Map.entry("consulta", "query"),
            Map.entry("descargar", "download"),
            Map.entry("enviar", "send"),
            Map.entry("guardarpad", "savepad"),
            Map.entry("guardartrat", "savetreatment"),
            Map.entry("importar", "import"),
            Map.entry("mostrar", "show"),
            Map.entry("padecimiento", "condition"),
            Map.entry("tratamiento", "treatment"),
            Map.entry("subir", "upload"),
            Map.entry("vaciar", "empty"));

    /** English -> Spanish, for a Spanish session that follows a link built from an English resource. {@code new} stays as it is: it is also a Spanish launcher name. */
    private static final Map<String, String> TO_SPANISH = reverse();

    private static Map<String, String> reverse() {
        Map<String, String> m = new HashMap<>();
        TO_ENGLISH.forEach((es, en) -> m.put(en, es));
        m.remove("new");
        return Map.copyOf(m);
    }

    private Locales() { }

    /** The command name formus-ws expects for {@code locale}: English names for {@code en_US}, Spanish names otherwise; any other name is kept. */
    public static String command(String name, String locale) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        String key = name.toLowerCase(Locale.ROOT);
        return ENGLISH.equals(locale) ? TO_ENGLISH.getOrDefault(key, name) : TO_SPANISH.getOrDefault(key, name);
    }

    /** @param lang the site language ({@code es} or {@code en}) chosen by the user. */
    public static String forBackend(String lang, boolean englishAvailable) {
        return englishAvailable && "en".equals(siteLang(lang)) ? ENGLISH : DEFAULT;
    }

    /** Normalises any input to {@code es} or {@code en}. */
    public static String siteLang(String raw) {
        return raw != null && raw.toLowerCase(Locale.ROOT).startsWith("en") ? "en" : "es";
    }
}
