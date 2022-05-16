package com.appgate.prueba.stepDefinitions;

import com.appgate.prueba.exceptions.RestartException;
import com.appgate.prueba.questions.App;
import com.appgate.prueba.questions.System;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.appgate.prueba.userInterfaces.TimeZone.RESET_BUTTON;
import static com.appgate.prueba.utils.constants.General.YISUS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class RestartQueryStepDefinition {

    @Before
    public void setup(){
        setTheStage(new OnlineCast());
    }


    @When("Reboot the system")
    public void rebootTheSystem() {
        theActorCalled(YISUS).attemptsTo(
                Click.on(RESET_BUTTON)
        );
    }

    @Then("The system returns and changes its state to consult coordinates")
    public void theSystemReturnsAndChangesItsStateToConsultCoordinates() {
        theActorInTheSpotlight().should(seeThat(
                App.isReset()
        ).orComplainWith(RestartException.class));
    }
}
