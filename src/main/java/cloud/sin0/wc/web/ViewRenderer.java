package cloud.sin0.wc.web;

import freemarker.core.HTMLOutputFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

/**
 * FreeMarker renderer, same approach as formuscmp-web-case: {@code HTMLOutputFormat} is enabled globally so
 * every {@code ${...}} is HTML-escaped (use {@code ?no_esc} only for trusted markup/JSON). Templates load
 * from the classpath ({@code templates/}); {@code TEMPLATES_DIR} switches to a directory on disk with
 * hot reload for local work.
 */
public class ViewRenderer {

    private static final Logger LOG = LoggerFactory.getLogger(ViewRenderer.class);

    private final Configuration configuration;

    public ViewRenderer() {
        this(System.getenv("TEMPLATES_DIR"));
    }

    public ViewRenderer(String templatesDir) {
        this.configuration = new Configuration(Configuration.VERSION_2_3_34);
        this.configuration.setDefaultEncoding("UTF-8");
        this.configuration.setOutputEncoding("UTF-8");
        this.configuration.setOutputFormat(HTMLOutputFormat.INSTANCE);
        this.configuration.setLocale(Locale.forLanguageTag("es-MX"));
        this.configuration.setNumberFormat("computer");
        this.configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        this.configuration.setLogTemplateExceptions(false);
        this.configuration.setFallbackOnNullLoopVariable(false);

        if (templatesDir != null && !templatesDir.isBlank()) {
            File dir = new File(templatesDir);
            if (dir.isDirectory()) {
                try {
                    // the directory overrides the classpath: the engine's layout and default views keep loading from its jar
                    this.configuration.setTemplateLoader(new freemarker.cache.MultiTemplateLoader(new freemarker.cache.TemplateLoader[]{
                            new freemarker.cache.FileTemplateLoader(dir),
                            new freemarker.cache.ClassTemplateLoader(getClass().getClassLoader(), "templates")}));
                    this.configuration.setTemplateUpdateDelayMilliseconds(0);
                    LOG.info("Loading templates from filesystem: {} (edits picked up without restart)", dir.getAbsolutePath());
                    return;
                } catch (IOException e) {
                    LOG.warn("Failed to use TEMPLATES_DIR '{}'; falling back to the classpath", templatesDir, e);
                }
            } else {
                LOG.warn("TEMPLATES_DIR '{}' is not a directory; falling back to the classpath", templatesDir);
            }
        }
        this.configuration.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "templates");
    }

    /** A variable every template sees (for example the application's {@code urls}); set before the first request. */
    public void setSharedVariable(String name, Object value) {
        try {
            configuration.setSharedVariable(name, value);
        } catch (freemarker.template.TemplateModelException e) {
            throw new IllegalArgumentException("Cannot share " + name, e);
        }
    }

    /** True if a template with this name can be loaded (used to honor ResponseResource.view only when we have it). */
    public boolean exists(String templateName) {
        try {
            return configuration.getTemplate(templateName) != null;
        } catch (freemarker.template.TemplateNotFoundException e) {
            return false;
        } catch (IOException e) {
            LOG.warn("Template lookup failed for {}", templateName, e);
            return false;
        }
    }

    public void render(String templateName, Map<String, Object> model, Writer out) throws IOException {
        try {
            Template template = configuration.getTemplate(templateName);
            template.process(model, out);
        } catch (TemplateException e) {
            LOG.error("Failed to render template {}", templateName, e);
            throw new IOException("Failed to render template " + templateName, e);
        }
    }
}
