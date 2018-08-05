package learning.automation.facebook.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

import learning.automation.facebook.config.SeleniumConfig;
import learning.automation.facebook.constants.Directory;
import learning.automation.facebook.exception.BrowserIntializationException;
import learning.automation.facebook.utils.YamlReader;

public class BrowserReportInitializer {

  public static WebDriver driver;

  public static void browserSetup(String browser) {
    try {
      // Read yaml config file to get details of selenium grid node
      YamlReader<SeleniumConfig> ob = new YamlReader<SeleniumConfig>();
      SeleniumConfig seleniumConfig = ob.readYaml(SeleniumConfig.class, Directory.getSeleniumConfig());
      
      DesiredCapabilities dc;
      if(browser == null || browser.equals("firefox")) {
        dc = DesiredCapabilities.firefox();
      } else {
        dc = DesiredCapabilities.chrome();
      }
      if (seleniumConfig.getGrid().containsKey("url")) {
        driver = new RemoteWebDriver(new URL(seleniumConfig.getGrid().get("url")),dc);
      } else {
        throw new BrowserIntializationException("Unable to intialize browser on " + seleniumConfig.getGrid().get("url"));
      }
      driver.manage().window().maximize();
    } catch (BrowserIntializationException exep) {
      
    } catch (MalformedURLException exep) {
      
    }
  }
  
  public static WebDriver getDriver() {
    return driver;
  }
}
