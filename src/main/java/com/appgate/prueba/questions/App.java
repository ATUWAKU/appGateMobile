package com.appgate.prueba.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.appgate.prueba.userInterfaces.Coordinates.*;
import static com.appgate.prueba.userInterfaces.TimeZone.*;

public class App implements Question<Boolean> {
    public static App isReset() {
        return new App();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return
                !LATIN.resolveFor(actor).isVisible() &&
                LNGIN.resolveFor(actor).isVisible() &&
                LATIN.resolveFor(actor).getText().equals("") &&
                LNGIN.resolveFor(actor).getText().equals("") &&
                CONSULT_COORDINATES_BUTTON.resolveFor(actor).isVisible() &&
                !SUNRISE.resolveFor(actor).isVisible() &&
                !LNG.resolveFor(actor).isVisible() &&
                !COUNTRYCODE.resolveFor(actor).isVisible() &&
                !GMTOFFSET.resolveFor(actor).isVisible() &&
                !RAWOFFSET.resolveFor(actor).isVisible() &&
                !SUNSET.resolveFor(actor).isVisible() &&
                !TIMEZONEID.resolveFor(actor).isVisible() &&
                !DSTOFFSET.resolveFor(actor).isVisible() &&
                !COUNTRYNAME.resolveFor(actor).isVisible() &&
                !TIME.resolveFor(actor).isVisible() &&
                !LAT.resolveFor(actor).isVisible() &&
                !SEND_BUTTON.resolveFor(actor).isVisible() &&
                !RESET_BUTTON.resolveFor(actor).isVisible();





    }
}
