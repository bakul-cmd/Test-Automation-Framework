package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
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
	private static final By ADDRESS_HEADING=By.tagName("h3");
	
	public AddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String saveAddress(AddressPOJO addressPOJO) {
		enterText(COMPANY_TEXT_BOX_LOCATOR, addressPOJO.getCompany());
		enterText(ADDRESS1_TEXT_BOX_LOCATOR, addressPOJO.getAddressLine1());
		enterText(ADDRESS2_TEXT_BOX_LOCATOR, addressPOJO.getAddressLine2());
		enterText(CITY_TEXT_BOX_LOCATOR, addressPOJO.getCity());
		enterText(POST_CODE_TEXT_BOX_LOCATOR, addressPOJO.getPostCode());
		enterText(HOME_PHONE_TEXT_BOX_LOCATOR, addressPOJO.getHomePh());
		enterText(MOBILE_NUMBER_TEXT_BOX_LOCATOR, addressPOJO.getMobileNo());
		enterText(OTHER_INFO_TEXT_BOX_LOCATOR, addressPOJO.getOtherinfo());
		clearText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR,addressPOJO.getAddressAlias());
		
		selectFromDropdown(STATE_DROPDOWN_LOCATOR,addressPOJO.getState());
		
		clickOn(SAVE_BUTTON_LOCATOR);
		
		String newAddress=getVisibleText(ADDRESS_HEADING);
		return newAddress;
		
		
		
	}

}
