package com.swaglabs.drivers;

import com.swaglabs.utils.LogsUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class DriverManager {

    private DriverManager(){
        super();
    }

    private static final ThreadLocal<WebDriver> driverThreadLocal =  new ThreadLocal<>();

    @Step("Create instance of browser started on : {browserName}")
    public static WebDriver createInstance(String browserName){
       WebDriver driver = BrowserFactory.getBrowser(browserName);
       LogsUtil.info("Browser is created","Browser Name: "+browserName);
       setDriver(driver);
       return getDriver();
    }

    public static WebDriver getDriver(){
        if (driverThreadLocal.get()==null){
            LogsUtil.error("Driver is null");
            fail("Driver is null");
        }
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver){
         driverThreadLocal.set(driver);
    }


}
