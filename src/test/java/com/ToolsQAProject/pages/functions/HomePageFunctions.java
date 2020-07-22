package com.ToolsQAProject.pages.functions;

import java.io.IOException;

import org.testng.Assert;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.pages.elements.ElementPageElements;
import com.ToolsQAProject.pages.elements.HomePageElements;
import com.relevantcodes.extentreports.ExtentTest;


public class HomePageFunctions {
	
	public static void elementTabClick() throws IOException
	{
		CommonDef.findElement(HomePageElements.elements_Tab());
		CommonDef.scrollJS(HomePageElements.elements_Tab());
		CommonDef.click(HomePageElements.elements_Tab());
		CommonDef.assertTextEquals( ElementPageElements.elements_Title_Text(), "Elements");
	}
	
	public static void formsTabClick() throws IOException
	{
		CommonDef.findElement(HomePageElements.forms_Tab());
		CommonDef.scrollJS(HomePageElements.forms_Tab());
		CommonDef.click(HomePageElements.forms_Tab());
		CommonDef.assertTextEquals( ElementPageElements.elements_Title_Text(), "Forms");
	}
	
	
	public static void alerts_frame_windowsTabClick() throws IOException
	{
		CommonDef.findElement(HomePageElements.alert_frame_window_Tab());
		CommonDef.scrollJS(HomePageElements.alert_frame_window_Tab());
		CommonDef.click(HomePageElements.alert_frame_window_Tab());
		CommonDef.assertTextEquals( ElementPageElements.elements_Title_Text(), "Alerts, Frame & Windows");
	}
	
	public static void WidgetsTabClick() throws IOException
	{
		CommonDef.findElement(HomePageElements.widgets_Tab());
		CommonDef.scrollJS(HomePageElements.widgets_Tab());
		CommonDef.click(HomePageElements.widgets_Tab());
		CommonDef.assertTextEquals( ElementPageElements.elements_Title_Text(), "Widgets");
	}
	
	public static void interactionsClick() throws IOException
	{
		CommonDef.findElement(HomePageElements.interactions_Tab());
		CommonDef.scrollJS(HomePageElements.interactions_Tab());
		CommonDef.click(HomePageElements.interactions_Tab());
		CommonDef.assertTextEquals( ElementPageElements.elements_Title_Text(), "Interactions");
	}
	
	public static void bookStoreClick() throws IOException
	{
		CommonDef.findElement(HomePageElements.bookstore_Tab());
		CommonDef.scrollJS(HomePageElements.bookstore_Tab());
		CommonDef.click(HomePageElements.bookstore_Tab());
		CommonDef.assertTextEquals( ElementPageElements.elements_Title_Text(), "Book Store");
	}

}
