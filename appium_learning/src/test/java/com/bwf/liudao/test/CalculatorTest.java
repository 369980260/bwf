package com.bwf.liudao.test;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CalculatorTest {
	
	private AndroidDriver<AndroidElement> driver;
	
	@BeforeClass
	public void initDriver() {
		URL url = null;
		try {
			url = new URL("http://localhost:4723/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Nexus_5X_API_25");
/*		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.1.1");*/
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", ".Calculator");
		
		driver = new AndroidDriver<>(url, caps);
	}
	
	@AfterClass
	public void closeDriver() {
		driver.closeApp();
		driver.quit();
	}
	
	@Test
	public void testAdd() {
		
		driver.rotate(ScreenOrientation.LANDSCAPE);

		driver.findElementById("com.android.calculator2:id/digit_7").click();
		driver.findElementById("com.android.calculator2:id/op_add").click();
		driver.findElementById("com.android.calculator2:id/digit_6").click();
		
		driver.findElementById("com.android.calculator2:id/eq").click();
		
		String actual = driver.findElementById("com.android.calculator2:id/result").getText();
		
		String expected = "13";
		
		assertEquals(actual, expected);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	@Test
	public void testSub() {

		driver.findElementById("com.android.calculator2:id/digit_7").click();
		driver.findElementById("com.android.calculator2:id/op_sub").click();
		driver.findElementById("com.android.calculator2:id/digit_6").click();
		
		driver.findElementById("com.android.calculator2:id/eq").click();
		
		String actual = driver.findElementById("com.android.calculator2:id/result").getText();
		
		String expected = "1";
		
		assertEquals(actual, expected);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}
