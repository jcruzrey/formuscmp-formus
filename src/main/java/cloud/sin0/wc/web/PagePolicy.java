package cloud.sin0.wc.web;

import java.util.regex.Pattern;

/**
 * What ONE page needs beyond the engine's default security headers (a page that talks to a provider from the browser, such as a softphone): extra places it may connect to and
 * load media from, and the microphone. Everything else stays as the engine sets it for every page, and an application that declares nothing changes nothing.
 *
 * <p>The values are lists of sources of a Content-Security-Policy ({@code https://*.example.com wss://*.example.com}); anything that could end a directive or add one
 * ({@code ;}, quotes, line breaks, commas) is refused when the policy is made, so a value read from a setting cannot open the policy.
 *
 * @param connectSrc places the page may open connections to (fetch, WebSocket), besides itself; may be empty
 * @param mediaSrc   places the page may load audio and video from, besides itself and {@code blob:}; may be empty
 * @param microphone true: the page may ask for the microphone (the default for every page is that it may not)
 */
public record PagePolicy(String connectSrc, String mediaSrc, boolean microphone) {

    private static final Pattern SOURCES = Pattern.compile("^[A-Za-z0-9:/*.\\- ]{0,300}$");

    public PagePolicy {
        connectSrc = connectSrc == null ? "" : connectSrc.trim();
        mediaSrc = mediaSrc == null ? "" : mediaSrc.trim();
        if (!SOURCES.matcher(connectSrc).matches() || !SOURCES.matcher(mediaSrc).matches()) {
            throw new IllegalArgumentException("a security policy source may only hold letters, digits and : / * . - and spaces");
        }
    }
}
