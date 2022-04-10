package co.com.choucair.retotecnico.tasks;

import co.com.choucair.retotecnico.model.Usuario;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.util.List;

import static co.com.choucair.retotecnico.userinterface.RegistroInfoUI.*;


public class RegistroDispositivo implements Task{

    private List<Usuario> usuario;

    public RegistroDispositivo(List<Usuario> usuario){
        this.usuario = usuario;
    }

    public static RegistroDispositivo dispositivoPersonal(List<Usuario> usuario){
        return Tasks.instrumented(RegistroDispositivo.class, usuario);
    }
    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Click.on(COMPUTADOR),
                Enter.theValue(usuario.get(0).getComputador()).into(INPUT_COMPUTADOR).thenHit(Keys.ENTER),
                Click.on(VERSION),
                Enter.theValue(usuario.get(0).getVersion()).into(INPUT_VERSION).thenHit(Keys.ENTER),
                Click.on(LENGUAJESO),
                Enter.theValue(usuario.get(0).getLenguajeSO()).into(INPUT_LENGUAJESO).thenHit(Keys.ENTER),
                Click.on(MOVIL),
                Enter.theValue(usuario.get(0).getMovil()).into(INPUT_MOVIL).thenHit(Keys.ENTER),
                Click.on(MODELO),
                Enter.theValue(usuario.get(0).getModelo()).into(INPUT_MODELO).thenHit(Keys.ENTER),
                Click.on(SISTEMA),
                Enter.theValue(usuario.get(0).getSistema()).into(INPUT_SISTEMA).thenHit(Keys.ENTER),
                Click.on(BTN_CONTRASENA)
        );
    }
}
