package learning.automation.facebook.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {
	@FindBy(xpath="//a/span[contains(text(),'Leonardo')]")
	public WebElement user_profile;
	
	@FindBy(id="pass")
	public WebElement pass;
	
	@FindBy(xpath="//div/a/span[contains(text(),Leonardo)]/parent::a")
	public WebElement user_profile_anchor;	
}
