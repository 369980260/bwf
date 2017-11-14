package com.bwf.youdao_note.test;

import org.testng.annotations.Test;

import com.bwf.youdao_note.pages.MainActivity;

public class WrappedDriverTest extends BaseTest {
	@Test
	public void test1() {
		MainActivity mainActivity = new MainActivity(driver);
		mainActivity.clickAddNoteButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
