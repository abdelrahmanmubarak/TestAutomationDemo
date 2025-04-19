package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.listeners.TestNGListeners;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.JsonUtils;
import com.swaglabs.utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class UserFlowTC {

    // variables
    WebDriver driver;
    JsonUtils testData;



    @Test
    public void userFlow(){
        new LoginPage(DriverManager.getDriver()).enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLoginBtn()
                .assertSuccessfulLogin()
                .takeScreenshot("Step1-Login") // Take screenshot after login
                .addSpecificItemToCart(testData.getJsonData("product-names.item1.name"))
                .assertProductAddedToCart(testData.getJsonData("product-names.item1.name"))
                .takeScreenshot("Step2-AddItemToCart") // Take screenshot after adding item to cart

                .clickOnCartIcon()
                .assertProductDetails(testData.getJsonData("product-names.item1.name"), testData.getJsonData("product-names.item1.price"))
                .clickCheckoutButton()
                .fillInformationForm(testData.getJsonData("information-form.firstName"),
                        testData.getJsonData("information-form.lastName"),
                        testData.getJsonData("information-form.postalCode"))
                .assertInformationPage(testData.getJsonData("information-form.firstName"),
                        testData.getJsonData("information-form.lastName"),
                        testData.getJsonData("information-form.postalCode"))
                .clickContinueButton()
                .clickOnFinishButton()
                .assertConfirmationMessage(testData.getJsonData("confirmation-message"));

    }
    // configurations
    @BeforeClass
    public void beforeClass(){
        testData = new JsonUtils("test-data");

    }

    @BeforeMethod(alwaysRun = true)
    public void setUP(){

        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver = DriverManager.createInstance(browserName);
        new LoginPage(DriverManager.getDriver()).navigateToLoginPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        BrowserActions.closeBrowser(driver);
    }

}
