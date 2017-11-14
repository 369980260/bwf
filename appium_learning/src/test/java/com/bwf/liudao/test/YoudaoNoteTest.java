package com.bwf.liudao.test;

import static org.testng.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class YoudaoNoteTest {
	
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
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5X_API_25");
		caps.setCapability(MobileCapabilityType.APP, "D:\\workspace\\appium_learning\\app\\youdaonote_android_6.0.0_youdaoweb.apk");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.youdao.note");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".activity2.SplashActivity");
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "G:\\Course\\appium\\chromedriver2.27\\chromedriver.exe");
		
		driver = new AndroidDriver<>(url, caps);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void closeDriver() {
		driver.closeApp();
		driver.quit();
	}
	
	@Test
	public void testOpen() {
		System.out.println(driver.getOrientation());
		Dimension dim = driver.manage().window().getSize();
		System.out.println(dim.width+", "+dim.height);
		/*File file = driver.getScreenshotAs(OutputType.FILE);
		file.renameTo(new File("d:\\youdao.png"));*/
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_POWER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_POWER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddNote() {
		driver.findElementById("com.youdao.note:id/add_note").click();
//		List<AndroidElement> imageViews = driver.findElementsByClassName("android.widget.ImageView");
//		System.out.println(imageViews.size());
//		imageViews.get(1).click();
//		driver.findElementByName("文件夹").click();
//		driver.findElementByAccessibilityId("云文档").click();
		driver.findElementById("com.youdao.note:id/add_note_floater_add_note").click();
//		driver.findElementById("com.youdao.note:id/btn_cancel").click();
		driver.findElementById("com.youdao.note:id/note_title").sendKeys("test demo1");
		driver.findElementByClassName("android.webkit.WebView").sendKeys("testtestesttest"); // 等webView介绍后就可以处理
		driver.findElementById("com.youdao.note:id/actionbar_complete_text").click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void testTouchAction() {
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_POWER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_POWER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		driver.performTouchAction(new TouchAction(driver)
				.press(driver.findElementById("com.android.systemui:id/keyguard_indication_text")).waitAction()
				.moveTo(driver.findElementById("com.android.systemui:id/clock_view"))
				.release()
		);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		Dimension dim = driver.manage().window().getSize();
		Point startPoint = new Point(dim.width/4, dim.height/2);
		int stepX = dim.width/4;
		int stepY = dim.width/4+20;
		driver.performTouchAction(new TouchAction(driver)
				.press(startPoint.x, startPoint.y)
				.moveTo(stepX, 0)
				.moveTo(0, stepY)
				.release()
		);
	}
	
	
	@Test
	public void xpathTest() {
		//driver.findElementByXPath("//android.view.ViewGroup[contains(@resource-id,'toolbar')]/android.widget.ImageButton").click();
//		AndroidElement element = driver.findElementByXPath(
//				"//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[last()]"
//				+ "/android.widget.LinearLayout/android.widget.TextView");
		AndroidElement element = driver.findElementByAndroidUIAutomator("new UiSelector().textStartsWith(\"欢迎进入\")");
		System.out.println(element.getText());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void editTest() {
		driver.findElementByAndroidUIAutomator("new UiSelector().textStartsWith(\"test demo1\")").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		//System.out.println(driver.getPageSource());
		driver.findElementById("com.youdao.note:id/edit").click();
//		driver.findElementByAccessibilityId("Navigate up").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		//System.out.println(driver.getContextHandles()); //[NATIVE_APP, WEBVIEW_com.youdao.note]
		driver.context("WEBVIEW_com.youdao.note");
		driver.findElementByXPath("//textarea").sendKeys("哈哈哈");
		driver.context("NATIVE_APP");
		driver.findElementById("com.youdao.note:id/actionbar_complete_text").click();
		try {
			driver.findElementByXPath("//*[@text='保存成功']");
			
		}catch(Exception e) {
			e.printStackTrace();
			fail("未找到toast提示——保存成功");
		}

	}
	
	
}
