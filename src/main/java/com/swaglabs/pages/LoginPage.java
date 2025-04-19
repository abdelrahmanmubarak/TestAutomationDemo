package com.swaglabs.pages;

import com.swaglabs.utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.swaglabs.utils.PropertiesUtils.getPropertyValue;

public class LoginPage {

    // locators
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test=\"error\"]");


    // Navigate to login page
    @Step("Navigate to login page")
    public void navigateToLoginPage(){
        BrowserActions.navigateToUrl(driver,"https://www.saucedemo.com/");
    }
    // actions > wait-scroll-find-action
    @Step("Enter username: {username}")
    public LoginPage enterUsername(String username){
        ElementActions.sendData(driver,this.username,username);
        return this;
    }
    @Step("Enter password: {password}")
    public LoginPage enterPassword(String password){
        ElementActions.sendData(driver,this.password,password);
        return this;
    }
    @Step("Click Login button")
    public LoginPage clickLoginBtn(){
        ElementActions.clickElement(driver,loginBtn);
        return this;
    }
    @Step("Get error message")
    public String getErrorMessage(){
        return ElementActions.getText(driver,errorMessage);
    }


    // validations
    @Step("Assert login page url")
    public LoginPage assertLoginPageUrl(){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentUrl(driver),getPropertyValue("homeURL"),"URL is not as expected");
        return this;
    }
    @Step("Assert login page title")
    public LoginPage assertLoginPageTitle(){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getPageTitle(driver),getPropertyValue("appTitle"),"Title is not as expected");
        return this;
    }
    @Step("Assert successful login")
    public HomePage assertSuccessfulLogin(){
        Validations.validatePageUrl(driver, getPropertyValue("homeURL"));
        return new HomePage(driver);

    }
    @Step("Assert unsuccessful login")
    public HomePage assertUnsuccessfulLogin(){
        Validations.validateEquals(getErrorMessage(),getPropertyValue("errorMSG"), "Error message is not as expected");

        return new HomePage(driver);


    }



















}
