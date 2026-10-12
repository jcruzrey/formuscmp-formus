package cloud.sin0.wc.client;

/**
 * One formus-ws operation: {@code module/resourceType/resourceName/commandName}. A null module means "the configured one"; the version
 * is set per call ({@link FormusClient.Call#target}). formus-ws finds the script as command name + locale.
 */
public record Command(String module, String resourceType, String resourceName, String name) {

    public Command(String resourceType, String resourceName, String name) {
        this(null, resourceType, resourceName, name);
    }
}
