package utility;

import driverRepo.ConfigDriver;
import org.apache.log4j.Logger;
import pages.Dashboard;
import pages.EntitySignIn;
import pages.Projects;
import pages.Step1;

public class ObjectRepository {

    public static Logger log = Logger.getLogger(ObjectRepository.class);

    public static ThreadLocal<Projects> ProjectsScreen = new ThreadLocal<Projects>();
    public static ThreadLocal<EntitySignIn> EntitySignInScreen = new ThreadLocal<EntitySignIn>();
    public static ThreadLocal<Dashboard> DashboardScreen = new ThreadLocal<Dashboard>();
    public static ThreadLocal<Step1> Step1Screen = new ThreadLocal<Step1>();

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
}
