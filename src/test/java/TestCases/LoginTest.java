package TestCases;

import api.actions.CartApi;
import api.actions.SignUpAPi;
import base.BaseTest;
import junit.framework.Assert;
import objects.Product;
import objects.User;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.LoginPage;
import utils.FakerUtils;

import java.io.IOException;

public class LoginTest extends BaseTest {

   @Test
    public void LoginDuringCheckOut() throws InterruptedException, IOException {
      //create dummy user
       String username = "demouser" + new FakerUtils().generateRandomNumber();
       User user = new User()
               .setUsername(username)
               .setPassword("demopwd")
               .setEmail(username+"@askomdch.com");

       //register user with above dummy
       SignUpAPi signUpAPi = new SignUpAPi();
        signUpAPi.registerUser(user);

       //add product to a cart
       CartApi cartApi = new CartApi();
      Product product = new Product(1215);
     System.out.println(product.getId());
      cartApi.addToCart(product.getId(),1);




      //go to CheckOut Page through UI
       CheckOutPage checkOutPage = new CheckOutPage(getDriver()).load();
       Thread.sleep(5000);
       //only after UI loaded, then we need to inject cookie
       //inject Cookies to browser
       injectCookiesToBrowser(cartApi.getCookies());
       checkOutPage.load(); //then it will come product added
       Thread.sleep(5000);
       checkOutPage.clickHereToLogin().login(user);
       Thread.sleep(5000);
      Assert.assertEquals("Blue Shoes",product.getName());




   }
}
