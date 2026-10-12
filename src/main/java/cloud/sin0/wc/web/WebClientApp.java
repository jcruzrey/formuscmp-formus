package cloud.sin0.wc.web;

import java.util.List;
import java.util.Map;

/**
 * What an application adds to the engine. Everything is optional: with no application code at all every formus-ws command is already a
 * page ({@code /<module>/<form|basket>/<name>/<version>/<command>}), drawn by the template its answer's view names or by the built-in
 * default form / basket template. Implement only what the application needs.
 */
public interface WebClientApp {

    /** Called once before the first request, with the engine services (formus-ws client, view renderer, resolver, page helpers). */
    default void init(WebClientContext context) { }

    /** Where a signed-in user lands after login and the brand link goes. */
    default String home() { return "/"; }

    /** Pages that need no session (a home page, public forms, webhooks). Tried first. */
    default List<Route> publicRoutes() { return List.of(); }

    /** Pages of the signed-in user. Tried before the generic pipeline; a route that does not answer returns false. */
    default List<Route> routes() { return List.of(); }

    /** True for paths that belong to the signed-in area although they are not operation addresses (anonymous visitors are sent to /login). */
    default boolean protectedPath(String path) { return false; }

    /** Who may run commands through the generic pipeline. */
    default AccessPolicy policy(cloud.sin0.wc.config.AppConfig cfg) { return AccessPolicy.standard(cfg); }

    /** Top bar links. */
    default List<NavItem> navigation() { return List.of(); }

    /** User menu links (above "log out"). */
    default List<NavItem> userMenu() { return List.of(); }

    /** Text of flash messages by code: {@code code -> {es, en}} (see {@code Ctx.flash}). */
    default Map<String, String[]> flashMessages() { return Map.of(); }

    /** Footer: {@code text}, {@code logo}, {@code alt}, {@code note}; all optional. */
    default Map<String, String> footer(boolean en) { return Map.of(); }

    /** Extra shared variables for every template (for example {@code urls}). */
    default Map<String, Object> templateVariables() { return Map.of(); }
}
