package com.appgate.prueba.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

import java.time.Duration;

import static com.appgate.prueba.userInterfaces.Coordinates.CONSULT_COORDINATES_BUTTON;
import static com.appgate.prueba.userInterfaces.Coordinates.GRANT_PERMI_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Verify implements Interaction {
    public static Performable permissions() {
        return instrumented(Verify.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Check.whether(GRANT_PERMI_BUTTON.waitingForNoMoreThan(Duration.ofSeconds(3)).isVisibleFor(actor)).andIfSo(
                Click.on(GRANT_PERMI_BUTTON),
                Click.on(CONSULT_COORDINATES_BUTTON)
        ));
    }
}
