package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    public void click(By elementLocation){
        driver.findElement(elementLocation).click();
    }

    public String readText(By elementLocation){
        return driver.findElement(elementLocation).getText();
    }

    //TO DO
    // - countElements method!!
}
