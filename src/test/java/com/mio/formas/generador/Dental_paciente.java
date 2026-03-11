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
public class Dental_paciente extends GenerateCode{

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
	public void testNuevoCrmPaciente() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve("dental_paciente.json").normalize();
		int orden = 1;
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes("es_MX", "directorio", "paciente", "1.0", 1);

		Field codigoCampo = new Field();
		//Field pacienteCampo = new Field();
		// Field companyCampo = new Field();

		//Field companyCampo = new Field();
		Field faltaCampo = new Field();
		//Field uuidCampo = new Field();

		// Aqui declaramos las variables de campos - Paloma
		Field nombresCampo = new Field();
		Field curpCampo = new Field();
		Field rfcCampo = new Field();
		Field fnacimientoCampo = new Field();
		Field especialistaCampo = new Field();
		Field hioficinaCampo = new Field();
		Field hfoficinaCampo = new Field();
		Field celularCampo = new Field();
		Field telefonoCampo = new Field();
		Field correoeCampo = new Field();
		//Field fcontactoCampo = new Field();
		Field cemergenciaCampo = new Field();
		Field sexoCampo = new Field();
		Field tsangreCampo = new Field();
		Field tipoCampo = new Field();
		//Field codigoCampo = new Field();
		Field zhorariaCampo = new Field();
		//Field faltaCampo = new Field();
		Field statusCampo = new Field();
		Field idiomaCampo = new Field();
		Field prenombreCampo = new Field();
		Field profesionCampo = new Field();
		Field sucursalCampo = new Field();
		Field uuidCampo = new Field();
		Field uuipCampo = new Field();
		Field uuideCampo = new Field();
		Field aprentescoCampo = new Field();
		Field odontogramaCampo = new Field();
		Field periodontogramaCampo = new Field();
		
		Resource forma = new Resource();

		forma.setPrefix("PAC");
		forma.setCommandName("guardar");
		forma.setName("paciente");
		forma.setView("paciente");
		forma.setTitle("Paciente");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("dircto");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion del paciente");
		forma.setUuid(generarToken());
		forma.setComment("Formulario para crear un paciente");
		forma.setOrigin("ui::case");
		forma.setDestination("db::mysql");
		forma.setUuid(generarToken());
		forma.setPersistible(true);
		forma.setValidate(true);

		codigoCampo.setName("codigo");
		codigoCampo.setFieldName("codigo");
		codigoCampo.setCss("form-control");
		codigoCampo.setOrder(orden);
		codigoCampo.setComponentType("texto");
		codigoCampo.setReadOnly(true);
		codigoCampo.setHidden(false);
		codigoCampo.setRequired(false);
		codigoCampo.setShowInBasket(true);
		codigoCampo.setId(true);
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
		codigoCampo.setComment("Campo codigo");
		codigoCampo.setAffects(null);
		codigoCampo.setFilter(null);
		codigoCampo.setEvents("*");
		codigoCampo.setOrigin(null);
		codigoCampo.setValue("");

		
		// Pegar aqui el campo original de codigo
		orden++; //2
		nombresCampo.setName("nombre");
		nombresCampo.setFieldName("nombre");
		nombresCampo.setCss("form-control");
		nombresCampo.setOrder(orden);
		nombresCampo.setComponentType("texto");
		nombresCampo.setReadOnly(false);
		nombresCampo.setHidden(false);
		nombresCampo.setRequired(true);
		nombresCampo.setShowInBasket(true);
		nombresCampo.setId(false);
		nombresCampo.setSearcheable(true);
		nombresCampo.setValidation(null);
		nombresCampo.setFormat(null);
		nombresCampo.setGroup("header");
		nombresCampo.setLength(150);
		nombresCampo.setDbFieldType("varchar");
		nombresCampo.setDecimals(0);
		nombresCampo.setPersistible(true);
		nombresCampo.setLabel("Nombre completo");
		nombresCampo.setUuid(generarToken());
		nombresCampo.setComment("Campo de nombre");
		nombresCampo.setAffects(null);
		nombresCampo.setFilter(null);
		nombresCampo.setEvents("*");
		nombresCampo.setOrigin(null);
		nombresCampo.setValue("");

