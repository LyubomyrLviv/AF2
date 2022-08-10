package pageobjects;

import actions.Action;
import base.BaseClass;
import org.openqa.selenium.By;

public class LoginPage extends BaseClass {

By userName = By.id("user-name");
By userPassword = By.id("password");
By loginButton = By.id("login-button");
By imageLoginPage = By.cssSelector("#root > div > div.login_wrapper > div.login_wrapper-inner > div.bot_column");


    public boolean validateLogo()
    {
       return Action.isDisplayed(driver,imageLoginPage);
    }

    public String getMyStoreTitle()
    {
        String myStoreTitle = driver.getTitle();
        return myStoreTitle;
    }

    public String getLoginPageUrl()
    {
        String currentLoginPageUrl = driver.getCurrentUrl();
        return currentLoginPageUrl;
    }

    public ProductsListPage login (String uname, String pswd)
    {
        Action.type(userName, uname);
        Action.type(userPassword, pswd);
        Action.click(driver, loginButton);
        return new ProductsListPage();


    }






}
