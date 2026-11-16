package cloud.sin0.wc.web;

import cloud.sin0.wc.auth.Permisos;

import java.util.Set;

/**
 * Who may run which formus-ws command through the generic pipeline. Application pages decide for themselves with {@link Ctx#can(String)}.
 *
 * <p>The only authorization there is: the effective permisos of the signed-in user ({@code module[:resource[:action]]}, a leading {@code -} denies, a denial always wins, what is not granted
 * is refused; see {@link Permisos}). The roles, the user's own rules and the application they belong to were already resolved by the backend at sign-in. Nobody passes because of what they are
 * called: staff and administrators need grants like anybody else.
 */
@FunctionalInterface
public interface AccessPolicy {

    boolean allows(Ctx c, Coords k);

    /** The commands of the platform's own protocol (identity, provider webhooks): no user ever runs them through the pipeline, whatever they were granted. */
    Set<String> PROTOCOL_COMMANDS = Set.of("identificar", "webhook");

    static AccessPolicy standard() {
        return (c, k) -> Set.of("form", "basket", "api").contains(k.type()) && !PROTOCOL_COMMANDS.contains(k.command()) && c.user != null && Permisos.of(c.user.permisos()).allows(k);
    }
}
