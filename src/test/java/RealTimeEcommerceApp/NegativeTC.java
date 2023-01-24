package RealTimeEcommerceApp;

import AppiumBasics.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTC extends BaseTest {
    @Test
    public void FillForm(){
        //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Komal kumari");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        //way to scroll until argentina found
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click(); //click on argentina
        //click button
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        //when u try to shop without entering your name
        String toastMessage=driver.findElement(By.xpath("//android.widget.Toast)[1])")).getAttribute("name");
        //validating error message
        Assert.assertEquals(toastMessage,"Please enter your name");

    }
}


