package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.listeners.TestNGListeners;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.HomePage;
import com.swaglabs.pages.InformationPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


@Listeners(TestNGListeners.class)
public class E2e {

    // variables
    WebDriver driver;
    JsonUtils testData;

    // tests
    @Test
    public void successfulLogin(){
        new LoginPage(DriverManager.getDriver()).enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLoginBtn()
                .assertSuccessfulLogin();
    }

    @Test(dependsOnMethods = "successfulLogin")
    public void addingProductToCart(){
        new HomePage(driver).addSpecificItemToCart(testData.getJsonData("product-names.item1.name"))
                .assertProductAddedToCart(testData.getJsonData("product-names.item1.name"));
    }

    @Test(dependsOnMethods = "addingProductToCart")
    public void checkOutProduct(){
        new HomePage(driver).clickOnCartIcon()
                .assertProductDetails(testData.getJsonData("product-names.item1.name"), testData.getJsonData("product-names.item1.price") );

    }

    @Test(dependsOnMethods = "checkOutProduct")
    public void fillInformationForm(){
        new CartPage(driver).clickCheckoutButton()
                .fillInformationForm(testData.getJsonData("information-form.firstName"),
                        testData.getJsonData("information-form.lastName"),
                        testData.getJsonData("information-form.postalCode"))
                .assertInformationPage(testData.getJsonData("information-form.firstName"),
                        testData.getJsonData("information-form.lastName"),
                        testData.getJsonData("information-form.postalCode"));

    }
    // configurations
    @BeforeClass
    public void beforeClass(){

        testData = new JsonUtils("test-data");
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver = DriverManager.createInstance(browserName);
        new LoginPage(DriverManager.getDriver()).navigateToLoginPage();
    }

    @AfterClass
    public void tearDown(){
        BrowserActions.closeBrowser(driver);
    }
}
