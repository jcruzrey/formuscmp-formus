package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/** case/pago: Pago de un plan (PayPal); solo lo escriben los comandos de pago. Generated JSON goes to formuscmp-formus/config (see CaseGenerador); deploy per formus/sql README. */
public class Case_pago extends CaseGenerador {

	@Test
	public void testNuevo() throws IOException {
		generar("pago", "Pago", "PAG", "Pago de un plan (PayPal); solo lo escriben los comandos de pago",
			campos(
				uuid(),
				email("usuario", "Usuario").required().readOnly().basket().search(),
				texto("plan", "Plan (uuid)", 80).required().readOnly(),
				texto("nombreplan", "Plan", 80).readOnly().basket(),
				lista("periodo", "Periodo", "mensual,anual").readOnly().basket(),
				fechaHora("falta", "Fecha").readOnly().basket().value("${default::fechayHoraCorto}"),
				fechaHora("fechapago", "Fecha de pago").readOnly(),
				fecha("vigencia", "Vigencia hasta").readOnly(),
				texto("factura", "Numero de factura", 30).readOnly().basket().search(),
				decimal("subtotal", "Subtotal").readOnly(),
				decimal("impuesto", "Impuesto").readOnly(),
				decimal("total", "Total").readOnly().basket(),
				lista("moneda", "Moneda", "MXN,USD").readOnly().basket(),
				texto("proveedor", "Proveedor", 20).readOnly().value("PayPal"),
				texto("referencia", "Orden PayPal", 80).readOnly().search(),
				texto("captura", "Captura PayPal", 80).readOnly(),
				email("pagador", "Correo del pagador").readOnly(),
				texto("eventoid", "Ultimo evento procesado", 80).readOnly().hidden(),
				lista("status", "Estatus", "pendiente,pagado,fallido,cancelado,reembolsado").readOnly().basket().value("pendiente"),
				texto("urlfactura", "URL de la factura", 300).readOnly()),
			metodosComunes(MODULO, "pago", VERSION));
	}
}