		//Aqui ponder todos los campos del excel - Paloma
		/*orden++;//3
		apaternoCampo.setName("apaterno");
		apaternoCampo.setFieldName("apaterno");
		apaternoCampo.setCss("form-control");
		apaternoCampo.setOrder(orden);
		apaternoCampo.setComponentType("texto");
		apaternoCampo.setReadOnly(false);
		apaternoCampo.setHidden(false);
		apaternoCampo.setRequired(true);
		apaternoCampo.setShowInBasket(true);
		apaternoCampo.setId(true);
		apaternoCampo.setSearcheable(true);
		apaternoCampo.setValidation(null);
		apaternoCampo.setFormat(null);
		apaternoCampo.setGroup("header");
		apaternoCampo.setLength(100);
		apaternoCampo.setDbFieldType("varchar");
		apaternoCampo.setDecimals(0);
		apaternoCampo.setPersistible(true);
		apaternoCampo.setLabel("Apellido Paterno");
		apaternoCampo.setUuid(generarToken());
		apaternoCampo.setComment("Campo apaterno");
		apaternoCampo.setAffects(null);
		apaternoCampo.setFilter(null);
		apaternoCampo.setEvents("*");
		apaternoCampo.setOrigin(null);
		apaternoCampo.setValue("");
		
		
		orden++;
		amaternoCampo.setName("amaterno");
		amaternoCampo.setFieldName("amaterno");
		amaternoCampo.setCss("form-control");
		amaternoCampo.setOrder(orden);
		amaternoCampo.setComponentType("texto");
		amaternoCampo.setReadOnly(false);
		amaternoCampo.setHidden(false);
		amaternoCampo.setRequired(true);
		amaternoCampo.setShowInBasket(true);
		amaternoCampo.setId(true);
		amaternoCampo.setSearcheable(true);
		amaternoCampo.setValidation(null);
		amaternoCampo.setFormat(null);
		amaternoCampo.setGroup("header");
		amaternoCampo.setLength(100);
		amaternoCampo.setDbFieldType("varchar");
		amaternoCampo.setDecimals(0);
		amaternoCampo.setPersistible(true);
		amaternoCampo.setLabel("Apellido Materno");
		amaternoCampo.setUuid(generarToken());
		amaternoCampo.setComment("Campo amaterno");
		amaternoCampo.setAffects(null);
		amaternoCampo.setFilter(null);
		amaternoCampo.setEvents("*");
		amaternoCampo.setOrigin(null);
		amaternoCampo.setValue("");*/
		
		
		orden++;
		curpCampo.setName("curp");
		curpCampo.setFieldName("curp");
		curpCampo.setCss("form-control");
		curpCampo.setOrder(orden);
		curpCampo.setComponentType("texto");
		curpCampo.setReadOnly(false);
		curpCampo.setHidden(false);
		curpCampo.setRequired(false);
		curpCampo.setShowInBasket(true);
		curpCampo.setId(false);
		curpCampo.setSearcheable(true);
		curpCampo.setValidation(null);
		curpCampo.setFormat(null);
		curpCampo.setGroup("header");
		curpCampo.setLength(30);
		curpCampo.setDbFieldType("varchar");
		curpCampo.setDecimals(0);
		curpCampo.setPersistible(true);
		curpCampo.setLabel("Curp");
		curpCampo.setUuid(generarToken());
		curpCampo.setComment("Curp");
		curpCampo.setAffects(null);
		curpCampo.setFilter(null);
		curpCampo.setEvents("*");
		curpCampo.setOrigin(null);
		curpCampo.setValue("");
		
		
		orden++;
		rfcCampo.setName("rfc");
		rfcCampo.setFieldName("rfc");
		rfcCampo.setCss("form-control");
		rfcCampo.setOrder(orden);
		rfcCampo.setComponentType("texto");
		rfcCampo.setReadOnly(false);
		rfcCampo.setHidden(false);
		rfcCampo.setRequired(false);
		rfcCampo.setShowInBasket(true);
		rfcCampo.setId(false);
		rfcCampo.setSearcheable(true);
		rfcCampo.setValidation(null);
		rfcCampo.setFormat(null);
		rfcCampo.setGroup("header");
		rfcCampo.setLength(30);
		rfcCampo.setDbFieldType("varchar");
		rfcCampo.setDecimals(0);
		rfcCampo.setPersistible(true);
		rfcCampo.setLabel("RFC");
		rfcCampo.setUuid(generarToken());
		rfcCampo.setComment("rfc");
		rfcCampo.setAffects(null);
		rfcCampo.setFilter(null);
		rfcCampo.setEvents("*");
		rfcCampo.setOrigin(null);
		rfcCampo.setValue("");
		
		
		orden++;
		fnacimientoCampo.setName("fnacimiento");
		fnacimientoCampo.setFieldName("fnacimiento");
		fnacimientoCampo.setCss("form-control");
		fnacimientoCampo.setOrder(orden);
		fnacimientoCampo.setComponentType("fecha");
		fnacimientoCampo.setReadOnly(false);
		fnacimientoCampo.setHidden(false);
		fnacimientoCampo.setRequired(false);
		fnacimientoCampo.setShowInBasket(true);
		fnacimientoCampo.setId(false);
		fnacimientoCampo.setSearcheable(true);
		fnacimientoCampo.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fnacimientoCampo.setFormat(null);
		fnacimientoCampo.setGroup("header");
		fnacimientoCampo.setLength(10);
		fnacimientoCampo.setDbFieldType("date");
		fnacimientoCampo.setDecimals(0);
		fnacimientoCampo.setPersistible(true);
		fnacimientoCampo.setLabel("Fecha De Nacimiento (aaaa-mm-dd)");
		fnacimientoCampo.setUuid(generarToken());
		fnacimientoCampo.setComment("fnacimiento");
		fnacimientoCampo.setAffects(null);
		fnacimientoCampo.setFilter(null);
		fnacimientoCampo.setEvents("*");
		fnacimientoCampo.setOrigin(null);
		fnacimientoCampo.setValue("${default::todayShort}");
		
		
		orden++;
		especialistaCampo.setName("especialidad");
		especialistaCampo.setFieldName("especialidad");
		especialistaCampo.setCss("form-control");
		especialistaCampo.setOrder(orden);
		especialistaCampo.setComponentType("texto");
		especialistaCampo.setReadOnly(false);
		especialistaCampo.setHidden(false);
		especialistaCampo.setRequired(false);
		especialistaCampo.setShowInBasket(true);
		especialistaCampo.setId(false);
		especialistaCampo.setSearcheable(true);
		especialistaCampo.setValidation(null);
		especialistaCampo.setFormat(null);
		especialistaCampo.setGroup("header");
		especialistaCampo.setLength(25);
		especialistaCampo.setDbFieldType("varchar");
		especialistaCampo.setDecimals(0);
		especialistaCampo.setPersistible(true);
		especialistaCampo.setLabel("Especialista");
		especialistaCampo.setUuid(generarToken());
		especialistaCampo.setComment("Especialidad");
		especialistaCampo.setAffects(null);
		especialistaCampo.setFilter(null);
		especialistaCampo.setEvents("*");
		especialistaCampo.setOrigin(null);
		especialistaCampo.setValue("");
		
		
		orden++;
		hioficinaCampo.setName("hioficina");
		hioficinaCampo.setFieldName("hioficina");
		hioficinaCampo.setCss("form-control");
		hioficinaCampo.setOrder(orden);
		hioficinaCampo.setComponentType("texto");
		hioficinaCampo.setReadOnly(false);
		hioficinaCampo.setHidden(false);
		hioficinaCampo.setRequired(false);
		hioficinaCampo.setShowInBasket(true);
		hioficinaCampo.setId(false);
		hioficinaCampo.setSearcheable(true);
		hioficinaCampo.setValidation(null);
		hioficinaCampo.setFormat(null);
		hioficinaCampo.setGroup("header");
		hioficinaCampo.setLength(25);
		hioficinaCampo.setDbFieldType("time");
		hioficinaCampo.setDecimals(0);
		hioficinaCampo.setPersistible(true);
		hioficinaCampo.setLabel("Hora Inicial de Oficina");
		hioficinaCampo.setUuid(generarToken());
		hioficinaCampo.setComment("hioficina");
		hioficinaCampo.setAffects(null);
		hioficinaCampo.setFilter(null);
		hioficinaCampo.setEvents("*");
		hioficinaCampo.setOrigin(null);
		hioficinaCampo.setValue("");
		
		
		orden++;
		hfoficinaCampo.setName("hfoficina");
		hfoficinaCampo.setFieldName("hfoficina");
		hfoficinaCampo.setCss("form-control");
		hfoficinaCampo.setOrder(orden);
		hfoficinaCampo.setComponentType("texto");
		hfoficinaCampo.setReadOnly(false);
		hfoficinaCampo.setHidden(false);
		hfoficinaCampo.setRequired(false);
		hfoficinaCampo.setShowInBasket(true);
		hfoficinaCampo.setId(false);
		hfoficinaCampo.setSearcheable(true);
		hfoficinaCampo.setValidation(null);
		hfoficinaCampo.setFormat(null);
		hfoficinaCampo.setGroup("header");
		hfoficinaCampo.setLength(25);
		hfoficinaCampo.setDbFieldType("time");
		hfoficinaCampo.setDecimals(0);
		hfoficinaCampo.setPersistible(true);
		hfoficinaCampo.setLabel("Horario Final de Oficina");
		hfoficinaCampo.setUuid(generarToken());
		hfoficinaCampo.setComment("hfoficina");
		hfoficinaCampo.setAffects(null);
		hfoficinaCampo.setFilter(null);
		hfoficinaCampo.setEvents("*");
		hfoficinaCampo.setOrigin(null);
		hfoficinaCampo.setValue("");
		
		
		orden++;
		celularCampo.setName("celular");
		celularCampo.setFieldName("celular");
		celularCampo.setCss("form-control");
		celularCampo.setOrder(orden);
		celularCampo.setComponentType("texto");
		celularCampo.setReadOnly(false);
		celularCampo.setHidden(false);
		celularCampo.setRequired(false);
		celularCampo.setShowInBasket(true);
		celularCampo.setId(false);
		celularCampo.setSearcheable(true);
		celularCampo.setValidation(null);
		celularCampo.setFormat(null);
		celularCampo.setGroup("header");
		celularCampo.setLength(25);
		celularCampo.setDbFieldType("varchar");
		celularCampo.setDecimals(0);
		celularCampo.setPersistible(true);
		celularCampo.setLabel("Celular");
		celularCampo.setUuid(generarToken());
		celularCampo.setComment("celular");
		celularCampo.setAffects(null);
		celularCampo.setFilter(null);
		celularCampo.setEvents("*");
		celularCampo.setOrigin(null);
		celularCampo.setValue("");
		
		
		orden++;
		telefonoCampo.setName("telefono");
		telefonoCampo.setFieldName("telefono");
		telefonoCampo.setCss("form-control");
		telefonoCampo.setOrder(orden);
		telefonoCampo.setComponentType("texto");
		telefonoCampo.setReadOnly(false);
		telefonoCampo.setHidden(false);
		telefonoCampo.setRequired(false);
		telefonoCampo.setShowInBasket(true);
		telefonoCampo.setId(false);
		telefonoCampo.setSearcheable(true);
		telefonoCampo.setValidation(null);
		telefonoCampo.setFormat(null);
		telefonoCampo.setGroup("header");
		telefonoCampo.setLength(10);
		telefonoCampo.setDbFieldType("varchar");
		telefonoCampo.setDecimals(0);
		telefonoCampo.setPersistible(true);
		telefonoCampo.setLabel("Telefono");
		telefonoCampo.setUuid(generarToken());
		telefonoCampo.setComment("telefono");
		telefonoCampo.setAffects(null);
		telefonoCampo.setFilter(null);
		telefonoCampo.setEvents("*");
		telefonoCampo.setOrigin(null);
		telefonoCampo.setValue("");
		
		
		orden++;
		correoeCampo.setName("usuario");
		correoeCampo.setFieldName("usuario");
		correoeCampo.setCss("form-control");
		correoeCampo.setOrder(orden);
		correoeCampo.setComponentType("texto");
		correoeCampo.setReadOnly(false);
		correoeCampo.setHidden(false);
		correoeCampo.setRequired(false);
		correoeCampo.setShowInBasket(true);
		correoeCampo.setId(true);
		correoeCampo.setSearcheable(true);
		correoeCampo.setValidation("^(.+)@(.+)$");
		correoeCampo.setFormat(null);
		correoeCampo.setGroup("header");
		correoeCampo.setLength(50);
		correoeCampo.setDbFieldType("varchar");
		correoeCampo.setDecimals(0);
		correoeCampo.setPersistible(true);
		correoeCampo.setLabel("Correo electronico");
		correoeCampo.setUuid(generarToken());
		correoeCampo.setComment("Correo de usuario");
		correoeCampo.setAffects(null);
		correoeCampo.setFilter(null);
		correoeCampo.setEvents("*");
		correoeCampo.setOrigin(null);
		correoeCampo.setValue("");
		
		
		/*orden++;
		fcontactoCampo.setName("fcontacto");
		fcontactoCampo.setFieldName("fcontacto");
		fcontactoCampo.setCss("form-control");
		fcontactoCampo.setOrder(orden);
		fcontactoCampo.setComponentType("texto");
		fcontactoCampo.setReadOnly(false);
		fcontactoCampo.setHidden(false);
		fcontactoCampo.setRequired(false);
		fcontactoCampo.setShowInBasket(true);
		fcontactoCampo.setId(true);
		fcontactoCampo.setSearcheable(true);
		fcontactoCampo.setValidation(null);
		fcontactoCampo.setFormat(null);
		fcontactoCampo.setGroup("header");
		fcontactoCampo.setLength(30);
		fcontactoCampo.setDbFieldType("varchar");
		fcontactoCampo.setDecimals(0);
		fcontactoCampo.setPersistible(true);
		fcontactoCampo.setLabel("Foto de Contacto");
		fcontactoCampo.setUuid(generarToken());
		fcontactoCampo.setComment("fcontacto");
		fcontactoCampo.setAffects(null);
		fcontactoCampo.setFilter(null);
		fcontactoCampo.setEvents("*");
		fcontactoCampo.setOrigin(null);
		fcontactoCampo.setValue("");*/
		
		
		orden++;
		cemergenciaCampo.setName("contacto");
		cemergenciaCampo.setFieldName("contacto");
		cemergenciaCampo.setCss("form-control");
		cemergenciaCampo.setOrder(orden);
		cemergenciaCampo.setComponentType("texto");
		cemergenciaCampo.setReadOnly(false);
		cemergenciaCampo.setHidden(false);
		cemergenciaCampo.setRequired(false);
		cemergenciaCampo.setShowInBasket(true);
		cemergenciaCampo.setId(false);
		cemergenciaCampo.setSearcheable(true);
		cemergenciaCampo.setValidation(null);
		cemergenciaCampo.setFormat(null);
		cemergenciaCampo.setGroup("header");
		cemergenciaCampo.setLength(30);
		cemergenciaCampo.setDbFieldType("varchar");
		cemergenciaCampo.setDecimals(0);
		cemergenciaCampo.setPersistible(true);
		cemergenciaCampo.setLabel("Contacto de Emergencia");
		cemergenciaCampo.setUuid(generarToken());
		cemergenciaCampo.setComment("Campo de contacto de emergencia");
		cemergenciaCampo.setAffects(null);
		cemergenciaCampo.setFilter(null);
		cemergenciaCampo.setEvents("*");
		cemergenciaCampo.setOrigin(null);
		cemergenciaCampo.setValue("");
		
		
		orden++;
		sexoCampo.setName("sexo");
		sexoCampo.setFieldName("sexo");
		sexoCampo.setCss("form-select");
		sexoCampo.setOrder(orden);
		sexoCampo.setComponentType("lista");
		sexoCampo.setReadOnly(false);
		sexoCampo.setHidden(false);
		sexoCampo.setRequired(false);
		sexoCampo.setShowInBasket(true);
		sexoCampo.setId(false);
		sexoCampo.setSearcheable(true);
		sexoCampo.setValidation(null);
		sexoCampo.setFormat(null);
		sexoCampo.setGroup("header");
		sexoCampo.setLength(10);
		sexoCampo.setDbFieldType("varchar");
		sexoCampo.setDecimals(0);
		sexoCampo.setPersistible(true);
		sexoCampo.setLabel("Sexo");
		sexoCampo.setUuid(generarToken());
		sexoCampo.setComment("sexo");
		sexoCampo.setAffects(null);
		sexoCampo.setFilter(null);
		sexoCampo.setEvents("*");
		sexoCampo.setOrigin("{\"origin\":\"recurso\",\"resource\":\"inlinevalues\",\"fields\":[{\"name\":\"Masculino,Femenino\"}]}");
		sexoCampo.setValue("");
		
