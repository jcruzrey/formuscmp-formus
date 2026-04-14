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
public class Dental_expediente extends GenerateCode{

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
		
		String modulo = "medicina"; // modulo *
		String formulario = "expediente"; //nombre del formulario *
		String version = "1.0"; //version
		String idioma = "es_MX"; //version
		
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve(modulo + "_" + formulario + ".json").normalize();
		int orden = 1;
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes(idioma, modulo, formulario, version, 1);

		//Definir todos los campos *
		Field nombresCampo        = new Field();
		Field apaternoCampo       = new Field();
		Field amaternoCampo       = new Field();
		Field curpCampo           = new Field();
		Field rfcCampo            = new Field();
		Field fnacimCampo         = new Field();
		Field celularCampo        = new Field();
		Field telefonoCampo       = new Field();
		Field cemergenciaCampo    = new Field();
		Field sexoCampo           = new Field();
		Field parentescoCampo     = new Field();
		Field tsangreCampo        = new Field();
		Field tipoCampo           = new Field();
		Field codigoCampo         = new Field();
		Field zhorariaCampo       = new Field();
		Field statusCampo         = new Field();
		Field uuidCampo         = new Field();
		Field uuideCampo         = new Field();
		Field uuidpCampo         = new Field();
		
		Resource forma = new Resource();

		//Ajustar *
		forma.setPrefix("dca");
		forma.setCommandName("guardar");
		forma.setName("expediente");
		forma.setView("expediente");
		forma.setTitle("Expediente");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule(modulo);
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("expediente");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion de la caracteristica del diente");
		forma.setUuid(generarToken());
		forma.setComment("Formulario para registrar las caracteristicas");
		forma.setOrigin("ui::case");
		forma.setDestination("db::mysql");
		forma.setUuid(generarToken());
		forma.setPersistible(true);
		forma.setValidate(true);


		orden++;
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
		nombresCampo.setLabel("Nombres");
		nombresCampo.setUuid(generarToken());
		nombresCampo.setComment("nombres");
		nombresCampo.setAffects(null);
		nombresCampo.setFilter(null);
		nombresCampo.setEvents("*");
		nombresCampo.setOrigin(null);
		nombresCampo.setValue("");

		orden++;
		apaternoCampo.setCss("form-control");
		apaternoCampo.setOrder(orden);
		apaternoCampo.setComponentType("texto");
		apaternoCampo.setReadOnly(false);
		apaternoCampo.setHidden(false);
		apaternoCampo.setRequired(true);
		apaternoCampo.setShowInBasket(true);
		apaternoCampo.setId(false);
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
		apaternoCampo.setComment("apaterno");
		apaternoCampo.setAffects(null);
		apaternoCampo.setFilter(null);
		apaternoCampo.setEvents("*");
		apaternoCampo.setOrigin(null);
		apaternoCampo.setValue("");

		orden++;
		amaternoCampo.setCss("form-control");
		amaternoCampo.setOrder(orden);
		amaternoCampo.setComponentType("texto");
		amaternoCampo.setReadOnly(false);
		amaternoCampo.setHidden(false);
		amaternoCampo.setRequired(true);
		amaternoCampo.setShowInBasket(true);
		amaternoCampo.setId(false);
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
		amaternoCampo.setComment("amaterno");
		amaternoCampo.setAffects(null);
		amaternoCampo.setFilter(null);
		amaternoCampo.setEvents("*");
		amaternoCampo.setOrigin(null);
		amaternoCampo.setValue("");

		orden++;
		curpCampo.setCss("form-control");
		curpCampo.setOrder(orden);
		curpCampo.setComponentType("texto");
		curpCampo.setReadOnly(false);
		curpCampo.setHidden(false);
		curpCampo.setRequired(true);
		curpCampo.setShowInBasket(true);
		curpCampo.setId(false);
		curpCampo.setSearcheable(true);
		curpCampo.setValidation(null);
		curpCampo.setFormat(null);
		curpCampo.setGroup("header");
		curpCampo.setLength(18);
		curpCampo.setDbFieldType("varchar");
		curpCampo.setDecimals(0);
		curpCampo.setPersistible(true);
		curpCampo.setLabel("CURP");
		curpCampo.setUuid(generarToken());
		curpCampo.setComment("curp");
		curpCampo.setAffects(null);
		curpCampo.setFilter(null);
		curpCampo.setEvents("*");
		curpCampo.setOrigin(null);
		curpCampo.setValue("");

