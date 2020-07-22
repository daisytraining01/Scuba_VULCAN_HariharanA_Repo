package com.ToolsQAProject.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ToolsQAProject.commonDef.CommonDef;

public class BrowserFactory {
	
	
	public static WebDriver createInstance(String browser)
	{
		WebDriver driver = null;
		
		try {
			
			if (browser.equalsIgnoreCase("chrome"))
			{
				System.out.println("Chrome ");
				System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		    	driver = new ChromeDriver();
			}
			
			else if (browser.equalsIgnoreCase("firefox"))
			{
				System.out.println("Firefox ");
	    		System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver.exe");
		    	driver = new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return driver;
		}
		
		
		return driver;
		
	}

}
