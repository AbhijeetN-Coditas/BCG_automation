package test;

import data.TestData;
import org.testng.annotations.Test;
import utility.BaseTest;

import java.awt.*;
import java.io.IOException;
import java.util.Map;


public class Step1Form extends BaseTest {

    @Test(priority = 3, description = "Submit step1 with invalid data", groups = {"Login" })
    public void CreateProjectWithInvalidData() throws IOException, InterruptedException, AWTException {
        step1.enterLLPIncorporationNumber("ABC1234");
        //step1.enterCINHoldingCompany("sagagg");
        step1.subsidaryOfAnotherCompany();
        step1.enterAlternateContact("1234567899");
        step1.enterDesignation("Manager");
        step1.uploadCertificateOfRegistration("C:\\Users\\shail\\Downloads\\DummyFileUpload.pdf");
        //System.out.println(driver.getPageSource());
        step1.uploadDeclarationOfLegal("C:\\Users\\shail\\Downloads\\DummyFileUpload.pdf");
        step1.uploadSupportingDoc("C:\\Users\\shail\\Downloads\\DummyFileUpload.pdf");
        step1.uploadLatestAuditedUpload("C:\\Users\\shail\\Downloads\\DummyFileUpload.pdf");
        step1.financialStatement();
        step1.upload1FinanceReport("C:\\Users\\shail\\Downloads\\DummyFileUpload.pdf");
        step1.upload2FinanceReport("C:\\Users\\shail\\Downloads\\DummyFileUpload.pdf");
        step1.upload3FinanceReport("C:\\Users\\shail\\Downloads\\DummyFileUpload.pdf");
        step1.clickAssociationType();
        step1.clickNext();

    }
}
