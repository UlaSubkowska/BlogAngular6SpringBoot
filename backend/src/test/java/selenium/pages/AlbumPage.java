package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlbumPage extends BasePage {

    public AlbumPage(WebDriver driver){
        super(driver);
    }

    public void displayUserAlbums(int userId){
        driver.findElement(By.id(Integer.toString(userId)+"Button")).click();
    }

    public String getUserName(int userId){
        return driver.findElement(By.id(Integer.toString(userId)+"Button")).getText();
    }
}
