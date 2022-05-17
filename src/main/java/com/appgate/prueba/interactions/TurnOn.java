package com.appgate.prueba.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

import java.time.Duration;

import static com.appgate.prueba.userInterfaces.Coordinates.GPS_ON_BUTTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TurnOn implements Interaction {
    public static Performable gps() {
        return instrumented(TurnOn.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(GPS_ON_BUTTO.waitingForNoMoreThan(Duration.ofSeconds(3)).isVisibleFor(actor))
                        .andIfSo(
                                Click.on(GPS_ON_BUTTO)
                        )
        );

    }
}
