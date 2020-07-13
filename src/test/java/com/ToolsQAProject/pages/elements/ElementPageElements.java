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
	 
	 public static By radiobutton_Dynamic(String radiobuttonName) {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'"+radiobuttonName+"')]");
	    }
	 
	 public static By radiobutton_ResultValidation(String result) {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'"+result+"')]");
	    }
	 
	 public static By button_dynamic_click() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[@id='rightClickBtn']//parent::div//following-sibling::div//button");
	    }
	 
	 public static By button_right_click() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[@id='rightClickBtn']");
	    }
	 
	 public static By button_double_click() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[@id='doubleClickBtn']");
	    }
	 
	 public static By button_double_click_result() {
	        return CommonDef.locatorValue(Locators.ID,"doubleClickMessage");
	    }
	 
	 public static By button_right_click_result() {
	        return CommonDef.locatorValue(Locators.ID,"rightClickMessage");
	    }
	 
	 public static By button_dynamic_click_result() {
	        return CommonDef.locatorValue(Locators.ID,"dynamicClickMessage");
	    }
	 
	 public static By button_click_dynamic_text(String buttonName) {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'"+buttonName+"']");
	    }
	 
	public static By webtable_dynamic_Editbutton(String name, String email)
	{
		 return CommonDef.locatorValue(Locators.XPATH,"//div[contains(text(),'"+name+"')]//following-sibling::div[contains(text(),'"+email+"')]//following-sibling::div[3]//div//span[@title='Edit']");
	}
	
	public static By webtable_dynamic_Deletebutton(String name, String email)
	{
		 return CommonDef.locatorValue(Locators.XPATH,"//div[contains(text(),'"+name+"')]//following-sibling::div[contains(text(),'"+email+"')]//following-sibling::div[3]//div//span[@title='Delete']");
	}
	
	public static By webtable_dynamic_firstname(String firstname) {
        return CommonDef.locatorValue(Locators.XPATH,"//div[contains(text(),'"+firstname+"')]");
    }
	
	public static By webtable_dynamic_secname(String firstname) {
        return CommonDef.locatorValue(Locators.XPATH,"//div[contains(text(),'"+firstname+"')]//following-sibling::div[1]");
    }
	
	public static By webtable_dynamic_age(String firstname) {
        return CommonDef.locatorValue(Locators.XPATH,"//div[contains(text(),'"+firstname+"')]//following-sibling::div[2]");
    }
	
	public static By webtable_dynamic_email(String firstname) {
        return CommonDef.locatorValue(Locators.XPATH,"//div[contains(text(),'"+firstname+"')]//following-sibling::div[3]");
    }
	
	public static By webelement_add_firstname_Box() {
        return CommonDef.locatorValue(Locators.ID,"firstName");
    }
	
	public static By webelement_add_lastName_Box() {
        return CommonDef.locatorValue(Locators.ID,"lastName");
    }
	
	
	
}
