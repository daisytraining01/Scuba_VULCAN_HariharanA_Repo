package com.CucumberProject.utilities;

import org.testng.annotations.DataProvider;

import com.codoid.products.exception.FilloException;

public class ProjectDataProvider {
	
	@DataProvider(name="forms", parallel = true)
	public Object[][] getFormsData() throws FilloException {
		return new Object[][] {
			{ExcelReader.ReadExcel(System.getProperty("user.dir")+ "/src/test/java/com/ToolsQAProject/resource/TestData.xlsx", "FormsToolsQA", "TC_ID='TC001'")},
			{ExcelReader.ReadExcel(System.getProperty("user.dir")+ "/src/test/java/com/ToolsQAProject/resource/TestData.xlsx", "FormsToolsQA", "TC_ID='TC002'")}
			
		};
	}
	
	@DataProvider(name="parabank",parallel = true)
	public Object[][] getParabankData() throws FilloException {
		return new Object[][] {
			{ExcelReader.ReadExcel(System.getProperty("user.dir")+ "/src/test/java/com/ToolsQAProject/resource/TestData.xlsx", "RegisterParaBank", "TC_ID='TC001'")},
			{ExcelReader.ReadExcel(System.getProperty("user.dir")+ "/src/test/java/com/ToolsQAProject/resource/TestData.xlsx", "RegisterParaBank", "TC_ID='TC002'")}
			
		};
	}

}
