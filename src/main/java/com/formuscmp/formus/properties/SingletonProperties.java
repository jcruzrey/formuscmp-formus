/**
 * 
 */
package com.formuscmp.formus.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Jose Luis Cruz Reyes - Formus CMP
 *
 */
public class SingletonProperties implements IProperties {
	
	private Properties p=null;

	public SingletonProperties() {
		super();
	}

	public void init() {
		p= new Properties();
		try {
			//p.load(new FileInputStream(new File("application.properties")));
			System.out.println("Cargando archivo aplicacion_dev.properties");
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("aplicacion_dev.properties");
			p.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getPropiedad(String clave) {
		if (null==p) init();
		return p.getProperty(clave);
	}
}
