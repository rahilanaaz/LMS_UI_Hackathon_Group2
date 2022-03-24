package testrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
		features = "src\\test\\resources\\LMS_Feature", 
		glue = { "stepdefinition"},

		plugin ={"json:target/cucumber-reports/CucumberTestReport.json",
		"pretty",
		"html:target/cucumber-reports/cucumber-pretty",
		"rerun:target/cucumber-reports/rerun.txt"})

public class ExtentTestNG extends AbstractTestNGCucumberTests {
	private TestNGCucumberRunner testNgCucumberRunner;
	public final static ThreadLocal<String> BROWSER = new ThreadLocal<>();

	
    
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		if(testNgCucumberRunner == null)
		testNgCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@BeforeTest
	@Parameters("browserName") 
    public void defineBrowser(String browserName) {
        //put browser value to thread-safe container
        ExtentTestNG.BROWSER.set(browserName);
        System.out.println(browserName);
    }
	
	
	
	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void runScenario(PickleWrapper pickleWrapper) throws Throwable {
		// the 'featureWrapper' parameter solely exists to display the feature file in a
		// test report
		testNgCucumberRunner.runScenario(pickleWrapper.getPickle());
	}

	@DataProvider
	  public Object[][] scenarios()
	{
		if (testNgCucumberRunner == null) {
			testNgCucumberRunner = new TestNGCucumberRunner(this.getClass());
		}
		return testNgCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		testNgCucumberRunner.finish();
	}

}
