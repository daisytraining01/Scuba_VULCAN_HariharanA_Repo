package com.CucumberProject.pages.functions;

import java.io.IOException;
import java.util.HashMap;

import com.CucumberProject.commonDef.CommonDef;
import com.CucumberProject.pages.elements.ParabankElement;

public class ParabankFunctions {
	CommonDef methods = new CommonDef();
	
	public void registerlinkclick() throws IOException
	{
		methods.clickJS(ParabankElement.parabank_register_link());
	}
	public void registerParaBank(HashMap<Object, Object> testData) throws IOException
	{	
		methods.clickJS(ParabankElement.parabank_register_link());
		methods.assertTextEquals(ParabankElement.parabank_register_header(), "Signing up is easy!");		
		methods.sendKeys(ParabankElement.parabank_register_textbox_dynamic("First Name"), testData.get("FirstName"));
		methods.sendKeys(ParabankElement.parabank_register_textbox_dynamic("Last Name"), testData.get("LastName"));
		methods.sendKeys(ParabankElement.parabank_register_textbox_dynamic("Address"), testData.get("Address"));
		methods.sendKeys(ParabankElement.parabank_register_textbox_dynamic("City"), testData.get("City"));
		methods.sendKeys(ParabankElement.parabank_register_textbox_dynamic("State"), testData.get("State"));
		methods.sendKeys(ParabankElement.parabank_register_textbox_dynamic("Zip Code"), testData.get("ZipCode"));
		methods.sendKeys(ParabankElement.parabank_register_textbox_dynamic("Phone"), testData.get("Phone"));
		methods.sendKeys(ParabankElement.parabank_register_textbox_dynamic("SSN"), testData.get("SSN"));
		methods.sendKeys(ParabankElement.parabank_register_textbox_dynamic("Username"), testData.get("UserName"));
		methods.sendKeys(ParabankElement.parabank_register_textbox_dynamic("Password"), testData.get("Password"));
		methods.sendKeys(ParabankElement.parabank_register_textbox_dynamic("Confirm"), testData.get("ConfirmPassword"));
	}
	
	public  void registerButtonClick() throws IOException
	{
		methods.clickJS(ParabankElement.parabank_register_button());
	}

	public  void loginParaBank(HashMap<Object, Object> testData) throws IOException {
		// TODO Auto-generated method stub
		methods.sendKeys(ParabankElement.parabank_login_usernamebox(),  testData.get("UserName"));
		methods.sendKeys(ParabankElement.parabank_login_passwordbox(), testData.get("Password"));
		methods.clickJS(ParabankElement.parabank_logon_button());	
	}
	
	public void logoutParaBank() throws IOException {
		// TODO Auto-generated method stub
		methods.waitVisible(ParabankElement.parabank_logout_link());
		methods.clickJS(ParabankElement.parabank_logout_link());
		
	}
	
	public void homepagevalidation() throws IOException {
		// TODO Auto-generated method stub
		methods.waitVisible(ParabankElement.parabank_logo());
		
	}
		

}
