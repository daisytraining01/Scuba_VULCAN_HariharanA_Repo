package com.ToolsQAProject.stepDefinition;

import java.io.IOException;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.pages.functions.BookStorePageFunctions;
import com.ToolsQAProject.pages.functions.ElementPageFunctions;
import com.ToolsQAProject.pages.functions.FormPageFunctions;
import com.ToolsQAProject.pages.functions.HomePageFunctions;
import com.aventstack.extentreports.ExtentTest;
import com.maveric.core.config.ConfigProperties;

public class ToolsQAProjectStepDefinition {
	

	public void elementsTabValidations(ExtentTest logger) throws IOException {
		HomePageFunctions.elementTabClick(logger);
		ElementPageFunctions.textBoxSubTab(logger);
		ElementPageFunctions.checkboxSubTab(logger);
		ElementPageFunctions.buttonsSubTab(logger);
		
	}

	public void alertsFrameWindowsValidation(ExtentTest logger) throws IOException{
		// TODO Auto-generated method stub
		HomePageFunctions.alerts_frame_windowsTabClick(logger);
		
	}
	
	public void widgetsValidation(ExtentTest logger) throws IOException{
		HomePageFunctions.WidgetsTabClick(logger);
		
	}
	
	public void formsValidation(ExtentTest logger) throws IOException{
		HomePageFunctions.formsTabClick(logger);
		FormPageFunctions.formfillup(logger);		
	}
	
	public void bookstoreValidation(ExtentTest logger) throws IOException{
		// TODO Auto-generated method stub
		HomePageFunctions.bookStoreClick(logger);
		BookStorePageFunctions.bookstorelogin(logger);
		BookStorePageFunctions.addingbooks(logger);
		BookStorePageFunctions.viewingprofile(logger);
		BookStorePageFunctions.deleteparticularbook("Git Pocket Guide", logger);
		BookStorePageFunctions.deleteallbook(logger);
		BookStorePageFunctions.logout(logger);
		
	}

}
