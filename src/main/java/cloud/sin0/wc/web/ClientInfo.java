package cloud.sin0.wc.web;

import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.server.Request;

import java.net.SocketAddress;

/** Remote address and browser of the caller; X-Forwarded-For is honoured only when the deployment says so. */
public final class ClientInfo {

    private static final int MAX_UA = 200;

    private ClientInfo() { }

    public static String ip(Request request, boolean trustProxy) {
        if (trustProxy) {
            String xff = request.getHeaders().get("X-Forwarded-For");
            if (xff != null && !xff.isBlank()) {
                String first = xff.split(",")[0].trim();
                if (first.matches("[0-9a-fA-F:.]{3,45}")) {
                    return first;
                }
            }
        }
        SocketAddress remote = request.getConnectionMetaData().getRemoteSocketAddress();
        if (remote instanceof java.net.InetSocketAddress isa && isa.getAddress() != null) {
            return isa.getAddress().getHostAddress();
        }
        return "";
    }

    public static String userAgent(Request request) {
        String ua = request.getHeaders().get(HttpHeader.USER_AGENT);
        if (ua == null) {
            return "";
        }
        ua = ua.replaceAll("[\\p{Cntrl}]", " ").trim();
        return ua.length() > MAX_UA ? ua.substring(0, MAX_UA) : ua;
    }
}
