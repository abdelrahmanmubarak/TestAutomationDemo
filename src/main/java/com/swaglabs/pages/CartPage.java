package com.swaglabs.pages;

import com.swaglabs.utils.CustomSoftAssertion;
import com.swaglabs.utils.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    // variables
    private WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    // Locators
    private final By productName = By.cssSelector(".inventory_item_name");
    private final By productPrice = By.cssSelector(".inventory_item_price");
    private final By checkoutButton = By.cssSelector("button[data-test='checkout']");

    // Actions
    @Step("get the product name")
    public String getProductName(){
        return ElementActions.getText(driver,productName);
    }
    @Step("get the product price")
    public String getProductPrice(){
        return ElementActions.getText(driver,productPrice);
    }
    @Step("click checkout button")
    public InformationPage clickCheckoutButton(){
        ElementActions.clickElement(driver,checkoutButton);
        return new InformationPage(driver);
    }

    // Validations
    @Step("Assert product details")
    public CartPage assertProductDetails(String productName, String productPrice){
       String actualProductName = getProductName();
       String actualProductPrice = getProductPrice();
        CustomSoftAssertion.softAssertion.assertEquals(actualProductName,productName,"Product name mismatch");
        CustomSoftAssertion.softAssertion.assertEquals(actualProductPrice,productPrice,"Product Price mismatch");
        return this;
    }






}
