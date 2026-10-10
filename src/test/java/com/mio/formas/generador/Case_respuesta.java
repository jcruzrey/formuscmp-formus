package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** case/respuesta: Respuesta capturada con un formulario publicado (metadatos + JSON de valores). Generated JSON goes to formuscmp-formus/config (see CaseGenerador); deploy per formus/sql README. */
public class Case_respuesta extends CaseGenerador {

	@Test
	public void testNuevo() throws IOException {
		generar("respuesta", "Respuesta", "RES", "Respuesta capturada con un formulario publicado (metadatos + JSON de valores)",
			campos(
				uuid(),
				texto("formulario", "Formulario (uuid)", 80).required().basket().search(),
				email("propietario", "Propietario del formulario").hidden().search(),
				texto("titulo", "Titulo del formulario", 200).readOnly().basket(),
				texto("formversion", "Version del formulario", 10).readOnly(),
				texto("usuario", "Capturado por", 150).readOnly().basket().search(),
				fechaHora("falta", "Fecha").readOnly().basket().value("${default::fechayHoraCorto}"),
				texto("ip", "IP", 45).readOnly().basket(),
				texto("ubicacion", "Ubicacion", 100).readOnly().basket(),
				texto("navegador", "Navegador", 200).readOnly().basket(),
				lista("status", "Estatus", "nueva,leida,archivada").basket().value("nueva"),
				largo("datos", "Valores capturados (JSON)")),
			metodosComunes(MODULO, "respuesta", VERSION));
	}
}
