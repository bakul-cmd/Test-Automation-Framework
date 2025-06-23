package com.ui.tests;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pages.MyAddressesPage;

public class DeleteAddressTest extends TestBase {
	private MyAccountPage myAccountPage;
	private MyAddressesPage myAddressesPage;
	
	@BeforeMethod
	public void setup() {
		
		myAccountPage=homePage.goToLoginPage().doLoginWith("jeweno5149@3dboxer.com", "password123");
	}
	
	
	@Test(description="It verifies to delete exsisting record", dependsOnGroups="coreFlow")
	public void deleteAddressTest() {
		
		String result=myAccountPage.goToMyAddressesPage().clickOnDeleteButton().confirmDelete().addAddressAgainVisibility();
		Assert.assertEquals("Add a new address", result);
	}

}
