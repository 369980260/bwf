package com.bwf.liudao.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bwf.liudao.Calc;

public class CalcTest {
	
	@BeforeMethod
	public void before() {
		System.out.println("before...");
	}
	@AfterMethod
	public void after() {
		System.out.println("after...");
	}
	
	@Parameters({"x_value","y_value","expected_value"})
	@Test
	public void testCompute1(int x, int y, int expected) {
		Calc ca = new Calc();
//		int x = 10, y = 20;
//		int expected = 30;
		int actual = ca.compute(x, y);
		assertEquals(actual, expected);
	}
	
	@DataProvider(name="testData1")
	public Object[][] getTestComputeData(){
		return new Object[][] {
			{10,20,30},
			{40,10,30},
			{20,20,41}
		};
	}
	
	@Test(dataProvider="testData1")
	public void testCompute2(int x, int y, int expected) {
		System.out.println("testCompute2...x="+x+",y="+y+",expected="+expected);
		Calc ca = new Calc();
		int actual = ca.compute(x, y);
		assertEquals(actual, expected);
	}
}
