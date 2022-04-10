package co.com.choucair.retotecnico.stepdefinitions;

import co.com.choucair.retotecnico.model.Usuario;
import co.com.choucair.retotecnico.questions.RegistroQuestion;
import co.com.choucair.retotecnico.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class RegistroStepDefinition {
    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("^que (.*) quiere registrarse como usuario$")
    public void quiereRegistrarseComoUsuario(String actor) {
        OnStage.theActorCalled(actor).wasAbleTo(AbreWeb.uTest());
    }


    @When("^cuando ingresa su informacion basica$")
    public void cuandoIngresaSuInformacionBasica(List<Usuario> usuario) {
        theActorInTheSpotlight().attemptsTo(
                RegistroInformacionBasic.informacionPersonal(usuario),
                RegistroDireccion.direccionPersonal(usuario),
                RegistroDispositivo.dispositivoPersonal(usuario),
                RegistroContrasena.contrasenaPersonal(usuario));
    }

    @Then("^debe ver la opcion (.*) para finalizar registro$")
    public void debeVerLaOpcionParaFinalizarRegistro(String mensaje) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(RegistroQuestion.obtenerTexto(mensaje)));
    }

}

