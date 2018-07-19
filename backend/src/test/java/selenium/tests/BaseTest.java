package selenium.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.pages.HomePage;

public class BaseTest {

    private static final String GECKODRIVER_LOCAL_PATH = "../tool/geckodriver";
    protected static WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", GECKODRIVER_LOCAL_PATH);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void teardown () {
        driver.quit();
    }

}
