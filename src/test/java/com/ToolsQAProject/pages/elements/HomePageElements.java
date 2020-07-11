package com.ToolsQAProject.pages.elements;

import org.openqa.selenium.By;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.commonDef.CommonDef.Locators;

public class HomePageElements {
	
	 public static By elements_Tab() {
	        return CommonDef.locatorValue(Locators.XPATH,"(//*[@class='card-body']/h5)[1]");
	    }
	 
	 public static By forms_Tab() {
	        return CommonDef.locatorValue(Locators.XPATH,"(//*[@class='card-body']/h5)[2]");
	    }
	 
	 public static By alert_frame_window_Tab() {
	        return CommonDef.locatorValue(Locators.XPATH,"(//*[@class='card-body']/h5)[3]");
	    }
	 
	 public static By widgets_Tab() {
	        return CommonDef.locatorValue(Locators.XPATH,"(//*[@class='card-body']/h5)[4]");
	    }
	 
	 public static By interactions_Tab() {
	        return CommonDef.locatorValue(Locators.XPATH,"(//*[@class='card-body']/h5)[5]");
	    }
	 
	 public static By bookstore_Tab() {
	        return CommonDef.locatorValue(Locators.XPATH,"(//*[@class='card-body']/h5)[6]");
	    }
	 
	 
	 
	

}
