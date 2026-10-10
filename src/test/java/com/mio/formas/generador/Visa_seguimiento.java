package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** visa/seguimiento: status history and notes of a solicitud (staff notes can be internal). */
public class Visa_seguimiento extends VisaGenerador {

	@Test
	public void testNuevo() throws IOException {
		generar("seguimiento", "Seguimiento", "SEG", "Historial de estatus y notas de una solicitud",
			campos(
				uuidp(),
				lista("tipo", "Tipo", "Cambio de estatus,Mensaje al solicitante,Nota interna").required().basket().value("Cambio de estatus"),
				lista("status", "Estatus", ESTATUS_SOLICITUD).basket(),
				area("comentario", "Comentario", 1000).required().basket(),
				lista("visible", "Visible para el solicitante", SI_NO).basket().value("Si"),
				email("usuario", "Registrado por").readOnly().basket(),
				fechaHora("fecha", "Fecha").readOnly().basket().value("${default::fechayHoraCorto}"),
				uuid()),
			metodosComunes(MODULO, "seguimiento", VERSION));
	}
}
