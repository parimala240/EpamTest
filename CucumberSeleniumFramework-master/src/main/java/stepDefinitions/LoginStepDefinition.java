package stepDefinitions;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import PageObjects.Homepageobjects;
import Utills.utiliesSelenium;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageTests.FlightClient;
import pageTests.TestBase;

public class LoginStepDefinition extends TestBase{
	public LoginStepDefinition(){
		
	}

	utiliesSelenium utill = new utiliesSelenium();
	public static Logger APPLICATION_LOGS = null;
	
	@Given("^user is already on Login Page\"([^\"]*)\"$")
	public void user_is_already_on_Login_Page_and(String browser) throws Throwable {
	     initConfig();
		initBrowser(browser);
		invokeApplication();
		//APPLICATION_LOGS.info("Browser lanched with URL");
	 }
	
	
	 @When("^title of login page is Free CRM$")
	 public void title_of_login_page_is_free_CRM(){
	 String title = driver.getTitle();
	 System.out.println(title);
	 //APPLICATION_LOGS.info("Titel validation");
	  //Assert.assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday", title);
	 }
	
	
	
	 @Then("^user enters sourceDestination\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	 public void user_enters_sourceDestination_and(String from, String to, String loginPhoneNumber) throws Throwable {
		 try {
		 System.out.println("enter page");
		 Homepageobjects home = PageFactory.initElements(driver, Homepageobjects.class);
		 
		 utill.waitelement(home.from);
		 Thread.sleep(2000);
		//static wait required 
		 try {
		 home.from.click();
		 
		 }catch (Exception e) {
			 try {
				 System.out.println("enter login page");
				 loginentries(loginPhoneNumber,home);
				 Thread.sleep(50000);
			 }catch (Exception e1) {} 
			 utill.waitelement(home.from);
			 home.from.click();
		}
		 
		 int noOfPlaces=home.places.size();
		 for(int i=1;i<=noOfPlaces;i++) {
			if( driver.findElement(By.xpath(home.placesSet.replace("INDEX", String.valueOf(i)))).getText().contains(from)) {
				driver.findElement(By.xpath(home.placesSet.replace("INDEX", String.valueOf(i)))).click();
				break;
			}
		 }
		 //APPLICATION_LOGS.info("From filed enterd and validation");
		 //static wait required 
		 Thread.sleep(2000);
		 for(int i=1;i<=noOfPlaces;i++) {
				if( driver.findElement(By.xpath(home.placesSet.replace("INDEX", String.valueOf(i)))).getText().contains(to)) {
					driver.findElement(By.xpath(home.placesSet.replace("INDEX", String.valueOf(i)))).click();
					break;
				}
			 }
		 //APPLICATION_LOGS.info("TO filed enterd and validation");
		 Thread.sleep(2000);
		 home.date.click();
		 home.search.click();
		 //APPLICATION_LOGS.info("Search Started--");
		 }catch (Exception e) {
			//APPLICATION_LOGS.info(e+"failure at From to selection fields");
			 System.out.println(e+"failure at From to selection fields");
		 }
	 }
	

	 public void loginentries(String loginPhoneNumber, Homepageobjects home) throws InterruptedException {
		 //Homepageobjects home = PageFactory.initElements(driver, Homepageobjects.class);
		 try {
			home.login.click();
			home.userid.sendKeys(loginPhoneNumber);
			home.continue1.click();
			JavascriptExecutor javascript = (JavascriptExecutor) driver;
			javascript.executeScript("alert('Enter otp or else tap on webpage for closeb the login promt');");
			Thread.sleep(20000);
			WebDriverWait wait = new WebDriverWait(driver, 500);
            wait.until(ExpectedConditions.elementToBeClickable(home.loginbutton));
			home.loginbutton.click();
		 }catch (Exception e) {
			//APPLICATION_LOGS.info(e+"failure at login page");
			 System.out.println(e+"failure at login page");
		 }
			
		}


	@And("^user clicks on pageScroll$")
    public void user_clicks_on_pageScroll() throws Throwable {
		 try {
		Homepageobjects home = PageFactory.initElements(driver, Homepageobjects.class);
		 utill.waitelementVisibility(home.flightsFrom, 100);
		 utill. scrollPageEnd();
		 
		 //APPLICATION_LOGS.info("PageScroll donet to collect the List of flights");
		 }catch (Exception e) {
				//APPLICATION_LOGS.info(e+"failure at scroll the flight filter page");
				 System.out.println(e+"failure at sctoll the flight filter page");
			 }
	
	 }
	
	
	
	 
	 @Then("^user filterTheFilght bookNOW$")
	 public void user_filterTheFilght_bookNOW() throws Throwable {
		 
		 FlightClient fclient = new FlightClient(driver);
         fclient.chooseFlight();
         
		}
	 
	

	 @Then("^Close the browser$")
	 public void close_the_browser(){
		 driver.quit();
		 //APPLICATION_LOGS.info("Close the browser");
	 }
	
	
	

}
