/**
 * 
 */
package com.formuscmp.formus.repository.impl;

import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formuscmp.formus.dto.MenuDto;
import com.formuscmp.formus.generator.Generador;
import com.formuscmp.formus.generator.IGenerador;
import com.formuscmp.formus.repository.IRepository;
import com.formuscmp.formus.resource.Resource;
import com.formuscmp.formus.resource.UseCase;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author mac
 *
 */
public class ComponentRepository implements IRepository, Closeable{

	private static final Logger LOGGER = Logger.getLogger(ComponentRepository.class.getName());
	private final Properties properties;
	private static JedisPool jedisPool;

	//@Inject
	public ComponentRepository(Properties properties) {
		super();
		this.properties = properties;
		//if (null!=configuration) {


		//galileas.com
		//jedisPool = new JedisPool(config, "127.0.0.1", 38375, null , "NJK3u3ojcHhIoMWeq5p");

		//formus.ws
		//jedisPool = new JedisPool(config, "127.0.0.1", 57083, null , "QRcaYF8Ldc484yW2k4J");

		//String pStr = "127.0.0.1";
		//formuscmp.com
		//jedisPool = new JedisPool(config, "127.0.0.1", 35757, null , "2ZwCm48uNMBnej1Lgbw");

		//System.out.println("Connecting to redis:" + redis_ip);

		if (this.properties.getProperty("redis.active").toString().equals("true")) {
			if (LOGGER.isLoggable(Level.INFO)) LOGGER.info("Conectando a REDIS:" + this.properties.getProperty("redis.ip"));
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(1000);
			config.setMaxIdle(20);

			/*final String redis_ip = Optional.ofNullable(configuration.getProperty("redis.ip")).orElse("").toString();
				final String redis_port = Optional.ofNullable(configuration.getProperty("redis.port")).orElse("0").toString();*/
			final String redis_user = Optional.ofNullable(properties.getProperty("redis.user")).orElse("").toString();
			final String redis_password = Optional.ofNullable(properties.getProperty("redis.password")).orElse("").toString();

			String ipStr = properties.getProperty("redis.ip");// "192.168.1.203";
			int ipPort = Integer.parseInt(properties.getProperty("redis.port"));
			//local
			//jedisPool = new JedisPool(config, ipStr, ipPort, properties.getProperty("redis.user").toString(), properties.getProperty("redis.password").toString());

			if (redis_user.isEmpty()) {
				if (LOGGER.isLoggable(Level.INFO)) LOGGER.info("Conectando a REDIS sin usuario, sin clave");
				jedisPool = new JedisPool(config, ipStr, ipPort, null, null);
			}else {
				if (LOGGER.isLoggable(Level.INFO)) LOGGER.info("Conectando a REDIS con clave y usuario " + redis_user);
				jedisPool = new JedisPool(config, ipStr, ipPort, redis_user, redis_password);
			}



			/*JedisClientConfig config = DefaultJedisClientConfig.builder()
	                .user("default")
	                .password("qBf6IjX2rzYHGBTGor3YMCLg2VvHF2ut")
	                .build();

	        UnifiedJedis jedis = new UnifiedJedis(
	            new HostAndPort("redis-18926.c261.us-east-1-4.ec2.cloud.redislabs.com", 18926),
	            config
	        );*/


		}
		//jedisPool = new JedisPool(config, redis_ip, Integer.parseInt(redis_port), redis_user.equals("") ? null : redis_user, redis_password.equals("") ? null : redis_password);
		/*}else {
			if (LOGGER.isLoggable(Level.INFO)) LOGGER.info("Omitiendo conexion a REDIS");
		}*/
	}

	public Path dameRutaJson(String raiz, String empresa, String modulo, String version, String forma, String tipo, final String localeStr) {
		String ruta = "";
		if (localeStr==null || localeStr.isBlank()) {
			ruta = raiz
					+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + forma +  "/" + version + "/";
		}else {
			ruta = raiz
					+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + forma +  "/" + version + "/" + forma + "_" + localeStr + IRepository.EXTENSION_JSON;
		}
		return Paths.get(ruta)
				.toAbsolutePath().normalize();
	}

