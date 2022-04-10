package co.com.choucair.retotecnico.tasks;

import co.com.choucair.retotecnico.userinterface.PaginaUtestUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class AbreWeb implements Task {
    private PaginaUtestUI utestPagina;
    public static AbreWeb uTest() {
        return Tasks.instrumented(AbreWeb.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(utestPagina));
    }
}
