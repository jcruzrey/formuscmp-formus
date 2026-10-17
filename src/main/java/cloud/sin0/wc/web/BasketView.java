package cloud.sin0.wc.web;

import com.formuscmp.formus.field.Field;
import com.formuscmp.formus.resource.Resource;
import com.formuscmp.formus.response.ResponseResource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Turns the answer of a basket command ({@code <module>/basket/<name>/<version>/nuevo}) into what a table needs: the columns (the form's
 * input fields) and the rows of the page. The platform returns the rows in {@code data["basket.<module>.<name>"]} and datus' Page
 * ({@code number, pages, totalRows, pageData}) in {@code data["PAGE.basket.<module>.<name>"]}.
 */
public final class BasketView {

    private static final Set<String> INPUTS = Set.of("texto", "email", "telefono", "numero", "fecha", "textarea", "lista", "radio", "checkboxes", "checkbox");

    private BasketView() { }

    /** The form's input fields as columns: {@code name} (the table column = fieldName), {@code label}, {@code show} (showInBasket). */
    public static List<Map<String, Object>> columnsOf(Resource form) {
        List<Map<String, Object>> out = new ArrayList<>();
        if (form == null || form.getModel() == null) {
            return out;
        }
        for (Field f : form.getModel()) {
            String name = f.getFieldName() == null || f.getFieldName().isBlank() ? f.getName() : f.getFieldName();
            if (name == null || name.isBlank() || !INPUTS.contains(f.getComponentType()) || (f.isHidden() && !f.isShowInBasket())) {
                continue;
            }
            Map<String, Object> col = new LinkedHashMap<>();
            col.put("name", name);
            col.put("label", f.getLabel() == null || f.getLabel().isBlank() ? name : f.getLabel());
            col.put("show", f.isShowInBasket());
            if (f.getFormat() != null && !f.getFormat().isBlank()) {
                col.put("format", f.getFormat());
            }
            String align = f.getAlign() == null ? "" : f.getAlign().trim().toLowerCase();
            if (align.equals("left") || align.equals("center") || align.equals("right")) {
                col.put("align", align);
            }
            if (f.getWidth() != null && f.getWidth() >= 40 && f.getWidth() <= 800) {
                col.put("width", f.getWidth());
            }
            out.add(col);
        }
        return out;
    }

    /** The columns of the list: those of the saved basket when it has any, else the form's own. */
    public static List<Map<String, Object>> columnsOf(Resource basket, Resource form) {
        List<Map<String, Object>> fromBasket = basket == null || basket.getModel() == null || basket.getModel().isEmpty() ? List.of() : columnsOf(basket);
        return fromBasket.isEmpty() ? columnsOf(form != null ? form : basket) : fromBasket;
    }

    /**
     * The rows as CSV (UTF-8, comma separated, CRLF): a header with the labels of the shown columns, then one line per row. A cell that could be read as a formula
     * by a spreadsheet ({@code =}, {@code +}, {@code -}, {@code @}, tab, CR first) is prefixed with an apostrophe.
     */
    public static String csv(List<Map<String, Object>> columns, List<Map<String, Object>> rows) {
        List<Map<String, Object>> shown = new ArrayList<>();
        for (Map<String, Object> c : columns) {
            if (Boolean.TRUE.equals(c.get("show"))) {
                shown.add(c);
            }
        }
        if (shown.isEmpty()) {
            shown = columns.subList(0, Math.min(4, columns.size()));
        }
        StringBuilder sb = new StringBuilder("\uFEFF");
        for (int i = 0; i < shown.size(); i++) {
            sb.append(i == 0 ? "" : ",").append(cell(String.valueOf(shown.get(i).get("label"))));
        }
        sb.append("\r\n");
        for (Map<String, Object> r : rows) {
            for (int i = 0; i < shown.size(); i++) {
                Object v = r.get(String.valueOf(shown.get(i).get("name")));
                sb.append(i == 0 ? "" : ",").append(cell(v == null ? "" : v instanceof List<?> l ? String.join("; ", l.stream().map(String::valueOf).toList()) : String.valueOf(v)));
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }

    private static String cell(String v) {
        String s = v;
        if (!s.isEmpty() && "=+-@\t\r".indexOf(s.charAt(0)) >= 0) {
            s = "'" + s;
        }
        return s.contains(",") || s.contains("\"") || s.contains("\n") || s.contains("\r") ? "\"" + s.replace("\"", "\"\"") + "\"" : s;
    }

    /** {@code rows} (maps of column -> value), {@code total}, {@code pages}, {@code page}, {@code size}. */
    public static Map<String, Object> pageOf(ResponseResource r, String module, String name) {
        String key = "basket." + module + "." + name;
        Object pg = r.getData() == null ? null : r.getData().get("PAGE." + key);
        Object raw = pg instanceof Map<?, ?> pm && pm.get("pageData") != null ? pm.get("pageData") : r.getData() == null ? null : r.getData().get(key);
        List<Map<String, Object>> rows = new ArrayList<>();
        if (raw instanceof List<?> list) {
            for (Object o : list) {
                if (o instanceof Map<?, ?> row) {
                    Map<String, Object> datos = new LinkedHashMap<>();
                    row.forEach((k, v) -> datos.put(String.valueOf(k), v));
                    rows.add(datos);
                }
            }
        }
        Map<String, Object> d = new LinkedHashMap<>();
        d.put("rows", rows);
        d.put("total", pg instanceof Map<?, ?> pm && pm.get("totalRows") instanceof Number n ? n.intValue() : rows.size());
        d.put("pages", pg instanceof Map<?, ?> pm && pm.get("pages") instanceof Number n ? n.intValue() : 1);
        d.put("page", pg instanceof Map<?, ?> pm && pm.get("number") instanceof Number n ? n.intValue() : 1);
        d.put("size", Math.max(rows.size(), 10));
        return d;
    }
}
