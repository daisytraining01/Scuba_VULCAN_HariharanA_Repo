package com.calculator.tests.dataProviders;

import org.testng.annotations.DataProvider;

public class calculatorData {
	
	@DataProvider(name="additionData")
	public Object[][] getAdditionData() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{1, 2, 3},
			{3, 4, 7},
			{5, 6, 11}
		};
	}
	
	@DataProvider(name="subractionData")
	public Object[][] getSubractionData() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{1, 2, -1},
			{3, 2, 1},
			{6, 6, 0}
		};
	}
	
	@DataProvider(name="multiplyData")
	public Object[][] getMultiplyData() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{1, 2, 2},
			{3, 2, 6},
			{6, 6, 36}
		};
	}
	
	@DataProvider(name="divIntData")
	public Object[][] getcalcDivInt() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{4, 2, 2},
			{3, 3, 1},
			{15, 5, 3}
		};
	}
	
	@DataProvider(name="divRealData")
	public Object[][] getcalcDivReal() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{4, 2, 22.0},
			{3, 3, 221.0},
			{15, 5, 23.0}
		};
	}
	
	@DataProvider(name="exponentData")
	public Object[][] getcalcExponent() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{4, 2, 16},
			{3, 3, 27},
			{5, 2, 25}
		};
	}
	
	@DataProvider(name="modulusData")
	public Object[][] getcalcModulus() {
		return new Object[][] {
			//{number1 , number2 , Result}
			{4, 2, 0},
			{3, 3, 0},
			{10, 2, 0}
		};
	}
	
	@DataProvider(name="inverseData")
	public Object[][] getcalcInverse() {
		return new Object[][] {
			//{number1 , Result}
			{4, 32},
			{3, 33},
			{5, 32}
		};
	}
	
	@DataProvider(name="negateData")
	public Object[][] getcalcNegate() {
		return new Object[][] {
			//{number1 , Result}
			{4, -4},
			{3, -3},
			{5, -5}
		};
	}

}