		orden++;
		aprentescoCampo.setName("parentesco");
		aprentescoCampo.setFieldName("parentesco");
		aprentescoCampo.setCss("form-control");
		aprentescoCampo.setOrder(orden);
		aprentescoCampo.setComponentType("texto");
		aprentescoCampo.setReadOnly(false);
		aprentescoCampo.setHidden(false);
		aprentescoCampo.setRequired(false);
		aprentescoCampo.setShowInBasket(true);
		aprentescoCampo.setId(false);
		aprentescoCampo.setSearcheable(true);
		aprentescoCampo.setValidation(null);
		aprentescoCampo.setFormat(null);
		aprentescoCampo.setGroup("header");
		aprentescoCampo.setLength(100);
		aprentescoCampo.setDbFieldType("varchar");
		aprentescoCampo.setDecimals(0);
		aprentescoCampo.setPersistible(true);
		aprentescoCampo.setLabel("Parentesco");
		aprentescoCampo.setUuid(generarToken());
		aprentescoCampo.setComment("parentesco");
		aprentescoCampo.setAffects(null);
		aprentescoCampo.setFilter(null);
		aprentescoCampo.setEvents("*");
		aprentescoCampo.setOrigin(null);
		aprentescoCampo.setValue("");
		
		
		orden++;
		tsangreCampo.setName("tsangre");
		tsangreCampo.setFieldName("tsangre");
		tsangreCampo.setCss("form-control");
		tsangreCampo.setOrder(orden);
		tsangreCampo.setComponentType("texto");
		tsangreCampo.setReadOnly(false);
		tsangreCampo.setHidden(false);
		tsangreCampo.setRequired(false);
		tsangreCampo.setShowInBasket(true);
		tsangreCampo.setId(false);
		tsangreCampo.setSearcheable(true);
		tsangreCampo.setValidation(null);
		tsangreCampo.setFormat(null);
		tsangreCampo.setGroup("header");
		tsangreCampo.setLength(20);
		tsangreCampo.setDbFieldType("varchar");
		tsangreCampo.setDecimals(0);
		tsangreCampo.setPersistible(true);
		tsangreCampo.setLabel("Tipo de Sangre");
		tsangreCampo.setUuid(generarToken());
		tsangreCampo.setComment("tsangre");
		tsangreCampo.setAffects(null);
		tsangreCampo.setFilter(null);
		tsangreCampo.setEvents("*");
		tsangreCampo.setOrigin(null);
		tsangreCampo.setValue("");
		
