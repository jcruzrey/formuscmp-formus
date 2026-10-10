package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** visa/dependiente: spouse or child (under 21, unmarried) attached to a solicitud (TD, L-2). */
public class Visa_dependiente extends VisaGenerador {

	@Test
	public void testNuevo() throws IOException {
		generar("dependiente", "Dependiente", "DEP", "Conyuge e hijos incluidos en una solicitud",
			campos(
				uuidp(),
				texto("nombre", "Nombre completo", 150).required().basket().search(),
				lista("parentesco", "Parentesco", "Conyuge,Hijo,Hija").required().basket(),
				fecha("fechanacimiento", "Fecha de nacimiento").required().basket(),
				lista("estadocivil", "Estado civil", "Soltero,Casado,Union libre,Divorciado,Viudo").value("Soltero"),
				texto("nacionalidad", "Nacionalidad", 60).value("Mexicana"),
				texto("numeropasaporte", "Numero de pasaporte", 30),
				fecha("vencimientopasaporte", "Vencimiento del pasaporte"),
				uuid()),
			metodosComunes(MODULO, "dependiente", VERSION));
	}
}
