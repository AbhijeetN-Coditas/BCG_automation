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
        Map<String,String> data= TestData.GetOrderData().get("Invalid Data");
        step1.enterLLPIncorporationNumber(data.get("Permanent Account Number (PAN)*"));
        //step1.enterCINHoldingCompany("sagagg");
        step1.subsidaryOfAnotherCompany();
        step1.enterAlternateContact("1234567899");
        step1.enterDesignation("Manager");
        step1.uploadCertificateOfRegistration("C:\\Users\\shail\\Downloads\\DummyFileUpload.pdf");
        step1.uploadDeclarationOfLegal("C:\\Users\\shail\\Downloads\\DummyFileUpload.pdf");
        step1.uploadSupportingDoc("C:\\Users\\shail\\Downloads\\DummyFileUpload.pdf");
        step1.uploadLatestAuditedUpload("C:\\Users\\shail\\Downloads\\DummyFileUpload.pdf");

    }
}
