package com.swaglabs.utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {

    private Validations(){

    }
    public  static void validateTrue(Boolean condition, String message){
        Assert.assertTrue(condition,message);
    }
    public  static void validateFalse(Boolean condition, String message){
        Assert.assertFalse(condition,message);
    }
     public static void validateEquals(String actual, String expected, String message){
        Assert.assertEquals(actual,expected,message);
     }

    public static void validateNotEquals(String actual, String expected, String message){
        Assert.assertNotEquals(actual,expected,message);
    }

    public static void validatePageUrl(WebDriver driver, String expected){
        Assert.assertEquals(BrowserActions.getCurrentUrl(driver), expected);
    }

    public static void validatePageTitle(WebDriver driver, String expected){
        Assert.assertEquals(BrowserActions.getPageTitle(driver), expected);
    }


}
