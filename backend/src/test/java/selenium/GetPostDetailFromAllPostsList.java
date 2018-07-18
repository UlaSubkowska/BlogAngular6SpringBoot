package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class GetPostDetailFromAllPostsList {
    public static final String baseUrl = "http://localhost:80";
    public static final String geckodriverLocalPath = "../tool/geckodriver";
    public static final String expectedTitle = "Blog";

    @Test
    public void GetPostDetailFromAllPostsList () {
        // Detail of current fifth post
        String expectedPostTitle = "nesciunt quas odio";
        String expectedPostBody = "repudiandae veniam quaerat sunt sed\\nalias aut fugiat sit autem sed est\\nvoluptatem omnis possimus esse voluptatibus quis\\nest aut tenetur dolor neque";
        int expectedNumberOfComments = 5;

        System.setProperty("webdriver.gecko.driver", geckodriverLocalPath);

        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);

        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals(expectedTitle, title);

        WebElement allposts = driver.findElement(By.linkText("All posts"));
        allposts.click();

        WebElement post = driver.findElement(By.partialLinkText("nesciunt quas odio"));
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
