/**
 * 
 */
package com.mio.formas.generador;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

import org.junit.Test;
import com.fasterxml.jackson.core.JsonGenerationException;
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
public class DentalOdontograma {

	public String generarToken() {
		Supplier<String> tokenSupplier = () -> {

			StringBuilder token = new StringBuilder();
			long currentTimeInMilisecond = Instant.now().toEpochMilli();
			return token.append(currentTimeInMilisecond).append("-").append(UUID.randomUUID().toString()).toString();
		};

		return tokenSupplier.get();
	}
	
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
		String formulario = "odontograma"; //nombre del formulario *
		String version = "1.0"; //version
		String idioma = "es_MX"; //version

		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve(modulo + "_" + formulario + ".json").normalize();
		int orden = 1;
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes(idioma, modulo, formulario, version, 1);

		//Definir todos los campos *
		Field codigoCampo = new Field();
		Field nombreCampo = new Field();
		Field faltaCampo = new Field();
		Field statusCampo = new Field();
		Field edadiCampo = new Field();
		Field edadfCampo = new Field();
		Field obsCampo = new Field();
		Field uuidCampo = new Field();
		Field uuidpCampo = new Field();
		Field uuideCampo = new Field();


		Field supizqCampo = new Field();
		Field supicenCampo = new Field();
		Field supdcenCampo = new Field();
		Field supderCampo = new Field();
		Field infizqCampo = new Field();
		Field inficenCampo = new Field();
		Field infdcenCampo = new Field();
		Field infderCampo = new Field();

		Resource forma = new Resource();

		//Ajustar *
		forma.setPrefix("OGM");
		forma.setCommandName("guardar");
		forma.setName("odontograma");
		forma.setView("vista");
		forma.setTitle("Odontograma");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule(modulo);
		forma.setBasket("odontograma");
		forma.setCreateable(true);
		forma.setTable("odontograma");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion del odontograma");
		forma.setUuid(generarToken());
		forma.setComment("Formulario para crear un odontograma");
		forma.setOrigin("ui::case");
		forma.setDestination("db::mysql");
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
		codigoCampo.setLabel("Codigo");
		codigoCampo.setUuid(generarToken());
		codigoCampo.setComment("codigo");
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
		nombreCampo.setLength(20);
		nombreCampo.setDbFieldType("varchar");
		nombreCampo.setDecimals(0);
		nombreCampo.setPersistible(true);
		nombreCampo.setLabel("Infantil/Adulto/Otro");
		nombreCampo.setUuid(generarToken());
		nombreCampo.setComment("nombre");
		nombreCampo.setAffects(null);
		nombreCampo.setFilter(null);
		nombreCampo.setEvents("*");
		nombreCampo.setOrigin(null);
		nombreCampo.setValue("");

		orden++;
		faltaCampo.setName("falta");
		faltaCampo.setFieldName("falta");
		faltaCampo.setCss("form-control");
		faltaCampo.setOrder(orden);
		faltaCampo.setComponentType("fecha");
		faltaCampo.setReadOnly(false);
		faltaCampo.setHidden(false);
		faltaCampo.setRequired(true);
		faltaCampo.setShowInBasket(true);
		faltaCampo.setId(false);
		faltaCampo.setSearcheable(true);
		faltaCampo.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		faltaCampo.setFormat(null);
		faltaCampo.setGroup("header");
		faltaCampo.setLength(0);
		faltaCampo.setDbFieldType("date");
		faltaCampo.setDecimals(0);
		faltaCampo.setPersistible(true);
		faltaCampo.setLabel("Fecha Alta");
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
		statusCampo.setCss("form-control");
		statusCampo.setOrder(orden);
		statusCampo.setComponentType("texto");
		statusCampo.setReadOnly(false);
		statusCampo.setHidden(false);
		statusCampo.setRequired(true);
		statusCampo.setShowInBasket(true);
		statusCampo.setId(false);
		statusCampo.setSearcheable(true);
		statusCampo.setValidation(null);
		statusCampo.setFormat(null);
		statusCampo.setGroup("header");
		statusCampo.setLength(30);
		statusCampo.setDbFieldType("varchar");
		statusCampo.setDecimals(0);
		statusCampo.setPersistible(true);
		statusCampo.setLabel("Status");
		statusCampo.setUuid(generarToken());
		statusCampo.setComment("status");
		statusCampo.setAffects(null);
		statusCampo.setFilter(null);
		statusCampo.setEvents("*");
		statusCampo.setOrigin(null);
		statusCampo.setValue("");

