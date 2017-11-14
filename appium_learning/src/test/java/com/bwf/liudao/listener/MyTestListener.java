package com.bwf.liudao.listener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MyTestListener extends TestListenerAdapter {
	
	private AndroidDriver<AndroidElement> driver;
	@SuppressWarnings("unchecked")
	@Override
	public void onTestFailure(ITestResult tr) {
//		Reporter.log("监控到有测试方法执行失败，方法名称为:"
//				+tr.getName()
//				+"，该方法在"+tr.getTestClass().getName()+"类中");
		String directory = "screenshot";
		String filename = tr.getTestClass().getName()+"."+tr.getMethod().getMethodName()
				+"_"+new SimpleDateFormat("yyyy-MM-dd.HHmmss.SSS").format(new Date())
				+".png";
		try {
			driver = (AndroidDriver<AndroidElement>)tr.getTestClass()
					.getRealClass().getField("driver").get(tr.getInstance());
			File file = driver.getScreenshotAs(OutputType.FILE);
			File dir = new File(directory);
			if(!dir.exists()) {
				dir.mkdir();
			}
			File png = new File(dir,filename);
			file.renameTo(png);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
