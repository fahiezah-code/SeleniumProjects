package TestCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.StorePage;

public class NavigationTest extends BaseTest {
//write in this class all navigation test
    @Test
    public void NavigateFromHomeToStoreUsingMainMenu() {
        StorePage storePage = new HomePage(getDriver())
                .load().navigateToStoreUsingMenu();
        System.out.println(storePage.getTitle());
        Assert.assertEquals(storePage.getTitle(),"Store");


    }

}
