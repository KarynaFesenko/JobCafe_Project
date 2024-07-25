package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public static BasePage basePage;
    public static HomePage homePage;


    private static final String homePageBanner = "//img[@alt='coming soon']";
    //    private static final String homePageFilter = "//input [@placeholder= 'Search jobs, keywords or company']";
//    private static final String homePageDescr = "//img[text() = 'MAKE IT FRESH']";
    private static final String homePage_link = "http://167.99.178.249:3000";
    private static final String findJobOption = "//a [@name= 'Find Job']";
    private static final String aboutUsOption = "//a [@name= 'About Us']";

    public void navigateToHomePage() {
        webDriver.get(homePage_link);
    }

    public WebElement navigateToAboutUsOption() {
        WebElement success = webDriver.findElement(By.xpath(aboutUsOption));
        return success;
    }

    public boolean bannerElementExist() {
        Boolean elementExist = elementExist(homePageBanner);
        return elementExist;
    }

    public boolean aboutUsOptionVisible() {
        boolean isVisible = elementExist(aboutUsOption);
        return isVisible;
    }

    public boolean findJobOptionVisible() {
        boolean isVisible = elementExist(findJobOption);
        return isVisible;
    }

    public FindJobPage openFindJobOption() {
        clickToElement(findJobOption);
        return new FindJobPage();
    }

    public AboutUsPage openAboutUsOptionTab() {
        clickToElement(aboutUsOption);
        return new AboutUsPage();
    }
public boolean bannerVisible(){
        boolean isVisible = elementExist(homePageBanner);
        return isVisible;

}

}
