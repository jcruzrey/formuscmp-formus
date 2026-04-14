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
public class Dental_tratamiento extends GenerateCode {

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
		String formulario = "tratamiento"; // nombre del formulario *
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
		Field descriptorCampo = new Field();
		Field precioCampo = new Field();
		Field uuidCampo = new Field();
		Field uuideCampo = new Field();
		Field uuidpCampo = new Field();

		Resource forma = new Resource();

		// Ajustar *
		forma.setPrefix("TMO");
		forma.setCommandName("guardar");
		forma.setName("tratamiento");
		forma.setView("tratamiento");
		forma.setTitle("Tratamiento");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule(modulo);
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("tratamiento");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion de tratamiento del diente");
		forma.setUuid(generarToken());
		forma.setComment("Formulario para registrar los tratamientos");
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
		descriptorCampo.setName("descripcion");
		descriptorCampo.setFieldName("descripcion");
		descriptorCampo.setCss("form-control");
		descriptorCampo.setOrder(orden);
		descriptorCampo.setComponentType("texto");
		descriptorCampo.setReadOnly(false);
		descriptorCampo.setHidden(false);
		descriptorCampo.setRequired(true);
		descriptorCampo.setShowInBasket(true);
		descriptorCampo.setId(false);
		descriptorCampo.setSearcheable(true);
		descriptorCampo.setValidation(null);
		descriptorCampo.setFormat(null);
		descriptorCampo.setGroup("header");
		descriptorCampo.setLength(200);
		descriptorCampo.setDbFieldType("varchar");
		descriptorCampo.setDecimals(0);
		descriptorCampo.setPersistible(true);
		descriptorCampo.setLabel("Descripcion");
		descriptorCampo.setUuid(generarToken());
		descriptorCampo.setComment("Descripcion");
		descriptorCampo.setAffects(null);
		descriptorCampo.setFilter(null);
		descriptorCampo.setEvents("*");
		descriptorCampo.setOrigin(null);
		descriptorCampo.setValue("");

		orden++;		
		precioCampo.setName("precio");
		precioCampo.setFieldName("precio");
		precioCampo.setCss("form-control");
		precioCampo.setOrder(orden);
		precioCampo.setComponentType("texto");
		precioCampo.setReadOnly(false);
		precioCampo.setHidden(false);
		precioCampo.setRequired(true);
		precioCampo.setShowInBasket(true);
		precioCampo.setId(false);
		precioCampo.setSearcheable(true);
		precioCampo.setValidation("^[0-9]*\\.[0-9]{2}$");
		precioCampo.setFormat("$###,###,###.00");
		precioCampo.setGroup("header");
		precioCampo.setLength(9);
		precioCampo.setDbFieldType("decimal");
		precioCampo.setDecimals(2);
		precioCampo.setPersistible(true);
		precioCampo.setLabel("Precio del tratamiento");
		precioCampo.setUuid(generarToken());
		precioCampo.setComment("tiempo");
		precioCampo.setAffects(null);
		precioCampo.setFilter(null);
		precioCampo.setEvents("*");
		precioCampo.setOrigin(null);
		precioCampo.setValue("");
		
		orden++;
		uuidCampo.setName("uuid");
		uuidCampo.setFieldName("uuid");
		uuidCampo.setCss("form-control");
		uuidCampo.setOrder(orden);
		uuidCampo.setComponentType("texto");
		uuidCampo.setReadOnly(false);
		uuidCampo.setHidden(true);
		uuidCampo.setRequired(true);
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
		uuidpCampo.setReadOnly(true);
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

		// Agregar todos los campos *
		campos.add(codigoCampo);
		campos.add(nombreCampo);
		campos.add(descriptorCampo);
		campos.add(precioCampo);
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