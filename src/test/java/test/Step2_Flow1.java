package test;

import org.testng.annotations.Test;
import utility.BaseTest;

public class Step2_Flow1 extends BaseTest {

    @Test(priority = 4, description = "Step2 submission Flow1", groups = {"FormSubmission" })
    public void step2Flow1() throws InterruptedException {

        step2Flow1.step2();
        step2Flow1.selectResearchProjectPriority(0);
        step2Flow1.selectResearchProjectSubPriorityArea(0);
        step2Flow1.selectStrategicPriorityInnovationsArea(0);
        step2Flow1.selectSPISubAreaOfProject();
        step2Flow1.selectCompleteTRLStage(0);
        step2Flow1.selectStatusAndRequirement(0);
        step2Flow1.uploadTRLCompletionDocument(pdfFilePath);
        step2Flow1.clickYesButton(0);
        step2Flow1.clickYesButton(1);
        step2Flow1.enterDesignation("Manager");
        step2Flow1.clickYesButton(2);
//        Thread.sleep(10000);
        step2Flow1.clickNext();


    }

}
