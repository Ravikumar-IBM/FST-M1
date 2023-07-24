package Activities;




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
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{
                { "admin", "password" }};
    }

}

