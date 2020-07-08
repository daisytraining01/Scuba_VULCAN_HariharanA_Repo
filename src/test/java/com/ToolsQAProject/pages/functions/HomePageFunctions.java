package com.ToolsQAProject.pages.functions;

import com.ToolsQAProject.commonDef.CommonDef;
import com.ToolsQAProject.pages.elements.HomePageElements;


public class HomePageFunctions {
	
	public static void elementTabClick()
	{
		CommonDef.waitVisible(HomePageElements.elementsTab());
		CommonDef.findElement(HomePageElements.elementsTab());
		System.out.println("Text-->"+CommonDef.getText(HomePageElements.elementsTab()));
		CommonDef.scrollJS(HomePageElements.elementsTab());
		CommonDef.click(HomePageElements.elementsTab());
		
	}

}
