package com.appgate.prueba.tasks;

import com.appgate.prueba.interactions.TurnOn;
import com.appgate.prueba.interactions.Verify;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

import java.time.Duration;

import static com.appgate.prueba.userInterfaces.Coordinates.CONSULT_COORDINATES_BUTTON;
import static com.appgate.prueba.userInterfaces.Coordinates.GRANT_PERMI_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Request implements Task {
    public static Performable coordinates() {
        return instrumented(Request.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                TurnOn.gps(),
                Click.on(CONSULT_COORDINATES_BUTTON),
                Verify.permissions()
        );
    }
}
