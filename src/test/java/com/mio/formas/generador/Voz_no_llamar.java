package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** voz/no_llamar: numeros a los que no se llama; la fuente de verdad (el campo nollamar de directorio/usuario es solo un resumen). Global o de una campana. */
public class Voz_no_llamar extends VozGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarVoz("no_llamar", "No llamar", "NLL", "Numero al que no se llama",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("e164", "Numero (E.164)", 20).required().basket().search().validation("^\\+[1-9]\\d{6,14}$"),
				lista("alcance", "Alcance", "global,campana").required().basket().value("global"),
				texto("campana", "Campana (uuid, si el alcance es campana)", 60).search(),
				lista("motivo", "Motivo", "solicitud_llamada,solicitud_web,repep,administrador,otro").basket().value("otro"),
				texto("origen", "Origen (llamada o usuario que lo pidio)", 100),
				texto("nota", "Nota", 200),
				fechaHora("falta", "Fecha de alta").readOnly().basket().value("${default::fechayHoraCorto}")),
			metodosComunes(MODULO_VOZ, "no_llamar", VERSION));
	}
}
