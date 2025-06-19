package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {
	
	private static final By COMPANY_TEXT_BOX_LOCATOR=By.id("company");
	private static final By ADDRESS1_TEXT_BOX_LOCATOR=By.id("address1");
	private static final By ADDRESS2_TEXT_BOX_LOCATOR=By.id("address2");
	private static final By CITY_TEXT_BOX_LOCATOR=By.id("city");
	private static final By POST_CODE_TEXT_BOX_LOCATOR=By.id("postcode");
	private static final By HOME_PHONE_TEXT_BOX_LOCATOR=By.id("phone");
	private static final By MOBILE_NUMBER_TEXT_BOX_LOCATOR=By.id("phone_mobile");
	private static final By OTHER_INFO_TEXT_BOX_LOCATOR=By.id("other");
	private static final By ADDRESS_ALIAS_TEXT_BOX_LOCATOR=By.id("alias");
	
	private static final By STATE_DROPDOWN_LOCATOR=By.id("id_state");
	private static final By SAVE_BUTTON_LOCATOR=By.id("submitAddress");
	
	public AddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void saveAddress() {
		enterText(COMPANY_TEXT_BOX_LOCATOR, "ABC");
		enterText(ADDRESS1_TEXT_BOX_LOCATOR, "Address1");
		enterText(ADDRESS2_TEXT_BOX_LOCATOR, "Address2");
		enterText(CITY_TEXT_BOX_LOCATOR, "CITY");
		enterText(POST_CODE_TEXT_BOX_LOCATOR, "76544");
		enterText(HOME_PHONE_TEXT_BOX_LOCATOR, "9870987654");
		enterText(MOBILE_NUMBER_TEXT_BOX_LOCATOR, "9870987654");
		enterText(OTHER_INFO_TEXT_BOX_LOCATOR, "RANDOM 1243");
		clearText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR, "home address");
		
		selectFromDropdown(STATE_DROPDOWN_LOCATOR, "California");
		
	}

}
