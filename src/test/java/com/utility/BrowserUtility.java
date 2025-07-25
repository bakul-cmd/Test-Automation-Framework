package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); // Instance variable -->Heap memory
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // Initialize the instance variable driver.
		logger.info("Bowser launched");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {
		logger.info("Initializing browser using : " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			logger.error("Invalid Browsername..Please select chrome or edge");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Initializing browser using : " + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			logger.info("Chrome Browser has launched");
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			logger.info("Edge Browser has launched");
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else if (browserName == Browser.EDGE) {
			if (browserName == Browser.EDGE) {
				if (isHeadless) {
					EdgeOptions options = new EdgeOptions();
					options.addArguments("--headless=old");
					options.addArguments("--window-size=1920,1080");

					driver.set(new EdgeDriver(options));
					logger.info("Edge Browser has launched");
					wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
				} else {
					driver.set(new EdgeDriver());
					wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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
					wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
				} else {
					driver.set(new FirefoxDriver());
					wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		logger.info("Clicked on element with locator: " + locator.toString());
	}
	public void clickOnCheckbox(By locator) {
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
		logger.info("Clicked on element with locator: " + locator.toString());
	}

	public void clickOn(WebElement element) {
		
		
		element.click();
		logger.info("Click on Element direct method is revoked.");
	}

	public void enterText(By locator, String textToEnter) {
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(textToEnter);
		logger.info("Entered text into element with locator" + locator.toString());
	}

	public void clearText(By textBoxLocator) {
		//WebElement element = driver.get().findElement(textBoxLocator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
		logger.info("Element found and cleared the text from textbox");
		element.clear();
	}

	public void selectFromDropdown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding element with the locator" + dropDownLocator);
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		select.selectByVisibleText(optionToSelect);
	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
	//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(keyToEnter);
		logger.info(keyToEnter + " key entered into element with locator" + locator.toString());
	}

	public String getVisibleText(By locator) {

		logger.info("Finding the element by locator" + locator);
	   //WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Returning the visible text of the element" + element.toString());
		return element.getText();
	}

	public String getVisibleText(WebElement element) {

		logger.info("Returning the visible text of the element" + element.toString());
		return element.getText();
	}

	public List<String> getAllVisibleText(By locator) {

		logger.info("Getting list of elements by locator" + locator);
		//List<WebElement> elementList = driver.get().findElements(locator);
		List<WebElement> elementList=
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {
			System.out.println(element.getText());
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;
	}

	public List<WebElement> getAllElements(By locator) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return driver.get().findElements(locator);
	}
	
	public void acceptAlert() {
		
		Alert alert=driver.get().switchTo().alert();
		logger.info("Alert Message -"+alert.getText());
		alert.accept();
	}
	
	public boolean isDisplayed(By locator) {
		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		return element.isDisplayed(); 
	}

	public void quit() {
		driver.get().close();
	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
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
