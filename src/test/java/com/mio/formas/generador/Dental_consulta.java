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
public class Dental_consulta extends GenerateCode{

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
			buttonGuardar.setComponentType("guardarjs");
			buttonGuardar.setCss("btn btn-primary");
			buttonGuardar.setEvents("nuevo");
			buttonGuardar.setInstruction("Formulario guardado correctamente");
			buttonGuardar.setLabel("Guardar cambios");
			buttonGuardar.setModule(modulo);
			buttonGuardar.setName("guardar");
			buttonGuardar.setOrder(1);
			buttonGuardar.setResourceName(recurso);
			buttonGuardar.setResourceType("form");
			buttonGuardar.setUuid(generarToken());
			buttonGuardar.setVersion(version);
			metodos.add(buttonGuardar);

			Button buttonReceta = new Button();
			buttonReceta.setCommandName("recetar");
			buttonReceta.setComment("Boton recetar");
			buttonReceta.setComponentType("recetarjs");
			buttonReceta.setCss("btn btn-primary");
			buttonReceta.setEvents("nuevo");
			buttonReceta.setInstruction("Formulario guardado correctamente");
			buttonReceta.setLabel("Emitir receta");
			buttonReceta.setModule(modulo);
			buttonReceta.setName("recetar");
			buttonReceta.setOrder(1);
			buttonReceta.setResourceName(recurso);
			buttonReceta.setResourceType("form");
			buttonReceta.setUuid(generarToken());
			buttonReceta.setVersion(version);
			metodos.add(buttonReceta);
			
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
			
			Button buttonConsultar = new Button();
			buttonConsultar.setCommandName("tratamiento");
			buttonConsultar.setComment("Boton tratamiento");
			buttonConsultar.setComponentType("tratamientojs");
			buttonConsultar.setCss("btn btn-primary");
			buttonConsultar.setEvents("nuevo,detalle");
			buttonConsultar.setInstruction("Registrar tratamiento");
			buttonConsultar.setLabel("Registrar tratamiento");
			buttonConsultar.setModule(modulo);
			buttonConsultar.setName("tratamiento");
			buttonConsultar.setOrder(3);
			buttonConsultar.setResourceName("caracteristica");
			buttonConsultar.setResourceType("form");
			buttonConsultar.setUuid(generarToken());
			buttonConsultar.setVersion(version);
			metodos.add(buttonConsultar);

			Button buttonRegistrar = new Button();
			buttonRegistrar.setCommandName("padecimiento");
			buttonRegistrar.setComment("Boton padecimiento");
			buttonRegistrar.setComponentType("padecimientojs");
			buttonRegistrar.setCss("btn btn-danger");
			buttonRegistrar.setEvents("nuevo,detalle");
			buttonRegistrar.setInstruction("Registrar padecimiento");
			buttonRegistrar.setLabel("Registrar Padecimiento");
			buttonRegistrar.setModule(modulo);
			buttonRegistrar.setName("padecimiento");
			buttonRegistrar.setOrder(4);
			buttonRegistrar.setResourceName("caracteristica");
			buttonRegistrar.setResourceType("form");
			buttonRegistrar.setUuid(generarToken());
			buttonRegistrar.setVersion(version);
			metodos.add(buttonRegistrar);
			
			/*Button buttonAgendar = new Button();
			buttonAgendar.setCommandName("agendar");
			buttonAgendar.setComment("Boton agendar");
			buttonAgendar.setComponentType("agendarjs");
			buttonAgendar.setCss("btn btn-danger");
			buttonAgendar.setEvents("nuevo,detalle");
			buttonAgendar.setInstruction("Agendar");
			buttonAgendar.setLabel("Agendar");
			buttonAgendar.setModule(modulo);
			buttonAgendar.setName("agendar");
			buttonAgendar.setOrder(4);
			buttonAgendar.setResourceName("caracteristica");
			buttonAgendar.setResourceType("form");
			buttonAgendar.setUuid(generarToken());
			buttonAgendar.setVersion(version);
			metodos.add(buttonAgendar);*/
			
			
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
		String formulario = "consulta"; //nombre del formulario *
		String version = "1.0"; //version
		String idioma = "es_MX"; //version

		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve(modulo + "_" + formulario + ".json").normalize();
		int orden = 1;
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes(idioma, modulo, formulario, version, 1);

