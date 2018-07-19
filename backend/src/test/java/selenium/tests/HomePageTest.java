package selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import selenium.pages.HomePage;

public class HomePageTest extends BaseTest {
    private static final String EXPECTED_TITLE = "Blog";

    @Test
    public void Given_VerifyPageTitle_When_OpenPageUsingWebDriver_Then_AssertExpectedTitle () throws InterruptedException {
        homePage =new HomePage(driver);
        homePage.goToDashbroad();
        Assert.assertEquals(driver.getTitle(), EXPECTED_TITLE);
    }
}
