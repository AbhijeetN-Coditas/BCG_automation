package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utility.GenericMethods.sendKeys;

public class Step1 {
    private static Logger log = Logger.getLogger(Step1.class);


    @FindBy(xpath = "//p[text()='Invalid entity incorporation / registration number']")
    private WebElement PANErrorForInvalid;

    @FindBy(xpath = "//p[text()='Please enter a valid CIN (e.g., L12345MH2020PLC123456)']")
    private WebElement CINErrorForInvalid;

    @FindBy(xpath = "//p[text()='Holding Company CIN is required when entity is a subsidiary']")
    private WebElement CINErrorForEmpty;

    @FindBy(xpath = "//p[text()='This field is mandatory']")
    private WebElement mandatoryFieldError;

    @FindBy(xpath = "//input[@name='particularsOfTheApplyingEntity.entityRegistrationNumber']")
    private WebElement PANInputField;


    public Step1(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getPANErrorText() {
        try {
            return PANErrorForInvalid.getText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isPANErrorDisplayed() {
        try {
            return PANErrorForInvalid.isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getCINErrorText() {
        try {
            return CINErrorForInvalid.getText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isCINErrorDisplayed() {
        try {
            return CINErrorForInvalid.isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getCINErrorForEmptyText() {
        try {
            return CINErrorForEmpty.getText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isCINErrorForEmptyDisplayed() {
        try {
            return CINErrorForEmpty.isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getMandatoryFieldErrorText() {
        try {
            return mandatoryFieldError.getText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isMandatoryFieldErrorDisplayed() {
        try {
            return mandatoryFieldError.isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public  void enterPAN( String pan) {
        try {
            sendKeys(PANInputField, pan);
            log.info("Entered PAN: " + pan);
        } catch (Exception e) {
            log.info("Failed to enter PAN: " + pan);
            throw new RuntimeException(e);
        }
    }
}
