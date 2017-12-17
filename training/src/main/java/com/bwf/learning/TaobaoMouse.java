package com.bwf.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

import com.bwf.utils.DriverUtils;

public class TaobaoMouse {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("https://www.taobao.com/");
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.id("J_SiteNavSeller")))
				.pause(Duration.ofSeconds(2L))
				.moveToElement(driver.findElement(By.id("J_SiteNavService")))
				.pause(Duration.ofSeconds(2L))
				.moveToElement(driver.findElement(By.id("J_SiteNavSitemap")))
				.perform();
			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			driver.quit();
			e.printStackTrace();
		} finally {
			DriverUtils.stopService();
			
		}
	}
	
}