		//Definir todos los campos *
		Field codigocitaCampo = new Field();
		Field codigoconsultaCampo = new Field();
		Field faltaCampo = new Field();
		Field faltafCampo = new Field();
		Field sucursalCampo = new Field();
		Field especialistaCampo = new Field();
		Field pesoCampo = new Field();
		Field estaturaCampo = new Field();
		Field presionCampo = new Field();
		Field temperaturaCampo = new Field();
		Field statusCampo = new Field();
		Field recetaCampo = new Field();
		Field uuidCampo = new Field();
		Field uuidpCampo = new Field();
		Field uuideCampo = new Field();
		
		Resource forma = new Resource();

		//Ajustar *
		forma.setPrefix("CSA");
		forma.setCommandName("guardar");
		forma.setName("consulta");
		forma.setView("consulta");
		forma.setTitle("Consulta");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule(modulo);
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("consulta");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion de la consulta");
		forma.setUuid(generarToken());
		forma.setComment("Formulario para registrar las consultas");
		forma.setOrigin("ui::case");
		forma.setDestination("db::mysql");
		forma.setUuid(generarToken());
		forma.setPersistible(true);
		forma.setValidate(true);
		forma.setLastModificationDate(new java.util.Date().getTime());


		codigocitaCampo.setName("codigocita");
		codigocitaCampo.setFieldName("codigocita");
		codigocitaCampo.setCss("form-control");
		codigocitaCampo.setOrder(orden);
		codigocitaCampo.setComponentType("texto");
		codigocitaCampo.setReadOnly(true);
		codigocitaCampo.setHidden(false);
		codigocitaCampo.setRequired(false);
		codigocitaCampo.setShowInBasket(true);
		codigocitaCampo.setId(false);
		codigocitaCampo.setSearcheable(true);
		codigocitaCampo.setValidation(null);
		codigocitaCampo.setFormat(null);
		codigocitaCampo.setGroup("header");
		codigocitaCampo.setLength(60);
		codigocitaCampo.setDbFieldType("varchar");
		codigocitaCampo.setDecimals(0);
		codigocitaCampo.setPersistible(true);
		codigocitaCampo.setLabel("Codigo Cita");
		codigocitaCampo.setUuid(generarToken());
		codigocitaCampo.setComment("codigocita");
		codigocitaCampo.setAffects(null);
		codigocitaCampo.setFilter(null);
		codigocitaCampo.setEvents("*");
		codigocitaCampo.setOrigin(null);
		codigocitaCampo.setValue("");

		orden++;
		codigoconsultaCampo.setName("codigo");
		codigoconsultaCampo.setFieldName("codigo");
		codigoconsultaCampo.setCss("form-control");
		codigoconsultaCampo.setOrder(orden);
		codigoconsultaCampo.setComponentType("texto");
		codigoconsultaCampo.setReadOnly(true);
		codigoconsultaCampo.setHidden(false);
		codigoconsultaCampo.setRequired(false);
		codigoconsultaCampo.setShowInBasket(true);
		codigoconsultaCampo.setId(false);
		codigoconsultaCampo.setSearcheable(true);
		codigoconsultaCampo.setValidation(null);
		codigoconsultaCampo.setFormat(null);
		codigoconsultaCampo.setGroup("header");
		codigoconsultaCampo.setLength(60);
		codigoconsultaCampo.setDbFieldType("varchar");
		codigoconsultaCampo.setDecimals(0);
		codigoconsultaCampo.setPersistible(true);
		codigoconsultaCampo.setLabel("Codigo Consulta (Auto)");
		codigoconsultaCampo.setUuid(generarToken());
		codigoconsultaCampo.setComment("codigoconsulta");
		codigoconsultaCampo.setAffects(null);
		codigoconsultaCampo.setFilter(null);
		codigoconsultaCampo.setEvents("*");
		codigoconsultaCampo.setOrigin(null);
		codigoconsultaCampo.setValue("");

