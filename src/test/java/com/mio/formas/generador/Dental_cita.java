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
public class Dental_cita extends GenerateCode{

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
		String formulario = "cita"; //nombre del formulario *
		String version = "1.0"; //version
		String idioma = "es_MX"; //version

		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve(modulo + "_" + formulario + ".json").normalize();
		int orden = 1;
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes(idioma, modulo, formulario, version, 1);

		//Definir todos los campos *
		Field fechayhoraCampo       = new Field();
		Field especialistaCampo    = new Field();
		Field sucursalCampo        = new Field();
		Field nuevoPacienteCampo   = new Field();
		Field pacienteCampo        = new Field();
		Field uuidCampo            = new Field();
		Field uuideCampo           = new Field();
		Field uuidpCampo           = new Field();



		Resource forma = new Resource();

		//Ajustar *
		forma.setPrefix("DCA");
		forma.setCommandName("guardar");
		forma.setName("cita");
		forma.setView("cita");
		forma.setTitle("Cita");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule(modulo);
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("cita");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion de la cita del cliente");
		forma.setUuid(generarToken());
		forma.setComment("Formulario para registrar las citas");
		forma.setOrigin("ui::case");
		forma.setDestination("db::mysql");
		forma.setUuid(generarToken());
		forma.setPersistible(true);
		forma.setValidate(true);
		forma.setLastModificationDate(new java.util.Date().getTime());

		orden++;
		fechayhoraCampo.setName("fechayhora");
		fechayhoraCampo.setFieldName("fechayhora");
		fechayhoraCampo.setCss("form-control");
		fechayhoraCampo.setOrder(orden);
		fechayhoraCampo.setComponentType("texto");
		fechayhoraCampo.setReadOnly(false);
		fechayhoraCampo.setHidden(false);
		fechayhoraCampo.setRequired(true);
		fechayhoraCampo.setShowInBasket(true);
		fechayhoraCampo.setId(true);
		fechayhoraCampo.setSearcheable(true);
		fechayhoraCampo.setValidation(null);
		fechayhoraCampo.setFormat(null);
		fechayhoraCampo.setGroup("header");
		fechayhoraCampo.setLength(200);
		fechayhoraCampo.setDbFieldType("datetime");
		fechayhoraCampo.setDecimals(0);
		fechayhoraCampo.setPersistible(true);
		fechayhoraCampo.setLabel("Fecha/Hora de la cita");
		fechayhoraCampo.setUuid(generarToken());
		fechayhoraCampo.setComment("fechayhora");
		fechayhoraCampo.setAffects(null);
		fechayhoraCampo.setFilter(null);
		fechayhoraCampo.setEvents("*");
		fechayhoraCampo.setOrigin(null);
		fechayhoraCampo.setValue("");

		orden++;
		especialistaCampo.setName("especialista");
		especialistaCampo.setFieldName("especialista");
		especialistaCampo.setCss("form-control");
		especialistaCampo.setOrder(orden);
		especialistaCampo.setComponentType("texto");
		especialistaCampo.setReadOnly(false);
		especialistaCampo.setHidden(false);
		especialistaCampo.setRequired(true);
		especialistaCampo.setShowInBasket(true);
		especialistaCampo.setId(true);
		especialistaCampo.setSearcheable(true);
		especialistaCampo.setValidation(null);
		especialistaCampo.setFormat(null);
		especialistaCampo.setGroup("header");
		especialistaCampo.setLength(200);
		especialistaCampo.setDbFieldType("varchar");
		especialistaCampo.setDecimals(0);
		especialistaCampo.setPersistible(true);
		especialistaCampo.setLabel("Especialista");
		especialistaCampo.setUuid(generarToken());
		especialistaCampo.setComment("especialista");
		especialistaCampo.setAffects(null);
		especialistaCampo.setFilter(null);
		especialistaCampo.setEvents("*");
		especialistaCampo.setOrigin(null);
		especialistaCampo.setValue("");

		orden++;
		sucursalCampo.setName("sucursal");
		sucursalCampo.setFieldName("sucursal");
		sucursalCampo.setCss("form-control");
		sucursalCampo.setOrder(orden);
		sucursalCampo.setComponentType("texto");
		sucursalCampo.setReadOnly(false);
		sucursalCampo.setHidden(false);
		sucursalCampo.setRequired(true);
		sucursalCampo.setShowInBasket(true);
		sucursalCampo.setId(true);
		sucursalCampo.setSearcheable(true);
		sucursalCampo.setValidation(null);
		sucursalCampo.setFormat(null);
		sucursalCampo.setGroup("header");
		sucursalCampo.setLength(200);
		sucursalCampo.setDbFieldType("varchar");
		sucursalCampo.setDecimals(0);
		sucursalCampo.setPersistible(true);
		sucursalCampo.setLabel("Sucursal");
		sucursalCampo.setUuid(generarToken());
		sucursalCampo.setComment("sucursal");
		sucursalCampo.setAffects(null);
		sucursalCampo.setFilter(null);
		sucursalCampo.setEvents("*");
		sucursalCampo.setOrigin(null);
		sucursalCampo.setValue("");

