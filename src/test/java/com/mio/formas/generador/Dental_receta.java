/**
 * 
 */
package com.mio.formas.generador;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.formuscmp.formus.button.Button;
import com.formuscmp.formus.field.Field;
import com.formuscmp.formus.generator.Generador;
import com.formuscmp.formus.generator.IGenerador;
import com.formuscmp.formus.resource.GenerateCode;
import com.formuscmp.formus.resource.Resource;

/**
 * @author jcruzrey
 *
 */
public class Dental_receta extends GenerateCode {

	private String[] templatesPath = new String[] { "/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config" };

	/**
	 * Test method for
	 * {@link com.formuscmp.formus.generator.Generador#guatdarForma(java.util.List, java.lang.String)}.
	 */

	private List<Button> dameMetodosComunes(String idioma, String modulo, String recurso, String version,
			Integer orden) {
		List<Button> metodos = new ArrayList<Button>();

		if (idioma.equals("es_MX")) {
			Button buttonGuardar = new Button();
			buttonGuardar.setCommandName("guardar");
			buttonGuardar.setComment("Boton guardar");
			buttonGuardar.setComponentType("botonjs");
			buttonGuardar.setCss("btn btn-primary");
			buttonGuardar.setEvents("nuevo");
			buttonGuardar.setInstruction("Formulario guardado correctamente");
			buttonGuardar.setLabel("Guardar");
			buttonGuardar.setModule(modulo);
			buttonGuardar.setName("guardar");
			buttonGuardar.setOrder(1);
			buttonGuardar.setResourceName(recurso);
			buttonGuardar.setResourceType("form");
			buttonGuardar.setUuid(generarToken());
			buttonGuardar.setVersion(version);
			metodos.add(buttonGuardar);

			Button buttonActualizar = new Button();
			buttonActualizar.setCommandName("actualizar");
			buttonActualizar.setComment("Boton actualizar");
			buttonActualizar.setComponentType("botonjs");
			buttonActualizar.setCss("btn btn-danger");
			buttonActualizar.setEvents("actualizar,detalle");
			buttonActualizar.setInstruction("Formulario actualizado correctamente");
			buttonActualizar.setLabel("Actualizar");
			buttonActualizar.setModule(modulo);
			buttonActualizar.setName("actualizar");
			buttonActualizar.setOrder(2);
			buttonActualizar.setResourceName(recurso);
			buttonActualizar.setResourceType("form");
			buttonActualizar.setUuid(generarToken());
			buttonActualizar.setVersion(version);
			metodos.add(buttonActualizar);
		} else {
			Button buttonGuardar = new Button();
			buttonGuardar.setCommandName("save");
			buttonGuardar.setComment("Save button");
			buttonGuardar.setComponentType("buttonjs");
			buttonGuardar.setCss("btn btn-primary");
			buttonGuardar.setEvents("new");
			buttonGuardar.setInstruction("Formulario guardado correctamente");
			buttonGuardar.setLabel("Save");
			buttonGuardar.setModule(modulo);
			buttonGuardar.setName("save");
			buttonGuardar.setOrder(1);
			buttonGuardar.setResourceName(recurso);
			buttonGuardar.setResourceType("form");
			buttonGuardar.setUuid(generarToken());
			buttonGuardar.setVersion(version);
			metodos.add(buttonGuardar);

			Button buttonActualizar = new Button();
			buttonActualizar.setCommandName("update");
			buttonActualizar.setComment("Update button");
			buttonActualizar.setComponentType("buttonjs");
			buttonActualizar.setCss("btn btn-danger");
			buttonActualizar.setEvents("update,detail");
			buttonActualizar.setInstruction("Form updated succesfully");
			buttonActualizar.setLabel("Update");
			buttonActualizar.setModule(modulo);
			buttonActualizar.setName("update");
			buttonActualizar.setOrder(2);
			buttonActualizar.setResourceName(recurso);
			buttonActualizar.setResourceType("form");
			buttonActualizar.setUuid(generarToken());
			buttonActualizar.setVersion(version);
			metodos.add(buttonActualizar);
		}

		Button metodoDetalle = new Button();
		metodoDetalle.setModule(modulo);
		metodoDetalle.setResourceName(recurso);
		metodoDetalle.setVersion(version);
		metodoDetalle.setCss("btn btn-primary");
		if (idioma.equals("es_MX")) {
			metodoDetalle.setName("detalle");
			metodoDetalle.setCommandName("detalle");
			metodoDetalle.setResourceType("form");
			metodoDetalle.setLabel("Detalle");
			metodoDetalle.setEvents("nuevo");
			metodoDetalle.setComponentType("someter");
			metodoDetalle.setOrder(3);
			metodoDetalle.setInstruction("Detalles");
			metodoDetalle.setEvents("guardar,actualizar,detalle");
		} else {
			metodoDetalle.setName("detail");
			metodoDetalle.setResourceType("form");
			metodoDetalle.setCommandName("detail");
			metodoDetalle.setLabel("Detail");
			metodoDetalle.setEvents("new");
			metodoDetalle.setComponentType("submit");
			metodoDetalle.setOrder(3);
			metodoDetalle.setInstruction("Details");
			metodoDetalle.setEvents("save,update,detail");
		}
		metodoDetalle.setUuid(generarToken());
		metodos.add(metodoDetalle);
		return metodos;
	}

