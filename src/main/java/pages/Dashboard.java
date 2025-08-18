package pages;

import driverRepo.ConfigDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utility.GenericMethods.click;
import static utility.GenericMethods.sendKeys;

public class Dashboard {

    private static Logger log = Logger.getLogger(Dashboard.class);

    public Dashboard(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Create Project']")
    private WebElement createProject;
    @FindBy(xpath = "//input[@placeholder='Enter the name of the project']")
    private WebElement projectNameInput;
    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    public void clickOnCreateProject() {
        try {
            click(createProject);
            log.info("Clicked on Create Project");
        } catch (Exception e) {
            log.info("Failed to click on Create Project: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public void enterProjectName(String projectName) {
        try {
            sendKeys(projectNameInput, projectName);
            log.info("Entered project name: " + projectName);
        } catch (Exception e) {
            log.info("Failed to enter project name: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public void clickOnSaveButton() {
        try {
            click(saveButton);
            log.info("Clicked on Save button");
        } catch (Exception e) {
            log.info("Failed to click on Save button: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
