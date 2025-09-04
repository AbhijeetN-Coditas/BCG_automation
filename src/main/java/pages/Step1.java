package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.FileUpload;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static utility.GenericMethods.*;

public class Step1 {
    private static Logger log = Logger.getLogger(Step1.class);
    private WebDriver driver;
    private FileUpload upload;

    @FindBy(xpath = "//input[@name='particularsOfTheApplyingEntity.entityRegistrationNumber']")
    private WebElement LLP_Incorporation_Number;

    @FindBy(xpath = "//button[contains(text(), 'No')]")
    private WebElement NoButton;

    @FindBy(xpath = "//input[@name='particularsOfTheApplyingEntity.nodalOfficerAlternateContactNumber']")
    private WebElement AlternateNumber;

    @FindBy(xpath = "//input[@name='particularsOfTheApplyingEntity.nodalOfficerDesignation']")
    private WebElement Designation;

    @FindBy(xpath = "//label[@for='particularsOfTheApplyingEntity.certificateOfIncorporation']")
    private WebElement CertificateOfRegUpload;

    @FindBy(xpath = "//label[@for='particularsOfTheApplyingEntity.legalExistenceAndRDObjectives']")
    private WebElement DeclarationOfLegalUpload;

    @FindBy(xpath = "//label[@for='particularsOfTheApplyingEntity.governanceAndControlDeclaration']")
    private WebElement SupportingDocUpload;

    @FindBy(xpath = "//label[@for='particularsOfTheApplyingEntity.shareholdingPattern']")
    private WebElement LatestAuditedUpload;

    @FindBy(xpath = "//button[contains(text(),'FY23, FY24, and FY25')]")
    private WebElement FinancialStatement;

    @FindBy(xpath = "//label[@for='particularsOfTheApplyingEntity.file1']")
    private WebElement FinanceReportUpload1;

    @FindBy(xpath = "//label[@for='particularsOfTheApplyingEntity.file2']")
    private WebElement FinanceReportUpload2;

    @FindBy(xpath = "//label[@for='particularsOfTheApplyingEntity.file3']")
    private WebElement FinanceReportUpload3;

    @FindBy(xpath = "//div/div[@role='combobox']")
    private WebElement AssociationType;

    @FindBy(xpath = "//li[contains(text(),'Not associated')]")
    private WebElement NotAssociated;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    private WebElement NextButton;


    public Step1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void printPageSource() {
        System.out.println(driver.getPageSource());
    }

    public void enterLLPIncorporationNumber(String pan) {
        try {
            sendKeys(LLP_Incorporation_Number, pan);
            log.info("Entered PAN: " + pan);
        } catch (Exception e) {
            log.info("Failed to enter PAN: " + pan);
            throw new RuntimeException(e);
        }
    }

    public void subsidaryOfAnotherCompany() {
        NoButton.click();
    }

    public void enterAlternateContact(String number) {
        try {
            sendKeys(AlternateNumber, number);
            log.info("Enter AlterNate Number: " + number);
        } catch (Exception e) {
            log.info("Failed to enter Alternate number : " + number);
            throw new RuntimeException(e);
        }
    }

    public void enterDesignation(String designation) {
        try {
            sendKeys(Designation, designation);
            log.info("Enter Designation" + designation);
        } catch (Exception e) {
            log.info("Failed to enter Designation: " + designation);
            throw new RuntimeException(e);
        }
    }

    public void uploadCertificateOfRegistration(String filePath) throws AWTException, InterruptedException {
        try {
            upload = new FileUpload();
            upload.fileUpload(filePath, CertificateOfRegUpload);
            //waitForUploadPopupToDisappear(driver, 10); // <-- wait for popup to disappear
            closeUploadPopupIfPresent(driver, 10);
            log.info("Uploaded File: " + filePath);
        } catch (Exception e) {
            log.info("Failed to upload file : " + filePath);
            throw new RuntimeException(e);
        }
    }

    public void uploadDeclarationOfLegal(String filePath) throws AWTException, InterruptedException {
        try {
            closeUploadPopupIfPresent(driver, 10);
            upload.fileUpload(filePath, DeclarationOfLegalUpload);
            //waitForUploadPopupToDisappear(driver, 10); // <-- wait for popup to disappear
            log.info("Uploaded File: " + filePath);
        } catch (Exception e) {
            log.info("Failed to upload file : " + filePath);
            throw new RuntimeException(e);
        }
    }

    public void uploadSupportingDoc(String filePath) throws InterruptedException, AWTException {
        try {
            closeUploadPopupIfPresent(driver, 10);
            upload.fileUpload(filePath, SupportingDocUpload);
            //waitForUploadPopupToDisappear(driver, 10); // <-- wait for popup to disappear
            log.info("Uploaded File: " + filePath);
        } catch (Exception e) {
            log.info("Failed to upload file : " + filePath);
            throw new RuntimeException(e);
        }
    }

    public void uploadLatestAuditedUpload(String filePath) throws InterruptedException, AWTException {
        try {
            closeUploadPopupIfPresent(driver, 10);
            upload.fileUpload(filePath, LatestAuditedUpload);
            //waitForUploadPopupToDisappear(driver, 10); // <-- wait for popup to disappear
            log.info("Uploaded File: " + filePath);
        } catch (Exception e) {
            log.info("Failed to upload file : " + filePath);
            throw new RuntimeException(e);
        }
    }

    public void financialStatement() {
        FinancialStatement.click();
    }

    public void upload1FinanceReport(String filePath) throws InterruptedException, AWTException {
        try {
            upload.fileUpload(filePath, FinanceReportUpload1);
            //waitForUploadPopupToDisappear(driver, 10); // <-- wait for popup to disappear
            //closeUploadPopupIfPresent(driver,10);
            waitForUploadPopupToDisappear(driver, 10);
            log.info("Uploaded File: " + filePath);
        } catch (Exception e) {
            log.info("Failed to upload file : " + filePath);
            throw new RuntimeException(e);
        }
    }

    public void upload2FinanceReport(String filePath) throws InterruptedException, AWTException {
        try {
            // FileUpload upload=new FileUpload();
            //waitForUploadPopupToDisappear(driver, 10); // <-- wait for popup to disappear
            upload.fileUpload(filePath, FinanceReportUpload2);
            waitForUploadPopupToDisappear(driver, 10);
            log.info("Uploaded File: " + filePath);
        } catch (Exception e) {
            log.info("Failed to upload file : " + filePath);
            throw new RuntimeException(e);
        }
    }

    public void upload3FinanceReport(String filePath) throws InterruptedException, AWTException {
        try {
            // FileUpload upload=new FileUpload();
            //waitForUploadPopupToDisappear(driver, 10); // <-- wait for popup to disappear
            //closeUploadPopupIfPresent(driver,10);
            waitForUploadPopupToDisappear(driver, 10);
            upload.fileUpload(filePath, FinanceReportUpload3);
            log.info("Uploaded File: " + filePath);
        } catch (Exception e) {
            log.info("Failed to upload file : " + filePath);
            throw new RuntimeException(e);
        }
    }

    public void clickAssociationType() {
        AssociationType.click();
        NotAssociated.click();
    }

    public void clickNext() {
        NextButton.click();
    }
}
