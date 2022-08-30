package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utility.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static Properties prop;

    //public static WebDriver driver;

    public static FileInputStream fis;

    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();


    public static WebDriver getDriver()
    {
        //Get Driver from thread localmap
        return driver.get();
    }



    @BeforeTest(groups = {"Smoke","Regression"})
    public void loadConfig() throws IOException
    {

        prop = new Properties();
        fis = new FileInputStream(System.getProperty("user.dir")+"/configurations/config.properties");
        prop.load(fis);
    }
    //Parameters was added in scope of multi browser testing

    public void lauchBrowser(String browserName)
    {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
//        String browserName = prop.getProperty("browser");

        if (browserName.contains("chrome"))
        {
            //driver = new ChromeDriver();
            //Changes for threads
            driver.set(new ChromeDriver());
        }
        else if (browserName.equals("firefox"))
        {
            //driver = new FirefoxDriver();
            //Changes for threads
            driver.set(new FirefoxDriver());
        }

            getDriver().manage().window().maximize();
            getDriver().get(prop.getProperty("url"));

    }



}
