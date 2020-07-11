package com.ToolsQAProject.pages.functions;

import java.io.IOException;

import org.testng.Assert;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.pages.elements.ElementPageElements;
import com.ToolsQAProject.pages.elements.HomePageElements;
import com.aventstack.extentreports.ExtentTest;


public class HomePageFunctions {
	
	public static void elementTabClick(ExtentTest logger) throws IOException
	{
		CommonDef.findElement(HomePageElements.elements_Tab(),logger);
		CommonDef.scrollJS(HomePageElements.elements_Tab(),logger);
		CommonDef.click(HomePageElements.elements_Tab(),logger);
		CommonDef.assertTextEquals(logger, ElementPageElements.elements_Title_Text(), "Elements");
	}
	
	public static void formsTabClick(ExtentTest logger) throws IOException
	{
		CommonDef.findElement(HomePageElements.forms_Tab(),logger);
		CommonDef.scrollJS(HomePageElements.forms_Tab(),logger);
		CommonDef.click(HomePageElements.forms_Tab(),logger);
		CommonDef.assertTextEquals(logger, ElementPageElements.elements_Title_Text(), "Forms");
	}
	
	public static void alerts_frame_windowsTabClick(ExtentTest logger) throws IOException
	{
		CommonDef.findElement(HomePageElements.alert_frame_window_Tab(),logger);
		CommonDef.scrollJS(HomePageElements.alert_frame_window_Tab(),logger);
		CommonDef.click(HomePageElements.alert_frame_window_Tab(),logger);
		CommonDef.assertTextEquals(logger, ElementPageElements.elements_Title_Text(), "Alerts, Frame & Windows");
	}
	
	public static void WidgetsTabClick(ExtentTest logger) throws IOException
	{
		CommonDef.findElement(HomePageElements.widgets_Tab(),logger);
		CommonDef.scrollJS(HomePageElements.widgets_Tab(),logger);
		CommonDef.click(HomePageElements.widgets_Tab(),logger);
		CommonDef.assertTextEquals(logger, ElementPageElements.elements_Title_Text(), "Widgets");
	}
	
	public static void interactionsClick(ExtentTest logger) throws IOException
	{
		CommonDef.findElement(HomePageElements.interactions_Tab(),logger);
		CommonDef.scrollJS(HomePageElements.interactions_Tab(),logger);
		CommonDef.click(HomePageElements.interactions_Tab(),logger);
		CommonDef.assertTextEquals(logger, ElementPageElements.elements_Title_Text(), "Interactions");
	}
	
	public static void bookStoreClick(ExtentTest logger) throws IOException
	{
		CommonDef.findElement(HomePageElements.bookstore_Tab(),logger);
		CommonDef.scrollJS(HomePageElements.bookstore_Tab(),logger);
		CommonDef.click(HomePageElements.bookstore_Tab(),logger);
		CommonDef.assertTextEquals(logger, ElementPageElements.elements_Title_Text(), "Book Store");
	}

}
