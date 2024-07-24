package TestCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StorePage;

public class SearchTest extends BaseTest {

    @Test
    public void searchWithPartialMatch(){
        String searchFor = "Blue";

        StorePage storePage = new StorePage(getDriver())
                .load()
                .search(searchFor)
                .getSearchTitle();
        Assert.assertEquals(storePage.getTitle(),"Search results: “"+ searchFor+"”");
    }
}
