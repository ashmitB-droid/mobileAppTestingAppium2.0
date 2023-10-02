package tests;
import base.AppLaunchBase;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import util.ConfigReader;

import java.io.IOException;

public class BaseTest {
    protected AppiumDriver driver;
    @BeforeTest(alwaysRun = true)
    public void setup() throws Exception {
//        String platform = "ANDROID";
        String platform = ConfigReader.targetReader();
        this.driver = new AppLaunchBase().getDriverInstance(platform);
    }
}
