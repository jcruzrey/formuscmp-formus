package cloud.sin0.wc.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The address of a page is the address of the formus-ws operation it runs:
 * {@code /<module>/<form|basket>/<name>/<version>/<command>}. With the {@code .do} suffix it is the raw command
 * ({@code /<module>/<type>/<name>/<version>/<command>.do}, any resource type), answered by the generic pipeline without application pages.
 * formus-ws finds the script from the command name plus the locale; the client only sends both.
 */
public record Coords(String module, String type, String name, String version, String command, boolean raw) {

    private static final Pattern PAGE = Pattern.compile("^/([A-Za-z0-9_-]{1,60})/(form|basket)/([A-Za-z0-9_-]{1,60})/([0-9][0-9.]{0,9})/([a-z]{3,20})$");
    private static final Pattern RAW = Pattern.compile("^/([\\w.-]+)/([\\w.-]+)/([\\w.-]+)/([\\w.-]+)/([\\w.-]+)\\.do$");

    /** The coordinates of a request path, or null when the path is not an operation address. */
    public static Coords parse(String path) {
        if (path == null) {
            return null;
        }
        Matcher m = PAGE.matcher(path);
        if (m.matches()) {
            return new Coords(m.group(1), m.group(2), m.group(3), m.group(4), m.group(5), false);
        }
        m = RAW.matcher(path);
        return m.matches() ? new Coords(m.group(1), m.group(2), m.group(3), m.group(4), m.group(5), true) : null;
    }

    /** The page address ({@code .do} never included). */
    public String path() {
        return "/" + module + "/" + type + "/" + name + "/" + version + "/" + command;
    }

    /** The same resource with another command: the page address a button of this form posts to. */
    public String path(String otherCommand) {
        return "/" + module + "/" + type + "/" + name + "/" + version + "/" + otherCommand;
    }
}
