package Utills;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Homepageobjects;
import programs.TestBase;

public class utiliesSelenium extends TestBase {
	
	public void waitelement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		 wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void waitelementVisibility(WebElement ele,long time) {
		WebDriverWait wait = new WebDriverWait (driver, time);
		 wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void scrollPageEnd() throws InterruptedException {
		int scroll_count=1; 
		 do {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 try {
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			} catch (Exception e) {}
			    Thread.sleep(500);
			    scroll_count++;
			} while(scroll_count<20);	
	}
	
	public void javaScriptClick(WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",ele);
	}

}
