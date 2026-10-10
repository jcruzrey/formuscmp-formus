package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** case/definicion: Definicion de un formulario creado por un usuario en el constructor (JSON builder + estado). Generated JSON goes to formuscmp-formus/config (see CaseGenerador); deploy per formus/sql README. */
public class Case_definicion extends CaseGenerador {

	@Test
	public void testNuevo() throws IOException {
		generar("definicion", "Definicion", "DEF", "Definicion de un formulario creado por un usuario en el constructor (JSON builder + estado)",
			campos(
				uuid(),
				email("usuario", "Propietario").required().basket().search(),
				texto("nombre", "Nombre tecnico", 64).required().search(),
				texto("titulo", "Titulo", 200).required().basket().search(),
				lista("status", "Estatus", "Borrador,Publicado").basket().value("Borrador"),
				largo("definicion", "Definicion (JSON del constructor)"),
				fechaHora("falta", "Fecha de alta").readOnly().basket().value("${default::fechayHoraCorto}"),
				fechaHora("fmodif", "Ultima modificacion").readOnly().basket(),
				fechaHora("publicado", "Fecha de publicacion").readOnly()),
			metodosComunes(MODULO, "definicion", VERSION));
	}
}
