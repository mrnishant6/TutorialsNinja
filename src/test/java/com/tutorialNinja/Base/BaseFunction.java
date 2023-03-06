package com.tutorialNinja.Base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.tutorialNinja.utility.Constant;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseFunction {

	WebDriver ldriver;
	public Properties prop;
	

	public BaseFunction() throws Exception {
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir") + "//src//main//java//com//tutorialNinja//utility//config.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);

	}


	public WebDriver init(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			ldriver = WebDriverManager.chromedriver().create();
		}

		else if(browser.equalsIgnoreCase("edge")){
			ldriver  = WebDriverManager.edgedriver().create();
		}

		else if(browser.equalsIgnoreCase("safari")) {
			ldriver = WebDriverManager.safaridriver().create();
		}

		else {
			ldriver = WebDriverManager.firefoxdriver().create();
		}
		ldriver.manage().window().maximize();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constant.IMPLICIT_WAIT_TIME));
		ldriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constant.PAGE_WAIT_TIME));
		ldriver.get(prop.getProperty("url"));

		return ldriver;


	}}
