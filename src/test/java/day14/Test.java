package day14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args) {

        ExtentTest extentTest;
        ExtentReports extentReports;
        ExtentSparkReporter extentSparkReporter;

        extentReports = new ExtentReports();

        extentTest = extentReports.createTest("test1");

        String currentDate = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/reports/testReport_second" + currentDate + ".html";


        extentSparkReporter = new ExtentSparkReporter(filePath);

        extentReports.attachReporter(extentSparkReporter);

        extentTest.log(Status.INFO, "this is a log");

        extentReports.flush();
    }
}
