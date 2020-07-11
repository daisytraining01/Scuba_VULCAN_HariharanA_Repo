package com.ToolsQAProject.commonDef;

import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.maveric.core.utils.web.WebActions;
import com.ToolsQAProject.tests.ToolQAProject;
import com.ToolsQAProject.utilities.ExtendReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.maveric.core.config.ConfigProperties;
import com.maveric.core.testng.BaseTest;

public class CommonDef extends BaseTest{
		public static WebDriver driver;
		 
		
	   			   
	    public static void driver_initiate()
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
	    
	    public static void logPassAndTakeScreenShot( ExtentTest logger, String screenshotname,String Message, By by) throws IOException {
	    	logger.log(Status.PASS, Message+ "- "+by);
			logger.pass("Test Case Passed Snapshot is below " + logger.addScreenCaptureFromPath(getScreenShot(screenshotname)));
	    }
	    
	    public static void logFailAndTakeScreenShot( ExtentTest logger,String screenshotname,String Message, By by) throws IOException {
	    	logger.log(Status.FAIL, Message +"- "+by);
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(getScreenShot(screenshotname)));
	    }

	    
	    public static void waitVisible(By by, ExtentTest logger) throws IOException {
			try {
				WebDriverWait wait = new WebDriverWait(driver, (ConfigProperties.WAIT_TIMEOUT.getInt()));
				wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				logger.log(Status.PASS, "Element Found "+ "- "+by);
			} catch (Exception e) {
				logFailAndTakeScreenShot(logger,"WebElementNotFound","WebElementNotFound",by);
			}
		}
	    
	    public static WebElement findElement(By by, ExtentTest logger)  throws IOException {
			try {		
				logPassAndTakeScreenShot(logger,"WebElementFound","WebElementFound", by);
				return driver.findElement(by);
				
			} catch (Exception e) {
				logFailAndTakeScreenShot(logger,"WebElementNotFound","WebElementNotFound",by);
				return null;
			}
		}

	    public static void click(By by, ExtentTest logger) throws IOException {
			try {
				
				WebElement element = driver.findElement(by);
				element.click();
				logger.log(Status.PASS, "Element CLicked "+ "- "+by);
			} catch (Exception e) {
				logFailAndTakeScreenShot(logger,"WebElementNotClicked","WebElementNotClicked",by);
				
			}
		}
	    
	    
	    public static String getScreenShot(String screenshotName) throws IOException {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			File source = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			String path =  "./test-output/ToolQAReport/Screenshots/" + screenshotName + dateName + ".png";
			File finalDestination = new File(path);
			FileUtils.copyFile(source, finalDestination);
			return path;
		}

		public static String getText(By by,ExtentTest logger) throws IOException {
	    	String text = null;
			try {
				 text = driver.findElement(by).getText();
			} catch (Exception e) {
				logFailAndTakeScreenShot(logger,"LocatorNotFound","LocatorNotFound",by);
			}
			
			return text;
		}
		
		public static String[] splitMethod(By by,String Symbol,ExtentTest logger) throws IOException {
	    	String text = null;
	    	 String[] array = null;
	    	
			try {
				 text = driver.findElement(by).getText();
				  array = text.split(Symbol);
			} catch (Exception e) {
				logFailAndTakeScreenShot(logger,"LocatorNotFound","LocatorNotFound",by);
			}
			
			return array;
		}
	    
	    
	    public static void scrollJS(By by, ExtentTest logger) throws IOException {
			try {
				WebElement element = driver.findElement(by);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			    Thread.sleep(500);
			} catch (Exception e) {
				logFailAndTakeScreenShot(logger,"UnableToScroll","UnableToScroll",by);
			}
			
		}
	    
	    public static void sendKeys(By by, String keysToSend,ExtentTest logger) throws IOException {
			try {
				driver.findElement(by).sendKeys(keysToSend);
				logPassAndTakeScreenShot(logger,"SendValueSuccess","SendValueSuccess",by);
			} catch (Exception E) {
				logFailAndTakeScreenShot(logger,"SendValueFailed","SendValueFailed",by);
			}
		}
	    
	    public static void clearText(By elem) {
	    	driver.findElement(elem).clear();
		}
	    
	    public static void createNode(ExtentTest logger,String Message) {
	    	logger.createNode(Message);
		}
	    
	    public static void clickJS(By by, ExtentTest logger) throws IOException {
			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();",  driver.findElement(by));
				logger.log(Status.PASS, "Element CLicked "+ "- "+by);
			} catch (Exception E) {
				logFailAndTakeScreenShot(logger,"WebElementNotClicked","WebElementNotClicked",by);
			}
		}
	    
	   
	    
	    
	    //*******************************  ASSERTIONS  ********************************************
	    
	    public static void assertTextEquals(ExtentTest logger,By by, String expected) throws IOException
	    {
	    	String actual = null;
	    	try {
	    		actual = getText(by, logger);
				Assert.assertEquals(actual, expected);
				logger.log(Status.PASS,"Actual- "+actual+" || Expected- "+expected);
			} catch (Exception E) {
				logger.log(Status.FAIL,"Assertion Failed - Actual ->"+actual+ "|| Expected ->"+expected);
			}
	    }
	    
	    public static void assertTextEquals(ExtentTest logger,String actual, String expected) throws IOException
	    {
	    	try {
	    		
				Assert.assertEquals(actual, expected);
				logger.log(Status.PASS,"Actual- "+actual+" || Expected- "+expected);
			} catch (Exception E) {
				logger.log(Status.FAIL,"Assertion Failed - Actual ->"+actual+ "|| Expected ->"+expected);
			}
	    }
	    
	    



	    
	    
	    
}
