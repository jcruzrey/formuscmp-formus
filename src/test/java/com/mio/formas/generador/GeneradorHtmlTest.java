/**
 * 
 */
package com.mio.formas.generador;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.formuscmp.formus.button.Button;
import com.formuscmp.formus.field.Field;
import com.formuscmp.formus.generator.Generador;
import com.formuscmp.formus.generator.IGenerador;
import com.formuscmp.formus.resource.Resource;

/**
 * @author jcruzreyf
 *
 */
public class GeneradorHtmlTest {
	
	private String[] templatesPath = new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"}; 
	/**
	 * Test method for
	 * {@link com.formuscmp.formus.generator.Generador#guatdarForma(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testGuardarFormaCampoDeFutbol() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve("cfutbol.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field calle = new Field();
		Field colonia = new Field();
		Resource forma = new Resource();

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		//campoCodigo.setAutogenerado(false);

		campoCampo.setName("Nombre");
		campoCampo.setFieldName("nombre");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(2);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);

		calle.setName("Calle");
		calle.setFieldName("calle");
		calle.setCss("form-control");
		calle.setOrder(3);
		calle.setComponentType("texto");
		calle.setReadOnly(false);
		calle.setHidden(false);
		calle.setRequired(false);
		calle.setShowInBasket(true);
		calle.setId(false);

		colonia.setName("Colonia");
		colonia.setFieldName("colonia");
		colonia.setCss("form-control");
		colonia.setOrder(4);
		colonia.setComponentType("texto");
		colonia.setReadOnly(false);
		colonia.setHidden(false);
		colonia.setRequired(false);
		colonia.setShowInBasket(true);
		colonia.setId(false);


		campos.add(campoCodigo);
		campos.add(calle);
		campos.add(colonia);
		campos.add(campoCampo);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("cfutbol");
		forma.setView("vista");
		forma.setTitle("Campo de futbol");
		forma.setVersion("1");
		forma.setStatus("produccion");
		forma.setModule("futbol");
		forma.setBasket("lista");
		forma.setCreateable(true);
		forma.setTable("cfutbol");
		forma.setValidate(true);
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

	/**
	 * Test method for
	 * {@link com.formuscmp.formus.generator.Generador#guatdarForma(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testGuardarFormaReporte() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("reporte.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		Field campoCodigo = new Field();
		Field reporte = new Field();
		Field jugador = new Field();
		Field jornada = new Field();
		Resource forma = new Resource();

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);

		reporte.setName("Reporte");
		reporte.setFieldName("reporte");
		reporte.setCss("form-control");
		reporte.setOrder(2);
		reporte.setComponentType("Campoarea");
		reporte.setReadOnly(false);
		reporte.setHidden(false);
		reporte.setRequired(true);
		reporte.setReadOnly(true);
		reporte.setId(false);

		jugador.setName("Jugador");
		jugador.setFieldName("jugador");
		jugador.setCss("form-control");
		jugador.setOrder(3);
		jugador.setComponentType("texto");
		jugador.setReadOnly(false);
		jugador.setHidden(false);
		jugador.setRequired(true);
		jugador.setShowInBasket(true);
		jugador.setId(false);

		jornada.setName("Jornada");
		jornada.setFieldName("jornada");
		jornada.setCss("form-control");
		jornada.setOrder(4);
		jornada.setComponentType("numero");
		jornada.setReadOnly(false);
		jornada.setHidden(false);
		jornada.setRequired(true);
		jornada.setShowInBasket(true);
		jornada.setId(false);

		campos.add(campoCodigo);
		campos.add(reporte);
		campos.add(jugador);
		campos.add(jornada);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("reporte");
		forma.setView("vista");
		forma.setTitle("Reporte");
		forma.setVersion("1");
		forma.setStatus("produccion");
		forma.setModule("futbol");
		forma.setBasket("lista");
		forma.setCreateable(true);
		forma.setTable("reporte");
		forma.setValidate(true);
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

	/**
	 * Test method for
	 * {@link com.formuscmp.formus.generator.Generador#guatdarForma(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testGuardarFormaArbitro() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("arbitro.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();
		Resource forma = new Resource();

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);

		campoCampo.setName("Nombre");
		campoCampo.setFieldName("nombre");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(2);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);

		aMaterno.setName("A. Materno");
		aMaterno.setFieldName("amaterno");
		aMaterno.setCss("form-control");
		aMaterno.setOrder(3);
		aMaterno.setComponentType("texto");
		aMaterno.setReadOnly(false);
		aMaterno.setHidden(false);
		aMaterno.setRequired(true);
		aMaterno.setShowInBasket(true);
		aMaterno.setId(false);

		aPaterno.setName("A. Paterno");
		aPaterno.setFieldName("apaterno");
		aPaterno.setCss("form-control");
		aPaterno.setOrder(4);
		aPaterno.setComponentType("texto");
		aPaterno.setReadOnly(false);
		aPaterno.setHidden(false);
		aPaterno.setRequired(true);
		aPaterno.setShowInBasket(true);
		aPaterno.setId(false);

		fNacim.setName("Fecha de nacimiento");
		fNacim.setFieldName("fnacim");
		fNacim.setCss("form-control");
		fNacim.setOrder(5);
		fNacim.setComponentType("texto");
		fNacim.setReadOnly(false);
		fNacim.setHidden(false);
		fNacim.setRequired(true);
		fNacim.setShowInBasket(true);
		fNacim.setId(false);

		campos.add(aPaterno);
		campos.add(fNacim);
		campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campoCodigo);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("arbitro");
		forma.setTitle("Arbitro");
		forma.setView("vista");
		forma.setVersion("1");
		forma.setStatus("produccion");
		forma.setModule("futbol");
		forma.setBasket("lista");
		forma.setCreateable(true);
		forma.setTable("arbitro");
		forma.setValidate(true);
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

	@Test
	public void testGuardarFormaJuego() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("juego.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		Field campoCodigo = new Field();
		Field fecha = new Field();
		Field lugar = new Field();
		Field alterno = new Field();
		Field equipo1 = new Field();
		Field equipo2 = new Field();
		Field ganador = new Field();
		Field inicio = new Field();
		Field finalizo = new Field();

		Field puntos = new Field();
		Field puntos1 = new Field();
		Resource forma = new Resource();

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);

		fecha.setName("Fecha a realizarse");
		fecha.setFieldName("fecha");
		fecha.setCss("form-control");
		fecha.setOrder(2);
		fecha.setComponentType("texto");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(true);
		fecha.setShowInBasket(true);
		fecha.setId(false);

		lugar.setName("Campo a jugar");
		lugar.setFieldName("lugar");
		lugar.setCss("form-control");
		lugar.setOrder(3);
		lugar.setComponentType("texto");
		lugar.setReadOnly(false);
		lugar.setHidden(false);
		lugar.setRequired(true);
		lugar.setShowInBasket(true);
		lugar.setId(false);

		alterno.setName("Lugar alterno");
		alterno.setFieldName("alterno");
		alterno.setCss("form-control");
		alterno.setOrder(4);
		alterno.setComponentType("texto");
		alterno.setReadOnly(false);
		alterno.setHidden(false);
		alterno.setRequired(false);
		alterno.setShowInBasket(false);
		alterno.setId(false);

		equipo1.setName("Equipo 1");
		equipo1.setFieldName("equipo1");
		equipo1.setCss("form-control");
		equipo1.setOrder(5);
		equipo1.setComponentType("texto");
		equipo1.setReadOnly(false);
		equipo1.setHidden(false);
		equipo1.setRequired(true);
		equipo1.setShowInBasket(true);
		equipo1.setId(false);

		equipo2.setName("Equipo 2");
		equipo2.setFieldName("equipo2");
		equipo2.setCss("form-control");
		equipo2.setOrder(6);
		equipo2.setComponentType("texto");
		equipo2.setReadOnly(false);
		equipo2.setHidden(false);
		equipo2.setRequired(true);
		equipo2.setShowInBasket(true);
		equipo2.setId(false);

		ganador.setName("Equipo ganador");
		ganador.setFieldName("ganador");
		ganador.setCss("form-control");
		ganador.setOrder(7);
		ganador.setComponentType("texto");
		ganador.setReadOnly(false);
		ganador.setHidden(false);
		ganador.setRequired(false);
		ganador.setShowInBasket(false);
		ganador.setId(false);

		puntos.setName("Puntos equipo 1");
		puntos.setFieldName("puntos1");
		puntos.setCss("form-control");
		puntos.setOrder(8);
		puntos.setComponentType("numero");
		puntos.setReadOnly(false);
		puntos.setHidden(false);
		puntos.setRequired(false);
		puntos.setShowInBasket(false);
		puntos.setId(false);

		puntos1.setName("Puntos equipo 2");
		puntos1.setFieldName("puntos2");
		puntos1.setCss("form-control");
		puntos1.setOrder(9);
		puntos1.setComponentType("numero");
		puntos1.setReadOnly(false);
		puntos1.setHidden(false);
		puntos1.setRequired(false);
		puntos1.setShowInBasket(false);
		puntos1.setId(false);

		inicio.setName("Horario de inicio");
		inicio.setFieldName("inicio");
		inicio.setCss("form-control");
		inicio.setOrder(10);
		inicio.setComponentType("texto");
		inicio.setReadOnly(false);
		inicio.setHidden(false);
		inicio.setRequired(false);
		inicio.setShowInBasket(true);
		inicio.setId(false);

		finalizo.setName("Horario de finalizacion");
		finalizo.setFieldName("finalizo");
		finalizo.setCss("form-control");
		finalizo.setOrder(11);
		finalizo.setComponentType("texto");
		finalizo.setReadOnly(false);
		finalizo.setHidden(false);
		finalizo.setRequired(false);
		finalizo.setShowInBasket(false);
		finalizo.setId(false);

		campos.add(campoCodigo);
		campos.add(alterno);
		campos.add(inicio);
		campos.add(finalizo);
		campos.add(equipo1);
		campos.add(equipo2);
		campos.add(ganador);
		campos.add(puntos);
		campos.add(puntos1);
		campos.add(lugar);
		campos.add(fecha);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("juego");
		forma.setView("vista");
		forma.setTitle("Juego");
		forma.setVersion("1");
		forma.setStatus("produccion");
		forma.setModule("futbol");
		forma.setBasket("lista");
		forma.setCreateable(true);
		forma.setTable("juego");
		forma.setValidate(true);
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

	/**
	 * Test method for
	 * {@link com.formuscmp.formus.generator.Generador#guatdarForma(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testGuardarFormaRegistro() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("registro.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field aMaterno = new Field();
		Resource forma = new Resource();

		campoCodigo.setName("Punto de acceso");
		campoCodigo.setFieldName("acceso");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);

		campoCampo.setName("Fecha y hora");
		campoCampo.setFieldName("fecha");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(2);
		campoCampo.setComponentType("tiempo");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);

		aMaterno.setName("Credencial");
		aMaterno.setFieldName("credencial");
		aMaterno.setCss("form-control");
		aMaterno.setOrder(3);
		aMaterno.setComponentType("texto");
		aMaterno.setReadOnly(false);
		aMaterno.setHidden(false);
		aMaterno.setRequired(false);
		aMaterno.setShowInBasket(true);
		aMaterno.setId(false);

		campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campoCodigo);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("registro");
		forma.setView("vista");
		forma.setTitle("Registro");
		forma.setVersion("1");
		forma.setStatus("produccion");
		forma.setModule("asistencia");
		forma.setBasket("lista");
		forma.setCreateable(true);
		forma.setTable("registro");
		forma.setValidate(true);
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



	@Test
	public void testGuardarFormaConsulta() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("consulta.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		Field campoCodigo = new Field();
		Resource forma = new Resource();

		campoCodigo.setName("Credencial");
		campoCodigo.setFieldName("credencial");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);


		campos.add(campoCodigo);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("consulta");
		forma.setView("consulta");
		forma.setTitle("consulta");
		forma.setVersion("1");
		forma.setStatus("produccion");
		forma.setModule("asistencia");
		forma.setCreateable(false);
		forma.setValidate(false);
		//asistencias se queda vacio pues debe ser la misma forma que se devuelve o convierto esto en consulta-lista.ftl
		//forma.setLista("lista");//nombres de listados, terminan asi consulta-lista.ftl
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



	@Test
	public void testGuardarFormaImportacion() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("importa.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		Field campoCodigo = new Field();
		Resource forma = new Resource();
		Field campoMostrar = new Field();

		campoCodigo.setName("archivo");
		campoCodigo.setFieldName("archivo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("archivo");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setReadOnly(true);

		campoMostrar.setName("mostrar resultados");
		campoMostrar.setFieldName("resultados");
		campoMostrar.setCss("form-control");
		campoMostrar.setOrder(2);
		campoMostrar.setComponentType("checkbox");
		campoMostrar.setReadOnly(false);
		campoMostrar.setHidden(false);
		campoMostrar.setRequired(true);
		campoMostrar.setShowInBasket(true);


		campos.add(campoMostrar);
		campos.add(campoCodigo);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("importacion");
		forma.setView("importacion");
		forma.setTitle("importacion");
		forma.setVersion("1");
		forma.setStatus("produccion");
		forma.setModule("asistencia");
		forma.setBasket("lista");//debe convertirse en lista
		forma.setCreateable(false);
		forma.setValidate(false);
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

	@Test
	public void testGuardarFormaNueva() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("forma.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field campoCodigo = new Field();
		Resource forma = new Resource();
		Field campoMostrar = new Field();
		Field campoTitulo = new Field();
		Field campoVista = new Field();
		Field campoUsuario = new Field();
		Field campoVersion = new Field();
		Field campoStatus = new Field();
		Field campoModulo = new Field();
		Field campoLista = new Field();
		Field campoCreable = new Field();
		Field campoBd = new Field();
		Field campoInstruccion = new Field();
		Field campoDestino = new Field();
		Field campoOrigen = new Field();
		
		Button guardar = new Button();
		guardar.setName("guardar");
		guardar.setCommandName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("submit");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("forma");
		guardar.setModule("case");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		guardar.setView("forma");

		Button cancelar = new Button();
		cancelar.setName("cancelar");
		cancelar.setCommandName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setResourceName("forma");
		cancelar.setModule("case");
		cancelar.setOrder(2);
		cancelar.setResourceType("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvents("nuevo");
		
		acciones.add(guardar);
		acciones.add(cancelar);


		campoCodigo.setName("Nombre de forma");
		campoCodigo.setFieldName("nombre");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(false);

		campoTitulo.setName("Titulo de forma");
		campoTitulo.setFieldName("titulo");
		campoTitulo.setCss("form-control");
		campoTitulo.setOrder(2);
		campoTitulo.setComponentType("texto");
		campoTitulo.setReadOnly(false);
		campoTitulo.setHidden(false);
		campoTitulo.setRequired(true);
		campoTitulo.setShowInBasket(true);
		campoTitulo.setId(false);

		campoMostrar.setName("Accion");
		campoMostrar.setFieldName("accion");
		campoMostrar.setCss("form-control");
		campoMostrar.setOrder(3);
		campoMostrar.setComponentType("texto");
		campoMostrar.setReadOnly(false);
		campoMostrar.setHidden(false);
		campoMostrar.setRequired(true);
		campoMostrar.setShowInBasket(true);
		campoMostrar.setValue("guardar");
		campoMostrar.setId(false);

		campoVista.setName("Vista");
		campoVista.setFieldName("vista");
		campoVista.setCss("form-control");
		campoVista.setOrder(4);
		campoVista.setComponentType("texto");
		campoVista.setReadOnly(false);
		campoVista.setHidden(false);
		campoVista.setRequired(true);
		campoVista.setShowInBasket(true);
		campoVista.setValue("vista");
		campoVista.setId(false);

		campoUsuario.setName("Crea usuario");
		campoUsuario.setFieldName("usuario");
		campoUsuario.setCss("form-control");
		campoUsuario.setOrder(5);
		campoUsuario.setComponentType("checkbox");
		campoUsuario.setReadOnly(false);
		campoUsuario.setHidden(false);
		campoUsuario.setRequired(true);
		campoUsuario.setShowInBasket(true);
		campoUsuario.setId(false);

		campoVersion.setName("Version");
		campoVersion.setFieldName("version");
		campoVersion.setCss("form-control");
		campoVersion.setOrder(6);
		campoVersion.setComponentType("texto");
		campoVersion.setReadOnly(true);
		campoVersion.setHidden(false);
		campoVersion.setRequired(true);
		campoVersion.setShowInBasket(true);
		campoVersion.setValue("1.0");
		campoVersion.setId(false);

		campoStatus.setName("Status");
		campoStatus.setFieldName("status");
		campoStatus.setCss("form-control");
		campoStatus.setOrder(7);
		campoStatus.setComponentType("status");
		campoStatus.setReadOnly(false);
		campoStatus.setHidden(false);
		campoStatus.setRequired(true);
		campoStatus.setShowInBasket(true);
		campoStatus.setValue("borrador");
		campoStatus.setId(false);

		campoModulo.setName("Modulo");
		campoModulo.setFieldName("modulo");
		campoModulo.setCss("form-control");
		campoModulo.setOrder(7);
		campoModulo.setComponentType("modulos");
		campoModulo.setReadOnly(false);
		campoModulo.setHidden(false);
		campoModulo.setRequired(true);
		campoModulo.setShowInBasket(true);
		campoModulo.setId(false);
		campoModulo.setOrigin("{\"origen\":\"recurso\",\"objeto\":\"modulos\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");


		campoLista.setName("Nombre de vista de listado");
		campoLista.setFieldName("lista");
		campoLista.setCss("form-control");
		campoLista.setOrder(8);
		campoLista.setComponentType("texto");
		campoLista.setReadOnly(false);
		campoLista.setHidden(false);
		campoLista.setRequired(true);
		campoLista.setShowInBasket(true);
		campoLista.setValue("lista");
		campoLista.setId(false);

		campoCreable.setName("Mostrar en menu de crear");
		campoCreable.setFieldName("creable");
		campoCreable.setCss("form-control");
		campoCreable.setOrder(9);
		campoCreable.setComponentType("checkbox");
		campoCreable.setReadOnly(false);
		campoCreable.setHidden(false);
		campoCreable.setRequired(true);
		campoCreable.setShowInBasket(false);
		campoCreable.setValue("false");
		campoCreable.setId(false);

		campoBd.setName("Nombre de tabla");
		campoBd.setFieldName("bd");
		campoBd.setCss("form-control");
		campoBd.setOrder(10);
		campoBd.setComponentType("texto");
		campoBd.setReadOnly(false);
		campoBd.setHidden(false);
		campoBd.setRequired(true);
		campoBd.setShowInBasket(true);
		campoBd.setValue("");
		campoBd.setId(true);
		
		campoInstruccion.setName("Instruccion");
		campoInstruccion.setFieldName("instruccion");
		campoInstruccion.setCss("form-control");
		campoInstruccion.setOrder(11);
		campoInstruccion.setComponentType("texto");
		campoInstruccion.setReadOnly(false);
		campoInstruccion.setHidden(false);
		campoInstruccion.setRequired(true);
		campoInstruccion.setShowInBasket(true);
		campoInstruccion.setValue("");
		campoInstruccion.setId(true);
		
		campoOrigen.setName("Origen");
		campoOrigen.setFieldName("instruccion");
		campoOrigen.setCss("form-control");
		campoOrigen.setOrder(12);
		campoOrigen.setComponentType("texto");
		campoOrigen.setReadOnly(false);
		campoOrigen.setHidden(false);
		campoOrigen.setRequired(true);
		campoOrigen.setShowInBasket(true);
		campoOrigen.setValue("ui::misops");
		campoOrigen.setId(true);
		
		campoDestino.setName("Destino");
		campoDestino.setFieldName("destino");
		campoDestino.setCss("form-control");
		campoDestino.setOrder(13);
		campoDestino.setComponentType("texto");
		campoDestino.setReadOnly(false);
		campoDestino.setHidden(false);
		campoDestino.setRequired(true);
		campoDestino.setShowInBasket(true);
		campoDestino.setValue("db::mysql");
		campoDestino.setId(true);
		
		campos.add(campoTitulo);
		campos.add(campoMostrar);
		campos.add(campoCodigo);
		campos.add(campoVista);
		campos.add(campoUsuario);
		campos.add(campoVersion);
		campos.add(campoStatus);
		campos.add(campoModulo);
		campos.add(campoLista);
		campos.add(campoCreable);
		campos.add(campoBd);
		campos.add(campoInstruccion);
		campos.add(campoDestino);
		campos.add(campoOrigen);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("forma");
		forma.setView("forma");
		forma.setTitle("Forma");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("case");
		forma.setBasket("forma");
		forma.setCreateable(true);
		forma.setTable("forma");
		forma.setValidate(true);
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

	@Test
	public void testGuardarCanastaNueva() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field campoCodigo = new Field();
		Resource forma = new Resource();
		
		Field campoTitulo = new Field();
		Field campoVista = new Field();
		Field campoVersion = new Field();
		Field campoStatus = new Field();
		Field campoModulo = new Field();
		Field campoCreable = new Field();
		Field campoBd = new Field();
		Field campoInstruccion = new Field();
		
		Button guardar = new Button();
		guardar.setName("guardar");
		guardar.setCommandName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("submit");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("basket");
		guardar.setModule("case");
		guardar.setOrder(1);
		guardar.setResourceType("basket");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		guardar.setView("basket");

		Button cancelar = new Button();
		cancelar.setName("cancelar");
		cancelar.setCommandName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setResourceName("forma");
		cancelar.setModule("case");
		cancelar.setOrder(2);
		cancelar.setResourceType("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvents("nuevo");
		
		acciones.add(guardar);
		acciones.add(cancelar);


		campoCodigo.setName("Nombre de la canasta");
		campoCodigo.setFieldName("nombre");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(false);

		campoTitulo.setName("Titulo de la canasta");
		campoTitulo.setFieldName("titulo");
		campoTitulo.setCss("form-control");
		campoTitulo.setOrder(2);
		campoTitulo.setComponentType("texto");
		campoTitulo.setReadOnly(false);
		campoTitulo.setHidden(false);
		campoTitulo.setRequired(true);
		campoTitulo.setShowInBasket(true);
		campoTitulo.setId(false);


		campoVista.setName("Vista");
		campoVista.setFieldName("vista");
		campoVista.setCss("form-control");
		campoVista.setOrder(4);
		campoVista.setComponentType("texto");
		campoVista.setReadOnly(false);
		campoVista.setHidden(false);
		campoVista.setRequired(true);
		campoVista.setShowInBasket(true);
		campoVista.setValue("vista");
		campoVista.setId(false);

		campoVersion.setName("Version");
		campoVersion.setFieldName("version");
		campoVersion.setCss("form-control");
		campoVersion.setOrder(6);
		campoVersion.setComponentType("texto");
		campoVersion.setReadOnly(true);
		campoVersion.setHidden(false);
		campoVersion.setRequired(true);
		campoVersion.setShowInBasket(true);
		campoVersion.setValue("1.0");
		campoVersion.setId(false);

		campoStatus.setName("Status");
		campoStatus.setFieldName("status");
		campoStatus.setCss("form-control");
		campoStatus.setOrder(7);
		campoStatus.setComponentType("status");
		campoStatus.setReadOnly(false);
		campoStatus.setHidden(false);
		campoStatus.setRequired(true);
		campoStatus.setShowInBasket(true);
		campoStatus.setValue("borrador");
		campoStatus.setId(false);

		campoModulo.setName("Modulo");
		campoModulo.setFieldName("modulo");
		campoModulo.setCss("form-control");
		campoModulo.setOrder(7);
		campoModulo.setComponentType("modulos");
		campoModulo.setReadOnly(false);
		campoModulo.setHidden(false);
		campoModulo.setRequired(true);
		campoModulo.setShowInBasket(true);
		campoModulo.setId(false);
		campoModulo.setOrigin("{\"origen\":\"recurso\",\"objeto\":\"modulos\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");

		campoCreable.setName("Mostrar en menu de crear");
		campoCreable.setFieldName("creable");
		campoCreable.setCss("form-control");
		campoCreable.setOrder(9);
		campoCreable.setComponentType("checkbox");
		campoCreable.setReadOnly(false);
		campoCreable.setHidden(false);
		campoCreable.setRequired(true);
		campoCreable.setShowInBasket(false);
		campoCreable.setValue("false");
		campoCreable.setId(false);

		campoBd.setName("Nombre de la forma");
		campoBd.setFieldName("bd");
		campoBd.setCss("form-control");
		campoBd.setOrder(10);
		campoBd.setComponentType("texto");
		campoBd.setReadOnly(false);
		campoBd.setHidden(false);
		campoBd.setRequired(true);
		campoBd.setShowInBasket(true);
		campoBd.setValue("");
		campoBd.setId(true);
		
		campoInstruccion.setName("Leyenda");
		campoInstruccion.setFieldName("instruccion");
		campoInstruccion.setCss("form-control");
		campoInstruccion.setOrder(11);
		campoInstruccion.setComponentType("texto");
		campoInstruccion.setReadOnly(false);
		campoInstruccion.setHidden(false);
		campoInstruccion.setRequired(true);
		campoInstruccion.setShowInBasket(true);
		campoInstruccion.setValue("");
		campoInstruccion.setId(true);
		
		campos.add(campoTitulo);
		campos.add(campoCodigo);
		campos.add(campoVista);
		
		campos.add(campoVersion);
		campos.add(campoStatus);
		campos.add(campoModulo);
		campos.add(campoCreable);
		campos.add(campoBd);
		campos.add(campoInstruccion);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("basket");
		forma.setView("basket");
		forma.setTitle("Canasta");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("case");
		forma.setBasket("basket");
		forma.setCreateable(true);
		forma.setTable("basket");
		forma.setValidate(true);
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
	
	@Test
	public void testGuardarFormaCaseAccion() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("accion.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();

		Resource forma = new Resource();
		Field campoAccion = new Field();
		Field campoMostrar = new Field();
		Field campoTitulo = new Field();

		Field campoOrden = new Field();
		Field campoType = new Field();
		Field campoLectura = new Field();

		Field campoOculto = new Field();
		Field campoRequerido = new Field();
		Field campoLista = new Field();
		//Campo campoVersion = new Campo();
		Field campoEvento = new Field();
		Field campoVista = new Field();
		Field campoForma = new Field();
		Field campoStatus = new Field();

		Button guardar = new Button();
		guardar.setName("guardar");
		guardar.setCommandName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("accion");
		guardar.setModule("case");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		guardar.setView("forma");

		Button actualizar = new Button();
		actualizar.setName("actualizar");
		actualizar.setCommandName("actualizar");
		actualizar.setLabel("Actualizar");
		actualizar.setComponentType("botonjs");
		actualizar.setCss("btn btn-primary");
		actualizar.setResourceName("accion");
		actualizar.setModule("case");
		actualizar.setOrder(1);
		actualizar.setResourceType("forma");
		actualizar.setVersion("1.0");
		actualizar.setEvents("detalle");
		actualizar.setView("forma");

		acciones.add(actualizar);
		acciones.add(guardar);
		
		campoAccion.setName("Accion");
		campoAccion.setFieldName("accion");
		campoAccion.setCss("form-control");
		campoAccion.setOrder(1);
		campoAccion.setComponentType("texto");
		campoAccion.setReadOnly(false);
		campoAccion.setHidden(false);
		campoAccion.setRequired(true);
		campoAccion.setShowInBasket(true);
		campoAccion.setId(true);
		campoAccion.setFormat("Accion");
		campoAccion.setGroup("cabecero");

		campoTitulo.setName("Nombre");
		campoTitulo.setFieldName("nombre");
		campoTitulo.setCss("form-control");
		campoTitulo.setOrder(2);
		campoTitulo.setComponentType("texto");
		campoTitulo.setReadOnly(false);
		campoTitulo.setHidden(false);
		campoTitulo.setRequired(true);
		campoTitulo.setShowInBasket(true);
		campoTitulo.setId(false);
		campoTitulo.setFormat("Nombre");
		campoTitulo.setGroup("cabecero");

		campoMostrar.setName("Titulo");
		campoMostrar.setFieldName("titulo");
		campoMostrar.setCss("form-control");
		campoMostrar.setOrder(3);
		campoMostrar.setComponentType("texto");
		campoMostrar.setReadOnly(false);
		campoMostrar.setHidden(false);
		campoMostrar.setRequired(true);
		campoMostrar.setShowInBasket(true);
		campoMostrar.setId(false);
		campoMostrar.setFormat("Titulo");
		campoMostrar.setGroup("cabecero");

		campoOrden.setName("Componente");
		campoOrden.setFieldName("type");
		campoOrden.setCss("form-control");
		campoOrden.setOrder(4);
		campoOrden.setComponentType("tipos");
		campoOrden.setReadOnly(false);
		campoOrden.setHidden(false);
		campoOrden.setRequired(true);
		campoOrden.setShowInBasket(true);
		campoOrden.setId(false);
		campoOrden.setFormat("Componente");
		campoOrden.setGroup("cabecero");
		campoOrden.setOrigin("{\"origen\":\"recurso\",\"objeto\":\"tipos\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");


		campoType.setName("Css");
		campoType.setFieldName("css");
		campoType.setCss("form-control");
		campoType.setOrder(5);
		campoType.setComponentType("texto");
		campoType.setReadOnly(false);
		campoType.setHidden(false);
		campoType.setRequired(true);
		campoType.setShowInBasket(true);
		campoType.setId(false);
		campoType.setFormat("Css");
		campoType.setGroup("cabecero");
		campoType.setValue("btn btn-primary");

		campoOculto.setName("Modulo");
		campoOculto.setFieldName("modulo");
		campoOculto.setCss("form-control");
		campoOculto.setOrder(6);
		campoOculto.setComponentType("modulos");
		campoOculto.setReadOnly(false);
		campoOculto.setHidden(false);
		campoOculto.setRequired(true);
		campoOculto.setShowInBasket(true);
		campoOculto.setId(false);
		campoOculto.setFormat("modulo");
		campoOculto.setGroup("cabecero");
		campoOculto.setOrigin("{\"origen\":\"recurso\",\"objeto\":\"modulos\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");

		
		campoLectura.setName("Forma");
		campoLectura.setFieldName("forma");
		campoLectura.setCss("form-control");
		campoLectura.setOrder(7);
		campoLectura.setComponentType("texto");
		campoLectura.setReadOnly(false);
		campoLectura.setHidden(false);
		campoLectura.setRequired(true);
		campoLectura.setShowInBasket(true);
		campoLectura.setId(false);
		campoLectura.setFormat("forma");
		campoLectura.setGroup("cabecero");

		campoRequerido.setName("Orden");
		campoRequerido.setFieldName("orden");
		campoRequerido.setCss("form-control");
		campoRequerido.setOrder(8);
		campoRequerido.setComponentType("texto");
		campoRequerido.setReadOnly(false);
		campoRequerido.setHidden(false);
		campoRequerido.setRequired(true);
		campoRequerido.setShowInBasket(true);
		campoRequerido.setId(false);
		campoRequerido.setFormat("Orden");
		campoRequerido.setGroup("cabecero");

		campoLista.setName("Tipo");
		campoLista.setFieldName("tipo");
		campoLista.setCss("form-control");
		campoLista.setOrder(9);
		campoLista.setComponentType("tipos");
		campoLista.setReadOnly(false);
		campoLista.setHidden(false);
		campoLista.setRequired(true);
		campoLista.setShowInBasket(true);
		campoLista.setId(false);
		campoLista.setFormat("Tipo");
		campoLista.setGroup("cabecero");
		campoLista.setOrigin("{\"origen\":\"recurso\",\"objeto\":\"tipos\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");

		/*
		 * campoVersion.setNombre("Version"); campoVersion.setBd("version");
		 * campoVersion.setCss("form-control"); campoVersion.setOrden(10);
		 * campoVersion.setType("texto"); campoVersion.setLectura(false);
		 * campoVersion.setOculto(false); campoVersion.setRequerido(true);
		 * campoVersion.setLista(true); campoVersion.setId(false);
		 * campoVersion.setFormato("Version"); campoVersion.setGrupo("cabecero");
		 */

		campoEvento.setName("Evento");
		campoEvento.setFieldName("evento");
		campoEvento.setCss("form-control");
		campoEvento.setOrder(11);
		campoEvento.setComponentType("evento");
		campoEvento.setReadOnly(false);
		campoEvento.setHidden(false);
		campoEvento.setRequired(true);
		campoEvento.setShowInBasket(true);
		campoEvento.setId(false);
		campoEvento.setFormat("Evento");
		campoEvento.setGroup("cabecero");
		campoEvento.setOrigin("{\"origen\":\"recurso\",\"objeto\":\"acciones\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");


		campoVista.setName("Vista");
		campoVista.setFieldName("vista");
		campoVista.setCss("form-control");
		campoVista.setOrder(11);
		campoVista.setComponentType("texto");
		campoVista.setReadOnly(false);
		campoVista.setHidden(false);
		campoVista.setRequired(false);
		campoVista.setShowInBasket(true);
		campoVista.setId(false);
		campoVista.setFormat("Vista");
		campoVista.setGroup("cabecero");

		campoForma.setName("Forma");
		campoForma.setFieldName("dis-forma");
		campoForma.setCss("form-control");
		campoForma.setOrder(14);
		campoForma.setComponentType("texto");
		campoForma.setReadOnly(false);
		campoForma.setHidden(true);
		campoForma.setRequired(true);
		campoForma.setShowInBasket(true);
		campoForma.setId(false);
		campoForma.setFormat("Forma");
		campoForma.setGroup("cabecero");
		campoForma.setPersistible(false);
		
		campoStatus.setName("Status");
		campoStatus.setFieldName("status");
		campoStatus.setCss("form-control");
		campoStatus.setOrder(14);
		campoStatus.setComponentType("texto");
		campoStatus.setReadOnly(true);
		campoStatus.setHidden(true);
		campoStatus.setRequired(true);
		campoStatus.setShowInBasket(true);
		campoStatus.setId(false);
		campoStatus.setFormat("Status");
		campoStatus.setGroup("cabecero");
		campoStatus.setPersistible(true);
		campoStatus.setValue("actualizar");
		
		campos.add(campoTitulo);
		campos.add(campoMostrar);
		campos.add(campoAccion);
		campos.add(campoOrden);
		campos.add(campoType);
		campos.add(campoLectura);
		campos.add(campoOculto);
		campos.add(campoRequerido);
		//campos.add(campoLista);
		campos.add(campoEvento);
		//campos.add(campoVersion);
		campos.add(campoVista);
		campos.add(campoForma);
		campos.add(campoStatus);
		
		forma.setModel(campos);
		forma.setMethods(acciones);

		forma.setCommandName("guardar");
		forma.setName("accion");
		forma.setView("accion");
		forma.setTitle("Accion");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("case");
		forma.setBasket("lista");
		forma.setCreateable(false);
		forma.setValidate(true);
		forma.setTable("accion");
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

	@Test
	public void testGuardarFormaCaseCampo() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("campo.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();

		Resource forma = new Resource();
		Field campoCodigo = new Field();
		Field campoMostrar = new Field();
		Field campoTitulo = new Field();

		Field campoOrden = new Field();
		Field campoType = new Field();
		Field campoDbtype = new Field();
		Field campoLectura = new Field();
		Field campoValidacion = new Field();
		
		Field campoFormato = new Field();
		Field campoGrupo = new Field();
		Field campoForma = new Field();
		
		Field campoOculto = new Field();
		Field campoRequerido = new Field();
		Field campoLista = new Field();
		Field campoId = new Field();
		Field campoLongitud = new Field();
		Field campoBuscable = new Field();
		Field campoDecimales = new Field();
		Field campoPersistible = new Field();
		Field campoLeyenda = new Field();
		
		Button guardar = new Button();
		guardar.setName("guardar");
		guardar.setCommandName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("campo");
		guardar.setModule("case");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		guardar.setView("forma");

		Button actualizar = new Button();
		actualizar.setName("actualizar");
		actualizar.setCommandName("actualizar");
		actualizar.setLabel("Actualizar");
		actualizar.setComponentType("botonjs");
		actualizar.setCss("btn btn-primary");
		actualizar.setResourceName("campo");
		actualizar.setModule("case");
		actualizar.setOrder(1);
		actualizar.setResourceType("forma");
		actualizar.setVersion("1.0");
		actualizar.setEvents("detalle");
		actualizar.setView("forma");

		/*Accion cancelar = new Accion();
		cancelar.setNombre("cancelar");
		cancelar.setAccion("cancelar");
		cancelar.setTitulo("Cancelar");
		cancelar.setType("botonjs");
		cancelar.setCss("btn btn-secondary");
		cancelar.setForma("campo");
		cancelar.setModulo("case");
		cancelar.setOrden(2);
		cancelar.setTipo("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvento("nuevo");*/
		acciones.add(guardar);
		acciones.add(actualizar);
		//acciones.add(cancelar);

		campoCodigo.setName("Titulo de campo");
		campoCodigo.setFieldName("nombre");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setFormat("Titulo de campo");
		campoCodigo.setGroup("cabecero");
		campoCodigo.setLength(50);

		campoTitulo.setName("Campo en Bd");
		campoTitulo.setFieldName("bd");
		campoTitulo.setCss("form-control");
		campoTitulo.setOrder(2);
		campoTitulo.setComponentType("texto");
		campoTitulo.setReadOnly(false);
		campoTitulo.setHidden(false);
		campoTitulo.setRequired(true);
		campoTitulo.setShowInBasket(true);
		campoTitulo.setId(false);
		campoTitulo.setFormat("Bd");
		campoTitulo.setGroup("cabecero");
		campoTitulo.setLength(20);

		campoMostrar.setName("Css");
		campoMostrar.setFieldName("css");
		campoMostrar.setCss("form-control");
		campoMostrar.setOrder(3);
		campoMostrar.setComponentType("texto");
		campoMostrar.setReadOnly(false);
		campoMostrar.setHidden(false);
		campoMostrar.setRequired(true);
		campoMostrar.setShowInBasket(true);
		campoMostrar.setId(false);
		campoMostrar.setFormat("Css");
		campoMostrar.setGroup("cabecero");
		campoMostrar.setLength(50);
		campoMostrar.setValue("form-control");

		campoOrden.setName("Orden");
		campoOrden.setFieldName("orden");
		campoOrden.setCss("form-control");
		campoOrden.setOrder(4);
		campoOrden.setComponentType("texto");
		campoOrden.setReadOnly(false);
		campoOrden.setHidden(false);
		campoOrden.setRequired(true);
		campoOrden.setShowInBasket(true);
		campoOrden.setId(false);
		campoOrden.setFormat("Orden");
		campoOrden.setGroup("cabecero");
		campoOrden.setLength(10);

		campoType.setName("Tipo");
		campoType.setFieldName("type");
		campoType.setCss("form-control");
		campoType.setOrder(5);
		campoType.setComponentType("tipos");
		campoType.setReadOnly(false);
		campoType.setHidden(false);
		campoType.setRequired(true);
		campoType.setShowInBasket(true);
		campoType.setId(false);
		campoType.setFormat("Tipo");
		campoType.setGroup("cabecero");
		campoType.setOrigin("{\"origen\":\"recurso\",\"objeto\":\"tiposcampos\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");
		campoType.setLength(50);

		campoLectura.setName("Lectura");
		campoLectura.setFieldName("lectura");
		campoLectura.setCss("form-control");
		campoLectura.setOrder(6);
		campoLectura.setComponentType("checkbox");
		campoLectura.setReadOnly(false);
		campoLectura.setHidden(false);
		campoLectura.setRequired(true);
		campoLectura.setShowInBasket(true);
		campoLectura.setId(false);
		campoLectura.setFormat("lectura");
		campoLectura.setGroup("cabecero");

		campoOculto.setName("Oculto");
		campoOculto.setFieldName("oculto");
		campoOculto.setCss("form-control");
		campoOculto.setOrder(7);
		campoOculto.setComponentType("checkbox");
		campoOculto.setReadOnly(false);
		campoOculto.setHidden(false);
		campoOculto.setRequired(true);
		campoOculto.setShowInBasket(true);
		campoOculto.setId(false);
		campoOculto.setFormat("Oculto");
		campoOculto.setGroup("cabecero");

		campoRequerido.setName("Requerido");
		campoRequerido.setFieldName("requerido");
		campoRequerido.setCss("form-control");
		campoRequerido.setOrder(8);
		campoRequerido.setComponentType("checkbox");
		campoRequerido.setReadOnly(false);
		campoRequerido.setHidden(false);
		campoRequerido.setRequired(true);
		campoRequerido.setShowInBasket(true);
		campoRequerido.setId(false);
		campoRequerido.setFormat("Requerido");
		campoRequerido.setGroup("cabecero");

		campoLista.setName("Lista");
		campoLista.setFieldName("lista");
		campoLista.setCss("form-control");
		campoLista.setOrder(9);
		campoLista.setComponentType("checkbox");
		campoLista.setReadOnly(false);
		campoLista.setHidden(false);
		campoLista.setRequired(true);
		campoLista.setShowInBasket(true);
		campoLista.setId(false);
		campoLista.setFormat("Lista");
		campoLista.setGroup("cabecero");

		campoId.setName("Id");
		campoId.setFieldName("id");
		campoId.setCss("form-control");
		campoId.setOrder(10);
		campoId.setComponentType("checkbox");
		campoId.setReadOnly(false);
		campoId.setHidden(false);
		campoId.setRequired(true);
		campoId.setShowInBasket(true);
		campoId.setId(false);
		campoId.setFormat("Id");
		campoId.setGroup("cabecero");

		campoBuscable.setName("Buscable");
		campoBuscable.setFieldName("buscable");
		campoBuscable.setCss("form-control");
		campoBuscable.setOrder(11);
		campoBuscable.setComponentType("checkbox");
		campoBuscable.setReadOnly(false);
		campoBuscable.setHidden(false);
		campoBuscable.setRequired(true);
		campoBuscable.setShowInBasket(true);
		campoBuscable.setId(false);
		campoBuscable.setFormat("Buscable");
		campoBuscable.setGroup("cabecero");
		
		
		campoLongitud.setName("Longitud");
		campoLongitud.setFieldName("longitud");
		campoLongitud.setCss("form-control");
		campoLongitud.setOrder(12);
		campoLongitud.setComponentType("texto");
		campoLongitud.setReadOnly(false);
		campoLongitud.setHidden(false);
		campoLongitud.setRequired(true);
		campoLongitud.setShowInBasket(true);
		campoLongitud.setId(false);
		campoLongitud.setFormat("Longitud");
		campoLongitud.setGroup("cabecero");
		
		campoValidacion.setName("Validacion");
		campoValidacion.setFieldName("validacion");
		campoValidacion.setCss("form-control");
		campoValidacion.setOrder(13);
		campoValidacion.setComponentType("texto");
		campoValidacion.setReadOnly(false);
		campoValidacion.setHidden(false);
		campoValidacion.setRequired(false);
		campoValidacion.setShowInBasket(true);
		campoValidacion.setId(false);
		campoValidacion.setFormat("Validacion");
		campoValidacion.setGroup("cabecero");
		
		campoFormato.setName("Formato");
		campoFormato.setFieldName("formato");
		campoFormato.setCss("form-control");
		campoFormato.setOrder(14);
		campoFormato.setComponentType("texto");
		campoFormato.setReadOnly(false);
		campoFormato.setHidden(true);
		campoFormato.setRequired(true);
		campoFormato.setShowInBasket(true);
		campoFormato.setId(false);
		campoFormato.setFormat("Formato");
		campoFormato.setGroup("cabecero");
		
		campoGrupo.setName("Grupo");
		campoGrupo.setFieldName("grupo");
		campoGrupo.setCss("form-control");
		campoGrupo.setOrder(15);
		campoGrupo.setComponentType("texto");
		campoGrupo.setReadOnly(false);
		campoGrupo.setHidden(false);
		campoGrupo.setRequired(true);
		campoGrupo.setShowInBasket(true);
		campoGrupo.setId(false);
		campoGrupo.setFormat("Grupo");
		campoGrupo.setGroup("cabecero");
		
		campoForma.setName("Forma");
		campoForma.setLabel("Fomra");
		campoForma.setFieldName("dis-forma");
		campoForma.setCss("form-control");
		campoForma.setOrder(16);
		campoForma.setComponentType("texto");
		campoForma.setReadOnly(false);
		campoForma.setHidden(true);
		campoForma.setRequired(true);
		campoForma.setShowInBasket(true);
		campoForma.setId(false);
		campoForma.setFormat("Forma");
		campoForma.setGroup("cabecero");
		campoForma.setPersistible(false);
		
		campoDbtype.setName("Tipo BD");
		campoDbtype.setLabel("Tipo Campo en BD");
		campoDbtype.setFieldName("dbtype");
		campoDbtype.setCss("form-control");
		campoDbtype.setOrder(17);
		campoDbtype.setComponentType("texto");
		campoDbtype.setReadOnly(false);
		campoDbtype.setHidden(true);
		campoDbtype.setRequired(true);
		campoDbtype.setShowInBasket(true);
		campoDbtype.setId(false);
		campoDbtype.setFormat("Tipo Bd");
		campoDbtype.setGroup("cabecero");
		campoDbtype.setPersistible(false);
		campoDbtype.setDbFieldType("varchar");
		
		campoDecimales.setName("Decimales");
		campoDecimales.setLabel("Decimales");
		campoDecimales.setFieldName("decimales");
		campoDecimales.setCss("form-control");
		campoDecimales.setOrder(18);
		campoDecimales.setComponentType("texto");
		campoDecimales.setReadOnly(false);
		campoDecimales.setHidden(false);
		campoDecimales.setRequired(true);
		campoDecimales.setShowInBasket(true);
		campoDecimales.setId(false);
		campoDecimales.setFormat("Decimales");
		campoDecimales.setGroup("cabecero");
		campoDecimales.setPersistible(false);
		campoDecimales.setDecimals(0);
		
		campoPersistible.setName("Persistible");
		campoPersistible.setLabel("Persistible");
		campoPersistible.setFieldName("persistible");
		campoPersistible.setCss("form-control");
		campoPersistible.setOrder(19);
		campoPersistible.setComponentType("checkbox");
		campoPersistible.setReadOnly(false);
		campoPersistible.setHidden(false);
		campoPersistible.setRequired(true);
		campoPersistible.setShowInBasket(true);
		campoPersistible.setId(false);
		campoPersistible.setFormat("Persistible");
		campoPersistible.setGroup("cabecero");
		campoPersistible.setPersistible(false);
		campoPersistible.setDecimals(0);
		
		campoLeyenda.setName("Leyenda");
		campoLeyenda.setLabel("Leyenda");
		campoLeyenda.setFieldName("leyenda");
		campoLeyenda.setCss("form-control");
		campoLeyenda.setOrder(20);
		campoLeyenda.setComponentType("texto");
		campoLeyenda.setReadOnly(false);
		campoLeyenda.setHidden(false);
		campoLeyenda.setRequired(true);
		campoLeyenda.setShowInBasket(true);
		campoLeyenda.setId(false);
		campoLeyenda.setFormat("Persistible");
		campoLeyenda.setGroup("cabecero");
		campoLeyenda.setPersistible(false);
		campoLeyenda.setDecimals(0);
		
		campos.add(campoTitulo);
		campos.add(campoMostrar);
		campos.add(campoCodigo);
		campos.add(campoOrden);
		campos.add(campoType);
		campos.add(campoDbtype);
		campos.add(campoLectura);
		campos.add(campoOculto);
		campos.add(campoRequerido);
		campos.add(campoLista);
		campos.add(campoId);
		campos.add(campoLongitud);
		campos.add(campoValidacion);
		campos.add(campoFormato);
		campos.add(campoGrupo);
		campos.add(campoForma);
		campos.add(campoBuscable);
		campos.add(campoDecimales);
		campos.add(campoPersistible);
		campos.add(campoLeyenda);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("campo");
		forma.setView("campo");
		forma.setTitle("Campo");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("case");
		forma.setBasket("lista");
		forma.setCreateable(false);
		forma.setValidate(true);
		forma.setTable("campo");
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

	@Test
	public void testGuardarFormaCaseCaracteristica() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("caracteristica.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();

		Resource forma = new Resource();
		Field campoCodigo = new Field();
		Field campoMostrar = new Field();
		Field campoTitulo = new Field();

		Field campoOrden = new Field();
		Field campoRegistro = new Field();

		Button guardar = new Button();
		guardar.setName("guardar");
		guardar.setCommandName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("caracteristica");
		guardar.setModule("inventario");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		guardar.setView("caracteristica");

		acciones.add(guardar);

		campoCodigo.setName("Padre");
		campoCodigo.setFieldName("padre");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(false);
		campoCodigo.setFormat("Padre");
		campoCodigo.setGroup("cabecero");
		campoCodigo.setLength(20);

		campoTitulo.setName("Origen");
		campoTitulo.setFieldName("origen");
		campoTitulo.setCss("form-control");
		campoTitulo.setOrder(2);
		campoTitulo.setComponentType("texto");
		campoTitulo.setReadOnly(false);
		campoTitulo.setHidden(false);
		campoTitulo.setRequired(true);
		campoTitulo.setShowInBasket(true);
		campoTitulo.setId(false);
		campoTitulo.setFormat("Otigrn");
		campoTitulo.setGroup("cabecero");
		campoTitulo.setLength(50);

		campoMostrar.setName("Nombre");
		campoMostrar.setFieldName("nombre");
		campoMostrar.setCss("form-control");
		campoMostrar.setOrder(3);
		campoMostrar.setComponentType("texto");
		campoMostrar.setReadOnly(false);
		campoMostrar.setHidden(false);
		campoMostrar.setRequired(true);
		campoMostrar.setShowInBasket(true);
		campoMostrar.setId(false);
		campoMostrar.setFormat("Nombre");
		campoMostrar.setGroup("cabecero");
		campoMostrar.setLength(50);

		campoOrden.setName("Valor");
		campoOrden.setFieldName("valor");
		campoOrden.setCss("form-control");
		campoOrden.setOrder(4);
		campoOrden.setComponentType("texto");
		campoOrden.setReadOnly(false);
		campoOrden.setHidden(false);
		campoOrden.setRequired(true);
		campoOrden.setShowInBasket(true);
		campoOrden.setId(false);
		campoOrden.setFormat("Valor");
		campoOrden.setGroup("cabecero");
		campoOrden.setLength(20);

		campoRegistro.setName("Registro");
		campoRegistro.setFieldName("registro");
		campoRegistro.setCss("form-control");
		campoRegistro.setOrder(5);
		campoRegistro.setComponentType("texto");
		campoRegistro.setReadOnly(false);
		campoRegistro.setHidden(false);
		campoRegistro.setRequired(true);
		campoRegistro.setShowInBasket(true);
		campoRegistro.setId(false);
		campoRegistro.setFormat("Registro");
		campoRegistro.setGroup("cabecero");		
		campoRegistro.setLength(50);

		campos.add(campoTitulo);
		campos.add(campoMostrar);
		campos.add(campoCodigo);
		campos.add(campoOrden);
		campos.add(campoRegistro);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("caracteristica");
		forma.setView("caracteristica");
		forma.setTitle("Caracteristica");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setBasket("caracteristica");
		forma.setCreateable(false);
		forma.setValidate(true);
		forma.setTable("caracteristica");
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
	
	/**
	 * Test method for
	 * {@link com.formuscmp.formus.generator.Generador#getCampos(java.lang.String)}.
	 */
	@Test
	public void testGetCampos() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		System.out.println(fileConfigLocation);
		Path filePath = fileConfigLocation.resolve("jugador.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		try {
			Resource forma = generador.get(filePath, Resource.class);

		} catch (JsonParseException e) {
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

	// getCampoCampo

	/**
	 * Test method for
	 * {@link com.formuscmp.formus.generator.Generador#getCampos(java.lang.String)}.
	 */
	@Test
	public void testGetCampo() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve("jugador.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		try {
			Resource forma = generador.get(filePath, Resource.class);

			Map<String, Object> data = new HashMap<String, Object>();
			data.put("a", 3);
			data.put("b", 5);
			data.put("type", forma.getModel().get(0).getComponentType());
			data.put("campo", forma.getModel().get(2));
			data.put("accion", "nuevo");

			//System.out.println(generador.getCampo(forma.getCampos().get(0).getType(), data, null, "ftl"));
			// forma.get

		} catch (JsonParseException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void testGuardarForma() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("jugador.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();

		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();
		Field posicion = new Field();
		Field goles = new Field();
		Field puntuacion = new Field();

		/*Campo nombreAccion = new Campo();
		Campo empresa = new Campo();
		Campo nombreModulo = new Campo();
		Campo version = new Campo();
		Campo nombreForma = new Campo();
		Campo tipo = new Campo();
		Campo formato = new Campo();
		Campo vista = new Campo();*/



		Resource forma = new Resource();

		Button guardar = new Button();
		guardar.setName("nuevo");
		guardar.setLabel("Registrar pedido");
		guardar.setComponentType("botonliga");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("jugador");
		guardar.setModule("directorio");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button cancelar = new Button();
		cancelar.setName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setResourceName("jugador");
		cancelar.setModule("directorio");
		cancelar.setOrder(2);
		cancelar.setResourceType("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvents("nuevo");
		acciones.add(guardar);
		acciones.add(cancelar);

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setValidation("[0-9]*");

		campoCampo.setName("Nombre(s) del jugador");
		campoCampo.setFieldName("nombre");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(2);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);

		aMaterno.setName("A. Materno");
		aMaterno.setFieldName("amaterno");
		aMaterno.setCss("form-control");
		aMaterno.setOrder(3);
		aMaterno.setComponentType("texto");
		aMaterno.setReadOnly(false);
		aMaterno.setHidden(false);
		aMaterno.setRequired(true);
		aMaterno.setShowInBasket(true);
		aMaterno.setId(false);

		aPaterno.setName("A. Paterno");
		aPaterno.setFieldName("apaterno");
		aPaterno.setCss("form-control");
		aPaterno.setOrder(4);
		aPaterno.setComponentType("texto");
		aPaterno.setReadOnly(false);
		aPaterno.setHidden(false);
		aPaterno.setRequired(true);
		aPaterno.setShowInBasket(true);
		aPaterno.setId(false);

		fNacim.setName("Fecha de nacimiento");
		fNacim.setFieldName("fnacim");
		fNacim.setCss("campo-fecha");
		fNacim.setOrder(5);
		fNacim.setComponentType("numero");
		fNacim.setReadOnly(false);
		fNacim.setHidden(false);
		fNacim.setRequired(true);
		fNacim.setShowInBasket(false);
		fNacim.setId(false);

		posicion.setName("Posicion");
		posicion.setFieldName("posicion");
		posicion.setCss("form-control");
		posicion.setOrder(6);
		posicion.setComponentType("texto");
		posicion.setReadOnly(false);
		posicion.setHidden(false);
		posicion.setRequired(false);
		posicion.setShowInBasket(false);
		posicion.setId(false);

		puntuacion.setName("Puntuacion");
		puntuacion.setFieldName("puntuacion");
		puntuacion.setCss("form-control");
		puntuacion.setOrder(7);
		puntuacion.setComponentType("numero");
		puntuacion.setReadOnly(false);
		puntuacion.setHidden(false);
		puntuacion.setRequired(false);
		puntuacion.setShowInBasket(false);
		puntuacion.setId(false);

		goles.setName("Goles");
		goles.setFieldName("goles");
		goles.setCss("form-control");
		goles.setOrder(8);
		goles.setComponentType("numero");
		goles.setReadOnly(false);
		goles.setHidden(false);
		goles.setRequired(false);
		goles.setShowInBasket(false);
		goles.setId(false);

		campos.add(aPaterno);
		campos.add(goles);
		campos.add(fNacim);
		campos.add(posicion);
		campos.add(puntuacion);
		campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campoCodigo);
		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("jugador");
		forma.setView("jugador");
		forma.setTitle("Jugador");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("futbol");
		forma.setBasket("jugador");
		forma.setCreateable(true);
		forma.setTable("jugador");
		forma.setValidate(true);
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

	@Test
	public void testGuardarFormaProducto() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("producto.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();

		Field tipo = new Field();
		Field codigo = new Field();
		Field sat = new Field();
		Field calterno = new Field();
		Field descripcion = new Field();
		Field uentrada = new Field();
		Field usalida = new Field();
		Field categoria = new Field();
		Field factor = new Field();
		Field uempaque = new Field();
		Field tsurtido = new Field();
		Field imagen = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		/*Campo longitud = new Campo();
		Campo altura = new Campo();
		Campo grosor = new Campo();
		Campo peso = new Campo();
		Campo ancho = new Campo();*/

		Field noserie = new Field();
		Field lote = new Field();
		Field pedimento = new Field();
		Field cmoneda = new Field();
		Field ccontable = new Field();
		Field costeo = new Field();
		Field existencias = new Field();
		Field sminimo = new Field();
		Field smaximo = new Field();
		Field comprometido = new Field();
		Field porrecibir = new Field();
		Field porsurtir = new Field();
		Field obs = new Field();
		Field status = new Field();

		Resource forma = new Resource();
		List<Field> decoradoresBuscar = new ArrayList<Field>();


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("producto");
		guardar.setModule("inventario");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button cancelar = new Button();
		cancelar.setCommandName("cancelar");
		cancelar.setName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setResourceName("producto");
		cancelar.setModule("inventario");
		cancelar.setOrder(1);
		cancelar.setResourceType("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvents("nuevo");


		Button editar = new Button();
		editar.setCommandName("actualizar");
		editar.setName("actualizar");
		editar.setLabel("Actualizar");
		editar.setComponentType("botonjs");
		editar.setCss("btn btn-info");
		editar.setResourceName("producto");
		editar.setModule("inventario");
		editar.setOrder(2);
		editar.setResourceType("forma");
		editar.setVersion("1.0");
		editar.setEvents("detalle");

		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Buscar");
		buscar.setComponentType("submit");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("basket");
		buscar.setVersion("1.0");
		buscar.setEvents("buscar");

		acciones.add(buscar);
		acciones.add(guardar);
		acciones.add(editar);
		acciones.add(cancelar);

		tipo.setName("Tipo");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("producto");
		tipo.setFormat("{TIPO}");
		tipo.setSearcheable(true);

		//decoradores
		/*Campo decoradorTipo = new Campo();
		decoradorTipo.setNombre("Tipo");
		decoradorTipo.setBd("tipo");
		decoradorTipo.setCss("form-control");
		decoradorTipo.setOrden(1);
		decoradorTipo.setType("texto");
		decoradorTipo.setLectura(true);
		decoradorTipo.setOculto(true);
		decoradorTipo.setRequerido(false);
		decoradorTipo.setLista(true);
		decoradorTipo.setId(false);
		decoradorTipo.setLongitud(20);
		decoradorTipo.setGrupo("cabecero");
		decoradorTipo.setPersistible(true);
		decoradorTipo.setValor("producto");
		decoradorTipo.setFormato("{TIPO}");
		decoradorTipo.setBuscable(true);

		decoradoresBuscar.add(decoradorTipo);*/

		codigo.setName("Codigo");
		codigo.setFieldName("codigo");
		codigo.setCss("form-control");
		codigo.setOrder(2);
		codigo.setComponentType("texto");
		codigo.setReadOnly(true);
		codigo.setHidden(false);
		codigo.setRequired(false);
		codigo.setShowInBasket(true);
		codigo.setId(true);
		codigo.setLength(20);
		codigo.setGroup("cabecero");
		codigo.setPersistible(true);
		codigo.setValue("");
		//codigo.setAutogenerado(false);
		codigo.setFormat("{TIPO-CONS}");
		codigo.setSearcheable(true);


		//decoradores
		Field decoradorCodigo = new Field();
		decoradorCodigo.setName("Codigo");
		decoradorCodigo.setFieldName("codigo");
		decoradorCodigo.setCss("form-control");
		decoradorCodigo.setOrder(2);
		decoradorCodigo.setComponentType("texto");
		decoradorCodigo.setReadOnly(true);
		decoradorCodigo.setHidden(false);
		decoradorCodigo.setRequired(false);
		decoradorCodigo.setShowInBasket(true);
		decoradorCodigo.setId(true);
		decoradorCodigo.setLength(20);
		decoradorCodigo.setGroup("cabecero");
		decoradorCodigo.setPersistible(true);
		decoradorCodigo.setValue("");
		//decoradorCodigo.setAutogenerado(false);
		decoradorCodigo.setFormat("{TIPO-CONS}");
		decoradorCodigo.setSearcheable(true);

		decoradoresBuscar.add(decoradorCodigo);

		sat.setName("Codigo SAT");
		sat.setFieldName("codigosat");
		sat.setCss("form-control");
		sat.setOrder(3);
		sat.setComponentType("texto");
		sat.setReadOnly(false);
		sat.setHidden(false);
		sat.setRequired(false);
		sat.setShowInBasket(true);
		sat.setId(false);
		sat.setLength(20);
		sat.setGroup("cabecero");
		sat.setPersistible(true);
		sat.setValue("");
		sat.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		sat.setFormat("Codigo SAT");
		sat.setSearcheable(true);

		calterno.setName("Codigo alterno");
		calterno.setFieldName("calterno");
		calterno.setCss("form-control");
		calterno.setOrder(4);
		calterno.setComponentType("texto");
		calterno.setReadOnly(false);
		calterno.setHidden(false);
		calterno.setRequired(false);
		calterno.setShowInBasket(true);
		calterno.setId(false);
		calterno.setLength(20);
		calterno.setGroup("cabecero");
		calterno.setPersistible(true);
		calterno.setValue("");
		calterno.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		calterno.setFormat("Codigo alterno");
		calterno.setSearcheable(true);

		descripcion.setName("Descripcion");
		descripcion.setFieldName("descripcion");
		descripcion.setCss("form-control");
		descripcion.setOrder(5);
		descripcion.setComponentType("texto");
		descripcion.setReadOnly(false);
		descripcion.setHidden(false);
		descripcion.setRequired(true);
		descripcion.setShowInBasket(true);
		descripcion.setId(false);
		descripcion.setLength(200);
		descripcion.setGroup("cabecero");
		descripcion.setPersistible(true);
		descripcion.setValue("");
		descripcion.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		descripcion.setFormat("Descripcion");
		descripcion.setSearcheable(true);

		uentrada.setName("U. Entrada");
		uentrada.setFieldName("uentrada");
		uentrada.setCss("form-control");
		uentrada.setOrder(6);
		uentrada.setComponentType("umedida");
		uentrada.setReadOnly(false);
		uentrada.setHidden(false);
		uentrada.setRequired(true);
		uentrada.setShowInBasket(false);
		uentrada.setId(false);
		uentrada.setLength(100);
		uentrada.setGroup("cabecero");
		uentrada.setPersistible(true);
		uentrada.setValue("");
		uentrada.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		uentrada.setFormat("U. Entrada");
		uentrada.setSearcheable(false);

		usalida.setName("U. Salida");
		usalida.setFieldName("usalida");
		usalida.setCss("form-control");
		usalida.setOrder(7);
		usalida.setComponentType("umedida");
		usalida.setReadOnly(false);
		usalida.setHidden(false);
		usalida.setRequired(true);
		usalida.setShowInBasket(false);
		usalida.setId(false);
		usalida.setLength(100);
		usalida.setGroup("cabecero");
		usalida.setPersistible(true);
		usalida.setValue("");
		usalida.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		usalida.setFormat("U. Salida");
		usalida.setSearcheable(false);

		categoria.setName("Categoria");
		categoria.setFieldName("categoria");
		categoria.setCss("form-control");
		categoria.setOrder(8);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(100);
		categoria.setGroup("cabecero");
		categoria.setPersistible(true);
		categoria.setValue("");
		categoria.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		categoria.setFormat("Categoria");
		categoria.setSearcheable(false);

		factor.setName("Factor empaque");
		factor.setFieldName("factor");
		factor.setCss("form-control");
		factor.setOrder(9);
		factor.setComponentType("moneda");
		factor.setReadOnly(false);
		factor.setHidden(false);
		factor.setRequired(true);
		factor.setShowInBasket(false);
		factor.setId(false);
		factor.setLength(100);
		factor.setGroup("cabecero");
		factor.setPersistible(true);
		factor.setValue("0");
		factor.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		factor.setFormat("Factor empaque");
		factor.setSearcheable(false);

		uempaque.setName("Unidades Empaque");
		uempaque.setFieldName("uempaque");
		uempaque.setCss("form-control");
		uempaque.setOrder(10);
		uempaque.setComponentType("moneda");
		uempaque.setReadOnly(false);
		uempaque.setHidden(false);
		uempaque.setRequired(false);
		uempaque.setShowInBasket(false);
		uempaque.setId(false);
		uempaque.setLength(100);
		uempaque.setGroup("cabecero");
		uempaque.setPersistible(true);
		uempaque.setValue("0");
		uempaque.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		uempaque.setFormat("Unidades Empaque");
		uempaque.setSearcheable(false);

		tsurtido.setName("Tiempo Surtido");
		tsurtido.setFieldName("tsurtido");
		tsurtido.setCss("form-control");
		tsurtido.setOrder(11);
		tsurtido.setComponentType("texto");
		tsurtido.setReadOnly(false);
		tsurtido.setHidden(false);
		tsurtido.setRequired(false);
		tsurtido.setShowInBasket(false);
		tsurtido.setId(false);
		tsurtido.setLength(10);
		tsurtido.setGroup("cabecero");
		tsurtido.setPersistible(true);
		tsurtido.setValue("");
		tsurtido.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		tsurtido.setFormat("Tiempo Surtido");
		tsurtido.setSearcheable(false);

		imagen.setName("Imagen");
		imagen.setFieldName("imagen");
		imagen.setCss("form-control");
		imagen.setOrder(12);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(100);
		imagen.setGroup("cabecero");
		imagen.setPersistible(true);
		imagen.setValue("0");
		imagen.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		imagen.setFormat("Imagen");
		imagen.setSearcheable(false);

		usuario.setName("Usuario");
		usuario.setFieldName("usuario");
		usuario.setCss("form-control");
		usuario.setOrder(13);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(100);
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setValue("0");
		usuario.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		usuario.setFormat("Usuario");
		usuario.setSearcheable(false);

		fecha.setName("Fecha");
		fecha.setFieldName("fecha");
		fecha.setCss("form-control");
		fecha.setOrder(14);
		fecha.setComponentType("fecha");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(20);
		fecha.setGroup("cabecero");
		fecha.setPersistible(true);
		fecha.setValue("");
		fecha.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fecha.setFormat("yyyy-MM-dd");
		fecha.setSearcheable(false);

		/*longitud.setNombre("Longitud");
		longitud.setBd("longitud");
		longitud.setCss("form-control");
		longitud.setOrden(15);
		longitud.setType("moneda");
		longitud.setLectura(false);
		longitud.setOculto(false);
		longitud.setRequerido(false);
		longitud.setLista(true);
		longitud.setId(false);
		longitud.setLongitud(10);
		longitud.setGrupo("cabecero");
		longitud.setPersistible(true);
		longitud.setValor("0");
		longitud.setValidacion("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		longitud.setFormato("Longitud");
		longitud.setBuscable(false);

		altura.setNombre("Altura");
		altura.setBd("altura");
		altura.setCss("form-control");
		altura.setOrden(16);
		altura.setType("moneda");
		altura.setLectura(false);
		altura.setOculto(false);
		altura.setRequerido(false);
		altura.setLista(true);
		altura.setId(false);
		altura.setLongitud(10);
		altura.setGrupo("cabecero");
		altura.setPersistible(true);
		altura.setValor("0");
		altura.setValidacion("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		altura.setFormato("Altura");
		altura.setBuscable(false);

		grosor.setNombre("Grosor");
		grosor.setBd("grosor");
		grosor.setCss("form-control");
		grosor.setOrden(17);
		grosor.setType("moneda");
		grosor.setLectura(false);
		grosor.setOculto(false);
		grosor.setRequerido(false);
		grosor.setLista(true);
		grosor.setId(false);
		grosor.setLongitud(10);
		grosor.setGrupo("cabecero");
		grosor.setPersistible(true);
		grosor.setValor("0");
		grosor.setValidacion("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		grosor.setFormato("Grosor");
		grosor.setBuscable(false);

		peso.setNombre("Peso");
		peso.setBd("peso");
		peso.setCss("form-control");
		peso.setOrden(18);
		peso.setType("moneda");
		peso.setLectura(false);
		peso.setOculto(false);
		peso.setRequerido(false);
		peso.setLista(true);
		peso.setId(false);
		peso.setLongitud(10);
		peso.setGrupo("cabecero");
		peso.setPersistible(true);
		peso.setValor("0");
		peso.setValidacion("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		peso.setFormato("Peso");
		peso.setBuscable(false);

		ancho.setNombre("Ancho");
		ancho.setBd("ancho");
		ancho.setCss("form-control");
		ancho.setOrden(19);
		ancho.setType("moneda");
		ancho.setLectura(false);
		ancho.setOculto(false);
		ancho.setRequerido(false);
		ancho.setLista(true);
		ancho.setId(false);
		ancho.setLongitud(10);
		ancho.setGrupo("cabecero");
		ancho.setPersistible(true);
		ancho.setValor("0");
		ancho.setValidacion("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		ancho.setFormato("Ancho");
		ancho.setBuscable(false);*/

		noserie.setName("No de series");
		noserie.setFieldName("noserie");
		noserie.setCss("form-control");
		noserie.setOrder(20);
		noserie.setComponentType("checkbox");
		noserie.setReadOnly(false);
		noserie.setHidden(false);
		noserie.setRequired(false);
		noserie.setShowInBasket(true);
		noserie.setId(false);
		noserie.setLength(10);
		noserie.setGroup("cantidades");
		noserie.setPersistible(true);
		noserie.setValue("");

		lote.setName("Lote");
		lote.setFieldName("lote");
		lote.setCss("form-control");
		lote.setOrder(21);
		lote.setComponentType("checkbox");
		lote.setReadOnly(false);
		lote.setHidden(false);
		lote.setRequired(false);
		lote.setShowInBasket(true);
		lote.setId(false);
		lote.setLength(10);
		lote.setGroup("cantidades");
		lote.setPersistible(true);
		lote.setValue("");

		pedimento.setName("Predimento aduanal");
		pedimento.setFieldName("pedimento");
		pedimento.setCss("form-control");
		pedimento.setOrder(22);
		pedimento.setComponentType("checkbox");
		pedimento.setReadOnly(false);
		pedimento.setHidden(false);
		pedimento.setRequired(false);
		pedimento.setShowInBasket(true);
		pedimento.setId(false);
		pedimento.setLength(10);
		pedimento.setGroup("cantidades");
		pedimento.setPersistible(true);
		pedimento.setValue("");

		cmoneda.setName("Moneda");
		cmoneda.setFieldName("moneda");
		cmoneda.setCss("form-control");
		cmoneda.setOrder(23);
		cmoneda.setComponentType("cmoneda");
		cmoneda.setReadOnly(false);
		cmoneda.setHidden(false);
		cmoneda.setRequired(false);
		cmoneda.setShowInBasket(true);
		cmoneda.setId(false);
		cmoneda.setLength(10);
		cmoneda.setGroup("cantidades");
		cmoneda.setPersistible(true);
		cmoneda.setValue("");

		ccontable.setName("Cuenta C.");
		ccontable.setFieldName("ccontable");
		ccontable.setCss("form-control");
		ccontable.setOrder(24);
		ccontable.setComponentType("texto");
		ccontable.setReadOnly(false);
		ccontable.setHidden(false);
		ccontable.setRequired(false);
		ccontable.setShowInBasket(false);
		ccontable.setId(false);
		ccontable.setLength(50);
		ccontable.setGroup("cantidades");
		ccontable.setPersistible(true);
		ccontable.setValue("");
		ccontable.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		ccontable.setFormat("Cuenta C.");

		costeo.setName("Costeo");
		costeo.setFieldName("costeo");
		costeo.setCss("form-control");
		costeo.setOrder(25);
		costeo.setComponentType("costeo");
		costeo.setReadOnly(false);
		costeo.setHidden(false);
		costeo.setRequired(false);
		costeo.setShowInBasket(true);
		costeo.setId(false);
		costeo.setLength(20);
		costeo.setGroup("cantidades");
		costeo.setPersistible(true);
		costeo.setFormat("Costeo");
		costeo.setValue("");

		existencias.setName("Existencias");
		existencias.setFieldName("existencias");
		existencias.setCss("form-control");
		existencias.setOrder(26);
		existencias.setComponentType("moneda");
		existencias.setReadOnly(true);
		existencias.setHidden(false);
		existencias.setRequired(false);
		existencias.setShowInBasket(false);
		existencias.setId(false);
		existencias.setLength(10);
		existencias.setGroup("cantidades");
		existencias.setPersistible(true);
		existencias.setValue("0");
		existencias.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		existencias.setFormat("Existencias");

		sminimo.setName("Stock minimo");
		sminimo.setFieldName("sminimo");
		sminimo.setCss("form-control");
		sminimo.setOrder(27);
		sminimo.setComponentType("moneda");
		sminimo.setReadOnly(false);
		sminimo.setHidden(false);
		sminimo.setRequired(false);
		sminimo.setShowInBasket(false);
		sminimo.setId(false);
		sminimo.setLength(10);
		sminimo.setGroup("cantidades");
		sminimo.setPersistible(true);
		sminimo.setValue("0");
		sminimo.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		sminimo.setFormat("Stock minimo");

		smaximo.setName("Stock maximo");
		smaximo.setFieldName("smaximo");
		smaximo.setCss("form-control");
		smaximo.setOrder(28);
		smaximo.setComponentType("moneda");
		smaximo.setReadOnly(false);
		smaximo.setHidden(false);
		smaximo.setRequired(false);
		smaximo.setShowInBasket(false);
		smaximo.setId(false);
		smaximo.setLength(10);
		smaximo.setGroup("cantidades");
		smaximo.setPersistible(true);
		smaximo.setValue("0");
		smaximo.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		smaximo.setFormat("Stock maximo");

		comprometido.setName("Comprometido");
		comprometido.setFieldName("comprometido");
		comprometido.setCss("form-control");
		comprometido.setOrder(29);
		comprometido.setComponentType("moneda");
		comprometido.setReadOnly(true);
		comprometido.setHidden(false);
		comprometido.setRequired(false);
		comprometido.setShowInBasket(false);
		comprometido.setId(false);
		comprometido.setLength(10);
		comprometido.setGroup("cantidades");
		comprometido.setPersistible(true);
		comprometido.setValue("0");
		comprometido.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		comprometido.setFormat("Comprometido");

		porrecibir.setName("Por recibir");
		porrecibir.setFieldName("porrecibir");
		porrecibir.setCss("form-control");
		porrecibir.setOrder(30);
		porrecibir.setComponentType("moneda");
		porrecibir.setReadOnly(true);
		porrecibir.setHidden(false);
		porrecibir.setRequired(false);
		porrecibir.setShowInBasket(false);
		porrecibir.setId(false);
		porrecibir.setLength(10);
		porrecibir.setGroup("cantidades");
		porrecibir.setPersistible(true);
		porrecibir.setValue("0");
		porrecibir.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		porrecibir.setFormat("Por recibir");

		porsurtir.setName("Por surtir");
		porsurtir.setFieldName("porsurtir");
		porsurtir.setCss("form-control");
		porsurtir.setOrder(31);
		porsurtir.setComponentType("moneda");
		porsurtir.setReadOnly(true);
		porsurtir.setHidden(false);
		porsurtir.setRequired(false);
		porsurtir.setShowInBasket(false);
		porsurtir.setId(false);
		porsurtir.setLength(10);
		porsurtir.setGroup("cantidades");
		porsurtir.setPersistible(true);
		porsurtir.setValue("0");
		porsurtir.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		porsurtir.setFormat("Por surtir");

		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(32);
		obs.setComponentType("textoarea");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(false);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(100);
		obs.setGroup("cantidades");
		obs.setPersistible(true);
		obs.setValue("");
		obs.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		obs.setFormat("Observaciones");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(33);
		status.setComponentType("texto");
		status.setReadOnly(true);
		status.setHidden(true);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("nuevo");
		status.setValidation("");
		status.setFormat("Status");

		campos.add(tipo);
		campos.add(codigo);
		campos.add(sat);
		campos.add(calterno);
		campos.add(descripcion);
		campos.add(factor);
		campos.add(tsurtido);
		campos.add(uempaque);
		campos.add(uentrada);
		campos.add(usalida);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		campos.add(lote);
		campos.add(pedimento);
		campos.add(cmoneda);
		campos.add(ccontable);
		campos.add(costeo);
		campos.add(existencias);
		campos.add(sminimo);
		campos.add(smaximo);
		campos.add(comprometido);
		campos.add(porrecibir);
		campos.add(porsurtir);
		campos.add(obs);
		campos.add(status);

		/*campos.add(longitud);
		campos.add(altura);
		campos.add(grosor);
		campos.add(peso);
		campos.add(ancho);*/
		campos.add(noserie);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("producto");
		forma.setView("producto");
		forma.setTitle("Producto");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setBasket("producto");
		forma.setCreateable(true);
		forma.setTable("prodserv");
		forma.setValidate(true);
		forma.getDecorators().put("nuevo", decoradoresBuscar);
		forma.getDecorators().put("buscar", decoradoresBuscar);
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

	@Test
	public void testGuardarFormaKit() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("kit.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();

		Field tipo = new Field();
		Field codigo = new Field();
		Field sat = new Field();
		Field calterno = new Field();
		Field descripcion = new Field();
		Field uentrada = new Field();
		Field usalida = new Field();
		Field categoria = new Field();
		Field factor = new Field();
		Field uempaque = new Field();
		Field tsurtido = new Field();
		Field imagen = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		/*Campo longitud = new Campo();
		Campo altura = new Campo();
		Campo grosor = new Campo();
		Campo peso = new Campo();
		Campo ancho = new Campo();*/

		Field noserie = new Field();
		Field lote = new Field();
		Field pedimento = new Field();
		Field cmoneda = new Field();
		Field ccontable = new Field();
		Field costeo = new Field();
		Field existencias = new Field();
		Field sminimo = new Field();
		Field smaximo = new Field();
		Field comprometido = new Field();
		Field porrecibir = new Field();
		Field porsurtir = new Field();
		Field obs = new Field();
		Field status = new Field();

		Resource forma = new Resource();
		List<Field> decoradoresBuscar = new ArrayList<Field>();


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("producto");
		guardar.setModule("inventario");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button cancelar = new Button();
		cancelar.setCommandName("cancelar");
		cancelar.setName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setResourceName("producto");
		cancelar.setModule("inventario");
		cancelar.setOrder(1);
		cancelar.setResourceType("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvents("nuevo");


		Button editar = new Button();
		editar.setCommandName("actualizar");
		editar.setName("actualizar");
		editar.setLabel("Actualizar");
		editar.setComponentType("botonjs");
		editar.setCss("btn btn-info");
		editar.setResourceName("producto");
		editar.setModule("inventario");
		editar.setOrder(2);
		editar.setResourceType("forma");
		editar.setVersion("1.0");
		editar.setEvents("detalle");

		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Buscar");
		buscar.setComponentType("submit");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("basket");
		buscar.setVersion("1.0");
		buscar.setEvents("buscar");

		acciones.add(buscar);
		acciones.add(guardar);
		acciones.add(editar);
		acciones.add(cancelar);

		tipo.setName("Tipo");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("kit");
		tipo.setFormat("{TIPO}");
		tipo.setSearcheable(true);

		//decoradores
		/*Campo decoradorTipo = new Campo();
		decoradorTipo.setNombre("Tipo");
		decoradorTipo.setBd("tipo");
		decoradorTipo.setCss("form-control");
		decoradorTipo.setOrden(1);
		decoradorTipo.setType("texto");
		decoradorTipo.setLectura(true);
		decoradorTipo.setOculto(true);
		decoradorTipo.setRequerido(false);
		decoradorTipo.setLista(true);
		decoradorTipo.setId(false);
		decoradorTipo.setLongitud(20);
		decoradorTipo.setGrupo("cabecero");
		decoradorTipo.setPersistible(true);
		decoradorTipo.setValor("producto");
		decoradorTipo.setFormato("{TIPO}");
		decoradorTipo.setBuscable(true);

		decoradoresBuscar.add(decoradorTipo);*/

		codigo.setName("Codigo");
		codigo.setFieldName("codigo");
		codigo.setCss("form-control");
		codigo.setOrder(2);
		codigo.setComponentType("texto");
		codigo.setReadOnly(true);
		codigo.setHidden(false);
		codigo.setRequired(false);
		codigo.setShowInBasket(true);
		codigo.setId(true);
		codigo.setLength(20);
		codigo.setGroup("cabecero");
		codigo.setPersistible(true);
		codigo.setValue("");
		//codigo.setAutogenerado(false);
		codigo.setFormat("{TIPO-CONS}");
		codigo.setSearcheable(true);


		//decoradores
		Field decoradorCodigo = new Field();
		decoradorCodigo.setName("Codigo");
		decoradorCodigo.setFieldName("codigo");
		decoradorCodigo.setCss("form-control");
		decoradorCodigo.setOrder(2);
		decoradorCodigo.setComponentType("texto");
		decoradorCodigo.setReadOnly(false);
		decoradorCodigo.setHidden(false);
		decoradorCodigo.setRequired(false);
		decoradorCodigo.setShowInBasket(true);
		decoradorCodigo.setId(true);
		decoradorCodigo.setLength(20);
		decoradorCodigo.setGroup("cabecero");
		decoradorCodigo.setPersistible(true);
		decoradorCodigo.setValue("");
		//decoradorCodigo.setAutogenerado(false);
		decoradorCodigo.setFormat("Codigo");
		decoradorCodigo.setSearcheable(true);

		decoradoresBuscar.add(decoradorCodigo);

		sat.setName("Codigo SAT");
		sat.setFieldName("codigosat");
		sat.setCss("form-control");
		sat.setOrder(3);
		sat.setComponentType("texto");
		sat.setReadOnly(false);
		sat.setHidden(false);
		sat.setRequired(false);
		sat.setShowInBasket(true);
		sat.setId(false);
		sat.setLength(20);
		sat.setGroup("cabecero");
		sat.setPersistible(true);
		sat.setValue("");
		sat.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		sat.setFormat("Codigo SAT");
		sat.setSearcheable(true);

		calterno.setName("Codigo alterno");
		calterno.setFieldName("calterno");
		calterno.setCss("form-control");
		calterno.setOrder(4);
		calterno.setComponentType("texto");
		calterno.setReadOnly(false);
		calterno.setHidden(false);
		calterno.setRequired(false);
		calterno.setShowInBasket(true);
		calterno.setId(false);
		calterno.setLength(20);
		calterno.setGroup("cabecero");
		calterno.setPersistible(true);
		calterno.setValue("");
		calterno.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		calterno.setFormat("Codigo alterno");
		calterno.setSearcheable(true);

		descripcion.setName("Descripcion");
		descripcion.setFieldName("descripcion");
		descripcion.setCss("form-control");
		descripcion.setOrder(5);
		descripcion.setComponentType("texto");
		descripcion.setReadOnly(false);
		descripcion.setHidden(false);
		descripcion.setRequired(true);
		descripcion.setShowInBasket(true);
		descripcion.setId(false);
		descripcion.setLength(200);
		descripcion.setGroup("cabecero");
		descripcion.setPersistible(true);
		descripcion.setValue("");
		descripcion.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		descripcion.setFormat("Descripcion");
		descripcion.setSearcheable(true);

		uentrada.setName("U. Entrada");
		uentrada.setFieldName("uentrada");
		uentrada.setCss("form-control");
		uentrada.setOrder(6);
		uentrada.setComponentType("umedida");
		uentrada.setReadOnly(false);
		uentrada.setHidden(false);
		uentrada.setRequired(true);
		uentrada.setShowInBasket(false);
		uentrada.setId(false);
		uentrada.setLength(100);
		uentrada.setGroup("cabecero");
		uentrada.setPersistible(true);
		uentrada.setValue("");
		uentrada.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		uentrada.setFormat("U. Entrada");
		uentrada.setSearcheable(false);

		usalida.setName("U. Salida");
		usalida.setFieldName("usalida");
		usalida.setCss("form-control");
		usalida.setOrder(7);
		usalida.setComponentType("umedida");
		usalida.setReadOnly(false);
		usalida.setHidden(false);
		usalida.setRequired(true);
		usalida.setShowInBasket(false);
		usalida.setId(false);
		usalida.setLength(100);
		usalida.setGroup("cabecero");
		usalida.setPersistible(true);
		usalida.setValue("");
		usalida.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		usalida.setFormat("U. Salida");
		usalida.setSearcheable(false);

		categoria.setName("Categoria");
		categoria.setFieldName("categoria");
		categoria.setCss("form-control");
		categoria.setOrder(8);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(100);
		categoria.setGroup("cabecero");
		categoria.setPersistible(true);
		categoria.setValue("");
		categoria.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		categoria.setFormat("Categoria");
		categoria.setSearcheable(false);

		factor.setName("Factor empaque");
		factor.setFieldName("factor");
		factor.setCss("form-control");
		factor.setOrder(9);
		factor.setComponentType("moneda");
		factor.setReadOnly(false);
		factor.setHidden(false);
		factor.setRequired(true);
		factor.setShowInBasket(false);
		factor.setId(false);
		factor.setLength(100);
		factor.setGroup("cabecero");
		factor.setPersistible(true);
		factor.setValue("0");
		factor.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		factor.setFormat("Factor empaque");
		factor.setSearcheable(false);

		uempaque.setName("Unidades Empaque");
		uempaque.setFieldName("uempaque");
		uempaque.setCss("form-control");
		uempaque.setOrder(10);
		uempaque.setComponentType("moneda");
		uempaque.setReadOnly(false);
		uempaque.setHidden(false);
		uempaque.setRequired(false);
		uempaque.setShowInBasket(false);
		uempaque.setId(false);
		uempaque.setLength(100);
		uempaque.setGroup("cabecero");
		uempaque.setPersistible(true);
		uempaque.setValue("0");
		uempaque.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		uempaque.setFormat("Unidades Empaque");
		uempaque.setSearcheable(false);

		tsurtido.setName("Tiempo Surtido");
		tsurtido.setFieldName("tsurtido");
		tsurtido.setCss("form-control");
		tsurtido.setOrder(11);
		tsurtido.setComponentType("texto");
		tsurtido.setReadOnly(false);
		tsurtido.setHidden(false);
		tsurtido.setRequired(false);
		tsurtido.setShowInBasket(false);
		tsurtido.setId(false);
		tsurtido.setLength(10);
		tsurtido.setGroup("cabecero");
		tsurtido.setPersistible(true);
		tsurtido.setValue("");
		tsurtido.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		tsurtido.setFormat("Tiempo Surtido");
		tsurtido.setSearcheable(false);

		imagen.setName("Imagen");
		imagen.setFieldName("imagen");
		imagen.setCss("form-control");
		imagen.setOrder(12);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(100);
		imagen.setGroup("cabecero");
		imagen.setPersistible(true);
		imagen.setValue("0");
		imagen.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		imagen.setFormat("Imagen");
		imagen.setSearcheable(false);

		usuario.setName("Usuario");
		usuario.setFieldName("usuario");
		usuario.setCss("form-control");
		usuario.setOrder(13);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(100);
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setValue("0");
		usuario.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		usuario.setFormat("Usuario");
		usuario.setSearcheable(false);

		fecha.setName("Fecha");
		fecha.setFieldName("fecha");
		fecha.setCss("form-control");
		fecha.setOrder(14);
		fecha.setComponentType("fecha");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(20);
		fecha.setGroup("cabecero");
		fecha.setPersistible(true);
		fecha.setValue("");
		fecha.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fecha.setFormat("yyyy-MM-dd");
		fecha.setSearcheable(false);

		/*longitud.setNombre("Longitud");
		longitud.setBd("longitud");
		longitud.setCss("form-control");
		longitud.setOrden(15);
		longitud.setType("moneda");
		longitud.setLectura(false);
		longitud.setOculto(false);
		longitud.setRequerido(false);
		longitud.setLista(true);
		longitud.setId(false);
		longitud.setLongitud(10);
		longitud.setGrupo("cabecero");
		longitud.setPersistible(true);
		longitud.setValor("0");
		longitud.setValidacion("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		longitud.setFormato("Longitud");
		longitud.setBuscable(false);

		altura.setNombre("Altura");
		altura.setBd("altura");
		altura.setCss("form-control");
		altura.setOrden(16);
		altura.setType("moneda");
		altura.setLectura(false);
		altura.setOculto(false);
		altura.setRequerido(false);
		altura.setLista(true);
		altura.setId(false);
		altura.setLongitud(10);
		altura.setGrupo("cabecero");
		altura.setPersistible(true);
		altura.setValor("0");
		altura.setValidacion("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		altura.setFormato("Altura");
		altura.setBuscable(false);

		grosor.setNombre("Grosor");
		grosor.setBd("grosor");
		grosor.setCss("form-control");
		grosor.setOrden(17);
		grosor.setType("moneda");
		grosor.setLectura(false);
		grosor.setOculto(false);
		grosor.setRequerido(false);
		grosor.setLista(true);
		grosor.setId(false);
		grosor.setLongitud(10);
		grosor.setGrupo("cabecero");
		grosor.setPersistible(true);
		grosor.setValor("0");
		grosor.setValidacion("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		grosor.setFormato("Grosor");
		grosor.setBuscable(false);

		peso.setNombre("Peso");
		peso.setBd("peso");
		peso.setCss("form-control");
		peso.setOrden(18);
		peso.setType("moneda");
		peso.setLectura(false);
		peso.setOculto(false);
		peso.setRequerido(false);
		peso.setLista(true);
		peso.setId(false);
		peso.setLongitud(10);
		peso.setGrupo("cabecero");
		peso.setPersistible(true);
		peso.setValor("0");
		peso.setValidacion("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		peso.setFormato("Peso");
		peso.setBuscable(false);

		ancho.setNombre("Ancho");
		ancho.setBd("ancho");
		ancho.setCss("form-control");
		ancho.setOrden(19);
		ancho.setType("moneda");
		ancho.setLectura(false);
		ancho.setOculto(false);
		ancho.setRequerido(false);
		ancho.setLista(true);
		ancho.setId(false);
		ancho.setLongitud(10);
		ancho.setGrupo("cabecero");
		ancho.setPersistible(true);
		ancho.setValor("0");
		ancho.setValidacion("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		ancho.setFormato("Ancho");
		ancho.setBuscable(false);*/

		noserie.setName("No de series");
		noserie.setFieldName("noserie");
		noserie.setCss("form-control");
		noserie.setOrder(20);
		noserie.setComponentType("checkbox");
		noserie.setReadOnly(false);
		noserie.setHidden(false);
		noserie.setRequired(false);
		noserie.setShowInBasket(true);
		noserie.setId(false);
		noserie.setLength(10);
		noserie.setGroup("cantidades");
		noserie.setPersistible(true);
		noserie.setValue("");

		lote.setName("Lote");
		lote.setFieldName("lote");
		lote.setCss("form-control");
		lote.setOrder(21);
		lote.setComponentType("checkbox");
		lote.setReadOnly(false);
		lote.setHidden(false);
		lote.setRequired(false);
		lote.setShowInBasket(true);
		lote.setId(false);
		lote.setLength(10);
		lote.setGroup("cantidades");
		lote.setPersistible(true);
		lote.setValue("");

		pedimento.setName("Predimento aduanal");
		pedimento.setFieldName("pedimento");
		pedimento.setCss("form-control");
		pedimento.setOrder(22);
		pedimento.setComponentType("checkbox");
		pedimento.setReadOnly(false);
		pedimento.setHidden(false);
		pedimento.setRequired(false);
		pedimento.setShowInBasket(true);
		pedimento.setId(false);
		pedimento.setLength(10);
		pedimento.setGroup("cantidades");
		pedimento.setPersistible(true);
		pedimento.setValue("");

		cmoneda.setName("Moneda");
		cmoneda.setFieldName("moneda");
		cmoneda.setCss("form-control");
		cmoneda.setOrder(23);
		cmoneda.setComponentType("cmoneda");
		cmoneda.setReadOnly(false);
		cmoneda.setHidden(false);
		cmoneda.setRequired(false);
		cmoneda.setShowInBasket(true);
		cmoneda.setId(false);
		cmoneda.setLength(10);
		cmoneda.setGroup("cantidades");
		cmoneda.setPersistible(true);
		cmoneda.setValue("");

		ccontable.setName("Cuenta C.");
		ccontable.setFieldName("ccontable");
		ccontable.setCss("form-control");
		ccontable.setOrder(24);
		ccontable.setComponentType("texto");
		ccontable.setReadOnly(false);
		ccontable.setHidden(false);
		ccontable.setRequired(false);
		ccontable.setShowInBasket(false);
		ccontable.setId(false);
		ccontable.setLength(50);
		ccontable.setGroup("cantidades");
		ccontable.setPersistible(true);
		ccontable.setValue("");
		ccontable.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		ccontable.setFormat("Cuenta C.");

		costeo.setName("Costeo");
		costeo.setFieldName("costeo");
		costeo.setCss("form-control");
		costeo.setOrder(25);
		costeo.setComponentType("costeo");
		costeo.setReadOnly(false);
		costeo.setHidden(false);
		costeo.setRequired(false);
		costeo.setShowInBasket(true);
		costeo.setId(false);
		costeo.setLength(20);
		costeo.setGroup("cantidades");
		costeo.setPersistible(true);
		costeo.setFormat("Costeo");
		costeo.setValue("");

		existencias.setName("Existencias");
		existencias.setFieldName("existencias");
		existencias.setCss("form-control");
		existencias.setOrder(26);
		existencias.setComponentType("moneda");
		existencias.setReadOnly(true);
		existencias.setHidden(false);
		existencias.setRequired(false);
		existencias.setShowInBasket(false);
		existencias.setId(false);
		existencias.setLength(10);
		existencias.setGroup("cantidades");
		existencias.setPersistible(true);
		existencias.setValue("0");
		existencias.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		existencias.setFormat("Existencias");

		sminimo.setName("Stock minimo");
		sminimo.setFieldName("sminimo");
		sminimo.setCss("form-control");
		sminimo.setOrder(27);
		sminimo.setComponentType("moneda");
		sminimo.setReadOnly(false);
		sminimo.setHidden(false);
		sminimo.setRequired(false);
		sminimo.setShowInBasket(false);
		sminimo.setId(false);
		sminimo.setLength(10);
		sminimo.setGroup("cantidades");
		sminimo.setPersistible(true);
		sminimo.setValue("0");
		sminimo.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		sminimo.setFormat("Stock minimo");

		smaximo.setName("Stock maximo");
		smaximo.setFieldName("smaximo");
		smaximo.setCss("form-control");
		smaximo.setOrder(28);
		smaximo.setComponentType("moneda");
		smaximo.setReadOnly(false);
		smaximo.setHidden(false);
		smaximo.setRequired(false);
		smaximo.setShowInBasket(false);
		smaximo.setId(false);
		smaximo.setLength(10);
		smaximo.setGroup("cantidades");
		smaximo.setPersistible(true);
		smaximo.setValue("0");
		smaximo.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		smaximo.setFormat("Stock maximo");

		comprometido.setName("Comprometido");
		comprometido.setFieldName("comprometido");
		comprometido.setCss("form-control");
		comprometido.setOrder(29);
		comprometido.setComponentType("moneda");
		comprometido.setReadOnly(true);
		comprometido.setHidden(false);
		comprometido.setRequired(false);
		comprometido.setShowInBasket(false);
		comprometido.setId(false);
		comprometido.setLength(10);
		comprometido.setGroup("cantidades");
		comprometido.setPersistible(true);
		comprometido.setValue("0");
		comprometido.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		comprometido.setFormat("Comprometido");

		porrecibir.setName("Por recibir");
		porrecibir.setFieldName("porrecibir");
		porrecibir.setCss("form-control");
		porrecibir.setOrder(30);
		porrecibir.setComponentType("moneda");
		porrecibir.setReadOnly(true);
		porrecibir.setHidden(false);
		porrecibir.setRequired(false);
		porrecibir.setShowInBasket(false);
		porrecibir.setId(false);
		porrecibir.setLength(10);
		porrecibir.setGroup("cantidades");
		porrecibir.setPersistible(true);
		porrecibir.setValue("0");
		porrecibir.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		porrecibir.setFormat("Por recibir");

		porsurtir.setName("Por surtir");
		porsurtir.setFieldName("porsurtir");
		porsurtir.setCss("form-control");
		porsurtir.setOrder(31);
		porsurtir.setComponentType("moneda");
		porsurtir.setReadOnly(true);
		porsurtir.setHidden(false);
		porsurtir.setRequired(false);
		porsurtir.setShowInBasket(false);
		porsurtir.setId(false);
		porsurtir.setLength(10);
		porsurtir.setGroup("cantidades");
		porsurtir.setPersistible(true);
		porsurtir.setValue("0");
		porsurtir.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		porsurtir.setFormat("Por surtir");

		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(32);
		obs.setComponentType("textoarea");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(false);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(100);
		obs.setGroup("cantidades");
		obs.setPersistible(true);
		obs.setValue("");
		obs.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		obs.setFormat("Observaciones");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(33);
		status.setComponentType("texto");
		status.setReadOnly(true);
		status.setHidden(true);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("nuevo");
		status.setValidation("");
		status.setFormat("Status");

		campos.add(tipo);
		campos.add(codigo);
		campos.add(sat);
		campos.add(calterno);
		campos.add(descripcion);
		campos.add(factor);
		campos.add(tsurtido);
		campos.add(uempaque);
		campos.add(uentrada);
		campos.add(usalida);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		campos.add(lote);
		campos.add(pedimento);
		campos.add(cmoneda);
		campos.add(ccontable);
		campos.add(costeo);
		campos.add(existencias);
		campos.add(sminimo);
		campos.add(smaximo);
		campos.add(comprometido);
		campos.add(porrecibir);
		campos.add(porsurtir);
		campos.add(obs);
		campos.add(status);

		/*campos.add(longitud);
		campos.add(altura);
		campos.add(grosor);
		campos.add(peso);
		campos.add(ancho);*/
		campos.add(noserie);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("kit");
		forma.setView("kit");
		forma.setTitle("Kit");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setBasket("kit");
		forma.setCreateable(true);
		forma.setTable("prodserv");
		forma.setValidate(true);
		forma.getDecorators().put("nuevo", decoradoresBuscar);
		forma.getDecorators().put("buscar", decoradoresBuscar);
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

	@Test
	public void testGuardarFormaProductoBuscar() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("producto_buscar.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();

		Field tipo = new Field();
		Field codigo = new Field();
		Field sat = new Field();
		Field calterno = new Field();
		Field descripcion = new Field();
		Field uentrada = new Field();
		Field usalida = new Field();
		Field categoria = new Field();
		Field factor = new Field();
		Field uempaque = new Field();
		Field tsurtido = new Field();
		Field imagen = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Field longitud = new Field();
		Field altura = new Field();
		Field grosor = new Field();
		Field peso = new Field();
		Field ancho = new Field();

		Field noserie = new Field();
		Field lote = new Field();
		Field pedimento = new Field();
		Field cmoneda = new Field();
		Field ccontable = new Field();
		Field costeo = new Field();
		Field existencias = new Field();
		Field sminimo = new Field();
		Field smaximo = new Field();
		Field comprometido = new Field();
		Field porrecibir = new Field();
		Field porsurtir = new Field();
		Field obs = new Field();

		Resource forma = new Resource();

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("producto");
		guardar.setModule("inventario");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button cancelar = new Button();
		cancelar.setCommandName("cancelar");
		cancelar.setName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setResourceName("producto");
		cancelar.setModule("inventario");
		cancelar.setOrder(1);
		cancelar.setResourceType("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvents("nuevo");


		Button editar = new Button();
		editar.setName("actualizar");
		editar.setLabel("Actualizar");
		editar.setComponentType("botonjs");
		editar.setCss("btn btn-info");
		editar.setResourceName("producto");
		editar.setModule("inventario");
		editar.setOrder(2);
		editar.setResourceType("forma");
		editar.setVersion("1.0");
		editar.setEvents("detalle");

		Button buscar = new Button();
		buscar.setName("buscar");
		buscar.setLabel("Buscar");
		buscar.setComponentType("submit");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("basket");
		buscar.setVersion("1.0");
		buscar.setEvents("buscar");

		acciones.add(buscar);
		acciones.add(guardar);
		acciones.add(editar);
		acciones.add(cancelar);

		tipo.setName("Tipo");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(false);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("producto");
		tipo.setFormat("{TIPO}");
		tipo.setSearcheable(true);

		codigo.setName("Codigo");
		codigo.setFieldName("codigo");
		codigo.setCss("form-control");
		codigo.setOrder(2);
		codigo.setComponentType("texto");
		codigo.setReadOnly(true);
		codigo.setHidden(false);
		codigo.setRequired(false);
		codigo.setShowInBasket(true);
		codigo.setId(true);
		codigo.setLength(20);
		codigo.setGroup("cabecero");
		codigo.setPersistible(true);
		codigo.setValue("");
		//codigo.setAutogenerado(false);
		codigo.setFormat("{TIPO-CONS}");
		codigo.setSearcheable(true);

		sat.setName("Codigo SAT");
		sat.setFieldName("codigosat");
		sat.setCss("form-control");
		sat.setOrder(3);
		sat.setComponentType("texto");
		sat.setReadOnly(false);
		sat.setHidden(false);
		sat.setRequired(false);
		sat.setShowInBasket(true);
		sat.setId(false);
		sat.setLength(20);
		sat.setGroup("cabecero");
		sat.setPersistible(true);
		sat.setValue("");
		sat.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		sat.setFormat("Codigo SAT");
		sat.setSearcheable(true);

		calterno.setName("Codigo alterno");
		calterno.setFieldName("calterno");
		calterno.setCss("form-control");
		calterno.setOrder(4);
		calterno.setComponentType("texto");
		calterno.setReadOnly(false);
		calterno.setHidden(false);
		calterno.setRequired(false);
		calterno.setShowInBasket(true);
		calterno.setId(false);
		calterno.setLength(20);
		calterno.setGroup("cabecero");
		calterno.setPersistible(true);
		calterno.setValue("");
		calterno.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		calterno.setFormat("Codigo alterno");
		calterno.setSearcheable(true);

		descripcion.setName("Descripcion");
		descripcion.setFieldName("descripcion");
		descripcion.setCss("form-control");
		descripcion.setOrder(5);
		descripcion.setComponentType("texto");
		descripcion.setReadOnly(false);
		descripcion.setHidden(false);
		descripcion.setRequired(true);
		descripcion.setShowInBasket(true);
		descripcion.setId(false);
		descripcion.setLength(200);
		descripcion.setGroup("cabecero");
		descripcion.setPersistible(true);
		descripcion.setValue("");
		descripcion.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		descripcion.setFormat("Descripcion");
		descripcion.setSearcheable(true);

		uentrada.setName("U. Entrada");
		uentrada.setFieldName("uentrada");
		uentrada.setCss("form-control");
		uentrada.setOrder(6);
		uentrada.setComponentType("umedida");
		uentrada.setReadOnly(false);
		uentrada.setHidden(false);
		uentrada.setRequired(true);
		uentrada.setShowInBasket(false);
		uentrada.setId(false);
		uentrada.setLength(100);
		uentrada.setGroup("cabecero");
		uentrada.setPersistible(true);
		uentrada.setValue("");
		uentrada.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		uentrada.setFormat("U. Entrada");

		usalida.setName("U. Salida");
		usalida.setFieldName("usalida");
		usalida.setCss("form-control");
		usalida.setOrder(7);
		usalida.setComponentType("umedida");
		usalida.setReadOnly(false);
		usalida.setHidden(false);
		usalida.setRequired(true);
		usalida.setShowInBasket(false);
		usalida.setId(false);
		usalida.setLength(100);
		usalida.setGroup("cabecero");
		usalida.setPersistible(true);
		usalida.setValue("");
		usalida.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		usalida.setFormat("U. Salida");

		categoria.setName("Categoria");
		categoria.setFieldName("categoria");
		categoria.setCss("form-control");
		categoria.setOrder(8);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(100);
		categoria.setGroup("cabecero");
		categoria.setPersistible(true);
		categoria.setValue("");
		categoria.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		categoria.setFormat("Categoria");

		factor.setName("Factor empaque");
		factor.setFieldName("factor");
		factor.setCss("form-control");
		factor.setOrder(9);
		factor.setComponentType("moneda");
		factor.setReadOnly(false);
		factor.setHidden(false);
		factor.setRequired(true);
		factor.setShowInBasket(false);
		factor.setId(false);
		factor.setLength(100);
		factor.setGroup("cabecero");
		factor.setPersistible(true);
		factor.setValue("0");
		factor.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		factor.setFormat("Factor empaque");

		uempaque.setName("Unidades Empaque");
		uempaque.setFieldName("uempaque");
		uempaque.setCss("form-control");
		uempaque.setOrder(10);
		uempaque.setComponentType("moneda");
		uempaque.setReadOnly(false);
		uempaque.setHidden(false);
		uempaque.setRequired(false);
		uempaque.setShowInBasket(false);
		uempaque.setId(false);
		uempaque.setLength(100);
		uempaque.setGroup("cabecero");
		uempaque.setPersistible(true);
		uempaque.setValue("0");
		uempaque.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		uempaque.setFormat("Unidades Empaque");

		tsurtido.setName("Tiempo Surtido");
		tsurtido.setFieldName("tsurtido");
		tsurtido.setCss("form-control");
		tsurtido.setOrder(11);
		tsurtido.setComponentType("texto");
		tsurtido.setReadOnly(false);
		tsurtido.setHidden(false);
		tsurtido.setRequired(false);
		tsurtido.setShowInBasket(false);
		tsurtido.setId(false);
		tsurtido.setLength(10);
		tsurtido.setGroup("cabecero");
		tsurtido.setPersistible(true);
		tsurtido.setValue("");
		tsurtido.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		tsurtido.setFormat("Tiempo Surtido");

		imagen.setName("Imagen");
		imagen.setFieldName("imagen");
		imagen.setCss("form-control");
		imagen.setOrder(12);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(100);
		imagen.setGroup("cabecero");
		imagen.setPersistible(true);
		imagen.setValue("0");
		imagen.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		imagen.setFormat("Imagen");

		usuario.setName("Usuario");
		usuario.setFieldName("usuario");
		usuario.setCss("form-control");
		usuario.setOrder(13);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(100);
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setValue("0");
		usuario.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		usuario.setFormat("Usuario");

		fecha.setName("Fecha");
		fecha.setFieldName("fecha");
		fecha.setCss("form-control");
		fecha.setOrder(14);
		fecha.setComponentType("fecha");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(20);
		fecha.setGroup("cabecero");
		fecha.setPersistible(true);
		fecha.setValue("");
		fecha.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fecha.setFormat("yyyy-MM-dd");

		longitud.setName("Longitud");
		longitud.setFieldName("longitud");
		longitud.setCss("form-control");
		longitud.setOrder(15);
		longitud.setComponentType("moneda");
		longitud.setReadOnly(false);
		longitud.setHidden(false);
		longitud.setRequired(false);
		longitud.setShowInBasket(true);
		longitud.setId(false);
		longitud.setLength(10);
		longitud.setGroup("cabecero");
		longitud.setPersistible(true);
		longitud.setValue("0");
		longitud.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		longitud.setFormat("Longitud");

		altura.setName("Altura");
		altura.setFieldName("altura");
		altura.setCss("form-control");
		altura.setOrder(16);
		altura.setComponentType("moneda");
		altura.setReadOnly(false);
		altura.setHidden(false);
		altura.setRequired(false);
		altura.setShowInBasket(true);
		altura.setId(false);
		altura.setLength(10);
		altura.setGroup("cabecero");
		altura.setPersistible(true);
		altura.setValue("0");
		altura.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		altura.setFormat("Altura");

		grosor.setName("Grosor");
		grosor.setFieldName("grosor");
		grosor.setCss("form-control");
		grosor.setOrder(17);
		grosor.setComponentType("moneda");
		grosor.setReadOnly(false);
		grosor.setHidden(false);
		grosor.setRequired(false);
		grosor.setShowInBasket(true);
		grosor.setId(false);
		grosor.setLength(10);
		grosor.setGroup("cabecero");
		grosor.setPersistible(true);
		grosor.setValue("0");
		grosor.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		grosor.setFormat("Grosor");

		peso.setName("Peso");
		peso.setFieldName("peso");
		peso.setCss("form-control");
		peso.setOrder(18);
		peso.setComponentType("moneda");
		peso.setReadOnly(false);
		peso.setHidden(false);
		peso.setRequired(false);
		peso.setShowInBasket(true);
		peso.setId(false);
		peso.setLength(10);
		peso.setGroup("cabecero");
		peso.setPersistible(true);
		peso.setValue("0");
		peso.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		peso.setFormat("Peso");

		ancho.setName("Ancho");
		ancho.setFieldName("ancho");
		ancho.setCss("form-control");
		ancho.setOrder(19);
		ancho.setComponentType("moneda");
		ancho.setReadOnly(false);
		ancho.setHidden(false);
		ancho.setRequired(false);
		ancho.setShowInBasket(true);
		ancho.setId(false);
		ancho.setLength(10);
		ancho.setGroup("cabecero");
		ancho.setPersistible(true);
		ancho.setValue("0");
		ancho.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		ancho.setFormat("Ancho");

		noserie.setName("No de series");
		noserie.setFieldName("noserie");
		noserie.setCss("form-control");
		noserie.setOrder(20);
		noserie.setComponentType("checkbox");
		noserie.setReadOnly(false);
		noserie.setHidden(false);
		noserie.setRequired(false);
		noserie.setShowInBasket(true);
		noserie.setId(false);
		noserie.setLength(10);
		noserie.setGroup("cantidades");
		noserie.setPersistible(true);


		lote.setName("Lote");
		lote.setFieldName("lote");
		lote.setCss("form-control");
		lote.setOrder(21);
		lote.setComponentType("checkbox");
		lote.setReadOnly(false);
		lote.setHidden(false);
		lote.setRequired(false);
		lote.setShowInBasket(true);
		lote.setId(false);
		lote.setLength(10);
		lote.setGroup("cantidades");
		lote.setPersistible(true);

		pedimento.setName("Predimento aduanal");
		pedimento.setFieldName("pedimento");
		pedimento.setCss("form-control");
		pedimento.setOrder(22);
		pedimento.setComponentType("checkbox");
		pedimento.setReadOnly(false);
		pedimento.setHidden(false);
		pedimento.setRequired(false);
		pedimento.setShowInBasket(true);
		pedimento.setId(false);
		pedimento.setLength(10);
		pedimento.setGroup("cantidades");
		pedimento.setPersistible(true);

		cmoneda.setName("Moneda");
		cmoneda.setFieldName("moneda");
		cmoneda.setCss("form-control");
		cmoneda.setOrder(23);
		cmoneda.setComponentType("cmoneda");
		cmoneda.setReadOnly(false);
		cmoneda.setHidden(false);
		cmoneda.setRequired(false);
		cmoneda.setShowInBasket(true);
		cmoneda.setId(false);
		cmoneda.setLength(10);
		cmoneda.setGroup("cantidades");
		cmoneda.setPersistible(true);

		ccontable.setName("Cuenta C.");
		ccontable.setFieldName("ccontable");
		ccontable.setCss("form-control");
		ccontable.setOrder(24);
		ccontable.setComponentType("texto");
		ccontable.setReadOnly(false);
		ccontable.setHidden(false);
		ccontable.setRequired(false);
		ccontable.setShowInBasket(false);
		ccontable.setId(false);
		ccontable.setLength(50);
		ccontable.setGroup("cantidades");
		ccontable.setPersistible(true);
		ccontable.setValue("");
		ccontable.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		ccontable.setFormat("Cuenta C.");

		costeo.setName("Costeo");
		costeo.setFieldName("costeo");
		costeo.setCss("form-control");
		costeo.setOrder(25);
		costeo.setComponentType("costeo");
		costeo.setReadOnly(false);
		costeo.setHidden(false);
		costeo.setRequired(false);
		costeo.setShowInBasket(true);
		costeo.setId(false);
		costeo.setLength(20);
		costeo.setGroup("cantidades");
		costeo.setPersistible(true);
		costeo.setFormat("Costeo");

		existencias.setName("Existencias");
		existencias.setFieldName("existencias");
		existencias.setCss("form-control");
		existencias.setOrder(26);
		existencias.setComponentType("moneda");
		existencias.setReadOnly(true);
		existencias.setHidden(false);
		existencias.setRequired(false);
		existencias.setShowInBasket(false);
		existencias.setId(false);
		existencias.setLength(10);
		existencias.setGroup("cantidades");
		existencias.setPersistible(true);
		existencias.setValue("0");
		existencias.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		existencias.setFormat("Existencias");

		sminimo.setName("Stock minimo");
		sminimo.setFieldName("sminimo");
		sminimo.setCss("form-control");
		sminimo.setOrder(27);
		sminimo.setComponentType("moneda");
		sminimo.setReadOnly(false);
		sminimo.setHidden(false);
		sminimo.setRequired(false);
		sminimo.setShowInBasket(false);
		sminimo.setId(false);
		sminimo.setLength(10);
		sminimo.setGroup("cantidades");
		sminimo.setPersistible(true);
		sminimo.setValue("0");
		sminimo.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		sminimo.setFormat("Stock minimo");

		smaximo.setName("Stock maximo");
		smaximo.setFieldName("smaximo");
		smaximo.setCss("form-control");
		smaximo.setOrder(28);
		smaximo.setComponentType("moneda");
		smaximo.setReadOnly(false);
		smaximo.setHidden(false);
		smaximo.setRequired(false);
		smaximo.setShowInBasket(false);
		smaximo.setId(false);
		smaximo.setLength(10);
		smaximo.setGroup("cantidades");
		smaximo.setPersistible(true);
		smaximo.setValue("0");
		smaximo.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		smaximo.setFormat("Stock maximo");

		comprometido.setName("Comprometido");
		comprometido.setFieldName("comprometido");
		comprometido.setCss("form-control");
		comprometido.setOrder(29);
		comprometido.setComponentType("moneda");
		comprometido.setReadOnly(true);
		comprometido.setHidden(false);
		comprometido.setRequired(false);
		comprometido.setShowInBasket(false);
		comprometido.setId(false);
		comprometido.setLength(10);
		comprometido.setGroup("cantidades");
		comprometido.setPersistible(true);
		comprometido.setValue("0");
		comprometido.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		comprometido.setFormat("Comprometido");

		porrecibir.setName("Por recibir");
		porrecibir.setFieldName("porrecibir");
		porrecibir.setCss("form-control");
		porrecibir.setOrder(30);
		porrecibir.setComponentType("moneda");
		porrecibir.setReadOnly(true);
		porrecibir.setHidden(false);
		porrecibir.setRequired(false);
		porrecibir.setShowInBasket(false);
		porrecibir.setId(false);
		porrecibir.setLength(10);
		porrecibir.setGroup("cantidades");
		porrecibir.setPersistible(true);
		porrecibir.setValue("0");
		porrecibir.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		porrecibir.setFormat("Por recibir");

		porsurtir.setName("Por surtir");
		porsurtir.setFieldName("porsurtir");
		porsurtir.setCss("form-control");
		porsurtir.setOrder(31);
		porsurtir.setComponentType("moneda");
		porsurtir.setReadOnly(true);
		porsurtir.setHidden(false);
		porsurtir.setRequired(false);
		porsurtir.setShowInBasket(false);
		porsurtir.setId(false);
		porsurtir.setLength(10);
		porsurtir.setGroup("cantidades");
		porsurtir.setPersistible(true);
		porsurtir.setValue("0");
		porsurtir.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		porsurtir.setFormat("Por surtir");

		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(32);
		obs.setComponentType("textoarea");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(false);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(100);
		obs.setGroup("cantidades");
		obs.setPersistible(true);
		obs.setValue("");
		obs.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		obs.setFormat("Observaciones");

		campos.add(tipo);
		campos.add(codigo);
		campos.add(sat);
		campos.add(calterno);
		campos.add(descripcion);
		campos.add(factor);
		campos.add(tsurtido);
		campos.add(uempaque);
		campos.add(uentrada);
		campos.add(usalida);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		campos.add(lote);
		campos.add(pedimento);
		campos.add(cmoneda);
		campos.add(ccontable);
		campos.add(costeo);
		campos.add(existencias);
		campos.add(sminimo);
		campos.add(smaximo);
		campos.add(comprometido);
		campos.add(porrecibir);
		campos.add(porsurtir);
		campos.add(obs);


		campos.add(longitud);
		campos.add(altura);
		campos.add(grosor);
		campos.add(peso);
		campos.add(ancho);
		campos.add(noserie);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("producto");
		forma.setView("producto");
		forma.setTitle("Producto");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setBasket("producto");
		forma.setCreateable(true);
		forma.setTable("prodserv");
		forma.setValidate(true);
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

	@Test
	public void testGuardarFormaServicio() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("servicio.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field campoTipo = new Field();
		Field campoCodigo = new Field();
		Field satCodigo = new Field();
		Field campoDescripcion = new Field();
		Field imagen = new Field();
		Field categoria = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Field status = new Field();
		Field lprecio = new Field();

		Resource forma = new Resource();

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("servicio");
		guardar.setModule("inventario");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button editar = new Button();
		editar.setName("actualizar");
		editar.setLabel("Actualizar");
		editar.setComponentType("botonjs");
		editar.setCss("btn btn-info");
		editar.setResourceName("servicio");
		editar.setModule("inventario");
		editar.setOrder(2);
		editar.setResourceType("forma");
		editar.setVersion("1.0");
		editar.setEvents("detalle");

		Button buscar = new Button();
		buscar.setName("buscar");
		buscar.setLabel("Buscar");
		buscar.setComponentType("submit");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("servicio");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("basket");
		buscar.setVersion("1.0");
		buscar.setEvents("buscar");

		acciones.add(guardar);
		acciones.add(editar);
		acciones.add(buscar);

		campoTipo.setName("Tipo");
		campoTipo.setFieldName("tipo");
		campoTipo.setCss("form-control");
		campoTipo.setOrder(1);
		campoTipo.setComponentType("texto");
		campoTipo.setReadOnly(true);
		campoTipo.setHidden(true);
		campoTipo.setRequired(false);
		campoTipo.setShowInBasket(true);
		campoTipo.setId(false);
		campoTipo.setLength(20);
		campoTipo.setGroup("cabecero");
		campoTipo.setPersistible(true);
		campoTipo.setValue("servicio");

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setValue("");
		//campoCodigo.setAutogenerado(false);
		campoCodigo.setFormat("{TIPO-CONS}");
		campoCodigo.setSearcheable(true);

		satCodigo.setName("Codigo SAT");
		satCodigo.setFieldName("codigosat");
		satCodigo.setCss("form-control");
		satCodigo.setOrder(3);
		satCodigo.setComponentType("texto");
		satCodigo.setReadOnly(false);
		satCodigo.setHidden(false);
		satCodigo.setRequired(false);
		satCodigo.setShowInBasket(true);
		satCodigo.setId(false);
		satCodigo.setLength(20);
		satCodigo.setGroup("cabecero");
		satCodigo.setPersistible(true);
		satCodigo.setValue("");
		satCodigo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		satCodigo.setFormat("Codigo SAT");
		satCodigo.setSearcheable(true);

		campoDescripcion.setName("Descripcion");
		campoDescripcion.setFieldName("descripcion");
		campoDescripcion.setCss("form-control");
		campoDescripcion.setOrder(4);
		campoDescripcion.setComponentType("texto");
		campoDescripcion.setReadOnly(false);
		campoDescripcion.setHidden(false);
		campoDescripcion.setRequired(true);
		campoDescripcion.setShowInBasket(true);
		campoDescripcion.setId(false);
		campoDescripcion.setLength(200);
		campoDescripcion.setGroup("cabecero");
		campoDescripcion.setPersistible(true);
		campoDescripcion.setValue("");
		campoDescripcion.setValidation("");
		campoDescripcion.setFormat("Descripcion");
		campoDescripcion.setSearcheable(true);

		imagen.setName("Imagen");
		imagen.setFieldName("imagen");
		imagen.setCss("form-control");
		imagen.setOrder(5);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(100);
		imagen.setGroup("cabecero");
		imagen.setPersistible(true);
		imagen.setValue("0");
		imagen.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		imagen.setFormat("Imagen");
		imagen.setSearcheable(false);


		categoria.setName("Categoria");
		categoria.setFieldName("categoria");
		categoria.setCss("form-control");
		categoria.setOrder(6);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(100);
		categoria.setGroup("cabecero");
		categoria.setPersistible(true);
		categoria.setValue("");
		categoria.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		categoria.setFormat("Categoria");
		categoria.setSearcheable(false);

		usuario.setName("Usuario");
		usuario.setFieldName("usuario");
		usuario.setCss("form-control");
		usuario.setOrder(7);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(100);
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setValue("0");
		usuario.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		usuario.setFormat("Usuario");
		usuario.setSearcheable(false);

		fecha.setName("Fecha");
		fecha.setFieldName("fecha");
		fecha.setCss("form-control");
		fecha.setOrder(8);
		fecha.setComponentType("fecha");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(20);
		fecha.setGroup("cabecero");
		fecha.setPersistible(true);
		fecha.setValue("");
		fecha.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fecha.setFormat("yyyy-MM-dd");
		fecha.setSearcheable(false);

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(9);
		status.setComponentType("texto");
		status.setReadOnly(true);
		status.setHidden(true);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("nuevo");
		status.setValidation("");
		status.setFormat("Status");
		
		lprecio.setName("Precios");
		lprecio.setFieldName("lprecio");
		lprecio.setCss("form-control");
		lprecio.setOrder(10);
		lprecio.setComponentType("texto");
		lprecio.setReadOnly(false);
		lprecio.setHidden(false);
		lprecio.setRequired(true);
		lprecio.setShowInBasket(true);
		lprecio.setId(false);
		lprecio.setLength(20);
		lprecio.setGroup("cabecero");
		lprecio.setPersistible(false);
		lprecio.setValue("CAT-01");
		lprecio.setValidation("");
		lprecio.setFormat("Lista de precios");

		campos.add(campoTipo);
		campos.add(satCodigo);
		campos.add(campoDescripcion);
		campos.add(campoCodigo);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		campos.add(status);
		campos.add(lprecio);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("servicio");
		forma.setView("servicio");
		forma.setTitle("Servicio");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setBasket("servicio");
		forma.setCreateable(true);
		forma.setTable("prodserv");
		forma.setValidate(true);
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

	@Test
	public void testGuardarFormaIngreso() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("ingreso.json").normalize();
		List<Field> decoradoreEmisor = new ArrayList<Field>();
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field campoCodigo = new Field();
		//Campo campoCampo = new Campo();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();
		Field posicion = new Field();
		Field goles = new Field();
		Field puntuacion = new Field();
		Field imagen = new Field();
		Field categoria = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Resource forma = new Resource();
		Field municipio = new Field();
		Field poblacion = new Field();
		Field ciudad = new Field();
		Field estado = new Field();
		Field metodopago = new Field();
		Field formapago = new Field();
		Field cantidad = new Field();
		Field fechaPago = new Field();
		Field obs = new Field();
		Field tipo = new Field();
		Field subtotal = new Field();
		Field descuento = new Field();
		Field imptras = new Field();
		Field impret = new Field();
		Field total = new Field();
		Field status = new Field();
		Field serie = new Field();
		Field uuid = new Field();

		Button verError = new Button();
		verError.setCommandName("error");
		verError.setName("error");
		verError.setLabel("Ver error");
		verError.setComponentType("location");
		verError.setCss("btn btn-info");
		verError.setResourceName("ingreso");
		verError.setModule("comprobante");
		verError.setOrder(3);
		verError.setResourceType("forma");
		verError.setVersion("1.0");
		verError.setEvents("detalle");
		verError.setStatus("CFDI33196");
		
		Button carrito = new Button();
		carrito.setCommandName("nuevo");
		carrito.setName("nuevo");
		carrito.setLabel("Productos/Servicios/Kits");
		carrito.setComponentType("location");
		carrito.setCss("btn btn-info");
		carrito.setResourceName("prodserv");
		carrito.setModule("inventario");
		carrito.setOrder(3);
		carrito.setResourceType("basket");
		carrito.setVersion("1.0");
		carrito.setEvents("nuevo");
		carrito.setStatus("nuevo");

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-info");
		guardar.setResourceName("ingreso");
		guardar.setModule("comprobantes");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("3.3");
		guardar.setEvents("nuevo");
		guardar.setStatus("nuevo");

		Button cancelar = new Button();
		cancelar.setCommandName("cancelar");
		cancelar.setName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("botonjs");
		cancelar.setCss("btn btn-info");
		cancelar.setResourceName("usuario");
		cancelar.setModule("directorio");
		cancelar.setOrder(1);
		cancelar.setResourceType("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvents("detalle");
		cancelar.setStatus("guardar");

		Button cancelarCFDi = new Button();
		cancelarCFDi.setCommandName("cancelarcfdi");
		cancelarCFDi.setName("cancelarcfdi");
		cancelarCFDi.setLabel("Cancelar CFDi");
		cancelarCFDi.setComponentType("botonjs");
		cancelarCFDi.setCss("btn btn-info");
		cancelarCFDi.setResourceName("usuario");
		cancelarCFDi.setModule("directorio");
		cancelarCFDi.setOrder(1);
		cancelarCFDi.setResourceType("forma");
		cancelarCFDi.setVersion("1.0");
		cancelarCFDi.setEvents("detalle");
		cancelarCFDi.setStatus("timbrar");

		Button eliminar = new Button();
		eliminar.setCommandName("actualizar");
		eliminar.setName("actualizar");
		eliminar.setLabel("Actualizar");
		eliminar.setComponentType("botonjs");
		eliminar.setCss("btn btn-info");
		eliminar.setResourceName("ingreso");
		eliminar.setModule("comprobantes");
		eliminar.setOrder(5);
		eliminar.setResourceType("forma");
		eliminar.setVersion("3.3");
		eliminar.setEvents("detalle");
		eliminar.setStatus("guardar");
		eliminar.setInstruction("Registro actualizado !!");

		Button timbrar = new Button();
		timbrar.setCommandName("timbrar");
		timbrar.setName("timbrar");
		timbrar.setLabel("Timbrar");
		timbrar.setComponentType("botonjs");
		timbrar.setCss("btn btn-info");
		timbrar.setResourceName("ingreso");
		timbrar.setModule("comprobantes");
		timbrar.setOrder(6);
		timbrar.setResourceType("forma");
		timbrar.setVersion("3.3");
		timbrar.setEvents("detalle");
		timbrar.setStatus("guardar");

		acciones.add(guardar);
		acciones.add(carrito);
		acciones.add(cancelar);
		acciones.add(eliminar);
		acciones.add(timbrar);
		acciones.add(cancelarCFDi);
		acciones.add(verError);

		tipo.setName("Tipo de documento");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("ingreso");
		tipo.setFormat("");


		campoCodigo.setName("Folio interno");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		//campoCodigo.setAutogenerado(true);
		campoCodigo.setFormat("{RFC-TIPO-CONS}");
		//campoCodigo.setAutogenerado(false);

		/*
		 * campoCampo.setNombre("Automatico"); campoCampo.setBd("AUTO");
		 * campoCampo.setCss("form-control"); campoCampo.setOrden(2);
		 * campoCampo.setType("checkbox"); campoCampo.setLectura(false);
		 * campoCampo.setOculto(false); campoCampo.setRequerido(true);
		 * campoCampo.setLista(true); campoCampo.setId(false);
		 * campoCampo.setGrupo("cabecero"); campoCampo.setPersistible(false);
		 */

		aMaterno.setName("Codigo emisor");
		aMaterno.setFieldName("emisorcodigo");
		aMaterno.setCss("form-control");
		aMaterno.setOrder(3);
		aMaterno.setComponentType("texto");
		aMaterno.setReadOnly(true);
		aMaterno.setHidden(false);
		aMaterno.setRequired(false);
		aMaterno.setShowInBasket(false);
		aMaterno.setId(false);
		aMaterno.setLength(20);
		aMaterno.setGroup("emisor");
		aMaterno.setPersistible(false);
		aMaterno.setFormat("Codigo emisor");
		aMaterno.setValue("${emisorcodigo}");

		aPaterno.setName("RFC emisor");
		aPaterno.setFieldName("emisor");
		aPaterno.setCss("form-control");
		aPaterno.setOrder(4);
		aPaterno.setComponentType("texto");
		aPaterno.setReadOnly(true);
		aPaterno.setHidden(false);
		aPaterno.setRequired(true);
		aPaterno.setShowInBasket(false);
		aPaterno.setId(false);
		aPaterno.setLength(20);
		aPaterno.setGroup("emisor");
		aPaterno.setPersistible(true);
		aPaterno.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		aPaterno.setFormat("RFC emisor");
		aPaterno.setValue("${emisor}");

		fNacim.setName("Codigo receptor");
		fNacim.setFieldName("receptorcodigo");
		fNacim.setCss("form-control");
		fNacim.setOrder(5);
		fNacim.setComponentType("texto");
		fNacim.setReadOnly(false);
		fNacim.setHidden(false);
		fNacim.setRequired(false);
		fNacim.setShowInBasket(false);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setGroup("receptor");
		fNacim.setPersistible(false);
		fNacim.setFormat("Codigo receptor");

		posicion.setName("RFC receptor");
		posicion.setFieldName("receptor");
		posicion.setCss("form-control");
		posicion.setOrder(6);
		posicion.setComponentType("texto");
		posicion.setReadOnly(false);
		posicion.setHidden(false);
		posicion.setRequired(true);
		posicion.setShowInBasket(false);
		posicion.setId(false);
		posicion.setLength(20);
		posicion.setGroup("receptor");
		posicion.setPersistible(true);
		posicion.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		posicion.setFormat("RFC receptor");

		puntuacion.setName("Uso CFDi");
		puntuacion.setFieldName("uso");
		puntuacion.setCss("form-control");
		puntuacion.setOrder(7);
		puntuacion.setComponentType("uso");
		puntuacion.setReadOnly(false);
		puntuacion.setHidden(false);
		puntuacion.setRequired(true);
		puntuacion.setShowInBasket(false);
		puntuacion.setId(false);
		puntuacion.setLength(5);
		puntuacion.setGroup("receptor");
		puntuacion.setPersistible(true);
		puntuacion.setValidation("");
		puntuacion.setFormat("Uso CFDi");
		puntuacion.setValue("");

		goles.setName("Direccion de facturación");
		goles.setFieldName("dirfactura");
		goles.setCss("form-control");
		goles.setOrder(8);
		goles.setComponentType("selectorDireccion");
		goles.setReadOnly(false);
		goles.setHidden(false);
		goles.setRequired(false);
		goles.setShowInBasket(false);
		goles.setId(false);
		goles.setLength(20);
		goles.setGroup("direccionFiscal");
		goles.setPersistible(false);
		goles.setFormat("Direccion de facturación");

		categoria.setName("Calle");
		categoria.setFieldName("calle");
		categoria.setCss("form-control");
		categoria.setOrder(10);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(20);
		categoria.setGroup("direccionFiscal");
		categoria.setPersistible(true);
		categoria.setFormat("Calle");

		usuario.setName("No Int");
		usuario.setFieldName("noint");
		usuario.setCss("form-control");
		usuario.setOrder(11);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(10);
		usuario.setGroup("direccionFiscal");
		usuario.setPersistible(true);
		usuario.setFormat("No Int");

		fecha.setName("No Ext");
		fecha.setFieldName("noext");
		fecha.setCss("form-control");
		fecha.setOrder(12);
		fecha.setComponentType("texto");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(10);
		fecha.setGroup("direccionFiscal");
		fecha.setPersistible(true);	
		fecha.setFormat("No Ext");

		municipio.setName("Municipio");
		municipio.setFieldName("municipio");
		municipio.setCss("form-control");
		municipio.setOrder(13);
		municipio.setComponentType("texto");
		municipio.setReadOnly(false);
		municipio.setHidden(false);
		municipio.setRequired(false);
		municipio.setShowInBasket(false);
		municipio.setId(false);
		municipio.setLength(20);
		municipio.setGroup("direccionFiscal");
		municipio.setPersistible(true);	
		municipio.setFormat("Municipio");

		poblacion.setName("Población");
		poblacion.setFieldName("poblacion");
		poblacion.setCss("form-control");
		poblacion.setOrder(14);
		poblacion.setComponentType("texto");
		poblacion.setReadOnly(false);
		poblacion.setHidden(false);
		poblacion.setRequired(false);
		poblacion.setShowInBasket(false);
		poblacion.setId(false);
		poblacion.setLength(20);
		poblacion.setGroup("direccionFiscal");
		poblacion.setPersistible(true);	
		poblacion.setFormat("Población");

		ciudad.setName("Ciudad");
		ciudad.setFieldName("ciudad");
		ciudad.setCss("form-control");
		ciudad.setOrder(15);
		ciudad.setComponentType("texto");
		ciudad.setReadOnly(false);
		ciudad.setHidden(false);
		ciudad.setRequired(false);
		ciudad.setShowInBasket(false);
		ciudad.setId(false);
		ciudad.setLength(20);
		ciudad.setGroup("direccionFiscal");
		ciudad.setPersistible(true);	
		ciudad.setFormat("Ciudad");

		imagen.setName("C. P.");
		imagen.setFieldName("cp");
		imagen.setCss("form-control");
		imagen.setOrder(16);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(10);
		imagen.setGroup("direccionFiscal");
		imagen.setPersistible(true);
		imagen.setFormat("C. P.");


		estado.setName("Estado");
		estado.setFieldName("estado");
		estado.setCss("form-control");
		estado.setOrder(17);
		estado.setComponentType("selectorEstado");
		estado.setReadOnly(false);
		estado.setHidden(false);
		estado.setRequired(false);
		estado.setShowInBasket(false);
		estado.setId(false);
		estado.setGroup("direccionFiscal");
		estado.setPersistible(true);
		estado.setLength(255);
		estado.setFormat("Estado");

		metodopago.setName("Metodo de pago");
		metodopago.setFieldName("metodopago");
		metodopago.setCss("form-control");
		metodopago.setOrder(18);
		metodopago.setComponentType("metodopago");
		metodopago.setReadOnly(false);
		metodopago.setHidden(false);
		metodopago.setRequired(false);
		metodopago.setShowInBasket(false);
		metodopago.setId(false);
		metodopago.setGroup("direccionFiscal");
		metodopago.setPersistible(true);
		metodopago.setLength(10);
		metodopago.setFormat("Metodo de pago");
		metodopago.setValue("");

		formapago.setName("Forma de pago");
		formapago.setFieldName("formapago");
		formapago.setCss("form-control");
		formapago.setOrder(19);
		formapago.setComponentType("formapago");
		formapago.setReadOnly(false);
		formapago.setHidden(false);
		formapago.setRequired(true);
		formapago.setShowInBasket(false);
		formapago.setId(false);
		formapago.setLength(6);
		formapago.setGroup("pago");
		formapago.setPersistible(false);
		formapago.setFormat("Forma de pago");
		formapago.setValue("");

		cantidad.setName("Monto");
		cantidad.setFieldName("monto");
		cantidad.setCss("form-control");
		cantidad.setOrder(20);
		cantidad.setComponentType("texto");
		cantidad.setReadOnly(false);
		cantidad.setHidden(false);
		cantidad.setRequired(true);
		cantidad.setShowInBasket(false);
		cantidad.setId(false);
		cantidad.setLength(20);
		cantidad.setGroup("pago");
		cantidad.setPersistible(false);
		cantidad.setFormat("00.00");
		cantidad.setValidation("^[1-9]+(\\.[0-9]{1,2})?$");

		fechaPago.setName("Fecha");
		fechaPago.setFieldName("fecha");
		fechaPago.setCss("form-control");
		fechaPago.setOrder(21);
		fechaPago.setComponentType("fecha");
		fechaPago.setReadOnly(false);
		fechaPago.setHidden(false);
		fechaPago.setRequired(true);
		fechaPago.setShowInBasket(false);
		fechaPago.setId(false);
		fechaPago.setLength(10);
		fechaPago.setGroup("pago");
		fechaPago.setPersistible(true);
		fechaPago.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fechaPago.setFormat("yyyy-MM-dd");

		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(21);
		obs.setComponentType("texto");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(true);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(20);
		obs.setGroup("pago");
		obs.setPersistible(false);
		obs.setFormat("Observaciones");

		subtotal.setName("Subtotal");
		subtotal.setFieldName("subtotal");
		subtotal.setCss("form-control");
		subtotal.setOrder(22);
		subtotal.setComponentType("moneda");
		subtotal.setReadOnly(true);
		subtotal.setHidden(false);
		subtotal.setRequired(true);
		subtotal.setShowInBasket(true);
		subtotal.setId(false);
		subtotal.setLength(20);
		subtotal.setGroup("totales");
		subtotal.setPersistible(false);
		subtotal.setValue("00.00");
		subtotal.setFormat("00.00");
		subtotal.setValidation("^(0*[1-9][0-9]*(\\.[0-9]+)?|0+\\.[0-9]*[1-9][0-9]*)$");

		descuento.setName("Descuento");
		descuento.setFieldName("descuento");
		descuento.setCss("form-control");
		descuento.setOrder(23);
		descuento.setComponentType("moneda");
		descuento.setReadOnly(true);
		descuento.setHidden(false);
		descuento.setRequired(true);
		descuento.setShowInBasket(true);
		descuento.setId(false);
		descuento.setLength(20);
		descuento.setGroup("totales");
		descuento.setPersistible(false);
		descuento.setValue("00.00");
		descuento.setFormat("00.00");


		impret.setName("Impuesto retenido");
		impret.setFieldName("impret");
		impret.setCss("form-control");
		impret.setOrder(24);
		impret.setComponentType("moneda");
		impret.setReadOnly(true);
		impret.setHidden(false);
		impret.setRequired(true);
		impret.setShowInBasket(true);
		impret.setId(false);
		impret.setLength(20);
		impret.setGroup("totales");
		impret.setPersistible(false);
		impret.setValue("00.00");
		impret.setFormat("00.00");

		imptras.setName("Impuesto trasladado");
		imptras.setFieldName("imptras");
		imptras.setCss("form-control");
		imptras.setOrder(25);
		imptras.setComponentType("moneda");
		imptras.setReadOnly(true);
		imptras.setHidden(false);
		imptras.setRequired(true);
		imptras.setShowInBasket(true);
		imptras.setId(false);
		imptras.setLength(20);
		imptras.setGroup("totales");
		imptras.setPersistible(false);
		imptras.setValue("00.00");
		imptras.setFormat("00.00");

		total.setName("Total");
		total.setFieldName("total");
		total.setCss("form-control");
		total.setOrder(26);
		total.setComponentType("moneda");
		total.setReadOnly(true);
		total.setHidden(false);
		total.setRequired(true);
		total.setShowInBasket(true);
		total.setId(false);
		total.setLength(20);
		total.setGroup("totales");
		total.setPersistible(false);
		total.setValue("00.00");
		total.setValidation("[a-zA-Z0-9,.;:_'\\s-]+$");
		total.setFormat("00.00");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(27);
		status.setComponentType("texto");
		status.setReadOnly(true);
		status.setHidden(true);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("nuevo");
		status.setValidation("");
		status.setFormat("Status");

		serie.setName("Serie");
		serie.setFieldName("serie");
		serie.setCss("form-control");
		serie.setOrder(28);
		serie.setComponentType("texto");
		serie.setReadOnly(true);
		serie.setHidden(true);
		serie.setRequired(true);
		serie.setShowInBasket(true);
		serie.setId(false);
		serie.setLength(20);
		serie.setGroup("cabecero");
		serie.setPersistible(false);
		serie.setValue("I");
		serie.setValidation("");
		serie.setFormat("Serie");

		uuid.setName("UUID");
		uuid.setFieldName("uuid");
		uuid.setCss("form-control");
		uuid.setOrder(29);
		uuid.setComponentType("texto");
		uuid.setReadOnly(true);
		uuid.setHidden(true);
		uuid.setRequired(false);
		uuid.setShowInBasket(true);
		uuid.setId(false);
		uuid.setLength(50);
		uuid.setGroup("cabecero");
		uuid.setPersistible(true);
		uuid.setValue("");
		uuid.setValidation("");
		uuid.setFormat("UUID");

		campos.add(status);
		campos.add(total);
		campos.add(impret);
		campos.add(imptras);
		campos.add(descuento);
		campos.add(subtotal);
		campos.add(tipo);
		campos.add(obs);
		campos.add(fechaPago);
		campos.add(cantidad);
		campos.add(formapago);
		campos.add(metodopago);
		campos.add(estado);
		campos.add(ciudad);
		campos.add(poblacion);
		campos.add(municipio);
		campos.add(goles);
		campos.add(puntuacion);
		campos.add(aMaterno);
		//campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(aPaterno);
		campos.add(fNacim);
		campos.add(posicion);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		campos.add(serie);
		campos.add(uuid);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("Guardar");
		forma.setName("ingreso");
		forma.setView("ingreso");
		forma.setTitle("Ingreso");
		forma.setVersion("3.3");
		forma.setStatus("produccion");
		forma.setModule("comprobantes");
		forma.setBasket("ingreso");
		forma.setCreateable(false);
		forma.setTable("doctos");
		forma.setValidate(true);
		forma.setInstruction("Comprobante fiscal de tipo ingreso");

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

	@Test
	public void testGuardarFormaReservacion() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("reservacion.json").normalize();
		List<Field> decoradoreEmisor = new ArrayList<Field>();
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field campoCodigo = new Field();
		//Campo campoCampo = new Campo();
		
		Field goles = new Field();
		Field imagen = new Field();
		Field categoria = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Resource forma = new Resource();
		Field municipio = new Field();
		Field poblacion = new Field();
		Field ciudad = new Field();
		Field estado = new Field();
		Field metodopago = new Field();
		Field formapago = new Field();
		Field cantidad = new Field();
		Field fechaPago = new Field();
		Field horaPago = new Field();
		Field obs = new Field();
		Field tipo = new Field();
		Field subtotal = new Field();
		Field descuento = new Field();

		Field total = new Field();
		Field status = new Field();
		Field serie = new Field();
		Field uuid = new Field();

		Button verError = new Button();
		verError.setCommandName("error");
		verError.setName("error");
		verError.setLabel("Ver error");
		verError.setComponentType("location");
		verError.setCss("btn btn-info");
		verError.setResourceName("reservacion");
		verError.setModule("solicitud");
		verError.setOrder(3);
		verError.setResourceType("forma");
		verError.setVersion("1.0");
		verError.setEvents("detalle");
		verError.setStatus("CFDI33196");
		
		Button carrito = new Button();
		carrito.setCommandName("nuevo");
		carrito.setName("nuevo");
		carrito.setLabel("Productos/Servicios/Kits");
		carrito.setComponentType("location");
		carrito.setCss("btn btn-info");
		carrito.setResourceName("prodserv");
		carrito.setModule("inventario");
		carrito.setOrder(3);
		carrito.setResourceType("basket");
		carrito.setVersion("1.0");
		carrito.setEvents("nuevo");
		carrito.setStatus("nuevo");

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Submit");
		guardar.setComponentType("submit");
		guardar.setCss("btn btn-primary w-100 py-3");
		guardar.setResourceName("reservacion");
		guardar.setModule("solicitud");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		guardar.setStatus("nuevo");

		Button cancelar = new Button();
		cancelar.setCommandName("cancelar");
		cancelar.setName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("botonjs");
		cancelar.setCss("btn btn-info");
		cancelar.setResourceName("usuario");
		cancelar.setModule("directorio");
		cancelar.setOrder(1);
		cancelar.setResourceType("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvents("detalle");
		cancelar.setStatus("guardar");


		Button eliminar = new Button();
		eliminar.setCommandName("actualizar");
		eliminar.setName("actualizar");
		eliminar.setLabel("Actualizar");
		eliminar.setComponentType("botonjs");
		eliminar.setCss("btn btn-info");
		eliminar.setResourceName("ingreso");
		eliminar.setModule("comprobantes");
		eliminar.setOrder(5);
		eliminar.setResourceType("forma");
		eliminar.setVersion("3.3");
		eliminar.setEvents("detalle");
		eliminar.setStatus("guardar");
		eliminar.setInstruction("Registro actualizado !!");


		acciones.add(guardar);
		acciones.add(carrito);
		acciones.add(cancelar);
		acciones.add(eliminar);
		acciones.add(verError);

		tipo.setName("Tipo de documento");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("reservacion");
		tipo.setFormat("");
		tipo.setDbFieldType("varchar");


		campoCodigo.setName("Folio interno");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		//campoCodigo.setAutogenerado(true);
		campoCodigo.setFormat("{TIPO-CONS}");
		//campoCodigo.setAutogenerado(false);
		campoCodigo.setDbFieldType("varchar");
		

		/*
		 * campoCampo.setNombre("Automatico"); campoCampo.setBd("AUTO");
		 * campoCampo.setCss("form-control"); campoCampo.setOrden(2);
		 * campoCampo.setType("checkbox"); campoCampo.setLectura(false);
		 * campoCampo.setOculto(false); campoCampo.setRequerido(true);
		 * campoCampo.setLista(true); campoCampo.setId(false);
		 * campoCampo.setGrupo("cabecero"); campoCampo.setPersistible(false);
		 */


		goles.setName("Direccion de facturación");
		goles.setFieldName("dirfactura");
		goles.setCss("form-control");
		goles.setOrder(8);
		goles.setComponentType("selectorDireccion");
		goles.setReadOnly(false);
		goles.setHidden(false);
		goles.setRequired(false);
		goles.setShowInBasket(false);
		goles.setId(false);
		goles.setLength(20);
		goles.setGroup("direccionFiscal");
		goles.setPersistible(false);
		goles.setFormat("Direccion de facturación");
		goles.setDbFieldType("varchar");

		categoria.setName("Calle");
		categoria.setFieldName("calle");
		categoria.setCss("form-control");
		categoria.setOrder(10);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(20);
		categoria.setGroup("direccionFiscal");
		categoria.setPersistible(true);
		categoria.setFormat("Calle");
		categoria.setDbFieldType("varchar");

		usuario.setName("No Int");
		usuario.setFieldName("noint");
		usuario.setCss("form-control");
		usuario.setOrder(11);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(10);
		usuario.setGroup("direccionFiscal");
		usuario.setPersistible(true);
		usuario.setFormat("No Int");
		usuario.setDbFieldType("varchar");

		fecha.setName("No Ext");
		fecha.setFieldName("noext");
		fecha.setCss("form-control");
		fecha.setOrder(12);
		fecha.setComponentType("texto");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(10);
		fecha.setGroup("direccionFiscal");
		fecha.setPersistible(true);	
		fecha.setFormat("No Ext");
		fecha.setDbFieldType("varchar");

		municipio.setName("Municipio");
		municipio.setFieldName("municipio");
		municipio.setCss("form-control");
		municipio.setOrder(13);
		municipio.setComponentType("texto");
		municipio.setReadOnly(false);
		municipio.setHidden(false);
		municipio.setRequired(false);
		municipio.setShowInBasket(false);
		municipio.setId(false);
		municipio.setLength(20);
		municipio.setGroup("direccionFiscal");
		municipio.setPersistible(true);	
		municipio.setFormat("Municipio");
		municipio.setDbFieldType("varchar");

		poblacion.setName("Población");
		poblacion.setFieldName("poblacion");
		poblacion.setCss("form-control");
		poblacion.setOrder(14);
		poblacion.setComponentType("texto");
		poblacion.setReadOnly(false);
		poblacion.setHidden(false);
		poblacion.setRequired(false);
		poblacion.setShowInBasket(false);
		poblacion.setId(false);
		poblacion.setLength(20);
		poblacion.setGroup("direccionFiscal");
		poblacion.setPersistible(true);	
		poblacion.setFormat("Población");
		poblacion.setDbFieldType("varchar");

		ciudad.setName("Ciudad");
		ciudad.setFieldName("ciudad");
		ciudad.setCss("form-control");
		ciudad.setOrder(15);
		ciudad.setComponentType("texto");
		ciudad.setReadOnly(false);
		ciudad.setHidden(false);
		ciudad.setRequired(false);
		ciudad.setShowInBasket(false);
		ciudad.setId(false);
		ciudad.setLength(20);
		ciudad.setGroup("direccionFiscal");
		ciudad.setPersistible(true);	
		ciudad.setFormat("Ciudad");
		ciudad.setDbFieldType("varchar");

		imagen.setName("C. P.");
		imagen.setFieldName("cp");
		imagen.setCss("form-control");
		imagen.setOrder(16);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(10);
		imagen.setGroup("direccionFiscal");
		imagen.setPersistible(true);
		imagen.setFormat("C. P.");
		imagen.setDbFieldType("varchar");

		estado.setName("Estado");
		estado.setFieldName("estado");
		estado.setCss("form-control");
		estado.setOrder(17);
		estado.setComponentType("selectorEstado");
		estado.setReadOnly(false);
		estado.setHidden(false);
		estado.setRequired(false);
		estado.setShowInBasket(false);
		estado.setId(false);
		estado.setGroup("direccionFiscal");
		estado.setPersistible(true);
		estado.setLength(255);
		estado.setFormat("Estado");
		estado.setDbFieldType("varchar");

		metodopago.setName("Metodo de pago");
		metodopago.setFieldName("metodopago");
		metodopago.setCss("form-control");
		metodopago.setOrder(18);
		metodopago.setComponentType("metodopago");
		metodopago.setReadOnly(false);
		metodopago.setHidden(false);
		metodopago.setRequired(false);
		metodopago.setShowInBasket(false);
		metodopago.setId(false);
		metodopago.setGroup("direccionFiscal");
		metodopago.setPersistible(true);
		metodopago.setLength(10);
		metodopago.setFormat("Metodo de pago");
		metodopago.setValue("");
		metodopago.setDbFieldType("varchar");

		formapago.setName("Forma de pago");
		formapago.setFieldName("formapago");
		formapago.setCss("form-control");
		formapago.setOrder(19);
		formapago.setComponentType("formapago");
		formapago.setReadOnly(false);
		formapago.setHidden(false);
		formapago.setRequired(true);
		formapago.setShowInBasket(false);
		formapago.setId(false);
		formapago.setLength(6);
		formapago.setGroup("pago");
		formapago.setPersistible(false);
		formapago.setFormat("Forma de pago");
		formapago.setValue("");
		formapago.setDbFieldType("varchar");

		cantidad.setName("Monto");
		cantidad.setFieldName("monto");
		cantidad.setCss("form-control");
		cantidad.setOrder(20);
		cantidad.setComponentType("texto");
		cantidad.setReadOnly(false);
		cantidad.setHidden(false);
		cantidad.setRequired(true);
		cantidad.setShowInBasket(false);
		cantidad.setId(false);
		cantidad.setLength(20);
		cantidad.setGroup("pago");
		cantidad.setPersistible(false);
		cantidad.setFormat("00.00");
		cantidad.setValidation("^[1-9]+(\\.[0-9]{1,2})?$");
		cantidad.setDbFieldType("varchar");

		fechaPago.setName("Fecha");
		fechaPago.setFieldName("fecha");
		fechaPago.setCss("form-control");
		fechaPago.setOrder(21);
		fechaPago.setComponentType("fecha");
		fechaPago.setReadOnly(false);
		fechaPago.setHidden(false);
		fechaPago.setRequired(true);
		fechaPago.setShowInBasket(false);
		fechaPago.setId(false);
		fechaPago.setLength(10);
		fechaPago.setGroup("pago");
		fechaPago.setPersistible(true);
		fechaPago.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fechaPago.setFormat("yyyy-MM-dd");
		fechaPago.setDbFieldType("date");

		horaPago.setName("Creacion");
		horaPago.setFieldName("creado");
		horaPago.setCss("form-control");
		horaPago.setOrder(21);
		horaPago.setComponentType("texto");
		horaPago.setReadOnly(false);
		horaPago.setHidden(false);
		horaPago.setRequired(true);
		horaPago.setShowInBasket(false);
		horaPago.setId(false);
		horaPago.setLength(10);
		horaPago.setGroup("pago");
		horaPago.setPersistible(true);
		horaPago.setValidation("");
		horaPago.setFormat("");
		horaPago.setDbFieldType("varchar");
		
		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(21);
		obs.setComponentType("texto");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(true);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(20);
		obs.setGroup("pago");
		obs.setPersistible(false);
		obs.setFormat("Observaciones");
		obs.setDbFieldType("varchar");

		subtotal.setName("Subtotal");
		subtotal.setFieldName("subtotal");
		subtotal.setCss("form-control");
		subtotal.setOrder(22);
		subtotal.setComponentType("moneda");
		subtotal.setReadOnly(true);
		subtotal.setHidden(false);
		subtotal.setRequired(true);
		subtotal.setShowInBasket(true);
		subtotal.setId(false);
		subtotal.setLength(8);
		subtotal.setGroup("totales");
		subtotal.setPersistible(false);
		subtotal.setValue("00.00");
		subtotal.setFormat("00.00");
		subtotal.setValidation("^(0*[1-9][0-9]*(\\.[0-9]+)?|0+\\.[0-9]*[1-9][0-9]*)$");
		subtotal.setDecimals(2);
		subtotal.setDbFieldType("decimal");

		descuento.setName("Descuento");
		descuento.setFieldName("descuento");
		descuento.setCss("form-control");
		descuento.setOrder(23);
		descuento.setComponentType("moneda");
		descuento.setReadOnly(true);
		descuento.setHidden(false);
		descuento.setRequired(true);
		descuento.setShowInBasket(true);
		descuento.setId(false);
		descuento.setLength(8);
		descuento.setGroup("totales");
		descuento.setPersistible(false);
		descuento.setValue("00.00");
		descuento.setFormat("00.00");
		descuento.setDecimals(2);
		descuento.setDbFieldType("decimal");

		total.setName("Total");
		total.setFieldName("total");
		total.setCss("form-control");
		total.setOrder(26);
		total.setComponentType("moneda");
		total.setReadOnly(true);
		total.setHidden(false);
		total.setRequired(true);
		total.setShowInBasket(true);
		total.setId(false);
		total.setLength(8);
		total.setGroup("totales");
		total.setPersistible(false);
		total.setValue("00.00");
		total.setValidation("[a-zA-Z0-9,.;:_'\\s-]+$");
		total.setFormat("00.00");
		total.setDecimals(2);
		total.setDbFieldType("decimal");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(27);
		status.setComponentType("texto");
		status.setReadOnly(true);
		status.setHidden(true);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("nuevo");
		status.setValidation("");
		status.setFormat("Status");
		status.setDbFieldType("varchar");

		serie.setName("Serie");
		serie.setFieldName("serie");
		serie.setCss("form-control");
		serie.setOrder(28);
		serie.setComponentType("texto");
		serie.setReadOnly(true);
		serie.setHidden(true);
		serie.setRequired(true);
		serie.setShowInBasket(true);
		serie.setId(false);
		serie.setLength(20);
		serie.setGroup("cabecero");
		serie.setPersistible(false);
		serie.setValue("I");
		serie.setValidation("");
		serie.setFormat("Serie");
		serie.setDbFieldType("varchar");

		uuid.setName("UUID");
		uuid.setFieldName("uuid");
		uuid.setCss("form-control");
		uuid.setOrder(29);
		uuid.setComponentType("texto");
		uuid.setReadOnly(true);
		uuid.setHidden(true);
		uuid.setRequired(false);
		uuid.setShowInBasket(true);
		uuid.setId(false);
		uuid.setLength(50);
		uuid.setGroup("cabecero");
		uuid.setPersistible(true);
		uuid.setValue("");
		uuid.setValidation("");
		uuid.setFormat("UUID");
		uuid.setDbFieldType("varchar");

		campos.add(status);
		campos.add(total);
		campos.add(descuento);
		campos.add(subtotal);
		campos.add(tipo);
		campos.add(obs);
		campos.add(fechaPago);
		campos.add(horaPago);
		campos.add(cantidad);
		campos.add(formapago);
		campos.add(metodopago);
		campos.add(estado);
		campos.add(ciudad);
		campos.add(poblacion);
		campos.add(municipio);
		campos.add(goles);
		//campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		campos.add(serie);
		campos.add(uuid);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("Guardar");
		forma.setName("reservacion");
		forma.setView("reservacion");
		forma.setTitle("Reservacion");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("solicitud");
		forma.setBasket("reservacion");
		forma.setCreateable(true);
		forma.setTable("doctos");
		forma.setValidate(true);
		forma.setInstruction("Reservacion");

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
	
	@Test
	public void testGuardarFormaRemision() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("remision.json").normalize();
		List<Field> decoradoreEmisor = new ArrayList<Field>();
		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field campoCodigo = new Field();
		//Campo campoCampo = new Campo();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();
		Field posicion = new Field();
		Field goles = new Field();
		Field puntuacion = new Field();
		Field imagen = new Field();
		Field categoria = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Resource forma = new Resource();
		Field municipio = new Field();
		Field poblacion = new Field();
		Field ciudad = new Field();
		Field estado = new Field();
		Field metodopago = new Field();
		Field formapago = new Field();
		Field cantidad = new Field();
		Field fechaPago = new Field();
		Field obs = new Field();
		Field tipo = new Field();
		Field subtotal = new Field();
		Field descuento = new Field();
		Field imptras = new Field();
		Field impret = new Field();
		Field total = new Field();
		Field status = new Field();
		Field serie = new Field();
		Field uuid = new Field();

		Button carrito = new Button();
		carrito.setCommandName("nuevo");
		carrito.setName("nuevo");
		carrito.setLabel("Productos/Servicios/Kits");
		carrito.setComponentType("location");
		carrito.setCss("btn btn-info");
		carrito.setResourceName("prodserv");
		carrito.setModule("inventario");
		carrito.setOrder(3);
		carrito.setResourceType("basket");
		carrito.setVersion("1.0");
		carrito.setEvents("nuevo");
		carrito.setStatus("nuevo");

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-info");
		guardar.setResourceName("ingreso");
		guardar.setModule("comprobantes");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("3.3");
		guardar.setEvents("nuevo");
		guardar.setStatus("nuevo");

		Button cancelar = new Button();
		cancelar.setCommandName("cancelar");
		cancelar.setName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("botonjs");
		cancelar.setCss("btn btn-info");
		cancelar.setResourceName("usuario");
		cancelar.setModule("directorio");
		cancelar.setOrder(1);
		cancelar.setResourceType("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvents("detalle");
		cancelar.setStatus("guardar");

		Button eliminar = new Button();
		eliminar.setCommandName("actualizar");
		eliminar.setName("actualizar");
		eliminar.setLabel("Actualizar");
		eliminar.setComponentType("botonjs");
		eliminar.setCss("btn btn-info");
		eliminar.setResourceName("remision");
		eliminar.setModule("documentos");
		eliminar.setOrder(5);
		eliminar.setResourceType("forma");
		eliminar.setVersion("1.0");
		eliminar.setEvents("detalle");
		eliminar.setStatus("guardar");

		Button timbrar = new Button();
		timbrar.setCommandName("timbrar");
		timbrar.setName("timbrar");
		timbrar.setLabel("Timbrar");
		timbrar.setComponentType("botonjs");
		timbrar.setCss("btn btn-info");
		timbrar.setResourceName("ingreso");
		timbrar.setModule("comprobantes");
		timbrar.setOrder(6);
		timbrar.setResourceType("forma");
		timbrar.setVersion("3.3");
		timbrar.setEvents("detalle");
		timbrar.setStatus("guardar");

		acciones.add(guardar);
		acciones.add(carrito);
		acciones.add(cancelar);
		acciones.add(eliminar);
		acciones.add(timbrar);



		tipo.setName("Tipo de documento");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("remision");
		tipo.setFormat("");


		campoCodigo.setName("Folio interno");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		//campoCodigo.setAutogenerado(true);
		campoCodigo.setFormat("{RFC-TIPO-CONS}");
		//campoCodigo.setAutogenerado(false);

		/*
		 * campoCampo.setNombre("Automatico"); campoCampo.setBd("AUTO");
		 * campoCampo.setCss("form-control"); campoCampo.setOrden(2);
		 * campoCampo.setType("checkbox"); campoCampo.setLectura(false);
		 * campoCampo.setOculto(false); campoCampo.setRequerido(true);
		 * campoCampo.setLista(true); campoCampo.setId(false);
		 * campoCampo.setGrupo("cabecero"); campoCampo.setPersistible(false);
		 */

		aMaterno.setName("Codigo emisor");
		aMaterno.setFieldName("emisorcodigo");
		aMaterno.setCss("form-control");
		aMaterno.setOrder(3);
		aMaterno.setComponentType("texto");
		aMaterno.setReadOnly(true);
		aMaterno.setHidden(false);
		aMaterno.setRequired(false);
		aMaterno.setShowInBasket(false);
		aMaterno.setId(false);
		aMaterno.setLength(20);
		aMaterno.setGroup("emisor");
		aMaterno.setPersistible(false);
		aMaterno.setFormat("Codigo emisor");
		aMaterno.setValue("${emisorcodigo}");

		aPaterno.setName("RFC emisor");
		aPaterno.setFieldName("emisor");
		aPaterno.setCss("form-control");
		aPaterno.setOrder(4);
		aPaterno.setComponentType("texto");
		aPaterno.setReadOnly(true);
		aPaterno.setHidden(false);
		aPaterno.setRequired(true);
		aPaterno.setShowInBasket(false);
		aPaterno.setId(false);
		aPaterno.setLength(20);
		aPaterno.setGroup("emisor");
		aPaterno.setPersistible(true);
		aPaterno.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		aPaterno.setFormat("RFC emisor");
		aPaterno.setValue("${emisor}");

		fNacim.setName("Codigo receptor");
		fNacim.setFieldName("receptorcodigo");
		fNacim.setCss("form-control");
		fNacim.setOrder(5);
		fNacim.setComponentType("texto");
		fNacim.setReadOnly(false);
		fNacim.setHidden(false);
		fNacim.setRequired(false);
		fNacim.setShowInBasket(false);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setGroup("receptor");
		fNacim.setPersistible(false);
		fNacim.setFormat("Codigo receptor");

		posicion.setName("RFC receptor");
		posicion.setFieldName("receptor");
		posicion.setCss("form-control");
		posicion.setOrder(6);
		posicion.setComponentType("texto");
		posicion.setReadOnly(false);
		posicion.setHidden(false);
		posicion.setRequired(true);
		posicion.setShowInBasket(false);
		posicion.setId(false);
		posicion.setLength(20);
		posicion.setGroup("receptor");
		posicion.setPersistible(true);
		posicion.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		posicion.setFormat("RFC receptor");

		puntuacion.setName("Uso CFDi");
		puntuacion.setFieldName("uso");
		puntuacion.setCss("form-control");
		puntuacion.setOrder(7);
		puntuacion.setComponentType("uso");
		puntuacion.setReadOnly(false);
		puntuacion.setHidden(false);
		puntuacion.setRequired(true);
		puntuacion.setShowInBasket(false);
		puntuacion.setId(false);
		puntuacion.setLength(5);
		puntuacion.setGroup("receptor");
		puntuacion.setPersistible(true);
		puntuacion.setValidation("");
		puntuacion.setFormat("Uso CFDi");
		puntuacion.setValue("");

		goles.setName("Direccion de facturación");
		goles.setFieldName("dirfactura");
		goles.setCss("form-control");
		goles.setOrder(8);
		goles.setComponentType("selectorDireccion");
		goles.setReadOnly(false);
		goles.setHidden(false);
		goles.setRequired(false);
		goles.setShowInBasket(false);
		goles.setId(false);
		goles.setLength(20);
		goles.setGroup("direccionFiscal");
		goles.setPersistible(false);
		goles.setFormat("Direccion de facturación");

		categoria.setName("Calle");
		categoria.setFieldName("calle");
		categoria.setCss("form-control");
		categoria.setOrder(10);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(20);
		categoria.setGroup("direccionFiscal");
		categoria.setPersistible(true);
		categoria.setFormat("Calle");

		usuario.setName("No Int");
		usuario.setFieldName("noint");
		usuario.setCss("form-control");
		usuario.setOrder(11);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(10);
		usuario.setGroup("direccionFiscal");
		usuario.setPersistible(true);
		usuario.setFormat("No Int");

		fecha.setName("No Ext");
		fecha.setFieldName("noext");
		fecha.setCss("form-control");
		fecha.setOrder(12);
		fecha.setComponentType("texto");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(10);
		fecha.setGroup("direccionFiscal");
		fecha.setPersistible(true);	
		fecha.setFormat("No Ext");

		municipio.setName("Municipio");
		municipio.setFieldName("municipio");
		municipio.setCss("form-control");
		municipio.setOrder(13);
		municipio.setComponentType("texto");
		municipio.setReadOnly(false);
		municipio.setHidden(false);
		municipio.setRequired(false);
		municipio.setShowInBasket(false);
		municipio.setId(false);
		municipio.setLength(20);
		municipio.setGroup("direccionFiscal");
		municipio.setPersistible(true);	
		municipio.setFormat("Municipio");

		poblacion.setName("Población");
		poblacion.setFieldName("poblacion");
		poblacion.setCss("form-control");
		poblacion.setOrder(14);
		poblacion.setComponentType("texto");
		poblacion.setReadOnly(false);
		poblacion.setHidden(false);
		poblacion.setRequired(false);
		poblacion.setShowInBasket(false);
		poblacion.setId(false);
		poblacion.setLength(20);
		poblacion.setGroup("direccionFiscal");
		poblacion.setPersistible(true);	
		poblacion.setFormat("Población");

		ciudad.setName("Ciudad");
		ciudad.setFieldName("ciudad");
		ciudad.setCss("form-control");
		ciudad.setOrder(15);
		ciudad.setComponentType("texto");
		ciudad.setReadOnly(false);
		ciudad.setHidden(false);
		ciudad.setRequired(false);
		ciudad.setShowInBasket(false);
		ciudad.setId(false);
		ciudad.setLength(20);
		ciudad.setGroup("direccionFiscal");
		ciudad.setPersistible(true);	
		ciudad.setFormat("Ciudad");

		imagen.setName("C. P.");
		imagen.setFieldName("cp");
		imagen.setCss("form-control");
		imagen.setOrder(16);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(10);
		imagen.setGroup("direccionFiscal");
		imagen.setPersistible(true);
		imagen.setFormat("C. P.");


		estado.setName("Estado");
		estado.setFieldName("estado");
		estado.setCss("form-control");
		estado.setOrder(17);
		estado.setComponentType("selectorEstado");
		estado.setReadOnly(false);
		estado.setHidden(false);
		estado.setRequired(false);
		estado.setShowInBasket(false);
		estado.setId(false);
		estado.setGroup("direccionFiscal");
		estado.setPersistible(true);
		estado.setLength(255);
		estado.setFormat("Estado");

		metodopago.setName("Metodo de pago");
		metodopago.setFieldName("metodopago");
		metodopago.setCss("form-control");
		metodopago.setOrder(18);
		metodopago.setComponentType("metodopago");
		metodopago.setReadOnly(false);
		metodopago.setHidden(false);
		metodopago.setRequired(false);
		metodopago.setShowInBasket(false);
		metodopago.setId(false);
		metodopago.setGroup("direccionFiscal");
		metodopago.setPersistible(true);
		metodopago.setLength(10);
		metodopago.setFormat("Metodo de pago");
		metodopago.setValue("");

		formapago.setName("Forma de pago");
		formapago.setFieldName("formapago");
		formapago.setCss("form-control");
		formapago.setOrder(19);
		formapago.setComponentType("formapago");
		formapago.setReadOnly(false);
		formapago.setHidden(false);
		formapago.setRequired(true);
		formapago.setShowInBasket(false);
		formapago.setId(false);
		formapago.setLength(6);
		formapago.setGroup("pago");
		formapago.setPersistible(false);
		formapago.setFormat("Forma de pago");
		formapago.setValue("");

		cantidad.setName("Monto");
		cantidad.setFieldName("monto");
		cantidad.setCss("form-control");
		cantidad.setOrder(20);
		cantidad.setComponentType("texto");
		cantidad.setReadOnly(false);
		cantidad.setHidden(false);
		cantidad.setRequired(true);
		cantidad.setShowInBasket(false);
		cantidad.setId(false);
		cantidad.setLength(20);
		cantidad.setGroup("pago");
		cantidad.setPersistible(false);
		cantidad.setFormat("00.00");
		cantidad.setValidation("^[1-9]+(\\.[0-9]{1,2})?$");

		fechaPago.setName("Fecha");
		fechaPago.setFieldName("fecha");
		fechaPago.setCss("form-control");
		fechaPago.setOrder(21);
		fechaPago.setComponentType("fecha");
		fechaPago.setReadOnly(true);
		fechaPago.setHidden(false);
		fechaPago.setRequired(true);
		fechaPago.setShowInBasket(false);
		fechaPago.setId(false);
		fechaPago.setLength(10);
		fechaPago.setGroup("pago");
		fechaPago.setPersistible(true);
		fechaPago.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fechaPago.setFormat("yyyy-MM-dd");
		fechaPago.setValue("${hoyCorto}");

		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(21);
		obs.setComponentType("texto");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(true);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(20);
		obs.setGroup("pago");
		obs.setPersistible(false);
		obs.setFormat("Observaciones");

		subtotal.setName("Subtotal");
		subtotal.setFieldName("subtotal");
		subtotal.setCss("form-control");
		subtotal.setOrder(22);
		subtotal.setComponentType("moneda");
		subtotal.setReadOnly(true);
		subtotal.setHidden(false);
		subtotal.setRequired(true);
		subtotal.setShowInBasket(true);
		subtotal.setId(false);
		subtotal.setLength(20);
		subtotal.setGroup("totales");
		subtotal.setPersistible(false);
		subtotal.setValue("00.00");
		subtotal.setFormat("00.00");
		subtotal.setValidation("^(0*[1-9][0-9]*(\\.[0-9]+)?|0+\\.[0-9]*[1-9][0-9]*)$");

		descuento.setName("Descuento");
		descuento.setFieldName("descuento");
		descuento.setCss("form-control");
		descuento.setOrder(23);
		descuento.setComponentType("moneda");
		descuento.setReadOnly(true);
		descuento.setHidden(false);
		descuento.setRequired(true);
		descuento.setShowInBasket(true);
		descuento.setId(false);
		descuento.setLength(20);
		descuento.setGroup("totales");
		descuento.setPersistible(false);
		descuento.setValue("00.00");
		descuento.setFormat("00.00");


		impret.setName("Impuesto retenido");
		impret.setFieldName("impret");
		impret.setCss("form-control");
		impret.setOrder(24);
		impret.setComponentType("moneda");
		impret.setReadOnly(true);
		impret.setHidden(false);
		impret.setRequired(true);
		impret.setShowInBasket(true);
		impret.setId(false);
		impret.setLength(20);
		impret.setGroup("totales");
		impret.setPersistible(false);
		impret.setValue("00.00");
		impret.setFormat("00.00");

		imptras.setName("Impuesto trasladado");
		imptras.setFieldName("imptras");
		imptras.setCss("form-control");
		imptras.setOrder(25);
		imptras.setComponentType("moneda");
		imptras.setReadOnly(true);
		imptras.setHidden(false);
		imptras.setRequired(true);
		imptras.setShowInBasket(true);
		imptras.setId(false);
		imptras.setLength(20);
		imptras.setGroup("totales");
		imptras.setPersistible(false);
		imptras.setValue("00.00");
		imptras.setFormat("00.00");

		total.setName("Total");
		total.setFieldName("total");
		total.setCss("form-control");
		total.setOrder(26);
		total.setComponentType("moneda");
		total.setReadOnly(true);
		total.setHidden(false);
		total.setRequired(true);
		total.setShowInBasket(true);
		total.setId(false);
		total.setLength(20);
		total.setGroup("totales");
		total.setPersistible(false);
		total.setValue("00.00");
		total.setValidation("[a-zA-Z0-9,.;:_'\\s-]+$");
		total.setFormat("00.00");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(27);
		status.setComponentType("texto");
		status.setReadOnly(true);
		status.setHidden(true);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("nuevo");
		status.setValidation("");
		status.setFormat("Status");

		serie.setName("Serie");
		serie.setFieldName("serie");
		serie.setCss("form-control");
		serie.setOrder(28);
		serie.setComponentType("texto");
		serie.setReadOnly(true);
		serie.setHidden(true);
		serie.setRequired(true);
		serie.setShowInBasket(true);
		serie.setId(false);
		serie.setLength(20);
		serie.setGroup("cabecero");
		serie.setPersistible(false);
		serie.setValue("I");
		serie.setValidation("");
		serie.setFormat("Serie");

		uuid.setName("UUID");
		uuid.setFieldName("uuid");
		uuid.setCss("form-control");
		uuid.setOrder(29);
		uuid.setComponentType("texto");
		uuid.setReadOnly(true);
		uuid.setHidden(true);
		uuid.setRequired(false);
		uuid.setShowInBasket(true);
		uuid.setId(false);
		uuid.setLength(50);
		uuid.setGroup("cabecero");
		uuid.setPersistible(true);
		uuid.setValue("");
		uuid.setValidation("");
		uuid.setFormat("UUID");

		campos.add(status);
		campos.add(total);
		campos.add(impret);
		campos.add(imptras);
		campos.add(descuento);
		campos.add(subtotal);
		campos.add(tipo);
		campos.add(obs);
		campos.add(fechaPago);
		campos.add(cantidad);
		campos.add(formapago);
		campos.add(metodopago);
		campos.add(estado);
		campos.add(ciudad);
		campos.add(poblacion);
		campos.add(municipio);
		campos.add(goles);
		campos.add(puntuacion);
		campos.add(aMaterno);
		//campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(aPaterno);
		campos.add(fNacim);
		campos.add(posicion);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		campos.add(serie);
		campos.add(uuid);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("Guardar");
		forma.setName("remision");
		forma.setView("remision");
		forma.setTitle("Nota de Remision");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("documentos");
		forma.setBasket("remision");
		forma.setCreateable(true);
		forma.setTable("doctos");
		forma.setValidate(true);

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
	
	@Test
	public void testGuardarFormaCancelacion() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("cancelacion.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field campoCodigo = new Field();
		//Campo campoCampo = new Campo();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();
		Field posicion = new Field();
		Field goles = new Field();
		Field puntuacion = new Field();
		Field imagen = new Field();
		Field categoria = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Resource forma = new Resource();
		Field municipio = new Field();
		Field poblacion = new Field();
		Field ciudad = new Field();
		Field estado = new Field();
		Field metodopago = new Field();
		Field formapago = new Field();
		Field cantidad = new Field();
		Field fechaPago = new Field();
		Field obs = new Field();
		Field tipo = new Field();
		Field subtotal = new Field();
		Field descuento = new Field();
		Field imptras = new Field();
		Field impret = new Field();
		Field total = new Field();
		Field status = new Field();
		Field serie = new Field();

		Button carrito = new Button();
		carrito.setCommandName("nuevo");
		carrito.setName("nuevo");
		carrito.setLabel("Productos/Servicios");
		carrito.setComponentType("location");
		carrito.setCss("btn btn-info");
		carrito.setResourceName("producto");
		carrito.setModule("inventario");
		carrito.setOrder(3);
		carrito.setResourceType("basket");
		carrito.setVersion("1.0");
		carrito.setEvents("nuevo");


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-info");
		guardar.setResourceName("ingreso");
		guardar.setModule("comprobantes");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("3.3");
		guardar.setEvents("nuevo");

		Button cancelar = new Button();
		cancelar.setCommandName("cancelar");
		cancelar.setName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("botonjs");
		cancelar.setCss("btn btn-info");
		cancelar.setResourceName("usuario");
		cancelar.setModule("directorio");
		cancelar.setOrder(1);
		cancelar.setResourceType("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvents("detalle");

		Button eliminar = new Button();
		eliminar.setCommandName("actualizar");
		eliminar.setName("actualizar");
		eliminar.setLabel("Actualizar");
		eliminar.setComponentType("botonjs");
		eliminar.setCss("btn btn-info");
		eliminar.setResourceName("ingreso");
		eliminar.setModule("comprobantes");
		eliminar.setOrder(5);
		eliminar.setResourceType("forma");
		eliminar.setVersion("3.3");
		eliminar.setEvents("detalle");

		Button timbrar = new Button();
		timbrar.setCommandName("timbrar");
		timbrar.setName("timbrar");
		timbrar.setLabel("Timbrar");
		timbrar.setComponentType("botonjs");
		timbrar.setCss("btn btn-info");
		timbrar.setResourceName("ingreso");
		timbrar.setModule("comprobantes");
		timbrar.setOrder(6);
		timbrar.setResourceType("forma");
		timbrar.setVersion("3.3");
		timbrar.setEvents("detalle");

		acciones.add(guardar);
		acciones.add(carrito);
		acciones.add(cancelar);
		acciones.add(eliminar);
		acciones.add(timbrar);

		tipo.setName("Tipo de documento");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(false);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("ingreso");
		tipo.setFormat("");


		campoCodigo.setName("Folio interno");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		//campoCodigo.setAutogenerado(true);
		campoCodigo.setFormat("{RFC-TIPO-CONS}");
		//campoCodigo.setAutogenerado(false);

		/*
		 * campoCampo.setNombre("Automatico"); campoCampo.setBd("AUTO");
		 * campoCampo.setCss("form-control"); campoCampo.setOrden(2);
		 * campoCampo.setType("checkbox"); campoCampo.setLectura(false);
		 * campoCampo.setOculto(false); campoCampo.setRequerido(true);
		 * campoCampo.setLista(true); campoCampo.setId(false);
		 * campoCampo.setGrupo("cabecero"); campoCampo.setPersistible(false);
		 */

		aMaterno.setName("Codigo emisor");
		aMaterno.setFieldName("emisorcodigo");
		aMaterno.setCss("form-control");
		aMaterno.setOrder(3);
		aMaterno.setComponentType("texto");
		aMaterno.setReadOnly(false);
		aMaterno.setHidden(false);
		aMaterno.setRequired(false);
		aMaterno.setShowInBasket(false);
		aMaterno.setId(false);
		aMaterno.setLength(20);
		aMaterno.setGroup("emisor");
		aMaterno.setPersistible(false);
		aMaterno.setFormat("Codigo emisor");

		aPaterno.setName("RFC emisor");
		aPaterno.setFieldName("emisor");
		aPaterno.setCss("form-control");
		aPaterno.setOrder(4);
		aPaterno.setComponentType("texto");
		aPaterno.setReadOnly(false);
		aPaterno.setHidden(false);
		aPaterno.setRequired(true);
		aPaterno.setShowInBasket(false);
		aPaterno.setId(false);
		aPaterno.setLength(20);
		aPaterno.setGroup("emisor");
		aPaterno.setPersistible(true);
		aPaterno.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		aPaterno.setFormat("RFC emisor");

		fNacim.setName("Codigo receptor");
		fNacim.setFieldName("receptorcodigo");
		fNacim.setCss("form-control");
		fNacim.setOrder(5);
		fNacim.setComponentType("texto");
		fNacim.setReadOnly(false);
		fNacim.setHidden(false);
		fNacim.setRequired(false);
		fNacim.setShowInBasket(false);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setGroup("receptor");
		fNacim.setPersistible(false);
		fNacim.setFormat("Codigo receptor");

		posicion.setName("RFC receptor");
		posicion.setFieldName("receptor");
		posicion.setCss("form-control");
		posicion.setOrder(6);
		posicion.setComponentType("texto");
		posicion.setReadOnly(false);
		posicion.setHidden(false);
		posicion.setRequired(true);
		posicion.setShowInBasket(false);
		posicion.setId(false);
		posicion.setLength(20);
		posicion.setGroup("receptor");
		posicion.setPersistible(true);
		posicion.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		posicion.setFormat("RFC receptor");

		puntuacion.setName("Uso CFDi");
		puntuacion.setFieldName("uso");
		puntuacion.setCss("form-control");
		puntuacion.setOrder(7);
		puntuacion.setComponentType("uso");
		puntuacion.setReadOnly(false);
		puntuacion.setHidden(false);
		puntuacion.setRequired(true);
		puntuacion.setShowInBasket(false);
		puntuacion.setId(false);
		puntuacion.setLength(5);
		puntuacion.setGroup("receptor");
		puntuacion.setPersistible(true);
		puntuacion.setValidation("");
		puntuacion.setFormat("Uso CFDi");
		puntuacion.setValue("");

		goles.setName("Direccion de facturación");
		goles.setFieldName("dirfactura");
		goles.setCss("form-control");
		goles.setOrder(8);
		goles.setComponentType("selectorDireccion");
		goles.setReadOnly(false);
		goles.setHidden(false);
		goles.setRequired(false);
		goles.setShowInBasket(false);
		goles.setId(false);
		goles.setLength(20);
		goles.setGroup("direccionFiscal");
		goles.setPersistible(false);
		goles.setFormat("Direccion de facturación");

		categoria.setName("Calle");
		categoria.setFieldName("calle");
		categoria.setCss("form-control");
		categoria.setOrder(10);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(20);
		categoria.setGroup("direccionFiscal");
		categoria.setPersistible(true);
		categoria.setFormat("Calle");

		usuario.setName("No Int");
		usuario.setFieldName("noint");
		usuario.setCss("form-control");
		usuario.setOrder(11);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(10);
		usuario.setGroup("direccionFiscal");
		usuario.setPersistible(true);
		usuario.setFormat("No Int");

		fecha.setName("No Ext");
		fecha.setFieldName("noext");
		fecha.setCss("form-control");
		fecha.setOrder(12);
		fecha.setComponentType("texto");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(10);
		fecha.setGroup("direccionFiscal");
		fecha.setPersistible(true);	
		fecha.setFormat("No Ext");

		municipio.setName("Municipio");
		municipio.setFieldName("municipio");
		municipio.setCss("form-control");
		municipio.setOrder(13);
		municipio.setComponentType("texto");
		municipio.setReadOnly(false);
		municipio.setHidden(false);
		municipio.setRequired(false);
		municipio.setShowInBasket(false);
		municipio.setId(false);
		municipio.setLength(20);
		municipio.setGroup("direccionFiscal");
		municipio.setPersistible(true);	
		municipio.setFormat("Municipio");

		poblacion.setName("Población");
		poblacion.setFieldName("poblacion");
		poblacion.setCss("form-control");
		poblacion.setOrder(14);
		poblacion.setComponentType("texto");
		poblacion.setReadOnly(false);
		poblacion.setHidden(false);
		poblacion.setRequired(false);
		poblacion.setShowInBasket(false);
		poblacion.setId(false);
		poblacion.setLength(20);
		poblacion.setGroup("direccionFiscal");
		poblacion.setPersistible(true);	
		poblacion.setFormat("Población");

		ciudad.setName("Ciudad");
		ciudad.setFieldName("ciudad");
		ciudad.setCss("form-control");
		ciudad.setOrder(15);
		ciudad.setComponentType("texto");
		ciudad.setReadOnly(false);
		ciudad.setHidden(false);
		ciudad.setRequired(false);
		ciudad.setShowInBasket(false);
		ciudad.setId(false);
		ciudad.setLength(20);
		ciudad.setGroup("direccionFiscal");
		ciudad.setPersistible(true);	
		ciudad.setFormat("Ciudad");

		imagen.setName("C. P.");
		imagen.setFieldName("cp");
		imagen.setCss("form-control");
		imagen.setOrder(16);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(10);
		imagen.setGroup("direccionFiscal");
		imagen.setPersistible(true);
		imagen.setFormat("C. P.");


		estado.setName("Estado");
		estado.setFieldName("estado");
		estado.setCss("form-control");
		estado.setOrder(17);
		estado.setComponentType("selectorEstado");
		estado.setReadOnly(false);
		estado.setHidden(false);
		estado.setRequired(false);
		estado.setShowInBasket(false);
		estado.setId(false);
		estado.setGroup("direccionFiscal");
		estado.setPersistible(true);
		estado.setLength(255);
		estado.setFormat("Estado");

		metodopago.setName("Metodo de pago");
		metodopago.setFieldName("metodopago");
		metodopago.setCss("form-control");
		metodopago.setOrder(18);
		metodopago.setComponentType("metodopago");
		metodopago.setReadOnly(false);
		metodopago.setHidden(false);
		metodopago.setRequired(false);
		metodopago.setShowInBasket(false);
		metodopago.setId(false);
		metodopago.setGroup("direccionFiscal");
		metodopago.setPersistible(true);
		metodopago.setLength(10);
		metodopago.setFormat("Metodo de pago");
		metodopago.setValue("");

		formapago.setName("Forma de pago");
		formapago.setFieldName("formapago");
		formapago.setCss("form-control");
		formapago.setOrder(19);
		formapago.setComponentType("formapago");
		formapago.setReadOnly(false);
		formapago.setHidden(false);
		formapago.setRequired(true);
		formapago.setShowInBasket(false);
		formapago.setId(false);
		formapago.setLength(6);
		formapago.setGroup("pago");
		formapago.setPersistible(false);
		formapago.setFormat("Forma de pago");
		formapago.setValue("");

		cantidad.setName("Monto");
		cantidad.setFieldName("monto");
		cantidad.setCss("form-control");
		cantidad.setOrder(20);
		cantidad.setComponentType("texto");
		cantidad.setReadOnly(false);
		cantidad.setHidden(false);
		cantidad.setRequired(true);
		cantidad.setShowInBasket(false);
		cantidad.setId(false);
		cantidad.setLength(20);
		cantidad.setGroup("pago");
		cantidad.setPersistible(false);
		cantidad.setFormat("00.00");

		fechaPago.setName("Fecha");
		fechaPago.setFieldName("fecha");
		fechaPago.setCss("form-control");
		fechaPago.setOrder(21);
		fechaPago.setComponentType("fecha");
		fechaPago.setReadOnly(false);
		fechaPago.setHidden(false);
		fechaPago.setRequired(true);
		fechaPago.setShowInBasket(false);
		fechaPago.setId(false);
		fechaPago.setLength(10);
		fechaPago.setGroup("pago");
		fechaPago.setPersistible(true);
		fechaPago.setFormat("yyyy-MM-dd");

		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(21);
		obs.setComponentType("texto");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(true);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(20);
		obs.setGroup("pago");
		obs.setPersistible(false);
		obs.setFormat("Observaciones");

		subtotal.setName("Subtotal");
		subtotal.setFieldName("subtotal");
		subtotal.setCss("form-control");
		subtotal.setOrder(22);
		subtotal.setComponentType("moneda");
		subtotal.setReadOnly(true);
		subtotal.setHidden(false);
		subtotal.setRequired(true);
		subtotal.setShowInBasket(true);
		subtotal.setId(false);
		subtotal.setLength(20);
		subtotal.setGroup("totales");
		subtotal.setPersistible(false);
		subtotal.setValue("00.00");
		subtotal.setFormat("00.00");

		descuento.setName("Descuento");
		descuento.setFieldName("descuento");
		descuento.setCss("form-control");
		descuento.setOrder(23);
		descuento.setComponentType("moneda");
		descuento.setReadOnly(true);
		descuento.setHidden(false);
		descuento.setRequired(true);
		descuento.setShowInBasket(true);
		descuento.setId(false);
		descuento.setLength(20);
		descuento.setGroup("totales");
		descuento.setPersistible(false);
		descuento.setValue("00.00");
		descuento.setFormat("00.00");


		impret.setName("Impuesto retenido");
		impret.setFieldName("impret");
		impret.setCss("form-control");
		impret.setOrder(24);
		impret.setComponentType("moneda");
		impret.setReadOnly(true);
		impret.setHidden(false);
		impret.setRequired(true);
		impret.setShowInBasket(true);
		impret.setId(false);
		impret.setLength(20);
		impret.setGroup("totales");
		impret.setPersistible(false);
		impret.setValue("00.00");
		impret.setFormat("00.00");

		imptras.setName("Impuesto trasladado");
		imptras.setFieldName("imptras");
		imptras.setCss("form-control");
		imptras.setOrder(25);
		imptras.setComponentType("moneda");
		imptras.setReadOnly(true);
		imptras.setHidden(false);
		imptras.setRequired(true);
		imptras.setShowInBasket(true);
		imptras.setId(false);
		imptras.setLength(20);
		imptras.setGroup("totales");
		imptras.setPersistible(false);
		imptras.setValue("00.00");
		imptras.setFormat("00.00");

		total.setName("Total");
		total.setFieldName("total");
		total.setCss("form-control");
		total.setOrder(26);
		total.setComponentType("moneda");
		total.setReadOnly(true);
		total.setHidden(false);
		total.setRequired(true);
		total.setShowInBasket(true);
		total.setId(false);
		total.setLength(20);
		total.setGroup("totales");
		total.setPersistible(false);
		total.setValue("00.00");
		total.setValidation("[a-zA-Z0-9,.;:_'\\s-]+$");
		total.setFormat("00.00");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(27);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("Nueva");
		status.setValidation("");
		status.setFormat("Status");

		serie.setName("Serie");
		serie.setFieldName("serie");
		serie.setCss("form-control");
		serie.setOrder(28);
		serie.setComponentType("texto");
		serie.setReadOnly(true);
		serie.setHidden(true);
		serie.setRequired(true);
		serie.setShowInBasket(true);
		serie.setId(false);
		serie.setLength(20);
		serie.setGroup("cabecero");
		serie.setPersistible(false);
		serie.setValue("I");
		serie.setValidation("");
		serie.setFormat("Status");

		campos.add(status);
		campos.add(total);
		campos.add(impret);
		campos.add(imptras);
		campos.add(descuento);
		campos.add(subtotal);
		campos.add(tipo);
		campos.add(obs);
		campos.add(fechaPago);
		campos.add(cantidad);
		campos.add(formapago);
		campos.add(metodopago);
		campos.add(estado);
		campos.add(ciudad);
		campos.add(poblacion);
		campos.add(municipio);
		campos.add(goles);
		campos.add(puntuacion);
		campos.add(aMaterno);
		//campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(aPaterno);
		campos.add(fNacim);
		campos.add(posicion);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		campos.add(serie);
		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("Guardar");
		forma.setName("cancelacion");
		forma.setView("cancelacion");
		forma.setTitle("Cancelacion");
		forma.setVersion("3.3");
		forma.setStatus("produccion");
		forma.setModule("comprobantes");
		forma.setBasket("cancelacion");
		forma.setCreateable(false);
		forma.setTable("doctos");
		forma.setValidate(true);

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

	@Test
	public void testGuardarFormaOCompra() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("ocompra.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field campoCodigo = new Field();
		//Campo campoCampo = new Campo();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();
		Field posicion = new Field();
		Field goles = new Field();
		Field puntuacion = new Field();
		Field imagen = new Field();
		Field categoria = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Resource forma = new Resource();
		Field municipio = new Field();
		Field poblacion = new Field();
		Field ciudad = new Field();
		Field estado = new Field();
		Field metodopago = new Field();
		Field formapago = new Field();
		Field cantidad = new Field();
		Field fechaPago = new Field();
		Field obs = new Field();
		Field tipo = new Field();
		Field subtotal = new Field();
		Field descuento = new Field();
		Field imptras = new Field();
		Field impret = new Field();
		Field total = new Field();
		Field status = new Field();

		Button carrito = new Button();
		carrito.setCommandName("nuevo");
		carrito.setName("nuevo");
		carrito.setLabel("Productos/Servicios");
		carrito.setComponentType("location");
		carrito.setCss("btn btn-info");
		carrito.setResourceName("prodserv");
		carrito.setModule("inventario");
		carrito.setOrder(3);
		carrito.setResourceType("basket");
		carrito.setVersion("1.0");
		carrito.setEvents("nuevo");

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-info");
		guardar.setResourceName("ocompra");
		guardar.setModule("solicitud");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button eliminar = new Button();
		eliminar.setCommandName("actualizar");
		eliminar.setName("actualizar");
		eliminar.setLabel("Actualizar");
		eliminar.setComponentType("botonjs");
		eliminar.setCss("btn btn-info");
		eliminar.setResourceName("ocompra");
		eliminar.setModule("solicitud");
		eliminar.setOrder(5);
		eliminar.setResourceType("forma");
		eliminar.setVersion("1.0");
		eliminar.setEvents("detalle");

		acciones.add(guardar);
		acciones.add(carrito);
		acciones.add(eliminar);

		tipo.setName("Tipo de documento");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("ocompra");
		tipo.setFormat("");


		campoCodigo.setName("Folio interno");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		//campoCodigo.setAutogenerado(true);
		campoCodigo.setFormat("{TIPO-CONS}");
		//campoCodigo.setAutogenerado(false);
		

		/*
		 * campoCampo.setNombre("Automatico"); campoCampo.setBd("AUTO");
		 * campoCampo.setCss("form-control"); campoCampo.setOrden(2);
		 * campoCampo.setType("checkbox"); campoCampo.setLectura(false);
		 * campoCampo.setOculto(false); campoCampo.setRequerido(true);
		 * campoCampo.setLista(true); campoCampo.setId(false);
		 * campoCampo.setGrupo("cabecero"); campoCampo.setPersistible(false);
		 */

		aMaterno.setName("Codigo emisor");
		aMaterno.setFieldName("emisorcodigo");
		aMaterno.setCss("form-control");
		aMaterno.setOrder(3);
		aMaterno.setComponentType("texto");
		aMaterno.setReadOnly(false);
		aMaterno.setHidden(false);
		aMaterno.setRequired(false);
		aMaterno.setShowInBasket(false);
		aMaterno.setId(false);
		aMaterno.setLength(20);
		aMaterno.setGroup("emisor");
		aMaterno.setPersistible(false);
		aMaterno.setFormat("Codigo emisor");

		aPaterno.setName("RFC emisor");
		aPaterno.setFieldName("emisor");
		aPaterno.setCss("form-control");
		aPaterno.setOrder(4);
		aPaterno.setComponentType("texto");
		aPaterno.setReadOnly(false);
		aPaterno.setHidden(false);
		aPaterno.setRequired(true);
		aPaterno.setShowInBasket(false);
		aPaterno.setId(false);
		aPaterno.setLength(20);
		aPaterno.setGroup("emisor");
		aPaterno.setPersistible(true);
		aPaterno.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		aPaterno.setFormat("RFC emisor");

		fNacim.setName("Codigo receptor");
		fNacim.setFieldName("receptorcodigo");
		fNacim.setCss("form-control");
		fNacim.setOrder(5);
		fNacim.setComponentType("texto");
		fNacim.setReadOnly(false);
		fNacim.setHidden(false);
		fNacim.setRequired(false);
		fNacim.setShowInBasket(false);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setGroup("receptor");
		fNacim.setPersistible(false);
		fNacim.setFormat("Codigo receptor");

		posicion.setName("RFC receptor");
		posicion.setFieldName("receptor");
		posicion.setCss("form-control");
		posicion.setOrder(6);
		posicion.setComponentType("texto");
		posicion.setReadOnly(false);
		posicion.setHidden(false);
		posicion.setRequired(true);
		posicion.setShowInBasket(false);
		posicion.setId(false);
		posicion.setLength(20);
		posicion.setGroup("receptor");
		posicion.setPersistible(true);
		posicion.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		posicion.setFormat("RFC receptor");

		puntuacion.setName("Uso CFDi");
		puntuacion.setFieldName("uso");
		puntuacion.setCss("form-control");
		puntuacion.setOrder(7);
		puntuacion.setComponentType("uso");
		puntuacion.setReadOnly(false);
		puntuacion.setHidden(false);
		puntuacion.setRequired(true);
		puntuacion.setShowInBasket(false);
		puntuacion.setId(false);
		puntuacion.setLength(5);
		puntuacion.setGroup("receptor");
		puntuacion.setPersistible(true);
		puntuacion.setFormat("Uso CFDi");

		goles.setName("Direccion de facturación");
		goles.setFieldName("dirfactura");
		goles.setCss("form-control");
		goles.setOrder(8);
		goles.setComponentType("selectorDireccion");
		goles.setReadOnly(false);
		goles.setHidden(false);
		goles.setRequired(false);
		goles.setShowInBasket(false);
		goles.setId(false);
		goles.setLength(20);
		goles.setGroup("direccionFiscal");
		goles.setPersistible(false);
		goles.setFormat("Direccion de facturación");

		categoria.setName("Calle");
		categoria.setFieldName("calle");
		categoria.setCss("form-control");
		categoria.setOrder(10);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(20);
		categoria.setGroup("direccionFiscal");
		categoria.setPersistible(true);
		categoria.setFormat("Calle");

		usuario.setName("No Int");
		usuario.setFieldName("noint");
		usuario.setCss("form-control");
		usuario.setOrder(11);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(10);
		usuario.setGroup("direccionFiscal");
		usuario.setPersistible(true);
		usuario.setFormat("No Int");

		fecha.setName("No Ext");
		fecha.setFieldName("noext");
		fecha.setCss("form-control");
		fecha.setOrder(12);
		fecha.setComponentType("texto");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(10);
		fecha.setGroup("direccionFiscal");
		fecha.setPersistible(true);	
		fecha.setFormat("No Ext");

		municipio.setName("Municipio");
		municipio.setFieldName("municipio");
		municipio.setCss("form-control");
		municipio.setOrder(13);
		municipio.setComponentType("texto");
		municipio.setReadOnly(false);
		municipio.setHidden(false);
		municipio.setRequired(false);
		municipio.setShowInBasket(false);
		municipio.setId(false);
		municipio.setLength(20);
		municipio.setGroup("direccionFiscal");
		municipio.setPersistible(true);	
		municipio.setFormat("Municipio");

		poblacion.setName("Población");
		poblacion.setFieldName("poblacion");
		poblacion.setCss("form-control");
		poblacion.setOrder(14);
		poblacion.setComponentType("texto");
		poblacion.setReadOnly(false);
		poblacion.setHidden(false);
		poblacion.setRequired(false);
		poblacion.setShowInBasket(false);
		poblacion.setId(false);
		poblacion.setLength(20);
		poblacion.setGroup("direccionFiscal");
		poblacion.setPersistible(true);	
		poblacion.setFormat("Población");

		ciudad.setName("Ciudad");
		ciudad.setFieldName("ciudad");
		ciudad.setCss("form-control");
		ciudad.setOrder(15);
		ciudad.setComponentType("texto");
		ciudad.setReadOnly(false);
		ciudad.setHidden(false);
		ciudad.setRequired(false);
		ciudad.setShowInBasket(false);
		ciudad.setId(false);
		ciudad.setLength(20);
		ciudad.setGroup("direccionFiscal");
		ciudad.setPersistible(true);	
		ciudad.setFormat("Ciudad");

		imagen.setName("C. P.");
		imagen.setFieldName("cp");
		imagen.setCss("form-control");
		imagen.setOrder(16);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(10);
		imagen.setGroup("direccionFiscal");
		imagen.setPersistible(true);
		imagen.setFormat("C. P.");


		estado.setName("Estado");
		estado.setFieldName("estado");
		estado.setCss("form-control");
		estado.setOrder(17);
		estado.setComponentType("selectorEstado");
		estado.setReadOnly(false);
		estado.setHidden(false);
		estado.setRequired(false);
		estado.setShowInBasket(false);
		estado.setId(false);
		estado.setGroup("direccionFiscal");
		estado.setPersistible(true);
		estado.setLength(255);
		estado.setFormat("Estado");

		metodopago.setName("Metodo de pago");
		metodopago.setFieldName("metodopago");
		metodopago.setCss("form-control");
		metodopago.setOrder(18);
		metodopago.setComponentType("metodopago");
		metodopago.setReadOnly(false);
		metodopago.setHidden(false);
		metodopago.setRequired(false);
		metodopago.setShowInBasket(false);
		metodopago.setId(false);
		metodopago.setGroup("direccionFiscal");
		metodopago.setPersistible(true);
		metodopago.setLength(10);
		metodopago.setFormat("Metodo de pago");
		metodopago.setValue("");

		formapago.setName("Forma de pago");
		formapago.setFieldName("formapago");
		formapago.setCss("form-control");
		formapago.setOrder(19);
		formapago.setComponentType("formapago");
		formapago.setReadOnly(false);
		formapago.setHidden(false);
		formapago.setRequired(true);
		formapago.setShowInBasket(false);
		formapago.setId(false);
		formapago.setLength(6);
		formapago.setGroup("pago");
		formapago.setPersistible(false);
		formapago.setFormat("Forma de pago");
		formapago.setValue("");

		cantidad.setName("Monto");
		cantidad.setFieldName("monto");
		cantidad.setCss("form-control");
		cantidad.setOrder(20);
		cantidad.setComponentType("texto");
		cantidad.setReadOnly(false);
		cantidad.setHidden(false);
		cantidad.setRequired(true);
		cantidad.setShowInBasket(false);
		cantidad.setId(false);
		cantidad.setLength(20);
		cantidad.setGroup("pago");
		cantidad.setPersistible(false);
		cantidad.setFormat("00.00");

		fechaPago.setName("Fecha");
		fechaPago.setFieldName("fecha");
		fechaPago.setCss("form-control");
		fechaPago.setOrder(21);
		fechaPago.setComponentType("fecha");
		fechaPago.setReadOnly(true);
		fechaPago.setHidden(false);
		fechaPago.setRequired(true);
		fechaPago.setShowInBasket(false);
		fechaPago.setId(false);
		fechaPago.setLength(10);
		fechaPago.setGroup("pago");
		fechaPago.setPersistible(true);
		fechaPago.setFormat("yyyy-MM-dd");
		fechaPago.setValue("${hoyCorto}");

		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(21);
		obs.setComponentType("texto");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(true);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(20);
		obs.setGroup("pago");
		obs.setPersistible(false);
		obs.setFormat("Observaciones");

		subtotal.setName("Subtotal");
		subtotal.setFieldName("subtotal");
		subtotal.setCss("form-control");
		subtotal.setOrder(22);
		subtotal.setComponentType("moneda");
		subtotal.setReadOnly(true);
		subtotal.setHidden(false);
		subtotal.setRequired(true);
		subtotal.setShowInBasket(true);
		subtotal.setId(false);
		subtotal.setLength(20);
		subtotal.setGroup("totales");
		subtotal.setPersistible(false);
		subtotal.setValue("00.00");
		subtotal.setFormat("00.00");

		descuento.setName("Descuento");
		descuento.setFieldName("descuento");
		descuento.setCss("form-control");
		descuento.setOrder(23);
		descuento.setComponentType("moneda");
		descuento.setReadOnly(true);
		descuento.setHidden(false);
		descuento.setRequired(true);
		descuento.setShowInBasket(true);
		descuento.setId(false);
		descuento.setLength(20);
		descuento.setGroup("totales");
		descuento.setPersistible(false);
		descuento.setValue("00.00");
		descuento.setFormat("00.00");


		impret.setName("Impuesto retenido");
		impret.setFieldName("impret");
		impret.setCss("form-control");
		impret.setOrder(24);
		impret.setComponentType("moneda");
		impret.setReadOnly(true);
		impret.setHidden(false);
		impret.setRequired(true);
		impret.setShowInBasket(true);
		impret.setId(false);
		impret.setLength(20);
		impret.setGroup("totales");
		impret.setPersistible(false);
		impret.setValue("00.00");
		impret.setFormat("00.00");

		imptras.setName("Impuesto trasladado");
		imptras.setFieldName("imptras");
		imptras.setCss("form-control");
		imptras.setOrder(25);
		imptras.setComponentType("moneda");
		imptras.setReadOnly(true);
		imptras.setHidden(false);
		imptras.setRequired(true);
		imptras.setShowInBasket(true);
		imptras.setId(false);
		imptras.setLength(20);
		imptras.setGroup("totales");
		imptras.setPersistible(false);
		imptras.setValue("00.00");
		imptras.setFormat("00.00");

		total.setName("Total");
		total.setFieldName("total");
		total.setCss("form-control");
		total.setOrder(26);
		total.setComponentType("moneda");
		total.setReadOnly(true);
		total.setHidden(false);
		total.setRequired(true);
		total.setShowInBasket(true);
		total.setId(false);
		total.setLength(20);
		total.setGroup("totales");
		total.setPersistible(false);
		total.setValue("00.00");
		total.setValidation("(\\+|-)?([0-9]+(\\.[0-9]+))");
		total.setFormat("00.00");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(27);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("Nueva");
		status.setFormat("Status");

		campos.add(status);
		campos.add(total);
		campos.add(impret);
		campos.add(imptras);
		campos.add(descuento);
		campos.add(subtotal);
		campos.add(tipo);
		campos.add(obs);
		campos.add(fechaPago);
		campos.add(cantidad);
		campos.add(formapago);
		campos.add(metodopago);
		campos.add(estado);
		campos.add(ciudad);
		campos.add(poblacion);
		campos.add(municipio);
		campos.add(goles);
		campos.add(puntuacion);
		campos.add(aMaterno);
		//campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(aPaterno);
		campos.add(fNacim);
		campos.add(posicion);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("Guardar");
		forma.setName("ocompra");
		forma.setView("ocompra");
		forma.setTitle("O. de Compra");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("solicitud");
		forma.setBasket("ocompra");
		forma.setCreateable(true);
		forma.setTable("doctos");
		forma.setValidate(true);

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

	@Test
	public void testGuardarFormaPedido() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("pedido.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field campoCodigo = new Field();
		//Campo campoCampo = new Campo();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();
		Field posicion = new Field();
		Field goles = new Field();
		Field puntuacion = new Field();
		Field imagen = new Field();
		Field categoria = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Resource forma = new Resource();
		Field municipio = new Field();
		Field poblacion = new Field();
		Field ciudad = new Field();
		Field estado = new Field();
		Field metodopago = new Field();
		Field formapago = new Field();
		Field cantidad = new Field();
		Field fechaPago = new Field();
		Field obs = new Field();
		Field tipo = new Field();
		Field subtotal = new Field();
		Field descuento = new Field();
		Field imptras = new Field();
		Field impret = new Field();
		Field total = new Field();
		Field status = new Field();

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("pedido");
		guardar.setModule("solicitud");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button carrito = new Button();
		carrito.setCommandName("nuevo");
		carrito.setName("nuevo");
		carrito.setLabel("Productos/Servicios");
		carrito.setComponentType("location");
		carrito.setCss("btn btn-success");
		carrito.setResourceName("prodserv");
		carrito.setModule("inventario");
		carrito.setOrder(3);
		carrito.setResourceType("basket");
		carrito.setVersion("1.0");
		carrito.setEvents("nuevo");

		acciones.add(guardar);
		acciones.add(carrito);

		tipo.setName("Tipo de documento");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("pedido");
		tipo.setFormat("{TIPO-CONS}");

		campoCodigo.setName("Folio interno");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		//campoCodigo.setAutogenerado(false);
		campoCodigo.setFormat("{RFC-TIPO-CONS}");

		/*
		 * campoCampo.setNombre("Automatico"); campoCampo.setBd("AUTO");
		 * campoCampo.setCss("form-control"); campoCampo.setOrden(2);
		 * campoCampo.setType("checkbox"); campoCampo.setLectura(false);
		 * campoCampo.setOculto(false); campoCampo.setRequerido(true);
		 * campoCampo.setLista(true); campoCampo.setId(false);
		 * campoCampo.setGrupo("cabecero"); campoCampo.setPersistible(false);
		 */

		aMaterno.setName("Codigo emisor");
		aMaterno.setFieldName("emisorcodigo");
		aMaterno.setCss("form-control");
		aMaterno.setOrder(3);
		aMaterno.setComponentType("texto");
		aMaterno.setReadOnly(false);
		aMaterno.setHidden(false);
		aMaterno.setRequired(false);
		aMaterno.setShowInBasket(false);
		aMaterno.setId(false);
		aMaterno.setLength(20);
		aMaterno.setGroup("emisor");
		aMaterno.setPersistible(false);
		aMaterno.setFormat("Codigo emisor");

		aPaterno.setName("RFC emisor");
		aPaterno.setFieldName("emisor");
		aPaterno.setCss("form-control");
		aPaterno.setOrder(4);
		aPaterno.setComponentType("texto");
		aPaterno.setReadOnly(false);
		aPaterno.setHidden(false);
		aPaterno.setRequired(true);
		aPaterno.setShowInBasket(false);
		aPaterno.setId(false);
		aPaterno.setLength(20);
		aPaterno.setGroup("emisor");
		aPaterno.setPersistible(true);
		aPaterno.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		aPaterno.setFormat("RFC emisor");

		fNacim.setName("Codigo receptor");
		fNacim.setFieldName("receptorcodigo");
		fNacim.setCss("form-control");
		fNacim.setOrder(5);
		fNacim.setComponentType("texto");
		fNacim.setReadOnly(false);
		fNacim.setHidden(false);
		fNacim.setRequired(false);
		fNacim.setShowInBasket(false);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setGroup("receptor");
		fNacim.setPersistible(false);
		fNacim.setFormat("Codigo receptor");

		posicion.setName("RFC receptor");
		posicion.setFieldName("receptor");
		posicion.setCss("form-control");
		posicion.setOrder(6);
		posicion.setComponentType("texto");
		posicion.setReadOnly(false);
		posicion.setHidden(false);
		posicion.setRequired(true);
		posicion.setShowInBasket(false);
		posicion.setId(false);
		posicion.setLength(20);
		posicion.setGroup("receptor");
		posicion.setPersistible(true);
		posicion.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		posicion.setFormat("RFC receptor");

		puntuacion.setName("Uso CFDi");
		puntuacion.setFieldName("uso");
		puntuacion.setCss("form-control");
		puntuacion.setOrder(7);
		puntuacion.setComponentType("uso");
		puntuacion.setReadOnly(false);
		puntuacion.setHidden(false);
		puntuacion.setRequired(true);
		puntuacion.setShowInBasket(false);
		puntuacion.setId(false);
		puntuacion.setLength(5);
		puntuacion.setGroup("receptor");
		puntuacion.setPersistible(true);
		puntuacion.setValidation("");
		puntuacion.setFormat("Uso CFDi");
		puntuacion.setValue("");

		goles.setName("Direccion de facturación");
		goles.setFieldName("dirfactura");
		goles.setCss("form-control");
		goles.setOrder(8);
		goles.setComponentType("selectorDireccion");
		goles.setReadOnly(false);
		goles.setHidden(false);
		goles.setRequired(false);
		goles.setShowInBasket(false);
		goles.setId(false);
		goles.setLength(20);
		goles.setGroup("direccionFiscal");
		goles.setPersistible(false);
		goles.setFormat("Direccion de facturación");

		categoria.setName("Calle");
		categoria.setFieldName("calle");
		categoria.setCss("form-control");
		categoria.setOrder(10);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(20);
		categoria.setGroup("direccionFiscal");
		categoria.setPersistible(true);
		categoria.setFormat("Calle");

		usuario.setName("No Int");
		usuario.setFieldName("noint");
		usuario.setCss("form-control");
		usuario.setOrder(11);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(10);
		usuario.setGroup("direccionFiscal");
		usuario.setPersistible(true);
		usuario.setFormat("No Int");

		fecha.setName("No Ext");
		fecha.setFieldName("noext");
		fecha.setCss("form-control");
		fecha.setOrder(12);
		fecha.setComponentType("texto");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(10);
		fecha.setGroup("direccionFiscal");
		fecha.setPersistible(true);	
		fecha.setFormat("No Ext");

		municipio.setName("Municipio");
		municipio.setFieldName("municipio");
		municipio.setCss("form-control");
		municipio.setOrder(13);
		municipio.setComponentType("texto");
		municipio.setReadOnly(false);
		municipio.setHidden(false);
		municipio.setRequired(false);
		municipio.setShowInBasket(false);
		municipio.setId(false);
		municipio.setLength(20);
		municipio.setGroup("direccionFiscal");
		municipio.setPersistible(true);	
		municipio.setFormat("Municipio");

		poblacion.setName("Población");
		poblacion.setFieldName("poblacion");
		poblacion.setCss("form-control");
		poblacion.setOrder(14);
		poblacion.setComponentType("texto");
		poblacion.setReadOnly(false);
		poblacion.setHidden(false);
		poblacion.setRequired(false);
		poblacion.setShowInBasket(false);
		poblacion.setId(false);
		poblacion.setLength(20);
		poblacion.setGroup("direccionFiscal");
		poblacion.setPersistible(true);	
		poblacion.setFormat("Población");

		ciudad.setName("Ciudad");
		ciudad.setFieldName("ciudad");
		ciudad.setCss("form-control");
		ciudad.setOrder(15);
		ciudad.setComponentType("texto");
		ciudad.setReadOnly(false);
		ciudad.setHidden(false);
		ciudad.setRequired(false);
		ciudad.setShowInBasket(false);
		ciudad.setId(false);
		ciudad.setLength(20);
		ciudad.setGroup("direccionFiscal");
		ciudad.setPersistible(true);	
		ciudad.setFormat("Ciudad");

		imagen.setName("C. P.");
		imagen.setFieldName("cp");
		imagen.setCss("form-control");
		imagen.setOrder(16);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(10);
		imagen.setGroup("direccionFiscal");
		imagen.setPersistible(true);
		imagen.setFormat("C. P.");


		estado.setName("Estado");
		estado.setFieldName("estado");
		estado.setCss("form-control");
		estado.setOrder(17);
		estado.setComponentType("selectorEstado");
		estado.setReadOnly(false);
		estado.setHidden(false);
		estado.setRequired(false);
		estado.setShowInBasket(false);
		estado.setId(false);
		estado.setGroup("direccionFiscal");
		estado.setPersistible(true);
		estado.setLength(255);
		estado.setFormat("Estado");

		metodopago.setName("Metodo de pago");
		metodopago.setFieldName("metodopago");
		metodopago.setCss("form-control");
		metodopago.setOrder(18);
		metodopago.setComponentType("metodopago");
		metodopago.setReadOnly(false);
		metodopago.setHidden(false);
		metodopago.setRequired(false);
		metodopago.setShowInBasket(false);
		metodopago.setId(false);
		metodopago.setGroup("direccionFiscal");
		metodopago.setPersistible(true);
		metodopago.setLength(10);
		metodopago.setFormat("Metodo de pago");
		metodopago.setValue("");

		formapago.setName("Forma de pago");
		formapago.setFieldName("formapago");
		formapago.setCss("form-control");
		formapago.setOrder(19);
		formapago.setComponentType("formapago");
		formapago.setReadOnly(false);
		formapago.setHidden(false);
		formapago.setRequired(true);
		formapago.setShowInBasket(false);
		formapago.setId(false);
		formapago.setLength(6);
		formapago.setGroup("pago");
		formapago.setPersistible(false);
		formapago.setFormat("Forma de pago");
		formapago.setValue("");

		cantidad.setName("Monto");
		cantidad.setFieldName("monto");
		cantidad.setCss("form-control");
		cantidad.setOrder(20);
		cantidad.setComponentType("texto");
		cantidad.setReadOnly(false);
		cantidad.setHidden(false);
		cantidad.setRequired(true);
		cantidad.setShowInBasket(false);
		cantidad.setId(false);
		cantidad.setLength(20);
		cantidad.setGroup("pago");
		cantidad.setPersistible(false);
		cantidad.setFormat("00.00");

		fechaPago.setName("Fecha");
		fechaPago.setFieldName("fecha");
		fechaPago.setCss("form-control");
		fechaPago.setOrder(21);
		fechaPago.setComponentType("fecha");
		fechaPago.setReadOnly(true);
		fechaPago.setHidden(false);
		fechaPago.setRequired(true);
		fechaPago.setShowInBasket(false);
		fechaPago.setId(false);
		fechaPago.setLength(10);
		fechaPago.setGroup("pago");
		fechaPago.setPersistible(true);
		fechaPago.setFormat("yyyy-MM-dd");
		fechaPago.setValue("${hoyCorto}");

		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(21);
		obs.setComponentType("texto");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(true);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(20);
		obs.setGroup("pago");
		obs.setPersistible(false);
		obs.setFormat("Observaciones");

		subtotal.setName("Subtotal");
		subtotal.setFieldName("subtotal");
		subtotal.setCss("form-control");
		subtotal.setOrder(22);
		subtotal.setComponentType("moneda");
		subtotal.setReadOnly(true);
		subtotal.setHidden(false);
		subtotal.setRequired(true);
		subtotal.setShowInBasket(true);
		subtotal.setId(false);
		subtotal.setLength(20);
		subtotal.setGroup("totales");
		subtotal.setPersistible(false);
		subtotal.setValue("00.00");
		subtotal.setFormat("00.00");

		descuento.setName("Descuento");
		descuento.setFieldName("descuento");
		descuento.setCss("form-control");
		descuento.setOrder(23);
		descuento.setComponentType("moneda");
		descuento.setReadOnly(true);
		descuento.setHidden(false);
		descuento.setRequired(true);
		descuento.setShowInBasket(true);
		descuento.setId(false);
		descuento.setLength(20);
		descuento.setGroup("totales");
		descuento.setPersistible(false);
		descuento.setValue("00.00");
		descuento.setFormat("00.00");


		impret.setName("Impuesto retenido");
		impret.setFieldName("impret");
		impret.setCss("form-control");
		impret.setOrder(24);
		impret.setComponentType("moneda");
		impret.setReadOnly(true);
		impret.setHidden(false);
		impret.setRequired(true);
		impret.setShowInBasket(true);
		impret.setId(false);
		impret.setLength(20);
		impret.setGroup("totales");
		impret.setPersistible(false);
		impret.setValue("00.00");
		impret.setFormat("00.00");

		imptras.setName("Impuesto trasladado");
		imptras.setFieldName("imptras");
		imptras.setCss("form-control");
		imptras.setOrder(25);
		imptras.setComponentType("moneda");
		imptras.setReadOnly(true);
		imptras.setHidden(false);
		imptras.setRequired(true);
		imptras.setShowInBasket(true);
		imptras.setId(false);
		imptras.setLength(20);
		imptras.setGroup("totales");
		imptras.setPersistible(false);
		imptras.setValue("00.00");
		imptras.setFormat("00.00");

		total.setName("Total");
		total.setFieldName("total");
		total.setCss("form-control");
		total.setOrder(26);
		total.setComponentType("moneda");
		total.setReadOnly(true);
		total.setHidden(false);
		total.setRequired(true);
		total.setShowInBasket(true);
		total.setId(false);
		total.setLength(20);
		total.setGroup("totales");
		total.setPersistible(false);
		total.setValue("00.00");
		total.setValidation("[a-zA-Z0-9,.;:_'\\s-]+$");
		total.setFormat("00.00");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(27);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("Nueva");
		status.setValidation("");
		status.setFormat("Status");

		campos.add(status);
		campos.add(total);
		campos.add(impret);
		campos.add(imptras);
		campos.add(descuento);
		campos.add(subtotal);
		campos.add(tipo);
		campos.add(obs);
		campos.add(fechaPago);
		campos.add(cantidad);
		campos.add(formapago);
		campos.add(metodopago);
		campos.add(estado);
		campos.add(ciudad);
		campos.add(poblacion);
		campos.add(municipio);
		campos.add(goles);
		campos.add(puntuacion);
		campos.add(aMaterno);
		//campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(aPaterno);
		campos.add(fNacim);
		campos.add(posicion);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("Guardar");
		forma.setName("pedido");
		forma.setView("pedido");
		forma.setTitle("Pedido");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("solicitud");
		forma.setBasket("pedido");
		forma.setCreateable(true);
		forma.setTable("doctos");
		forma.setValidate(true);

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

	@Test
	public void testGuardarFormaCotizacion() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("cotizacion.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field campoCodigo = new Field();
		//Campo campoCampo = new Campo();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();
		Field posicion = new Field();
		Field goles = new Field();
		Field puntuacion = new Field();
		Field imagen = new Field();
		Field categoria = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Resource forma = new Resource();
		Field municipio = new Field();
		Field poblacion = new Field();
		Field ciudad = new Field();
		Field estado = new Field();
		Field metodopago = new Field();
		Field formapago = new Field();
		Field cantidad = new Field();
		Field fechaPago = new Field();
		Field obs = new Field();
		Field tipo = new Field();
		Field subtotal = new Field();
		Field descuento = new Field();
		Field imptras = new Field();
		Field impret = new Field();
		Field total = new Field();
		Field status = new Field();

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("cotizacion");
		guardar.setModule("solicitud");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button carrito = new Button();
		carrito.setCommandName("nuevo");
		carrito.setName("nuevo");
		carrito.setLabel("Productos/Servicios");
		carrito.setComponentType("location");
		carrito.setCss("btn btn-success");
		carrito.setResourceName("prodserv");
		carrito.setModule("inventario");
		carrito.setOrder(3);
		carrito.setResourceType("basket");
		carrito.setVersion("1.0");
		carrito.setEvents("nuevo");

		acciones.add(guardar);
		acciones.add(carrito);

		/*tipo.setNombre("Tipo de documento");
		tipo.setBd("tipo");
		tipo.setCss("form-control");
		tipo.setOrden(1);
		tipo.setType("texto");
		tipo.setLectura(true);
		tipo.setOculto(false);
		tipo.setRequerido(false);
		tipo.setLista(true);
		tipo.setId(false);
		tipo.setLongitud(20);
		tipo.setGrupo("cabecero");
		tipo.setPersistible(true);
		tipo.setValor("cotizacion");

		campoCodigo.setNombre("Folio interno");
		campoCodigo.setBd("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrden(2);
		campoCodigo.setType("texto");
		campoCodigo.setLectura(false);
		campoCodigo.setOculto(false);
		campoCodigo.setRequerido(true);
		campoCodigo.setLista(true);
		campoCodigo.setId(true);
		campoCodigo.setLongitud(20);
		campoCodigo.setGrupo("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setAutogenerado(true);*/

		tipo.setName("Tipo de documento");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("cotizacion");
		tipo.setFormat("");


		campoCodigo.setName("Folio interno");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		//campoCodigo.setAutogenerado(true);
		campoCodigo.setFormat("{TIPO-CONS}");
		//campoCodigo.setAutogenerado(false);

		/*
		 * campoCampo.setNombre("Automatico"); campoCampo.setBd("AUTO");
		 * campoCampo.setCss("form-control"); campoCampo.setOrden(2);
		 * campoCampo.setType("checkbox"); campoCampo.setLectura(false);
		 * campoCampo.setOculto(false); campoCampo.setRequerido(true);
		 * campoCampo.setLista(true); campoCampo.setId(false);
		 * campoCampo.setGrupo("cabecero"); campoCampo.setPersistible(false);
		 */

		aMaterno.setName("Codigo emisor");
		aMaterno.setFieldName("emisorcodigo");
		aMaterno.setCss("form-control");
		aMaterno.setOrder(3);
		aMaterno.setComponentType("texto");
		aMaterno.setReadOnly(false);
		aMaterno.setHidden(false);
		aMaterno.setRequired(false);
		aMaterno.setShowInBasket(false);
		aMaterno.setId(false);
		aMaterno.setLength(20);
		aMaterno.setGroup("emisor");
		aMaterno.setPersistible(false);
		aMaterno.setFormat("Codigo emisor");

		aPaterno.setName("RFC emisor");
		aPaterno.setFieldName("emisor");
		aPaterno.setCss("form-control");
		aPaterno.setOrder(4);
		aPaterno.setComponentType("texto");
		aPaterno.setReadOnly(false);
		aPaterno.setHidden(false);
		aPaterno.setRequired(true);
		aPaterno.setShowInBasket(false);
		aPaterno.setId(false);
		aPaterno.setLength(20);
		aPaterno.setGroup("emisor");
		aPaterno.setPersistible(true);
		aPaterno.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		aPaterno.setFormat("RFC emisor");

		fNacim.setName("Codigo receptor");
		fNacim.setFieldName("receptorcodigo");
		fNacim.setCss("form-control");
		fNacim.setOrder(5);
		fNacim.setComponentType("texto");
		fNacim.setReadOnly(false);
		fNacim.setHidden(false);
		fNacim.setRequired(false);
		fNacim.setShowInBasket(false);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setGroup("receptor");
		fNacim.setPersistible(false);
		fNacim.setFormat("Codigo receptor");

		posicion.setName("RFC receptor");
		posicion.setFieldName("receptor");
		posicion.setCss("form-control");
		posicion.setOrder(6);
		posicion.setComponentType("texto");
		posicion.setReadOnly(false);
		posicion.setHidden(false);
		posicion.setRequired(true);
		posicion.setShowInBasket(false);
		posicion.setId(false);
		posicion.setLength(20);
		posicion.setGroup("receptor");
		posicion.setPersistible(true);
		posicion.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		posicion.setFormat("RFC receptor");

		puntuacion.setName("Uso CFDi");
		puntuacion.setFieldName("uso");
		puntuacion.setCss("form-control");
		puntuacion.setOrder(7);
		puntuacion.setComponentType("uso");
		puntuacion.setReadOnly(false);
		puntuacion.setHidden(false);
		puntuacion.setRequired(true);
		puntuacion.setShowInBasket(false);
		puntuacion.setId(false);
		puntuacion.setLength(5);
		puntuacion.setGroup("receptor");
		puntuacion.setPersistible(true);
		puntuacion.setValidation("");
		puntuacion.setFormat("Uso CFDi");
		puntuacion.setValue("");

		goles.setName("Direccion de facturación");
		goles.setFieldName("dirfactura");
		goles.setCss("form-control");
		goles.setOrder(8);
		goles.setComponentType("selectorDireccion");
		goles.setReadOnly(false);
		goles.setHidden(false);
		goles.setRequired(false);
		goles.setShowInBasket(false);
		goles.setId(false);
		goles.setLength(20);
		goles.setGroup("direccionFiscal");
		goles.setPersistible(false);
		goles.setFormat("Direccion de facturación");

		categoria.setName("Calle");
		categoria.setFieldName("calle");
		categoria.setCss("form-control");
		categoria.setOrder(10);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(20);
		categoria.setGroup("direccionFiscal");
		categoria.setPersistible(true);
		categoria.setFormat("Calle");

		usuario.setName("No Int");
		usuario.setFieldName("noint");
		usuario.setCss("form-control");
		usuario.setOrder(11);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(10);
		usuario.setGroup("direccionFiscal");
		usuario.setPersistible(true);
		usuario.setFormat("No Int");

		fecha.setName("No Ext");
		fecha.setFieldName("noext");
		fecha.setCss("form-control");
		fecha.setOrder(12);
		fecha.setComponentType("texto");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(10);
		fecha.setGroup("direccionFiscal");
		fecha.setPersistible(true);	
		fecha.setFormat("No Ext");

		municipio.setName("Municipio");
		municipio.setFieldName("municipio");
		municipio.setCss("form-control");
		municipio.setOrder(13);
		municipio.setComponentType("texto");
		municipio.setReadOnly(false);
		municipio.setHidden(false);
		municipio.setRequired(false);
		municipio.setShowInBasket(false);
		municipio.setId(false);
		municipio.setLength(20);
		municipio.setGroup("direccionFiscal");
		municipio.setPersistible(true);	
		municipio.setFormat("Municipio");

		poblacion.setName("Población");
		poblacion.setFieldName("poblacion");
		poblacion.setCss("form-control");
		poblacion.setOrder(14);
		poblacion.setComponentType("texto");
		poblacion.setReadOnly(false);
		poblacion.setHidden(false);
		poblacion.setRequired(false);
		poblacion.setShowInBasket(false);
		poblacion.setId(false);
		poblacion.setLength(20);
		poblacion.setGroup("direccionFiscal");
		poblacion.setPersistible(true);	
		poblacion.setFormat("Población");

		ciudad.setName("Ciudad");
		ciudad.setFieldName("ciudad");
		ciudad.setCss("form-control");
		ciudad.setOrder(15);
		ciudad.setComponentType("texto");
		ciudad.setReadOnly(false);
		ciudad.setHidden(false);
		ciudad.setRequired(false);
		ciudad.setShowInBasket(false);
		ciudad.setId(false);
		ciudad.setLength(20);
		ciudad.setGroup("direccionFiscal");
		ciudad.setPersistible(true);	
		ciudad.setFormat("Ciudad");

		imagen.setName("C. P.");
		imagen.setFieldName("cp");
		imagen.setCss("form-control");
		imagen.setOrder(16);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(10);
		imagen.setGroup("direccionFiscal");
		imagen.setPersistible(true);
		imagen.setFormat("C. P.");


		estado.setName("Estado");
		estado.setFieldName("estado");
		estado.setCss("form-control");
		estado.setOrder(17);
		estado.setComponentType("selectorEstado");
		estado.setReadOnly(false);
		estado.setHidden(false);
		estado.setRequired(false);
		estado.setShowInBasket(false);
		estado.setId(false);
		estado.setGroup("direccionFiscal");
		estado.setPersistible(true);
		estado.setLength(255);
		estado.setFormat("Estado");

		metodopago.setName("Metodo de pago");
		metodopago.setFieldName("metodopago");
		metodopago.setCss("form-control");
		metodopago.setOrder(18);
		metodopago.setComponentType("metodopago");
		metodopago.setReadOnly(false);
		metodopago.setHidden(false);
		metodopago.setRequired(false);
		metodopago.setShowInBasket(false);
		metodopago.setId(false);
		metodopago.setGroup("direccionFiscal");
		metodopago.setPersistible(true);
		metodopago.setLength(10);
		metodopago.setFormat("Metodo de pago");
		metodopago.setValue("");

		formapago.setName("Forma de pago");
		formapago.setFieldName("formapago");
		formapago.setCss("form-control");
		formapago.setOrder(19);
		formapago.setComponentType("formapago");
		formapago.setReadOnly(false);
		formapago.setHidden(false);
		formapago.setRequired(true);
		formapago.setShowInBasket(false);
		formapago.setId(false);
		formapago.setLength(6);
		formapago.setGroup("pago");
		formapago.setPersistible(false);
		formapago.setFormat("Forma de pago");
		formapago.setValue("");

		cantidad.setName("Monto");
		cantidad.setFieldName("monto");
		cantidad.setCss("form-control");
		cantidad.setOrder(20);
		cantidad.setComponentType("texto");
		cantidad.setReadOnly(false);
		cantidad.setHidden(false);
		cantidad.setRequired(true);
		cantidad.setShowInBasket(false);
		cantidad.setId(false);
		cantidad.setLength(20);
		cantidad.setGroup("pago");
		cantidad.setPersistible(false);
		cantidad.setFormat("00.00");

		fechaPago.setName("Fecha");
		fechaPago.setFieldName("fecha");
		fechaPago.setCss("form-control");
		fechaPago.setOrder(21);
		fechaPago.setComponentType("fecha");
		fechaPago.setReadOnly(true);
		fechaPago.setHidden(false);
		fechaPago.setRequired(true);
		fechaPago.setShowInBasket(false);
		fechaPago.setId(false);
		fechaPago.setLength(10);
		fechaPago.setGroup("pago");
		fechaPago.setPersistible(true);
		fechaPago.setFormat("yyyy-MM-dd");
		fechaPago.setValue("${hoyCorto}");

		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(21);
		obs.setComponentType("texto");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(true);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(20);
		obs.setGroup("pago");
		obs.setPersistible(false);
		obs.setFormat("Observaciones");

		subtotal.setName("Subtotal");
		subtotal.setFieldName("subtotal");
		subtotal.setCss("form-control");
		subtotal.setOrder(22);
		subtotal.setComponentType("moneda");
		subtotal.setReadOnly(true);
		subtotal.setHidden(false);
		subtotal.setRequired(true);
		subtotal.setShowInBasket(true);
		subtotal.setId(false);
		subtotal.setLength(20);
		subtotal.setGroup("totales");
		subtotal.setPersistible(false);
		subtotal.setValue("00.00");
		subtotal.setFormat("00.00");

		descuento.setName("Descuento");
		descuento.setFieldName("descuento");
		descuento.setCss("form-control");
		descuento.setOrder(23);
		descuento.setComponentType("moneda");
		descuento.setReadOnly(true);
		descuento.setHidden(false);
		descuento.setRequired(true);
		descuento.setShowInBasket(true);
		descuento.setId(false);
		descuento.setLength(20);
		descuento.setGroup("totales");
		descuento.setPersistible(false);
		descuento.setValue("00.00");
		descuento.setFormat("00.00");


		impret.setName("Impuesto retenido");
		impret.setFieldName("impret");
		impret.setCss("form-control");
		impret.setOrder(24);
		impret.setComponentType("moneda");
		impret.setReadOnly(true);
		impret.setHidden(false);
		impret.setRequired(true);
		impret.setShowInBasket(true);
		impret.setId(false);
		impret.setLength(20);
		impret.setGroup("totales");
		impret.setPersistible(false);
		impret.setValue("00.00");
		impret.setFormat("00.00");

		imptras.setName("Impuesto trasladado");
		imptras.setFieldName("imptras");
		imptras.setCss("form-control");
		imptras.setOrder(25);
		imptras.setComponentType("moneda");
		imptras.setReadOnly(true);
		imptras.setHidden(false);
		imptras.setRequired(true);
		imptras.setShowInBasket(true);
		imptras.setId(false);
		imptras.setLength(20);
		imptras.setGroup("totales");
		imptras.setPersistible(false);
		imptras.setValue("00.00");
		imptras.setFormat("00.00");

		total.setName("Total");
		total.setFieldName("total");
		total.setCss("form-control");
		total.setOrder(26);
		total.setComponentType("moneda");
		total.setReadOnly(true);
		total.setHidden(false);
		total.setRequired(true);
		total.setShowInBasket(true);
		total.setId(false);
		total.setLength(20);
		total.setGroup("totales");
		total.setPersistible(false);
		total.setValue("00.00");
		total.setValidation("[a-zA-Z0-9,.;:_'\\s-]+$");
		total.setFormat("00.00");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(27);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("Nueva");
		status.setValidation("");
		status.setFormat("Status");

		campos.add(status);
		campos.add(total);
		campos.add(impret);
		campos.add(imptras);
		campos.add(descuento);
		campos.add(subtotal);
		campos.add(tipo);
		campos.add(obs);
		campos.add(fechaPago);
		campos.add(cantidad);
		campos.add(formapago);
		campos.add(metodopago);
		campos.add(estado);
		campos.add(ciudad);
		campos.add(poblacion);
		campos.add(municipio);
		campos.add(goles);
		campos.add(puntuacion);
		campos.add(aMaterno);
		//campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(aPaterno);
		campos.add(fNacim);
		campos.add(posicion);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("Guardar");
		forma.setName("cotizacion");
		forma.setView("cotizacion");
		forma.setTitle("Cotizacion");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("solicitud");
		forma.setBasket("cotizacion");
		forma.setCreateable(true);
		forma.setTable("doctos");
		forma.setValidate(true);
		forma.setVersionable(false);

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

	@Test
	public void testGuardarFormaComprobante() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("comprobante.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field campoCodigo = new Field();
		//Campo campoCampo = new Campo();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();
		Field posicion = new Field();
		Field goles = new Field();
		Field puntuacion = new Field();
		Field imagen = new Field();
		Field categoria = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Resource forma = new Resource();
		Field municipio = new Field();
		Field poblacion = new Field();
		Field ciudad = new Field();
		Field estado = new Field();
		Field metodopago = new Field();
		Field formapago = new Field();
		Field cantidad = new Field();
		Field fechaPago = new Field();
		Field obs = new Field();
		Field tipo = new Field();
		Field subtotal = new Field();
		Field descuento = new Field();
		Field imptras = new Field();
		Field impret = new Field();
		Field total = new Field();
		Field status = new Field();
		Field serie = new Field();

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("submit");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("comprobante");
		guardar.setModule("comprobantes");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("3.3");
		guardar.setEvents("nuevo");

		Button carrito = new Button();
		carrito.setCommandName("nuevo");
		carrito.setName("nuevo");
		carrito.setLabel("Productos/Servicios");
		carrito.setComponentType("botonliga");
		carrito.setCss("btn btn-success");
		carrito.setResourceName("producto");
		carrito.setModule("inventario");
		carrito.setOrder(3);
		carrito.setResourceType("basket");
		carrito.setVersion("1.0");
		carrito.setEvents("nuevo");

		acciones.add(guardar);
		acciones.add(carrito);

		tipo.setName("Tipo de documento");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(false);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("comprobante");

		campoCodigo.setName("Folio interno");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);

		/*
		 * campoCampo.setNombre("Automatico"); campoCampo.setBd("AUTO");
		 * campoCampo.setCss("form-control"); campoCampo.setOrden(2);
		 * campoCampo.setType("checkbox"); campoCampo.setLectura(false);
		 * campoCampo.setOculto(false); campoCampo.setRequerido(true);
		 * campoCampo.setLista(true); campoCampo.setId(false);
		 * campoCampo.setGrupo("cabecero"); campoCampo.setPersistible(false);
		 */

		aMaterno.setName("Codigo emisor");
		aMaterno.setFieldName("emisorcodigo");
		aMaterno.setCss("form-control");
		aMaterno.setOrder(3);
		aMaterno.setComponentType("texto");
		aMaterno.setReadOnly(false);
		aMaterno.setHidden(false);
		aMaterno.setRequired(false);
		aMaterno.setShowInBasket(false);
		aMaterno.setId(false);
		aMaterno.setLength(20);
		aMaterno.setGroup("emisor");
		aMaterno.setPersistible(false);

		aPaterno.setName("RFC emisor");
		aPaterno.setFieldName("emisor");
		aPaterno.setCss("form-control");
		aPaterno.setOrder(4);
		aPaterno.setComponentType("texto");
		aPaterno.setReadOnly(false);
		aPaterno.setHidden(false);
		aPaterno.setRequired(true);
		aPaterno.setShowInBasket(false);
		aPaterno.setId(false);
		aPaterno.setLength(20);
		aPaterno.setGroup("emisor");
		aPaterno.setPersistible(true);
		aPaterno.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");

		fNacim.setName("Codigo receptor");
		fNacim.setFieldName("receptorcodigo");
		fNacim.setCss("form-control");
		fNacim.setOrder(5);
		fNacim.setComponentType("texto");
		fNacim.setReadOnly(false);
		fNacim.setHidden(false);
		fNacim.setRequired(false);
		fNacim.setShowInBasket(false);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setGroup("receptor");
		fNacim.setPersistible(false);

		posicion.setName("RFC receptor");
		posicion.setFieldName("receptor");
		posicion.setCss("form-control");
		posicion.setOrder(6);
		posicion.setComponentType("texto");
		posicion.setReadOnly(false);
		posicion.setHidden(false);
		posicion.setRequired(true);
		posicion.setShowInBasket(false);
		posicion.setId(false);
		posicion.setLength(20);
		posicion.setGroup("receptor");
		posicion.setPersistible(true);
		posicion.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");

		puntuacion.setName("Uso CFDi");
		puntuacion.setFieldName("uso");
		puntuacion.setCss("form-control");
		puntuacion.setOrder(7);
		puntuacion.setComponentType("uso");
		puntuacion.setReadOnly(false);
		puntuacion.setHidden(false);
		puntuacion.setRequired(true);
		puntuacion.setShowInBasket(false);
		puntuacion.setId(false);
		puntuacion.setLength(5);
		puntuacion.setGroup("receptor");
		puntuacion.setPersistible(true);
		puntuacion.setValidation("[a-zA-Z]");

		goles.setName("Direccion de facturación");
		goles.setFieldName("dirfactura");
		goles.setCss("form-control");
		goles.setOrder(8);
		goles.setComponentType("selectorDireccion");
		goles.setReadOnly(false);
		goles.setHidden(false);
		goles.setRequired(false);
		goles.setShowInBasket(false);
		goles.setId(false);
		goles.setLength(20);
		goles.setGroup("direccionFiscal");
		goles.setPersistible(false);

		categoria.setName("Calle");
		categoria.setFieldName("calle");
		categoria.setCss("form-control");
		categoria.setOrder(10);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(20);
		categoria.setGroup("direccionFiscal");
		categoria.setPersistible(true);

		usuario.setName("No Int");
		usuario.setFieldName("noint");
		usuario.setCss("form-control");
		usuario.setOrder(11);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(10);
		usuario.setGroup("direccionFiscal");
		usuario.setPersistible(true);

		fecha.setName("No Ext");
		fecha.setFieldName("noext");
		fecha.setCss("form-control");
		fecha.setOrder(12);
		fecha.setComponentType("texto");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(10);
		fecha.setGroup("direccionFiscal");
		fecha.setPersistible(true);		

		municipio.setName("Municipio");
		municipio.setFieldName("municipio");
		municipio.setCss("form-control");
		municipio.setOrder(13);
		municipio.setComponentType("texto");
		municipio.setReadOnly(false);
		municipio.setHidden(false);
		municipio.setRequired(false);
		municipio.setShowInBasket(false);
		municipio.setId(false);
		municipio.setLength(20);
		municipio.setGroup("direccionFiscal");
		municipio.setPersistible(true);	

		poblacion.setName("Población");
		poblacion.setFieldName("poblacion");
		poblacion.setCss("form-control");
		poblacion.setOrder(14);
		poblacion.setComponentType("texto");
		poblacion.setReadOnly(false);
		poblacion.setHidden(false);
		poblacion.setRequired(false);
		poblacion.setShowInBasket(false);
		poblacion.setId(false);
		poblacion.setLength(20);
		poblacion.setGroup("direccionFiscal");
		poblacion.setPersistible(true);		

		ciudad.setName("Ciudad");
		ciudad.setFieldName("ciudad");
		ciudad.setCss("form-control");
		ciudad.setOrder(15);
		ciudad.setComponentType("texto");
		ciudad.setReadOnly(false);
		ciudad.setHidden(false);
		ciudad.setRequired(false);
		ciudad.setShowInBasket(false);
		ciudad.setId(false);
		ciudad.setLength(20);
		ciudad.setGroup("direccionFiscal");
		ciudad.setPersistible(true);	

		imagen.setName("C. P.");
		imagen.setFieldName("cp");
		imagen.setCss("form-control");
		imagen.setOrder(16);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(10);
		imagen.setGroup("direccionFiscal");
		imagen.setPersistible(true);


		estado.setName("Estado");
		estado.setFieldName("estado");
		estado.setCss("form-control");
		estado.setOrder(17);
		estado.setComponentType("selectorEstado");
		estado.setReadOnly(false);
		estado.setHidden(false);
		estado.setRequired(false);
		estado.setShowInBasket(false);
		estado.setId(false);
		estado.setGroup("direccionFiscal");
		estado.setPersistible(true);
		imagen.setLength(255);

		metodopago.setName("Metodo de pago");
		metodopago.setFieldName("metodopago");
		metodopago.setCss("form-control");
		metodopago.setOrder(18);
		metodopago.setComponentType("radio_mpago");
		metodopago.setReadOnly(false);
		metodopago.setHidden(false);
		metodopago.setRequired(false);
		metodopago.setShowInBasket(false);
		metodopago.setId(false);
		metodopago.setGroup("direccionFiscal");
		metodopago.setPersistible(true);
		imagen.setLength(10);

		formapago.setName("Forma de pago");
		formapago.setFieldName("formapago");
		formapago.setCss("form-control");
		formapago.setOrder(19);
		formapago.setComponentType("texto");
		formapago.setReadOnly(false);
		formapago.setHidden(false);
		formapago.setRequired(true);
		formapago.setShowInBasket(false);
		formapago.setId(false);
		formapago.setLength(6);
		formapago.setGroup("pago");
		formapago.setPersistible(false);

		cantidad.setName("Monto");
		cantidad.setFieldName("monto");
		cantidad.setCss("form-control");
		cantidad.setOrder(20);
		cantidad.setComponentType("texto");
		cantidad.setReadOnly(false);
		cantidad.setHidden(false);
		cantidad.setRequired(true);
		cantidad.setShowInBasket(false);
		cantidad.setId(false);
		cantidad.setLength(20);
		cantidad.setGroup("pago");
		cantidad.setPersistible(false);

		fechaPago.setName("Fecha");
		fechaPago.setFieldName("fecha");
		fechaPago.setCss("form-control");
		fechaPago.setOrder(21);
		fechaPago.setComponentType("fecha");
		fechaPago.setReadOnly(false);
		fechaPago.setHidden(false);
		fechaPago.setRequired(true);
		fechaPago.setShowInBasket(false);
		fechaPago.setId(false);
		fechaPago.setLength(10);
		fechaPago.setGroup("pago");
		fechaPago.setPersistible(true);
		fechaPago.setFormat("yyyy-MM-dd");

		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(21);
		obs.setComponentType("texto");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(true);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(20);
		obs.setGroup("pago");
		obs.setPersistible(false);

		subtotal.setName("Subtotal");
		subtotal.setFieldName("subtotal");
		subtotal.setCss("form-control");
		subtotal.setOrder(22);
		subtotal.setComponentType("moneda");
		subtotal.setReadOnly(true);
		subtotal.setHidden(false);
		subtotal.setRequired(true);
		subtotal.setShowInBasket(true);
		subtotal.setId(false);
		subtotal.setLength(20);
		subtotal.setGroup("totales");
		subtotal.setPersistible(false);
		subtotal.setValue("00.00");

		descuento.setName("Descuento");
		descuento.setFieldName("descuento");
		descuento.setCss("form-control");
		descuento.setOrder(23);
		descuento.setComponentType("moneda");
		descuento.setReadOnly(true);
		descuento.setHidden(false);
		descuento.setRequired(true);
		descuento.setShowInBasket(true);
		descuento.setId(false);
		descuento.setLength(20);
		descuento.setGroup("totales");
		descuento.setPersistible(false);
		descuento.setValue("00.00");


		impret.setName("Impuesto retenido");
		impret.setFieldName("impret");
		impret.setCss("form-control");
		impret.setOrder(24);
		impret.setComponentType("moneda");
		impret.setReadOnly(true);
		impret.setHidden(false);
		impret.setRequired(true);
		impret.setShowInBasket(true);
		impret.setId(false);
		impret.setLength(20);
		impret.setGroup("totales");
		impret.setPersistible(false);
		impret.setValue("00.00");

		imptras.setName("Impuesto trasladado");
		imptras.setFieldName("imptras");
		imptras.setCss("form-control");
		imptras.setOrder(25);
		imptras.setComponentType("moneda");
		imptras.setReadOnly(true);
		imptras.setHidden(false);
		imptras.setRequired(true);
		imptras.setShowInBasket(true);
		imptras.setId(false);
		imptras.setLength(20);
		imptras.setGroup("totales");
		imptras.setPersistible(false);
		imptras.setValue("00.00");

		total.setName("Total");
		total.setFieldName("total");
		total.setCss("form-control");
		total.setOrder(26);
		total.setComponentType("moneda");
		total.setReadOnly(true);
		total.setHidden(false);
		total.setRequired(true);
		total.setShowInBasket(true);
		total.setId(false);
		total.setLength(20);
		total.setGroup("totales");
		total.setPersistible(false);
		total.setValue("00.00");
		total.setValidation("(\\+|-)?([0-9]+(\\.[0-9]+))");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(27);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("Nueva");
		status.setValidation("");

		serie.setName("Serie");
		serie.setFieldName("serie");
		serie.setCss("form-control");
		serie.setOrder(28);
		serie.setComponentType("texto");
		serie.setReadOnly(true);
		serie.setHidden(true);
		serie.setRequired(true);
		serie.setShowInBasket(true);
		serie.setId(false);
		serie.setLength(20);
		serie.setGroup("cabecero");
		serie.setPersistible(false);
		serie.setValue("I");
		serie.setValidation("");
		serie.setFormat("Status");

		campos.add(status);
		campos.add(total);
		campos.add(impret);
		campos.add(imptras);
		campos.add(descuento);
		campos.add(subtotal);
		campos.add(tipo);
		campos.add(obs);
		campos.add(fechaPago);
		campos.add(cantidad);
		campos.add(formapago);
		campos.add(metodopago);
		campos.add(estado);
		campos.add(ciudad);
		campos.add(poblacion);
		campos.add(municipio);
		campos.add(goles);
		campos.add(puntuacion);
		campos.add(aMaterno);
		//campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(aPaterno);
		campos.add(fNacim);
		campos.add(posicion);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		campos.add(serie);
		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("Guardar");
		forma.setName("comprobante");
		forma.setView("comprobante");
		forma.setTitle("Comprobante");
		forma.setVersion("3.3");
		forma.setStatus("produccion");
		forma.setModule("comprobantes");
		forma.setBasket("comprobante");
		forma.setCreateable(false);
		forma.setTable("doctos");
		forma.setValidate(true);

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

	@Test
	public void testGuardarFormaDocumento() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("documento.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field campoCodigo = new Field();
		//Campo campoCampo = new Campo();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();
		Field posicion = new Field();
		Field goles = new Field();
		Field puntuacion = new Field();
		Field imagen = new Field();
		Field categoria = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Resource forma = new Resource();
		Field municipio = new Field();
		Field poblacion = new Field();
		Field ciudad = new Field();
		Field estado = new Field();
		Field metodopago = new Field();
		Field formapago = new Field();
		Field cantidad = new Field();
		Field fechaPago = new Field();
		Field obs = new Field();
		Field tipo = new Field();
		Field subtotal = new Field();
		Field descuento = new Field();
		Field imptras = new Field();
		Field impret = new Field();
		Field total = new Field();
		Field status = new Field();

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("submit");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("documento");
		guardar.setModule("documentos");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("3.3");
		guardar.setEvents("nuevo");

		Button carrito = new Button();
		carrito.setCommandName("nuevo");
		carrito.setName("nuevo");
		carrito.setLabel("Productos/Servicios");
		carrito.setComponentType("botonliga");
		carrito.setCss("btn btn-success");
		carrito.setResourceName("documento");
		carrito.setModule("documentos");
		carrito.setOrder(3);
		carrito.setResourceType("basket");
		carrito.setVersion("1.0");
		carrito.setEvents("nuevo");

		acciones.add(guardar);
		acciones.add(carrito);

		tipo.setName("Tipo de documento");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(false);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("documento");

		campoCodigo.setName("Folio interno");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setSearcheable(true);
		/*
		 * campoCampo.setNombre("Automatico"); campoCampo.setBd("AUTO");
		 * campoCampo.setCss("form-control"); campoCampo.setOrden(2);
		 * campoCampo.setType("checkbox"); campoCampo.setLectura(false);
		 * campoCampo.setOculto(false); campoCampo.setRequerido(true);
		 * campoCampo.setLista(true); campoCampo.setId(false);
		 * campoCampo.setGrupo("cabecero"); campoCampo.setPersistible(false);
		 */

		aMaterno.setName("Codigo emisor");
		aMaterno.setFieldName("emisorcodigo");
		aMaterno.setCss("form-control");
		aMaterno.setOrder(3);
		aMaterno.setComponentType("texto");
		aMaterno.setReadOnly(false);
		aMaterno.setHidden(false);
		aMaterno.setRequired(false);
		aMaterno.setShowInBasket(false);
		aMaterno.setId(false);
		aMaterno.setLength(20);
		aMaterno.setGroup("emisor");
		aMaterno.setPersistible(false);

		aPaterno.setName("RFC emisor");
		aPaterno.setFieldName("emisor");
		aPaterno.setCss("form-control");
		aPaterno.setOrder(4);
		aPaterno.setComponentType("texto");
		aPaterno.setReadOnly(false);
		aPaterno.setHidden(false);
		aPaterno.setRequired(true);
		aPaterno.setShowInBasket(false);
		aPaterno.setId(false);
		aPaterno.setLength(20);
		aPaterno.setGroup("emisor");
		aPaterno.setPersistible(true);
		aPaterno.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");

		fNacim.setName("Codigo receptor");
		fNacim.setFieldName("receptorcodigo");
		fNacim.setCss("form-control");
		fNacim.setOrder(5);
		fNacim.setComponentType("texto");
		fNacim.setReadOnly(false);
		fNacim.setHidden(false);
		fNacim.setRequired(false);
		fNacim.setShowInBasket(false);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setGroup("receptor");
		fNacim.setPersistible(false);
		fNacim.setSearcheable(true);

		posicion.setName("RFC receptor");
		posicion.setFieldName("receptor");
		posicion.setCss("form-control");
		posicion.setOrder(6);
		posicion.setComponentType("texto");
		posicion.setReadOnly(false);
		posicion.setHidden(false);
		posicion.setRequired(true);
		posicion.setShowInBasket(false);
		posicion.setId(false);
		posicion.setLength(20);
		posicion.setGroup("receptor");
		posicion.setPersistible(true);
		posicion.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		posicion.setSearcheable(true);
		
		puntuacion.setName("Uso CFDi");
		puntuacion.setFieldName("uso");
		puntuacion.setCss("form-control");
		puntuacion.setOrder(7);
		puntuacion.setComponentType("uso");
		puntuacion.setReadOnly(false);
		puntuacion.setHidden(false);
		puntuacion.setRequired(true);
		puntuacion.setShowInBasket(false);
		puntuacion.setId(false);
		puntuacion.setLength(5);
		puntuacion.setGroup("receptor");
		puntuacion.setPersistible(true);
		puntuacion.setValidation("[a-zA-Z]");

		goles.setName("Direccion de facturación");
		goles.setFieldName("dirfactura");
		goles.setCss("form-control");
		goles.setOrder(8);
		goles.setComponentType("selectorDireccion");
		goles.setReadOnly(false);
		goles.setHidden(false);
		goles.setRequired(false);
		goles.setShowInBasket(false);
		goles.setId(false);
		goles.setLength(20);
		goles.setGroup("direccionFiscal");
		goles.setPersistible(false);

		categoria.setName("Calle");
		categoria.setFieldName("calle");
		categoria.setCss("form-control");
		categoria.setOrder(10);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(20);
		categoria.setGroup("direccionFiscal");
		categoria.setPersistible(true);

		usuario.setName("No Int");
		usuario.setFieldName("noint");
		usuario.setCss("form-control");
		usuario.setOrder(11);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(10);
		usuario.setGroup("direccionFiscal");
		usuario.setPersistible(true);

		fecha.setName("No Ext");
		fecha.setFieldName("noext");
		fecha.setCss("form-control");
		fecha.setOrder(12);
		fecha.setComponentType("texto");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(10);
		fecha.setGroup("direccionFiscal");
		fecha.setPersistible(true);		

		municipio.setName("Municipio");
		municipio.setFieldName("municipio");
		municipio.setCss("form-control");
		municipio.setOrder(13);
		municipio.setComponentType("texto");
		municipio.setReadOnly(false);
		municipio.setHidden(false);
		municipio.setRequired(false);
		municipio.setShowInBasket(false);
		municipio.setId(false);
		municipio.setLength(20);
		municipio.setGroup("direccionFiscal");
		municipio.setPersistible(true);	

		poblacion.setName("Población");
		poblacion.setFieldName("poblacion");
		poblacion.setCss("form-control");
		poblacion.setOrder(14);
		poblacion.setComponentType("texto");
		poblacion.setReadOnly(false);
		poblacion.setHidden(false);
		poblacion.setRequired(false);
		poblacion.setShowInBasket(false);
		poblacion.setId(false);
		poblacion.setLength(20);
		poblacion.setGroup("direccionFiscal");
		poblacion.setPersistible(true);		

		ciudad.setName("Ciudad");
		ciudad.setFieldName("ciudad");
		ciudad.setCss("form-control");
		ciudad.setOrder(15);
		ciudad.setComponentType("texto");
		ciudad.setReadOnly(false);
		ciudad.setHidden(false);
		ciudad.setRequired(false);
		ciudad.setShowInBasket(false);
		ciudad.setId(false);
		ciudad.setLength(20);
		ciudad.setGroup("direccionFiscal");
		ciudad.setPersistible(true);	

		imagen.setName("C. P.");
		imagen.setFieldName("cp");
		imagen.setCss("form-control");
		imagen.setOrder(16);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(10);
		imagen.setGroup("direccionFiscal");
		imagen.setPersistible(true);


		estado.setName("Estado");
		estado.setFieldName("estado");
		estado.setCss("form-control");
		estado.setOrder(17);
		estado.setComponentType("selectorEstado");
		estado.setReadOnly(false);
		estado.setHidden(false);
		estado.setRequired(false);
		estado.setShowInBasket(false);
		estado.setId(false);
		estado.setGroup("direccionFiscal");
		estado.setPersistible(true);
		imagen.setLength(255);

		metodopago.setName("Metodo de pago");
		metodopago.setFieldName("metodopago");
		metodopago.setCss("form-control");
		metodopago.setOrder(18);
		metodopago.setComponentType("radio_mpago");
		metodopago.setReadOnly(false);
		metodopago.setHidden(false);
		metodopago.setRequired(false);
		metodopago.setShowInBasket(false);
		metodopago.setId(false);
		metodopago.setGroup("direccionFiscal");
		metodopago.setPersistible(true);
		imagen.setLength(10);

		formapago.setName("Forma de pago");
		formapago.setFieldName("formapago");
		formapago.setCss("form-control");
		formapago.setOrder(19);
		formapago.setComponentType("texto");
		formapago.setReadOnly(false);
		formapago.setHidden(false);
		formapago.setRequired(true);
		formapago.setShowInBasket(false);
		formapago.setId(false);
		formapago.setLength(6);
		formapago.setGroup("pago");
		formapago.setPersistible(false);

		cantidad.setName("Monto");
		cantidad.setFieldName("monto");
		cantidad.setCss("form-control");
		cantidad.setOrder(20);
		cantidad.setComponentType("texto");
		cantidad.setReadOnly(false);
		cantidad.setHidden(false);
		cantidad.setRequired(true);
		cantidad.setShowInBasket(false);
		cantidad.setId(false);
		cantidad.setLength(20);
		cantidad.setGroup("pago");
		cantidad.setPersistible(false);

		fechaPago.setName("Fecha");
		fechaPago.setFieldName("fecha");
		fechaPago.setCss("form-control");
		fechaPago.setOrder(21);
		fechaPago.setComponentType("fecha");
		fechaPago.setReadOnly(false);
		fechaPago.setHidden(false);
		fechaPago.setRequired(true);
		fechaPago.setShowInBasket(false);
		fechaPago.setId(false);
		fechaPago.setLength(10);
		fechaPago.setGroup("pago");
		fechaPago.setPersistible(true);
		fechaPago.setFormat("yyyy-MM-dd");

		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(21);
		obs.setComponentType("texto");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(true);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(20);
		obs.setGroup("pago");
		obs.setPersistible(false);

		subtotal.setName("Subtotal");
		subtotal.setFieldName("subtotal");
		subtotal.setCss("form-control");
		subtotal.setOrder(22);
		subtotal.setComponentType("moneda");
		subtotal.setReadOnly(true);
		subtotal.setHidden(false);
		subtotal.setRequired(true);
		subtotal.setShowInBasket(true);
		subtotal.setId(false);
		subtotal.setLength(20);
		subtotal.setGroup("totales");
		subtotal.setPersistible(false);
		subtotal.setValue("00.00");

		descuento.setName("Descuento");
		descuento.setFieldName("descuento");
		descuento.setCss("form-control");
		descuento.setOrder(23);
		descuento.setComponentType("moneda");
		descuento.setReadOnly(true);
		descuento.setHidden(false);
		descuento.setRequired(true);
		descuento.setShowInBasket(true);
		descuento.setId(false);
		descuento.setLength(20);
		descuento.setGroup("totales");
		descuento.setPersistible(false);
		descuento.setValue("00.00");


		impret.setName("Impuesto retenido");
		impret.setFieldName("impret");
		impret.setCss("form-control");
		impret.setOrder(24);
		impret.setComponentType("moneda");
		impret.setReadOnly(true);
		impret.setHidden(false);
		impret.setRequired(true);
		impret.setShowInBasket(true);
		impret.setId(false);
		impret.setLength(20);
		impret.setGroup("totales");
		impret.setPersistible(false);
		impret.setValue("00.00");

		imptras.setName("Impuesto trasladado");
		imptras.setFieldName("imptras");
		imptras.setCss("form-control");
		imptras.setOrder(25);
		imptras.setComponentType("moneda");
		imptras.setReadOnly(true);
		imptras.setHidden(false);
		imptras.setRequired(true);
		imptras.setShowInBasket(true);
		imptras.setId(false);
		imptras.setLength(20);
		imptras.setGroup("totales");
		imptras.setPersistible(false);
		imptras.setValue("00.00");

		total.setName("Total");
		total.setFieldName("total");
		total.setCss("form-control");
		total.setOrder(26);
		total.setComponentType("moneda");
		total.setReadOnly(true);
		total.setHidden(false);
		total.setRequired(true);
		total.setShowInBasket(true);
		total.setId(false);
		total.setLength(20);
		total.setGroup("totales");
		total.setPersistible(false);
		total.setValue("00.00");
		total.setValidation("(\\+|-)?([0-9]+(\\.[0-9]+))");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(27);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("Nueva");
		status.setValidation("");

		campos.add(status);
		campos.add(total);
		campos.add(impret);
		campos.add(imptras);
		campos.add(descuento);
		campos.add(subtotal);
		campos.add(tipo);
		campos.add(obs);
		campos.add(fechaPago);
		campos.add(cantidad);
		campos.add(formapago);
		campos.add(metodopago);
		campos.add(estado);
		campos.add(ciudad);
		campos.add(poblacion);
		campos.add(municipio);
		campos.add(goles);
		campos.add(puntuacion);
		campos.add(aMaterno);
		//campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(aPaterno);
		campos.add(fNacim);
		campos.add(posicion);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("Guardar");
		forma.setName("documento");
		forma.setView("documento");
		forma.setTitle("Documento");
		forma.setVersion("3.3");
		forma.setStatus("produccion");
		forma.setModule("documentos");
		forma.setBasket("documento");
		forma.setCreateable(false);
		forma.setTable("doctos");
		forma.setValidate(true);

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

	@Test
	public void testGuardarFormaCatalogoProdServ() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("c_ClaveProdServ.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field campoCodigo = new Field();
		//Campo campoCampo = new Campo();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();
		Field posicion = new Field();
		Field goles = new Field();
		Field puntuacion = new Field();
		Field imagen = new Field();
		Field categoria = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Resource forma = new Resource();
		Field municipio = new Field();
		Field poblacion = new Field();
		Field ciudad = new Field();
		Field estado = new Field();
		Field metodopago = new Field();
		Field formapago = new Field();
		Field cantidad = new Field();
		Field fechaPago = new Field();
		Field obs = new Field();
		Field tipo = new Field();
		Field subtotal = new Field();
		Field descuento = new Field();
		Field imptras = new Field();
		Field impret = new Field();
		Field total = new Field();
		Field status = new Field();

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("submit");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("documento");
		guardar.setModule("documentos");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("3.3");
		guardar.setEvents("nuevo");

		Button carrito = new Button();
		carrito.setCommandName("nuevo");
		carrito.setName("nuevo");
		carrito.setLabel("Productos/Servicios");
		carrito.setComponentType("botonliga");
		carrito.setCss("btn btn-success");
		carrito.setResourceName("documento");
		carrito.setModule("documentos");
		carrito.setOrder(3);
		carrito.setResourceType("basket");
		carrito.setVersion("1.0");
		carrito.setEvents("nuevo");

		acciones.add(guardar);
		acciones.add(carrito);

		tipo.setName("Tipo de documento");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(false);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("documento");

		campoCodigo.setName("Folio interno");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setSearcheable(true);
		/*
		 * campoCampo.setNombre("Automatico"); campoCampo.setBd("AUTO");
		 * campoCampo.setCss("form-control"); campoCampo.setOrden(2);
		 * campoCampo.setType("checkbox"); campoCampo.setLectura(false);
		 * campoCampo.setOculto(false); campoCampo.setRequerido(true);
		 * campoCampo.setLista(true); campoCampo.setId(false);
		 * campoCampo.setGrupo("cabecero"); campoCampo.setPersistible(false);
		 */

		aMaterno.setName("Codigo emisor");
		aMaterno.setFieldName("emisorcodigo");
		aMaterno.setCss("form-control");
		aMaterno.setOrder(3);
		aMaterno.setComponentType("texto");
		aMaterno.setReadOnly(false);
		aMaterno.setHidden(false);
		aMaterno.setRequired(false);
		aMaterno.setShowInBasket(false);
		aMaterno.setId(false);
		aMaterno.setLength(20);
		aMaterno.setGroup("emisor");
		aMaterno.setPersistible(false);

		aPaterno.setName("RFC emisor");
		aPaterno.setFieldName("emisor");
		aPaterno.setCss("form-control");
		aPaterno.setOrder(4);
		aPaterno.setComponentType("texto");
		aPaterno.setReadOnly(false);
		aPaterno.setHidden(false);
		aPaterno.setRequired(true);
		aPaterno.setShowInBasket(false);
		aPaterno.setId(false);
		aPaterno.setLength(20);
		aPaterno.setGroup("emisor");
		aPaterno.setPersistible(true);
		aPaterno.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");

		fNacim.setName("Codigo receptor");
		fNacim.setFieldName("receptorcodigo");
		fNacim.setCss("form-control");
		fNacim.setOrder(5);
		fNacim.setComponentType("texto");
		fNacim.setReadOnly(false);
		fNacim.setHidden(false);
		fNacim.setRequired(false);
		fNacim.setShowInBasket(false);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setGroup("receptor");
		fNacim.setPersistible(false);
		fNacim.setSearcheable(true);

		posicion.setName("RFC receptor");
		posicion.setFieldName("receptor");
		posicion.setCss("form-control");
		posicion.setOrder(6);
		posicion.setComponentType("texto");
		posicion.setReadOnly(false);
		posicion.setHidden(false);
		posicion.setRequired(true);
		posicion.setShowInBasket(false);
		posicion.setId(false);
		posicion.setLength(20);
		posicion.setGroup("receptor");
		posicion.setPersistible(true);
		posicion.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		posicion.setSearcheable(true);
		
		puntuacion.setName("Uso CFDi");
		puntuacion.setFieldName("uso");
		puntuacion.setCss("form-control");
		puntuacion.setOrder(7);
		puntuacion.setComponentType("uso");
		puntuacion.setReadOnly(false);
		puntuacion.setHidden(false);
		puntuacion.setRequired(true);
		puntuacion.setShowInBasket(false);
		puntuacion.setId(false);
		puntuacion.setLength(5);
		puntuacion.setGroup("receptor");
		puntuacion.setPersistible(true);
		puntuacion.setValidation("[a-zA-Z]");

		goles.setName("Direccion de facturación");
		goles.setFieldName("dirfactura");
		goles.setCss("form-control");
		goles.setOrder(8);
		goles.setComponentType("selectorDireccion");
		goles.setReadOnly(false);
		goles.setHidden(false);
		goles.setRequired(false);
		goles.setShowInBasket(false);
		goles.setId(false);
		goles.setLength(20);
		goles.setGroup("direccionFiscal");
		goles.setPersistible(false);

		categoria.setName("Calle");
		categoria.setFieldName("calle");
		categoria.setCss("form-control");
		categoria.setOrder(10);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(20);
		categoria.setGroup("direccionFiscal");
		categoria.setPersistible(true);

		usuario.setName("No Int");
		usuario.setFieldName("noint");
		usuario.setCss("form-control");
		usuario.setOrder(11);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(10);
		usuario.setGroup("direccionFiscal");
		usuario.setPersistible(true);

		fecha.setName("No Ext");
		fecha.setFieldName("noext");
		fecha.setCss("form-control");
		fecha.setOrder(12);
		fecha.setComponentType("texto");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(10);
		fecha.setGroup("direccionFiscal");
		fecha.setPersistible(true);		

		municipio.setName("Municipio");
		municipio.setFieldName("municipio");
		municipio.setCss("form-control");
		municipio.setOrder(13);
		municipio.setComponentType("texto");
		municipio.setReadOnly(false);
		municipio.setHidden(false);
		municipio.setRequired(false);
		municipio.setShowInBasket(false);
		municipio.setId(false);
		municipio.setLength(20);
		municipio.setGroup("direccionFiscal");
		municipio.setPersistible(true);	

		poblacion.setName("Población");
		poblacion.setFieldName("poblacion");
		poblacion.setCss("form-control");
		poblacion.setOrder(14);
		poblacion.setComponentType("texto");
		poblacion.setReadOnly(false);
		poblacion.setHidden(false);
		poblacion.setRequired(false);
		poblacion.setShowInBasket(false);
		poblacion.setId(false);
		poblacion.setLength(20);
		poblacion.setGroup("direccionFiscal");
		poblacion.setPersistible(true);		

		ciudad.setName("Ciudad");
		ciudad.setFieldName("ciudad");
		ciudad.setCss("form-control");
		ciudad.setOrder(15);
		ciudad.setComponentType("texto");
		ciudad.setReadOnly(false);
		ciudad.setHidden(false);
		ciudad.setRequired(false);
		ciudad.setShowInBasket(false);
		ciudad.setId(false);
		ciudad.setLength(20);
		ciudad.setGroup("direccionFiscal");
		ciudad.setPersistible(true);	

		imagen.setName("C. P.");
		imagen.setFieldName("cp");
		imagen.setCss("form-control");
		imagen.setOrder(16);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(10);
		imagen.setGroup("direccionFiscal");
		imagen.setPersistible(true);


		estado.setName("Estado");
		estado.setFieldName("estado");
		estado.setCss("form-control");
		estado.setOrder(17);
		estado.setComponentType("selectorEstado");
		estado.setReadOnly(false);
		estado.setHidden(false);
		estado.setRequired(false);
		estado.setShowInBasket(false);
		estado.setId(false);
		estado.setGroup("direccionFiscal");
		estado.setPersistible(true);
		imagen.setLength(255);

		metodopago.setName("Metodo de pago");
		metodopago.setFieldName("metodopago");
		metodopago.setCss("form-control");
		metodopago.setOrder(18);
		metodopago.setComponentType("radio_mpago");
		metodopago.setReadOnly(false);
		metodopago.setHidden(false);
		metodopago.setRequired(false);
		metodopago.setShowInBasket(false);
		metodopago.setId(false);
		metodopago.setGroup("direccionFiscal");
		metodopago.setPersistible(true);
		imagen.setLength(10);

		formapago.setName("Forma de pago");
		formapago.setFieldName("formapago");
		formapago.setCss("form-control");
		formapago.setOrder(19);
		formapago.setComponentType("texto");
		formapago.setReadOnly(false);
		formapago.setHidden(false);
		formapago.setRequired(true);
		formapago.setShowInBasket(false);
		formapago.setId(false);
		formapago.setLength(6);
		formapago.setGroup("pago");
		formapago.setPersistible(false);

		cantidad.setName("Monto");
		cantidad.setFieldName("monto");
		cantidad.setCss("form-control");
		cantidad.setOrder(20);
		cantidad.setComponentType("texto");
		cantidad.setReadOnly(false);
		cantidad.setHidden(false);
		cantidad.setRequired(true);
		cantidad.setShowInBasket(false);
		cantidad.setId(false);
		cantidad.setLength(20);
		cantidad.setGroup("pago");
		cantidad.setPersistible(false);

		fechaPago.setName("Fecha");
		fechaPago.setFieldName("fecha");
		fechaPago.setCss("form-control");
		fechaPago.setOrder(21);
		fechaPago.setComponentType("fecha");
		fechaPago.setReadOnly(false);
		fechaPago.setHidden(false);
		fechaPago.setRequired(true);
		fechaPago.setShowInBasket(false);
		fechaPago.setId(false);
		fechaPago.setLength(10);
		fechaPago.setGroup("pago");
		fechaPago.setPersistible(true);
		fechaPago.setFormat("yyyy-MM-dd");

		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(21);
		obs.setComponentType("texto");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(true);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(20);
		obs.setGroup("pago");
		obs.setPersistible(false);

		subtotal.setName("Subtotal");
		subtotal.setFieldName("subtotal");
		subtotal.setCss("form-control");
		subtotal.setOrder(22);
		subtotal.setComponentType("moneda");
		subtotal.setReadOnly(true);
		subtotal.setHidden(false);
		subtotal.setRequired(true);
		subtotal.setShowInBasket(true);
		subtotal.setId(false);
		subtotal.setLength(20);
		subtotal.setGroup("totales");
		subtotal.setPersistible(false);
		subtotal.setValue("00.00");

		descuento.setName("Descuento");
		descuento.setFieldName("descuento");
		descuento.setCss("form-control");
		descuento.setOrder(23);
		descuento.setComponentType("moneda");
		descuento.setReadOnly(true);
		descuento.setHidden(false);
		descuento.setRequired(true);
		descuento.setShowInBasket(true);
		descuento.setId(false);
		descuento.setLength(20);
		descuento.setGroup("totales");
		descuento.setPersistible(false);
		descuento.setValue("00.00");


		impret.setName("Impuesto retenido");
		impret.setFieldName("impret");
		impret.setCss("form-control");
		impret.setOrder(24);
		impret.setComponentType("moneda");
		impret.setReadOnly(true);
		impret.setHidden(false);
		impret.setRequired(true);
		impret.setShowInBasket(true);
		impret.setId(false);
		impret.setLength(20);
		impret.setGroup("totales");
		impret.setPersistible(false);
		impret.setValue("00.00");

		imptras.setName("Impuesto trasladado");
		imptras.setFieldName("imptras");
		imptras.setCss("form-control");
		imptras.setOrder(25);
		imptras.setComponentType("moneda");
		imptras.setReadOnly(true);
		imptras.setHidden(false);
		imptras.setRequired(true);
		imptras.setShowInBasket(true);
		imptras.setId(false);
		imptras.setLength(20);
		imptras.setGroup("totales");
		imptras.setPersistible(false);
		imptras.setValue("00.00");

		total.setName("Total");
		total.setFieldName("total");
		total.setCss("form-control");
		total.setOrder(26);
		total.setComponentType("moneda");
		total.setReadOnly(true);
		total.setHidden(false);
		total.setRequired(true);
		total.setShowInBasket(true);
		total.setId(false);
		total.setLength(20);
		total.setGroup("totales");
		total.setPersistible(false);
		total.setValue("00.00");
		total.setValidation("(\\+|-)?([0-9]+(\\.[0-9]+))");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(27);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("Nueva");
		status.setValidation("");

		campos.add(status);
		campos.add(total);
		campos.add(impret);
		campos.add(imptras);
		campos.add(descuento);
		campos.add(subtotal);
		campos.add(tipo);
		campos.add(obs);
		campos.add(fechaPago);
		campos.add(cantidad);
		campos.add(formapago);
		campos.add(metodopago);
		campos.add(estado);
		campos.add(ciudad);
		campos.add(poblacion);
		campos.add(municipio);
		campos.add(goles);
		campos.add(puntuacion);
		campos.add(aMaterno);
		//campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(aPaterno);
		campos.add(fNacim);
		campos.add(posicion);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("Guardar");
		forma.setName("documento");
		forma.setView("documento");
		forma.setTitle("Documento");
		forma.setVersion("3.3");
		forma.setStatus("produccion");
		forma.setModule("documentos");
		forma.setBasket("documento");
		forma.setCreateable(false);
		forma.setTable("doctos");
		forma.setValidate(true);

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
	
	@Test
	public void testGuardarFormaCertPrepa() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("prepa.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();
		Field posicion = new Field();
		Field goles = new Field();
		Field puntuacion = new Field();
		Field imagen = new Field();
		Field categoria = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Resource forma = new Resource();
		Field municipio = new Field();
		Field poblacion = new Field();
		Field ciudad = new Field();
		Field estado = new Field();
		Field metodopago = new Field();
		Field formapago = new Field();
		Field cantidad = new Field();
		Field fechaPago = new Field();
		Field obs = new Field();
		Field tipo = new Field();
		Field subtotal = new Field();
		Field descuento = new Field();
		Field imptras = new Field();
		Field impret = new Field();
		Field total = new Field();
		Field status = new Field();


		campoCodigo.setName("Folio interno");
		campoCodigo.setFieldName("CODIGO");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);

		campoCampo.setName("Automatico");
		campoCampo.setFieldName("AUTO");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(2);
		campoCampo.setComponentType("checkbox");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);
		campoCampo.setGroup("cabecero");
		campoCampo.setPersistible(false);

		aMaterno.setName("Version");
		aMaterno.setFieldName("VERSIONSPEC");
		aMaterno.setCss("form-control");
		aMaterno.setOrder(3);
		aMaterno.setComponentType("texto");
		aMaterno.setReadOnly(true);
		aMaterno.setHidden(false);
		aMaterno.setRequired(false);
		aMaterno.setShowInBasket(false);
		aMaterno.setId(false);
		aMaterno.setLength(20);
		aMaterno.setGroup("cabecero");
		aMaterno.setPersistible(true);
		aMaterno.setValue("1.0");

		aPaterno.setName("Tipo certificado");
		aPaterno.setFieldName("TIPOCERT");
		aPaterno.setCss("form-control");
		aPaterno.setOrder(4);
		aPaterno.setComponentType("texto");
		aPaterno.setReadOnly(true);
		aPaterno.setHidden(false);
		aPaterno.setRequired(true);
		aPaterno.setShowInBasket(false);
		aPaterno.setId(false);
		aPaterno.setLength(20);
		aPaterno.setGroup("cabecero");
		aPaterno.setPersistible(true);
		//aPaterno.setValidacion("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		aPaterno.setValue("5");
		aPaterno.setValidation("");


		fNacim.setName("Sello");
		fNacim.setFieldName("SELLO");
		fNacim.setCss("form-control");
		fNacim.setOrder(5);
		fNacim.setComponentType("texto");
		fNacim.setReadOnly(true);
		fNacim.setHidden(false);
		fNacim.setRequired(false);
		fNacim.setShowInBasket(false);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setGroup("cabecero");
		fNacim.setPersistible(true);

		posicion.setName("Certificado responsable");
		posicion.setFieldName("CERTRESP");
		posicion.setCss("form-control");
		posicion.setOrder(6);
		posicion.setComponentType("texto");
		posicion.setReadOnly(true);
		posicion.setHidden(false);
		posicion.setRequired(true);
		posicion.setShowInBasket(false);
		posicion.setId(false);
		posicion.setLength(20);
		posicion.setGroup("cabecero");
		posicion.setPersistible(true);
		//posicion.setValidacion("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		posicion.setValidation("");

		puntuacion.setName("No Certificado responsable");
		puntuacion.setFieldName("NOCERTRESP");
		puntuacion.setCss("form-control");
		puntuacion.setOrder(7);
		puntuacion.setComponentType("texto");
		puntuacion.setReadOnly(false);
		puntuacion.setHidden(false);
		puntuacion.setRequired(true);
		puntuacion.setShowInBasket(false);
		puntuacion.setId(false);
		puntuacion.setLength(20);
		puntuacion.setGroup("cabecero");
		puntuacion.setPersistible(true);
		//puntuacion.setValidacion("[a-zA-Z]");
		puntuacion.setValidation("");

		/*goles.setNombre("Direccion de facturación");
		goles.setBd("DIRFACTURA");
		goles.setCss("form-control");
		goles.setOrden(8);
		goles.setType("selectorDireccion");
		goles.setLectura(false);
		goles.setOculto(false);
		goles.setRequerido(false);
		goles.setLista(false);
		goles.setId(false);
		goles.setGrupo("direccionFiscal");
		goles.setPersistible(false);

		categoria.setNombre("Calle");
		categoria.setBd("CALLE");
		categoria.setCss("form-control");
		categoria.setOrden(10);
		categoria.setType("texto");
		categoria.setLectura(false);
		categoria.setOculto(false);
		categoria.setRequerido(false);
		categoria.setLista(false);
		categoria.setId(false);
		categoria.setLongitud("20");
		categoria.setGrupo("direccionFiscal");
		categoria.setPersistible(true);

		usuario.setNombre("No Int");
		usuario.setBd("NOINT");
		usuario.setCss("form-control");
		usuario.setOrden(11);
		usuario.setType("texto");
		usuario.setLectura(false);
		usuario.setOculto(false);
		usuario.setRequerido(false);
		usuario.setLista(false);
		usuario.setId(false);
		usuario.setLongitud("10");
		usuario.setGrupo("direccionFiscal");
		usuario.setPersistible(true);

		fecha.setNombre("No Ext");
		fecha.setBd("NOEXT");
		fecha.setCss("form-control");
		fecha.setOrden(12);
		fecha.setType("texto");
		fecha.setLectura(false);
		fecha.setOculto(false);
		fecha.setRequerido(false);
		fecha.setLista(false);
		fecha.setId(false);
		fecha.setLongitud("10");
		fecha.setGrupo("direccionFiscal");
		fecha.setPersistible(true);		

		municipio.setNombre("Municipio");
		municipio.setBd("MUNICIPIO");
		municipio.setCss("form-control");
		municipio.setOrden(13);
		municipio.setType("texto");
		municipio.setLectura(false);
		municipio.setOculto(false);
		municipio.setRequerido(false);
		municipio.setLista(false);
		municipio.setId(false);
		municipio.setLongitud("20");
		municipio.setGrupo("direccionFiscal");
		municipio.setPersistible(true);	

		poblacion.setNombre("Población");
		poblacion.setBd("POBLACION");
		poblacion.setCss("form-control");
		poblacion.setOrden(14);
		poblacion.setType("texto");
		poblacion.setLectura(false);
		poblacion.setOculto(false);
		poblacion.setRequerido(false);
		poblacion.setLista(false);
		poblacion.setId(false);
		poblacion.setLongitud("20");
		poblacion.setGrupo("direccionFiscal");
		poblacion.setPersistible(true);		

		ciudad.setNombre("Ciudad");
		ciudad.setBd("CIUDAD");
		ciudad.setCss("form-control");
		ciudad.setOrden(15);
		ciudad.setType("texto");
		ciudad.setLectura(false);
		ciudad.setOculto(false);
		ciudad.setRequerido(false);
		ciudad.setLista(false);
		ciudad.setId(false);
		ciudad.setLongitud("20");
		ciudad.setGrupo("direccionFiscal");
		ciudad.setPersistible(true);	

		imagen.setNombre("C. P.");
		imagen.setBd("CP");
		imagen.setCss("form-control");
		imagen.setOrden(16);
		imagen.setType("texto");
		imagen.setLectura(false);
		imagen.setOculto(false);
		imagen.setRequerido(false);
		imagen.setLista(false);
		imagen.setId(false);
		imagen.setLongitud("10");
		imagen.setGrupo("direccionFiscal");
		imagen.setPersistible(true);


		estado.setNombre("Estado");
		estado.setBd("ESTADO");
		estado.setCss("form-control");
		estado.setOrden(17);
		estado.setType("selectorEstado");
		estado.setLectura(false);
		estado.setOculto(false);
		estado.setRequerido(false);
		estado.setLista(false);
		estado.setId(false);
		estado.setGrupo("direccionFiscal");
		estado.setPersistible(true);

		metodopago.setNombre("Metodo de pago");
		metodopago.setBd("METODOPAGO");
		metodopago.setCss("form-control");
		metodopago.setOrden(18);
		metodopago.setType("radio_mpago");
		metodopago.setLectura(false);
		metodopago.setOculto(false);
		metodopago.setRequerido(false);
		metodopago.setLista(false);
		metodopago.setId(false);
		metodopago.setGrupo("direccionFiscal");
		metodopago.setPersistible(true);

		formapago.setNombre("Forma de pago");
		formapago.setBd("FORMAPAGO");
		formapago.setCss("form-control");
		formapago.setOrden(19);
		formapago.setType("texto");
		formapago.setLectura(false);
		formapago.setOculto(false);
		formapago.setRequerido(true);
		formapago.setLista(false);
		formapago.setId(false);
		formapago.setLongitud("6");
		formapago.setGrupo("pago");
		formapago.setPersistible(false);

		cantidad.setNombre("Monto");
		cantidad.setBd("MONTO");
		cantidad.setCss("form-control");
		cantidad.setOrden(20);
		cantidad.setType("texto");
		cantidad.setLectura(false);
		cantidad.setOculto(false);
		cantidad.setRequerido(true);
		cantidad.setLista(false);
		cantidad.setId(false);
		cantidad.setLongitud("20");
		cantidad.setGrupo("pago");
		cantidad.setPersistible(false);

		fechaPago.setNombre("Fecha");
		fechaPago.setBd("FECHA");
		fechaPago.setCss("form-control");
		fechaPago.setOrden(21);
		fechaPago.setType("fecha");
		fechaPago.setLectura(false);
		fechaPago.setOculto(false);
		fechaPago.setRequerido(true);
		fechaPago.setLista(false);
		fechaPago.setId(false);
		fechaPago.setLongitud("10");
		fechaPago.setGrupo("pago");
		fechaPago.setPersistible(false);

		obs.setNombre("Observaciones");
		obs.setBd("OBS");
		obs.setCss("form-control");
		obs.setOrden(21);
		obs.setType("texto");
		obs.setLectura(false);
		obs.setOculto(false);
		obs.setRequerido(true);
		obs.setLista(false);
		obs.setId(false);
		obs.setLongitud("20");
		obs.setGrupo("pago");
		obs.setPersistible(false);

		tipo.setNombre("Tipo de documento");
		tipo.setBd("TIPO");
		tipo.setCss("form-control");
		tipo.setOrden(0);
		tipo.setType("texto");
		tipo.setLectura(true);
		tipo.setOculto(false);
		tipo.setRequerido(false);
		tipo.setLista(true);
		tipo.setId(false);
		tipo.setLongitud("10");
		tipo.setGrupo("cabecero");
		tipo.setPersistible(true);

		subtotal.setNombre("Subtotal");
		subtotal.setBd("SUBTOTAL");
		subtotal.setCss("form-control");
		subtotal.setOrden(22);
		subtotal.setType("moneda");
		subtotal.setLectura(true);
		subtotal.setOculto(false);
		subtotal.setRequerido(true);
		subtotal.setLista(true);
		subtotal.setId(false);
		subtotal.setLongitud("20");
		subtotal.setGrupo("totales");
		subtotal.setPersistible(false);
		subtotal.setValor("00.00");

		descuento.setNombre("Descuento");
		descuento.setBd("DESCUENTO");
		descuento.setCss("form-control");
		descuento.setOrden(23);
		descuento.setType("moneda");
		descuento.setLectura(true);
		descuento.setOculto(false);
		descuento.setRequerido(true);
		descuento.setLista(true);
		descuento.setId(false);
		descuento.setLongitud("20");
		descuento.setGrupo("totales");
		descuento.setPersistible(false);
		descuento.setValor("00.00");


		impret.setNombre("Impuesto retenido");
		impret.setBd("IMPRET");
		impret.setCss("form-control");
		impret.setOrden(24);
		impret.setType("moneda");
		impret.setLectura(true);
		impret.setOculto(false);
		impret.setRequerido(true);
		impret.setLista(true);
		impret.setId(false);
		impret.setLongitud("20");
		impret.setGrupo("totales");
		impret.setPersistible(false);
		impret.setValor("00.00");

		imptras.setNombre("Impuesto trasladado");
		imptras.setBd("IMPTRAS");
		imptras.setCss("form-control");
		imptras.setOrden(25);
		imptras.setType("moneda");
		imptras.setLectura(true);
		imptras.setOculto(false);
		imptras.setRequerido(true);
		imptras.setLista(true);
		imptras.setId(false);
		imptras.setLongitud("20");
		imptras.setGrupo("totales");
		imptras.setPersistible(false);
		imptras.setValor("00.00");

		total.setNombre("Total");
		total.setBd("TOTAL");
		total.setCss("form-control");
		total.setOrden(26);
		total.setType("moneda");
		total.setLectura(true);
		total.setOculto(false);
		total.setRequerido(true);
		total.setLista(true);
		total.setId(false);
		total.setLongitud("20");
		total.setGrupo("totales");
		total.setPersistible(false);
		total.setValor("00.00");
		total.setValidacion("(\\+|-)?([0-9]+(\\.[0-9]+))");

		status.setNombre("Status");
		status.setBd("STATUS");
		status.setCss("form-control");
		status.setOrden(27);
		status.setType("status");
		status.setLectura(true);
		status.setOculto(false);
		status.setRequerido(true);
		status.setLista(true);
		status.setId(false);
		status.setLongitud("20");
		status.setGrupo("cabecero");
		status.setPersistible(false);
		status.setValor("Nueva");
		status.setValidacion("");*/

		campos.add(status);
		campos.add(total);
		campos.add(impret);
		campos.add(imptras);
		campos.add(descuento);
		campos.add(subtotal);
		campos.add(tipo);
		campos.add(obs);
		campos.add(fechaPago);
		campos.add(cantidad);
		campos.add(formapago);
		campos.add(metodopago);
		campos.add(estado);
		campos.add(ciudad);
		campos.add(poblacion);
		campos.add(municipio);
		campos.add(goles);
		campos.add(puntuacion);
		/*campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(aPaterno);
		campos.add(fNacim);
		campos.add(posicion);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);*/
		forma.setModel(campos);
		forma.setCommandName("Guardar");
		forma.setName("Prepa");
		forma.setView("prepa");
		forma.setTitle("Certificado prepa");
		forma.setVersion("1");
		forma.setStatus("produccion");
		forma.setModule("certificado");
		forma.setBasket("lista");
		forma.setCreateable(true);
		forma.setTable("PREPA");
		forma.setValidate(true);
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

	@Test
	public void testGuardarFormaPPago() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("pago.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field campoCodigo = new Field();
		//Campo campoCampo = new Campo();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();
		Field posicion = new Field();
		Field goles = new Field();
		Field puntuacion = new Field();
		Field imagen = new Field();
		Field categoria = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Resource forma = new Resource();
		Field municipio = new Field();
		Field poblacion = new Field();
		Field ciudad = new Field();
		Field estado = new Field();
		Field metodopago = new Field();
		Field formapago = new Field();
		Field cantidad = new Field();
		Field fechaPago = new Field();
		Field obs = new Field();
		Field tipo = new Field();
		Field subtotal = new Field();
		Field descuento = new Field();
		Field imptras = new Field();
		Field impret = new Field();
		Field total = new Field();
		Field status = new Field();
		Field serie = new Field();

		Button carrito = new Button();
		carrito.setCommandName("nuevo");
		carrito.setName("nuevo");
		carrito.setLabel("Productos/Servicios");
		carrito.setComponentType("location");
		carrito.setCss("btn btn-info");
		carrito.setResourceName("prodserv");
		carrito.setModule("inventario");
		carrito.setOrder(3);
		carrito.setResourceType("basket");
		carrito.setVersion("1.0");
		carrito.setEvents("nuevo");


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-info");
		guardar.setResourceName("ingreso");
		guardar.setModule("comprobantes");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("3.3");
		guardar.setEvents("nuevo");

		Button cancelar = new Button();
		cancelar.setCommandName("cancelar");
		cancelar.setName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("botonjs");
		cancelar.setCss("btn btn-info");
		cancelar.setResourceName("usuario");
		cancelar.setModule("directorio");
		cancelar.setOrder(1);
		cancelar.setResourceType("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvents("detalle");

		Button eliminar = new Button();
		eliminar.setCommandName("actualizar");
		eliminar.setName("actualizar");
		eliminar.setLabel("Actualizar");
		eliminar.setComponentType("botonjs");
		eliminar.setCss("btn btn-info");
		eliminar.setResourceName("ingreso");
		eliminar.setModule("comprobantes");
		eliminar.setOrder(5);
		eliminar.setResourceType("forma");
		eliminar.setVersion("3.3");
		eliminar.setEvents("detalle");

		Button timbrar = new Button();
		timbrar.setCommandName("timbrar");
		timbrar.setName("timbrar");
		timbrar.setLabel("Timbrar");
		timbrar.setComponentType("botonjs");
		timbrar.setCss("btn btn-info");
		timbrar.setResourceName("ingreso");
		timbrar.setModule("comprobantes");
		timbrar.setOrder(6);
		timbrar.setResourceType("forma");
		timbrar.setVersion("3.3");
		timbrar.setEvents("detalle");

		acciones.add(guardar);
		acciones.add(carrito);
		acciones.add(cancelar);
		acciones.add(eliminar);
		acciones.add(timbrar);

		tipo.setName("Tipo de documento");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(false);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("pago");
		tipo.setFormat("");


		campoCodigo.setName("Folio interno");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setFormat("{RFC-TIPO-CONS}");

		/*
		 * campoCampo.setNombre("Automatico"); campoCampo.setBd("AUTO");
		 * campoCampo.setCss("form-control"); campoCampo.setOrden(2);
		 * campoCampo.setType("checkbox"); campoCampo.setLectura(false);
		 * campoCampo.setOculto(false); campoCampo.setRequerido(true);
		 * campoCampo.setLista(true); campoCampo.setId(false);
		 * campoCampo.setGrupo("cabecero"); campoCampo.setPersistible(false);
		 */

		aMaterno.setName("Codigo emisor");
		aMaterno.setFieldName("emisorcodigo");
		aMaterno.setCss("form-control");
		aMaterno.setOrder(3);
		aMaterno.setComponentType("texto");
		aMaterno.setReadOnly(false);
		aMaterno.setHidden(false);
		aMaterno.setRequired(false);
		aMaterno.setShowInBasket(false);
		aMaterno.setId(false);
		aMaterno.setLength(20);
		aMaterno.setGroup("emisor");
		aMaterno.setPersistible(false);
		aMaterno.setFormat("Codigo emisor");

		aPaterno.setName("RFC emisor");
		aPaterno.setFieldName("emisor");
		aPaterno.setCss("form-control");
		aPaterno.setOrder(4);
		aPaterno.setComponentType("texto");
		aPaterno.setReadOnly(false);
		aPaterno.setHidden(false);
		aPaterno.setRequired(true);
		aPaterno.setShowInBasket(false);
		aPaterno.setId(false);
		aPaterno.setLength(20);
		aPaterno.setGroup("emisor");
		aPaterno.setPersistible(true);
		aPaterno.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		aPaterno.setFormat("RFC emisor");

		fNacim.setName("Codigo receptor");
		fNacim.setFieldName("receptorcodigo");
		fNacim.setCss("form-control");
		fNacim.setOrder(5);
		fNacim.setComponentType("texto");
		fNacim.setReadOnly(false);
		fNacim.setHidden(false);
		fNacim.setRequired(false);
		fNacim.setShowInBasket(false);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setGroup("receptor");
		fNacim.setPersistible(false);
		fNacim.setFormat("Codigo receptor");

		posicion.setName("RFC receptor");
		posicion.setFieldName("receptor");
		posicion.setCss("form-control");
		posicion.setOrder(6);
		posicion.setComponentType("texto");
		posicion.setReadOnly(false);
		posicion.setHidden(false);
		posicion.setRequired(true);
		posicion.setShowInBasket(false);
		posicion.setId(false);
		posicion.setLength(20);
		posicion.setGroup("receptor");
		posicion.setPersistible(true);
		posicion.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		posicion.setFormat("RFC receptor");

		puntuacion.setName("Uso CFDi");
		puntuacion.setFieldName("uso");
		puntuacion.setCss("form-control");
		puntuacion.setOrder(7);
		puntuacion.setComponentType("uso");
		puntuacion.setReadOnly(false);
		puntuacion.setHidden(false);
		puntuacion.setRequired(true);
		puntuacion.setShowInBasket(false);
		puntuacion.setId(false);
		puntuacion.setLength(5);
		puntuacion.setGroup("receptor");
		puntuacion.setPersistible(true);
		puntuacion.setValidation("");
		puntuacion.setFormat("Uso CFDi");
		puntuacion.setValue("");

		goles.setName("Direccion de facturación");
		goles.setFieldName("dirfactura");
		goles.setCss("form-control");
		goles.setOrder(8);
		goles.setComponentType("selectorDireccion");
		goles.setReadOnly(false);
		goles.setHidden(false);
		goles.setRequired(false);
		goles.setShowInBasket(false);
		goles.setId(false);
		goles.setLength(20);
		goles.setGroup("direccionFiscal");
		goles.setPersistible(false);
		goles.setFormat("Direccion de facturación");

		categoria.setName("Calle");
		categoria.setFieldName("calle");
		categoria.setCss("form-control");
		categoria.setOrder(10);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(20);
		categoria.setGroup("direccionFiscal");
		categoria.setPersistible(true);
		categoria.setFormat("Calle");

		usuario.setName("No Int");
		usuario.setFieldName("noint");
		usuario.setCss("form-control");
		usuario.setOrder(11);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(10);
		usuario.setGroup("direccionFiscal");
		usuario.setPersistible(true);
		usuario.setFormat("No Int");

		fecha.setName("No Ext");
		fecha.setFieldName("noext");
		fecha.setCss("form-control");
		fecha.setOrder(12);
		fecha.setComponentType("texto");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(10);
		fecha.setGroup("direccionFiscal");
		fecha.setPersistible(true);	
		fecha.setFormat("No Ext");

		municipio.setName("Municipio");
		municipio.setFieldName("municipio");
		municipio.setCss("form-control");
		municipio.setOrder(13);
		municipio.setComponentType("texto");
		municipio.setReadOnly(false);
		municipio.setHidden(false);
		municipio.setRequired(false);
		municipio.setShowInBasket(false);
		municipio.setId(false);
		municipio.setLength(20);
		municipio.setGroup("direccionFiscal");
		municipio.setPersistible(true);	
		municipio.setFormat("Municipio");

		poblacion.setName("Población");
		poblacion.setFieldName("poblacion");
		poblacion.setCss("form-control");
		poblacion.setOrder(14);
		poblacion.setComponentType("texto");
		poblacion.setReadOnly(false);
		poblacion.setHidden(false);
		poblacion.setRequired(false);
		poblacion.setShowInBasket(false);
		poblacion.setId(false);
		poblacion.setLength(20);
		poblacion.setGroup("direccionFiscal");
		poblacion.setPersistible(true);	
		poblacion.setFormat("Población");

		ciudad.setName("Ciudad");
		ciudad.setFieldName("ciudad");
		ciudad.setCss("form-control");
		ciudad.setOrder(15);
		ciudad.setComponentType("texto");
		ciudad.setReadOnly(false);
		ciudad.setHidden(false);
		ciudad.setRequired(false);
		ciudad.setShowInBasket(false);
		ciudad.setId(false);
		ciudad.setLength(20);
		ciudad.setGroup("direccionFiscal");
		ciudad.setPersistible(true);	
		ciudad.setFormat("Ciudad");

		imagen.setName("C. P.");
		imagen.setFieldName("cp");
		imagen.setCss("form-control");
		imagen.setOrder(16);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(10);
		imagen.setGroup("direccionFiscal");
		imagen.setPersistible(true);
		imagen.setFormat("C. P.");


		estado.setName("Estado");
		estado.setFieldName("estado");
		estado.setCss("form-control");
		estado.setOrder(17);
		estado.setComponentType("selectorEstado");
		estado.setReadOnly(false);
		estado.setHidden(false);
		estado.setRequired(false);
		estado.setShowInBasket(false);
		estado.setId(false);
		estado.setGroup("direccionFiscal");
		estado.setPersistible(true);
		estado.setLength(255);
		estado.setFormat("Estado");

		metodopago.setName("Metodo de pago");
		metodopago.setFieldName("metodopago");
		metodopago.setCss("form-control");
		metodopago.setOrder(18);
		metodopago.setComponentType("metodopago");
		metodopago.setReadOnly(false);
		metodopago.setHidden(false);
		metodopago.setRequired(false);
		metodopago.setShowInBasket(false);
		metodopago.setId(false);
		metodopago.setGroup("direccionFiscal");
		metodopago.setPersistible(true);
		metodopago.setLength(10);
		metodopago.setFormat("Metodo de pago");
		metodopago.setValue("");

		formapago.setName("Forma de pago");
		formapago.setFieldName("formapago");
		formapago.setCss("form-control");
		formapago.setOrder(19);
		formapago.setComponentType("formapago");
		formapago.setReadOnly(false);
		formapago.setHidden(false);
		formapago.setRequired(true);
		formapago.setShowInBasket(false);
		formapago.setId(false);
		formapago.setLength(6);
		formapago.setGroup("pago");
		formapago.setPersistible(false);
		formapago.setFormat("Forma de pago");
		formapago.setValue("");

		cantidad.setName("Monto");
		cantidad.setFieldName("monto");
		cantidad.setCss("form-control");
		cantidad.setOrder(20);
		cantidad.setComponentType("texto");
		cantidad.setReadOnly(false);
		cantidad.setHidden(false);
		cantidad.setRequired(true);
		cantidad.setShowInBasket(false);
		cantidad.setId(false);
		cantidad.setLength(20);
		cantidad.setGroup("pago");
		cantidad.setPersistible(false);
		cantidad.setFormat("00.00");

		fechaPago.setName("Fecha");
		fechaPago.setFieldName("fecha");
		fechaPago.setCss("form-control");
		fechaPago.setOrder(21);
		fechaPago.setComponentType("fecha");
		fechaPago.setReadOnly(false);
		fechaPago.setHidden(false);
		fechaPago.setRequired(true);
		fechaPago.setShowInBasket(false);
		fechaPago.setId(false);
		fechaPago.setLength(10);
		fechaPago.setGroup("pago");
		fechaPago.setPersistible(true);
		fechaPago.setFormat("yyyy-MM-dd");

		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(21);
		obs.setComponentType("texto");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(true);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(20);
		obs.setGroup("pago");
		obs.setPersistible(false);
		obs.setFormat("Observaciones");

		subtotal.setName("Subtotal");
		subtotal.setFieldName("subtotal");
		subtotal.setCss("form-control");
		subtotal.setOrder(22);
		subtotal.setComponentType("moneda");
		subtotal.setReadOnly(true);
		subtotal.setHidden(false);
		subtotal.setRequired(true);
		subtotal.setShowInBasket(true);
		subtotal.setId(false);
		subtotal.setLength(20);
		subtotal.setGroup("totales");
		subtotal.setPersistible(false);
		subtotal.setValue("00.00");
		subtotal.setFormat("00.00");

		descuento.setName("Descuento");
		descuento.setFieldName("descuento");
		descuento.setCss("form-control");
		descuento.setOrder(23);
		descuento.setComponentType("moneda");
		descuento.setReadOnly(true);
		descuento.setHidden(false);
		descuento.setRequired(true);
		descuento.setShowInBasket(true);
		descuento.setId(false);
		descuento.setLength(20);
		descuento.setGroup("totales");
		descuento.setPersistible(false);
		descuento.setValue("00.00");
		descuento.setFormat("00.00");


		impret.setName("Impuesto retenido");
		impret.setFieldName("impret");
		impret.setCss("form-control");
		impret.setOrder(24);
		impret.setComponentType("moneda");
		impret.setReadOnly(true);
		impret.setHidden(false);
		impret.setRequired(true);
		impret.setShowInBasket(true);
		impret.setId(false);
		impret.setLength(20);
		impret.setGroup("totales");
		impret.setPersistible(false);
		impret.setValue("00.00");
		impret.setFormat("00.00");

		imptras.setName("Impuesto trasladado");
		imptras.setFieldName("imptras");
		imptras.setCss("form-control");
		imptras.setOrder(25);
		imptras.setComponentType("moneda");
		imptras.setReadOnly(true);
		imptras.setHidden(false);
		imptras.setRequired(true);
		imptras.setShowInBasket(true);
		imptras.setId(false);
		imptras.setLength(20);
		imptras.setGroup("totales");
		imptras.setPersistible(false);
		imptras.setValue("00.00");
		imptras.setFormat("00.00");

		total.setName("Total");
		total.setFieldName("total");
		total.setCss("form-control");
		total.setOrder(26);
		total.setComponentType("moneda");
		total.setReadOnly(true);
		total.setHidden(false);
		total.setRequired(true);
		total.setShowInBasket(true);
		total.setId(false);
		total.setLength(20);
		total.setGroup("totales");
		total.setPersistible(false);
		total.setValue("00.00");
		total.setValidation("[a-zA-Z0-9,.;:_'\\s-]+$");
		total.setFormat("00.00");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(27);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("Nueva");
		status.setValidation("");
		status.setFormat("Status");

		serie.setName("Serie");
		serie.setFieldName("serie");
		serie.setCss("form-control");
		serie.setOrder(28);
		serie.setComponentType("texto");
		serie.setReadOnly(true);
		serie.setHidden(true);
		serie.setRequired(true);
		serie.setShowInBasket(true);
		serie.setId(false);
		serie.setLength(20);
		serie.setGroup("cabecero");
		serie.setPersistible(false);
		serie.setValue("I");
		serie.setValidation("");
		serie.setFormat("Status");

		campos.add(status);
		campos.add(total);
		campos.add(impret);
		campos.add(imptras);
		campos.add(descuento);
		campos.add(subtotal);
		campos.add(tipo);
		campos.add(obs);
		campos.add(fechaPago);
		campos.add(cantidad);
		campos.add(formapago);
		campos.add(metodopago);
		campos.add(estado);
		campos.add(ciudad);
		campos.add(poblacion);
		campos.add(municipio);
		campos.add(goles);
		campos.add(puntuacion);
		campos.add(aMaterno);
		//campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(aPaterno);
		campos.add(fNacim);
		campos.add(posicion);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		campos.add(serie);
		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("Guardar");
		forma.setName("pago");
		forma.setView("pago");
		forma.setTitle("Pago");
		forma.setVersion("3.3");
		forma.setStatus("produccion");
		forma.setModule("comprobantes");
		forma.setBasket("pago");
		forma.setCreateable(false);
		forma.setTable("doctos");
		forma.setValidate(true);
		
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

	@Test
	public void testGuardarFormaGogoRegistro() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("registro.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		Field campoCodigo = new Field();
		Resource forma = new Resource();


		campoCodigo.setName("Folio interno");
		campoCodigo.setFieldName("CODIGO");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(true);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);

		campos.add(campoCodigo);

		forma.setModel(campos);
		forma.setCommandName("Guardar");
		forma.setName("Registro");
		forma.setView("registro");
		forma.setTitle("Registro");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("gogo");
		forma.setBasket("lista");
		forma.setCreateable(true);
		forma.setTable("registro");
		forma.setValidate(true);
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

	@Test
	public void testGuardarFormaCliente() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("cliente.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("cliente");
		guardar.setModule("directorio");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		/*Accion cancelar = new Accion();
		cancelar.setAccion("cancelar");
		cancelar.setNombre("cancelar");
		cancelar.setTitulo("Cancelar");
		cancelar.setType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setForma("cliente");
		cancelar.setModulo("directorio");
		cancelar.setOrden(1);
		cancelar.setTipo("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvento("nuevo");*/


		Button editar = new Button();
		editar.setName("actualizar");
		editar.setLabel("Actualizar");
		editar.setComponentType("botonjs");
		editar.setCss("btn btn-info");
		editar.setResourceName("cliente");
		editar.setModule("directorio");
		editar.setOrder(2);
		editar.setResourceType("forma");
		editar.setVersion("1.0");
		editar.setEvents("detalle");

		Button firmarse = new Button();
		firmarse.setCommandName("contactar");
		firmarse.setName("contactar");
		firmarse.setLabel("Contactar");
		firmarse.setComponentType("submit");
		firmarse.setCss("btn btn-secondary");
		firmarse.setResourceName("cliente");
		firmarse.setModule("directorio");
		firmarse.setOrder(6);
		firmarse.setResourceType("forma");
		firmarse.setVersion("1.0");
		firmarse.setEvents("nuevo");
		firmarse.setView("contactar");

		acciones.add(guardar);
		//acciones.add(cancelar);
		acciones.add(editar);


		Resource forma = new Resource();

		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();

		Field status = new Field();
		Field regimen = new Field();
		Field persona = new Field();
		Field uso = new Field();

		Field rfc = new Field();
		Field curp = new Field();

		Field contacto = new Field();
		Field celular = new Field();
		Field usuario = new Field();
		Field clave = new Field();

		Field vendedor = new Field();
		Field zona = new Field();
		Field lprecios = new Field();

		Field credito = new Field();
		Field tipo = new Field();

		Field idpadre = new Field();
		Field almacen = new Field();
		Field carrito = new Field();

		tipo.setName("Tipo");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setValue("cliente");
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setFormat("");

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(true);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setFormat("{TIPO-CONS}");

		campoCampo.setName("Nombre");
		campoCampo.setFieldName("nombre");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(3);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);
		campoCampo.setLength(150);
		campoCampo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoCampo.setGroup("cabecero");
		campoCampo.setPersistible(true);
		campoCampo.setFormat("Nombre");

		/*
		 * aMaterno.setNombre("A. Materno"); aMaterno.setBd("amaterno");
		 * aMaterno.setCss("form-control"); aMaterno.setOrden(3);
		 * aMaterno.setType("texto"); aMaterno.setLectura(false);
		 * aMaterno.setOculto(false); aMaterno.setRequerido(true);
		 * aMaterno.setLista(true); aMaterno.setId(false); aMaterno.setLongitud(100);
		 * 
		 * aPaterno.setNombre("A. Paterno"); aPaterno.setBd("apaterno");
		 * aPaterno.setCss("form-control"); aPaterno.setOrden(4);
		 * aPaterno.setType("texto"); aPaterno.setLectura(false);
		 * aPaterno.setOculto(false); aPaterno.setRequerido(true);
		 * aPaterno.setLista(true); aPaterno.setId(false); aPaterno.setLongitud(100);
		 */
		fNacim.setName("Fecha de alta");
		fNacim.setFieldName("falta");
		fNacim.setCss("form-control");
		fNacim.setOrder(4);
		fNacim.setComponentType("fecha");
		fNacim.setReadOnly(true);
		fNacim.setHidden(false);
		fNacim.setRequired(true);
		fNacim.setShowInBasket(true);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fNacim.setGroup("cabecero");
		fNacim.setPersistible(true);
		fNacim.setFormat("yyyy-MM-dd");
		fNacim.setValue("${hoyCorto}");


		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(5);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setValue("Activo");
		status.setLength(20);
		status.setValidation("");
		status.setGroup("cabecero");
		status.setPersistible(true);
		status.setFormat("Status");


		regimen.setName("Regimen fiscal");
		regimen.setFieldName("regimen");
		regimen.setCss("form-control");
		regimen.setOrder(6);
		regimen.setComponentType("regimen");
		regimen.setReadOnly(false);
		regimen.setHidden(false);
		regimen.setRequired(true);
		regimen.setShowInBasket(true);
		regimen.setId(false);
		regimen.setLength(3);
		regimen.setValidation("");
		regimen.setGroup("cabecero");
		regimen.setPersistible(true);
		regimen.setFormat("Regimen fiscal");


		persona.setName("Tipo de persona");
		persona.setFieldName("persona");
		persona.setCss("form-control");
		persona.setOrder(7);
		persona.setComponentType("persona");
		persona.setReadOnly(false);
		persona.setHidden(false);
		persona.setRequired(true);
		persona.setShowInBasket(true);
		persona.setId(false);
		persona.setLength(6);
		persona.setValidation("");
		persona.setGroup("cabecero");
		persona.setPersistible(true);
		persona.setFormat("Tipo de persona");

		uso.setName("Uso de comprobantes");
		uso.setFieldName("uso");
		uso.setCss("form-control");
		uso.setOrder(8);
		uso.setComponentType("uso");
		uso.setReadOnly(false);
		uso.setHidden(false);
		uso.setRequired(true);
		uso.setShowInBasket(true);
		uso.setId(false);
		uso.setLength(3);
		uso.setValidation("");
		uso.setGroup("cabecero");
		uso.setPersistible(true);
		uso.setFormat("Uso de comprobantes");

		rfc.setName("RFC");
		rfc.setFieldName("rfc");
		rfc.setCss("form-control");
		rfc.setOrder(9);
		rfc.setComponentType("texto");
		rfc.setReadOnly(false);
		rfc.setHidden(false);
		rfc.setRequired(true);
		rfc.setShowInBasket(true);
		rfc.setId(false);
		rfc.setLength(20);
		rfc.setValidation("");
		rfc.setGroup("cabecero");
		rfc.setPersistible(true);
		rfc.setFormat("RFC");

		curp.setName("CURP");
		curp.setFieldName("curp");
		curp.setCss("form-control");
		curp.setOrder(10);
		curp.setComponentType("texto");
		curp.setReadOnly(false);
		curp.setHidden(false);
		curp.setRequired(false);
		curp.setShowInBasket(true);
		curp.setId(false);
		curp.setLength(18);
		curp.setValidation("");
		curp.setGroup("cabecero");
		curp.setPersistible(true);
		curp.setFormat("CURP");

		contacto.setName("Contacto");
		contacto.setFieldName("contacto");
		contacto.setCss("form-control");
		contacto.setOrder(11);
		contacto.setComponentType("texto");
		contacto.setReadOnly(false);
		contacto.setHidden(false);
		contacto.setRequired(false);
		contacto.setShowInBasket(true);
		contacto.setId(false);
		contacto.setLength(100);
		contacto.setValidation("");
		contacto.setGroup("cabecero");
		contacto.setPersistible(true);
		contacto.setFormat("Contacto");

		celular.setName("No. tel.");
		celular.setFieldName("celular");
		celular.setCss("form-control");
		celular.setOrder(12);
		celular.setComponentType("texto");
		celular.setReadOnly(false);
		celular.setHidden(false);
		celular.setRequired(true);
		celular.setShowInBasket(true);
		celular.setId(false);
		celular.setLength(30);
		celular.setValidation("");
		celular.setGroup("cabecero");
		celular.setPersistible(true);
		celular.setFormat("No. tel.");
		
		usuario.setName("Correo elec.");
		usuario.setFieldName("usuario");
		usuario.setCss("form-control");
		usuario.setOrder(13);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(true);
		usuario.setShowInBasket(true);
		usuario.setId(false);
		usuario.setLength(50);
		usuario.setValidation("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setFormat("Correo elec.");
		usuario.setValue("");

		clave.setName("Clave de acceso");
		clave.setFieldName("clave");
		clave.setCss("form-control");
		clave.setOrder(14);
		clave.setComponentType("texto");
		clave.setReadOnly(false);
		clave.setHidden(false);
		clave.setRequired(true);
		clave.setShowInBasket(true);
		clave.setId(false);
		clave.setLength(10);
		clave.setValidation("");
		clave.setGroup("cabecero");
		clave.setPersistible(true);
		clave.setFormat("Clave de acceso");

		vendedor.setName("Vendedor");
		vendedor.setFieldName("vendedor");
		vendedor.setCss("form-control");
		vendedor.setOrder(15);
		vendedor.setComponentType("texto");
		vendedor.setReadOnly(false);
		vendedor.setHidden(false);
		vendedor.setRequired(false);
		vendedor.setShowInBasket(true);
		vendedor.setId(false);
		vendedor.setLength(10);
		vendedor.setValidation("");
		vendedor.setGroup("cabecero");
		vendedor.setPersistible(true);
		vendedor.setFormat("Vendedor");

		zona.setName("Zona");
		zona.setFieldName("zona");
		zona.setCss("form-control");
		zona.setOrder(16);
		zona.setComponentType("texto");
		zona.setReadOnly(false);
		zona.setHidden(false);
		zona.setRequired(false);
		zona.setShowInBasket(true);
		zona.setId(false);
		zona.setLength(10);
		zona.setValidation("");
		zona.setGroup("cabecero");
		zona.setPersistible(true);
		zona.setFormat("Zona");

		lprecios.setName("Lista de precios");
		lprecios.setFieldName("lprecio");
		lprecios.setCss("form-control");
		lprecios.setOrder(17);
		lprecios.setComponentType("listavalores");
		lprecios.setReadOnly(false);
		lprecios.setHidden(false);
		lprecios.setRequired(true);
		lprecios.setShowInBasket(true);
		lprecios.setId(false);
		lprecios.setLength(20);
		lprecios.setValidation("");
		lprecios.setGroup("cabecero");
		lprecios.setPersistible(true);
		lprecios.setFormat("Lista de precios");
		lprecios.setValue("");
		//lprecios.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"prodserv\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"descripcion\"}]}");
		lprecios.setOrigin("{\"origen\":\"tabla\",\"objeto\":\"lprecio\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");


		credito.setName("Crédito");
		credito.setFieldName("credito");
		credito.setCss("form-control");
		credito.setOrder(18);
		credito.setComponentType("moneda");
		credito.setReadOnly(false);
		credito.setHidden(false);
		credito.setRequired(true);
		credito.setShowInBasket(true);
		credito.setId(false);
		credito.setLength(11);
		credito.setValidation("");
		credito.setGroup("cabecero");
		credito.setPersistible(true);
		credito.setFormat("Crédito");
		credito.setDecimals(2);

		idpadre.setName("Pertenece a empresa");
		idpadre.setFieldName("idpadre");
		idpadre.setCss("form-control");
		idpadre.setOrder(19);
		idpadre.setComponentType("listavalores");
		idpadre.setReadOnly(false);
		idpadre.setHidden(false);
		idpadre.setRequired(false);
		idpadre.setShowInBasket(true);
		idpadre.setId(false);
		idpadre.setLength(10);
		idpadre.setValidation("");
		idpadre.setGroup("cabecero");
		idpadre.setPersistible(true);
		idpadre.setFormat("Pertenece a empresa");
		idpadre.setValue("");
		idpadre.setOrigin("{\"origen\":\"tabla\",\"objeto\":\"dircto\",\"campos\":[{\"nombre\":\"codigo\", \"filtro\":\"\"},{\"nombre\":\"nombre\", \"filtro\":\"\"},{\"nombre\":\"tipo\", \"filtro\":\"empresa\"}]}");

		
		almacen.setName("Almacen");
		almacen.setFieldName("almacen");
		almacen.setCss("form-control");
		almacen.setOrder(20);
		almacen.setComponentType("listavalores");
		almacen.setReadOnly(false);
		almacen.setHidden(false);
		almacen.setRequired(true);
		almacen.setShowInBasket(true);
		almacen.setId(false);
		almacen.setLength(20);
		almacen.setValidation("");
		almacen.setGroup("cabecero");
		almacen.setPersistible(true);
		almacen.setFormat("Almacen");
		almacen.setValue("");
		//lprecios.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"prodserv\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"descripcion\"}]}");
		almacen.setOrigin("{\"origen\":\"tabla\",\"objeto\":\"dircto\",\"campos\":[{\"nombre\":\"codigo\", \"filtro\":\"\"},{\"nombre\":\"nombre\", \"filtro\":\"\"},{\"nombre\":\"tipo\", \"filtro\":\"almacen\"}]}");

		carrito.setName("Carrito");
		carrito.setFieldName("carrito");
		carrito.setCss("form-control");
		carrito.setOrder(21);
		carrito.setComponentType("texto");
		carrito.setReadOnly(true);
		carrito.setHidden(false);
		carrito.setRequired(true);
		carrito.setShowInBasket(true);
		carrito.setId(false);
		carrito.setLength(20);
		carrito.setValidation("");
		carrito.setGroup("cabecero");
		carrito.setPersistible(true);
		carrito.setFormat("carrito");
		carrito.setValue("B2C");
		//lprecios.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"prodserv\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"descripcion\"}]}");
		//carrito.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"dircto\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");
		

		
		//campos.add(aPaterno);
		campos.add(fNacim);
		//campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(status);
		campos.add(regimen);
		campos.add(persona);
		campos.add(uso);
		campos.add(rfc);
		campos.add(curp);

		campos.add(contacto);
		campos.add(celular);
		campos.add(usuario);
		campos.add(clave);

		campos.add(vendedor);
		campos.add(zona);
		campos.add(lprecios);

		campos.add(credito);
		campos.add(tipo);
		campos.add(idpadre);
		campos.add(almacen);
		campos.add(carrito);

		forma.setMethods(acciones);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("cliente");
		forma.setTitle("Cliente");
		forma.setView("cliente");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setBasket("cliente");
		forma.setCreateable(true);
		forma.setTable("dircto");
		forma.setValidate(true);
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

	@Test
	public void testGuardarFormaEmpresa() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("empresa.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("empresa");
		guardar.setModule("directorio");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		/*Accion cancelar = new Accion();
		cancelar.setAccion("cancelar");
		cancelar.setNombre("cancelar");
		cancelar.setTitulo("Cancelar");
		cancelar.setType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setForma("cliente");
		cancelar.setModulo("directorio");
		cancelar.setOrden(1);
		cancelar.setTipo("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvento("nuevo");*/


		Button editar = new Button();
		editar.setName("actualizar");
		editar.setLabel("Actualizar");
		editar.setComponentType("botonjs");
		editar.setCss("btn btn-info");
		editar.setResourceName("empresa");
		editar.setModule("directorio");
		editar.setOrder(2);
		editar.setResourceType("forma");
		editar.setVersion("1.0");
		editar.setEvents("detalle");

		Button firmarse = new Button();
		firmarse.setCommandName("contactar");
		firmarse.setName("contactar");
		firmarse.setLabel("Contactar");
		firmarse.setComponentType("submit");
		firmarse.setCss("btn btn-secondary");
		firmarse.setResourceName("empresa");
		firmarse.setModule("directorio");
		firmarse.setOrder(6);
		firmarse.setResourceType("forma");
		firmarse.setVersion("1.0");
		firmarse.setEvents("nuevo");
		firmarse.setView("contactar");

		acciones.add(guardar);
		//acciones.add(cancelar);
		acciones.add(editar);


		Resource forma = new Resource();

		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();

		Field status = new Field();
		Field regimen = new Field();
		Field persona = new Field();
		Field uso = new Field();

		Field rfc = new Field();
		Field curp = new Field();

		Field contacto = new Field();
		Field celular = new Field();
		Field usuario = new Field();
		Field clave = new Field();

		Field vendedor = new Field();
		Field zona = new Field();
		//Campo lprecios = new Campo();

		Field credito = new Field();
		Field tipo = new Field();

		Field idpadre = new Field();

		tipo.setName("Tipo");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setValue("empresa");
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setFormat("");

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setFormat("{TIPO-CONS}");

		campoCampo.setName("Nombre");
		campoCampo.setFieldName("nombre");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(3);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);
		campoCampo.setLength(150);
		campoCampo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoCampo.setGroup("cabecero");
		campoCampo.setPersistible(true);
		campoCampo.setFormat("Nombre");

		/*
		 * aMaterno.setNombre("A. Materno"); aMaterno.setBd("amaterno");
		 * aMaterno.setCss("form-control"); aMaterno.setOrden(3);
		 * aMaterno.setType("texto"); aMaterno.setLectura(false);
		 * aMaterno.setOculto(false); aMaterno.setRequerido(true);
		 * aMaterno.setLista(true); aMaterno.setId(false); aMaterno.setLongitud(100);
		 * 
		 * aPaterno.setNombre("A. Paterno"); aPaterno.setBd("apaterno");
		 * aPaterno.setCss("form-control"); aPaterno.setOrden(4);
		 * aPaterno.setType("texto"); aPaterno.setLectura(false);
		 * aPaterno.setOculto(false); aPaterno.setRequerido(true);
		 * aPaterno.setLista(true); aPaterno.setId(false); aPaterno.setLongitud(100);
		 */
		fNacim.setName("Fecha de alta");
		fNacim.setFieldName("falta");
		fNacim.setCss("form-control");
		fNacim.setOrder(4);
		fNacim.setComponentType("fecha");
		fNacim.setReadOnly(true);
		fNacim.setHidden(false);
		fNacim.setRequired(true);
		fNacim.setShowInBasket(true);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fNacim.setGroup("cabecero");
		fNacim.setPersistible(true);
		fNacim.setFormat("yyyy-MM-dd");
		fNacim.setValue("${hoyCorto}");


		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(5);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setValue("Activo");
		status.setLength(20);
		status.setValidation("");
		status.setGroup("cabecero");
		status.setPersistible(true);
		status.setFormat("Status");


		regimen.setName("Regimen fiscal");
		regimen.setFieldName("regimen");
		regimen.setCss("form-control");
		regimen.setOrder(6);
		regimen.setComponentType("regimen");
		regimen.setReadOnly(false);
		regimen.setHidden(false);
		regimen.setRequired(true);
		regimen.setShowInBasket(true);
		regimen.setId(false);
		regimen.setLength(3);
		regimen.setValidation("");
		regimen.setGroup("cabecero");
		regimen.setPersistible(true);
		regimen.setFormat("Regimen fiscal");


		persona.setName("Tipo de persona");
		persona.setFieldName("persona");
		persona.setCss("form-control");
		persona.setOrder(7);
		persona.setComponentType("persona");
		persona.setReadOnly(false);
		persona.setHidden(false);
		persona.setRequired(true);
		persona.setShowInBasket(true);
		persona.setId(false);
		persona.setLength(6);
		persona.setValidation("");
		persona.setGroup("cabecero");
		persona.setPersistible(true);
		persona.setFormat("Tipo de persona");

		uso.setName("Uso de comprobantes");
		uso.setFieldName("uso");
		uso.setCss("form-control");
		uso.setOrder(8);
		uso.setComponentType("uso");
		uso.setReadOnly(false);
		uso.setHidden(false);
		uso.setRequired(true);
		uso.setShowInBasket(true);
		uso.setId(false);
		uso.setLength(3);
		uso.setValidation("");
		uso.setGroup("cabecero");
		uso.setPersistible(true);
		uso.setFormat("Uso de comprobantes");

		rfc.setName("RFC");
		rfc.setFieldName("rfc");
		rfc.setCss("form-control");
		rfc.setOrder(9);
		rfc.setComponentType("texto");
		rfc.setReadOnly(false);
		rfc.setHidden(false);
		rfc.setRequired(true);
		rfc.setShowInBasket(true);
		rfc.setId(false);
		rfc.setLength(20);
		rfc.setValidation("");
		rfc.setGroup("cabecero");
		rfc.setPersistible(true);
		rfc.setFormat("RFC");

		curp.setName("CURP");
		curp.setFieldName("curp");
		curp.setCss("form-control");
		curp.setOrder(10);
		curp.setComponentType("texto");
		curp.setReadOnly(false);
		curp.setHidden(false);
		curp.setRequired(false);
		curp.setShowInBasket(true);
		curp.setId(false);
		curp.setLength(18);
		curp.setValidation("");
		curp.setGroup("cabecero");
		curp.setPersistible(true);
		curp.setFormat("CURP");

		contacto.setName("Contacto");
		contacto.setFieldName("contacto");
		contacto.setCss("form-control");
		contacto.setOrder(11);
		contacto.setComponentType("texto");
		contacto.setReadOnly(false);
		contacto.setHidden(false);
		contacto.setRequired(false);
		contacto.setShowInBasket(true);
		contacto.setId(false);
		contacto.setLength(100);
		contacto.setValidation("");
		contacto.setGroup("cabecero");
		contacto.setPersistible(true);
		contacto.setFormat("Contacto");

		celular.setName("No. tel.");
		celular.setFieldName("celular");
		celular.setCss("form-control");
		celular.setOrder(12);
		celular.setComponentType("texto");
		celular.setReadOnly(false);
		celular.setHidden(false);
		celular.setRequired(true);
		celular.setShowInBasket(true);
		celular.setId(false);
		celular.setLength(30);
		celular.setValidation("");
		celular.setGroup("cabecero");
		celular.setPersistible(true);
		celular.setFormat("No. tel.");
		
		usuario.setName("Correo elec.");
		usuario.setFieldName("usuario");
		usuario.setCss("form-control");
		usuario.setOrder(13);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(true);
		usuario.setShowInBasket(true);
		usuario.setId(false);
		usuario.setLength(50);
		usuario.setValidation("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setFormat("Correo elec.");
		usuario.setValue("");

		clave.setName("Clave de acceso");
		clave.setFieldName("clave");
		clave.setCss("form-control");
		clave.setOrder(14);
		clave.setComponentType("texto");
		clave.setReadOnly(false);
		clave.setHidden(false);
		clave.setRequired(true);
		clave.setShowInBasket(true);
		clave.setId(false);
		clave.setLength(10);
		clave.setValidation("");
		clave.setGroup("cabecero");
		clave.setPersistible(true);
		clave.setFormat("Clave de acceso");

		vendedor.setName("Vendedor");
		vendedor.setFieldName("vendedor");
		vendedor.setCss("form-control");
		vendedor.setOrder(15);
		vendedor.setComponentType("texto");
		vendedor.setReadOnly(false);
		vendedor.setHidden(false);
		vendedor.setRequired(false);
		vendedor.setShowInBasket(true);
		vendedor.setId(false);
		vendedor.setLength(10);
		vendedor.setValidation("");
		vendedor.setGroup("cabecero");
		vendedor.setPersistible(true);
		vendedor.setFormat("Vendedor");

		zona.setName("Zona");
		zona.setFieldName("zona");
		zona.setCss("form-control");
		zona.setOrder(16);
		zona.setComponentType("texto");
		zona.setReadOnly(false);
		zona.setHidden(false);
		zona.setRequired(false);
		zona.setShowInBasket(true);
		zona.setId(false);
		zona.setLength(10);
		zona.setValidation("");
		zona.setGroup("cabecero");
		zona.setPersistible(true);
		zona.setFormat("Zona");

		/*lprecios.setNombre("Lista de precios");
		lprecios.setBd("lprecio");
		lprecios.setCss("form-control");
		lprecios.setOrden(17);
		lprecios.setType("lprecio");
		lprecios.setLectura(false);
		lprecios.setOculto(false);
		lprecios.setRequerido(true);
		lprecios.setLista(true);
		lprecios.setId(false);
		lprecios.setLongitud(20);
		lprecios.setValidacion("");
		lprecios.setGrupo("cabecero");
		lprecios.setPersistible(true);
		lprecios.setAutogenerado(false);
		lprecios.setFormato("Lista de precios");
		lprecios.setValor("");
		//lprecios.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"prodserv\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"descripcion\"}]}");
		lprecios.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"lprecio\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");
*/

		credito.setName("Crédito");
		credito.setFieldName("credito");
		credito.setCss("form-control");
		credito.setOrder(18);
		credito.setComponentType("moneda");
		credito.setReadOnly(false);
		credito.setHidden(false);
		credito.setRequired(true);
		credito.setShowInBasket(true);
		credito.setId(false);
		credito.setLength(10);
		credito.setValidation("");
		credito.setGroup("cabecero");
		credito.setPersistible(true);
		credito.setFormat("Crédito");

		idpadre.setName("Pertenece a Organizacion");
		idpadre.setFieldName("idpadre");
		idpadre.setCss("form-control");
		idpadre.setOrder(19);
		idpadre.setComponentType("texto");
		idpadre.setReadOnly(false);
		idpadre.setHidden(false);
		idpadre.setRequired(false);
		idpadre.setShowInBasket(true);
		idpadre.setId(false);
		idpadre.setLength(10);
		idpadre.setValidation("");
		idpadre.setGroup("cabecero");
		idpadre.setPersistible(true);
		idpadre.setFormat("Organizacion");
		idpadre.setValue("");
		
		//campos.add(aPaterno);
		campos.add(fNacim);
		//campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(status);
		campos.add(regimen);
		campos.add(persona);
		campos.add(uso);
		campos.add(rfc);
		campos.add(curp);

		campos.add(contacto);
		campos.add(celular);
		campos.add(usuario);
		campos.add(clave);

		campos.add(vendedor);
		campos.add(zona);
		//campos.add(lprecios);

		campos.add(credito);
		campos.add(tipo);
		campos.add(idpadre);


		forma.setMethods(acciones);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("empresa");
		forma.setTitle("Empresa");
		forma.setView("empresa");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setBasket("empresa");
		forma.setCreateable(true);
		forma.setTable("dircto");
		forma.setValidate(true);
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
	
	@Test
	public void testGuardarFormaMensaje() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("mensaje.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("mensaje");
		guardar.setModule("solicitud");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		/*Accion cancelar = new Accion();
		cancelar.setAccion("cancelar");
		cancelar.setNombre("cancelar");
		cancelar.setTitulo("Cancelar");
		cancelar.setType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setForma("cliente");
		cancelar.setModulo("directorio");
		cancelar.setOrden(1);
		cancelar.setTipo("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvento("nuevo");*/


		Button editar = new Button();
		editar.setName("actualizar");
		editar.setLabel("Actualizar");
		editar.setComponentType("botonjs");
		editar.setCss("btn btn-info");
		editar.setResourceName("empresa");
		editar.setModule("directorio");
		editar.setOrder(2);
		editar.setResourceType("forma");
		editar.setVersion("1.0");
		editar.setEvents("detalle");

		Button firmarse = new Button();
		firmarse.setCommandName("contactar");
		firmarse.setName("contactar");
		firmarse.setLabel("Contactar");
		firmarse.setComponentType("submit");
		firmarse.setCss("btn btn-secondary");
		firmarse.setResourceName("empresa");
		firmarse.setModule("directorio");
		firmarse.setOrder(6);
		firmarse.setResourceType("forma");
		firmarse.setVersion("1.0");
		firmarse.setEvents("nuevo");
		firmarse.setView("contactar");

		acciones.add(guardar);
		//acciones.add(cancelar);
		acciones.add(editar);


		Resource forma = new Resource();

		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();

		Field status = new Field();
		Field regimen = new Field();
		Field persona = new Field();
		Field uso = new Field();

		Field rfc = new Field();
		Field curp = new Field();

		Field contacto = new Field();
		Field celular = new Field();
		Field usuario = new Field();
		Field clave = new Field();

		Field vendedor = new Field();
		Field zona = new Field();
		//Campo lprecios = new Campo();

		Field credito = new Field();
		Field campoComs = new Field();
		
		Field tipo = new Field();

		Field idpadre = new Field();

		tipo.setName("Tipo");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setValue("mensaje");
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setFormat("");

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setFormat("{TIPO-CONS}");

		campoCampo.setName("Nombre");
		campoCampo.setFieldName("nombre");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(3);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);
		campoCampo.setLength(150);
		campoCampo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoCampo.setGroup("cabecero");
		campoCampo.setPersistible(true);
		campoCampo.setFormat("Nombre");

		/*
		 * aMaterno.setNombre("A. Materno"); aMaterno.setBd("amaterno");
		 * aMaterno.setCss("form-control"); aMaterno.setOrden(3);
		 * aMaterno.setType("texto"); aMaterno.setLectura(false);
		 * aMaterno.setOculto(false); aMaterno.setRequerido(true);
		 * aMaterno.setLista(true); aMaterno.setId(false); aMaterno.setLongitud(100);
		 * 
		 * aPaterno.setNombre("A. Paterno"); aPaterno.setBd("apaterno");
		 * aPaterno.setCss("form-control"); aPaterno.setOrden(4);
		 * aPaterno.setType("texto"); aPaterno.setLectura(false);
		 * aPaterno.setOculto(false); aPaterno.setRequerido(true);
		 * aPaterno.setLista(true); aPaterno.setId(false); aPaterno.setLongitud(100);
		 */
		fNacim.setName("Fecha de alta");
		fNacim.setFieldName("falta");
		fNacim.setCss("form-control");
		fNacim.setOrder(4);
		fNacim.setComponentType("fecha");
		fNacim.setReadOnly(true);
		fNacim.setHidden(false);
		fNacim.setRequired(true);
		fNacim.setShowInBasket(true);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fNacim.setGroup("cabecero");
		fNacim.setPersistible(true);
		fNacim.setFormat("yyyy-MM-dd");
		fNacim.setValue("${hoyCorto}");


		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(5);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setValue("Activo");
		status.setLength(20);
		status.setValidation("");
		status.setGroup("cabecero");
		status.setPersistible(true);
		status.setFormat("Status");


		regimen.setName("Regimen fiscal");
		regimen.setFieldName("regimen");
		regimen.setCss("form-control");
		regimen.setOrder(6);
		regimen.setComponentType("regimen");
		regimen.setReadOnly(false);
		regimen.setHidden(false);
		regimen.setRequired(true);
		regimen.setShowInBasket(true);
		regimen.setId(false);
		regimen.setLength(3);
		regimen.setValidation("");
		regimen.setGroup("cabecero");
		regimen.setPersistible(true);
		regimen.setFormat("Regimen fiscal");


		persona.setName("Tipo de persona");
		persona.setFieldName("persona");
		persona.setCss("form-control");
		persona.setOrder(7);
		persona.setComponentType("persona");
		persona.setReadOnly(false);
		persona.setHidden(false);
		persona.setRequired(true);
		persona.setShowInBasket(true);
		persona.setId(false);
		persona.setLength(6);
		persona.setValidation("");
		persona.setGroup("cabecero");
		persona.setPersistible(true);
		persona.setFormat("Tipo de persona");

		uso.setName("Uso de comprobantes");
		uso.setFieldName("uso");
		uso.setCss("form-control");
		uso.setOrder(8);
		uso.setComponentType("uso");
		uso.setReadOnly(false);
		uso.setHidden(false);
		uso.setRequired(true);
		uso.setShowInBasket(true);
		uso.setId(false);
		uso.setLength(3);
		uso.setValidation("");
		uso.setGroup("cabecero");
		uso.setPersistible(true);
		uso.setFormat("Uso de comprobantes");

		rfc.setName("RFC");
		rfc.setFieldName("rfc");
		rfc.setCss("form-control");
		rfc.setOrder(9);
		rfc.setComponentType("texto");
		rfc.setReadOnly(false);
		rfc.setHidden(false);
		rfc.setRequired(true);
		rfc.setShowInBasket(true);
		rfc.setId(false);
		rfc.setLength(20);
		rfc.setValidation("");
		rfc.setGroup("cabecero");
		rfc.setPersistible(true);
		rfc.setFormat("RFC");

		curp.setName("CURP");
		curp.setFieldName("curp");
		curp.setCss("form-control");
		curp.setOrder(10);
		curp.setComponentType("texto");
		curp.setReadOnly(false);
		curp.setHidden(false);
		curp.setRequired(false);
		curp.setShowInBasket(true);
		curp.setId(false);
		curp.setLength(18);
		curp.setValidation("");
		curp.setGroup("cabecero");
		curp.setPersistible(true);
		curp.setFormat("CURP");

		contacto.setName("Contacto");
		contacto.setFieldName("contacto");
		contacto.setCss("form-control");
		contacto.setOrder(11);
		contacto.setComponentType("texto");
		contacto.setReadOnly(false);
		contacto.setHidden(false);
		contacto.setRequired(false);
		contacto.setShowInBasket(true);
		contacto.setId(false);
		contacto.setLength(100);
		contacto.setValidation("");
		contacto.setGroup("cabecero");
		contacto.setPersistible(true);
		contacto.setFormat("Contacto");

		celular.setName("No. tel.");
		celular.setFieldName("celular");
		celular.setCss("form-control");
		celular.setOrder(12);
		celular.setComponentType("texto");
		celular.setReadOnly(false);
		celular.setHidden(false);
		celular.setRequired(true);
		celular.setShowInBasket(true);
		celular.setId(false);
		celular.setLength(30);
		celular.setValidation("");
		celular.setGroup("cabecero");
		celular.setPersistible(true);
		celular.setFormat("No. tel.");
		
		usuario.setName("Correo elec.");
		usuario.setFieldName("usuario");
		usuario.setCss("form-control");
		usuario.setOrder(13);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(true);
		usuario.setShowInBasket(true);
		usuario.setId(false);
		usuario.setLength(50);
		usuario.setValidation("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setFormat("Correo elec.");
		usuario.setValue("");

		clave.setName("Clave de acceso");
		clave.setFieldName("clave");
		clave.setCss("form-control");
		clave.setOrder(14);
		clave.setComponentType("texto");
		clave.setReadOnly(false);
		clave.setHidden(false);
		clave.setRequired(true);
		clave.setShowInBasket(true);
		clave.setId(false);
		clave.setLength(10);
		clave.setValidation("");
		clave.setGroup("cabecero");
		clave.setPersistible(true);
		clave.setFormat("Clave de acceso");

		vendedor.setName("Vendedor");
		vendedor.setFieldName("vendedor");
		vendedor.setCss("form-control");
		vendedor.setOrder(15);
		vendedor.setComponentType("texto");
		vendedor.setReadOnly(false);
		vendedor.setHidden(false);
		vendedor.setRequired(false);
		vendedor.setShowInBasket(true);
		vendedor.setId(false);
		vendedor.setLength(10);
		vendedor.setValidation("");
		vendedor.setGroup("cabecero");
		vendedor.setPersistible(true);
		vendedor.setFormat("Vendedor");

		zona.setName("Zona");
		zona.setFieldName("zona");
		zona.setCss("form-control");
		zona.setOrder(16);
		zona.setComponentType("texto");
		zona.setReadOnly(false);
		zona.setHidden(false);
		zona.setRequired(false);
		zona.setShowInBasket(true);
		zona.setId(false);
		zona.setLength(10);
		zona.setValidation("");
		zona.setGroup("cabecero");
		zona.setPersistible(true);
		zona.setFormat("Zona");

		/*lprecios.setNombre("Lista de precios");
		lprecios.setBd("lprecio");
		lprecios.setCss("form-control");
		lprecios.setOrden(17);
		lprecios.setType("lprecio");
		lprecios.setLectura(false);
		lprecios.setOculto(false);
		lprecios.setRequerido(true);
		lprecios.setLista(true);
		lprecios.setId(false);
		lprecios.setLongitud(20);
		lprecios.setValidacion("");
		lprecios.setGrupo("cabecero");
		lprecios.setPersistible(true);
		lprecios.setAutogenerado(false);
		lprecios.setFormato("Lista de precios");
		lprecios.setValor("");
		//lprecios.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"prodserv\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"descripcion\"}]}");
		lprecios.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"lprecio\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");
*/

		credito.setName("Crédito");
		credito.setFieldName("credito");
		credito.setCss("form-control");
		credito.setOrder(18);
		credito.setComponentType("moneda");
		credito.setReadOnly(false);
		credito.setHidden(false);
		credito.setRequired(true);
		credito.setShowInBasket(true);
		credito.setId(false);
		credito.setLength(10);
		credito.setValidation("");
		credito.setGroup("cabecero");
		credito.setPersistible(true);
		credito.setFormat("Crédito");

		/*idpadre.setNombre("Pertenece a Organizacion");
		idpadre.setBd("idpadre");
		idpadre.setCss("form-control");
		idpadre.setOrden(19);
		idpadre.setType("texto");
		idpadre.setLectura(false);
		idpadre.setOculto(false);
		idpadre.setRequerido(false);
		idpadre.setLista(true);
		idpadre.setId(false);
		idpadre.setLongitud(10);
		idpadre.setValidacion("");
		idpadre.setGrupo("cabecero");
		idpadre.setPersistible(true);
		idpadre.setFormato("Organizacion");
		idpadre.setValor("");*/
		
		
		campoComs.setName("Comentarios");
		campoComs.setFieldName("comentarios");
		campoComs.setCss("form-control");
		campoComs.setOrder(19);
		campoComs.setComponentType("textoarea");
		campoComs.setReadOnly(false);
		campoComs.setHidden(false);
		campoComs.setRequired(false);
		campoComs.setShowInBasket(true);
		campoComs.setId(false);
		campoComs.setLength(250);
		campoComs.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		//campoComs.setGrupo("cantidades");
		campoComs.setGroup("cabecero");
		campoComs.setPersistible(true);
		campoComs.setFormat("Comentarios");
		campoComs.setValue("");
		
		//campos.add(aPaterno);
		campos.add(fNacim);
		//campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(status);
		//campos.add(regimen);
		//campos.add(persona);
		//campos.add(uso);
		//campos.add(rfc);
		//campos.add(curp);

		campos.add(contacto);
		campos.add(celular);
		campos.add(usuario);
		//campos.add(clave);

		//campos.add(vendedor);
		//campos.add(zona);
		//campos.add(lprecios);

		campos.add(campoComs);
		campos.add(tipo);
		//campos.add(idpadre);


		forma.setMethods(acciones);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("mensaje");
		forma.setTitle("Mensaje");
		forma.setView("mensaje");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("solicitud");
		forma.setBasket("mensaje");
		forma.setCreateable(true);
		forma.setTable("mensaje");
		forma.setValidate(true);
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
	
	@Test
	public void testGuardarFormaConfiguracion() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("configuracion.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("configuracion");
		guardar.setModule("sistema");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		/*Accion cancelar = new Accion();
		cancelar.setAccion("cancelar");
		cancelar.setNombre("cancelar");
		cancelar.setTitulo("Cancelar");
		cancelar.setType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setForma("cliente");
		cancelar.setModulo("directorio");
		cancelar.setOrden(1);
		cancelar.setTipo("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvento("nuevo");*/


		Button editar = new Button();
		editar.setName("actualizar");
		editar.setLabel("Actualizar");
		editar.setComponentType("botonjs");
		editar.setCss("btn btn-info");
		editar.setResourceName("configuracion");
		editar.setModule("sistema");
		editar.setOrder(2);
		editar.setResourceType("forma");
		editar.setVersion("1.0");
		editar.setEvents("detalle");

		Button firmarse = new Button();
		firmarse.setCommandName("contactar");
		firmarse.setName("contactar");
		firmarse.setLabel("Contactar");
		firmarse.setComponentType("submit");
		firmarse.setCss("btn btn-secondary");
		firmarse.setResourceName("empresa");
		firmarse.setModule("sistema");
		firmarse.setOrder(6);
		firmarse.setResourceType("forma");
		firmarse.setVersion("1.0");
		firmarse.setEvents("nuevo");
		firmarse.setView("contactar");

		acciones.add(guardar);
		//acciones.add(cancelar);
		acciones.add(editar);


		Resource forma = new Resource();

		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field campollave = new Field();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();

		Field status = new Field();
		Field regimen = new Field();
		Field persona = new Field();
		Field uso = new Field();

		Field rfc = new Field();
		Field curp = new Field();

		Field contacto = new Field();
		Field celular = new Field();
		Field usuario = new Field();
		Field clave = new Field();

		Field vendedor = new Field();
		Field zona = new Field();
		//Campo lprecios = new Campo();

		Field credito = new Field();
		Field campoComs = new Field();
		
		Field tipo = new Field();

		Field idpadre = new Field();

		tipo.setName("Tipo");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setValue("configuracion");
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setFormat("");

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setFormat("{TIPO-CONS}");

		campoCampo.setName("Certificado");
		campoCampo.setFieldName("certificado");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(3);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);
		campoCampo.setLength(150);
		campoCampo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoCampo.setGroup("cabecero");
		campoCampo.setPersistible(true);
		campoCampo.setFormat("Certificado");

		campollave.setName("Llave");
		campollave.setFieldName("llave");
		campollave.setCss("form-control");
		campollave.setOrder(3);
		campollave.setComponentType("texto");
		campollave.setReadOnly(false);
		campollave.setHidden(false);
		campollave.setRequired(true);
		campollave.setShowInBasket(true);
		campollave.setId(false);
		campollave.setLength(150);
		campollave.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campollave.setGroup("cabecero");
		campollave.setPersistible(true);
		campollave.setFormat("Llave");
		
		/*
		 * aMaterno.setNombre("A. Materno"); aMaterno.setBd("amaterno");
		 * aMaterno.setCss("form-control"); aMaterno.setOrden(3);
		 * aMaterno.setType("texto"); aMaterno.setLectura(false);
		 * aMaterno.setOculto(false); aMaterno.setRequerido(true);
		 * aMaterno.setLista(true); aMaterno.setId(false); aMaterno.setLongitud(100);
		 * 
		 * aPaterno.setNombre("A. Paterno"); aPaterno.setBd("apaterno");
		 * aPaterno.setCss("form-control"); aPaterno.setOrden(4);
		 * aPaterno.setType("texto"); aPaterno.setLectura(false);
		 * aPaterno.setOculto(false); aPaterno.setRequerido(true);
		 * aPaterno.setLista(true); aPaterno.setId(false); aPaterno.setLongitud(100);
		 */
		fNacim.setName("Fecha de alta");
		fNacim.setFieldName("falta");
		fNacim.setCss("form-control");
		fNacim.setOrder(4);
		fNacim.setComponentType("fecha");
		fNacim.setReadOnly(true);
		fNacim.setHidden(false);
		fNacim.setRequired(true);
		fNacim.setShowInBasket(true);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fNacim.setGroup("cabecero");
		fNacim.setPersistible(true);
		fNacim.setFormat("yyyy-MM-dd");
		fNacim.setValue("${hoyCorto}");


		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(5);
		status.setComponentType("texto");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setValue("Activo");
		status.setLength(20);
		status.setValidation("");
		//status.setValidacion("^[a-zA-Z0-9,.;:_'\\s-]+$");
		status.setGroup("cabecero");
		status.setPersistible(true);
		status.setFormat("Status");


		regimen.setName("Regimen fiscal");
		regimen.setFieldName("regimen");
		regimen.setCss("form-control");
		regimen.setOrder(6);
		regimen.setComponentType("regimen");
		regimen.setReadOnly(false);
		regimen.setHidden(false);
		regimen.setRequired(true);
		regimen.setShowInBasket(true);
		regimen.setId(false);
		regimen.setLength(3);
		regimen.setValidation("");
		regimen.setGroup("cabecero");
		regimen.setPersistible(true);
		regimen.setFormat("Regimen fiscal");


		persona.setName("Tipo de persona");
		persona.setFieldName("persona");
		persona.setCss("form-control");
		persona.setOrder(7);
		persona.setComponentType("persona");
		persona.setReadOnly(false);
		persona.setHidden(false);
		persona.setRequired(true);
		persona.setShowInBasket(true);
		persona.setId(false);
		persona.setLength(6);
		persona.setValidation("");
		persona.setGroup("cabecero");
		persona.setPersistible(true);
		persona.setFormat("Tipo de persona");

		uso.setName("Uso de comprobantes");
		uso.setFieldName("uso");
		uso.setCss("form-control");
		uso.setOrder(8);
		uso.setComponentType("uso");
		uso.setReadOnly(false);
		uso.setHidden(false);
		uso.setRequired(true);
		uso.setShowInBasket(true);
		uso.setId(false);
		uso.setLength(3);
		uso.setValidation("");
		uso.setGroup("cabecero");
		uso.setPersistible(true);
		uso.setFormat("Uso de comprobantes");

		rfc.setName("RFC");
		rfc.setFieldName("rfc");
		rfc.setCss("form-control");
		rfc.setOrder(9);
		rfc.setComponentType("texto");
		rfc.setReadOnly(false);
		rfc.setHidden(false);
		rfc.setRequired(true);
		rfc.setShowInBasket(true);
		rfc.setId(false);
		rfc.setLength(20);
		rfc.setValidation("");
		rfc.setGroup("cabecero");
		rfc.setPersistible(true);
		rfc.setFormat("RFC");

		curp.setName("CURP");
		curp.setFieldName("curp");
		curp.setCss("form-control");
		curp.setOrder(10);
		curp.setComponentType("texto");
		curp.setReadOnly(false);
		curp.setHidden(false);
		curp.setRequired(false);
		curp.setShowInBasket(true);
		curp.setId(false);
		curp.setLength(18);
		curp.setValidation("");
		curp.setGroup("cabecero");
		curp.setPersistible(true);
		curp.setFormat("CURP");

		contacto.setName("Contacto");
		contacto.setFieldName("contacto");
		contacto.setCss("form-control");
		contacto.setOrder(11);
		contacto.setComponentType("texto");
		contacto.setReadOnly(false);
		contacto.setHidden(false);
		contacto.setRequired(false);
		contacto.setShowInBasket(true);
		contacto.setId(false);
		contacto.setLength(100);
		contacto.setValidation("");
		contacto.setGroup("cabecero");
		contacto.setPersistible(true);
		contacto.setFormat("Contacto");

		
		/*lprecios.setNombre("Lista de precios");
		lprecios.setBd("lprecio");
		lprecios.setCss("form-control");
		lprecios.setOrden(17);
		lprecios.setType("lprecio");
		lprecios.setLectura(false);
		lprecios.setOculto(false);
		lprecios.setRequerido(true);
		lprecios.setLista(true);
		lprecios.setId(false);
		lprecios.setLongitud(20);
		lprecios.setValidacion("");
		lprecios.setGrupo("cabecero");
		lprecios.setPersistible(true);
		lprecios.setFormato("Lista de precios");
		lprecios.setValor("");
		//lprecios.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"prodserv\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"descripcion\"}]}");
		lprecios.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"lprecio\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");
*/


		/*idpadre.setNombre("Pertenece a Organizacion");
		idpadre.setBd("idpadre");
		idpadre.setCss("form-control");
		idpadre.setOrden(19);
		idpadre.setType("texto");
		idpadre.setLectura(false);
		idpadre.setOculto(false);
		idpadre.setRequerido(false);
		idpadre.setLista(true);
		idpadre.setId(false);
		idpadre.setLongitud(10);
		idpadre.setValidacion("");
		idpadre.setGrupo("cabecero");
		idpadre.setPersistible(true);
		idpadre.setFormato("Organizacion");
		idpadre.setValor("");*/
		
		
		campoComs.setName("Comentarios");
		campoComs.setFieldName("comentarios");
		campoComs.setCss("form-control");
		campoComs.setOrder(19);
		campoComs.setComponentType("textoarea");
		campoComs.setReadOnly(false);
		campoComs.setHidden(false);
		campoComs.setRequired(false);
		campoComs.setShowInBasket(true);
		campoComs.setId(false);
		campoComs.setLength(10);
		campoComs.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		//campoComs.setGrupo("cantidades");
		campoComs.setGroup("cabecero");
		campoComs.setPersistible(true);
		campoComs.setFormat("Comentarios");
		campoComs.setValue("");
		
		//campos.add(aPaterno);
		campos.add(fNacim);
		//campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campollave);
		campos.add(campoCodigo);
		campos.add(status);
		//campos.add(regimen);
		//campos.add(persona);
		//campos.add(uso);
		//campos.add(rfc);
		//campos.add(curp);

		campos.add(contacto);
		//campos.add(celular);
		//campos.add(usuario);
		//campos.add(clave);

		//campos.add(vendedor);
		//campos.add(zona);
		//campos.add(lprecios);

		//campos.add(campoComs);
		campos.add(tipo);
		//campos.add(idpadre);


		forma.setMethods(acciones);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("configuracion");
		forma.setTitle("Configuracion");
		forma.setView("configuracion");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("sistema");
		forma.setBasket("configuracion");
		forma.setCreateable(true);
		forma.setTable("config");
		forma.setValidate(true);
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
	
	
	@Test
	public void testGuardarFormaUsuario() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("usuario.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("usuario");
		guardar.setModule("directorio");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button cancelar = new Button();
		cancelar.setCommandName("nuevo");
		cancelar.setName("nuevo");
		cancelar.setLabel("Directorio");
		cancelar.setComponentType("location");
		cancelar.setCss("btn btn-secondary");
		cancelar.setResourceName("directorio");
		cancelar.setModule("directorio");
		cancelar.setOrder(1);
		cancelar.setResourceType("basket");
		cancelar.setVersion("1.0");
		cancelar.setEvents("nuevo,detalle");

		Button eliminar = new Button();
		eliminar.setCommandName("actualizar");
		eliminar.setName("actualizar");
		eliminar.setLabel("Actualizar");
		eliminar.setComponentType("botonjs");
		eliminar.setCss("btn btn-secondary");
		eliminar.setResourceName("usuario");
		eliminar.setModule("directorio");
		eliminar.setOrder(5);
		eliminar.setResourceType("forma");
		eliminar.setVersion("1.0");
		eliminar.setEvents("detalle");

		Button login = new Button();
		login.setCommandName("login");
		login.setName("login");
		login.setLabel("Login");
		login.setComponentType("submit");
		login.setCss("btn btn-secondary");
		login.setResourceName("usuario");
		login.setModule("directorio");
		login.setOrder(6);
		login.setResourceType("forma");
		login.setVersion("1.0");
		login.setEvents("inicio");
		login.setView("login");

		Button firmarse = new Button();
		firmarse.setCommandName("firmarse");
		firmarse.setName("firmarse");
		firmarse.setLabel("Ingresar al sistema");
		firmarse.setComponentType("submit");
		firmarse.setCss("btn btn-secondary");
		firmarse.setResourceName("usuario");
		firmarse.setModule("directorio");
		firmarse.setOrder(6);
		firmarse.setResourceType("forma");
		firmarse.setVersion("1.0");
		firmarse.setEvents("login");
		firmarse.setView("bienvenido");

		Button logout = new Button();
		logout.setCommandName("logout");
		logout.setName("logout");
		logout.setLabel("Salir del sistema");
		logout.setComponentType("submit");
		logout.setCss("btn btn-secondary");
		logout.setResourceName("usuario");
		logout.setModule("directorio");
		logout.setOrder(6);
		logout.setResourceType("forma");
		logout.setVersion("1.0");
		//logout.setEvento("detalle");
		logout.setEvents("admin");
		logout.setView("bienvenido");
		
		Button bienvenido = new Button();
		bienvenido.setCommandName("bienvenido");
		bienvenido.setName("bienvenido");
		bienvenido.setLabel("Bienvenido");
		bienvenido.setComponentType("submit");
		bienvenido.setCss("btn btn-secondary");
		bienvenido.setResourceName("usuario");
		bienvenido.setModule("directorio");
		bienvenido.setOrder(6);
		bienvenido.setResourceType("forma");
		bienvenido.setVersion("1.0");
		bienvenido.setEvents("login");
		bienvenido.setView("bienvenido");
		
		Button gentoken = new Button();
		gentoken.setCommandName("gentoken");
		gentoken.setName("gentoken");
		gentoken.setLabel("Genera token");
		gentoken.setComponentType("botonjs");
		gentoken.setCss("btn btn-info");
		gentoken.setResourceName("usuario");
		gentoken.setModule("directorio");
		gentoken.setOrder(6);
		gentoken.setResourceType("forma");
		gentoken.setVersion("1.0");
		//gentoken.setEvento("detalle");
		gentoken.setEvents("admin");
		gentoken.setView("");
		
		Button confirmar = new Button();
		confirmar.setCommandName("confirmar");
		confirmar.setName("confirmar");
		confirmar.setLabel("Confirmar");
		confirmar.setComponentType("botonliga");
		confirmar.setCss("btn btn-info");
		confirmar.setResourceName("usuario");
		confirmar.setModule("directorio");
		confirmar.setOrder(6);
		confirmar.setResourceType("forma");
		confirmar.setVersion("1.0");
		//confirmar.setEvento("detalle");
		confirmar.setEvents("admin");
		confirmar.setView("confirmar");
		
		acciones.add(guardar);
		acciones.add(cancelar);
		acciones.add(eliminar);
		acciones.add(login);
		acciones.add(firmarse);
		acciones.add(logout);
		acciones.add(bienvenido);
		acciones.add(gentoken);
		acciones.add(confirmar);

		Resource forma = new Resource();

		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();

		Field status = new Field();
		Field regimen = new Field();
		Field persona = new Field();
		Field uso = new Field();

		Field rfc = new Field();
		Field curp = new Field();

		Field contacto = new Field();
		Field celular = new Field();
		Field usuario = new Field();
		Field clave = new Field();
		Field claveDec = new Field();
		Field claveNuevo = new Field();

		Field vendedor = new Field();
		Field zona = new Field();
		//Campo lprecios = new Campo();

		Field credito = new Field();
		Field tipo = new Field();
		Field campoActivo = new Field();
		Field campoSalt = new Field();
		Field campoToken = new Field();
		Field idpadre = new Field();
		
		Field campoActivoDec = new Field();
		Field campoSaltDec = new Field();
		Field campoTokenDec = new Field();
		
		List<Field> decoradoresDetalle = new ArrayList<Field>();
		List<Field> decoradoresNuevo = new ArrayList<Field>();
		
		tipo.setName("Tipo");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setValue("usuario");
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setFormat("{TIPO}");

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(true);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setFormat("{TIPO-CONS}");
		campoCodigo.setValue("");

		campoCampo.setName("Nombre");
		campoCampo.setFieldName("nombre");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(3);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);
		campoCampo.setLength(150);
		campoCampo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoCampo.setGroup("cabecero");
		campoCampo.setPersistible(true);
		campoCampo.setFormat("Nombre");
		campoCampo.setValue("");

		/*
		 * aMaterno.setNombre("A. Materno"); aMaterno.setBd("amaterno");
		 * aMaterno.setCss("form-control"); aMaterno.setOrden(3);
		 * aMaterno.setType("texto"); aMaterno.setLectura(false);
		 * aMaterno.setOculto(false); aMaterno.setRequerido(true);
		 * aMaterno.setLista(true); aMaterno.setId(false); aMaterno.setLongitud(100);
		 * 
		 * aPaterno.setNombre("A. Paterno"); aPaterno.setBd("apaterno");
		 * aPaterno.setCss("form-control"); aPaterno.setOrden(4);
		 * aPaterno.setType("texto"); aPaterno.setLectura(false);
		 * aPaterno.setOculto(false); aPaterno.setRequerido(true);
		 * aPaterno.setLista(true); aPaterno.setId(false); aPaterno.setLongitud(100);
		 */
		fNacim.setName("Fecha de alta");
		fNacim.setFieldName("falta");
		fNacim.setCss("form-control");
		fNacim.setOrder(4);
		fNacim.setComponentType("fecha");
		fNacim.setReadOnly(true);
		fNacim.setHidden(false);
		fNacim.setRequired(true);
		fNacim.setShowInBasket(true);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fNacim.setGroup("cabecero");
		fNacim.setPersistible(true);
		fNacim.setFormat("yyyy-MM-dd");
		//fNacim.setValor("");
		fNacim.setValue("${hoyCorto}");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(5);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setValue("Activo");
		status.setLength(20);
		status.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		status.setGroup("cabecero");
		status.setPersistible(true);
		status.setFormat("Status");


		regimen.setName("Regimen fiscal");
		regimen.setFieldName("regimen");
		regimen.setCss("form-control");
		regimen.setOrder(6);
		regimen.setComponentType("regimen");
		regimen.setReadOnly(false);
		regimen.setHidden(false);
		regimen.setRequired(true);
		regimen.setShowInBasket(true);
		regimen.setId(false);
		regimen.setLength(3);
		regimen.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		regimen.setGroup("cabecero");
		regimen.setPersistible(true);
		regimen.setFormat("Regimen fiscal");
		regimen.setValue("");


		persona.setName("Tipo de persona");
		persona.setFieldName("persona");
		persona.setCss("form-control");
		persona.setOrder(7);
		persona.setComponentType("persona");
		persona.setReadOnly(false);
		persona.setHidden(false);
		persona.setRequired(true);
		persona.setShowInBasket(true);
		persona.setId(false);
		persona.setLength(6);
		persona.setValidation("^[ía-zA-Z0-9,.;:_'\\s-]+$");
		persona.setGroup("cabecero");
		persona.setPersistible(true);
		persona.setFormat("Tipo de persona");
		persona.setValue("");

		uso.setName("Uso de comprobantes");
		uso.setFieldName("uso");
		uso.setCss("form-control");
		uso.setOrder(8);
		uso.setComponentType("uso");
		uso.setReadOnly(false);
		uso.setHidden(false);
		uso.setRequired(true);
		uso.setShowInBasket(true);
		uso.setId(false);
		uso.setLength(3);
		uso.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		uso.setGroup("cabecero");
		uso.setPersistible(true);
		uso.setFormat("Uso de comprobantes");
		uso.setValue("");

		rfc.setName("RFC");
		rfc.setFieldName("rfc");
		rfc.setCss("form-control");
		rfc.setOrder(9);
		rfc.setComponentType("texto");
		rfc.setReadOnly(false);
		rfc.setHidden(false);
		rfc.setRequired(true);
		rfc.setShowInBasket(true);
		rfc.setId(false);
		rfc.setLength(20);
		rfc.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		rfc.setGroup("cabecero");
		rfc.setPersistible(true);
		rfc.setFormat("RFC");
		rfc.setValue("");

		curp.setName("CURP");
		curp.setFieldName("curp");
		curp.setCss("form-control");
		curp.setOrder(10);
		curp.setComponentType("texto");
		curp.setReadOnly(false);
		curp.setHidden(false);
		curp.setRequired(false);
		curp.setShowInBasket(true);
		curp.setId(false);
		curp.setLength(18);
		curp.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		curp.setGroup("cabecero");
		curp.setPersistible(true);
		curp.setFormat("CURP");
		curp.setValue("");

		contacto.setName("Contacto");
		contacto.setFieldName("contacto");
		contacto.setCss("form-control");
		contacto.setOrder(11);
		contacto.setComponentType("texto");
		contacto.setReadOnly(false);
		contacto.setHidden(false);
		contacto.setRequired(false);
		contacto.setShowInBasket(true);
		contacto.setId(false);
		contacto.setLength(100);
		contacto.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		contacto.setGroup("cabecero");
		contacto.setPersistible(true);
		contacto.setFormat("Contacto");
		contacto.setValue("");

		celular.setName("No. tel.");
		celular.setFieldName("celular");
		celular.setCss("form-control");
		celular.setOrder(12);
		celular.setComponentType("texto");
		celular.setReadOnly(false);
		celular.setHidden(false);
		celular.setRequired(true);
		celular.setShowInBasket(true);
		celular.setId(false);
		celular.setLength(30);
		celular.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		celular.setGroup("cabecero");
		celular.setPersistible(true);
		celular.setFormat("No. tel.");
		celular.setValue("");

		usuario.setName("Correo elec.");
		usuario.setFieldName("usuario");
		usuario.setCss("form-control");
		usuario.setOrder(13);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(true);
		usuario.setShowInBasket(true);
		usuario.setId(false);
		usuario.setLength(50);
		usuario.setValidation("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setFormat("Correo elec.");
		usuario.setValue("");
		
		clave.setName("Clave de acceso");
		clave.setFieldName("clave");
		clave.setCss("form-control");
		clave.setOrder(14);
		clave.setComponentType("texto");
		clave.setReadOnly(false);
		clave.setHidden(false);
		clave.setRequired(true);
		clave.setShowInBasket(true);
		clave.setId(false);
		clave.setLength(10);
		clave.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		clave.setGroup("cabecero");
		clave.setPersistible(true);
		clave.setFormat("Clave de acceso");
		clave.setValue("");

		claveDec.setName("Clave de acceso");
		claveDec.setFieldName("clave");
		claveDec.setCss("form-control");
		claveDec.setOrder(14);
		claveDec.setComponentType("password");
		claveDec.setReadOnly(true);
		claveDec.setHidden(false);
		claveDec.setRequired(true);
		claveDec.setShowInBasket(true);
		claveDec.setId(false);
		claveDec.setLength(10);
		claveDec.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		claveDec.setGroup("cabecero");
		claveDec.setPersistible(true);
		claveDec.setFormat("Clave de acceso");
		claveDec.setValue("");

		claveNuevo.setName("Clave de acceso");
		claveNuevo.setFieldName("clave");
		claveNuevo.setCss("form-control");
		claveNuevo.setOrder(14);
		claveNuevo.setComponentType("password");
		claveNuevo.setReadOnly(false);
		claveNuevo.setHidden(false);
		claveNuevo.setRequired(true);
		claveNuevo.setShowInBasket(true);
		claveNuevo.setId(false);
		claveNuevo.setLength(10);
		claveNuevo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		claveNuevo.setGroup("cabecero");
		claveNuevo.setPersistible(true);
		claveNuevo.setFormat("Clave de acceso");
		claveNuevo.setValue("");
		
		vendedor.setName("Vendedor");
		vendedor.setFieldName("vendedor");
		vendedor.setCss("form-control");
		vendedor.setOrder(15);
		vendedor.setComponentType("texto");
		vendedor.setReadOnly(false);
		vendedor.setHidden(false);
		vendedor.setRequired(false);
		vendedor.setShowInBasket(true);
		vendedor.setId(false);
		vendedor.setLength(10);
		vendedor.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		vendedor.setGroup("cabecero");
		vendedor.setPersistible(true);
		vendedor.setFormat("Vendedor");
		vendedor.setValue("");

		zona.setName("Grupo");
		zona.setFieldName("zona");
		zona.setCss("form-control");
		zona.setOrder(16);
		zona.setComponentType("texto");
		zona.setReadOnly(false);
		zona.setHidden(false);
		zona.setRequired(false);
		zona.setShowInBasket(true);
		zona.setId(false);
		zona.setLength(10);
		zona.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		zona.setGroup("cabecero");
		zona.setPersistible(true);
		zona.setFormat("Zona");
		zona.setValue("");

		/*
		 * lprecios.setNombre("Lista de precios"); lprecios.setBd("lprecio");
		 * lprecios.setCss("form-control"); lprecios.setOrden(17);
		 * lprecios.setType("texto"); lprecios.setLectura(false);
		 * lprecios.setOculto(false); lprecios.setRequerido(true);
		 * lprecios.setLista(true); lprecios.setId(false); lprecios.setLongitud(10);
		 * lprecios.setValidacion("^[a-zA-Z0-9,.;:_'\\s-]+$");
		 * lprecios.setGrupo("cabecero"); lprecios.setPersistible(true);
		 * lprecios.setAutogenerado(false); lprecios.setFormato("Lista de precios");
		 */

		credito.setName("Credito");
		credito.setFieldName("credito");
		credito.setCss("form-control");
		credito.setOrder(18);
		credito.setComponentType("moneda");
		credito.setReadOnly(false);
		credito.setHidden(false);
		credito.setRequired(false);
		credito.setShowInBasket(true);
		credito.setId(false);
		credito.setLength(10);
		credito.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		//credito.setGrupo("cantidades");
		credito.setGroup("cabecero");
		credito.setPersistible(true);
		credito.setFormat("Credito");
		credito.setValue("0");

		idpadre.setName("Pertenece a empresa");
		idpadre.setFieldName("idpadre");
		idpadre.setCss("form-control");
		idpadre.setOrder(19);
		idpadre.setComponentType("listavalores");
		idpadre.setReadOnly(false);
		idpadre.setHidden(false);
		idpadre.setRequired(false);
		idpadre.setShowInBasket(true);
		idpadre.setId(false);
		idpadre.setLength(20);
		idpadre.setValidation("");
		idpadre.setGroup("cabecero");
		idpadre.setPersistible(true);
		idpadre.setFormat("Pertenece a empresa");
		idpadre.setValue("");
		idpadre.setOrigin("{\"origen\":\"tabla\",\"objeto\":\"dircto\",\"campos\":[{\"nombre\":\"codigo\", \"filtro\":\"\"},{\"nombre\":\"nombre\", \"filtro\":\"\"},{\"nombre\":\"tipo\", \"filtro\":\"empresa\"}]}");

		
		campoActivo.setName("Activo");
		campoActivo.setFieldName("activo");
		campoActivo.setCss("form-control");
		campoActivo.setOrder(20);
		campoActivo.setComponentType("texto");
		campoActivo.setReadOnly(true);
		campoActivo.setHidden(false);
		campoActivo.setRequired(true);
		campoActivo.setShowInBasket(true);
		campoActivo.setId(false);
		campoActivo.setLength(50);
		campoActivo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoActivo.setGroup("cabecero");
		campoActivo.setPersistible(true);
		campoActivo.setFormat("Activo");
		campoActivo.setValue("no");
		
		campoActivoDec.setName("Activo");
		campoActivoDec.setFieldName("activo");
		campoActivoDec.setCss("form-control");
		campoActivoDec.setOrder(20);
		campoActivoDec.setComponentType("texto");
		campoActivoDec.setReadOnly(true);
		campoActivoDec.setHidden(true);
		campoActivoDec.setRequired(true);
		campoActivoDec.setShowInBasket(true);
		campoActivoDec.setId(false);
		campoActivoDec.setLength(50);
		campoActivoDec.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoActivoDec.setGroup("cabecero");
		campoActivoDec.setPersistible(true);
		campoActivoDec.setFormat("Activo");
		campoActivoDec.setValue("no");
		
		
		campoSalt.setName("salt");
		campoSalt.setFieldName("salt");
		campoSalt.setCss("form-control");
		campoSalt.setOrder(21);
		campoSalt.setComponentType("texto");
		campoSalt.setReadOnly(false);
		campoSalt.setHidden(false);
		campoSalt.setRequired(false);
		campoSalt.setShowInBasket(true);
		campoSalt.setId(false);
		campoSalt.setLength(510);
		campoSalt.setValidation("");
		campoSalt.setGroup("cabecero");
		campoSalt.setPersistible(true);
		campoSalt.setFormat("Salt");
		campoSalt.setValue("");
		
		campoSaltDec.setName("salt");
		campoSaltDec.setFieldName("salt");
		campoSaltDec.setCss("form-control");
		campoSaltDec.setOrder(21);
		campoSaltDec.setComponentType("texto");
		campoSaltDec.setReadOnly(true);
		campoSaltDec.setHidden(false);
		campoSaltDec.setRequired(false);
		campoSaltDec.setShowInBasket(true);
		campoSaltDec.setId(false);
		campoSaltDec.setLength(150);
		campoSaltDec.setValidation("");
		campoSaltDec.setGroup("cabecero");
		campoSaltDec.setPersistible(true);
		campoSaltDec.setFormat("Salt");
		campoSaltDec.setValue("");
		
		campoToken.setName("token");
		campoToken.setFieldName("token");
		campoToken.setCss("form-control");
		campoToken.setOrder(22);
		campoToken.setComponentType("texto");
		campoToken.setReadOnly(true);
		campoToken.setHidden(false);
		campoToken.setRequired(false);
		campoToken.setShowInBasket(true);
		campoToken.setId(false);
		campoToken.setLength(510);
		campoToken.setValidation("");
		campoToken.setGroup("cabecero");
		campoToken.setPersistible(true);
		campoToken.setFormat("token");
		campoToken.setValue("");
		
		campoTokenDec.setName("token");
		campoTokenDec.setFieldName("token");
		campoTokenDec.setCss("form-control");
		campoTokenDec.setOrder(22);
		campoTokenDec.setComponentType("texto");
		campoTokenDec.setReadOnly(true);
		campoTokenDec.setHidden(false);
		campoTokenDec.setRequired(false);
		campoTokenDec.setShowInBasket(true);
		campoTokenDec.setId(false);
		campoTokenDec.setLength(150);
		campoTokenDec.setValidation("");
		campoTokenDec.setGroup("cabecero");
		campoTokenDec.setPersistible(true);
		campoTokenDec.setFormat("token");
		campoTokenDec.setValue("");
		
		decoradoresDetalle.add(claveDec);
		decoradoresDetalle.add(campoSaltDec);
		decoradoresDetalle.add(campoTokenDec);
		decoradoresDetalle.add(campoActivoDec);
		
		decoradoresNuevo.add(claveNuevo);
		decoradoresNuevo.add(campoSaltDec);
		decoradoresNuevo.add(campoTokenDec);
		decoradoresNuevo.add(campoActivoDec);
		
		//campos.add(aPaterno);
		campos.add(fNacim);
		//campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(status);
		campos.add(regimen);
		campos.add(persona);
		campos.add(uso);
		campos.add(rfc);
		campos.add(curp);

		campos.add(contacto);
		campos.add(celular);
		campos.add(usuario);
		campos.add(clave);

		campos.add(vendedor);
		campos.add(zona);
		//campos.add(lprecios);

		campos.add(credito);
		campos.add(tipo);
		campos.add(campoActivo);
		campos.add(campoSalt);
		campos.add(campoToken);
		campos.add(idpadre);
		
		forma.setMethods(acciones);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("usuario");
		forma.setTitle("Usuario");
		forma.setView("usuario");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setBasket("usuario");
		forma.setCreateable(true);
		forma.setTable("dircto");
		forma.setValidate(true);
		
		forma.getDecorators().put("nuevo", decoradoresNuevo);
		forma.getDecorators().put("detalle", decoradoresDetalle);
		
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

	@Test
	public void testGuardarFormaPermiso() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("permiso.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("permiso");
		guardar.setModule("directorio");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button eliminar = new Button();
		eliminar.setCommandName("actualizar");
		eliminar.setName("actualizar");
		eliminar.setLabel("Actualizar");
		eliminar.setComponentType("botonjs");
		eliminar.setCss("btn btn-secondary");
		eliminar.setResourceName("permiso");
		eliminar.setModule("directorio");
		eliminar.setOrder(5);
		eliminar.setResourceType("forma");
		eliminar.setVersion("1.0");
		eliminar.setEvents("detalle");


		acciones.add(guardar);
		acciones.add(eliminar);

		Resource forma = new Resource();

		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field fNacim = new Field();

		Field status = new Field();

		Field clave = new Field();

		campoCodigo.setName("Usuario");
		campoCodigo.setFieldName("usuario");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("lprecio");
		campoCodigo.setReadOnly(false);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(false);
		campoCodigo.setLength(150);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setFormat("Usuario");
		campoCodigo.setValue("");
		//lprecios.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"prodserv\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"descripcion\"}]}");
		campoCodigo.setOrigin("{\"origen\":\"tabla\",\"objeto\":\"dircto\",\"campos\":[{\"nombre\":\"codigo\", \"filtro\":\"\"},{\"nombre\":\"nombre\", \"filtro\":\"\"},{\"nombre\":\"tipo\", \"filtro\":\"usuario\"}]}");


		campoCampo.setName("Nombre");
		campoCampo.setFieldName("nombre");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(3);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);
		campoCampo.setLength(150);
		//campoCampo.setValidacion("^[a-zA-Z0-9,.;:_'s-]+$");
		campoCampo.setGroup("cabecero");
		campoCampo.setPersistible(true);
		campoCampo.setFormat("Nombre");
		campoCampo.setValue("");

		fNacim.setName("Fecha de alta");
		fNacim.setFieldName("falta");
		fNacim.setCss("form-control");
		fNacim.setOrder(4);
		fNacim.setComponentType("fecha");
		fNacim.setReadOnly(true);
		fNacim.setHidden(false);
		fNacim.setRequired(true);
		fNacim.setShowInBasket(true);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fNacim.setGroup("cabecero");
		fNacim.setPersistible(true);
		fNacim.setFormat("yyyy-MM-dd");
		//fNacim.setValor("");
		fNacim.setValue("${hoyCorto}");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(5);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setValue("Activo");
		status.setLength(20);
		status.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		status.setGroup("cabecero");
		status.setPersistible(true);
		status.setFormat("Status");


		clave.setName("Atributo");
		clave.setFieldName("atributo");
		clave.setCss("form-control");
		clave.setOrder(14);
		clave.setComponentType("texto");
		clave.setReadOnly(false);
		clave.setHidden(false);
		clave.setRequired(true);
		clave.setShowInBasket(true);
		clave.setId(false);
		clave.setLength(10);
		clave.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		clave.setGroup("cabecero");
		clave.setPersistible(true);
		clave.setFormat("Atributo");
		clave.setValue("");

				
		//campos.add(aPaterno);
		campos.add(fNacim);
		//campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(status);
		campos.add(clave);
		//campos.add(lprecios);
		
		forma.setMethods(acciones);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("permiso");
		forma.setTitle("Permiso");
		forma.setView("permiso");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setBasket("permiso");
		forma.setCreateable(true);
		forma.setTable("permiso");
		forma.setValidate(true);
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

	
	@Test
	public void testGuardarFormaDirectorio() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("directorio.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("directorio");
		guardar.setModule("directorio");
		guardar.setOrder(3);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button cancelar = new Button();
		cancelar.setCommandName("nuevo");
		cancelar.setName("nuevo");
		cancelar.setLabel("Ir a canasta");
		cancelar.setComponentType("location");
		cancelar.setCss("btn btn-secondary");
		cancelar.setResourceName("directorio");
		cancelar.setModule("directorio");
		cancelar.setOrder(4);
		cancelar.setResourceType("basket");
		cancelar.setVersion("1.0");
		cancelar.setEvents("nuevo,detalle");

		Button eliminar = new Button();
		eliminar.setCommandName("actualizar");
		eliminar.setName("actualizar");
		eliminar.setLabel("Actualizar");
		eliminar.setComponentType("botonjs");
		eliminar.setCss("btn btn-secondary");
		eliminar.setResourceName("directorio");
		eliminar.setModule("directorio");
		eliminar.setOrder(5);
		eliminar.setResourceType("forma");
		eliminar.setVersion("1.0");
		eliminar.setEvents("detalle");

		acciones.add(guardar);
		acciones.add(cancelar);
		acciones.add(eliminar);

		Resource forma = new Resource();
		List<Field> decoradoresBuscar = new ArrayList<Field>();
		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field decoradorNombre = new Field();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();

		Field status = new Field();
		Field regimen = new Field();
		Field persona = new Field();
		Field uso = new Field();

		Field rfc = new Field();
		Field decoradorRfc = new Field();
		Field curp = new Field();

		Field contacto = new Field();
		Field celular = new Field();
		Field usuario = new Field();
		Field clave = new Field();

		Field vendedor = new Field();
		Field zona = new Field();
		Field lprecios = new Field();

		Field credito = new Field();
		Field tipo = new Field();
		
		Field zhoraria = new Field();

		tipo.setName("Tipo");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(false);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setValue("usuario");
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setFormat("{TIPO}");
		tipo.setSearcheable(true);

		Field decoradorTipo = new Field();
		decoradorTipo.setName("Tipo");
		decoradorTipo.setFieldName("tipo");
		decoradorTipo.setCss("form-control");
		decoradorTipo.setOrder(1);
		decoradorTipo.setComponentType("tipo");
		decoradorTipo.setReadOnly(true);
		decoradorTipo.setHidden(false);
		decoradorTipo.setRequired(false);
		decoradorTipo.setShowInBasket(true);
		decoradorTipo.setId(false);
		decoradorTipo.setValue("usuario");
		decoradorTipo.setLength(20);
		decoradorTipo.setGroup("cabecero");
		decoradorTipo.setPersistible(true);
		decoradorTipo.setFormat("{TIPO}");
		decoradorTipo.setSearcheable(true);

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setFormat("{TIPO-CONS}");
		campoCodigo.setSearcheable(true);

		//decoradores
		Field decoradorCodigo = new Field();
		decoradorCodigo.setName("Codigo");
		decoradorCodigo.setFieldName("codigo");
		decoradorCodigo.setCss("form-control");
		decoradorCodigo.setOrder(2);
		decoradorCodigo.setComponentType("texto");
		decoradorCodigo.setReadOnly(false);
		decoradorCodigo.setHidden(false);
		decoradorCodigo.setRequired(false);
		decoradorCodigo.setShowInBasket(true);
		decoradorCodigo.setId(true);
		decoradorCodigo.setLength(20);
		decoradorCodigo.setGroup("cabecero");
		decoradorCodigo.setPersistible(true);
		decoradorCodigo.setValue("");
		decoradorCodigo.setFormat("Codigo");
		decoradorCodigo.setSearcheable(true);



		campoCampo.setName("Nombre");
		campoCampo.setFieldName("nombre");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(3);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);
		campoCampo.setLength(150);
		campoCampo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoCampo.setGroup("cabecero");
		campoCampo.setPersistible(true);
		campoCampo.setFormat("Nombre");
		campoCampo.setSearcheable(true);

		decoradorNombre.setName("Nombre");
		decoradorNombre.setFieldName("nombre");
		decoradorNombre.setCss("form-control");
		decoradorNombre.setOrder(3);
		decoradorNombre.setComponentType("texto");
		decoradorNombre.setReadOnly(false);
		decoradorNombre.setHidden(false);
		decoradorNombre.setRequired(false);
		decoradorNombre.setShowInBasket(true);
		decoradorNombre.setId(false);
		decoradorNombre.setLength(150);
		decoradorNombre.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		decoradorNombre.setGroup("cabecero");
		decoradorNombre.setPersistible(true);
		decoradorNombre.setFormat("Nombre");
		decoradorNombre.setSearcheable(true);

		decoradoresBuscar.add(decoradorNombre);
		decoradoresBuscar.add(decoradorTipo);
		decoradoresBuscar.add(decoradorCodigo);

		/*
		 * aMaterno.setNombre("A. Materno"); aMaterno.setBd("amaterno");
		 * aMaterno.setCss("form-control"); aMaterno.setOrden(3);
		 * aMaterno.setType("texto"); aMaterno.setLectura(false);
		 * aMaterno.setOculto(false); aMaterno.setRequerido(true);
		 * aMaterno.setLista(true); aMaterno.setId(false); aMaterno.setLongitud(100);
		 * 
		 * aPaterno.setNombre("A. Paterno"); aPaterno.setBd("apaterno");
		 * aPaterno.setCss("form-control"); aPaterno.setOrden(4);
		 * aPaterno.setType("texto"); aPaterno.setLectura(false);
		 * aPaterno.setOculto(false); aPaterno.setRequerido(true);
		 * aPaterno.setLista(true); aPaterno.setId(false); aPaterno.setLongitud(100);
		 */
		fNacim.setName("Fecha de alta");
		fNacim.setFieldName("falta");
		fNacim.setCss("form-control");
		fNacim.setOrder(4);
		fNacim.setComponentType("fecha");
		fNacim.setReadOnly(false);
		fNacim.setHidden(false);
		fNacim.setRequired(true);
		fNacim.setShowInBasket(true);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fNacim.setGroup("cabecero");
		fNacim.setPersistible(true);
		fNacim.setFormat("yyyy-MM-dd");
		fNacim.setSearcheable(false);

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(5);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setValue("");
		status.setLength(20);
		status.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		status.setGroup("cabecero");
		status.setPersistible(true);
		status.setFormat("Status");
		status.setSearcheable(true);

		regimen.setName("Regimen fiscal");
		regimen.setFieldName("regimen");
		regimen.setCss("form-control");
		regimen.setOrder(6);
		regimen.setComponentType("regimen");
		regimen.setReadOnly(false);
		regimen.setHidden(false);
		regimen.setRequired(true);
		regimen.setShowInBasket(true);
		regimen.setId(false);
		regimen.setLength(3);
		regimen.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		regimen.setGroup("cabecero");
		regimen.setPersistible(true);
		regimen.setFormat("Regimen fiscal");
		regimen.setSearcheable(false);
		regimen.setValue("");

		persona.setName("Tipo de persona");
		persona.setFieldName("persona");
		persona.setCss("form-control");
		persona.setOrder(7);
		persona.setComponentType("persona");
		persona.setReadOnly(false);
		persona.setHidden(false);
		persona.setRequired(true);
		persona.setShowInBasket(true);
		persona.setId(false);
		persona.setLength(6);
		persona.setValidation("^[ía-zA-Z0-9,.;:_'\\s-]+$");
		persona.setGroup("cabecero");
		persona.setPersistible(true);
		persona.setFormat("Tipo de persona");
		persona.setSearcheable(false);
		persona.setValue("");

		uso.setName("Uso de comprobantes");
		uso.setFieldName("uso");
		uso.setCss("form-control");
		uso.setOrder(8);
		uso.setComponentType("uso");
		uso.setReadOnly(false);
		uso.setHidden(false);
		uso.setRequired(true);
		uso.setShowInBasket(true);
		uso.setId(false);
		uso.setLength(3);
		uso.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		uso.setGroup("cabecero");
		uso.setPersistible(true);
		uso.setFormat("Uso de comprobantes");
		uso.setSearcheable(false);
		uso.setValue("");

		rfc.setName("RFC");
		rfc.setFieldName("rfc");
		rfc.setCss("form-control");
		rfc.setOrder(9);
		rfc.setComponentType("texto");
		rfc.setReadOnly(false);
		rfc.setHidden(false);
		rfc.setRequired(true);
		rfc.setShowInBasket(true);
		rfc.setId(false);
		rfc.setLength(20);
		rfc.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		rfc.setGroup("cabecero");
		rfc.setPersistible(true);
		rfc.setFormat("RFC");
		rfc.setSearcheable(true);
		rfc.setValue("");

		decoradorRfc.setName("RFC");
		decoradorRfc.setFieldName("rfc");
		decoradorRfc.setCss("form-control");
		decoradorRfc.setOrder(9);
		decoradorRfc.setComponentType("texto");
		decoradorRfc.setReadOnly(false);
		decoradorRfc.setHidden(false);
		decoradorRfc.setRequired(false);
		decoradorRfc.setShowInBasket(true);
		decoradorRfc.setId(false);
		decoradorRfc.setLength(20);
		decoradorRfc.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		decoradorRfc.setGroup("cabecero");
		decoradorRfc.setPersistible(true);
		decoradorRfc.setFormat("RFC");
		decoradorRfc.setSearcheable(true);
		decoradorRfc.setValue("");

		decoradoresBuscar.add(decoradorRfc);

		curp.setName("CURP");
		curp.setFieldName("curp");
		curp.setCss("form-control");
		curp.setOrder(10);
		curp.setComponentType("texto");
		curp.setReadOnly(false);
		curp.setHidden(false);
		curp.setRequired(false);
		curp.setShowInBasket(true);
		curp.setId(false);
		curp.setLength(18);
		curp.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		curp.setGroup("cabecero");
		curp.setPersistible(true);
		curp.setFormat("CURP");
		curp.setSearcheable(false);
		curp.setValue("");

		contacto.setName("Contacto");
		contacto.setFieldName("contacto");
		contacto.setCss("form-control");
		contacto.setOrder(11);
		contacto.setComponentType("texto");
		contacto.setReadOnly(false);
		contacto.setHidden(false);
		contacto.setRequired(false);
		contacto.setShowInBasket(true);
		contacto.setId(false);
		contacto.setLength(100);
		contacto.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		contacto.setGroup("cabecero");
		contacto.setPersistible(true);
		contacto.setFormat("Contacto");
		contacto.setSearcheable(false);
		contacto.setValue("");

		celular.setName("No. tel.");
		celular.setFieldName("celular");
		celular.setCss("form-control");
		celular.setOrder(12);
		celular.setComponentType("texto");
		celular.setReadOnly(false);
		celular.setHidden(false);
		celular.setRequired(true);
		celular.setShowInBasket(true);
		celular.setId(false);
		celular.setLength(30);
		celular.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		celular.setGroup("cabecero");
		celular.setPersistible(true);
		celular.setFormat("No. tel.");
		celular.setSearcheable(false);
		celular.setValue("");

		usuario.setName("Correo elec.");
		usuario.setFieldName("usuario");
		usuario.setCss("form-control");
		usuario.setOrder(13);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(true);
		usuario.setShowInBasket(true);
		usuario.setId(false);
		usuario.setLength(150);
		usuario.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setFormat("Correo elec.");
		usuario.setSearcheable(false);
		usuario.setValue("");

		clave.setName("Clave de acceso");
		clave.setFieldName("clave");
		clave.setCss("form-control");
		clave.setOrder(14);
		clave.setComponentType("texto");
		clave.setReadOnly(false);
		clave.setHidden(false);
		clave.setRequired(true);
		clave.setShowInBasket(true);
		clave.setId(false);
		clave.setLength(150);
		clave.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		clave.setGroup("cabecero");
		clave.setPersistible(true);
		clave.setFormat("Clave de acceso");
		clave.setSearcheable(false);
		clave.setValue("");

		vendedor.setName("Vendedor");
		vendedor.setFieldName("vendedor");
		vendedor.setCss("form-control");
		vendedor.setOrder(15);
		vendedor.setComponentType("texto");
		vendedor.setReadOnly(false);
		vendedor.setHidden(false);
		vendedor.setRequired(false);
		vendedor.setShowInBasket(true);
		vendedor.setId(false);
		vendedor.setLength(10);
		vendedor.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		vendedor.setGroup("cabecero");
		vendedor.setPersistible(true);
		vendedor.setFormat("Vendedor");
		vendedor.setSearcheable(false);
		vendedor.setValue("");

		zhoraria.setName("Zona horaria");
		zhoraria.setFieldName("zhoraria");
		zhoraria.setCss("form-control");
		zhoraria.setOrder(16);
		zhoraria.setComponentType("zhoraria");
		zhoraria.setReadOnly(false);
		zhoraria.setHidden(false);
		zhoraria.setRequired(false);
		zhoraria.setShowInBasket(true);
		zhoraria.setId(false);
		zhoraria.setLength(10);
		zhoraria.setValidation("");
		zhoraria.setGroup("cabecero");
		zhoraria.setPersistible(true);
		zhoraria.setFormat("zhoraria");
		zhoraria.setSearcheable(false);
		zhoraria.setValue("");

		zona.setName("Zona");
		zona.setFieldName("zona");
		zona.setCss("form-control");
		zona.setOrder(17);
		zona.setComponentType("texto");
		zona.setReadOnly(false);
		zona.setHidden(false);
		zona.setRequired(false);
		zona.setShowInBasket(true);
		zona.setId(false);
		zona.setLength(10);
		zona.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		zona.setGroup("cabecero");
		zona.setPersistible(true);
		zona.setFormat("Zona");
		zona.setSearcheable(false);
		zona.setValue("");
		
		lprecios.setName("Lista de precios");
		lprecios.setFieldName("lprecio");
		lprecios.setCss("form-control");
		lprecios.setOrder(18);
		lprecios.setComponentType("lprecio");
		lprecios.setReadOnly(false);
		lprecios.setHidden(false);
		lprecios.setRequired(true);
		lprecios.setShowInBasket(true);
		lprecios.setId(false);
		lprecios.setLength(20);
		lprecios.setValidation("");
		lprecios.setGroup("cabecero");
		lprecios.setPersistible(true);
		lprecios.setFormat("Lista de precios");
		lprecios.setValue("");
		//lprecios.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"prodserv\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"descripcion\"}]}");
		lprecios.setOrigin("{\"origen\":\"tabla\",\"objeto\":\"lprecio\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");


		credito.setName("Crédito");
		credito.setFieldName("credito");
		credito.setCss("form-control");
		credito.setOrder(19);
		credito.setComponentType("moneda");
		credito.setReadOnly(false);
		credito.setHidden(false);
		credito.setRequired(false);
		credito.setShowInBasket(true);
		credito.setId(false);
		credito.setLength(10);
		credito.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		//credito.setGrupo("cantidades");
		credito.setGroup("cabecero");
		credito.setPersistible(true);
		credito.setFormat("Crédito");
		credito.setValue("");
		credito.setSearcheable(false);

		//campos.add(aPaterno);
		campos.add(fNacim);
		//campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(status);
		campos.add(regimen);
		campos.add(persona);
		campos.add(uso);
		campos.add(rfc);
		campos.add(curp);

		campos.add(contacto);
		campos.add(celular);
		campos.add(usuario);
		campos.add(clave);

		campos.add(vendedor);
		campos.add(zona);
		campos.add(lprecios);

		campos.add(credito);
		campos.add(tipo);
		campos.add(zhoraria);

		forma.getDecorators().put("nuevo", decoradoresBuscar);
		forma.getDecorators().put("buscar", decoradoresBuscar);

		forma.setMethods(acciones);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("directorio");
		forma.setTitle("Directorio");
		forma.setView("directorio");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setBasket("directorio");
		forma.setCreateable(false);
		forma.setTable("dircto");
		forma.setValidate(true);
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


	@Test
	public void testGuardarFormaProveedor() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("proveedor.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("proveedor");
		guardar.setModule("directorio");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button cancelar = new Button();
		cancelar.setCommandName("cancelar");
		cancelar.setName("cancelar");
		cancelar.setLabel("Cancelar proveedor");
		cancelar.setComponentType("backjs");
		cancelar.setCss("btn btn-secondary");
		cancelar.setResourceName("proveedor");
		cancelar.setModule("directorio");
		cancelar.setOrder(2);
		cancelar.setResourceType("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvents("detalle");


		Button editar = new Button();
		editar.setName("actualizar");
		editar.setLabel("Actualizar");
		editar.setComponentType("botonjs");
		editar.setCss("btn btn-info");
		editar.setResourceName("cliente");
		editar.setModule("directorio");
		editar.setOrder(3);
		editar.setResourceType("forma");
		editar.setVersion("1.0");
		editar.setEvents("detalle");


		acciones.add(guardar);
		acciones.add(cancelar);
		acciones.add(editar);

		Resource forma = new Resource();

		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();

		Field status = new Field();
		Field regimen = new Field();
		Field persona = new Field();
		Field uso = new Field();

		Field rfc = new Field();
		Field curp = new Field();

		Field contacto = new Field();
		Field celular = new Field();
		Field usuario = new Field();
		Field clave = new Field();

		Field vendedor = new Field();
		Field zona = new Field();
		Field lprecios = new Field();

		Field credito = new Field();
		Field tipo = new Field();

		tipo.setName("Tipo");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setValue("proveedor");
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setFormat("{TIPO}");

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setFormat("{TIPO-CONS}");

		campoCampo.setName("Nombre");
		campoCampo.setFieldName("nombre");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(3);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);
		campoCampo.setLength(150);
		campoCampo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoCampo.setGroup("cabecero");
		campoCampo.setPersistible(true);
		campoCampo.setFormat("Nombre");

		/*
		 * aMaterno.setNombre("A. Materno"); aMaterno.setBd("amaterno");
		 * aMaterno.setCss("form-control"); aMaterno.setOrden(3);
		 * aMaterno.setType("texto"); aMaterno.setLectura(false);
		 * aMaterno.setOculto(false); aMaterno.setRequerido(true);
		 * aMaterno.setLista(true); aMaterno.setId(false); aMaterno.setLongitud(100);
		 * 
		 * aPaterno.setNombre("A. Paterno"); aPaterno.setBd("apaterno");
		 * aPaterno.setCss("form-control"); aPaterno.setOrden(4);
		 * aPaterno.setType("texto"); aPaterno.setLectura(false);
		 * aPaterno.setOculto(false); aPaterno.setRequerido(true);
		 * aPaterno.setLista(true); aPaterno.setId(false); aPaterno.setLongitud(100);
		 */
		fNacim.setName("Fecha de alta");
		fNacim.setFieldName("falta");
		fNacim.setCss("form-control");
		fNacim.setOrder(4);
		fNacim.setComponentType("fecha");
		fNacim.setReadOnly(true);
		fNacim.setHidden(false);
		fNacim.setRequired(true);
		fNacim.setShowInBasket(true);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fNacim.setGroup("cabecero");
		fNacim.setPersistible(true);
		fNacim.setFormat("yyyy-MM-dd");
		fNacim.setValue("${hoyCorto}");


		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(5);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setValue("Activo");
		status.setLength(20);
		status.setValidation("");
		status.setGroup("cabecero");
		status.setPersistible(true);
		status.setFormat("Status");


		regimen.setName("Regimen fiscal");
		regimen.setFieldName("regimen");
		regimen.setCss("form-control");
		regimen.setOrder(6);
		regimen.setComponentType("regimen");
		regimen.setReadOnly(false);
		regimen.setHidden(false);
		regimen.setRequired(true);
		regimen.setShowInBasket(true);
		regimen.setId(false);
		regimen.setLength(3);
		regimen.setValidation("");
		regimen.setGroup("cabecero");
		regimen.setPersistible(true);
		regimen.setFormat("Regimen fiscal");


		persona.setName("Tipo de persona");
		persona.setFieldName("persona");
		persona.setCss("form-control");
		persona.setOrder(7);
		persona.setComponentType("persona");
		persona.setReadOnly(false);
		persona.setHidden(false);
		persona.setRequired(true);
		persona.setShowInBasket(true);
		persona.setId(false);
		persona.setLength(6);
		persona.setValidation("");
		persona.setGroup("cabecero");
		persona.setPersistible(true);
		persona.setFormat("Tipo de persona");

		uso.setName("Uso de comprobantes");
		uso.setFieldName("uso");
		uso.setCss("form-control");
		uso.setOrder(8);
		uso.setComponentType("uso");
		uso.setReadOnly(false);
		uso.setHidden(false);
		uso.setRequired(true);
		uso.setShowInBasket(true);
		uso.setId(false);
		uso.setLength(3);
		uso.setValidation("");
		uso.setGroup("cabecero");
		uso.setPersistible(true);
		uso.setFormat("Uso de comprobantes");

		rfc.setName("RFC");
		rfc.setFieldName("rfc");
		rfc.setCss("form-control");
		rfc.setOrder(9);
		rfc.setComponentType("texto");
		rfc.setReadOnly(false);
		rfc.setHidden(false);
		rfc.setRequired(true);
		rfc.setShowInBasket(true);
		rfc.setId(false);
		rfc.setLength(20);
		rfc.setValidation("");
		rfc.setGroup("cabecero");
		rfc.setPersistible(true);
		rfc.setFormat("RFC");

		curp.setName("CURP");
		curp.setFieldName("curp");
		curp.setCss("form-control");
		curp.setOrder(10);
		curp.setComponentType("texto");
		curp.setReadOnly(false);
		curp.setHidden(false);
		curp.setRequired(false);
		curp.setShowInBasket(true);
		curp.setId(false);
		curp.setLength(18);
		curp.setValidation("");
		curp.setGroup("cabecero");
		curp.setPersistible(true);
		curp.setFormat("CURP");

		contacto.setName("Contacto");
		contacto.setFieldName("contacto");
		contacto.setCss("form-control");
		contacto.setOrder(11);
		contacto.setComponentType("texto");
		contacto.setReadOnly(false);
		contacto.setHidden(false);
		contacto.setRequired(false);
		contacto.setShowInBasket(true);
		contacto.setId(false);
		contacto.setLength(100);
		contacto.setValidation("");
		contacto.setGroup("cabecero");
		contacto.setPersistible(true);
		contacto.setFormat("Contacto");

		celular.setName("No. tel.");
		celular.setFieldName("celular");
		celular.setCss("form-control");
		celular.setOrder(12);
		celular.setComponentType("texto");
		celular.setReadOnly(false);
		celular.setHidden(false);
		celular.setRequired(true);
		celular.setShowInBasket(true);
		celular.setId(false);
		celular.setLength(30);
		celular.setValidation("");
		celular.setGroup("cabecero");
		celular.setPersistible(true);
		celular.setFormat("No. tel.");

		usuario.setName("Correo elec.");
		usuario.setFieldName("usuario");
		usuario.setCss("form-control");
		usuario.setOrder(13);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(true);
		usuario.setShowInBasket(true);
		usuario.setId(false);
		usuario.setLength(50);
		usuario.setValidation("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setFormat("Correo elec.");
		usuario.setValue("");

		clave.setName("Clave de acceso");
		clave.setFieldName("clave");
		clave.setCss("form-control");
		clave.setOrder(14);
		clave.setComponentType("texto");
		clave.setReadOnly(false);
		clave.setHidden(false);
		clave.setRequired(true);
		clave.setShowInBasket(true);
		clave.setId(false);
		clave.setLength(10);
		clave.setValidation("");
		clave.setGroup("cabecero");
		clave.setPersistible(true);
		clave.setFormat("Clave de acceso");

		vendedor.setName("Vendedor");
		vendedor.setFieldName("vendedor");
		vendedor.setCss("form-control");
		vendedor.setOrder(15);
		vendedor.setComponentType("texto");
		vendedor.setReadOnly(false);
		vendedor.setHidden(false);
		vendedor.setRequired(false);
		vendedor.setShowInBasket(true);
		vendedor.setId(false);
		vendedor.setLength(10);
		vendedor.setValidation("");
		vendedor.setGroup("cabecero");
		vendedor.setPersistible(true);
		vendedor.setFormat("Vendedor");

		zona.setName("Zona");
		zona.setFieldName("zona");
		zona.setCss("form-control");
		zona.setOrder(16);
		zona.setComponentType("texto");
		zona.setReadOnly(false);
		zona.setHidden(false);
		zona.setRequired(false);
		zona.setShowInBasket(true);
		zona.setId(false);
		zona.setLength(10);
		zona.setValidation("");
		zona.setGroup("cabecero");
		zona.setPersistible(true);
		zona.setFormat("Zona");

		lprecios.setName("Lista de precios");
		lprecios.setFieldName("lprecio");
		lprecios.setCss("form-control");
		lprecios.setOrder(17);
		lprecios.setComponentType("lprecio");
		lprecios.setReadOnly(false);
		lprecios.setHidden(false);
		lprecios.setRequired(true);
		lprecios.setShowInBasket(true);
		lprecios.setId(false);
		lprecios.setLength(20);
		lprecios.setValidation("");
		lprecios.setGroup("cabecero");
		lprecios.setPersistible(true);
		lprecios.setFormat("Lista de precios");
		lprecios.setOrigin("{\"origen\":\"tabla\",\"objeto\":\"lprecio\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");


		credito.setName("Crédito");
		credito.setFieldName("credito");
		credito.setCss("form-control");
		credito.setOrder(18);
		credito.setComponentType("moneda");
		credito.setReadOnly(false);
		credito.setHidden(false);
		credito.setRequired(false);
		credito.setShowInBasket(true);
		credito.setId(false);
		credito.setLength(10);
		credito.setValidation("");
		credito.setGroup("cabecero");
		credito.setPersistible(true);
		credito.setFormat("Crédito");

		//campos.add(aPaterno);
		campos.add(fNacim);
		//campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(status);
		campos.add(regimen);
		campos.add(persona);
		campos.add(uso);
		campos.add(rfc);
		campos.add(curp);

		campos.add(contacto);
		campos.add(celular);
		campos.add(usuario);
		campos.add(clave);

		campos.add(vendedor);
		campos.add(zona);
		campos.add(lprecios);

		campos.add(credito);
		campos.add(tipo);
		forma.setMethods(acciones);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("proveedor");
		forma.setTitle("Proveedor");
		forma.setView("proveedor");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setBasket("proveedor");
		forma.setCreateable(true);
		forma.setTable("dircto");
		forma.setValidate(true);
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

	@Test
	public void testGuardarFormaAlmacen() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("almacen.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("almacen");
		guardar.setModule("directorio");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		/*Accion cancelar = new Accion();
		cancelar.setAccion("cancelar");
		cancelar.setNombre("cancelar");
		cancelar.setTitulo("Cancelar");
		cancelar.setType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setForma("almacen");
		cancelar.setModulo("directorio");
		cancelar.setOrden(1);
		cancelar.setTipo("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvento("nuevo");*/


		Button editar = new Button();
		editar.setCommandName("actualizar");
		editar.setName("actualizar");
		editar.setLabel("Actualizar");
		editar.setComponentType("botonjs");
		editar.setCss("btn btn-info");
		editar.setResourceName("almacen");
		editar.setModule("directorio");
		editar.setOrder(2);
		editar.setResourceType("forma");
		editar.setVersion("1.0");
		editar.setEvents("detalle");

		/*Accion nuevo = new Accion();
		nuevo.setAccion("nuevo");
		nuevo.setNombre("nuevo");
		nuevo.setTitulo("Nuevo");
		nuevo.setType("botonjs");
		nuevo.setCss("btn btn-info");
		nuevo.setForma("almacen");
		nuevo.setModulo("directorio");
		nuevo.setOrden(2);
		nuevo.setTipo("forma");
		nuevo.setVersion("1.0");
		nuevo.setEvento("detalle");*/


		acciones.add(guardar);
		//acciones.add(cancelar);
		acciones.add(editar);
		//acciones.add(nuevo);

		Resource forma = new Resource();

		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		//Campo aMaterno = new Campo();
		//Campo aPaterno = new Campo();
		Field fNacim = new Field();

		Field status = new Field();
		Field regimen = new Field();
		Field persona = new Field();
		Field uso = new Field();

		Field rfc = new Field();
		Field curp = new Field();

		Field contacto = new Field();
		Field celular = new Field();
		Field usuario = new Field();
		Field clave = new Field();

		Field vendedor = new Field();
		Field zona = new Field();
		Field lprecios = new Field();

		Field credito = new Field();
		Field tipo = new Field();

		tipo.setName("Tipo");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setValue("almacen");
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setFormat("{TIPO}");

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setFormat("{TIPO-CONS}");

		campoCampo.setName("Nombre");
		campoCampo.setFieldName("nombre");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(3);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);
		campoCampo.setLength(150);
		campoCampo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoCampo.setGroup("cabecero");
		campoCampo.setPersistible(true);
		campoCampo.setFormat("Nombre");

		/*
		 * aMaterno.setNombre("A. Materno"); aMaterno.setBd("amaterno");
		 * aMaterno.setCss("form-control"); aMaterno.setOrden(3);
		 * aMaterno.setType("texto"); aMaterno.setLectura(false);
		 * aMaterno.setOculto(false); aMaterno.setRequerido(true);
		 * aMaterno.setLista(true); aMaterno.setId(false); aMaterno.setLongitud(100);
		 * 
		 * aPaterno.setNombre("A. Paterno"); aPaterno.setBd("apaterno");
		 * aPaterno.setCss("form-control"); aPaterno.setOrden(4);
		 * aPaterno.setType("texto"); aPaterno.setLectura(false);
		 * aPaterno.setOculto(false); aPaterno.setRequerido(true);
		 * aPaterno.setLista(true); aPaterno.setId(false); aPaterno.setLongitud(100);
		 */
		fNacim.setName("Fecha de alta");
		fNacim.setFieldName("falta");
		fNacim.setCss("form-control");
		fNacim.setOrder(4);
		fNacim.setComponentType("fecha");
		fNacim.setReadOnly(true);
		fNacim.setHidden(false);
		fNacim.setRequired(true);
		fNacim.setShowInBasket(true);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fNacim.setGroup("cabecero");
		fNacim.setPersistible(true);
		fNacim.setFormat("yyyy-MM-dd");
		fNacim.setValue("${hoyCorto}");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(5);
		status.setComponentType("status");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setValue("Activo");
		status.setLength(20);
		status.setValidation("");
		status.setGroup("cabecero");
		status.setPersistible(true);
		status.setFormat("Status");


		regimen.setName("Regimen fiscal");
		regimen.setFieldName("regimen");
		regimen.setCss("form-control");
		regimen.setOrder(6);
		regimen.setComponentType("regimen");
		regimen.setReadOnly(false);
		regimen.setHidden(false);
		regimen.setRequired(true);
		regimen.setShowInBasket(true);
		regimen.setId(false);
		regimen.setLength(3);
		regimen.setValidation("");
		regimen.setGroup("cabecero");
		regimen.setPersistible(true);
		regimen.setFormat("Regimen fiscal");


		persona.setName("Tipo de persona");
		persona.setFieldName("persona");
		persona.setCss("form-control");
		persona.setOrder(7);
		persona.setComponentType("persona");
		persona.setReadOnly(false);
		persona.setHidden(false);
		persona.setRequired(true);
		persona.setShowInBasket(true);
		persona.setId(false);
		persona.setLength(6);
		persona.setValidation("");
		persona.setGroup("cabecero");
		persona.setPersistible(true);
		persona.setFormat("Tipo de persona");

		uso.setName("Uso de comprobantes");
		uso.setFieldName("uso");
		uso.setCss("form-control");
		uso.setOrder(8);
		uso.setComponentType("uso");
		uso.setReadOnly(false);
		uso.setHidden(false);
		uso.setRequired(true);
		uso.setShowInBasket(true);
		uso.setId(false);
		uso.setLength(3);
		uso.setValidation("");
		uso.setGroup("cabecero");
		uso.setPersistible(true);
		uso.setFormat("Uso de comprobantes");

		rfc.setName("RFC");
		rfc.setFieldName("rfc");
		rfc.setCss("form-control");
		rfc.setOrder(9);
		rfc.setComponentType("texto");
		rfc.setReadOnly(false);
		rfc.setHidden(false);
		rfc.setRequired(true);
		rfc.setShowInBasket(true);
		rfc.setId(false);
		rfc.setLength(20);
		rfc.setValidation("");
		rfc.setGroup("cabecero");
		rfc.setPersistible(true);
		rfc.setFormat("RFC");

		curp.setName("CURP");
		curp.setFieldName("curp");
		curp.setCss("form-control");
		curp.setOrder(10);
		curp.setComponentType("texto");
		curp.setReadOnly(false);
		curp.setHidden(false);
		curp.setRequired(false);
		curp.setShowInBasket(true);
		curp.setId(false);
		curp.setLength(18);
		curp.setValidation("");
		curp.setGroup("cabecero");
		curp.setPersistible(true);
		curp.setFormat("CURP");

		contacto.setName("Contacto");
		contacto.setFieldName("contacto");
		contacto.setCss("form-control");
		contacto.setOrder(11);
		contacto.setComponentType("texto");
		contacto.setReadOnly(false);
		contacto.setHidden(false);
		contacto.setRequired(false);
		contacto.setShowInBasket(true);
		contacto.setId(false);
		contacto.setLength(100);
		contacto.setValidation("");
		contacto.setGroup("cabecero");
		contacto.setPersistible(true);
		contacto.setFormat("Contacto");

		celular.setName("No. tel.");
		celular.setFieldName("celular");
		celular.setCss("form-control");
		celular.setOrder(12);
		celular.setComponentType("texto");
		celular.setReadOnly(false);
		celular.setHidden(false);
		celular.setRequired(true);
		celular.setShowInBasket(true);
		celular.setId(false);
		celular.setLength(30);
		celular.setValidation("");
		celular.setGroup("cabecero");
		celular.setPersistible(true);
		celular.setFormat("No. tel.");

		usuario.setName("Correo elec.");
		usuario.setFieldName("usuario");
		usuario.setCss("form-control");
		usuario.setOrder(13);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(true);
		usuario.setShowInBasket(true);
		usuario.setId(false);
		usuario.setLength(50);
		usuario.setValidation("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setFormat("Correo elec.");
		usuario.setValue("");

		clave.setName("Clave de acceso");
		clave.setFieldName("clave");
		clave.setCss("form-control");
		clave.setOrder(14);
		clave.setComponentType("texto");
		clave.setReadOnly(false);
		clave.setHidden(false);
		clave.setRequired(true);
		clave.setShowInBasket(true);
		clave.setId(false);
		clave.setLength(10);
		clave.setValidation("");
		clave.setGroup("cabecero");
		clave.setPersistible(true);
		clave.setFormat("Clave de acceso");

		vendedor.setName("Vendedor");
		vendedor.setFieldName("vendedor");
		vendedor.setCss("form-control");
		vendedor.setOrder(15);
		vendedor.setComponentType("texto");
		vendedor.setReadOnly(false);
		vendedor.setHidden(false);
		vendedor.setRequired(false);
		vendedor.setShowInBasket(true);
		vendedor.setId(false);
		vendedor.setLength(10);
		vendedor.setValidation("");
		vendedor.setGroup("cabecero");
		vendedor.setPersistible(true);
		vendedor.setFormat("Vendedor");

		zona.setName("Zona");
		zona.setFieldName("zona");
		zona.setCss("form-control");
		zona.setOrder(16);
		zona.setComponentType("texto");
		zona.setReadOnly(false);
		zona.setHidden(false);
		zona.setRequired(false);
		zona.setShowInBasket(true);
		zona.setId(false);
		zona.setLength(10);
		zona.setValidation("");
		zona.setGroup("cabecero");
		zona.setPersistible(true);
		zona.setFormat("Zona");

		lprecios.setName("Lista de precios");
		lprecios.setFieldName("lprecio");
		lprecios.setCss("form-control");
		lprecios.setOrder(17);
		lprecios.setComponentType("lprecio");
		lprecios.setReadOnly(false);
		lprecios.setHidden(false);
		lprecios.setRequired(true);
		lprecios.setShowInBasket(true);
		lprecios.setId(false);
		lprecios.setLength(20);
		lprecios.setValidation("");
		lprecios.setGroup("cabecero");
		lprecios.setPersistible(true);
		lprecios.setFormat("Lista de precios");
		lprecios.setOrigin("{\"origen\":\"tabla\",\"objeto\":\"lprecio\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");


		credito.setName("Crédito");
		credito.setFieldName("credito");
		credito.setCss("form-control");
		credito.setOrder(18);
		credito.setComponentType("moneda");
		credito.setReadOnly(false);
		credito.setHidden(false);
		credito.setRequired(false);
		credito.setShowInBasket(true);
		credito.setId(false);
		credito.setLength(10);
		credito.setValidation("");
		credito.setGroup("cabecero");
		credito.setPersistible(true);
		credito.setFormat("Crédito");

		//campos.add(aPaterno);
		campos.add(fNacim);
		//campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(status);
		campos.add(regimen);
		campos.add(persona);
		campos.add(uso);
		campos.add(rfc);
		campos.add(curp);

		campos.add(contacto);
		campos.add(celular);
		campos.add(usuario);
		campos.add(clave);

		campos.add(vendedor);
		campos.add(zona);
		campos.add(lprecios);

		campos.add(credito);
		campos.add(tipo);
		forma.setMethods(acciones);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("almacen");
		forma.setTitle("Almacen");
		forma.setView("almacen");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setBasket("almacen");
		forma.setCreateable(true);
		forma.setTable("dircto");
		forma.setValidate(true);
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


	@Test
	public void testGuardarFormaSolicitudCarrito() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("carrito.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		Field docId = new Field();
		Field codigosat = new Field();
		Field codigo = new Field();
		//Campo descripcion = new Campo();
		Field umedida = new Field();
		Field precio = new Field();
		Field cantidad = new Field();
		Field descuento = new Field();
		Field retencion = new Field();

		Field impuesto = new Field();
		Field subtotal = new Field();
		Field sessionId = new Field();
		Field status = new Field();

		Resource forma = new Resource();

		Button registrar = new Button();
		registrar.setName("nuevo");
		registrar.setLabel("Registrar pedido");
		registrar.setComponentType("botonliga");
		registrar.setCss("btn btn-primary");
		registrar.setResourceName("ingreso");
		registrar.setModule("comprobante");
		registrar.setOrder(1);
		registrar.setResourceType("forma");
		registrar.setVersion("3.3");
		registrar.setEvents("nuevo");

		Button cancelar = new Button();
		cancelar.setName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setResourceName("ingreso");
		cancelar.setModule("comprobante");
		cancelar.setOrder(2);
		cancelar.setResourceType("forma");
		cancelar.setVersion("3.3");
		cancelar.setEvents("nuevo");

		Button agregar = new Button();
		agregar.setName("agregar");
		agregar.setLabel("Comprar");
		agregar.setComponentType("botonjs");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("carrito");
		agregar.setModule("solicitud");
		agregar.setOrder(3);
		agregar.setResourceType("forma");
		agregar.setVersion("3.3");
		agregar.setEvents("nuevo");

		acciones.add(registrar);
		acciones.add(cancelar);
		acciones.add(agregar);

		docId.setName("DocId");
		docId.setFieldName("docid");
		docId.setCss("form-control");
		docId.setOrder(1);
		docId.setComponentType("texto");
		docId.setReadOnly(false);
		docId.setHidden(false);
		docId.setRequired(true);
		docId.setShowInBasket(false);
		docId.setId(false);
		docId.setLength(20);
		docId.setGroup("cabecero");

		codigosat.setName("Codigo SAT");
		codigosat.setFieldName("codigosat");
		codigosat.setCss("form-control");
		codigosat.setOrder(2);
		codigosat.setComponentType("texto");
		codigosat.setReadOnly(false);
		codigosat.setHidden(false);
		codigosat.setRequired(true);
		codigosat.setShowInBasket(true);
		codigosat.setId(false);
		codigosat.setLength(50);
		codigosat.setGroup("cabecero");

		codigo.setName("Codigo");
		codigo.setFieldName("codigo");
		codigo.setCss("form-control");
		codigo.setOrder(3);
		codigo.setComponentType("texto");
		codigo.setReadOnly(false);
		codigo.setHidden(false);
		codigo.setRequired(true);
		codigo.setShowInBasket(true);
		codigo.setId(false);
		codigo.setLength(20);
		codigo.setGroup("cabecero");

		/*descripcion.setNombre("Descripcion");
		descripcion.setBd("descripcion");
		descripcion.setCss("form-control");
		descripcion.setOrden(4);
		descripcion.setType("texto");
		descripcion.setLectura(false);
		descripcion.setOculto(false);
		descripcion.setRequerido(true);
		descripcion.setLista(true);
		descripcion.setId(false);
		descripcion.setLongitud(200);
		descripcion.setGrupo("cabecero");*/

		umedida.setName("U. Medida");
		umedida.setFieldName("medida");
		umedida.setCss("form-control");
		umedida.setOrder(5);
		umedida.setComponentType("texto");
		umedida.setReadOnly(false);
		umedida.setHidden(false);
		umedida.setRequired(true);
		umedida.setShowInBasket(false);
		umedida.setId(false);
		umedida.setLength(50);
		umedida.setGroup("cabecero");

		precio.setName("Precio Unitario");
		precio.setFieldName("precio");
		precio.setCss("campo-fecha");
		precio.setOrder(6);
		precio.setComponentType("moneda");
		precio.setReadOnly(false);
		precio.setHidden(false);
		precio.setRequired(true);
		precio.setShowInBasket(false);
		precio.setId(false);
		precio.setLength(20);
		precio.setValidation("^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$");
		precio.setGroup("cabecero");

		cantidad.setName("Cantidad");
		cantidad.setFieldName("cantidad");
		cantidad.setCss("campo-fecha");
		cantidad.setOrder(7);
		cantidad.setComponentType("moneda");
		cantidad.setReadOnly(false);
		cantidad.setHidden(false);
		cantidad.setRequired(true);
		cantidad.setShowInBasket(false);
		cantidad.setId(false);
		cantidad.setLength(10);
		cantidad.setValidation("^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$");
		cantidad.setGroup("cabecero");

		descuento.setName("Descuento");
		descuento.setFieldName("descuento");
		descuento.setCss("campo-fecha");
		descuento.setOrder(8);
		descuento.setComponentType("moneda");
		descuento.setReadOnly(false);
		descuento.setHidden(false);
		descuento.setRequired(true);
		descuento.setShowInBasket(false);
		descuento.setId(false);
		descuento.setLength(10);
		descuento.setValidation("^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$");
		descuento.setGroup("cabecero");

		retencion.setName("Retención");
		retencion.setFieldName("retencion");
		retencion.setCss("campo-fecha");
		retencion.setOrder(9);
		retencion.setComponentType("moneda");
		retencion.setReadOnly(false);
		retencion.setHidden(false);
		retencion.setRequired(true);
		retencion.setShowInBasket(false);
		retencion.setId(false);
		retencion.setLength(10);
		retencion.setValidation("^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$");
		retencion.setGroup("cabecero");

		impuesto.setName("Impuesto");
		impuesto.setFieldName("impuesto");
		impuesto.setCss("campo-fecha");
		impuesto.setOrder(10);
		impuesto.setComponentType("moneda");
		impuesto.setReadOnly(false);
		impuesto.setHidden(false);
		impuesto.setRequired(true);
		impuesto.setShowInBasket(false);
		impuesto.setId(false);
		impuesto.setLength(10);
		impuesto.setValidation("^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$");
		impuesto.setGroup("cabecero");

		subtotal.setName("Subtotal");
		subtotal.setFieldName("subtotal");
		subtotal.setCss("campo-fecha");
		subtotal.setOrder(11);
		subtotal.setComponentType("moneda");
		subtotal.setReadOnly(true);
		subtotal.setHidden(false);
		subtotal.setRequired(false);
		subtotal.setShowInBasket(false);
		subtotal.setId(false);
		subtotal.setLength(20);
		subtotal.setGroup("cabecero");

		sessionId.setName("Id Sesion");
		sessionId.setFieldName("sessionid");
		sessionId.setCss("form-control");
		sessionId.setOrder(12);
		sessionId.setComponentType("texto");
		sessionId.setReadOnly(false);
		sessionId.setHidden(false);
		sessionId.setRequired(false);
		sessionId.setShowInBasket(false);
		sessionId.setId(false);
		sessionId.setLength(50);
		sessionId.setGroup("cabecero");

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(13);
		status.setComponentType("texto");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(false);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(true);
		status.setValue("nuevo");
		status.setValidation("");
		status.setFormat("Status");

		campos.add(docId);
		campos.add(codigosat);
		campos.add(precio);
		campos.add(cantidad);
		campos.add(umedida);
		//campos.add(descripcion);
		campos.add(codigo);
		campos.add(descuento);
		campos.add(impuesto);
		campos.add(subtotal);
		campos.add(sessionId);
		campos.add(status);
		campos.add(retencion);


		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("carrito");
		forma.setView("carrito");
		forma.setTitle("Carrito de compra");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("solicitud");
		forma.setBasket("carrito");
		forma.setCreateable(false);
		forma.setTable("carrito");
		forma.setValidate(true);

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

	@Test
	public void testGuardarFormaComprobantesImpuesto() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("impuesto.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();


		Field codigo = new Field();
		//Campo descripcion = new Campo();
		Field umedida = new Field();
		Field precio = new Field();
		Field cantidad = new Field();
		Field descuento = new Field();
		Field retencion = new Field();

		Field impuesto = new Field();
		Field subtotal = new Field();

		Resource forma = new Resource();

		Button registrar = new Button();
		registrar.setName("nuevo");
		registrar.setLabel("Registrar pedido");
		registrar.setComponentType("botonliga");
		registrar.setCss("btn btn-primary");
		registrar.setResourceName("ingreso");
		registrar.setModule("comprobante");
		registrar.setOrder(1);
		registrar.setResourceType("forma");
		registrar.setVersion("3.3");
		registrar.setEvents("nuevo");

		Button cancelar = new Button();
		cancelar.setName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setResourceName("ingreso");
		cancelar.setModule("comprobante");
		cancelar.setOrder(2);
		cancelar.setResourceType("forma");
		cancelar.setVersion("3.3");
		cancelar.setEvents("nuevo");

		Button agregar = new Button();
		agregar.setName("agregar");
		agregar.setLabel("Agregar a carrito");
		agregar.setComponentType("botonjs");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("carrito");
		agregar.setModule("solicitud");
		agregar.setOrder(3);
		agregar.setResourceType("forma");
		agregar.setVersion("3.3");
		agregar.setEvents("nuevo");

		acciones.add(registrar);
		acciones.add(cancelar);
		acciones.add(agregar);

		codigo.setName("Codigo");
		codigo.setFieldName("codigo");
		codigo.setCss("form-control");
		codigo.setOrder(3);
		codigo.setComponentType("texto");
		codigo.setReadOnly(false);
		codigo.setHidden(false);
		codigo.setRequired(true);
		codigo.setShowInBasket(true);
		codigo.setId(false);
		codigo.setLength(20);
		codigo.setGroup("cabecero");
		codigo.setFormat("Codigo");
		/*descripcion.setNombre("Descripcion");
		descripcion.setBd("descripcion");
		descripcion.setCss("form-control");
		descripcion.setOrden(4);
		descripcion.setType("texto");
		descripcion.setLectura(false);
		descripcion.setOculto(false);
		descripcion.setRequerido(true);
		descripcion.setLista(true);
		descripcion.setId(false);
		descripcion.setLongitud(200);
		descripcion.setGrupo("cabecero");*/

		umedida.setName("Grupo"); // doc o item
		umedida.setFieldName("grupo");
		umedida.setCss("form-control");
		umedida.setOrder(5);
		umedida.setComponentType("texto");
		umedida.setReadOnly(false);
		umedida.setHidden(false);
		umedida.setRequired(true);
		umedida.setShowInBasket(false);
		umedida.setId(false);
		umedida.setLength(50);
		umedida.setGroup("cabecero");
		umedida.setFormat("Codigo");

		precio.setName("Tipo");
		precio.setFieldName("tipo");
		precio.setCss("campo-fecha");
		precio.setOrder(6);
		precio.setComponentType("texto");
		precio.setReadOnly(false);
		precio.setHidden(false);
		precio.setRequired(true);
		precio.setShowInBasket(false);
		precio.setId(false);
		precio.setLength(20);
		//precio.setValidacion("^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$");
		precio.setGroup("cabecero");
		precio.setFormat("Codigo");

		cantidad.setName("Impuesto %");
		cantidad.setFieldName("impuestop");
		cantidad.setCss("campo-fecha");
		cantidad.setOrder(7);
		cantidad.setComponentType("moneda");
		cantidad.setReadOnly(false);
		cantidad.setHidden(false);
		cantidad.setRequired(true);
		cantidad.setShowInBasket(false);
		cantidad.setId(false);
		cantidad.setLength(10);
		//cantidad.setValidacion("^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$");
		cantidad.setGroup("cabecero");
		cantidad.setFormat("Codigo");

		descuento.setName("Tipo/Factor");
		descuento.setFieldName("tipofactor");
		descuento.setCss("campo-fecha");
		descuento.setOrder(8);
		descuento.setComponentType("texto");
		descuento.setReadOnly(false);
		descuento.setHidden(false);
		descuento.setRequired(true);
		descuento.setShowInBasket(false);
		descuento.setId(false);
		descuento.setLength(20);
		//descuento.setValidacion("^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$");
		descuento.setGroup("cabecero");
		descuento.setFormat("Codigo");

		retencion.setName("Tasa/Cuota");
		retencion.setFieldName("tasaocuota");
		retencion.setCss("campo-fecha");
		retencion.setOrder(9);
		retencion.setComponentType("moneda");
		retencion.setReadOnly(false);
		retencion.setHidden(false);
		retencion.setRequired(true);
		retencion.setShowInBasket(false);
		retencion.setId(false);
		retencion.setLength(10);
		//retencion.setValidacion("^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$");
		retencion.setGroup("cabecero");
		retencion.setFormat("Codigo");

		impuesto.setName("Impuesto");
		impuesto.setFieldName("impuesto");
		impuesto.setCss("campo-fecha");
		impuesto.setOrder(10);
		impuesto.setComponentType("moneda");
		impuesto.setReadOnly(false);
		impuesto.setHidden(false);
		impuesto.setRequired(true);
		impuesto.setShowInBasket(false);
		impuesto.setId(false);
		impuesto.setLength(10);
		impuesto.setValidation("^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$");
		impuesto.setGroup("cabecero");
		impuesto.setFormat("Codigo");

		subtotal.setName("Importe");
		subtotal.setFieldName("importe");
		subtotal.setCss("campo-fecha");
		subtotal.setOrder(11);
		subtotal.setComponentType("moneda");
		subtotal.setReadOnly(true);
		subtotal.setHidden(false);
		subtotal.setRequired(false);
		subtotal.setShowInBasket(false);
		subtotal.setId(false);
		subtotal.setLength(20);
		subtotal.setGroup("cabecero");
		subtotal.setFormat("Codigo");

		campos.add(precio);
		campos.add(cantidad);
		campos.add(umedida);
		//campos.add(descripcion);
		campos.add(codigo);
		campos.add(descuento);
		campos.add(impuesto);
		campos.add(subtotal);
		campos.add(retencion);


		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("impuesto");
		forma.setView("impuesto");
		forma.setTitle("Impuesto");
		forma.setVersion("3.3");
		forma.setStatus("produccion");
		forma.setModule("comprobantes");
		forma.setBasket("impuesto");
		forma.setCreateable(false);
		forma.setTable("impuesto");
		forma.setValidate(true);

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

	@Test
	public void testGuardarFormaSolicitudProdServ() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("prodserv.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();

		Field tipo = new Field();
		Field codigo = new Field();
		Field sat = new Field();
		Field calterno = new Field();
		Field descripcion = new Field();
		Field uentrada = new Field();
		Field usalida = new Field();
		Field categoria = new Field();
		Field factor = new Field();
		Field uempaque = new Field();
		Field tsurtido = new Field();
		Field imagen = new Field();
		Field usuario = new Field();
		Field fecha = new Field();
		Field longitud = new Field();
		Field altura = new Field();
		Field grosor = new Field();
		Field peso = new Field();
		Field ancho = new Field();

		Field noserie = new Field();
		Field lote = new Field();
		Field pedimento = new Field();
		Field cmoneda = new Field();
		Field ccontable = new Field();
		Field costeo = new Field();
		Field existencias = new Field();
		Field sminimo = new Field();
		Field smaximo = new Field();
		Field comprometido = new Field();
		Field porrecibir = new Field();
		Field porsurtir = new Field();
		Field obs = new Field();
		Field status = new Field();
		Field lprecio = new Field();

		Resource forma = new Resource();
		List<Field> decoradoresBuscar = new ArrayList<Field>();


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("producto");
		guardar.setModule("inventario");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button cancelar = new Button();
		cancelar.setCommandName("cancelar");
		cancelar.setName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setResourceName("producto");
		cancelar.setModule("inventario");
		cancelar.setOrder(1);
		cancelar.setResourceType("forma");
		cancelar.setVersion("1.0");
		cancelar.setEvents("nuevo");


		Button editar = new Button();
		editar.setCommandName("cancelar");
		editar.setName("actualizar");
		editar.setLabel("Actualizar");
		editar.setComponentType("botonjs");
		editar.setCss("btn btn-info");
		editar.setResourceName("producto");
		editar.setModule("inventario");
		editar.setOrder(2);
		editar.setResourceType("forma");
		editar.setVersion("1.0");
		editar.setEvents("detalle");

		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Buscar");
		buscar.setComponentType("submit");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("prodserv");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("basket");
		buscar.setVersion("1.0");
		buscar.setEvents("buscar");

		acciones.add(buscar);
		acciones.add(guardar);
		acciones.add(editar);
		acciones.add(cancelar);

		tipo.setName("Tipo");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setValue("producto");
		tipo.setFormat("{TIPO}");
		tipo.setSearcheable(true);
		tipo.setDbFieldType("varchar");
		tipo.setDecimals(0);

		//decoradores

		Field decoradorTipo = new Field();
		decoradorTipo.setName("Tipo");
		decoradorTipo.setFieldName("tipo");
		decoradorTipo.setCss("form-control");
		decoradorTipo.setOrder(1);
		decoradorTipo.setComponentType("tipo");
		decoradorTipo.setReadOnly(true);
		decoradorTipo.setHidden(false);
		decoradorTipo.setRequired(false);
		decoradorTipo.setShowInBasket(true);
		decoradorTipo.setId(false);
		decoradorTipo.setValue("Todos");
		decoradorTipo.setLength(20);
		decoradorTipo.setGroup("cabecero");
		decoradorTipo.setPersistible(true);
		decoradorTipo.setFormat("{TIPO}");
		decoradorTipo.setSearcheable(true);
		decoradorTipo.setDbFieldType("varchar");
		decoradorTipo.setDecimals(0);

		decoradoresBuscar.add(decoradorTipo);

		codigo.setName("Codigo");
		codigo.setFieldName("codigo");
		codigo.setCss("form-control");
		codigo.setOrder(2);
		codigo.setComponentType("texto");
		codigo.setReadOnly(true);
		codigo.setHidden(false);
		codigo.setRequired(false);
		codigo.setShowInBasket(true);
		codigo.setId(true);
		codigo.setLength(20);
		codigo.setGroup("cabecero");
		codigo.setPersistible(true);
		codigo.setValue("");
		codigo.setFormat("{TIPO-CONS}");
		codigo.setSearcheable(true);
		codigo.setDbFieldType("varchar");
		codigo.setDecimals(0);

		//decoradores
		Field decoradorCodigo = new Field();
		decoradorCodigo.setName("Codigo");
		decoradorCodigo.setFieldName("codigo");
		decoradorCodigo.setCss("form-control");
		decoradorCodigo.setOrder(2);
		decoradorCodigo.setComponentType("texto");
		decoradorCodigo.setReadOnly(false);
		decoradorCodigo.setHidden(false);
		decoradorCodigo.setRequired(false);
		decoradorCodigo.setShowInBasket(true);
		decoradorCodigo.setId(true);
		decoradorCodigo.setLength(20);
		decoradorCodigo.setGroup("cabecero");
		decoradorCodigo.setPersistible(true);
		decoradorCodigo.setValue("");
		decoradorCodigo.setFormat("Codigo");
		decoradorCodigo.setSearcheable(true);
		decoradorCodigo.setDbFieldType("varchar");
		decoradorCodigo.setDecimals(0);

		decoradoresBuscar.add(decoradorCodigo);

		sat.setName("Codigo SAT");
		sat.setFieldName("codigosat");
		sat.setCss("form-control");
		sat.setOrder(3);
		sat.setComponentType("texto");
		sat.setReadOnly(false);
		sat.setHidden(false);
		sat.setRequired(false);
		sat.setShowInBasket(true);
		sat.setId(false);
		sat.setLength(20);
		sat.setGroup("cabecero");
		sat.setPersistible(true);
		sat.setValue("");
		sat.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		sat.setFormat("Codigo SAT");
		sat.setSearcheable(true);
		sat.setDbFieldType("varchar");
		sat.setDecimals(0);

		calterno.setName("Codigo alterno");
		calterno.setFieldName("calterno");
		calterno.setCss("form-control");
		calterno.setOrder(4);
		calterno.setComponentType("texto");
		calterno.setReadOnly(false);
		calterno.setHidden(false);
		calterno.setRequired(false);
		calterno.setShowInBasket(true);
		calterno.setId(false);
		calterno.setLength(20);
		calterno.setGroup("cabecero");
		calterno.setPersistible(true);
		calterno.setValue("");
		calterno.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		calterno.setFormat("Codigo alterno");
		calterno.setSearcheable(true);
		calterno.setDbFieldType("varchar");
		calterno.setDecimals(0);

		descripcion.setName("Descripcion");
		descripcion.setFieldName("descripcion");
		descripcion.setCss("form-control");
		descripcion.setOrder(5);
		descripcion.setComponentType("texto");
		descripcion.setReadOnly(false);
		descripcion.setHidden(false);
		descripcion.setRequired(true);
		descripcion.setShowInBasket(true);
		descripcion.setId(false);
		descripcion.setLength(200);
		descripcion.setGroup("cabecero");
		descripcion.setPersistible(true);
		descripcion.setValue("");
		descripcion.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		descripcion.setFormat("Descripcion");
		descripcion.setSearcheable(true);
		descripcion.setDbFieldType("varchar");
		descripcion.setDecimals(0);

		uentrada.setName("U. Entrada");
		uentrada.setFieldName("uentrada");
		uentrada.setCss("form-control");
		uentrada.setOrder(6);
		uentrada.setComponentType("umedida");
		uentrada.setReadOnly(false);
		uentrada.setHidden(false);
		uentrada.setRequired(true);
		uentrada.setShowInBasket(false);
		uentrada.setId(false);
		uentrada.setLength(100);
		uentrada.setGroup("cabecero");
		uentrada.setPersistible(true);
		uentrada.setValue("");
		uentrada.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		uentrada.setFormat("U. Entrada");
		uentrada.setSearcheable(false);
		uentrada.setDbFieldType("varchar");
		uentrada.setDecimals(0);

		usalida.setName("U. Salida");
		usalida.setFieldName("usalida");
		usalida.setCss("form-control");
		usalida.setOrder(7);
		usalida.setComponentType("umedida");
		usalida.setReadOnly(false);
		usalida.setHidden(false);
		usalida.setRequired(true);
		usalida.setShowInBasket(false);
		usalida.setId(false);
		usalida.setLength(100);
		usalida.setGroup("cabecero");
		usalida.setPersistible(true);
		usalida.setValue("");
		usalida.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		usalida.setFormat("U. Salida");
		usalida.setSearcheable(false);
		usalida.setDbFieldType("varchar");
		usalida.setDecimals(0);

		categoria.setName("Categoria");
		categoria.setFieldName("categoria");
		categoria.setCss("form-control");
		categoria.setOrder(8);
		categoria.setComponentType("texto");
		categoria.setReadOnly(false);
		categoria.setHidden(false);
		categoria.setRequired(false);
		categoria.setShowInBasket(false);
		categoria.setId(false);
		categoria.setLength(100);
		categoria.setGroup("cabecero");
		categoria.setPersistible(true);
		categoria.setValue("");
		categoria.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		categoria.setFormat("Categoria");
		categoria.setSearcheable(false);
		categoria.setDbFieldType("varchar");
		categoria.setDecimals(0);

		factor.setName("Factor empaque");
		factor.setFieldName("factor");
		factor.setCss("form-control");
		factor.setOrder(9);
		factor.setComponentType("moneda");
		factor.setReadOnly(false);
		factor.setHidden(false);
		factor.setRequired(true);
		factor.setShowInBasket(false);
		factor.setId(false);
		factor.setLength(100);
		factor.setGroup("cabecero");
		factor.setPersistible(true);
		factor.setValue("0");
		factor.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		factor.setFormat("Factor empaque");
		factor.setSearcheable(false);
		factor.setDbFieldType("varchar");
		factor.setDecimals(0);

		uempaque.setName("Unidades Empaque");
		uempaque.setFieldName("uempaque");
		uempaque.setCss("form-control");
		uempaque.setOrder(10);
		uempaque.setComponentType("moneda");
		uempaque.setReadOnly(false);
		uempaque.setHidden(false);
		uempaque.setRequired(false);
		uempaque.setShowInBasket(false);
		uempaque.setId(false);
		uempaque.setLength(8);
		uempaque.setGroup("cabecero");
		uempaque.setPersistible(true);
		uempaque.setValue("0");
		uempaque.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		uempaque.setFormat("Unidades Empaque");
		uempaque.setSearcheable(false);
		uempaque.setDbFieldType("decimal");
		uempaque.setDecimals(2);

		tsurtido.setName("Tiempo Surtido");
		tsurtido.setFieldName("tsurtido");
		tsurtido.setCss("form-control");
		tsurtido.setOrder(11);
		tsurtido.setComponentType("texto");
		tsurtido.setReadOnly(false);
		tsurtido.setHidden(false);
		tsurtido.setRequired(false);
		tsurtido.setShowInBasket(false);
		tsurtido.setId(false);
		tsurtido.setLength(10);
		tsurtido.setGroup("cabecero");
		tsurtido.setPersistible(true);
		tsurtido.setValue("");
		tsurtido.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		tsurtido.setFormat("Tiempo Surtido");
		tsurtido.setSearcheable(false);
		tsurtido.setDbFieldType("varchar");
		tsurtido.setDecimals(0);

		imagen.setName("Imagen");
		imagen.setFieldName("imagen");
		imagen.setCss("form-control");
		imagen.setOrder(12);
		imagen.setComponentType("texto");
		imagen.setReadOnly(false);
		imagen.setHidden(false);
		imagen.setRequired(false);
		imagen.setShowInBasket(false);
		imagen.setId(false);
		imagen.setLength(100);
		imagen.setGroup("cabecero");
		imagen.setPersistible(true);
		imagen.setValue("0");
		imagen.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		imagen.setFormat("Imagen");
		imagen.setSearcheable(false);
		imagen.setDbFieldType("varchar");
		imagen.setDecimals(0);

		usuario.setName("Usuario");
		usuario.setFieldName("usuario");
		usuario.setCss("form-control");
		usuario.setOrder(13);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(false);
		usuario.setShowInBasket(false);
		usuario.setId(false);
		usuario.setLength(100);
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setValue("0");
		usuario.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		usuario.setFormat("Usuario");
		usuario.setSearcheable(false);
		usuario.setDbFieldType("varchar");
		usuario.setDecimals(0);

		fecha.setName("Fecha");
		fecha.setFieldName("fecha");
		fecha.setCss("form-control");
		fecha.setOrder(14);
		fecha.setComponentType("fecha");
		fecha.setReadOnly(false);
		fecha.setHidden(false);
		fecha.setRequired(false);
		fecha.setShowInBasket(false);
		fecha.setId(false);
		fecha.setLength(20);
		fecha.setGroup("cabecero");
		fecha.setPersistible(true);
		fecha.setValue("");
		fecha.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fecha.setFormat("yyyy-MM-dd");
		fecha.setSearcheable(false);
		fecha.setDbFieldType("date");
		fecha.setDecimals(0);

		longitud.setName("Longitud");
		longitud.setFieldName("longitud");
		longitud.setCss("form-control");
		longitud.setOrder(15);
		longitud.setComponentType("moneda");
		longitud.setReadOnly(false);
		longitud.setHidden(false);
		longitud.setRequired(false);
		longitud.setShowInBasket(true);
		longitud.setId(false);
		longitud.setLength(8);
		longitud.setGroup("cabecero");
		longitud.setPersistible(true);
		longitud.setValue("0");
		longitud.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		longitud.setFormat("Longitud");
		longitud.setSearcheable(false);
		longitud.setDbFieldType("decimal");
		longitud.setDecimals(2);

		altura.setName("Altura");
		altura.setFieldName("altura");
		altura.setCss("form-control");
		altura.setOrder(16);
		altura.setComponentType("moneda");
		altura.setReadOnly(false);
		altura.setHidden(false);
		altura.setRequired(false);
		altura.setShowInBasket(true);
		altura.setId(false);
		altura.setLength(8);
		altura.setGroup("cabecero");
		altura.setPersistible(true);
		altura.setValue("0");
		altura.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		altura.setFormat("Altura");
		altura.setSearcheable(false);
		altura.setDbFieldType("decimal");
		altura.setDecimals(2);

		grosor.setName("Grosor");
		grosor.setFieldName("grosor");
		grosor.setCss("form-control");
		grosor.setOrder(17);
		grosor.setComponentType("moneda");
		grosor.setReadOnly(false);
		grosor.setHidden(false);
		grosor.setRequired(false);
		grosor.setShowInBasket(true);
		grosor.setId(false);
		grosor.setLength(8);
		grosor.setGroup("cabecero");
		grosor.setPersistible(true);
		grosor.setValue("0");
		grosor.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		grosor.setFormat("Grosor");
		grosor.setSearcheable(false);
		grosor.setDbFieldType("decimal");
		grosor.setDecimals(2);

		peso.setName("Peso");
		peso.setFieldName("peso");
		peso.setCss("form-control");
		peso.setOrder(18);
		peso.setComponentType("moneda");
		peso.setReadOnly(false);
		peso.setHidden(false);
		peso.setRequired(false);
		peso.setShowInBasket(true);
		peso.setId(false);
		peso.setLength(8);
		peso.setGroup("cabecero");
		peso.setPersistible(true);
		peso.setValue("0");
		peso.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		peso.setFormat("Peso");
		peso.setSearcheable(false);
		peso.setDbFieldType("decimal");
		peso.setDecimals(2);

		ancho.setName("Ancho");
		ancho.setFieldName("ancho");
		ancho.setCss("form-control");
		ancho.setOrder(19);
		ancho.setComponentType("moneda");
		ancho.setReadOnly(false);
		ancho.setHidden(false);
		ancho.setRequired(false);
		ancho.setShowInBasket(true);
		ancho.setId(false);
		ancho.setLength(10);
		ancho.setGroup("cabecero");
		ancho.setPersistible(true);
		ancho.setValue("0");
		ancho.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		ancho.setFormat("Ancho");
		ancho.setSearcheable(false);
		ancho.setDbFieldType("decimal");
		ancho.setDecimals(2);

		noserie.setName("No de series");
		noserie.setFieldName("noserie");
		noserie.setCss("form-control");
		noserie.setOrder(20);
		noserie.setComponentType("checkbox");
		noserie.setReadOnly(false);
		noserie.setHidden(false);
		noserie.setRequired(false);
		noserie.setShowInBasket(true);
		noserie.setId(false);
		noserie.setLength(10);
		noserie.setGroup("cantidades");
		noserie.setPersistible(true);
		noserie.setValue("");
		noserie.setDbFieldType("boolean");
		noserie.setDecimals(0);

		lote.setName("Lote");
		lote.setFieldName("lote");
		lote.setCss("form-control");
		lote.setOrder(21);
		lote.setComponentType("checkbox");
		lote.setReadOnly(false);
		lote.setHidden(false);
		lote.setRequired(false);
		lote.setShowInBasket(true);
		lote.setId(false);
		lote.setLength(10);
		lote.setGroup("cantidades");
		lote.setPersistible(true);
		lote.setValue("");
		lote.setDbFieldType("boolean");
		lote.setDecimals(0);

		pedimento.setName("Predimento aduanal");
		pedimento.setFieldName("pedimento");
		pedimento.setCss("form-control");
		pedimento.setOrder(22);
		pedimento.setComponentType("checkbox");
		pedimento.setReadOnly(false);
		pedimento.setHidden(false);
		pedimento.setRequired(false);
		pedimento.setShowInBasket(true);
		pedimento.setId(false);
		pedimento.setLength(10);
		pedimento.setGroup("cantidades");
		pedimento.setPersistible(true);
		pedimento.setValue("");
		pedimento.setDbFieldType("boolean");
		pedimento.setDecimals(0);

		cmoneda.setName("Moneda");
		cmoneda.setFieldName("moneda");
		cmoneda.setCss("form-control");
		cmoneda.setOrder(23);
		cmoneda.setComponentType("cmoneda");
		cmoneda.setReadOnly(false);
		cmoneda.setHidden(false);
		cmoneda.setRequired(false);
		cmoneda.setShowInBasket(true);
		cmoneda.setId(false);
		cmoneda.setLength(10);
		cmoneda.setGroup("cantidades");
		cmoneda.setPersistible(true);
		cmoneda.setValue("");
		cmoneda.setDbFieldType("varchar");
		cmoneda.setDecimals(0);

		ccontable.setName("Cuenta C.");
		ccontable.setFieldName("ccontable");
		ccontable.setCss("form-control");
		ccontable.setOrder(24);
		ccontable.setComponentType("texto");
		ccontable.setReadOnly(false);
		ccontable.setHidden(false);
		ccontable.setRequired(false);
		ccontable.setShowInBasket(false);
		ccontable.setId(false);
		ccontable.setLength(50);
		ccontable.setGroup("cantidades");
		ccontable.setPersistible(true);
		ccontable.setValue("");
		ccontable.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		ccontable.setFormat("Cuenta C.");
		ccontable.setDbFieldType("varchar");
		ccontable.setDecimals(0);


		costeo.setName("Costeo");
		costeo.setFieldName("costeo");
		costeo.setCss("form-control");
		costeo.setOrder(25);
		costeo.setComponentType("costeo");
		costeo.setReadOnly(false);
		costeo.setHidden(false);
		costeo.setRequired(false);
		costeo.setShowInBasket(true);
		costeo.setId(false);
		costeo.setLength(20);
		costeo.setGroup("cantidades");
		costeo.setPersistible(true);
		costeo.setFormat("Costeo");
		costeo.setValue("");
		costeo.setDbFieldType("varchar");
		costeo.setDecimals(0);

		existencias.setName("Existencias");
		existencias.setFieldName("existencias");
		existencias.setCss("form-control");
		existencias.setOrder(26);
		existencias.setComponentType("moneda");
		existencias.setReadOnly(true);
		existencias.setHidden(false);
		existencias.setRequired(false);
		existencias.setShowInBasket(false);
		existencias.setId(false);
		existencias.setLength(10);
		existencias.setGroup("cantidades");
		existencias.setPersistible(true);
		existencias.setValue("0");
		existencias.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		existencias.setFormat("Existencias");
		existencias.setDbFieldType("decimal");
		existencias.setDecimals(2);

		sminimo.setName("Stock minimo");
		sminimo.setFieldName("sminimo");
		sminimo.setCss("form-control");
		sminimo.setOrder(27);
		sminimo.setComponentType("moneda");
		sminimo.setReadOnly(false);
		sminimo.setHidden(false);
		sminimo.setRequired(false);
		sminimo.setShowInBasket(false);
		sminimo.setId(false);
		sminimo.setLength(10);
		sminimo.setGroup("cantidades");
		sminimo.setPersistible(true);
		sminimo.setValue("0");
		sminimo.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		sminimo.setFormat("Stock minimo");
		sminimo.setDbFieldType("decimal");
		sminimo.setDecimals(2);

		smaximo.setName("Stock maximo");
		smaximo.setFieldName("smaximo");
		smaximo.setCss("form-control");
		smaximo.setOrder(28);
		smaximo.setComponentType("moneda");
		smaximo.setReadOnly(false);
		smaximo.setHidden(false);
		smaximo.setRequired(false);
		smaximo.setShowInBasket(false);
		smaximo.setId(false);
		smaximo.setLength(10);
		smaximo.setGroup("cantidades");
		smaximo.setPersistible(true);
		smaximo.setValue("0");
		smaximo.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		smaximo.setFormat("Stock maximo");
		smaximo.setDbFieldType("decimal");
		smaximo.setDecimals(2);

		comprometido.setName("Comprometido");
		comprometido.setFieldName("comprometido");
		comprometido.setCss("form-control");
		comprometido.setOrder(29);
		comprometido.setComponentType("moneda");
		comprometido.setReadOnly(true);
		comprometido.setHidden(false);
		comprometido.setRequired(false);
		comprometido.setShowInBasket(false);
		comprometido.setId(false);
		comprometido.setLength(10);
		comprometido.setGroup("cantidades");
		comprometido.setPersistible(true);
		comprometido.setValue("0");
		comprometido.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		comprometido.setFormat("Comprometido");
		comprometido.setDbFieldType("decimal");
		comprometido.setDecimals(2);

		porrecibir.setName("Por recibir");
		porrecibir.setFieldName("porrecibir");
		porrecibir.setCss("form-control");
		porrecibir.setOrder(30);
		porrecibir.setComponentType("moneda");
		porrecibir.setReadOnly(true);
		porrecibir.setHidden(false);
		porrecibir.setRequired(false);
		porrecibir.setShowInBasket(false);
		porrecibir.setId(false);
		porrecibir.setLength(10);
		porrecibir.setGroup("cantidades");
		porrecibir.setPersistible(true);
		porrecibir.setValue("0");
		porrecibir.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		porrecibir.setFormat("Por recibir");
		porrecibir.setDbFieldType("decimal");
		porrecibir.setDecimals(2);

		porsurtir.setName("Por surtir");
		porsurtir.setFieldName("porsurtir");
		porsurtir.setCss("form-control");
		porsurtir.setOrder(31);
		porsurtir.setComponentType("moneda");
		porsurtir.setReadOnly(true);
		porsurtir.setHidden(false);
		porsurtir.setRequired(false);
		porsurtir.setShowInBasket(false);
		porsurtir.setId(false);
		porsurtir.setLength(10);
		porsurtir.setGroup("cantidades");
		porsurtir.setPersistible(true);
		porsurtir.setValue("0");
		porsurtir.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		porsurtir.setFormat("Por surtir");
		porsurtir.setDbFieldType("decimal");
		porsurtir.setDecimals(2);

		obs.setName("Observaciones");
		obs.setFieldName("obs");
		obs.setCss("form-control");
		obs.setOrder(32);
		obs.setComponentType("textoarea");
		obs.setReadOnly(false);
		obs.setHidden(false);
		obs.setRequired(false);
		obs.setShowInBasket(false);
		obs.setId(false);
		obs.setLength(100);
		obs.setGroup("cantidades");
		obs.setPersistible(true);
		obs.setValue("");
		obs.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		obs.setFormat("Observaciones");
		obs.setDbFieldType("varchar");
		obs.setDecimals(0);

		status.setName("Status");
		status.setFieldName("status");
		status.setCss("form-control");
		status.setOrder(33);
		status.setComponentType("texto");
		status.setReadOnly(true);
		status.setHidden(false);
		status.setRequired(true);
		status.setShowInBasket(true);
		status.setId(false);
		status.setLength(20);
		status.setGroup("cabecero");
		status.setPersistible(false);
		status.setValue("nuevo");
		status.setValidation("");
		status.setFormat("Status");
		status.setDbFieldType("varchar");
		status.setDecimals(2);

		lprecio.setName("Precios");
		lprecio.setFieldName("lprecio");
		lprecio.setCss("form-control");
		lprecio.setOrder(34);
		lprecio.setComponentType("texto");
		lprecio.setReadOnly(false);
		lprecio.setHidden(false);
		lprecio.setRequired(true);
		lprecio.setShowInBasket(true);
		lprecio.setId(false);
		lprecio.setLength(20);
		lprecio.setGroup("cabecero");
		lprecio.setPersistible(false);
		lprecio.setValue("CAT-01");
		lprecio.setValidation("");
		lprecio.setFormat("Lista de precios");
		lprecio.setDbFieldType("varchar");
		lprecio.setDecimals(0);
		
		campos.add(tipo);
		campos.add(codigo);
		campos.add(sat);
		campos.add(calterno);
		campos.add(descripcion);
		campos.add(factor);
		campos.add(tsurtido);
		campos.add(uempaque);
		campos.add(uentrada);
		campos.add(usalida);
		campos.add(imagen);
		campos.add(categoria);
		campos.add(usuario);
		campos.add(fecha);
		campos.add(lote);
		campos.add(pedimento);
		campos.add(cmoneda);
		campos.add(ccontable);
		campos.add(costeo);
		campos.add(existencias);
		campos.add(sminimo);
		campos.add(smaximo);
		campos.add(comprometido);
		campos.add(porrecibir);
		campos.add(porsurtir);
		campos.add(obs);
		campos.add(status);
		campos.add(lprecio);

		campos.add(longitud);
		campos.add(altura);
		campos.add(grosor);
		campos.add(peso);
		campos.add(ancho);
		campos.add(noserie);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("prodserv");
		forma.setView("prodserv");
		forma.setTitle("Producto/Servicios/Kits");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setBasket("prodserv");
		forma.setCreateable(false);
		forma.setTable("prodserv");
		forma.setValidate(true);
		forma.getDecorators().put("nuevo", decoradoresBuscar);
		forma.getDecorators().put("buscar", decoradoresBuscar);
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

	@Test
	public void testInventarioBuscar() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("inventario_buscar.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();

		Field codigo = new Field();
		Field descripcion = new Field();
		Field umedida = new Field();

		Resource forma = new Resource();

		Button registrar = new Button();
		registrar.setName("nuevo");
		registrar.setLabel("Registrar pedido");
		registrar.setComponentType("submit");
		registrar.setCss("btn btn-primary");
		registrar.setResourceName("ingreso");
		registrar.setModule("comprobante");
		registrar.setOrder(1);

		Button cancelar = new Button();
		cancelar.setName("cancelar");
		cancelar.setLabel("Cancelar");
		cancelar.setComponentType("boton");
		cancelar.setCss("btn btn-secondary");
		cancelar.setResourceName("ingreso");
		cancelar.setModule("comprobante");
		cancelar.setOrder(2);

		Button agregar = new Button();
		agregar.setName("agregar");
		agregar.setLabel("Agregar a carrito");
		agregar.setComponentType("boton");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("carrito");
		agregar.setModule("solicitud");
		agregar.setOrder(3);

		acciones.add(registrar);
		acciones.add(cancelar);
		acciones.add(agregar);


		codigo.setName("Codigo");
		codigo.setFieldName("codigo");
		codigo.setCss("form-control");
		codigo.setOrder(3);
		codigo.setComponentType("texto");
		codigo.setReadOnly(false);
		codigo.setHidden(false);
		codigo.setRequired(false);
		codigo.setShowInBasket(true);
		codigo.setId(false);
		codigo.setLength(20);
		codigo.setGroup("cabecero");
		
		descripcion.setName("Descripcion");
		descripcion.setFieldName("descripcion");
		descripcion.setCss("form-control");
		descripcion.setOrder(4);
		descripcion.setComponentType("texto");
		descripcion.setReadOnly(false);
		descripcion.setHidden(false);
		descripcion.setRequired(false);
		descripcion.setShowInBasket(true);
		descripcion.setId(false);
		descripcion.setLength(200);
		descripcion.setGroup("cabecero");

		umedida.setName("U. Medida");
		umedida.setFieldName("medida");
		umedida.setCss("form-control");
		umedida.setOrder(5);
		umedida.setComponentType("texto");
		umedida.setReadOnly(false);
		umedida.setHidden(false);
		umedida.setRequired(false);
		umedida.setShowInBasket(false);
		umedida.setId(false);
		umedida.setLength(50);
		umedida.setGroup("cabecero");

		campos.add(umedida);
		campos.add(descripcion);
		campos.add(codigo);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("buscar");
		forma.setView("buscar");
		forma.setTitle("Buscar producto");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setBasket("producto");
		forma.setCreateable(false);
		forma.setTable("producto");
		forma.setValidate(true);

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

	@Test
	public void testGuardarFormaPrecio() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("precio.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();

		Field campoCodigo = new Field();
		Field campoNombre = new Field();
		Field base = new Field();
		Field factor = new Field();
		Field campoStatus = new Field();

		Resource forma = new Resource();

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("precio");
		guardar.setModule("inventario");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button editar = new Button();
		editar.setCommandName("actualizar");
		editar.setName("actualizar");
		editar.setLabel("Actualizar");
		editar.setComponentType("botonjs");
		editar.setCss("btn btn-info");
		editar.setResourceName("precio");
		editar.setModule("inventario");
		editar.setOrder(2);
		editar.setResourceType("forma");
		editar.setVersion("1.0");
		editar.setEvents("detalle");

		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Buscar");
		buscar.setComponentType("botonjs");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("precio");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("basket");
		buscar.setVersion("1.0");
		buscar.setEvents("buscar");

		acciones.add(guardar);
		acciones.add(editar);
		acciones.add(buscar);

		/*campoCodigo.setNombre("Codigo");
		campoCodigo.setBd("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrden(1);
		campoCodigo.setType("texto");
		campoCodigo.setLectura(false);
		campoCodigo.setOculto(false);
		campoCodigo.setRequerido(true);
		campoCodigo.setLista(true);
		campoCodigo.setId(true);
		campoCodigo.setLongitud(20);*/

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(false);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setFormat("{TIPO-CONS}");
		campoCodigo.setValue("");

		campoNombre.setName("Nombre");
		campoNombre.setFieldName("nombre");
		campoNombre.setCss("form-control");
		campoNombre.setOrder(2);
		campoNombre.setComponentType("texto");
		campoNombre.setReadOnly(false);
		campoNombre.setHidden(false);
		campoNombre.setRequired(true);
		campoNombre.setShowInBasket(true);
		campoNombre.setId(false);
		campoNombre.setLength(100);
		campoNombre.setFormat("Nombre");
		campoNombre.setValue("");

		base.setName("Base");
		base.setFieldName("base");
		base.setCss("form-control");
		base.setOrder(3);
		base.setComponentType("lprecio");
		base.setReadOnly(false);
		base.setHidden(false);
		base.setRequired(false);
		base.setShowInBasket(false);
		base.setId(false);
		base.setLength(20);
		base.setOrigin("{\"origen\":\"tabla\",\"objeto\":\"lprecio\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");
		base.setFormat("Base");
		base.setValue("");

		factor.setName("Factor");
		factor.setFieldName("factor");
		factor.setCss("form-control");
		factor.setOrder(3);
		factor.setComponentType("texto");
		factor.setReadOnly(false);
		factor.setHidden(false);
		factor.setRequired(false);
		factor.setShowInBasket(false);
		factor.setId(false);
		factor.setLength(3);
		factor.setFormat("Factor");
		factor.setValue("");

		campoStatus.setName("Status");
		campoStatus.setFieldName("status");
		campoStatus.setCss("form-control");
		campoStatus.setOrder(7);
		campoStatus.setComponentType("texto");
		campoStatus.setReadOnly(false);
		campoStatus.setHidden(false);
		campoStatus.setRequired(true);
		campoStatus.setShowInBasket(true);
		campoStatus.setValue("nuevo");
		campoStatus.setId(false);
		campoStatus.setLength(20);
		campoStatus.setFormat("Status");

		campos.add(campoNombre);
		campos.add(campoCodigo);
		campos.add(base);
		campos.add(factor);
		campos.add(campoStatus);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("precio");
		forma.setView("precio");
		forma.setTitle("Lista de precio");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setBasket("precios");
		forma.setCreateable(true);
		forma.setTable("lprecio");
		forma.setValidate(true);
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

	@Test
	public void testGuardarFormaPrecios() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		//precios -> precio
		Path filePath = fileConfigLocation.resolve("precios.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();

		Field campoCodigo = new Field();
		Field campoNombre = new Field();
		Field factor = new Field();
		Field precio = new Field();
		Field campoStatus = new Field();
		Field lprecios = new Field();
		Field campoDescripcion = new Field();
		Field campoLenguage = new Field();
		Field campoMoneda = new Field();

		Resource forma = new Resource();

		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("precios");
		guardar.setModule("inventario");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		Button editar = new Button();
		editar.setCommandName("guardar");
		editar.setName("actualizar");
		editar.setLabel("Actualizar");
		editar.setComponentType("botonjs");
		editar.setCss("btn btn-info");
		editar.setResourceName("precios");
		editar.setModule("inventario");
		editar.setOrder(2);
		editar.setResourceType("forma");
		editar.setVersion("1.0");
		editar.setEvents("detalle");

		Button buscar = new Button();
		buscar.setCommandName("guardar");
		buscar.setName("buscar");
		buscar.setLabel("Buscar");
		buscar.setComponentType("botonjs");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("precios");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("basket");
		buscar.setVersion("1.0");
		buscar.setEvents("buscar");

		acciones.add(guardar);
		acciones.add(editar);
		acciones.add(buscar);

		campoCodigo.setName("Lista de precios");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		//campoCodigo.setType("lprecio");
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(true);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(false);
		campoCodigo.setLength(20);
		//campoCodigo.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"lprecio\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setValue("");
		campoCodigo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoCodigo.setFormat("Codigo");

		campoNombre.setName("Producto/Servicio");
		campoNombre.setFieldName("prodserv");
		campoNombre.setCss("form-control");
		campoNombre.setOrder(2);
		campoNombre.setComponentType("texto");
		campoNombre.setReadOnly(false);
		campoNombre.setHidden(false);
		campoNombre.setRequired(true);
		campoNombre.setShowInBasket(true);
		campoNombre.setId(false);
		campoNombre.setLength(100);
		//campoNombre.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"prodserv\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"descripcion\"}]}");
		campoNombre.setGroup("cabecero");
		campoNombre.setPersistible(true);
		campoNombre.setValue("");
		campoNombre.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoNombre.setFormat("Producto/Servicio");


		factor.setName("Factor");
		factor.setFieldName("factor");
		factor.setCss("form-control");
		factor.setOrder(3);
		factor.setComponentType("texto");
		factor.setReadOnly(false);
		factor.setHidden(false);
		factor.setRequired(true);
		factor.setShowInBasket(false);
		factor.setId(false);
		factor.setLength(3);
		factor.setGroup("cabecero");
		factor.setPersistible(true);
		factor.setValue("");
		factor.setValidation("^([0-9]*|\\d*\\.\\d{1}?\\d*)$");
		factor.setFormat("Factor");

		precio.setName("Precio");
		precio.setFieldName("precio");
		precio.setCss("form-control");
		precio.setOrder(4);
		precio.setComponentType("moneda");
		precio.setReadOnly(false);
		precio.setHidden(false);
		precio.setRequired(true);
		precio.setShowInBasket(false);
		precio.setId(false);
		precio.setLength(20);
		precio.setGroup("cabecero");
		precio.setPersistible(true);
		precio.setValue("");
		precio.setValidation("^[0-9]+(\\.[0-9]{1,2})?$");
		precio.setFormat("Precio");

		campoStatus.setName("Status");
		campoStatus.setFieldName("status");
		campoStatus.setCss("form-control");
		campoStatus.setOrder(7);
		campoStatus.setComponentType("texto");
		campoStatus.setReadOnly(false);
		campoStatus.setHidden(false);
		campoStatus.setRequired(true);
		campoStatus.setShowInBasket(true);
		campoStatus.setValue("");
		campoStatus.setId(false);
		campoStatus.setLength(20);
		campoStatus.setFormat("Status");

		lprecios.setName("Lista de precios");
		lprecios.setFieldName("lprecio");
		lprecios.setCss("form-control");
		lprecios.setOrder(8);
		lprecios.setComponentType("texto");
		lprecios.setReadOnly(false);
		lprecios.setHidden(true);
		lprecios.setRequired(true);
		lprecios.setShowInBasket(true);
		lprecios.setId(false);
		lprecios.setLength(20);
		lprecios.setGroup("cabecero");
		lprecios.setPersistible(true);
		lprecios.setFormat("Lista de precios");
		lprecios.setValue("${lprecio}");

		campoDescripcion.setName("Descripcion");
		campoDescripcion.setFieldName("descripcion");
		campoDescripcion.setCss("form-control");
		campoDescripcion.setOrder(9);
		campoDescripcion.setComponentType("texto");
		campoDescripcion.setReadOnly(false);
		campoDescripcion.setHidden(false);
		campoDescripcion.setRequired(true);
		campoDescripcion.setShowInBasket(true);
		campoDescripcion.setId(false);
		campoDescripcion.setLength(150);
		campoDescripcion.setGroup("cabecero");
		campoDescripcion.setPersistible(true);
		campoDescripcion.setFormat("Descripcion");
		campoDescripcion.setValue("");
		
		campoLenguage.setName("Lenguage");
		campoLenguage.setFieldName("lenguage");
		campoLenguage.setCss("form-control");
		campoLenguage.setOrder(10);
		campoLenguage.setComponentType("texto");
		campoLenguage.setReadOnly(false);
		campoLenguage.setHidden(false);
		campoLenguage.setRequired(true);
		campoLenguage.setShowInBasket(true);
		campoLenguage.setId(false);
		campoLenguage.setLength(20);
		campoLenguage.setGroup("cabecero");
		campoLenguage.setPersistible(true);
		campoLenguage.setFormat("Descripcion");
		campoLenguage.setValue("");
		
		campoMoneda.setName("Moneda");
		campoMoneda.setFieldName("moneda");
		campoMoneda.setCss("form-control");
		campoMoneda.setOrder(11);
		campoMoneda.setComponentType("texto");
		campoMoneda.setReadOnly(false);
		campoMoneda.setHidden(false);
		campoMoneda.setRequired(true);
		campoMoneda.setShowInBasket(true);
		campoMoneda.setId(false);
		campoMoneda.setLength(20);
		campoMoneda.setGroup("cabecero");
		campoMoneda.setPersistible(true);
		campoMoneda.setFormat("Descripcion");
		campoMoneda.setValue("");
		
		campos.add(campoNombre);
		campos.add(campoCodigo);
		campos.add(precio);
		campos.add(factor);
		campos.add(campoStatus);
		campos.add(lprecios);
		campos.add(campoDescripcion);
		campos.add(campoLenguage);
		campos.add(campoMoneda);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("precios");
		forma.setView("precios");
		forma.setTitle("Precio de producto");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setBasket("precios");
		forma.setCreateable(false);
		forma.setTable("precios");
		forma.setValidate(true);
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

	@Test
	public void testGuardarFormaMasiva() throws IOException {


		List<Field> decoradoresSolicitud = new ArrayList<Field>();
		List<Field> decoradoresPaquete = new ArrayList<Field>();
		//decoradores
		Field decoradorIdsolicitud = new Field();
		Field decoradorIdpaquete = new Field();


		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		//precios -> precio
		Path filePath = fileConfigLocation.resolve("masiva.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();

		Field campoCodigo = new Field();
		Field campoNombre = new Field();
		Field factor = new Field();
		Field precio = new Field();
		Field campoStatus = new Field();
		Field idsolicitud = new Field();
		Field campoInicial = new Field();
		Field campoFinal = new Field();
		Field idsPaquetes = new Field();

		Resource forma = new Resource();

		Button guardar = new Button();
		guardar.setCommandName("crear");
		guardar.setName("crear");
		guardar.setLabel("Crear solicitud");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("masiva");
		guardar.setModule("solicitud");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		guardar.setStatus("nuevo");

		Button editar = new Button();
		editar.setCommandName("validar");
		editar.setName("validar");
		editar.setLabel("Validar paquete");
		editar.setComponentType("botonjs");
		editar.setCss("btn btn-info");
		editar.setResourceName("masiva");
		editar.setModule("solicitud");
		editar.setOrder(2);
		editar.setResourceType("forma");
		editar.setVersion("1.0");
		editar.setEvents("detalle");
		editar.setStatus("nuevo");

		Button buscar = new Button();
		buscar.setCommandName("descargar");
		buscar.setName("descargar");
		buscar.setLabel("Descargar paquete");
		buscar.setComponentType("botonjs");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("masiva");
		buscar.setModule("solicitud");
		buscar.setOrder(3);
		buscar.setResourceType("forma");
		buscar.setVersion("1.0");
		buscar.setEvents("detalle");
		buscar.setStatus("validar");

		acciones.add(guardar);
		acciones.add(editar);
		acciones.add(buscar);

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(1);
		//campoCodigo.setType("lprecio");
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(true);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(false);
		campoCodigo.setLength(20);
		//campoCodigo.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"lprecio\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"nombre\"}]}");
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setValue("");
		campoCodigo.setValidation("");
		campoCodigo.setFormat("{TIPO-CONS}");

		campoNombre.setName("Tipo");
		campoNombre.setFieldName("tipo");
		campoNombre.setCss("form-control");
		campoNombre.setOrder(2);
		campoNombre.setComponentType("sat_tipo");
		campoNombre.setReadOnly(false);
		campoNombre.setHidden(false);
		campoNombre.setRequired(true);
		campoNombre.setShowInBasket(true);
		campoNombre.setId(false);
		campoNombre.setLength(100);
		//campoNombre.setOrigen("{\"origen\":\"tabla\",\"objeto\":\"prodserv\",\"campos\":[{\"nombre\":\"codigo\"},{\"nombre\":\"descripcion\"}]}");
		campoNombre.setGroup("cabecero");
		campoNombre.setPersistible(true);
		campoNombre.setValue("");
		campoNombre.setValidation("");
		campoNombre.setFormat("");


		factor.setName("Emisor");
		factor.setFieldName("emisor");
		factor.setCss("form-control");
		factor.setOrder(3);
		factor.setComponentType("texto");
		factor.setReadOnly(false);
		factor.setHidden(false);
		factor.setRequired(true);
		factor.setShowInBasket(false);
		factor.setId(false);
		factor.setLength(20);
		factor.setGroup("cabecero");
		factor.setPersistible(true);
		factor.setValue("AAA010101AAA");
		factor.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		factor.setFormat("Emisor");

		precio.setName("Receptor");
		precio.setFieldName("receptor");
		precio.setCss("form-control");
		precio.setOrder(4);
		precio.setComponentType("texto");
		precio.setReadOnly(false);
		precio.setHidden(false);
		precio.setRequired(false);
		precio.setShowInBasket(false);
		precio.setId(false);
		precio.setLength(20);
		precio.setGroup("cabecero");
		precio.setPersistible(true);
		precio.setValue("");
		precio.setValidation("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([A-Z]|[0-9]){2}([A]|[0-9]){1})?$");
		precio.setFormat("Receptor");

		campoInicial.setName("Fecha inicial");
		campoInicial.setFieldName("finicial");
		campoInicial.setCss("form-control");
		campoInicial.setOrder(7);
		campoInicial.setComponentType("texto");
		campoInicial.setReadOnly(false);
		campoInicial.setHidden(false);
		campoInicial.setRequired(true);
		campoInicial.setShowInBasket(true);
		campoInicial.setValue("");
		campoInicial.setId(false);
		campoInicial.setLength(20);
		campoInicial.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		campoInicial.setFormat("yyyy-MM-dd");

		campoFinal.setName("Fecha final");
		campoFinal.setFieldName("ffinal");
		campoFinal.setCss("form-control");
		campoFinal.setOrder(8);
		campoFinal.setComponentType("texto");
		campoFinal.setReadOnly(false);
		campoFinal.setHidden(false);
		campoFinal.setRequired(true);
		campoFinal.setShowInBasket(true);
		campoFinal.setValue("");
		campoFinal.setId(false);
		campoFinal.setLength(20);
		campoFinal.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		campoFinal.setFormat("yyyy-MM-dd");

		idsolicitud.setName("Folio SAT");
		idsolicitud.setFieldName("idsolicitud");
		idsolicitud.setCss("form-control");
		idsolicitud.setOrder(9);
		idsolicitud.setComponentType("texto");
		idsolicitud.setReadOnly(true);
		idsolicitud.setHidden(true);
		idsolicitud.setRequired(false);
		idsolicitud.setShowInBasket(true);
		idsolicitud.setId(false);
		idsolicitud.setLength(20);
		idsolicitud.setGroup("cabecero");
		idsolicitud.setPersistible(true);
		idsolicitud.setFormat("Folio Sat");
		idsolicitud.setValue("");


		decoradorIdsolicitud.setName("Folio SAT");
		decoradorIdsolicitud.setFieldName("idsolicitud");
		decoradorIdsolicitud.setCss("form-control");
		decoradorIdsolicitud.setOrder(9);
		decoradorIdsolicitud.setComponentType("texto");
		decoradorIdsolicitud.setReadOnly(true);
		decoradorIdsolicitud.setHidden(false);
		decoradorIdsolicitud.setRequired(false);
		decoradorIdsolicitud.setShowInBasket(true);
		decoradorIdsolicitud.setId(false);
		decoradorIdsolicitud.setLength(20);
		decoradorIdsolicitud.setGroup("cabecero");
		decoradorIdsolicitud.setPersistible(true);
		decoradorIdsolicitud.setFormat("Folio Sat");
		decoradorIdsolicitud.setValue("");

		idsPaquetes.setName("ID de paquete");
		idsPaquetes.setFieldName("idspaquetes");
		idsPaquetes.setCss("form-control");
		idsPaquetes.setOrder(10);
		idsPaquetes.setComponentType("texto");
		idsPaquetes.setReadOnly(false);
		idsPaquetes.setHidden(true);
		idsPaquetes.setRequired(false);
		idsPaquetes.setShowInBasket(true);
		idsPaquetes.setId(false);
		idsPaquetes.setLength(20);
		idsPaquetes.setGroup("cabecero");
		idsPaquetes.setPersistible(true);
		idsPaquetes.setFormat("ID de paquete");
		idsPaquetes.setValue("");

		decoradorIdpaquete.setName("ID de paquete");
		decoradorIdpaquete.setFieldName("idspaquetes");
		decoradorIdpaquete.setCss("form-control");
		decoradorIdpaquete.setOrder(10);
		decoradorIdpaquete.setComponentType("texto");
		decoradorIdpaquete.setReadOnly(true);
		decoradorIdpaquete.setHidden(false);
		decoradorIdpaquete.setRequired(false);
		decoradorIdpaquete.setShowInBasket(true);
		decoradorIdpaquete.setId(false);
		decoradorIdpaquete.setLength(20);
		decoradorIdpaquete.setGroup("cabecero");
		decoradorIdpaquete.setPersistible(true);
		decoradorIdpaquete.setFormat("ID de paquete");
		decoradorIdpaquete.setValue("");

		decoradoresSolicitud.add(decoradorIdsolicitud);
		decoradoresPaquete.add(decoradorIdsolicitud);
		decoradoresPaquete.add(decoradorIdpaquete);

		campoStatus.setName("Status");
		campoStatus.setFieldName("status");
		campoStatus.setCss("form-control");
		campoStatus.setOrder(11);
		campoStatus.setComponentType("texto");
		campoStatus.setReadOnly(true);
		campoStatus.setHidden(false);
		campoStatus.setRequired(false);
		campoStatus.setShowInBasket(true);
		campoStatus.setId(false);
		campoStatus.setLength(20);
		campoStatus.setGroup("cabecero");
		campoStatus.setPersistible(true);
		campoStatus.setFormat("Folio Sat");
		campoStatus.setValue("nuevo");

		campos.add(campoNombre);
		campos.add(campoCodigo);
		campos.add(precio);
		campos.add(factor);
		campos.add(campoStatus);
		campos.add(idsolicitud);
		campos.add(campoInicial);
		campos.add(campoFinal);
		campos.add(idsPaquetes);

		forma.setModel(campos);
		forma.setMethods(acciones);
		forma.setCommandName("guardar");
		forma.setName("masiva");
		forma.setView("masiva");
		forma.setTitle("Solicitud de masiva");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("solicitud");
		forma.setBasket("masiva");
		forma.setCreateable(false);
		forma.setTable("masiva");
		forma.setValidate(true);

		forma.getDecorators().put("nuevo,detalle", decoradoresSolicitud);
		forma.getDecorators().put("validar", decoradoresPaquete);

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


	@Test
	public void testGuardarFormaInformacion() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("informacion.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Enviar peticion de informacion");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("informacion");
		guardar.setModule("solicitud");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
guardar.setInstruction("Registro guardado satisfactoriamente");

		/*Accion eliminar = new Accion();
		eliminar.setAccion("actualizar");
		eliminar.setNombre("actualizar");
		eliminar.setTitulo("Actualizar");
		eliminar.setType("botonjs");
		eliminar.setCss("btn btn-secondary");
		eliminar.setForma("informacion");
		eliminar.setModulo("solicitud");
		eliminar.setOrden(5);
		eliminar.setTipo("forma");
		eliminar.setVersion("1.0");
		eliminar.setEvento("detalle");

		Accion login = new Accion();
		login.setAccion("login");
		login.setNombre("login");
		login.setTitulo("Login");
		login.setType("submit");
		login.setCss("btn btn-secondary");
		login.setForma("informacion");
		login.setModulo("solicitud");
		login.setOrden(6);
		login.setTipo("forma");
		login.setVersion("1.0");
		login.setEvento("inicio");
		login.setVista("login");

		Accion firmarse = new Accion();
		firmarse.setAccion("firmarse");
		firmarse.setNombre("firmarse");
		firmarse.setTitulo("Ingresar al sistema");
		firmarse.setType("submit");
		firmarse.setCss("btn btn-secondary");
		firmarse.setForma("informacion");
		firmarse.setModulo("solicitud");
		firmarse.setOrden(6);
		firmarse.setTipo("forma");
		firmarse.setVersion("1.0");
		firmarse.setEvento("login");
		firmarse.setVista("usuario");*/

		acciones.add(guardar);
		/*acciones.add(cancelar);
		acciones.add(eliminar);
		acciones.add(login);
		acciones.add(firmarse);*/

		Resource forma = new Resource();

		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();

		Field status = new Field();
		Field regimen = new Field();
		Field persona = new Field();
		Field uso = new Field();

		Field rfc = new Field();
		Field curp = new Field();

		Field contacto = new Field();
		Field celular = new Field();
		Field usuario = new Field();
		Field clave = new Field();

		Field vendedor = new Field();
		Field zona = new Field();
		//Campo lprecios = new Campo();

		Field credito = new Field();
		Field tipo = new Field();
		
		Field campoComs = new Field();

		tipo.setName("Tipo");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setValue("informacion");
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setFormat("{TIPO}");

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(true);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setFormat("{TIPO-CONS}");
		campoCodigo.setValue("");

		campoCampo.setName("Nombre");
		campoCampo.setFieldName("nombre");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(3);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);
		campoCampo.setLength(150);
		campoCampo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoCampo.setGroup("cabecero");
		campoCampo.setPersistible(true);
		campoCampo.setFormat("Nombre");
		campoCampo.setValue("");

		/*
		 * aMaterno.setNombre("A. Materno"); aMaterno.setBd("amaterno");
		 * aMaterno.setCss("form-control"); aMaterno.setOrden(3);
		 * aMaterno.setType("texto"); aMaterno.setLectura(false);
		 * aMaterno.setOculto(false); aMaterno.setRequerido(true);
		 * aMaterno.setLista(true); aMaterno.setId(false); aMaterno.setLongitud(100);
		 * 
		 * aPaterno.setNombre("A. Paterno"); aPaterno.setBd("apaterno");
		 * aPaterno.setCss("form-control"); aPaterno.setOrden(4);
		 * aPaterno.setType("texto"); aPaterno.setLectura(false);
		 * aPaterno.setOculto(false); aPaterno.setRequerido(true);
		 * aPaterno.setLista(true); aPaterno.setId(false); aPaterno.setLongitud(100);
		 */
		fNacim.setName("Fecha de alta");
		fNacim.setFieldName("falta");
		fNacim.setCss("form-control");
		fNacim.setOrder(4);
		fNacim.setComponentType("fecha");
		fNacim.setReadOnly(true);
		fNacim.setHidden(false);
		fNacim.setRequired(true);
		fNacim.setShowInBasket(true);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fNacim.setGroup("cabecero");
		fNacim.setPersistible(true);
		fNacim.setFormat("yyyy-MM-dd");
		//fNacim.setValor("");
		fNacim.setValue("${hoyCorto}");


		status.setName("Status"); 
		status.setFieldName("status");
		status.setCss("form-control"); 
		status.setOrder(5); 
		status.setComponentType("status");
		status.setReadOnly(true); 
		status.setHidden(true); 
		status.setRequired(true);
		status.setShowInBasket(true); 
		status.setId(false); 
		status.setValue("Activo");
		status.setLength(20); 
		status.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		status.setGroup("cabecero"); 
		status.setPersistible(true); 
		status.setFormat("Status");



		regimen.setName("Regimen fiscal");
		regimen.setFieldName("regimen");
		regimen.setCss("form-control");
		regimen.setOrder(6);
		regimen.setComponentType("regimen");
		regimen.setReadOnly(false);
		regimen.setHidden(false);
		regimen.setRequired(true);
		regimen.setShowInBasket(true);
		regimen.setId(false);
		regimen.setLength(3);
		regimen.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		regimen.setGroup("cabecero");
		regimen.setPersistible(true);
		regimen.setFormat("Regimen fiscal");
		regimen.setValue("");


		persona.setName("Tipo de persona");
		persona.setFieldName("persona");
		persona.setCss("form-control");
		persona.setOrder(7);
		persona.setComponentType("persona");
		persona.setReadOnly(false);
		persona.setHidden(false);
		persona.setRequired(true);
		persona.setShowInBasket(true);
		persona.setId(false);
		persona.setLength(6);
		persona.setValidation("^[ía-zA-Z0-9,.;:_'\\s-]+$");
		persona.setGroup("cabecero");
		persona.setPersistible(true);
		persona.setFormat("Tipo de persona");
		persona.setValue("");

		uso.setName("Uso de comprobantes");
		uso.setFieldName("uso");
		uso.setCss("form-control");
		uso.setOrder(8);
		uso.setComponentType("uso");
		uso.setReadOnly(false);
		uso.setHidden(false);
		uso.setRequired(true);
		uso.setShowInBasket(true);
		uso.setId(false);
		uso.setLength(3);
		uso.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		uso.setGroup("cabecero");
		uso.setPersistible(true);
		uso.setFormat("Uso de comprobantes");
		uso.setValue("");

		rfc.setName("RFC");
		rfc.setFieldName("rfc");
		rfc.setCss("form-control");
		rfc.setOrder(9);
		rfc.setComponentType("texto");
		rfc.setReadOnly(false);
		rfc.setHidden(false);
		rfc.setRequired(true);
		rfc.setShowInBasket(true);
		rfc.setId(false);
		rfc.setLength(20);
		rfc.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		rfc.setGroup("cabecero");
		rfc.setPersistible(true);
		rfc.setFormat("RFC");
		rfc.setValue("");

		curp.setName("CURP");
		curp.setFieldName("curp");
		curp.setCss("form-control");
		curp.setOrder(10);
		curp.setComponentType("texto");
		curp.setReadOnly(false);
		curp.setHidden(false);
		curp.setRequired(false);
		curp.setShowInBasket(true);
		curp.setId(false);
		curp.setLength(18);
		curp.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		curp.setGroup("cabecero");
		curp.setPersistible(true);
		curp.setFormat("CURP");
		curp.setValue("");

		contacto.setName("Contacto");
		contacto.setFieldName("contacto");
		contacto.setCss("form-control");
		contacto.setOrder(11);
		contacto.setComponentType("texto");
		contacto.setReadOnly(false);
		contacto.setHidden(false);
		contacto.setRequired(false);
		contacto.setShowInBasket(true);
		contacto.setId(false);
		contacto.setLength(100);
		contacto.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		contacto.setGroup("cabecero");
		contacto.setPersistible(true);
		contacto.setFormat("Contacto");
		contacto.setValue("");

		celular.setName("No. tel.");
		celular.setFieldName("celular");
		celular.setCss("form-control");
		celular.setOrder(12);
		celular.setComponentType("texto");
		celular.setReadOnly(false);
		celular.setHidden(false);
		celular.setRequired(true);
		celular.setShowInBasket(true);
		celular.setId(false);
		celular.setLength(30);
		celular.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		celular.setGroup("cabecero");
		celular.setPersistible(true);
		celular.setFormat("No. tel.");
		celular.setValue("");

		usuario.setName("Correo elec.");
		usuario.setFieldName("usuario");
		usuario.setCss("form-control");
		usuario.setOrder(13);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(true);
		usuario.setShowInBasket(true);
		usuario.setId(false);
		usuario.setLength(50);
		usuario.setValidation("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setFormat("Correo elec.");
		usuario.setValue("");

		clave.setName("Clave de acceso");
		clave.setFieldName("clave");
		clave.setCss("form-control");
		clave.setOrder(14);
		clave.setComponentType("texto");
		clave.setReadOnly(false);
		clave.setHidden(false);
		clave.setRequired(true);
		clave.setShowInBasket(true);
		clave.setId(false);
		clave.setLength(10);
		clave.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		clave.setGroup("cabecero");
		clave.setPersistible(true);
		clave.setFormat("Clave de acceso");
		clave.setValue("");

		vendedor.setName("Vendedor");
		vendedor.setFieldName("vendedor");
		vendedor.setCss("form-control");
		vendedor.setOrder(15);
		vendedor.setComponentType("texto");
		vendedor.setReadOnly(false);
		vendedor.setHidden(false);
		vendedor.setRequired(false);
		vendedor.setShowInBasket(true);
		vendedor.setId(false);
		vendedor.setLength(10);
		vendedor.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		vendedor.setGroup("cabecero");
		vendedor.setPersistible(true);
		vendedor.setFormat("Vendedor");
		vendedor.setValue("");

		zona.setName("Zona");
		zona.setFieldName("zona");
		zona.setCss("form-control");
		zona.setOrder(16);
		zona.setComponentType("texto");
		zona.setReadOnly(false);
		zona.setHidden(false);
		zona.setRequired(false);
		zona.setShowInBasket(true);
		zona.setId(false);
		zona.setLength(10);
		zona.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		zona.setGroup("cabecero");
		zona.setPersistible(true);
		zona.setFormat("Zona");
		zona.setValue("");

		/*
		 * lprecios.setNombre("Lista de precios"); lprecios.setBd("lprecio");
		 * lprecios.setCss("form-control"); lprecios.setOrden(17);
		 * lprecios.setType("texto"); lprecios.setLectura(false);
		 * lprecios.setOculto(false); lprecios.setRequerido(true);
		 * lprecios.setLista(true); lprecios.setId(false); lprecios.setLongitud(10);
		 * lprecios.setValidacion("^[a-zA-Z0-9,.;:_'\\s-]+$");
		 * lprecios.setGrupo("cabecero"); lprecios.setPersistible(true);
		 * lprecios.setAutogenerado(false); lprecios.setFormato("Lista de precios");
		 */

		credito.setName("Credito");
		credito.setFieldName("credito");
		credito.setCss("form-control");
		credito.setOrder(18);
		credito.setComponentType("moneda");
		credito.setReadOnly(false);
		credito.setHidden(false);
		credito.setRequired(false);
		credito.setShowInBasket(true);
		credito.setId(false);
		credito.setLength(10);
		credito.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		//credito.setGrupo("cantidades");
		credito.setGroup("cabecero");
		credito.setPersistible(true);
		credito.setFormat("Credito");
		credito.setValue("0");

		campoComs.setName("Comentarios");
		campoComs.setFieldName("comentarios");
		campoComs.setCss("form-control");
		campoComs.setOrder(19);
		campoComs.setComponentType("textoarea");
		campoComs.setReadOnly(false);
		campoComs.setHidden(false);
		campoComs.setRequired(false);
		campoComs.setShowInBasket(true);
		campoComs.setId(false);
		campoComs.setLength(10);
		campoComs.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		//campoComs.setGrupo("cantidades");
		campoComs.setGroup("cabecero");
		campoComs.setPersistible(true);
		campoComs.setFormat("Comentarios");
		campoComs.setValue("");
		
		//campos.add(aPaterno);
		campos.add(fNacim);
		//campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(status);
		campos.add(regimen);
		campos.add(persona);
		campos.add(uso);
		campos.add(rfc);
		campos.add(curp);

		campos.add(contacto);
		campos.add(celular);
		campos.add(usuario);
		campos.add(clave);

		//campos.add(vendedor);
		//campos.add(zona);
		//campos.add(lprecios);

		//campos.add(credito);
		campos.add(tipo);
		campos.add(campoComs);
		forma.setMethods(acciones);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("informacion");
		forma.setTitle("Solicitud de Informacion");
		forma.setView("informacion");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("solicitud");
		forma.setBasket("informacion");
		forma.setCreateable(false);
		forma.setTable("dircto");
		forma.setValidate(true);
		forma.setInstruction("Ingrese la informacion solicitada");
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

	@Test
	public void testGuardarFormaRegistrarse() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("registrarse.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Enviar petiion de Registro");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("registrarse");
		guardar.setModule("solicitud");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		guardar.setInstruction("Registro guardado satisfactoriamente, le estaremos enviando un correo de confirmacion para finalizar la activacion de su registro.");

		/*Accion eliminar = new Accion();
		eliminar.setAccion("actualizar");
		eliminar.setNombre("actualizar");
		eliminar.setTitulo("Actualizar");
		eliminar.setType("botonjs");
		eliminar.setCss("btn btn-secondary");
		eliminar.setForma("informacion");
		eliminar.setModulo("solicitud");
		eliminar.setOrden(5);
		eliminar.setTipo("forma");
		eliminar.setVersion("1.0");
		eliminar.setEvento("detalle");

		Accion login = new Accion();
		login.setAccion("login");
		login.setNombre("login");
		login.setTitulo("Login");
		login.setType("submit");
		login.setCss("btn btn-secondary");
		login.setForma("informacion");
		login.setModulo("solicitud");
		login.setOrden(6);
		login.setTipo("forma");
		login.setVersion("1.0");
		login.setEvento("inicio");
		login.setVista("login");

		Accion firmarse = new Accion();
		firmarse.setAccion("firmarse");
		firmarse.setNombre("firmarse");
		firmarse.setTitulo("Ingresar al sistema");
		firmarse.setType("submit");
		firmarse.setCss("btn btn-secondary");
		firmarse.setForma("informacion");
		firmarse.setModulo("solicitud");
		firmarse.setOrden(6);
		firmarse.setTipo("forma");
		firmarse.setVersion("1.0");
		firmarse.setEvento("login");
		firmarse.setVista("usuario");*/

		acciones.add(guardar);
		/*acciones.add(cancelar);
		acciones.add(eliminar);
		acciones.add(login);
		acciones.add(firmarse);*/

		Resource forma = new Resource();

		Field campoCodigo = new Field();
		Field campoCampo = new Field();
		Field aMaterno = new Field();
		Field aPaterno = new Field();
		Field fNacim = new Field();

		Field status = new Field();
		Field regimen = new Field();
		Field persona = new Field();
		Field uso = new Field();

		Field rfc = new Field();
		Field curp = new Field();

		Field contacto = new Field();
		Field celular = new Field();
		Field usuario = new Field();
		Field clave = new Field();
		Field claveDec = new Field();
		Field claveNuevo = new Field();

		Field vendedor = new Field();
		Field zona = new Field();
		//Campo lprecios = new Campo();

		Field credito = new Field();
		Field tipo = new Field();
		
		Field campoActivo = new Field();
		Field campoSalt = new Field();
		Field campoToken = new Field();
		
		Field campoActivoDec = new Field();
		Field campoSaltDec = new Field();
		Field campoTokenDec = new Field();
		

		List<Field> decoradoresDetalle = new ArrayList<Field>();
		List<Field> decoradoresNuevo = new ArrayList<Field>();
		
		tipo.setName("Tipo");
		tipo.setFieldName("tipo");
		tipo.setCss("form-control");
		tipo.setOrder(1);
		tipo.setComponentType("texto");
		tipo.setReadOnly(true);
		tipo.setHidden(true);
		tipo.setRequired(false);
		tipo.setShowInBasket(true);
		tipo.setId(false);
		tipo.setValue("registrarse");
		tipo.setLength(20);
		tipo.setGroup("cabecero");
		tipo.setPersistible(true);
		tipo.setFormat("{TIPO}");

		campoCodigo.setName("Codigo");
		campoCodigo.setFieldName("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrder(2);
		campoCodigo.setComponentType("texto");
		campoCodigo.setReadOnly(true);
		campoCodigo.setHidden(true);
		campoCodigo.setRequired(false);
		campoCodigo.setShowInBasket(true);
		campoCodigo.setId(true);
		campoCodigo.setLength(20);
		campoCodigo.setGroup("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setFormat("{TIPO-CONS}");
		campoCodigo.setValue("");

		campoCampo.setName("Nombre completo");
		campoCampo.setFieldName("nombre");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(3);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);
		campoCampo.setLength(150);
		campoCampo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoCampo.setGroup("cabecero");
		campoCampo.setPersistible(true);
		campoCampo.setFormat("Nombre");
		campoCampo.setValue("");

		/*
		 * aMaterno.setNombre("A. Materno"); aMaterno.setBd("amaterno");
		 * aMaterno.setCss("form-control"); aMaterno.setOrden(3);
		 * aMaterno.setType("texto"); aMaterno.setLectura(false);
		 * aMaterno.setOculto(false); aMaterno.setRequerido(true);
		 * aMaterno.setLista(true); aMaterno.setId(false); aMaterno.setLongitud(100);
		 * 
		 * aPaterno.setNombre("A. Paterno"); aPaterno.setBd("apaterno");
		 * aPaterno.setCss("form-control"); aPaterno.setOrden(4);
		 * aPaterno.setType("texto"); aPaterno.setLectura(false);
		 * aPaterno.setOculto(false); aPaterno.setRequerido(true);
		 * aPaterno.setLista(true); aPaterno.setId(false); aPaterno.setLongitud(100);
		 */
		fNacim.setName("Fecha de alta");
		fNacim.setFieldName("falta");
		fNacim.setCss("form-control");
		fNacim.setOrder(4);
		fNacim.setComponentType("fecha");
		fNacim.setReadOnly(true);
		fNacim.setHidden(false);
		fNacim.setRequired(true);
		fNacim.setShowInBasket(true);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setValidation("^\\d{4}-\\d{2}-\\d{2}$");
		fNacim.setGroup("cabecero");
		fNacim.setPersistible(true);
		fNacim.setFormat("yyyy-MM-dd");
		//fNacim.setValor("");
		fNacim.setValue("${hoyCorto}");


		status.setName("Status"); 
		status.setFieldName("status");
		status.setCss("form-control"); 
		status.setOrder(5); 
		status.setComponentType("status");
		status.setReadOnly(true); 
		status.setHidden(true); 
		status.setRequired(true);
		status.setShowInBasket(true); 
		status.setId(false); 
		status.setValue("Activo");
		status.setLength(20); 
		status.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		status.setGroup("cabecero"); 
		status.setPersistible(true);
		status.setFormat("Status");



		regimen.setName("Regimen fiscal");
		regimen.setFieldName("regimen");
		regimen.setCss("form-control");
		regimen.setOrder(6);
		regimen.setComponentType("regimen");
		regimen.setReadOnly(false);
		regimen.setHidden(false);
		regimen.setRequired(true);
		regimen.setShowInBasket(true);
		regimen.setId(false);
		regimen.setLength(3);
		regimen.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		regimen.setGroup("cabecero");
		regimen.setPersistible(true);
		regimen.setFormat("Regimen fiscal");
		regimen.setValue("");


		persona.setName("Tipo de persona");
		persona.setFieldName("persona");
		persona.setCss("form-control");
		persona.setOrder(7);
		persona.setComponentType("persona");
		persona.setReadOnly(false);
		persona.setHidden(false);
		persona.setRequired(true);
		persona.setShowInBasket(true);
		persona.setId(false);
		persona.setLength(6);
		persona.setValidation("^[ía-zA-Z0-9,.;:_'\\s-]+$");
		persona.setGroup("cabecero");
		persona.setPersistible(true);
		persona.setFormat("Tipo de persona");
		persona.setValue("");

		uso.setName("Uso de comprobantes");
		uso.setFieldName("uso");
		uso.setCss("form-control");
		uso.setOrder(8);
		uso.setComponentType("uso");
		uso.setReadOnly(false);
		uso.setHidden(false);
		uso.setRequired(true);
		uso.setShowInBasket(true);
		uso.setId(false);
		uso.setLength(3);
		uso.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		uso.setGroup("cabecero");
		uso.setPersistible(true);
		uso.setFormat("Uso de comprobantes");
		uso.setValue("");

		rfc.setName("RFC");
		rfc.setFieldName("rfc");
		rfc.setCss("form-control");
		rfc.setOrder(9);
		rfc.setComponentType("texto");
		rfc.setReadOnly(false);
		rfc.setHidden(false);
		rfc.setRequired(false);
		rfc.setShowInBasket(true);
		rfc.setId(false);
		rfc.setLength(20);
		rfc.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		rfc.setGroup("cabecero");
		rfc.setPersistible(true);
		rfc.setFormat("RFC");
		rfc.setValue("");

		curp.setName("CURP");
		curp.setFieldName("curp");
		curp.setCss("form-control");
		curp.setOrder(10);
		curp.setComponentType("texto");
		curp.setReadOnly(false);
		curp.setHidden(false);
		curp.setRequired(false);
		curp.setShowInBasket(true);
		curp.setId(false);
		curp.setLength(18);
		curp.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		curp.setGroup("cabecero");
		curp.setPersistible(true);
		curp.setFormat("CURP");
		curp.setValue("");

		contacto.setName("Contacto");
		contacto.setFieldName("contacto");
		contacto.setCss("form-control");
		contacto.setOrder(11);
		contacto.setComponentType("texto");
		contacto.setReadOnly(false);
		contacto.setHidden(false);
		contacto.setRequired(false);
		contacto.setShowInBasket(true);
		contacto.setId(false);
		contacto.setLength(100);
		contacto.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		contacto.setGroup("cabecero");
		contacto.setPersistible(true);
		contacto.setFormat("Contacto");
		contacto.setValue("");

		celular.setName("No. tel.");
		celular.setFieldName("celular");
		celular.setCss("form-control");
		celular.setOrder(12);
		celular.setComponentType("texto");
		celular.setReadOnly(false);
		celular.setHidden(false);
		celular.setRequired(false);
		celular.setShowInBasket(true);
		celular.setId(false);
		celular.setLength(30);
		celular.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		celular.setGroup("cabecero");
		celular.setPersistible(true);
		celular.setFormat("No. tel.");
		celular.setValue("");

		usuario.setName("Correo elec.");
		usuario.setFieldName("usuario");
		usuario.setCss("form-control");
		usuario.setOrder(13);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(true);
		usuario.setShowInBasket(true);
		usuario.setId(false);
		usuario.setLength(50);
		usuario.setValidation("^(.+)@(.+)$");
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setFormat("Correo elec.");
		usuario.setValue("");

		clave.setName("Clave de acceso");
		clave.setFieldName("clave");
		clave.setCss("form-control");
		clave.setOrder(14);
		clave.setComponentType("password");
		clave.setReadOnly(false);
		clave.setHidden(false);
		clave.setRequired(true);
		clave.setShowInBasket(true);
		clave.setId(false);
		clave.setLength(10);
		clave.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		clave.setGroup("cabecero");
		clave.setPersistible(true);
		clave.setFormat("Clave de acceso");
		clave.setValue("");
		
		claveDec.setName("Clave de acceso");
		claveDec.setFieldName("clave");
		claveDec.setCss("form-control");
		claveDec.setOrder(14);
		claveDec.setComponentType("password");
		claveDec.setReadOnly(true);
		claveDec.setHidden(false);
		claveDec.setRequired(true);
		claveDec.setShowInBasket(true);
		claveDec.setId(false);
		claveDec.setLength(10);
		claveDec.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		claveDec.setGroup("cabecero");
		claveDec.setPersistible(true);
		claveDec.setFormat("Clave de acceso");
		claveDec.setValue("");

		claveNuevo.setName("Clave de acceso");
		claveNuevo.setFieldName("clave");
		claveNuevo.setCss("form-control");
		claveNuevo.setOrder(14);
		claveNuevo.setComponentType("password");
		claveNuevo.setReadOnly(false);
		claveNuevo.setHidden(false);
		claveNuevo.setRequired(true);
		claveNuevo.setShowInBasket(true);
		claveNuevo.setId(false);
		claveNuevo.setLength(10);
		claveNuevo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		claveNuevo.setGroup("cabecero");
		claveNuevo.setPersistible(true);
		claveNuevo.setFormat("Clave de acceso");
		claveNuevo.setValue("");
		
		vendedor.setName("Vendedor");
		vendedor.setFieldName("vendedor");
		vendedor.setCss("form-control");
		vendedor.setOrder(15);
		vendedor.setComponentType("texto");
		vendedor.setReadOnly(false);
		vendedor.setHidden(false);
		vendedor.setRequired(false);
		vendedor.setShowInBasket(true);
		vendedor.setId(false);
		vendedor.setLength(10);
		vendedor.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		vendedor.setGroup("cabecero");
		vendedor.setPersistible(true);
		vendedor.setFormat("Vendedor");
		vendedor.setValue("");

		zona.setName("Zona");
		zona.setFieldName("zona");
		zona.setCss("form-control");
		zona.setOrder(16);
		zona.setComponentType("texto");
		zona.setReadOnly(false);
		zona.setHidden(false);
		zona.setRequired(false);
		zona.setShowInBasket(true);
		zona.setId(false);
		zona.setLength(10);
		zona.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		zona.setGroup("cabecero");
		zona.setPersistible(true);
		zona.setFormat("Zona");
		zona.setValue("");

		/*
		 * lprecios.setNombre("Lista de precios"); lprecios.setBd("lprecio");
		 * lprecios.setCss("form-control"); lprecios.setOrden(17);
		 * lprecios.setType("texto"); lprecios.setLectura(false);
		 * lprecios.setOculto(false); lprecios.setRequerido(true);
		 * lprecios.setLista(true); lprecios.setId(false); lprecios.setLongitud(10);
		 * lprecios.setValidacion("^[a-zA-Z0-9,.;:_'\\s-]+$");
		 * lprecios.setGrupo("cabecero"); lprecios.setPersistible(true);
		 * lprecios.setAutogenerado(false); lprecios.setFormato("Lista de precios");
		 */

		credito.setName("Crédito");
		credito.setFieldName("credito");
		credito.setCss("form-control");
		credito.setOrder(18);
		credito.setComponentType("moneda");
		credito.setReadOnly(false);
		credito.setHidden(false);
		credito.setRequired(false);
		credito.setShowInBasket(true);
		credito.setId(false);
		credito.setLength(10);
		credito.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		//credito.setGrupo("cantidades");
		credito.setGroup("cabecero");
		credito.setPersistible(true);
		credito.setFormat("Crédito");
		credito.setValue("0");
		
		
		campoActivo.setName("Activo");
		campoActivo.setFieldName("activo");
		campoActivo.setCss("form-control");
		campoActivo.setOrder(20);
		campoActivo.setComponentType("texto");
		campoActivo.setReadOnly(true);
		campoActivo.setHidden(false);
		campoActivo.setRequired(true);
		campoActivo.setShowInBasket(true);
		campoActivo.setId(false);
		campoActivo.setLength(50);
		campoActivo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoActivo.setGroup("cabecero");
		campoActivo.setPersistible(true);
		campoActivo.setFormat("Activo");
		campoActivo.setValue("no");
		
		campoActivoDec.setName("Activo");
		campoActivoDec.setFieldName("activo");
		campoActivoDec.setCss("form-control");
		campoActivoDec.setOrder(20);
		campoActivoDec.setComponentType("texto");
		campoActivoDec.setReadOnly(true);
		campoActivoDec.setHidden(true);
		campoActivoDec.setRequired(true);
		campoActivoDec.setShowInBasket(true);
		campoActivoDec.setId(false);
		campoActivoDec.setLength(50);
		campoActivoDec.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoActivoDec.setGroup("cabecero");
		campoActivoDec.setPersistible(true);
		campoActivoDec.setFormat("Activo");
		campoActivoDec.setValue("no");
		
		campoSalt.setName("salt");
		campoSalt.setFieldName("salt");
		campoSalt.setCss("form-control");
		campoSalt.setOrder(21);
		campoSalt.setComponentType("texto");
		campoSalt.setReadOnly(true);
		campoSalt.setHidden(false);
		campoSalt.setRequired(false);
		campoSalt.setShowInBasket(true);
		campoSalt.setId(false);
		campoSalt.setLength(150);
		campoSalt.setValidation("");
		campoSalt.setGroup("cabecero");
		campoSalt.setPersistible(true);
		campoSalt.setFormat("Salt");
		campoSalt.setValue("");
		
		campoSaltDec.setName("salt");
		campoSaltDec.setFieldName("salt");
		campoSaltDec.setCss("form-control");
		campoSaltDec.setOrder(21);
		campoSaltDec.setComponentType("texto");
		campoSaltDec.setReadOnly(true);
		campoSaltDec.setHidden(false);
		campoSaltDec.setRequired(false);
		campoSaltDec.setShowInBasket(true);
		campoSaltDec.setId(false);
		campoSaltDec.setLength(150);
		campoSaltDec.setValidation("");
		campoSaltDec.setGroup("cabecero");
		campoSaltDec.setPersistible(true);
		campoSaltDec.setFormat("Salt");
		campoSaltDec.setValue("");
		
		campoToken.setName("token");
		campoToken.setFieldName("token");
		campoToken.setCss("form-control");
		campoToken.setOrder(22);
		campoToken.setComponentType("texto");
		campoToken.setReadOnly(true);
		campoToken.setHidden(false);
		campoToken.setRequired(false);
		campoToken.setShowInBasket(true);
		campoToken.setId(false);
		campoToken.setLength(150);
		campoToken.setValidation("");
		campoToken.setGroup("cabecero");
		campoToken.setPersistible(true);
		campoToken.setFormat("token");
		campoToken.setValue("");
		
		campoTokenDec.setName("token");
		campoTokenDec.setFieldName("token");
		campoTokenDec.setCss("form-control");
		campoTokenDec.setOrder(22);
		campoTokenDec.setComponentType("texto");
		campoTokenDec.setReadOnly(true);
		campoTokenDec.setHidden(false);
		campoTokenDec.setRequired(false);
		campoTokenDec.setShowInBasket(true);
		campoTokenDec.setId(false);
		campoTokenDec.setLength(150);
		campoTokenDec.setValidation("");
		campoTokenDec.setGroup("cabecero");
		campoTokenDec.setPersistible(true);
		campoTokenDec.setFormat("token");
		campoTokenDec.setValue("");
		
		//campos.add(aPaterno);
		campos.add(fNacim);
		//campos.add(aMaterno);
		campos.add(campoCampo);
		campos.add(campoCodigo);
		campos.add(status);
		campos.add(regimen);
		campos.add(persona);
		campos.add(uso);
		campos.add(rfc);
		campos.add(curp);

		campos.add(contacto);
		campos.add(celular);
		campos.add(usuario);
		campos.add(clave);

		campos.add(campoActivo);
		campos.add(campoSalt);
		campos.add(campoToken);

		//campos.add(credito);
		campos.add(tipo);
		
		decoradoresDetalle.add(claveDec);
		decoradoresDetalle.add(campoSaltDec);
		decoradoresDetalle.add(campoTokenDec);
		decoradoresDetalle.add(campoActivoDec);
		
		decoradoresNuevo.add(claveNuevo);
		decoradoresNuevo.add(campoSaltDec);
		decoradoresNuevo.add(campoTokenDec);
		decoradoresNuevo.add(campoActivoDec);
		
		
		forma.setMethods(acciones);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("registrarse");
		forma.setTitle("Solicitud de Registro");
		forma.setView("registrarse");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("solicitud");
		forma.setBasket("registrarse");
		forma.setCreateable(false);
		forma.setTable("dircto");
		forma.setValidate(true);
		forma.setInstruction("Ingrese la informacion solicitada, para requisitar su registro, para seguimiento, se le enviara un correo electronico.");
		forma.getDecorators().put("nuevo", decoradoresNuevo);
		forma.getDecorators().put("detalle", decoradoresDetalle);
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
	
	@Test
	public void testGuardarFormaTraza() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("traza.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(templatesPath);
		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();


		Button guardar = new Button();
		guardar.setCommandName("guardar");
		guardar.setName("guardar");
		guardar.setLabel("Guardar");
		guardar.setComponentType("botonjs");
		guardar.setCss("btn btn-primary");
		guardar.setResourceName("traza");
		guardar.setModule("sistema");
		guardar.setOrder(1);
		guardar.setResourceType("forma");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		guardar.setInstruction("Registro guardado satisfactoriamente");

		/*Accion eliminar = new Accion();
		eliminar.setAccion("actualizar");
		eliminar.setNombre("actualizar");
		eliminar.setTitulo("Actualizar");
		eliminar.setType("botonjs");
		eliminar.setCss("btn btn-secondary");
		eliminar.setForma("informacion");
		eliminar.setModulo("solicitud");
		eliminar.setOrden(5);
		eliminar.setTipo("forma");
		eliminar.setVersion("1.0");
		eliminar.setEvento("detalle");

		Accion login = new Accion();
		login.setAccion("login");
		login.setNombre("login");
		login.setTitulo("Login");
		login.setType("submit");
		login.setCss("btn btn-secondary");
		login.setForma("informacion");
		login.setModulo("solicitud");
		login.setOrden(6);
		login.setTipo("forma");
		login.setVersion("1.0");
		login.setEvento("inicio");
		login.setVista("login");

		Accion firmarse = new Accion();
		firmarse.setAccion("firmarse");
		firmarse.setNombre("firmarse");
		firmarse.setTitulo("Ingresar al sistema");
		firmarse.setType("submit");
		firmarse.setCss("btn btn-secondary");
		firmarse.setForma("informacion");
		firmarse.setModulo("solicitud");
		firmarse.setOrden(6);
		firmarse.setTipo("forma");
		firmarse.setVersion("1.0");
		firmarse.setEvento("login");
		firmarse.setVista("usuario");*/

		acciones.add(guardar);
		/*acciones.add(cancelar);
		acciones.add(eliminar);
		acciones.add(login);
		acciones.add(firmarse);*/

		Resource forma = new Resource();

		//Campo campoCodigo = new Campo();
		Field campoCampo = new Field();
		Field fNacim = new Field();

		Field status = new Field();
		Field regimen = new Field();
		//Campo uso = new Campo();

		//Campo rfc = new Campo();
		//Campo curp = new Campo();

		//Campo contacto = new Campo();
		Field celular = new Field();
		Field usuario = new Field();
		Field clave = new Field();
		Field sessionId = new Field();
		Field cId = new Field();
		Field accion = new Field();
		//Campo accion = new Campo();

		//Campo tipo = new Campo();

		/*tipo.setNombre("Tipo");
		tipo.setBd("tipo");
		tipo.setCss("form-control");
		tipo.setOrden(1);
		tipo.setType("texto");
		tipo.setLectura(true);
		tipo.setOculto(true);
		tipo.setRequerido(false);
		tipo.setLista(true);
		tipo.setId(false);
		tipo.setValor("traza");
		tipo.setLongitud(20);
		tipo.setGrupo("cabecero");
		tipo.setPersistible(true);
		tipo.setAutogenerado(true);
		tipo.setFormato("{TIPO}");

		campoCodigo.setNombre("Codigo");
		campoCodigo.setBd("codigo");
		campoCodigo.setCss("form-control");
		campoCodigo.setOrden(2);
		campoCodigo.setType("texto");
		campoCodigo.setLectura(true);
		campoCodigo.setOculto(true);
		campoCodigo.setRequerido(false);
		campoCodigo.setLista(true);
		campoCodigo.setId(true);
		campoCodigo.setLongitud(20);
		campoCodigo.setGrupo("cabecero");
		campoCodigo.setPersistible(true);
		campoCodigo.setAutogenerado(true);
		campoCodigo.setFormato("{TIPO-CONS}");
		campoCodigo.setValor("");*/

		campoCampo.setName("Nombre");
		campoCampo.setFieldName("nombre");
		campoCampo.setCss("form-control");
		campoCampo.setOrder(3);
		campoCampo.setComponentType("texto");
		campoCampo.setReadOnly(false);
		campoCampo.setHidden(false);
		campoCampo.setRequired(true);
		campoCampo.setShowInBasket(true);
		campoCampo.setId(false);
		campoCampo.setLength(150);
		campoCampo.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		campoCampo.setGroup("cabecero");
		campoCampo.setPersistible(true);
		campoCampo.setFormat("Nombre");
		campoCampo.setValue("");

		/*
		 * aMaterno.setNombre("A. Materno"); aMaterno.setBd("amaterno");
		 * aMaterno.setCss("form-control"); aMaterno.setOrden(3);
		 * aMaterno.setType("texto"); aMaterno.setLectura(false);
		 * aMaterno.setOculto(false); aMaterno.setRequerido(true);
		 * aMaterno.setLista(true); aMaterno.setId(false); aMaterno.setLongitud(100);
		 * 
		 * aPaterno.setNombre("A. Paterno"); aPaterno.setBd("apaterno");
		 * aPaterno.setCss("form-control"); aPaterno.setOrden(4);
		 * aPaterno.setType("texto"); aPaterno.setLectura(false);
		 * aPaterno.setOculto(false); aPaterno.setRequerido(true);
		 * aPaterno.setLista(true); aPaterno.setId(false); aPaterno.setLongitud(100);
		 */
		fNacim.setName("Fecha/Hora de alta");
		fNacim.setFieldName("fechayhora");
		fNacim.setCss("form-control");
		fNacim.setOrder(4);
		fNacim.setComponentType("fechayhora");
		fNacim.setReadOnly(false);
		fNacim.setHidden(false);
		fNacim.setRequired(true);
		fNacim.setShowInBasket(true);
		fNacim.setId(false);
		fNacim.setLength(20);
		fNacim.setValidation("^([0-2][0-9]{3})\\-(0[1-9]|1[0-2])\\-([0-2][0-9]|3[0-1]) ([0-1][0-9]|2[0-3]):([0-5][0-9])\\:([0-5][0-9])( ([\\-\\+]([0-1][0-9])\\:00))?$");
		fNacim.setGroup("cabecero");
		fNacim.setPersistible(true);
		fNacim.setFormat("yyyy-MM-dd hh:mm");
		fNacim.setValue("");

		status.setName("Status"); 
		status.setFieldName("status");
		status.setCss("form-control"); 
		status.setOrder(5); 
		status.setComponentType("status");
		status.setReadOnly(true); 
		status.setHidden(true); 
		status.setRequired(true);
		status.setShowInBasket(true); 
		status.setId(false); 
		status.setValue("");
		status.setLength(20); 
		status.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		status.setGroup("cabecero"); 
		status.setPersistible(true);
		status.setFormat("Status");



		regimen.setName("Valor");
		regimen.setFieldName("valor");
		regimen.setCss("form-control");
		regimen.setOrder(6);
		regimen.setComponentType("texto");
		regimen.setReadOnly(false);
		regimen.setHidden(false);
		regimen.setRequired(true);
		regimen.setShowInBasket(true);
		regimen.setId(false);
		regimen.setLength(50);
		regimen.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		regimen.setGroup("cabecero");
		regimen.setPersistible(true);
		regimen.setFormat("Valor");
		regimen.setValue("");


		celular.setName("Usuario");
		celular.setFieldName("usuario");
		celular.setCss("form-control");
		celular.setOrder(7);
		celular.setComponentType("texto");
		celular.setReadOnly(false);
		celular.setHidden(false);
		celular.setRequired(true);
		celular.setShowInBasket(true);
		celular.setId(false);
		celular.setLength(30);
		celular.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		celular.setGroup("cabecero");
		celular.setPersistible(true);
		celular.setFormat("Usuario");
		celular.setValue("");

		usuario.setName("Forma");
		usuario.setFieldName("forma");
		usuario.setCss("form-control");
		usuario.setOrder(8);
		usuario.setComponentType("texto");
		usuario.setReadOnly(false);
		usuario.setHidden(false);
		usuario.setRequired(true);
		usuario.setShowInBasket(true);
		usuario.setId(false);
		usuario.setLength(50);
		usuario.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		usuario.setGroup("cabecero");
		usuario.setPersistible(true);
		usuario.setFormat("Forma");
		usuario.setValue("");

		clave.setName("Modulo");
		clave.setFieldName("modulo");
		clave.setCss("form-control");
		clave.setOrder(9);
		clave.setComponentType("texto");
		clave.setReadOnly(false);
		clave.setHidden(false);
		clave.setRequired(true);
		clave.setShowInBasket(true);
		clave.setId(false);
		clave.setLength(10);
		clave.setValidation("^[a-zA-Z0-9,.;:_'\\s-]+$");
		clave.setGroup("cabecero");
		clave.setPersistible(true);
		clave.setFormat("Modulo");
		clave.setValue("");

		sessionId.setName("Id Sesion");
		sessionId.setFieldName("sessionid");
		sessionId.setCss("form-control");
		sessionId.setOrder(10);
		sessionId.setComponentType("texto");
		sessionId.setReadOnly(false);
		sessionId.setHidden(false);
		sessionId.setRequired(false);
		sessionId.setShowInBasket(false);
		sessionId.setId(false);
		sessionId.setLength(50);
		sessionId.setGroup("cabecero");
		sessionId.setPersistible(true);
		sessionId.setFormat("Id Sesion");
		sessionId.setValue("");
		
		accion.setName("Accion");
		accion.setFieldName("accion");
		accion.setCss("form-control");
		accion.setOrder(11);
		accion.setComponentType("texto");
		accion.setReadOnly(false);
		accion.setHidden(false);
		accion.setRequired(false);
		accion.setShowInBasket(false);
		accion.setId(false);
		accion.setLength(50);
		accion.setGroup("cabecero");
		accion.setPersistible(true);
		accion.setFormat("Accion");
		accion.setValue("");
		
		cId.setName("Corralation");
		cId.setFieldName("cId");
		cId.setCss("form-control");
		cId.setOrder(12);
		cId.setComponentType("texto");
		cId.setReadOnly(false);
		cId.setHidden(false);
		cId.setRequired(false);
		cId.setShowInBasket(false);
		cId.setId(false);
		cId.setLength(50);
		cId.setGroup("cabecero");
		cId.setPersistible(true);
		cId.setFormat("");
		cId.setValue("");
		
		campos.add(fNacim);
		//campos.add(regimen);
		campos.add(campoCampo);
		//campos.add(campoCodigo);
		campos.add(status);
		campos.add(regimen);
		campos.add(celular);
		campos.add(usuario);
		campos.add(clave);

		//campos.add(vendedor);
		//campos.add(zona);
		//campos.add(lprecios);

		//campos.add(credito);
		//campos.add(tipo);
		campos.add(sessionId);
		campos.add(accion);
		campos.add(cId);
		
		forma.setMethods(acciones);
		forma.setModel(campos);
		forma.setCommandName("guardar");
		forma.setName("traza");
		forma.setTitle("Solicitud de traza");
		forma.setView("traza");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("sistema");
		forma.setBasket("traza");
		forma.setCreateable(false);
		forma.setTable("traza");
		forma.setValidate(true);
		forma.setInstruction("Ingrese la informacion solicitada");
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