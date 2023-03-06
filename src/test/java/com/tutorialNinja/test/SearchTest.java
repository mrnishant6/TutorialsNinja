package com.tutorialNinja.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialNinja.Base.BaseFunction;
import com.tutorialNinja.Pageobjects.HomePage;
import com.tutorialNinja.Pageobjects.SearchPage;

public class SearchTest extends BaseFunction {
	public WebDriver driver;
	public SearchPage sp;
	public HomePage hp;
	
	
	
	
	public SearchTest() throws Exception {
		super();
	}

	

	@BeforeMethod
	public void setup() {
		driver = init(prop.getProperty("browser"));

}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyValidProductSearch() {
		hp = new HomePage(driver);
		sp =hp.Search("HP");
		String actualText = sp.searchResultText();
		Assert.assertEquals(actualText, "HP LP3065");
	}
	
	
	
	@Test(priority=2)
	public void verifyInalidProductSearch() {
		hp = new HomePage(driver);
		sp = hp.Search("Honda");
		String actualText = sp.searchErrorText();
		Assert.assertEquals(actualText, "There is no product that matches the search criteria.");
	}

	
	@Test(priority=3)
	public void verifyNullProductSearch() {
		hp = new HomePage(driver);
		sp =hp.Search("");
		String actualText = sp.searchErrorText();
		Assert.assertEquals(actualText, "There is no product that matches the search criteria.");
	}
}
