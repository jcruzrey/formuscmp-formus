package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** crm/oportunidad: una posible venta a una persona o empresa, con su monto, su etapa del embudo y su vendedor. Una oportunidad cerrada no se reabre. */
public class Crm_oportunidad extends CrmGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarCrm("oportunidad", "Oportunidad", "OPO", "Oportunidad de venta",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("empresa", "Empresa (codigo)", 60).readOnly().basket().search(),
				texto("persona", "Persona (uuid de directorio/usuario)", 60).required().readOnly().basket().search(),
				texto("titulo", "Titulo", 160).required().basket().search(),
				decimal("monto", "Monto").basket(),
				lista("moneda", "Moneda", "MXN,USD").value("MXN"),
				texto("etapa", "Etapa (uuid)", 60).basket().search(),
				entero("probabilidad", "Probabilidad (0 a 100)").basket(),
				fecha("cierre", "Cierre esperado").basket(),
				texto("vendedor", "Vendedor (usuario)", 120).basket().search(),
				lista("estado", "Estado", "abierta,ganada,perdida").basket().value("abierta"),
				texto("motivoperdida", "Motivo de la perdida", 200),
				fechaHora("falta", "Fecha de alta").readOnly().value("${default::fechayHoraCorto}"),
				fechaHora("factualiza", "Ultimo cambio").readOnly(),
				fechaHora("fcierre", "Cerrada el").readOnly()),
			metodosComunes(MODULO_CRM, "oportunidad", VERSION));
	}
}
