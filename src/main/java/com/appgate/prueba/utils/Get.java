package com.appgate.prueba.utils;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.webdriver.WebDriverFacade;

public class Get {

    public static AppiumDriver appiumDriver(){
        return  (AppiumDriver)((WebDriverFacade) Serenity.getDriver()).getProxiedDriver();
    }
}
