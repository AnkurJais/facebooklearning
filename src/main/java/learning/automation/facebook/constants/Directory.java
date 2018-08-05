package learning.automation.facebook.constants;

import java.io.File;

public class Directory {
  
  public static final String SRC = "src";
  public static final String MAIN = "main";
  public static final String JAVA = "java";
  public static final String RESOURCES = "resources";
  public static final String PATH_SEPERATOR = File.separator;
  public static final String CONF = "conf";
  public static final String REPORT = "report";
  public static final String HTML_REPORT = "htmlreport";
  
  public static String projectDir() {
    return System.getProperty("user.dir");
  }
  
  public static String projectResourceDir() {
    return projectDir() + PATH_SEPERATOR + SRC + PATH_SEPERATOR + MAIN + PATH_SEPERATOR + RESOURCES;
  }
  
  public static String getConfigDir() {
    return projectResourceDir() + PATH_SEPERATOR + CONF;
  }
  
  public static String getSeleniumConfig() {
    return getConfigDir() + PATH_SEPERATOR + FileConstants.Config.SELENIUM_CONF;
  }
  
  public static String getHtmlReportDir() {
    return projectDir() + PATH_SEPERATOR + REPORT + PATH_SEPERATOR + HTML_REPORT + PATH_SEPERATOR;
  }
}
