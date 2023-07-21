package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyDirectory_6 {
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
    public void VerifyDirectory() {
        WebElement username = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click();
        //Verify that the “Directory” menu item is visible and clickable.
        //check if element visible
        boolean Directory = driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[9]/a/b")).isDisplayed();
        if (Directory) {
            System.out.println("Directory is dispalyed");
        } else {
            System.out.println("Directory is not dispalyed");

        }
         driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[9]/a/b")).click();

    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}

