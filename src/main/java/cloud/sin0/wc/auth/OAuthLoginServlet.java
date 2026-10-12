package cloud.sin0.wc.auth;

import com.nimbusds.oauth2.sdk.id.State;
import com.nimbusds.oauth2.sdk.pkce.CodeVerifier;
import com.nimbusds.openid.connect.sdk.Nonce;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/** GET /auth/{provider}/login: stores state, nonce and PKCE verifier in the session and redirects to the provider. */
public class OAuthLoginServlet extends HttpServlet {

    private final OAuthProvider provider;

    public OAuthLoginServlet(OAuthProvider provider) {
        this.provider = provider;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        String state = new State().getValue();
        String nonce = new Nonce().getValue();
        String verifier = new CodeVerifier().getValue();
        String p = "oauth." + provider.id();
        session.setAttribute(p + ".state", state);
        session.setAttribute(p + ".nonce", nonce);
        session.setAttribute(p + ".verifier", verifier);

        String next = Redirects.sanitizeNext(request.getParameter("next"), null);
        if (next != null) {
            session.setAttribute(LoginFlow.NEXT_ATTR, next);
        } else {
            session.removeAttribute(LoginFlow.NEXT_ATTR);
        }
        response.sendRedirect(provider.authorizationUri(state, nonce, verifier).toString());
    }
}
