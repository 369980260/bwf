package com.bwf.ecshop.teststeps;

import org.openqa.selenium.WebDriver;

import com.bwf.ecshop.pages.IndexPage;
import com.bwf.ecshop.pages.UserPage;
import com.bwf.framework.utils.DriverUtils;

import cucumber.api.java.zh_cn.假设;
import cucumber.api.java.zh_cn.并且;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;

public class LoginSteps {
	private WebDriver driver = DriverUtils.getDriver();
	private IndexPage indexPage;
	private UserPage userPage;
	@假设("打开首页")
	public void open_index_page() {
		driver.get("http://localhost/ecshop");
		indexPage = new IndexPage(driver);
	}
	
	@当("点击用户登录链接")
	public void click_login_link() {
		indexPage.click_login_link();
		userPage = new UserPage(driver);
	}
	
	@并且("输入用户名为'(.*?)'")
	public void input_username(String username) {
		userPage.input_username(username);
	}
	@并且("输入密码为'(.*?)'")
	public void input_password(String password) {
		userPage.input_password(password);
	}
	@并且("点击登录按钮")
	public void click_login_btn() {
		userPage.click_submit();
	}
	@那么("登录页面显示'(.*?)'")
	public void assertText(String expectedText) {
		userPage.assert_result_text(expectedText);
	}
}
