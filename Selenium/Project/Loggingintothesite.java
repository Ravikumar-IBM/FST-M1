package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Loggingintothesite {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        Actions builder = new Actions(driver);

        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @Test
    public void Loggingint() {
        WebElement username = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        String actualUrl="http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/dashboard";
        String expectedUrl= driver.getCurrentUrl();
        System.out.println("Page title is: " + expectedUrl);
        //verify that the homepage has opened.
        if(actualUrl.equalsIgnoreCase(expectedUrl))
            System.out.println("Home page displayed");
        else
            System.out.println("Home page not displayed");

    }
    @AfterMethod
    public void afterMethod() {
        ///Close the browser
        driver.quit();
    }
}
