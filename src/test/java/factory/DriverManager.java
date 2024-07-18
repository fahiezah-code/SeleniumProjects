package factory;

import constants.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    /*      here if we want to run different browser, we need to change code here as below
        public WebDriver initializeDriver(){
      // WebDriverManager.chromedriver().cachePath("Drivers").setup();
        WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
      //  WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
 */

    public WebDriver initializeDriver(){
        WebDriver driver;
        //to run from command line pass browser, use System.getProperty
        String browser = System.getProperty("browser", "CHROME");
        switch (DriverType.valueOf(browser)){
            case CHROME : //to control anyUppercase or lCase,
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX :
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
                break;
            default: throw new IllegalStateException("Invalid browser name "+browser);

        }

        // 1. can use change to lowercase, switch (browser.toLowerCase())
        // 2. use ENUM -> enforce to use

        //

        driver.manage().window().maximize();
        return driver;
    }




}
