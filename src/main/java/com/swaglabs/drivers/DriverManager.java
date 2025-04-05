package com.swaglabs.drivers;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class DriverManager {

    private DriverManager(){
        super();
    }

    private static final ThreadLocal<WebDriver> driverThreadLocal =  new ThreadLocal<>();

    public static WebDriver createInstance(String browserName){
       WebDriver driver = BrowserFactory.getBrowser(browserName);
       setDriver(driver);
       return getDriver();
    }

    public static WebDriver getDriver(){
        if (driverThreadLocal.get()==null){
            fail("Driver is null");
        }
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver){
         driverThreadLocal.set(driver);
    }


}
