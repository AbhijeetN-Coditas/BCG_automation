package pages;

import listners.ExtentReportListener;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.FileUpload;

import java.util.List;

public class Step4 {
    private static Logger log = Logger.getLogger(Step1.class);
    private WebDriver driver;
    private FileUpload upload;

    public Step4(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[contains(text(),'Project details')]")
    private WebElement Step4;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1evp3of']/following-sibling::button")
    private WebElement PrimaryindicationCheckbox;

    @FindBy(xpath = "//input[@placeholder='Enter target']")
    private WebElement TartgetIndicationTextbox;

    @FindBy(xpath = "//textarea[@placeholder='Enter text']")
    private List<WebElement> textArea;

    @FindBy(xpath = "//div[text()='Select dimension']")
    private WebElement productTechnologyOnsuperiorityDropdown;
    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-ubifyk']/li")
    private List<WebElement> productTechnologyOnsuperiorityDropdownOptions;

    @FindBy(xpath = "//textarea[@placeholder='Enter justification']")
    private WebElement justificationTextArea;

    @FindBy(xpath = "//label[@for='projectDetails.valueProposition.superiorityDimensions.0.supportingDocument']")
    private WebElement uploadSupportingDocument;

    @FindBy(xpath = "//textarea[@placeholder='Please describe the unique features of your project...']")
    private WebElement uniqueFeaturesTextArea;

    @FindBy(xpath = "//textarea[@placeholder='Please explain the technical advancement...']")
    private WebElement technicalAdvancementTextArea;

    @FindBy(xpath = "//div[@class='_yesno-group_ozp4x_1 MuiBox-root css-0']/button")
    private List<WebElement> yesNoRadioButtons;

    @FindBy(xpath = "//div[text()='Applicant Entity']")
    private WebElement ApplicantEntityDropdown;

    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-ubifyk']/li")
    private List<WebElement> ApplicantEntityDropdownOptions;

    @FindBy(xpath = "//label[text()='Current status of the patent for the core Intellectual Property of the project']/following-sibling::div")
    private WebElement currentStatusOfThePatentDropdown;

    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-ubifyk']/li")
    private List<WebElement> currentStatusOfThePatentDropdownOptions;

    @FindBy(xpath = "//input[@id=':rha:']")
    private WebElement patentApplicationNumberInput1;

    @FindBy(xpath = "//input[@id=':rhb:']")
    private WebElement patentTitle1;

    @FindBy(xpath = "//div[text()='Select patent status']")
    private WebElement patentStatusDropdown;

    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-ubifyk']/li")
    private List<WebElement> patentStatusDropdownOptions;

    @FindBy(xpath = "//div[text()='Select patent owner']")
    private WebElement patentOwnerDropdown;

    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-ubifyk']/li")
    private List<WebElement> patentOwnerDropdownOptions;

    @FindBy(xpath = "//input[@id=':rfj:']")
    private WebElement patentApplicationNumberInput2;

    @FindBy(xpath = "//input[@id=':rfk:']")
    private WebElement patentTitle2;

    @FindBy(xpath = "//div[text()='India']")
    private WebElement  countriesDropdown;

    @FindBy(xpath = "//div[@class='MuiToggleButtonGroup-root MuiToggleButtonGroup-horizontal css-i324f5']/button")
    private List<WebElement> classificationOfTheGrantedPatentOptions;

    @FindBy(xpath = "//input[@id=':rfl:']")
    private WebElement patentGeo;

    @FindBy(xpath = "//input[@id=':rfm:']")
    private WebElement posedRestrictions;

    @FindBy(xpath = "//input[@id=':rfn:']")
    private WebElement counteringMeasure;

    public void clickOnStep4() {
        try {
            Step4.isDisplayed();
            log.info("on step 4 page");
            ExtentReportListener.logger("on step 4 page");
        } catch (Exception e) {
            log.info("not able to land on step 4 page: " + e.getMessage());
            ExtentReportListener.logger("not able to land on step 4 page: " + e.getMessage());
            Assert.fail("not able to land on step 4 page");
        }
    }

    public void clickOnPrimaryindicationCheckbox() {
        try {
            PrimaryindicationCheckbox.click();
            log.info("clicked on primary indication checkbox");
            ExtentReportListener.logger("clicked on primary indication checkbox");
        } catch (Exception e) {
            log.info("not able to click on primary indication checkbox: " + e.getMessage());
            ExtentReportListener.logger("not able to click on primary indication checkbox: " + e.getMessage());
            Assert.fail("not able to click on primary indication checkbox");
        }
    }
    public void enterTargetIndicationName(String targetIndication) {
        try {
            TartgetIndicationTextbox.sendKeys(targetIndication);
            log.info("entered target indication Name: " + targetIndication);
            ExtentReportListener.logger("entered target indication Name: " + targetIndication);
        } catch (Exception e) {
            log.info("not able to enter target indication Name: " + e.getMessage());
            ExtentReportListener.logger("not able to enter target indication Name: " + e.getMessage());
            Assert.fail("not able to enter target indication Name");
        }
    }

    public void enterTextInTextArea(int index, String text) {
        try {
            textArea.get(index).sendKeys(text);
            log.info("entered text in text area: " + text);
            ExtentReportListener.logger("entered text in text area: " + text);
        } catch (Exception e) {
            log.info("not able to enter text in text area: " + e.getMessage());
            ExtentReportListener.logger("not able to enter text in text area: " + e.getMessage());
            Assert.fail("not able to enter text in text area");
        }
    }

    public void selectFromProductTechnologyOnsuperiorityDropdown(int idx ) {
        try {
            productTechnologyOnsuperiorityDropdown.click();
            productTechnologyOnsuperiorityDropdownOptions.get(idx).click();
            log.info("selected option from product technology on superiority dropdown: " + productTechnologyOnsuperiorityDropdownOptions.get(idx).getText());
            ExtentReportListener.logger("selected option from product technology on superiority dropdown: " + productTechnologyOnsuperiorityDropdownOptions.get(idx).getText());
        } catch (Exception e) {
            log.info("not able to select option from product technology on superiority dropdown: " + e.getMessage());
            ExtentReportListener.logger("not able to select option from product technology on superiority dropdown: " + e.getMessage());
            Assert.fail("not able to select option from product technology on superiority dropdown");
        }
    }
    public void enterJustificationTextArea(String justification) {
        try {
            justificationTextArea.sendKeys(justification);
            log.info("entered justification text area: " + justification);
            ExtentReportListener.logger("entered justification text area: " + justification);
        } catch (Exception e) {
            log.info("not able to enter justification text area: " + e.getMessage());
            ExtentReportListener.logger("not able to enter justification text area: " + e.getMessage());
            Assert.fail("not able to enter justification text area");
        }
    }
    public void uploadSupportingDocument(String filePath) {
        try {
            upload = new FileUpload();
            upload.fileUpload(filePath,uploadSupportingDocument);
            log.info("uploaded supporting document" );
            ExtentReportListener.logger("uploaded supporting document" );
        } catch (Exception e) {
            log.info("not able to upload supporting document: " + e.getMessage());
            ExtentReportListener.logger("not able to upload supporting document: " + e.getMessage());
            Assert.fail("not able to upload supporting document");
        }
    }

    public void enterUniqueFeaturesTextArea(String uniqueFeatures) {
        try {
            uniqueFeaturesTextArea.sendKeys(uniqueFeatures);
            log.info("entered unique features text area: " + uniqueFeatures);
            ExtentReportListener.logger("entered unique features text area: " + uniqueFeatures);
        } catch (Exception e) {
            log.info("not able to enter unique features text area: " + e.getMessage());
            ExtentReportListener.logger("not able to enter unique features text area: " + e.getMessage());
            Assert.fail("not able to enter unique features text area");
        }
    }

    public void enterTechnicalAdvancementTextArea(String technicalAdvancement) {
        try {
            technicalAdvancementTextArea.sendKeys(technicalAdvancement);
            log.info("entered technical advancement text area: " + technicalAdvancement);
            ExtentReportListener.logger("entered technical advancement text area: " + technicalAdvancement);
        } catch (Exception e) {
            log.info("not able to enter technical advancement text area: " + e.getMessage());
            ExtentReportListener.logger("not able to enter technical advancement text area: " + e.getMessage());
            Assert.fail("not able to enter technical advancement text area");
        }
    }
    public void clickOnYesNoRadioButtons(int idx) {
        try {
            yesNoRadioButtons.get(idx).click();
            log.info("clicked on yes no radio button: " + yesNoRadioButtons.get(idx).getText());
            ExtentReportListener.logger("clicked on yes no radio button: " + yesNoRadioButtons.get(idx).getText());
        } catch (Exception e) {
            log.info("not able to click on yes no radio button: " + e.getMessage());
            ExtentReportListener.logger("not able to click on yes no radio button: " + e.getMessage());
            Assert.fail("not able to click on yes no radio button");
        }
    }
    
    public void selectFromApplicantEntityDropdown(int idx ) {
        try {
            ApplicantEntityDropdown.click();
            ApplicantEntityDropdownOptions.get(idx).click();
            log.info("selected option from applicant entity dropdown: " + ApplicantEntityDropdownOptions.get(idx).getText());
            ExtentReportListener.logger("selected option from applicant entity dropdown: " + ApplicantEntityDropdownOptions.get(idx).getText());
        } catch (Exception e) {
            log.info("not able to select option from applicant entity dropdown: " + e.getMessage());
            ExtentReportListener.logger("not able to select option from applicant entity dropdown: " + e.getMessage());
            Assert.fail("not able to select option from applicant entity dropdown");
        }
    }
    
    public void selectFromCurrentStatusOfThePatentDropdown(int idx ) {
        try {
            currentStatusOfThePatentDropdown.click();
            currentStatusOfThePatentDropdownOptions.get(idx).click();
            log.info("selected option from current status of the patent dropdown: " + currentStatusOfThePatentDropdownOptions.get(idx).getText());
            ExtentReportListener.logger("selected option from current status of the patent dropdown: " + currentStatusOfThePatentDropdownOptions.get(idx).getText());
        } catch (Exception e) {
            log.info("not able to select option from current status of the patent dropdown: " + e.getMessage());
            ExtentReportListener.logger("not able to select option from current status of the patent dropdown: " + e.getMessage());
            Assert.fail("not able to select option from current status of the patent dropdown");
        }
    }

    public void enterPatentApplicationNumber1(String patentApplicationNumber) {
        try {
            patentApplicationNumberInput1.sendKeys(patentApplicationNumber);
            log.info("entered patent application number: " + patentApplicationNumber);
            ExtentReportListener.logger("entered patent application number: " + patentApplicationNumber);
        } catch (Exception e) {
            log.info("not able to enter patent application number: " + e.getMessage());
            ExtentReportListener.logger("not able to enter patent application number: " + e.getMessage());
            Assert.fail("not able to enter patent application number");
        }
    }

    public void enterPatentTitle1(String patentTitleStr) {
        try {
            patentTitle1.sendKeys(patentTitleStr);
            log.info("entered patent title: " + patentTitleStr);
            ExtentReportListener.logger("entered patent title: " + patentTitleStr);
        } catch (Exception e) {
            log.info("not able to enter patent title: " + e.getMessage());
            ExtentReportListener.logger("not able to enter patent title: " + e.getMessage());
            Assert.fail("not able to enter patent title");
        }
    }

    public void selectFromPatentStatusDropdown(int idx ) {
        try {
            patentStatusDropdown.click();
            patentStatusDropdownOptions.get(idx).click();
            log.info("selected option from patent status dropdown: " + patentStatusDropdownOptions.get(idx).getText());
            ExtentReportListener.logger("selected option from patent status dropdown: " + patentStatusDropdownOptions.get(idx).getText());
        } catch (Exception e) {
            log.info("not able to select option from patent status dropdown: " + e.getMessage());
            ExtentReportListener.logger("not able to select option from patent status dropdown: " + e.getMessage());
            Assert.fail("not able to select option from patent status dropdown");
        }
    }

    public void selectFromPatentOwnerDropdown(int idx ) {
        try {
            patentOwnerDropdown.click();
            patentOwnerDropdownOptions.get(idx).click();
            log.info("selected option from patent owner dropdown: " + patentOwnerDropdownOptions.get(idx).getText());
            ExtentReportListener.logger("selected option from patent owner dropdown: " + patentOwnerDropdownOptions.get(idx).getText());
        } catch (Exception e) {
            log.info("not able to select option from patent owner dropdown: " + e.getMessage());
            ExtentReportListener.logger("not able to select option from patent owner dropdown: " + e.getMessage());
            Assert.fail("not able to select option from patent owner dropdown");
        }
    }

    public void enterPatentApplicationNumber2(String patentApplicationNumber) {
        try {
            patentApplicationNumberInput2.sendKeys(patentApplicationNumber);
            log.info("entered patent application number: " + patentApplicationNumber);
            ExtentReportListener.logger("entered patent application number: " + patentApplicationNumber);
        } catch (Exception e) {
            log.info("not able to enter patent application number: " + e.getMessage());
            ExtentReportListener.logger("not able to enter patent application number: " + e.getMessage());
            Assert.fail("not able to enter patent application number");
        }
    }

    public void enterPatentTitle2(String patentTitleStr) {
        try {
            patentTitle2.sendKeys(patentTitleStr);
            log.info("entered patent title: " + patentTitleStr);
            ExtentReportListener.logger("entered patent title: " + patentTitleStr);
        } catch (Exception e) {
            log.info("not able to enter patent title: " + e.getMessage());
            ExtentReportListener.logger("not able to enter patent title: " + e.getMessage());
            Assert.fail("not able to enter patent title");
        }
    }

    public void enterPatentGeo(String patentGeoStr) {
        try {
            patentGeo.sendKeys(patentGeoStr);
            log.info("entered patent geo: " + patentGeoStr);
            ExtentReportListener.logger("entered patent geo: " + patentGeoStr);
        } catch (Exception e) {
            log.info("not able to enter patent geo: " + e.getMessage());
            ExtentReportListener.logger("not able to enter patent geo: " + e.getMessage());
            Assert.fail("not able to enter patent geo");
        }
    }

    public void enterPosedRestrictions(String posedRestrictionsStr) {
        try {
            posedRestrictions.sendKeys(posedRestrictionsStr);
            log.info("entered posed restrictions: " + posedRestrictionsStr);
            ExtentReportListener.logger("entered posed restrictions: " + posedRestrictionsStr);
        } catch (Exception e) {
            log.info("not able to enter posed restrictions: " + e.getMessage());
            ExtentReportListener.logger("not able to enter posed restrictions: " + e.getMessage());
            Assert.fail("not able to enter posed restrictions");
        }
    }

    public void enterCounteringMeasure(String counteringMeasureStr) {
        try {
            counteringMeasure.sendKeys(counteringMeasureStr);
            log.info("entered countering measure: " + counteringMeasureStr);
            ExtentReportListener.logger("entered countering measure: " + counteringMeasureStr);
        } catch (Exception e) {
            log.info("not able to enter countering measure: " + e.getMessage());
            ExtentReportListener.logger("not able to enter countering measure: " + e.getMessage());
            Assert.fail("not able to enter countering measure");
        }
    }
}
