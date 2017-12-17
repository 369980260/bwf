package com.bwf.learning;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Demo1 {
	public static void main(String[] args) {
		/*System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "E:\\tools\\seleniumForStudents\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();*/
		GeckoDriverService service = new GeckoDriverService.Builder()
				.usingFirefoxBinary(new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")))
				.usingAnyFreePort()
				.usingDriverExecutable(new File("E:\\tools\\seleniumForStudents\\geckodriver.exe"))
				.build();
		try {
			service.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WebDriver driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.firefox());
		driver.get("https://www.baidu.com");
		driver.close();
		driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.firefox());
		driver.get("http://bbs.51testing.com");
		driver.close();
		
		service.stop();
		
		/*GeckoDriverService service = new GeckoDriverService.Builder()
				.usingFirefoxBinary(new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")))
				.usingAnyFreePort()
				.usingDriverExecutable(new File("E:\\tools\\seleniumForStudents\\geckodriver.exe"))
				.build();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setProfile(new FirefoxProfile(new File("E:\\temp")));
		WebDriver driver = new FirefoxDriver(service,firefoxOptions);
		driver.get("https://www.baidu.com");*/
	}
}