		orden++;
		faltaCampo.setName("fechayhora");
		faltaCampo.setFieldName("fechayhora");
		faltaCampo.setCss("form-control");
		faltaCampo.setOrder(orden);
		faltaCampo.setComponentType("texto");
		faltaCampo.setReadOnly(true);
		faltaCampo.setHidden(false);
		faltaCampo.setRequired(false);
		faltaCampo.setShowInBasket(true);
		faltaCampo.setId(false);
		faltaCampo.setSearcheable(true);
		faltaCampo.setValidation("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$");
		faltaCampo.setFormat(null);
		faltaCampo.setGroup("header");
		faltaCampo.setLength(10);
		faltaCampo.setDbFieldType("datetime");
		faltaCampo.setDecimals(0);
		faltaCampo.setPersistible(true);
		faltaCampo.setLabel("Fecha de consulta");
		faltaCampo.setUuid(generarToken());
		faltaCampo.setComment("falta");
		faltaCampo.setAffects(null);
		faltaCampo.setFilter(null);
		faltaCampo.setEvents("*");
		faltaCampo.setOrigin(null);
		faltaCampo.setValue("${default::fechayHoraCorto}");
		
		orden++;
		faltafCampo.setName("fechayhoraf");
		faltafCampo.setFieldName("fechayhoraf");
		faltafCampo.setCss("form-control");
		faltafCampo.setOrder(orden);
		faltafCampo.setComponentType("texto");
		faltafCampo.setReadOnly(true);
		faltafCampo.setHidden(false);
		faltafCampo.setRequired(false);
		faltafCampo.setShowInBasket(true);
		faltafCampo.setId(false);
		faltafCampo.setSearcheable(true);
		faltafCampo.setValidation("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$");
		faltafCampo.setFormat(null);
		faltafCampo.setGroup("header");
		faltafCampo.setLength(10);
		faltafCampo.setDbFieldType("datetime");
		faltafCampo.setDecimals(0);
		faltafCampo.setPersistible(true);
		faltafCampo.setLabel("Fecha/Hora fin de consulta");
		faltafCampo.setUuid(generarToken());
		faltafCampo.setComment("falta");
		faltafCampo.setAffects(null);
		faltafCampo.setFilter(null);
		faltafCampo.setEvents("*");
		faltafCampo.setOrigin(null);
		faltafCampo.setValue(null);
		
		orden++;		
		sucursalCampo.setName("sucursal");
		sucursalCampo.setFieldName("sucursal");
		sucursalCampo.setCss("form-control");
		sucursalCampo.setOrder(orden);
		sucursalCampo.setComponentType("sucursal");
		sucursalCampo.setReadOnly(false);
		sucursalCampo.setHidden(false);
		sucursalCampo.setRequired(true);
		sucursalCampo.setShowInBasket(true);
		sucursalCampo.setId(false);
		sucursalCampo.setSearcheable(true);
		sucursalCampo.setValidation(null);
		sucursalCampo.setFormat(null);
		sucursalCampo.setGroup("header");
		sucursalCampo.setLength(0);
		sucursalCampo.setDbFieldType("varchar");
		sucursalCampo.setDecimals(0);
		sucursalCampo.setPersistible(true);
		sucursalCampo.setLabel("Sucursal");
		sucursalCampo.setUuid(generarToken());
		sucursalCampo.setComment("sucursal");
		sucursalCampo.setAffects(null);
		sucursalCampo.setFilter(null);
		sucursalCampo.setEvents("*");
		sucursalCampo.setOrigin("{\"origin\":\"tabla\",\"resource\":\"dircto\",\"fields\":[{\"name\":\"uuid\", \"filter\":\"\"},{\"name\":\"codigo\", \"filter\":\"\"},{\"name\":\"nombre\", \"filter\":\"\"},{\"name\":\"tipo\", \"filter\":\"sucursal\"}]}");		
		sucursalCampo.setValue("");

