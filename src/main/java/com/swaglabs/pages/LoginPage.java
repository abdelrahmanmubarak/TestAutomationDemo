package com.swaglabs.pages;

import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
    public void navigateToLoginPage(){
        BrowserActions.navigateToUrl(driver,"https://www.saucedemo.com/");
    }
    // actions > wait-scroll-find-action
    public LoginPage enterUsername(String username){
        ElementActions.sendData(driver,this.username,username);
        return this;
    }
    public LoginPage enterPassword(String password){
        ElementActions.sendData(driver,this.password,password);
        return this;
    }
    public LoginPage clickLoginBtn(){
        ElementActions.clickElement(driver,loginBtn);
        return this;
    }

    public String getErrorMessage(){
        return ElementActions.getText(driver,errorMessage);
    }


    // validations
    public LoginPage assertSuccessfulLogin(){
        Assert.assertEquals(BrowserActions.getCurrentUrl(driver),"https://www.saucedemo.com/inventory.html");
        return this;

    }

    public LoginPage assertUnsuccessfulLogin(){

        Assert.assertEquals(getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
        return this;

    }

















}
