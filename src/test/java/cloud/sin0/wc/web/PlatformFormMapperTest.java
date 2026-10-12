package cloud.sin0.wc.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlatformFormMapperTest {

    static final ObjectMapper OM = new ObjectMapper();
    final PlatformFormMapper mapper = new PlatformFormMapper(OM);

    JsonNode json(String s) throws Exception {
        return OM.readTree(s.replace('\'', '"'));
    }

    @Test
    void mapsMetaAndSimpleComponentTypesInOrder() throws Exception {
        JsonNode out = mapper.toBuilderModel(json("{'name':'empresa','title':'Empresa','module':'directorio','version':'1.0','table':'dircto','instruction':'Datos','model':["
                + "{'name':'b','fieldName':'correo','label':'Correo','componentType':'email','order':2,'required':true},"
                + "{'name':'a','fieldName':'razon','label':'Razon social','componentType':'texto','order':1,'required':true},"
                + "{'name':'c','fieldName':'alta','label':'Alta','componentType':'fecha','order':3},"
                + "{'name':'d','fieldName':'nota','label':'Nota','componentType':'textoarea','order':4},"
                + "{'name':'e','fieldName':'activo','label':'Activo','componentType':'checkbox','order':5}]}"));
        assertEquals("Empresa", out.at("/meta/title").asText());
        assertEquals("directorio", out.at("/meta/module").asText());
        assertEquals("dircto", out.at("/meta/table").asText());
        JsonNode f = out.get("fields");
        assertEquals(5, f.size());
        assertEquals("razon", f.get(0).get("name").asText(), "ordered by the platform's order, not by array position");
        assertEquals("text", f.get(0).get("type").asText());
        assertTrue(f.get(0).get("required").asBoolean());
        assertEquals("email", f.get(1).get("type").asText());
        assertEquals("date", f.get(2).get("type").asText());
        assertEquals("textarea", f.get(3).get("type").asText());
        assertEquals("checkbox", f.get(4).get("type").asText());
    }

    @Test
    void inlineListsBecomeSelectsAndDynamicListsFallBackToText() throws Exception {
        String origin = "{\\\"origin\\\":\\\"recurso\\\",\\\"resource\\\":\\\"inlinevalues\\\",\\\"fields\\\":[{\\\"name\\\":\\\"A, B ,C\\\"}]}";
        JsonNode out = mapper.toBuilderModel(OM.readTree("{\"name\":\"x\",\"model\":["
                + "{\"fieldName\":\"tipo\",\"label\":\"Tipo\",\"componentType\":\"lista\",\"order\":1,\"origin\":\"" + origin + "\"},"
                + "{\"fieldName\":\"regimen\",\"label\":\"Regimen\",\"componentType\":\"regimen\",\"order\":2,\"dbFieldType\":\"varchar\"},"
                + "{\"fieldName\":\"cantidad\",\"label\":\"Cantidad\",\"componentType\":\"raro\",\"order\":3,\"dbFieldType\":\"int\"},"
                + "{\"fieldName\":\"precio\",\"label\":\"Precio\",\"componentType\":\"raro\",\"order\":4,\"dbFieldType\":\"decimal\"}]}"));
        JsonNode f = out.get("fields");
        assertEquals("select", f.get(0).get("type").asText());
        assertEquals("[\"A\",\"B\",\"C\"]", f.get(0).get("options").toString(), "values trimmed");
        assertEquals("text", f.get(1).get("type").asText(), "dynamic platform lists are plain inputs in v1");
        assertEquals("number", f.get(2).get("type").asText());
        assertEquals("0.01", f.get(3).get("step").asText());
    }

    @Test
    void skipsUnsafeNamesAndUnresolvedHiddenDefaultsAndShowsTheRest() throws Exception {
        JsonNode out = mapper.toBuilderModel(json("{'name':'x','model':["
                + "{'fieldName':'token','label':'Token','componentType':'texto','hidden':true,'order':1,'value':'${default::uuid}'},"
                + "{'fieldName':'bad name','label':'Bad','componentType':'texto','order':2},"
                + "{'fieldName':'1abc','label':'Bad2','componentType':'texto','order':3},"
                + "{'fieldName':'codigo','label':'Codigo','componentType':'texto','order':3},"
                + "{'fieldName':'falta','label':'Fecha','componentType':'texto','value':'${default::fecha}','order':4},"
                + "{'fieldName':'pais','label':'Pais','componentType':'texto','value':'MX','order':5,'readOnly':true}]}"));
        JsonNode f = out.get("fields");
        assertEquals(2, f.size());
        assertEquals("falta", f.get(0).get("name").asText());
        assertFalse(f.get(0).has("value"), "an unresolved ${default::...} is never shown as a value");
        assertEquals("MX", f.get(1).get("value").asText());
        assertTrue(f.get(1).get("readOnly").asBoolean());
    }

    @Test
    void toleratesGarbage() throws Exception {
        assertEquals(0, mapper.toBuilderModel(null).get("fields").size());
        assertEquals(0, mapper.toBuilderModel(json("{'model':'nope'}")).get("fields").size());
        assertEquals(0, mapper.toBuilderModel(json("{'model':[1,'x',null,{'label':5}]}")).get("fields").size());
        JsonNode meta = mapper.toBuilderModel(json("{'name':{'a':1},'title':[1]}")).get("meta");
        assertEquals("", meta.get("title").asText());
    }

    @Test
    void hiddenFieldsArePartOfTheCaptureFormFlaggedHiddenAndTheDesignerIsGivenAllOfThemWithTheirFlags() throws Exception {
        JsonNode form = json("{'name':'evento','model':["
                + "{'fieldName':'uuid','label':'Uuid','componentType':'texto','order':1,'id':true,'showInBasket':true},"
                + "{'fieldName':'uuidp','label':'Uuidp','componentType':'texto','order':2,'hidden':true,'required':true},"
                + "{'fieldName':'uuide','label':'Uuide','componentType':'texto','order':3,'hidden':true,'value':'1791-abc'},"
                + "{'fieldName':'token','label':'Token','componentType':'texto','order':4,'hidden':true,'value':'${default::uuid}'},"
                + "{'fieldName':'lugar','label':'Lugar','componentType':'texto','order':5}]}");
        JsonNode capture = mapper.toBuilderModel(form).get("fields");
        assertEquals(4, capture.size(), "capture: hidden fields are on the form (token's unresolved default is left to the platform)");
        assertEquals("uuid,uuidp,uuide,lugar", String.join(",", capture.findValuesAsText("name")));
        assertFalse(capture.get(0).has("hidden"));
        assertTrue(capture.get(1).get("hidden").asBoolean(), "flagged hidden: the renderer keeps it out of sight but it is posted");
        assertFalse(capture.get(1).get("required").asBoolean(), "a hidden field can never block the submit");
        assertEquals("1791-abc", capture.get(2).get("value").asText(), "the resolved default travels with the form");
        assertFalse(capture.get(0).has("isId"), "capture output carries no designer flags");

        JsonNode edit = mapper.toBuilderModel(form, true).get("fields");
        assertEquals(5, edit.size(), "designer: every field, hidden ones included");
        assertTrue(edit.get(0).get("isId").asBoolean());
        assertTrue(edit.get(0).get("showInBasket").asBoolean());
        assertFalse(edit.get(0).has("hidden"));
        assertEquals("uuidp", edit.get(1).get("name").asText());
        assertTrue(edit.get(1).get("hidden").asBoolean(), "flagged hidden, so saving it back keeps it hidden");
        assertFalse(edit.get(2).has("isId"));
    }

    @Test
    void capsTheNumberOfFields() throws Exception {
        StringBuilder sb = new StringBuilder("{'name':'big','model':[");
        for (int i = 0; i < 400; i++) {
            sb.append(i == 0 ? "" : ",").append("{'fieldName':'f").append(i).append("','label':'L','componentType':'texto','order':").append(i).append('}');
        }
        assertEquals(200, mapper.toBuilderModel(json(sb.append("]}").toString())).get("fields").size());
    }
}
