package selenium.pages;

import org.openqa.selenium.*;

public class AlbumPage extends BasePage {

    public AlbumPage(WebDriver driver){
        super(driver);
    }

    public void displayUserAlbums(int userId){
        click(By.id(Integer.toString(userId)+"Button"));
    }

    public String getUserName(int userId){
        return readText(By.id(Integer.toString(userId)+"Button"));
    }

    public void goToUserAlbum(int albumId){
        click(By.id("albumLink"+Integer.toString(albumId)));
    }

    public String getAlbumTitle(){
        return readText(By.id("albumTitle"));
    }

    public int getNumberOfPhotos(){
        return countElements(By.id("photo"));
    }

    public void popupPhoto(int photoId){
        WebElement photo = driver.findElement(By.id(Integer.toString(photoId)+"PhotoDetail"));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", photo);
    }

}

