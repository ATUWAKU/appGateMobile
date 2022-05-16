package com.appgate.prueba.interactions;

import com.appgate.prueba.utils.Get;
import com.appgate.prueba.utils.enums.Permisions;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Grant implements Interaction {

    Permisions permision;
    WebDriver driver;

    public Grant(Permisions permision, WebDriver driver) {
        this.permision = permision;
        this.driver = driver;
    }

    public static GrantBuilder permission(Permisions permision) {
        return new GrantBuilder(permision);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (permision){
            case LOCATION:
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("appium:autoGrantPermissions ",true);
                capabilities.setCapability("appium:automationName ","UiAutomator2");
                //capabilities.setCapability("hub ","http://127.0.0.1:4723/wd/hub");
                capabilities.setCapability("appium:platformName ","android");
                capabilities.setCapability("appium:platformVersion ","12");
                capabilities.setCapability("appium:deviceName  ","R5CRA1J9APL");
                capabilities.setCapability("appium:appPackage ","mx.com.cdp.consumirws");
                capabilities.setCapability("appium:appActivity ","MainActivity");
                capabilities.setCapability("appium:noReset ",false);
                capabilities.setCapability("appium:autoAcceptAlerts ",true);
                capabilities.setCapability("appium:newCommandTimeout ","1000");

                try {
                    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
