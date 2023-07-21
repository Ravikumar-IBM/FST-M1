package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Applyingfor_leave_8 {
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
    public void Applyingforleave() {
        WebElement username = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click();
        //click on the Apply Leave option.
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[3]/a/b")).click();
        driver.findElement(By.xpath("//*[@id=\"menu_leave_applyLeave\"]")).click();
        ///find the Qualification option on the left side menu and click it.
        WebElement LeaveType =driver.findElement(By.xpath("//*[@id=\"applyleave_txtLeaveType\"]"));
        LeaveType.sendKeys("DayOff");
        WebElement FromDate = driver.findElement(By.xpath("//*[@id=\"applyleave_txtFromDate\"]"));
        FromDate.clear();
        FromDate.sendKeys("2023-07-16");
        WebElement ToDate = driver.findElement(By.xpath("//*[@id=\"applyleave_txtToDate\"]"));
        ToDate.clear();
        ToDate.sendKeys("2023-07-16");
        driver.findElement(By.xpath("//*[@id=\"applyBtn\"]")).click();
        //MyLeaves
        driver.findElement(By.xpath("//*[@id=\"menu_leave_viewMyLeaveList\"]")).click();
        String ExpectedTitle = "Pending Approval(1.00)";
        WebElement TableValue = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[3]/table/tbody/tr[1]/td[6]/a"));
        System.out.println("Second row, second cell value: " + TableValue.getText());
        Assert.assertEquals(ExpectedTitle, TableValue);


    }
   @AfterMethod
    public void afterMethod() {
       driver.quit();
  }
}

