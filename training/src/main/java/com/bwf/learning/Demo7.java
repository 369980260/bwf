package com.bwf.learning;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bwf.utils.DriverUtils;

public class Demo7 {
	
	//关于alert
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("https://www.baidu.com");
			driver.findElement(By.id("kw")).sendKeys("51testing");
			driver.findElement(By.id("kw")).sendKeys(Keys.ENTER);
			String baiduWindow = driver.getWindowHandle();
			driver.findElement(By.partialLinkText("51Testing")).click();
			Thread.sleep(2000);
			Set<String> handles = driver.getWindowHandles();
			System.out.println(handles.size());
			String testingWindow = "";
			for(String handle : handles) {
				if(!handle.equals(baiduWindow)) {
					testingWindow = handle;
					break;
				}
			}
			driver.switchTo().window(testingWindow);
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DriverUtils.stopService();
			
		}
	}
}
