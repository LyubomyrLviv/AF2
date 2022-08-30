package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExReports {

    ExtentReports extentReports = new ExtentReports();
    File file = new File(System.getProperty("user.dir"+"/logs/extentRep/report.html"));
    ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

    public void setExtentReports () throws IOException
    {
        extentReports.attachReporter(sparkReporter);

        ExtentTest loginTest = extentReports.createTest("LoginPageTest");



        extentReports.flush();
        //Automatically open the file report in the system default browser
        Desktop.getDesktop().browse(new File("./logs/extentRep/report.html").toURI());
    }

    public static void main(String[] args) throws IOException {

        ExReports exReports = new ExReports();
        exReports.setExtentReports();

    }


}
