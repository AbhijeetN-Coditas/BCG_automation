package pages;

import driverRepo.ConfigDriver;
import listners.ExtentReportListener;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utility.GenericMethods.click;
import static utility.GenericMethods.getText;

public class Projects {
    private static Logger log = Logger.getLogger(Projects.class);
    WebDriver driver = ConfigDriver.getDriver();

    @FindBy(xpath = "//p[text()='Primary Focus Area']/following-sibling::dd[@class='MuiTypography-root MuiTypography-body1 css-adi36o']")
    private WebElement primaryFocus;
    @FindBy(xpath = "//div[@id='mui-component-select-subFocusArea']")
    private WebElement  subfocusAreaFilter;
    @FindBy(xpath = "//div[@id='mui-component-select-primaryFocusArea']")
    private WebElement primaryFocusAreaFilter;
    @FindBy(xpath = "//div[@id=\"mui-component-select-primaryFocusArea\"]/div/div/span")
    private WebElement primaryFocusArea;
    @FindBy(xpath = "//button[text()='Academia to Industry: Discovery Marketplace']")
    private  WebElement academiaToIndustryTab;
    @FindBy(xpath = "//p[text()='New Chemical ']")
    private WebElement newChemicalTab;
    @FindBy(xpath = "//div[@class='MuiBox-root css-100genp']/div/p")
    private WebElement subFocusAreaTiles;
    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-1j1bogg'])[1]")
    private  WebElement subfocusTab;
    @FindBy(xpath = "//div[@id='mui-component-select-subFocusArea']/div/div/span[@class='MuiChip-label MuiChip-labelSmall css-b9zgoq']")
    private WebElement subFocusdropdown;
    @FindBy (xpath = "//button[text()='Applicant Sign up/ Sign in']")
    private  WebElement applicantSignUpSignInButton;


    public Projects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public  void ClickOnApplicantSignUpSignInButton() {
        try {
            click(applicantSignUpSignInButton);
            log.info("clicked on applicant sign up/sign in button");
        } catch (Exception e) {
            log.info("unable to click on applicant sign up/sign in button");
            throw new RuntimeException(e);
        }
    }

    public  void clickOnAcademiaToIndustryTab() {
        try{
            click(academiaToIndustryTab);
            log.info("clicked on academia to industry tab");
        } catch (Exception e) {
            log.info("unable to click on academia to industry tab");
            throw new RuntimeException(e);
        }
    }

    public void clickOnNewChemicalTab() {
        try{
            click(subfocusTab);
            log.info("clicked on new chemical tab");
        } catch (Exception e) {
            log.info("unable to click on new chemical tab");
            throw new RuntimeException(e);
        }
    }

    public String getTextFromTiles() {
        String str = "";
        try {
             str = getText(newChemicalTab);
        } catch(Exception e) {
            log.info("unable to get the text");
            throw new RuntimeException(e);
        }
        return str;
    }
    public String getTextFromSubFocusFilter() {
        String str = "";
        try {
            str = getText(subfocusAreaFilter);
        } catch(Exception e) {
            log.info("unable to get the text");
            throw new RuntimeException(e);
        }
        return str;
    }

    public String getTextFromPrimaryFocus() {
        String str = "";
        try {
            str = getText(primaryFocus);
        } catch(Exception e) {
            log.info("unable to get the text");
            throw new RuntimeException(e);
        }
        return str;
    }

}
