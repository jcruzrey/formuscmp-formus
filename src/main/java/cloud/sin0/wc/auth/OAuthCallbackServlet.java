package cloud.sin0.wc.auth;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * GET /auth/{provider}/callback: validates the state bound to the session, exchanges the code, then hands the
 * verified profile to {@link LoginFlow}. Every failure ends on /login?e=&lt;code&gt; (codes, never free text).
 */
public class OAuthCallbackServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(OAuthCallbackServlet.class);

    private final OAuthProvider provider;
    private final LoginFlow flow;

    public OAuthCallbackServlet(OAuthProvider provider, LoginFlow flow) {
        this.provider = provider;
        this.flow = flow;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect(LoginFlow.loginError("session"));
            return;
        }
        String p = "oauth." + provider.id();
        String expectedState = (String) session.getAttribute(p + ".state");
        String nonce = (String) session.getAttribute(p + ".nonce");
        String verifier = (String) session.getAttribute(p + ".verifier");
        // the state is single use
        session.removeAttribute(p + ".state");

        if (request.getParameter("error") != null) {
            LOG.warn("{} login denied by the user/provider: {}", provider.id(), request.getParameter("error"));
            response.sendRedirect(LoginFlow.loginError("denied"));
            return;
        }
        String state = request.getParameter("state");
        if (expectedState == null || state == null
                || !MessageDigest.isEqual(expectedState.getBytes(StandardCharsets.UTF_8), state.getBytes(StandardCharsets.UTF_8))) {
            LOG.warn("{} callback rejected: state mismatch", provider.id());
            response.sendRedirect(LoginFlow.loginError("state"));
            return;
        }
        String code = request.getParameter("code");
        if (code == null || code.isBlank()) {
            response.sendRedirect(LoginFlow.loginError("provider"));
            return;
        }

        Profile profile;
        try {
            profile = provider.complete(code, nonce, verifier);
        } catch (Exception e) {
            LOG.error("{} callback failed", provider.id(), e);
            response.sendRedirect(LoginFlow.loginError("provider"));
            return;
        }
        if (profile.email() == null || profile.email().isBlank()) {
            LOG.warn("{} returned no verified email", provider.id());
            response.sendRedirect(LoginFlow.loginError("noemail"));
            return;
        }
        flow.finish(request, response, profile);
    }
}
