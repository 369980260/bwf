package com.bwf.liudao.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	
	private static int MAX_TRY = 2;
	private int retryCount = 1;
	@Override
	public boolean retry(ITestResult result) {
		if(retryCount <= MAX_TRY) {
			
			System.out.println("---->>"+result.getName()+"方法正要被重运行！");
			retryCount ++;
			return true;
		}
		return false;
	}

}
