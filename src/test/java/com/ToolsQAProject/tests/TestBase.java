package com.ToolsQAProject.tests;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.ToolsQAProject.Driver.BrowserFactory;
import com.ToolsQAProject.Driver.DriverFactory;
import com.ToolsQAProject.utilities.ExcelReader;
import com.ToolsQAProject.utilities.ITestReporter;
import com.ToolsQAProject.utilities.Reporter;
import com.codoid.products.exception.FilloException;
import com.maveric.core.config.ConfigProperties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase {
	
public static ITestReporter testReporter;
//public static HashMap<String, String> testData;

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
		//testData = ExcelReader.ReadExcel(System.getProperty("user.dir")+ "/src/test/java/com/ToolsQAProject/resource/TestData.xlsx", getTestDescription(caller), "ScenarioID='"+getTestName(caller)+"'");
	}
	
	@AfterMethod
	public synchronized void afterMethod()
	{
		
		testReporter.endTest();
		Reporter.flushReport();
		DriverFactory.getInstance().removeDriver();
	}
	
	@AfterSuite
	public void closeReport()
	{
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
