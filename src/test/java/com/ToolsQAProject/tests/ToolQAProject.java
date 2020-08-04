package com.ToolsQAProject.tests;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.Test;

import com.ToolsQAProject.Driver.BrowserFactory;
import com.ToolsQAProject.Driver.DriverFactory;
import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.stepDefinition.ToolsQAProjectStepDefinition;
import com.ToolsQAProject.utilities.ProjectDataProvider;
import com.maveric.core.config.ConfigProperties;


public class ToolQAProject extends TestBase {	
	
	@Test(testName = "Forms", description = "Filling Up Forms", dataProvider = "forms", dataProviderClass = ProjectDataProvider.class)
	public void formsOptionValidation(HashMap<Object, Object> testData) throws IOException {
		DriverFactory.getInstance().setDriver(BrowserFactory.createInstance(testData.get("Browser").toString()));
		CommonDef.launchURL(ConfigProperties.TOOLSQA_URL.get());
		System.out.println("TestData - "+testData);
		ToolsQAProjectStepDefinition steps = new ToolsQAProjectStepDefinition();
		steps.formsValidation(testData);	
	}
	
//	@Test(testName = "BookStoreApplication", description = "Choose your book")
	public void bookstoreOptionValidation() throws IOException {
		DriverFactory.getInstance().setDriver(BrowserFactory.createInstance(ConfigProperties.BROWSER.get()));
		CommonDef.launchURL(ConfigProperties.TOOLSQA_URL.get());
		ToolsQAProjectStepDefinition steps = new ToolsQAProjectStepDefinition();
		steps.bookstoreValidation();	
	}
	
//	@Test(testName = "Parabank-Registration-Login", description = "Filling Up Forms", dataProvider = "parabank", dataProviderClass = ProjectDataProvider.class)
	public void parabankRegistration(HashMap<Object, Object> testData) throws IOException {
		DriverFactory.getInstance().setDriver(BrowserFactory.createInstance(testData.get("Browser").toString()));
		CommonDef.launchURL(ConfigProperties.PARABANK_URL.get());
		System.out.println("TestData - "+testData);
		ToolsQAProjectStepDefinition steps = new ToolsQAProjectStepDefinition();
		steps.parabankRegistration(testData);	
		steps.parabankLogin(testData);	
	}
}
