package com.tutorialNinja.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='button-search']/following-sibling::div/descendant::h4")
	private WebElement searchResult;
	
	
	@FindBy(xpath = "//*[@id='button-search']/following-sibling::p")
	private WebElement searchError;
	
	public String searchResultText() {
		
		

		String result = searchResult.getText();
		return result;
	}
	
	
	public String searchErrorText() {
		String result = searchError.getText();
		return result;
	}

}
