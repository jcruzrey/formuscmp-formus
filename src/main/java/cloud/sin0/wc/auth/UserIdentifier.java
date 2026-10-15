package cloud.sin0.wc.auth;

import cloud.sin0.wc.client.BackendException;
import cloud.sin0.wc.client.Commands;
import cloud.sin0.wc.client.FormusClient;
import cloud.sin0.wc.config.AppConfig;
import com.formuscmp.formus.response.ResponseResource;

import java.util.Map;

/**
 * Right after SSO, asks formus-ws (directorio/usuario/identificar) who this email is: the command returns the role
 * (admin | staff | solicitante) and the user id, registering unknown users as solicitante.
 *
 * <p>Two things belong to the client application, not to the platform:
 * <ul>
 * <li>the lists of staff and administrator e-mails ({@code STAFF_EMAILS}, {@code ADMIN_EMAILS}): the application proposes the role of the person
 * in {@code rolInicial}; formus-ws only applies it to a user whose role is still empty;</li>
 * <li>the application's identity ({@code client.app.origin}, sent as the request origin): the user row names the application the person
 * registered in ({@code clientapp}) and the sign-in is valid only when it equals this application's. An application that has not set
 * {@code client.app.origin} keeps working as before (no match is required).</li>
 * </ul>
 */
public class UserIdentifier {

    public record Identity(String id, String role, String library, String plan, String permisos, String clientApp) { }

    public static class IdentifyException extends Exception {
        public IdentifyException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    private final FormusClient client;
    private final AppConfig cfg;

    /** For an application that has not adopted the client-application rule (no staff list, no origin match). */
    public UserIdentifier(FormusClient client) {
        this(client, null);
    }

    public UserIdentifier(FormusClient client, AppConfig cfg) {
        this.client = client;
        this.cfg = cfg;
    }

    /** The role this application proposes for an e-mail: {@code admin}, {@code staff} or empty (admin wins when both lists have it). */
    String proposedRole(String email) {
        if (cfg == null || email == null) {
            return "";
        }
        String e = email.trim().toLowerCase(java.util.Locale.ROOT);
        return cfg.adminEmails().contains(e) ? SessionUser.ADMIN : cfg.staffEmails().contains(e) ? SessionUser.STAFF : "";
    }

    public Identity identify(Profile p, FormusClient.CallContext ctx) throws IdentifyException {
        ResponseResource r;
        try {
            r = client.call(Commands.IDENTIFICAR, ctx)
                    .param("username", p.email())
                    .param("nombre", p.name())
                    .param("proveedor", p.provider())
                    .param("subject", p.sub())
                    .param("foto", p.picture())
                    .param("rolInicial", proposedRole(p.email()))   // blank is not sent
                    .param("plan", "true")   // also answer the name of the plan that applies to the user
                    .execute();
        } catch (BackendException e) {
            throw new IdentifyException("identify unavailable: " + e.getMessage(), e);
        }
        if (FormusClient.hasErrors(r)) {
            throw new IdentifyException("identify rejected: " + r.getErrorMessages(), null);
        }
        Map<String, Object> data = r.getData();
        String role = data == null ? null : String.valueOf(data.getOrDefault("rol", ""));
        String id = data == null || data.get("uuid") == null ? null : String.valueOf(data.get("uuid"));
        if (!SessionUser.STAFF.equals(role) && !SessionUser.ADMIN.equals(role)) {
            role = SessionUser.SOLICITANTE; // anything unexpected is the least-privileged role
        }
        if (data != null && "false".equalsIgnoreCase(String.valueOf(data.get("activo")))) {
            throw new IdentifyException("user is inactive", null);
        }
        String library = data == null || data.get("library") == null ? null : String.valueOf(data.get("library")).trim();
        String plan = data == null || data.get("planNombre") == null ? null : String.valueOf(data.get("planNombre")).trim();
        String permisos = data == null || data.get("permisos") == null ? null : String.valueOf(data.get("permisos")).trim();
        String clientApp = data == null || data.get("clientapp") == null ? "" : String.valueOf(data.get("clientapp")).trim().toLowerCase(java.util.Locale.ROOT);
        String mine = cfg == null ? "" : cfg.clientApp();
        if (!mine.isEmpty() && !mine.equals(clientApp)) {
            // the person registered in another application (or in none recorded yet): not valid here
            throw new IdentifyException(clientApp.isEmpty() ? "user has no client application recorded" : "user belongs to another client application", null);
        }
        return new Identity(id, role, library, plan, permisos, clientApp);
    }
}
