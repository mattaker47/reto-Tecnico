package co.com.choucair.retotecnico.tasks;

import co.com.choucair.retotecnico.model.Usuario;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.util.List;

import static co.com.choucair.retotecnico.userinterface.RegistroInfoUI.*;


public class RegistroDireccion implements Task {

    private List<Usuario> usuario;
    public RegistroDireccion(List<Usuario> usuario){
        this.usuario = usuario;
    }
    public static RegistroDireccion direccionPersonal(List<Usuario> usuario){
        return Tasks.instrumented(RegistroDireccion.class,usuario);
    }
    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Enter.theValue(usuario.get(0).getCity()).into(INPUT_CITY),
                Hit.the(Keys.ARROW_DOWN).into(INPUT_CITY),
                Hit.the(Keys.ENTER).into(INPUT_CITY),
                Enter.theValue(usuario.get(0).getPostalCode()).into(INPUT_POSTAL_CODE),
                Click.on(SPAN_COUNTRY),
                Enter.theValue(usuario.get(0).getCountry()).into(SPAN_COUNTRY1),
                Click.on(BTN_DISPOSITIVOS));
    }
}

