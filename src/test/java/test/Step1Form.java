package test;

import data.TestData;
import org.testng.annotations.Test;
import utility.BaseTest;

import java.io.IOException;
import java.util.Map;


public class Step1Form extends BaseTest {

    @Test(priority = 3, description = "Submit step1 with invalid data", groups = {"Login" })
    public void CreateProjectWithInvalidData() throws IOException {
        Map<String,String> data= TestData.GetOrderData().get("Invalid Data");
        step1.enterPAN(data.get("Permanent Account Number (PAN)*"));

    }
}
