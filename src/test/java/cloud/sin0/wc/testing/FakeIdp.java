package cloud.sin0.wc.testing;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.io.Content;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/** Fake Google (OIDC token + JWKS) and Facebook (token + Graph) endpoints. */
public class FakeIdp {

    public static final String ISSUER = "http://idp.test";

    private final Server server = new Server(0);
    private final RSAKey key;
    public volatile String googleNonce = "";
    public volatile String googleEmail = "ana.lopez@example.com";
    public volatile String googleClientId = "g-client";
    public volatile String facebookEmail = "fb.user@example.com"; // null = Facebook returns no email
    public volatile Map<String, String> lastGoogleTokenForm = new LinkedHashMap<>();

    public FakeIdp() throws Exception {
        key = new RSAKeyGenerator(2048).keyID("k1").generate();
        server.setHandler(new Handler.Abstract() {
            @Override
            public boolean handle(Request request, Response response, Callback callback) throws Exception {
                String path = Request.getPathInContext(request);
                String body = "POST".equals(request.getMethod()) ? Content.Source.asString(request, StandardCharsets.UTF_8) : "";
                String out;
                switch (path) {
                    case "/google/jwks" -> out = new JWKSet(key.toPublicJWK()).toString();
                    case "/google/token" -> {
                        lastGoogleTokenForm = form(body);
                        out = googleToken();
                    }
                    case "/facebook/token" -> out = "{\"access_token\":\"fb-token\",\"token_type\":\"bearer\"}";
                    case "/facebook/me" -> out = "{\"id\":\"fb-1\",\"name\":\"Fb User\""
                            + (facebookEmail == null ? "" : ",\"email\":\"" + facebookEmail + "\"")
                            + ",\"picture\":{\"data\":{\"url\":\"http://img.test/p.png\"}}}";
                    default -> {
                        response.setStatus(404);
                        callback.succeeded();
                        return true;
                    }
                }
                response.setStatus(200);
                response.getHeaders().put(HttpHeader.CONTENT_TYPE, "application/json");
                response.write(true, BufferUtil.toBuffer(out, StandardCharsets.UTF_8), callback);
                return true;
            }
        });
        server.start();
    }

    private String googleToken() throws Exception {
        Date now = new Date();
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .issuer(ISSUER).audience(googleClientId).subject("google-sub-1")
                .issueTime(now).expirationTime(new Date(now.getTime() + 600_000))
                .claim("nonce", googleNonce).claim("email", googleEmail).claim("email_verified", true)
                .claim("name", "Ana López").build();
        SignedJWT jwt = new SignedJWT(new JWSHeader.Builder(JWSAlgorithm.RS256).keyID("k1").build(), claims);
        jwt.sign(new RSASSASigner(key));
        return "{\"access_token\":\"g-access\",\"token_type\":\"Bearer\",\"expires_in\":3600,\"id_token\":\"" + jwt.serialize() + "\"}";
    }

    private static Map<String, String> form(String body) {
        Map<String, String> m = new LinkedHashMap<>();
        for (String p : body.split("&")) {
            int i = p.indexOf('=');
            if (i > 0) {
                m.put(URLDecoder.decode(p.substring(0, i), StandardCharsets.UTF_8), URLDecoder.decode(p.substring(i + 1), StandardCharsets.UTF_8));
            }
        }
        return m;
    }

    public String base() {
        return "http://localhost:" + ((ServerConnector) server.getConnectors()[0]).getLocalPort();
    }

    public void stop() throws Exception { server.stop(); }
}
