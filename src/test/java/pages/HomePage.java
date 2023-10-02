package pages;

import base.AppLaunchBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    AppiumDriver driver;
    public HomePage(AppiumDriver driver){
//        this.driver=driver;
        super(driver);
    }

    String logo_xpath = "//android.view.ViewGroup[@content-desc='container header']/android.widget.TextView";

    public Boolean homePageLogoIsDisplayed(){
        return getElement(logo_xpath).isDisplayed();
    }
}
