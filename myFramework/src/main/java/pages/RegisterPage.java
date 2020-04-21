package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	MyAccountsPage myAccounts ;
	
	@FindBy(id="content")
	WebElement register_label;
	
	@FindBy(name="firstname")
	WebElement firstName_txtBox;

	@FindBy(name="lastname")
	WebElement lastName_txtBox;

	@FindBy(name="email")
	WebElement email_txtBox;

	@FindBy(name="telephone")
	WebElement telephoneNo_txtBox;

	@FindBy(name="password")
	WebElement password_txtBox;

	@FindBy(name="confirm")
	WebElement confirmPassword_txtBox;

	@FindBy(xpath ="//input[(@name=\"newsletter\") and (@value=\"1\")]")
	WebElement newsletterNo_rdBtn;

	@FindBy(name="agree")
	WebElement privacyPolicy_chkBox;

	@FindBy(xpath="//*[@value=\"Continue\"]")
	WebElement continue_btn;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	WebElement continueGeneric_btn;
	
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement accountCreated_label;
	
	
	public void registerUser() throws InterruptedException
	{
		if(register_label.isDisplayed()){
			System.out.println("---->Successfully directed to Registration Page ");
		}
		else 
			{
			System.out.println("-----> Error at Registration Page");
			}
		
		firstName_txtBox.sendKeys("Harry");
		lastName_txtBox.sendKeys("Michealis");
		email_txtBox.sendKeys("HRXYd99dZ@GMAIL.COM");
		telephoneNo_txtBox.sendKeys("4534643656");
		password_txtBox.sendKeys("Hrxyz12334");
		confirmPassword_txtBox.sendKeys("Hrxyz12334");
		newsletterNo_rdBtn.click();
		privacyPolicy_chkBox.click();
		continue_btn.click();
		
		if(accountCreated_label.isDisplayed()){
			System.out.println("---->Successfully created Account ");
		}
		else 
			{
			  System.out.println("-----> Error at Account Creation Page");	
			}
		
		continueGeneric_btn.click();
		Thread.sleep(3000);
		
		if(myAccounts.myAccount_label.isDisplayed()){
			System.out.println("---->Navigated to MyAccounts ");
		}
		else
			{
			System.out.println("-----> Error navigating to MyAccounts");
			}
		
	}


}
