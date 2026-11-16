package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** voz/llamada: una llamada (entrante o saliente) = una corrida de workflow; la escriben los comandos de voz (webhook, estado), no la web. */
public class Voz_llamada extends VozGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarVoz("llamada", "Llamada", "LLA", "Una llamada telefonica; una llamada = una corrida de workflow",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("sid", "ID del proveedor", 64).readOnly().basket().search(),
				lista("direccion", "Direccion", "entrante,saliente").readOnly().basket(),
				texto("campana", "Campana (uuid)", 60).readOnly().search(),
				texto("contacto", "Contacto de campana (uuid)", 60).readOnly().search(),
				texto("persona", "Persona (uuid de directorio/usuario)", 60).readOnly().search(),
				texto("numero", "Numero propio (uuid)", 60).readOnly(),
				texto("desde", "Desde (E.164)", 20).readOnly().basket().search(),
				texto("hacia", "Hacia (E.164)", 20).readOnly().basket().search(),
				texto("corrida", "Corrida del workflow", 60).readOnly().search(),
				texto("paso", "Paso actual", 60).readOnly(),
				entero("turno", "Turno").readOnly().value("0"),
				texto("ultimoevento", "Ultimo evento procesado", 80).readOnly().hidden(),
				lista("estado", "Estado", "en_marcado,sonando,en_curso,completada,ocupado,sin_respuesta,buzon,fallida,cancelada").readOnly().basket().value("en_marcado"),
				lista("disposicion", "Disposicion", "interesado,no_interesado,volver_a_llamar,no_contesta,buzon,no_llamar,error,otra").readOnly().basket(),
				texto("idioma", "Idioma", 10).readOnly(),
				fechaHora("falta", "Fecha de alta").readOnly().basket().value("${default::fechayHoraCorto}"),
				fechaHora("inicio", "Inicio").readOnly(),
				fechaHora("fin", "Fin").readOnly(),
				entero("duracion", "Duracion (s)").readOnly().basket(),
				decimal("costo", "Costo").readOnly().basket(),
				lista("moneda", "Moneda", "USD,MXN").readOnly(),
				texto("grabacion", "Grabacion (uuid)", 60).readOnly(),
				largo("datos", "Datos capturados (JSON)").readOnly()),
			metodosComunes(MODULO_VOZ, "llamada", VERSION));
	}
}
