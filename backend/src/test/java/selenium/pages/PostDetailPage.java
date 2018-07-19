package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PostDetailPage extends BasePage {

    public PostDetailPage (WebDriver driver){
        super(driver);
    }

    public String getPostTitle(){
        return driver.findElement(By.id("postTitle")).getText();
    }

    public String getPostBody(){
        return driver.findElement(By.id("postBody")).getText();
    }

    public int getNumberOfComments(){
        return driver.findElements(By.id("postComment")).size();
    }

}
