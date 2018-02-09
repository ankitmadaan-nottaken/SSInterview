package com.ss.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ShapeSecurityTestSuite {
	WebDriver driver;
	protected DynamicContentPage dynamic;
	
	@BeforeClass (alwaysRun = true)
	public void setUp() throws Exception{
		driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_content");
		dynamic       	= PageFactory.initElements(driver, DynamicContentPage.class);
	}
	
	@AfterClass
	public void cleanUp() {
		try {
			if (driver != null) 
				driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
