package programs;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
//import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import PageObjects.Homepageobjects;
import Utills.Constants;


public class TestBase {

	public static Properties CONFIG = null;
	public static WebDriver driver = null;

	/*
	 * properties file loading 
	 */
	public void initConfig() {
	CONFIG = new Properties();
		try {
			FileInputStream input = new FileInputStream(Constants.PROPERTIES_FILE_PATH);
			// load a properties file
			CONFIG.load(input);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	/*
	 * To initialize the Driver  based on given properties 
	 */
	public void initBrowser(String browser) {
		if (driver == null) {
			if (browser.equalsIgnoreCase("Mozilla")) {
				driver = new FirefoxDriver();				
			}
			else if (browser.equalsIgnoreCase("Safari")) {
				System.setProperty("webdriver.chrome.driver", Constants.SAFARI_DRIVER);
				driver = new SafariDriver();				
			}
			else if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
				driver = new ChromeDriver();				
			}
			else {
				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
				driver = new ChromeDriver();
			}			

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			//APPLICATION_LOGS.info("Browser Initialized");
		} else {
			//APPLICATION_LOGS.debug("WebDriver Instance was avaiable ");

		}
	}

	public void invokeApplication() {
		driver.manage().window().maximize();
		driver.get(CONFIG.getProperty("URL"));
		
	}

	public void closeBrowser() {
		driver.close();
		//APPLICATION_LOGS.info("Browser Closed");
	}

	public void quitDriver() {
		driver.quit();
		//APPLICATION_LOGS.info("All Browser Instance are closed");
	}

	public void takeScreenShot(String fileName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			//FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\screenshots\\" + fileName + ".jpg"));
		} catch (Exception e) {
			//APPLICATION_LOGS.error("Failed to create Screenshot with following exception" + e);
			e.printStackTrace();
		}
	}

	/*
	 * Invoke the browser along with url
	 */
	
	
	
}
