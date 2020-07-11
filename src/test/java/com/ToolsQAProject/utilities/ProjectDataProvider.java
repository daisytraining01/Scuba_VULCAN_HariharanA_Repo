package com.ToolsQAProject.utilities;

import org.testng.annotations.DataProvider;

public class ProjectDataProvider {
	
	@DataProvider(name="additionData")
	public Object[][] getAdditionData() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{1, 2, 3},
			{3, 4, 7},
			{5, 6, 11}
		};
	}

}