		orden++;
		tipoCampo.setName("tipo");
		tipoCampo.setFieldName("tipo");
		tipoCampo.setCss("form-control");
		tipoCampo.setOrder(orden);
		tipoCampo.setComponentType("texto");
		tipoCampo.setReadOnly(true);
		tipoCampo.setHidden(false);
		tipoCampo.setRequired(false);
		tipoCampo.setShowInBasket(true);
		tipoCampo.setId(false);
		tipoCampo.setSearcheable(true);
		tipoCampo.setValidation(null);
		tipoCampo.setFormat(null);
		tipoCampo.setGroup("header");
		tipoCampo.setLength(50);
		tipoCampo.setDbFieldType("varchar");
		tipoCampo.setDecimals(0);
		tipoCampo.setPersistible(true);
		tipoCampo.setLabel("Tipo");
		tipoCampo.setUuid(generarToken());
		tipoCampo.setComment("Tipo");
		tipoCampo.setAffects(null);
		tipoCampo.setFilter(null);
		tipoCampo.setEvents("*");
		tipoCampo.setOrigin(null);
		tipoCampo.setValue("paciente");

		
		orden++;
		zhorariaCampo.setName("zhoraria");
		zhorariaCampo.setFieldName("zhoraria");
		zhorariaCampo.setCss("form-control");
		zhorariaCampo.setOrder(orden);
		zhorariaCampo.setComponentType("zhoraria");
		zhorariaCampo.setReadOnly(false);
		zhorariaCampo.setHidden(false);
		zhorariaCampo.setRequired(false);
		zhorariaCampo.setShowInBasket(true);
		zhorariaCampo.setId(false);
		zhorariaCampo.setSearcheable(true);
		zhorariaCampo.setValidation(null);
		zhorariaCampo.setFormat(null);
		zhorariaCampo.setGroup("header");
		zhorariaCampo.setLength(10);
		zhorariaCampo.setDbFieldType("time");
		zhorariaCampo.setDecimals(0);
		zhorariaCampo.setPersistible(true);
		zhorariaCampo.setLabel("Zona Horaria");
		zhorariaCampo.setUuid(generarToken());
		zhorariaCampo.setComment("zhoraria");
		zhorariaCampo.setAffects(null);
		zhorariaCampo.setFilter(null);
		zhorariaCampo.setEvents("*");
		zhorariaCampo.setOrigin(null);
		zhorariaCampo.setValue("");
		
		
		orden++;
		faltaCampo.setName("falta");
		faltaCampo.setFieldName("falta");
		faltaCampo.setCss("form-control");
		faltaCampo.setOrder(orden);
		faltaCampo.setComponentType("texto");
		faltaCampo.setReadOnly(true);
		faltaCampo.setHidden(false);
		faltaCampo.setRequired(false);
		faltaCampo.setShowInBasket(true);
		faltaCampo.setId(false);
		faltaCampo.setSearcheable(true);
		faltaCampo.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		faltaCampo.setFormat(null);
		faltaCampo.setGroup("header");
		faltaCampo.setLength(10);
		faltaCampo.setDbFieldType("date");
		faltaCampo.setDecimals(0);
		faltaCampo.setPersistible(true);
		faltaCampo.setLabel("Falta");
		faltaCampo.setUuid(generarToken());
		faltaCampo.setComment("falta");
		faltaCampo.setAffects(null);
		faltaCampo.setFilter(null);
		faltaCampo.setEvents("*");
		faltaCampo.setOrigin(null);
		faltaCampo.setValue("${default::todayShort}");
		
