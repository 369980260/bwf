package com.bwf.learning;

public class RunProxyDemo {
	public static void main(String[] args) {
		ITestAnno ta = TestAnnoFactory.build();
		ta.sayHi();
	}
}
