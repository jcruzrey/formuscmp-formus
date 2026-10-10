package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** visa/requisito: documents required for each visa type (drives the upload section of the form). */
public class Visa_requisito extends VisaGenerador {

	@Test
	public void testNuevo() throws IOException {
		generar("requisito", "Requisito documental", "REQ", "Documentos requeridos por tipo de visa",
			campos(
				lista("tipovisa", "Tipo de visa", TIPOS_VISA).required().basket().search(),
				texto("nombre", "Documento", 150).required().basket().search(),
				area("descripcion", "Descripcion", 500),
				lista("clasificacion", "Clasificacion", "Identidad,Academico,Laboral,Financiero,Corporativo,Familiar,Otro").basket().value("Otro"),
				lista("obligatorio", "Obligatorio", SI_NO).basket().value("Si"),
				texto("formatos", "Formatos permitidos", 60).value("PDF,JPG,PNG"),
				entero("posicion", "Posicion").value("0"),
				lista("activo", "Activo", SI_NO).basket().value("Si"),
				uuid()),
			metodosComunes(MODULO, "requisito", VERSION));
	}
}
