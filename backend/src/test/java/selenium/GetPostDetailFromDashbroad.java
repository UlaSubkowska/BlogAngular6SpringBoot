package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class GetPostDetailFromDashbroad {
    public static final String baseUrl = "http://localhost:80";
    public static final String geckodriverLocalPath = "../tool/geckodriver";
    public static final String expectedTitle = "Blog";

    @Test
    public void GetPostDetailFromAllPostsList () {
        // Detail of current first post
        String expectedPostTitle = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
        String expectedPostBody = "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto";
        int expectedNumberOfComments = 5;

        System.setProperty("webdriver.gecko.driver", geckodriverLocalPath);

        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);

        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals(expectedTitle, title);


        WebElement post = driver.findElement(By.partialLinkText("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
        post.click();

        String postTitle = driver.findElement(By.id("postTitle")).getText();
        Assert.assertEquals(expectedPostTitle, postTitle);

        String postBody = driver.findElement(By.id("postBody")).getText();
        Assert.assertEquals(expectedPostBody, postBody);

        List<WebElement> postComments = driver.findElements(By.id("postComment"));
        Assert.assertEquals(postComments.size(), expectedNumberOfComments);

        driver.quit();
    }
}
