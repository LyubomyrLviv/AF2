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
       return Action.isDisplayed(getDriver(),imageLoginPage);
    }

    public String getMyStoreTitle()
    {
        String myStoreTitle = getDriver().getTitle();
        return myStoreTitle;
    }

    public String getLoginPageUrl()
    {
        String currentLoginPageUrl = getDriver().getCurrentUrl();
        return currentLoginPageUrl;
    }

    public ProductsListPage login (String uname, String pswd)
    {
        Action.type(userName, uname);
        Action.type(userPassword, pswd);
        Action.click(getDriver(), loginButton);
        return new ProductsListPage();


    }






}
