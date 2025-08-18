package pages;

import driverRepo.ConfigDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utility.GenericMethods.click;
import static utility.GenericMethods.sendKeys;

public class EntitySignIn {
    private static Logger log = Logger.getLogger(EntitySignIn.class);

    //WebDriver driver = ConfigDriver.getDriver();

    @FindBy(xpath = "//button[text()='Sign in via Entity Locker']")
    private WebElement entityLockerSignInButton;
    @FindBy(id = "mobile")
    private WebElement mobileNumberInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement nextButton;
    @FindBy(id = "profilepin")
    private WebElement profilePinInput;
    @FindBy(id="a_otp_1")
    private WebElement otpInput;
    @FindBy(id = "otp_button")
    private WebElement otpSubmitButton;

    public EntitySignIn(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickEntityLockerSignIn() {
        try{
            click(entityLockerSignInButton);
            log.info("clicked on Entity locker sign in button");
        } catch (Exception e) {
            log.info("Unable to click on Entity locker sign in button");
            throw new RuntimeException(e);
        }

    }
    public void enterMobileNumber(String mobileNumber) {
        try {
            sendKeys(mobileNumberInput,mobileNumber);
            log.info("Entered mobile number: " + mobileNumber);
        } catch (Exception e) {
            log.error("Failed to enter mobile number: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public void clickNextButton() {
        try {
            click(nextButton);
            log.info("Clicked on Next button");
        } catch (Exception e) {
            log.error("Failed to click submit button: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public void enterProfilePin(String profilePin) {
        try {
            sendKeys(profilePinInput, profilePin);
            log.info("Entered profile pin: " + profilePin);
        } catch (Exception e) {
            log.error("Failed to enter profile pin: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public void enterOtp(String otp) {
        try {
            sendKeys(otpInput, otp);
            log.info("Entered OTP: " + otp);
        } catch (Exception e) {
            log.error("Failed to enter OTP: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public boolean isDisplayedOtpInput() {
        try {
            boolean isDisplayed = otpInput.isDisplayed();
            log.info("OTP input field is displayed: " + isDisplayed);
            return isDisplayed;
        } catch (NoSuchElementException | TimeoutException e) {
            log.info("OTP input not displayed : " + e.getMessage());
            return false;
        } catch (Exception e) {
            log.error("Unexpected error while checking OTP input: " + e.getMessage());
            return false;
        }
    }

    public void otpSubmit() {
        try {
            click(otpSubmitButton);
            log.info("Clicked on OTP submit button");
        } catch (Exception e) {
            log.error("Failed to click submit button: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
