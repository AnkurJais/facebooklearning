package learning.automation.facebook.assertion;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
  private static ExtentHtmlReporter htmlReporter;
  private static ExtentTest test;
  private static ExtentReports extent;
  
  public static void initializeHtmlReport(String report) {
    htmlReporter = new ExtentHtmlReporter(report);
    extent = new ExtentReports();
    htmlReporter.setAppendExisting(false);
    extent.attachReporter(htmlReporter);
    extent.setSystemInfo("Host Name", "ans");
    extent.setSystemInfo("Environment", "QA");
    extent.setSystemInfo("User Name", "Ankur");
    
    htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
    htmlReporter.config().setReportName("Name of the Report Comes here");
    htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    htmlReporter.config().setTheme(Theme.STANDARD);
  }
  
  public static void createTest(String extentTest) {
    test = extent.createTest(extentTest);
  }
  
  public static void flush() {
    extent.flush();
  }
  
  public static void logPass(String step) {
    test.log(Status.PASS, step);
  }
  
  public static void logFail(String step) {
    test.log(Status.FAIL, step);
  }
  
  public static void logFail(Throwable e) {
    test.log(Status.FAIL, e);
  }
  
  public static void logFail(String step, String screenShot) {
    try {
      test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
    } catch (IOException e) {
      logFail(e);
    }
  }
  
  public static ExtentTest getTest() {
    return test;
  }
  
  public static void setTest(ExtentTest extentTest) {
    test = extentTest;
  }
}
