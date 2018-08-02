package com.advanceAmarica.utils;


import java.io.FileReader;

import java.util.Properties;

public class PropertyFileReader {
	
	public static Properties p;
	public static FileReader reader;
	public static String value = null;
	
	public static String getPropertyValue(String key) {
		
		try {
			p=new Properties();  
			reader = new FileReader("./src/test/java/com/advanceAmarica/Config/Config.properties");
			p.load(reader);
			reader = new FileReader("./src/test/java/com/advanceAmerica/Object/SignUpPage.properties");
			p.load(reader);
			reader = new FileReader("./src/test/java/com/advanceAmerica/Object/Login.properties");
			p.load(reader);
			value  = p.getProperty(key);
		} catch (Exception e1) {
		
			e1.printStackTrace();
		}
		return value;  
	}

	
}
