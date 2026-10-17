package cloud.sin0.wc.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formuscmp.formus.field.Field;
import com.formuscmp.formus.resource.Resource;

/** The columns of a list as the saved basket says them (label, order, format, align, width), and the CSV of its rows. */
class BasketViewTest {

	private static Field campo(String nombre, String etiqueta, boolean enLista) {
		Field f = new Field();
		f.setFieldName(nombre);
		f.setName(nombre);
		f.setLabel(etiqueta);
		f.setComponentType("texto");
		f.setShowInBasket(enLista);
		return f;
	}

	private static Resource recurso(Field... campos) {
		Resource r = new Resource();
		List<Field> modelo = new ArrayList<>(List.of(campos));
		r.setModel(modelo);
		return r;
	}

	@Test
	void alineacionAnchoYFormatoLlegaranALaColumnaSoloSiSonValidos() {
		Field precio = campo("precio", "Precio", true);
		precio.setAlign("Right");
		precio.setWidth(120);
		precio.setFormat("0.00");
		Field raro = campo("raro", "Raro", true);
		raro.setAlign("justify");   // not one of left/center/right
		raro.setWidth(5);           // out of range
		Map<String, Object> p = BasketView.columnsOf(recurso(precio, raro)).get(0), r = BasketView.columnsOf(recurso(precio, raro)).get(1);
		assertEquals("right", p.get("align"));
		assertEquals(120, p.get("width"));
		assertEquals("0.00", p.get("format"));
		assertFalse(r.containsKey("align"));
		assertFalse(r.containsKey("width"));
		assertFalse(r.containsKey("format"));
	}

	@Test
	void laCanastaGuardadaManda_ysinCanastaSeUsaElFormulario() {
		Resource forma = recurso(campo("a", "A", true), campo("b", "B", true), campo("c", "C", true));
		Resource canasta = recurso(campo("c", "Ce", true), campo("a", "A grande", true));   // the saved basket: two columns, in its own order and labels
		List<Map<String, Object>> cols = BasketView.columnsOf(canasta, forma);
		assertEquals(List.of("c", "a"), cols.stream().map(c -> String.valueOf(c.get("name"))).toList());
		assertEquals("Ce", cols.get(0).get("label"));
		assertEquals(3, BasketView.columnsOf(null, forma).size(), "no saved basket: the form's own columns");
		assertEquals(3, BasketView.columnsOf(new Resource(), forma).size(), "an empty basket model is no basket");
	}

	@Test
	void elCsvLlevaEtiquetasFilasYProtegeCeldasQueParecenFormulas() {
		List<Map<String, Object>> cols = BasketView.columnsOf(recurso(campo("n", "Nombre", true), campo("o", "Obs, nota", true), campo("x", "Oculta", false)));
		Map<String, Object> fila = new LinkedHashMap<>();
		fila.put("n", "Ana \"la\" Cruz");
		fila.put("o", "=HYPERLINK(\"http://x\")");
		fila.put("x", "no sale");
		Map<String, Object> otra = new LinkedHashMap<>();
		otra.put("n", "Luis");
		otra.put("o", List.of("a", "b"));
		String csv = BasketView.csv(cols, List.of(fila, otra));
		String[] lineas = csv.split("\r\n");
		assertEquals("﻿Nombre,\"Obs, nota\"", lineas[0]);
		assertEquals("\"Ana \"\"la\"\" Cruz\",\"'=HYPERLINK(\"\"http://x\"\")\"", lineas[1], "quotes doubled, formula neutralised");
		assertEquals("Luis,a; b", lineas[2]);
		assertTrue(csv.endsWith("\r\n"));
		assertFalse(csv.contains("no sale"), "a column that is not shown is not exported");
	}

	@Test
	void alineacionYAnchoSeGuardanEnElJsonSoloSiSeAsignan() throws Exception {
		ObjectMapper m = new ObjectMapper();
		Field sin = campo("a", "A", true);
		assertFalse(m.valueToTree(sin).has("align"));
		assertFalse(m.valueToTree(sin).has("width"));
		Field con = campo("b", "B", true);
		con.setAlign("center");
		con.setWidth(90);
		assertEquals("center", m.valueToTree(con).get("align").asText());
		assertEquals(90, m.valueToTree(con).get("width").asInt());
		Resource r = recurso(con);
		assertNull(r.getBasketOptions());
		assertFalse(m.valueToTree(r).has("basketOptions"), "no options: nothing written");
		r.setBasketOptions(Map.of("pageSize", 10, "exportCsv", true));
		Resource back = m.readValue(m.writeValueAsString(r), Resource.class);
		assertEquals(10, back.getBasketOptions().get("pageSize"));
		assertEquals(true, back.getBasketOptions().get("exportCsv"));
	}
}
