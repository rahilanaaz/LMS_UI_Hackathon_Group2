package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber.html"},
		monochrome=true,
		features = {"src\\test\\resources\\LMS_Feature"},
		glue= "stepdefinition")


public class JuniteRunner {
	
}
	