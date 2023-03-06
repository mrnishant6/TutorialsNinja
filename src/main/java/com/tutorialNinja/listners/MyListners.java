package com.tutorialNinja.listners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialNinja.utility.ExtentReporter;

public class MyListners implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extTest;
	WebDriver driver;
	
	public void onStart(ITestContext context) {
		
		
		extentReport = ExtentReporter.generateExtentReport();
		System.out.println("Execution has started");
	}

	public void onTestStart(ITestResult result) {
		String test = result.getName();
		extTest = extentReport.createTest(test);
		extTest.log(Status.INFO, test + "started Executing");
	}

	public void onTestSuccess(ITestResult result) {
		String test = result.getName();
		extTest = extentReport.createTest(test);
		extTest.log(Status.PASS, test + "Passed Successfully");
		
	}



	public void onTestFailure(ITestResult result) {
		String test = result.getName();
		extTest = extentReport.createTest(test);
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		File scrnShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshot = System.getProperty("user.dir") + "//Screenshot//" + test + ".png";
		try {
			FileHandler.copy(scrnShot, new File(destinationScreenshot));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extTest.addScreenCaptureFromPath(destinationScreenshot);
		extTest.log(Status.FAIL, test + " got Failed");
		extTest.log(Status.INFO, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		String test = result.getName();
		extTest = extentReport.createTest(test);
		extTest.log(Status.SKIP, test + "Skipped");
		extTest.log(Status.INFO, result.getThrowable());
	}

	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
