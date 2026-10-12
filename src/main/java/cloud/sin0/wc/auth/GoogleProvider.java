package cloud.sin0.wc.auth;

import cloud.sin0.wc.config.AppConfig;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.oauth2.sdk.AuthorizationCode;
import com.nimbusds.oauth2.sdk.AuthorizationCodeGrant;
import com.nimbusds.oauth2.sdk.ResponseType;
import com.nimbusds.oauth2.sdk.Scope;
import com.nimbusds.oauth2.sdk.TokenRequest;
import com.nimbusds.oauth2.sdk.TokenResponse;
import com.nimbusds.oauth2.sdk.auth.ClientSecretBasic;
import com.nimbusds.oauth2.sdk.auth.Secret;
import com.nimbusds.oauth2.sdk.http.HTTPResponse;
import com.nimbusds.oauth2.sdk.id.ClientID;
import com.nimbusds.oauth2.sdk.id.Issuer;
import com.nimbusds.oauth2.sdk.id.State;
import com.nimbusds.oauth2.sdk.pkce.CodeChallengeMethod;
import com.nimbusds.oauth2.sdk.pkce.CodeVerifier;
import com.nimbusds.openid.connect.sdk.AuthenticationRequest;
import com.nimbusds.openid.connect.sdk.Nonce;
import com.nimbusds.openid.connect.sdk.OIDCScopeValue;
import com.nimbusds.openid.connect.sdk.OIDCTokenResponse;
import com.nimbusds.openid.connect.sdk.OIDCTokenResponseParser;
import com.nimbusds.openid.connect.sdk.claims.IDTokenClaimsSet;
import com.nimbusds.openid.connect.sdk.validators.IDTokenValidator;

import java.net.URI;
import java.net.URL;

/**
 * Google OpenID Connect: authorization code flow + PKCE (S256), ID token validated against Google's JWKS
 * (issuer, audience, signature, expiry, nonce). Endpoints are constants from {@link AppConfig}, no discovery.
 */
public class GoogleProvider implements OAuthProvider {

    private final AppConfig.OAuth cfg;
    private final IDTokenValidator validator;

    public GoogleProvider(AppConfig.OAuth cfg) {
        this.cfg = cfg;
        IDTokenValidator v = null;
        if (cfg.enabled()) {
            try {
                // the JWKS is fetched lazily on first validation, so fake credentials never block startup
                v = new IDTokenValidator(new Issuer(cfg.issuer()), new ClientID(cfg.clientId()),
                        JWSAlgorithm.RS256, new URL(cfg.extraUri()));
            } catch (Exception e) {
                throw new IllegalStateException("Invalid Google OIDC configuration", e);
            }
        }
        this.validator = v;
    }

    @Override
    public String id() { return "google"; }

    @Override
    public boolean enabled() { return cfg.enabled(); }

    @Override
    public URI authorizationUri(String state, String nonce, String codeVerifier) {
        return new AuthenticationRequest.Builder(ResponseType.CODE,
                new Scope(OIDCScopeValue.OPENID, OIDCScopeValue.EMAIL, OIDCScopeValue.PROFILE),
                new ClientID(cfg.clientId()), URI.create(cfg.redirectUri()))
                .endpointURI(URI.create(cfg.authUri()))
                .state(new State(state))
                .nonce(new Nonce(nonce))
                .codeChallenge(new CodeVerifier(codeVerifier), CodeChallengeMethod.S256)
                .build().toURI();
    }

    @Override
    public Profile complete(String code, String nonce, String codeVerifier) throws Exception {
        AuthorizationCodeGrant grant = new AuthorizationCodeGrant(new AuthorizationCode(code),
                URI.create(cfg.redirectUri()), new CodeVerifier(codeVerifier));
        TokenRequest tokenRequest = new TokenRequest(URI.create(cfg.tokenUri()),
                new ClientSecretBasic(new ClientID(cfg.clientId()), new Secret(cfg.clientSecret())), grant);
        HTTPResponse http = tokenRequest.toHTTPRequest().send();
        TokenResponse response = OIDCTokenResponseParser.parse(http);
        if (!response.indicatesSuccess()) {
            throw new IllegalStateException("Google token exchange failed: " + response.toErrorResponse().getErrorObject());
        }
        OIDCTokenResponse ok = (OIDCTokenResponse) response;
        IDTokenClaimsSet claims = validator.validate(ok.getOIDCTokens().getIDToken(), new Nonce(nonce));
        String email = claims.getStringClaim("email");
        Boolean verified = claims.getBooleanClaim("email_verified");
        if (verified != null && !verified) {
            email = null; // an unverified address is not an identity
        }
        return new Profile("Google", claims.getSubject().getValue(), email,
                claims.getStringClaim("name"), claims.getStringClaim("picture"));
    }
}
