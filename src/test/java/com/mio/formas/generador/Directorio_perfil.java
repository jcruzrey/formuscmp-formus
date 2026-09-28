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
public class Directorio_perfil extends GenerateCode{
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
		String formulario = "perfil"; //nombre del formulario *
		String version = "1.0"; //version
		String idioma = "es_MX"; //version
		
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve(modulo + "_" + formulario + ".json").normalize();
		int orden = 1;
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes(idioma, modulo, formulario, version, 1);

		//Definir todos los campos *
		Field codigoCampo   = new Field();
		Field tipoCampo   = new Field();
        Field rolCampo       = new Field();
        //Field urlCampo       = new Field();
        Field uuidCampo      = new Field();
        Field uuidpCampo     = new Field();
        Field uuideCampo     = new Field();

		
		Resource forma = new Resource();

		//Ajustar *
		forma.setPrefix("PRF");
		forma.setCommandName("guardar");
		forma.setName("perfil");
		forma.setView("perfil");
		forma.setTitle("Perfil");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule(modulo);
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("perfil");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion del perfil");
		forma.setUuid(generarToken());
		forma.setComment("Formulario para perfil de roles");
		forma.setOrigin("ui::case");
		forma.setDestination("db::mysql");
		forma.setUuid(generarToken());
		forma.setPersistible(true);
		forma.setValidate(true);
		forma.setLastModificationDate(new java.util.Date().getTime());

		/*usuarioCampo.setName("usuario");
		usuarioCampo.setFieldName("usuario");
		usuarioCampo.setCss("form-control");
        usuarioCampo.setOrder(orden);
        usuarioCampo.setComponentType("texto");
        usuarioCampo.setReadOnly(false);
        usuarioCampo.setHidden(false);
        usuarioCampo.setRequired(true);
        usuarioCampo.setShowInBasket(true);
        usuarioCampo.setId(true);
        usuarioCampo.setSearcheable(true);
        usuarioCampo.setValidation(null);
        usuarioCampo.setFormat(null);
        usuarioCampo.setGroup("header");
        usuarioCampo.setLength(20);
        usuarioCampo.setDbFieldType("varchar");
        usuarioCampo.setDecimals(0);
        usuarioCampo.setPersistible(true);
        usuarioCampo.setLabel("Usuario");
        usuarioCampo.setUuid(generarToken());
        usuarioCampo.setComment("usuario");
        usuarioCampo.setAffects(null);
        usuarioCampo.setFilter(null);
        usuarioCampo.setEvents("*");
        usuarioCampo.setOrigin(null);
        usuarioCampo.setValue("");*/
		
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
		tipoCampo.setValue("perfil");
		
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
		codigoCampo.setLength(60);
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
        rolCampo.setName("nombre");
		rolCampo.setFieldName("nombre");
        rolCampo.setCss("form-control");
        rolCampo.setOrder(orden);
        rolCampo.setComponentType("texto");
        rolCampo.setReadOnly(false);
        rolCampo.setHidden(false);
        rolCampo.setRequired(true);
        rolCampo.setShowInBasket(true);
        rolCampo.setId(false);
        rolCampo.setSearcheable(true);
        rolCampo.setValidation(null);
        rolCampo.setFormat(null);
        rolCampo.setGroup("header");
        rolCampo.setLength(50);
        rolCampo.setDbFieldType("varchar");
        rolCampo.setDecimals(0);
        rolCampo.setPersistible(true);
        rolCampo.setLabel("Nombre");
        rolCampo.setUuid(generarToken());
        rolCampo.setComment("rol");
        rolCampo.setAffects(null);
        rolCampo.setFilter(null);
        rolCampo.setEvents("*");
        rolCampo.setOrigin(null);
        rolCampo.setValue("");

		
		/*orden++;
		urlCampo.setName("uri");
		urlCampo.setFieldName("uri");
		urlCampo.setCss("form-control");
        urlCampo.setOrder(orden);
        urlCampo.setComponentType("texto");
        urlCampo.setReadOnly(false);
        urlCampo.setHidden(false);
        urlCampo.setRequired(false);
        urlCampo.setShowInBasket(true);
        urlCampo.setId(false);
        urlCampo.setSearcheable(true);
        urlCampo.setValidation(null);
        urlCampo.setFormat(null);
        urlCampo.setGroup("header");
        urlCampo.setLength(150);
        urlCampo.setDbFieldType("varchar");
        urlCampo.setDecimals(0);
        urlCampo.setPersistible(true);
        urlCampo.setLabel("Uri");
        urlCampo.setUuid(generarToken());
        urlCampo.setComment("Uri");
        urlCampo.setAffects(null);
        urlCampo.setFilter(null);
        urlCampo.setEvents("*");
        urlCampo.setOrigin(null);
        urlCampo.setValue("");*/
		

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
		campos.add(codigoCampo);
		campos.add(tipoCampo);
        campos.add(rolCampo);
   //     campos.add(urlCampo);
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