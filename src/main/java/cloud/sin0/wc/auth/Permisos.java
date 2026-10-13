package cloud.sin0.wc.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import cloud.sin0.wc.web.Coords;

/**
 * The authorization list of a user: the {@code permisos} column of {@code directorio/usuario}, tokens separated by commas.
 *
 * <pre>
 *   token  := [-] module [ : resource [ : action ] ]        (a missing or * segment matches anything)
 *   action := leer | crear | actualizar | eliminar | * | any exact command name
 * </pre>
 *
 * <ul>
 * <li>{@code *} everything; {@code inventario} the whole module; {@code inventario:producto} one resource, every action;
 *     {@code inventario:producto:leer} only reading it; {@code inventario:*:leer} read every resource of the module;
 *     {@code inventario:producto:vertir} one specific command.</li>
 * <li>A token that starts with {@code -} denies; a denial always wins over any grant, whatever their order.</li>
 * <li>Nothing matched, or an empty list, is a refusal (deny by default). Staff are not evaluated here: the caller lets them through.</li>
 * </ul>
 *
 * CRUD verbs are derived from the command that is run: {@code leer} = detalle, ver, buscar, listar, and every command of a basket
 * (a basket's {@code nuevo} is its list); {@code crear} = a form's nuevo and guardar; {@code actualizar} = actualizar, cambiarstatus,
 * cambiar; {@code eliminar} = eliminar. A command outside those is matched only by its own name (or by {@code *}).
 */
public final class Permisos {

    /** The CRUD verbs and the commands each one stands for: the single source of the check below and of the permisos editor. */
    private static final java.util.Map<String, List<String>> VOCABULARY = new java.util.LinkedHashMap<>();
    static {
        VOCABULARY.put("leer", List.of("detalle", "ver", "buscar", "listar", "consultar"));
        VOCABULARY.put("crear", List.of("nuevo", "guardar"));
        VOCABULARY.put("actualizar", List.of("actualizar", "cambiarstatus", "cambiar"));
        VOCABULARY.put("eliminar", List.of("eliminar"));
    }
    private static final String BASKET_VERB = "leer";

    /** Verb -> the commands it covers, in the order the grammar lists them (a read-only copy). */
    public static java.util.Map<String, List<String>> vocabulary() {
        java.util.Map<String, List<String>> copy = new java.util.LinkedHashMap<>();
        VOCABULARY.forEach((verb, commands) -> copy.put(verb, List.copyOf(commands)));
        return java.util.Collections.unmodifiableMap(copy);
    }

    /** The verb every command of a basket stands for (a basket's {@code nuevo} is its list). */
    public static String basketVerb() {
        return BASKET_VERB;
    }

    private final List<String[]> grants = new ArrayList<>();
    private final List<String[]> denials = new ArrayList<>();

    private Permisos(String list) {
        if (list == null) {
            return;
        }
        for (String raw : list.split(",")) {
            String token = raw.trim().toLowerCase(Locale.ROOT);
            boolean deny = token.startsWith("-");
            if (deny) {
                token = token.substring(1).trim();
            }
            if (token.isEmpty()) {
                continue;
            }
            String[] parts = token.split(":", -1);
            if (parts.length > 3) {
                continue;   // malformed: ignored, so it can neither grant nor deny by accident
            }
            String[] segments = {"*", "*", "*"};
            for (int i = 0; i < parts.length; i++) {
                String s = parts[i].trim();
                segments[i] = s.isEmpty() ? "*" : s;
            }
            (deny ? denials : grants).add(segments);
        }
    }

    public static Permisos of(String list) {
        return new Permisos(list);
    }

    private static final java.util.regex.Pattern SEGMENT = java.util.regex.Pattern.compile("[a-z0-9_.*-]*");

    /**
     * The canonical text of a permisos list as the editor writes it, or {@code null} when some token is not valid (a segment with a character
     * outside {@code a-z 0-9 _ . - *}, an empty module, more than three segments). Tokens are lower-cased, trimmed and de-duplicated in
     * order, and trailing wildcard segments are dropped ({@code inventario:*:*} and {@code inventario:producto:*} become {@code inventario} and
     * {@code inventario:producto}), which {@link #of} reads exactly the same. A blank list is {@code ""}.
     */
    public static String normalize(String list) {
        if (list == null) {
            return "";
        }
        java.util.LinkedHashSet<String> out = new java.util.LinkedHashSet<>();
        for (String raw : list.split(",")) {
            String token = raw.trim().toLowerCase(Locale.ROOT);
            if (token.isEmpty()) {
                continue;
            }
            boolean deny = token.startsWith("-");
            if (deny) {
                token = token.substring(1).trim();
            }
            String[] parts = token.split(":", -1);
            if (token.isEmpty() || parts.length > 3 || parts[0].trim().isEmpty() || parts[0].startsWith("-")) {
                return null;
            }
            List<String> segments = new ArrayList<>();
            for (String part : parts) {
                String seg = part.trim();
                if (!SEGMENT.matcher(seg).matches()) {
                    return null;
                }
                segments.add(seg.isEmpty() ? "*" : seg);
            }
            while (segments.size() > 1 && segments.get(segments.size() - 1).equals("*")) {
                segments.remove(segments.size() - 1);
            }
            out.add((deny ? "-" : "") + String.join(":", segments));
        }
        return String.join(",", out);
    }

    public boolean isEmpty() {
        return grants.isEmpty() && denials.isEmpty();
    }

    /** True when the list grants this operation and no denial covers it. */
    public boolean allows(Coords k) {
        String module = k.module().toLowerCase(Locale.ROOT), name = k.name().toLowerCase(Locale.ROOT);
        String command = k.command().toLowerCase(Locale.ROOT);
        String verb = verbOf(k.type(), command);
        for (String[] d : denials) {
            if (matches(d, module, name, command, verb)) {
                return false;
            }
        }
        for (String[] g : grants) {
            if (matches(g, module, name, command, verb)) {
                return true;
            }
        }
        return false;
    }

    /** The CRUD verb of a command, or null when the command has none (only its own name or {@code *} then matches). */
    static String verbOf(String type, String command) {
        if ("basket".equals(type)) {
            return BASKET_VERB;
        }
        for (java.util.Map.Entry<String, List<String>> verb : VOCABULARY.entrySet()) {
            if (verb.getValue().contains(command)) {
                return verb.getKey();
            }
        }
        return null;
    }

    private static boolean matches(String[] t, String module, String name, String command, String verb) {
        return (t[0].equals("*") || t[0].equals(module))
                && (t[1].equals("*") || t[1].equals(name))
                && (t[2].equals("*") || t[2].equals(command) || t[2].equals(verb));
    }
}
