package webstuarant.com.utlities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {
    }
    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            synchronized (Driver.class) {

                String browser = ConfigurationReader.getProperty("browser");

                switch (browser) {



                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                         driver=new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                         driver=new FirefoxDriver();
                        break;

                }

            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //This same driver will be returned every time we call Driver.getDriver() method
        return driver;

    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver=null;
        }
    }


}