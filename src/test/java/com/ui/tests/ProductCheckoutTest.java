package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {
	
	private static final String SEARCH_TERM="Printed Summer Dress";
	private SearchResultPage searchResultPage;
	
	
	@BeforeMethod(description = "User logs into the application and searches for a product")
	public void setup() {

		searchResultPage=homePage.goToLoginPage().doLoginWith("jeweno5149@3dboxer.com", "password123")
				.searchForProduct(SEARCH_TERM);

	}

	@Test(description = "Verify User able to able to buy a product", groups = { "e2e", "Sanity", "Smoke" })
	public void checkoutTest() {
		
		Assert.assertTrue(searchResultPage.isSearchTermPresentInProductList(SEARCH_TERM),
			    "Search term not present in product list!");

			searchResultPage.ClickOnTheProductAt(0);


	}

}
