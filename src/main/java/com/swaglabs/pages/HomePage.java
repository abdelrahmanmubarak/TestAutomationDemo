package com.swaglabs.pages;

import com.swaglabs.utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class HomePage {

    // variables
    private  WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    // locators
    private final By cartIcon = By.cssSelector("[data-test='shopping-cart-link']");

    // actions
    @Step("Navigate to HomePage")
    public HomePage navigateToHomePage(){
        BrowserActions.navigateToUrl(driver, PropertiesUtils.getPropertyValue("homeURL"));


        return this;
    }
    @Step("Add specific Product to cart")
    public HomePage addSpecificItemToCart(String productName){
        LogsUtil.info("adding Product " + productName + "to cart ");
        By addToCartButton = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='"+productName+"']"));
        ElementActions.clickElement(driver,addToCartButton);

        return this;
    }
    @Step("Click cart icon")
    public CartPage clickOnCartIcon(){
        ElementActions.clickElement(driver,cartIcon);
        return new CartPage(driver);
    }


    // validations
    @Step("Assert product added to cart")
    public HomePage assertProductAddedToCart(String productName){
        By addToCartButton = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='"+productName+"']"));
        String actualValue = ElementActions.getText(driver,addToCartButton);
        LogsUtil.info("Actual Value is " + actualValue);
        Validations.validateEquals(actualValue,"Remove","Product not added to Cart");
        LogsUtil.info(productName,"Added to cart successfully");
        return this;

    }

    @Step("Take screenshot: {screenshotName}")
    public HomePage takeScreenshot(String screenshotName) {
        ScreenshotsUtils.takeScreenshot(screenshotName);
        return this;
    }
}
