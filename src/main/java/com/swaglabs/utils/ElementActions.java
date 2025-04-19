package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {
    private ElementActions(){

    }
    // send keys
    @Step("Sending data: {data} to the element: {locator}")
    public static void sendData(WebDriver driver, By locator, String data){
        Waits.waitForElementVisible(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        driver.findElement(locator).sendKeys(data);
        LogsUtil.info("Data entered: " + data, "in the field:",locator.toString());
    }
        @Step("Clicking on element: {locator}")
    public static void clickElement(WebDriver driver, By locator){
        Waits.waitForElementVisible(driver,locator);
        Scrolling.scrollToElement(driver, locator);
        driver.findElement(locator).click();
        LogsUtil.info("Clicked on element: " + locator.toString());

    }
    @Step("Getting text from the element: {locator}")
    public static String getText(WebDriver driver, By locator){
        Waits.waitForElementVisible(driver,locator);
        Scrolling.scrollToElement(driver, locator);
        LogsUtil.info(" Getting Text from the element: " + locator.toString() + " is: " + driver.findElement(locator).getText());
        return driver.findElement(locator).getText();
    }

    public static WebElement findElement(WebDriver driver, By locator){
        LogsUtil.info("Finding element: " + locator.toString());
        return driver.findElement(locator);
    }
    public static String getTextFromInput(WebDriver driver, By locator){
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        LogsUtil.info("getting text from the input field ", locator.toString(),"Text: ", findElement(driver,locator).getDomAttribute("value"));
        return findElement(driver, locator).getDomAttribute("value");
    }
}
