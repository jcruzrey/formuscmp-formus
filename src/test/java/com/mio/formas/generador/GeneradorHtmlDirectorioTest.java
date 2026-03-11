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
public class GeneradorHtmlDirectorioTest {

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

	private List<Button> dameMetodosComunes(String idioma, String modulo, String recurso, String version) {
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
	public void testNuevoRol() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve("rol.json").normalize();
		int orden = 1;
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> metodos = dameMetodosComunes("es_MX", "crm", "rol", "1.0");

		Field codigoCampo = new Field();
		//Field pacienteCampo = new Field();
		// Field companyCampo = new Field();

		//Field companyCampo = new Field();
		Field faltaCampo = new Field();
		//Field uuidCampo = new Field();

		// Aqui declaramos las variables de campos - Paloma
		Field nombresCampo = new Field();
		Field apaternoCampo = new Field();
		
		Field correoeCampo = new Field();
		//Field fcontactoCampo = new Field();
		Field cemergenciaCampo = new Field();
	
		//Field faltaCampo = new Field();
		Field statusCampo = new Field();
		
		Field sucursalCampo = new Field();
		Field uuidCampo = new Field();
		Field uuipCampo = new Field();
		Field uuideCampo = new Field();
		
		Resource forma = new Resource();

		forma.setPrefix("DRO");
		forma.setCommandName("guardar");
		forma.setName("rol");
		forma.setView("rol");
		forma.setTitle("Rol");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("rol");
		forma.setValidate(true);
		forma.setInstruction("Por favor complete la informacion del paciente");
		forma.setUuid(generarToken());
		forma.setComment("Formulario para crear un rol");
		forma.setOrigin("ui::case");
		forma.setDestination("db::mysql");
		forma.setUuid(generarToken());
		forma.setPersistible(true);
		forma.setValidate(true);

		codigoCampo.setName("codigo");
		codigoCampo.setFieldName("codigo");
		codigoCampo.setCss("form-control");
		codigoCampo.setOrder(orden);
		codigoCampo.setComponentType("texto");
		codigoCampo.setReadOnly(true);
		codigoCampo.setHidden(false);
		codigoCampo.setRequired(false);
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
		codigoCampo.setLabel("Codigo (Auto)");
		codigoCampo.setUuid(generarToken());
		codigoCampo.setComment("Campo codigo");
		codigoCampo.setAffects(null);
		codigoCampo.setFilter(null);
		codigoCampo.setEvents("*");
		codigoCampo.setOrigin(null);
		codigoCampo.setValue("");

		
		// Pegar aqui el campo original de codigo
		orden++; //2
		nombresCampo.setName("nombre");
		nombresCampo.setFieldName("nombre");
		nombresCampo.setCss("form-control");
		nombresCampo.setOrder(orden);
		nombresCampo.setComponentType("texto");
		nombresCampo.setReadOnly(false);
		nombresCampo.setHidden(false);
		nombresCampo.setRequired(true);
		nombresCampo.setShowInBasket(true);
		nombresCampo.setId(true);
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
		nombresCampo.setComment("Campo de nombre");
		nombresCampo.setAffects(null);
		nombresCampo.setFilter(null);
		nombresCampo.setEvents("*");
		nombresCampo.setOrigin(null);
		nombresCampo.setValue("");

		//Aqui ponder todos los campos del excel - Paloma
		orden++;//3
		apaternoCampo.setName("descripcion");
		apaternoCampo.setFieldName("descripcion");
		apaternoCampo.setCss("form-control");
		apaternoCampo.setOrder(orden);
		apaternoCampo.setComponentType("texto");
		apaternoCampo.setReadOnly(false);
		apaternoCampo.setHidden(false);
		apaternoCampo.setRequired(true);
		apaternoCampo.setShowInBasket(true);
		apaternoCampo.setId(true);
		apaternoCampo.setSearcheable(true);
		apaternoCampo.setValidation(null);
		apaternoCampo.setFormat(null);
		apaternoCampo.setGroup("header");
		apaternoCampo.setLength(100);
		apaternoCampo.setDbFieldType("varchar");
		apaternoCampo.setDecimals(0);
		apaternoCampo.setPersistible(true);
		apaternoCampo.setLabel("Descripcion");
		apaternoCampo.setUuid(generarToken());
		apaternoCampo.setComment("Descripcion");
		apaternoCampo.setAffects(null);
		apaternoCampo.setFilter(null);
		apaternoCampo.setEvents("*");
		apaternoCampo.setOrigin(null);
		apaternoCampo.setValue("");
		
		
		orden++;
		correoeCampo.setName("usuario");
		correoeCampo.setFieldName("usuario");
		correoeCampo.setCss("form-control");
		correoeCampo.setOrder(orden);
		correoeCampo.setComponentType("texto");
		correoeCampo.setReadOnly(false);
		correoeCampo.setHidden(false);
		correoeCampo.setRequired(false);
		correoeCampo.setShowInBasket(true);
		correoeCampo.setId(true);
		correoeCampo.setSearcheable(true);
		correoeCampo.setValidation(null);
		correoeCampo.setFormat(null);
		correoeCampo.setGroup("header");
		correoeCampo.setLength(50);
		correoeCampo.setDbFieldType("varchar");
		correoeCampo.setDecimals(0);
		correoeCampo.setPersistible(true);
		correoeCampo.setLabel("Correo electronico");
		correoeCampo.setUuid(generarToken());
		correoeCampo.setComment("Correo de usuario");
		correoeCampo.setAffects(null);
		correoeCampo.setFilter(null);
		correoeCampo.setEvents("*");
		correoeCampo.setOrigin(null);
		correoeCampo.setValue("");
		
		
		
		orden++;
		cemergenciaCampo.setName("contacto");
		cemergenciaCampo.setFieldName("contacto");
		cemergenciaCampo.setCss("form-control");
		cemergenciaCampo.setOrder(orden);
		cemergenciaCampo.setComponentType("texto");
		cemergenciaCampo.setReadOnly(false);
		cemergenciaCampo.setHidden(false);
		cemergenciaCampo.setRequired(false);
		cemergenciaCampo.setShowInBasket(true);
		cemergenciaCampo.setId(true);
		cemergenciaCampo.setSearcheable(true);
		cemergenciaCampo.setValidation(null);
		cemergenciaCampo.setFormat(null);
		cemergenciaCampo.setGroup("header");
		cemergenciaCampo.setLength(30);
		cemergenciaCampo.setDbFieldType("varchar");
		cemergenciaCampo.setDecimals(0);
		cemergenciaCampo.setPersistible(true);
		cemergenciaCampo.setLabel("Contacto de Emergencia");
		cemergenciaCampo.setUuid(generarToken());
		cemergenciaCampo.setComment("Campo de contacto de emergencia");
		cemergenciaCampo.setAffects(null);
		cemergenciaCampo.setFilter(null);
		cemergenciaCampo.setEvents("*");
		cemergenciaCampo.setOrigin(null);
		cemergenciaCampo.setValue("");
		
		
		orden++;
		faltaCampo.setName("falta");
		faltaCampo.setFieldName("falta");
		faltaCampo.setCss("form-control");
		faltaCampo.setOrder(orden);
		faltaCampo.setComponentType("texto");
		faltaCampo.setReadOnly(true);
		faltaCampo.setHidden(false);
		faltaCampo.setRequired(false);
		faltaCampo.setShowInBasket(true);
		faltaCampo.setId(true);
		faltaCampo.setSearcheable(true);
		faltaCampo.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		faltaCampo.setFormat(null);
		faltaCampo.setGroup("header");
		faltaCampo.setLength(10);
		faltaCampo.setDbFieldType("varchar");
		faltaCampo.setDecimals(0);
		faltaCampo.setPersistible(true);
		faltaCampo.setLabel("Falta");
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
		statusCampo.setRequired(false);
		statusCampo.setShowInBasket(true);
		statusCampo.setId(true);
		statusCampo.setSearcheable(true);
		statusCampo.setValidation(null);
		statusCampo.setFormat(null);
		statusCampo.setGroup("header");
		statusCampo.setLength(45);
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
		
		//Estos son los ultimos campos
		
		orden++;
		uuidCampo.setName("uuid");
		uuidCampo.setFieldName("uuid");
		uuidCampo.setCss("form-control");
		uuidCampo.setOrder(orden);
		uuidCampo.setLength(30);
		uuidCampo.setComponentType("lista");
		uuidCampo.setReadOnly(false);
		uuidCampo.setHidden(false);
		uuidCampo.setRequired(true);
		uuidCampo.setShowInBasket(true);
		uuidCampo.setId(true);
		uuidCampo.setSearcheable(true);
		uuidCampo.setValidation(null);
		uuidCampo.setFormat(null);
		uuidCampo.setGroup("header");
		// Change to dropdown with patients records
		uuidCampo.setComponentType("texto");
		uuidCampo.setReadOnly(false);
		uuidCampo.setHidden(true);
		uuidCampo.setShowInBasket(true);
		uuidCampo.setDecimals(0);
		uuidCampo.setDbFieldType("varchar");
		uuidCampo.setLabel("uuid pariente");
		uuidCampo.setUuid(generarToken());
		uuidCampo.setComment("Campo uuid pariente");
		uuidCampo.setEvents("*");
		uuidCampo.setValue("${default::uuid}");

		orden++;
		uuipCampo.setName("uuidp");
		uuipCampo.setFieldName("uuidp");
		uuipCampo.setCss("form-control");
		uuipCampo.setOrder(orden);
		uuipCampo.setLength(30);
		// Change to dropdown with patients records
		uuipCampo.setComponentType("texto");
		uuipCampo.setReadOnly(false);
		uuipCampo.setHidden(true);
		uuipCampo.setRequired(false);
		uuipCampo.setShowInBasket(true);
		uuipCampo.setId(false);
		uuipCampo.setSearcheable(true);
		uuipCampo.setValidation(null);
		uuipCampo.setFormat(null);
		uuipCampo.setGroup("header");
		sucursalCampo.setComponentType("texto");
		uuipCampo.setReadOnly(false);
		uuipCampo.setHidden(true);
		uuipCampo.setShowInBasket(true);
		uuipCampo.setDecimals(0);
		uuipCampo.setDbFieldType("varchar");
		uuipCampo.setLabel("uuid pariente");
		uuipCampo.setUuid(generarToken());
		uuipCampo.setComment("Campo uuidp pariente");
		uuipCampo.setEvents("*");

		orden++;
		uuideCampo.setName("uuide");
		uuideCampo.setFieldName("uuide");
		uuideCampo.setCss("form-control");
		uuideCampo.setOrder(orden);
		uuideCampo.setLength(30);
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
		uuideCampo.setComponentType("texto");
		uuideCampo.setReadOnly(false);
		uuideCampo.setHidden(true);
		uuideCampo.setShowInBasket(true);
		uuideCampo.setDecimals(0);
		uuideCampo.setDbFieldType("varchar");
		uuideCampo.setLabel("uuid empresa");
		uuideCampo.setUuid(generarToken());
		uuideCampo.setComment("Campo uuie empresa");
		uuideCampo.setEvents("*");

		campos.add(codigoCampo);//
		campos.add(uuidCampo);
		campos.add(uuipCampo);
		campos.add(uuideCampo);
		//campos.add(pacienteCampo);
		//campos.add(companyCampo);
		// Copiar esta linea - Paloma
		campos.add(nombresCampo);//
		campos.add(apaternoCampo);//
		
		campos.add(correoeCampo);//
		//campos.add(fcontactoCampo);
		campos.add(cemergenciaCampo);//
		campos.add(faltaCampo);//
		campos.add(statusCampo);//
		
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