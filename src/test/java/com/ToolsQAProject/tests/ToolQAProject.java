package com.ToolsQAProject.tests;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.stepDefinition.ToolsQAProjectStepDefinition;
import com.ToolsQAProject.utilities.ExtendReport;

import com.maveric.core.config.ConfigProperties;


public class ToolQAProject extends ExtendReport{
	@BeforeTest
	public void start() {
		ExtendReport.startReport();
	}

	@BeforeMethod
	public void setup() {
		CommonDef.driverInit(ConfigProperties.TOOLSQA_URL.get());
		System.out.println("Started.....");
	}



	@Test()
	public void variousElementValidation() throws IOException {
		logger = extent.createTest("Elements");
		ToolsQAProjectStepDefinition steps = new ToolsQAProjectStepDefinition();
		steps.elementsTabValidations(logger);	
	}
	
	
	public void variousAlertsFrameWindowsValidation() throws IOException {
		logger = extent.createTest("Aerts Frame & Windows");
		ToolsQAProjectStepDefinition steps = new ToolsQAProjectStepDefinition();
		steps.alertsFrameWindowsValidation(logger);	
	}
	
	
	public void variousWidgetsValidation() throws IOException {
		logger = extent.createTest("Widgets");
		ToolsQAProjectStepDefinition steps = new ToolsQAProjectStepDefinition();
		steps.widgetsValidation(logger);	
	}
	
	public void formsOptionValidation() throws IOException {
		logger = extent.createTest("Forms");
		ToolsQAProjectStepDefinition steps = new ToolsQAProjectStepDefinition();
		steps.formsValidation(logger);	
	}
	
	public void bookstoreOptionValidation() throws IOException {
		logger = extent.createTest("Book Store");
		ToolsQAProjectStepDefinition steps = new ToolsQAProjectStepDefinition();
		steps.bookstoreValidation(logger);	
	}


	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
		
		System.out.println("Came into After Test"+result);
		CommonDef.closeBrowser();
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}



}
