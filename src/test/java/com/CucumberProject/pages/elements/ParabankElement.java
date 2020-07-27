package com.CucumberProject.pages.elements;

import org.openqa.selenium.By;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.commonDef.CommonDef.Locators;

public class ParabankElement {
	
	 public static By parabank_register_link() {
	        return CommonDef.locatorValue(Locators.XPATH,"//a[contains(text(),'Register')]");
	    }
	 
	 public static By parabank_logo() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[@class='logo']");
	    }
	 
	 public static By parabank_register_header() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[@id='rightPanel']//h1");
	    }
	
	 public static By parabank_register_textbox_dynamic(String textboxname) {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[contains(text(),'"+textboxname+"')]//parent::td//following-sibling::td//input");
	    }
	 
	 public static By parabank_register_button() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[@value='Register']");
	    }
	 
	 public static By parabank_login_usernamebox() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[@name='username']");
	    }
	 
	 public static By parabank_login_passwordbox() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[@name='password']");
	    }
	 
	 public static By parabank_logon_button() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[@value='Log In']");
	    }
	 
	 public static By parabank_logout_link() {
	        return CommonDef.locatorValue(Locators.XPATH,"//a[contains(text(),'Log Out')]");
	    }
	
	
	
	

}
