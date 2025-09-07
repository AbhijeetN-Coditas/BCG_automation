package utility;

import constants.Constants;
import data.TestData;
import driverRepo.ConfigDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static utility.ReadExcel.readExcelAsTestCases;


public class SuiteSetup  extends Constants {
    private static Logger log;

    @Parameters("Browser")
    @BeforeSuite
    public void preRequisite(String browser) throws IOException {
        configureLogger();

        Properties prop = new Properties();

        FileInputStream is = new FileInputStream(new File(userConfig1));

        prop.load(is);
        Constants.harshadAppPass=prop.getProperty("pass");
        Constants.harshadEmail=prop.getProperty("mail");
        TestData.SetOrderData(readExcelAsTestCases(InputExcelFile,"Sheet1"));
        ConfigDriver.setDriver(browser);
        pageInitialize();
    }

    protected void pageInitialize() {
        projects = ObjectRepository.ProjectInstance();
        entitySignIn = ObjectRepository.EntitySignInInstance();
        dashboard = ObjectRepository.DashboardInstance();
        step1 = ObjectRepository.Step1Instance();
        step2Flow1 = ObjectRepository.Step2_Flow1Instance();
        step3 = ObjectRepository.Step3Instance();
        step5 = ObjectRepository.Step5Instance();
    }
    private void configureLogger() {

        PropertyConfigurator.configure(log4jPath);

        log = Logger.getLogger(SuiteSetup.class);

        log.info("Configured Logger File");
    }

//    @AfterSuite
//    public void postRequisite() {
//        ConfigDriver.quitDriver();
//    }
}
