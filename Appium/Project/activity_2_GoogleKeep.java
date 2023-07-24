package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class activity_2_GoogleKeep {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    @Test
    public void GoogleTask() {
        //Click on Add Button
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"New text note\"]")).click();
        // Type Title
        WebElement Title=driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title"));
        Title.sendKeys("Title 1");
        // Add note
        WebElement Note=driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text"));
        Note.sendKeys("2.Goal: Use the Google Keep app to add a note");
        //Click on Back
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();

        String result1 = driver.findElement(By.id("com.google.android.keep:id/index_note_title")).getText();
        System.out.println(result1);
        String result2 = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_text_description")).getText();

        Assert.assertEquals(result1, "Title 1");
        Assert.assertEquals(result2, "2.Goal: Use the Google Keep app to add a note");
    }

    @AfterClass
    public void tearDown() {
    driver.quit();
    }
}
