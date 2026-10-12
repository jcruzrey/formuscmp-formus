package cloud.sin0.wc.web;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.Callback;

/**
 * Adds the security headers to every response (pages, static files, redirects).
 * The CSP allows inline scripts/styles because the form page embeds the catalog JSON and Bootstrap uses inline
 * style attributes; a nonce-based policy is a later hardening step (plan.md, Phase 7).
 */
public class SecurityHeadersHandler extends Handler.Wrapper {

    static final String CSP = "default-src 'self'; img-src 'self' data: https:; style-src 'self' 'unsafe-inline'; "
            + "script-src 'self' 'unsafe-inline'; font-src 'self'; object-src 'none'; base-uri 'self'; "
            + "form-action 'self'; frame-ancestors 'none'";

    private final boolean hsts;

    public SecurityHeadersHandler(Handler handler, boolean hsts) {
        super(handler);
        this.hsts = hsts;
    }

    @Override
    public boolean handle(Request request, Response response, Callback callback) throws Exception {
        var h = response.getHeaders();
        h.put("Content-Security-Policy", CSP);
        h.put("X-Content-Type-Options", "nosniff");
        h.put("X-Frame-Options", "DENY");
        h.put("Referrer-Policy", "strict-origin-when-cross-origin");
        h.put("Permissions-Policy", "camera=(), microphone=(), geolocation=()");
        if (hsts) {
            h.put("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
        }
        return super.handle(request, response, callback);
    }
}
