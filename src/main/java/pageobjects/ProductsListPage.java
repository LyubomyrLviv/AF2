package pageobjects;

import actions.Action;
import base.BaseClass;
import org.openqa.selenium.By;

public class ProductsListPage extends BaseClass {

    By logoutBtn = By.id("logout_sidebar_link");
    By sideBarMenu = By.id("react-burger-menu-btn");
    By addCart = By.id("add-to-cart-sauce-labs-backpack");
    By product = By.id("item_4_title_link");

    LoginPage loginPage;
    ProductsListPage productsListPage;


    public String getCurUrl()
    {
        return getDriver().getCurrentUrl();
    }

    public void logout() throws InterruptedException {
        Action.click(getDriver(), sideBarMenu);
        Action.implicitWait(getDriver(), 2);
        Action.click(BaseClass.getDriver(), logoutBtn);
    }

    public void addToCart()
    {
        Action.click(BaseClass.getDriver(), addCart);
    }

    public ProductProfilePage goToProductProfile()
    {
        Action.click(BaseClass.getDriver(),product);
        return new ProductProfilePage();

    }









}
