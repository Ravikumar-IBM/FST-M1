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

public class activity4 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.samsung.android.app.contacts");
        options.setAppActivity("com.samsung.android.contacts.contactslist.PeopleActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Test method
    @Test
    public void contactsTest() {
        driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("nameEdit")));
        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/childButtoContainer")).click();
        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/firstEdit")).sendKeys("Aaditya");
        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/lastEdit")).sendKeys("Varma");
        driver.findElement(AppiumBy.id("android.widget.TextView")).click();
        driver.findElement(AppiumBy.id("android.widget.LinearLayout")).sendKeys("999148292");
        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/menu_done")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.samsung.android.app.contacts:id/header")));

        String contactName = driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/header")).getText();
        Assert.assertEquals(contactName, "Aaditya Varma");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }}
