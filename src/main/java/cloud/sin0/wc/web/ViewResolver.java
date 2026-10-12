package cloud.sin0.wc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

/**
 * Chooses the page template of a formus-ws answer from {@code ResponseResource.getView()}, the web-visa way: the view IS a template path,
 * built by the platform's {@code armaRutaVista} as {@code /<resourceType>/<format>/<view>_<locale>.ftl} from the {@code view} in the
 * resource JSON (the button named like the command, else the resource; a basket: its {@code basket} property). Nothing maps one name to
 * another: {@code /form/html/perfil_es_MX.ftl} is rendered by {@code templates/form/html/perfil.ftl} (the templates are bilingual, so the
 * locale suffix is dropped). Lookup, first hit wins: the exact path, then the path without the locale suffix. No hit = {@code null}:
 * the caller keeps the page's own template.
 */
public final class ViewResolver {

    private static final Logger LOG = LoggerFactory.getLogger(ViewResolver.class);
    private static final Pattern LOCALE_SUFFIX = Pattern.compile("_[a-z]{2}_[A-Z]{2}(?=\\.ftl$|$)");

    private final ViewRenderer views;

    public ViewResolver(ViewRenderer views) {
        this.views = views;
    }

    /** The local template for a backend view, or null. */
    public String resolve(String view) {
        if (view == null || view.isBlank()) {
            return null;
        }
        String path = view.startsWith("/") ? view.substring(1) : view;
        if (path.contains("..") || path.contains("\\")) {
            return null;
        }
        String stripped = LOCALE_SUFFIX.matcher(path).replaceFirst("");
        String withExtension = stripped.endsWith(".ftl") ? stripped : stripped + ".ftl";
        for (String candidate : new String[]{path, withExtension}) {
            if (views.exists(candidate)) {
                return candidate;
            }
        }
        LOG.debug("formus-ws view '{}' has no local template", view);
        return null;
    }
}
