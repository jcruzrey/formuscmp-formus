package cloud.sin0.wc.client;

import com.formuscmp.formus.request.RequestResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormusEndpointTest {

    static RequestResource rr(String module, String type, String name, String command) {
        RequestResource r = new RequestResource();
        r.setModule(module);
        r.setResourceType(type);
        r.setResourceName(name);
        r.setVersion("1.0");
        r.setCommandName(command);
        return r;
    }

    @Test
    void pathIsTheOperationOfTheSpec() {
        assertEquals("http://localhost:9998/api/v1/formus/case/form/form/1.0/guardar",
                FormusClient.endpoint("http://localhost:9998/api/v1/formus", rr("case", "form", "form", "guardar")));
        assertEquals("http://localhost:9998/api/v1/formus/case/basket/form/1.0/nuevo",
                FormusClient.endpoint("http://localhost:9998/api/v1/formus/", rr("case", "basket", "form", "nuevo")));
    }

    @Test
    void anOldConfiguredCommandPathIsCutBackToTheRoot() {
        assertEquals("http://localhost:9998/api/v1/formus/directorio/form/usuario/1.0/identificar",
                FormusClient.endpoint("http://localhost:9998/api/v1/formus/case/basket/form/1.0/nuevo", rr("directorio", "form", "usuario", "identificar")));
        assertEquals("https://ws.example.com/api/v1/formus/case/form/plan/1.0/detalle",
                FormusClient.endpoint("https://ws.example.com/api/v1/formus/visa", rr("case", "form", "plan", "detalle")));
    }
}
