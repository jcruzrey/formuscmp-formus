package cloud.sin0.wc.auth;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The signed-in person, kept as plain session attributes so both the core Handler (jetty Session) and the
 * servlets (HttpSession) can read/write it. Nothing else about the user is stored in the frontend.
 */
public record SessionUser(String sub, String email, String name, String provider, String picture, String id, String role, String library, String plan, String permisos) {

    public static final String STAFF = "staff";
    public static final String SOLICITANTE = "solicitante";

    private static final String[] KEYS = {"sub", "email", "name", "provider", "picture", "id", "role", "library", "plan", "permisos"};

    public boolean isStaff() {
        return STAFF.equals(role);
    }

    public String initials() {
        String base = name != null && !name.isBlank() ? name : email;
        if (base == null || base.isBlank()) {
            return "?";
        }
        String[] parts = base.trim().split("[\\s@._-]+");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            if (!p.isEmpty() && sb.length() < 2) {
                sb.append(p.substring(0, 1).toUpperCase(Locale.ROOT));
            }
        }
        return sb.length() == 0 ? "?" : sb.toString();
    }

    /** Model entry used by the layout ({@code user}). */
    public Map<String, Object> toModel() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("name", name);
        m.put("email", email);
        m.put("initials", initials());
        m.put("role", role);
        m.put("picture", picture);
        m.put("id", id);
        m.put("library", library);
        m.put("plan", plan);
        return m;
    }

    public static SessionUser from(Function<String, Object> get) {
        Object email = get.apply("user.email");
        if (email == null) {
            return null;
        }
        return new SessionUser(str(get.apply("user.sub")), email.toString(), str(get.apply("user.name")),
                str(get.apply("user.provider")), str(get.apply("user.picture")), str(get.apply("user.id")),
                str(get.apply("user.role")), str(get.apply("user.library")), str(get.apply("user.plan")), str(get.apply("user.permisos")));
    }

    public void store(BiConsumer<String, Object> set) {
        String[] values = {sub, email, name, provider, picture, id, role, library, plan, permisos};
        for (int i = 0; i < KEYS.length; i++) {
            set.accept("user." + KEYS[i], values[i]);
        }
    }

    private static String str(Object o) {
        return o == null ? null : o.toString();
    }
}
