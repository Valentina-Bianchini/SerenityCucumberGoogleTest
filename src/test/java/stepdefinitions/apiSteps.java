package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.List;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class apiSteps {
    private Actor actor = Actor.named("Usuario");
    private String URL = "https://reqres.in";
    private String PATH = "/api/users/";

    @Given("^el usuario existe$")
    public void el_usuario_existe() {

    }

    @When("^consulta datos de usuario$")
    public void consulta_datos_de_usuario(List<String> data) {
        actor.whoCan(CallAnApi.at(URL));
        actor.attemptsTo(
                Get.resource(PATH+data.get(0)).with(request -> request.header("Content-Type","application/json"))
        );
    }

    @Then("^recibe datos de usuario$")
    public void recibe_datos_de_usuario() {
        actor.should(seeThatResponse("Retorna codigo 200", response -> response.statusCode(200)));
        String nombre = SerenityRest.lastResponse().jsonPath().get("data.first_name").toString();
        actor.attemptsTo(Ensure.that(nombre).isEqualTo("Janet"));
    }
    
}
