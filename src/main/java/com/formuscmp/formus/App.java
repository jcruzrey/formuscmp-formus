package com.formuscmp.formus;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.formuscmp.formus.generator.Generador;
import com.formuscmp.formus.generator.IGenerador;
import com.formuscmp.formus.resource.AbstractResource;
import com.formuscmp.formus.resource.Resource;
/**
 * Formas App
 *
 */
public class App 
{
	public static final String CONFIG_DIR = "./config"; 
    
    public static List<Resource> config() throws JsonParseException, JsonMappingException, IOException{
    	List<Resource> lista = new ArrayList<Resource>();
		/*
		 * IGenerador generador = new Generador(); File folder = new File(CONFIG_DIR);
		 * File[] listOfFiles = folder.listFiles();
		 * 
		 * for (int i = 0; i < listOfFiles.length; i++) { if (listOfFiles[i].isFile()) {
		 * Path fileConfigLocation = Paths.get(CONFIG_DIR)
		 * .toAbsolutePath().normalize(); Path filePath =
		 * fileConfigLocation.resolve(listOfFiles[i].getName()).normalize(); Forma forma
		 * = generador.getForma(filePath); lista.add(forma); } else if
		 * (listOfFiles[i].isDirectory()) { //System.out.println("Directory " +
		 * listOfFiles[i].getName()); } }
		 */
    	
    	return lista;
    }
}
