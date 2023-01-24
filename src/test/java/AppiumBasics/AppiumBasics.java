package AppiumBasics;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBasics extends BaseTest {

    @Test
    public void WifiSettingName()
    {
        //actual automation-clicking on elements
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(By.id("android:id/checkbox")).click();

        //to rotate mobile in landscape mode
        //DeviceRotation landScape=new DeviceRotation(0,0,90);
       // driver.rotate(landScape);

        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        //validation of title
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");

        //copy and paste
        //copy to clipboard
        //driver.setClipboardText("Komal wifi");
        //driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        //driver.pressKey(new KeyEvent(AndroidKey.ENTER)); //press enter
        //driver.pressKey(new KeyEvent(AndroidKey.HOME)); //press home page

        //entering password
        driver.findElement(By.id("android:id/edit")).sendKeys("Komal wifi");

        //click on OK
        driver.findElement(By.id("android:id/button1")).click();

    }

}
