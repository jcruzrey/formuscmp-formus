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
public class Directorio_rol extends GenerateCode{

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
		
		String modulo = "directorio"; // modulo *
		String formulario = "rol"; //nombre del formulario *
		String version = "1.0"; //version
		String idioma = "es_MX"; //version
		
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve(modulo + "_" + formulario + ".json").normalize();
		int orden = 1;
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes(idioma, modulo, formulario, version, 1);

		//Definir todos los campos *
	Field nombreCampo        = new Field();
        Field descripcionCampo   = new Field();
        Field tipoCampo   = new Field();
        Field statusCampo        = new Field();
        Field perfilCampo           = new Field();
        Field uuidCampo          = new Field();
        Field uuidpCampo         = new Field();
        Field uuideCampo         = new Field();

		
		Resource forma = new Resource();

		//Ajustar *
		forma.setPrefix("ROL");
		forma.setCommandName("guardar");
		forma.setName("rol");
		forma.setView("rol");
		forma.setTitle("Rol");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule(modulo);
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("rol");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la información");
		forma.setUuid(generarToken());
		forma.setComment("Formulario para registrar información");
		forma.setOrigin("ui::case");
		forma.setDestination("db::mysql");
		forma.setUuid(generarToken());
		forma.setPersistible(true);
		forma.setValidate(true);
		forma.setLastModificationDate(new java.util.Date().getTime());

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
		nombreCampo.setLength(50);
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
        descripcionCampo.setName("descripcion");
		descripcionCampo.setFieldName("descripcion");
        descripcionCampo.setCss("form-control");
        descripcionCampo.setOrder(orden);
        descripcionCampo.setComponentType("texto");
        descripcionCampo.setReadOnly(false);
        descripcionCampo.setHidden(false);
        descripcionCampo.setRequired(false);
        descripcionCampo.setShowInBasket(true);
        descripcionCampo.setId(false);
        descripcionCampo.setSearcheable(true);
        descripcionCampo.setValidation(null);
        descripcionCampo.setFormat(null);
        descripcionCampo.setGroup("header");
        descripcionCampo.setLength(150);
        descripcionCampo.setDbFieldType("varchar");
        descripcionCampo.setDecimals(0);
        descripcionCampo.setPersistible(true);
        descripcionCampo.setLabel("Descripción");
        descripcionCampo.setUuid(generarToken());
        descripcionCampo.setComment("descripcion");
        descripcionCampo.setAffects(null);
        descripcionCampo.setFilter(null);
        descripcionCampo.setEvents("*");
        descripcionCampo.setOrigin(null);
        descripcionCampo.setValue("");

        orden++;
		tipoCampo.setName("tipo");
		tipoCampo.setFieldName("tipo");
		tipoCampo.setCss("form-control");
		tipoCampo.setOrder(orden);
		tipoCampo.setComponentType("texto");
		tipoCampo.setReadOnly(true);
		tipoCampo.setHidden(true);
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
		tipoCampo.setValue("rol");

        orden++;
        statusCampo.setName("status");
		statusCampo.setFieldName("status");
		statusCampo.setCss("form-control");
        statusCampo.setOrder(orden);
        statusCampo.setComponentType("texto");
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
		perfilCampo.setName("perfil");
		perfilCampo.setFieldName("perfil");
		perfilCampo.setCss("form-control");
        perfilCampo.setOrder(orden);
        perfilCampo.setComponentType("texto");
        perfilCampo.setReadOnly(false);
        perfilCampo.setHidden(false);
        perfilCampo.setRequired(false);
        perfilCampo.setShowInBasket(true);
        perfilCampo.setId(false);
        perfilCampo.setSearcheable(true);
        perfilCampo.setValidation(null);
        perfilCampo.setFormat(null);
        perfilCampo.setGroup("header");
        perfilCampo.setLength(150);
        perfilCampo.setDbFieldType("varchar");
        perfilCampo.setDecimals(0);
        perfilCampo.setPersistible(true);
        perfilCampo.setLabel("Perfil");
        perfilCampo.setUuid(generarToken());
        perfilCampo.setComment("perfil");
        perfilCampo.setAffects(null);
        perfilCampo.setFilter(null);
        perfilCampo.setEvents("*");
        perfilCampo.setOrigin(null);
        perfilCampo.setValue("");
		
		

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

		//Agregar todos los campos *
		campos.add(nombreCampo);
        campos.add(descripcionCampo);
        campos.add(tipoCampo);
        campos.add(statusCampo);
        campos.add(perfilCampo);
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