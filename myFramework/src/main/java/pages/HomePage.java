package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import config.ConfigurationProperties;

public class HomePage extends BasePage {

	
	ConfigurationProperties configProperty=new ConfigurationProperties();
	
	//*************************Constructor**************************************//
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//***************************Page Variables*********************************//
	
    //String baseURL = "https://demo.opencart.com//";
    
    
	//******************Web Elements using Page Factory*************************//
	
	@FindBy(linkText="Your Store")
	WebElement homePage_label;
	
	
	@FindBy(linkText="My Account")
	WebElement myAccount_link;
	
	@FindBy(linkText="Register")
	WebElement registerOption_link;
	
	@FindBy(linkText="Login")
	WebElement loginOption_link;
	
	//*****************************Page Methods*********************************//

	public void launchHomePage()
	{
		driver.get(configProperty.getProperties("baseURL"));
	}
	
	public void verifyHomePage()
	{
		if(homePage_label.isDisplayed())
		{
			System.out.println("---->Successfully directed to Home Page ");
		}
		else System.out.println("-----> Error");
	}
	
	public void  goToRegisterPage()
	{
		myAccount_link.click();
		registerOption_link.click();
	}
	
	public void  goToLoginPage()
	{
		myAccount_link.click();
		loginOption_link.click();
	}
	
}