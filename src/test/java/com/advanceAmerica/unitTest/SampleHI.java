package com.advanceAmerica.unitTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleHI {

	public static WebDriver driver;
	
	public static void main(String[] args) {
	String s1 = args[0];
	String s2 = args[1];
	String s3 = args[2];
	System.out.println(s1);
	System.out.println(s2);
	System.out.println(s3);
	if(s1.equalsIgnoreCase("Chrome"))
	{
	System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.google.com");
	}else{
	
		throw new RuntimeException("Browser name is not Chrome");
	}
	}
}
