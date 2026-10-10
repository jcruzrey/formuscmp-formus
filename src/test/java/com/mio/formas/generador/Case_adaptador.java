package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/**
 * case/adaptador: definition of an HTTP call (an "adaptador") laid out like the RESTer Firefox add-on request editor: Method + URL (+ SEND),
 * then the tabs ENCABEZADOS / CUERPO / AUTORIZACION / VARIABLES (the field `group` is the tab). Headers and variables are JSON arrays
 * [{"nombre","valor","activo"}]. Field names and labels are exactly those of templates/form/html/adaptador.ftl, whose "Guardar JSON" button
 * writes these fields to a .json file (authsecreto is never written). No table: the model is never persisted (persistible=false).
 * Labels use unicode escapes because the build does not compile sources as UTF-8. Generated JSON goes to formuscmp-formus/config (see
 * CaseGenerador); deploy per tools/deploy_case_models.py.
 */
public class Case_adaptador extends CaseGenerador {

	@Test
	public void testNuevo() throws IOException {
		persistible = false;
		generar("adaptador", "Adaptador", "ADP", "Adaptador de llamadas HTTP (editor tipo RESTer)",
			campos(
				uuid(),
				texto("nombre", "Nombre", 100).required().basket().search(),
				texto("coleccion", "Colecci\u00f3n", 100).basket().search(),
				area("descripcion", "Descripci\u00f3n", 500),
				lista("metodo", "M\u00e9todo", "GET,POST,PUT,PATCH,DELETE,HEAD,OPTIONS").required().basket().value("POST").group("peticion"),
				texto("uri", "URL", 500).required().basket().search().group("peticion"),
				largo("encabezados", "Encabezados (JSON)").group("encabezados"),
				lista("tipocuerpo", "Tipo de contenido", "ninguno,json,texto,xml,formulario,urlencoded").value("json").group("cuerpo"),
				largo("cuerpo", "Cuerpo").group("cuerpo"),
				check("usaplantilla", "Cuerpo con plantilla").group("cuerpo"),
				largo("plantilla", "Plantilla del cuerpo").group("cuerpo"),
				texto("recurso", "Forma de entrada", 60).group("cuerpo"),
				lista("tipoauth", "Autorizaci\u00f3n", "ninguna,basica,oauth2").value("ninguna").group("autorizacion"),
				texto("authusuario", "Usuario", 150).group("autorizacion"),
				texto("authsecreto", "Contrase\u00f1a o token", 500).group("autorizacion"),
				texto("conexion", "Conexi\u00f3n", 60).group("autorizacion"),
				largo("variables", "Variables (JSON)").group("variables")),
			metodosComunes(MODULO, "adaptador", VERSION));
	}
}
