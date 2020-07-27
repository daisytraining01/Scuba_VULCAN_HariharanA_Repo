package com.CucumberProject.commonDef;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ToolsQAProject.Driver.BrowserFactory;
import com.ToolsQAProject.Driver.DriverFactory;
import com.ToolsQAProject.tests.TestBase;
import com.maveric.core.config.ConfigProperties;
import com.maveric.core.driver.Driver;
import com.maveric.core.utils.reporter.Report;
import com.maveric.core.utils.web.WebActions;

public class CommonDef extends WebActions{
	
	public  WebDriver getCurrentDriver()
	{
		return Driver.getWebDriver();
	}

	public void  launchURL(String URL)
	{
		try {
			getCurrentDriver().get(URL);
			Report.log("URL Lunched Successfully"+URL);
			logScreenshot("URL_Launched");
		
		} catch (Exception e) {
			// TODO: handle exception
			logScreenshot("URL_Launched_Failed");
			logger.error("Failed Reason" + e);
		}
		
	}
	
	public String  getCurrentURL()
	{
		try {
			return getCurrentDriver().getCurrentUrl();
		
		} catch (Exception e) {
			logger.error("Failed Reason" + e);
			return null;
			
		}
		
	}

	public  void implicitWait()
	{
		try {
			getCurrentDriver().manage().timeouts().implicitlyWait(ConfigProperties.WAIT_TIMEOUT.getInt(), TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Failed Reason" + e);
		}
		
		    		    	
	}

	public  void waitnow()
	{
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.error("Failed Reason" + e);
		}
	}
	public  void maxmizeBrowser()
	{
		
		try {
			getCurrentDriver().manage().window().maximize();
			implicitWait();
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Failed Reason" + e);
		}
	}

	public void closeBrowser()
	{
		getCurrentDriver().close();	    	
	}



	public enum Locators {
		ID, NAME, XPATH, CSS, LINKTEXT, PARTIAL_LINKTEXT, TAG_NAME, NA, CLASS_NAME
	}

