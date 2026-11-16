package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** case/solicitud_vacaciones: la solicitud de vacaciones de una persona empleada (flujo aprobacion-vacaciones). Generated JSON goes to formuscmp-formus/config (see CaseGenerador). */
public class Case_solicitud_vacaciones extends CaseGenerador {

	@Test
	public void testNuevo() throws IOException {
		generar("solicitud_vacaciones", "Solicitud de vacaciones", "VAC", "Solicitud de vacaciones de una persona empleada",
			campos(
				uuid(),
				texto("empleado", "Nombre del empleado", 100).required().basket().search(),
				email("correo", "Correo").required().basket().search(),
				fecha("desde", "Desde").required().basket(),
				fecha("hasta", "Hasta").required().basket(),
				entero("dias", "Dias solicitados").required().basket(),
				lista("tipo", "Tipo", "Vacaciones,Permiso sin goce").required().basket(),
				area("motivo", "Motivo", 500),
				area("comentario", "Comentario de la revision", 500),
				fechaHora("falta", "Fecha").readOnly().basket().value("${default::fechayHoraCorto}"),
				lista("status", "Estatus", "pendiente,aprobada,rechazada").basket().value("pendiente")),
			metodosComunes(MODULO, "solicitud_vacaciones", VERSION));
	}
}
