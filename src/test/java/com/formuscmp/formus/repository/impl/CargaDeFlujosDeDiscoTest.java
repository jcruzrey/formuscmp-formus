package com.formuscmp.formus.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formuscmp.formus.dto.MenuDto;

/**
 * A workflow read from the disk (when Redis has no list of the library) is a plain JSON document: the typed UseCase does not know every field a workflow carries
 * ({@code tests}, an {@code upload} or {@code pick} of a step, ...), so loading it used to fail or to store it again without them.
 */
class CargaDeFlujosDeDiscoTest {

	@TempDir
	Path dir;

	private final Map<String, String> redis = new HashMap<>();

	private ComponentRepository repo() {
		Properties p = new Properties();
		p.setProperty("redis.active", "false");
		return new ComponentRepository(p) {
			@Override
			public void jedisSet(String llave, String valor) {
				redis.put(llave, valor);
			}
		};
	}

	private void flujo(String nombre, String uuid, String extra) throws Exception {
		Path carpeta = dir.resolve("base").resolve("usecase").resolve("inventario").resolve(nombre).resolve("1.0");
		Files.createDirectories(carpeta);
		String json = "{\"name\":\"" + nombre + "\",\"title\":\"Flujo " + nombre + "\",\"version\":\"1.0\",\"module\":\"inventario\",\"uuid\":\"" + uuid + "\",\"createable\":true,"
				+ "\"steps\":[{\"name\":\"cargar\",\"upload\":{\"as\":\"archivo\",\"module\":\"directorio\",\"name\":\"usuario\"},\"pick\":{\"source\":\"x\"}}]" + extra + "}";
		Files.writeString(carpeta.resolve(nombre + "_es_MX.json"), json, StandardCharsets.UTF_8);
	}

	@Test
	void unFlujoConCamposQueLaClaseNoConoceSeCargaYSeGuardaCompleto() throws Exception {
		flujo("con-pruebas", "uc-1", ",\"tests\":[{\"name\":\"caso 1\"}]");
		List<MenuDto> lista = repo().config(dir.resolve("base").resolve("usecase").toString() + "/", "1.0", new ArrayList<>(), true, "es_MX", "usecase");
		assertEquals(1, lista.size());
		assertEquals("uc-1", lista.get(0).getUuid());
		assertEquals("Flujo con-pruebas", lista.get(0).getTitle());
		assertEquals("inventario", lista.get(0).getModule());
		assertTrue(lista.get(0).isCreateable());
		String guardado = redis.get("uc-1");
		assertNotNull(guardado, "the workflow goes to Redis under its uuid");
		Map<?, ?> doc = new ObjectMapper().readValue(guardado, Map.class);
		assertNotNull(doc.get("tests"), "the tests of the workflow are kept");
		Map<?, ?> paso = (Map<?, ?>) ((List<?>) doc.get("steps")).get(0);
		assertNotNull(paso.get("upload"), "the upload of the step is kept");
		assertNotNull(paso.get("pick"), "the pick of the step is kept");
	}

	@Test
	void unArchivoSinUuidSeOmiteEnLugarDeRomperLaCarga() throws Exception {
		flujo("sin-uuid", "", "");
		flujo("con-uuid", "uc-2", "");
		List<MenuDto> lista = repo().config(dir.resolve("base").resolve("usecase").toString() + "/", "1.0", new ArrayList<>(), true, "es_MX", "usecase");
		assertEquals(1, lista.size());
		assertEquals("uc-2", lista.get(0).getUuid());
	}
}
