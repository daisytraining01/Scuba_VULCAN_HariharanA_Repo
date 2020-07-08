package com.ToolsQAProject.commonDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.maveric.core.utils.web.WebActions;
import com.maveric.core.config.ConfigProperties;
import com.maveric.core.testng.BaseTest;

public class CommonDef extends BaseTest{
		 static WebDriver driver = null;
	   			   
	    public static WebDriver driver_initiate()
	    {
	    	String browserName = ConfigProperties.BROWSER.get();
	    	
	    	switch (browserName.toLowerCase())
	    	{
	    	case "chrome":
	    		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		    	driver = new ChromeDriver();
		    	break;
			case "firefox":
	    		System.out.println("Firefox ");
	    		break;	
	    		
	    	}
	    	return driver;
	    	
	    }
	    
	    public static void launchURL(String URL)
	    {
	    	driver.get(URL);
	    	Reporter.log("URL Launched.."+URL, true);
	    	
	    	
	    		    	
	    }
	    
	    public static void implicitWait()
	    {
	    	driver.manage().timeouts().implicitlyWait(ConfigProperties.WAIT_TIMEOUT.getInt(), TimeUnit.SECONDS);    		    	
	    }
	    
	    public static void maxmizeBrowser()
	    {
	    	driver.manage().window().maximize();
	    	implicitWait();
	    }
	    
	    public static void closeBrowser()
	    {
	    	driver.close();	    	
	    }
	    
	    public static void driverInit(String URL)
	    {
	    	driver_initiate();
	    	launchURL(URL);
	    	maxmizeBrowser();
	    	implicitWait();    	
	    }
	    
	    public enum Locators {
	        ID, NAME, XPATH, CSS, LINKTEXT, PARTIAL_LINKTEXT, TAG_NAME, NA, CLASS_NAME
	    }
	    
	    public static By locatorValue(Locators locatorTpye, String value) {
			By by = null;
			switch (locatorTpye) {
			case ID:
				by = By.id(value);
				break;
			case NAME:
				by = By.name(value);
				break;
			case XPATH:
				by = By.xpath(value);
				break;
			case CSS:
				by = By.cssSelector(value);
				break;
			case LINKTEXT:
				by = By.linkText(value);
				break;
			case PARTIAL_LINKTEXT:
				by = By.partialLinkText(value);
				break;
			case TAG_NAME:
				by = By.tagName(value);
				break;
			case CLASS_NAME:
				by = By.className(value);
				break;
			case NA:
				break;
			}
			return by;
		}

	    
	    public static void waitVisible(By by) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, (ConfigProperties.WAIT_TIMEOUT.getInt()));
				wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				System.out.println("Element is located");
			} catch (Exception e) {
				Reporter.log("Element not visible "+ by+e.getMessage(), false);
			}
		}
	    
	    public static WebElement findElement(By by) {
			try {			
				return driver.findElement(by);
				
			} catch (Exception e) {
				Reporter.log("Unable to Find the element "+ by+e.getMessage(), false);
				return null;
			}
		}

	    public static void click(By by) {
			try {
				
				WebElement element = driver.findElement(by);
				element.click();
			} catch (Exception e) {
				Reporter.log("Unable to click the element "+ by+e.getMessage(), false);
			}
		}
	    
	    public static String getText(By by) {
	    	String text = null;
			try {
				 text = driver.findElement(by).getText();
			} catch (Exception e) {
				Reporter.log("Unable to click the element "+ by+e.getMessage(), false);
			}
			
			return text;
		}
	    
	    
	    public static void scrollJS(By by) {
			try {
				WebElement element = driver.findElement(by);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			    Thread.sleep(500);
			} catch (Exception e) {
				Reporter.log("Unable to scroll to the element "+ by+e.getMessage(), false);
			}
			
		}

	    
	    
	    
}
