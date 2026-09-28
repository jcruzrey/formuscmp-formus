/**
 * 
 */
package com.mio.repo.impl;

import java.nio.file.Path;
import java.util.Properties;

import org.junit.Test;

import com.formuscmp.formus.repository.IRepository;
import com.formuscmp.formus.repository.impl.ComponentRepository;

/**
 * @author mac
 *
 */
public class RespoServicioArchivoTest {

	/**
	 * Test method for {@link com.formuscmp.formus.repository.impl.ComponentRepository#dameRutaJson(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDameRutaJson() {
		Properties properties = new Properties();
		properties.put("redis.ip", "192.168.1.203");
		properties.put("redis.port", 6379);
		IRepository repoServicio = new ComponentRepository(properties);
		
		
		Path rutaGroovyEmpresa = repoServicio.dameRutaJson("./config", "23rernmnm45n5w34dert", "comprobante", "3.3", "ingreso", "form", "en_US");
		if (!rutaGroovyEmpresa.toFile().exists()) {
			System.out.println("No existe:" + rutaGroovyEmpresa);
		}else {
			System.out.println("Si existe:" + rutaGroovyEmpresa);
		}
		
		Path rutaGroovy = repoServicio.dameRutaJson("./config", "base", "comprobante", "3.3", "ingreso", "form", "en_US");
		if (!rutaGroovy.toFile().exists()) {
			System.out.println("No existe:" + rutaGroovy);
		}else {
			System.out.println("Si existe:" + rutaGroovy);
		}
		
		Path rutaVista = repoServicio.dameRutaVista("./config/vistas", "comprobantes", "3.3", "comprobante", "basket", "Comprobantes", "en_US");
		if (!rutaVista.toFile().exists()) {
			System.out.println("No existe:" + rutaVista);
		}else {
			System.out.println("Si existe:" + rutaVista);
		}
		
	}

	/**
	 * Test method for {@link com.formuscmp.formus.repository.impl.ComponentRepository#dameRutaCampo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDameRutaCampoBxml() {
		Properties properties = new Properties();
		properties.put("redis.ip", "192.168.1.203");
		properties.put("redis.port", 6379);
		IRepository repoServicio = new ComponentRepository(properties);
		Path rutaGroovy = repoServicio.dameRutaRecurso("./config", "base", "comprobante", "3.3", "ingreso", "1", "texto" , "bxml", "form", "campo", "en_US");
		if (!rutaGroovy.toFile().exists()) {
			System.out.println("No existe:" + rutaGroovy);
		}else {
			System.out.println("Si existe:" + rutaGroovy);
		}
	}

	/**
	 * Test method for {@link com.formuscmp.formus.repository.impl.ComponentRepository#dameRutaCampo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDameRutaCampoHtml() {
		Properties properties = new Properties();
		properties.put("redis.ip", "192.168.1.203");
		properties.put("redis.port", 6379);
		IRepository repoServicio = new ComponentRepository(properties);
		Path rutaGroovy = repoServicio.dameRutaRecurso("./config", "base", "comprobante", "3.3", "ingreso", "1", "texto" , "html", "form", "campo", "en_US");
		if (!rutaGroovy.toFile().exists()) {
			System.out.println("No existe:" + rutaGroovy);
		}else {
			System.out.println("Si existe:" + rutaGroovy);
		}
	}
	
	/**
	 * Test method for {@link com.formuscmp.formus.repository.impl.ComponentRepository#dameRutaCampo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDameRutaCampoAndroid() {
		Properties properties = new Properties();
		properties.put("redis.ip", "192.168.1.203");
		properties.put("redis.port", 6379);
		IRepository repoServicio = new ComponentRepository(properties);
		Path rutaGroovy = repoServicio.dameRutaRecurso("./config", "base", "comprobante", "3.3", "ingreso", "1", "texto" , "android", "form", "campo", "en_US");
		if (!rutaGroovy.toFile().exists()) {
			System.out.println("No existe:" + rutaGroovy);
		}else {
			System.out.println("Si existe:" + rutaGroovy);
		}
	}
	
	/**
	 * Test method for {@link com.formuscmp.formus.repository.impl.ComponentRepository#dameRutaFormaAccion(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDameRutaFormaAccion() {
		Properties properties = new Properties();
		properties.put("redis.ip", "192.168.1.203");
		properties.put("redis.port", 6379);
		IRepository repoServicio = new ComponentRepository(properties);
		Path rutaGroovy = repoServicio.dameRutaFormaScript("./config", "base", "comprobante", "3.3", "ingreso", "nuevo", "form", "en_US");
		if (!rutaGroovy.toFile().exists()) {
			System.out.println("No existe:" + rutaGroovy);
		}else {
			System.out.println("Si existe:" + rutaGroovy);
		}
	}
	
	/**
	 * Test method for {@link com.formuscmp.formus.repository.impl.ComponentRepository#dameRutaFormaAccion(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDameRutaColumnaBxml() {
		IRepository repoServicio = new ComponentRepository(new Properties());
		Path rutaColumna = repoServicio.dameRutaRecurso("./config", "base", "comprobante", "3.3", "comprobante", "1", "texto" , "bxml", "basket", "campo", "en_US");
		if (!rutaColumna.toFile().exists()) {
			System.out.println("No existe:" + rutaColumna);
		}else {
			System.out.println("Si existe:" + rutaColumna);
		}
	}

}
