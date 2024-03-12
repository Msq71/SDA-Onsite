package day14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateReportPractice {
    public static void main(String[] args) {
        ExtentReports extentReports;
        ExtentTest extentTest;
        ExtentSparkReporter extentSparkReporter;

        extentReports = new ExtentReports();

        extentTest = extentReports.createTest("test2");


        String filePath = System.getProperty("user.dir") + "\\test-output\\reports\\Index2.html";

        extentSparkReporter = new ExtentSparkReporter(filePath);

        extentReports.attachReporter(extentSparkReporter);

        extentTest.log(Status.INFO, "this is test2");

        extentReports.flush();

    }
}
