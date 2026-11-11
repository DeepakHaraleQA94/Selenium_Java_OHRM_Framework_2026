package com.ohrm.qa.parent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestBase {
    public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException{
		prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\Selenium_Java_OHRM_Framework_2026\\src\\main\\java\\com\\ohrm\\qa\\environment\\config.properties");
		prop.load(file);	
	}
	
	
	public void Intilization() {
		
		String broswerName =  prop.getProperty("BrowserName");
		if(broswerName.equals("Chrome")) {
			driver = new ChromeDriver();
		}else if(broswerName.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(broswerName.equals("edge")) {
			driver = new EdgeDriver();
		}else {
			System.out.println("Check your browser name ... !");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("URL"));
		
	}
	
	
	
}
