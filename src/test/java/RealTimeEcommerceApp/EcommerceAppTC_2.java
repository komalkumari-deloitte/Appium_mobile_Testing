package RealTimeEcommerceApp;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class EcommerceAppTC_2 extends BaseTest1{
    @Test(priority = 1)
    public void FillForm(){
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Komal kumari");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        //way to scroll until argentina found
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click(); //click on argentina
        //click button
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }
    @Test(priority = 2)
    public void Shopping() throws InterruptedException {
        //shopping for two products
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        //click on cart icon
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        //wait until page get fully loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Thread.sleep(3000);
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
    }
    @Test(priority = 3)
    public void ValidatingTotalAmount() throws InterruptedException {
        List < WebElement> productPrice=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count=productPrice.size();
        //sum of product prices
        double sum=0;
        for (int i=0;i<count;i++)
        {
            String amountString=productPrice.get(i).getText();
            Double price=getFormattedAmount(amountString);
            sum=sum+price;

        }
        String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedSum=getFormattedAmount(displaySum);
        //validation for sum
        Assert.assertEquals(sum,displayFormattedSum);

        //longPress on cart page
        WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(ele);
        driver.findElement(By.id("android:id/button1")).click();

        //click on check box
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        //click on proceed to purchase
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(6000);
    }
    @Test(priority = 4)
    public void Hybrid(){
        //give us all context from native app to Webview
        Set<String> context=driver.getContextHandles();
        //fetching context name through appium
        for (String contextName:context) //enhanced for loop
        {
            System.out.println(contextName);
        }
        //name of context- WEBVIEW_com.androidsample.generalstore
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Shopping apps");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");






    }
}
