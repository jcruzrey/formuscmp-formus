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
public class GeneradorHtmlImportarTest {

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

		if (idioma.equals("es_MX")) {
			Button buttonGuardar = new Button();
			buttonGuardar.setCommandName("importar");
			buttonGuardar.setComment("Boton guardar");
			buttonGuardar.setComponentType("botonjs");
			buttonGuardar.setCss("btn btn-primary");
			buttonGuardar.setEvents("nuevo");
			buttonGuardar.setInstruction("Formulario guardado correctamente");
			buttonGuardar.setLabel("Iniciar importacion");
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

	@Test
	public void testNuevoCSV() throws IOException {
	int orden = 1;
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve("csv.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes("es_MX", "integracion", "csv", "1.0", 1);

		Field codigoCampo = new Field();
		Field pacienteCampo = new Field();
		Field companyCampo = new Field();
		Field faltaCampo = new Field();
		Field nombreCampo = new Field();
		Field archivoCampo = new Field();
		Field tablaCampo = new Field();
		Field borraCampo = new Field();
		Field uuidCampo = new Field();
		
		Resource forma = new Resource();

		forma.setPrefix("CSV");
		forma.setCommandName("guardar");
		forma.setName("csv");
		forma.setView("csv");
		forma.setTitle("Importar CSV");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("integracion");
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("csv");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion");
		forma.setUuid(generarToken());
		forma.setComment("Formulario para importar un formulario");

		codigoCampo.setName("Codigo");
		codigoCampo.setFieldName("codigo");
		codigoCampo.setCss("form-control");
		codigoCampo.setOrder(orden);
		codigoCampo.setLength(30);
		codigoCampo.setComponentType("texto");
		codigoCampo.setReadOnly(true);
		codigoCampo.setHidden(false);
		codigoCampo.setRequired(false);
		codigoCampo.setShowInBasket(true);
		codigoCampo.setId(true);
		codigoCampo.setDecimals(0);
		codigoCampo.setDbFieldType("varchar");
		codigoCampo.setLabel("Codigo (Auto)");
		codigoCampo.setUuid(generarToken());
		codigoCampo.setComment("Campo codigo");
		codigoCampo.setEvents("*");
		
		orden ++;
		faltaCampo.setName("falta");
		faltaCampo.setFieldName("falta");
		faltaCampo.setCss("form-control");
		faltaCampo.setOrder(orden);
		faltaCampo.setComponentType("fecha");
		faltaCampo.setReadOnly(true);
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
		faltaCampo.setValue("${default::todayShort}");
		faltaCampo.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		
		orden ++;
		nombreCampo.setName("nombre");
		nombreCampo.setFieldName("nombre");
		nombreCampo.setCss("form-control");
		nombreCampo.setOrder(orden);
		nombreCampo.setLength(150);
		nombreCampo.setComponentType("texto");
		nombreCampo.setReadOnly(false);
		nombreCampo.setHidden(false);
		nombreCampo.setRequired(true);
		nombreCampo.setShowInBasket(true);
		nombreCampo.setId(false);
		nombreCampo.setDecimals(0);
		nombreCampo.setDbFieldType("varchar");
		nombreCampo.setLabel("Nombre de Formulario");
		nombreCampo.setUuid(generarToken());
		nombreCampo.setComment("Nombre de Formulario");
		nombreCampo.setEvents("*");
		
		orden ++;
		archivoCampo.setName("archivo");
		archivoCampo.setFieldName("archivo");
		archivoCampo.setCss("form-control");
		archivoCampo.setOrder(orden);
		archivoCampo.setLength(150);
		archivoCampo.setComponentType("texto");
		archivoCampo.setReadOnly(false);
		archivoCampo.setHidden(false);
		archivoCampo.setRequired(true);
		archivoCampo.setShowInBasket(true);
		archivoCampo.setId(false);
		archivoCampo.setDecimals(0);
		archivoCampo.setDbFieldType("varchar");
		archivoCampo.setLabel("Nombre del Archivo");
		archivoCampo.setUuid(generarToken());
		archivoCampo.setComment("Nombre del Archivo");
		archivoCampo.setEvents("*");
		
		orden ++;
		tablaCampo.setName("tabla");
		tablaCampo.setFieldName("tabla");
		tablaCampo.setCss("form-control");
		tablaCampo.setOrder(orden);
		tablaCampo.setLength(2);
		tablaCampo.setComponentType("texto");
		tablaCampo.setReadOnly(false);
		tablaCampo.setHidden(false);
		tablaCampo.setRequired(false);
		tablaCampo.setShowInBasket(true);
		tablaCampo.setId(false);
		tablaCampo.setDecimals(0);
		tablaCampo.setDbFieldType("varchar");
		tablaCampo.setLabel("Tabla destino");
		tablaCampo.setUuid(generarToken());
		tablaCampo.setComment("Tabla destino");
		tablaCampo.setEvents("*");
		
		orden ++;
		borraCampo.setName("borra");
		borraCampo.setFieldName("borra");
		borraCampo.setCss("form-control");
		borraCampo.setOrder(orden);
		borraCampo.setLength(5);
		borraCampo.setComponentType("checkbox");
		borraCampo.setReadOnly(false);
		borraCampo.setHidden(false);
		borraCampo.setRequired(false);
		borraCampo.setShowInBasket(true);
		borraCampo.setId(false);
		borraCampo.setDecimals(0);
		borraCampo.setDbFieldType("varchar");
		borraCampo.setLabel("Borrar Datos Existentes");
		borraCampo.setUuid(generarToken());
		borraCampo.setComment("Borrar Datos Existentes");
		borraCampo.setEvents("*");
		
		orden ++;
		uuidCampo.setName("uuid");
		uuidCampo.setFieldName("uuid");
		uuidCampo.setCss("form-control");
		uuidCampo.setOrder(orden);
		uuidCampo.setLength(60);
		// Change to dropdown with patients records
		uuidCampo.setComponentType("texto");
		uuidCampo.setReadOnly(true);
		uuidCampo.setHidden(true);
		uuidCampo.setRequired(true);
		uuidCampo.setShowInBasket(true);
		uuidCampo.setId(false);
		uuidCampo.setDecimals(0);
		uuidCampo.setDbFieldType("varchar");
		uuidCampo.setLabel("uuid pariente");
		uuidCampo.setUuid(generarToken());
		uuidCampo.setComment("Campo uuid pariente");
		uuidCampo.setEvents("*");
		uuidCampo.setValue("${default::uuid}");
		
		orden ++;
		pacienteCampo.setName("uuidp");
		pacienteCampo.setFieldName("uuidp");
		pacienteCampo.setCss("form-control");
		pacienteCampo.setOrder(orden);
		pacienteCampo.setLength(60);
		// Change to dropdown with patients records
		pacienteCampo.setComponentType("texto");
		pacienteCampo.setReadOnly(true);
		pacienteCampo.setHidden(true);
		pacienteCampo.setRequired(false);
		pacienteCampo.setShowInBasket(true);
		pacienteCampo.setId(false);
		pacienteCampo.setDecimals(0);
		pacienteCampo.setDbFieldType("varchar");
		pacienteCampo.setLabel("uuidp pariente");
		pacienteCampo.setUuid(generarToken());
		pacienteCampo.setComment("Campo uuid pariente");
		pacienteCampo.setEvents("*");

		orden ++;
		companyCampo.setName("uuide");
		companyCampo.setFieldName("uuide");
		companyCampo.setCss("form-control");
		companyCampo.setOrder(orden);
		companyCampo.setLength(60);
		companyCampo.setComponentType("texto");
		companyCampo.setReadOnly(true);
		companyCampo.setHidden(true);
		companyCampo.setRequired(false);
		companyCampo.setShowInBasket(true);
		companyCampo.setId(false);
		companyCampo.setDecimals(0);
		companyCampo.setDbFieldType("varchar");
		companyCampo.setLabel("Campo uuide empresa");
		companyCampo.setUuid(generarToken());
		companyCampo.setComment("Campo uuide empresa");
		companyCampo.setEvents("*");


		campos.add(codigoCampo);
		campos.add(pacienteCampo);
		campos.add(companyCampo);
		campos.add(faltaCampo);
		campos.add(nombreCampo);
		campos.add(archivoCampo);
		campos.add(tablaCampo);
		campos.add(borraCampo);
		campos.add(uuidCampo);

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