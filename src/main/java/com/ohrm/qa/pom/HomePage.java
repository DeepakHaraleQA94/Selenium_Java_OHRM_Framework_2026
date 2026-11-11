package com.ohrm.qa.pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrm.qa.parent.TestBase;

public class HomePage extends TestBase {



//	@FindBy(xpath = "//span[text()='Administrador']")
	@FindBy(linkText = "Admin")
	private WebElement adminTab;
	
	@FindBy(xpath = "//span[text()='Módulo de Información Personal']")
	private WebElement personalInfoTab;
	
	@FindBy(xpath = "//p[text()='manda user']")
	private WebElement userName;
	
	
	
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAdminTab() {
		adminTab.click();
	}
	
	public String getUserName() {
		 String getUserName = userName.getText();
		 return getUserName;
	}
	
	
	
}
