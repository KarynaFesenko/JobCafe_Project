package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver webDriver;
    public static WebDriverWait wait;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

    protected WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }

    protected boolean elementExist(String xpath) {
        try {
            findElementByXpath(xpath);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

        public void sendKeys (String xpath, String text){
            findElementByXpath(xpath).sendKeys(text);
        }

        public void clickToElement (String xpath){
            findElementByXpath(xpath).click();
        }

//        protected String getCurrentPageUrl() {
//            return webDriver.getCurrentUrl();
//        }

    }

