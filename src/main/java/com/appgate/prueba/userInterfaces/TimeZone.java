package com.appgate.prueba.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TimeZone {

    public static final Target SUNRISE = Target.the("EditText of Sunrise").located(By.id("mx.com.cdp.consumirws:id/txtSunrise"));
    public static final Target LNG = Target.the("EditText of Lng").located(By.id("mx.com.cdp.consumirws:id/txtLng"));
    public static final Target COUNTRYCODE = Target.the("EditText of Countrycode").located(By.id("mx.com.cdp.consumirws:id/txtCountryCode"));
    public static final Target GMTOFFSET = Target.the("EditText of Gmtoffset").located(By.id("mx.com.cdp.consumirws:id/txtGmtOffset"));
    public static final Target RAWOFFSET = Target.the("EditText of Rawoffset").located(By.id("mx.com.cdp.consumirws:id/txtRawOffset"));
    public static final Target SUNSET = Target.the("EditText of Sunset").located(By.id("mx.com.cdp.consumirws:id/txtSunset"));
    public static final Target TIMEZONEID = Target.the("EditText of Timezoneid").located(By.id("mx.com.cdp.consumirws:id/txtTimezoneId"));
    public static final Target DSTOFFSET = Target.the("EditText of Dstoffset").located(By.id("mx.com.cdp.consumirws:id/txtDstOffset"));
    public static final Target COUNTRYNAME = Target.the("EditText of Countryname").located(By.id("mx.com.cdp.consumirws:id/txtCountryName"));
    public static final Target TIME = Target.the("EditText of Time").located(By.id("mx.com.cdp.consumirws:id/txtTime"));
    public static final Target LAT = Target.the("EditText of Lat").located(By.id("mx.com.cdp.consumirws:id/txtLat"));
    public static final Target RESET_BUTTON = Target.the("Reset button").located(By.id("mx.com.cdp.consumirws:id/btnStart"));

}
