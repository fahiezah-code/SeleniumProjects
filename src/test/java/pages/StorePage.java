package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {

    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartLink = By.cssSelector("a[title='View cart]");
    private final By addToCartBtn = By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']");
    private final By viewCartBtn = By.xpath("//a[@title='View cart']");


    public StorePage(WebDriver driver) {
        super(driver);
    }
    private StorePage enterTextInSearchFld(String txt){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFld)).sendKeys(txt);
        return this;
    }
    public StorePage load(){
        load("/store");
        return this;
    }

    public StorePage search(String txt){
        enterTextInSearchFld(txt).clickSearchBtn();
        return this;
    }
    public StorePage clickSearchBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        return this;
    }
    public String getTitle(){
       return driver.findElement(title).getText();

    }
    public StorePage getSearchTitle(){
        wait.until(ExpectedConditions.urlContains("=Blue&post_type=product"));
        return this;
    }
    public StorePage clickOnAddToCartBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        return this;
    }
    public CartPage clickOnViewCartBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
        return new CartPage(driver);
    }

}
