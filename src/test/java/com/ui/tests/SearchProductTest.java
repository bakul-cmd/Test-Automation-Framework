package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listeners.TestListener.class)
public class SearchProductTest extends TestBase{
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM="Printed Summer Dress";
	
	
	@BeforeMethod(description="Valid user logs into the application")
	public void setup() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("jeweno5149@3dboxer.com", "password123");
	}
	
	
	@Test(description="Verify if the logged in user is able to search for a product and correct products are displayed",
			groups= {"e2e","Sanity"})
	public void verifyProductSearchTest() {
		
		boolean actualResult=myAccountPage.searchForProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}

}