	public Path dameRutaRecurso(String raiz, String empresa, String modulo, String versionForma, String forma,
			String versionCampo, String campo, String formato, String tipo, String tipoRecurso, final String localeStr) {

		String ruta = "";

		if ((versionForma==null || versionForma.isBlank()) && (modulo==null || modulo.isBlank()) && (forma==null || forma.isBlank()) 
				&& (campo==null || campo.isBlank()) && (tipo==null || tipo.isBlank())) {
			//base/forma/campo/html/
			ruta = raiz
					//+ "/" + empresa + "/" + tipo + "/" + tipoRecurso + "/" + formato + "/";
					+ "/" + empresa + "/" + tipoRecurso + "/" + formato + "/";
		}else if ((versionForma==null || versionForma.isBlank()) && (modulo==null || modulo.isBlank()) && (forma==null || forma.isBlank()) 
				&& (campo==null || campo.isBlank())) {
			//base/forma/campo/html/
			ruta = raiz
					+ "/" + empresa + "/" + tipo + "/" + tipoRecurso + "/" + formato + "/";
			//+ "/" + empresa + "/" + tipoRecurso + "/" + formato + "/";
		}else if ((versionForma==null || versionForma.isBlank()) && (modulo==null || modulo.isBlank()) && (forma==null || forma.isBlank())) {
			//base/campo/html/texto_es_MX.ftl
			ruta = raiz
					//+ "/" + empresa + "/" + tipo + "/" + tipoRecurso + "/" + formato + "/" + campo + "_" + localeStr + IRepoServicio.EXTENSION_PLANTILLA;
					+ "/" + empresa + "/" + tipoRecurso + "/" + formato + "/" + campo + "_" + localeStr + IRepository.EXTENSION_PLANTILLA;
		}else if ((versionForma==null || versionForma.isBlank()) && (forma==null || forma.isBlank()) && (campo==null || campo.isBlank())) {
			//base/forma/directorio/campo/html/
			ruta = raiz
					+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + tipoRecurso + "/" + formato + "/";
		}else if ((versionForma==null || versionForma.isBlank()) && (forma==null || forma.isBlank())) {
			//base/forma/directorio/campo/html/texto_es_MX.ftl
			ruta = raiz
					+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + tipoRecurso + "/" + formato + "/" + campo + "_" + localeStr + IRepository.EXTENSION_PLANTILLA;
		}else if ((versionForma==null || versionForma.isBlank()) && (campo==null || campo.isBlank())) {
			//base/forma/directorio/cliente/campo/html/
			ruta = raiz
					+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + forma + "/" + tipoRecurso + "/" + formato + "/";
		}else if (versionForma==null || versionForma.isBlank()) {
			//base/forma/directorio/cliente/campo/html/texto_es_MX.ftl
			ruta = raiz
					+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + forma + "/" + tipoRecurso + "/" + formato + "/" + campo + "_" + localeStr + IRepository.EXTENSION_PLANTILLA;
		}else if (campo==null || campo.isBlank()){
			//base/forma/directorio/cliente/1.0/campo/html/texto_es_MX.ftl
			ruta = raiz
					+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + forma +  "/" + versionForma + "/" + tipoRecurso + "/" + formato + "/";
		}else {
			//base/forma/directorio/cliente/1.0/campo/html/texto_es_MX.ftl
			ruta = raiz
					+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + forma +  "/" + versionForma + "/" + tipoRecurso + "/" + formato + "/" + campo + "_" + localeStr + IRepository.EXTENSION_PLANTILLA;
		}
		return Paths.get(ruta)
				.toAbsolutePath().normalize();
	}

	public Path dameRutaFormaScript(String raiz, String empresa, String modulo, String version, String forma,
			String accion, String tipo, final String localeStr) {
		String ruta = "";
		if (version==null && modulo==null && forma==null) {
			//EMP-0000000002/forma/detail_en_US.groovy
			ruta = raiz
					+ "/" + empresa + "/" + tipo + "/" + accion + "_" + localeStr + IRepository.EXTENSION_SCRIPT;	
		}else if (version==null && forma==null) {
			//EMP-0000000002/forma/solicitud/detail_en_US.groovy
			ruta = raiz
					+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + accion + "_" + localeStr + IRepository.EXTENSION_SCRIPT;	
		}else if (version==null) {
			//EMP-0000000002/forma/solicitud/registrarse/detail_en_US.groovy
			ruta = raiz
					+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + forma + "/" + accion + "_" + localeStr + IRepository.EXTENSION_SCRIPT;	
		}else {
			//EMP-0000000002/forma/solicitud/registrarse/1.0/detail_en_US.groovy
			ruta = raiz
					+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + forma +  "/" + version + "/" + accion + "_" + localeStr + IRepository.EXTENSION_SCRIPT;
		}
		return Paths.get(ruta)
				.toAbsolutePath().normalize();
	}

