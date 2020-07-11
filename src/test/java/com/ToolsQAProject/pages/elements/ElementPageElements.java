package com.ToolsQAProject.pages.elements;

import org.openqa.selenium.By;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.commonDef.CommonDef.Locators;

public class ElementPageElements {
	 public static By elements_Title_Text() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[@class='main-header']");
	    }
	 
	 public static By subMenu_Tab_Dynamic(String SubMenuName) {
	        return CommonDef.locatorValue(Locators.XPATH,"//span[contains(text(),'"+SubMenuName+"')]");
	    }
	 
	 public static By textBox_FullName_Box() {
	        return CommonDef.locatorValue(Locators.ID,"userName");
	    }
	 
	 public static By textBox_nameResult_Box() {
	        return CommonDef.locatorValue(Locators.XPATH,"//p[@id='name']");
	    }
	 
	 public static By textBox_Email_Box() {
	        return CommonDef.locatorValue(Locators.ID,"userEmail");
	    }
	 
	 public static By textBox_EmailResult_Box() {
	        return CommonDef.locatorValue(Locators.XPATH,"//p[@id='email']");
	    }
	 
	 public static By textBox_Address_Box() {
	        return CommonDef.locatorValue(Locators.ID,"currentAddress");
	    }
	 
	 public static By textBox_AddressResult_Box() {
	        return CommonDef.locatorValue(Locators.XPATH,"//p[@id='currentAddress']");
	    }
	 
	 public static By textBox_Submit_Button() {
	        return CommonDef.locatorValue(Locators.ID,"submit");
	    }
	 
	 public static By checkbox_Dynamic(String checkboxName) {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[@class='rct-checkbox']//following-sibling::span//following-sibling::span[contains(text(),'"+checkboxName+"')]");
	    }
	 
	 public static By checkbox_Expand_Button() {
	        return CommonDef.locatorValue(Locators.XPATH,"//button[@title='Expand all']");
	    }
	 
	 public static By checkbox_Collapse_Button() {
	        return CommonDef.locatorValue(Locators.XPATH,"//button[@title='Collapse all']");
	    }
	 
	 public static By checkbox_ResultValidation(String result) {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'"+result+"')]");
	    }
	
	
}
