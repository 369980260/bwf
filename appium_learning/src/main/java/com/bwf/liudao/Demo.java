package com.bwf.liudao;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Demo {
	public static void main(String[] args) {
		
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
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, caps);
		
		driver.findElementById("com.android.calculator2:id/digit_7").click();
		driver.findElementById("com.android.calculator2:id/op_add").click();
		driver.findElementById("com.android.calculator2:id/digit_6").click();
		
		driver.findElementById("com.android.calculator2:id/eq").click();
		
		String actual = driver.findElementById("com.android.calculator2:id/result").getText();
		
		String expected = "13";
		
		System.out.println(actual.equals(expected)?"pass":"fail");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.closeApp();
		driver.quit();
	}
}
