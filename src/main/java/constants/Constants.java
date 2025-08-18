package constants;

import pages.Dashboard;
import pages.EntitySignIn;
import pages.Projects;
import pages.Step1;

import java.io.File;

public class Constants {
    public static final String ExtendReportPath = System.getProperty("user.dir") + File.separator + "Reports"
            + File.separator + "Extent_Results.html";

    public static final String log4jPath = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + "main" + File.separator + "java" + File.separator  + "logger" + File.separator
            + "log4j.properties";
    public static final String ExcelOutPutFile = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + "main" + File.separator + "java" + File.separator  + "data" + File.separator
            + "output.txt";

    public static final String InputExcelFile = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + "main" + File.separator +"resources"+File.separator+ File.separator + "PRIP_EntityDetails_TestData.xlsx";

    public static final String userConfig = System.getProperty("user.dir") + File.separator + "user.properties";

    protected static Projects projects;
    protected static EntitySignIn entitySignIn;
    protected static Dashboard dashboard;
    protected static Step1 step1;
    public static String harshadAppPass = "jhgk qdat cgmp yltp";
    public static String harshadEmail = "harshadbadre3@gmail.com";
}
