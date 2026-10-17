package cloud.sin0.wc.client;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * formus-ws answered with a file (a command set {@code ResponseResource.attachment}) instead of the JSON envelope. The caller must close it.
 *
 * @param status       200, or 206 for a range
 * @param contentType  type of the stored file
 * @param disposition  the {@code Content-Disposition} formus-ws sent (always {@code attachment})
 * @param contentRange {@code Content-Range} of a 206, else null
 * @param length       bytes in {@code body}, -1 when unknown
 * @param body         the bytes, streamed
 */
public record FileAnswer(int status, String contentType, String disposition, String contentRange, long length, InputStream body) implements Closeable {

    @Override
    public void close() throws IOException {
        body.close();
    }
}