	/**
	 * Test method for
	 * {@link com.formuscmp.formus.generator.Generador#guatdarForma(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testNuevo() throws IOException {

		String modulo = "dental"; // modulo *
		String formulario = "receta"; // nombre del formulario *
		String version = "1.0"; // version
		String idioma = "es_MX"; // version

		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve(modulo + "_" + formulario + ".json").normalize();
		int orden = 1;
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes(idioma, modulo, formulario, version, 1);

		// Definir todos los campos *
		Field codigoCampo = new Field();
		Field nombreCampo = new Field();
		Field fechaCampo = new Field();
		Field edadCampo = new Field();
		Field pesoCampo = new Field();
		Field firmaCampo = new Field();
		Field recetaCampo = new Field();
		Field uuidCampo = new Field();
		Field uuidpCampo = new Field();
		Field uuideCampo = new Field();

		Resource forma = new Resource();

		// Ajustar *
		forma.setPrefix("RCA");
		forma.setCommandName("guardar");
		forma.setName("receta");
		forma.setView("recet01");
		forma.setTitle("Receta Dental");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule(modulo);
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("recetadental");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la receta");
		forma.setUuid(generarToken());
		forma.setComment("Receta Dental");
		forma.setOrigin("ui::case");
		forma.setDestination("db::mysql");
		forma.setUuid(generarToken());
		forma.setPersistible(true);
		forma.setValidate(true);
		forma.setLastModificationDate(new java.util.Date().getTime());

		codigoCampo.setName("codigo");
		codigoCampo.setFieldName("codigo");
		codigoCampo.setCss("form-control");
		codigoCampo.setOrder(orden);
		codigoCampo.setComponentType("texto");
		codigoCampo.setReadOnly(true);
		codigoCampo.setHidden(false);
		codigoCampo.setRequired(false);
		codigoCampo.setShowInBasket(true);
		codigoCampo.setId(false);
		codigoCampo.setSearcheable(true);
		codigoCampo.setValidation(null);
		codigoCampo.setFormat(null);
		codigoCampo.setGroup("header");
		codigoCampo.setLength(20);
		codigoCampo.setDbFieldType("varchar");
		codigoCampo.setDecimals(0);
		codigoCampo.setPersistible(true);
		codigoCampo.setLabel("Codigo (Auto)");
		codigoCampo.setUuid(generarToken());
		codigoCampo.setComment("Receta");
		codigoCampo.setAffects(null);
		codigoCampo.setFilter(null);
		codigoCampo.setEvents("*");
		codigoCampo.setOrigin(null);
		codigoCampo.setValue("");

		orden++;
		nombreCampo.setName("nombre");
		nombreCampo.setFieldName("nombre");
		nombreCampo.setCss("form-control");
		nombreCampo.setOrder(orden);
		nombreCampo.setComponentType("texto");
		nombreCampo.setReadOnly(false);
		nombreCampo.setHidden(false);
		nombreCampo.setRequired(true);
		nombreCampo.setShowInBasket(true);
		nombreCampo.setId(false);
		nombreCampo.setSearcheable(true);
		nombreCampo.setValidation(null);
		nombreCampo.setFormat(null);
		nombreCampo.setGroup("header");
		nombreCampo.setLength(100);
		nombreCampo.setDbFieldType("varchar");
		nombreCampo.setDecimals(0);
		nombreCampo.setPersistible(true);
		nombreCampo.setLabel("Nombre");
		nombreCampo.setUuid(generarToken());
		nombreCampo.setComment("nombre");
		nombreCampo.setAffects(null);
		nombreCampo.setFilter(null);
		nombreCampo.setEvents("*");
		nombreCampo.setOrigin(null);
		nombreCampo.setValue("");

		orden++;
		fechaCampo.setName("fechayhora");
		fechaCampo.setFieldName("fechayhora");
		fechaCampo.setCss("form-control");
		fechaCampo.setOrder(orden);
		fechaCampo.setComponentType("texto");
		fechaCampo.setReadOnly(false);
		fechaCampo.setHidden(false);
		fechaCampo.setRequired(true);
		fechaCampo.setShowInBasket(true);
		fechaCampo.setId(false);
		fechaCampo.setSearcheable(true);
		fechaCampo.setValidation("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$");
		fechaCampo.setFormat(null);
		fechaCampo.setGroup("header");
		fechaCampo.setLength(0);
		fechaCampo.setDbFieldType("datetime");
		fechaCampo.setDecimals(0);
		fechaCampo.setPersistible(true);
		fechaCampo.setLabel("Fecha/Hora");
		fechaCampo.setUuid(generarToken());
		fechaCampo.setComment("Fecha/Hora");
		fechaCampo.setAffects(null);
		fechaCampo.setFilter(null);
		fechaCampo.setEvents("*");
		fechaCampo.setOrigin(null);
		fechaCampo.setValue("${default::fechayHoraCorto}");

		orden++;
		edadCampo.setName("edad");
		edadCampo.setFieldName("edad");
		edadCampo.setCss("form-control");
		edadCampo.setOrder(orden);
		edadCampo.setComponentType("texto");
		edadCampo.setReadOnly(false);
		edadCampo.setHidden(false);
		edadCampo.setRequired(true);
		edadCampo.setShowInBasket(true);
		edadCampo.setId(false);
		edadCampo.setSearcheable(true);
		edadCampo.setValidation(null);
		edadCampo.setFormat(null);
		edadCampo.setGroup("header");
		edadCampo.setLength(4);
		edadCampo.setDbFieldType("int");
		edadCampo.setDecimals(0);
		edadCampo.setPersistible(true);
		edadCampo.setLabel("Edad");
		edadCampo.setUuid(generarToken());
		edadCampo.setComment("edad");
		edadCampo.setAffects(null);
		edadCampo.setFilter(null);
		edadCampo.setEvents("*");
		edadCampo.setOrigin(null);
		edadCampo.setValue("");

		orden++;
		pesoCampo.setName("peso");
		pesoCampo.setFieldName("peso");
		pesoCampo.setCss("form-control");
		pesoCampo.setOrder(orden);
		pesoCampo.setComponentType("texto");
		pesoCampo.setReadOnly(false);
		pesoCampo.setHidden(false);
		pesoCampo.setRequired(true);
		pesoCampo.setShowInBasket(true);
		pesoCampo.setId(false);
		pesoCampo.setSearcheable(true);
		pesoCampo.setValidation(null);
		pesoCampo.setFormat(null);
		pesoCampo.setGroup("header");
		pesoCampo.setLength(3);
		pesoCampo.setDbFieldType("decimal");
		pesoCampo.setDecimals(2);
		pesoCampo.setPersistible(true);
		pesoCampo.setLabel("Peso");
		pesoCampo.setUuid(generarToken());
		pesoCampo.setComment("peso");
		pesoCampo.setAffects(null);
		pesoCampo.setFilter(null);
		pesoCampo.setEvents("*");
		pesoCampo.setOrigin(null);
		pesoCampo.setValue("");

		orden++;
		firmaCampo.setName("firma");
		firmaCampo.setFieldName("firma");
		firmaCampo.setCss("form-control");
		firmaCampo.setOrder(orden);
		firmaCampo.setComponentType("texto");
		firmaCampo.setReadOnly(false);
		firmaCampo.setHidden(false);
		firmaCampo.setRequired(false);
		firmaCampo.setShowInBasket(true);
		firmaCampo.setId(false);
		firmaCampo.setSearcheable(false);
		firmaCampo.setValidation(null);
		firmaCampo.setFormat(null);
		firmaCampo.setGroup("header");
		firmaCampo.setLength(150);
		firmaCampo.setDbFieldType("varchar");
		firmaCampo.setDecimals(0);
		firmaCampo.setPersistible(true);
		firmaCampo.setLabel("Firma");
		firmaCampo.setUuid(generarToken());
		firmaCampo.setComment("firma");
		firmaCampo.setAffects(null);
		firmaCampo.setFilter(null);
		firmaCampo.setEvents("*");
		firmaCampo.setOrigin(null);
		firmaCampo.setValue("");

		orden++;
		recetaCampo.setName("receta");
		recetaCampo.setFieldName("receta");
		recetaCampo.setCss("form-control");
		recetaCampo.setOrder(orden);
		recetaCampo.setComponentType("textoarea");
		recetaCampo.setReadOnly(false);
		recetaCampo.setHidden(false);
		recetaCampo.setRequired(false);
		recetaCampo.setShowInBasket(true);
		recetaCampo.setId(false);
		recetaCampo.setSearcheable(true);
		recetaCampo.setValidation(null);
		recetaCampo.setFormat(null);
		recetaCampo.setGroup("header");
		recetaCampo.setLength(500);
		recetaCampo.setDbFieldType("varchar");
		recetaCampo.setDecimals(0);
		recetaCampo.setPersistible(true);
		recetaCampo.setLabel("Receta General");
		recetaCampo.setUuid(generarToken());
		recetaCampo.setComment("receta");
		recetaCampo.setAffects(null);
		recetaCampo.setFilter(null);
		recetaCampo.setEvents("*");
		recetaCampo.setOrigin(null);
		recetaCampo.setValue("");
		
		orden++;
		uuidCampo.setName("uuid");
		uuidCampo.setFieldName("uuid");
		uuidCampo.setCss("form-control");
		uuidCampo.setOrder(orden);
		uuidCampo.setComponentType("texto");
		uuidCampo.setReadOnly(true);
		uuidCampo.setHidden(true);
		uuidCampo.setRequired(false);
		uuidCampo.setShowInBasket(false);
		uuidCampo.setId(true);
		uuidCampo.setSearcheable(true);
		uuidCampo.setValidation(null);
		uuidCampo.setFormat(null);
		uuidCampo.setGroup("header");
		uuidCampo.setLength(60);
		uuidCampo.setDbFieldType("varchar");
		uuidCampo.setDecimals(0);
		uuidCampo.setPersistible(true);
		uuidCampo.setLabel("Uuid");
		uuidCampo.setUuid(generarToken());
		uuidCampo.setComment("uuid");
		uuidCampo.setAffects(null);
		uuidCampo.setFilter(null);
		uuidCampo.setEvents("*");
		uuidCampo.setOrigin(null);
		uuidCampo.setValue("${default::uuid}");

		orden++;
		uuidpCampo.setName("uuidp");
		uuidpCampo.setFieldName("uuidp");
		uuidpCampo.setCss("form-control");
		uuidpCampo.setOrder(orden);
		uuidpCampo.setComponentType("texto");
		uuidpCampo.setReadOnly(true);
		uuidpCampo.setHidden(true);
		uuidpCampo.setRequired(false);
		uuidpCampo.setShowInBasket(false);
		uuidpCampo.setId(false);
		uuidpCampo.setSearcheable(true);
		uuidpCampo.setValidation(null);
		uuidpCampo.setFormat(null);
		uuidpCampo.setGroup("header");
		uuidpCampo.setLength(60);
		uuidpCampo.setDbFieldType("varchar");
		uuidpCampo.setDecimals(0);
		uuidpCampo.setPersistible(true);
		uuidpCampo.setLabel("Uuidp");
		uuidpCampo.setUuid(generarToken());
		uuidpCampo.setComment("uuidp");
		uuidpCampo.setAffects(null);
		uuidpCampo.setFilter(null);
		uuidpCampo.setEvents("*");
		uuidpCampo.setOrigin(null);
		uuidpCampo.setValue("");

		orden++;
		uuideCampo.setName("uuide");
		uuideCampo.setFieldName("uuide");
		uuideCampo.setCss("form-control");
		uuideCampo.setOrder(orden);
		uuideCampo.setComponentType("texto");
		uuideCampo.setReadOnly(true);
		uuideCampo.setHidden(true);
		uuideCampo.setRequired(false);
		uuideCampo.setShowInBasket(false);
		uuideCampo.setId(false);
		uuideCampo.setSearcheable(false);
		uuideCampo.setValidation(null);
		uuideCampo.setFormat(null);
		uuideCampo.setGroup("header");
		uuideCampo.setLength(60);
		uuideCampo.setDbFieldType("varchar");
		uuideCampo.setDecimals(0);
		uuideCampo.setPersistible(true);
		uuideCampo.setLabel("Uuide");
		uuideCampo.setUuid(generarToken());
		uuideCampo.setComment("uuide");
		uuideCampo.setAffects(null);
		uuideCampo.setFilter(null);
		uuideCampo.setEvents("*");
		uuideCampo.setOrigin(null);
		uuideCampo.setValue("");

		// Agregar todos los campos *
		campos.add(nombreCampo);
		campos.add(fechaCampo);
		campos.add(edadCampo);
		campos.add(pesoCampo);
		campos.add(firmaCampo);
		campos.add(recetaCampo);
		campos.add(uuidCampo);
		campos.add(uuidpCampo);
		campos.add(uuideCampo);
		forma.setModel(campos);
		forma.setMethods(metodos);

		try {
			generador.put(filePath, forma);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}