package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static final int TIMEOUT=5;
	public static final int POLLING=100;

	public WebDriver driver=null;
	public WebDriverWait wait;


	//Constructor
	public BasePage(WebDriver driver)
	{
		this.driver=driver;	
		wait=new WebDriverWait(driver,TIMEOUT,POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,TIMEOUT),this);
	}

	//***********Common useful Methods***************//

	
	public void waitForElementToAppear(By locator)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
//	
//	protected void waitForElementToDisappear(By locator) {
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//    }

//    protected void waitForTextToDisappear(By locator, String text) {
//        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
//    }


//	//Click Method
//	public void click(By locator)
//	{
//		waitForElementToAppear(locator);
//		driver.findElement(locator).click();
//
//	}
//    
//	//Write Text
//	public void writeText (By locator, String text) {
//		waitForElementToAppear(locator);
//		driver.findElement(locator).sendKeys(text);
//	}
//
//	//Read Text
//	public String readText (By locator) {
//		waitForElementToAppear(locator);
//		return driver.findElement(locator).getText();
//	}
//
//	//Assert Equals
//	public void assertEquals (By locator, String expectedText) {
//		waitForElementToAppear(locator);
//		Assert.assertEquals(readText(locator), expectedText);
//	
//	}


}
