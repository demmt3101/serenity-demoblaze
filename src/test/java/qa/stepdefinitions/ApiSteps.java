package qa.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ApiSteps {

    private static final String BASE = "https://api.demoblaze.com";

    private static final String KEY_USER = "api.user";
    private static final String KEY_PASS = "api.pass";
    private static final String KEY_LAST_RESPONSE = "api.last.response";

    private Response lastResponse() {
        return (Response) Serenity.sessionVariableCalled(KEY_LAST_RESPONSE);
    }

    private void saveResponse(Response response) {
        Serenity.setSessionVariable(KEY_LAST_RESPONSE).to(response);
    }

    private String getUser() {
        return Serenity.sessionVariableCalled(KEY_USER);
    }

    private String getPass() {
        return Serenity.sessionVariableCalled(KEY_PASS);
    }

    private void setUserPass(String user, String pass) {
        Serenity.setSessionVariable(KEY_USER).to(user);
        Serenity.setSessionVariable(KEY_PASS).to(pass);
    }

    private String randomUser() {
        return "qa_" + UUID.randomUUID().toString().substring(0, 8);
    }

    private Response postJson(String path, Map<String, Object> body) {
        return SerenityRest.given()
                .baseUri(BASE)
                .contentType(ContentType.JSON)
                .accept("*/*")
                .body(body)
                .log().all()
                .post(path)
                .then()
                .log().all()
                .extract()
                .response();
    }

    // ---------------------- GIVEN ----------------------

    @Given("existe un usuario registrado")
    public void existeUsuarioRegistrado() {
        String user = getUser();
        String pass = getPass();

        if (user == null || pass == null) {
            user = randomUser();
            pass = "Pass123!";
            setUserPass(user, pass);

            // Intentamos registrarlo. Si ya existe por coincidencia, no nos importa para el resto de pruebas,
            // porque lo importante es tener credenciales "conocidas" para intentar login.
            Response r = postJson("/signup", Map.of("username", user, "password", pass));
            saveResponse(r);
        }
    }

    // ---------------------- WHEN ----------------------

    @When("hago signup con un usuario nuevo")
    public void signupNuevo() {
        String user = randomUser();
        String pass = "Pass123!";
        setUserPass(user, pass);

        Response r = postJson("/signup", Map.of("username", user, "password", pass));
        saveResponse(r);
    }

    @When("hago signup con el mismo usuario")
    public void signupExistente() {
        String user = getUser();
        String pass = getPass();

        // Si por alguna razón no existían, los creamos
        if (user == null || pass == null) {
            existeUsuarioRegistrado();
            user = getUser();
            pass = getPass();
        }

        Response r = postJson("/signup", Map.of("username", user, "password", pass));
        saveResponse(r);
    }

    @When("hago login con credenciales correctas")
    public void loginOk() {
        String user = getUser();
        String pass = getPass();

        if (user == null || pass == null) {
            existeUsuarioRegistrado();
            user = getUser();
            pass = getPass();
        }

        Response r = postJson("/login", Map.of("username", user, "password", pass));
        saveResponse(r);
    }

    @When("hago login con password incorrecta")
    public void loginBad() {
        String user = getUser();
        if (user == null) {
            existeUsuarioRegistrado();
            user = getUser();
        }

        Response r = postJson("/login", Map.of("username", user, "password", "wrong"));
        saveResponse(r);
    }

    // ---------------------- THEN (ASSERTS ROBUSTOS) ----------------------

    @Then("la respuesta de signup no debe contener error")
    public void signupSinError() {
        Response r = lastResponse();
        assertThat("status code", r.statusCode(), is(200));

        String body = r.asString(); // puede ser "" en éxito
        // éxito = no aparece "errorMessage"
        assertThat("signup body should not contain errorMessage", body, not(containsString("errorMessage")));
    }

    @Then("la respuesta de signup debe contener error")
    public void signupConError() {
        Response r = lastResponse();
        assertThat("status code", r.statusCode(), is(200));

        String body = r.asString();
        // error = aparece "errorMessage"
        assertThat("signup body should contain errorMessage", body, containsString("errorMessage"));
    }

    @Then("la respuesta de login debe ser exitosa")
    public void loginExitoso() {
        Response r = lastResponse();
        assertThat("status code", r.statusCode(), is(200));

        String body = r.asString(); // suele ser "Auth_token: ..."
        assertThat("login body should not contain errorMessage", body, not(containsString("errorMessage")));
        assertThat("login body should not be empty", body, not(isEmptyOrNullString()));
    }

    @Then("la respuesta de login debe contener error")
    public void loginDebeTenerError() {
        Response r = lastResponse();
        assertThat("status code", r.statusCode(), is(200));

        String body = r.asString();
        assertThat("login body should contain errorMessage", body, containsString("errorMessage"));
    }
}