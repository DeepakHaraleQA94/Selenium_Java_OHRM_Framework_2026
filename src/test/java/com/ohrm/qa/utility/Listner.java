package com.ohrm.qa.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ohrm.qa.parent.TestBase;

public class Listner extends TestBase implements ITestListener{
	utility util = new utility();
	 ExtentReports report = utility.getExtentReport();
	 ExtentTest eTest;
	public Listner() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void onStart(ITestContext context) {
	Reporter.log("Test class excution started...!",true);
	  }
	
	public void onTestStart(ITestResult result) {
		   String methodName = result.getMethod().getMethodName();
		   Reporter.log("TC excution started..!"+ methodName,true);
	
		  
		   eTest = report.createTest(methodName);
		   eTest.log(Status.INFO, methodName+ " "+"TC excution started..!");
		  
	  }

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		   Reporter.log("TC excution Successfull..!"+ methodName,true);
		   eTest.log(Status.PASS, methodName+" "+ "TC Passed..!");
		  
		   
	  }
	
	  public void onTestFailure(ITestResult result) {
		  String methodName = result.getMethod().getMethodName();
		   Reporter.log("TC excution failuer..!"+ methodName,true);
		   if(eTest != null) {
		   
		   try {
			eTest.log(Status.FAIL, methodName+" "+ "TC Failed..!").addScreenCaptureFromPath(util.captureScreenShot(methodName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   eTest.log(Status.INFO, result.getThrowable());
		  try {
			util = new utility();
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }

		   try {
			util.captureScreenShot(methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		   
		  }

	  public void onTestSkipped(ITestResult result) {
		  String methodName = result.getMethod().toString();
		   Reporter.log("TC excution skipped..!"+ methodName,true);
		 
			eTest.log(Status.SKIP, methodName+" "+ "TC Skipped..!");
		
		   eTest.log(Status.INFO, result.getThrowable());
		  }
	
	  public void onFinish(ITestContext context) {
		     
		     report.flush();
		  }

	
}
