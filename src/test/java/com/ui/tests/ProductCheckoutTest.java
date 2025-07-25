package com.ui.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.ProductDetailsPage;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {
	
	private static final String SEARCH_TERM="Printed Summer Dress";
	private SearchResultPage searchResultPage;
	
	
	@BeforeMethod(description = "User logs into the application and searches for a product")
	public void setup() {

		searchResultPage=homePage.goToLoginPage().doLoginWith("jeweno5149@3dboxer.com", "password123")
				.searchForProduct(SEARCH_TERM);

	}

	@Test(description = "Verify User able to able to buy a product", groups = {"coreFlow"},
			retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class)
	public void checkoutTest() {
		
		//Assert.assertTrue(searchResultPage.isSearchTermPresentInProductList(SEARCH_TERM),
			    //"Search term not present in product list!");

		String result=searchResultPage.ClickOnTheProductAt(1).ChangeSize(L).addToCart().proceedToCheckout()
			.goToConfirmAddressPage().goToShipmentPage().goToPaymentPage().makePaymentByWire();
		
		Assert.assertTrue(result.contains("complete"));


	}

}
