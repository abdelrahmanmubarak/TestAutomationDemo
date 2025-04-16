package com.swaglabs.pages;

import com.swaglabs.utils.CustomSoftAssertion;
import com.swaglabs.utils.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationPage {

    //variables
    private WebDriver driver;

    //constructor
    public InformationPage(WebDriver driver){
        this.driver=driver;
    }

    //locators
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");

    //actions
    @Step("Fill Information Page")
    public InformationPage fillInformationForm(String firstName, String  lastName, String postalCode){
        ElementActions.sendData(driver,this.firstName,firstName);
        ElementActions.sendData(driver,this.lastName,lastName);
        ElementActions.sendData(driver,this.postalCode,postalCode);
        return this;
    }
    @Step("Click continue button")
    public InformationPage clickContinueButton(){
        ElementActions.clickElement(driver,continueButton);
        return this;
    }

    //validations
    @Step("Assert Information Page")
    public void assertInformationPage(String firstName, String lastName, String postalCode){
        CustomSoftAssertion.softAssertion.assertEquals(ElementActions.getText(driver,this.firstName),firstName);
        CustomSoftAssertion.softAssertion.assertEquals(ElementActions.getText(driver,this.lastName),lastName);
        CustomSoftAssertion.softAssertion.assertEquals(ElementActions.getText(driver,this.postalCode),postalCode);
    }
}
