package com.ToolsQAProject.pages.functions;

import java.io.IOException;
import java.util.HashMap;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.pages.elements.ParabankElement;

public class ParabankFunctions {
	public static void registerParaBank(HashMap<Object, Object> testData) throws IOException
	{	
		CommonDef.waitForPageLoad();
		CommonDef.clickJS(ParabankElement.parabank_register_link());
		CommonDef.waitForPageLoad();
		CommonDef.assertTextEquals(ParabankElement.parabank_register_header(), "Signing up is easy!");		
		CommonDef.sendKeys(ParabankElement.parabank_register_textbox_dynamic("First Name"), testData.get("FirstName"));
		CommonDef.sendKeys(ParabankElement.parabank_register_textbox_dynamic("Last Name"), testData.get("LastName"));
		CommonDef.sendKeys(ParabankElement.parabank_register_textbox_dynamic("Address"), testData.get("Address"));
		CommonDef.sendKeys(ParabankElement.parabank_register_textbox_dynamic("City"), testData.get("City"));
		CommonDef.sendKeys(ParabankElement.parabank_register_textbox_dynamic("State"), testData.get("State"));
		CommonDef.sendKeys(ParabankElement.parabank_register_textbox_dynamic("Zip Code"), testData.get("ZipCode"));
		CommonDef.sendKeys(ParabankElement.parabank_register_textbox_dynamic("Phone"), testData.get("Phone"));
		CommonDef.sendKeys(ParabankElement.parabank_register_textbox_dynamic("SSN"), testData.get("SSN"));
		CommonDef.sendKeys(ParabankElement.parabank_register_textbox_dynamic("Username"), testData.get("UserName"));
		CommonDef.sendKeys(ParabankElement.parabank_register_textbox_dynamic("Password"), testData.get("Password"));
		CommonDef.sendKeys(ParabankElement.parabank_register_textbox_dynamic("Confirm"), testData.get("ConfirmPassword"));
		CommonDef.clickJS(ParabankElement.parabank_register_button());
		CommonDef.waitForPageLoad();
		CommonDef.assertTextEquals(ParabankElement.parabank_register_header(), "Welcome "+testData.get("UserName").toString());
	}

	public static void loginParaBank(HashMap<Object, Object> testData) throws IOException {
		// TODO Auto-generated method stub
		CommonDef.waitForPageLoad();
		CommonDef.sendKeys(ParabankElement.parabank_login_usernamebox(),  testData.get("UserName"));
		CommonDef.sendKeys(ParabankElement.parabank_login_passwordbox(), testData.get("Password"));
		CommonDef.clickJS(ParabankElement.parabank_logon_button());
		CommonDef.waitForPageLoad();	
	}
	
	public static void logoutParaBank() throws IOException {
		// TODO Auto-generated method stub
		CommonDef.waitForPageLoad();
		CommonDef.waitVisible(ParabankElement.parabank_logout_link());
		CommonDef.clickJS(ParabankElement.parabank_logout_link());
		
		
	}
		

}
