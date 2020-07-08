package com.ToolsQAProject.pages.elements;

import org.openqa.selenium.By;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.commonDef.CommonDef.Locators;

public class HomePageElements {
	
	 public static By elementsTab() {
	        return CommonDef.locatorValue(Locators.XPATH,"//*[text()='Elements']");
	    }

}
