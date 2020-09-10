package stepDefinitions;

import java.util.concurrent.TimeUnit;

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
import programs.FlightClient;
import programs.TestBase;

public class LoginStepDefinition extends TestBase{
	public LoginStepDefinition(){
		
	}

	utiliesSelenium utill = new utiliesSelenium();
	
	@Given("^user is already on Login Page\"([^\"]*)\"$")
	public void user_is_already_on_Login_Page_and(String browser) throws Throwable {
	     initConfig();
		initBrowser(browser);
		invokeApplication();
	 }
	
	
	 @When("^title of login page is Free CRM$")
	 public void title_of_login_page_is_free_CRM(){
	 String title = driver.getTitle();
	 System.out.println(title);
	  //Assert.assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday", title);
	 }
	
	
	
	 @Then("^user enters sourceDestination\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	 public void user_enters_sourceDestination_and(String from, String to, String loginPhoneNumber) throws Throwable {
		 System.out.println("enter------------");
		 Homepageobjects home = PageFactory.initElements(driver, Homepageobjects.class);
		 
		 utill.waitelement(home.from);
		 Thread.sleep(2000);
		//static wait required 
		 try {
		 home.from.click();
		 }catch (Exception e) {
			 try {
				 loginentries(loginPhoneNumber,home);
			 }catch (Exception e1) {} 
		}
		 utill.waitelement(home.from);
		 home.from.click();
		 int noOfPlaces=home.places.size();
		 for(int i=1;i<=noOfPlaces;i++) {
			if( driver.findElement(By.xpath(home.placesSet.replace("INDEX", String.valueOf(i)))).getText().contains(from)) {
				driver.findElement(By.xpath(home.placesSet.replace("INDEX", String.valueOf(i)))).click();
				break;
			}
		 }
		 //static wait required 
		 Thread.sleep(2000);
		 for(int i=1;i<=noOfPlaces;i++) {
				if( driver.findElement(By.xpath(home.placesSet.replace("INDEX", String.valueOf(i)))).getText().contains(to)) {
					driver.findElement(By.xpath(home.placesSet.replace("INDEX", String.valueOf(i)))).click();
					break;
				}
			 }
		 Thread.sleep(2000);
		 home.date.click();
		 home.search.click();
		 
	 }
	

	 public void loginentries(String loginPhoneNumber, Homepageobjects home) throws InterruptedException {
		 //Homepageobjects home = PageFactory.initElements(driver, Homepageobjects.class);
			home.login.click();
			home.userid.sendKeys(loginPhoneNumber);
			home.continue1.click();
			Thread.sleep(5000);
			home.loginbutton.click();
			
		}


	@And("^user clicks on pageScroll$")
    public void user_clicks_on_pageScroll() throws Throwable {
		 
		Homepageobjects home = PageFactory.initElements(driver, Homepageobjects.class);
		 utill.waitelementVisibility(home.flightsFrom, 100);
		 utill. scrollPageEnd();
	
	 }
	
	
	
	 
	 @Then("^user filterTheFilght bookNOW$")
	 public void user_filterTheFilght_bookNOW() throws Throwable {
		 
		 FlightClient fclient = new FlightClient(driver);
         fclient.chooseFlight();
         
		}
	 
	

	 @Then("^Close the browser$")
	 public void close_the_browser(){
		 driver.quit();
	 }
	
	
	

}
