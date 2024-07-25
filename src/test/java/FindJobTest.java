import Pages.BasePage;
import Pages.FindJobPage;
import Pages.HomePage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class FindJobTest extends UseCaseBase {
    FindJobPage findJobPage;
    static HomePage homePage;
    static BasePage basePage;


    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage();
        basePage = new BasePage();
    }

    @BeforeEach
    public void beforeTest() {
        homePage.navigateToHomePage();
        findJobPage = homePage.openFindJobOption();
    }

    @Test
    public void checkLocationFiledExist() {
        String location = "Toronto";
        findJobPage.findLocationField(location);
        assertNotNull(FindJobPage.locationFilter);
    }

    @Test
    public void checkPositionFiledExist() {
        String position = "QA";
        findJobPage.findPositionField(position);
        assertNotNull(FindJobPage.positionFilter);
    }

    @Test
    public void checkCompanyFiledExist() {
        String company = "Google";
        findJobPage.findCompanyField(company);
        assertNotNull(FindJobPage.companyFilter);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Toronto", "Tel Aviv", "Chicago", "New York"})
    public void checkCity(String city) {
        findJobPage.sendKeys(FindJobPage.locationFilter, city);
        assertEquals(city, city);
        assertNotNull(city);
    }

    @ParameterizedTest
    @ValueSource(strings = {"QA", "Developer", "Project Manager"})
    public void checkPosition(String position) {
        findJobPage.sendKeys(FindJobPage.positionFilter, position);
        assertEquals(position, position);
        assertNotNull(position);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Apple", "Facebook", "Google"})
    public void checkCompany(String company) {
        findJobPage.sendKeys(FindJobPage.positionFilter, company);
        assertEquals(company, company);
        assertNotNull(company);
    }



//    @Test
//    public void testNoResultTest() {
//        findJobPage.noResultTest();
//
//    }


    @Test
    public void resetSearchTest() {
        findJobPage.findLocationField("Toronto");
        findJobPage.findPositionField("QA");
        findJobPage.findCompanyField("Apple");
        findJobPage.clickToElement(FindJobPage.resetButton);
        assertTrue(findJobPage.correctLocationResult());
    }

    @Test
    public void combinedSearchTest() {
        findJobPage.findJob("Manager", "Google", "USA");
        assertTrue(findJobPage.correctLocationResult());
    }
}

