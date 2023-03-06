package com.tutorialNinja.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	
	WebDriver driver;
	
	@FindBy(xpath = "//h2[contains(text(),'My Account')]")
	private WebElement MyAccount;
	
	
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean myAccountLinkDisplayed() {
		boolean myStatus = MyAccount.isDisplayed();
		return myStatus;
	}
	

}



