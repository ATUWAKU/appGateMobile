package com.appgate.prueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.appgate.prueba.userInterfaces.Coordinates.*;
import static com.appgate.prueba.userInterfaces.TimeZone.*;

public class System implements Question<Boolean> {

    private  String errorMsg;
    public System(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static System show(String errorMsg) {
        return new System(errorMsg);
    }



    @Override
    public Boolean answeredBy(Actor actor) {
        return LATIN.resolveFor(actor).isVisible() &&
               LNGIN.resolveFor(actor).isVisible() &&
               CONTROL_MESSAGE.resolveFor(actor).isVisible() &&
               CONTROL_MESSAGE.resolveFor(actor).getText().equals(errorMsg) &&
               CONSULT_COORDINATES_BUTTON.resolveFor(actor).isVisible();




    }
}
