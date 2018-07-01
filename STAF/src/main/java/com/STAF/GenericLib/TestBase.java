
package com.STAF.GenericLib;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



public class TestBase  {
	
	public static WebDriver driver;

	
	
	public static WebDriver initializeDriver() throws IOException, InterruptedException, AWTException{
			 
		 String browserName = Property_Helper.readValue("Browser_type");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", Property_Helper.readValue("Chrome_Path"));
			driver= new ChromeDriver();
			//execute in chrome driver
			
		}
		else if (browserName.equals("firefox"))
		{
			 System.setProperty("webdriver.gecko.driver", Property_Helper.readValue("FF_Path"));
			 driver= new FirefoxDriver();
			//firefox code
		}
		else if (browserName.equals("IE"))
		{
		//	IE code
			 System.setProperty("webdriver.ie.driver", Property_Helper.readValue("IE_Path"));
			 DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			 ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			 ieCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			 driver = new InternetExplorerDriver(ieCapabilities);
			 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			 driver.manage().window().maximize();
		 	//driver = new InternetExplorerDriver();
		}
		return driver;
		 
	}	  
	/*webdriver commands
	waitforPagetoLoad
	waitForXpathPresent
	waitForNamePresent
	verifyText
	AcceptAlert
	dismissAlert*/
	 	
}
