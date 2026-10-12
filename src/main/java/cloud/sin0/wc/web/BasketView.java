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
            out.add(col);
        }
        return out;
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
