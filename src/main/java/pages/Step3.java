package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Step3 {
    private static Logger log = Logger.getLogger(Step1.class);
    private WebDriver driver;

    public Step3(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//p[contains(text(),'Credentials, credibility and track record')]")
    WebElement step3;

    @FindBy(xpath = "//h6[contains(text(),'Project Lead 1')]")
    WebElement ProjectLeadsDropdown;

    @FindBy(xpath = "")


    public void clickStep3(){
        try{
            step3.click();
            log.info("Clicked on Step3");
        }catch(Exception e){
            log.error("Not clicked on Step3.");
            throw new RuntimeException();
        }
    }

    public void projectLeadsDropdown(){
        ProjectLeadsDropdown.click();

    }
}
