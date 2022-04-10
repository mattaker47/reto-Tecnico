package co.com.choucair.retotecnico.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.choucair.retotecnico.userinterface.RegistroInfoUI.LBL_MENSAJE;

public class RegistroQuestion implements Question<Boolean> {
    private String mensaje;

    public RegistroQuestion(String mensaje){
        this.mensaje = mensaje;
    }



    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String mensajeRegistro = Text.of(LBL_MENSAJE).viewedBy(actor).asString();
        if (mensaje.equals(mensajeRegistro)){
            result = true;
        }else{
            result = false;
        }
        return  result;
    }

    public static RegistroQuestion obtenerTexto(String mensaje) {
        return  new RegistroQuestion(mensaje);
    }
}
