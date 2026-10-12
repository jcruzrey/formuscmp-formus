package cloud.sin0.wc.auth;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * POST /auth/dev/login: local-only sign-in by email, through the same identify step as real providers (so the
 * role comes from the backend). Only registered when {@code AppConfig.devLogin()} is true, which is never the
 * case with secure cookies.
 */
public class DevLoginServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(DevLoginServlet.class);
    private static final Pattern EMAIL = Pattern.compile("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$");

    private final LoginFlow flow;

    public DevLoginServlet(LoginFlow flow) {
        this.flow = flow;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null || !Csrf.matches(session::getAttribute, request.getParameter(Csrf.FIELD))) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "CSRF");
            return;
        }
        String email = request.getParameter("email");
        if (email == null || !EMAIL.matcher(email.trim()).matches()) {
            response.sendRedirect(LoginFlow.loginError("noemail"));
            return;
        }
        email = email.trim().toLowerCase();
        String local = email.substring(0, email.indexOf('@'));
        String name = Character.toUpperCase(local.charAt(0)) + local.substring(1);
        String next = Redirects.sanitizeNext(request.getParameter("next"), null);
        if (next != null) {
            session.setAttribute(LoginFlow.NEXT_ATTR, next);
        }
        LOG.warn("DEV LOGIN used for {}", email);
        flow.finish(request, response, new Profile("Local", "dev:" + email, email, name, null));
    }
}
