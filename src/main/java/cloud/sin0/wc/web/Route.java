package cloud.sin0.wc.web;

/** A page of an application. {@link #handle} answers the request and returns true, or returns false to let the next route (and finally the generic pipeline) try. */
@FunctionalInterface
public interface Route {
    boolean handle(Ctx c) throws Exception;
}
