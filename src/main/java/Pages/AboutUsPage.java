package Pages;

import org.openqa.selenium.WebDriver;

public class AboutUsPage extends BasePage {
    BasePage basePage;
    WebDriver webDriver;
    public static final String AboutUs_link = "http://167.99.178.249:3000/about";
    public static final String aboutUs_banner = "//img [@class= 'img-fluid']";
    public static final String aboutUs_descr = "//img [@class= 'col-lg-6 pt-4 pt-lg-0']";

    public boolean aboutUsPageLoaded() {
        return elementExist(aboutUs_banner);
    }

    public boolean aboutUsDescrVisible() {
        boolean descriptionIsVisible = elementExist(aboutUs_descr);
        return descriptionIsVisible;
    }
}
