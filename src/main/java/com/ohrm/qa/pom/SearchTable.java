package com.ohrm.qa.pom;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrm.qa.parent.TestBase;

public class SearchTable extends TestBase {

	public SearchTable() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[@role='table']")
	private WebElement table;
	
	@FindBy(xpath = "//div[@role='table']//div[@role='row']")
	private WebElement getTableRows;
	
	
	public List<WebElement> getTableData() {
	 	  List<WebElement> getRowsData = table.findElements(By.xpath("//div[@role='row']"));
	 	  return getRowsData;
		
	}
	
	
}
