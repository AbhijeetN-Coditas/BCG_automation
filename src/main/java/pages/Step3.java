package pages;

import listners.ExtentReportListener;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.util.List;

import static constants.Constants.pdfFilePath;
import static utility.GenericMethods.fileUpload;

public class Step3 {
    private static Logger log = Logger.getLogger(Step3.class);
    private WebDriver driver;

    public Step3(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[contains(text(),'Credentials, credibility and track record')]")
    private WebElement step3;

    @FindBy(xpath = "//h6[contains(text(),'Project Lead 1')]")
    private WebElement ProjectLeadsDropdown;

    @FindBy(xpath = "//label[contains(text(),'Name')]/following-sibling::div//input[@name='projectTeam.projectLeads[0].name']")
    private WebElement LeadName;

    @FindBy(xpath = "//label[contains(text(),'Time contribution to this project (%)')]/following-sibling::div//input[@name='projectTeam.projectLeads[0].timeContributedToProject']")
    private WebElement ContributionPercentage;

    @FindBy(xpath = "//label[contains(text(),'Email address')]/following-sibling::div//input[@name='projectTeam.projectLeads[0].email']")
    private WebElement EmailAddress;

    @FindBy(xpath = "//label[contains(text(),'Designation')]/following-sibling::div//input[@name='projectTeam.projectLeads[0].designation']")
    private WebElement Designation;

    @FindBy(xpath = "//label[contains(text(),'Highest degree of qualification')]/following-sibling::div")
    private WebElement HighestDegreeDropdown;

    @FindBy(xpath = "//li[contains(text(),'Ph.D./Equivalent')]/parent::ul//li")
    private List<WebElement> HighestDegreeDropdownOptions;

    @FindBy(xpath = "//label[contains(text(),'Area of qualification')]/following-sibling::div//input[@name='projectTeam.projectLeads[0].qualificationArea']")
    private WebElement AreaOfQualification;

    @FindBy(xpath = "//label[contains(text(),'Years of Relevant R&D Experience in project’s research area*')]/following-sibling::div")
    private WebElement YearsOfRDExperience;

    @FindBy(xpath = "//li[contains(text(),'<10 Years')]/parent::ul//li")
    private List<WebElement> YearsOfRDExperienceOptions;

    @FindBy(xpath = "//p[starts-with(text(),'Has the lead in the past 10')]/following-sibling::div//button[contains(text(),'No')]")
    private WebElement past10yearExperience;

    @FindBy(xpath = "//label[starts-with(text(),'What is the number of patents granted')]/following-sibling::div//input")
    private WebElement NumbersOfPatentGranted;

    @FindBy(xpath = "//input[@name='projectTeam.projectLeads[0].patents[0].patentNumber']")
    private WebElement PatentNumber1;

    @FindBy(xpath = "//input[@name='projectTeam.projectLeads[0].patents[0].patentTitle']")
    private WebElement PatentTitle1;

    @FindBy(xpath = "//span[contains(text(),'Upload PDF File')]")
    private WebElement PatentDocumentUpload;

    @FindBy(xpath = "//input[@name='projectTeam.projectLeads[0].hIndex']")
    private WebElement HIndex;

    @FindBy(xpath = "//input[@name='projectTeam.projectLeads[0].topCitedPapers[0].title']")
    private WebElement TitlePublishArticle;

    @FindBy(xpath = "//input[@name='projectTeam.projectLeads[0].topCitedPapers[0].publicationName']")
    private WebElement NameOfPublication;

    @FindBy(xpath = "//input[@name='projectTeam.projectLeads[0].topCitedPapers[0].numberOfCitations']")
    private WebElement NumberOfCitations;

    @FindBy(xpath = "//label[starts-with(text(),'Please select all relevant experience applicable to the project')]/following-sibling::div")
    private WebElement RelevantYearExperienceDropdown;

    @FindBy(xpath = "//li[contains(text(),'Advised/Mentored startups in project domain')]/parent::ul")
    private List<WebElement> RelevantYearExperienceDropdownOptions;

    @FindBy(xpath = "//*[starts-with(text(),'Number of citations')]")
    private WebElement RelevantYearExperienceDropdownClose;

    @FindBy(xpath = "//p[starts-with(text(),'Does the project lead have experience raising capital from')]/parent::div/child::div//button[contains(text(),'No')]")
    private WebElement RaisingCapitalNoButton;

    @FindBy(xpath = "//input[@id='projectTeam.projectLeads[0].resume']/following-sibling::span")
    private WebElement ResumeUpload;

    @FindBy(xpath = "//label[contains(text(),'Expertise-based role*')]/parent::div/div")
    private WebElement ExpertiseBasedDropdown;

    @FindBy(xpath = "//li[contains(text(),'Analytical Chemist')]/parent::ul/li")
    private List<WebElement> ExpertiseBasedDropdownOptions;

    @FindBy(xpath = "//label[contains(text(),'Capacity on the project*')]/parent::div/child::div")
    private WebElement CapacityOfProjectDropdown;

    @FindBy(xpath = "//li[contains(text(),'Full-time on this project')]/parent::ul/li")
    private List<WebElement> CapacityOfProjectDropdownOptions;

    @FindBy(xpath = "//label[contains(text(),'Association with the applicant*')]/parent::div/div")
    private WebElement AssociationWithApplicantDropdown;

    @FindBy(xpath = "//li[contains(text(),'In-house')]/parent::ul/li")
    private List<WebElement> AssociationWithApplicantDropdownOptions;

    @FindBy(xpath = "//label[contains(text(),'Number of members*')]/parent::div/child::div//input")
    private WebElement NumberOfMembers;

    @FindBy(xpath = "//label[contains(text(),'Current status of such members*')]/parent::div/div")
    private WebElement CurrentStatusMembersDropdown;

    @FindBy(xpath = "//li[contains(text(),'Currently involved')]/parent::ul/li")
    private List<WebElement> CurrentStatusMembersDropdownOptions;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    private WebElement NextButton;


    public void clickStep3() {
        try {
            step3.click();
            log.info("Clicked on Step3");
        } catch (Exception e) {
            log.error("Not clicked on Step3.");
            throw new RuntimeException();
        }
    }

    public void projectLeadsDropdown() {
        try {
            //  ProjectLeadsDropdown.click();
            log.info("Project Leads dropdown clicked.");

            //  ProjectLeadsDropdown.click();
            LeadName.sendKeys("Harshad");
            log.info("Name entered ");

            // ProjectLeadsDropdown.click();
            ContributionPercentage.sendKeys("74");
            log.info("Percentage entered ");

            EmailAddress.sendKeys("test@gmail.com");
            log.info("Email entered ");

            Designation.sendKeys("Associate Director Reasearch");
            log.info("Designation entered");

            HighestDegreeDropdown.click();
            log.info("Clicked on Highest Degree Dropdown");

            HighestDegreeDropdownOptions.get(3).click();
            log.info("Higher Education Dropdown Option selected ");

            AreaOfQualification.sendKeys("Pharmacodynamics");
            log.info("Area of qualification entered successfully");

            YearsOfRDExperience.click();
            log.info("Clicked on Years on R&D experience dropdown");

            YearsOfRDExperienceOptions.get(2).click();
            log.info("Years of experience Dropdown Option selected ");

            past10yearExperience.click();
            log.info("Clicked on No button ");

            NumbersOfPatentGranted.sendKeys("4");
            log.info("Entered Number of Patent granted ");

        } catch (Exception e) {
            log.info("Unable to click on Project Leads Dropdown for input fields: " + e.getMessage());
            ExtentReportListener.logger("Unable to click on Project Leads Dropdown for input fields: " + e.getMessage());
            Assert.fail("Unable to click on Project Leads Dropdown for input fields ");
        }
    }

    public void numberOfPatentGranted(String patentNumber) {
        try {
            PatentNumber1.sendKeys(patentNumber);
            log.info("Entered Patent number");

            PatentTitle1.sendKeys("Pharmacology Research Development");
            log.info("Entered Patent Title");

            fileUpload(pdfFilePath, PatentDocumentUpload);
            log.info("Patent Document file uploaded successfully");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void HIndex() {
        try {
            HIndex.sendKeys("1234");
            log.info("H-Index entered");

            TitlePublishArticle.sendKeys("Benefits of Pharmacology");
            log.info("Title of article entered");

            NameOfPublication.sendKeys("Sun Pharma");
            log.info("Name of Publication entered : ");

            NumberOfCitations.sendKeys("1234");
            log.info("Number of citations entered : ");
        } catch (Exception e) {
            log.info("Unable to entered H-Index input fields :" + e.getMessage());
            ExtentReportListener.logger("Unable to entered H-Index input fields :" + e.getMessage());
            Assert.fail("Unable to entered H-Index input fields :");
        }
    }

    public void relevantExpertiesDropdown() {
        try {
            RelevantYearExperienceDropdown.click();
            log.info("Clicked on RelevantYear Expertise dropdown");

            RelevantYearExperienceDropdownOptions.get(0).click();

            // RelevantYearExperienceDropdownOptions.get(5).click();
            log.info("Relevant year dropdown options selected");

            Actions alt = new Actions(driver);
            alt.moveToElement(RelevantYearExperienceDropdownClose).perform();
            alt.click(RelevantYearExperienceDropdownClose).perform();
            log.info("Relevant year dropdown closed.");

            RaisingCapitalNoButton.click();
            log.info("Raising Capital No button clicked");
        } catch (Exception e) {
            log.info("Unable to select options from Relevant Year Experience dropdown");
            Assert.fail("Unable to select options from Relevant Year Experience dropdown");
        }

        try {
            fileUpload(pdfFilePath, ResumeUpload);
            log.info("Resume file uploaded");
        }catch (Exception e){
            log.info("Unable to upload Resume file : "+e.getMessage());
            Assert.fail("Unable to upload Resume file : "+e.getMessage());
            }
    }

    public void projectMembers(){
        try{
        ExpertiseBasedDropdown.click();
        log.info("Clicked on Expertise based dropdown");

        ExpertiseBasedDropdownOptions.get(1).click();
        log.info(" Expertise based dropdown selected");
        }catch(Exception e){
            log.info("Unable to click on Expertise Based Dropdown option" +e.getMessage());
        }
        try {
            CapacityOfProjectDropdown.click();
            log.info("Clicked on Capacity on project dropdown");

            CapacityOfProjectDropdownOptions.get(0).click();
            log.info("Capacity of project dropdown option selected");
        }catch(Exception e){
            log.info("Unable to click on Capacity of Project Dropdown option");
            Assert.fail("Unable to click on Capacity of Project Dropdown option");
        }
        try{
            AssociationWithApplicantDropdown.click();
            log.info("Clicked on Association with Applicant dropdown");

            AssociationWithApplicantDropdownOptions.get(0).click();
            log.info("Association with applicant option selected");
        }catch (Exception e){
            log.info("Unable to click on Association with applicant option");
            Assert.fail("Unable to click on Association with applicant option");
        }
        try{
            NumberOfMembers.sendKeys("15");
            log.info("Number of members entered");
        } catch (Exception e) {
            log.info("Unable to entered number of members");
            Assert.fail("Unable to entered number of members");
        }

        try{
            CurrentStatusMembersDropdown.click();
            log.info("Clicked on Current status Members dropdown");

            CurrentStatusMembersDropdownOptions.get(0).click();
            log.info("Current status Members dropdown option selected");

            NextButton.click();
        }catch (Exception e){
            log.info("Unable to selected option from Current status Members dropdown");
            Assert.fail("Unable to selected option from Current status Members dropdown");
        }
    }
}