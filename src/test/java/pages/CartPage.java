package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private final By cartTitle = By.xpath("//h1[normalize-space()='Cart']");
    private final By productName = By.xpath("//a[normalize-space()='Blue Shoes']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage getViewCartUrl(){
         wait.until(ExpectedConditions.urlContains("cart"));
        return this;
    }
    public String getProductName(){
        return driver.findElement(productName).getText();
    }

}
