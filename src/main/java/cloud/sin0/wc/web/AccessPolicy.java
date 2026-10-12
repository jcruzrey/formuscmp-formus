package cloud.sin0.wc.web;

import cloud.sin0.wc.config.AppConfig;

/** Who may run which formus-ws command through the generic pipeline. Application pages decide for themselves. */
@FunctionalInterface
public interface AccessPolicy {

    boolean allows(Ctx c, Coords k);

    /**
     * The default, driven by configuration: resource names ({@code fb.client.deniedResources}) and commands
     * ({@code fb.client.deniedCommands}) nobody runs; staff run anything else; other users only the modules listed in
     * {@code fb.client.userModules} (blank = every module).
     */
    static AccessPolicy standard(AppConfig cfg) {
        return (c, k) -> {
            if (!java.util.Set.of("form", "basket", "api").contains(k.type())
                    || cfg.deniedResources().contains(k.name()) || cfg.deniedCommands().contains(k.command())) {
                return false;
            }
            return c.user != null && (c.user.isStaff() || cfg.userModules().isEmpty() || cfg.userModules().contains(k.module()));
        };
    }
}
