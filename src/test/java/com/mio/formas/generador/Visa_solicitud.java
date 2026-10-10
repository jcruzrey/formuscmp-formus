package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/**
 * visa/solicitud: the visa request. One table, fields grouped by purpose; the frontend shows
 * the groups that apply to the chosen tipovisa (the backend command validates the rest).
 */
public class Visa_solicitud extends VisaGenerador {

	@Test
	public void testNuevo() throws IOException {
		generar("solicitud", "Solicitud de visa", "SOL", "Solicitud de visa o residencia basada en empleo",
			campos(
				// control
				texto("folio", "Folio", 30).readOnly().basket().search().group("control"),
				lista("status", "Estatus", ESTATUS_SOLICITUD).basket().search().group("control").value("Borrador"),
				email("usuario", "Solicitante (usuario)").readOnly().basket().search().group("control"),
				email("asignadoa", "Asignada a (staff)").basket().search().group("control"),
				fechaHora("fechaalta", "Fecha de solicitud").readOnly().basket().group("control").value("${default::fechayHoraCorto}"),
				fechaHora("fechaactualizacion", "Ultima actualizacion").readOnly().group("control"),
				// visa
				lista("tipovisa", "Tipo de visa", TIPOS_VISA).required().basket().search().group("visa"),
				texto("paisdestino", "Pais de destino", 60).required().group("visa").value("Estados Unidos"),
				texto("lugartramite", "Embajada / consulado", 150).group("visa").value("Ciudad de Mexico"),
				texto("solicitudprincipal", "Folio de la solicitud principal (TD y L-2)", 60).group("visa"),
				// datos personales
				texto("nombre", "Nombre completo", 150).required().basket().search().group("personales"),
				email("email", "Correo electronico").required().basket().search().group("personales"),
				texto("telefono", "Telefono", 30).group("personales"),
				texto("nacionalidad", "Nacionalidad", 60).required().group("personales").value("Mexicana"),
				texto("paisresidencia", "Pais de residencia", 60).group("personales").value("Mexico"),
				fecha("fechanacimiento", "Fecha de nacimiento").required().group("personales"),
				lista("estadocivil", "Estado civil", "Soltero,Casado,Union libre,Divorciado,Viudo").group("personales"),
				// pasaporte
				texto("numeropasaporte", "Numero de pasaporte", 30).required().group("pasaporte"),
				texto("paisemision", "Pais de emision", 60).group("pasaporte").value("Mexico"),
				fecha("vencimientopasaporte", "Vencimiento del pasaporte").required().group("pasaporte"),
				// perfil profesional (TN, EB-2 NIW)
				texto("profesion", "Profesion", 100).group("profesional"),
				lista("niveleducativo", "Nivel academico", "Licenciatura,Maestria,Doctorado,Cedula profesional equivalente,Otro").group("profesional"),
				texto("cedula", "Cedula profesional", 30).group("profesional"),
				entero("experienciaanios", "Anios de experiencia documentada").group("profesional"),
				// empleo en EE.UU. (TN, O-1, EB)
				texto("empleador", "Empleador en EE.UU.", 150).group("empleo"),
				texto("puesto", "Puesto", 100).group("empleo"),
				lista("ofertatrabajo", "Documento de oferta", "Carta de oferta,Contrato,No aplica").group("empleo").value("No aplica"),
				texto("ciudadtrabajo", "Ciudad y estado de trabajo", 100).group("empleo"),
				// empresa (L-1A, L-1B, E-1, E-2)
				texto("empresaextranjera", "Empresa en el extranjero", 150).group("empresa"),
				texto("empresaeeuu", "Empresa en EE.UU.", 150).group("empresa"),
				lista("relacionempresas", "Relacion entre empresas", "Matriz,Subsidiaria,Afiliada,Sucursal,Otra").group("empresa"),
				entero("mesesempresa", "Meses trabajados de forma continua en la empresa").group("empresa"),
				lista("negocioopera", "El negocio en EE.UU. esta operando", SI_NO).group("empresa"),
				// comercio e inversion (E-1, E-2)
				decimal("porcentajecomercio", "Porcentaje de comercio con EE.UU.").group("inversion"),
				decimal("inversionusd", "Monto de inversion (USD)").group("inversion"),
				entero("empleosgenerados", "Empleos generados en EE.UU.").group("inversion"),
				// habilidades extraordinarias y residencia (O-1, EB-1A, EB-2 NIW)
				lista("areahabilidad", "Area de habilidad", "Ciencias,Educacion,Negocios,Atletismo,Artes,Cine y television").group("habilidad"),
				area("logros", "Resumen de logros y reconocimientos", 2000).group("habilidad"),
				area("proyecto", "Proyecto o labor propuesta (interes nacional)", 2000).group("habilidad"),
				lista("autopeticion", "Autopeticion (sin patrocinador)", SI_NO).group("habilidad").value("No"),
				// cierre
				area("observaciones", "Observaciones", 1000).group("cierre"),
				check("declaracion", "Declaro que la informacion proporcionada es veraz").required().group("cierre"),
				uuid()),
			metodosComunes(MODULO, "solicitud", VERSION, "enviar|Enviar solicitud", "cambiarstatus|Cambiar estatus"));
	}
}
