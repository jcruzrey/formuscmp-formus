/**
 * 
 */
package com.mio.canasta.generador;

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
import com.formuscmp.formus.resource.Resource;

/**
 * @author jcruzrey
 *
 */
public class GeneradorHtmlTest {
	
	@Test
	public void testGuardarFormaDocumento() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_documento.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSat = new Field();
		Field campoDescripcion = new Field();
		Field campoTipo = new Field();
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("documento");
		exportar.setModule("documentos");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		/*Accion buscar = new Accion();
		buscar.setAccion("buscar");
		buscar.setNombre("buscar");
		buscar.setTitulo("Mostrar filtros");
		buscar.setType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setForma("documento");
		buscar.setModulo("documentos");
		buscar.setOrden(3);
		buscar.setTipo("form");
		buscar.setVersion("1.0");
		buscar.setEvento("nuevo");*/
		
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Buscar");
		buscar.setComponentType("submit");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("documento");
		buscar.setModule("documentos");
		buscar.setOrder(2);
		buscar.setResourceType("basket");
		buscar.setVersion("3.3");
		buscar.setEvents("nuevo,buscar");
		
		Button mostrar = new Button();
		mostrar.setCommandName("filtros");
		mostrar.setName("filtros");
		mostrar.setLabel("Mostrar filtros");
		mostrar.setComponentType("botonliga");
		mostrar.setCss("btn btn-secondary");
		mostrar.setResourceName("documento");
		mostrar.setModule("documentos");
		mostrar.setOrder(2);
		mostrar.setResourceType("form");
		mostrar.setVersion("1.0");
		mostrar.setEvents("nuevo,buscar");
		
		Button detalleProducto = new Button();
		detalleProducto.setCommandName("detalle");
		detalleProducto.setName("detalleIngreso");
		detalleProducto.setLabel("Detalles");
		detalleProducto.setComponentType("submit");
		detalleProducto.setCss("btn btn-success");
		detalleProducto.setResourceName("ingreso");
		detalleProducto.setModule("comprobantes");
		detalleProducto.setOrder(4);
		detalleProducto.setResourceType("form");
		detalleProducto.setVersion("3.3");
		detalleProducto.setEvents("nuevo,buscar");
		
		Button detalleServicio = new Button();
		detalleServicio.setCommandName("detalle");
		detalleServicio.setName("detalleServicio");
		detalleServicio.setLabel("Detalles");
		detalleServicio.setComponentType("submit");
		detalleServicio.setCss("btn btn-success");
		detalleServicio.setResourceName("documento");
		detalleServicio.setModule("documentos");
		detalleServicio.setOrder(4);
		detalleServicio.setResourceType("form");
		detalleServicio.setVersion("1.0");
		detalleServicio.setEvents("nuevo,buscar");
		
		Button detallePedido = new Button();
		detallePedido.setCommandName("detalle");
		detallePedido.setName("detallePedido");
		detallePedido.setLabel("Detalles");
		detallePedido.setComponentType("submit");
		detallePedido.setCss("btn btn-success");
		detallePedido.setResourceName("pedido");
		detallePedido.setModule("solicitud");
		detallePedido.setOrder(4);
		detallePedido.setResourceType("form");
		detallePedido.setVersion("1.0");
		detallePedido.setEvents("nuevo,buscar");
		
		Button detalleOCompra = new Button();
		detalleOCompra.setCommandName("detalle");
		detalleOCompra.setName("detalleOcompra");
		detalleOCompra.setLabel("Detalles");
		detalleOCompra.setComponentType("submit");
		detalleOCompra.setCss("btn btn-success");
		detalleOCompra.setResourceName("ocompra");
		detalleOCompra.setModule("solicitud");
		detalleOCompra.setOrder(4);
		detalleOCompra.setResourceType("form");
		detalleOCompra.setVersion("1.0");
		detalleOCompra.setEvents("nuevo,buscar");
		
		Button detalleRemision = new Button();
		detalleRemision.setCommandName("detalle");
		detalleRemision.setName("detalleRemision");
		detalleRemision.setLabel("Detalles");
		detalleRemision.setComponentType("submit");
		detalleRemision.setCss("btn btn-success");
		detalleRemision.setResourceName("remision");
		detalleRemision.setModule("solicitud");
		detalleRemision.setOrder(5);
		detalleRemision.setResourceType("form");
		detalleRemision.setVersion("1.0");
		detalleRemision.setEvents("nuevo,buscar");
		
		Button detalleCotizacion = new Button();
		detalleCotizacion.setCommandName("detalle");
		detalleCotizacion.setName("detalleCotizacion");
		detalleCotizacion.setLabel("Detalles");
		detalleCotizacion.setComponentType("submit");
		detalleCotizacion.setCss("btn btn-success");
		detalleCotizacion.setResourceName("cotizacion");
		detalleCotizacion.setModule("solicitud");
		detalleCotizacion.setOrder(5);
		detalleCotizacion.setResourceType("form");
		detalleCotizacion.setVersion("1.0");
		detalleCotizacion.setEvents("nuevo,buscar");
		
		Button detalleReservacion = new Button();
		detalleReservacion.setCommandName("prevista");
		detalleReservacion.setName("detalleReservacion");
		detalleReservacion.setLabel("Ver");
		detalleReservacion.setComponentType("submit");
		detalleReservacion.setCss("btn btn-success");
		detalleReservacion.setResourceName("reservacion");
		detalleReservacion.setModule("solicitud");
		detalleReservacion.setOrder(6);
		detalleReservacion.setResourceType("form");
		detalleReservacion.setVersion("1.0");
		detalleReservacion.setEvents("nuevo,buscar");
		detalleReservacion.setView("prevista");
		
		Button detalleEmpresa = new Button();
		detalleEmpresa.setCommandName("detalle");
		detalleEmpresa.setName("detalleEmpresa");
		detalleEmpresa.setLabel("Detalles");
		detalleEmpresa.setComponentType("submit");
		detalleEmpresa.setCss("btn btn-success");
		detalleEmpresa.setResourceName("empresa");
		detalleEmpresa.setModule("directorio");
		detalleEmpresa.setOrder(7);
		detalleEmpresa.setResourceType("form");
		detalleEmpresa.setVersion("1.0");
		detalleEmpresa.setEvents("nuevo,buscar");
		
		Button agregar = new Button();
		agregar.setCommandName("agregar");
		agregar.setName("agregar");
		agregar.setLabel("Agregar a carrito");
		agregar.setComponentType("botonjs");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("documento");
		agregar.setModule("documentos");
		agregar.setOrder(8);
		agregar.setResourceType("form");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSat.setFieldName("receptor");
		campoSat.setName("Receptor");
		campoSat.setHidden(false);
		campoSat.setOrder(3);
		campoSat.setComponentType("texto");
		campoSat.setLength(1);
		campoSat.setShowInBasket(true);
		
		campoDescripcion.setFieldName("obs");
		campoDescripcion.setName("Observaciones");
		campoDescripcion.setHidden(false);
		campoDescripcion.setOrder(3);
		campoDescripcion.setComponentType("texto");
		campoDescripcion.setLength(1);
		campoDescripcion.setShowInBasket(true);
		
		campoTipo.setFieldName("tipo");
		campoTipo.setName("Tipo");
		campoTipo.setHidden(false);
		campoTipo.setOrder(4);
		campoTipo.setComponentType("texto");
		campoTipo.setLength(1);
		campoTipo.setShowInBasket(true);
		
		campos.add(campoFolio);
		campos.add(campoSat);
		campos.add(campoDescripcion);
		campos.add(campoTipo);
		
		acciones.add(exportar);
		acciones.add(mostrar);
		acciones.add(buscar);
		acciones.add(detalleProducto);
		acciones.add(detalleServicio);
		acciones.add(detallePedido);
		acciones.add(detalleOCompra);
		
		acciones.add(detalleCotizacion);
		acciones.add(detalleRemision);
		acciones.add(detalleEmpresa);
		acciones.add(detalleReservacion);
		acciones.add(agregar);

		
		forma.setModel(campos);
		forma.setName("documento");
		forma.setTitle("Documentos");
		forma.setVersion("3.3");
		forma.setStatus("produccion");
		forma.setModule("documentos");
		forma.setView("documento");
		forma.setTable("doctos");
		forma.setMethods(acciones);
		forma.setCreateable(true);
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

		Path filePath = fileConfigLocation.resolve("canasta_comprobante.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSat = new Field();
		Field campoDescripcion = new Field();
		Field campoTipo = new Field();
		Field campoStatus = new Field();
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("prodserv");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("prodserv");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");
		
		Button detalleProducto = new Button();
		detalleProducto.setCommandName("detalle");
		detalleProducto.setName("detalleIngreso");
		detalleProducto.setLabel("Detalles");
		detalleProducto.setComponentType("submit");
		detalleProducto.setCss("btn btn-success");
		detalleProducto.setResourceName("ingreso");
		detalleProducto.setModule("comprobantes");
		detalleProducto.setOrder(4);
		detalleProducto.setResourceType("form");
		detalleProducto.setVersion("3.3");
		detalleProducto.setEvents("nuevo");
		
		Button detallePedido = new Button();
		detallePedido.setCommandName("detalle");
		detallePedido.setName("detallePedido");
		detallePedido.setLabel("Detalles");
		detallePedido.setComponentType("submit");
		detallePedido.setCss("btn btn-success");
		detallePedido.setResourceName("pedido");
		detallePedido.setModule("solicitud");
		detallePedido.setOrder(5);
		detallePedido.setResourceType("form");
		detallePedido.setVersion("1.0");
		detallePedido.setEvents("nuevo");
		
		Button detalleServicio = new Button();
		detalleServicio.setCommandName("detalle");
		detalleServicio.setName("detalleServicio");
		detalleServicio.setLabel("Detalles");
		detalleServicio.setComponentType("submit");
		detalleServicio.setCss("btn btn-success");
		detalleServicio.setResourceName("comprobante");
		detalleServicio.setModule("comprobantes");
		detalleServicio.setOrder(6);
		detalleServicio.setResourceType("form");
		detalleServicio.setVersion("1.0");
		detalleServicio.setEvents("nuevo");
		
		Button detalleCotizacion = new Button();
		detalleCotizacion.setCommandName("detalle");
		detalleCotizacion.setName("detalleCotizacion");
		detalleCotizacion.setLabel("Detalles");
		detalleCotizacion.setComponentType("submit");
		detalleCotizacion.setCss("btn btn-success");
		detalleCotizacion.setResourceName("comprobante");
		detalleCotizacion.setModule("comprobantes");
		detalleCotizacion.setOrder(7);
		detalleCotizacion.setResourceType("form");
		detalleCotizacion.setVersion("1.0");
		detalleCotizacion.setEvents("nuevo");
		
		Button agregar = new Button();
		agregar.setCommandName("agregar");
		agregar.setName("agregar");
		agregar.setLabel("Agregar a carrito");
		agregar.setComponentType("botonjs");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("carrito");
		agregar.setModule("solicitud");
		agregar.setOrder(8);
		agregar.setResourceType("form");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSat.setFieldName("receptor");
		campoSat.setName("Receptor");
		campoSat.setHidden(false);
		campoSat.setOrder(3);
		campoSat.setComponentType("texto");
		campoSat.setLength(1);
		campoSat.setShowInBasket(true);
		
		campoDescripcion.setFieldName("obs");
		campoDescripcion.setName("Observaciones");
		campoDescripcion.setHidden(false);
		campoDescripcion.setOrder(3);
		campoDescripcion.setComponentType("texto");
		campoDescripcion.setLength(1);
		campoDescripcion.setShowInBasket(true);
		
		campoTipo.setFieldName("tipo");
		campoTipo.setName("Tipo");
		campoTipo.setHidden(false);
		campoTipo.setOrder(4);
		campoTipo.setComponentType("texto");
		campoTipo.setLength(1);
		campoTipo.setShowInBasket(true);
		
		
		campoStatus.setFieldName("status");
		campoStatus.setName("Status");
		campoStatus.setHidden(false);
		campoStatus.setOrder(4);
		campoStatus.setComponentType("texto");
		campoStatus.setLength(1);
		campoStatus.setShowInBasket(true);
		
		campos.add(campoFolio);
		campos.add(campoSat);
		campos.add(campoDescripcion);
		campos.add(campoTipo);
		campos.add(campoStatus);
		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalleProducto);
		acciones.add(detallePedido);
		acciones.add(detalleServicio);
		acciones.add(agregar);
		acciones.add(detalleCotizacion);
		
