package com.ToolsQAProject.utilities;

import org.testng.annotations.DataProvider;

import com.codoid.products.exception.FilloException;

public class ProjectDataProvider {
	
	@DataProvider(name="forms")
	public Object[][] getFormsData() throws FilloException {
		return new Object[][] {
			{ExcelReader.ReadExcel(System.getProperty("user.dir")+ "/src/test/java/com/ToolsQAProject/resource/TestData.xlsx", "Sheet1", "TC_ID='TC001'")},
			{ExcelReader.ReadExcel(System.getProperty("user.dir")+ "/src/test/java/com/ToolsQAProject/resource/TestData.xlsx", "Sheet1", "TC_ID='TC002'")}
			
		};
	}

}
