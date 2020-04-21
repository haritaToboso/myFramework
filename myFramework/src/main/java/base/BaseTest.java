package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import config.ConfigurationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;
	ConfigurationProperties configProperty=new ConfigurationProperties();
	String BROWSER=configProperty.getProperties("browser");    


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
	@BeforeClass
	private void setupLocalDriver() {

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

	}

	@BeforeMethod(alwaysRun = true)
	public void SetUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}


	@AfterMethod(alwaysRun = true)
	public void teardown () {
		if(null != driver) {
			driver.close();
			driver.quit();
		}
	}

	public WebDriver getDriver() {

		return driver;
	}

}


