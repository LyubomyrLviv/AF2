package pageobjects;

import actions.Action;
import base.BaseClass;
import org.openqa.selenium.By;

public class ProductProfilePage extends BaseClass {

    By addTCartProductPage = By.id("add-to-cart-sauce-labs-backpack");

    LoginPage loginPage;
    ProductsListPage productsListPage;


    public void addToCartFromProductP()
    {
        loginPage = new LoginPage();
        productsListPage = new ProductsListPage();
        productsListPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        productsListPage.goToProductProfile();
        Action.click(driver, addTCartProductPage);
    }
}
