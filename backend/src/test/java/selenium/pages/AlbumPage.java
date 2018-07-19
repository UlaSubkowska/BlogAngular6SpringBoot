package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void goToUserAlbum(int albumId){
        driver.findElement(By.id("albumLink"+Integer.toString(albumId))).click();
    }

    public String getAlbumName(){
        return driver.findElement(By.id("albumTitle")).getText();
    }

    public int getNumberOfPhotos(){
        return driver.findElements(By.id("photo")).size();
    }

    // TO DO!!!
    //nie do konca to co chcemy bo chcemy popup a nie przejscie do linku
    public void popupPhoto(int photoId){
        String urlimages =driver.findElement(By.id(Integer.toString(photoId)+"PhotoDetail")).getAttribute("src");
        driver.get(urlimages);
    }
}

