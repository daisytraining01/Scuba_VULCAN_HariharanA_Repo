package com.ToolsQAProject.stepDefinition;

import java.io.IOException;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.pages.functions.ElementPageFunctions;
import com.ToolsQAProject.pages.functions.HomePageFunctions;
import com.aventstack.extentreports.ExtentTest;
import com.maveric.core.config.ConfigProperties;

public class ToolsQAProjectStepDefinition {
	

	public void elementsTabValidations(ExtentTest logger) throws IOException {
		// TODO Auto-generated method stub
		HomePageFunctions.elementTabClick(logger);
		ElementPageFunctions.textBoxSubTab(logger);
		ElementPageFunctions.checkboxSubTab(logger);
		
	}

	public void alertsFrameWindowsValidation(ExtentTest logger) throws IOException{
		// TODO Auto-generated method stub
		HomePageFunctions.alerts_frame_windowsTabClick(logger);
		
	}
	
	public void widgetsValidation(ExtentTest logger) throws IOException{
		// TODO Auto-generated method stub
		HomePageFunctions.WidgetsTabClick(logger);
		
	}
	
	public void formsValidation(ExtentTest logger) throws IOException{
		// TODO Auto-generated method stub
		HomePageFunctions.formsTabClick(logger);
		
	}
	
	public void bookstoreValidation(ExtentTest logger) throws IOException{
		// TODO Auto-generated method stub
		HomePageFunctions.bookStoreClick(logger);
		
	}

}
