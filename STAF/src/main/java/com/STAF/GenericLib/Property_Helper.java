package com.STAF.GenericLib;
//Class to get the item value for a key in the GLOBAL PROPERTIES File



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property_Helper {
	
	public static String readValue(String key) throws IOException
	{
		
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\Sandul\\Documents\\Workspace\\STAF\\src\\main\\java\\com\\STAF\\GenericLib\\global.properties"));
		Properties prop = new Properties();
		
		prop.load(fis);
		return prop.getProperty(key);
			
	}

}
