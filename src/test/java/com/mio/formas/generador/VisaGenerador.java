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
import com.formuscmp.formus.resource.GenerateCode;
import com.formuscmp.formus.resource.Resource;

/**
 * Shared helper for the generators of module "visa" (Visas Direct). Each Visa_xxx test
 * defines one domain model and calls {@link #generar}; this keeps the per-model classes
 * small while producing exactly the same Resource JSON shape as the Dental_xxx generators.
 *
 * Output (relative to the working directory, i.e. formuscmp-formus):
 *   config/visa_{name}.json          the form resource   (resourceType form)
 *   config/canasta_visa_{name}.json  the basket resource (resourceType basket, showInBasket fields only)
 */
public abstract class VisaGenerador extends GenerateCode {

	public static final String MODULO = "visa";
	public static final String VERSION = "1.0";
	public static final String IDIOMA = "es_MX";

	protected static final String RUTA_PLANTILLAS = "C:/Melo-Builder-V1.0/formus/formuscmp-formus-api/config";

	/** Visa type codes, from "JJ Medina Lawyers.pdf" (Visas Direct). Keep in sync with tipovisa seed data. */
	public static final String TIPOS_VISA = "TN,TD,E-1,E-2,L-1A,L-1B,L-2,O-1A,O-1B,EB-1A,EB-2 NIW";
	public static final String ESTATUS_SOLICITUD = "Borrador,Enviada,En revision,Documentos pendientes,Aprobada,Rechazada,Cancelada";
	public static final String SI_NO = "Si,No";

	private int orden = 0;

	/** Fluent field definition. */
	protected class F {
		final Field f = new Field();

		F(String name, String label, String componentType, String dbType, int length) {
			orden++;
			f.setName(name);
			f.setFieldName(name);
			f.setLabel(label);
			f.setComment(name);
			f.setCss("lista".equals(componentType) || "status".equals(componentType) ? "form-select" : "form-control");
			f.setOrder(orden);
			f.setComponentType(componentType);
			f.setReadOnly(false);
			f.setHidden(false);
			f.setRequired(false);
			f.setShowInBasket(false);
			f.setId(false);
			f.setSearcheable(false);
			f.setValidation(null);
			f.setFormat(null);
			f.setGroup("general");
			f.setLength(length);
			f.setDbFieldType(dbType);
			f.setDecimals(0);
			f.setPersistible(true);
			f.setUuid(generarToken());
			f.setAffects(null);
			f.setFilter(null);
			f.setEvents("*");
			f.setOrigin(null);
			f.setValue("");
		}

		F required() { f.setRequired(true); return this; }
		F readOnly() { f.setReadOnly(true); return this; }
		F hidden() { f.setHidden(true); return this; }
		F basket() { f.setShowInBasket(true); return this; }
		F search() { f.setSearcheable(true); return this; }
		F id() { f.setId(true); return this; }
		F group(String g) { f.setGroup(g); return this; }
		F value(String v) { f.setValue(v); return this; }
		F validation(String v) { f.setValidation(v); return this; }
		F format(String v) { f.setFormat(v); return this; }
		F decimals(int d) { f.setDecimals(d); return this; }
		F comment(String c) { f.setComment(c); return this; }
		F origin(String o) { f.setOrigin(o); return this; }
		/** Inline list values: "A,B,C". */
		F values(String csv) {
			f.setOrigin("{\"origin\":\"recurso\",\"resource\":\"inlinevalues\",\"fields\":[{\"name\":\"" + csv + "\"}]}");
			return this;
		}
		Field build() { return f; }
	}

	protected F texto(String name, String label, int length) {
		return new F(name, label, "texto", "varchar", length);
	}

	protected F entero(String name, String label) {
		return new F(name, label, "texto", "int", 5).validation("^\\d+$");
	}

	protected F decimal(String name, String label) {
		return new F(name, label, "texto", "decimal", 14).decimals(2).format("00.00").validation("^\\d+(\\.\\d{1,2})?$");
	}

	protected F area(String name, String label, int length) {
		return new F(name, label, "textoarea", "varchar", length);
	}

	protected F lista(String name, String label, String csv) {
		return new F(name, label, "lista", "varchar", 60).values(csv);
	}

	protected F fecha(String name, String label) {
		return new F(name, label, "fecha", "date", 20).format("yyyy-MM-dd");
	}

	protected F fechaHora(String name, String label) {
		return new F(name, label, "texto", "datetime", 20)
				.validation("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$");
	}

	protected F email(String name, String label) {
		return texto(name, label, 150).validation("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$");
	}

	protected F archivo(String name, String label) {
		return new F(name, label, "archivo", "varchar", 250);
	}

