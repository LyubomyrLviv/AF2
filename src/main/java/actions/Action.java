package actions;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action extends BaseClass {

    public static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    public static void click(WebDriver driver, By ele)
    {
        driver.findElement(ele).click();
    }

    public static boolean findElement(WebDriver driver, By ele) {
        boolean flag = false;
        try {
            getDriver().findElement(ele).isDisplayed();
            flag = true;
        } catch (Exception e) {
            // System.out.println("Location not found: "+locatorName);
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully Found element at");

            } else {
                System.out.println("Unable to locate element at");
            }
        }
        return flag;
    }

    public static boolean isDisplayed(WebDriver driver, By ele) {

           boolean flag;
           flag = driver.findElement(ele).isDisplayed();
              if (flag) {
                   System.out.println("Successfully Found element at");

              } else {
                   System.out.println("Unable to locate element at");
             }

        return flag;
    }

    public static boolean type(By ele, String text) {
        boolean flag = false;
        try {
            flag = getDriver().findElement(ele).isDisplayed();
            getDriver().findElement(ele).clear();
            getDriver().findElement(ele).sendKeys(text);
            // logger.info("Entered text :"+text);
            flag = true;
        } catch (Exception e) {
            System.out.println("Location Not found");
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully entered value");
            } else {
                System.out.println("Unable to enter value");
            }

        }
        return flag;
    }

    public static void implicitWait(WebDriver driver, int timeOut) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }



    }
