package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LogoutPage;
import pages.RegisterPage;

public class HomePageTest extends BaseTest{

	//*************PAGE INSTANTIATIONS*************

	HomePage homePage;
	RegisterPage registerPage; 
	LogoutPage logoutPage;
	
	//*****************Tests***********************
	
	@Test(priority=0)
	public void launchHomePage() {
	
		homePage=new HomePage(getDriver());
		homePage.launchHomePage();
		homePage.verifyHomePage();
	}
		
	//@Test(priority=1)
	public void registerUser () throws InterruptedException {
	
		homePage=new HomePage(getDriver());
		homePage.launchHomePage();
		homePage.goToRegisterPage();
		registerPage=new RegisterPage(getDriver());
		registerPage.registerUser();
		logoutPage=new LogoutPage(getDriver());
		logoutPage.logoutUser();
	}
	
//	@Test
	public void loginUser() {
	
		homePage=new HomePage(getDriver());
		homePage.launchHomePage();
		homePage.verifyHomePage();
		homePage.goToLoginPage();
	}
		
	
		
}
