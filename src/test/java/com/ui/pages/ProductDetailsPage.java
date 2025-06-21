package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;



public class ProductDetailsPage extends BrowserUtility {
	
	private static final By SIZE_DROP_DOWN_LOCATOR= By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_LOCATOR=By.name("Submit");
	private static final By PROCEED_TO_CHECKOUT_LOCATOR=By.xpath("//a[@title='Proceed to checkout']");
	


	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ProductDetailsPage ChangeSize(Size size) {
		
		selectFromDropdown(SIZE_DROP_DOWN_LOCATOR, size.toString());
		return new ProductDetailsPage(getDriver());
	}
	
	public ProductDetailsPage addToCart() {
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailsPage(getDriver());
	}
	
	public ShoppingCartPage proceedToCheckout() {
		clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
		return new ShoppingCartPage(getDriver());
	}

}
