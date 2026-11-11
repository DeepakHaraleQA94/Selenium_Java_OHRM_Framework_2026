package com.ohrm.qa.pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrm.qa.parent.TestBase;

public class LoginPage extends TestBase {

		
	@FindBy(name = "username")
	private WebElement uname;

	@FindBy(name = "password")
	private WebElement passwd ;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//p[text()='Forgot your password? ']")
	private WebElement forgotPass;
	
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String UserName) {
		uname.sendKeys(UserName);
	}
	
	public void enterPassword(String password) {
		passwd.sendKeys(password);
	}
	
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	
	public void clickOnForgotPassLink() {
		forgotPass.click();
	}
}
