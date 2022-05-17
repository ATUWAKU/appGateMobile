package com.appgate.prueba.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Coordinates {

    public static final Target LATIN = Target.the("EditText of LatIn").located(By.id("mx.com.cdp.consumirws:id/txtLatIn"));
    public static final Target LNGIN = Target.the("EditText of LngIn").located(By.id("mx.com.cdp.consumirws:id/txtLngIn"));
    public static final Target CONSULT_COORDINATES_BUTTON = Target.the("Button that consults the current coordinates of the cell phone").located(By.id("mx.com.cdp.consumirws:id/btnConsGeo"));
    public static final Target CONTROL_MESSAGE = Target.the("Textview for the error message").located(By.id("mx.com.cdp.consumirws:id/txtMsg"));
    public static final Target SEND_BUTTON = Target.the("Button that consults the data of the time zone").located(By.id("mx.com.cdp.consumirws:id/btnEnviar"));
    public static final Target GRANT_PERMI_BUTTON = Target.the("button to grant permission").located(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
    public static final Target GPS_ON_BUTTO = Target.the("Button that turns on the GPS").located(By.id("android:id/button1"));
}
