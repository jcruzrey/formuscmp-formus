package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** case/plan: Plan de suscripcion (catalogo). Generated JSON goes to formuscmp-formus/config (see CaseGenerador); deploy per formus/sql README. */
public class Case_plan extends CaseGenerador {

	@Test
	public void testNuevo() throws IOException {
		generar("plan", "Plan", "PLN", "Plan de suscripcion (catalogo)",
			campos(
				uuid(),
				texto("nombre", "Nombre", 80).required().basket().search(),
				area("descripcion", "Descripcion", 500),
				decimal("precio", "Precio").basket(),
				lista("moneda", "Moneda", "MXN,USD").basket(),
				lista("periodo", "Periodo", "gratis,mensual,anual").basket(),
				entero("limiteformularios", "Limite de formularios"),
				entero("limiterespuestas", "Limite de respuestas por mes"),
				entero("limitealmacenamiento", "Almacenamiento (MB)"),
				entero("limiteusuarios", "Usuarios"),
				area("caracteristicas", "Caracteristicas (una por linea)", 1000),
				check("destacado", "Destacado").value("false"),
				check("gratuito", "Plan gratuito").value("false"),
				entero("orden", "Orden").basket(),
				check("activo", "Activo").value("true")),
			metodosComunes(MODULO, "plan", VERSION));
	}
}