		orden++;
		statusCampo.setName("status");
		statusCampo.setFieldName("status");
		statusCampo.setCss("form-select");
		statusCampo.setOrder(orden);
		statusCampo.setComponentType("lista");
		statusCampo.setReadOnly(false);
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
		statusCampo.setComment("status");
		statusCampo.setAffects(null);
		statusCampo.setFilter(null);
		statusCampo.setEvents("*");
		statusCampo.setOrigin("{\"origin\":\"recurso\",\"resource\":\"inlinevalues\",\"fields\":[{\"name\":\"Activo,Cancelado\"}]}");
		statusCampo.setValue("");
		
		orden++;
		idiomaCampo.setName("idioma");
		idiomaCampo.setFieldName("idioma");
		idiomaCampo.setCss("form-control");
		idiomaCampo.setOrder(orden);
		idiomaCampo.setComponentType("idioma");
		idiomaCampo.setReadOnly(false);
		idiomaCampo.setHidden(false);
		idiomaCampo.setRequired(false);
		idiomaCampo.setShowInBasket(true);
		idiomaCampo.setId(false);
		idiomaCampo.setSearcheable(true);
		idiomaCampo.setValidation(null);
		idiomaCampo.setFormat(null);
		idiomaCampo.setGroup("header");
		idiomaCampo.setLength(45);
		idiomaCampo.setDbFieldType("list");
		idiomaCampo.setDecimals(0);
		idiomaCampo.setPersistible(true);
		idiomaCampo.setLabel("Idioma");
		idiomaCampo.setUuid(generarToken());
		idiomaCampo.setComment("idioma");
		idiomaCampo.setAffects(null);
		idiomaCampo.setFilter(null);
		idiomaCampo.setEvents("*");
		idiomaCampo.setOrigin(null);
		idiomaCampo.setValue("");
		
		
		orden++;
		prenombreCampo.setName("prenombre");
		prenombreCampo.setFieldName("prenombre");
		prenombreCampo.setCss("form-control");
		prenombreCampo.setOrder(orden);
		prenombreCampo.setComponentType("texto");
		prenombreCampo.setReadOnly(false);
		prenombreCampo.setHidden(false);
		prenombreCampo.setRequired(false);
		prenombreCampo.setShowInBasket(true);
		prenombreCampo.setId(false);
		prenombreCampo.setSearcheable(true);
		prenombreCampo.setValidation(null);
		prenombreCampo.setFormat(null);
		prenombreCampo.setGroup("header");
		prenombreCampo.setLength(20);
		prenombreCampo.setDbFieldType("varchar");
		prenombreCampo.setDecimals(0);
		prenombreCampo.setPersistible(true);
		prenombreCampo.setLabel("Prenombre");
		prenombreCampo.setUuid(generarToken());
		prenombreCampo.setComment("prenombre");
		prenombreCampo.setAffects(null);
		prenombreCampo.setFilter(null);
		prenombreCampo.setEvents("*");
		prenombreCampo.setOrigin(null);
		prenombreCampo.setValue("");
		
		
		orden++;
		profesionCampo.setName("profesion");
		profesionCampo.setFieldName("profesion");
		profesionCampo.setCss("form-control");
		profesionCampo.setOrder(orden);
		profesionCampo.setComponentType("texto");
		profesionCampo.setReadOnly(false);
		profesionCampo.setHidden(false);
		profesionCampo.setRequired(false);
		profesionCampo.setShowInBasket(true);
		profesionCampo.setId(false);
		profesionCampo.setSearcheable(true);
		profesionCampo.setValidation(null);
		profesionCampo.setFormat(null);
		profesionCampo.setGroup("header");
		profesionCampo.setLength(100);
		profesionCampo.setDbFieldType("varchar");
		profesionCampo.setDecimals(0);
		profesionCampo.setPersistible(true);
		profesionCampo.setLabel("Profesion");
		profesionCampo.setUuid(generarToken());
		profesionCampo.setComment("profesion");
		profesionCampo.setAffects(null);
		profesionCampo.setFilter(null);
		profesionCampo.setEvents("*");
		profesionCampo.setOrigin(null);
		profesionCampo.setValue("");
		
		
		orden++;
		sucursalCampo.setName("sucursal");
		sucursalCampo.setFieldName("sucursal");
		sucursalCampo.setCss("form-control");
		sucursalCampo.setOrder(orden);
		sucursalCampo.setComponentType("sucursal");
		sucursalCampo.setReadOnly(false);
		sucursalCampo.setHidden(false);
		sucursalCampo.setRequired(false);
		sucursalCampo.setShowInBasket(true);
		sucursalCampo.setId(false);
		sucursalCampo.setSearcheable(true);
		sucursalCampo.setValidation(null);
		sucursalCampo.setFormat(null);
		sucursalCampo.setGroup("header");
		sucursalCampo.setLength(60);
		sucursalCampo.setDbFieldType("varchar");
		sucursalCampo.setDecimals(0);
		sucursalCampo.setPersistible(true);
		sucursalCampo.setLabel("Sucursal");
		sucursalCampo.setUuid(generarToken());
		sucursalCampo.setComment("sucursal");
		sucursalCampo.setAffects(null);
		sucursalCampo.setFilter(null);
		sucursalCampo.setEvents("*");
		sucursalCampo.setOrigin("{\"origin\":\"tabla\",\"resource\":\"dircto\",\"fields\":[{\"name\":\"uuid\", \"filter\":\"\"},{\"name\":\"nombre\", \"filter\":\"\"},{\"name\":\"tipo\", \"filter\":\"sucursal\"}]}");		
		sucursalCampo.setValue("");
		