		orden++;
		edadiCampo.setName("edadi");
		edadiCampo.setFieldName("edadi");
		edadiCampo.setCss("form-control");
		edadiCampo.setOrder(orden);
		edadiCampo.setComponentType("texto");
		edadiCampo.setReadOnly(false);
		edadiCampo.setHidden(false);
		edadiCampo.setRequired(true);
		edadiCampo.setShowInBasket(true);
		edadiCampo.setId(false);
		edadiCampo.setSearcheable(true);
		edadiCampo.setValidation(null);
		edadiCampo.setFormat(null);
		edadiCampo.setGroup("header");
		edadiCampo.setLength(2);
		edadiCampo.setDbFieldType("int");
		edadiCampo.setDecimals(0);
		edadiCampo.setPersistible(true);
		edadiCampo.setLabel("Edad inicial");
		edadiCampo.setUuid(generarToken());
		edadiCampo.setComment("edad");
		edadiCampo.setAffects(null);
		edadiCampo.setFilter(null);
		edadiCampo.setEvents("*");
		edadiCampo.setOrigin(null);
		edadiCampo.setValue("");
		
		orden++;
		edadfCampo.setName("edadf");
		edadfCampo.setFieldName("edadf");
		edadfCampo.setCss("form-control");
		edadfCampo.setOrder(orden);
		edadfCampo.setComponentType("texto");
		edadfCampo.setReadOnly(false);
		edadfCampo.setHidden(false);
		edadfCampo.setRequired(true);
		edadfCampo.setShowInBasket(true);
		edadfCampo.setId(false);
		edadfCampo.setSearcheable(true);
		edadfCampo.setValidation(null);
		edadfCampo.setFormat(null);
		edadfCampo.setGroup("header");
		edadfCampo.setLength(2);
		edadfCampo.setDbFieldType("int");
		edadfCampo.setDecimals(0);
		edadfCampo.setPersistible(true);
		edadfCampo.setLabel("Edad final");
		edadfCampo.setUuid(generarToken());
		edadfCampo.setComment("edad");
		edadfCampo.setAffects(null);
		edadfCampo.setFilter(null);
		edadfCampo.setEvents("*");
		edadfCampo.setOrigin(null);
		edadfCampo.setValue("");

		
		
		
		
		orden++;
		supizqCampo.setName("supizq");
		supizqCampo.setFieldName("supizq");
		supizqCampo.setCss("form-control");
		supizqCampo.setOrder(orden);
		supizqCampo.setComponentType("texto");
		supizqCampo.setReadOnly(false);
		supizqCampo.setHidden(false);
		supizqCampo.setRequired(true);
		supizqCampo.setShowInBasket(true);
		supizqCampo.setId(false);
		supizqCampo.setSearcheable(true);
		supizqCampo.setValidation(null);
		supizqCampo.setFormat(null);
		supizqCampo.setGroup("header");
		supizqCampo.setLength(2);
		supizqCampo.setDbFieldType("int");
		supizqCampo.setDecimals(0);
		supizqCampo.setPersistible(true);
		supizqCampo.setLabel("Superior Izquierda");
		supizqCampo.setUuid(generarToken());
		supizqCampo.setComment("Superior izquierda");
		supizqCampo.setAffects(null);
		supizqCampo.setFilter(null);
		supizqCampo.setEvents("*");
		supizqCampo.setOrigin(null);
		supizqCampo.setValue("18");

		orden++;
		supicenCampo.setName("supicen");
		supicenCampo.setFieldName("supicen");
		supicenCampo.setCss("form-control");
		supicenCampo.setOrder(orden);
		supicenCampo.setComponentType("texto");
		supicenCampo.setReadOnly(false);
		supicenCampo.setHidden(false);
		supicenCampo.setRequired(true);
		supicenCampo.setShowInBasket(true);
		supicenCampo.setId(false);
		supicenCampo.setSearcheable(true);
		supicenCampo.setValidation(null);
		supicenCampo.setFormat(null);
		supicenCampo.setGroup("header");
		supicenCampo.setLength(2);
		supicenCampo.setDbFieldType("int");
		supicenCampo.setDecimals(0);
		supicenCampo.setPersistible(true);
		supicenCampo.setLabel("Superior Izquierda Centro");
		supicenCampo.setUuid(generarToken());
		supicenCampo.setComment("Superior Izquierda Centro");
		supicenCampo.setAffects(null);
		supicenCampo.setFilter(null);
		supicenCampo.setEvents("*");
		supicenCampo.setOrigin(null);
		supicenCampo.setValue("11");

