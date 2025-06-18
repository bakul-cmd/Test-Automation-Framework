package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pojo.User;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase {
	
	
	@Test(enabled=false,description="Verifies with the valid user able to login with JSON file" , groups = {"e2e","sanity"}, 
			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class, dataProvider="LoginTestDataProvider")
	public void loginTest(User user){
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Bakul Karmakar");
	}
	@Test(enabled=false,description="Verifies with the valid user able to login with CSV data" , groups = {"e2e","sanity"}, 
			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class, dataProvider="LoginTestCSVDataProvider")
	public void loginCSVTest(User user){
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Bakul Karmakar");
	}
	@Test(description="Verifies with the valid user able to login with Excel data" , groups = {"e2e","sanity"}, 
			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class, dataProvider="LoginTestExcelDataProvider",
			retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user){
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Bakul Karmakar");
		
		
	
		
	}

}