		orden++;
		nuevoPacienteCampo.setName("nuevopaciente");
		nuevoPacienteCampo.setFieldName("nuevopaciente");
		nuevoPacienteCampo.setCss("form-control");
		nuevoPacienteCampo.setOrder(orden);
		nuevoPacienteCampo.setComponentType("texto");
		nuevoPacienteCampo.setReadOnly(false);
		nuevoPacienteCampo.setHidden(false);
		nuevoPacienteCampo.setRequired(true);
		nuevoPacienteCampo.setShowInBasket(true);
		nuevoPacienteCampo.setId(true);
		nuevoPacienteCampo.setSearcheable(true);
		nuevoPacienteCampo.setValidation(null);
		nuevoPacienteCampo.setFormat(null);
		nuevoPacienteCampo.setGroup("header");
		nuevoPacienteCampo.setLength(100);
		nuevoPacienteCampo.setDbFieldType("varchar");
		nuevoPacienteCampo.setDecimals(0);
		nuevoPacienteCampo.setPersistible(true);
		nuevoPacienteCampo.setLabel("Nuevo Paciente");
		nuevoPacienteCampo.setUuid(generarToken());
		nuevoPacienteCampo.setComment("nuevopaciente");
		nuevoPacienteCampo.setAffects(null);
		nuevoPacienteCampo.setFilter(null);
		nuevoPacienteCampo.setEvents("*");
		nuevoPacienteCampo.setOrigin(null);
		nuevoPacienteCampo.setValue("");

		orden++;
		pacienteCampo.setName("paciente");
		pacienteCampo.setFieldName("paciente");
		pacienteCampo.setCss("form-control");
		pacienteCampo.setOrder(orden);
		pacienteCampo.setComponentType("texto");
		pacienteCampo.setReadOnly(false);
		pacienteCampo.setHidden(false);
		pacienteCampo.setRequired(true);
		pacienteCampo.setShowInBasket(true);
		pacienteCampo.setId(true);
		pacienteCampo.setSearcheable(true);
		pacienteCampo.setValidation(null);
		pacienteCampo.setFormat(null);
		pacienteCampo.setGroup("header");
		pacienteCampo.setLength(100);
		pacienteCampo.setDbFieldType("varchar");
		pacienteCampo.setDecimals(0);
		pacienteCampo.setPersistible(true);
		pacienteCampo.setLabel("Paciente");
		pacienteCampo.setUuid(generarToken());
		pacienteCampo.setComment("paciente");
		pacienteCampo.setAffects(null);
		pacienteCampo.setFilter(null);
		pacienteCampo.setEvents("*");
		pacienteCampo.setOrigin(null);
		pacienteCampo.setValue("");

		orden++;
		uuidCampo.setName("uuid");
		uuidCampo.setFieldName("uuid");
		uuidCampo.setCss("form-control");
		uuidCampo.setOrder(orden);
		uuidCampo.setComponentType("texto");
		uuidCampo.setReadOnly(false);
		uuidCampo.setHidden(false);
		uuidCampo.setRequired(true);
		uuidCampo.setShowInBasket(true);
		uuidCampo.setId(false);
		uuidCampo.setSearcheable(false);
		uuidCampo.setValidation(null);
		uuidCampo.setFormat(null);
		uuidCampo.setGroup("header");
		uuidCampo.setLength(60);
		uuidCampo.setDbFieldType("varchar");
		uuidCampo.setDecimals(0);
		uuidCampo.setPersistible(true);
		uuidCampo.setLabel("uuid");
		uuidCampo.setUuid(generarToken());
		uuidCampo.setComment("uuid");
		uuidCampo.setAffects(null);
		uuidCampo.setFilter(null);
		uuidCampo.setEvents("*");
		uuidCampo.setOrigin("${default::uuid}");
		uuidCampo.setValue("");

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
		uuideCampo.setLabel("uuide");
		uuideCampo.setUuid(generarToken());
		uuideCampo.setComment("uuide");
		uuideCampo.setAffects(null);
		uuideCampo.setFilter(null);
		uuideCampo.setEvents("*");
		uuideCampo.setOrigin(null);
		uuideCampo.setValue("");

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
		uuidpCampo.setLabel("uuidp");
		uuidpCampo.setUuid(generarToken());
		uuidpCampo.setComment("uuidp");
		uuidpCampo.setAffects(null);
		uuidpCampo.setFilter(null);
		uuidpCampo.setEvents("*");
		uuidpCampo.setOrigin(null);
		uuidpCampo.setValue("");

		//Agregar todos los campos *
		campos.add(fechayhoraCampo);
		campos.add(especialistaCampo);
		campos.add(sucursalCampo);
		campos.add(nuevoPacienteCampo);
		campos.add(pacienteCampo);
		campos.add(uuidCampo);
		campos.add(uuideCampo);
		campos.add(uuidpCampo);

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