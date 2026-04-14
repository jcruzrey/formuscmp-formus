/**
 * 
 */
package com.mio.formas.generador;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class Dental_caracteristica extends GenerateCode{

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
			buttonGuardar.setCommandName("guardarpad");
			buttonGuardar.setComment("Boton guardar padecimiento");
			buttonGuardar.setComponentType("guardarjs");
			buttonGuardar.setCss("btn btn-primary");
			buttonGuardar.setEvents("padecimiento,guardarpad");
			buttonGuardar.setInstruction("Formulario guardado correctamente");
			buttonGuardar.setLabel("Guardar padecimiento");
			buttonGuardar.setModule(modulo);
			buttonGuardar.setName("guardar");
			buttonGuardar.setOrder(1);
			buttonGuardar.setResourceName(recurso);
			buttonGuardar.setResourceType("form");
			buttonGuardar.setUuid(generarToken());
			buttonGuardar.setVersion(version);
			metodos.add(buttonGuardar);
			
			Button buttonGuardarTrat = new Button();
			buttonGuardarTrat.setCommandName("guardartrat");
			buttonGuardarTrat.setComment("Boton guardar tratamiento");
			buttonGuardarTrat.setComponentType("guardarjs");
			buttonGuardarTrat.setCss("btn btn-primary");
			buttonGuardarTrat.setEvents("tratamiento,guardartrat");
			buttonGuardarTrat.setInstruction("Formulario guardado correctamente");
			buttonGuardarTrat.setLabel("Guardar tratamiento");
			buttonGuardarTrat.setModule(modulo);
			buttonGuardarTrat.setName("guardartrat");
			buttonGuardarTrat.setOrder(1);
			buttonGuardarTrat.setResourceName(recurso);
			buttonGuardarTrat.setResourceType("form");
			buttonGuardarTrat.setUuid(generarToken());
			buttonGuardarTrat.setVersion(version);
			metodos.add(buttonGuardarTrat);
			
			Button buttonGuardarCita = new Button();
			buttonGuardarCita.setCommandName("guardarcita");
			buttonGuardarCita.setComment("Boton guardar tratamiento");
			buttonGuardarCita.setComponentType("guardarjs");
			buttonGuardarCita.setCss("btn btn-primary");
			buttonGuardarCita.setEvents("cita,guardarcita");
			buttonGuardarCita.setInstruction("Formulario guardado correctamente");
			buttonGuardarCita.setLabel("Guardar cita");
			buttonGuardarCita.setModule(modulo);
			buttonGuardarCita.setName("guardarcita");
			buttonGuardarCita.setOrder(1);
			buttonGuardarCita.setResourceName(recurso);
			buttonGuardarCita.setResourceType("form");
			buttonGuardarCita.setUuid(generarToken());
			buttonGuardarCita.setVersion(version);
			metodos.add(buttonGuardarCita);
			
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
		String formulario = "caracteristica"; //nombre del formulario *
		String version = "1.0"; //version
		String idioma = "es_MX"; //version
		
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve(modulo + "_" + formulario + ".json").normalize();
		int orden = 1;
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes(idioma, modulo, formulario, version, 1);

		Map<String, List<Field>> decorators = new HashMap<String,List<Field>>();
		List<Field> decoradoresTratamiento = new ArrayList<Field>();
		
		//Definir todos los campos *
		Field codigocitaCampo = new Field();
		Field statusCampo = new Field();
		Field fyhCampo = new Field();
		Field fyhfCampo = new Field();
		Field dienteCampo = new Field();
		Field obsCampo = new Field();
		Field recetaCampo = new Field();
		Field padecimientoCampo = new Field();
		Field tratamientoCampo = new Field();
		Field tratamientoDecCampo = new Field();
		//Field figuraCampo = new Field();
		Field uuidCampo = new Field();
		Field uuidpCampo = new Field();
		Field uuideCampo = new Field();
		Field uuidrCampo = new Field();
		Field consultaCampo = new Field();
		Field consultaTCampo = new Field();
		Field pacienteCodigo = new Field();
		
		Resource forma = new Resource();

		//Ajustar *
		forma.setPrefix("DCA");
		forma.setCommandName("guardar");
		forma.setName("caracteristica");
		forma.setView("vista");
		forma.setTitle("Caracteristica de diente");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule(modulo);
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("caracteristica");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion de la caracteristica del diente");
		forma.setUuid(generarToken());
		forma.setComment("Formulario para registrar las caracteristicas");
		forma.setOrigin("ui::case");
		forma.setDestination("db::mysql");
		forma.setUuid(generarToken());
		forma.setPersistible(true);
		forma.setValidate(true);
		forma.setLastModificationDate(new java.util.Date().getTime());

		codigocitaCampo.setName("cita");
		codigocitaCampo.setFieldName("cita");
		codigocitaCampo.setCss("form-control");
		codigocitaCampo.setOrder(orden);
		codigocitaCampo.setComponentType("texto");
		codigocitaCampo.setReadOnly(true);
		codigocitaCampo.setHidden(false);
		codigocitaCampo.setRequired(false);
		codigocitaCampo.setShowInBasket(true);
		codigocitaCampo.setId(false);
		codigocitaCampo.setSearcheable(true);
		codigocitaCampo.setValidation(null);
		codigocitaCampo.setFormat(null);
		codigocitaCampo.setGroup("header");
		codigocitaCampo.setLength(60);
		codigocitaCampo.setDbFieldType("varchar");
		codigocitaCampo.setDecimals(0);
		codigocitaCampo.setPersistible(true);
		codigocitaCampo.setLabel("Codigo Cita");
		codigocitaCampo.setUuid(generarToken());
		codigocitaCampo.setComment("codigocita");
		codigocitaCampo.setAffects(null);
		codigocitaCampo.setFilter(null);
		codigocitaCampo.setEvents("*");
		codigocitaCampo.setOrigin(null);
		codigocitaCampo.setValue("");
		
		orden++;
		statusCampo.setName("status");
		statusCampo.setFieldName("status");
		statusCampo.setCss("form-control");
		statusCampo.setOrder(orden);
		statusCampo.setComponentType("lista");
		statusCampo.setReadOnly(true);
		statusCampo.setHidden(false);
		statusCampo.setRequired(false);
		statusCampo.setShowInBasket(true);
		statusCampo.setId(false);
		statusCampo.setSearcheable(true);
		statusCampo.setValidation(null);
		statusCampo.setFormat(null);
		statusCampo.setGroup("header");
		statusCampo.setLength(20);
		statusCampo.setDbFieldType("varchar");
		statusCampo.setDecimals(0);
		statusCampo.setPersistible(true);
		statusCampo.setLabel("Status");
		statusCampo.setUuid(generarToken());
		statusCampo.setComment("registrar,cancelar,consultar");
		statusCampo.setAffects(null);
		statusCampo.setFilter(null);
		statusCampo.setEvents("*");
		statusCampo.setOrigin("{\"origin\":\"recurso\",\"resource\":\"inlinevalues\",\"fields\":[{\"name\":\"Padecimiento,Agendada,Tratamiento,Cancelada\"}]}");
		statusCampo.setValue("");
		
		orden++;
		fyhCampo.setName("fyhora");
		fyhCampo.setFieldName("fyhora");
		fyhCampo.setCss("form-control");
		fyhCampo.setOrder(orden);
		fyhCampo.setComponentType("texto");
		fyhCampo.setReadOnly(true);
		fyhCampo.setHidden(false);
		fyhCampo.setRequired(true);
		fyhCampo.setShowInBasket(true);
		fyhCampo.setId(false);
		fyhCampo.setSearcheable(true);
		fyhCampo.setValidation("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$");
		fyhCampo.setFormat(null);
		fyhCampo.setGroup("header");
		fyhCampo.setLength(0);
		fyhCampo.setDbFieldType("datetime");
		fyhCampo.setDecimals(0);
		fyhCampo.setPersistible(true);
		fyhCampo.setLabel("Fecha/Hora");
		fyhCampo.setUuid(generarToken());
		fyhCampo.setComment("Fecha/Hora");
		fyhCampo.setAffects(null);
		fyhCampo.setFilter(null);
		fyhCampo.setEvents("*");
		fyhCampo.setOrigin(null);
		fyhCampo.setValue("${default::fechayHoraCorto}");
		
		orden++;
		fyhfCampo.setName("fyhoraf");
		fyhfCampo.setFieldName("fyhoraf");
		fyhfCampo.setCss("form-control");
		fyhfCampo.setOrder(orden);
		fyhfCampo.setComponentType("texto");
		fyhfCampo.setReadOnly(true);
		fyhfCampo.setHidden(false);
		fyhfCampo.setRequired(false);
		fyhfCampo.setShowInBasket(false);
		fyhfCampo.setId(false);
		fyhfCampo.setSearcheable(false);
		fyhfCampo.setValidation(null);
		fyhfCampo.setFormat(null);
		fyhfCampo.setGroup("header");
		fyhfCampo.setLength(0);
		fyhfCampo.setDbFieldType("datetime");
		fyhfCampo.setDecimals(0);
		fyhfCampo.setPersistible(true);
		fyhfCampo.setLabel("Fecha/Hora final");
		fyhfCampo.setUuid(generarToken());
		fyhfCampo.setComment("Fecha/Hora Fin");
		fyhfCampo.setAffects(null);
		fyhfCampo.setFilter(null);
		fyhfCampo.setEvents("*");
		fyhfCampo.setOrigin(null);
		fyhfCampo.setValue(null);
		

		orden++;
		dienteCampo.setName("diente");
		dienteCampo.setFieldName("diente");
		dienteCampo.setCss("form-select");
		dienteCampo.setOrder(orden);
		dienteCampo.setComponentType("texto");
		dienteCampo.setReadOnly(false);
		dienteCampo.setHidden(false);
		dienteCampo.setRequired(true);
		dienteCampo.setShowInBasket(true);
		dienteCampo.setId(false);
		dienteCampo.setSearcheable(true);
		dienteCampo.setValidation(null);
		dienteCampo.setFormat(null);
		dienteCampo.setGroup("header");
		dienteCampo.setLength(0);
		dienteCampo.setDbFieldType("int");
		dienteCampo.setDecimals(0);
		dienteCampo.setPersistible(true);
		dienteCampo.setLabel("Numero de diente");
		dienteCampo.setUuid(generarToken());
		dienteCampo.setComment("Numero de diente");
		dienteCampo.setAffects(null);
		dienteCampo.setFilter(null);
		dienteCampo.setEvents("*");
		//dienteCampo.setOrigin("{\"origin\":\"recurso\",\"resource\":\"inlinevalues\",\"fields\":[{\"name\":\"" + Dientes(1,100) + "\"}]}");
		dienteCampo.setOrigin(null);
		dienteCampo.setValue("");
		
		orden++;
		uuidpCampo.setName("uuidp");
		uuidpCampo.setFieldName("uuidp");
		uuidpCampo.setCss("form-select");
		uuidpCampo.setOrder(orden);
		uuidpCampo.setComponentType("texto");
		uuidpCampo.setReadOnly(false);
		uuidpCampo.setHidden(true);
		uuidpCampo.setRequired(false);
		uuidpCampo.setShowInBasket(true);
		uuidpCampo.setId(false);
		uuidpCampo.setSearcheable(true);
		uuidpCampo.setValidation(null);
		uuidpCampo.setFormat(null);
		uuidpCampo.setGroup("header");
		uuidpCampo.setLength(60);
		uuidpCampo.setDbFieldType("varchar");
		uuidpCampo.setDecimals(0);
		uuidpCampo.setPersistible(true);
		uuidpCampo.setLabel("Paciente");
		uuidpCampo.setUuid(generarToken());
		uuidpCampo.setComment("Uuid paciente");
		uuidpCampo.setAffects(null);
		uuidpCampo.setFilter(null);
		uuidpCampo.setEvents("*");
		//uuidpCampo.setOrigin("{\"origin\":\"tabla\",\"resource\":\"diente\",\"fields\":[{\"name\":\"numero\", \"filter\":\"\"},{\"name\":\"uuid\", \"filter\":\"\"}]}");
		uuidpCampo.setOrigin(null);
		uuidpCampo.setValue("");

		orden++;
		obsCampo.setName("obs");
		obsCampo.setFieldName("obs");
		obsCampo.setCss("form-control");
		obsCampo.setOrder(orden);
		obsCampo.setComponentType("textoarea");
		obsCampo.setReadOnly(false);
		obsCampo.setHidden(false);
		obsCampo.setRequired(false);
		obsCampo.setShowInBasket(true);
		obsCampo.setId(false);
		obsCampo.setSearcheable(true);
		obsCampo.setValidation(null);
		obsCampo.setFormat(null);
		obsCampo.setGroup("header");
		obsCampo.setLength(200);
		obsCampo.setDbFieldType("varchar");
		obsCampo.setDecimals(0);
		obsCampo.setPersistible(true);
		obsCampo.setLabel("Observaciones");
		obsCampo.setUuid(generarToken());
		obsCampo.setComment("obs");
		obsCampo.setAffects(null);
		obsCampo.setFilter(null);
		obsCampo.setEvents("*");
		obsCampo.setOrigin(null);
		obsCampo.setValue("");
		
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
		recetaCampo.setLabel("Receta");
		recetaCampo.setUuid(generarToken());
		recetaCampo.setComment("receta");
		recetaCampo.setAffects(null);
		recetaCampo.setFilter(null);
		recetaCampo.setEvents("*");
		recetaCampo.setOrigin(null);
		recetaCampo.setValue("");

		orden++;
		padecimientoCampo.setName("padecimiento");
		padecimientoCampo.setFieldName("padecimiento");
		padecimientoCampo.setCss("form-control");
		padecimientoCampo.setOrder(orden);
		padecimientoCampo.setComponentType("padecimientos");
		padecimientoCampo.setReadOnly(false);
		padecimientoCampo.setHidden(false);
		padecimientoCampo.setRequired(true);
		padecimientoCampo.setShowInBasket(true);
		padecimientoCampo.setId(false);
		padecimientoCampo.setSearcheable(true);
		padecimientoCampo.setValidation(null);
		padecimientoCampo.setFormat(null);
		padecimientoCampo.setGroup("header");
		padecimientoCampo.setLength(60);
		padecimientoCampo.setDbFieldType("varchar");
		padecimientoCampo.setDecimals(0);
		padecimientoCampo.setPersistible(true);
		padecimientoCampo.setLabel("Padecimiento");
		padecimientoCampo.setUuid(generarToken());
		padecimientoCampo.setComment("Padecimiento");
		padecimientoCampo.setAffects(null);
		padecimientoCampo.setFilter(null);
		padecimientoCampo.setEvents("*");
		padecimientoCampo.setOrigin("{\"origin\":\"tabla\",\"resource\":\"padecimiento\",\"fields\":[{\"name\":\"nombre\", \"filter\":\"\"},{\"name\":\"uuid\", \"filter\":\"\"}]}");
		//padecimientoCampo.setOrigin(null);
		padecimientoCampo.setValue("");
		
		orden++;
		tratamientoCampo.setName("tratamiento");
		tratamientoCampo.setFieldName("tratamiento");
		tratamientoCampo.setCss("form-control");
		tratamientoCampo.setOrder(orden);
		tratamientoCampo.setComponentType("tratamientos");
		tratamientoCampo.setReadOnly(false);
		tratamientoCampo.setHidden(false);
		tratamientoCampo.setRequired(false);
		tratamientoCampo.setShowInBasket(true);
		tratamientoCampo.setId(false);
		tratamientoCampo.setSearcheable(true);
		tratamientoCampo.setValidation(null);
		tratamientoCampo.setFormat(null);
		tratamientoCampo.setGroup("header");
		tratamientoCampo.setLength(60);
		tratamientoCampo.setDbFieldType("varchar");
		tratamientoCampo.setDecimals(0);
		tratamientoCampo.setPersistible(true);
		tratamientoCampo.setLabel("Tratamiento");
		tratamientoCampo.setUuid(generarToken());
		tratamientoCampo.setComment("Tratamiento");
		tratamientoCampo.setAffects(null);
		tratamientoCampo.setFilter(null);
		tratamientoCampo.setEvents("*");
		tratamientoCampo.setOrigin("{\"origin\":\"tabla\",\"resource\":\"tratamiento\",\"fields\":[{\"name\":\"nombre\", \"filter\":\"\"},{\"name\":\"uuid\", \"filter\":\"\"}]}");
		tratamientoCampo.setValue("");
		
		tratamientoDecCampo.setName("tratamiento");
		tratamientoDecCampo.setFieldName("tratamiento");
		tratamientoDecCampo.setCss("form-control");
		tratamientoDecCampo.setOrder(orden);
		tratamientoDecCampo.setComponentType("tratamientos");
		tratamientoDecCampo.setReadOnly(false);
		tratamientoDecCampo.setHidden(false);
		tratamientoDecCampo.setRequired(true);
		tratamientoDecCampo.setShowInBasket(true);
		tratamientoDecCampo.setId(false);
		tratamientoDecCampo.setSearcheable(true);
		tratamientoDecCampo.setValidation(null);
		tratamientoDecCampo.setFormat(null);
		tratamientoDecCampo.setGroup("header");
		tratamientoDecCampo.setLength(200);
		tratamientoDecCampo.setDbFieldType("varchar");
		tratamientoDecCampo.setDecimals(0);
		tratamientoDecCampo.setPersistible(true);
		tratamientoDecCampo.setLabel("Tratamiento");
		tratamientoDecCampo.setUuid(generarToken());
		tratamientoDecCampo.setComment("Tratamiento");
		tratamientoDecCampo.setAffects(null);
		tratamientoDecCampo.setFilter(null);
		tratamientoDecCampo.setEvents("*");
		tratamientoDecCampo.setOrigin("{\"origin\":\"tabla\",\"resource\":\"tratamiento\",\"fields\":[{\"name\":\"nombre\", \"filter\":\"\"},{\"name\":\"uuid\", \"filter\":\"\"}]}");
		tratamientoDecCampo.setValue("");
		
		decoradoresTratamiento.add(tratamientoDecCampo);
		forma.getDecorators().put("tratamiento", decoradoresTratamiento);
		
		orden++;		
		uuidCampo.setName("uuid");
		uuidCampo.setFieldName("uuid");
		uuidCampo.setCss("form-control");
		uuidCampo.setOrder(orden);
		uuidCampo.setComponentType("texto");
		uuidCampo.setReadOnly(true);
		uuidCampo.setHidden(true);
		uuidCampo.setRequired(true);
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
		uuideCampo.setSearcheable(true);
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
		
		orden++;
		uuidrCampo.setName("uuidr");
		uuidrCampo.setFieldName("uuidr");
		uuidrCampo.setCss("form-control");
		uuidrCampo.setOrder(orden);
		uuidrCampo.setComponentType("texto");
		uuidrCampo.setReadOnly(false);
		uuidrCampo.setHidden(true);
		uuidrCampo.setRequired(false);
		uuidrCampo.setShowInBasket(false);
		uuidrCampo.setId(false);
		uuidrCampo.setSearcheable(true);
		uuidrCampo.setValidation(null);
		uuidrCampo.setFormat(null);
		uuidrCampo.setGroup("header");
		uuidrCampo.setLength(60);
		uuidrCampo.setDbFieldType("varchar");
		uuidrCampo.setDecimals(0);
		uuidrCampo.setPersistible(true);
		uuidrCampo.setLabel("Receta");
		uuidrCampo.setUuid(generarToken());
		uuidrCampo.setComment("uuidr de receta");
		uuidrCampo.setAffects(null);
		uuidrCampo.setFilter(null);
		uuidrCampo.setEvents("*");
		uuidrCampo.setOrigin(null);
		uuidrCampo.setValue("");
		
		orden++;
		consultaCampo.setName("consulta");
		consultaCampo.setFieldName("consulta");
		consultaCampo.setCss("form-control");
		consultaCampo.setOrder(orden);
		consultaCampo.setComponentType("texto");
		consultaCampo.setReadOnly(false);
		consultaCampo.setHidden(true);
		consultaCampo.setRequired(false);
		consultaCampo.setShowInBasket(true);
		consultaCampo.setId(false);
		consultaCampo.setSearcheable(true);
		consultaCampo.setValidation(null);
		consultaCampo.setFormat(null);
		consultaCampo.setGroup("header");
		consultaCampo.setLength(60);
		consultaCampo.setDbFieldType("varchar");
		consultaCampo.setDecimals(0);
		consultaCampo.setPersistible(true);
		consultaCampo.setLabel("Consulta Padecimiento");
		consultaCampo.setUuid(generarToken());
		consultaCampo.setComment("Consulta");
		consultaCampo.setAffects(null);
		consultaCampo.setFilter(null);
		consultaCampo.setEvents("*");
		consultaCampo.setOrigin(null);
		consultaCampo.setValue("");
		
		orden++;
		consultaTCampo.setName("consultat");
		consultaTCampo.setFieldName("consultat");
		consultaTCampo.setCss("form-control");
		consultaTCampo.setOrder(orden);
		consultaTCampo.setComponentType("texto");
		consultaTCampo.setReadOnly(false);
		consultaTCampo.setHidden(true);
		consultaTCampo.setRequired(false);
		consultaTCampo.setShowInBasket(true);
		consultaTCampo.setId(false);
		consultaTCampo.setSearcheable(true);
		consultaTCampo.setValidation(null);
		consultaTCampo.setFormat(null);
		consultaTCampo.setGroup("header");
		consultaTCampo.setLength(60);
		consultaTCampo.setDbFieldType("varchar");
		consultaTCampo.setDecimals(0);
		consultaTCampo.setPersistible(true);
		consultaTCampo.setLabel("Consulta Tratamiento");
		consultaTCampo.setUuid(generarToken());
		consultaTCampo.setComment("Consulta Tratamiento");
		consultaTCampo.setAffects(null);
		consultaTCampo.setFilter(null);
		consultaTCampo.setEvents("*");
		consultaTCampo.setOrigin(null);
		consultaTCampo.setValue("");

		orden++;
		pacienteCodigo.setName("paciente");
		pacienteCodigo.setFieldName("paciente");
		pacienteCodigo.setCss("form-control");
		pacienteCodigo.setOrder(orden);
		pacienteCodigo.setComponentType("texto");
		pacienteCodigo.setReadOnly(false);
		pacienteCodigo.setHidden(false);
		pacienteCodigo.setRequired(false);
		pacienteCodigo.setShowInBasket(true);
		pacienteCodigo.setId(false);
		pacienteCodigo.setSearcheable(true);
		pacienteCodigo.setValidation(null);
		pacienteCodigo.setFormat(null);
		pacienteCodigo.setGroup("header");
		pacienteCodigo.setLength(60);
		pacienteCodigo.setDbFieldType("varchar");
		pacienteCodigo.setDecimals(0);
		pacienteCodigo.setPersistible(true);
		pacienteCodigo.setLabel("Paciente");
		pacienteCodigo.setUuid(generarToken());
		pacienteCodigo.setComment("Paciente");
		pacienteCodigo.setAffects(null);
		pacienteCodigo.setFilter(null);
		pacienteCodigo.setEvents("*");
		pacienteCodigo.setOrigin(null);
		pacienteCodigo.setValue("");
		
		
		//Agregar todos los campos *
		campos.add(codigocitaCampo);
		campos.add(statusCampo);
		campos.add(fyhCampo);
		campos.add(fyhfCampo);
		campos.add(dienteCampo);
		campos.add(obsCampo);
		campos.add(recetaCampo);
		campos.add(padecimientoCampo);
		campos.add(tratamientoCampo);
		//campos.add(figuraCampo);
		campos.add(uuidCampo);
		campos.add(uuidpCampo);
		campos.add(uuideCampo);
		campos.add(uuidrCampo);
		campos.add(consultaCampo);
		campos.add(consultaTCampo);
		campos.add(pacienteCodigo);
		
		
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