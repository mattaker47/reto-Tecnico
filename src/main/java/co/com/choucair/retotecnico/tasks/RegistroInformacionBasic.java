package co.com.choucair.retotecnico.tasks;

import co.com.choucair.retotecnico.model.Usuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.Keys;

import java.util.List;


import static co.com.choucair.retotecnico.userinterface.RegistroInfoUI.*;

public class RegistroInformacionBasic implements Task {

    private List<Usuario> usuario;

    public RegistroInformacionBasic(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    public static RegistroInformacionBasic informacionPersonal(List<Usuario> usuario){
        return Tasks.instrumented(RegistroInformacionBasic.class, usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_UNETE),
                Enter.theValue(usuario.get(0).getNombre()).into(TXT_NOMBRE),
                Enter.theValue(usuario.get(0).getApellido()).into(TXT_APELLIDO),
                Enter.theValue(usuario.get(0).getCorreo()).into(TXT_CORREO),
                SelectFromOptions.byVisibleText(usuario.get(0).getMes()).from(SELECTOR_MES),
                SelectFromOptions.byVisibleText(usuario.get(0).getDia()).from(SELECTOR_DIA),
                SelectFromOptions.byVisibleText(usuario.get(0).getAnos()).from(SELECTOR_ANOS),
                Click.on(LENGUAJE),
                Enter.theValue(usuario.get(0).getLenguaje()).into(INPUT_LENGUAJE).thenHit(Keys.ENTER),
                Click.on(BTN_DIRECCION)
        );

    }
}
