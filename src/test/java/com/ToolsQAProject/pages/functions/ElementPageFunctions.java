package com.ToolsQAProject.pages.functions;

import java.io.IOException;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.pages.elements.ElementPageElements;
import com.relevantcodes.extentreports.ExtentTest;


public class ElementPageFunctions {
	
	public static void textBoxSubTab() throws IOException
	{
		CommonDef.click(ElementPageElements.subMenu_Tab_Dynamic("Text Box"));
		CommonDef.click(ElementPageElements.textBox_FullName_Box());
		CommonDef.waitVisible(ElementPageElements.textBox_FullName_Box());
		CommonDef.sendKeys(ElementPageElements.textBox_FullName_Box(),"Hariharan Arumugam");
		CommonDef.click(ElementPageElements.textBox_Email_Box());
		CommonDef.waitVisible(ElementPageElements.textBox_Email_Box());
		CommonDef.sendKeys(ElementPageElements.textBox_Email_Box(),"Hariharan@gmail.com");
		CommonDef.click(ElementPageElements.textBox_Address_Box());
		CommonDef.waitVisible(ElementPageElements.textBox_Address_Box());
		CommonDef.sendKeys(ElementPageElements.textBox_Address_Box(),"Tirunelveli");
		CommonDef.waitVisible(ElementPageElements.textBox_Submit_Button());	
		CommonDef.click(ElementPageElements.textBox_Submit_Button());
		CommonDef.waitVisible(ElementPageElements.textBox_Submit_Button());	
		CommonDef.assertTextEquals( CommonDef.splitMethod(ElementPageElements.textBox_nameResult_Box(), ":")[1].toString(), "Hariharan Arumugam");
		CommonDef.assertTextEquals( CommonDef.splitMethod(ElementPageElements.textBox_EmailResult_Box(), ":")[1].toString(), "Hariharan@gmail.com");
		CommonDef.assertTextEquals( CommonDef.splitMethod(ElementPageElements.textBox_AddressResult_Box(), ":")[1].toString(), "Tirunelveli");
		//logger.log(Status.INFO,MarkupHelper.createLabel("TEXT BOX COMPLETED", ExtentColor.GREEN));
	}
	
	public static void checkboxSubTab() throws IOException
	{	
		CommonDef.waitVisible(ElementPageElements.subMenu_Tab_Dynamic("Check Box"));
		CommonDef.click(ElementPageElements.subMenu_Tab_Dynamic("Check Box"));
		CommonDef.waitVisible(ElementPageElements.checkbox_Expand_Button());
		CommonDef.clickJS(ElementPageElements.checkbox_Expand_Button());
		CommonDef.waitVisible(ElementPageElements.checkbox_Dynamic("Home"));
		CommonDef.click(ElementPageElements.checkbox_Dynamic("Notes"));
		CommonDef.assertTextEquals( ElementPageElements.checkbox_ResultValidation("Notes"), "Notes");
//		logger.log(Status.INFO,MarkupHelper.createLabel("CHECK BOX COMPLETED...!", ExtentColor.GREEN));
	}
	
	public static void radioButtonSubTab(ExtentTest logger) throws IOException
	{	
		CommonDef.waitVisible(ElementPageElements.subMenu_Tab_Dynamic("Radio Button"));
		CommonDef.click(ElementPageElements.subMenu_Tab_Dynamic("Radio Button"));
		CommonDef.waitVisible(ElementPageElements.radiobutton_Dynamic("Yes"));
		CommonDef.assertTextEquals( ElementPageElements.radiobutton_ResultValidation("Yes"), "Yes");
//		logger.log(Status.INFO,MarkupHelper.createLabel("RADIO BUTTON COMPLETED...!", ExtentColor.GREEN));
	}
	
	public static void buttonsSubTab() throws IOException
	{	
		CommonDef.waitVisible(ElementPageElements.subMenu_Tab_Dynamic("Buttons"));
		CommonDef.click(ElementPageElements.subMenu_Tab_Dynamic("Buttons"));
		CommonDef.waitVisible(ElementPageElements.button_double_click());
		CommonDef.doubleclick(ElementPageElements.button_double_click());
		CommonDef.waitVisible(ElementPageElements.button_right_click());
		CommonDef.rightclick(ElementPageElements.button_right_click());
		CommonDef.waitVisible(ElementPageElements.button_dynamic_click());
		CommonDef.click(ElementPageElements.button_dynamic_click());
		CommonDef.assertTextEquals( ElementPageElements.button_double_click_result(), "You have done a double click");
		CommonDef.assertTextEquals( ElementPageElements.button_right_click_result(), "You have done a right click");
		CommonDef.assertTextEquals( ElementPageElements.button_dynamic_click_result(), "You have done a dynamic click");
//		logger.log(Status.INFO,MarkupHelper.createLabel("BUTTON COMPLETED...!", ExtentColor.GREEN));
	}
	
	
	

}
