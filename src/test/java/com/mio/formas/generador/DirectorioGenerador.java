package com.mio.formas.generador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.formuscmp.formus.button.Button;
import com.formuscmp.formus.field.Field;
import com.formuscmp.formus.generator.Generador;
import com.formuscmp.formus.generator.IGenerador;
import com.formuscmp.formus.resource.Resource;

/**
 * Generators of module "directorio" (CRM de ventas y servicio dentro de formuscmp-web-contacto). Same field helpers as {@link CaseGenerador};
 * only the module, the table prefix and the output names change. Output (relative to formuscmp-formus):
 *   config/directorio_{name}.json          the form resource
 *   config/canasta_directorio_{name}.json  the basket resource (showInBasket fields only)
 * Deploy with tools/deploy_roles_models.py; DDL with tools/generate_roles_ddl.py.
 */
public abstract class DirectorioGenerador extends CaseGenerador {

	public static final String MODULO_DIRECTORIO = "directorio";

	protected void generarDirectorio(String nombre, String titulo, String prefijo, String comentario,
			List<Field> campos, List<Button> metodos) throws IOException {
		Path dir = Paths.get("./config").toAbsolutePath().normalize();
		Files.createDirectories(dir);
		IGenerador<Resource> generador = new Generador<Resource>(new String[] { RUTA_PLANTILLAS });

		Resource forma = recursoDirectorio(nombre, titulo, prefijo, comentario);
		forma.setInstruction("Por favor complete la informacion de " + titulo.toLowerCase());
		forma.setModel(campos);
		forma.setMethods(metodos);
		generador.put(dir.resolve(MODULO_DIRECTORIO + "_" + nombre + ".json").normalize(), forma);

		// A basket lists with the values of its fields as equality filters ("Todos" = no filter): a default of the form (estado=borrador, falta=now, a
		// generated uuid...) would hide every row. The basket gets its own copies, with no value.
		List<Field> enCanasta = new ArrayList<Field>();
		com.fasterxml.jackson.databind.ObjectMapper copia = new com.fasterxml.jackson.databind.ObjectMapper();
		for (Field c : campos) {
			if (c.isShowInBasket()) {
				Field sinValor = copia.readValue(copia.writeValueAsString(c), Field.class);
				sinValor.setValue("");
				enCanasta.add(sinValor);
			}
		}
		Resource canasta = recursoDirectorio(nombre, titulo, prefijo, comentario);
		canasta.setCommandName("buscar");
		canasta.setModel(enCanasta);
		canasta.setMethods(new ArrayList<Button>());
		generador.put(dir.resolve("canasta_" + MODULO_DIRECTORIO + "_" + nombre + ".json").normalize(), canasta);
	}

	private Resource recursoDirectorio(String nombre, String titulo, String prefijo, String comentario) {
		Resource r = new Resource();
		r.setPrefix(prefijo);
		r.setCommandName("guardar");
		r.setName(nombre);
		r.setView(nombre);
		r.setTitle(titulo);
		r.setVersion(VERSION);
		r.setStatus("produccion");
		r.setModule(MODULO_DIRECTORIO);
		r.setBasket("basket");
		r.setCreateable(true);
		r.setTable("dircto_" + nombre);   // the directory tables share the dircto prefix
		r.setValidate(true);
		r.setComment(comentario);
		r.setOrigin("ui::case");
		r.setDestination("db::mysql");
		r.setUuid(generarToken());
		r.setPersistible(persistible);
		r.setLastModificationDate(new java.util.Date().getTime());
		return r;
	}
}
