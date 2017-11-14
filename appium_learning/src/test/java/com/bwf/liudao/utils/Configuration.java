package com.bwf.liudao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	private Properties prop = new Properties();
	public Configuration(String configFile) {
		InputStream is = Configuration.class.getClassLoader().getResourceAsStream(configFile);
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getConfig(String key) {
		String value = prop.getProperty(key);
		return value;
	}
}
