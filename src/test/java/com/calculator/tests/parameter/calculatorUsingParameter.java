package com.calculator.tests.parameter;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.calculator.tests.Calculator;

public class calculatorUsingParameter {

	
	@Test (groups= "basic_calculation")
	@Parameters({"addition"})
	public void calcAddition(String data) {
		System.out.println("\nRunning Test -> calcAddition");
		String[] stringArray = data.split(",");
		Calculator obj = new Calculator();
		int result = obj.add(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]));
		Assert.assertEquals(result, Integer.parseInt(stringArray[2]));
		Reporter.log("Actual - "+ result + " Expected - "+Integer.parseInt(stringArray[2]), true);
	}
	
	@Test (groups= "basic_calculation")
	@Parameters({"subraction"})
	public void calcSubraction(String data) {
		System.out.println("\nRunning Test -> calcSubraction");
		String[] stringArray = data.split(",");
		Calculator obj = new Calculator();
		int result = obj.sub(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]));
		Assert.assertEquals(result, Integer.parseInt(stringArray[2]));
		Reporter.log("Actual - "+ result + " Expected - "+Integer.parseInt(stringArray[2]), true);
	}
	
	@Test (groups= "basic_calculation")
	@Parameters({"multiplication"})
	public void calcMultiplication(String data) {
		System.out.println("\nRunning Test -> calcMultiplication");
		String[] stringArray = data.split(",");
		Calculator obj = new Calculator();
		int result = obj.mul(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]));
		Assert.assertEquals(result, Integer.parseInt(stringArray[2]));
		Reporter.log("Actual - "+ result + " Expected - "+Integer.parseInt(stringArray[2]), true);
	
	}
	
	@Test (groups= "basic_calculation")
	@Parameters({"intDivision"})
	public void calcDivInt(String data) {
		System.out.println("\nRunning Test -> calcDivInt");
		String[] stringArray = data.split(",");
		Calculator obj = new Calculator();
		int result = obj.divInt(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]));
		Assert.assertEquals(result, Integer.parseInt(stringArray[2]));
		Reporter.log("Actual - "+ result + " Expected - "+Integer.parseInt(stringArray[2]), true);
	
	}

}
