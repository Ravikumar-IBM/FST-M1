package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class activity5 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.samsung.android.messaging");
        options.setAppActivity("com.android.mms.ui.ConversationComposer");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Test method
    @Test
    public void smsTest() {
        // Find and click the add button
        driver.findElement(AppiumBy.accessibilityId("Compose new message")).click();

        // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.samsung.android.messaging:id/recipients_editor_to")));
        // Find the element to add recipient
       driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/recipients_editor_to")).sendKeys("8147961924");
       // Press ENTER
        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));

     // Wait for textbox to appear
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.samsung.android.messaging:id/message_edit_text")));

    // Enter text to send
         driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/message_edit_text")).sendKeys("Hello from Appium");
     // Press Send
       driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/send_button1")).click();

    // Assertion
        String messageTextSent = driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/content_text_view")).getText();
        Assert.assertEquals(messageTextSent, "Hello from Appium");
   }


   @AfterClass
   public void tearDown() {
      driver.quit();
    }
}