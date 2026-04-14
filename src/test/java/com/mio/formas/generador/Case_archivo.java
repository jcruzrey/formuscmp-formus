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
public class Case_archivo extends GenerateCode{

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
			buttonGuardar.setCommandName("importar");
			buttonGuardar.setComment("Boton importar");
			buttonGuardar.setComponentType("botonjs");
			buttonGuardar.setCss("btn btn-primary");
			buttonGuardar.setEvents("nuevo");
			buttonGuardar.setInstruction("Archivo importado correctamente");
			buttonGuardar.setLabel("Importar");
			buttonGuardar.setModule(modulo);
			buttonGuardar.setName("importar");
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
			buttonGuardar.setCommandName("import");
			buttonGuardar.setComment("import button");
			buttonGuardar.setComponentType("buttonjs");
			buttonGuardar.setCss("btn btn-primary");
			buttonGuardar.setEvents("new");
			buttonGuardar.setInstruction("File imported correctly");
			buttonGuardar.setLabel("Import");
			buttonGuardar.setModule(modulo);
			buttonGuardar.setName("import");
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
		
		String modulo = "case"; // modulo *
		String formulario = "archivo"; //nombre del formulario *
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
		forma.setPrefix("ARC");
		forma.setCommandName("guardar");
		forma.setName("archivo");
		forma.setView("archivo");
		forma.setTitle("Archivo");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule(modulo);
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("archivo");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion del archivo");
		forma.setUuid(generarToken());
		forma.setComment("Formulario de archivo");
		forma.setOrigin("ui::case");
		forma.setDestination("db::mysql");
		forma.setUuid(generarToken());
		forma.setPersistible(false);
		forma.setValidate(true);
		forma.setLastModificationDate(new java.util.Date().getTime());

		archivoCampo.setName("archivo");
		archivoCampo.setFieldName("archivo");
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
		archivoCampo.setLabel("Archivo");
		archivoCampo.setUuid(generarToken());
		archivoCampo.setComment("Archivo");
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