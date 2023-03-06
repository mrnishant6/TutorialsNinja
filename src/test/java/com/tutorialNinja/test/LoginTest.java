package com.tutorialNinja.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialNinja.Base.BaseFunction;
import com.tutorialNinja.Pageobjects.AccountPage;
import com.tutorialNinja.Pageobjects.HomePage;
import com.tutorialNinja.Pageobjects.LoginPage;
import com.tutorialNinja.utility.Utility;

public class LoginTest extends BaseFunction {
	

	public WebDriver driver;
	public LoginPage lp;
	public AccountPage ap;
	
	
	
	
	
	public LoginTest() throws Exception {
		super();
	}
	

	
	@BeforeMethod
	public void setup(){
		
		driver =init(prop.getProperty("browser"));
		HomePage hp = new HomePage(driver);
		lp = hp.navigateToLoginPage();

	}
	
	
	@Test(priority = 1, dataProvider = "supplyValidLogindata")
	public void verifyLoginCreds(String email, String password) {
		ap =lp.loggingInTheApplication(email, password);
		Assert.assertTrue(ap.myAccountLinkDisplayed());
		
		
		}
	
	@DataProvider
	public Object supplyValidLogindata() throws IOException {
		Object  [] [] data = Utility.getTestdataFromExcel("Login");
		return data;
	}
	
	@Test(priority = 2, dataProvider = "supplyInvalidLogindata")
	public void verifyWrongLoginCreds(String email, String pass) {
		lp.loggingInTheApplication(email, pass);
		Assert.assertTrue(lp.emailWarnIsDisplayed());
	
		
		}
	
	
	@DataProvider
	public Object supplyInvalidLogindata() throws IOException {
		Object  [] [] data = Utility.getTestdataFromExcel("InvalidLogin");
		return data;
	}
	
	
	@Test(dataProvider = "supplyInvalidUsernamedata")
	public void verifyWrongUsernameLoginCreds(String email, String pass) {
		lp.loggingInTheApplication(email, pass);
		Assert.assertTrue(lp.emailWarnIsDisplayed());
		
		
		}
	
	@DataProvider
	public Object supplyInvalidUsernamedata() throws IOException {
		Object  [] [] data = Utility.getTestdataFromExcel("InvalidUsername");
		return data;
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
