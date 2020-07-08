package com.ToolsQAProject.stepDefinition;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.pages.functions.HomePageFunctions;
import com.maveric.core.config.ConfigProperties;

public class ToolsQAProjectStepDefinition {
	
	public void elementsTextBox()
	{
		CommonDef.driverInit(ConfigProperties.TOOLSQA_URL.get());
		HomePageFunctions.elementTabClick();		
		
	}

}
