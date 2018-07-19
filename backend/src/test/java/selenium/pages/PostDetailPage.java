package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PostDetailPage extends BasePage {

    public PostDetailPage (WebDriver driver){
        super(driver);
    }

    public String getPostTitle(){
        return readText(By.id("postTitle"));
    }

    public String getPostBody(){
        return readText(By.id("postBody"));
    }

    public int getNumberOfComments(){
        return driver.findElements(By.id("postComment")).size();
    }

}
