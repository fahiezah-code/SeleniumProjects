package base;

import factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){
        driver = new DriverManager().initializeDriver();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
