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

    static final String CSP_BASE = "default-src 'self'; img-src 'self' data: https:; style-src 'self' 'unsafe-inline'; "
            + "script-src 'self' 'unsafe-inline'; font-src 'self'; object-src 'none'; base-uri 'self'; "
            + "form-action 'self'; ";
    static final String CSP = CSP_BASE + "frame-ancestors 'none'";
    /** For an application that shows its own pages inside itself (an IDE with editors in tabs): the same origin may frame, nobody else. */
    static final String CSP_SAME_ORIGIN_FRAMES = CSP_BASE + "frame-ancestors 'self'";

    private final boolean hsts;
    private final boolean sameOriginFrames;

    public SecurityHeadersHandler(Handler handler, boolean hsts) {
        this(handler, hsts, false);
    }

    /** @param sameOriginFrames true: pages may be framed by pages of the same origin (X-Frame-Options SAMEORIGIN); false (the default): never framed */
    public SecurityHeadersHandler(Handler handler, boolean hsts, boolean sameOriginFrames) {
        super(handler);
        this.hsts = hsts;
        this.sameOriginFrames = sameOriginFrames;
    }

    @Override
    public boolean handle(Request request, Response response, Callback callback) throws Exception {
        var h = response.getHeaders();
        h.put("Content-Security-Policy", sameOriginFrames ? CSP_SAME_ORIGIN_FRAMES : CSP);
        h.put("X-Content-Type-Options", "nosniff");
        h.put("X-Frame-Options", sameOriginFrames ? "SAMEORIGIN" : "DENY");
        h.put("Referrer-Policy", "strict-origin-when-cross-origin");
        h.put("Permissions-Policy", "camera=(), microphone=(), geolocation=()");
        if (hsts) {
            h.put("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
        }
        return super.handle(request, response, callback);
    }
}
