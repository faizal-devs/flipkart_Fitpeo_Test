package com.flipkart.base;

import org.openqa.selenium.WebDriver;

public class BasePage extends BaseTest {

	WebDriver driver;
	CommonHelpers helper;
	BaseLocators locate;

	// This file I've created for our base methods that we can use around all
	// framework

	public BasePage(WebDriver driver) {
		this.driver = driver;
		locate = new BaseLocators();
		helper = new CommonHelpers(driver);
	}

	// It a demo function that can be use further once we'll do login
	public String flipkartLogin(String userName, String password) {
		helper.sendKeys(BaseLocators.emailTextField, userName);
		helper.sendKeys(BaseLocators.passwordTextField, password);
		helper.clickElement(BaseLocators.loginButton);
		return helper.getText(BaseLocators.headerNew);
	}

}
