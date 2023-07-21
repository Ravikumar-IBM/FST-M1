package Activities;

import org.testng.annotations.*;

public class Setup {
    @BeforeMethod
    public void createDriver() {
        System.out.println("Login to app ");
    }
    @Test
    public  void GetTitle(){
        System.out.println("Page Title ");

    }

    @AfterMethod
    public void closeBrowser(){
        System.out.println("Close Browser ");
    }
}


