package listners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import driverRepo.ConfigDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static constants.Constants.ExtendReportPath;

public class ExtentReportListener implements ITestListener, ISuiteListener {
    private Logger log = Logger.getLogger(ExtentReportListener.class);
    private static ThreadLocal<ExtentTest> logger = new ThreadLocal<>();
    private com.aventstack.extentreports.ExtentReports report;
    private ExtentSparkReporter htmlreport;
    @Override
    public void onStart(ISuite suite) {
        log.info("Invoked Test Suite On Start method in listners");

        report = new com.aventstack.extentreports.ExtentReports();

        htmlreport = new ExtentSparkReporter(ExtendReportPath);

        report.attachReporter(htmlreport);

        htmlreport.config().setDocumentTitle("PRIP_Report");// Setting Report Document Title

        htmlreport.config().setReportName("PRIP_Report");
    }
    @Override
    public void onTestStart(ITestResult result) {

        setLogger(result);
    }
    @Override
    public synchronized void onTestFailure(ITestResult result) {

        //String screenshot = ((TakesScreenshot) ConfigDriver.getDriver()).getScreenshotAs(OutputType.BASE64); // Take

    }
    public synchronized void setLogger(ITestResult result) {
        ExtentTest test;
        try {
             test = report.createTest(result.getMethod().getDescription());
        } catch (Exception e) {
            test = report.createTest(result.getMethod().getMethodName());
        }
        logger.set(test);
}
    @Override
    public synchronized void onTestSkipped(ITestResult result) {

    }
    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        log.info("Test Passed: " + result.getName());
        report.createTest(result.getName()).pass("Test passed successfully");
    }

    public static synchronized void logger(String str) {
        logger.get().info(str);
    }

    }
