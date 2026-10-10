package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** visa/tipovisa: catalog of visa types (TN, TD, E-1, E-2, L-1A, L-1B, L-2, O-1A, O-1B, EB-1A, EB-2 NIW). */
public class Visa_tipovisa extends VisaGenerador {

	@Test
	public void testNuevo() throws IOException {
		generar("tipovisa", "Tipo de visa", "TVI", "Catalogo de tipos de visa y residencia basados en empleo",
			campos(
				texto("codigo", "Codigo", 20).required().basket().search().group("catalogo"),
				texto("nombre", "Nombre", 150).required().basket().search().group("catalogo"),
				lista("categoria", "Categoria", "Trabajo,Transferencia intracorporativa,Habilidades extraordinarias,Residencia permanente").required().basket().search().group("catalogo"),
				area("descripcion", "Descripcion", 500).group("catalogo"),
				area("elegibilidad", "Elegibilidad", 1000).group("requisitos"),
				area("requisitos", "Requisitos", 1500).group("requisitos"),
				texto("nacionalidadrequerida", "Nacionalidad requerida", 100).group("requisitos"),
				entero("experienciaminima", "Experiencia minima (anios)").group("requisitos").value("0"),
				entero("duracioninicial", "Duracion inicial (anios)").basket().group("vigencia"),
				entero("duracionrenovacion", "Duracion en renovacion (anios)").group("vigencia"),
				entero("duracionmaxima", "Duracion maxima (anios, 0 = ilimitada)").group("vigencia").value("0"),
				lista("renovable", "Renovable", SI_NO).group("vigencia").value("Si"),
				texto("lugartramite", "Lugar de tramite", 150).group("tramite"),
				decimal("inversionrecomendada", "Inversion recomendada (USD)").group("tramite"),
				texto("dependede", "Es dependiente de (codigos)", 60).group("dependencia")
					.comment("TD depende de TN; L-2 depende de L-1A o L-1B"),
				lista("conyugetrabajo", "Permiso de trabajo del conyuge", "No aplica,Automatico,No automatico").group("dependencia").value("No aplica"),
				lista("activo", "Activo", SI_NO).basket().search().group("catalogo").value("Si"),
				entero("posicion", "Posicion en el listado").group("catalogo").value("0"),
				uuid()),
			metodosComunes(MODULO, "tipovisa", VERSION));
	}
}
