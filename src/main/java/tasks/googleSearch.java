package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.MainPage.INPUT_SEARCH;

public class googleSearch implements Task {
    private String busqueda;

    public googleSearch(String busqueda) {
        this.busqueda = busqueda;
    }

    public static googleSearch conDatos(String s){
        return instrumented(googleSearch.class,s);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(busqueda).into(INPUT_SEARCH),
                Hit.the(Keys.ENTER).into(INPUT_SEARCH)
        );
    }


}
