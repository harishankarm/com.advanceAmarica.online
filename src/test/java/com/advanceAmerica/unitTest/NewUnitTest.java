package com.advanceAmerica.unitTest;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.advanceAmarica.utils.ExtentReprotSample;

public class NewUnitTest {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		ExtentReprotSample.ExtentReprotSample1();
		
	}
	
	@Test
	public void testCase1() throws InterruptedException
	{
		ExtentReprotSample.startTestCaseReport(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExtentReprotSample.loggerInfo("This is my first TC and first step .....");
		ExtentReprotSample.loggerInfo("This is my first TC and second step .....");
		ExtentReprotSample.loggerInfo("This is my first TC and Third step .....");
		Thread.sleep(2000);
	}
	@Test
	public void testCase2() throws InterruptedException
	{
		ExtentReprotSample.startTestCaseReport(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExtentReprotSample.loggerInfo("This is my second TC and first step .....");
		ExtentReprotSample.loggerInfo("This is my second TC and second step .....");
		
		Assert.fail();
		ExtentReprotSample.loggerInfo("This is my second TC and Third step .....");
		Thread.sleep(2000);
	}
	@Test
	public void testCase3() throws InterruptedException
	{
		ExtentReprotSample.startTestCaseReport(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExtentReprotSample.loggerInfo("This is my Third TC and first step .....");
		ExtentReprotSample.loggerInfo("This is my Third TC and second step .....");
		ExtentReprotSample.loggerInfo("This is my Third TC and Third step .....");
		ExtentReprotSample.loggerSkip("Skiped");
		Thread.sleep(2000);
		
	}

	
	public void afterTest()
	{
		ExtentReprotSample.endTest();
	}
	@AfterMethod
	public void setTestResult(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentReprotSample.loggerFail(result.getName());
			ExtentReprotSample.addScreenshot(ExtentReprotSample.captureScreen(driver, "Fail"));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentReprotSample.loggerPass(result.getName());
			ExtentReprotSample.addScreenshot(ExtentReprotSample.captureScreen(driver, "Pass"));
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentReprotSample.loggerSkip(result.getName());
		}
		ExtentReprotSample.endTest();
		
	}
	@AfterSuite()
	public void CloseBrowser()
	{
		driver.close();
	}
}
