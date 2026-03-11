/**
 * 
 */
package com.mio.formas.generador;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

import org.junit.Test;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.formuscmp.formus.button.Button;
import com.formuscmp.formus.field.Field;
import com.formuscmp.formus.generator.Generador;
import com.formuscmp.formus.generator.IGenerador;
import com.formuscmp.formus.resource.Resource;

/**
 * @author jcruzrey
 *
 */
public class GeneradorHtmlCrmTest1 {

	private String[] templatesPath = new String[] { "/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config" };

	/**
	 * Test method for
	 * {@link com.formuscmp.formus.generator.Generador#guatdarForma(java.util.List, java.lang.String)}.
	 */
	private String generarToken() {
		Supplier<String> tokenSupplier = () -> {

			StringBuilder token = new StringBuilder();
			long currentTimeInMilisecond = Instant.now().toEpochMilli();
			return token.append(currentTimeInMilisecond).append("-").append(UUID.randomUUID().toString()).toString();
		};

		return tokenSupplier.get();
	}

	private List<Button> dameMetodosComunes(String idioma, String modulo, String recurso, String version,
			Integer orden) {
		List<Button> metodos = new ArrayList<Button>();

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
			metodoDetalle.setOrder(orden);
			metodoDetalle.setInstruction("Detalles");
		} else {
			metodoDetalle.setName("detail");
			metodoDetalle.setResourceType("form");
			metodoDetalle.setCommandName("detail");
			metodoDetalle.setLabel("Detail");
			metodoDetalle.setEvents("new");
			metodoDetalle.setComponentType("submit");
			metodoDetalle.setOrder(orden);
			metodoDetalle.setInstruction("Details");
		}
		metodoDetalle.setUuid(generarToken());
		metodos.add(metodoDetalle);
		return metodos;
	}

	@Test
	public void testNuevoFormaCita() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve("cita.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes("es_MX", "crm", "cita", "1.0", 1);

		Field codigoCampo = new Field();
		Field pacienteCampo = new Field();
		// Field companyCampo = new Field();

		Field companyCampo = new Field();
		Field faltaCampo = new Field();
		Resource forma = new Resource();

		forma.setPrefix("CIT");
		forma.setCommandName("guardar");
		forma.setName("cita");
		forma.setView("vista");
		forma.setTitle("Cita");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("crm");
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("cita");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion de la cita");
		forma.setUuid(generarToken());
		forma.setComment("Formulario para crear una cita");

		codigoCampo.setName("Codigo");
		codigoCampo.setFieldName("codigo");
		codigoCampo.setCss("form-control");
		codigoCampo.setOrder(1);
		codigoCampo.setLength(30);
		codigoCampo.setComponentType("texto");
		codigoCampo.setReadOnly(false);
		codigoCampo.setHidden(false);
		codigoCampo.setRequired(true);
		codigoCampo.setShowInBasket(true);
		codigoCampo.setId(true);
		codigoCampo.setDecimals(0);
		codigoCampo.setDbFieldType("varchar");
		codigoCampo.setLabel("Codigo (Auto)");
		codigoCampo.setUuid(generarToken());
		codigoCampo.setComment("Campo codigo");
		codigoCampo.setEvents("*");

		pacienteCampo.setName("uuip");
		pacienteCampo.setFieldName("uuidp");
		pacienteCampo.setCss("form-control");
		pacienteCampo.setOrder(2);
		pacienteCampo.setLength(30);
		// Change to dropdown with patients records
		pacienteCampo.setComponentType("texto");
		pacienteCampo.setReadOnly(false);
		pacienteCampo.setHidden(false);
		pacienteCampo.setRequired(true);
		pacienteCampo.setShowInBasket(true);
		pacienteCampo.setId(false);
		pacienteCampo.setDecimals(0);
		pacienteCampo.setDbFieldType("varchar");
		pacienteCampo.setLabel("uuid pariente");
		pacienteCampo.setUuid(generarToken());
		pacienteCampo.setComment("Campo uuid pariente");
		pacienteCampo.setEvents("*");

		companyCampo.setName("uuide");
		companyCampo.setFieldName("uuide");
		companyCampo.setCss("form-control");
		companyCampo.setOrder(3);
		companyCampo.setLength(30);
		companyCampo.setComponentType("texto");
		companyCampo.setReadOnly(false);
		companyCampo.setHidden(false);
		companyCampo.setRequired(false);
		companyCampo.setShowInBasket(true);
		companyCampo.setId(false);
		companyCampo.setDecimals(0);
		companyCampo.setDbFieldType("varchar");
		companyCampo.setLabel("uuid empresa");
		companyCampo.setUuid(generarToken());
		companyCampo.setComment("Campo uuid empresa");
		companyCampo.setEvents("*");

		faltaCampo.setName("falta");
		faltaCampo.setFieldName("falta");
		faltaCampo.setCss("form-control");
		faltaCampo.setOrder(4);
		faltaCampo.setComponentType("fecha");
		faltaCampo.setReadOnly(false);
		faltaCampo.setHidden(false);
		faltaCampo.setRequired(false);
		faltaCampo.setShowInBasket(true);
		faltaCampo.setId(false);
		faltaCampo.setDecimals(0);
		faltaCampo.setDbFieldType("date");
		faltaCampo.setLabel("Fecha registro");
		faltaCampo.setUuid(generarToken());
		faltaCampo.setComment("Fecha de registro");
		faltaCampo.setEvents("*");

		campos.add(codigoCampo);
		campos.add(pacienteCampo);
		campos.add(companyCampo);
		campos.add(faltaCampo);

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

	/**
	 * Test method for
	 * {@link com.formuscmp.formus.generator.Generador#guatdarForma(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testNuevoCrmPaciente() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve("paciente.json").normalize();
		int orden = 1;
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes("es_MX", "crm", "cita", "1.0", 1);

		Field codigoCampo = new Field();
		Field pacienteCampo = new Field();
		// Field companyCampo = new Field();

		Field companyCampo = new Field();
		Field faltaCampo = new Field();
		Field uuidCampo = new Field();

		// Aqui declaramos las variables de campos - Paloma
		Field nombresCampo = new Field();

		Resource forma = new Resource();

		forma.setPrefix("PAC");
		forma.setCommandName("guardar");
		forma.setName("paciente");
		forma.setView("vista");
		forma.setTitle("Paciente");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("crm");
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

		codigoCampo.setName("Codigo");
		codigoCampo.setFieldName("codigo");
		codigoCampo.setCss("form-control");
		codigoCampo.setOrder(orden);
		codigoCampo.setComponentType("texto");
		codigoCampo.setReadOnly(false);
		codigoCampo.setHidden(false);
		codigoCampo.setRequired(true);
		codigoCampo.setShowInBasket(true);
		codigoCampo.setId(true);
		codigoCampo.setSearcheable(true);
		codigoCampo.setValidation(null);
		codigoCampo.setFormat(null);
		codigoCampo.setGroup("header");
		codigoCampo.setLength(30);
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
		orden++;
		nombresCampo.setName("nombres");
		nombresCampo.setFieldName("nombres");
		nombresCampo.setCss("form-control");
		nombresCampo.setOrder(orden);
		nombresCampo.setComponentType("texto");
		nombresCampo.setReadOnly(false);
		nombresCampo.setHidden(false);
		nombresCampo.setRequired(true);
		nombresCampo.setShowInBasket(true);
		nombresCampo.setId(true);
		nombresCampo.setSearcheable(true);
		nombresCampo.setValidation(null);
		nombresCampo.setFormat(null);
		nombresCampo.setGroup("header");
		nombresCampo.setLength(30);
		nombresCampo.setDbFieldType("varchar");
		nombresCampo.setDecimals(0);
		nombresCampo.setPersistible(true);
		nombresCampo.setLabel("Codigo (Auto)");
		nombresCampo.setUuid(generarToken());
		nombresCampo.setComment("Campo codigo");
		nombresCampo.setAffects(null);
		nombresCampo.setFilter(null);
		nombresCampo.setEvents("*");
		nombresCampo.setOrigin(null);
		nombresCampo.setValue("");

		//Aqui ponder todos los campos del excel - Paloma
		
		
		
		
		
		
		//Estos son los ultimos campos
		orden++;
		faltaCampo.setName("falta");
		faltaCampo.setFieldName("falta");
		faltaCampo.setCss("form-control");
		faltaCampo.setOrder(orden); // Este deb ser el 19
		faltaCampo.setComponentType("fecha");
		faltaCampo.setReadOnly(false);
		faltaCampo.setHidden(false);
		faltaCampo.setRequired(false);
		faltaCampo.setShowInBasket(true);
		faltaCampo.setId(false);
		faltaCampo.setDecimals(0);
		faltaCampo.setDbFieldType("date");
		faltaCampo.setLabel("Fecha registro");
		faltaCampo.setUuid(generarToken());
		faltaCampo.setComment("Fecha de registro");
		faltaCampo.setEvents("*");
		
		orden++;
		uuidCampo.setName("uuid");
		uuidCampo.setFieldName("uuid");
		uuidCampo.setCss("form-control");
		uuidCampo.setOrder(orden);
		uuidCampo.setLength(30);
		// Change to dropdown with patients records
		uuidCampo.setComponentType("texto");
		uuidCampo.setReadOnly(false);
		uuidCampo.setHidden(false);
		uuidCampo.setRequired(true);
		uuidCampo.setShowInBasket(true);
		uuidCampo.setId(false);
		uuidCampo.setDecimals(0);
		uuidCampo.setDbFieldType("varchar");
		uuidCampo.setLabel("uuid pariente");
		uuidCampo.setUuid(generarToken());
		uuidCampo.setComment("Campo uuid pariente");
		uuidCampo.setEvents("*");

		orden++;
		pacienteCampo.setName("uuip");
		pacienteCampo.setFieldName("uuidp");
		pacienteCampo.setCss("form-control");
		pacienteCampo.setOrder(orden);
		pacienteCampo.setLength(30);
		// Change to dropdown with patients records
		pacienteCampo.setComponentType("texto");
		pacienteCampo.setReadOnly(false);
		pacienteCampo.setHidden(false);
		pacienteCampo.setRequired(true);
		pacienteCampo.setShowInBasket(true);
		pacienteCampo.setId(false);
		pacienteCampo.setDecimals(0);
		pacienteCampo.setDbFieldType("varchar");
		pacienteCampo.setLabel("uuid pariente");
		pacienteCampo.setUuid(generarToken());
		pacienteCampo.setComment("Campo uuip pariente");
		pacienteCampo.setEvents("*");

		companyCampo.setName("uuide");
		companyCampo.setFieldName("uuide");
		companyCampo.setCss("form-control");
		companyCampo.setOrder(52);
		companyCampo.setLength(30);
		companyCampo.setComponentType("texto");
		companyCampo.setReadOnly(false);
		companyCampo.setHidden(false);
		companyCampo.setRequired(false);
		companyCampo.setShowInBasket(true);
		companyCampo.setId(false);
		companyCampo.setDecimals(0);
		companyCampo.setDbFieldType("varchar");
		companyCampo.setLabel("uuid empresa");
		companyCampo.setUuid(generarToken());
		companyCampo.setComment("Campo uuie empresa");
		companyCampo.setEvents("*");

		campos.add(codigoCampo);
		campos.add(faltaCampo);
		campos.add(uuidCampo);
		campos.add(pacienteCampo);
		campos.add(companyCampo);
		// Copiar esta linea - Paloma
		campos.add(nombresCampo);

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