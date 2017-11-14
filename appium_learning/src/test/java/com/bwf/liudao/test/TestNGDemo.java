package com.bwf.liudao.test;

import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("invoke beforeClass....");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("invoke afterClass....");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("invoke beforeMethod....");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("invoke afterMethod....");
	}
	
	@Test(groups= {"g1","mg"})
	public void test1() {
		assertEquals(1, 2);
		System.out.println("invoke test1....");
	}
	@Test(groups= {"g2","mg"})
	public void test2() {
		System.out.println("invoke test2....");
		assertEquals(1, 1);
	}
	@Test(groups= {"mg"})
	public void test3() {
		System.out.println("invoke test3....");
		assertEquals(1, 1);
	}
	
	@Test(enabled = false)
	public void test4() {
		System.out.println("invoke test4....");
		assertEquals(1, 1);
	}
	
	@Test(invocationCount=4)
	public void test5() {
		System.out.println("invoke test5....");
		assertEquals(1, 1);
	}
}
