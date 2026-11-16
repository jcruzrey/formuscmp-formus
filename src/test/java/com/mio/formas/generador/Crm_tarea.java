package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** crm/tarea: algo que hacer (llamar, enviar, dar seguimiento) con responsable y vencimiento. */
public class Crm_tarea extends CrmGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarCrm("tarea", "Tarea", "TAR", "Tarea de seguimiento",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("empresa", "Empresa (codigo)", 60).readOnly().basket().search(),
				texto("persona", "Persona (uuid de directorio/usuario)", 60).required().readOnly().basket().search(),
				texto("oportunidad", "Oportunidad (uuid)", 60).readOnly().search(),
				texto("titulo", "Titulo", 160).required().basket().search(),
				area("descripcion", "Descripcion", 1000),
				texto("responsable", "Responsable (usuario)", 120).basket().search(),
				fechaHora("vence", "Vence").basket(),
				lista("estado", "Estado", "pendiente,en_curso,hecha,cancelada").basket().value("pendiente"),
				lista("prioridad", "Prioridad", "baja,media,alta").basket().value("media"),
				texto("autor", "Autor (usuario)", 120).readOnly().search(),
				fechaHora("falta", "Fecha de alta").readOnly().value("${default::fechayHoraCorto}"),
				fechaHora("completada", "Completada el").readOnly()),
			metodosComunes(MODULO_CRM, "tarea", VERSION));
	}
}
