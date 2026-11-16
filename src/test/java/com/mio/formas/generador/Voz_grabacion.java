package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** voz/grabacion: una grabacion de llamada guardada en la infraestructura del dueño (la ruta del archivo, no el audio). Solo la escriben los comandos de grabacion. */
public class Voz_grabacion extends VozGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarVoz("grabacion", "Grabacion", "GRB", "Grabacion de una llamada",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("llamada", "Llamada (uuid)", 60).readOnly().basket().search(),
				texto("llamadasid", "ID de la llamada en el proveedor", 40).readOnly(),
				texto("campana", "Campana (uuid)", 60).readOnly().basket().search(),
				texto("sid", "ID de la grabacion en el proveedor", 40).required().readOnly().search(),
				lista("estado", "Estado", "pendiente,guardada,error,borrada").readOnly().basket().value("pendiente"),
				texto("archivo", "Archivo (ruta relativa)", 255).readOnly().hidden(),
				entero("bytes", "Tamano (bytes)").readOnly(),
				entero("duracion", "Duracion (s)").readOnly().basket(),
				entero("canales", "Canales").readOnly(),
				entero("intentos", "Intentos de guardado").readOnly().value("0"),
				texto("ultimoerror", "Ultimo error (codigo)", 60).readOnly(),
				fechaHora("ultimointento", "Ultimo intento").readOnly(),
				fechaHora("guardada", "Guardada el").readOnly().basket(),
				check("borradoproveedor", "Borrada del proveedor").readOnly().value("false"),
				fecha("vence", "Se borra a partir de").readOnly().basket(),
				fechaHora("falta", "Fecha de alta").readOnly().value("${default::fechayHoraCorto}")),
			metodosComunes(MODULO_VOZ, "grabacion", VERSION));
	}
}
