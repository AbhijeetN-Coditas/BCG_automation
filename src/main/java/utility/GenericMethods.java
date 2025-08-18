package utility;

import driverRepo.ConfigDriver;
import listners.ExtentReportListener;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericMethods {
    private static Logger log = Logger.getLogger(ExtentReportListener.class);
    static WebDriver driver = ConfigDriver.getDriver();

    public static WebElement waitUntiElementClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }



    public static void click(WebElement element) {
        try{
            waitUntiElementClickable(element,10).click();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public static void sendKeys(WebElement element,String value) {
        try{
            waitUntiElementClickable(element,10).sendKeys(value);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    public static void launchURL( String url) {
        try {
            driver.get(url);
            log.info("URL launched: " + url);
        } catch (Exception e) {
            log.error("Failed to launch URL: " + url, e);
            throw new RuntimeException("Failed to launch URL: " + url, e);
        }

    }
    public static String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            log.error("Failed to get text from element: " + element, e);
            throw new RuntimeException("Failed to get text from element: " + element, e);
        }
    }
}
