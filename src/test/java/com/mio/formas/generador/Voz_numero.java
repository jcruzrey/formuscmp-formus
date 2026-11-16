package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** voz/numero: un numero del proveedor, su uso (entrante / saliente) y el guion que atiende las llamadas entrantes. */
public class Voz_numero extends VozGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarVoz("numero", "Numero", "NUM", "Numero telefonico del proveedor y su guion",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("e164", "Numero (E.164)", 20).required().basket().search().validation("^\\+[1-9]\\d{6,14}$"),
				texto("nombre", "Nombre", 80).basket().search(),
				texto("sidproveedor", "ID del numero en el proveedor", 64).readOnly(),
				lista("pais", "Pais", "MX,US").required().basket(),
				lista("uso", "Uso", "entrante,saliente,ambos").required().basket().value("ambos"),
				texto("guion", "Guion de llamadas entrantes (workflow)", 80).search(),
				lista("idioma", "Idioma por defecto", "es_MX,en_US").value("es_MX"),
				check("verificado", "Identificador de llamada verificado").basket().value("false"),
				check("activo", "Activo").basket().value("true"),
				fechaHora("falta", "Fecha de alta").readOnly().value("${default::fechayHoraCorto}")),
			metodosComunes(MODULO_VOZ, "numero", VERSION));
	}
}
