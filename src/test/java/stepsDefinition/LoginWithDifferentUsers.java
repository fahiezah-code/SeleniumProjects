package stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginWithDifferentUsers {

    WebDriver driver;
    @Given("User is on login page")
    public void userIsOnLoginPage() {
        WebDriverManager.chromedriver().cachePath("Drivers").setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/v1");

    }


    @When("User enters valid {string} and {string}")
    public void userEntersValidAnd(String username, String password) {

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("Clicks on Login Button")
    public void clicksOnLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User is navigated to Home page")
    public void userIsNavigatedToHomePage() {
      String title =  driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Swag Labs");

    }
    @And("close the browser")
    public void closeBrowser(){
        driver.quit();
    }



}
