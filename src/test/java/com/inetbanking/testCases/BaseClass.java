package com.inetbanking.testCases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadData;


public class BaseClass {
	
	ReadData data = new ReadData();
	
	public String baseURL = data.getApplicationURL();
	public String username = data.getUsername();
	public String password = data.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{	
		System.setProperty("webdriver.chrome.driver", data.getChromepath());
		driver = new ChromeDriver();
		}
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File (".//Screenshots//"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
	public String randomstring()// for Aplabets
	{
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return (generatedString);
	}

	public String randomnum()//For Numbers
	{
		String generatedString=RandomStringUtils.randomNumeric(8);
		return (generatedString);
	}
}
