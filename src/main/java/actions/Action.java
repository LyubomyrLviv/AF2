package actions;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class Action extends BaseClass {

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



    }
