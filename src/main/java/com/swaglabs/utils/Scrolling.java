package com.swaglabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scrolling {
    private Scrolling(){

    }

    // Scroll to Element
    public static void scrollToElement(WebDriver driver, By locator){
        // code
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(locator));
    }
}
