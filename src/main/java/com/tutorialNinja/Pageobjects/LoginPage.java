package com.tutorialNinja.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver driver;
	
	@FindBy(name = "email")
	private WebElement email;
	
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@type='submit' and @value = 'Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = " //div[@id = 'account-login']/ul/following-sibling::div[contains(@class,'alert')]")
	private WebElement emailWarning;
	
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterEmailAddress(String emailText) {
		email.sendKeys(emailText);
	}
	
	public void enterPassword(String Pass) {
		password.sendKeys(Pass);
	}
	
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	
	public AccountPage loggingInTheApplication(String emailText, String Pass) {
		email.sendKeys(emailText);
		password.sendKeys(Pass);
		loginButton.click();
		return new AccountPage(driver);
	}
	
	
	public boolean emailWarnIsDisplayed() {
		boolean warnMessage= emailWarning.isDisplayed();
		return warnMessage;
	}
	
	

}
