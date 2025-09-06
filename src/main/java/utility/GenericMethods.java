package utility;

import driverRepo.ConfigDriver;
import listners.ExtentReportListener;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.*;
import java.util.List;

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

    public static WebElement selectRandomElement(List<WebElement> elements) {
        if (elements == null || elements.isEmpty()) {
            log.error("The list is empty or null!");
            throw new IllegalArgumentException("The list is empty or null!");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(elements.size()); // Generate random index
        WebElement randomElement = elements.get(randomIndex);
        log.info("Random option selected");
        return randomElement;
    }

//    public static List<String> selectRandomMultipleOptions(List<WebElement> elements, int numberOfExcludedOption) {
//
//        List<String> options=new ArrayList<>();
//
//        if (elements == null || elements.isEmpty()) {
//            throw new IllegalArgumentException("The list is empty or null!");
//        }
//
//        Random random = new Random();
//
//        int totalOptions = elements.size() - numberOfExcludedOption; // Ignoring last option
//        // Random count of selections (between 1 and total options)
//        int numberOfSelections = random.nextInt(totalOptions) + 1;
//
//        System.out.println("Selecting " + numberOfSelections + " random options.");
//
//        // Use a Set to avoid duplicates
//        Set<Integer> selectedIndexes = new HashSet<>();
//
//        while (selectedIndexes.size() < numberOfSelections) {
//            int randomIndex = random.nextInt(totalOptions);
//            selectedIndexes.add(randomIndex);
//        }
//
//        // Select those options
//        for (int index : selectedIndexes) {
//            WebElement option=elements.get(index);
//            option.click();
//            options.add(option.getText());
//            log.info("Options Selected : " +option.getText());
//            System.out.println("Selected option: " + option.getText());
//        }
//        return options;
//    }

    public static List<String> selectRandomMultipleOptions(List<WebElement> elements, int numberOfExcludedOption) {
        List<String> options = new ArrayList<>();

        if (elements == null || elements.isEmpty()) {
            throw new IllegalArgumentException("The list is empty or null!");
        }

        Random random = new Random();

        // Make sure we don't exclude more than available
        if (numberOfExcludedOption >= elements.size()) {
            throw new IllegalArgumentException("Excluded options exceed available options!");
        }

        // Exclude last N elements
        List<WebElement> availableElements = elements.subList(0, elements.size() - numberOfExcludedOption);

        int totalOptions = availableElements.size();
        int numberOfSelections = random.nextInt(totalOptions) + 1; // select 1 → totalOptions

        System.out.println("Selecting " + numberOfSelections + " random options.");

        Set<Integer> selectedIndexes = new HashSet<>();

        while (selectedIndexes.size() < numberOfSelections) {
            int randomIndex = random.nextInt(totalOptions); // safe, because we use subList
            selectedIndexes.add(randomIndex);
        }

        for (int index : selectedIndexes) {
            WebElement option = availableElements.get(index); // No out of bounds

            option.click();
            options.add(option.getText());
            log.info("Options Selected : " + option.getText());
            System.out.println("Selected option: " + option.getText());
        }
        return options;
    }

    public static void fileUpload(String filePath, WebElement element) throws AWTException, InterruptedException {
        // Click the label to open the file chooser dialog
        element.click();
        Robot robot = new Robot();
        //Thread.sleep(2000); // Wait for the dialog to appear
        robot.delay(2000);

        // Set the file path in the system clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Use Robot class to simulate keyboard actions


        // Press CTRL + V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Thread.sleep(1000); // Wait for the path to be pasted

        // Press ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }






}


