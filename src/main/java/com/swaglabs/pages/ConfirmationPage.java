package com.swaglabs.pages;

import com.swaglabs.utils.ElementActions;
import com.swaglabs.utils.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    //variables
    private WebDriver driver;
    // constructor
    public ConfirmationPage(WebDriver driver){
        this.driver = driver;
    }
    // locators
    private final By confirmationMessage = By.cssSelector(".complete-header");

    // actions
    @Step("Get confirmation Message")
    public String getConformationMessage(){
        return ElementActions.getText(driver,confirmationMessage);
    }

    // validations
    @Step("Assert on Confirmation Message")
    public void assertConfirmationMessage(String expectedMessage){
        String actualMessage = getConformationMessage();
        Validations.validateEquals(actualMessage,expectedMessage,"Confirmation Message mismatch");
    }
}
