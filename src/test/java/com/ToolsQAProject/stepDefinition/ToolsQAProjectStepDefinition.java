package com.ToolsQAProject.stepDefinition;

import java.io.IOException;
import java.util.HashMap;

import com.ToolsQAProject.pages.functions.BookStorePageFunctions;
import com.ToolsQAProject.pages.functions.ElementPageFunctions;
import com.ToolsQAProject.pages.functions.FormPageFunctions;
import com.ToolsQAProject.pages.functions.HomePageFunctions;
import com.ToolsQAProject.pages.functions.ParabankFunctions;
import com.relevantcodes.extentreports.ExtentTest;

public class ToolsQAProjectStepDefinition {
	

	public void elementsTabValidations() throws IOException {
		HomePageFunctions.elementTabClick();
		ElementPageFunctions.textBoxSubTab();
		ElementPageFunctions.checkboxSubTab();
		ElementPageFunctions.buttonsSubTab();
		
	}

	public void alertsFrameWindowsValidation() throws IOException{
		// TODO Auto-generated method stub
		HomePageFunctions.alerts_frame_windowsTabClick();
		
	}
	
	public void widgetsValidation() throws IOException{
		HomePageFunctions.WidgetsTabClick();
		
	}
	
	public void formsValidation(HashMap<Object, Object> testData) throws IOException{
		HomePageFunctions.formsTabClick();
		FormPageFunctions.formfillup(testData);		
	}
	
	public void bookstoreValidation() throws IOException{
		// TODO Auto-generated method stub
		HomePageFunctions.bookStoreClick();
		BookStorePageFunctions.bookstorelogin();
		BookStorePageFunctions.addingbooks();
		BookStorePageFunctions.viewingprofile();
		BookStorePageFunctions.deleteparticularbook("Git Pocket Guide");
		BookStorePageFunctions.deleteallbook();
		BookStorePageFunctions.logout();
		
	}

	public void parabankRegistration(HashMap<Object, Object> testData) throws IOException {
		// TODO Auto-generated method stub
		ParabankFunctions.registerParaBank(testData);
		ParabankFunctions.logoutParaBank();
		}

	public void parabankLogin(HashMap<Object, Object> testData) throws IOException  {
		// TODO Auto-generated method stub
		ParabankFunctions.loginParaBank(testData);
		ParabankFunctions.logoutParaBank();		
	}

}
