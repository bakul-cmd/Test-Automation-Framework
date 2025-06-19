package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;

public class AddNewAddressTest extends TestBase {
	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	@BeforeMethod
	public void setup() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("jeweno5149@3dboxer.com", "password123");
	}
	
	
	@Test
	public void addNewAddress() {
		myAccountPage.goToAddAddressPage().saveAddress();
		
	}
}
