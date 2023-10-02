package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;

public class ConfigReader {
    private static Properties properties;

    public static Properties configReader() throws Exception {
        String target = targetReader();
        String propertyFilePath = "";
        if(target.equals("ANDROID")) {
            propertyFilePath = System.getProperty("user.dir")+"//src//test//configs//android.properties";
        }else if(target.equals("IOS")){
            propertyFilePath = System.getProperty("user.dir")+"//src//test//configs//ios.properties";
        }else{
            throw new Exception("Unable to find the right target");
        }
        properties = fileReader(propertyFilePath);
        return properties;
    }

    public static String targetReader() throws Exception {
        String propertyFilePath = "";
        propertyFilePath = System.getProperty("user.dir")+"//src//test//configs//target.properties";
        Properties properties = fileReader(propertyFilePath);
        return properties.getProperty("targetPlatform").toUpperCase();
    }

    public static Properties fileReader(String propertyFilePath){
        BufferedReader reader;
        Properties properties;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
        return properties;
    }

    public static UiAutomator2Options getAndroidOptions() throws Exception {
        properties = configReader();
        UiAutomator2Options options = new UiAutomator2Options();
        return options.setPlatformName(properties.getProperty("platformName"))
                .setPlatformVersion(properties.getProperty("platformVersion"))
                .setDeviceName(properties.getProperty("deviceName"))
                .setApp(System.getProperty("user.dir")+"//src//test//resources//"+properties.getProperty("app"))
                .setAppPackage(properties.getProperty("appPackage"))
                .setAppActivity(properties.getProperty("appActivity"))
                .setNoReset(Boolean.valueOf(properties.getProperty("noReset")));
    }

    public XCUITestOptions getIOSOptions(String target){
        XCUITestOptions options = new XCUITestOptions();
        return options;
    }

}