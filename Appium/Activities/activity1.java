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

public class activity1 {
    AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.sec.android.app.popupcalculator");
        options.setAppActivity(".Calculator");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void multiplyTest() {
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06")).click();
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul")).click();
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07")).click();
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();

        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();

        Assert.assertEquals(result, "42");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}