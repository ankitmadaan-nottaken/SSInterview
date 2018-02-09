package com.ss.gui.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ss.gui.framework.SeleniumDriver;

public class DynamicContentPage extends ShapeSecurityBaseModule{
	// Ideally I would keep the xpaths in an xml file in resources, but to make it quicler I am creating them as variables here
	
	String xpathImgs = "//div[@id='content']//img";
	String xpathText = "//div[@id='content']/div[num]/div[2]";
	String punisherImgXpath = "//div[@id='content']//img[contains(@src, 'Avatar-3')]";
	String imgXPath = "//div[@id='content']//img";
	HashMap<String, String> hMap = new HashMap<String, String>();
	
	public DynamicContentPage(WebDriver driver) {
		super(driver);
		hMap.put("Avatar-1", "Mario");
		hMap.put("Avatar-2", "Punisher");
		hMap.put("Avatar-3", "Punisher");
		hMap.put("Avatar-4", "Punisher");
		hMap.put("Avatar-5", "WeiredGuy");
		hMap.put("Avatar-6", "StartTrek");
		hMap.put("Avatar-7", "Clown");
	}


	public boolean  isTenCharacterWordExits() {
		for (int i =1; i<=3; i++) {
			String xPath = xpathText.replace("num", ""+i);
			System.out.println("Xpath is "+xPath);
			WebElement elem = getElement(xPath);
			String text = elem.getText();
			String[] textArr = text.split(" ");
			for (String x : textArr) {
				if (x.length() >= 10)
					return true;
			}		
		}
		return false;
	}
	
	public boolean isPunisherExists() {
		return isElementExists(punisherImgXpath);
	}
	
	public List<String> getAvatar() {
		List<WebElement> imageList = getElements(imgXPath);
		List<String> avatarNameList = new ArrayList<String>();
		for (WebElement e: imageList) {
			String src = e.getAttribute("src");
			String[] srcArray = src.split("/");
			String[] avatarNameArr = srcArray[srcArray.length -1].split("-");
			avatarNameList.add(hMap.get(avatarNameArr[4]+"-"+avatarNameArr[5].substring(0, 1)));
		}
		return avatarNameList;
	}
	
	public String printLongestWord() {
		String longestWord = "";
		for (int i=1; i<=3; i++) {
			WebElement elem = driver.findElement(By.xpath(xpathText.replace("num", ""+i)));
			String text = elem.getText();
			String[] textArr = text.split(" ");
			for (String x : textArr) {
				if (x.length() > longestWord.length())
					longestWord = x;
			}
		}
		return longestWord;
	}
	
	
	
	
}
