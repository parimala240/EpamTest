package programs;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Homepageobjects;
import Utills.utiliesSelenium;

public class FlightClient {
	public WebDriver driver=null;
	
	public FlightClient(WebDriver driver){
		this.driver=driver;
	}
	utiliesSelenium utill = new utiliesSelenium();
	public static Logger APPLICATION_LOGS = null;
	
	/*
	 * Getting all flight details and create listObjects
	 * Book the flight based on filtered details of flight requirements 
	 */
	public  void chooseFlight() throws InterruptedException {
		
		Homepageobjects home = PageFactory.initElements(driver, Homepageobjects.class);
		
		int size =home.listFilghts.size();
		List<FlightDetails> flightDetailsList = new ArrayList<FlightDetails>();
		
		//getting all flight details and create listObjects
		for(int i=1;i<=size;i++) {
		WebElement flightNamex = driver.findElement(By.xpath(home.flightName.replace("INDEX",String.valueOf(i))));
		WebElement startTimex = driver.findElement(By.xpath(home.startTime.replace("INDEX",String.valueOf(i))));
		WebElement endTimex = driver.findElement(By.xpath(home.filghtsTravalDuration.replace("INDEX",String.valueOf(i))));
		WebElement filghtsCostx = driver.findElement(By.xpath(home.filghtsCost.replace("INDEX",String.valueOf(i))));
		WebElement filghtsCode = driver.findElement(By.xpath(home.flightCode.replace("INDEX",String.valueOf(i))));
		
		int filghtsTravalDurationx;
		try {
		 filghtsTravalDurationx =
		Integer.parseInt(startTimex.getText().replace(":", ""))-Integer.parseInt(endTimex.getText().replace(":", ""));
		System.out.println(flightNamex.getText()+""+startTimex.getText()+""+filghtsTravalDurationx+""+filghtsCostx.getText());
		}catch(Exception e) {
			filghtsTravalDurationx =
					Integer.parseInt(startTimex.getText().replace(":", ""))-Integer.parseInt(endTimex.getText().split("\\+")[0].replace(":", ""));
					System.out.println(flightNamex.getText()+""+startTimex.getText()+""+filghtsTravalDurationx+""+filghtsCostx.getText());
		}
				
		flightDetailsList.add(new FlightDetails(flightNamex.getText(), startTimex.getText(), filghtsTravalDurationx, filghtsCostx.getText(),filghtsCode.getText()));
		
		}
		 APPLICATION_LOGS.info("List of objects created with flight details");
		//get the value of flight code based on required filters 
		String flightCode1=filterFlightDetails(flightDetailsList);
		 APPLICATION_LOGS.info("Filterd flight details code"+flightCode1);
		
		// book the filtered flight 
		for(int i=1;i<=size;i++) {
			
			WebElement filghtsCode = driver.findElement(By.xpath(home.flightCode.replace("INDEX",String.valueOf(i))));
			
			if(filghtsCode.getText().equals(flightCode1)) {
				
				utill.javaScriptClick(driver.findElement(By.xpath(home.view.replace("INDEX",String.valueOf(i)))));
				utill.javaScriptClick(driver.findElement(By.xpath(home.booknow.replace("INDEX",String.valueOf(i)))));
				APPLICATION_LOGS.info("Filght booking done");
				break;
				
			}
		
		}

	}
	/*
	 *  Filter the list of objects based on cost and time of flight 
	 */
	public String filterFlightDetails(List<FlightDetails> flightDetailsList) {
		int totalTimeTaken = flightDetailsList.stream()
				.min(Comparator.comparing(FlightDetails::getfilghtsTravalDuration)).get().getfilghtsTravalDuration();

		
		List<FlightDetails> collect = flightDetailsList.stream()
				.filter(x -> x.getfilghtsTravalDuration()==totalTimeTaken)
				.collect(Collectors.toList());
		String price = collect.stream()
				.min(Comparator.comparing(FlightDetails::getPrice)).get().getPrice();
		List<FlightDetails> collect1 = collect.stream().filter(x -> x.getPrice().equals(price))
				.collect(Collectors.toList());
		System.out.println(collect1);
		
		String flightName1;
		if(collect1.size() > 1){
			String dep = collect1.stream().min(Comparator.comparing(FlightDetails::getStartTime)).get().getStartTime();
			flightName1 = collect1.stream().filter(x->x.getStartTime().equals(dep)).findFirst().get().getFlightName();
		}
		flightName1 = collect1.get(0).getFlightName();
		
		String flightCode1;
		if(collect1.size() > 1){
			String dep = collect1.stream().min(Comparator.comparing(FlightDetails::getStartTime)).get().getStartTime();
			flightCode1 = collect1.stream().filter(x->x.getStartTime().equals(dep)).findFirst().get().getfilghtsCode();
		}
		flightCode1 = collect1.get(0).getfilghtsCode();
		
		return flightCode1;
	}
}
