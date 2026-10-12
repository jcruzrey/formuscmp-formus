package cloud.sin0.wc.auth;

/** Identity data returned by an SSO provider (provider: "Google", "Facebook" or "Local"). */
public record Profile(String provider, String sub, String email, String name, String picture) { }
