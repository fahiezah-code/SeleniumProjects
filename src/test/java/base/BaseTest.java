package base;

import factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUpDriver(String browser){
        driver = new DriverManager().initializeDriver(browser);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
