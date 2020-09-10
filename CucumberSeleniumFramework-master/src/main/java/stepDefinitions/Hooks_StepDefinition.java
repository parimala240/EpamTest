package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Hooks_StepDefinition {
	
@Before
public void setUP(){
	System.out.println("launch FF");
	System.out.println("Enter URL for MakeMyTrip");
}

@After
public void tearDown(){
	System.out.println("close the browser");
}



}