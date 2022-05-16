package com.appgate.prueba.stepDefinitions;

import com.appgate.prueba.exceptions.CoordinateQueryException;
import com.appgate.prueba.questions.Coordinates;
import com.appgate.prueba.questions.System;
import com.appgate.prueba.tasks.Request;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.appgate.prueba.utils.constants.General.YISUS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class CaptureCoordinatesStepDefinition {



    @Before
    public void setup(){
        setTheStage(new OnlineCast());
    }

    @When("Request the coordinates")
    public void RequestTheCoordinates() {
        theActorCalled(YISUS).attemptsTo(
                Request.coordinates()

        );
    }
    @Then("The system displays latitude and longitude of the current location")
    public void theSystemDisplaysLatitudeAndLongitudeOfTheCurrentLocation() {
        theActorInTheSpotlight().should(seeThat(
                Coordinates.appear(), x -> x.equals(true)
        ).orComplainWith(CoordinateQueryException.class));
    }
    @Then("The APP shows the error message {string}")
    public void theAPPShowsAnErrorMessage(String errorMsg) {
        theActorInTheSpotlight().should(seeThat(
                System.show(errorMsg), x -> x.equals(true)
        ).orComplainWith(CoordinateQueryException.class));
    }
}
