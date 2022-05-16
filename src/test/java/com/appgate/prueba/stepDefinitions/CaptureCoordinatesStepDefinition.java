package com.appgate.prueba.stepDefinitions;

import com.appgate.prueba.exceptions.CoordinateQueryException;
import com.appgate.prueba.interactions.Grant;
import com.appgate.prueba.questions.Coordinates;
import com.appgate.prueba.questions.System;
import com.appgate.prueba.tasks.Request;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static com.appgate.prueba.utils.constants.General.YISUS;
import static com.appgate.prueba.utils.enums.Permisions.LOCATION;
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

//    @Given("Grant permissions in the location of the cell phone")
//    public void grantPermissionsInTheLocationOfTheCellPhone() {
//        actor.wasAbleTo(
//                Grant.permission(LOCATION).with(driver)
//        );
//    }
}
