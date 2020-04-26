package utils;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

/*To get ExtentReports instance from ExtentManager class. 
  This can be used to create instance of ExtentTest and put into extentTestMap with current thread id.
  
   
 * OB: extentTestMap holds the information of thread ids and ExtentTest instances.
 * ExtentReports instance created by calling getReporter() method from ExtentManager.
 * At startTest() method, an instance of ExtentTest created and put into extentTestMap with current thread id.
 * At endTest() method, test ends and ExtentTest instance got from extentTestMap via current thread id.
 * At getTest() method, return ExtentTest instance in extentTestMap by using current thread id.
 */

public class ExtentTestManager {

	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();

	//returns ExtentTest instance from extentTestMap by using current thread id.
	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {

		extent.flush();
	}

	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}
}
