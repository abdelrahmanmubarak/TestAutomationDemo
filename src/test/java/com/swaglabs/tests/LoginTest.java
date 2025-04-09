package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.AllureUtils;
import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.FilesUtils;
import com.swaglabs.utils.ScreenshotsUtils;
import org.testng.annotations.*;

import java.io.File;

public class LoginTest {

    // variables
    File allure_results = new File("test-outputs/allure-results");

    // tests
    @Test
    public void successfulLogin(){
        new LoginPage(DriverManager.getDriver()).enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginBtn()
                .assertSuccessfulLogin();
                ScreenshotsUtils.takeScreenshot("successful-Login");




    }
    // configurations
    @BeforeSuite
    public void beforeSuite(){
        FilesUtils.deleteFiles(allure_results);
    }
    @BeforeMethod
    public void setUp(){
         DriverManager.createInstance("edge");
        new LoginPage(DriverManager.getDriver()).navigateToLoginPage();

    }

    @AfterMethod
    public void tearDown(){
        BrowserActions.closeBrowser(DriverManager.getDriver());
    }
    @AfterClass
    public void afterClass(){
        AllureUtils.attachLogsToAllureReport();
    }
}
