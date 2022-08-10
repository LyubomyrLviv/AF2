package testclases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ProductsListPage;

public class ProductListPageTest extends BaseClass {

    ProductsListPage productsListPage;
    LoginPage loginPage;

    //Prepare browser and data
    @BeforeMethod
    public void setup() {lauchBrowser();}
    @AfterMethod
    public void tearDown() {driver.quit();}


    @Test
    public void logOutTest() throws InterruptedException {
        productsListPage = new ProductsListPage();
        loginPage = new LoginPage();
        loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        productsListPage.logout();
        String cLoginPageUrl = loginPage.getLoginPageUrl();
        String actLoginPageUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(cLoginPageUrl, actLoginPageUrl);
    }

    @Test
    public void addToCart()
    {
        productsListPage = new ProductsListPage();
        loginPage = new LoginPage();
        loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        productsListPage.addToCart();
    }



}
