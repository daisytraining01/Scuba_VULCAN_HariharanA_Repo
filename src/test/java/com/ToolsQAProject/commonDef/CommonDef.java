package com.ToolsQAProject.commonDef;

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

public class CommonDef extends TestBase{


	public static WebDriver getCurrentDriver()
	{
		return DriverFactory.getInstance().getDriver();
	}

	public static void  launchURL(String URL)
	{
		DriverFactory.getInstance().getDriver().get(URL);
		testReporter.log(LogStatus.INFO, "URL Launched - "+URL);

	}

	public static void implicitWait()
	{
		getCurrentDriver().manage().timeouts().implicitlyWait(ConfigProperties.WAIT_TIMEOUT.getInt(), TimeUnit.SECONDS);    		    	
	}

	public static void waitnow()
	{
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void maxmizeBrowser()
	{
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		implicitWait();
	}

	public static void closeBrowser()
	{
		getCurrentDriver().close();	    	
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

	public static void logPassAndTakeScreenShot( String screenshotname,String Message, By by) throws IOException {
		testReporter.log(LogStatus.PASS, Message+ "- "+by+ testReporter.addScreenCapture(getScreenShot(screenshotname)));

	}

	public static void logFailAndTakeScreenShot(String screenshotname,String Message, By by) throws IOException {
		testReporter.log(LogStatus.FAIL, Message+ "- "+by+ testReporter.addScreenCapture(getScreenShot(screenshotname)));
	}



	public static void waitVisible(By by) throws IOException {
		try {

			WebDriverWait wait = new WebDriverWait(getCurrentDriver(), (ConfigProperties.WAIT_TIMEOUT.getInt()));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			testReporter.log(LogStatus.PASS, "Element Found "+ "- "+by);
		} catch (Exception e) {
			logFailAndTakeScreenShot("WebElementNotFound","WebElementNotFound",by);
		}
	}

	public static WebElement findElement(By by, ExtentTest testReporter)  throws IOException {
		try {		

			logPassAndTakeScreenShot("WebElementFound","WebElementFound", by);
			return getCurrentDriver().findElement(by);

		} catch (Exception e) {
			logFailAndTakeScreenShot("WebElementNotFound","WebElementNotFound",by);
			return null;
		}
	}

	public static WebElement findElement(By by)  throws IOException {
		try {		

			return getCurrentDriver().findElement(by);

		} catch (Exception e) {
			return null;
		}
	}

	public static void click(By by) throws IOException {
		try {

			waitVisible(by);
			WebElement element = getCurrentDriver().findElement(by);
			element.click();
			testReporter.log(LogStatus.PASS, "Element CLicked "+ "- "+by);
		} catch (Exception e) {
			logFailAndTakeScreenShot("WebElementNotClicked","WebElementNotClicked",by);

		}
	}


	public static String getText(By by) throws IOException {
		String text = null;
		try {

			text = getCurrentDriver().findElement(by).getText();
		} catch (Exception e) {
			logFailAndTakeScreenShot("LocatorNotFound","LocatorNotFound",by);
		}

		return text;
	}


	public static String getAlertText() throws IOException {
		String text = null;
		try {

			text = getCurrentDriver().switchTo().alert().getText();
		} catch (Exception e) {
			testReporter.log(LogStatus.FAIL, "Alert Not Found");
		}

		return text;
	}

	public static void alertDismiss() throws IOException {
		try {

			implicitWait();
			getCurrentDriver().switchTo().alert().dismiss();
		} catch (Exception e) {
			testReporter.log(LogStatus.FAIL, "Alert Not Found");
		}

	}

	public static String[] splitMethod(By by,String Symbol) throws IOException {
		String text = null;
		String[] array = null;

		try {

			text = getCurrentDriver().findElement(by).getText();
			array = text.split(Symbol);
		} catch (Exception e) {
			logFailAndTakeScreenShot("LocatorNotFound","LocatorNotFound",by);
		}

		return array;
	}


	public static void scrollJS(By by) throws IOException {
		try {

			WebElement element = getCurrentDriver().findElement(by);
			((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500);
		} catch (Exception e) {
			logFailAndTakeScreenShot("UnableToScroll","UnableToScroll",by);
		}

	}

	public static void sendKeys(By by, String keysToSend) throws IOException {
		try {

			click(by);
			getCurrentDriver().findElement(by).sendKeys(keysToSend);
			logPassAndTakeScreenShot("SendValueSuccess","SendValueSuccess",by);
		} catch (Exception E) {
			logFailAndTakeScreenShot("SendValueFailed","SendValueFailed",by);
		}
	}
	
	public static void sendKeys(By by, Object keysToSend) throws IOException {
		try {

			click(by);
			getCurrentDriver().findElement(by).sendKeys(keysToSend.toString());
			logPassAndTakeScreenShot("SendValueSuccess","SendValueSuccess",by);
		} catch (Exception E) {
			logFailAndTakeScreenShot("SendValueFailed","SendValueFailed",by);
		}
	}

	public static void uploadPic(By by, String keysToSend) throws IOException {
		try {

			getCurrentDriver().findElement(by).sendKeys(keysToSend);
		} catch (Exception E) {
		}
	}

	public static void sendKeyswithEnter(By by, String keysToSend) throws IOException {
		try {

			Actions action = new Actions(getCurrentDriver());
			getCurrentDriver().findElement(by).sendKeys(keysToSend);
			action.sendKeys(Keys.ENTER).build().perform();
			logPassAndTakeScreenShot("SendValueSuccess","SendValueSuccess",by);
		} catch (Exception E) {
			logFailAndTakeScreenShot("SendValueFailed","SendValueFailed",by);
		}
	}

	public static void sendKeyswithTab(By by, String keysToSend) throws IOException {
		try {

			click(by);
			getCurrentDriver().findElement(by).sendKeys(keysToSend);
			getCurrentDriver().findElement(by).sendKeys(Keys.TAB);
			logPassAndTakeScreenShot("SendValueSuccess","SendValueSuccess",by);
		} catch (Exception E) {
			logFailAndTakeScreenShot("SendValueFailed","SendValueFailed",by);
		}
	}

	public static void clearText(By elem) {

		getCurrentDriver().findElement(elem).clear();
	}


	public static void clickJS(By by) throws IOException {
		try {

			JavascriptExecutor executor = (JavascriptExecutor) getCurrentDriver();
			executor.executeScript("arguments[0].click();",  getCurrentDriver().findElement(by));
			testReporter.log(LogStatus.PASS, "Element CLicked "+ "- "+by);
		} catch (Exception E) {
			logFailAndTakeScreenShot("WebElementNotClicked","WebElementNotClicked",by);
		}
	}

	public static void doubleclick(By by) throws IOException {
		try {

			Actions actions = new Actions(getCurrentDriver());
			WebElement elementLocator = getCurrentDriver().findElement(by);
			actions.doubleClick(elementLocator).perform();
			testReporter.log(LogStatus.PASS, "Element CLicked "+ "- "+by);
		} catch (Exception e) {
			logFailAndTakeScreenShot("WebElementNotClicked","WebElementNotClicked",by);

		}
	}

	public static void rightclick(By by) throws IOException {
		try {

			Actions actions = new Actions(getCurrentDriver());
			WebElement elementLocator = getCurrentDriver().findElement(by);
			actions.contextClick(elementLocator).perform();
			testReporter.log(LogStatus.PASS, "Element CLicked "+ "- "+by);
		} catch (Exception e) {
			logFailAndTakeScreenShot("WebElementNotClicked","WebElementNotClicked",by);

		}
	}

	public static void reloadPage(ExtentTest testReporter) {
		try {

			getCurrentDriver().navigate().refresh();
			waitForPageLoad(testReporter);
		} catch (Exception e) {
		}
	}

	public static void waitForPageLoad(ExtentTest testReporter) {

		ExpectedCondition<Boolean> expect = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(getCurrentDriver(),120);
		try {
			wait.until(expect);
		} catch (Exception E) {
			testReporter.log(LogStatus.INFO, "Page Load Condition failed. Continuing with test");
		}
	}

	public static String capitalize(String str) {
		if(str == null || str.isEmpty()) {
			return str;
		}

		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static synchronized void datepicker(By by,String date, String Month,String Year) throws IOException
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


	public static String getScreenShot(String screenshotName) throws IOException{

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
	//*******************************  ASSERTIONS  ********************************************

	public static void assertTextEquals(By by, String expected) throws IOException
	{
		String actual = null;
		try {
			actual = getText(by);
			Assert.assertEquals(actual, expected);
			testReporter.log(LogStatus.PASS,"Actual- "+actual+" || Expected- "+expected);
		} catch (Exception E) {
			testReporter.log(LogStatus.FAIL,"Assertion Failed - Actual ->"+actual+ "|| Expected ->"+expected);
		}
	}

	public static void assertTextEquals(String actual, String expected) throws IOException
	{
		try {

			Assert.assertEquals(actual, expected);
			testReporter.log(LogStatus.PASS,"Actual- "+actual+" || Expected- "+expected);
		} catch (Exception E) {
			testReporter.log(LogStatus.FAIL,"Assertion Failed - Actual ->"+actual+ "|| Expected ->"+expected);
		}
	}

}
