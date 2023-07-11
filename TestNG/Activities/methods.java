package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class methods {
    @BeforeMethod
    public void createDriver() {
        System.out.println("Login to app ");
    }

    @Test
    public void GetTitle() {
        System.out.println("Page Title ");


    }
    @Test
    @Parameters({ "sUsername", "sPassword" })
    public void test(String sUsername, String sPassword) {

    }
    @Test
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{
                { "admin", "password" }};
    }
    @BeforeMethod
    public void SwitchBrowser() {
        System.out.println("Switch focus back to the page ");
    }

    @AfterMethod
    public void closeBrowser() {
        System.out.println("Close Browser ");
    }
    @BeforeClass
    public void createDriver1() {
        System.out.println("Login to app ");
    }
    @AfterClass
    public void closeBrowser1() {
        System.out.println("Close Browser ");
    }
}
