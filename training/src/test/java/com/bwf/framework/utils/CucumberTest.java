package com.bwf.framework.utils;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features= {"target/test-classes"},
		glue= {"com.bwf.ecshop.teststeps"},
		monochrome=true
)
public class CucumberTest extends AbstractTestNGCucumberTests {

}
