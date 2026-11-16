package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** voz/escucha: quien escucho que grabacion y cuando. Solo la escribe el comando que entrega el audio. */
public class Voz_escucha extends VozGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarVoz("escucha", "Escucha", "ESC", "Registro de una escucha de grabacion",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("grabacion", "Grabacion (uuid)", 60).required().readOnly().basket().search(),
				texto("usuario", "Usuario", 120).required().readOnly().basket().search(),
				fechaHora("fecha", "Fecha").readOnly().basket().value("${default::fechayHoraCorto}")),
			metodosComunes(MODULO_VOZ, "escucha", VERSION));
	}
}
