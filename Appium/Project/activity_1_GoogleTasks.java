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

public class activity_1_GoogleTasks {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    @Test
    public void GoogleTask() {
        //Click on Add task
        //driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        // Type task
        //WebElement task=driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText"));
        //task.sendKeys("Google Task1");
        //Click on save
        //driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        // Add 2nd ask and save
        //Click on Add task
        //driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        //WebElement task2=driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText"));
        //task2.sendKeys("Google Task2");
        //driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        // Add 3rd ask and save
        //Click on Add task
        //driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        //task.sendKeys("Google Task3");
        //driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        //driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        //driver.findElement(AppiumBy.accessibilityId("Equal")).click();
        String result = driver.findElement(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup")).getText();
        System.out.println(result);

        //String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();

        //Assert.assertEquals(result, "42");
    }

    //@AfterClass
    //public void tearDown() {
        //driver.quit();
    //}
}
