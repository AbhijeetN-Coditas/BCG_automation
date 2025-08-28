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

import static utility.GenericMethods.sendKeys;
import static utility.GenericMethods.waitUntiElementClickable;

public class Step1 {
    private static Logger log = Logger.getLogger(Step1.class);


//    @FindBy(xpath = "//p[text()='Invalid entity incorporation / registration number']")
//    private WebElement PANErrorForInvalid;
//
//    @FindBy(xpath = "//p[text()='Please enter a valid CIN (e.g., L12345MH2020PLC123456)']")
//    private WebElement CINErrorForInvalid;
//
//    @FindBy(xpath = "//p[text()='Holding Company CIN is required when entity is a subsidiary']")
//    private WebElement CINErrorForEmpty;
//
//    @FindBy(xpath = "//p[text()='This field is mandatory']")
//    private WebElement mandatoryFieldError;
//
//    @FindBy(xpath = "//input[@name='particularsOfTheApplyingEntity.entityRegistrationNumber']")
//    private WebElement PANInputField;
//-----------------------------------------------------------------------------------------------------
    @FindBy(xpath="//input[@name='particularsOfTheApplyingEntity.entityRegistrationNumber']")
    private WebElement LLP_Incorporation_Number;

//    @FindBy(xpath = "//button[contains(text(), 'Yes')]")
//    private WebElement YesButton;
//
//        @FindBy(xpath = "//input[@name='particularsOfTheApplyingEntity.holdingCompanyCIN']")
//        WebElement CINHoldingCompany;
//
//        @FindBy(xpath = "//input[@name='particularsOfTheApplyingEntity.holdingCompanyName']")
//        WebElement LegalNameHoldingCompany;

    @FindBy(xpath = "//button[contains(text(), 'No')]")
    WebElement NoButton;

    @FindBy(xpath = "//input[@name='particularsOfTheApplyingEntity.nodalOfficerAlternateContactNumber']")
    WebElement AlternateNumber;

    @FindBy(xpath = "//input[@name='particularsOfTheApplyingEntity.nodalOfficerDesignation']")
    WebElement Designation;

    @FindBy(xpath = "//label[@for='particularsOfTheApplyingEntity.certificateOfIncorporation']")
    WebElement CertificateOfRegUpload;

    @FindBy(xpath = "//label[@for='particularsOfTheApplyingEntity.legalExistenceAndRDObjectives']")
    WebElement DeclarationOfLegalUpload;

    @FindBy(xpath="//label[@for='particularsOfTheApplyingEntity.governanceAndControlDeclaration']")
    WebElement SupportingDocUpload;

    @FindBy(xpath="//label[@for='particularsOfTheApplyingEntity.shareholdingPattern']")
    WebElement LatestAuditedUpload;









    public Step1(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterLLPIncorporationNumber(String pan){
        try {
            sendKeys(LLP_Incorporation_Number, pan);
            log.info("Entered PAN: " + pan);
        } catch (Exception e) {
            log.info("Failed to enter PAN: " + pan);
            throw new RuntimeException(e);
        }
    }

    public void subsidaryOfAnotherCompany(){
        NoButton.click();
    }

    public void enterAlternateContact(String number){
        try{
            sendKeys(AlternateNumber, number);
            log.info("Enter AlterNate Number: "+ number);
        }catch (Exception e){
            log.info("Failed to enter Alternate number : "+ number);
            throw new RuntimeException(e);
        }
    }

    public void enterDesignation(String designation){
        try{
            sendKeys(Designation, designation);
            log.info("Enter Designation" + designation);
        }catch(Exception e){
            log.info("Failed to enter Designation: "+ designation);
            throw new RuntimeException(e);
        }
    }

//    public void uploadSetCertificateOfReg(String filePath){
//        try{
//            CertificateOfRegUpload.click();
//            sendKeys(CertificateOfRegUpload, filePath);
//            log.info("Uploaded File: " + filePath);
//        }catch (Exception e){
//            log.info("Failed to upload file: " + filePath);
//            throw new RuntimeException(e);
//        }
//    }

    public void uploadCertificateOfRegistration(String filePath) throws AWTException, InterruptedException {
        FileUpload upload=new FileUpload();
        waitUntiElementClickable(CertificateOfRegUpload, 10);
        upload.fileUpload(filePath, CertificateOfRegUpload);
    }

    public void uploadDeclarationOfLegal(String filePath) throws AWTException, InterruptedException {
//        Thread.sleep(6000);
        waitUntiElementClickable(DeclarationOfLegalUpload, 10);
        FileUpload upload=new FileUpload();
        upload.fileUpload(filePath, DeclarationOfLegalUpload);
    }

    public void uploadSupportingDoc(String filePath) throws InterruptedException, AWTException {
//        Thread.sleep(9000);
        waitUntiElementClickable(SupportingDocUpload, 10);
        FileUpload upload=new FileUpload();
        upload.fileUpload(filePath, SupportingDocUpload);
        }

    public void uploadLatestAuditedUpload(String filePath) throws InterruptedException, AWTException {
       // Thread.sleep(9000);
        waitUntiElementClickable(LatestAuditedUpload, 10);
        FileUpload upload=new FileUpload();
        upload.fileUpload(filePath, LatestAuditedUpload);
    }





//    public void enterCINHoldingCompany(String CIN){
//        try {
//            sendKeys(CINHoldingCompany, CIN);
//            log.info("Entered CIN: " + CIN);
//        } catch (Exception e) {
//            log.info("Failed to enter CIN: " + CIN);
//            throw new RuntimeException(e);
//        }
//    }

















//    public String getPANErrorText() {
//        try {
//            return PANErrorForInvalid.getText();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public boolean isPANErrorDisplayed() {
//        try {
//            return PANErrorForInvalid.isDisplayed();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public String getCINErrorText() {
//        try {
//            return CINErrorForInvalid.getText();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public boolean isCINErrorDisplayed() {
//        try {
//            return CINErrorForInvalid.isDisplayed();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public String getCINErrorForEmptyText() {
//        try {
//            return CINErrorForEmpty.getText();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public boolean isCINErrorForEmptyDisplayed() {
//        try {
//            return CINErrorForEmpty.isDisplayed();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public String getMandatoryFieldErrorText() {
//        try {
//            return mandatoryFieldError.getText();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public boolean isMandatoryFieldErrorDisplayed() {
//        try {
//            return mandatoryFieldError.isDisplayed();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public  void enterPAN( String pan) {
//        try {
//            sendKeys(PANInputField, pan);
//            log.info("Entered PAN: " + pan);
//        } catch (Exception e) {
//            log.info("Failed to enter PAN: " + pan);
//            throw new RuntimeException(e);
//        }
//    }
}
