package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase {
	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	private AddressPOJO address;
	@BeforeMethod(description="Valid for first time user , if address is already there it does not work")
	public void setup() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("jeweno5149@3dboxer.com", "password123");
		address=FakeAddressUtility.getFakeAddress();
	}
	
	
	@Test(retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class)
	public void addNewAddress() {
		String newAddress =myAccountPage.goToAddAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress,address.getAddressAlias().toUpperCase());
		
	}
}
