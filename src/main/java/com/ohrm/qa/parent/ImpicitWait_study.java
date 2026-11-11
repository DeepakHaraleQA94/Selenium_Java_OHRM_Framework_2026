package com.ohrm.qa.parent;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class ImpicitWait_study {

	public static void main(String[] args)  {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
//		it will not work on the brower action it will work on only your web element
//		String currentPageUrl = driver.getCurrentUrl();
//		String expectedPageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index" ;
//		
//		Assert.assertEquals(currentPageUrl, expectedPageUrl);

		
		 WebElement userName = driver.findElement(By.xpath("//p[text()='Hugo Doe']"));
		 String actualName = userName.getText();
		 String expectedName = "Hugo Doe";
		 
		 Assert.assertEquals(actualName, expectedName, "TC Not maching , TC failed");
		 Reporter.log("Result Maching , Tc Passed",true);
		 
		 
		
		
	}
}
