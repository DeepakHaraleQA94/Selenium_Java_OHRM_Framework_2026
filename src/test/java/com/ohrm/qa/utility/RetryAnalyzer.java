package com.ohrm.qa.utility;

import java.io.IOException;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.ohrm.qa.parent.TestBase;

public class RetryAnalyzer extends TestBase implements IRetryAnalyzer {

		public RetryAnalyzer() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

		private int retryCount = 0;
	    private static final int MAX_RETRY_COUNT = 2;

	    @Override
	    public boolean retry(ITestResult result) {

	        if (retryCount < MAX_RETRY_COUNT) {
	            retryCount++;

	            System.out.println(
	                "Retrying test: " + result.getName()
	                + " | Retry attempt: " + retryCount
	            );

	            return true;
	        }

	        return false;
	    }
	}

