package cloud.sin0.wc.auth;

import cloud.sin0.wc.client.FormusClient;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/** Common ending of every login (Google, Facebook, dev): identify, renew the session id, store the user, redirect. */
public class LoginFlow {

    private static final Logger LOG = LoggerFactory.getLogger(LoginFlow.class);
    public static final String NEXT_ATTR = "login.next";

    private final UserIdentifier identifier;
    private final String home;

    public LoginFlow(UserIdentifier identifier) {
        this(identifier, "/");
    }

    /** {@code home}: where a user lands after signing in when no page was asked for. */
    public LoginFlow(UserIdentifier identifier, String home) {
        this.identifier = identifier;
        this.home = home;
    }

    public static String loginError(String code) {
        return "/login?e=" + code;
    }

    public static FormusClient.CallContext context(HttpServletRequest request) {
        String locale = cloud.sin0.wc.client.Locales.DEFAULT; // identificar is locale independent
        String base = request.getScheme() + "://" + request.getServerName()
                + (request.getServerPort() == 80 || request.getServerPort() == 443 ? "" : ":" + request.getServerPort());
        HttpSession s = request.getSession(false);
        return new FormusClient.CallContext(locale, base, s == null ? null : s.getId(), null);
    }

    public void finish(HttpServletRequest request, HttpServletResponse response, Profile profile) throws IOException {
        HttpSession session = request.getSession(true);
        UserIdentifier.Identity identity;
        try {
            identity = identifier.identify(profile, context(request));
        } catch (UserIdentifier.IdentifyException e) {
            LOG.error("Login refused for {}: {}", profile.email(), e.getMessage());
            response.sendRedirect(loginError("identify"));
            return;
        }

        String next = Redirects.sanitizeNext((String) session.getAttribute(NEXT_ATTR), home);

        request.changeSessionId(); // session fixation protection
        new SessionUser(profile.sub(), profile.email(), profile.name(), profile.provider(), profile.picture(),
                identity.id(), identity.role(), identity.library(), identity.plan(), identity.permisos()).store(session::setAttribute);
        session.removeAttribute(NEXT_ATTR);
        session.removeAttribute(Csrf.ATTR); // new token for the new authenticated session
        for (String p : new String[]{"google", "facebook"}) {
            session.removeAttribute("oauth." + p + ".state");
            session.removeAttribute("oauth." + p + ".nonce");
            session.removeAttribute("oauth." + p + ".verifier");
        }
        LOG.info("User {} signed in via {} as {}", profile.email(), profile.provider(), identity.role());
        response.sendRedirect(next);
    }
}
