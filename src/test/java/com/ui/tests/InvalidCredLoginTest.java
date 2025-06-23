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
public class InvalidCredLoginTest extends TestBase {
	
	private static final String INVALID_EMAIL="bakulkarmakar@gmail.com";
	private static final String INVALID_PASSWORD="password1234";
	
	
	
	@Test(enabled=true,description="Verifies with the Invalid user to get proper error message" , groups = {"coreFlow"})
	public void loginTest(){
		
		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL, INVALID_PASSWORD).
				getErrorMessage(),"Authentication failed.");				
	}
	
}


