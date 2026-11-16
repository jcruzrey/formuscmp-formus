package cloud.sin0.wc.web;

import java.util.List;

/**
 * A link of the top bar or of the user menu, bilingual; {@code key} is compared with the page's {@code nav} value to mark the current one.
 * An item with no {@code href} is not a link: with {@code children} it is a collapsible group of the user menu (see {@link #group}; it opens by
 * itself when the current page is one of its children, and it is shown only when one of them is), without them a section heading (see {@link #heading}).
 *
 * <p>{@code permiso} is the authorization token ({@code module:resource:action}) the user needs to see the item: it is shown only to whoever {@code can} it. An item without a
 * {@code permiso} is public: everybody sees it.
 */
public record NavItem(String key, String es, String en, String href, List<NavItem> children, String permiso) {

    public NavItem {
        children = children == null ? List.of() : List.copyOf(children);
    }

    public NavItem(String key, String es, String en, String href) {
        this(key, es, en, href, List.of(), null);
    }

    /** The same item shown only to the users who can {@code token} ({@code module:resource:action}). */
    public NavItem withPermiso(String token) {
        return new NavItem(key, es, en, href, children, token);
    }

    /** A section heading of the user menu (no link, no key). */
    public static NavItem heading(String es, String en) {
        return new NavItem(null, es, en, "", List.of(), null);
    }

    /** A collapsible group of the user menu: one row that expands to its {@code children} (links). */
    public static NavItem group(String es, String en, NavItem... children) {
        return new NavItem(null, es, en, "", List.of(children), null);
    }
}
