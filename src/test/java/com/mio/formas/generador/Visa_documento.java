package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** visa/documento: file attached to a solicitud (passport scan, photo, job offer, ...). */
public class Visa_documento extends VisaGenerador {

	@Test
	public void testNuevo() throws IOException {
		generar("documento", "Documento", "DOC", "Archivos adjuntos a una solicitud",
			campos(
				uuidp(),
				texto("requisito", "Requisito documental", 150).required().basket().search(),
				archivo("archivo", "Archivo").required(),
				texto("nombrearchivo", "Nombre del archivo", 250).readOnly().basket().search(),
				texto("tipocontenido", "Tipo de contenido", 100).readOnly().basket(),
				entero("tamano", "Tamano (bytes)").readOnly().basket(),
				texto("ruta", "Ruta de almacenamiento", 400).readOnly().hidden(),
				texto("hash", "Hash SHA-256", 64).readOnly().hidden(),
				lista("status", "Estatus del documento", "Pendiente,Recibido,Aprobado,Rechazado").basket().value("Recibido"),
				area("comentario", "Comentario", 500),
				email("subidopor", "Subido por").readOnly().basket(),
				fechaHora("fechasubida", "Fecha de carga").readOnly().basket().value("${default::fechayHoraCorto}"),
				uuid()),
			metodosComunes(MODULO, "documento", VERSION, "subir|Subir archivo", "descargar|Descargar"));
	}
}
