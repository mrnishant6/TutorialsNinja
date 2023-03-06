package com.tutorialNinja.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialNinja.Base.BaseFunction;
import com.tutorialNinja.Pageobjects.AccountPage;
import com.tutorialNinja.Pageobjects.HomePage;
import com.tutorialNinja.Pageobjects.RegisterPage;

public class RegisterTest  extends BaseFunction{
	public WebDriver driver;
	public RegisterPage rp;
	public AccountPage ap;
	
	
	
	
	
	
	public RegisterTest() throws Exception {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		driver = init(prop.getProperty("browser"));
		HomePage hp = new HomePage(driver);
		rp =hp.navigateToRegisterPage();
	}
	
	@Test(priority = 1)
	public void verifyregisterWithMandatoryFields() {
		ap =rp.register("Testing", "Nishkr", "Testing1230601@gmail.com", "00000000000", "TestingTesting");
		Assert.assertTrue(rp.AccntIsDisplayed());
		rp.clickOnContinueBtn();
		Assert.assertTrue(ap.myAccountLinkDisplayed());
		}
	
	
	
	@Test(priority = 2)
	public void verifyRegisteringAccountWithoutFillingDetails() {
		rp.clickOnRegisterBtn();
		String actualPrivacyPolicyMessage = rp.PrivacyMessage();
		Assert.assertTrue(actualPrivacyPolicyMessage.contains("Warning: You must agree to the Privacy Policy!"));
		
		String firstNameError =  rp.firstNameErrorText();
		Assert.assertTrue(firstNameError.contains("First Name must be between 1 and 32 characters!"));
		
		String lastNameError =  rp.lastNameErrorText();
		Assert.assertTrue(lastNameError.contains("Last Name must be between 1 and 32 characters!"));
		
		String emailError =  rp.emailErrorText();
		Assert.assertTrue(emailError.contains("E-Mail Address does not appear to be valid!"));
		
		
		String telephoneError =  rp.teleErrorText();
		Assert.assertTrue(telephoneError.contains("Telephone must be between 3 and 32 characters!"));
		
		
		String passwordError =  rp.passErrorText();
		Assert.assertTrue(passwordError.contains("Password must be between 4 and 20 characters!"));
		
		
		
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
