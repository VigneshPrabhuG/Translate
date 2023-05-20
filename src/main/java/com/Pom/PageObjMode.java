package com.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjMode {
	public static WebDriver driver;
	
	@FindBy (xpath = "(//span[@class=\"VfPpkd-YVzG2b\"])[6]")
	private WebElement spanish;
	
	@FindBy (xpath = "//textarea[@aria-label=\"Source text\"]")
	private WebElement input;
	
	@FindBy (xpath = "//div[@class=\"KkbLmb\"]" )
	private WebElement value;

	public PageObjMode(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getSpanish() {
		return spanish;
	}

	public WebElement getInput() {
		return input;
	}

	public WebElement getValue() {
		return value;
	}
	
	
}
