package com.flipkart.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	public WebDriver driver;

	// This is our kind of hooks file that will create instance of the webdriver and
	// decide browser as per param given in testng.xml

	@Parameters("browser")
	@BeforeClass
	public void beforeMethod(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterMethod() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