		orden++;
		supdcenCampo.setName("supdcen");
		supdcenCampo.setFieldName("supdcen");
		supdcenCampo.setCss("form-control");
		supdcenCampo.setOrder(orden);
		supdcenCampo.setComponentType("texto");
		supdcenCampo.setReadOnly(false);
		supdcenCampo.setHidden(false);
		supdcenCampo.setRequired(true);
		supdcenCampo.setShowInBasket(true);
		supdcenCampo.setId(false);
		supdcenCampo.setSearcheable(true);
		supdcenCampo.setValidation(null);
		supdcenCampo.setFormat(null);
		supdcenCampo.setGroup("header");
		supdcenCampo.setLength(2);
		supdcenCampo.setDbFieldType("int");
		supdcenCampo.setDecimals(0);
		supdcenCampo.setPersistible(true);
		supdcenCampo.setLabel("Superior Derecha Centro");
		supdcenCampo.setUuid(generarToken());
		supdcenCampo.setComment("Superior Derecha Centro");
		supdcenCampo.setAffects(null);
		supdcenCampo.setFilter(null);
		supdcenCampo.setEvents("*");
		supdcenCampo.setOrigin(null);
		supdcenCampo.setValue("21");

		orden++;
		supderCampo.setName("supder");
		supderCampo.setFieldName("supder");
		supderCampo.setCss("form-control");
		supderCampo.setOrder(orden);
		supderCampo.setComponentType("texto");
		supderCampo.setReadOnly(false);
		supderCampo.setHidden(false);
		supderCampo.setRequired(true);
		supderCampo.setShowInBasket(true);
		supderCampo.setId(false);
		supderCampo.setSearcheable(true);
		supderCampo.setValidation(null);
		supderCampo.setFormat(null);
		supderCampo.setGroup("header");
		supderCampo.setLength(2);
		supderCampo.setDbFieldType("int");
		supderCampo.setDecimals(0);
		supderCampo.setPersistible(true);
		supderCampo.setLabel("Superior derecha");
		supderCampo.setUuid(generarToken());
		supderCampo.setComment("Superior derecha");
		supderCampo.setAffects(null);
		supderCampo.setFilter(null);
		supderCampo.setEvents("*");
		supderCampo.setOrigin(null);
		supderCampo.setValue("28");

		orden++;
		infizqCampo.setName("infizq");
		infizqCampo.setFieldName("infizq");
		infizqCampo.setCss("form-control");
		infizqCampo.setOrder(orden);
		infizqCampo.setComponentType("texto");
		infizqCampo.setReadOnly(false);
		infizqCampo.setHidden(false);
		infizqCampo.setRequired(true);
		infizqCampo.setShowInBasket(true);
		infizqCampo.setId(false);
		infizqCampo.setSearcheable(true);
		infizqCampo.setValidation(null);
		infizqCampo.setFormat(null);
		infizqCampo.setGroup("header");
		infizqCampo.setLength(2);
		infizqCampo.setDbFieldType("int");
		infizqCampo.setDecimals(0);
		infizqCampo.setPersistible(true);
		infizqCampo.setLabel("Izquierda inferior");
		infizqCampo.setUuid(generarToken());
		infizqCampo.setComment("Izquierda inferior");
		infizqCampo.setAffects(null);
		infizqCampo.setFilter(null);
		infizqCampo.setEvents("*");
		infizqCampo.setOrigin(null);
		infizqCampo.setValue("48");

