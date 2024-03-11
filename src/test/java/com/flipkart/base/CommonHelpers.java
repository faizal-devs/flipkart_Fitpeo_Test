package com.flipkart.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonHelpers extends BaseTest {

	private WebDriver driver;

	public CommonHelpers(WebDriver driver) {
		this.driver = driver;
	}

	// These are the common functions I've used So created to reduce redundancy.

	public void clickElement(String ele) {
		driver.findElement(By.xpath(ele)).click();
	}

	public String getText(String ele) {
		return driver.findElement(By.xpath(ele)).getText();
	}

	public void sendKeys(String ele, String value) {
		System.out.println("Send Keys :" + driver);
		WebElement type = driver.findElement(By.xpath(ele));
		type.sendKeys(value);
	}

	public boolean waitForElementToBeVisible(String ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele)));
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public List<WebElement> getListOfElements(String webElement) {
		return driver.findElements(By.xpath(webElement));
	}

	public String switchToNewWindow() throws InterruptedException {
		Thread.sleep(5000);
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			if (!winHandle.equals(winHandleBefore)) {
				driver.switchTo().window(winHandle);
				break;
			}
		}

		return winHandleBefore;
	}

}
