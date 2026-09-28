/**
 * 
 */
package com.formuscmp.formus.generator;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * @author Jose Luis Cruz Reyes
 * Formus Case Management Platform
 *
 */
public class AdministradorPlantillas {
	private Configuration freemarkerConfig;
    
    public AdministradorPlantillas(String[] templatePath) throws IOException {
    	
    	TemplateLoader[] loaderArray = new TemplateLoader[templatePath.length];
    	
    	int x = 0;
    	for (String path : templatePath) {
    		FileTemplateLoader ftl1 = new FileTemplateLoader(new File(path));
    		loaderArray[x] = ftl1;
    		x++;
    	}
    	
    	MultiTemplateLoader mtl = new MultiTemplateLoader(loaderArray);
    	
        freemarkerConfig = new Configuration(Configuration.VERSION_2_3_23);
        freemarkerConfig.setTagSyntax(Configuration.ANGLE_BRACKET_TAG_SYNTAX);
        freemarkerConfig.setDefaultEncoding("UTF-8");
        freemarkerConfig.setNumberFormat("computer");
        freemarkerConfig.setObjectWrapper(new BeansWrapperBuilder(Configuration.VERSION_2_3_23).build());
        //freemarkerConfig.setTemplateLoader(new StringTemplateLoader());
        freemarkerConfig.setTemplateLoader(mtl);
        freemarkerConfig.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER); // Or RETHROW_HANDLER for production
    }

    public String processTemplate(String templateName, Map<String, Object> data, final String rutaCompleta, final String formato) {

        try {
        	Template template = freemarkerConfig.getTemplate(rutaCompleta, "utf-8");
        	StringWriter writer = new StringWriter();
            template.process(data, writer);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