		orden++;		
		especialistaCampo.setName("especialista");
		especialistaCampo.setFieldName("especialista");
		especialistaCampo.setCss("form-control");
		especialistaCampo.setOrder(orden);
		especialistaCampo.setComponentType("sucursal");
		especialistaCampo.setReadOnly(false);
		especialistaCampo.setHidden(false);
		especialistaCampo.setRequired(true);
		especialistaCampo.setShowInBasket(true);
		especialistaCampo.setId(false);
		especialistaCampo.setSearcheable(true);
		especialistaCampo.setValidation(null);
		especialistaCampo.setFormat(null);
		especialistaCampo.setGroup("header");
		especialistaCampo.setLength(0);
		especialistaCampo.setDbFieldType("varchar");
		especialistaCampo.setDecimals(0);
		especialistaCampo.setPersistible(true);
		especialistaCampo.setLabel("Especialista");
		especialistaCampo.setUuid(generarToken());
		especialistaCampo.setComment("especialista");
		especialistaCampo.setAffects(null);
		especialistaCampo.setFilter(null);
		especialistaCampo.setEvents("*");
		especialistaCampo.setOrigin("{\"origin\":\"tabla\",\"resource\":\"dircto\",\"fields\":[{\"name\":\"uuid\", \"filter\":\"\"},{\"name\":\"codigo\", \"filter\":\"\"},{\"name\":\"nombre\", \"filter\":\"\"},{\"name\":\"tipo\", \"filter\":\"especialista\"}]}");		
		especialistaCampo.setValue("");


		orden++;
		pesoCampo.setName("peso");
		pesoCampo.setFieldName("peso");
		pesoCampo.setCss("form-control");
		pesoCampo.setOrder(orden);
		pesoCampo.setComponentType("texto");
		pesoCampo.setReadOnly(false);
		pesoCampo.setHidden(false);
		pesoCampo.setRequired(true);
		pesoCampo.setShowInBasket(true);
		pesoCampo.setId(false);
		pesoCampo.setSearcheable(true);
		pesoCampo.setValidation(null);
		pesoCampo.setFormat(null);
		pesoCampo.setGroup("header");
		pesoCampo.setLength(10);
		pesoCampo.setDbFieldType("varchar");
		pesoCampo.setDecimals(0);
		pesoCampo.setPersistible(true);
		pesoCampo.setLabel("Peso");
		pesoCampo.setUuid(generarToken());
		pesoCampo.setComment("peso");
		pesoCampo.setAffects(null);
		pesoCampo.setFilter(null);
		pesoCampo.setEvents("*");
		pesoCampo.setOrigin(null);
		pesoCampo.setValue("");

		orden++;
		estaturaCampo.setName("estatura");
		estaturaCampo.setFieldName("estatura");
		estaturaCampo.setCss("form-control");
		estaturaCampo.setOrder(orden);
		estaturaCampo.setComponentType("texto");
		estaturaCampo.setReadOnly(false);
		estaturaCampo.setHidden(false);
		estaturaCampo.setRequired(true);
		estaturaCampo.setShowInBasket(true);
		estaturaCampo.setId(false);
		estaturaCampo.setSearcheable(true);
		estaturaCampo.setValidation(null);
		estaturaCampo.setFormat(null);
		estaturaCampo.setGroup("header");
		estaturaCampo.setLength(10);
		estaturaCampo.setDbFieldType("varchar");
		estaturaCampo.setDecimals(0);
		estaturaCampo.setPersistible(true);
		estaturaCampo.setLabel("Estatura");
		estaturaCampo.setUuid(generarToken());
		estaturaCampo.setComment("estatura");
		estaturaCampo.setAffects(null);
		estaturaCampo.setFilter(null);
		estaturaCampo.setEvents("*");
		estaturaCampo.setOrigin(null);
		estaturaCampo.setValue("");


		orden++;
		presionCampo.setName("presion");
		presionCampo.setFieldName("presion");
		presionCampo.setCss("form-control");
		presionCampo.setOrder(orden);
		presionCampo.setComponentType("texto");
		presionCampo.setReadOnly(false);
		presionCampo.setHidden(false);
		presionCampo.setRequired(true);
		presionCampo.setShowInBasket(true);
		presionCampo.setId(false);
		presionCampo.setSearcheable(true);
		presionCampo.setValidation(null);
		presionCampo.setFormat(null);
		presionCampo.setGroup("header");
		presionCampo.setLength(10);
		presionCampo.setDbFieldType("varchar");
		presionCampo.setDecimals(0);
		presionCampo.setPersistible(true);
		presionCampo.setLabel("Presion");
		presionCampo.setUuid(generarToken());
		presionCampo.setComment("presion");
		presionCampo.setAffects(null);
		presionCampo.setFilter(null);
		presionCampo.setEvents("*");
		presionCampo.setOrigin(null);
		presionCampo.setValue("");


