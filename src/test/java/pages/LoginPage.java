package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By feelingLuckyBtn = By.xpath("(//input[@class='RNmpXc'])[2]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public String clickOnFeelingLuckyBtn(){
        driver.findElement(feelingLuckyBtn).click();
       String title = driver.getTitle();
       return title;
    }
}
