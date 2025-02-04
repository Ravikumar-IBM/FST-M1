package Activities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
public class activity2 {

    AndroidDriver driver;

      @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        driver.get("https://training-support.net/");
    }
    @Test
    public void chromeTest() {

        String pageHeading = driver.findElement(AppiumBy.id("com.android.chrome:id/url_bar")).getText();
        System.out.println("Heading: " + pageHeading);
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"About Us\"]")).click();
        String aboutPageHeading = driver.findElement(AppiumBy.id("com.android.chrome:id/url_bar")).getText();
        System.out.println(aboutPageHeading);
    }
    @AfterClass
    public void tearDown()
    {driver.quit();
    }
}