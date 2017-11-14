package com.bwf.youdao_note.test;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.bwf.youdao_note.pages.MainActivity;
import com.bwf.youdao_note.pages.NoteEditActivity;

public class NewNoteTest extends BaseTest {
	
	@Test(dataProviderClass=com.bwf.liudao.utils.YoudaoNoteTestData.class,dataProvider="addNewNoteData")
	public void addNewNoteTest(String title, String content, String toastMsg) {
		MainActivity mainActivity = new MainActivity(driver);
		mainActivity.clickAddNoteButton();
		mainActivity.clickAddNewNoteButton();
		NoteEditActivity noteEditActivity = new NoteEditActivity(driver);
		noteEditActivity.editNote(title, content);
		noteEditActivity.clickFinishButton();
		try {
			driver.findElementByXPath("//*[@text='"+toastMsg+"']");
			
		}catch(Exception e) {
			e.printStackTrace();
			fail("未找到toast提示——"+toastMsg);
		}
	}
	
	
//	@Test(description="添加一份新日志，有标题，但是无内容")
//	public void addNewNoteWithTitleNoContent() {
//		driver.findElementById("com.youdao.note:id/add_note").click();
//		driver.findElementById("com.youdao.note:id/add_note_floater_add_note").click();
//		driver.findElementById("com.youdao.note:id/note_title").sendKeys("test demo1");
//		driver.context("WEBVIEW_com.youdao.note");
//		driver.findElementByXPath("//textarea").sendKeys("");
//		driver.context("NATIVE_APP");
//		driver.findElementById("com.youdao.note:id/actionbar_complete_text").click();
//		try {
//			driver.findElementByXPath("//*[@text='保存成功']");
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			fail("未找到toast提示——保存成功");
//		}
//	}
//	
//	@Test(description="添加一份新日志，有标题，且有内容")
//	public void addNewNoteWithTitleAndContent() {
//		driver.findElementById("com.youdao.note:id/add_note").click();
//		driver.findElementById("com.youdao.note:id/add_note_floater_add_note").click();
//		driver.findElementById("com.youdao.note:id/note_title").sendKeys("test demo2");
//		driver.context("WEBVIEW_com.youdao.note");
//		driver.findElementByXPath("//textarea").sendKeys("这是一次用例的演示");
//		driver.context("NATIVE_APP");
//		driver.findElementById("com.youdao.note:id/actionbar_complete_text").click();
//		try {
//			driver.findElementByXPath("//*[@text='保存成功']");
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			fail("未找到toast提示——保存成功");
//		}
//	}
	
}
