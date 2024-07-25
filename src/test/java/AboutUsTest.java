import Pages.AboutUsPage;
import Pages.BasePage;
import Pages.HomePage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AboutUsTest extends UseCaseBase {
    static AboutUsPage aboutUsPage;
    static BasePage basePage;

    @BeforeAll
    public static void classSetup() {
        aboutUsPage = new AboutUsPage();
    }

    @Test
    public void AboutUsPageLoaded(){
        boolean loaded = aboutUsPage.aboutUsPageLoaded();
        assertTrue(loaded);
    }
    @Test
    public void findAboutUsDescr(){
       Boolean isVisible =  aboutUsPage.aboutUsDescrVisible();
        assertTrue(isVisible);
    }
}
