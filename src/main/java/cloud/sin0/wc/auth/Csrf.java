package cloud.sin0.wc.auth;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.function.BiConsumer;
import java.util.function.Function;

/** Per-session CSRF token for every state-changing POST (hidden field {@code _csrf}). */
public final class Csrf {

    public static final String ATTR = "csrf";
    public static final String FIELD = "_csrf";
    private static final SecureRandom RANDOM = new SecureRandom();

    private Csrf() { }

    /** Returns the session's token, creating it on first use. */
    public static String token(Function<String, Object> get, BiConsumer<String, Object> set) {
        Object existing = get.apply(ATTR);
        if (existing != null) {
            return existing.toString();
        }
        byte[] b = new byte[24];
        RANDOM.nextBytes(b);
        String t = Base64.getUrlEncoder().withoutPadding().encodeToString(b);
        set.accept(ATTR, t);
        return t;
    }

    public static boolean matches(Function<String, Object> get, String submitted) {
        Object expected = get.apply(ATTR);
        if (expected == null || submitted == null || submitted.isEmpty()) {
            return false;
        }
        return MessageDigest.isEqual(expected.toString().getBytes(StandardCharsets.UTF_8), submitted.getBytes(StandardCharsets.UTF_8));
    }
}
