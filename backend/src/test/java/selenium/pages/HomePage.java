package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private static final String BASE_URL = "http://localhost:80";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToDashbroad() {
        driver.get(BASE_URL);
    }

    public void goToAllPosts() {
        driver.findElement(By.linkText("All posts")).click();
    }

    public void goToAlbums() {
        driver.findElement(By.linkText("Albums")).click();
    }

    public void goToPost(String postTitle){
        driver.findElement(By.partialLinkText(postTitle)).click();
    }

    public void verifyTitle(String expectedTitle){
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

}
