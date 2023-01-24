package RealTimeEcommerceApp;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EcommerceAppTC_1 extends BaseTest1{
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
        //scrolling until jorden 6 rings found
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
        int ProductCount=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        //iterate in all the products having name jorden 6 rings
        for(int i=0;i<ProductCount;i++)
        {
            //fetching product name
            String ProductName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(ProductName.equalsIgnoreCase("Jordan 6 Rings"))
            {
                //click on "ADD TO CART" whose product name is Jordan 6 Rings
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        //click on cart icon
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(2000);

        //wait until page get fully loaded
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","cart"));

        //validating
        String lastPage=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(lastPage,"Jordan 6 Ring");


    }
}
