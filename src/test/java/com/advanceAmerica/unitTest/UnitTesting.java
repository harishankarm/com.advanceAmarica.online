package com.advanceAmerica.unitTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.advanceAmarica.utils.ExtentReprotSample;



public class UnitTesting  {
	
	//mvn clean test -DtestXml=testng.xml -Dbrowser=HI -DbrowserName=Bye -DtestRunID=Hello
	public static WebDriver driver;
	@Test
	public void setBroserUp() {
		  String browserName = getParameter("browser");
		  System.out.println(browserName);
		  String value = System.getProperty("browserName");
		  String value1 = System.getProperty("testRunID");
		  Reporter.log(value);
		  Reporter.log(value1);
		  System.out.println(value);
		  System.out.println(value1);
		  System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.google.com");
			
		 }
	private String getParameter(String name) { 
		  String value = System.getProperty(name);
		  if (value == null)
		     throw new RuntimeException(name + " is not a parameter!");

		  if (value.isEmpty())
		    throw new RuntimeException(name + " is empty!");

		  return value;
		 }
	
	/*
	public static WebDriver driver;
	public static final String Browser_Jenkin=System.getProperty("BrowserName");
    public static final String TestRunID=System.getProperty("TestRunID");
	//static Properties p = new Properties();
	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println(System.getProperty("user.dir"));
		
	String s1=browser_Setter();
	String s2 = testRunID_Setter();
	System.out.println(s1);
	System.out.println(s2);
	}
		

	  public static String browser_Setter()
	    {
	        String value=null;
	        try {
	            if(!Browser_Jenkin.isEmpty())
	            {
	                value = Browser_Jenkin;
	            }
	        } catch (Exception e) {
	           // value =propObj.getProperty("BROWSER");
	        }
	        return value;   
	    }

	    public static String testRunID_Setter()
	    {
	        String value=null;
	        try {
	            if(!TestRunID.isEmpty())
	            {
	                value = TestRunID;
	            }
	        } catch (Exception e) {
	           // value =propObj.getProperty("TEST_RUN_ID");
	        }
	        return value;   
	    }
		
		String s1 = PropertyFileReader.getPropertyValue("login.signIn");
		String s2 = PropertyFileReader.getPropertyValue("Home.Link");
		System.out.println(s1);
		System.out.println(s2);
		
		SpreadSheetBaseFunc obj1 = new SpreadSheetBaseFunc();
		List<String>  ls = obj1.getTableColumnValues("Sheet1","TC");
		System.out.println(ls);
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.youtube.com/");
		Thread.sleep(4000);
		//ExtentReprotSample.captureScreenShot(driver, "Test");
		ExtentReprotSample.startTestCaseReport("TC1");
		ExtentReprotSample.loggerFail("Failer");
		ExtentReprotSample.addScreenshot(ExtentReprotSample.captureScreen(driver, "Fail"));
		
		ExtentReprotSample.endTest();
		driver.close();
	
		*/

}
