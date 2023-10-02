package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import util.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class AppLaunchBase {
    private AppiumDriver driver;

    public AppiumDriver getDriverInstance(String target) throws Exception {
        switch(target){
            case "ANDROID":
                return getAndroidDriver(target);
            case "IOS":
                return getIOSDriver(target);
            default:
                throw new Exception("Platform not supported");
        }
    }

    public AppiumDriver getAndroidDriver(String target){
        try{
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),
                    ConfigReader.getAndroidOptions());
        }catch(MalformedURLException e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return driver;
    }

    public AppiumDriver getIOSDriver(String target){
        XCUITestOptions options = new XCUITestOptions();
        return driver;
    }

}
