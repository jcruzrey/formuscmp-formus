package cloud.sin0.wc.auth;

/** Open-redirect protection: a post-login target must be a local absolute path. */
public final class Redirects {

    private Redirects() { }

    /** Returns {@code next} if it is a safe local path, otherwise {@code fallback}. */
    public static String sanitizeNext(String next, String fallback) {
        if (next == null || next.isBlank() || next.length() > 300) {
            return fallback;
        }
        if (!next.startsWith("/") || next.startsWith("//") || next.contains("\\") || next.contains("\r") || next.contains("\n")) {
            return fallback;
        }
        int q = next.indexOf('?');
        String path = q < 0 ? next : next.substring(0, q);
        if (path.contains(":")) {
            return fallback; // would look like a scheme to some clients
        }
        if (path.startsWith("/auth/") || path.equals("/login")) {
            return fallback; // never bounce back into the login flow
        }
        return next;
    }
}