	public  By locatorValue(Locators locatorTpye, String value) {
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




	public  void waitVisible(By by) throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(getCurrentDriver(), (ConfigProperties.WAIT_TIMEOUT.getInt()));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			logScreenshot("Element Visible");
		} catch (Exception e) {
			logger.error("Failed Reason" + e + by);
		}
	}

	public  WebElement findElement(By by)  throws IOException {
		try {		

			logScreenshot("Element Visible");
			return getCurrentDriver().findElement(by);

		} catch (Exception e) {
			logScreenshot("Element Not Visible");
			logger.error("Failed Reason" + e + by);
			return null;
		}
	}


	public  void click(By by) throws IOException {
		try {			
			waitVisible(by);
			WebElement element = getCurrentDriver().findElement(by);
			element.click();
			logScreenshot("Element clicked");
		} catch (Exception e) {		
			logger.error("Failed Reason" + e + by);

		}
	}


	public  String getText(By by) throws IOException {
		String text = null;
		try {
			text = getCurrentDriver().findElement(by).getText();
		} catch (Exception e) {
			logger.error("Failed Reason" + e + by);
		}

		return text;
	}


	public  String getAlertText() throws IOException {
		String text = null;
		try {

			text = getCurrentDriver().switchTo().alert().getText();
		} catch (Exception e) {
			logger.error("Failed Reason" + e );
		}

		return text;
	}

	public  void alertDismiss() throws IOException {
		try {

			implicitWait();
			getCurrentDriver().switchTo().alert().dismiss();
		} catch (Exception e) {
			logger.error("Failed Reason" + e);
		}

	}

	public  String[] splitMethod(By by,String Symbol) throws IOException {
		String text = null;
		String[] array = null;

		try {

			text = getCurrentDriver().findElement(by).getText();
			array = text.split(Symbol);
		} catch (Exception e) {
			logger.error("Failed Reason" + e + by);
		}

		return array;
	}


	public  void scrollJS(By by) throws IOException {
		try {

			WebElement element = getCurrentDriver().findElement(by);
			((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500);
		} catch (Exception e) {
			logger.error("Failed Reason" + e + by);
		}

	}

	public  void sendKeys(By by, String keysToSend) throws IOException {
		try {

			click(by);
			getCurrentDriver().findElement(by).sendKeys(keysToSend);
			logScreenshot("Element Visible");
		} catch (Exception e) {
			logger.error("Failed Reason" + e + by);
			logScreenshot("Element Not Visible");
		}
	}
	
	public  void sendKeys(By by, Object keysToSend) throws IOException {
		try {

			click(by);
			getCurrentDriver().findElement(by).sendKeys(keysToSend.toString());
			logScreenshot("Value send to Element ");
		} catch (Exception e) {
			logger.error("Failed Reason" + e + by);
			logScreenshot("Element Not Visible");
		}
	}

	public  void uploadPic(By by, String keysToSend) throws IOException {
		try {

			getCurrentDriver().findElement(by).sendKeys(keysToSend);
		} catch (Exception E) {
		}
	}

	public  void sendKeyswithEnter(By by, String keysToSend) throws IOException {
		try {

			Actions action = new Actions(getCurrentDriver());
			getCurrentDriver().findElement(by).sendKeys(keysToSend);
			action.sendKeys(Keys.ENTER).build().perform();
			logScreenshot("Value send to Element ");
		} catch (Exception e) {
			logger.error("Failed Reason" + e + by);
			logScreenshot("Element Not Visible");
		}
	}

	public  void sendKeyswithTab(By by, String keysToSend) throws IOException {
		try {

			click(by);
			getCurrentDriver().findElement(by).sendKeys(keysToSend);
			getCurrentDriver().findElement(by).sendKeys(Keys.TAB);
			logScreenshot("Value send to Element ");
		} catch (Exception e) {
			logger.error("Failed Reason" + e + by);
			logScreenshot("Element Not Visible");
		}
	}

	public  void clearText(By elem) {

		getCurrentDriver().findElement(elem).clear();
	}


	public  void clickJS(By by) throws IOException {
		try {

			JavascriptExecutor executor = (JavascriptExecutor) getCurrentDriver();
			executor.executeScript("arguments[0].click();",  getCurrentDriver().findElement(by));
			logScreenshot("Element clicked ");
		} catch (Exception e) {
			logger.error("Failed Reason" + e + by);
			logScreenshot("Element Not Visible");
		}
	}

	public  void doubleclick(By by) throws IOException {
		try {

			Actions actions = new Actions(getCurrentDriver());
			WebElement elementLocator = getCurrentDriver().findElement(by);
			actions.doubleClick(elementLocator).perform();
			logScreenshot("Element clicked ");
		} catch (Exception e) {
			logger.error("Failed Reason" + e + by);
			logScreenshot("Element Not Visible");

		}
	}

	public  void rightclick(By by) throws IOException {
		try {

			Actions actions = new Actions(getCurrentDriver());
			WebElement elementLocator = getCurrentDriver().findElement(by);
			actions.contextClick(elementLocator).perform();
			logScreenshot("Element clicked ");
		} catch (Exception e) {
			logger.error("Failed Reason" + e + by);
			logScreenshot("Element Not Visible");

		}
	}

	public  void reloadPage(ExtentTest testReporter) {
		try {

			getCurrentDriver().navigate().refresh();
			waitForPageLoad();
		} catch (Exception e) {
		}
	}

	public  void waitForPageLoad() {

		ExpectedCondition<Boolean> expect = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(getCurrentDriver(),120);
		try {
			wait.until(expect);
		} catch (Exception E) {
			Report.log("Page Load Condition failed. Continuing with test");
		}
	}

	public  String capitalize(String str) {
		if(str == null || str.isEmpty()) {
			return str;
		}

		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public  synchronized void datepicker(By by,String date, String Month,String Year) throws IOException
	{

		getCurrentDriver().findElement(by).click();
		String month_formated = capitalize(Month);
		implicitWait();
		String month_xpath = "//select[@class='react-datepicker__month-select']//option";

		getCurrentDriver().findElement(By.xpath(month_xpath)).click();
		implicitWait();
		List<WebElement> month_element = getCurrentDriver().findElements(By.xpath(month_xpath));
		for(WebElement option : month_element)
		{
			String month = option.getText();


			if(month.equals(month_formated))
			{
				option.click();
				implicitWait();   
				break;
			}

		}

		String year_xpath = "//select[@class='react-datepicker__year-select']//option";
		getCurrentDriver().findElement(By.xpath(year_xpath)).click();  
		implicitWait();
		List<WebElement> year_element = getCurrentDriver().findElements(By.xpath(year_xpath));
		for(WebElement option : year_element)
		{
			String year = option.getText();


			if(year.equals(Year))
			{
				option.click();
				implicitWait();
				break;

			}

		}

		List<WebElement> dates = getCurrentDriver().findElements(By.xpath("//div[@class='react-datepicker']/child::div[2]/child::div[2]/div/div"));

		for(WebElement elem : dates)
		{
			String datess = elem.getText();

			if(datess.equals(date))
			{
				elem.click();
				implicitWait();
				break;
			}			
		}

	}


	public  String getScreenShot(String screenshotName) throws IOException{

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) getCurrentDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/target/Screenshots/" + screenshotName + dateName+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	

	public  String getsubstring(String string, int beginIndex, int lastIndex) throws IOException{
		String substring ;
		if (string.length() > lastIndex) 
		{
			substring = string.toLowerCase().substring(beginIndex, lastIndex);
		} 
		else
		{
			substring = string;
		}
	
		return substring;
	}
	//*******************************  ASSERTIONS  ********************************************

	public  void assertTextEquals(By by, String expected) throws IOException
	{
		String actual = null;
		try {
			actual = getText(by);
			Assert.assertEquals(actual, expected);
			Report.log("Actual- "+actual+" || Expected- "+expected);
			logScreenshot("Assertion Passed");
		} catch (Exception e) {
			logger.error("Failed Reason" + e + by);
			logScreenshot("Assertion Failed");
		}
	}

	public  void assertTextEquals(String actual, String expected) throws IOException
	{
		try {

			Assert.assertEquals(actual, expected);
			logScreenshot("Assertion Passed");
		} catch (Exception e) {
			logger.error("Failed Reason" + e );
			logScreenshot("Assertion Failed");
		}
	}

}
