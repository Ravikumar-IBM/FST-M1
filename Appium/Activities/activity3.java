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
public class activity3 {

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
    public void additionTest() {

        driver.findElement(AppiumBy.id("calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_add")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();// Press 0
        driver.findElement(AppiumBy.id("calc_keypad_btn_dot")).click();//Press dot
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();//Press5
        driver.findElement(AppiumBy.id("calc_keypad_btn_equal")).click();
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
        Assert.assertEquals(result, "100.5");

    }

    @Test
    public void subtractTest() {

        driver.findElement(AppiumBy.id("calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_sub")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();// Press 5
        driver.findElement(AppiumBy.id("calc_keypad_btn_dot")).click();//Press dot
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();//Press5
        driver.findElement(AppiumBy.id("calc_keypad_btn_equal")).click();
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
        Assert.assertEquals(result, "94.5");
    }

    @Test
    public void multiplyTest() {
        driver.findElement(AppiumBy.id("calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_mul")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();// Press 5
        driver.findElement(AppiumBy.id("calc_keypad_btn_dot")).click();//Press dot
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();//Press5
        driver.findElement(AppiumBy.id("calc_keypad_btn_equal")).click();
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
        Assert.assertEquals(result, "550");
    }
    @Test
    public void divideTest() {
        driver.findElement(AppiumBy.id("calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_div")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();// Press 5
        driver.findElement(AppiumBy.id("calc_keypad_btn_dot")).click();//Press dot
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();//Press5
        driver.findElement(AppiumBy.id("calc_keypad_btn_equal")).click();
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
        Assert.assertEquals(result, "18.1818181818");
    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}