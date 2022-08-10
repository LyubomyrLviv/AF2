package pageobjects;

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
        return driver.getCurrentUrl();
    }







}