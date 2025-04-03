package com.swaglabs.utils;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions(){

    }
    public static void navigateToUrl(WebDriver driver, String url){
        driver.get(url);
    }

    public static String getCurrentUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }
}
