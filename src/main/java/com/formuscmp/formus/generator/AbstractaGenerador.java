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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formuscmp.formus.resource.Resource;

/**
 * @author mac
 *
 */
public abstract class AbstractaGenerador<T> implements IGenerador<T> {

	private final AdministradorPlantillas templateManager;
			
	public AbstractaGenerador(final String[] templatePath) throws IOException {
		super();
		templateManager = new AdministradorPlantillas(templatePath);
	}

	/**
	 * Obtiene el contenido de una plantilla de campo
	 *
	 */
	public String getCampo(String nombreCampo, Map<String, Object> data, final String rutaCompleta, final String formato) {
		//AdministradorPlantillas 
        String result = templateManager.processTemplate(nombreCampo, data, rutaCompleta, formato);

        return result;
	}
	
	/* (non-Javadoc)
	 * @see com.mio.formas.generador.IGenerador#getForma(java.lang.String)
	 */
	public Resource getForma(Path ruta) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Resource forma = null;
		forma = mapper.readValue(ruta.toFile(), Resource.class);
		//forma.setFechaUltimaModificacion(new Date(ruta.toFile().lastModified()));
		return forma;
	}

	/* (non-Javadoc)
	 * @see com.mio.formas.generador.IGenerador#guardarForma(com.mio.formas.forma.AbstractForma)
	 */
	public void guardarForma(Path ruta, Resource forma) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(ruta.toFile(), forma);
	}
	
	public void put(Path ruta, T forma) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(ruta.toFile(), forma);
	}
	
	public T get(Path ruta, Class<T> valueType) throws JsonParseException, JsonMappingException, IOException {
		//Class<T> c
		ObjectMapper mapper = new ObjectMapper();
		T forma = mapper.readValue(ruta.toFile(), valueType);
		//forma.setFechaUltimaModificacion(new Date(ruta.toFile().lastModified()));
		return forma;
	}
}
