package com.ohrm.qa.test;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ohrm.qa.parent.TestBase;
import com.ohrm.qa.pom.LoginPage;
import com.ohrm.qa.utility.utility;

public class LoginTestPage extends TestBase{
     LoginPage login;
     utility util;
	public LoginTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		Intilization();
		login = new LoginPage();
		
	}
	
//	@DataProvider
//	public Object[][] data() {
//		Object testData[][]= {{"abc","xyz"},
//							{"pqr","stw"}};
//	return testData;	
//	}
	
	@DataProvider(name = "excelData")
	public Object[][] getData() throws IOException {
		util = new utility();
		 Object[][] data = util.CollectDataFromExcel("Sheet1");
		 return data;
	}

	@Test(dataProvider = "excelData")
	public void validateLoginPage(String uname, String pass) throws IOException {
		
		login.enterUserName(uname);
		login.enterPassword(pass);
		login.clickOnLoginBtn();
		String actualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(actualUrl, ExpectedUrl, "Both url not matching TC Failed");
		Reporter.log("TC Passed", true);
		
	}
	
	

	
	@Test(enabled = false)
	public void validateResetPage() throws InterruptedException {
		Thread.sleep(4000);
		login.clickOnForgotPassLink();
		String ExpectedResetPageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
		String actualResetPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualResetPageUrl, ExpectedResetPageUrl, "Url not matchi TC failed");
		Reporter.log("Reset page url Matching TC passed",true);
		
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	
}
