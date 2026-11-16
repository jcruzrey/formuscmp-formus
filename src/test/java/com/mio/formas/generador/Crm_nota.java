package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** crm/nota: una nota libre sobre una persona u oportunidad. */
public class Crm_nota extends CrmGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarCrm("nota", "Nota", "NOT", "Nota sobre una persona",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("empresa", "Empresa (codigo)", 60).readOnly().basket().search(),
				texto("persona", "Persona (uuid de directorio/usuario)", 60).required().readOnly().basket().search(),
				texto("oportunidad", "Oportunidad (uuid)", 60).readOnly().search(),
				area("texto", "Texto", 2000).required(),
				texto("autor", "Autor (usuario)", 120).readOnly().basket().search(),
				fechaHora("falta", "Fecha de alta").readOnly().basket().value("${default::fechayHoraCorto}")),
			metodosComunes(MODULO_CRM, "nota", VERSION));
	}
}
