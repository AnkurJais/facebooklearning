package learning.automation.facebook.core;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import learning.automation.facebook.assertion.ExtentManager;
import learning.automation.facebook.constants.Directory;
import learning.automation.facebook.constants.FileConstants;
import learning.automation.facebook.utils.FileUtils;

public class BaseClass {
  public static WebDriver driver;
  
  @BeforeSuite
  public void beforeSuite() {
    FileUtils.createDir(Directory.getHtmlReportDir());
    BrowserReportInitializer.browserSetup("firefox");
    driver = BrowserReportInitializer.getDriver();
    ExtentManager.initializeHtmlReport(Directory.getHtmlReportDir() + FileConstants.REPORT.HTML_REPORT);
  }
  
  @BeforeMethod
  public void beforeMethod(Method result) {
    Test test = result.getAnnotation(Test.class);
    if (result != null) {
      ExtentManager.createTest(test.description());
    }
  }
  
  @AfterSuite
  public void afterSuite() {
    driver.close();
    ExtentManager.flush();
  }
}