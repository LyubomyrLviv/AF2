package testclases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ProductsListPage;

public class ProductListPageTest extends BaseClass {

    ProductsListPage productsListPage;
    LoginPage loginPage;

//    Browser start and stop and parameter to read browser from the xml file
    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Regression"})
    public void setup(String browser)
    {
        lauchBrowser(browser);
    }
    @AfterMethod(groups = {"Smoke","Regression"})
    public void tearDown() {getDriver().quit();}


    @Test(groups = {"Regression"})
    public void logOutTest() throws InterruptedException {
        productsListPage = new ProductsListPage();
        loginPage = new LoginPage();
        loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        productsListPage.logout();
        String cLoginPageUrl = loginPage.getLoginPageUrl();
        String actLoginPageUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(cLoginPageUrl, actLoginPageUrl);
    }

    @Test(groups = {"Regression"})
    public void addToCart()
    {
        productsListPage = new ProductsListPage();
        loginPage = new LoginPage();
        loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        productsListPage.addToCart();
    }



}
