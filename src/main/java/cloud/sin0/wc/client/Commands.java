package cloud.sin0.wc.client;

/** The only command the engine itself runs (sign-in): the platform's existing user model. Everything else belongs to the application. */
public final class Commands {

    // params username, nombre, proveedor, subject, foto -> data { uuid, rol, permisos, activo, nombre }
    public static final Command IDENTIFICAR = new Command("directorio", "form", "usuario", "identificar");

    private Commands() { }
}
