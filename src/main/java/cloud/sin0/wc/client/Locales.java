package cloud.sin0.wc.client;

import java.util.Locale;

/**
 * The locale sent to formus-ws. formus-ws has command scripts for {@code es_MX} and {@code en_US}, but keeps one
 * resource list per locale in Redis that is only loaded once a call for that locale loads the menus. Sending
 * {@code en_US} before that list exists makes every call fail with "Requested resource ... was not found"
 * (seen with {@code identificar}). So English is forwarded only when {@code fb.microservice.enLocale=true}
 * (tasks.md T3.8); otherwise everything goes as {@code es_MX} and the page language is handled by the site's own bundles.
 */
public final class Locales {

    public static final String DEFAULT = "es_MX";
    public static final String ENGLISH = "en_US";

    private Locales() { }

    /** @param lang the site language ({@code es} or {@code en}) chosen by the user. */
    public static String forBackend(String lang, boolean englishAvailable) {
        return englishAvailable && "en".equals(siteLang(lang)) ? ENGLISH : DEFAULT;
    }

    /** Normalises any input to {@code es} or {@code en}. */
    public static String siteLang(String raw) {
        return raw != null && raw.toLowerCase(Locale.ROOT).startsWith("en") ? "en" : "es";
    }
}
