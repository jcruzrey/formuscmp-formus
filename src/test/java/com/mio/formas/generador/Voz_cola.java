package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** voz/cola: un grupo de agentes al que se transfieren llamadas, con su regla de a quien suena primero y cuanto. */
public class Voz_cola extends VozGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarVoz("cola", "Cola", "COL", "Cola de agentes",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("nombre", "Nombre", 80).required().basket().search(),
				area("descripcion", "Descripcion", 300),
				lista("estrategia", "A quien suena primero", "ordenada,menos_ocupado").basket().value("ordenada"),
				entero("espera", "Segundos que suena cada agente").value("20"),
				lista("sinagente", "Si nadie contesta", "colgar,buzon").value("colgar"),
				check("activa", "Activa").basket().value("true"),
				fechaHora("falta", "Fecha de alta").readOnly().value("${default::fechayHoraCorto}")),
			metodosComunes(MODULO_VOZ, "cola", VERSION));
	}
}
