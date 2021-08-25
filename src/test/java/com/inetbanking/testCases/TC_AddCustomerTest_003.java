package com.inetbanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	
	@Test
	public void addNewCustomer() throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("Provideding the customer details");
		addcust.custName("Raja");
		addcust.custgender("male");
		addcust.custdob("01", "22", "1996");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");		
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("adcdcd");
		Thread.sleep(7000);
		
		addcust.custsubmit();
		Thread.sleep(2000);
		logger.info("validation started....");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test case is passed");
			
		}
		else
		{
			logger.info("Test case is failed");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	
	
}
