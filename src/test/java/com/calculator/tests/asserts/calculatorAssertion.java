package com.calculator.tests.asserts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.calculator.tests.Calculator;
import com.calculator.tests.dataProviders.calculatorData;
import com.maveric.core.testng.BaseTest;

public class calculatorAssertion extends BaseTest {
	
	@BeforeClass
	public void classSetUp() {
		System.out.println("Calculator Operations\n");
	
	}
	
	@BeforeMethod
	public void methodSetUp() {
		System.out.println("\nPass New values for Assertions");
	
	}
	
	@Test (dataProvider="additionData", 
			dataProviderClass = calculatorData.class, 
			groups= {"sanity","regression"})
	public void calcAddition(int number1,int number2, int expected_result) {
		System.out.println("\nRunning Test -> calcAddition");
		Calculator obj = new Calculator();
		int result = obj.add(number1, number2);
		Assert.assertEquals(result, expected_result);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result, true);

	}
	
	@Test (dataProvider="subractionData", 
			dataProviderClass = calculatorData.class, 
			groups= {"sanity","regression"})
	public void calcSubraction(int number1,int number2, int expected_result) {
		System.out.println("\nRunning Test -> calcSubraction");
		Calculator obj = new Calculator();
		int result = obj.sub(number1, number2);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result, true);
	}
	
	@Test (dataProvider="multiplyData", 
			dataProviderClass = calculatorData.class, 
			groups= {"sanity","regression"})
	public void calcMultiplication(int number1,int number2, int expected_result) {
		System.out.println("\nRunning Test -> calcMultiplication");
		Calculator obj = new Calculator();
		int result = obj.mul(number1, number2);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result, true);
	
	}
	
	@Test (dataProvider="divIntData", 
			dataProviderClass = calculatorData.class, 
			groups= {"sanity","regression"})
	public void calcDivInt(int number1,int number2, int expected_result) {
		System.out.println("\nRunning Test -> calcDivInt");
		Calculator obj = new Calculator();
		int result = obj.divInt(number1, number2);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result, true);
	
	}
	
	@Test (dataProvider="divRealData", 
			dataProviderClass = calculatorData.class, 
			groups= {"regression"})
	public void calcDivReal(int number1,int number2, double expected_result) {
		System.out.println("\nRunning Test -> calcDivReal");
		Calculator obj = new Calculator();
		double result = obj.divReal(number1, number2);
		Assert.assertFalse(result == expected_result, "False | Output success");
		Reporter.log("Actual - "+ result + " Expected - "+expected_result, true);
	
	}
	
	@Test (dataProvider="exponentData", 
			dataProviderClass = calculatorData.class, 
			groups= {"regression"})
	public void calcExponent(double number1,double number2, double expected_result) {
		System.out.println("\nRunning Test -> calcExponent");
		Calculator obj = new Calculator();
		double result = obj.exp(number1, number2);
		Assert.assertTrue(result == expected_result, "True | Output success");
		Reporter.log("Actual - "+ result + " Expected - "+expected_result, true);
		
	}
	
	@Test (dataProvider="modulusData", 
			dataProviderClass = calculatorData.class, 
			groups= {"regression"})
	public void calcModulus(int number1,int number2, int expected_result) {
		System.out.println("\nRunning Test -> calcModulus");
		Calculator obj = new Calculator();
		int result = obj.mod(number1, number2);
		Assert.assertEquals(result, expected_result);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result, true);
	
	}
	
	@Test (dataProvider="inverseData", 
			dataProviderClass = calculatorData.class,
			groups= {"basic_calculation","intermittent_calculation"})
	public void calcInverse(int number1, double expected_result) {
		System.out.println("\nRunning Test -> calcInverse");
		Calculator obj = new Calculator();
		double result = obj.inverse(number1);
		Assert.assertNotEquals(result,expected_result);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result, true);
	
	}
	
	@Test (dataProvider="negateData", 
			dataProviderClass = calculatorData.class, 
			groups= {"basic_calculation","intermittent_calculation"})
	public void calcNegate(int number1, int expected_result) {
		System.out.println("\nRunning Test -> calcNegate");
		Calculator obj = new Calculator();
		int result = obj.negate(number1);
		Assert.assertEquals(result, expected_result);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result, true);
	
	}
	
	
	@AfterMethod
	public void afterMethodSetUp() {
		System.out.println("Check your Results");
	
	}
	
	@AfterClass
	public void afterClassSetUp() {
		System.out.println("All done || Thanks .. ");
	
	}
}
