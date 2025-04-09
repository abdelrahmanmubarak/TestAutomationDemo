package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions(){
    }

    @Step( "Navigating to URL: {url}")
    public static void navigateToUrl(WebDriver driver, String url){
        driver.get(url);
        LogsUtil.info("Navigated to URL: " + url);
    }

    public static String getCurrentUrl(WebDriver driver){
        LogsUtil.info("Current URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    @Step( "Getting Page Title")
    public static String getPageTitle(WebDriver driver){
        LogsUtil.info("Page Title: " + driver.getTitle());
        return driver.getTitle();
    }
    @Step( "Refreshing the page")
    public static void refreshPage(WebDriver driver){
        LogsUtil.info("Refreshing the page");
         driver.navigate().refresh();
    }
    //close Browser
    @Step( "Closing the browser")
    public static void closeBrowser(WebDriver driver){
        LogsUtil.info("Closing the browser");
        driver.quit();
    }


}
