import Pages.AboutUsPage;
import Pages.BasePage;
import Pages.FindJobPage;
import Pages.HomePage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest extends UseCaseBase {


    private static HomePage homePage;
    private static BasePage basePage;

    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage();
    }

    @BeforeEach
    public void beforeTest() {
        homePage.navigateToHomePage();
    }

    @Test
    public void homePageLoaded() {
        boolean success = homePage.bannerElementExist();
        assertTrue(success);
    }

    @Test
    public void visibilityOfAboutUsOption() {
        boolean isVisible = homePage.aboutUsOptionVisible();
        assertNotNull(isVisible);
    }

    @Test
    public void visibilityOfFindJobOption() {
        boolean isVisible = homePage.findJobOptionVisible();
        assertNotNull(isVisible);
    }

    @Test
    public void clickOnAboutUsOption() {
        AboutUsPage aboutUsPage = homePage.openAboutUsOptionTab();
        boolean isOpened = homePage.bannerElementExist();
        assertTrue(isOpened);
    }

    @Test
    public void clickFindJobOption() {
        FindJobPage findJobPage = homePage.openFindJobOption();
        boolean isOpened = homePage.bannerElementExist();
        assertTrue(isOpened);
    }
}