		orden++;
		odontogramaCampo.setName("odontograma");
		odontogramaCampo.setFieldName("odontograma");
		odontogramaCampo.setCss("form-control");
		odontogramaCampo.setOrder(orden);
		odontogramaCampo.setComponentType("odontograma");
		odontogramaCampo.setReadOnly(false);
		odontogramaCampo.setHidden(false);
		odontogramaCampo.setRequired(true);
		odontogramaCampo.setShowInBasket(true);
		odontogramaCampo.setId(false);
		odontogramaCampo.setSearcheable(true);
		odontogramaCampo.setValidation(null);
		odontogramaCampo.setFormat(null);
		odontogramaCampo.setGroup("header");
		odontogramaCampo.setLength(60);
		odontogramaCampo.setDbFieldType("varchar");
		odontogramaCampo.setDecimals(0);
		odontogramaCampo.setPersistible(true);
		odontogramaCampo.setLabel("Odontograma");
		odontogramaCampo.setUuid(generarToken());
		odontogramaCampo.setComment("Odontograma");
		odontogramaCampo.setAffects(null);
		odontogramaCampo.setFilter(null);
		odontogramaCampo.setEvents("*");
		odontogramaCampo.setOrigin("{\"origin\":\"tabla\",\"resource\":\"odontograma\",\"fields\":[{\"name\":\"nombre\", \"filter\":\"\"},{\"name\":\"uuid\", \"filter\":\"\"}]}");
		odontogramaCampo.setValue("");
		
