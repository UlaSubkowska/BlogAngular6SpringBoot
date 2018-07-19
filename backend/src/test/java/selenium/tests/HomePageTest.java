package selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import selenium.pages.HomePage;

public class HomePageTest extends BaseTest {
    private static final String EXPECTED_TITLE = "Blog";

    @Test
    // to do - change test name!!!
    public void testPageTitle() throws InterruptedException {
        homePage =new HomePage(driver);
        homePage.goToDashbroad();
        Assert.assertEquals(driver.getTitle(), EXPECTED_TITLE);
    }
}
