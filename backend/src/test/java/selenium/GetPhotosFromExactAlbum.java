package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetPhotosFromExactAlbum {
    public static final String baseUrl = "http://localhost:80";
    public static final String geckodriverLocalPath = "/Users/urszulas/Tools/geckodriver";
    public static final String expectedTitle = "Blog";

    @Test
    public void GetPhotosFromExactAlbum () {

        //Details of user with id 5
        int userId = 5;
        int albumId = 43;
        String expectedAlbumUserName = "Kamren";
        String expectedAlbumTitle = "aperiam doloremque nihil";

        System.setProperty("webdriver.gecko.driver", geckodriverLocalPath);

        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);

        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals(expectedTitle, title);

        WebElement albums = driver.findElement(By.linkText("Albums"));
        albums.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement userButton = driver.findElement(By.id(Integer.toString(userId)+"Button"));
        Assert.assertEquals(expectedAlbumUserName, userButton.getText());
        userButton.click();

        WebElement userAlbum = driver.findElement(By.id("albumLink"+Integer.toString(albumId)));
        Assert.assertEquals(expectedAlbumTitle, userAlbum.getText());
        userAlbum.click();

        driver.quit();
    }
}
