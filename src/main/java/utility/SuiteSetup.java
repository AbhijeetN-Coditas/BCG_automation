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

import static utility.ReadExcel.readExcelAsTestCases;


public class SuiteSetup  extends Constants {
    private static Logger log;

    @Parameters("Browser")
    @BeforeSuite
    public void preRequisite(String browser) {
        configureLogger();
        //TestData.SetOrderData(readExcelAsTestCases(InputExcelFile,"Sheet1"));
        ConfigDriver.setDriver(browser);
        pageInitialize();
    }

    protected void pageInitialize() {
        projects = ObjectRepository.ProjectInstance();
        entitySignIn = ObjectRepository.EntitySignInInstance();
        dashboard = ObjectRepository.DashboardInstance();
        step1 = ObjectRepository.Step1Instance();
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
