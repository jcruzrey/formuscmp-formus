/**
 * 
 */
package com.formuscmp.formus.resource;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.formuscmp.formus.generator.Generador;
import com.formuscmp.formus.generator.IGenerador;


/**
 * 
 */
public class UseCaseTest extends GenerateCode{

	private String[] templatesPath = new String[] { "/Users/macbook/Documents/formuscmp/formuscmp-formus-api/config" };

	/**
	 * Test method for {@link com.formuscmp.formus.resource.UseCase#getSteps()}.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@Test
	public void testGetSteps() throws JsonGenerationException, JsonMappingException, IOException {
		IGenerador<UseCase> generador = new Generador<UseCase>(templatesPath);
		
		//Path fileConfigLocation = Paths.get("./config")
		//		.toAbsolutePath().normalize();
		
		//Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		//Path filePath = fileConfigLocation.resolve("casoimportar.json").normalize();
		
		Path fileConfigLocation = Paths.get("./config").toAbsolutePath().normalize();
		Path filePath = fileConfigLocation.resolve("caso_importar.json").normalize();
		
		UseCase useCase = new UseCase();
		useCase.setName("importar");
		useCase.setResourceName("importar");
		useCase.setResourceType("usecase");
		useCase.setTitle("Caso de uso de importacion");
		useCase.setCreateable(true);
		useCase.setModule("sistema");
		useCase.setAlias("importar");
		useCase.setPrefix("IMP");
		useCase.setVersion("1.0");
		useCase.setUuid(generarToken());
		useCase.setLocale("es_MX");
		useCase.setStatus("produccion");
		useCase.getOwners().add("*");
		
		Map<String,Step> steps = new HashMap<String,Step>();
		
		Step step = new Step();
		step.getResources().add("form.directorio.empresa.1.0-es_MX");
		step.setName("subir");
		step.setObs("Paso de importacion de archivo");
		step.setOrder(1);
		step.setAlias("Subir Archivo");
		step.getOwners().add("*");
		step.setUuid(generarToken());
		step.setInstruction("Elija el archivo a subir a la plataforma");
		steps.put(step.getName(), step);
		
		Step step1 = new Step();
		step1.getResources().add("form.directorio.empresa.1.0-es_MX");
		step1.setName("importar");
		step1.setObs("Paso de importacion de archivo");
		step1.setOrder(2);
		step1.setAlias("Subir Archivo");
		step1.getOwners().add("*");
		step1.setUuid(generarToken());
		step1.setInstruction("Inicie la importacion del archivo");
		steps.put(step1.getName(), step1);
		
		useCase.setSteps(steps);
		
		generador.put(filePath, useCase);
		
	}

}
