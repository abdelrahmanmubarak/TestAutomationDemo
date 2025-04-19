package com.swaglabs.pages;

import com.swaglabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {

    // variables
    private WebDriver driver;
    // constructor
    public OverviewPage(WebDriver driver){
        this.driver = driver;
    }
    // locators
    private final By finishButton = By.id("finish");

    // actions
    public ConfirmationPage clickOnFinishButton(){
        ElementActions.clickElement(driver,finishButton);
        return new ConfirmationPage(driver);
    }

    // validations
}
