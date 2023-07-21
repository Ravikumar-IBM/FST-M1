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

import java.awt.*;
import java.util.List;

public class Retrieveemergency_contacts_9 {
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
    public void Retrieveemergencycontacts() {
        WebElement username = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click();
        //Find the “My Info” menu item and click it.
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();
        ///Click on Emergency Contacts  .
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a")).click();
        //Table
        WebElement table=driver.findElement(By.xpath("//*[@id=\"emgcontact_list\"]"));
        List<WebElement> cols = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody"));
        System.out.println("Number of columns: " + cols.size());
        List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/thead/tr"));
        System.out.println("Number of rows: " + rows.size());

        for(WebElement cell : rows) {
            System.out.println(cell.getText());
        }
        WebElement cellValue = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr[1]/td[5]"));
        System.out.println("Second row, second cell value: " + cellValue.getText());
    }
   @AfterMethod
  public void afterMethod() {
       driver.quit();
    }
}

