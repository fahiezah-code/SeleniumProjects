package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private final By storeMenuLink = By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public StorePage navigateToStoreUsingMenu(){
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }
    public HomePage load(){
       super.load("/");
      wait.until(ExpectedConditions.titleContains("AskOmDch"));
       return this;
    }
}
