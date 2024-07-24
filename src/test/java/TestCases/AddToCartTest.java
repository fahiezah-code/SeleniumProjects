package TestCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.StorePage;


public class AddToCartTest extends BaseTest {


    @Test
    public void addToCartFromStorePage(){
        CartPage cartPage = new StorePage(getDriver())
                .load()
                .clickOnAddToCartBtn()
                .clickOnViewCartBtn();
        Assert.assertEquals(cartPage.getProductName(),"Blue Shoes");


    }
}


