package cloud.sin0.wc.auth;

import cloud.sin0.wc.client.FormusClient;
import cloud.sin0.wc.config.AppConfig;
import cloud.sin0.wc.testing.StubFormusWs;
import com.formuscmp.formus.request.RequestResource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Properties;

import static cloud.sin0.wc.testing.StubFormusWs.data;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** The client-application rule: own origin, own staff/admin lists, and a sign-in that is valid only when the user row names this application. */
class ClientAppIdentityTest {

    StubFormusWs backend;

    @BeforeEach
    void start() throws Exception {
        backend = new StubFormusWs();
    }

    @AfterEach
    void stop() throws Exception {
        backend.stop();
    }

    AppConfig cfg(Map<String, String> props, Map<String, String> env) {
        Properties p = new Properties();
        p.setProperty("fb.microservice.url", backend.url());
        props.forEach(p::setProperty);
        return new AppConfig(p, env);
    }

    static final Profile ANA = new Profile("Google", "sub-1", "Ana@Example.com", "Ana", "");

    @Test
    void theApplicationsOwnOriginWinsAndAnOldApplicationKeepsItsConfiguredOne() {
        assertEquals("ui::dental", cfg(Map.of("client.app.origin", "ui::dental", "fb.microservice.origin", "ui::case"), Map.of()).origin());
        assertEquals("ui::dental", cfg(Map.of("client.app.origin", " UI::Dental "), Map.of()).clientApp(), "trimmed, lower case");
        assertEquals("ui::dental", cfg(Map.of("client.app.origin", "ui::case"), Map.of("CLIENT_APP_ORIGIN", "ui::dental")).origin(), "the environment wins");
        AppConfig old = cfg(Map.of("fb.microservice.origin", "ui::visa"), Map.of());
        assertEquals("", old.clientApp());
        assertEquals("ui::visa", old.origin());
        assertEquals("ui::case", cfg(Map.of(), Map.of()).origin(), "the platform default");
    }

    @Test
    void theStaffAndAdminListsComeFromTheApplication() {
        AppConfig c = cfg(Map.of("STAFF_EMAILS", "a@x.com"), Map.of("STAFF_EMAILS", " B@x.com, c@x.com;d@x.com  e@x.com ", "ADMIN_EMAILS", "Boss@x.com"));
        assertEquals(java.util.Set.of("b@x.com", "c@x.com", "d@x.com", "e@x.com"), c.staffEmails());
        assertEquals(java.util.Set.of("boss@x.com"), c.adminEmails());
        assertEquals(java.util.Set.of("a@x.com"), cfg(Map.of("STAFF_EMAILS", "A@x.com"), Map.of()).staffEmails());
        assertTrue(cfg(Map.of(), Map.of()).staffEmails().isEmpty());
    }

    @Test
    void theProposedRoleIsAdminThenStaffThenNothing() {
        UserIdentifier id = new UserIdentifier(new FormusClient(cfg(Map.of(), Map.of())), cfg(Map.of(), Map.of("STAFF_EMAILS", "both@x.com,staff@x.com", "ADMIN_EMAILS", "both@x.com,admin@x.com")));
        assertEquals("admin", id.proposedRole("Admin@X.com"));
        assertEquals("admin", id.proposedRole("both@x.com"), "admin wins");
        assertEquals("staff", id.proposedRole("staff@x.com"));
        assertEquals("", id.proposedRole("nobody@x.com"));
        assertEquals("", new UserIdentifier(new FormusClient(cfg(Map.of(), Map.of()))).proposedRole("staff@x.com"), "an application without the rule proposes nothing");
    }

    UserIdentifier identifier(Map<String, String> props, Map<String, String> env) {
        AppConfig c = cfg(props, env);
        return new UserIdentifier(new FormusClient(c), c);
    }

    @Test
    void identifySendsTheOriginAndTheProposedRole() throws Exception {
        backend.on("usuario/identificar", rr -> data("uuid", "u-1", "rol", "staff", "clientapp", "ui::dental", "activo", true));
        identifier(Map.of("client.app.origin", "ui::dental"), Map.of("STAFF_EMAILS", "ana@example.com")).identify(ANA, FormusClient.CallContext.none());
        RequestResource sent = backend.calls("usuario/identificar").get(0);
        assertEquals("ui::dental", sent.getOrigin(), "the application's origin travels as the request origin");
        assertEquals("staff", sent.getParameters().get("rolInicial"));
        assertEquals("Ana@Example.com", sent.getParameters().get("username"));
    }

    @Test
    void noRoleIsSentForSomeoneNotOnAList() throws Exception {
        backend.on("usuario/identificar", rr -> data("uuid", "u-1", "rol", "solicitante", "clientapp", "ui::dental"));
        identifier(Map.of("client.app.origin", "ui::dental"), Map.of("STAFF_EMAILS", "other@example.com")).identify(ANA, FormusClient.CallContext.none());
        assertTrue(!backend.calls("usuario/identificar").get(0).getParameters().containsKey("rolInicial"));
    }

    @Test
    void theSignInIsValidOnlyWhenTheRecordNamesThisApplication() throws Exception {
        UserIdentifier id = identifier(Map.of("client.app.origin", "ui::dental"), Map.of());
        backend.on("usuario/identificar", rr -> data("uuid", "u-1", "rol", "admin", "clientapp", "UI::Dental"));
        UserIdentifier.Identity ok = id.identify(ANA, FormusClient.CallContext.none());
        assertEquals("admin", ok.role());
        assertEquals("ui::dental", ok.clientApp());

        backend.on("usuario/identificar", rr -> data("uuid", "u-1", "rol", "staff", "clientapp", "ui::visa"));
        assertThrows(UserIdentifier.IdentifyException.class, () -> id.identify(ANA, FormusClient.CallContext.none()), "registered in another application");
        backend.on("usuario/identificar", rr -> data("uuid", "u-1", "rol", "staff", "clientapp", ""));
        assertThrows(UserIdentifier.IdentifyException.class, () -> id.identify(ANA, FormusClient.CallContext.none()), "no application recorded: not valid until migrated");
        backend.on("usuario/identificar", rr -> data("uuid", "u-1", "rol", "staff"));
        assertThrows(UserIdentifier.IdentifyException.class, () -> id.identify(ANA, FormusClient.CallContext.none()), "an old formus-ws that returns no clientapp");
    }

    @Test
    void anApplicationThatHasNotAdoptedTheRuleIsNotChecked() throws Exception {
        backend.on("usuario/identificar", rr -> data("uuid", "u-1", "rol", "staff", "clientapp", "ui::whatever"));
        UserIdentifier.Identity i = identifier(Map.of(), Map.of()).identify(ANA, FormusClient.CallContext.none());
        assertEquals("staff", i.role());
        backend.on("usuario/identificar", rr -> data("uuid", "u-1", "rol", "root"));
        assertEquals("solicitante", identifier(Map.of(), Map.of()).identify(ANA, FormusClient.CallContext.none()).role(), "an unknown role is the least privileged");
    }

    @Test
    void anAdministratorIsStaffForTheEngine() {
        SessionUser admin = new SessionUser("s", "a@x.com", "A", "Google", "", "1", "admin", "lib", "", "");
        assertTrue(admin.isStaff() && admin.isAdmin());
        SessionUser staff = new SessionUser("s", "a@x.com", "A", "Google", "", "1", "staff", "lib", "", "");
        assertTrue(staff.isStaff() && !staff.isAdmin());
        assertTrue(!new SessionUser("s", "a@x.com", "A", "Google", "", "1", "solicitante", "lib", "", "").isStaff());
    }
}
