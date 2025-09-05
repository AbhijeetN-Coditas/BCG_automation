package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Step5 {
    private static Logger log = Logger.getLogger(Step1.class);
    private WebDriver driver;

    public Step5(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@aria-label='Navigate to Soundness of Project Plan']/span")
    WebElement Step5;


}
