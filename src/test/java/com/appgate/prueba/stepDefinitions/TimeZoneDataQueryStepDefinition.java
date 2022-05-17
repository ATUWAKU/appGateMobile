package com.appgate.prueba.stepDefinitions;

import com.appgate.prueba.exceptions.ConsultTimeZoneException;
import com.appgate.prueba.questions.Information;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.appgate.prueba.exceptions.ConsultTimeZoneException.MSGCONSTIZONEXCP;
import static com.appgate.prueba.userInterfaces.Coordinates.SEND_BUTTON;
import static com.appgate.prueba.utils.constants.General.YISUS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;

public class TimeZoneDataQueryStepDefinition {

    @Before
    public void setup(){
        setTheStage(new OnlineCast());
    }

    @When("Consult the time zone information")
    public void consultTheTimeZoneInformation() {
        theActorCalled(YISUS).attemptsTo(
                Click.on(SEND_BUTTON)
        );
    }
    @Then("The APP displays the information")
    public void theAPPDisplaysTheInformation() {
        theActorInTheSpotlight().should(seeThat(
                Information.appear(), equalTo(true)
        ).orComplainWith(ConsultTimeZoneException.class, MSGCONSTIZONEXCP));
    }
}
