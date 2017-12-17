package com.bwf.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bwf.utils.DriverUtils;

public class Demo3 {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver();
		try {
			driver.get("http://localhost/test/table.html");
			/*int price1, price2;
			price1 = choice(driver, 1);
			price2 = choice(driver, 3);
			System.out.println("总价为："+(price1+price2));*/
/*			WebElement element = driver.findElement(By.xpath("//table/tbody/tr[2]/td[4]/input"));
			System.out.println(element.findElement(By.xpath("../..")).getTagName());*/
			driver.findElement(By.xpath("//table/tbody/tr[last()]/td[4]/input")).click();
			Thread.sleep(2000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DriverUtils.stopService();
			
		}
		
		/*driver.get("http://localhost/test/link.html");
		WebElement link = driver.findElement(By.partialLinkText("吃了吗"));
		System.out.println(link.getText());*/
		
	}
	
	public static int choice(WebDriver driver, int index) {
		int price;
		WebElement check = driver.findElement(By.xpath("//table/tbody/tr["+(1+index)+"]/td[4]/input"));
		check.click();
		price = Integer.parseInt(check.findElement(By.xpath("../../td[3]")).getText());
		return price;
	}
}
