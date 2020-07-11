package com.ToolsQAProject.pages.functions;

import java.io.IOException;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.pages.elements.ElementPageElements;
import com.ToolsQAProject.pages.elements.HomePageElements;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ElementPageFunctions {
	
	public static void textBoxSubTab(ExtentTest logger) throws IOException
	{
		CommonDef.click(ElementPageElements.subMenu_Tab_Dynamic("Text Box"),logger);
		CommonDef.click(ElementPageElements.textBox_FullName_Box(),logger);
		CommonDef.waitVisible(ElementPageElements.textBox_FullName_Box(), logger);
		CommonDef.sendKeys(ElementPageElements.textBox_FullName_Box(),"Hariharan Arumugam", logger);
		CommonDef.click(ElementPageElements.textBox_Email_Box(),logger);
		CommonDef.waitVisible(ElementPageElements.textBox_Email_Box(), logger);
		CommonDef.sendKeys(ElementPageElements.textBox_Email_Box(),"Hariharan@gmail.com", logger);
		CommonDef.click(ElementPageElements.textBox_Address_Box(),logger);
		CommonDef.waitVisible(ElementPageElements.textBox_Address_Box(), logger);
		CommonDef.sendKeys(ElementPageElements.textBox_Address_Box(),"Tirunelveli", logger);
		CommonDef.waitVisible(ElementPageElements.textBox_Submit_Button(), logger);	
		CommonDef.click(ElementPageElements.textBox_Submit_Button(), logger);
		CommonDef.waitVisible(ElementPageElements.textBox_Submit_Button(), logger);	
		CommonDef.assertTextEquals(logger, CommonDef.splitMethod(ElementPageElements.textBox_nameResult_Box(), ":", logger)[1].toString(), "Hariharan Arumugam");
		CommonDef.assertTextEquals(logger, CommonDef.splitMethod(ElementPageElements.textBox_EmailResult_Box(), ":", logger)[1].toString(), "Hariharan@gmail.com");
		CommonDef.assertTextEquals(logger, CommonDef.splitMethod(ElementPageElements.textBox_AddressResult_Box(), ":", logger)[1].toString(), "Tirunelveli");
		logger.log(Status.INFO,"TEXT BOX COMPLETED");
	}
	
	public static void checkboxSubTab(ExtentTest logger) throws IOException
	{	
		CommonDef.waitVisible(ElementPageElements.subMenu_Tab_Dynamic("Check Box"), logger);
		CommonDef.click(ElementPageElements.subMenu_Tab_Dynamic("Check Box"), logger);
		CommonDef.waitVisible(ElementPageElements.checkbox_Expand_Button(), logger);
		CommonDef.clickJS(ElementPageElements.checkbox_Expand_Button(), logger);
		CommonDef.waitVisible(ElementPageElements.checkbox_Dynamic("Home"), logger);
		CommonDef.click(ElementPageElements.checkbox_Dynamic("Notes"), logger);
		CommonDef.assertTextEquals(logger, ElementPageElements.checkbox_ResultValidation("Notes"), "Notes");
		logger.log(Status.INFO,"CHECK BOX COMPLETED...!");
	}
	
	

}
