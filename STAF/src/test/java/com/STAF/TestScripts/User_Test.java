package com.STAF.TestScripts;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.STAF.GenericLib.TestBase;
import com.STAF.GenericLib.Xls_Reader;

public class User_Test extends TestBase{
	
	//Creating datatable object of Xls_Reader class
	

	Xls_Reader elib = new Xls_Reader("C:\\Users\\Sandul\\Documents\\Workspace\\STAF\\TestData\\TestData.xlsx");
	@BeforeTest
	public void initialize() throws IOException, InterruptedException, AWTException
	{
	
		 driver =initializeDriver();

	}
	@Test
	public void createUserTest() throws InvalidFormatException, IOException, InterruptedException
	{
		//get test data
		//String userID=datatable.getExcelData("TestData", 1, 2);
		String userID=elib.getCellData("TestData", "UserName", 1);
		System.out.println(userID);
		//step1:logon to app
		//WebDriver driver=new FirefoxDriver();
		driver.get("http://facebook.com");
		/*driver.findElement(By.name("username"));
		driver.findElement(By.name("password"));
		driver.findElement(By.name("login")).click();*/
		Thread.sleep(3000);
		driver.quit();
		
		//write data back to excel
		elib.setCellData("TestData", "url", 1, "PASS");
		
	}

}
