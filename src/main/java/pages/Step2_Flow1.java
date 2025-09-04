package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utility.FileUpload;
import java.util.List;
import static utility.GenericMethods.selectRandomElement;
import static utility.GenericMethods.selectRandomMultipleOptions;

public class Step2_Flow1 {
    private static Logger log = Logger.getLogger(Step1.class);
    private WebDriver driver;
    private FileUpload upload;

    @FindBy(xpath="//label[contains(text(),'Research Project Sub-Priority Area')]")
    private WebElement emptySpace;

    @FindBy(xpath = "//p[contains(text(),'Project Overview')]")
    private WebElement step2start;

    @FindBy(xpath = "//div[contains(text(), 'Select research project area')]")
    private WebElement researchprojectdropdown;

    @FindBy(xpath="//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation8 MuiPopover-paper MuiMenu-paper css-unt79y']//ul//li")
    private List<WebElement> researchProjectPriorityDropdownAllOptions;

    //New Chemical Entity--------->>>>--------Research Project Sub-Priority
    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-ubifyk']//li")
    private List<WebElement> researchProjectSubPriorityDropdownAllOptions;

    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-ubifyk']//li")
    private List<WebElement> SPIDropdownOptions;

    @FindBy(xpath ="//p[contains(text(),'Select the Neglected Tropical Disease targeted')]/parent::div//table//tr[@class='MuiTableRow-root MuiTableRow-hover css-lcmlwl']")
    private List<WebElement> NeglectedTropicalDiseaseDropdown;

    @FindBy(xpath = "//p[contains(text(),'Select the Rare disease targeted')]/parent::div//table//tr[@class='MuiTableRow-root MuiTableRow-hover css-lcmlwl']")
    private List<WebElement> RareDiseaseDropdown;

    @FindBy(xpath = "//p[contains(text(),'Select the pathogen targeted')]/parent::div//table//tr[@class='MuiTableRow-root MuiTableRow-hover css-lcmlwl']")
    private List<WebElement> AntimicrobialResistancePriorityPathogensDropdown;

    @FindBy(xpath = "//p[contains(text(),'Select the pathogen family targeted')]/parent::div//table//tr[@class='MuiTableRow-root MuiTableRow-hover css-lcmlwl']")
    private List<WebElement> PandemicPreparednessPriorityPathogensDropdown;

    @FindBy(xpath = "//p[contains(text(),'Select the disease targeted')]/parent::div//table//tr[@class='MuiTableRow-root MuiTableRow-hover css-lcmlwl']")
    private List<WebElement> VaccineForVaccinePreventableDiseasesDropdown;

    @FindBy(xpath = "//li[contains(text(), 'New Chemical Entity')]")
    private WebElement newChemicalEntitydropdown;

    @FindBy(xpath = "//div[contains(text(), 'Select research project sub-area')]")
    private WebElement Sub_PriorityAreaDropdown;

    @FindBy(xpath = "//li[contains(text(),'Investigational new drug (with NO approved global reference')]")
    private WebElement investigationnewdrugdropdown;

    @FindBy(xpath = "//div[contains(text(),'Select strategic priority innovations')]")
    private WebElement StrategicPriorityInnovations;

    @FindBy(xpath = "//li[contains(text(),'Neglected Tropical Diseases relevant to India')]")
    private WebElement  NeglectedTropicalDropdown;

    @FindBy(xpath = "//td[contains(text(),'Dengue and chikungunya')]")
    private WebElement DengueAndChikungunyaradiobtn;

    @FindBy(xpath = "(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-10hwd1r'])[3]")
    private WebElement TRL_dropdown;

    @FindBy(xpath = "//li[contains(text(),'1. Ideation')]")
    private WebElement TRL_options;

    public Step2_Flow1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void step2(){
        step2start.click();
    }

    public void researchprojectPriority(){
        researchprojectdropdown.click();
//        WebElement option=selectRandomElement(researchProjectPriorityDropdownAllOptions);
//        String text= option.getText();
//        log.info("Option selected : "+ text);
//        if(text.equals("New Chemical Entity")){
//            researchProjectSubPriority();
//        }

        newChemicalEntitydropdown.click();
        newChemicalEntityOption();
    }

//    public void researchProjectSubPriority(){
//
//
//    }

    public void newChemicalEntityOption(){
        Sub_PriorityAreaDropdown.click();
        WebElement subPriorityOption = selectRandomElement(researchProjectSubPriorityDropdownAllOptions);
        String text = subPriorityOption.getText();
        subPriorityOption.click();
        log.info("Sub-Priority Option clicked.");

        StrategicPriorityInnovations.click();
        //WebElement SPIOption = selectRandomElement(SPIDropdownOptions);
        //SPIOption.click();
        List<String> selectedOptionsTexts =selectRandomMultipleOptions(SPIDropdownOptions, 1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();

        for (String textt : selectedOptionsTexts) {
            //String textt = texttt.trim();
            System.out.println("Processing dependent dropdown for: " + textt);

            if (textt.equalsIgnoreCase("Neglected Tropical Diseases relevant to India")) {
                selectRandomMultipleOptions(NeglectedTropicalDiseaseDropdown, 0);
            }
            else if (textt.equalsIgnoreCase("Rare Disease in India")) {
                selectRandomMultipleOptions(RareDiseaseDropdown, 0);
            }
            else if (textt.equalsIgnoreCase("Antimicrobial resistance priority pathogens")) {
                selectRandomMultipleOptions(AntimicrobialResistancePriorityPathogensDropdown, 0);
            }
            else if (textt.equalsIgnoreCase("Pandemic Preparedness priority pathogens")) {
                selectRandomMultipleOptions(PandemicPreparednessPriorityPathogensDropdown, 0);
            }
            else if (textt.equalsIgnoreCase("Vaccine for vaccine–preventable diseases")) {
                selectRandomMultipleOptions(VaccineForVaccinePreventableDiseasesDropdown, 0);
            }
            else {
                System.out.println("No matching dependent dropdown found for: " + textt);
            }
        }
    }


}
