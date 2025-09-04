package test;

import org.testng.annotations.Test;
import utility.BaseTest;

public class Step2_Flow1 extends BaseTest {

    @Test(priority = 4, description = "Step2 submission Flow1", groups = {"FormSubmission" })
    public void step2Flow1(){

        step2Flow1.step2();
        step2Flow1.selectResearchProjectPriority(0);
        step2Flow1.selectResearchProjectSubPriorityArea(0);
        step2Flow1.selectStrategicPriorityInnovationsArea(0);
    }

}
