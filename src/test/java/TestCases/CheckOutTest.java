package TestCases;

import api.actions.CartApi;
import base.BaseTest;
import objects.BillingAddress;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import utils.JacksonUtils;

import java.io.IOException;

public class CheckOutTest extends BaseTest {

    @Test
    public void GuestCheckOutUsingDirectBankTransfer() throws IOException, InterruptedException {

        BillingAddress billingAddress = JacksonUtils.deserializeJson("BillingAddress.json",BillingAddress.class);
        CheckOutPage checkOutPage = new CheckOutPage(getDriver()).load();

        CartApi cartApi = new CartApi();
        cartApi.addToCart(1215,1);
        injectCookiesToBrowser(cartApi.getCookies());

        checkOutPage.load()
                .setBillingAddress(billingAddress)
                .selectDirectBankTransfer();
      //  Thread.sleep(4000);
                checkOutPage.placeOrder();
        Assert.assertEquals(checkOutPage.getTextSuccessNotice(),"Thank you. Your order has been received.");


    }
}
