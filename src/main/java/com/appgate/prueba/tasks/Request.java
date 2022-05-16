package com.appgate.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.appgate.prueba.userInterfaces.Coordinates.CONSULT_COORDINATES_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Request implements Task {
    public static Performable coordinates() {
        return instrumented(Request.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CONSULT_COORDINATES_BUTTON)
        );
    }
}
