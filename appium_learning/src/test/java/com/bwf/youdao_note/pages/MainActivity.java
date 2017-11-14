package com.bwf.youdao_note.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static org.testng.Assert.fail;
import static org.testng.asserts.Assertion.*;

public class MainActivity {
	
	private AndroidDriver<AndroidElement> driver;
	
	private Logger logger = LogManager.getLogger();
	
	@AndroidFindBy(id="com.youdao.note:id/add_note")
	private AndroidElement add_note_btn;
	
	@AndroidFindBy(id="com.youdao.note:id/add_note_floater_add_note")
	private AndroidElement add_new_note_btn;
	
	@AndroidFindBy(xpath="//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout")
	private List<AndroidElement> note_links;
	
	public MainActivity(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickAddNoteButton() {
		add_note_btn.click();
	}
	public void clickAddNewNoteButton() {
		add_new_note_btn.click();
	}
	public void deleteNoteByIndex(int index) {
		if(index >= note_links.size()) {
			logger.error("超出笔记数量范围！");
			fail("超出笔记数量范围！");
		}else {
			driver.performTouchAction(new TouchAction(driver).longPress(note_links.get(index)));
			driver.findElementByXPath("//android.widget.TextView[@text='删除']").click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.findElementById("com.youdao.note:id/btn_ok").click();
		}
	}
}
