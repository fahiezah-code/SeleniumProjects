package base;

import factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private void setDriver(WebDriver driver)
    { // private : only this class will set the driver
        this.driver.set(driver);
    }
    protected WebDriver getDriver(){ //protected: only inherits class will get access
        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUpDriver(@Optional String browser){
        //to run from command line pass browser, use System.getProperty
        browser = System.getProperty("browser",browser); // here"browser" is from Mvn command line, browser from TestNG.xml
       if(browser == null){
           browser = "CHROME";
       }
        setDriver(new DriverManager().initializeDriver(browser));
      //  System.out.println(Thread.currentThread().getId() +" , "+ getDriver());
        //every thread will come create new local driver for each TC
    }
    @AfterMethod
    public void tearDown(){
     getDriver().quit();
    }


}
