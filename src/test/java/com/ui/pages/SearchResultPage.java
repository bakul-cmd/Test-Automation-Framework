package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {
	
	private static final By PRODUCT_LISTING_TITLE_LOCATOR=By.xpath("//span[@class='lighter']");
	private static final By ALL_PRODUCT_LIST_NAME_LOCATOR=By.xpath("//h5[@itemprop='name']/a");

	public SearchResultPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getSearchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}
	
	public boolean  isSearchTermPresentInProductList(String searchTerm) {
	    List<String>keyword=Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNamesList=getAllVisibleText(ALL_PRODUCT_LIST_NAME_LOCATOR);
		boolean result=productNamesList.stream()
		.anyMatch(name -> (keyword.stream().anyMatch(name.toLowerCase()::contains)));
		
		return result;
	}
	
	public ProductDetailsPage ClickOnTheProductAt(int index) {


	    clickOn(getAllElements(ALL_PRODUCT_LIST_NAME_LOCATOR).get(index));
	    ProductDetailsPage productDetailPage=new ProductDetailsPage(getDriver());
	    return productDetailPage;
	}


	

}
