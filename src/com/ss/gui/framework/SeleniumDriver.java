package com.ss.gui.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class SeleniumDriver {
	protected WebDriver   driver;
	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param driver
	 */
	public SeleniumDriver(WebDriver driver) {
		this.driver =	driver;
	}
	public WebElement getElement(String locator){
		WebElement e = null;
		e = driver.findElement(By.xpath(locator));	
		return e;
	}
	
	public List<WebElement> getElements(String locator) {
		return driver.findElements(By.xpath(locator));
	}
	
	public boolean isElementExists(String locator) {
		if(driver.findElements(By.xpath(locator)).size() != 0)
			return true;
		else
			return false;
	}
}
