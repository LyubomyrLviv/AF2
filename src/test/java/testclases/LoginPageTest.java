package testclases;

import base.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ProductsListPage;
import utility.Log;
import utility.ReadXLSdata;


public class LoginPageTest extends BaseClass {

    LoginPage loginPage;
    ProductsListPage productsListPage;
//    Logger use latter
//    public static final Logger logger = LogManager.getLogger(LoginPageTest.class);


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

        loginPage = new LoginPage();
        String actualTitle = loginPage.getMyStoreTitle();
        Assert.assertEquals(actualTitle, "Swag Labs");
    }

    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "loginData")
    public void loginTest(String username, String pswd)
    {
        loginPage = new LoginPage();
        productsListPage = new ProductsListPage();
        //First way read data from properties file
//        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        loginPage.login(username, pswd);
        String actUrl = productsListPage.getCurUrl();
        String expUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actUrl, "https://www.saucedemo.com/inventory.html");
    }

//    //Example of DataProvider
//    @DataProvider(name="loginData")
//    public Object [][] loData()
//    {
//        return new Object[][]
//                {
//                        {"standard_user","secret_sauce"},
//                        {"locked_out_user","secret_sauce"}
//                };
//    }

}
