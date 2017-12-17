package com.bwf.learning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bwf.utils.DriverUtils;

public class Demo4 {
	public static void main(String[] args) {
		//javascript & jquery
		WebDriver driver = DriverUtils.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("http://localhost/test/table.html");
			System.out.println(driver.getWindowHandle());
			/*JavascriptExecutor jse = (JavascriptExecutor)driver;
			Thread.sleep(4000);
			List<WebElement> list = (List<WebElement>) jse.executeScript("return document.getElementsByTagName('tr');");
			System.out.println(list);*/
			
			driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]/label")).click();
			driver.switchTo().activeElement().sendKeys("25");
//			driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]/input")).sendKeys("25");
			driver.findElement(By.xpath("//table/tbody/tr[3]/td[3]")).click();
//			((JavascriptExecutor)driver).executeScript("document.getElementById('price').innerText=1234");
			Thread.sleep(2000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DriverUtils.stopService();
			
		}
	}
}
