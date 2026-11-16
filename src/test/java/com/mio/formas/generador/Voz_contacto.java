package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** voz/contacto: la pertenencia de una persona (directorio/usuario) a una campana, con lo propio de la campana. No guarda nombre ni telefono. */
public class Voz_contacto extends VozGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarVoz("contacto", "Contacto de campana", "CTO", "Persona inscrita en una campana de llamadas",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("campana", "Campana (uuid)", 60).required().readOnly().basket().search(),
				texto("persona", "Persona (uuid de directorio/usuario)", 60).required().readOnly().basket().search(),
				lista("estado", "Estado", "pendiente,en_marcado,en_curso,completado,reintentar,no_contactar,error").readOnly().basket().value("pendiente"),
				entero("intentos", "Intentos").readOnly().basket().value("0"),
				lista("disposicion", "Ultima disposicion", "interesado,no_interesado,volver_a_llamar,no_contesta,buzon,no_llamar,error,otra").readOnly().basket(),
				fechaHora("ultimointento", "Ultimo intento").readOnly().basket(),
				fechaHora("proximointento", "Proximo intento").readOnly().basket(),
				texto("llamada", "Ultima llamada (uuid)", 60).readOnly(),
				largo("datos", "Datos para el guion (JSON)"),
				fechaHora("falta", "Fecha de alta").readOnly().value("${default::fechayHoraCorto}")),
			metodosComunes(MODULO_VOZ, "contacto", VERSION));
	}
}
