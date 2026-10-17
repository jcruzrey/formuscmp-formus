package cloud.sin0.wc.client;

import cloud.sin0.wc.config.AppConfig;
import cloud.sin0.wc.testing.StubFormusWs;
import com.formuscmp.formus.response.ResponseResource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Properties;

import static cloud.sin0.wc.testing.StubFormusWs.data;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

/** {@code Call.cacheable()}: the last answer is revalidated with If-None-Match, so an unchanged list is not sent again. */
class FormusClientCacheTest {

    StubFormusWs backend;
    FormusClient client;
    int version = 1;

    @BeforeEach
    void start() throws Exception {
        backend = new StubFormusWs();
        Properties p = new Properties();
        p.setProperty("fb.microservice.url", backend.url());
        client = new FormusClient(new AppConfig(p, Map.of()));
        backend.on("basket:form/nuevo", rr -> data("version", version, "fields", String.valueOf(rr.getParameters().get("fields"))));
    }

    @AfterEach
    void stop() throws Exception {
        backend.stop();
    }

    FormusClient.Call list(boolean cacheable, String fields) {
        FormusClient.Call c = client.call(new Command("case", "basket", "form", "nuevo"), FormusClient.CallContext.none()).param("fields", fields);
        return cacheable ? c.cacheable() : c;
    }

    @Test
    void anUnchangedAnswerIsRevalidatedNotResent() {
        ResponseResource first = list(true, "summary").execute();
        ResponseResource second = list(true, "summary").execute();
        assertEquals(1, backend.notModifiedCount(), "the second call carried the ETag and got 304");
        assertEquals(first.getData(), second.getData());
        assertNotSame(first, second, "every call gets its own object; callers may change it");
        assertEquals(2, backend.calls("basket:form/nuevo").size());
    }

    @Test
    void aChangedAnswerReplacesTheKeptOne() {
        assertEquals(1, list(true, "summary").execute().getData().get("version"));
        version = 2;
        assertEquals(2, list(true, "summary").execute().getData().get("version"), "different bytes -> the new answer, not the kept one");
        assertEquals(0, backend.notModifiedCount());
        assertEquals(2, list(true, "summary").execute().getData().get("version"));
        assertEquals(1, backend.notModifiedCount());
    }

    @Test
    void largeAnswersTravelGzippedAndAreReadTransparently() {
        backend.on("basket:grande/nuevo", rr -> data("blob", "x".repeat(5000)));
        ResponseResource r = client.call(new Command("case", "basket", "grande", "nuevo"), FormusClient.CallContext.none()).execute();
        assertEquals("x".repeat(5000), r.getData().get("blob"));
        assertEquals(1, backend.gzippedCount(), "the client asked for gzip and the stub compressed the answer");
    }

    @Test
    void differentParametersAreDifferentEntries() {
        list(true, "summary").execute();
        assertEquals("full", list(true, "full").execute().getData().get("fields"));
        assertEquals(0, backend.notModifiedCount());
    }

    @Test
    void aCallThatIsNotCacheableNeverSendsIfNoneMatch() {
        list(false, "summary").execute();
        list(false, "summary").execute();
        assertEquals(0, backend.notModifiedCount());
    }
}
