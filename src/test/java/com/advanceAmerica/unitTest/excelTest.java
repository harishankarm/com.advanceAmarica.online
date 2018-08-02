package com.advanceAmerica.unitTest;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.advanceAmarica.utils.SpreadSheetBaseFunc;

public class excelTest {

	
	static WebDriver driver=null;
	public static void main(String args[]) throws IOException, AWTException, InterruptedException
	{
		
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();

		//chromeOptions.setCapability("chrome.binary", configData.get("ChromeBinary").toString());
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("disable-extensions");
		chromeOptions.setExperimentalOption("useAutomationExtension", false);


		driver = new ChromeDriver(chromeOptions);

	
		driver.get("file:///C:/Users/38283/Desktop/New%20Text%20Document.html");
		
	    driver.findElement(By.id("1")).click();                                 					
	    Thread.sleep(3000);
	    Runtime.getRuntime().exec("D:\\01_Projects\\Sample\\One.exe");		
	   
	    /*driver.close();
	    
		System.setProperty("webdriver.ie.driver", "./src/test/resources/Drivers/IEDriverServer.exe");
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		WebDriver ieDriver = new InternetExplorerDriver(ieCapabilities);
		ieDriver.get("https://www.google.com");*/
		
		/*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability("ignoreProtectedModeSettings", true);
		capabilities.setCapability("ie.ensureCleanSession", true);
		capabilities.setCapability("enableElementCacheCleanup", true);
		capabilities.setCapability("ignoreZoomSetting", true);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		File file = new File("./src/test/resources/Drivers/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		WebDriver driver = new InternetExplorerDriver(capabilities);
		driver.get("https://www.google.com/");
		*/
		
		/*
		Desktop.getDesktop().open(new File("D:\\Qfund Fix.reg"));
		Robot r = new Robot();Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		//Runtime.getRuntime().load("D:\\Qfund Fix.reg");
		//driver.switchTo().alert().accept();
		//driver.switchTo().alert().accept();
		
		SpreadSheetBaseFunc obj = new SpreadSheetBaseFunc();
		obj.getColumnNo("TestCases","RunMode");
		obj.getRunnableTestCaseName("TestCases","RunMode");*/
	}
	
}
