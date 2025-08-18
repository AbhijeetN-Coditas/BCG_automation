package test;

import org.testng.annotations.Test;
import utility.BaseTest;
import utility.ReadMail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import static utility.GenericMethods.launchURL;

public class CreateProject extends BaseTest {

    @Test(priority = 2, description = "Login as Entity User", groups = {"Login" })
    public void CreateProject() throws IOException {
        dashboard.clickOnCreateProject();
        Random ran = new Random();
        int randomNum = ran.nextInt(1000);
        dashboard.enterProjectName("Development of a Scalable and Secure Cloud-Native Platform for Real-Time Analytics, Monitoring, and Automated Decision-Making Across Industries  " + randomNum);
        dashboard.clickOnSaveButton();
    }
}
