package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LogoutPage extends BasePage{

	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	HomePage homePage;
	
	@FindBy(linkText="Logout")
	WebElement logout_link;
	
	@FindBy(xpath="//h1[contains(text(),'Account Logout')]")
	WebElement accountLogout_label;
	
	
	public void logoutUser()
	{
		homePage.myAccount_link.click();
		logout_link.click();
		if(accountLogout_label.isDisplayed()){
			System.out.println("---->Successfully Logged out ");
		}
		else 
			{
			System.out.println("-----> Error in Logging Out");
			}
	}
}
