/**
 * 
 */
package com.formuscmp.formus.generator;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
/**
 * @author jcruzrey
 *
 */
public interface IGenerador<T> {
	//Resource getForma(Path ruta) throws JsonParseException, JsonMappingException, IOException;
	//void guardarForma(Path ruta, final Resource forma) throws JsonGenerationException, JsonMappingException, IOException;
	String getCampo(String nombreCampo, Map<String, Object> data, final String rutaCompleta, final String formato);
	void put(Path ruta, final T forma) throws JsonGenerationException, JsonMappingException, IOException;
	T get(Path ruta, Class<T> valueType) throws JsonParseException, JsonMappingException, IOException;
	
}
