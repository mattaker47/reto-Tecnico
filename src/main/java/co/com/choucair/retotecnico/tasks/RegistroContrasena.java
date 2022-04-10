package co.com.choucair.retotecnico.tasks;

import co.com.choucair.retotecnico.model.Usuario;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;

import java.util.List;

import static co.com.choucair.retotecnico.userinterface.RegistroInfoUI.*;

public class RegistroContrasena implements Task {
    private List<Usuario> usuario;
    public RegistroContrasena(List<Usuario> usuario){
        this.usuario = usuario;
    }
    public static RegistroContrasena contrasenaPersonal(List<Usuario> usuario){
        return Tasks.instrumented(RegistroContrasena.class,usuario);
    }
    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Enter.theValue(usuario.get(0).getContrasena()).into(TXT_CONTRASENA),
                Enter.theValue(usuario.get(0).getConfirmarcontrasena()).into(TXT_CONFIRCONTRASENA),
                Click.on(BTN_TERMINO),
                Click.on(BTN_POLITICA),
                Click.on(BTN_REGISTRAR)
        );
    }
}
