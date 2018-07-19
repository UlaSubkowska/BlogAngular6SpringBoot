package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final String BASE_URL = "http://localhost:80";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToDashbroad() {
        driver.get(BASE_URL);
    }

    public void goToAllPosts() {
        click(By.linkText("All posts"));
    }

    public void goToAlbums() {
        click(By.linkText("Albums"));
    }

    public void goToPost(String postTitle){
        click(By.partialLinkText(postTitle));
    }

}
