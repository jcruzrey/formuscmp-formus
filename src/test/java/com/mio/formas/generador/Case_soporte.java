package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** case/soporte: Ticket de soporte. Generated JSON goes to formuscmp-formus/config (see CaseGenerador); deploy per formus/sql README. */
public class Case_soporte extends CaseGenerador {

	@Test
	public void testNuevo() throws IOException {
		generar("soporte", "Soporte", "SOP", "Ticket de soporte",
			campos(
				uuid(),
				email("usuario", "Usuario").readOnly().basket().search(),
				texto("asunto", "Asunto", 150).required().basket().search(),
				lista("categoria", "Categoria", "tecnico,facturacion,cuenta,otro").required().basket(),
				area("mensaje", "Mensaje", 1000).required(),
				fechaHora("falta", "Fecha").readOnly().basket().value("${default::fechayHoraCorto}"),
				lista("status", "Estatus", "abierto,en proceso,cerrado").basket().value("abierto")),
			metodosComunes(MODULO, "soporte", VERSION));
	}
}
