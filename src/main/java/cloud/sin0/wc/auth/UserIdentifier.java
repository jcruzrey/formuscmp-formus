package cloud.sin0.wc.auth;

import cloud.sin0.wc.client.BackendException;
import cloud.sin0.wc.client.Commands;
import cloud.sin0.wc.client.FormusClient;
import com.formuscmp.formus.response.ResponseResource;

import java.util.Map;

/**
 * Right after SSO, asks formus-ws (directorio/usuario/identificar) who this email is: the command returns the role
 * (staff | solicitante) and the user id, registering unknown users as solicitante.
 */
public class UserIdentifier {

    public record Identity(String id, String role, String library, String plan) { }

    public static class IdentifyException extends Exception {
        public IdentifyException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    private final FormusClient client;

    public UserIdentifier(FormusClient client) {
        this.client = client;
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
        if (!SessionUser.STAFF.equals(role)) {
            role = SessionUser.SOLICITANTE; // anything unexpected is the least-privileged role
        }
        if (data != null && "false".equalsIgnoreCase(String.valueOf(data.get("activo")))) {
            throw new IdentifyException("user is inactive", null);
        }
        String library = data == null || data.get("library") == null ? null : String.valueOf(data.get("library")).trim();
        String plan = data == null || data.get("planNombre") == null ? null : String.valueOf(data.get("planNombre")).trim();
        return new Identity(id, role, library, plan);
    }
}
