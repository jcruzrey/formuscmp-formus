package cloud.sin0.wc.web;

import java.util.List;

/**
 * A link of the top bar or of the user menu, bilingual; {@code key} is compared with the page's {@code nav} value to mark the current one.
 * An item with no {@code href} is not a link: with {@code children} it is a collapsible group of the user menu (see {@link #group}; it opens by
 * itself when the current page is one of its children), without them a section heading (see {@link #heading}).
 */
public record NavItem(String key, String es, String en, String href, boolean staffOnly, List<NavItem> children) {

    public NavItem {
        children = children == null ? List.of() : List.copyOf(children);
    }

    public NavItem(String key, String es, String en, String href, boolean staffOnly) {
        this(key, es, en, href, staffOnly, List.of());
    }

    public NavItem(String key, String es, String en, String href) {
        this(key, es, en, href, false, List.of());
    }

    /** A section heading of the user menu (no link, no key). */
    public static NavItem heading(String es, String en) {
        return new NavItem(null, es, en, "", false, List.of());
    }

    /** A collapsible group of the user menu: one row that expands to its {@code children} (links). */
    public static NavItem group(String es, String en, NavItem... children) {
        return new NavItem(null, es, en, "", false, List.of(children));
    }
}
