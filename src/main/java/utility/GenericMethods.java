package utility;

import driverRepo.ConfigDriver;
import listners.ExtentReportListener;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

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

    public static void waitForUploadPopupToDisappear(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        By popupLocator = By.xpath("//div[contains(text(),'File uploaded successfully')]");
        try {
            // Wait until popup appears
            wait.until(ExpectedConditions.visibilityOfElementLocated(popupLocator));
            // Then wait until popup disappears
            wait.until(ExpectedConditions.invisibilityOfElementLocated(popupLocator));
        } catch (TimeoutException e) {
            System.out.println("Popup did not appear or disappear within the timeout");
        }
    }

    public static void closeUploadPopupIfPresent(WebDriver driver, int timeoutInSeconds) {
        try {
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                    .pollingEvery(Duration.ofMillis(500))  // check every 500ms
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);

            WebElement closeButton = fluentWait.until(driverInstance -> {
                WebElement element = driverInstance.findElement(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--light']"));
                return (element.isDisplayed()) ? element : null; // return element if visible
            });

            if (closeButton != null) {
                closeButton.click();
                log.info("Upload popup closed successfully using FluentWait.");
            }
        } catch (TimeoutException e) {
            log.info("No upload popup present to close within timeout.");
        } catch (Exception e) {
            log.error("Error while closing upload popup using FluentWait: " + e.getMessage());
        }
    }



}


