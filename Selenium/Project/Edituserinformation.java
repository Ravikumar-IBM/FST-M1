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

public class Edituserinformation {
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
    public void Edituser() {
        WebElement username = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[6]/a/b")).click();

        //Click on Edit button

        driver.findElement(By.id("btnSave")).click();
        WebElement FirstName = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]"));
        FirstName.clear();
        FirstName.sendKeys("Ravi");
        WebElement LastName = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpLastName\"]"));
        LastName.clear();
        LastName.sendKeys("Kumar");
        WebElement Gender = driver.findElement(By.xpath("//*[@id=\"personal_optGender_2\"]"));
        Gender.click();
        //Select Nationality,

        Select Nationality = new Select(driver.findElement(By.id("personal_cmbNation")));
        Nationality.selectByValue("Greek");
        //Set DOB
        WebElement DOB = driver.findElement(By.xpath("//*[@id=\"personal_DOB\"]"));
        DOB.clear();
        DOB.sendKeys("1990-10-10");
        //Clcik on save button
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();

    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    }

