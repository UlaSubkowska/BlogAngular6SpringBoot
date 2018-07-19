package selenium.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    private static final String GECKODRIVER_LOCAL_PATH = "../tool/geckodriver";
    public WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", GECKODRIVER_LOCAL_PATH);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown () {
        driver.quit();
    }

}
