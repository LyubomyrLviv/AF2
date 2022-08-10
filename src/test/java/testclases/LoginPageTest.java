package testclases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ProductsListPage;

public class LoginPageTest extends BaseClass {

    LoginPage loginPage;
    ProductsListPage productsListPage;

    //Browser start and stop
    @BeforeMethod
    public void setup() {
        lauchBrowser();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
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
        loginPage = new LoginPage();
        String actualTitle = loginPage.getMyStoreTitle();
        Assert.assertEquals(actualTitle, "Swag Labs");
    }

    @Test
    public void LoginPageTest()
    {
        loginPage = new LoginPage();
        productsListPage = new ProductsListPage();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        String actUrl = productsListPage.getCurUrl();
        String expUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actUrl, "https://www.saucedemo.com/inventory.html");
    }

}
