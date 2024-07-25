package Pages;

public class FindJobPage extends BasePage {
    BasePage basePage;
    public static final String findJobPage_link = "http://167.99.178.249:3000/job-page";
    public static final String positionFilter = "//input[@placeholder= 'position']";
    public static final String locationFilter = "//*[@placeholder= 'location']";
    public static final String companyFilter = "//input[@placeholder= 'company']";
    public static final String resetButton = "//button [text() = 'reset']";
    public static final String searchButton = "//button[@class= 'search-butom']";
    public static final String filtersOption = "//h3 [@class='sidebar-title']";
    public static final String errorMessage = "//* [text()='No results found!']";
    public static final String correctLocation = "//* [@class= 'entry-content']";


    public void findLocationField(String location) {
        sendKeys(locationFilter, location);
        clickToElement(searchButton);
    }

    public void findPositionField(String position) {
        sendKeys(positionFilter, position);
        clickToElement(searchButton);
    }

    public void findCompanyField(String company) {
        sendKeys(companyFilter, company);
        clickToElement(searchButton);
    }

    public void findJob(String position, String company, String location) {
        sendKeys(positionFilter, position);
        sendKeys(companyFilter, company);
        sendKeys(location, location);
        clickToElement(searchButton);
    }

    public boolean correctLocationResult() {
        try {
            elementExist(correctLocation);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

    public void combinedSearch() {
        webDriver.get(findJobPage_link);
        sendKeys(companyFilter, "Google");
        sendKeys(positionFilter, "manager");
        sendKeys(locationFilter, "USA");
        findElementByXpath(searchButton).click();
        correctLocationResult();
    }

    public boolean noResultTest() {
        return elementExist(errorMessage);
    }

    public void resetTest() {
        basePage.sendKeys(locationFilter, "Toronto");
        basePage.sendKeys(positionFilter, "QA");
        basePage.sendKeys(companyFilter, "Google");
        findElementByXpath(resetButton).click();
        correctLocationResult();
    }

}

