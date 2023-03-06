package com.tutorialNinja.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath= "//span[contains(text(),'My Account')]")
	private WebElement MyAccount;


	@FindBy(xpath= "//a[contains(text(),'Login')]")
	private WebElement loginOption;

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	private WebElement registerOption;


	@FindBy(name = "search")
	WebElement searchField;


	@FindBy(xpath = "//*[contains(@name,'search')]/following-sibling::span/button")
	WebElement findBtn;





	public LoginPage navigateToLoginPage() {
		MyAccount.click();
		loginOption.click();
		return new LoginPage(driver);
	}



	public RegisterPage navigateToRegisterPage() {
		MyAccount.click();
		registerOption.click();
		return new RegisterPage(driver);
	}

	public RegisterPage clickOnRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}



	public SearchPage Search(String searchText) {
		searchField.sendKeys(searchText);
		findBtn.click();
		return new SearchPage(driver);
	}	


}
