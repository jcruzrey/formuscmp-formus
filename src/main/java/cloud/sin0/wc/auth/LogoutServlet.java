package cloud.sin0.wc.auth;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/** POST /auth/logout (CSRF-protected). A GET is answered 405 by HttpServlet. */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (!Csrf.matches(session::getAttribute, request.getParameter(Csrf.FIELD))) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "CSRF");
                return;
            }
            session.invalidate();
        }
        response.sendRedirect("/login");
    }
}
