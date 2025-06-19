package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import com.constants.Browser;

public abstract class BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); // Instance variable -->Heap memory

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // Initialize the instance variable driver.
		logger.info("Bowser launched");
	}

	public BrowserUtility(String browserName) {
		logger.info("Initializing browser using : " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			logger.error("Invalid Browsername..Please select chrome or edge");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Initializing browser using : " + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			logger.info("Chrome Browser has launched");
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
			logger.info("Edge Browser has launched");
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());

			logger.info("Firefox Browser has launched");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Initializing browser using : " + browserName);

		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");

				driver.set(new ChromeDriver(options));
				logger.info("Chrome Browser has launched");
			} else {
				driver.set(new ChromeDriver());
			}
		} else if (browserName == Browser.EDGE) {
			if (browserName == Browser.EDGE) {
				if (isHeadless) {
					EdgeOptions options = new EdgeOptions();
					options.addArguments("--headless=old");
					options.addArguments("--window-size=1920,1080");

					driver.set(new EdgeDriver(options));
					logger.info("Edge Browser has launched");
				} else {
					driver.set(new EdgeDriver());
				}

				logger.info("Edge Browser has launched");
			}
		} else if (browserName == Browser.FIREFOX) {
			if (browserName == Browser.FIREFOX) {
				if (isHeadless) {
					FirefoxOptions options = new FirefoxOptions();
					options.addArguments("--headless");
					options.addArguments("--window-size=1920,1080");

					driver.set(new FirefoxDriver(options));
					logger.info("Firefox Browser has launched");
				} else {
					driver.set(new FirefoxDriver());
				}

			}
		}
	}

	public void goToWebsite(String url) {
		driver.get().get(url);
		logger.info("Visiting " + url);
	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();
		logger.info("Maximized the window");
	}

	public void clickOn(By locator) {
		WebElement element = driver.get().findElement(locator);
		element.click();
		logger.info("Clicked on element with locator: " + locator.toString());
	}

	public void enterText(By locator, String textToEnter) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(textToEnter);
		logger.info("Entered text into element with locator" + locator.toString());
	}
	
	public void clearText(By textBoxLocator) {
		WebElement element = driver.get().findElement(textBoxLocator);

		logger.info("Element found and cleared the text from textbox");
		
		element.clear();
	}
	
	public void selectFromDropdown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding element with the locator"+dropDownLocator);
		WebElement element=driver.get().findElement(dropDownLocator);
		Select select=new Select(element);
		select.selectByVisibleText(optionToSelect);
	}
	public void enterSpecialKey(By locator, Keys keyToEnter) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(keyToEnter);
		logger.info(keyToEnter+" key entered into element with locator" + locator.toString());
	}

	public String getVisibleText(By locator) {
		
		logger.info("Finding the element by locator"+locator);
		WebElement element = driver.get().findElement(locator);
		
		logger.info("Returning the visible text of the element"+element.toString());
		return element.getText();
	}
	public String getVisibleText(WebElement element) {
		
		logger.info("Returning the visible text of the element"+element.toString());
		return element.getText();
	}
	
	public List<String> getAllVisibleText(By locator) {
		
		logger.info("Getting list of elements by locator"+locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		
		List<String> visibleTextList=new ArrayList<String>();
		for( WebElement element: elementList) {
			System.out.println(element.getText());
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;
	}

	public void quit() {
		driver.get().close();
	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshot/" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return path;
	}

}
