package AppiumBasics;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Basics {
    @Test
    public void AppiumTest() throws MalformedURLException {
        UiAutomator2Options options=new UiAutomator2Options();
        //name of the app which u want to automate
        options.setDeviceName("Komalapp");
        //path of the app
        options.setApp("C:\\Users\\komalkumari\\Git_Projects\\Appium_mobile_Testing\\src\\test\\java\\resources\\ApiDemos-debug.apk");

        //creating object for android driver
        //android code-> appium server -> mobile
        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.0:4723/wd/hub"),options);


    }
}
