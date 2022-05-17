package com.appgate.prueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.appgate.prueba.userInterfaces.Coordinates.*;
import static com.appgate.prueba.userInterfaces.TimeZone.*;

public class Information implements Question<Boolean> {
    public static Information appear() {
        return new Information();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return
                SUNRISE.resolveFor(actor).getText().equals("") &&
                !LNG.resolveFor(actor).getText().equals("") &&
                !COUNTRYCODE.resolveFor(actor).getText().equals("") &&
                !GMTOFFSET.resolveFor(actor).getText().equals("") &&
                !RAWOFFSET.resolveFor(actor).getText().equals("") &&
                !SUNSET.resolveFor(actor).getText().equals("") &&
                !TIMEZONEID.resolveFor(actor).getText().equals("") &&
                !DSTOFFSET.resolveFor(actor).getText().equals("") &&
                !COUNTRYNAME.resolveFor(actor).getText().equals("") &&
                !TIME.resolveFor(actor).getText().equals("") &&
                !LAT.resolveFor(actor).getText().equals("") &&
                SUNRISE.resolveFor(actor).isVisible() &&
                LNG.resolveFor(actor).isVisible() &&
                COUNTRYCODE.resolveFor(actor).isVisible() &&
                GMTOFFSET.resolveFor(actor).isVisible() &&
                RAWOFFSET.resolveFor(actor).isVisible() &&
                SUNSET.resolveFor(actor).isVisible() &&
                TIMEZONEID.resolveFor(actor).isVisible() &&
                DSTOFFSET.resolveFor(actor).isVisible() &&
                COUNTRYNAME.resolveFor(actor).isVisible() &&
                TIME.resolveFor(actor).isVisible() &&
                LAT.resolveFor(actor).isVisible() &&
                RESET_BUTTON.resolveFor(actor).isVisible() &&
                !LATIN.resolveFor(actor).isVisible() &&
                !LNGIN.resolveFor(actor).isVisible() &&
                !CONSULT_COORDINATES_BUTTON.resolveFor(actor).isVisible() &&
                !SEND_BUTTON.resolveFor(actor).isVisible();







    }
}
