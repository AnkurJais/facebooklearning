package learning.jenkins.facebook;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.File;
import learning.jenkins.pageobjects.*;

public class UploadAndDownload {

	WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(@Optional String browser) throws MalformedURLException{
		System.out.println("Browser==========" + browser);
		if(browser == null || browser.equals("firefox")){
			System.out.println("Browser========== FF" + browser);
			System.setProperty("webdriver.gecko.driver", "/var/jenkins_home/softwares/geckodriver");
			DesiredCapabilities dc = DesiredCapabilities.firefox();
//			dc.setBrowserName("chrome");
			driver = new RemoteWebDriver(new URL("http://172.17.0.4:5555/wd/hub"),dc);
			driver.manage().window().maximize();
		}
		else{
			System.out.println("Browser========== Chrome" + browser);
			File file = new File("/var/jenkins_home/softwares/chromedriver");
			boolean result;
			// check if file exists
			result=file.exists();
			if(result){
				// print message that file exists
				System.out.println(file.getAbsolutePath() + " exists");
			}
			else{
				//print message that the file does not exist
				System.out.println(file.getAbsolutePath()+" does not exists");
			}
			System.setProperty("webdriver.chrome.driver", "/var/jenkins_home/softwares/chromedriver");
			Map<String, Object> prefs = new HashMap<String, Object>();

			//Put this into prefs map to switch off browser notification
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			
			//Create chrome options to set this prefs
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);			
			driver = new ChromeDriver(options);
			DesiredCapabilities dc = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://172.17.0.4:5555/wd/hub"),dc);
			driver.manage().window().maximize();
		}
	}

	@Test(priority=1)
	public void login() throws InterruptedException{
		driver.get("https://facebook.com");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.email.sendKeys("testuser11356@gmail.com");
		login.pass.sendKeys("aloha@123");
		login.pass.submit();
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void upload_profile_pic() throws InterruptedException, AWTException{		
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a/span[contains(text(),'Leonardo')]"))));
		WebElement profile = driver.findElement(By.xpath("//a/span[contains(text(),'Leonardo')]"));
		Actions action = new Actions(driver);
		action.moveToElement(profile).perform();
		WebElement profile_anchor = driver.findElement(By.xpath("//div/a/span[contains(text(),Leonardo)]/parent::a"));
		String title = profile_anchor.getAttribute("title");
		System.out.println("Tooltip: "+title);
		Assert.assertEquals(title, "Profile");
		profile.click();
		
		Thread.sleep(2000);
		Boolean dialog_present = is_dialog_present();
		if(dialog_present){
			driver.findElement(By.xpath("//a[@data-testid='skip_button']")).click();
		}
		
		Thread.sleep(2000);
		if(dialog_present){
			driver.findElement(By.xpath("//a[@data-testid='skip_button']")).click();
		}
		
		WebElement profile_upload_element = driver.findElement(By.xpath("//div[@class='photoContainer']/div/div/div/a"));
		profile_upload_element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Update Profile Picture')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'Update Profile Picture')]")));
		
		driver.findElement(By.xpath("//input[@title='Choose a file to upload']/parent::div")).click();
		Thread.sleep(5000);
		Robot r = new Robot();
		StringSelection stringSelection = new StringSelection("/home/ankur/Pictures/baahubali-2-new-poster.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        r.setAutoDelay(300);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        
        Thread.sleep(10000);
        System.out.println(driver.findElement(By.xpath("//div/em[@data-intl-translation='Create profile picture']")).getText());
        action.moveByOffset(50, 0).perform();
        WebElement zoom = driver.findElement(By.xpath("//input[@type='hidden']/parent::div[@role='presentation']"));
        action.clickAndHold(zoom).moveByOffset(100,0).release().build().perform();
        
        WebElement save_button = driver.findElement(By.xpath("//button[@data-testid='profilePicSaveButton']"));
        save_button.click();  
	}
	
	Boolean is_dialog_present(){
		// Element that displayed to change profile pic or cover pic with option ok and skip
		List <WebElement> element = (List<WebElement>)driver.findElements(By.xpath("//div[contains(@class,'uiContextualLayerBelowLeft')]"));
		System.out.println(element.size());
		if(element.size()>0)
			return true;
		else
			return false;
	}
}
