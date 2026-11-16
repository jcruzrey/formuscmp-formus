package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** crm/etapa: un paso del embudo de ventas de una empresa. El tipo dice si la oportunidad sigue abierta o se cerro ganada o perdida. */
public class Crm_etapa extends CrmGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarCrm("etapa", "Etapa", "ETA", "Etapa del embudo de ventas",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("empresa", "Empresa (codigo)", 60).readOnly().basket().search(),
				texto("nombre", "Nombre", 80).required().basket().search(),
				entero("orden", "Orden").basket().value("0"),
				entero("probabilidad", "Probabilidad (0 a 100)").basket().value("0"),
				lista("tipo", "Tipo", "abierta,ganada,perdida").basket().value("abierta"),
				check("activa", "Activa").basket().value("true"),
				fechaHora("falta", "Fecha de alta").readOnly().value("${default::fechayHoraCorto}")),
			metodosComunes(MODULO_CRM, "etapa", VERSION));
	}
}
