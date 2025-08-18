package test;

import org.testng.annotations.Test;
import utility.BaseTest;
import utility.ReadMail;

import javax.management.Descriptor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static utility.GenericMethods.launchURL;

public class EntityLogin extends BaseTest {
    @Test(priority = 1, description = "Login as Entity User", groups = {"Login" })
    public void Login() throws IOException {
        launchURL("https://eoi.coditas.org/");
        projects.ClickOnApplicantSignUpSignInButton();
        entitySignIn.clickEntityLockerSignIn();
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(userConfig);
        properties.load(fileInputStream);

        entitySignIn.enterMobileNumber(properties.getProperty("mobile"));
        entitySignIn.clickNextButton();
        entitySignIn.enterProfilePin(properties.getProperty("profilePin"));
        entitySignIn.clickNextButton();
            if(entitySignIn.isDisplayedOtpInput()) {
                entitySignIn.enterOtp(ReadMail.fetchOTPFromGmail());
                entitySignIn.otpSubmit();
            } else {
                System.out.println("OTP screen did NOT appear; skipping OTP step");
            }
    }
}
