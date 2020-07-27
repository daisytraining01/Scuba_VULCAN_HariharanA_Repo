package com.CucumberProject.stepDefinitions;

import java.util.HashMap;

import com.CucumberProject.commonDef.CommonDef;
import com.CucumberProject.utilities.ExcelReader;
import com.maveric.core.utils.data.Database;
import com.maveric.core.utils.reporter.Report;
import com.CucumberProject.pages.elements.ParabankElement;
import com.CucumberProject.pages.functions.ParabankFunctions;

import io.cucumber.java8.En;

public class ParabankLoginStepDefinition implements En{
	CommonDef methods = new CommonDef();
	ParabankFunctions parabankFunctions = new ParabankFunctions();
	HashMap<Object, Object> testData;
	
	
	public ParabankLoginStepDefinition()
	{	 
		 Given("User should pass the vaild data for {string} for {string} from DB table {string}", (String caseID, String dbName, String dbTableName) -> {
			 	Database db = new Database("mysql", "Hariharan", "Iamgroot", "localhost", "3306", dbName);
			    System.out.println("Case ID --"+caseID);
			    //testData = ExcelReader.ReadExcel(System.getProperty("user.dir")+ "/src/test/java/com/ToolsQAProject/resource/TestData.xlsx",workbookname , "TC_ID='"+caseID+"'");			 
			    testData = db.readDataFromDB("select * from "+dbTableName+" where TC_ID='"+caseID+"'");
			    Report.log("Data Used :\n"+testData.toString());
			});
	
		 
		 When("I launch parabank website {string}", (String url) -> {
			 methods.launchURL(url);
			 methods.maxmizeBrowser();
	        });
		 
		   And("I click on register link", () -> {
			   parabankFunctions.registerlinkclick();
	        });
		 
		 Then("System should show the header as {string}", (String message) -> {
			 methods.assertTextEquals(ParabankElement.parabank_register_header(), message);	
	        });
		 
		 When("I fill the mandatory details", () -> {
			 parabankFunctions.registerParaBank(testData);
	        });
		 
		 And("I click on register button", () -> {
			 parabankFunctions.registerButtonClick();
	        });
		 
		 Then("System should display the user name in home page", () -> {
			 methods.waitnow();
			 methods.assertTextEquals(ParabankElement.parabank_register_header(), "Welcome "+testData.get("UserName").toString());
	        });
		 
		 When("I click on logout link", () -> {
			 parabankFunctions.logoutParaBank();
	        });
		 
		 Then("System should logout the session", () -> {
			 parabankFunctions.homepagevalidation();
	        });
		 
		 When("I login with registered details", () -> {
			 parabankFunctions.loginParaBank(testData);
	        });
		 
		 Then("System should take to parabank home page", () -> {
			 
	        });
		 
		 
		 
	}
	

}
