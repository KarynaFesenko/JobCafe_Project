package Utils;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public class UseCaseBase{

    private static WebDriver webDriver;
    private static BasePage basePage;


    @BeforeAll
    public static void setMain(){
        basePage = new BasePage ();
        webDriver = SharedDriver.getWebDriver(SharedDriver.Browser.CHROME);
        basePage.setWebDriver(webDriver);
    }

    @AfterAll
    public static void tearDownDriver() {
        SharedDriver.closeDriver();
        webDriver = null;
    }


}
