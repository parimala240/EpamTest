package MyRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	
	@CucumberOptions(
			features = "src/main/java/Features",
			glue = "stepDefinitions",
			//plugin= {"pretty"},
			plugin ="json:target/cucumber-reports/CucumberTestReport.json",
			monochrome=true,
			tags= {"@chrome"},
			dryRun =false)
					 
	        /*features = "src/main/java/Features",
	        glue = {"stepDefinitions"},
	        tags = {"~@Ignore"},
	        format = {
	                "pretty",
	                "html:target/cucumber-reports/cucumber-pretty",
	                "json:target/cucumber-reports/CucumberTestReport.json",
	                "rerun:target/cucumber-reports/rerun.txt"
	        },plugin ="json:target/cucumber-reports/CucumberTestReport.json")*/

	
	public class TestRunner {
	 
	}
	
	//ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
	//ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest
	

