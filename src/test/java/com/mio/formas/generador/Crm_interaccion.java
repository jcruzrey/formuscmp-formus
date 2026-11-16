package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** crm/interaccion: un contacto con una persona (llamada, correo, SMS, reunion, nota...). La escriben los comandos del CRM y el cierre de las llamadas; la empresa sale del que escribe, nunca de la peticion. */
public class Crm_interaccion extends CrmGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarCrm("interaccion", "Interaccion", "INT", "Interaccion con una persona",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("empresa", "Empresa (codigo)", 60).readOnly().basket().search(),
				texto("persona", "Persona (uuid de directorio/usuario)", 60).required().readOnly().basket().search(),
				texto("oportunidad", "Oportunidad (uuid)", 60).readOnly().search(),
				lista("canal", "Canal", "llamada,correo,sms,reunion,nota,otro").basket().value("otro"),
				lista("direccion", "Direccion", "entrante,saliente,interna").basket().value("interna"),
				area("resumen", "Resumen", 500),
				texto("autor", "Autor (usuario)", 120).readOnly().basket().search(),
				fechaHora("fecha", "Fecha de la interaccion").basket(),
				texto("origen", "Origen (referencia)", 120).readOnly(),
				fechaHora("falta", "Fecha de alta").readOnly().value("${default::fechayHoraCorto}")),
			metodosComunes(MODULO_CRM, "interaccion", VERSION));
	}
}
