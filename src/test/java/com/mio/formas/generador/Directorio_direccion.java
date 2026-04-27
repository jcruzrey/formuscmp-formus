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
public class Directorio_direccion extends GenerateCode{
	private final String CREADO_POR="formuscmp";
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
			buttonGuardar.setInstruction("Direccion guardada correctamente");
			buttonGuardar.setLabel("Guardar");
			buttonGuardar.setModule(modulo);
			buttonGuardar.setName("guardar");
			buttonGuardar.setOrder(1);
			buttonGuardar.setResourceName(recurso);
			buttonGuardar.setResourceType("form");
			buttonGuardar.setUuid(generarToken());
			buttonGuardar.setVersion(version);
			buttonGuardar.setTarget("#tab_block_1");
			buttonGuardar.setSwap("innerHTML");
			metodos.add(buttonGuardar);
			
			Button buttonActualizar = new Button();
			buttonActualizar.setCommandName("actualizar");
			buttonActualizar.setComment("Boton actualizar");
			buttonActualizar.setComponentType("botonjs");
			buttonActualizar.setCss("btn btn-danger");
			buttonActualizar.setEvents("guardar,actualizar,detalle");
			buttonActualizar.setInstruction("Direccion actualizada correctamente");
			buttonActualizar.setLabel("Actualizar");
			buttonActualizar.setModule(modulo);
			buttonActualizar.setName("actualizar");
			buttonActualizar.setOrder(2);
			buttonActualizar.setResourceName(recurso);
			buttonActualizar.setResourceType("form");
			buttonActualizar.setUuid(generarToken());
			buttonActualizar.setVersion(version);
			buttonActualizar.setTarget("#tab_block_1");
			buttonActualizar.setSwap("innerHTML");
			metodos.add(buttonActualizar);
		}else {
			Button buttonGuardar = new Button();
			buttonGuardar.setCommandName("save");
			buttonGuardar.setComment("save button");
			buttonGuardar.setComponentType("buttonjs");
			buttonGuardar.setCss("btn btn-primary");
			buttonGuardar.setEvents("new");
			buttonGuardar.setInstruction("File saved correctly");
			buttonGuardar.setLabel("Save");
			buttonGuardar.setModule(modulo);
			buttonGuardar.setName("save");
			buttonGuardar.setOrder(1);
			buttonGuardar.setResourceName(recurso);
			buttonGuardar.setResourceType("form");
			buttonGuardar.setUuid(generarToken());
			buttonGuardar.setVersion(version);
			buttonGuardar.setTarget("#tab_block_1");
			buttonGuardar.setSwap("outerHTML");
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
			buttonActualizar.setTarget("#tab_block_1");
			buttonActualizar.setSwap("outerHTML");
			metodos.add(buttonActualizar);
		}
		
		return metodos;
	}

	/**
	 * Test method for
	 * {@link com.formuscmp.formus.generator.Generador#guatdarForma(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testNuevo() throws IOException {
		
		String modulo = "directorio"; // modulo *
		String formulario = "direccion"; //nombre del formulario *
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
		Field grupoCampo       = new Field();
		Field noExtCampo       = new Field();
		Field calleCampo       = new Field();
		Field ciudadCampo       = new Field();
		Field estadoCampo       = new Field();
		Field cpostalCampo       = new Field();
		Field linea2Campo       = new Field();

		Field uuidCampo            = new Field();
		Field uuideCampo           = new Field();
		Field uuidpCampo           = new Field();
		Resource forma = new Resource();

		//Ajustar *
		forma.setPrefix("DID");
		forma.setCommandName("guardar");
		forma.setName("direccion");
		forma.setView("basket");
		forma.setTitle("direccion");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule(modulo);
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("direccion");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion");
		forma.setUuid(generarToken());
		forma.setComment("Formulario de direccion");
		forma.setOrigin("ui::case");
		forma.setDestination("db::mysql");
		forma.setUuid(generarToken());
		forma.setPersistible(true);
		forma.setValidate(true);
		forma.setCreatedBy(CREADO_POR);
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
		codigoCampo.setComment("Codigo");
		codigoCampo.setAffects(null);
		codigoCampo.setFilter(null);
		codigoCampo.setEvents("*");
		codigoCampo.setOrigin(null);
		codigoCampo.setValue("");
		
		orden++;
		grupoCampo.setName("grupo");
		grupoCampo.setFieldName("grupo");
		grupoCampo.setCss("form-control");
		grupoCampo.setOrder(orden);
		grupoCampo.setComponentType("lista");
		grupoCampo.setReadOnly(false);
		grupoCampo.setHidden(false);
		grupoCampo.setRequired(false);
		grupoCampo.setShowInBasket(true);
		grupoCampo.setId(false);
		grupoCampo.setSearcheable(true);
		grupoCampo.setValidation(null);
		grupoCampo.setFormat(null);
		grupoCampo.setGroup("header");
		grupoCampo.setLength(20);
		grupoCampo.setDbFieldType("varchar");
		grupoCampo.setDecimals(0);
		grupoCampo.setPersistible(true);
		grupoCampo.setLabel("A donde pertence la direccion");
		grupoCampo.setUuid(generarToken());
		grupoCampo.setComment("grupo");
		grupoCampo.setAffects(null);
		grupoCampo.setFilter(null);
		grupoCampo.setEvents("*");
		grupoCampo.setOrigin("{\"origin\":\"recurso\",\"resource\":\"inlinevalues\",\"fields\":[{\"name\":\"Hogar,Envio,Facturación\"}]}");
		grupoCampo.setValue("");
		
		orden++;
		noExtCampo.setName("noext");
		noExtCampo.setFieldName("noext");
		noExtCampo.setCss("form-control");
		noExtCampo.setOrder(orden);
		noExtCampo.setComponentType("texto");
		noExtCampo.setReadOnly(false);
		noExtCampo.setHidden(false);
		noExtCampo.setRequired(false);
		noExtCampo.setShowInBasket(true);
		noExtCampo.setId(false);
		noExtCampo.setSearcheable(true);
		noExtCampo.setValidation(null);
		noExtCampo.setFormat(null);
		noExtCampo.setGroup("header");
		noExtCampo.setLength(50);
		noExtCampo.setDbFieldType("varchar");
		noExtCampo.setDecimals(0);
		noExtCampo.setPersistible(true);
		noExtCampo.setLabel("No ext");
		noExtCampo.setUuid(generarToken());
		noExtCampo.setComment("no ext");
		noExtCampo.setAffects(null);
		noExtCampo.setFilter(null);
		noExtCampo.setEvents("*");
		noExtCampo.setOrigin(null);
		noExtCampo.setValue("");
		
		orden++;
		calleCampo.setName("calle");
		calleCampo.setFieldName("calle");
		calleCampo.setCss("form-control");
		calleCampo.setOrder(orden);
		calleCampo.setComponentType("texto");
		calleCampo.setReadOnly(false);
		calleCampo.setHidden(false);
		calleCampo.setRequired(false);
		calleCampo.setShowInBasket(true);
		calleCampo.setId(false);
		calleCampo.setSearcheable(true);
		calleCampo.setValidation(null);
		calleCampo.setFormat(null);
		calleCampo.setGroup("header");
		calleCampo.setLength(150);
		calleCampo.setDbFieldType("varchar");
		calleCampo.setDecimals(0);
		calleCampo.setPersistible(true);
		calleCampo.setLabel("Calle");
		calleCampo.setUuid(generarToken());
		calleCampo.setComment("Calle");
		calleCampo.setAffects(null);
		calleCampo.setFilter(null);
		calleCampo.setEvents("*");
		calleCampo.setOrigin(null);
		calleCampo.setValue("");
		
		orden++;
		linea2Campo.setName("linea2");
		linea2Campo.setFieldName("linea2");
		linea2Campo.setCss("form-control");
		linea2Campo.setOrder(orden);
		linea2Campo.setComponentType("texto");
		linea2Campo.setReadOnly(false);
		linea2Campo.setHidden(false);
		linea2Campo.setRequired(false);
		linea2Campo.setShowInBasket(true);
		linea2Campo.setId(false);
		linea2Campo.setSearcheable(true);
		linea2Campo.setValidation(null);
		linea2Campo.setFormat(null);
		linea2Campo.setGroup("header");
		linea2Campo.setLength(20);
		linea2Campo.setDbFieldType("varchar");
		linea2Campo.setDecimals(0);
		linea2Campo.setPersistible(true);
		linea2Campo.setLabel("Linea 2 de direccion (Opcional)");
		linea2Campo.setUuid(generarToken());
		linea2Campo.setComment("no ext");
		linea2Campo.setAffects(null);
		linea2Campo.setFilter(null);
		linea2Campo.setEvents("*");
		linea2Campo.setOrigin(null);
		linea2Campo.setValue("");
		
		orden++;
		ciudadCampo.setName("ciudad");
		ciudadCampo.setFieldName("ciudad");
		ciudadCampo.setCss("form-control");
		ciudadCampo.setOrder(orden);
		ciudadCampo.setComponentType("texto");
		ciudadCampo.setReadOnly(false);
		ciudadCampo.setHidden(false);
		ciudadCampo.setRequired(false);
		ciudadCampo.setShowInBasket(true);
		ciudadCampo.setId(false);
		ciudadCampo.setSearcheable(true);
		ciudadCampo.setValidation(null);
		ciudadCampo.setFormat(null);
		ciudadCampo.setGroup("header");
		ciudadCampo.setLength(150);
		ciudadCampo.setDbFieldType("varchar");
		ciudadCampo.setDecimals(0);
		ciudadCampo.setPersistible(true);
		ciudadCampo.setLabel("Ciudad");
		ciudadCampo.setUuid(generarToken());
		ciudadCampo.setComment("no ext");
		ciudadCampo.setAffects(null);
		ciudadCampo.setFilter(null);
		ciudadCampo.setEvents("*");
		ciudadCampo.setOrigin(null);
		ciudadCampo.setValue("");
		
		orden++;
		estadoCampo.setName("estado");
		estadoCampo.setFieldName("estado");
		estadoCampo.setCss("form-control");
		estadoCampo.setOrder(orden);
		estadoCampo.setComponentType("texto");
		estadoCampo.setReadOnly(false);
		estadoCampo.setHidden(false);
		estadoCampo.setRequired(false);
		estadoCampo.setShowInBasket(true);
		estadoCampo.setId(false);
		estadoCampo.setSearcheable(true);
		estadoCampo.setValidation(null);
		estadoCampo.setFormat(null);
		estadoCampo.setGroup("header");
		estadoCampo.setLength(150);
		estadoCampo.setDbFieldType("varchar");
		estadoCampo.setDecimals(0);
		estadoCampo.setPersistible(true);
		estadoCampo.setLabel("Estado");
		estadoCampo.setUuid(generarToken());
		estadoCampo.setComment("no ext");
		estadoCampo.setAffects(null);
		estadoCampo.setFilter(null);
		estadoCampo.setEvents("*");
		estadoCampo.setOrigin(null);
		estadoCampo.setValue("");
		
		orden++;
		cpostalCampo.setName("cpostal");
		cpostalCampo.setFieldName("cpostal");
		cpostalCampo.setCss("form-control");
		cpostalCampo.setOrder(orden);
		cpostalCampo.setComponentType("texto");
		cpostalCampo.setReadOnly(false);
		cpostalCampo.setHidden(false);
		cpostalCampo.setRequired(false);
		cpostalCampo.setShowInBasket(true);
		cpostalCampo.setId(false);
		cpostalCampo.setSearcheable(true);
		cpostalCampo.setValidation(null);
		cpostalCampo.setFormat(null);
		cpostalCampo.setGroup("header");
		cpostalCampo.setLength(20);
		cpostalCampo.setDbFieldType("varchar");
		cpostalCampo.setDecimals(0);
		cpostalCampo.setPersistible(true);
		cpostalCampo.setLabel("C. Postal");
		cpostalCampo.setUuid(generarToken());
		cpostalCampo.setComment("C. Postal");
		cpostalCampo.setAffects(null);
		cpostalCampo.setFilter(null);
		cpostalCampo.setEvents("*");
		cpostalCampo.setOrigin(null);
		cpostalCampo.setValue("");
		
		orden++;
		uuidCampo.setName("uuid");
		uuidCampo.setFieldName("uuid");
		uuidCampo.setCss("form-control");
		uuidCampo.setOrder(orden);
		uuidCampo.setComponentType("texto");
		uuidCampo.setReadOnly(true);
		uuidCampo.setHidden(true);
		uuidCampo.setRequired(true);
		uuidCampo.setShowInBasket(true);
		uuidCampo.setId(true);
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
		uuidpCampo.setComponentType("sucursal");
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
		uuidpCampo.setLabel("Directorio");
		uuidpCampo.setUuid(generarToken());
		uuidpCampo.setComment("uuidp");
		uuidpCampo.setAffects(null);
		uuidpCampo.setFilter(null);
		uuidpCampo.setEvents("*");
		uuidpCampo.setOrigin("{\"origin\":\"tabla\",\"resource\":\"dircto\",\"fields\":[{\"name\":\"uuid\", \"filter\":\"\"},{\"name\":\"codigo\", \"filter\":\"\"},{\"name\":\"nombre\", \"filter\":\"\"},{\"name\":\"tipo\", \"filter\":\"\"}]}");		
		uuidpCampo.setValue("");

		//Agregar todos los campos *
		campos.add(codigoCampo);
		campos.add(calleCampo);
		campos.add(grupoCampo);
		campos.add(noExtCampo);
		campos.add(ciudadCampo);
		campos.add(estadoCampo);
		campos.add(cpostalCampo);
		campos.add(linea2Campo);
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