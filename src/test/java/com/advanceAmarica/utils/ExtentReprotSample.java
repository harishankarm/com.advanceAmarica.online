package com.advanceAmarica.utils;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReprotSample {

	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd hh-mm-ss");
	
	public static void ExtentReprotSample1()
	{
		reporter = new ExtentHtmlReporter(PropertyFileReader.getPropertyValue("ExtentReports.Path"));
		
		extent = new ExtentReports();
	
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Machine", "Anshul-772G");
		extent.setSystemInfo("Env", "DevOps");
		extent.setSystemInfo("Build", "Integration");
		extent.setSystemInfo("Browser", "IE");
	}
	
	public static void startTestCaseReport(String TCName)
	{
		
		
		logger = extent.createTest(TCName);
		
	
	}
	
	public static void addScreenshot(String Path)
	{
		try {
			
			logger.addScreenCaptureFromPath(Path);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loggerInfo(String Message)
	{
		logger.log(Status.INFO, Message);
	}
	public static void loggerFail(String Message)
	{
		logger.log(Status.FAIL, Message);
	}
	public static void loggerPass(String Message)
	{
		logger.log(Status.PASS, Message);
	}
	public static void loggerSkip(String Message)
	{
		logger.log(Status.SKIP, Message);
		
	}
	public static void endTest()
	{
		extent.flush();
	}
	

	
	public static String captureScreen(WebDriver driver, String screenName){
		Date date = new Date();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		CreateDirectoryExample();
		String dest = PropertyFileReader.getPropertyValue("Screenshot.Folder")+screenName+dateFormat.format(date)+".jpg";
		File target = new File(dest);
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return dest;
	}
	
	
	public static void captureScreenShot(WebDriver ldriver, String Fname) {
		File src = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
		try {
			CreateDirectoryExample();
			FileUtils.copyFile(src, new File(PropertyFileReader.getPropertyValue("Screenshot.Folder")+Fname + System.currentTimeMillis() + ".png"));
		} catch (IOException e)

		{
			System.out.println(e.getMessage());
		}
		
	}

	
	public static void CreateDirectoryExample()
	{
	File file = new File("C:\\Directory1");
    if (!file.exists()) {
        if (file.mkdir()) {
            System.out.println("Directory is created!");
        } else {
            System.out.println("Failed to create directory!");
        }
    }
	}
	
}
