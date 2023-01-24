package AppiumBasics;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollDemo extends BaseTest {

    @Test
    public void ScrollGesture(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //where to scroll is known prior
        //first way to scroll:-
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        //Thread.sleep(2000);

        //calling function to scrollTillEnd
        //second way to scroll use any one:-
        scrollTillEndAction();


    }

}
