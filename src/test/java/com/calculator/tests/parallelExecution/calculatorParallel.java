package com.calculator.tests.parallelExecution;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.calculator.tests.Calculator;
import com.calculator.tests.dataProviders.calculatorData;
import com.maveric.core.testng.BaseTest;

public class calculatorParallel extends BaseTest {
	
	@Test (dataProvider="additionData", 
			dataProviderClass = calculatorData.class, 
			groups= {"basic_calculation","intermittent_calculation"})
	public void calcAddition(int number1,int number2, int expected_result) {
		System.out.println("\nRunning Test -> calcAddition");
		Calculator obj = new Calculator();
		int result = obj.add(number1, number2);
		Assert.assertEquals(result, expected_result);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result, true);

	}
	
	@Test (dataProvider="subractionData", 
			dataProviderClass = calculatorData.class, 
			groups= {"basic_calculation","intermittent_calculation"})
	public void calcSubraction(int number1,int number2, int expected_result) {
		System.out.println("\nRunning Test -> calcSubraction");
		Calculator obj = new Calculator();
		int result = obj.sub(number1, number2);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result, true);
	}
	
	@Test (dataProvider="multiplyData", 
			dataProviderClass = calculatorData.class, 
			groups= {"basic_calculation","intermittent_calculation"})
	public void calcMultiplication(int number1,int number2, int expected_result) {
		System.out.println("\nRunning Test -> calcMultiplication");
		Calculator obj = new Calculator();
		int result = obj.mul(number1, number2);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result, true);
	
	}
	
	@Test (dataProvider="divIntData", 
			dataProviderClass = calculatorData.class, 
			groups= {"basic_calculation","intermittent_calculation"})
	public void calcDivInt(int number1,int number2, int expected_result) {
		System.out.println("\nRunning Test -> calcDivInt");
		Calculator obj = new Calculator();
		int result = obj.divInt(number1, number2);
		Reporter.log("Actual - "+ result + " Expected - "+expected_result, true);
	
	}

}
