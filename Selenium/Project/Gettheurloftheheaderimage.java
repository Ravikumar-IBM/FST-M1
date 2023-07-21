package Activities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Gettheurloftheheaderimage {
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
    public void imageURL() {

        WebElement l =driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/img"));
        //getAttribute() to get src of image
        System.out.println("Src attribute is: "+ l.getAttribute("src"));
    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
