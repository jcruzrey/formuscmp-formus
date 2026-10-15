package cloud.sin0.wc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Application configuration. Source order (first non-blank wins): environment variable, system property,
 * {@code fb_client_<env>.properties} on the classpath ({@code FB_CLIENT_ENV}, default {@code _dev}).
 *
 * <p>The checked-in dev properties carry FAKE Google/Facebook credentials; replace them with environment
 * variables ({@code GOOGLE_CLIENT_ID}, ...) when the real apps exist. Provider endpoints are constants (no
 * network discovery at startup), so fake values never block startup.
 */
public class AppConfig {

    private static final Logger LOG = LoggerFactory.getLogger(AppConfig.class);

    public record OAuth(String id, String clientId, String clientSecret, String redirectUri,
                        String authUri, String tokenUri, String extraUri, String issuer) {
        public boolean enabled() {
            return notBlank(clientId) && notBlank(clientSecret) && notBlank(redirectUri);
        }
    }

    private final Properties props;
    private final Map<String, String> env;

    public AppConfig(Properties props, Map<String, String> env) {
        this.props = props;
        this.env = env;
    }

    public static AppConfig load() {
        Map<String, String> env = System.getenv();
        String suffix = env.getOrDefault("FB_CLIENT_ENV", "_dev");
        Properties p = new Properties();
        String file = "fb_client" + suffix + ".properties";
        try (InputStream in = AppConfig.class.getClassLoader().getResourceAsStream(file)) {
            if (in == null) {
                LOG.warn("{} not found on the classpath; using defaults and environment variables only", file);
            } else {
                p.load(in);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read " + file, e);
        }
        return new AppConfig(p, env);
    }

    /** First non-blank of: environment variable {@code envKey} (may be null), system property, properties file, then {@code def}. */
    public String get(String envKey, String propKey, String def) {
        if (envKey != null) {
            String v = env.get(envKey);
            if (notBlank(v)) return v;
        }
        String v = System.getProperty(propKey);
        if (notBlank(v)) return v;
        v = props.getProperty(propKey);
        return notBlank(v) ? v : def;
    }

    public int getInt(String envKey, String propKey, int def) {
        return Integer.parseInt(get(envKey, propKey, String.valueOf(def)));
    }

    public boolean getBool(String envKey, String propKey, boolean def) {
        return Boolean.parseBoolean(get(envKey, propKey, String.valueOf(def)));
    }

    private static boolean notBlank(String s) {
        return s != null && !s.isBlank();
    }

    // ---- server
    public int port() { return Integer.parseInt(get("PORT", "fb.port", "9092")); }

    public boolean cookieSecure() { return Boolean.parseBoolean(get("COOKIE_SECURE", "fb.cookieSecure", "false")); }

    public int sessionTimeoutMinutes() { return Integer.parseInt(get("SESSION_TIMEOUT_MIN", "fb.sessionTimeoutMin", "60")); }

    /** Dev login is refused whenever cookies are secure (production-like). */
    public boolean devLogin() { return Boolean.parseBoolean(get("FB_DEV_LOGIN", "fb.devLogin", "false")) && !cookieSecure(); }

    /** Public origin used to build return/cancel/public-form links; blank = derive from the request. */
    public String baseUrl() { return get("BASE_URL", "fb.baseUrl", ""); }

    /** Honour X-Forwarded-For only behind a reverse proxy we control. */
    public boolean trustProxy() { return Boolean.parseBoolean(get("TRUST_PROXY", "fb.trustProxy", "false")); }

    // ---- formus-ws
    public String backendUrl() { return get("BACKEND_URL", "fb.microservice.url", ""); }

    public String assetLibrary() { return get(null, "fb.microservice.assetLibrary", "base"); }

    public String module() { return get(null, "fb.microservice.module", "case"); }

    public String version() { return get(null, "fb.microservice.version", "1.0"); }

    /**
     * Who this client application is: {@code ui::<app>} ({@code client.app.origin}, or the environment variable {@code CLIENT_APP_ORIGIN}). It is
     * sent as the {@code origin} of every request, stored on the user row at registration ({@code clientapp}) and required to match when a person
     * signs in. Blank = an application that has not adopted the rule yet: it keeps sending {@code fb.microservice.origin} and no match is required.
     */
    public String clientApp() { return get("CLIENT_APP_ORIGIN", "client.app.origin", "").trim().toLowerCase(java.util.Locale.ROOT); }

    /** The origin sent to formus-ws: the application's own {@link #clientApp()}, else the configured {@code fb.microservice.origin} (default ui::case). */
    public String origin() {
        String app = clientApp();
        return app.isEmpty() ? get(null, "fb.microservice.origin", "ui::case") : app;
    }

    /** E-mails this application proposes as {@code staff} for a user whose role is still empty (the property or env var {@code STAFF_EMAILS}, comma separated). */
    public java.util.Set<String> staffEmails() { return emails(get("STAFF_EMAILS", "STAFF_EMAILS", "")); }

    /** E-mails this application proposes as {@code admin} (the property or env var {@code ADMIN_EMAILS}); an administrator is also staff. */
    public java.util.Set<String> adminEmails() { return emails(get("ADMIN_EMAILS", "ADMIN_EMAILS", "")); }

    private static java.util.Set<String> emails(String csv) {
        java.util.Set<String> out = new java.util.LinkedHashSet<>();
        for (String s : csv.split("[,;\s]+")) {
            if (!s.isBlank()) out.add(s.trim().toLowerCase(java.util.Locale.ROOT));
        }
        return out;
    }

    public int backendTimeoutMs() { return Integer.parseInt(get("BACKEND_TIMEOUT_MS", "fb.microservice.timeoutMs", "8000")); }

    /** Send en_US to the backend only once its English resource list is loaded (tasks.md T3.8). */
    public boolean backendEnLocale() { return Boolean.parseBoolean(get("BACKEND_EN_LOCALE", "fb.microservice.enLocale", "false")); }

    // ---- branding (shown by the layout)
    public String brand() { return get(null, "fb.brand.name", "Formus Web Client"); }

    public String brandLogo() { return get(null, "fb.brand.logo", "/static/img/logo-cmp.png"); }

    // ---- generic command pipeline
    /** Largest body the generic pipeline reads from a form post. */
    public int maxBodyBytes() { return getInt(null, "fb.limit.bodyBytes", 64 * 1024); }

    /** Modules a non-staff user may run through the generic pipeline (comma separated); blank = every module. */
    public java.util.Set<String> userModules() { return csv(get(null, "fb.client.userModules", "")); }

    /**
     * How non-staff users are authorized through the generic pipeline: {@code modules} (default: {@link #userModules()}) or
     * {@code permisos} (the user's own authorization list, see {@code cloud.sin0.wc.auth.Permisos}; an empty list refuses everything).
     */
    public boolean authorizationByPermisos() { return "permisos".equalsIgnoreCase(get(null, "fb.client.authorization", "modules").trim()); }

    /** Resource names and command names nobody may run through the generic pipeline (identity, payments, webhooks...). */
    public java.util.Set<String> deniedResources() { return csv(get(null, "fb.client.deniedResources", "usuario")); }

    public java.util.Set<String> deniedCommands() { return csv(get(null, "fb.client.deniedCommands", "webhook,identificar")); }

    private static java.util.Set<String> csv(String v) {
        java.util.Set<String> out = new java.util.LinkedHashSet<>();
        for (String s : v.split(",")) {
            if (!s.isBlank()) out.add(s.trim());
        }
        return out;
    }

    // ---- SSO
    public OAuth google() {
        return new OAuth("google",
                get("GOOGLE_CLIENT_ID", "google.clientId", ""),
                get("GOOGLE_CLIENT_SECRET", "google.clientSecret", ""),
                get("GOOGLE_REDIRECT_URI", "google.redirectUri", ""),
                get(null, "google.authUri", "https://accounts.google.com/o/oauth2/v2/auth"),
                get(null, "google.tokenUri", "https://oauth2.googleapis.com/token"),
                get(null, "google.jwksUri", "https://www.googleapis.com/oauth2/v3/certs"),
                get(null, "google.issuer", "https://accounts.google.com"));
    }

    public OAuth facebook() {
        return new OAuth("facebook",
                get("FACEBOOK_APP_ID", "facebook.appId", ""),
                get("FACEBOOK_APP_SECRET", "facebook.appSecret", ""),
                get("FACEBOOK_REDIRECT_URI", "facebook.redirectUri", ""),
                get(null, "facebook.authUri", "https://www.facebook.com/v19.0/dialog/oauth"),
                get(null, "facebook.tokenUri", "https://graph.facebook.com/v19.0/oauth/access_token"),
                get(null, "facebook.graphUri", "https://graph.facebook.com/v19.0/me"),
                "");
    }
}
