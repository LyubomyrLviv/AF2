package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static Properties prop;

    public static WebDriver driver;

    public static FileInputStream fis;


    @BeforeTest
    public void loadConfig() throws IOException
    {
        prop = new Properties();
        fis = new FileInputStream(System.getProperty("user.dir")+"configurations/config.properties");
        prop.load(fis);
    }


    public void lauchBrowser()
    {
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");

        if (browserName.contains("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if (browserName.equals("firefox"))
        {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));

    }



}
