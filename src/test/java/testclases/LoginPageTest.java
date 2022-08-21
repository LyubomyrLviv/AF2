package testclases;

import base.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ProductsListPage;
import utility.Log;

public class LoginPageTest extends BaseClass {

    LoginPage loginPage;
    ProductsListPage productsListPage;

    public static final Logger logger = LogManager.getLogger(LoginPageTest.class);


    //Browser start and stop
    @BeforeMethod
    public void setup()
    {
        lauchBrowser();


    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @Test
    public void verifyLogo()
    {
        loginPage = new LoginPage();
        boolean result = loginPage.validateLogo();
        Assert.assertTrue(result);
    }

    @Test
    public void verifyTitleTest()
    {
        logger.info("Title verification test");
        loginPage = new LoginPage();
        String actualTitle = loginPage.getMyStoreTitle();
        Assert.assertEquals(actualTitle, "Swag Labs");
    }

    @Test
    public void LoginTest()
    {
        loginPage = new LoginPage();
        productsListPage = new ProductsListPage();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        String actUrl = productsListPage.getCurUrl();
        String expUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actUrl, "https://www.saucedemo.com/inventory.html");
    }

}
