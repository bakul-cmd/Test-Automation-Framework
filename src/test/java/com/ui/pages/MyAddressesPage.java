package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class MyAddressesPage extends BrowserUtility{
	
	private static final By DELETE_BUTTON_LOCATOR=By.xpath("//a[@title='Delete']/span");
	private static final By ADD_A_NEW_ADDRESS_ALERT_LINK_LOCATOR=By.xpath("//p[contains(@class,'alert-warning')]/a");

	public MyAddressesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public MyAddressesPage clickOnDeleteButton() {
		clickOn(DELETE_BUTTON_LOCATOR);
		return this;
	}
	
	public MyAddressesPage confirmDelete() {
		acceptAlert();
		return this;
	}
	
	public String addAddressAgainVisibility() {
		return getVisibleText(ADD_A_NEW_ADDRESS_ALERT_LINK_LOCATOR);
		

	}

}
