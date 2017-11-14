package com.bwf.youdao_note.test;

import org.testng.annotations.Test;

import com.bwf.youdao_note.pages.MainActivity;

public class DeleteNoteTest extends BaseTest {
	@Test
	public void deleteTest() {
		MainActivity mainActivity = new MainActivity(driver);
		mainActivity.deleteNoteByIndex(10);
	}
	
}