	protected F check(String name, String label) {
		return new F(name, label, "checkbox", "boolean", 0);
	}

	/** Standard hidden primary key. */
	protected F uuid() {
		return texto("uuid", "Uuid", 60).readOnly().hidden().id().search().basket().value("${default::uuid}");
	}

	/** Standard hidden link to the parent solicitud (platform convention: uuidp). */
	protected F uuidp() {
		return texto("uuidp", "Solicitud", 60).hidden().search().value("");
	}

	protected List<Field> campos(F... defs) {
		List<Field> campos = new ArrayList<Field>();
		for (F d : defs) {
			campos.add(d.build());
		}
		return campos;
	}

	protected List<Button> metodosComunes(String modulo, String recurso, String version, String... extras) {
		List<Button> metodos = new ArrayList<Button>();

		Button guardar = boton("guardar", "Guardar cambios", "guardarjs", "btn btn-primary", "nuevo1",
				"Registro guardado correctamente", 1, modulo, recurso, version);
		guardar.setTarget("#" + recurso + "Forma");
		metodos.add(guardar);

		Button actualizar = boton("actualizar", "Actualizar", "botonjs", "btn btn-danger", "nuevo,actualizar,detalle",
				"Registro actualizado correctamente", 2, modulo, recurso, version);
		actualizar.setTarget("#" + recurso + "Forma");
		metodos.add(actualizar);

		Button detalle = boton("detalle", "Detalle", "someter", "btn btn-primary", "guardar,actualizar,detalle",
				"Detalles", 3, modulo, recurso, version);
		metodos.add(detalle);

		int pos = 4;
		for (String extra : extras) {
			// extra = "command|Label"
			String[] p = extra.split("\\|");
			metodos.add(boton(p[0], p[1], "botonjs", "btn btn-primary", "nuevo,detalle",
					p[1], pos++, modulo, recurso, version));
		}
		return metodos;
	}

	private Button boton(String comando, String etiqueta, String componente, String css, String eventos,
			String instruccion, int orden, String modulo, String recurso, String version) {
		Button b = new Button();
		b.setCommandName(comando);
		b.setComment("Boton " + comando);
		b.setComponentType(componente);
		b.setCss(css);
		b.setEvents(eventos);
		b.setInstruction(instruccion);
		b.setLabel(etiqueta);
		b.setModule(modulo);
		b.setName(comando);
		b.setOrder(orden);
		b.setResourceName(recurso);
		b.setResourceType("form");
		b.setUuid(generarToken());
		b.setVersion(version);
		return b;
	}

	/** Builds the form Resource and its basket Resource and writes both JSON files. */
	protected void generar(String nombre, String titulo, String prefijo, String comentario,
			List<Field> campos, List<Button> metodos) throws IOException {

		Path dir = Paths.get("./config").toAbsolutePath().normalize();
		Files.createDirectories(dir);
		IGenerador<Resource> generador = new Generador<Resource>(new String[] { RUTA_PLANTILLAS });

		Resource forma = recurso(nombre, titulo, prefijo, comentario);
		forma.setInstruction("Por favor complete la informacion de " + titulo.toLowerCase());
		forma.setModel(campos);
		forma.setMethods(metodos);
		generador.put(dir.resolve(MODULO + "_" + nombre + ".json").normalize(), forma);

		List<Field> enCanasta = new ArrayList<Field>();
		for (Field c : campos) {
			if (c.isShowInBasket()) {
				enCanasta.add(c);
			}
		}
		Resource canasta = recurso(nombre, titulo, prefijo, comentario);
		canasta.setCommandName("buscar");
		canasta.setModel(enCanasta);
		canasta.setMethods(new ArrayList<Button>());
		generador.put(dir.resolve("canasta_" + MODULO + "_" + nombre + ".json").normalize(), canasta);
	}

	private Resource recurso(String nombre, String titulo, String prefijo, String comentario) {
		Resource r = new Resource();
		r.setPrefix(prefijo);
		r.setCommandName("guardar");
		r.setName(nombre);
		r.setView(nombre);
		r.setTitle(titulo);
		r.setVersion(VERSION);
		r.setStatus("produccion");
		r.setModule(MODULO);
		r.setBasket("basket");
		r.setCreateable(true);
		r.setTable(MODULO + "_" + nombre);
		r.setValidate(true);
		r.setComment(comentario);
		r.setOrigin("ui::case");
		r.setDestination("db::mysql");
		r.setUuid(generarToken());
		r.setPersistible(true);
		r.setLastModificationDate(new java.util.Date().getTime());
		return r;
	}
}
