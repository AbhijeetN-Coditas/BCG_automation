package test;

import org.testng.annotations.Test;
import utility.BaseTest;

public class Step3Form extends BaseTest {
    @Test(priority = 5, description = "Step3 submission form", groups = {"FormSubmission" })
    public void step3(){

        step3.clickStep3();
        //step3.researchprojectPriority();
    }
}
