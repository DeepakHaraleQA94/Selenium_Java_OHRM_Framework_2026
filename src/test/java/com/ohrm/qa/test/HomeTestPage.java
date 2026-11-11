package com.ohrm.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.qa.parent.TestBase;
import com.ohrm.qa.pom.HomePage;
import com.ohrm.qa.pom.LoginPage;
import com.ohrm.qa.utility.utility;

public class HomeTestPage extends TestBase{

	utility util;
	HomePage home;
	public HomeTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {
		Intilization();
		util = new utility();
	    home = new HomePage();
	}
	
	@Test
	public void vaildateUserName() throws IOException{
		util.ClickOnloginPage();
		String actualUserName = home.getUserName();
		String expectedUserName = "manda user";
		Assert.assertEquals(actualUserName, expectedUserName, "TC Failed");
		Reporter.log("TC passed",true);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
