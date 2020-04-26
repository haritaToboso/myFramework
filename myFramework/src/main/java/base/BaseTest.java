package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import config.ConfigurationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private static WebDriver driver=null;
	static ConfigurationProperties configProperty=new ConfigurationProperties();
	String BROWSER=configProperty.getProperties("browser");    
	static String screenshotPath=configProperty.getProperties("screenshotPath"); 


	//	@BeforeClass
	//	public void browserSettings(String browser) {
	//		
	//		DesiredCapabilities capabilities = new DesiredCapabilities();
	//		  capabilities.setCapability("browser",BROWSER);
	//		  capabilities.setCapability("platform", "win10");
	//		  
	//		
	//	}
	//	



	@BeforeMethod
	public void SetUp() {
		setupLocalDriver(BROWSER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}


	@AfterTest
	public void teardown () {
		if(null != driver) {
			driver.close();
			driver.quit();
		}
	}

	private void setupLocalDriver(String BROWSER) {

		if(BROWSER.equalsIgnoreCase("chrome")){

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}	
		else 
		{
			System.out.println("Invalid Browser...By default launching Chrome");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

	}
	
	public WebDriver getDriver() {

		return driver;
	}

	public void takeScreenShotOnFail(String methodName) throws Exception{


		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(scrFile, new File(screenshotPath+methodName+".png"));
			System.out.println("***Placed screen shot in "+screenshotPath+" ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}