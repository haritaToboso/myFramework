package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//this class we will create and instance for ExtentReports using createInstance() with HTML config params like the report location, Report name, Theme format etc.
	
	public class ExtentManager {
	    private static ExtentReports extent;
	    private static String reportFileName = "Test-Automaton-Report"+".html";
	    private static String fileSeperator = System.getProperty("file.separator"); // To get "\\" or "/"
	    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport"; // To set report folder
	    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName; // To store report file under the folder
	  
	 
	    public static ExtentReports getInstance() {
	        if (extent == null)
	            createInstance();
	        return extent;
	    }
	 
	    //Create an extent report instance
	    public static ExtentReports createInstance() {
	        String fileName = getReportPath(reportFilepath); //verifying if folder already exists in the location. else creating new folder & returning filename.
	       
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName); 
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(reportFileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(reportFileName);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	 
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        //Set environment details
			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("AUT", "QA");
	 
	        return extent;
	    }
	     
	    //Create the report path
	    private static String getReportPath (String path) {
	    	File testDirectory = new File(path);
	        if (!testDirectory.exists()) {
	        	if (testDirectory.mkdir()) {
	                System.out.println("Directory: " + path + " is created!" );
	                return reportFileLocation;
	            } else {
	                System.out.println("Failed to create directory: " + path);
	                return System.getProperty("user.dir");
	            }
	        } else {
	            System.out.println("Directory already exists: " + path);
	        }
			return reportFileLocation;
	    }
	 
	}


