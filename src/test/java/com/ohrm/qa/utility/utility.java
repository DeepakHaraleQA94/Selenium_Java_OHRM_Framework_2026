package com.ohrm.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ohrm.qa.parent.TestBase;
import com.ohrm.qa.pom.LoginPage;

public class utility extends TestBase{
//	String EXCEL_SHEET_PATH ="C:\\Users\\Hp\\eclipse-workspace\\Selenium_Java_OHRM_Framework_2026\\src\\main\\java\\com\\ohrm\\qa\\environment\\validationSheet.xlsx";
	String EXCEL_SHEET_PATH  = "C:\\Users\\Hp\\eclipse-workspace\\Selenium_Java_OHRM_Framework_2026\\src\\main\\java\\com\\ohrm\\qa\\testdata\\testData.xlsx";
	LoginPage login;
	public utility() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

  
	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% LoginPage code %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	
	public void ClickOnloginPage() throws IOException {
		login = new LoginPage();
		login.enterUserName(prop.getProperty("Uname"));
		login.enterPassword(prop.getProperty("Pass"));
		login.clickOnLoginBtn();
	}
	
	
	public String captureScreenShot(String testName) throws IOException {
		// step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		// step2: call getScreenshotAs method to create image file

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "\\Screenshot\\" + testName + ".png";
		File dest = new File(path);

		// step3: copy image file to destination
		FileUtils.copyFile(src, dest);

		return path;
	}

	
	
	
	public static ExtentReports getExtentReport() {

	    ExtentReports report = new ExtentReports();

	    // Report File Path
	    File extentReportFile = new File(
	            System.getProperty("user.dir")
	            + "\\ExtentReports\\eReport.html"
	    );

	    // Spark Reporter Configuration
	    ExtentSparkReporter sparkReporter =
	            new ExtentSparkReporter(extentReportFile);

	    // Report Theme
	    sparkReporter.config().setTheme(Theme.DARK);

	    // Report Title
	    sparkReporter.config().setDocumentTitle("Automation Test Report");

	    // Report Name
	    sparkReporter.config().setReportName("Selenium Automation Execution Report");

	    // Encoding it will give proper formate for special text
	    sparkReporter.config().setEncoding("UTF-8");

	    // Attach Reporter
	    report.attachReporter(sparkReporter);

	    // System Information
	    report.setSystemInfo("Automation Tool", "Selenium WebDriver");
	    report.setSystemInfo("Testing Framework", "TestNG");
	    report.setSystemInfo("Programming Language", "Java");
	    report.setSystemInfo("Operating System",
	            System.getProperty("os.name"));
	    report.setSystemInfo("OS Architecture",
	            System.getProperty("os.arch"));
	    report.setSystemInfo("Java Version",
	            System.getProperty("java.version"));
	    report.setSystemInfo("User Name",
	            System.getProperty("user.name"));
	    report.setSystemInfo("Project Directory",
	            System.getProperty("user.dir"));

	    return report;
	}
	
	
//	################## DataProvide ###############

	
	@DataProvider(name = "excelData")
	public Object[][] CollectDataFromExcel(String SheetName) throws IOException {

	    FileInputStream findpath = new FileInputStream(EXCEL_SHEET_PATH);
	    XSSFWorkbook action = new XSSFWorkbook(findpath);

	    XSSFSheet sheetName = action.getSheet(SheetName);

	    int lastRow = sheetName.getLastRowNum();
	    int lastCell = sheetName.getRow(1).getLastCellNum();
	    System.out.println(lastRow);
	    Object[][] data = new Object[lastRow][lastCell];

	    for (int r = 1; r <= lastRow; r++) {

	        for (int c = 0; c < lastCell; c++) {

	            data[r - 1][c] =
	                sheetName.getRow(r).getCell(c).toString();

	            System.out.println(data[r - 1][c]);
	            
	        }
	        
	        	        
	    }

	    
	    
	    findpath.close();
	    
	    return data;
	}

	
	
}
