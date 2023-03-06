package com.tutorialNinja.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport(){
		ExtentReports extReport = new ExtentReports(); 

		File extentReportFile = new File(System.getProperty("user.dir") + "//test-output//ExtentReports//extentReport.html");

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialNinja Test Automation Detailed Report");
		sparkReporter.config().setDocumentTitle("TutorialNinja Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm;ss");
		extReport.attachReporter(sparkReporter);


		Properties configProp = new Properties();
		File configFile = new File(System.getProperty("user.dir") + "//src//main//java//com//tutorialNinja//utility//config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(configFile);
			configProp.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}



		extReport.setSystemInfo("Appplication Url", configProp.getProperty("url"));
		extReport.setSystemInfo("BrowserName", configProp.getProperty("browser"));
		extReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extReport.setSystemInfo("System UserName", System.getProperty("user.name"));
		extReport.setSystemInfo("java-version", System.getProperty("java.version"));


		return extReport;





	}

}
