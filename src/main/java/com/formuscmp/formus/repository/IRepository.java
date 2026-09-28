/**
 * 
 */
package com.formuscmp.formus.repository;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.formuscmp.formus.dto.MenuDto;

/**
 * @author Jose Luis Cruz Reyes - Formus CMP
 *
 */
public interface IRepository {
	
	public static final int MODULO_POS=4;
	public static final int TIPO_POS=5;
	public static final int RECURSO_POS=6;
	public static final int VERSION_POS=7;
	public static final int COMMAND_POS=8;
	
	public static final String EXTENSION_JSON = ".json";
	public final static String EXTENSION_PLANTILLA=".ftl";
	public final static String EXTENSION_SCRIPT=".groovy";
	public final static String EXTENSION_BXML=".bxml";

	
	public final static String CACHE_GRAL_PREFIX = "formus.";
	public final static String CACHE_FORM_PREFIX = CACHE_GRAL_PREFIX + "form:";
	public final static String CACHE_FORMS_PREFIX = CACHE_GRAL_PREFIX + "forms:";
	public final static String CACHE_USECASES_PREFIX = CACHE_GRAL_PREFIX + "cases:";
	public final static String CACHE_USECASE_PREFIX = CACHE_GRAL_PREFIX + "case:";
	public final static String CACHE_FIELDS_PREFIX = CACHE_GRAL_PREFIX + "fields:";
	public final static String CACHE_FIELD_PREFIX = CACHE_GRAL_PREFIX + "field:";
	public final static String CACHE_BUTTONS_PREFIX = CACHE_GRAL_PREFIX + "buttons:";
	public final static String CACHE_BUTTON_PREFIX = CACHE_GRAL_PREFIX + "button:";
	
	Path dameRutaJson(String raiz, String empresa, String modulo, String version, String forma,String tipo, final String localeStr);
	Path dameRutaRecurso(String raiz, String empresa, String modulo, String versionForma, String forma, String versionCampo, String campo, String formato,String tipo, String tipoRecurso, final String localeStr);
	Path dameRutaFormaScript(String raiz, String empresa, String modulo, String version, String forma, String accion,String tipo, final String localeStr);
	List<MenuDto> config(final String rutaEmpresaConfig, final String version, List<MenuDto> listaAgregar, final boolean creable, final String localeStr, final String resourceType) throws JsonParseException, JsonMappingException, IOException;
	Path dameRutaVista(String raiz, String modulo, String version, String forma, String tipo, String vista, final String localeStr);
	Path dameRutaFormaScript(String rutaRaizRepo, String origen, String objeto, final String localeStr);
	Path dameRutaResourceBundle(final String raiz, final String empresa, final String modulo, final String version, final String forma,
			final String tipo);
	void flushCache(final String rutaEmpresaConfig, final String assetLibrary, final String resourceType,
			final String localeStr) throws JsonParseException, JsonMappingException, IOException;
	public void jedisFlushAll();
	public String jedisGet(String llave);
	public void jedisSet(String llave, String jsonValue);
	public void jedisDel(String llave);
	/**
	 * 
	 * @param raiz
	 * @param empresa
	 * @param modulo
	 * @param version
	 * @param forma
	 * @param tipo
	 * @param tipofragmento
	 * @return
	 */
	Path dameRutaResourceBundle(String raiz, String empresa, String modulo, String version, String forma,
			String tipo, String tipofragmento, final String localeStr);
	

	/**
	 * 
	 * @param ruta
	 * @param extensionArchivo
	 * @return
	 * @throws IOException
	 */
	String [] dameNombreArchivos(Path ruta, String extensionArchivo)
            throws IOException;
	

	String [] dameNombreCarpetas(Path ruta)
            throws IOException;
	
	String generateToken();
}