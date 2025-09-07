package utility;

import driverRepo.ConfigDriver;
import org.apache.log4j.Logger;
import pages.*;

public class ObjectRepository {

    public static Logger log = Logger.getLogger(ObjectRepository.class);

    public static ThreadLocal<Projects> ProjectsScreen = new ThreadLocal<Projects>();
    public static ThreadLocal<EntitySignIn> EntitySignInScreen = new ThreadLocal<EntitySignIn>();
    public static ThreadLocal<Dashboard> DashboardScreen = new ThreadLocal<Dashboard>();
    public static ThreadLocal<Step1> Step1Screen = new ThreadLocal<Step1>();
    public static ThreadLocal<Step2_Flow1> Step2Screen = new ThreadLocal<>();
    public static ThreadLocal<Step3> Step3Screen = new ThreadLocal<>();
    public static ThreadLocal<Step5> Step5Screen = new ThreadLocal<>();
    public static ThreadLocal<Step4> Step4Screen = new ThreadLocal<>();

    public static Projects ProjectInstance() {
        if (ProjectsScreen.get() == null) // if Login page object not created then create store for further use
        {
            ProjectsScreen.set(new Projects(ConfigDriver.getDriver()));

            log.info("Login page object created");
        }
        return ProjectsScreen.get(); // returning created/existing driver instance
    }
    public static EntitySignIn EntitySignInInstance() {
        if (EntitySignInScreen.get() == null)
        {
            EntitySignInScreen.set(new EntitySignIn(ConfigDriver.getDriver()));

            log.info("Login page object created");
        }
        return EntitySignInScreen.get();
    }
    public static Dashboard DashboardInstance() {
        if (DashboardScreen.get() == null)
        {
            DashboardScreen.set(new Dashboard(ConfigDriver.getDriver()));

            log.info("Dashboard page object created");
        }
        return DashboardScreen.get();
    }
    public static Step1 Step1Instance() {
        if (Step1Screen.get() == null)
        {
            Step1Screen.set(new Step1(ConfigDriver.getDriver()));

            log.info("Step1 page object created");
        }
        return Step1Screen.get();
    }
    public static Step2_Flow1 Step2_Flow1Instance(){
        if(Step2Screen.get() == null)
        {
            Step2Screen.set(new Step2_Flow1(ConfigDriver.getDriver()));

            log.info("Step2_Flow1 page object created");
        }
        return Step2Screen.get();
    }
    public static Step3 Step3Instance(){
        if(Step3Screen.get() == null)
        {
            Step3Screen.set(new Step3(ConfigDriver.getDriver()));

            log.info("Step2_Flow1 page object created");
        }
        return Step3Screen.get();
    }

    public static Step5 Step5Instance() {
        if (Step5Screen.get() == null) {
            Step5Screen.set(new Step5(ConfigDriver.getDriver()));

            log.info("Step2_Flow1 page object created");
        }
        return Step5Screen.get();
    }
    public static Step4 Step4_Flow1Instance(){
        if(Step4Screen.get() == null)
        {
            Step4Screen.set(new Step4(ConfigDriver.getDriver()));

            log.info("Step2_Flow1 page object created");
        }
        return Step4Screen.get();
    }
}
