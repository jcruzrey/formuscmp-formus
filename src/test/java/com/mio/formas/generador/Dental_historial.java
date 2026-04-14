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
public class Dental_historial extends GenerateCode{

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
		}else {
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
		String formulario = "historial"; //nombre del formulario *
		String version = "1.0"; //version
		String idioma = "es_MX"; //version
		
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve(modulo + "_" + formulario + ".json").normalize();
		int orden = 1;
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes(idioma, modulo, formulario, version, 1);

		//Definir todos los campos *
		Field codigoCampo       = new Field();
		Field preguntaCampo  = new Field();
		Field observacionCampo  = new Field();
		Field sinoCampo         = new Field();
		Field especifiqueCampo  = new Field();
		Field grupoCampo        = new Field();
		Field ordenCampo        = new Field();
		Field uuidCampo         = new Field();
		Field uuidpCampo        = new Field();
		Field uuideCampo        = new Field();
		
		Resource forma = new Resource();

		//Ajustar *
		forma.setPrefix("dca");
		forma.setCommandName("guardar");
		forma.setName("historial");
		forma.setView("historial");
		forma.setTitle("Historial");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule(modulo);
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("historial");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion del formulario");
		forma.setUuid(generarToken());
		forma.setComment("Formulario de historial");
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
		codigoCampo.setShowInBasket(false);
		codigoCampo.setId(false);
		codigoCampo.setSearcheable(false);
		codigoCampo.setValidation(null);
		codigoCampo.setFormat(null);
		codigoCampo.setGroup("header");
		codigoCampo.setLength(50);
		codigoCampo.setDbFieldType("varchar");
		codigoCampo.setDecimals(0);
		codigoCampo.setPersistible(true);
		codigoCampo.setLabel("Codigo (Auto)");
		codigoCampo.setUuid(generarToken());
		codigoCampo.setComment("codigo");
		codigoCampo.setAffects(null);
		codigoCampo.setFilter(null);
		codigoCampo.setEvents("*");
		codigoCampo.setOrigin(null);
		codigoCampo.setValue("");

		orden++;
		preguntaCampo.setName("pregunta");
		preguntaCampo.setFieldName("pregunta");
		preguntaCampo.setCss("form-control");
		preguntaCampo.setOrder(orden);
		preguntaCampo.setComponentType("texto");
		preguntaCampo.setReadOnly(false);
		preguntaCampo.setHidden(false);
		preguntaCampo.setRequired(false);
		preguntaCampo.setShowInBasket(false);
		preguntaCampo.setId(false);
		preguntaCampo.setSearcheable(false);
		preguntaCampo.setValidation(null);
		preguntaCampo.setFormat(null);
		preguntaCampo.setGroup("header");
		preguntaCampo.setLength(300);
		preguntaCampo.setDbFieldType("varchar");
		preguntaCampo.setDecimals(0);
		preguntaCampo.setPersistible(true);
		preguntaCampo.setLabel("Pregunta");
		preguntaCampo.setUuid(generarToken());
		preguntaCampo.setComment("Pregunta");
		preguntaCampo.setAffects(null);
		preguntaCampo.setFilter(null);
		preguntaCampo.setEvents("*");
		preguntaCampo.setOrigin(null);
		preguntaCampo.setValue("");
		
		orden++;
		observacionCampo.setName("observacion");
		observacionCampo.setFieldName("observacion");
		observacionCampo.setCss("form-control");
		observacionCampo.setOrder(orden);
		observacionCampo.setComponentType("texto");
		observacionCampo.setReadOnly(false);
		observacionCampo.setHidden(false);
		observacionCampo.setRequired(false);
		observacionCampo.setShowInBasket(false);
		observacionCampo.setId(false);
		observacionCampo.setSearcheable(false);
		observacionCampo.setValidation(null);
		observacionCampo.setFormat(null);
		observacionCampo.setGroup("header");
		observacionCampo.setLength(50);
		observacionCampo.setDbFieldType("varchar");
		observacionCampo.setDecimals(0);
		observacionCampo.setPersistible(true);
		observacionCampo.setLabel("Observacion");
		observacionCampo.setUuid(generarToken());
		observacionCampo.setComment("observacion");
		observacionCampo.setAffects(null);
		observacionCampo.setFilter(null);
		observacionCampo.setEvents("*");
		observacionCampo.setOrigin(null);
		observacionCampo.setValue("");

		orden++;
		sinoCampo.setName("sino");
		sinoCampo.setFieldName("sino");
		sinoCampo.setCss("form-check-input");
		sinoCampo.setOrder(orden);
		sinoCampo.setComponentType("botonradio");
		sinoCampo.setReadOnly(false);
		sinoCampo.setHidden(false);
		sinoCampo.setRequired(false);
		sinoCampo.setShowInBasket(false);
		sinoCampo.setId(false);
		sinoCampo.setSearcheable(false);
		sinoCampo.setValidation(null);
		sinoCampo.setFormat(null);
		sinoCampo.setGroup("header");
		sinoCampo.setLength(5);
		sinoCampo.setDbFieldType("varchar");
		sinoCampo.setDecimals(0);
		sinoCampo.setPersistible(true);
		sinoCampo.setLabel("Elija la respuesta");
		sinoCampo.setUuid(generarToken());
		sinoCampo.setComment("si_no");
		sinoCampo.setAffects(null);
		sinoCampo.setFilter(null);
		sinoCampo.setEvents("*");
		sinoCampo.setOrigin("{\"origin\":\"recurso\",\"resource\":\"inlinevalues\",\"fields\":[{\"name\":\"true,false\"}]}");
		sinoCampo.setValue("true");

		orden++;
		especifiqueCampo.setName("especifique");
		especifiqueCampo.setFieldName("especifique");
		especifiqueCampo.setCss("form-control");
		especifiqueCampo.setOrder(orden);
		especifiqueCampo.setComponentType("texto");
		especifiqueCampo.setReadOnly(false);
		especifiqueCampo.setHidden(false);
		especifiqueCampo.setRequired(false);
		especifiqueCampo.setShowInBasket(false);
		especifiqueCampo.setId(false);
		especifiqueCampo.setSearcheable(false);
		especifiqueCampo.setValidation(null);
		especifiqueCampo.setFormat(null);
		especifiqueCampo.setGroup("header");
		especifiqueCampo.setLength(100);
		especifiqueCampo.setDbFieldType("varchar");
		especifiqueCampo.setDecimals(0);
		especifiqueCampo.setPersistible(true);
		especifiqueCampo.setLabel("Especifique");
		especifiqueCampo.setUuid(generarToken());
		especifiqueCampo.setComment("especifique");
		especifiqueCampo.setAffects(null);
		especifiqueCampo.setFilter(null);
		especifiqueCampo.setEvents("*");
		especifiqueCampo.setOrigin(null);
		especifiqueCampo.setValue("");

		orden++;
		grupoCampo.setName("grupo");
		grupoCampo.setFieldName("grupo");
		grupoCampo.setCss("form-select");
		grupoCampo.setOrder(orden);
		grupoCampo.setComponentType("lista");
		grupoCampo.setReadOnly(false);
		grupoCampo.setHidden(false);
		grupoCampo.setRequired(false);
		grupoCampo.setShowInBasket(false);
		grupoCampo.setId(false);
		grupoCampo.setSearcheable(false);
		grupoCampo.setValidation(null);
		grupoCampo.setFormat(null);
		grupoCampo.setGroup("header");
		grupoCampo.setLength(5);
		grupoCampo.setDbFieldType("varchar");
		grupoCampo.setDecimals(0);
		grupoCampo.setPersistible(true);
		grupoCampo.setLabel("Grupo");
		grupoCampo.setUuid(generarToken());
		grupoCampo.setComment("grupo");
		grupoCampo.setAffects(null);
		grupoCampo.setFilter(null);
		grupoCampo.setEvents("*");
		grupoCampo.setOrigin("{\"origin\":\"recurso\",\"resource\":\"inlinevalues\",\"fields\":[{\"name\":\"Historial dental,Historial médico\"}]}");
		grupoCampo.setValue("Historial dental");

		orden++;
		ordenCampo.setName("orden");
		ordenCampo.setFieldName("orden");
		ordenCampo.setCss("form-control");
		ordenCampo.setOrder(orden);
		ordenCampo.setComponentType("texto");
		ordenCampo.setReadOnly(false);
		ordenCampo.setHidden(false);
		ordenCampo.setRequired(true);
		ordenCampo.setShowInBasket(false);
		ordenCampo.setId(false);
		ordenCampo.setSearcheable(false);
		ordenCampo.setValidation(null);
		ordenCampo.setFormat(null);
		ordenCampo.setGroup("header");
		ordenCampo.setLength(3);
		ordenCampo.setDbFieldType("int");
		ordenCampo.setDecimals(0);
		ordenCampo.setPersistible(true);
		ordenCampo.setLabel("Orden");
		ordenCampo.setUuid(generarToken());
		ordenCampo.setComment("Orden");
		ordenCampo.setAffects(null);
		ordenCampo.setFilter(null);
		ordenCampo.setEvents("*");
		ordenCampo.setOrigin(null);
		ordenCampo.setValue("");
		ordenCampo.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		ordenCampo.setSuggestion("Ingrese el orden de la pregunta");

		
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
		uuidCampo.setSearcheable(false);
		uuidCampo.setValidation(null);
		uuidCampo.setFormat(null);
		uuidCampo.setGroup("header");
		uuidCampo.setLength(60);
		uuidCampo.setDbFieldType("varchar");
		uuidCampo.setDecimals(0);
		uuidCampo.setPersistible(true);
		uuidCampo.setLabel("UUID");
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
		uuidpCampo.setReadOnly(false);
		uuidpCampo.setHidden(true);
		uuidpCampo.setRequired(false);
		uuidpCampo.setShowInBasket(false);
		uuidpCampo.setId(false);
		uuidpCampo.setSearcheable(false);
		uuidpCampo.setValidation(null);
		uuidpCampo.setFormat(null);
		uuidpCampo.setGroup("header");
		uuidpCampo.setLength(60);
		uuidpCampo.setDbFieldType("varchar");
		uuidpCampo.setDecimals(0);
		uuidpCampo.setPersistible(true);
		uuidpCampo.setLabel("UUIDP");
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
		uuideCampo.setReadOnly(false);
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
		uuideCampo.setLabel("UUIDE");
		uuideCampo.setUuid(generarToken());
		uuideCampo.setComment("uuide");
		uuideCampo.setAffects(null);
		uuideCampo.setFilter(null);
		uuideCampo.setEvents("*");
		uuideCampo.setOrigin(null);
		uuideCampo.setValue("");

		
		//Agregar todos los campos *
		campos.add(codigoCampo);
		campos.add(preguntaCampo);
		campos.add(observacionCampo);
		campos.add(sinoCampo);
		campos.add(especifiqueCampo);
		campos.add(ordenCampo);
		campos.add(grupoCampo);
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