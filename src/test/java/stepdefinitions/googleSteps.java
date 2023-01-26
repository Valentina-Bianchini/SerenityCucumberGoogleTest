package stepdefinitions;

import configurations.Configurations;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import tasks.googleSearch;
import userinterfaces.MainPage;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static userinterfaces.MainPage.BTN_BUSCAR;


public class googleSteps {

    WebDriver driver;
    private Actor actor = Actor.named("Usuario");
    private MainPage main = new MainPage();

    @Given("^usuario ingresa en el buscador de Google$")
    public void usuario_ingresa_en_el_buscador_de_Google() {
        driver = new Configurations().setup();
        actor.can(BrowseTheWeb.with(driver));
        actor.wasAbleTo(Open.browserOn(main));
    }


    @When("^ingresa una busqueda$")
    public void ingresa_una_busqueda(List<String> data) {
        actor.attemptsTo(WaitUntil.the(BTN_BUSCAR, isVisible()).forNoMoreThan(30).seconds());

        actor.should(seeThat(the(BTN_BUSCAR),isPresent()));

        actor.wasAbleTo(
                googleSearch.conDatos(data.get(0))
        );
    }

    @Then("^recibe resultados relacionados con la busqueda$")
    public void recibe_resultados_relacionados_con_la_busqueda(List<String> data) {
        Target LINK = Target.the(" link a recursos relacionados a "+data.get(0)+"").locatedBy("//div[@id='result-stats añelhaefh']");

        actor.attemptsTo(WaitUntil.the(LINK, isVisible()).forNoMoreThan(30).seconds());

        actor.should(seeThat(the(LINK), isPresent()));
    }

}
