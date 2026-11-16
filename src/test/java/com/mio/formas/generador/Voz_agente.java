package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** voz/agente: quien atiende llamadas. La persona vive en directorio/usuario; aqui solo su estado, sus colas y la llamada que atiende. Una fila por persona. */
public class Voz_agente extends VozGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarVoz("agente", "Agente", "AGT", "Agente de llamadas",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("persona", "Persona (uuid de directorio/usuario)", 60).required().basket().search(),
				texto("nombre", "Nombre", 80).basket().search(),
				texto("colas", "Colas (uuid, separados por coma)", 300),
				lista("estado", "Estado", "disponible,en_llamada,descanso,desconectado").readOnly().basket().value("desconectado"),
				fechaHora("ultimocambio", "Ultimo cambio de estado").readOnly().basket(),
				texto("llamada", "Llamada que atiende (uuid)", 60).readOnly(),
				check("activo", "Activo").basket().value("true"),
				fechaHora("falta", "Fecha de alta").readOnly().value("${default::fechayHoraCorto}")),
			metodosComunes(MODULO_VOZ, "agente", VERSION));
	}
}
