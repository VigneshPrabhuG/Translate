package com.Translate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	public static WebDriver driver;
	public static WebDriver browserLaunch(String value) {
		
		if (value.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
		else if(value.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
		return driver;
	}
	public static WebDriver getUrl(String url) {
		driver.get(url);
		
		return driver;
	}
	public static void navigateToUrl(String url) {
		driver.navigate().to(url);
	}
	
	public static WebDriver clickOnElement(WebElement element) {
		element.click();
		return driver;
	}
	
	public static WebDriver clearText(WebElement element) {
		element.clear();
		return driver;
	}
	
	public static WebDriver inputValueElement(WebElement element,String values) {
		element.sendKeys(values);
		return driver;
	}
}
