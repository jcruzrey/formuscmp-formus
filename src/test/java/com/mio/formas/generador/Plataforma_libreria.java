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
public class Plataforma_libreria extends GenerateCode{
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
			buttonGuardar.setInstruction("Archivo guardado correctamente");
			buttonGuardar.setLabel("Guardar");
			buttonGuardar.setModule(modulo);
			buttonGuardar.setName("guardar");
			buttonGuardar.setOrder(1);
			buttonGuardar.setResourceName(recurso);
			buttonGuardar.setResourceType("form");
			buttonGuardar.setUuid(generarToken());
			buttonGuardar.setVersion(version);
			buttonGuardar.setTarget(".hk-pg-wrapper");
			buttonGuardar.setSwap("innerHTML");
			metodos.add(buttonGuardar);
			
			
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
			buttonGuardar.setTarget(".hk-pg-wrapper");
			buttonGuardar.setSwap("outerHTML");
			metodos.add(buttonGuardar);
			
			
		}
		
		return metodos;
	}

	/**
	 * Test method for
	 * {@link com.formuscmp.formus.generator.Generador#guatdarForma(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testNuevo() throws IOException {
		
		String modulo = "plataforma"; // modulo *
		String formulario = "libreria"; //nombre del formulario *
		String version = "1.0"; //version
		String idioma = "es_MX"; //version
		
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve(modulo + "_" + formulario + ".json").normalize();
		int orden = 1;
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes(idioma, modulo, formulario, version, 1);

		//Definir todos los campos *
		Field archivoCampo       = new Field();
		
		
		Resource forma = new Resource();

		//Ajustar *
		forma.setPrefix("ALI");
		forma.setCommandName("guardar");
		forma.setName("libreria");
		forma.setView("libreria");
		forma.setTitle("Libreria");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule(modulo);
		forma.setBasket("libreria");
		forma.setCreateable(true);
		forma.setTable("libreria");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion");
		forma.setUuid(generarToken());
		forma.setComment("Formulario de libreria");
		forma.setOrigin("ui::case");
		forma.setDestination("fs::config");
		forma.setUuid(generarToken());
		forma.setPersistible(false);
		forma.setValidate(true);
		forma.setCreatedBy(CREADO_POR);
		forma.setLastModificationDate(new java.util.Date().getTime());

		archivoCampo.setName("libreria");
		archivoCampo.setFieldName("libreria");
		archivoCampo.setCss("form-control");
		archivoCampo.setOrder(orden);
		archivoCampo.setComponentType("texto");
		archivoCampo.setReadOnly(false);
		archivoCampo.setHidden(false);
		archivoCampo.setRequired(true);
		archivoCampo.setShowInBasket(false);
		archivoCampo.setId(false);
		archivoCampo.setSearcheable(false);
		archivoCampo.setValidation(null);
		archivoCampo.setFormat(null);
		archivoCampo.setGroup("header");
		archivoCampo.setLength(150);
		archivoCampo.setDbFieldType("varchar");
		archivoCampo.setDecimals(0);
		archivoCampo.setPersistible(true);
		archivoCampo.setLabel("Libreria");
		archivoCampo.setUuid(generarToken());
		archivoCampo.setComment("Libreria");
		archivoCampo.setAffects(null);
		archivoCampo.setFilter(null);
		archivoCampo.setEvents("*");
		archivoCampo.setOrigin(null);
		archivoCampo.setValue("");

		//Agregar todos los campos *
		campos.add(archivoCampo);
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