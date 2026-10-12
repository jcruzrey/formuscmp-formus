package cloud.sin0.wc.auth;

import java.net.URI;

/** One SSO provider. The servlets generate state/nonce/PKCE verifier and keep them in the session. */
public interface OAuthProvider {

    /** Path segment and session key prefix: "google" or "facebook". */
    String id();

    boolean enabled();

    URI authorizationUri(String state, String nonce, String codeVerifier);

    /** Exchanges the authorization code and returns the verified profile (may have a null email). */
    Profile complete(String code, String nonce, String codeVerifier) throws Exception;
}
