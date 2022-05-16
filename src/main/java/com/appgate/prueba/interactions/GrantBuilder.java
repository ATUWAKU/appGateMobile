package com.appgate.prueba.interactions;

import com.appgate.prueba.utils.enums.Permisions;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Performable;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GrantBuilder {

    Permisions permision;

    public GrantBuilder(Permisions permision) {
        this.permision = permision;
    }

    public Performable with(WebDriver driver) {
        return instrumented(Grant.class, permision, driver);
    }
}
