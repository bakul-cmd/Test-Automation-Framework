package com.ui.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {
	private static final By USER_NAME_LOCATOR=By.xpath("//a[@title=\"View my customer account\"]/span");
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	
	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);
	}

}
