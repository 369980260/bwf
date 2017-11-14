package com.bwf.youdao_note.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.bwf.liudao.utils.Configuration;
import com.bwf.liudao.utils.WrappedAndroidDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	public WrappedAndroidDriver<AndroidElement> driver;
	@BeforeClass
	public void initDriver() {
		
		Configuration config = new Configuration("youdaonote_config.properties");
		
		URL url = null;
		try {
			url = new URL(config.getConfig("url"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, config.getConfig("deviceName"));
		caps.setCapability(MobileCapabilityType.APP, config.getConfig("app"));
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, config.getConfig("appPackage"));
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, config.getConfig("appActivity"));
		caps.setCapability(MobileCapabilityType.NO_RESET, Boolean.parseBoolean(config.getConfig("noReset")));
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, config.getConfig("automationName"));
		caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, config.getConfig("chromeDriver"));
		caps.setCapability(AndroidMobileCapabilityType.RECREATE_CHROME_DRIVER_SESSIONS, true);
		
		driver = new WrappedAndroidDriver<>(url, caps);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void closeDriver() {
		driver.closeApp();
		driver.quit();
	}
}
