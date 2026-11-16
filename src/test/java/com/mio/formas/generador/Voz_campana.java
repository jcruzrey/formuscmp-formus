package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/**
 * voz/campana: una campana de llamadas (guion, numeros, horario, ritmo, reintentos y cumplimiento). Su {@code codigo} (CAM-...) es el que lista
 * {@code directorio/usuario.campanas}. El estado lo cambian los comandos iniciar / pausar / detener; que la campana omita el horario o la lista
 * no_llamar solo lo puede hacer un administrador y queda registrado (quien, cuando, por que).
 */
public class Voz_campana extends VozGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarVoz("campana", "Campana", "CAM", "Campana de llamadas telefonicas",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("nombre", "Nombre", 80).required().basket().search(),
				area("descripcion", "Descripcion", 300),
				lista("modo", "Modo", "automatico,progresivo,agente").required().basket().value("automatico"),
				texto("cola", "Cola de agentes (uuid; marcado progresivo)", 60),
				lista("estado", "Estado", "borrador,activa,pausada,detenida,finalizada").readOnly().basket().value("borrador"),
				texto("guion", "Guion (workflow)", 80).required().search(),
				texto("numeros", "Numeros de salida (uuid, separados por coma)", 300),
				lista("idioma", "Idioma por defecto", "es_MX,en_US").value("es_MX"),
				texto("zonahoraria", "Zona horaria", 60).value("America/Mexico_City"),
				texto("ventanainicio", "Ventana: desde (HH:MM)", 5).value("09:00").validation("^([01][0-9]|2[0-3]):[0-5][0-9]$"),
				texto("ventanafin", "Ventana: hasta (HH:MM)", 5).value("18:00").validation("^([01][0-9]|2[0-3]):[0-5][0-9]$"),
				texto("ventanadias", "Ventana: dias (L,M,X,J,V,S,D)", 20).value("L,M,X,J,V").validation("^[LMXJVSD](,[LMXJVSD])*$"),
				check("respetarventana", "Respetar la ventana horaria").value("true"),
				check("respetarnollamar", "Respetar la lista no llamar").value("true"),
				texto("cumplimientopor", "Cumplimiento omitido por", 150).readOnly(),
				fechaHora("cumplimientoen", "Cumplimiento omitido el").readOnly(),
				texto("cumplimientomotivo", "Motivo de omitir el cumplimiento", 200).readOnly(),
				texto("cumplimientoapaga", "Protecciones omitidas (firmado)", 40).readOnly(),
				texto("cumplimientofirma", "Firma del registro de cumplimiento", 64).readOnly(),
				entero("concurrencia", "Llamadas simultaneas maximas").value("50"),
				entero("cps", "Llamadas nuevas por segundo").value("5"),
				entero("reintentos", "Reintentos").value("2"),
				entero("esperareintento", "Espera entre reintentos (min)").value("60"),
				lista("accionbuzon", "Si contesta un buzon", "colgar,dejar_mensaje,transferir").value("colgar"),
				check("grabar", "Grabar las llamadas").value("false"),
				entero("retencion", "Retencion de grabaciones (dias)").value("90"),
				texto("usuario", "Creada por", 150).readOnly().basket(),
				fechaHora("falta", "Fecha de alta").readOnly().basket().value("${default::fechayHoraCorto}")),
			metodosComunes(MODULO_VOZ, "campana", VERSION));
	}
}
