package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** voz/pin: el PIN con que una persona se identifica por telefono. Solo un hash con sal (y un secreto del servidor); nunca el PIN. Una fila por persona. */
public class Voz_pin extends VozGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarVoz("pin", "PIN", "PIN", "PIN de una persona",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("persona", "Persona (uuid de directorio/usuario)", 60).required().readOnly().basket().search(),
				texto("pinhash", "Hash del PIN", 64).readOnly().hidden(),
				texto("pinsal", "Sal del PIN", 40).readOnly().hidden(),
				entero("intentos", "Intentos fallidos seguidos").readOnly().value("0"),
				fechaHora("bloqueohasta", "Bloqueado hasta").readOnly().basket(),
				fechaHora("actualizado", "Ultimo cambio del PIN").readOnly().basket(),
				fechaHora("falta", "Fecha de alta").readOnly().value("${default::fechayHoraCorto}")),
			metodosComunes(MODULO_VOZ, "pin", VERSION));
	}
}
