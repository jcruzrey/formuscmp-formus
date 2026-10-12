package cloud.sin0.wc.web;

import cloud.sin0.wc.client.FormusClient;
import cloud.sin0.wc.config.AppConfig;

/** The engine services an application gets in {@link WebClientApp#init}. */
public final class WebClientContext {

    public final AppConfig cfg;
    public final ViewRenderer views;
    public final ViewResolver resolver;
    public final FormusClient client;
    public final Pages pages;

    public WebClientContext(AppConfig cfg, ViewRenderer views, ViewResolver resolver, FormusClient client, Pages pages) {
        this.cfg = cfg;
        this.views = views;
        this.resolver = resolver;
        this.client = client;
        this.pages = pages;
    }
}
