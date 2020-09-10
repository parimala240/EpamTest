package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepageobjects {
	
	public WebDriver driver;

	// Define the Constructor and pass the WebDriver instance to it
	public Homepageobjects(WebDriver driver) {
		this.driver = driver;
	}
	
	 @FindBy(xpath="//input[@id='fromCity']")
	 public  WebElement from;
	 
	 @FindBy(id="flying_to_N")
	 public  WebElement to;
	 
	 @FindBy(xpath="//div[@class='DayPicker-Week']/div[(@aria-selected='true')]")
	 public  WebElement date;
	 
	 @FindBy(xpath="//a[text()='Search']")
	 public  WebElement search;
	 
	 @FindBy(xpath="//div[@class='fli-list one-way']")
	 public  List<WebElement> listFilghts;
	 
	 @FindBy(xpath="//ul[@class='react-autosuggest__suggestions-list']/li")
	 public  List<WebElement> places;
	 

	 @FindBy(xpath="//p[contains(text(),'Flights from')]")
	 public  WebElement flightsFrom;
	 
	
	 @FindBy(xpath="//span[@class='rightArrow pushRight']")
	 public  WebElement login;
	 
	 @FindBy(xpath="//input[@id='username']")
	 public  WebElement userid;
	 
	 @FindBy(xpath="//input[@id='otp']")
	 public  WebElement otp;
	 
	 @FindBy(xpath="//*[text()='Continue']")
	 public  WebElement continue1;
	 
	 @FindBy(xpath="//*[text()='Login']")
	 public  WebElement loginbutton;
	 

	 public String flightName="//div[@class='fli-list one-way'][INDEX]//span[@class='airways-name ']";
		                        
	 public String flightCode ="//div[@class='fli-list one-way'][INDEX]//*[@class='fli-code']";
		
	 public String startTime="//div[@class='fli-list one-way'][INDEX]//div[@class='dept-time']";
		
	 public String filghtsTravalDuration="//div[@class='fli-list one-way'][INDEX]//*[@class='reaching-time append_bottom3']";
		
	 public String filghtsCost="//div[@class='fli-list one-way'][INDEX]//*[@class='actual-price']";
		
	 public String view="//div[@class='fli-list one-way'][INDEX]//button[contains(@id,bookbutton-RKEY)]";
	 
	 public String booknow="//div[@class='fli-list one-way'][12]//button[@class='btn fli_primary_btn text-uppercase ']";
	 
	 public String placesSet = "//ul[@class='react-autosuggest__suggestions-list']/li[INDEX]//div/p";
		
		
		
	
}

