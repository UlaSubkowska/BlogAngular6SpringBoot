package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllPostsPage extends BasePage {

    public AllPostsPage(WebDriver driver) {
        super(driver);
    }

    public void goToPost(String postTitle){
        driver.findElement(By.partialLinkText(postTitle)).click();
    }

}
