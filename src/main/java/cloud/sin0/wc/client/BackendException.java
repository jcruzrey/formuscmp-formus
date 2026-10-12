package cloud.sin0.wc.client;

/** Transport-level failure talking to formus-ws (unreachable, timeout, unparseable body). Business errors are NOT exceptions. */
public class BackendException extends RuntimeException {

    private final String correlationId;

    public BackendException(String message, String correlationId, Throwable cause) {
        super(message, cause);
        this.correlationId = correlationId;
    }

    public String correlationId() {
        return correlationId;
    }
}
