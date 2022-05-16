package com.appgate.prueba.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/Features/CaptureCoordinates.feature",
        glue = "com.appgate.prueba.stepDefinitions",
        tags = "@PermissionsGranted",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class CaptCoorWithPermiRunner {
}