	public Path dameRutaResourceBundle(final String raiz, final String empresa, final String modulo, final String versionForma, final String forma,
			final String tipo) {
		String ruta = "";

		if ((versionForma==null || versionForma.isBlank()) && (modulo==null || modulo.isBlank()) && (forma==null || forma.isBlank())) {
			//ruta/base/forma o ruta/base/canasta
			ruta = raiz
					+ "/" + empresa + "/" + tipo ;
		}else if ((forma==null || forma.isBlank()) && (versionForma==null || versionForma.isBlank())) {
			//ruta/base/forma/directorio/
			ruta = raiz	+ "/" + empresa + "/" + tipo + "/" + modulo;
		}else if ((forma!=null && !forma.isBlank()) && (versionForma==null || versionForma.isBlank())) {
			//ruta/base/forma/directorio/usuario
			ruta = raiz	+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + forma;
		}else {
			//ruta/base/forma/directorio/usuario/1.0
			ruta = raiz
					+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + forma +  "/" + versionForma;

		}
		return Paths.get(ruta)
				.toAbsolutePath().normalize();
	}

	public Path dameRutaFormaScript(String raiz, String tabla, String tipo, final String localeStr) {
		if (localeStr != null) {
			String ruta = raiz
					+ "/" + tipo  + "/" + tabla + "_" + localeStr + IRepository.EXTENSION_SCRIPT;
			return Paths.get(ruta)
					.toAbsolutePath().normalize();
		}else {
			String ruta = raiz
					+ "/" + tipo  + "/" + tabla + IRepository.EXTENSION_SCRIPT;
			return Paths.get(ruta)
					.toAbsolutePath().normalize();
		}
	}

	public Path dameRutaFormaScriptDato(String raiz, String empresa, String modulo, String version, String forma,
			String accion, String tipo, final String localeStr) {
		String ruta = raiz
				+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + forma +  "/" + version + "/" + accion + "_" + localeStr + IRepository.EXTENSION_SCRIPT;
		return Paths.get(ruta)
				.toAbsolutePath().normalize();
	}

	@Override
	public String generateToken() {
		Supplier<String> tokenSupplier = () -> {

			StringBuilder token = new StringBuilder();
			long currentTimeInMilisecond = Instant.now().toEpochMilli();
			return token.append(currentTimeInMilisecond).append("-")
					.append(UUID.randomUUID().toString()).toString();
		};

		return tokenSupplier.get();
	}