		forma.setModel(campos);
		forma.setName("comprobante");
		forma.setTitle("Comprobantes");
		forma.setVersion("3.3");
		forma.setStatus("produccion");
		forma.setModule("comprobantes");
		forma.setView("comprobante");
		forma.setTable("doctos");
		forma.setMethods(acciones);
		forma.setCreateable(false);
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
	public void testGuardarIngreso() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_ingreso.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("comprobante");
		exportar.setModule("comprobantes");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);

		campos.add(campoFolio);
		acciones.add(exportar);
		
		forma.setModel(campos);
		forma.setName("ingreso");
		forma.setTitle("Comprobantes");
		forma.setVersion("3.3");
		forma.setStatus("produccion");
		forma.setModule("comprobantes");
		forma.setView("ingreso");
		forma.setTable("doctos");
		forma.setMethods(acciones);
		forma.setCreateable(false);
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
	public void testGuardarRemision() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_remision.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSat = new Field();
		Field campoDescripcion = new Field();
		Field campoTipo = new Field();
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("documento");
		exportar.setModule("documentos");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("documento");
		buscar.setModule("documentos");
		buscar.setOrder(3);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");
		
		Button detalleProducto = new Button();
		detalleProducto.setCommandName("detalle");
		detalleProducto.setName("detalleIngreso");
		detalleProducto.setLabel("Detalles");
		detalleProducto.setComponentType("submit");
		detalleProducto.setCss("btn btn-success");
		detalleProducto.setResourceName("ingreso");
		detalleProducto.setModule("comprobantes");
		detalleProducto.setOrder(4);
		detalleProducto.setResourceType("form");
		detalleProducto.setVersion("3.3");
		detalleProducto.setEvents("nuevo");
		
		Button detalleServicio = new Button();
		detalleServicio.setCommandName("detalle");
		detalleServicio.setName("detalleServicio");
		detalleServicio.setLabel("Detalles");
		detalleServicio.setComponentType("submit");
		detalleServicio.setCss("btn btn-success");
		detalleServicio.setResourceName("documento");
		detalleServicio.setModule("documentos");
		detalleServicio.setOrder(4);
		detalleServicio.setResourceType("form");
		detalleServicio.setVersion("1.0");
		detalleServicio.setEvents("nuevo");
		
		Button detallePedido = new Button();
		detallePedido.setCommandName("detalle");
		detallePedido.setName("detallePedido");
		detallePedido.setLabel("Detalles");
		detallePedido.setComponentType("submit");
		detallePedido.setCss("btn btn-success");
		detallePedido.setResourceName("pedido");
		detallePedido.setModule("solicitud");
		detallePedido.setOrder(4);
		detallePedido.setResourceType("form");
		detallePedido.setVersion("1.0");
		detallePedido.setEvents("nuevo");
		
		Button detalleOCompra = new Button();
		detalleOCompra.setCommandName("detalle");
		detalleOCompra.setName("detalleOcompra");
		detalleOCompra.setLabel("Detalles");
		detalleOCompra.setComponentType("submit");
		detalleOCompra.setCss("btn btn-success");
		detalleOCompra.setResourceName("ocompra");
		detalleOCompra.setModule("solicitud");
		detalleOCompra.setOrder(4);
		detalleOCompra.setResourceType("form");
		detalleOCompra.setVersion("1.0");
		detalleOCompra.setEvents("nuevo");
		
		Button agregar = new Button();
		agregar.setCommandName("agregar");
		agregar.setName("agregar");
		agregar.setLabel("Agregar a carrito");
		agregar.setComponentType("botonjs");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("documento");
		agregar.setModule("documentos");
		agregar.setOrder(5);
		agregar.setResourceType("form");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSat.setFieldName("receptor");
		campoSat.setName("Receptor");
		campoSat.setHidden(false);
		campoSat.setOrder(3);
		campoSat.setComponentType("texto");
		campoSat.setLength(1);
		campoSat.setShowInBasket(true);
		
		campoDescripcion.setFieldName("obs");
		campoDescripcion.setName("Observaciones");
		campoDescripcion.setHidden(false);
		campoDescripcion.setOrder(3);
		campoDescripcion.setComponentType("texto");
		campoDescripcion.setLength(1);
		campoDescripcion.setShowInBasket(true);
		
		campoTipo.setFieldName("tipo");
		campoTipo.setName("Tipo");
		campoTipo.setHidden(false);
		campoTipo.setOrder(4);
		campoTipo.setComponentType("texto");
		campoTipo.setLength(1);
		campoTipo.setShowInBasket(true);
		
		campos.add(campoFolio);
		campos.add(campoSat);
		campos.add(campoDescripcion);
		campos.add(campoTipo);
		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalleProducto);
		acciones.add(detalleServicio);
		acciones.add(detallePedido);
		acciones.add(detalleOCompra);
		
		acciones.add(agregar);

		
		forma.setModel(campos);
		forma.setName("remision");
		forma.setTitle("Remisiones");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("documentos");
		forma.setView("remision");
		forma.setTable("doctos");
		forma.setMethods(acciones);
		forma.setCreateable(false);
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
	public void testGuardarReservacion() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_reservacion.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSat = new Field();
		Field campoDescripcion = new Field();
		Field campoTipo = new Field();
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("documento");
		exportar.setModule("documentos");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("documento");
		buscar.setModule("documentos");
		buscar.setOrder(3);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");
		
		Button detalleProducto = new Button();
		detalleProducto.setCommandName("detalle");
		detalleProducto.setName("detalleIngreso");
		detalleProducto.setLabel("Detalles");
		detalleProducto.setComponentType("submit");
		detalleProducto.setCss("btn btn-success");
		detalleProducto.setResourceName("ingreso");
		detalleProducto.setModule("comprobantes");
		detalleProducto.setOrder(4);
		detalleProducto.setResourceType("form");
		detalleProducto.setVersion("3.3");
		detalleProducto.setEvents("nuevo");
		
		Button detalleServicio = new Button();
		detalleServicio.setCommandName("detalle");
		detalleServicio.setName("detalleServicio");
		detalleServicio.setLabel("Detalles");
		detalleServicio.setComponentType("submit");
		detalleServicio.setCss("btn btn-success");
		detalleServicio.setResourceName("documento");
		detalleServicio.setModule("documentos");
		detalleServicio.setOrder(4);
		detalleServicio.setResourceType("form");
		detalleServicio.setVersion("1.0");
		detalleServicio.setEvents("nuevo");
		
		Button detallePedido = new Button();
		detallePedido.setCommandName("detalle");
		detallePedido.setName("detallePedido");
		detallePedido.setLabel("Detalles");
		detallePedido.setComponentType("submit");
		detallePedido.setCss("btn btn-success");
		detallePedido.setResourceName("pedido");
		detallePedido.setModule("solicitud");
		detallePedido.setOrder(4);
		detallePedido.setResourceType("form");
		detallePedido.setVersion("1.0");
		detallePedido.setEvents("nuevo");
		
		Button detalleOCompra = new Button();
		detalleOCompra.setCommandName("detalle");
		detalleOCompra.setName("detalleOcompra");
		detalleOCompra.setLabel("Detalles");
		detalleOCompra.setComponentType("submit");
		detalleOCompra.setCss("btn btn-success");
		detalleOCompra.setResourceName("ocompra");
		detalleOCompra.setModule("solicitud");
		detalleOCompra.setOrder(4);
		detalleOCompra.setResourceType("form");
		detalleOCompra.setVersion("1.0");
		detalleOCompra.setEvents("nuevo");
		
		Button agregar = new Button();
		agregar.setCommandName("agregar");
		agregar.setName("agregar");
		agregar.setLabel("Agregar a carrito");
		agregar.setComponentType("botonjs");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("documento");
		agregar.setModule("documentos");
		agregar.setOrder(5);
		agregar.setResourceType("form");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSat.setFieldName("receptor");
		campoSat.setName("Receptor");
		campoSat.setHidden(false);
		campoSat.setOrder(3);
		campoSat.setComponentType("texto");
		campoSat.setLength(1);
		campoSat.setShowInBasket(true);
		
		campoDescripcion.setFieldName("obs");
		campoDescripcion.setName("Observaciones");
		campoDescripcion.setHidden(false);
		campoDescripcion.setOrder(3);
		campoDescripcion.setComponentType("texto");
		campoDescripcion.setLength(1);
		campoDescripcion.setShowInBasket(true);
		
		campoTipo.setFieldName("tipo");
		campoTipo.setName("Tipo");
		campoTipo.setHidden(false);
		campoTipo.setOrder(4);
		campoTipo.setComponentType("texto");
		campoTipo.setLength(1);
		campoTipo.setShowInBasket(true);
		
		campos.add(campoFolio);
		campos.add(campoSat);
		campos.add(campoDescripcion);
		campos.add(campoTipo);
		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalleProducto);
		acciones.add(detalleServicio);
		acciones.add(detallePedido);
		acciones.add(detalleOCompra);
		
		acciones.add(agregar);

		
		forma.setModel(campos);
		forma.setName("remision");
		forma.setTitle("Remisiones");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("documentos");
		forma.setView("remision");
		forma.setTable("doctos");
		forma.setMethods(acciones);
		forma.setCreateable(false);
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
	public void testGuardarCancelacion() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_cancelacion.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("comprobante");
		exportar.setModule("comprobantes");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);

		campos.add(campoFolio);
		acciones.add(exportar);
		
		forma.setModel(campos);
		forma.setName("cancelacion");
		forma.setTitle("Cancelaciones");
		forma.setVersion("3.3");
		forma.setStatus("produccion");
		forma.setModule("comprobantes");
		forma.setView("cancelacion");
		forma.setTable("doctos");
		forma.setMethods(acciones);
		forma.setCreateable(false);
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
	public void testGuardarFormaOrdenCompra() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_ocompra.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		
		Field campoFolio = new Field();
		Field campoSat = new Field();
		Field campoDescripcion = new Field();
		Field campoTipo = new Field();
		Field campoStatus = new Field();
		
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("producto");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Buscar");
		buscar.setComponentType("submit");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("directorio");
		buscar.setModule("directorio");
		buscar.setOrder(2);
		buscar.setResourceType("basket");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo,buscar");
		
		Button filtro = new Button();
		filtro.setCommandName("filtros");
		filtro.setName("filtros");
		filtro.setLabel("Mostrar filtros");
		filtro.setComponentType("botonliga");
		filtro.setCss("btn btn-secondary");
		filtro.setResourceName("producto");
		filtro.setModule("inventario");
		filtro.setOrder(2);
		filtro.setResourceType("form");
		filtro.setVersion("1.0");
		filtro.setEvents("nuevo,buscar");
		
		Button guardar = new Button();
		guardar.setCommandName("detalle");
		guardar.setName("detalle");
		guardar.setLabel("Detalles");
		guardar.setComponentType("submit");
		guardar.setCss("btn btn-secondary");
		guardar.setResourceName("ocompra");
		guardar.setModule("solicitud");
		guardar.setOrder(3);
		guardar.setResourceType("form");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");

		
		
		
		
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSat.setFieldName("receptor");
		campoSat.setName("Receptor");
		campoSat.setHidden(false);
		campoSat.setOrder(3);
		campoSat.setComponentType("texto");
		campoSat.setLength(1);
		campoSat.setShowInBasket(true);
		
		campoDescripcion.setFieldName("obs");
		campoDescripcion.setName("Observaciones");
		campoDescripcion.setHidden(false);
		campoDescripcion.setOrder(3);
		campoDescripcion.setComponentType("texto");
		campoDescripcion.setLength(1);
		campoDescripcion.setShowInBasket(true);
		
		campoTipo.setFieldName("tipo");
		campoTipo.setName("Tipo");
		campoTipo.setHidden(false);
		campoTipo.setOrder(4);
		campoTipo.setComponentType("texto");
		campoTipo.setLength(1);
		campoTipo.setShowInBasket(true);
		
		
		campoStatus.setFieldName("status");
		campoStatus.setName("Status");
		campoStatus.setHidden(false);
		campoStatus.setOrder(4);
		campoStatus.setComponentType("texto");
		campoStatus.setLength(1);
		campoStatus.setShowInBasket(true);
		
		campos.add(campoFolio);
		campos.add(campoSat);
		campos.add(campoDescripcion);
		campos.add(campoTipo);
		campos.add(campoStatus);
		

		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(filtro);
		acciones.add(guardar);
		
		forma.setModel(campos);
		forma.setName("ocompra");
		forma.setTitle("O. de compra");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("solicitud");
		forma.setView("ocompra");
		forma.setTable("doctos");
		forma.setMethods(acciones);
		forma.setCreateable(false);
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
	public void testCrearCanastaProducto() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_producto.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSat = new Field();
		Field campoDescripcion = new Field();
		Field campoTipo = new Field();
		Resource forma = new Resource();
		List<Field> decoradoresBuscar = new ArrayList<Field>();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("producto");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");
		
		Button detalleProducto = new Button();
		detalleProducto.setCommandName("detalle");
		detalleProducto.setName("detalleProducto");
		detalleProducto.setLabel("Detalles");
		detalleProducto.setComponentType("submit");
		detalleProducto.setCss("btn btn-success");
		detalleProducto.setResourceName("producto");
		detalleProducto.setModule("inventario");
		detalleProducto.setOrder(4);
		detalleProducto.setResourceType("form");
		detalleProducto.setVersion("1.0");
		detalleProducto.setEvents("nuevo");
		
		Button detalleServicio = new Button();
		detalleServicio.setCommandName("detalle");
		detalleServicio.setName("detalleServicio");
		detalleServicio.setLabel("Detalles");
		detalleServicio.setComponentType("submit");
		detalleServicio.setCss("btn btn-success");
		detalleServicio.setResourceName("servicio");
		detalleServicio.setModule("inventario");
		detalleServicio.setOrder(4);
		detalleServicio.setResourceType("form");
		detalleServicio.setVersion("1.0");
		detalleServicio.setEvents("nuevo");
		
		Button agregar = new Button();
		agregar.setCommandName("agregar");
		agregar.setName("agregar");
		agregar.setLabel("Agregar a carrito");
		agregar.setComponentType("botonjs");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("carrito");
		agregar.setModule("solicitud");
		agregar.setOrder(5);
		agregar.setResourceType("form");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		
		Button quitar = new Button();
		quitar.setCommandName("eliminar");
		quitar.setName("eliminar");
		quitar.setLabel("Quitar de carrito");
		quitar.setComponentType("botonjs");
		quitar.setCss("btn btn-secondary");
		quitar.setResourceName("carrito");
		quitar.setModule("solicitud");
		quitar.setOrder(5);
		quitar.setResourceType("form");
		quitar.setVersion("1.0");
		quitar.setEvents("nuevo");
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSat.setFieldName("codigosat");
		campoSat.setName("Codigo SAT");
		campoSat.setHidden(false);
		campoSat.setOrder(3);
		campoSat.setComponentType("texto");
		campoSat.setLength(1);
		campoSat.setShowInBasket(true);
		
		campoDescripcion.setFieldName("descripcion");
		campoDescripcion.setName("Descripcion");
		campoDescripcion.setHidden(false);
		campoDescripcion.setOrder(3);
		campoDescripcion.setComponentType("texto");
		campoDescripcion.setLength(1);
		campoDescripcion.setShowInBasket(true);
		
		campoTipo.setFieldName("tipo");
		campoTipo.setName("Tipo");
		campoTipo.setHidden(false);
		campoTipo.setOrder(4);
		campoTipo.setComponentType("texto");
		campoTipo.setLength(1);
		campoTipo.setShowInBasket(true);
		
		campos.add(campoFolio);
		campos.add(campoSat);
		campos.add(campoDescripcion);
		campos.add(campoTipo);
		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalleProducto);
		acciones.add(detalleServicio);
		acciones.add(agregar);
		acciones.add(quitar);
		
		forma.setModel(campos);
		forma.setName("producto");
		forma.setTitle("Catálogo de Productos");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setView("producto");
		forma.setTable("prodserv");
		forma.setMethods(acciones);
		forma.setCreateable(false);
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
	public void testCrearCanastaKit() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_kit.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSat = new Field();
		Field campoDescripcion = new Field();
		Field campoTipo = new Field();
		Resource forma = new Resource();
		List<Field> decoradoresBuscar = new ArrayList<Field>();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("producto");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");
		
		Button detalleProducto = new Button();
		detalleProducto.setCommandName("detalle");
		detalleProducto.setName("detalleProducto");
		detalleProducto.setLabel("Detalles");
		detalleProducto.setComponentType("submit");
		detalleProducto.setCss("btn btn-success");
		detalleProducto.setResourceName("producto");
		detalleProducto.setModule("inventario");
		detalleProducto.setOrder(4);
		detalleProducto.setResourceType("form");
		detalleProducto.setVersion("1.0");
		detalleProducto.setEvents("nuevo");
		
		Button detalleServicio = new Button();
		detalleServicio.setCommandName("detalle");
		detalleServicio.setName("detalleServicio");
		detalleServicio.setLabel("Detalles");
		detalleServicio.setComponentType("submit");
		detalleServicio.setCss("btn btn-success");
		detalleServicio.setResourceName("servicio");
		detalleServicio.setModule("inventario");
		detalleServicio.setOrder(4);
		detalleServicio.setResourceType("form");
		detalleServicio.setVersion("1.0");
		detalleServicio.setEvents("nuevo");
		
		Button agregar = new Button();
		agregar.setCommandName("agregar");
		agregar.setName("agregar");
		agregar.setLabel("Agregar a carrito");
		agregar.setComponentType("botonjs");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("carrito");
		agregar.setModule("solicitud");
		agregar.setOrder(5);
		agregar.setResourceType("form");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		
		Button quitar = new Button();
		quitar.setCommandName("eliminar");
		quitar.setName("eliminar");
		quitar.setLabel("Quitar de carrito");
		quitar.setComponentType("botonjs");
		quitar.setCss("btn btn-secondary");
		quitar.setResourceName("carrito");
		quitar.setModule("solicitud");
		quitar.setOrder(5);
		quitar.setResourceType("form");
		quitar.setVersion("1.0");
		quitar.setEvents("nuevo");
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSat.setFieldName("codigosat");
		campoSat.setName("Codigo SAT");
		campoSat.setHidden(false);
		campoSat.setOrder(3);
		campoSat.setComponentType("texto");
		campoSat.setLength(1);
		campoSat.setShowInBasket(true);
		
		campoDescripcion.setFieldName("descripcion");
		campoDescripcion.setName("Descripcion");
		campoDescripcion.setHidden(false);
		campoDescripcion.setOrder(3);
		campoDescripcion.setComponentType("texto");
		campoDescripcion.setLength(1);
		campoDescripcion.setShowInBasket(true);
		
		campoTipo.setFieldName("tipo");
		campoTipo.setName("Tipo");
		campoTipo.setHidden(false);
		campoTipo.setOrder(4);
		campoTipo.setComponentType("texto");
		campoTipo.setLength(1);
		campoTipo.setShowInBasket(true);
		
		campos.add(campoFolio);
		campos.add(campoSat);
		campos.add(campoDescripcion);
		campos.add(campoTipo);
		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalleProducto);
		acciones.add(detalleServicio);
		acciones.add(agregar);
		acciones.add(quitar);
		
		forma.setModel(campos);
		forma.setName("kit");
		forma.setTitle("Kit de Productos");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setView("kit");
		forma.setTable("prodserv");
		forma.setMethods(acciones);
		forma.setCreateable(false);
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
	public void testCrearCanastaCaracteristica() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_caracteristica.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSat = new Field();
		Field campoDescripcion = new Field();
		Field campoTipo = new Field();
		Field campoRegistro = new Field();
		Resource forma = new Resource();
		List<Field> decoradoresBuscar = new ArrayList<Field>();
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");
		

		
		Button quitar = new Button();
		quitar.setCommandName("eliminar");
		quitar.setName("eliminar");
		quitar.setLabel("Quitar de carrito");
		quitar.setComponentType("botonjs");
		quitar.setCss("btn btn-secondary");
		quitar.setResourceName("carrito");
		quitar.setModule("solicitud");
		quitar.setOrder(5);
		quitar.setResourceType("form");
		quitar.setVersion("1.0");
		quitar.setEvents("nuevo");
		
		campoFolio.setFieldName("padre");
		campoFolio.setName("Padre");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSat.setFieldName("Origen");
		campoSat.setName("origen");
		campoSat.setHidden(false);
		campoSat.setOrder(3);
		campoSat.setComponentType("texto");
		campoSat.setLength(1);
		campoSat.setShowInBasket(true);
		
		campoDescripcion.setFieldName("nombre");
		campoDescripcion.setName("Nombre");
		campoDescripcion.setHidden(false);
		campoDescripcion.setOrder(3);
		campoDescripcion.setComponentType("texto");
		campoDescripcion.setLength(1);
		campoDescripcion.setShowInBasket(true);
		
		campoTipo.setFieldName("valor");
		campoTipo.setName("Valor");
		campoTipo.setHidden(false);
		campoTipo.setOrder(4);
		campoTipo.setComponentType("texto");
		campoTipo.setLength(1);
		campoTipo.setShowInBasket(true);
		
		campoRegistro.setFieldName("valor");
		campoRegistro.setName("Valor");
		campoRegistro.setHidden(false);
		campoRegistro.setOrder(4);
		campoRegistro.setComponentType("texto");
		campoRegistro.setLength(1);
		campoRegistro.setShowInBasket(true);
		
		campos.add(campoFolio);
		campos.add(campoSat);
		campos.add(campoDescripcion);
		campos.add(campoTipo);
		campos.add(campoRegistro);
		
		acciones.add(buscar);
		acciones.add(quitar);
		
		forma.setModel(campos);
		forma.setName("caracteristica");
		forma.setTitle("Caracteristica");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setView("caracteristica");
		forma.setTable("caracteristica");
		forma.setMethods(acciones);
		forma.setCreateable(false);
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
	public void testCrearCanastaProdServ() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_prodserv.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSat = new Field();
		Field campoDescripcion = new Field();
		Field campoTipo = new Field();
		Field campoStatus = new Field();
		Field campoLPrecio = new Field();
		Field campoNombre = new Field();
		
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("prodserv");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
	
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Buscar");
		buscar.setComponentType("submit");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("prodserv");
		buscar.setModule("inventario");
		buscar.setOrder(2);
		buscar.setResourceType("basket");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo,buscar");
		
		Button mostrar = new Button();
		mostrar.setCommandName("filtros");
		mostrar.setName("filtros");
		mostrar.setLabel("Mostrar filtros");
		mostrar.setComponentType("botonliga");
		mostrar.setCss("btn btn-secondary");
		mostrar.setResourceName("producto");
		mostrar.setModule("inventario");
		mostrar.setOrder(2);
		mostrar.setResourceType("form");
		mostrar.setVersion("1.0");
		mostrar.setEvents("nuevo,buscar");
		
		Button detalleProducto = new Button();
		detalleProducto.setCommandName("detalle");
		detalleProducto.setName("detalleProducto");
		detalleProducto.setLabel("Detalles");
		detalleProducto.setComponentType("submit");
		detalleProducto.setCss("btn btn-success");
		detalleProducto.setResourceName("producto");
		detalleProducto.setModule("inventario");
		detalleProducto.setOrder(4);
		detalleProducto.setResourceType("form");
		detalleProducto.setVersion("1.0");
		detalleProducto.setEvents("nuevo");
		
		Button detalleServicio = new Button();
		detalleServicio.setCommandName("detalle");
		detalleServicio.setName("detalleServicio");
		detalleServicio.setLabel("Detalles");
		detalleServicio.setComponentType("submit");
		detalleServicio.setCss("btn btn-success");
		detalleServicio.setResourceName("servicio");
		detalleServicio.setModule("inventario");
		detalleServicio.setOrder(4);
		detalleServicio.setResourceType("form");
		detalleServicio.setVersion("1.0");
		detalleServicio.setEvents("nuevo");
		
		Button detalleKit = new Button();
		detalleKit.setCommandName("detalle");
		detalleKit.setName("detalleKit");
		detalleKit.setLabel("Detalles");
		detalleKit.setComponentType("submit");
		detalleKit.setCss("btn btn-success");
		detalleKit.setResourceName("kit");
		detalleKit.setModule("inventario");
		detalleKit.setOrder(4);
		detalleKit.setResourceType("form");
		detalleKit.setVersion("1.0");
		detalleKit.setEvents("nuevo");
		
		Button productosKit = new Button();
		productosKit.setCommandName("productos");
		productosKit.setName("productos");
		productosKit.setLabel("Productos");
		productosKit.setComponentType("submit");
		productosKit.setCss("btn btn-success");
		productosKit.setResourceName("kit");
		productosKit.setModule("inventario");
		productosKit.setOrder(4);
		productosKit.setResourceType("basket");
		productosKit.setVersion("1.0");
		productosKit.setEvents("nuevo");
		
		Button agregar = new Button();
		agregar.setCommandName("agregar");
		agregar.setName("agregar");
		agregar.setLabel("Agregar");
		agregar.setComponentType("botonjs");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("carrito");
		agregar.setModule("solicitud");
		agregar.setOrder(5);
		agregar.setResourceType("form");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSat.setFieldName("codigosat");
		campoSat.setName("Codigo SAT");
		campoSat.setHidden(false);
		campoSat.setOrder(3);
		campoSat.setComponentType("texto");
		campoSat.setLength(1);
		campoSat.setShowInBasket(true);
		
		campoDescripcion.setFieldName("descripcion");
		campoDescripcion.setName("Descripcion");
		campoDescripcion.setHidden(false);
		campoDescripcion.setOrder(3);
		campoDescripcion.setComponentType("texto");
		campoDescripcion.setLength(1);
		campoDescripcion.setShowInBasket(true);
		
		campoTipo.setFieldName("tipo");
		campoTipo.setName("Tipo");
		campoTipo.setHidden(false);
		campoTipo.setOrder(4);
		campoTipo.setComponentType("texto");
		campoTipo.setLength(1);
		campoTipo.setShowInBasket(true);
		
		campoStatus.setFieldName("status");
		campoStatus.setName("Status");
		campoStatus.setHidden(false);
		campoStatus.setOrder(4);
		campoStatus.setComponentType("texto");
		campoStatus.setLength(1);
		campoStatus.setShowInBasket(true);
		
		campoLPrecio.setFieldName("lprecio");
		campoLPrecio.setName("Precio");
		campoLPrecio.setHidden(false);
		campoLPrecio.setOrder(5);
		campoLPrecio.setComponentType("texto");
		campoLPrecio.setLength(1);
		campoLPrecio.setShowInBasket(true);
		
		campoNombre.setFieldName("nombre");
		campoNombre.setName("Nombre");
		campoNombre.setHidden(false);
		campoNombre.setOrder(6);
		campoNombre.setComponentType("texto");
		campoNombre.setLength(50);
		campoNombre.setShowInBasket(true);
		
		campos.add(campoFolio);
		campos.add(campoSat);
		campos.add(campoDescripcion);
		campos.add(campoTipo);
		campos.add(campoStatus);
		campos.add(campoLPrecio);
		campos.add(campoNombre);
		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalleProducto);
		acciones.add(detalleServicio);
		acciones.add(detalleKit);
		acciones.add(productosKit);
		acciones.add(agregar);
		acciones.add(mostrar);
		
		forma.setModel(campos);
		forma.setName("prodserv");
		forma.setTitle("Productos/Servicios/Kits");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setView("prodserv");
		forma.setTable("prodserv");
		forma.setMethods(acciones);
		forma.setCreateable(true);
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
	public void testCrearCanastaCarrito() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_carrito.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSubtotal = new Field();
		Field campoDescripcion = new Field();
		Field sessionid = new Field();
		Field status = new Field();
		Field cantidad = new Field();
		Field precio = new Field();
		Resource forma = new Resource();
		
		/*Accion exportar = new Accion();
		exportar.setAccion("exportar");
		exportar.setNombre("exportar");
		exportar.setTitulo("Exportar");
		exportar.setType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setForma("producto");
		exportar.setModulo("inventario");
		exportar.setOrden(1);
		exportar.setTipo("form");
		exportar.setVersion("1.0");
		exportar.setEvento("nuevo");*/
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(2);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");
		
		Button detalle = new Button();
		detalle.setCommandName("detalle");
		detalle.setName("detalle");
		detalle.setLabel("Detalles");
		detalle.setComponentType("submit");
		detalle.setCss("btn btn-success");
		detalle.setResourceName("producto");
		detalle.setModule("inventario");
		detalle.setOrder(3);
		detalle.setResourceType("form");
		detalle.setVersion("1.0");
		detalle.setEvents("nuevo");
		
		Button agregar = new Button();
		agregar.setCommandName("agregar");
		agregar.setName("agregar");
		agregar.setLabel("+");
		agregar.setComponentType("botonjs");
		agregar.setCss("form-control-plaintext");
		agregar.setResourceName("carrito");
		agregar.setModule("solicitud");
		agregar.setOrder(4);
		agregar.setResourceType("form");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		
		Button eliminar = new Button();
		eliminar.setCommandName("eliminar");
		eliminar.setName("eliminar");
		eliminar.setLabel("-");
		eliminar.setComponentType("botonjs");
		eliminar.setCss("form-control-plaintext");
		eliminar.setResourceName("carrito");
		eliminar.setModule("solicitud");
		eliminar.setOrder(5);
		eliminar.setResourceType("form");
		eliminar.setVersion("1.0");
		eliminar.setEvents("nuevo");
		
		Button cotizacion = new Button();
		cotizacion.setCommandName("nuevo");
		cotizacion.setName("nuevaCotizacion");
		cotizacion.setLabel("Cotizacion");
		cotizacion.setComponentType("botonligadd");
		cotizacion.setCss("dropdown-item");
		cotizacion.setResourceName("cotizacion");
		cotizacion.setModule("solicitud");
		cotizacion.setOrder(6);
		cotizacion.setResourceType("form");
		cotizacion.setVersion("1.0");
		cotizacion.setEvents("nuevo");
		
		Button ocompra = new Button();
		ocompra.setCommandName("nuevo");
		ocompra.setName("nuevaOCompra");
		ocompra.setLabel("Orden de Compra");
		ocompra.setComponentType("botonligadd");
		ocompra.setCss("dropdown-item");
		ocompra.setResourceName("ocompra");
		ocompra.setModule("solicitud");
		ocompra.setOrder(7);
		ocompra.setResourceType("form");
		ocompra.setVersion("1.0");
		ocompra.setEvents("nuevo");
		
		Button pedido = new Button();
		pedido.setCommandName("nuevo");
		pedido.setName("nuevoPedido");
		pedido.setLabel("Pedido");
		pedido.setComponentType("botonligadd");
		pedido.setCss("dropdown-item");
		pedido.setResourceName("pedido");
		pedido.setModule("solicitud");
		pedido.setOrder(7);
		pedido.setResourceType("form");
		pedido.setVersion("1.0");
		pedido.setEvents("nuevo");
		
		Button remision = new Button();
		remision.setCommandName("nuevo");
		remision.setName("nuevoRemision");
		remision.setLabel("Nota de remision");
		remision.setComponentType("botonligadd");
		remision.setCss("dropdown-item");
		remision.setResourceName("remision");
		remision.setModule("documentos");
		remision.setOrder(7);
		remision.setResourceType("form");
		remision.setVersion("1.0");
		remision.setEvents("nuevo");
		
		Button carrito = new Button();
		carrito.setCommandName("nuevo");
		carrito.setName("catalogoProductos");
		carrito.setLabel("&leftarrow; Productos/Servicios/Kits");
		carrito.setComponentType("location");
		carrito.setCss("btn btn-info");
		carrito.setResourceName("prodserv");
		carrito.setModule("inventario");
		carrito.setOrder(3);
		carrito.setResourceType("basket");
		carrito.setVersion("1.0");
		carrito.setEvents("nuevo");
		carrito.setStatus("nuevo");
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSubtotal.setFieldName("subtotal");
		campoSubtotal.setName("Subtotal");
		campoSubtotal.setHidden(false);
		campoSubtotal.setOrder(3);
		campoSubtotal.setComponentType("texto");
		campoSubtotal.setLength(1);
		campoSubtotal.setShowInBasket(true);
		
		sessionid.setFieldName("sessionid");
		sessionid.setName("Sesion");
		sessionid.setHidden(false);
		sessionid.setOrder(4);
		sessionid.setComponentType("texto");
		sessionid.setLength(1);
		sessionid.setShowInBasket(false);
		
		status.setFieldName("status");
		status.setName("Status");
		status.setHidden(false);
		status.setOrder(5);
		status.setComponentType("texto");
		status.setLength(1);
		status.setShowInBasket(false);
		
		cantidad.setFieldName("cantidad");
		cantidad.setName("Cantidad");
		cantidad.setHidden(false);
		cantidad.setOrder(5);
		cantidad.setComponentType("texto");
		cantidad.setLength(1);
		cantidad.setShowInBasket(false);
		
		precio.setFieldName("precio");
		precio.setName("Precio");
		precio.setHidden(false);
		precio.setOrder(6);
		precio.setComponentType("texto");
		precio.setLength(1);
		precio.setShowInBasket(false);
		
		campos.add(campoFolio);
		campos.add(campoSubtotal);
		campos.add(sessionid);
		campos.add(status);
		campos.add(cantidad);
		campos.add(precio);
		
		//acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalle);
		acciones.add(agregar);
		acciones.add(eliminar);
		acciones.add(cotizacion);
		acciones.add(carrito);
		acciones.add(pedido);
		acciones.add(remision);
		acciones.add(ocompra);
		
		forma.setModel(campos);
		forma.setName("carrito");
		forma.setTitle("Carrito");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("solicitud");
		forma.setView("carrito");
		forma.setTable("carrito");
		forma.setMethods(acciones);
		forma.setCreateable(false);
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
	public void testCrearCanastaTraza() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_traza.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSubtotal = new Field();
		Field campoDescripcion = new Field();
		Field sessionid = new Field();
		Field status = new Field();
		Field cantidad = new Field();
		Field precio = new Field();
		Field usuario = new Field();
		Field corralationId = new Field();
		
		Resource forma = new Resource();
		
		/*Accion exportar = new Accion();
		exportar.setAccion("exportar");
		exportar.setNombre("exportar");
		exportar.setTitulo("Exportar");
		exportar.setType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setForma("producto");
		exportar.setModulo("inventario");
		exportar.setOrden(1);
		exportar.setTipo("form");
		exportar.setVersion("1.0");
		exportar.setEvento("nuevo");*/
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(2);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");
		

		
		Button ingreso = new Button();
		ingreso.setCommandName("nuevo");
		ingreso.setName("nuevoIngreso");
		ingreso.setLabel("Factura Ingreso(Beta)");
		ingreso.setComponentType("botonligadd");
		ingreso.setCss("dropdown-item");
		ingreso.setResourceName("ingreso");
		ingreso.setModule("comprobantes");
		ingreso.setOrder(6);
		ingreso.setResourceType("form");
		ingreso.setVersion("3.3");
		ingreso.setEvents("nuevo");
		
		
		campoFolio.setFieldName("nombre");
		campoFolio.setName("Nombre");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSubtotal.setFieldName("fechayhora");
		campoSubtotal.setName("Fecha");
		campoSubtotal.setHidden(false);
		campoSubtotal.setOrder(3);
		campoSubtotal.setComponentType("texto");
		campoSubtotal.setLength(1);
		campoSubtotal.setShowInBasket(true);
		
		status.setFieldName("status");
		status.setName("Status");
		status.setHidden(false);
		status.setOrder(5);
		status.setComponentType("texto");
		status.setLength(1);
		status.setShowInBasket(false);
		
		cantidad.setFieldName("valor");
		cantidad.setName("Valor");
		cantidad.setHidden(false);
		cantidad.setOrder(5);
		cantidad.setComponentType("texto");
		cantidad.setLength(1);
		cantidad.setShowInBasket(false);
		
		precio.setFieldName("forma");
		precio.setName("form");
		precio.setHidden(false);
		precio.setOrder(6);
		precio.setComponentType("texto");
		precio.setLength(1);
		precio.setShowInBasket(false);
		
		usuario.setFieldName("usuario");
		usuario.setName("usuario");
		usuario.setHidden(false);
		usuario.setOrder(7);
		usuario.setComponentType("texto");
		usuario.setLength(1);
		usuario.setShowInBasket(false);
		
		corralationId.setFieldName("cid");
		corralationId.setName("CorralationId");
		corralationId.setHidden(false);
		corralationId.setOrder(7);
		corralationId.setComponentType("texto");
		corralationId.setLength(1);
		corralationId.setShowInBasket(false);
		
		campos.add(campoFolio);
		campos.add(campoSubtotal);
		campos.add(status);
		campos.add(cantidad);
		campos.add(precio);
		campos.add(usuario);
		campos.add(corralationId);
		
		//acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(ingreso);
		
		forma.setModel(campos);
		forma.setName("traza");
		forma.setTitle("Trazas");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("sistema");
		forma.setView("traza");
		forma.setTable("traza");
		forma.setMethods(acciones);
		forma.setCreateable(false);
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
	public void testCrearCanastaForma() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_forma.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSubtotal = new Field();
		Field campoDescripcion = new Field();
		Field sessionid = new Field();
		Field status = new Field();
		Field cantidad = new Field();
		Field precio = new Field();
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("producto");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(2);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");
		
		Button detalle = new Button();
		detalle.setCommandName("detalle");
		detalle.setName("detalle");
		detalle.setLabel("Editar");
		detalle.setComponentType("submit");
		detalle.setCss("btn btn-primary");
		detalle.setResourceName("form");
		detalle.setModule("case");
		detalle.setOrder(3);
		detalle.setResourceType("form");
		detalle.setVersion("1.0");
		detalle.setEvents("nuevo");
		
		Button crearTablaAccion = new Button();
		crearTablaAccion.setCommandName("creartabla");
		crearTablaAccion.setName("creartabla");
		crearTablaAccion.setLabel("Crear tabla");
		crearTablaAccion.setComponentType("submit");
		crearTablaAccion.setCss("btn btn-success");
		crearTablaAccion.setResourceName("form");
		crearTablaAccion.setModule("case");
		crearTablaAccion.setOrder(3);
		crearTablaAccion.setResourceType("basket");
		crearTablaAccion.setVersion("1.0");
		crearTablaAccion.setEvents("nuevo");
		crearTablaAccion.setView("creartabla");
		
		Button detalleCampo = new Button();
		detalleCampo.setCommandName("detalle");
		detalleCampo.setName("detallecampo");
		detalleCampo.setLabel("Editar");
		detalleCampo.setComponentType("submit");
		detalleCampo.setCss("btn btn-outline-success");
		detalleCampo.setResourceName("campo");
		detalleCampo.setModule("case");
		detalleCampo.setOrder(8);
		detalleCampo.setResourceType("form");
		detalleCampo.setVersion("1.0");
		detalleCampo.setEvents("nuevo");
		
		Button detalleAccion = new Button();
		detalleAccion.setCommandName("detalle");
		detalleAccion.setName("detalleaccion");
		detalleAccion.setLabel("Editar");
		detalleAccion.setComponentType("submit");
		detalleAccion.setCss("btn btn-success");
		detalleAccion.setResourceName("accion");
		detalleAccion.setModule("case");
		detalleAccion.setOrder(8);
		detalleAccion.setResourceType("form");
		detalleAccion.setVersion("1.0");
		detalleAccion.setEvents("nuevo");
		
		Button agregar = new Button();
		agregar.setCommandName("agregar");
		agregar.setName("agregar");
		agregar.setLabel("Agregar");
		agregar.setComponentType("botonliga");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("forma");
		agregar.setModule("case");
		agregar.setOrder(4);
		agregar.setResourceType("form");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		
		Button eliminar = new Button();
		eliminar.setCommandName("eliminar");
		eliminar.setName("eliminar");
		eliminar.setLabel("Eliminar de carrito");
		eliminar.setComponentType("botonjs");
		eliminar.setCss("btn btn-secondary");
		eliminar.setResourceName("carrito");
		eliminar.setModule("solicitud");
		eliminar.setOrder(5);
		eliminar.setResourceType("form");
		eliminar.setVersion("1.0");
		eliminar.setEvents("nuevo");

		Button nuevo = new Button();
		nuevo.setCommandName("nuevo");
		nuevo.setName("nuevo");
		nuevo.setLabel("Nueva forma");
		nuevo.setComponentType("botonliga");
		nuevo.setCss("btn btn-secondary");
		nuevo.setResourceName("forma");
		nuevo.setModule("case");
		nuevo.setOrder(5);
		nuevo.setResourceType("form");
		nuevo.setVersion("1.0");
		nuevo.setEvents("nuevo");
		
		
		campoFolio.setFieldName("Nombre");
		campoFolio.setName("nombre");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSubtotal.setFieldName("vista");
		campoSubtotal.setName("Vista");
		campoSubtotal.setHidden(false);
		campoSubtotal.setOrder(3);
		campoSubtotal.setComponentType("texto");
		campoSubtotal.setLength(1);
		campoSubtotal.setShowInBasket(true);
		
		sessionid.setFieldName("titulo");
		sessionid.setName("Titulo");
		sessionid.setHidden(false);
		sessionid.setOrder(4);
		sessionid.setComponentType("texto");
		sessionid.setLength(1);
		sessionid.setShowInBasket(false);
		
		status.setFieldName("status");
		status.setName("Status");
		status.setHidden(false);
		status.setOrder(5);
		status.setComponentType("texto");
		status.setLength(1);
		status.setShowInBasket(false);
		
		cantidad.setFieldName("version");
		cantidad.setName("Version");
		cantidad.setHidden(false);
		cantidad.setOrder(5);
		cantidad.setComponentType("texto");
		cantidad.setLength(1);
		cantidad.setShowInBasket(false);
		
		precio.setFieldName("modulo");
		precio.setName("Modulo");
		precio.setHidden(false);
		precio.setOrder(6);
		precio.setComponentType("texto");
		precio.setLength(1);
		precio.setShowInBasket(false);
		
		campos.add(campoFolio);
		campos.add(campoSubtotal);
		campos.add(sessionid);
		campos.add(status);
		campos.add(cantidad);
		campos.add(precio);
		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalle);
		acciones.add(crearTablaAccion);
		acciones.add(agregar);
		acciones.add(eliminar);
		acciones.add(nuevo);
		acciones.add(detalleCampo);
		acciones.add(detalleAccion);
		
		forma.setModel(campos);
		forma.setName("forma");
		forma.setTitle("Formas");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("case");
		forma.setView("forma");
		forma.setTable("forma");
		forma.setMethods(acciones);
		forma.setCreateable(true);
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
	public void testCrearCanastaCanasta() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_canasta.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSubtotal = new Field();
		Field campoDescripcion = new Field();
		Field sessionid = new Field();
		Field status = new Field();
		Field cantidad = new Field();
		Field precio = new Field();
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("producto");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(2);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");
		
		Button detalle = new Button();
		detalle.setCommandName("detalle");
		detalle.setName("detalle");
		detalle.setLabel("Editar");
		detalle.setComponentType("submit");
		detalle.setCss("btn btn-success");
		detalle.setResourceName("forma");
		detalle.setModule("case");
		detalle.setOrder(3);
		detalle.setResourceType("form");
		detalle.setVersion("1.0");
		detalle.setEvents("nuevo");
		
		Button crearTablaAccion = new Button();
		crearTablaAccion.setCommandName("creartabla");
		crearTablaAccion.setName("creartabla");
		crearTablaAccion.setLabel("Crear tabla");
		crearTablaAccion.setComponentType("submit");
		crearTablaAccion.setCss("btn btn-success");
		crearTablaAccion.setResourceName("forma");
		crearTablaAccion.setModule("case");
		crearTablaAccion.setOrder(3);
		crearTablaAccion.setResourceType("basket");
		crearTablaAccion.setVersion("1.0");
		crearTablaAccion.setEvents("nuevo");
		crearTablaAccion.setView("creartabla");
		
		Button detalleCampo = new Button();
		detalleCampo.setCommandName("detalle");
		detalleCampo.setName("detallecampo");
		detalleCampo.setLabel("Editar");
		detalleCampo.setComponentType("submit");
		detalleCampo.setCss("btn btn-success");
		detalleCampo.setResourceName("campo");
		detalleCampo.setModule("case");
		detalleCampo.setOrder(8);
		detalleCampo.setResourceType("form");
		detalleCampo.setVersion("1.0");
		detalleCampo.setEvents("nuevo");
		
		Button detalleAccion = new Button();
		detalleAccion.setCommandName("detalle");
		detalleAccion.setName("detalleaccion");
		detalleAccion.setLabel("Editar");
		detalleAccion.setComponentType("submit");
		detalleAccion.setCss("btn btn-success");
		detalleAccion.setResourceName("accion");
		detalleAccion.setModule("case");
		detalleAccion.setOrder(8);
		detalleAccion.setResourceType("form");
		detalleAccion.setVersion("1.0");
		detalleAccion.setEvents("nuevo");
		
		Button agregar = new Button();
		agregar.setCommandName("agregar");
		agregar.setName("agregar");
		agregar.setLabel("Agregar");
		agregar.setComponentType("botonliga");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("forma");
		agregar.setModule("case");
		agregar.setOrder(4);
		agregar.setResourceType("form");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		
		Button eliminar = new Button();
		eliminar.setCommandName("eliminar");
		eliminar.setName("eliminar");
		eliminar.setLabel("Eliminar de carrito");
		eliminar.setComponentType("botonjs");
		eliminar.setCss("btn btn-secondary");
		eliminar.setResourceName("carrito");
		eliminar.setModule("solicitud");
		eliminar.setOrder(5);
		eliminar.setResourceType("form");
		eliminar.setVersion("1.0");
		eliminar.setEvents("nuevo");

		Button nuevo = new Button();
		nuevo.setCommandName("nuevo");
		nuevo.setName("nuevo");
		nuevo.setLabel("Nueva forma");
		nuevo.setComponentType("botonliga");
		nuevo.setCss("btn btn-secondary");
		nuevo.setResourceName("forma");
		nuevo.setModule("case");
		nuevo.setOrder(5);
		nuevo.setResourceType("form");
		nuevo.setVersion("1.0");
		nuevo.setEvents("nuevo");
		
		
		campoFolio.setFieldName("Nombre");
		campoFolio.setName("nombre");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSubtotal.setFieldName("vista");
		campoSubtotal.setName("Vista");
		campoSubtotal.setHidden(false);
		campoSubtotal.setOrder(3);
		campoSubtotal.setComponentType("texto");
		campoSubtotal.setLength(1);
		campoSubtotal.setShowInBasket(true);
		
		sessionid.setFieldName("titulo");
		sessionid.setName("Titulo");
		sessionid.setHidden(false);
		sessionid.setOrder(4);
		sessionid.setComponentType("texto");
		sessionid.setLength(1);
		sessionid.setShowInBasket(false);
		
		status.setFieldName("status");
		status.setName("Status");
		status.setHidden(false);
		status.setOrder(5);
		status.setComponentType("texto");
		status.setLength(1);
		status.setShowInBasket(false);
		
		cantidad.setFieldName("version");
		cantidad.setName("Version");
		cantidad.setHidden(false);
		cantidad.setOrder(5);
		cantidad.setComponentType("texto");
		cantidad.setLength(1);
		cantidad.setShowInBasket(false);
		
		precio.setFieldName("modulo");
		precio.setName("Modulo");
		precio.setHidden(false);
		precio.setOrder(6);
		precio.setComponentType("texto");
		precio.setLength(1);
		precio.setShowInBasket(false);
		
		campos.add(campoFolio);
		campos.add(campoSubtotal);
		campos.add(sessionid);
		campos.add(status);
		campos.add(cantidad);
		campos.add(precio);
		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalle);
		acciones.add(crearTablaAccion);
		acciones.add(agregar);
		acciones.add(eliminar);
		acciones.add(nuevo);
		acciones.add(detalleCampo);
		acciones.add(detalleAccion);
		
		forma.setModel(campos);
		forma.setName("basket");
		forma.setTitle("Canastas");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("case");
		forma.setView("basket");
		forma.setTable("basket");
		forma.setMethods(acciones);
		forma.setCreateable(true);
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
	public void testCrearCanastaMasiva() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_masiva.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSubtotal = new Field();
		Field campoDescripcion = new Field();
		Field sessionid = new Field();
		Field status = new Field();
		Field receptor = new Field();
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("producto");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(2);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");
		
		Button detalle = new Button();
		detalle.setCommandName("detalle");
		detalle.setName("detalle");
		detalle.setLabel("Detalles");
		detalle.setComponentType("submit");
		detalle.setCss("btn btn-success");
		detalle.setResourceName("masiva");
		detalle.setModule("solicitud");
		detalle.setOrder(3);
		detalle.setResourceType("form");
		detalle.setVersion("1.0");
		detalle.setEvents("nuevo");
		
		Button agregar = new Button();
		agregar.setCommandName("agregar");
		agregar.setName("agregar");
		agregar.setLabel("Agregar a carrito");
		agregar.setComponentType("botonjs");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("carrito");
		agregar.setModule("solicitud");
		agregar.setOrder(4);
		agregar.setResourceType("form");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		

		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSubtotal.setFieldName("tipo");
		campoSubtotal.setName("Tipo");
		campoSubtotal.setHidden(false);
		campoSubtotal.setOrder(3);
		campoSubtotal.setComponentType("texto");
		campoSubtotal.setLength(1);
		campoSubtotal.setShowInBasket(true);
		
		sessionid.setFieldName("emisor");
		sessionid.setName("Emisor");
		sessionid.setHidden(false);
		sessionid.setOrder(4);
		sessionid.setComponentType("texto");
		sessionid.setLength(1);
		sessionid.setShowInBasket(true);
		
		receptor.setFieldName("receptor");
		receptor.setName("Receptor");
		receptor.setHidden(false);
		receptor.setOrder(5);
		receptor.setComponentType("texto");
		receptor.setLength(1);
		receptor.setShowInBasket(true);
		
		status.setFieldName("status");
		status.setName("Status");
		status.setHidden(false);
		status.setOrder(5);
		status.setComponentType("texto");
		status.setLength(1);
		status.setShowInBasket(true);
		
		campos.add(campoFolio);
		campos.add(campoSubtotal);
		campos.add(sessionid);
		campos.add(receptor);
		campos.add(status);
		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalle);
		acciones.add(agregar);
		
		forma.setModel(campos);
		forma.setName("masiva");
		forma.setTitle("Masivas");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("solicitud");
		forma.setView("masiva");
		forma.setTable("masiva");
		forma.setMethods(acciones);
		forma.setCreateable(false);
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
	public void testCrearCanastaServicio() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_servicio.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSat = new Field();
		Field campoDescripcion = new Field();
		Field campoTipo = new Field();
		
		Field campoNombre = new Field();
		Field campoTitulo = new Field();
		Field campoNote = new Field();
		Field campoCategoria = new Field();
		Field campoImagen = new Field();
		Field campoLPrecio = new Field();
		
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("producto");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");
		
		Button detalleProducto = new Button();
		detalleProducto.setCommandName("detalle");
		detalleProducto.setName("detalleProducto");
		detalleProducto.setLabel("Detalles");
		detalleProducto.setComponentType("submit");
		detalleProducto.setCss("btn btn-success");
		detalleProducto.setResourceName("producto");
		detalleProducto.setModule("inventario");
		detalleProducto.setOrder(4);
		detalleProducto.setResourceType("form");
		detalleProducto.setVersion("1.0");
		detalleProducto.setEvents("nuevo");
		
		Button detalleServicio = new Button();
		detalleServicio.setCommandName("detalle");
		detalleServicio.setName("detalleServicio");
		detalleServicio.setLabel("Detalles");
		detalleServicio.setComponentType("submit");
		detalleServicio.setCss("btn btn-success");
		detalleServicio.setResourceName("servicio");
		detalleServicio.setModule("inventario");
		detalleServicio.setOrder(4);
		detalleServicio.setResourceType("form");
		detalleServicio.setVersion("1.0");
		detalleServicio.setEvents("nuevo");
		
		Button detalleKit = new Button();
		detalleKit.setCommandName("detalle");
		detalleKit.setName("detalleKit");
		detalleKit.setLabel("Detalles");
		detalleKit.setComponentType("submit");
		detalleKit.setCss("btn btn-success");
		detalleKit.setResourceName("kit");
		detalleKit.setModule("inventario");
		detalleKit.setOrder(4);
		detalleKit.setResourceType("form");
		detalleKit.setVersion("1.0");
		detalleKit.setEvents("nuevo");
		
		Button agregar = new Button();
		agregar.setCommandName("agregar");
		agregar.setName("agregar");
		agregar.setLabel("Agregar a carrito");
		agregar.setComponentType("botonjs");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("carrito");
		agregar.setModule("solicitud");
		agregar.setOrder(5);
		agregar.setResourceType("form");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSat.setFieldName("codigosat");
		campoSat.setName("Codigo SAT");
		campoSat.setHidden(false);
		campoSat.setOrder(3);
		campoSat.setComponentType("texto");
		campoSat.setLength(20);
		campoSat.setShowInBasket(true);
		
		campoDescripcion.setFieldName("descripcion");
		campoDescripcion.setName("Descripcion");
		campoDescripcion.setHidden(false);
		campoDescripcion.setOrder(3);
		campoDescripcion.setComponentType("texto");
		campoDescripcion.setLength(1);
		campoDescripcion.setShowInBasket(true);
		
		campoTipo.setFieldName("tipo");
		campoTipo.setName("Tipo");
		campoTipo.setHidden(false);
		campoTipo.setOrder(4);
		campoTipo.setComponentType("texto");
		campoTipo.setLength(20);
		campoTipo.setShowInBasket(true);
		campoTipo.setValue("servicio");
		
		campoNombre.setFieldName("nombre");
		campoNombre.setName("Nombre");
		campoNombre.setHidden(false);
		campoNombre.setOrder(2);
		campoNombre.setComponentType("texto");
		campoNombre.setLength(1);
		campoNombre.setShowInBasket(true);

		campoTitulo.setFieldName("titulo");
		campoTitulo.setName("Titulo");
		campoTitulo.setHidden(false);
		campoTitulo.setOrder(3);
		campoTitulo.setComponentType("texto");
		campoTitulo.setLength(50);
		campoTitulo.setShowInBasket(true);
		
		
		campoNote.setFieldName("nota");
		campoNote.setName("Nota");
		campoNote.setHidden(false);
		campoNote.setOrder(5);
		campoNote.setComponentType("texto");
		campoNote.setLength(50);
		campoNote.setShowInBasket(true);
		
		campoCategoria.setFieldName("categoria");
		campoCategoria.setName("Categoria");
		campoCategoria.setHidden(false);
		campoCategoria.setOrder(6);
		campoCategoria.setComponentType("texto");
		campoCategoria.setLength(50);
		campoCategoria.setShowInBasket(true);
		
		campoImagen.setFieldName("imagen");
		campoImagen.setName("Imagen");
		campoImagen.setHidden(false);
		campoImagen.setOrder(7);
		campoImagen.setComponentType("texto");
		campoImagen.setLength(50);
		campoImagen.setShowInBasket(true);
		
		campoLPrecio.setFieldName("lprecio");
		campoLPrecio.setName("Precio");
		campoLPrecio.setHidden(false);
		campoLPrecio.setOrder(8);
		campoLPrecio.setComponentType("texto");
		campoLPrecio.setLength(1);
		campoLPrecio.setShowInBasket(true);
		
		campos.add(campoFolio);
		campos.add(campoSat);
		campos.add(campoDescripcion);
		campos.add(campoTipo);
		campos.add(campoNombre);
		campos.add(campoTitulo);
		campos.add(campoNote);
		campos.add(campoCategoria);
		campos.add(campoImagen);
		campos.add(campoLPrecio);
		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalleProducto);
		acciones.add(detalleServicio);
		acciones.add(detalleKit);
		acciones.add(agregar);
		
		forma.setModel(campos);
		forma.setName("servicio");
		forma.setTitle("Servicios");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setView("servicio");
		forma.setTable("prodserv");
		forma.setMethods(acciones);
		forma.setCreateable(true);
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
	public void testCrearCanastaActividad() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_actividad.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field campoSat = new Field();
		Field campoDescripcion = new Field();
		Field campoTipo = new Field();
		
		Field campoNombre = new Field();
		Field campoTitulo = new Field();
		Field campoNote = new Field();
		Field campoCategoria = new Field();
		Field campoImagen = new Field();
		Field campoLPrecio = new Field();
		
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("actividad");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("actividad");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");
		
		Button detalleProducto = new Button();
		detalleProducto.setCommandName("detalle");
		detalleProducto.setName("detalleProducto");
		detalleProducto.setLabel("Detalles");
		detalleProducto.setComponentType("submit");
		detalleProducto.setCss("btn btn-success");
		detalleProducto.setResourceName("producto");
		detalleProducto.setModule("inventario");
		detalleProducto.setOrder(4);
		detalleProducto.setResourceType("form");
		detalleProducto.setVersion("1.0");
		detalleProducto.setEvents("nuevo");
		
		Button detalleServicio = new Button();
		detalleServicio.setCommandName("detalle");
		detalleServicio.setName("detalleServicio");
		detalleServicio.setLabel("Detalles");
		detalleServicio.setComponentType("submit");
		detalleServicio.setCss("btn btn-success");
		detalleServicio.setResourceName("servicio");
		detalleServicio.setModule("inventario");
		detalleServicio.setOrder(4);
		detalleServicio.setResourceType("form");
		detalleServicio.setVersion("1.0");
		detalleServicio.setEvents("nuevo");
		
		Button detalleActividad = new Button();
		detalleActividad.setCommandName("detalle");
		detalleActividad.setName("detalleActividad");
		detalleActividad.setLabel("Detalles");
		detalleActividad.setComponentType("submit");
		detalleActividad.setCss("btn btn-success");
		detalleActividad.setResourceName("actividad");
		detalleActividad.setModule("inventario");
		detalleActividad.setOrder(4);
		detalleActividad.setResourceType("form");
		detalleActividad.setVersion("1.0");
		detalleActividad.setEvents("nuevo");
		
		Button detalleKit = new Button();
		detalleKit.setCommandName("detalle");
		detalleKit.setName("detalleKit");
		detalleKit.setLabel("Detalles");
		detalleKit.setComponentType("submit");
		detalleKit.setCss("btn btn-success");
		detalleKit.setResourceName("kit");
		detalleKit.setModule("inventario");
		detalleKit.setOrder(4);
		detalleKit.setResourceType("form");
		detalleKit.setVersion("1.0");
		detalleKit.setEvents("nuevo");
		
		Button agregar = new Button();
		agregar.setCommandName("agregar");
		agregar.setName("agregar");
		agregar.setLabel("Agregar a carrito");
		agregar.setComponentType("botonjs");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("carrito");
		agregar.setModule("solicitud");
		agregar.setOrder(5);
		agregar.setResourceType("form");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campoSat.setFieldName("codigosat");
		campoSat.setName("Codigo SAT");
		campoSat.setHidden(false);
		campoSat.setOrder(3);
		campoSat.setComponentType("texto");
		campoSat.setLength(20);
		campoSat.setShowInBasket(true);
		
		campoDescripcion.setFieldName("descripcion");
		campoDescripcion.setName("Descripcion");
		campoDescripcion.setHidden(false);
		campoDescripcion.setOrder(3);
		campoDescripcion.setComponentType("texto");
		campoDescripcion.setLength(1);
		campoDescripcion.setShowInBasket(true);
		
		campoTipo.setFieldName("tipo");
		campoTipo.setName("Tipo");
		campoTipo.setHidden(false);
		campoTipo.setOrder(4);
		campoTipo.setComponentType("texto");
		campoTipo.setLength(20);
		campoTipo.setShowInBasket(true);
		campoTipo.setValue("servicio");
		
		campoNombre.setFieldName("nombre");
		campoNombre.setName("Nombre");
		campoNombre.setHidden(false);
		campoNombre.setOrder(2);
		campoNombre.setComponentType("texto");
		campoNombre.setLength(1);
		campoNombre.setShowInBasket(true);

		campoTitulo.setFieldName("titulo");
		campoTitulo.setName("Titulo");
		campoTitulo.setHidden(false);
		campoTitulo.setOrder(3);
		campoTitulo.setComponentType("texto");
		campoTitulo.setLength(50);
		campoTitulo.setShowInBasket(true);
		
		
		campoNote.setFieldName("nota");
		campoNote.setName("Nota");
		campoNote.setHidden(false);
		campoNote.setOrder(5);
		campoNote.setComponentType("texto");
		campoNote.setLength(50);
		campoNote.setShowInBasket(true);
		
		campoCategoria.setFieldName("categoria");
		campoCategoria.setName("Categoria");
		campoCategoria.setHidden(false);
		campoCategoria.setOrder(6);
		campoCategoria.setComponentType("texto");
		campoCategoria.setLength(50);
		campoCategoria.setShowInBasket(true);
		
		campoImagen.setFieldName("imagen");
		campoImagen.setName("Imagen");
		campoImagen.setHidden(false);
		campoImagen.setOrder(7);
		campoImagen.setComponentType("texto");
		campoImagen.setLength(50);
		campoImagen.setShowInBasket(true);
		
		campoLPrecio.setFieldName("lprecio");
		campoLPrecio.setName("Precio");
		campoLPrecio.setHidden(false);
		campoLPrecio.setOrder(8);
		campoLPrecio.setComponentType("texto");
		campoLPrecio.setLength(1);
		campoLPrecio.setShowInBasket(true);
		
		campos.add(campoFolio);
		campos.add(campoSat);
		campos.add(campoDescripcion);
		campos.add(campoTipo);
		campos.add(campoNombre);
		campos.add(campoTitulo);
		campos.add(campoNote);
		campos.add(campoCategoria);
		campos.add(campoImagen);
		campos.add(campoLPrecio);
		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalleProducto);
		acciones.add(detalleServicio);
		acciones.add(detalleActividad);
		acciones.add(detalleKit);
		acciones.add(agregar);
		
		forma.setModel(campos);
		forma.setName("actividad");
		forma.setTitle("Actividades");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setView("actividad");
		forma.setTable("prodserv");
		forma.setMethods(acciones);
		forma.setCreateable(true);
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
	public void testCrearCanastaPPago() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_pago.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("prodserv");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button guardar = new Button();
		guardar.setCommandName("editar");
		guardar.setName("editar");
		guardar.setLabel("Editar");
		guardar.setComponentType("boton");
		guardar.setCss("btn btn-secondary");
		guardar.setResourceName("ppago");
		guardar.setModule("comprobantes");
		guardar.setOrder(1);
		guardar.setResourceType("form");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campos.add(campoFolio);
		acciones.add(guardar);
		acciones.add(exportar);
		
		
		forma.setModel(campos);
		forma.setName("pago");
		forma.setTitle("Pago");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("comprobantes");
		forma.setView("pago");
		forma.setMethods(acciones);
		forma.setCreateable(false);
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
	public void testCrearCanastaJugador() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_jugador.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Resource forma = new Resource();
		
		Button guardar = new Button();
		guardar.setCommandName("editar");
		guardar.setName("editar");
		guardar.setLabel("Editar");
		guardar.setComponentType("boton");
		guardar.setCss("btn btn-secondary");
		guardar.setResourceName("jugador");
		guardar.setModule("directorio");
		guardar.setOrder(1);
		guardar.setResourceType("form");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campos.add(campoFolio);
		acciones.add(guardar);
		
		forma.setModel(campos);
		forma.setName("jugador");
		forma.setTitle("Jugadores");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("futbol");
		forma.setView("jugador");
		forma.setCreateable(false);
		forma.setMethods(acciones);
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
	public void testCrearCanastaDirectorio() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_directorio.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field nombre = new Field();
		Field tipo = new Field();
		Field campoStatus = new Field();
		Field campoRfc = new Field();
		
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("producto");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Buscar");
		buscar.setComponentType("submit");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("directorio");
		buscar.setModule("directorio");
		buscar.setOrder(2);
		buscar.setResourceType("basket");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo,buscar");
		
		Button filtro = new Button();
		filtro.setCommandName("filtros");
		filtro.setName("filtros");
		filtro.setLabel("Mostrar filtros");
		filtro.setComponentType("botonliga");
		filtro.setCss("btn btn-secondary");
		filtro.setResourceName("producto");
		filtro.setModule("inventario");
		filtro.setOrder(2);
		filtro.setResourceType("form");
		filtro.setVersion("1.0");
		filtro.setEvents("nuevo,buscar");
		
		Button guardar = new Button();
		guardar.setCommandName("editar");
		guardar.setName("editar");
		guardar.setLabel("Editar");
		guardar.setComponentType("boton");
		guardar.setCss("btn btn-secondary");
		guardar.setResourceName("usuario");
		guardar.setModule("directorio");
		guardar.setOrder(3);
		guardar.setResourceType("form");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		
		Button detalle = new Button();
		detalle.setCommandName("detalle");
		detalle.setName("detalleUsuario");
		detalle.setLabel("Detalles");
		detalle.setComponentType("submit");
		detalle.setCss("btn btn-success");
		detalle.setResourceName("usuario");
		detalle.setModule("directorio");
		detalle.setOrder(4);
		detalle.setResourceType("form");
		detalle.setVersion("1.0");
		detalle.setEvents("nuevo,buscar");
		
		Button detallec = new Button();
		detallec.setCommandName("detalle");
		detallec.setName("detalleCliente");
		detallec.setLabel("Detalles");
		detallec.setComponentType("submit");
		detallec.setCss("btn btn-success");
		detallec.setResourceName("cliente");
		detallec.setModule("directorio");
		detallec.setOrder(4);
		detallec.setResourceType("form");
		detallec.setVersion("1.0");
		detallec.setEvents("nuevo,buscar");
		
		Button detallep = new Button();
		detallep.setCommandName("detalle");
		detallep.setName("detalleProveedor");
		detallep.setLabel("Detalles");
		detallep.setComponentType("submit");
		detallep.setCss("btn btn-success");
		detallep.setResourceName("proveedor");
		detallep.setModule("directorio");
		detallep.setOrder(4);
		detallep.setResourceType("form");
		detallep.setVersion("1.0");
		detallep.setEvents("nuevo,buscar");
		
		Button detallea = new Button();
		detallea.setCommandName("detalle");
		detallea.setName("detalleAlmacen");
		detallea.setLabel("Detalles");
		detallea.setComponentType("submit");
		detallea.setCss("btn btn-success");
		detallea.setResourceName("almacen");
		detallea.setModule("directorio");
		detallea.setOrder(4);
		detallea.setResourceType("form");
		detallea.setVersion("1.0");
		detallea.setEvents("nuevo,buscar");
		
		Button detalleInfo = new Button();
		detalleInfo.setCommandName("detalle");
		detalleInfo.setName("detalleInformacion");
		detalleInfo.setLabel("Detalles");
		detalleInfo.setComponentType("submit");
		detalleInfo.setCss("btn btn-success");
		detalleInfo.setResourceName("informacion");
		detalleInfo.setModule("solicitud");
		detalleInfo.setOrder(4);
		detalleInfo.setResourceType("form");
		detalleInfo.setVersion("1.0");
		detalleInfo.setEvents("nuevo,buscar");
		
		Button detalleRegistrarse = new Button();
		detalleRegistrarse.setCommandName("detalle");
		detalleRegistrarse.setName("detalleRegistrarse");
		detalleRegistrarse.setLabel("Detalles");
		detalleRegistrarse.setComponentType("submit");
		detalleRegistrarse.setCss("btn btn-success");
		detalleRegistrarse.setResourceName("registrarse");
		detalleRegistrarse.setModule("solicitud");
		detalleRegistrarse.setOrder(4);
		detalleRegistrarse.setResourceType("form");
		detalleRegistrarse.setVersion("1.0");
		detalleRegistrarse.setEvents("nuevo,buscar");
		
		Button detalleEmpresa = new Button();
		detalleEmpresa.setCommandName("detalle");
		detalleEmpresa.setName("detalleEmpresa");
		detalleEmpresa.setLabel("Detalles");
		detalleEmpresa.setComponentType("submit");
		detalleEmpresa.setCss("btn btn-success");
		detalleEmpresa.setResourceName("empresa");
		detalleEmpresa.setModule("directorio");
		detalleEmpresa.setOrder(6);
		detalleEmpresa.setResourceType("form");
		detalleEmpresa.setVersion("1.0");
		detalleEmpresa.setEvents("nuevo,buscar");
		
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		nombre.setFieldName("nombre");
		nombre.setName("Nombre");
		nombre.setHidden(false);
		nombre.setOrder(2);
		nombre.setComponentType("texto");
		nombre.setLength(1);
		nombre.setShowInBasket(true);
		
		tipo.setFieldName("tipo");
		tipo.setName("Tipo");
		tipo.setHidden(false);
		tipo.setOrder(3);
		tipo.setComponentType("texto");
		tipo.setLength(1);
		tipo.setShowInBasket(true);
		
		campoStatus.setFieldName("status");
		campoStatus.setName("Status");
		campoStatus.setHidden(false);
		campoStatus.setOrder(3);
		campoStatus.setComponentType("texto");
		campoStatus.setLength(1);
		campoStatus.setShowInBasket(true);
		
		campoRfc.setFieldName("rfc");
		campoRfc.setName("RFC");
		campoRfc.setHidden(false);
		campoRfc.setOrder(3);
		campoRfc.setComponentType("texto");
		campoRfc.setLength(1);
		campoRfc.setShowInBasket(true);
		
		campos.add(campoFolio);
		campos.add(nombre);
		campos.add(tipo);
		campos.add(campoStatus);
		campos.add(campoRfc);
		
		acciones.add(exportar);
		acciones.add(filtro);
		acciones.add(buscar);
		acciones.add(guardar);
		acciones.add(detalle);
		acciones.add(detallec);
		acciones.add(detallep);
		acciones.add(detallea);
		acciones.add(detalleInfo);
		acciones.add(detalleRegistrarse);
		acciones.add(detalleEmpresa);
		
		forma.setModel(campos);
		forma.setName("directorio");
		forma.setTitle("Directorio");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setView("directorio");
		forma.setCreateable(false);
		forma.setTable("dircto");
		forma.setMethods(acciones);
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
	public void testCrearCanastaDirectorioCliente() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_cliente.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Resource forma = new Resource();
		
		Button guardar = new Button();
		guardar.setCommandName("editar");
		guardar.setName("editar");
		guardar.setLabel("Editar");
		guardar.setComponentType("boton");
		guardar.setCss("btn btn-secondary");
		guardar.setResourceName("cliente");
		guardar.setModule("directorio");
		guardar.setOrder(1);
		guardar.setResourceType("form");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campos.add(campoFolio);
		acciones.add(guardar);
		
		forma.setModel(campos);
		forma.setName("cliente");
		forma.setTitle("Clientes");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setView("cliente");
		forma.setTable("dircto");
		forma.setCreateable(false);
		forma.setMethods(acciones);
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
	public void testCrearCanastaDirectorioEmpresa() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_empresa.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Resource forma = new Resource();
		
		Button guardar = new Button();
		guardar.setCommandName("editar");
		guardar.setName("editar");
		guardar.setLabel("Editar");
		guardar.setComponentType("boton");
		guardar.setCss("btn btn-secondary");
		guardar.setResourceName("cliente");
		guardar.setModule("directorio");
		guardar.setOrder(1);
		guardar.setResourceType("form");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campos.add(campoFolio);
		acciones.add(guardar);
		
		forma.setModel(campos);
		forma.setName("empresa");
		forma.setTitle("Empresa");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setView("empresa");
		forma.setTable("dircto");
		forma.setCreateable(false);
		forma.setMethods(acciones);
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
	public void testCrearCanastaDirectorioMensaje() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_mensaje.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Resource forma = new Resource();
		
		Button guardar = new Button();
		guardar.setCommandName("editar");
		guardar.setName("editar");
		guardar.setLabel("Editar");
		guardar.setComponentType("boton");
		guardar.setCss("btn btn-secondary");
		guardar.setResourceName("mensaje");
		guardar.setModule("solicitud");
		guardar.setOrder(1);
		guardar.setResourceType("form");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campos.add(campoFolio);
		acciones.add(guardar);
		
		forma.setModel(campos);
		forma.setName("mensaje");
		forma.setTitle("Mensaje");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("solicitud");
		forma.setView("mensaje");
		forma.setTable("mensaje");
		forma.setCreateable(false);
		forma.setMethods(acciones);
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
	public void testCrearCanastaDirectorioUsuario() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_usuario.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Field nombre = new Field();
		Field tipo = new Field();
		Resource forma = new Resource();
		
		Button guardar = new Button();
		guardar.setCommandName("editar");
		guardar.setName("editar");
		guardar.setLabel("Editar");
		guardar.setComponentType("boton");
		guardar.setCss("btn btn-secondary");
		guardar.setResourceName("usuario");
		guardar.setModule("directorio");
		guardar.setOrder(1);
		guardar.setResourceType("form");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		
		Button detalle = new Button();
		detalle.setCommandName("detalle");
		detalle.setName("detalle");
		detalle.setLabel("Detalles");
		detalle.setComponentType("submit");
		detalle.setCss("btn btn-success");
		detalle.setResourceName("usuario");
		detalle.setModule("directorio");
		detalle.setOrder(3);
		detalle.setResourceType("form");
		detalle.setVersion("1.0");
		detalle.setEvents("nuevo");
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		nombre.setFieldName("nombre");
		nombre.setName("Nombre");
		nombre.setHidden(false);
		nombre.setOrder(2);
		nombre.setComponentType("texto");
		nombre.setLength(1);
		nombre.setShowInBasket(true);
		
		tipo.setFieldName("tipo");
		tipo.setName("Tipo");
		tipo.setHidden(false);
		tipo.setOrder(3);
		tipo.setComponentType("texto");
		tipo.setLength(1);
		tipo.setShowInBasket(true);
		
		campos.add(campoFolio);
		campos.add(nombre);
		campos.add(tipo);
		
		acciones.add(guardar);
		acciones.add(detalle);
		
		forma.setModel(campos);
		forma.setName("usuario");
		forma.setTitle("Usuarios");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setView("usuario");
		forma.setTable("dircto");
		forma.setCreateable(false);
		forma.setMethods(acciones);
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
	public void testCrearCanastaDirectorioProveedor() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_proveedor.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Resource forma = new Resource();
		
		Button guardar = new Button();
		guardar.setCommandName("editar");
		guardar.setName("editar");
		guardar.setLabel("Editar");
		guardar.setComponentType("boton");
		guardar.setCss("btn btn-secondary");
		guardar.setResourceName("proveedor");
		guardar.setModule("directorio");
		guardar.setOrder(1);
		guardar.setResourceType("form");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campos.add(campoFolio);
		acciones.add(guardar);
		
		forma.setModel(campos);
		forma.setName("proveedor");
		forma.setTitle("Proveedores");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setView("proveedor");
		forma.setTable("dircto");
		forma.setCreateable(false);
		forma.setMethods(acciones);
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
	public void testCrearCanastaDirectorioAlmacen() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_almacen.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoFolio = new Field();
		Resource forma = new Resource();
		
		Button guardar = new Button();
		guardar.setCommandName("editar");
		guardar.setName("editar");
		guardar.setLabel("Editar");
		guardar.setComponentType("boton");
		guardar.setCss("btn btn-secondary");
		guardar.setResourceName("almacen");
		guardar.setModule("directorio");
		guardar.setOrder(1);
		guardar.setResourceType("form");
		guardar.setVersion("1.0");
		guardar.setEvents("nuevo");
		
		
		campoFolio.setFieldName("codigo");
		campoFolio.setName("Codigo");
		campoFolio.setHidden(false);
		campoFolio.setOrder(1);
		campoFolio.setComponentType("texto");
		campoFolio.setLength(1);
		campoFolio.setShowInBasket(true);

		campos.add(campoFolio);
		acciones.add(guardar);
		
		forma.setModel(campos);
		forma.setName("almacen");
		forma.setTitle("Almacenes");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("directorio");
		forma.setView("almacen");
		forma.setTable("dircto");
		forma.setCreateable(false);
		forma.setMethods(acciones);
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
	public void testCrearCanastaPrecio() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_precio.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoCodigo = new Field();
		Field campoNombre = new Field();
		Field campoBase = new Field();
		Field campoFactor = new Field();
		Field campoStatus = new Field();
		
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("producto");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");

		Button detalle = new Button();
		detalle.setCommandName("detalle");
		detalle.setName("detalle");
		detalle.setLabel("Detalles");
		detalle.setComponentType("submit");
		detalle.setCss("btn btn-success");
		detalle.setResourceName("precio");
		detalle.setModule("inventario");
		detalle.setOrder(4);
		detalle.setResourceType("form");
		detalle.setVersion("1.0");
		detalle.setEvents("nuevo");
		
		Button agregar = new Button();
		agregar.setCommandName("nuevo");
		agregar.setName("nuevo");
		agregar.setLabel("Productos");
		agregar.setComponentType("submit");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("precios");
		agregar.setModule("inventario");
		agregar.setOrder(5);
		agregar.setResourceType("basket");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		
		campoCodigo.setFieldName("codigo");
		campoCodigo.setName("Codigo");
		campoCodigo.setHidden(false);
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setLength(1);
		campoCodigo.setShowInBasket(true);
		
		campoNombre.setFieldName("nombre");
		campoNombre.setName("Nombre");
		campoNombre.setHidden(false);
		campoNombre.setOrder(2);
		campoNombre.setComponentType("texto");
		campoNombre.setLength(1);
		campoNombre.setShowInBasket(true);

		campoBase.setFieldName("base");
		campoBase.setName("Base");
		campoBase.setHidden(false);
		campoBase.setOrder(3);
		campoBase.setComponentType("texto");
		campoBase.setLength(1);
		campoBase.setShowInBasket(true);
		
		campoFactor.setFieldName("factor");
		campoFactor.setName("Factor");
		campoFactor.setHidden(false);
		campoFactor.setOrder(4);
		campoFactor.setComponentType("texto");
		campoFactor.setLength(1);
		campoFactor.setShowInBasket(true);
		
		campoStatus.setFieldName("status");
		campoStatus.setName("Status");
		campoStatus.setHidden(false);
		campoStatus.setOrder(4);
		campoStatus.setComponentType("texto");
		campoStatus.setLength(1);
		campoStatus.setShowInBasket(true);
		
		
		campos.add(campoCodigo);
		campos.add(campoNombre);
		campos.add(campoBase);
		campos.add(campoFactor);
		campos.add(campoStatus);
		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalle);
		acciones.add(agregar);
		
		forma.setModel(campos);
		forma.setName("precio");
		forma.setTitle("Listas de precio");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setView("precio");
		forma.setTable("lprecio");
		forma.setMethods(acciones);
		forma.setCreateable(true);
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
	public void testCrearCanastaPrecios() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_precios.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoCodigo = new Field();
		Field campoNombre = new Field();
		Field campoBase = new Field();
		Field campoFactor = new Field();
		Field campoStatus = new Field();
		Field campoLPrecio = new Field();
		Field campoDescripcion = new Field();
		Field campoMoneda = new Field();
		
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("nuevo");
		exportar.setName("nuevo");
		exportar.setLabel("Nuevo producto");
		exportar.setComponentType("submit");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("precios");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");

		Button detalle = new Button();
		detalle.setCommandName("detalle");
		detalle.setName("detalle");
		detalle.setLabel("Detalles");
		detalle.setComponentType("submit");
		detalle.setCss("btn btn-success");
		detalle.setResourceName("precios");
		detalle.setModule("inventario");
		detalle.setOrder(4);
		detalle.setResourceType("form");
		detalle.setVersion("1.0");
		detalle.setEvents("nuevo");
		
		Button agregar = new Button();
		agregar.setCommandName("agregar");
		agregar.setName("agregar");
		agregar.setLabel("Agregar a carrito");
		agregar.setComponentType("botonjs");
		agregar.setCss("btn btn-secondary");
		agregar.setResourceName("carrito");
		agregar.setModule("solicitud");
		agregar.setOrder(5);
		agregar.setResourceType("form");
		agregar.setVersion("1.0");
		agregar.setEvents("nuevo");
		
		campoCodigo.setFieldName("codigo");
		campoCodigo.setName("Codigo");
		campoCodigo.setHidden(false);
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setLength(1);
		campoCodigo.setShowInBasket(true);
		
		campoNombre.setFieldName("prodserv");
		campoNombre.setName("Nombre");
		campoNombre.setHidden(false);
		campoNombre.setOrder(2);
		campoNombre.setComponentType("texto");
		campoNombre.setLength(1);
		campoNombre.setShowInBasket(true);

		campoBase.setFieldName("factor");
		campoBase.setName("Factor");
		campoBase.setHidden(false);
		campoBase.setOrder(3);
		campoBase.setComponentType("texto");
		campoBase.setLength(1);
		campoBase.setShowInBasket(true);
		
		campoFactor.setFieldName("precio");
		campoFactor.setName("Precio");
		campoFactor.setHidden(false);
		campoFactor.setOrder(4);
		campoFactor.setComponentType("texto");
		campoFactor.setLength(1);
		campoFactor.setShowInBasket(true);
		
		campoStatus.setFieldName("status");
		campoStatus.setName("Status");
		campoStatus.setHidden(false);
		campoStatus.setOrder(4);
		campoStatus.setComponentType("texto");
		campoStatus.setLength(1);
		campoStatus.setShowInBasket(true);
		
		campoLPrecio.setFieldName("lprecio");
		campoLPrecio.setName("Lista");
		campoLPrecio.setHidden(true);
		campoLPrecio.setOrder(4);
		campoLPrecio.setComponentType("texto");
		campoLPrecio.setLength(1);
		campoLPrecio.setShowInBasket(false);
		
		campoDescripcion.setFieldName("descripcion");
		campoDescripcion.setName("Descripcion");
		campoDescripcion.setHidden(false);
		campoDescripcion.setOrder(5);
		campoDescripcion.setComponentType("texto");
		campoDescripcion.setLength(50);
		campoDescripcion.setShowInBasket(true);
		
		campoMoneda.setFieldName("moneda");
		campoMoneda.setName("Moneda");
		campoMoneda.setHidden(false);
		campoMoneda.setOrder(6);
		campoMoneda.setComponentType("texto");
		campoMoneda.setLength(10);
		campoMoneda.setShowInBasket(true);
		
		campos.add(campoCodigo);
		campos.add(campoNombre);
		campos.add(campoBase);
		campos.add(campoFactor);
		campos.add(campoStatus);
		campos.add(campoLPrecio);
		campos.add(campoDescripcion);
		campos.add(campoMoneda);
		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalle);
		acciones.add(agregar);
		
		forma.setModel(campos);
		forma.setName("precios");
		forma.setTitle("Precios de lista");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("inventario");
		forma.setView("precios");
		forma.setTable("precios");
		forma.setMethods(acciones);
		forma.setCreateable(false);
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
	public void testCrearCanastaIncluye() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_incluye.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoTipo = new Field();
		Field campoCodigo = new Field();
		Field campoActividad = new Field();
		Field campoNombre = new Field();
		Field campoStatus = new Field();
		Field campoIcono = new Field();
		Field campoLenguage = new Field();
		
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("nuevo");
		exportar.setName("nuevo");
		exportar.setLabel("Nuevo producto");
		exportar.setComponentType("submit");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("precios");
		exportar.setModule("inventario");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Mostrar filtros");
		buscar.setComponentType("botonliga");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("producto");
		buscar.setModule("inventario");
		buscar.setOrder(3);
		buscar.setResourceType("form");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo");

		Button detalle = new Button();
		detalle.setCommandName("detalle");
		detalle.setName("detalle");
		detalle.setLabel("Detalles");
		detalle.setComponentType("submit");
		detalle.setCss("btn btn-success");
		detalle.setResourceName("incluye");
		detalle.setModule("solicitud");
		detalle.setOrder(4);
		detalle.setResourceType("form");
		detalle.setVersion("1.0");
		detalle.setEvents("nuevo");
		
		campoTipo.setFieldName("tipo");
		campoTipo.setName("Tipo");
		campoTipo.setHidden(false);
		campoTipo.setOrder(0);
		campoTipo.setComponentType("texto");
		campoTipo.setLength(1);
		campoTipo.setShowInBasket(true);
		
		campoCodigo.setFieldName("codigo");
		campoCodigo.setName("Codigo");
		campoCodigo.setHidden(false);
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setLength(1);
		campoCodigo.setShowInBasket(true);
		
		campoActividad.setFieldName("actividad");
		campoActividad.setName("Actividad");
		campoActividad.setHidden(false);
		campoActividad.setOrder(2);
		campoActividad.setComponentType("texto");
		campoActividad.setLength(1);
		campoActividad.setShowInBasket(true);

		campoNombre.setFieldName("nombre");
		campoNombre.setName("Nombre");
		campoNombre.setHidden(false);
		campoNombre.setOrder(3);
		campoNombre.setComponentType("texto");
		campoNombre.setLength(1);
		campoNombre.setShowInBasket(true);
		
		campoStatus.setFieldName("status");
		campoStatus.setName("Status");
		campoStatus.setHidden(false);
		campoStatus.setOrder(4);
		campoStatus.setComponentType("texto");
		campoStatus.setLength(1);
		campoStatus.setShowInBasket(true);
		
		campoIcono.setFieldName("icono");
		campoIcono.setName("Icono");
		campoIcono.setHidden(true);
		campoIcono.setOrder(4);
		campoIcono.setComponentType("texto");
		campoIcono.setLength(1);
		campoIcono.setShowInBasket(false);
		
		campoLenguage.setFieldName("lenguage");
		campoLenguage.setName("Lenguage");
		campoLenguage.setHidden(false);
		campoLenguage.setOrder(5);
		campoLenguage.setComponentType("texto");
		campoLenguage.setLength(50);
		campoLenguage.setShowInBasket(true);
		
		campos.add(campoTipo);
		campos.add(campoCodigo);
		campos.add(campoActividad);
		campos.add(campoNombre);
		campos.add(campoStatus);
		campos.add(campoIcono);
		campos.add(campoLenguage);
		
		acciones.add(exportar);
		acciones.add(buscar);
		acciones.add(detalle);
		
		forma.setModel(campos);
		forma.setName("incluye");
		forma.setTitle("Incluye");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("solicitud");
		forma.setView("incluye_en_US");
		forma.setTable("incluye");
		forma.setMethods(acciones);
		forma.setCreateable(true);
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
	public void testGuardarActivity_en_US() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_activity_en_US.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoCodigo = new Field();
		Field campoNombre = new Field();
		Field campoTitulo = new Field();
		Field campoDescription = new Field();
		Field campoNote = new Field();
		Field campoCategoria = new Field();
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("comprobante");
		exportar.setModule("comprobantes");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button detallePedido = new Button();
		detallePedido.setCommandName("detalle");
		detallePedido.setName("detalle");
		detallePedido.setLabel("Detalles");
		detallePedido.setComponentType("submit");
		detallePedido.setCss("btn btn-success");
		detallePedido.setResourceName("activity");
		detallePedido.setModule("cactus");
		detallePedido.setOrder(2);
		detallePedido.setResourceType("form");
		detallePedido.setVersion("1.0");
		detallePedido.setEvents("nuevo,buscar");
		
		Button mostrar = new Button();
		mostrar.setCommandName("filtros");
		mostrar.setName("filtros");
		mostrar.setLabel("Mostrar filtros");
		mostrar.setComponentType("botonliga");
		mostrar.setCss("btn btn-secondary");
		mostrar.setResourceName("activity");
		mostrar.setModule("cactus");
		mostrar.setOrder(2);
		mostrar.setResourceType("form");
		mostrar.setVersion("1.0");
		mostrar.setEvents("nuevo,buscar");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Buscar");
		buscar.setComponentType("submit");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("includes");
		buscar.setModule("cactus");
		buscar.setOrder(2);
		buscar.setResourceType("basket");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo,buscar");
		
		campoCodigo.setFieldName("codigo");
		campoCodigo.setName("Code");
		campoCodigo.setHidden(false);
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setLength(1);
		campoCodigo.setShowInBasket(true);
		
		campoNombre.setFieldName("name");
		campoNombre.setName("Name");
		campoNombre.setHidden(false);
		campoNombre.setOrder(2);
		campoNombre.setComponentType("texto");
		campoNombre.setLength(1);
		campoNombre.setShowInBasket(true);

		campoTitulo.setFieldName("title");
		campoTitulo.setName("Title");
		campoTitulo.setHidden(false);
		campoTitulo.setOrder(3);
		campoTitulo.setComponentType("texto");
		campoTitulo.setLength(50);
		campoTitulo.setShowInBasket(true);
		
		campoDescription.setFieldName("description");
		campoDescription.setName("Description");
		campoDescription.setHidden(false);
		campoDescription.setOrder(4);
		campoDescription.setComponentType("texto");
		campoDescription.setLength(50);
		campoDescription.setShowInBasket(true);
		
		campoNote.setFieldName("note");
		campoNote.setName("Notes");
		campoNote.setHidden(false);
		campoNote.setOrder(5);
		campoNote.setComponentType("texto");
		campoNote.setLength(50);
		campoNote.setShowInBasket(true);
		
		campoCategoria.setFieldName("category");
		campoCategoria.setName("Category");
		campoCategoria.setHidden(false);
		campoCategoria.setOrder(6);
		campoCategoria.setComponentType("texto");
		campoCategoria.setLength(50);
		campoCategoria.setShowInBasket(true);
		
		campos.add(campoCodigo);
		campos.add(campoNombre);
		campos.add(campoTitulo);
		campos.add(campoDescription);
		campos.add(campoNote);
		campos.add(campoCategoria);
		
		acciones.add(exportar);
		acciones.add(detallePedido);
		acciones.add(mostrar);
		acciones.add(buscar);
		
		forma.setModel(campos);
		forma.setName("activity");
		forma.setTitle("Activities");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("cactus");
		forma.setView("activity_en_US");
		forma.setTable("activity");
		forma.setMethods(acciones);
		forma.setCreateable(true);
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
	public void testGuardarPrices_en_US() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_prices_en_US.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoCodigo = new Field();
		Field campoNombre = new Field();
		Field campoTitulo = new Field();
		Field campoDescription = new Field();
		Field campoNote = new Field();
		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("comprobante");
		exportar.setModule("comprobantes");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button mostrar = new Button();
		mostrar.setCommandName("filtros");
		mostrar.setName("filtros");
		mostrar.setLabel("Mostrar filtros");
		mostrar.setComponentType("botonliga");
		mostrar.setCss("btn btn-secondary");
		mostrar.setResourceName("prices");
		mostrar.setModule("cactus");
		mostrar.setOrder(2);
		mostrar.setResourceType("form");
		mostrar.setVersion("1.0");
		mostrar.setEvents("nuevo,buscar");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Buscar");
		buscar.setComponentType("submit");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("prices");
		buscar.setModule("cactus");
		buscar.setOrder(2);
		buscar.setResourceType("basket");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo,buscar");
		
		Button detallePedido = new Button();
		detallePedido.setCommandName("detalle");
		detallePedido.setName("detalle");
		detallePedido.setLabel("Detalles");
		detallePedido.setComponentType("submit");
		detallePedido.setCss("btn btn-success");
		detallePedido.setResourceName("prices");
		detallePedido.setModule("cactus");
		detallePedido.setOrder(2);
		detallePedido.setResourceType("form");
		detallePedido.setVersion("1.0");
		detallePedido.setEvents("detalle,buscar");
		
		campoCodigo.setFieldName("codigo");
		campoCodigo.setName("Code");
		campoCodigo.setHidden(false);
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setLength(1);
		campoCodigo.setShowInBasket(true);
		
		campoNombre.setFieldName("name");
		campoNombre.setName("Name");
		campoNombre.setHidden(false);
		campoNombre.setOrder(2);
		campoNombre.setComponentType("texto");
		campoNombre.setLength(1);
		campoNombre.setShowInBasket(true);

		campoTitulo.setFieldName("price");
		campoTitulo.setName("Price");
		campoTitulo.setHidden(false);
		campoTitulo.setOrder(3);
		campoTitulo.setComponentType("texto");
		campoTitulo.setLength(50);
		campoTitulo.setShowInBasket(true);
		
		campoDescription.setFieldName("currency");
		campoDescription.setName("Currency");
		campoDescription.setHidden(false);
		campoDescription.setOrder(4);
		campoDescription.setComponentType("texto");
		campoDescription.setLength(50);
		campoDescription.setShowInBasket(true);
		
		campoNote.setFieldName("language");
		campoNote.setName("Language");
		campoNote.setHidden(false);
		campoNote.setOrder(5);
		campoNote.setComponentType("texto");
		campoNote.setLength(50);
		campoNote.setShowInBasket(true);
		
		campos.add(campoCodigo);
		campos.add(campoNombre);
		campos.add(campoTitulo);
		campos.add(campoDescription);
		campos.add(campoNote);
		
		acciones.add(exportar);
		acciones.add(detallePedido);
		acciones.add(mostrar);
		acciones.add(buscar);
		
		forma.setModel(campos);
		forma.setName("prices");
		forma.setTitle("Prices");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("cactus");
		forma.setView("prices_en_US");
		forma.setTable("prices");
		forma.setMethods(acciones);
		forma.setCreateable(true);
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
	public void testGuardarIncludes_en_US() throws IOException {
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();

		Path filePath = fileConfigLocation.resolve("canasta_includes_en_US.json").normalize();

		IGenerador<Resource> generador = new Generador<Resource>(new String[] {"/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config"});

		List<Field> campos = new ArrayList<Field>();
		List<Button> acciones = new ArrayList<Button>();
		
		Field campoCodigo = new Field();
		Field campoNombre = new Field();
		Field campoTitulo = new Field();
		Field campoActividad = new Field();

		Resource forma = new Resource();
		
		Button exportar = new Button();
		exportar.setCommandName("exportar");
		exportar.setName("exportar");
		exportar.setLabel("Exportar");
		exportar.setComponentType("boton");
		exportar.setCss("btn btn-secondary");
		exportar.setResourceName("comprobante");
		exportar.setModule("comprobantes");
		exportar.setOrder(1);
		exportar.setResourceType("form");
		exportar.setVersion("1.0");
		exportar.setEvents("nuevo");
		
		Button mostrar = new Button();
		mostrar.setCommandName("filtros");
		mostrar.setName("filtros");
		mostrar.setLabel("Mostrar filtros");
		mostrar.setComponentType("botonliga");
		mostrar.setCss("btn btn-secondary");
		mostrar.setResourceName("producto");
		mostrar.setModule("inventario");
		mostrar.setOrder(2);
		mostrar.setResourceType("form");
		mostrar.setVersion("1.0");
		mostrar.setEvents("nuevo,buscar");
		
		Button buscar = new Button();
		buscar.setCommandName("buscar");
		buscar.setName("buscar");
		buscar.setLabel("Buscar");
		buscar.setComponentType("submit");
		buscar.setCss("btn btn-secondary");
		buscar.setResourceName("includes");
		buscar.setModule("cactus");
		buscar.setOrder(2);
		buscar.setResourceType("basket");
		buscar.setVersion("1.0");
		buscar.setEvents("nuevo,buscar");
		
		Button detallePedido = new Button();
		detallePedido.setCommandName("detalle");
		detallePedido.setName("detalle");
		detallePedido.setLabel("Detalles");
		detallePedido.setComponentType("submit");
		detallePedido.setCss("btn btn-success");
		detallePedido.setResourceName("includes");
		detallePedido.setModule("cactus");
		detallePedido.setOrder(2);
		detallePedido.setResourceType("form");
		detallePedido.setVersion("1.0");
		detallePedido.setEvents("nuevo,buscar");
		
		campoCodigo.setFieldName("codigo");
		campoCodigo.setName("Code");
		campoCodigo.setHidden(false);
		campoCodigo.setOrder(1);
		campoCodigo.setComponentType("texto");
		campoCodigo.setLength(1);
		campoCodigo.setShowInBasket(true);
		
		campoNombre.setFieldName("name");
		campoNombre.setName("Name");
		campoNombre.setHidden(false);
		campoNombre.setOrder(2);
		campoNombre.setComponentType("texto");
		campoNombre.setLength(1);
		campoNombre.setShowInBasket(true);

		campoTitulo.setFieldName("icono");
		campoTitulo.setName("Title");
		campoTitulo.setHidden(false);
		campoTitulo.setOrder(3);
		campoTitulo.setComponentType("texto");
		campoTitulo.setLength(50);
		campoTitulo.setShowInBasket(true);
		
		campoActividad.setFieldName("actividad");
		campoActividad.setName("Activity");
		campoActividad.setHidden(false);
		campoActividad.setOrder(4);
		campoActividad.setComponentType("texto");
		campoActividad.setLength(10);
		campoActividad.setShowInBasket(true);		
		
		campos.add(campoCodigo);
		campos.add(campoNombre);
		campos.add(campoTitulo);
		campos.add(campoActividad);
		
		acciones.add(exportar);
		acciones.add(detallePedido);
		acciones.add(buscar);
		acciones.add(mostrar);
		
		forma.setModel(campos);
		forma.setName("includes");
		forma.setTitle("Includes");
		forma.setVersion("1.0");
		forma.setStatus("produccion");
		forma.setModule("cactus");
		forma.setView("includes_en_US");
		forma.setTable("includes");
		forma.setMethods(acciones);
		forma.setCreateable(true);
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