		orden++;
		rfcCampo.setCss("form-control");
		rfcCampo.setOrder(orden);
		rfcCampo.setComponentType("texto");
		rfcCampo.setReadOnly(false);
		rfcCampo.setHidden(false);
		rfcCampo.setRequired(true);
		rfcCampo.setShowInBasket(true);
		rfcCampo.setId(false);
		rfcCampo.setSearcheable(true);
		rfcCampo.setValidation(null);
		rfcCampo.setFormat(null);
		rfcCampo.setGroup("header");
		rfcCampo.setLength(13);
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
		fnacimCampo.setCss("form-control");
		fnacimCampo.setOrder(orden);
		fnacimCampo.setComponentType("fecha");
		fnacimCampo.setReadOnly(false);
		fnacimCampo.setHidden(false);
		fnacimCampo.setRequired(true);
		fnacimCampo.setShowInBasket(true);
		fnacimCampo.setId(false);
		fnacimCampo.setSearcheable(true);
		fnacimCampo.setValidation(null);
		fnacimCampo.setFormat(null);
		fnacimCampo.setGroup("header");
		fnacimCampo.setLength(0);
		fnacimCampo.setDbFieldType("date");
		fnacimCampo.setDecimals(0);
		fnacimCampo.setPersistible(true);
		fnacimCampo.setLabel("Fecha de nacimiento");
		fnacimCampo.setUuid(generarToken());
		fnacimCampo.setComment("fnacim");
		fnacimCampo.setAffects(null);
		fnacimCampo.setFilter(null);
		fnacimCampo.setEvents("*");
		fnacimCampo.setOrigin(null);
		fnacimCampo.setValue("");

		orden++;
		celularCampo.setCss("form-control");
		celularCampo.setOrder(orden);
		celularCampo.setComponentType("texto");
		celularCampo.setReadOnly(false);
		celularCampo.setHidden(false);
		celularCampo.setRequired(true);
		celularCampo.setShowInBasket(true);
		celularCampo.setId(false);
		celularCampo.setSearcheable(true);
		celularCampo.setValidation(null);
		celularCampo.setFormat(null);
		celularCampo.setGroup("header");
		celularCampo.setLength(30);
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
		telefonoCampo.setCss("form-control");
		telefonoCampo.setOrder(orden);
		telefonoCampo.setComponentType("texto");
		telefonoCampo.setReadOnly(false);
		telefonoCampo.setHidden(false);
		telefonoCampo.setRequired(true);
		telefonoCampo.setShowInBasket(true);
		telefonoCampo.setId(false);
		telefonoCampo.setSearcheable(true);
		telefonoCampo.setValidation(null);
		telefonoCampo.setFormat(null);
		telefonoCampo.setGroup("header");
		telefonoCampo.setLength(30);
		telefonoCampo.setDbFieldType("varchar");
		telefonoCampo.setDecimals(0);
		telefonoCampo.setPersistible(true);
		telefonoCampo.setLabel("Teléfono");
		telefonoCampo.setUuid(generarToken());
		telefonoCampo.setComment("telefono");
		telefonoCampo.setAffects(null);
		telefonoCampo.setFilter(null);
		telefonoCampo.setEvents("*");
		telefonoCampo.setOrigin(null);
		telefonoCampo.setValue("");


		orden++;
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
		cemergenciaCampo.setLength(100);
		cemergenciaCampo.setDbFieldType("varchar");
		cemergenciaCampo.setDecimals(0);
		cemergenciaCampo.setPersistible(true);
		cemergenciaCampo.setLabel("Contacto de emergencia");
		cemergenciaCampo.setUuid(generarToken());
		cemergenciaCampo.setComment("cemergencia");
		cemergenciaCampo.setAffects(null);
		cemergenciaCampo.setFilter(null);
		cemergenciaCampo.setEvents("*");
		cemergenciaCampo.setOrigin(null);
		cemergenciaCampo.setValue("");

		orden++;
		sexoCampo.setCss("form-control");
		sexoCampo.setOrder(orden);
		sexoCampo.setComponentType("texto");
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
		sexoCampo.setOrigin(null);
		sexoCampo.setValue("");
		