	public List<MenuDto> config(final String rutaEmpresaConfig, final String version, List<MenuDto> listaAgregar, 
			final boolean creable, final String localeStr, final String resourceType) throws JsonParseException, JsonMappingException, IOException{
		String ruta = "";
		ObjectMapper objectMapper =  new ObjectMapper();
		List<MenuDto> lista = listaAgregar;
		IGenerador<Resource> generador = new Generador<Resource>(new String[] {rutaEmpresaConfig});
		IGenerador<UseCase> generadorUseCase = new Generador<UseCase>(new String[] {rutaEmpresaConfig});
		createIfNotPresent(rutaEmpresaConfig);
		File folder = new File(rutaEmpresaConfig);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			//System.out.println(listOfFiles[i].getName());
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().contains(localeStr + ".json")) {
				//System.out.println("Procesando:" + listOfFiles[i].getName());
				Path fileConfigLocation = Paths.get(rutaEmpresaConfig)
						.toAbsolutePath().normalize();
				Path filePath = fileConfigLocation.resolve(listOfFiles[i].getName()).normalize();
				String pattern = Pattern.quote(System.getProperty("file.separator"));
				String[] splittedFileName = filePath.toString().split(pattern);
				if (splittedFileName.length < 7) {
					if (LOGGER.isLoggable(Level.INFO)) LOGGER.info("No esta correctamente configurado:"+filePath.toString());
				}else {
					//String llaveCacheForma = IRepoServicio.FORMA_PREFIX + splittedFileName[splittedFileName.length - 6] + "." + splittedFileName[splittedFileName.length - 5] + "." + splittedFileName[splittedFileName.length - 4] + "." + splittedFileName[splittedFileName.length - 3] + "." + splittedFileName[splittedFileName.length - 2] + "-" + localeStr;
					if (resourceType.equals("usecase")) {
						UseCase useCase = generadorUseCase.get(filePath, UseCase.class);
						String llaveCacheForma = useCase.getUuid();
						MenuDto menu = new MenuDto(splittedFileName[splittedFileName.length - 6], useCase.getTitle(), null, useCase.getVersion(), useCase.getUuid(),
								useCase.getModule(), resourceType, useCase.getName(), useCase.isCreateable());
						jedisSet(llaveCacheForma, objectMapper.writeValueAsString(useCase));
						lista.add(menu);
					}else {
						Resource forma = generador.get(filePath, Resource.class);
						if ((null!=forma) && (null!=forma.getUuid())) {
							/*forma.setUuid(generateToken());
							//if (forma.getDecorators()==null || forma.getDecorators().size()==0) {
								forma.getModel().stream().forEach(f -> f.setUuid(generateToken()));
								forma.getMethods().stream().forEach(b -> b.setUuid(generateToken()));
								//forma.setLastModificationDate(0L);
							//}
							generador.put(filePath, forma);*/
							String llaveCacheForma = forma.getUuid();
							MenuDto menu = new MenuDto(splittedFileName[splittedFileName.length - 6], forma.getTitle(), null, forma.getVersion(), forma.getUuid(),
									forma.getModule(), resourceType, forma.getName(), forma.isCreateable());
							
							String rutaJson = "";
							if (filePath!=null) {
								
								int idx = filePath.toString().indexOf("config");
								if (idx > -1) {
									rutaJson = filePath.toString().substring(idx);
								}
							}
							
							forma.setResourcePath(rutaJson);
							
							jedisSet(llaveCacheForma, objectMapper.writeValueAsString(forma));
							lista.add(menu);
							//System.out.println(forma.getUuid());
						}
						/*if (forma.getName().equals("usuario")) {
							System.out.println(forma.getUuid());
							System.out.println("usuario");
						}*/
					}
				}
			} else if (listOfFiles[i].isDirectory()) {
				ruta = rutaEmpresaConfig + listOfFiles[i].getName() + "/";
				this.config(ruta, version, listaAgregar, creable, localeStr, resourceType);
			}
		}
		return lista;
	}

	public void flushCache(final String rutaEmpresaConfig, final String assetLibrary, final String resourceType,
			final String localeStr) throws JsonParseException, JsonMappingException, IOException{

		ObjectMapper objectMapper =  new ObjectMapper();
		IGenerador<Resource> generador = new Generador<Resource>(new String[] {rutaEmpresaConfig});
		final String key = "formus.resource." + assetLibrary + ".list." + resourceType + "." + localeStr;


		String menuCompany = jedisGet(key);
		if (null!=menuCompany) {
			List<MenuDto> formas = objectMapper.readValue(menuCompany, objectMapper.getTypeFactory().constructCollectionType(List.class, MenuDto.class));
			for (MenuDto menu : formas) {
				if (menu.getUuid()!=null) {
					String resourceStr = jedisGet(menu.getUuid());
					if (resourceStr!=null) {
						Resource resource = objectMapper.readValue(resourceStr, Resource.class);
						if (resource!=null && resource.isDirty()) {
							resource.getModel().stream().forEach(f -> f.setSourceCode(null));
							resource.getMethods().stream().forEach(b -> b.setSourceCode(null));
							resource.getModel().stream().forEach(f -> f.setTemplate(null));
							resource.getMethods().stream().forEach(b -> b.setTemplate(null));
							java.nio.file.Path rutaFormaEmpresa = dameRutaJson(rutaEmpresaConfig, menu.getAssetLibrary(), menu.getModule(), menu.getVersion(), menu.getResourceName(), menu.getResourceType(), localeStr);
							System.out.println("Flush:" + rutaFormaEmpresa.toString());
							Files.createDirectories(Paths.get(rutaFormaEmpresa.toFile().getParentFile().getAbsolutePath()));
							//createIfNotPresent(rutaFormaEmpresa.toString());
							resource.setDirty(false);
							generador.put(rutaFormaEmpresa, resource);
							jedisSet(menu.getUuid(), objectMapper.writeValueAsString(resource));
						}
					}
				}
			}
		}
	}

	private void createIfNotPresent(final String strPath) {
		if (!Files.exists(Paths.get(strPath)
				.toAbsolutePath().normalize())) {
			java.nio.file.Path path = Paths.get(strPath);
			try {
				if (LOGGER.isLoggable(Level.INFO)) LOGGER.info("Creating company asset Library :" + strPath);
				Files.createDirectories(path);
			} catch (IOException e) {
				if (LOGGER.isLoggable(Level.SEVERE)) LOGGER.severe("Error creating asset library :" + strPath);
				e.printStackTrace();
			}
		}
	}

	public Path dameRutaVista(String raiz, String modulo, String version, String forma, String tipo, String vista, final String localeStr) {
		String ruta = raiz
				+ "/" + tipo + "/" + modulo + "/" + forma +  "/" + version + "/" + vista + IRepository.EXTENSION_BXML;
		return Paths.get(ruta)
				.toAbsolutePath().normalize();
	}

	public void jedisFlushAll() {

		if (!this.properties.getProperty("redis.active").toString().equals("true")) {
			if (LOGGER.isLoggable(Level.INFO)) LOGGER.info("REDIS active :" + this.properties.getProperty("redis.active").toString());
		}else {

			Jedis jedis = null;

			try {
				jedis = jedisPool.getResource();
				jedis.flushAll();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				jedisPool.returnResource(jedis);
			}
		}
	}

	public String jedisGet(String llave) {

		if (!this.properties.getProperty("redis.active").toString().equals("true")) {
			if (LOGGER.isLoggable(Level.INFO)) LOGGER.info("REDIS active :" + this.properties.getProperty("redis.active").toString());
			return null;
		}

		Jedis jedis = null;
		String cacheForma = null;

		try {
			jedis = jedisPool.getResource();
			cacheForma = jedis.get(llave);
		} catch (Exception e) {
			e.printStackTrace();
			return cacheForma;
		} finally {
			jedisPool.returnResource(jedis);
		}
		return cacheForma;
	}

	public void jedisSet(String llave, String jsonValue) {

		if (!this.properties.getProperty("redis.active").toString().equals("true")) {
			if (LOGGER.isLoggable(Level.INFO)) LOGGER.info("REDIS active :" + this.properties.getProperty("redis.active").toString());
		}else {
			Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();
				jedis.set(llave,jsonValue);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				jedisPool.returnResource(jedis);
			}
		}
	}

	public void jedisDel(String llave) {
		if (!this.properties.getProperty("redis.active").toString().equals("true")) {
			if (LOGGER.isLoggable(Level.INFO)) LOGGER.info("REDIS active :" + this.properties.getProperty("redis.active").toString());
		}else {
			Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();
				jedis.del(llave);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				jedisPool.returnResource(jedis);
			}
		}
	}

	public Path dameRutaResourceBundle(String raiz, String empresa, String modulo, String version, String forma,
			String tipo, String tipofragmento, final String localeStr) {
		String ruta = raiz
				+ "/" + empresa + "/" + tipo + "/" + modulo + "/" + forma +  "/" + version +  "/" + tipofragmento ;
		return Paths.get(ruta)
				.toAbsolutePath().normalize();
	}

	public String[] dameNombreArchivos(Path ruta, String extensionArchivo) {
		if (null==ruta || null==extensionArchivo)
			return new String[] {"Empty path or extension"};

		if (!Files.exists(ruta))
			return new String[] {};

		return Stream.of(new File(ruta.toString()).listFiles())
				.filter(f -> !f.isDirectory() && f.getName().endsWith(extensionArchivo))
				.map(p -> p.getName().replace(extensionArchivo, ""))
				.toArray(String[]::new);
	}

	public String[] dameNombreCarpetas(Path ruta) throws IOException {

		if (!Files.exists(ruta))
			return new String[] {};

		if (!Files.isDirectory(ruta)) {
			throw new IllegalArgumentException("El parametro de ruta debe ser un directorio!");
		}

		String[] directories = ruta.toFile().list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});

		return directories;
	}

	@Override
	public void close() throws IOException {
		if (LOGGER.isLoggable(Level.INFO)) LOGGER.info("Cerrando conexion REDIS:");
		if (!this.properties.getProperty("redis.active").toString().equals("true")) {
			if (LOGGER.isLoggable(Level.INFO)) LOGGER.info("REDIS active :" + this.properties.getProperty("redis.active").toString());
		}else {
			jedisPool.close();
			jedisPool = null;
		}
	}

}
