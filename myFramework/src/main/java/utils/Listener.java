package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class Listener extends BaseTest implements ITestListener {
	
	WebDriver driver=null;
	
	
	public void onTestStart(ITestResult result) {
		
		 System.out.println(result.getName()+" test case started");
		 ExtentTestManager.startTest(result.getMethod().getMethodName());

		
	}

	public void onTestSuccess(ITestResult result) {
			
		    System.out.println("The name of the testcase passed is :"+result.getName());
		    ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		  
		    
		
	}

	public void onTestFailure(ITestResult result) {
		

		String methodName=result.getName().toString().trim();
		System.out.println("The name of the testcase failed is :"+ methodName);
		try {
			takeScreenShotOnFail(methodName);
		} catch (Exception e) {

			e.printStackTrace();

		}
		
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	public void onTestSkipped(ITestResult result) {
		
		 System.out.println("The name of the testcase Skipped is :"+result.getName());	
		 ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		ExtentTestManager.endTest();
		
	}



}
