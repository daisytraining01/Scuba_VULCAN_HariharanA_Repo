package com.ToolsQAProject.tests;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.ToolsQAProject.Driver.BrowserFactory;
import com.ToolsQAProject.Driver.DriverFactory;
import com.ToolsQAProject.utilities.ExcelReader;
import com.ToolsQAProject.utilities.ITestReporter;
import com.ToolsQAProject.utilities.Reporter;
import com.ToolsQAProject.utilities.ResultAnalysisLog;
import com.ToolsQAProject.utilities.logger.LoggerManager;
import com.codoid.products.exception.FilloException;
import com.maveric.core.config.ConfigProperties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase {
	
public static ITestReporter testReporter;
//public static HashMap<String, String> testData;
	public static Logger logger = LogManager.getLogger(TestBase.class);;

	@BeforeSuite
	public void startReport()
	{
		Reporter.createReporter(System.getProperty("user.dir")+ "/target/HtmlReport.html", true);
	}
	
	@BeforeTest
	public void classSetUp()
	{
		testReporter = Reporter.getTestReporter();
				
	}
	
	@BeforeMethod
	public synchronized void methodSetup(Method caller) throws FilloException
	{
		testReporter.startTest(getTestName(caller), getTestDescription(caller));
		logger.info("STARTED ||"+ getTestName(caller)+getTestDescription(caller));
		//testData = ExcelReader.ReadExcel(System.getProperty("user.dir")+ "/src/test/java/com/ToolsQAProject/resource/TestData.xlsx", getTestDescription(caller), "ScenarioID='"+getTestName(caller)+"'");
	}
	
	@AfterMethod
	public synchronized void afterMethod(Method caller)
	{
		System.out.println("Run Status"+testReporter.getRunStatus());
		if(testReporter.getRunStatus().toString().toLowerCase() == "pass")
		{
			logger.info("PASS || "+ getTestName(caller)+getTestDescription(caller));
		}
		if(testReporter.getRunStatus().toString().toLowerCase() == "fail")
		{
			logger.error("FAIL || "+ getTestName(caller)+getTestDescription(caller));
		}
		if(testReporter.getRunStatus().toString().toLowerCase() == "unknown")
		{
			logger.warn("SKIP || "+ getTestName(caller)+getTestDescription(caller));
		}
		
		testReporter.endTest();
		Reporter.flushReport();
		DriverFactory.getInstance().removeDriver();
	}
	
	@AfterSuite
	public void closeReport()
	{
		ResultAnalysisLog dummy = new ResultAnalysisLog();
		Reporter.closeReport();
	}

	private String getTestName(Method caller)
	{
		Test testAnnotation = caller.getAnnotation(Test.class);
		if(testAnnotation != null)
		{
			return testAnnotation.testName();
		}
		return "";
	}
	
	private String getTestDescription(Method caller)
	{
		Test testAnnotation = caller.getAnnotation(Test.class);
		if(testAnnotation != null)
		{
			return testAnnotation.description();
		}
		return "";
	}

}