		orden++;
		temperaturaCampo.setName("temperatura");
		temperaturaCampo.setFieldName("temperatura");
		temperaturaCampo.setCss("form-control");
		temperaturaCampo.setOrder(orden);
		temperaturaCampo.setComponentType("texto");
		temperaturaCampo.setReadOnly(false);
		temperaturaCampo.setHidden(false);
		temperaturaCampo.setRequired(true);
		temperaturaCampo.setShowInBasket(true);
		temperaturaCampo.setId(false);
		temperaturaCampo.setSearcheable(true);
		temperaturaCampo.setValidation(null);
		temperaturaCampo.setFormat(null);
		temperaturaCampo.setGroup("header");
		temperaturaCampo.setLength(10);
		temperaturaCampo.setDbFieldType("varchar");
		temperaturaCampo.setDecimals(0);
		temperaturaCampo.setPersistible(true);
		temperaturaCampo.setLabel("Temperatura");
		temperaturaCampo.setUuid(generarToken());
		temperaturaCampo.setComment("temperatura");
		temperaturaCampo.setAffects(null);
		temperaturaCampo.setFilter(null);
		temperaturaCampo.setEvents("*");
		temperaturaCampo.setOrigin(null);
		temperaturaCampo.setValue("");


		orden++;
		statusCampo.setName("status");
		statusCampo.setFieldName("status");
		statusCampo.setCss("form-control");
		statusCampo.setOrder(orden);
		statusCampo.setComponentType("lista");
		statusCampo.setReadOnly(false);
		statusCampo.setHidden(false);
		statusCampo.setRequired(false);
		statusCampo.setShowInBasket(true);
		statusCampo.setId(false);
		statusCampo.setSearcheable(false);
		statusCampo.setValidation(null);
		statusCampo.setFormat(null);
		statusCampo.setGroup("header");
		statusCampo.setLength(50);
		statusCampo.setDbFieldType("varchar");
		statusCampo.setDecimals(0);
		statusCampo.setPersistible(true);
		statusCampo.setLabel("Status consulta");
		statusCampo.setUuid(generarToken());
		statusCampo.setComment("Status");
		statusCampo.setAffects(null);
		statusCampo.setFilter(null);
		statusCampo.setEvents("*");
		statusCampo.setOrigin("{\"origin\":\"recurso\",\"resource\":\"inlinevalues\",\"fields\":[{\"name\":\"Iniciada,Finalizada,Cancelada\"}]}");
		statusCampo.setValue("Iniciada");
		
		orden++;
		recetaCampo.setName("receta");
		recetaCampo.setFieldName("receta");
		recetaCampo.setCss("form-control");
		recetaCampo.setOrder(orden);
		recetaCampo.setComponentType("lista");
		recetaCampo.setReadOnly(false);
		recetaCampo.setHidden(false);
		recetaCampo.setRequired(false);
		recetaCampo.setShowInBasket(true);
		recetaCampo.setId(false);
		recetaCampo.setSearcheable(false);
		recetaCampo.setValidation(null);
		recetaCampo.setFormat(null);
		recetaCampo.setGroup("header");
		recetaCampo.setLength(60);
		recetaCampo.setDbFieldType("varchar");
		recetaCampo.setDecimals(0);
		recetaCampo.setPersistible(true);
		recetaCampo.setLabel("Plantilla de receta");
		recetaCampo.setUuid(generarToken());
		recetaCampo.setComment("receta");
		recetaCampo.setAffects(null);
		recetaCampo.setFilter(null);
		recetaCampo.setEvents("*");
		recetaCampo.setOrigin("{\"origin\":\"recurso\",\"resource\":\"inlinevalues\",\"fields\":[{\"name\":\"Ninguna,Detalle,Resumen,Detalle y Resumen,Editar Detalle,Editar Resumen, Editar Detalle y Resumen\"}]}");
		recetaCampo.setValue("Ninguna");
		
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
		campos.add(codigocitaCampo);
		campos.add(codigoconsultaCampo);
		campos.add(faltaCampo);
		campos.add(faltafCampo);
		campos.add(sucursalCampo);
		campos.add(especialistaCampo);
		campos.add(pesoCampo);
		campos.add(estaturaCampo);
		campos.add(presionCampo);
		campos.add(temperaturaCampo);
		campos.add(statusCampo);
		campos.add(recetaCampo);
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