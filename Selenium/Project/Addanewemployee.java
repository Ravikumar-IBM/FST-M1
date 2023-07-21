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

public class Addanewemployee {
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
    public void Addemployee() {
        WebElement username = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click();
        //Click the Add button to add a new Employee.
        //driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
        driver.findElement(By.name("btnAdd")).click();
        //Fill in the required fields and click Save.
        WebElement FirstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        FirstName.sendKeys("Ravi");
        WebElement LastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        LastName.sendKeys("Kumar");
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click();
        WebElement EmployeeName = driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]"));
        EmployeeName.sendKeys("Ravi Kumar ");
        driver.findElement(By.xpath("//*[@id=\"searchBtn\"]")).click();
        WebElement btnSearch = driver.findElement(By.xpath("//input[@id='searchBtn']"));
        btnSearch.click();
        System.out.println("Employee name added successfully");

    }
        @AfterMethod
        public void afterMethod() {
            driver.quit();
        }

}
