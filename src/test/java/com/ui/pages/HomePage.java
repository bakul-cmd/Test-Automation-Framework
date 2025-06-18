
package com.ui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

import static com.utility.PropertiesUtil.*;
public final class HomePage extends BrowserUtility {
	

	private static final By SIGN_IN_LINK_LOCATOR=By.xpath("//a[contains(text(),'Sign in')]");
	
	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);
		//goToWebsite(readProperty(QA, "URL")); //reading data from .properties file 
		goToWebsite(JSONUtility.readJSON(QA).getUrl()); //reading data from .json file
		
	}
	public HomePage(WebDriver driver) {
		super(driver);
		//goToWebsite(readProperty(QA, "URL")); //reading data from .properties file 
		goToWebsite(JSONUtility.readJSON(QA).getUrl()); //reading data from .json file
		
	}
	

	public LoginPage goToLoginPage() { //Page Function---> can't be void..
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage=new LoginPage(getDriver());
		return loginPage;
	}
	
}
