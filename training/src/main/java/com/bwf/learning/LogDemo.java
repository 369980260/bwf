package com.bwf.learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogDemo {
	private static final Logger logger = LogManager.getLogger("LogDemo");
	public static void main(String[] args) {
		logger.warn("hello world");
	}
}
