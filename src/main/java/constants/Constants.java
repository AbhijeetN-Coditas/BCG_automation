package constants;

import pages.*;
import utility.FileUpload;

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

    public static final String userConfig1 = System.getProperty("user.dir") + File.separator + "email.properties";

    public static final String pdfFilePath = System.getProperty("user.dir") + File.separator
            + "dummydummydummydummydummydummydummydummydummydummy.pdf";
    protected static Projects projects;
    protected static EntitySignIn entitySignIn;
    protected static Dashboard dashboard;
    protected static Step1 step1;
    protected static Step2_Flow1 step2Flow1;
    protected static Step3 step3;
    protected static FileUpload fileUpload;
    public static String harshadAppPass;
    public static String harshadEmail;
}