		orden++;
		periodontogramaCampo.setName("periodontograma");
		periodontogramaCampo.setFieldName("periodontograma");
		periodontogramaCampo.setCss("form-control");
		periodontogramaCampo.setOrder(orden);
		periodontogramaCampo.setComponentType("texto");
		periodontogramaCampo.setReadOnly(true);
		periodontogramaCampo.setHidden(false);
		periodontogramaCampo.setRequired(false);
		periodontogramaCampo.setShowInBasket(true);
		periodontogramaCampo.setId(false);
		periodontogramaCampo.setSearcheable(true);
		periodontogramaCampo.setValidation(null);
		periodontogramaCampo.setFormat(null);
		periodontogramaCampo.setGroup("header");
		periodontogramaCampo.setLength(60);
		periodontogramaCampo.setDbFieldType("varchar");
		periodontogramaCampo.setDecimals(0);
		periodontogramaCampo.setPersistible(true);
		periodontogramaCampo.setLabel("Periodontograma");
		periodontogramaCampo.setUuid(generarToken());
		periodontogramaCampo.setComment("Periodontograma");
		periodontogramaCampo.setAffects(null);
		periodontogramaCampo.setFilter(null);
		periodontogramaCampo.setEvents("*");
		periodontogramaCampo.setOrigin("");
		periodontogramaCampo.setValue("");
		
