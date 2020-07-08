package com.ToolsQAProject.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.stepDefinition.ToolsQAProjectStepDefinition;


public class ToolQAProject {
	
//	@AfterMethod
//	public void closeDriver()
//	{
//		WebDriver driver=CommonDef.driver_initiate();
//		driver.close();
//	}
	
	@Test()
	public void textBoxValidation() {
		ToolsQAProjectStepDefinition steps = new ToolsQAProjectStepDefinition();
		steps.elementsTextBox();		
	}

}
