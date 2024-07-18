package TestCases;

import base.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        login.load("/");
        Thread.sleep(3000);
        String title = login.clickOnFeelingLuckyBtn();
        Assert.assertEquals("Google Doodles - Google’s Search Logo Changes for Every Occasion",title);

    }
}
