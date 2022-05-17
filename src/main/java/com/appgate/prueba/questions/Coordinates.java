package com.appgate.prueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.appgate.prueba.userInterfaces.Coordinates.*;

public class Coordinates implements Question<Boolean> {
    public static Coordinates appear() {
        return new Coordinates();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return  !LATIN.resolveFor(actor).isVisible() &&
                !LATIN.resolveFor(actor).getText().equals("") &&
                LNGIN.resolveFor(actor).isVisible() &&
                !LNGIN.resolveFor(actor).getText().equals("") &&
                SEND_BUTTON.resolveFor(actor).isVisible();



    }
}
