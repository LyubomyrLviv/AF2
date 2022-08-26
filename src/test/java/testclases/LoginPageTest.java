package testclases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.LoginPage;
import pageobjects.ProductsListPage;
import utility.ReadXLSdata;


public class LoginPageTest extends BaseClass {

    LoginPage loginPage;
    ProductsListPage productsListPage;
//    Logger use latter
//    public static final Logger logger = LogManager.getLogger(LoginPageTest.class);


    //Browser start and stop and parameter to read browser from the xml file
    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Regression"})
    public void setup(String browser)
    {
        lauchBrowser(browser);
    }


    @AfterMethod(groups = {"Smoke","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = {"Smoke"})
    public void verifyLogo()
    {
        loginPage = new LoginPage();
        boolean result = loginPage.validateLogo();
        Assert.assertTrue(result);
    }

    @Test(groups = {"Smoke"})
    public void verifyTitleTest()
    {
        loginPage = new LoginPage();
        String actualTitle = loginPage.getMyStoreTitle();
        Assert.assertEquals(actualTitle, "Swag Labs");
    }

    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "loginData", groups = {"Smoke"})
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