		orden++;
		parentescoCampo.setCss("form-control");
		parentescoCampo.setOrder(orden);
		parentescoCampo.setComponentType("texto");
		parentescoCampo.setReadOnly(false);
		parentescoCampo.setHidden(false);
		parentescoCampo.setRequired(false);
		parentescoCampo.setShowInBasket(true);
		parentescoCampo.setId(false);
		parentescoCampo.setSearcheable(true);
		parentescoCampo.setValidation(null);
		parentescoCampo.setFormat(null);
		parentescoCampo.setGroup("header");
		parentescoCampo.setLength(100);
		parentescoCampo.setDbFieldType("varchar");
		parentescoCampo.setDecimals(0);
		parentescoCampo.setPersistible(true);
		parentescoCampo.setLabel("Parentesco");
		parentescoCampo.setUuid(generarToken());
		parentescoCampo.setComment("parentesco");
		parentescoCampo.setAffects(null);
		parentescoCampo.setFilter(null);
		parentescoCampo.setEvents("*");
		parentescoCampo.setOrigin(null);
		parentescoCampo.setValue("");

		orden++;
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
		tsangreCampo.setLabel("Tipo de sangre");
		tsangreCampo.setUuid(generarToken());
		tsangreCampo.setComment("tsangre");
		tsangreCampo.setAffects(null);
		tsangreCampo.setFilter(null);
		tsangreCampo.setEvents("*");
		tsangreCampo.setOrigin(null);
		tsangreCampo.setValue("");

		orden++;
		tipoCampo.setCss("form-control");
		tipoCampo.setOrder(orden);
		tipoCampo.setComponentType("texto");
		tipoCampo.setReadOnly(false);
		tipoCampo.setHidden(false);
		tipoCampo.setRequired(true);
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
		tipoCampo.setComment("tipo");
		tipoCampo.setAffects(null);
		tipoCampo.setFilter(null);
		tipoCampo.setEvents("*");
		tipoCampo.setOrigin(null);
		tipoCampo.setValue("");

		orden++;
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
		codigoCampo.setLength(20);
		codigoCampo.setDbFieldType("varchar");
		codigoCampo.setDecimals(0);
		codigoCampo.setPersistible(true);
		codigoCampo.setLabel("Código");
		codigoCampo.setUuid(generarToken());
		codigoCampo.setComment("codigo");
		codigoCampo.setAffects(null);
		codigoCampo.setFilter(null);
		codigoCampo.setEvents("*");
		codigoCampo.setOrigin(null);
		codigoCampo.setValue("");

		orden++;
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
		zhorariaCampo.setLength(50);
		zhorariaCampo.setDbFieldType("varchar");
		zhorariaCampo.setDecimals(0);
		zhorariaCampo.setPersistible(true);
		zhorariaCampo.setLabel("Zona horaria");
		zhorariaCampo.setUuid(generarToken());
		zhorariaCampo.setComment("zhoraria");
		zhorariaCampo.setAffects(null);
		zhorariaCampo.setFilter(null);
		zhorariaCampo.setEvents("*");
		zhorariaCampo.setOrigin(null);
		zhorariaCampo.setValue("");

		orden++;
		statusCampo.setCss("form-control");
		statusCampo.setOrder(orden);
		statusCampo.setComponentType("status");
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
		statusCampo.setOrigin(null);
		statusCampo.setValue("");

		orden++;
		uuidCampo.setCss("form-control");
		uuidCampo.setOrder(orden);
		uuidCampo.setComponentType("texto");
		uuidCampo.setReadOnly(false);
		uuidCampo.setHidden(false);
		uuidCampo.setRequired(false);
		uuidCampo.setShowInBasket(false);
		uuidCampo.setId(false);
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
		uuidCampo.setValue("");

		orden++;
		uuidpCampo.setCss("form-control");
		uuidpCampo.setOrder(orden);
		uuidpCampo.setComponentType("texto");
		uuidpCampo.setReadOnly(false);
		uuidpCampo.setHidden(false);
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
		uuideCampo.setCss("form-control");
		uuideCampo.setOrder(orden);
		uuideCampo.setComponentType("texto");
		uuideCampo.setReadOnly(false);
		uuideCampo.setHidden(false);
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
		campos.add(nombresCampo);
		campos.add(apaternoCampo);
		campos.add(amaternoCampo);
		campos.add(curpCampo);
		campos.add(rfcCampo);
		campos.add(fnacimCampo);
		campos.add(celularCampo);
		campos.add(telefonoCampo);
		campos.add(cemergenciaCampo);
		campos.add(sexoCampo);
		campos.add(parentescoCampo);
		campos.add(tsangreCampo);
		campos.add(tipoCampo);
		campos.add(codigoCampo);
		campos.add(zhorariaCampo);
		campos.add(statusCampo);
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