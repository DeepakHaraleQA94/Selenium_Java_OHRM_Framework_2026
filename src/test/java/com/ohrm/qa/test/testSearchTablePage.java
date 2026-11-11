package com.ohrm.qa.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.qa.parent.TestBase;
import com.ohrm.qa.pom.HomePage;
import com.ohrm.qa.pom.SearchTable;
import com.ohrm.qa.utility.utility;

public class testSearchTablePage extends TestBase {
	utility util;
	HomePage home;
	SearchTable search;
	public testSearchTablePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		Intilization();
		util = new utility();
		util.ClickOnloginPage();
		home = new HomePage();
		Thread.sleep(4000);
		home.clickOnAdminTab();
		
	}
	
	
	@Test
	public void getrowDataOfTable() throws IOException {
		search = new SearchTable();
		List<WebElement> getData = search.getTableData();
		for(WebElement obj:getData) {
			
			String getRowText = obj.getText();
			System.out.println(getRowText);
			boolean actualResult = getRowText.contains("Actions");
			Assert.assertTrue(actualResult, "TC failed");
//			if(getRowText.contains("Actions")) {
//				System.out.println("true");
//				
//			}else
//			{
//				System.out.println("false");
//			}
			
		}
		
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