		orden++;
		inficenCampo.setName("inficen");
		inficenCampo.setFieldName("inficen");
		inficenCampo.setCss("form-control");
		inficenCampo.setOrder(orden);
		inficenCampo.setComponentType("texto");
		inficenCampo.setReadOnly(false);
		inficenCampo.setHidden(false);
		inficenCampo.setRequired(true);
		inficenCampo.setShowInBasket(true);
		inficenCampo.setId(false);
		inficenCampo.setSearcheable(true);
		inficenCampo.setValidation(null);
		inficenCampo.setFormat(null);
		inficenCampo.setGroup("header");
		inficenCampo.setLength(2);
		inficenCampo.setDbFieldType("int");
		inficenCampo.setDecimals(0);
		inficenCampo.setPersistible(true);
		inficenCampo.setLabel("Inferior Izquierda centro");
		inficenCampo.setUuid(generarToken());
		inficenCampo.setComment("Inferior Izquierda centro");
		inficenCampo.setAffects(null);
		inficenCampo.setFilter(null);
		inficenCampo.setEvents("*");
		inficenCampo.setOrigin(null);
		inficenCampo.setValue("41");

		orden++;
		infdcenCampo.setName("infdcen");
		infdcenCampo.setFieldName("infdcen");
		infdcenCampo.setCss("form-control");
		infdcenCampo.setOrder(orden);
		infdcenCampo.setComponentType("texto");
		infdcenCampo.setReadOnly(false);
		infdcenCampo.setHidden(false);
		infdcenCampo.setRequired(true);
		infdcenCampo.setShowInBasket(true);
		infdcenCampo.setId(false);
		infdcenCampo.setSearcheable(true);
		infdcenCampo.setValidation(null);
		infdcenCampo.setFormat(null);
		infdcenCampo.setGroup("header");
		infdcenCampo.setLength(2);
		infdcenCampo.setDbFieldType("int");
		infdcenCampo.setDecimals(0);
		infdcenCampo.setPersistible(true);
		infdcenCampo.setLabel("Inferior derecha centro");
		infdcenCampo.setUuid(generarToken());
		infdcenCampo.setComment("Inferior derecha centro");
		infdcenCampo.setAffects(null);
		infdcenCampo.setFilter(null);
		infdcenCampo.setEvents("*");
		infdcenCampo.setOrigin(null);
		infdcenCampo.setValue("31");

		orden++;
		infderCampo.setName("infder");
		infderCampo.setFieldName("infder");
		infderCampo.setCss("form-control");
		infderCampo.setOrder(orden);
		infderCampo.setComponentType("texto");
		infderCampo.setReadOnly(false);
		infderCampo.setHidden(false);
		infderCampo.setRequired(true);
		infderCampo.setShowInBasket(true);
		infderCampo.setId(false);
		infderCampo.setSearcheable(true);
		infderCampo.setValidation(null);
		infderCampo.setFormat(null);
		infderCampo.setGroup("header");
		infderCampo.setLength(2);
		infderCampo.setDbFieldType("int");
		infderCampo.setDecimals(0);
		infderCampo.setPersistible(true);
		infderCampo.setLabel("Inferior derecha");
		infderCampo.setUuid(generarToken());
		infderCampo.setComment("Inferior derecha");
		infderCampo.setAffects(null);
		infderCampo.setFilter(null);
		infderCampo.setEvents("*");
		infderCampo.setOrigin(null);
		infderCampo.setValue("38");


		orden++;
		obsCampo.setName("obs");
		obsCampo.setFieldName("obs");
		obsCampo.setCss("form-control");
		obsCampo.setOrder(orden);
		obsCampo.setComponentType("texto");
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
		uuidCampo.setName("uuid");
		uuidCampo.setFieldName("uuid");
		uuidCampo.setCss("form-control");
		uuidCampo.setOrder(orden);
		uuidCampo.setComponentType("texto");
		uuidCampo.setReadOnly(false);
		uuidCampo.setHidden(true);
		uuidCampo.setRequired(true);
		uuidCampo.setShowInBasket(true);
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
		uuideCampo.setReadOnly(false);
		uuideCampo.setHidden(true);
		uuideCampo.setRequired(false);
		uuideCampo.setShowInBasket(true);
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

		//Agregar todos los campos *
		campos.add(codigoCampo);
		campos.add(nombreCampo);
		campos.add(faltaCampo);
		campos.add(statusCampo);
		campos.add(edadiCampo);
		campos.add(edadfCampo);
		
		campos.add(supizqCampo);
		campos.add(supicenCampo);
		campos.add(supdcenCampo);
		campos.add(supderCampo);
		
		campos.add(infizqCampo);
		campos.add(inficenCampo);
		campos.add(infdcenCampo);
		campos.add(infderCampo);
		
		campos.add(obsCampo);
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