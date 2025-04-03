package com.swaglabs.tests;

import com.swaglabs.pages.LoginPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    // variables

    private WebDriver driver;
    // tests
    @Test
    public void successfulLogin(){
        new LoginPage(driver).enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginBtn()
                .assertSuccessfulLogin();

    }
    // configurations

    @BeforeMethod
    public void setUp(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("start-maximized");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);
        new LoginPage(driver).navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
