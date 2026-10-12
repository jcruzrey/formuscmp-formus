package cloud.sin0.wc.auth;

import cloud.sin0.wc.config.AppConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

/**
 * Facebook Login: OAuth2 authorization code (state-protected), then the Graph API profile
 * ({@code id,name,email,picture}). Facebook is not a full OIDC provider, hence no ID token / nonce / PKCE.
 * The email can be absent (user denied it or has no verified address).
 */
public class FacebookProvider implements OAuthProvider {

    private final AppConfig.OAuth cfg;
    private final HttpClient http = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
    private final ObjectMapper mapper = new ObjectMapper();

    public FacebookProvider(AppConfig.OAuth cfg) {
        this.cfg = cfg;
    }

    @Override
    public String id() { return "facebook"; }

    @Override
    public boolean enabled() { return cfg.enabled(); }

    private static String enc(String s) {
        return URLEncoder.encode(s, StandardCharsets.UTF_8);
    }

    @Override
    public URI authorizationUri(String state, String nonce, String codeVerifier) {
        return URI.create(cfg.authUri() + "?client_id=" + enc(cfg.clientId())
                + "&redirect_uri=" + enc(cfg.redirectUri())
                + "&state=" + enc(state)
                + "&response_type=code&scope=" + enc("email,public_profile"));
    }

    @Override
    public Profile complete(String code, String nonce, String codeVerifier) throws Exception {
        String form = "client_id=" + enc(cfg.clientId()) + "&client_secret=" + enc(cfg.clientSecret())
                + "&redirect_uri=" + enc(cfg.redirectUri()) + "&code=" + enc(code);
        HttpResponse<String> token = http.send(HttpRequest.newBuilder(URI.create(cfg.tokenUri()))
                .timeout(Duration.ofSeconds(8))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(form)).build(), HttpResponse.BodyHandlers.ofString());
        if (token.statusCode() / 100 != 2) {
            throw new IllegalStateException("Facebook token exchange failed: HTTP " + token.statusCode());
        }
        String accessToken = mapper.readTree(token.body()).path("access_token").asText("");
        if (accessToken.isBlank()) {
            throw new IllegalStateException("Facebook token response without access_token");
        }

        HttpResponse<String> me = http.send(HttpRequest.newBuilder(URI.create(cfg.extraUri()
                + "?fields=" + enc("id,name,email,picture.width(200)") + "&access_token=" + enc(accessToken)))
                .timeout(Duration.ofSeconds(8)).GET().build(), HttpResponse.BodyHandlers.ofString());
        if (me.statusCode() / 100 != 2) {
            throw new IllegalStateException("Facebook profile request failed: HTTP " + me.statusCode());
        }
        JsonNode n = mapper.readTree(me.body());
        String email = n.path("email").asText("");
        return new Profile("Facebook", n.path("id").asText(), email.isBlank() ? null : email,
                n.path("name").asText(null), n.path("picture").path("data").path("url").asText(null));
    }
}
