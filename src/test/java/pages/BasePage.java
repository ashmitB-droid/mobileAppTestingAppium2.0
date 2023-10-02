package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    AppiumDriver driver;
    public BasePage(AppiumDriver driver){
        this.driver = driver;
    }

    public WebElement getElement(String ele) {
        return driver.findElement(By.xpath(ele));
    }
}
