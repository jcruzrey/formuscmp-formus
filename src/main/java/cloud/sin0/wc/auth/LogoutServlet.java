package cloud.sin0.wc.auth;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URI;

/**
 * POST /auth/logout (CSRF-protected). A GET is answered 405 by HttpServlet.
 * A page that was loaded under an older session (another tab signed in again, the server restarted) carries a token the current session does not know: the
 * person asking to sign out is still the person, so a request that comes from this very site (Sec-Fetch-Site same-origin, or an Origin / Referer with this
 * host) signs out even then. Anything else with a wrong token (another site, no origin at all) is still refused with 403.
 */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (!Csrf.matches(session::getAttribute, request.getParameter(Csrf.FIELD)) && !fromThisSite(request)) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "CSRF");
                return;
            }
            session.invalidate();
        }
        response.sendRedirect("/login");
    }

    /** True when the browser says the request was made by a page of this same site: browsers set these headers and a page of another site cannot forge them. */
    static boolean fromThisSite(HttpServletRequest request) {
        String site = request.getHeader("Sec-Fetch-Site");
        if (site != null) {
            return "same-origin".equals(site);
        }
        String host = request.getHeader("Host");
        if (host == null || host.isBlank()) {
            return false;
        }
        for (String header : new String[] {"Origin", "Referer"}) {
            String v = request.getHeader(header);
            if (v == null || v.isBlank() || "null".equals(v)) {
                continue;
            }
            try {
                String authority = URI.create(v).getAuthority();
                return authority != null && authority.equalsIgnoreCase(host);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return false;
    }
}
