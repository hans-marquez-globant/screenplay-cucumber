package mystore.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ParameterDefinitions {

    //setea el nombre del actor
    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    // Genera todos los procedimientos previos al abrir el browser, setear el actor
    // Tener en memoria los stepDef.
    //En el metodo de arriba prepare el actor, con este preparo el stage
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
}