		//Estos son los ultimos campos
		
		orden++;
		uuidCampo.setName("uuid");
		uuidCampo.setFieldName("uuid");
		uuidCampo.setCss("form-control");
		uuidCampo.setOrder(orden);
		uuidCampo.setLength(30);
		uuidCampo.setComponentType("varchar");
		uuidCampo.setReadOnly(false);
		uuidCampo.setHidden(false);
		uuidCampo.setRequired(true);
		uuidCampo.setShowInBasket(true);
		uuidCampo.setId(false);
		uuidCampo.setSearcheable(true);
		uuidCampo.setValidation(null);
		uuidCampo.setFormat(null);
		uuidCampo.setGroup("header");
		// Change to dropdown with patients records
		uuidCampo.setComponentType("texto");
		uuidCampo.setReadOnly(false);
		uuidCampo.setHidden(true);
		uuidCampo.setShowInBasket(true);
		uuidCampo.setDecimals(0);
		uuidCampo.setDbFieldType("varchar");
		uuidCampo.setLabel("uuid pariente");
		uuidCampo.setUuid(generarToken());
		uuidCampo.setComment("Campo uuid pariente");
		uuidCampo.setEvents("*");
		uuidCampo.setValue("${default::uuid}");

		orden++;
		uuipCampo.setName("uuidp");
		uuipCampo.setFieldName("uuidp");
		uuipCampo.setCss("form-control");
		uuipCampo.setOrder(orden);
		uuipCampo.setLength(30);
		// Change to dropdown with patients records
		uuipCampo.setComponentType("texto");
		uuipCampo.setReadOnly(false);
		uuipCampo.setHidden(true);
		uuipCampo.setRequired(false);
		uuipCampo.setShowInBasket(true);
		uuipCampo.setId(false);
		uuipCampo.setSearcheable(true);
		uuipCampo.setValidation(null);
		uuipCampo.setFormat(null);
		uuipCampo.setGroup("header");
		uuipCampo.setReadOnly(false);
		uuipCampo.setHidden(true);
		uuipCampo.setDecimals(0);
		uuipCampo.setDbFieldType("varchar");
		uuipCampo.setLabel("uuid pariente");
		uuipCampo.setUuid(generarToken());
		uuipCampo.setComment("Campo uuidp pariente");
		uuipCampo.setEvents("*");

		orden++;
		uuideCampo.setName("uuide");
		uuideCampo.setFieldName("uuide");
		uuideCampo.setCss("form-control");
		uuideCampo.setOrder(orden);
		uuideCampo.setLength(30);
		uuideCampo.setComponentType("texto");
		uuideCampo.setReadOnly(false);
		uuideCampo.setHidden(true);
		uuideCampo.setRequired(false);
		uuideCampo.setShowInBasket(true);
		uuideCampo.setId(false);
		uuideCampo.setSearcheable(true);
		uuideCampo.setValidation(null);
		uuideCampo.setFormat(null);
		uuideCampo.setGroup("header");
		uuideCampo.setComponentType("texto");
		uuideCampo.setDecimals(0);
		uuideCampo.setDbFieldType("varchar");
		uuideCampo.setLabel("uuid empresa");
		uuideCampo.setUuid(generarToken());
		uuideCampo.setComment("Campo uuie empresa");
		uuideCampo.setEvents("*");

		campos.add(codigoCampo);
		campos.add(uuidCampo);
		campos.add(uuipCampo);
		campos.add(uuideCampo);
		//campos.add(pacienteCampo);
		//campos.add(companyCampo);
		// Copiar esta linea - Paloma
		campos.add(nombresCampo);
		//campos.add(apaternoCampo);
		//campos.add(amaternoCampo);
		campos.add(curpCampo);
		campos.add(rfcCampo);
		campos.add(fnacimientoCampo);
		campos.add(especialistaCampo);
		campos.add(hioficinaCampo);
		campos.add(hfoficinaCampo);
		campos.add(celularCampo);
		campos.add(telefonoCampo);
		campos.add(correoeCampo);
		//campos.add(fcontactoCampo);
		campos.add(cemergenciaCampo);
		campos.add(sexoCampo);
		campos.add(aprentescoCampo);
		campos.add(tsangreCampo);
		campos.add(tipoCampo);
		campos.add(zhorariaCampo);
		campos.add(faltaCampo);
		campos.add(statusCampo);
		campos.add(idiomaCampo);
		campos.add(prenombreCampo);
		campos.add(profesionCampo);
		campos.add(sucursalCampo);
		campos.add(odontogramaCampo);
		campos.add(periodontogramaCampo);
		
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