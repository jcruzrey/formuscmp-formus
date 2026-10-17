package cloud.sin0.wc.client;

import java.nio.file.Path;

/**
 * A file the user posted, waiting in a temporary file to be relayed to formus-ws.
 *
 * @param field       the form field (multipart part name)
 * @param filename    the name the browser sent (only a label)
 * @param contentType the type the browser declared
 * @param path        where the bytes are
 * @param size        length in bytes
 */
public record Upload(String field, String filename, String contentType, Path path, long size) { }
