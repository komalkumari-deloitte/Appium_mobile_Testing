//official document:
//https://github.com/rakjha/appium/blob/master/docs/en/writing-running-appium/android/android-mobile-gestures.md

package RealTimeEcommerceApp;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest1 {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;


    @BeforeTest
    public void SetupAppium() throws MalformedURLException {

        //code to start appium server
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\komalkumari\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("192.168.29.11").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();

        //name of the app which u want to automate
        options.setDeviceName("Komalapp");

        //path of the app
        options.setApp("C:\\Users\\komalkumari\\Git_Projects\\Appium_mobile_Testing\\src\\test\\java\\resources\\General-Store.apk");

        //creating object for android driver
        //android code-> appium server -> mobile
        driver = new AndroidDriver(new URL("http://192.168.29.11:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    //formatting from string to double so that able to add price
    public Double getFormattedAmount(String amount){
        Double price=Double.parseDouble(amount.substring(1));
        return price;
    }
    public void longPressAction(WebElement ele)  {
        //for long press
        ((JavascriptExecutor)driver).executeScript("mobile:longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele)
                .getId(),"duration",2000));
    }
    /*@AfterTest
    public void tearDown()
    {
        driver.quit();
        service.stop();
     }*/
}
