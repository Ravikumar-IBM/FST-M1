package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity2 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void testCase1() {
        //This test case will pass
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Target Practice");
    }

    @Test
    public void testCase2() {
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
    }

    @Test(enabled = false)
    public void testCase3() {
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }

    @Test
    public void testCase4() {
        throw new SkipException("Skipping test case");
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.close();
    }

}
