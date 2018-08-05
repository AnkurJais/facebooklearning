package learning.automation.facebook.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(using="email")
	public WebElement email;
	
	@FindBy(using="pass")
	public WebElement pass;
}
