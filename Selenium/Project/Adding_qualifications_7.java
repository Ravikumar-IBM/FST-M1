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

public class Adding_qualifications_7 {
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
    public void Adding_qualifications() {
        WebElement username = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click();
        //Find the “My Info” menu item and click it.
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();
        ///find the Qualification option on the left side menu and click it.
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[9]/a")).click();
        ///Click on ADD button
        driver.findElement(By.xpath("//*[@id=\"addWorkExperience\"]")).click();
        //Add Work Experience and click Save.
        WebElement Company  = driver.findElement(By.xpath("//*[@id=\"experience_employer\"]"));
        WebElement JobTitle = driver.findElement(By.xpath("//*[@id=\"experience_jobtitle\"]"));
        Company.sendKeys("XYZ");
        JobTitle.sendKeys("SSE");
        driver.findElement(By.xpath("//*[@id=\"btnWorkExpSave\"]")).click();

    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}

