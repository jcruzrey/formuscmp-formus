package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/**
 * case/template: an HTML template (a message or document body) with its direction (output = what the platform sends, input = what it receives) and its
 * output type (the HTTP Content-Type it is served as: text/html, application/json, ...).
 * No table: each template is one JSON file, base/template/<module>/<resourceName>/1.0/template01_es_MX.json (see the template commands of
 * formuscmp-formus-api and templates/form/html/template.ftl of the web site). The creator and the creation date are set by the backend when the
 * file is first written. Labels use unicode escapes because the build does not compile sources as UTF-8. Generated JSON goes to
 * formuscmp-formus/config (see CaseGenerador); deploy per tools/deploy_case_models.py.
 */
public class Case_template extends CaseGenerador {

	@Test
	public void testNuevo() throws IOException {
		persistible = false;
		generar("template", "Plantilla", "TPL", "Plantilla HTML de entrada o salida",
			campos(
				uuid(),
				fechaHora("fechacreado", "Fecha creado").readOnly().basket().value("${default::fechayHoraCorto}"),
				texto("creadopor", "Creado por", 150).readOnly().basket(),
				texto("nombre", "Nombre", 100).required().basket().search(),
				lista("status", "Estatus", "active,blocked").required().basket().value("active"),
				texto("templatename", "Nombre de la plantilla", 100).required().basket().search(),
				lista("direction", "Dirección", "output,input").required().basket().value("output"),
				lista("outputtype", "Tipo de salida", "text/html,text/plain,text/csv,text/xml,application/json,application/xml,application/pdf,application/octet-stream,application/x-www-form-urlencoded,multipart/form-data").required().basket().value("text/html"),
				largo("templatecontents", "Contenido de la plantilla").required()),
			metodosComunes(MODULO, "template", VERSION));
	}
}
