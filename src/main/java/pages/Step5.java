package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Step5 {
    private static Logger log = Logger.getLogger(Step5.class);
    private WebDriver driver;

    public Step5(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@aria-label='Navigate to Soundness of Project Plan']/span")
    private WebElement Step5;

    @FindBy(xpath = "//input[@id='projectProposal.budget.budgetFile']/parent::label/child::span")
    private WebElement UploadBudgetFile;

    @FindBy(xpath = "//label[starts-with(text(),'Please provide information on the supporting quotations')]/parent::div/div")
    private WebElement ProvideInformationDropdown;

    @FindBy(xpath = "//li[starts-with(text(),'Is applicable and is partially submitted')]/parent::ul/li")
    private List<WebElement> ProvideInformationDropdownOptions;

    @FindBy(xpath = "//span[contains(text(),'Upload ZIP File')]")
    private WebElement UploadCompressedFolder;

    @FindBy(xpath = "//input[@name='projectProposal.budget.totalProjectCost']")
    private WebElement ProjectTotalCost;

    





}
