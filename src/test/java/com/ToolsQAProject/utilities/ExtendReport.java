package com.ToolsQAProject.utilities;

import org.openqa.selenium.WebDriver;
import com.ToolsQAProject.commonDef.CommonDef;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReport {
	public static WebDriver driver = CommonDef.driver;
	 public static ExtentHtmlReporter htmlReporter;
	 public static ExtentReports extent;
	 public static ExtentTest logger;
		 
	
		public static void startReport() {
		 System.out.println("Came into Before Test");
			htmlReporter = new ExtentHtmlReporter("./test-output/ToolQAReport/ToolsQAExtentReport.html");
	        	// Create an object of Extent Reports
			extent = new ExtentReports();  
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
	        	extent.setSystemInfo("Environment", "Production");
			extent.setSystemInfo("User Name", "Hariharan Arumugam");
			htmlReporter.config().setDocumentTitle("Scuba - Trainning "); 
	                // Name of the report
			htmlReporter.config().setReportName("TestNG - ToolsQA - Reports"); 
	                // Dark Theme
			htmlReporter.config().setTheme(Theme.STANDARD);			
		}
	
			
}
