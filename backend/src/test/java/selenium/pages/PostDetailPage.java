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

    public void verifyPostTitle(String expectedPostTitle){
        Assert.assertEquals(expectedPostTitle, driver.findElement(By.id("postTitle")).getText());
    }

    public void verifyPostBody(String expectedPostBody){
        Assert.assertEquals(expectedPostBody, driver.findElement(By.id("postBody")).getText());
    }

    public void verifyNumberOfComments(int expectedNumberOfComments){
        List<WebElement> postComments = driver.findElements(By.id("postComment"));
        Assert.assertEquals(postComments.size(), expectedNumberOfComments);
    }


}
