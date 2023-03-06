package com.tutorialNinja.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;



	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstname")
	private WebElement firstName;


	@FindBy(name = "lastname")
	private WebElement lastName;


	@FindBy(name = "email")
	private WebElement email;


	@FindBy(name = "telephone")
	private WebElement telephone;


	@FindBy(name = "password")
	private WebElement passWord;


	@FindBy(name = "confirm")
	private WebElement cnfmPass;



	@FindBy(name = "agree")
	private WebElement agreeRdoBtn;


	@FindBy(xpath = "//*[@name='agree']/following-sibling::input[@type='submit']")
	private WebElement registerBtn;


	@FindBy(xpath = "//div[@id='content']/h1[contains(text(),'Account')]")
	private WebElement accntText;


	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	private WebElement cntnueBtn;
	
	
	@FindBy(xpath = "//div[contains(text(),'Privacy Policy!')]")
	WebElement privacyPolicyMessage;
	
	@FindBy(xpath = "//*[@name='firstname']/following-sibling::div")
	WebElement firstNameError;
	
	
	@FindBy(xpath = "//*[@name='lastname']/following-sibling::div")
	WebElement lastNameError;
	
	
	@FindBy(xpath = "//*[@name='email']/following-sibling::div")
	WebElement emailError;
	
	
	@FindBy(xpath = "//*[@name='telephone']/following-sibling::div")
	WebElement teleError;
	
	
	@FindBy(xpath = "//*[@name='password']/following-sibling::div")
	WebElement passError;
	


	
	public AccountPage clickOnRegisterBtn() {
		registerBtn.click();
		return new AccountPage(driver);
	}
	
	
	public boolean AccntIsDisplayed() {
		boolean Isdisplayed = accntText.isDisplayed();
		return Isdisplayed;
	}
	
	
	public void clickOnContinueBtn() {
		cntnueBtn.click();
	}
	
	
	public String PrivacyMessage() {
		String message = privacyPolicyMessage.getText();
		return message;
	}


	public String firstNameErrorText() {
		String text = firstNameError.getText();
		return text;
	}

	
	
	public String lastNameErrorText() {
		String text = lastNameError.getText();
		return text;
	}


	public String emailErrorText() {
		String text = emailError.getText();
		return text;
	}

	
	
	public String teleErrorText() {
		String text = teleError.getText();
		return text;
	}

	
	
	public String passErrorText() {
		String text = passError.getText();
		return text;
	}


	
	public AccountPage register(String firstname, String lastname, String emailText,String tele, String pass) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		email.sendKeys(emailText);
		telephone.sendKeys(tele);
		passWord.sendKeys(pass);
		cnfmPass.sendKeys(pass);
		agreeRdoBtn.click();
		registerBtn.click();
		return new AccountPage(driver);
		
	}





}
