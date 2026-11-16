package com.mio.formas.generador;

import java.io.IOException;
import org.junit.Test;

/**
 * directorio/rol (the base library only; the dentista library no longer has its own, directorio/rol): a role is a named list of authorizations (the same grammar as the permisos of a person: module[:resource[:action]], "-" denies, a denial always wins) that the owner
 * edits in a form and assigns to people (column roles of dircto, role names separated by commas). The ambito says which client application the role is for ("ui::contacto") or
 * every one ("*"). A role with a rolbase (staff, admin, solicitante) applies AUTOMATICALLY to every person whose base role in that application is that one; without it, the role is
 * assigned by hand. A role is switched off, never deleted.
 */
public class Directorio_rol extends DirectorioGenerador {

	@Test
	public void testNuevo() throws IOException {
		generarDirectorio("rol", "Rol", "ROL", "Rol de autorizaciones",
			campos(
				texto("codigo", "Codigo", 255).readOnly().hidden(),
				uuid(),
				texto("nombre", "Nombre", 60).required().basket().search().validation("^[A-Za-z0-9_.-]{1,60}$"),
				texto("ambito", "Aplicacion (ui::contacto o *)", 40).required().basket().search().value("*"),
				texto("rolbase", "Rol base al que aplica solo (staff, admin, solicitante o vacio)", 12).basket().search().validation("^(staff|admin|solicitante)?$"),
				texto("modulo", "Modulo (informativo)", 40).basket().search(),
				texto("descripcion", "Descripcion", 200),
				area("permisos", "Autorizaciones", 2000).required(),
				check("activo", "Activo").basket().value("true"),
				fechaHora("falta", "Fecha de alta").readOnly().value("${default::fechayHoraCorto}")),
			metodosComunes(MODULO_DIRECTORIO, "rol", VERSION));
	}
}
