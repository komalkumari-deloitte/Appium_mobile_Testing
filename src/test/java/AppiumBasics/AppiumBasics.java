package AppiumBasics;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
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
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        //validation of title
        String alartTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alartTitle,"WiFi settings");

        //entering password
        driver.findElement(By.id("android:id/edit")).sendKeys("Komal wifi");

        driver.findElement(By.id("android:id/button1")).click();
    }

}
