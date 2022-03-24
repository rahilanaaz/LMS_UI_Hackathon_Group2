package stepdefinition;


import static org.testng.Assert.assertEquals;

import org.junit.After;
import org.openqa.selenium.WebDriver;

import Page.LaunchWebsitePage;
import base.Base;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testrunner.ExtentTestNG;

public class LaunchStep extends Base{
	
		
		LaunchWebsitePage launchPage = new LaunchWebsitePage();
		WebDriver driver;
		String currentBrowser;
		
		
		@Before
		
		public void setup() {
			String browserName = ExtentTestNG.BROWSER.get();
			driver=initialize(browserName);
		}
		
		@After
		public void tearDown()
		{
			driver.quit();
		}
		
		//@openLMSWebsite
				@Given("Admin or User is on webBrowser")
				public void admin_or_user_is_on_web_browser() {
				    // Write code here that turns the phrase above into concrete actions
					System.out.println("LMS:UI google chrome browser opens");
				}

				@When("Admin or User enters LMS website url")
				public void admin_or_user_enters_lms_website_url() {
				    // Write code here that turns the phrase above into concrete actions
					
				    System.out.println("LMSUI: entered LMS website url");
				}
				@Then("Admin or User is on LMS Website page")
				public void admin_or_user_is_on_lms_website_page() {
				    // Write code here that turns the phrase above into concrete actions
				//assert lms website here
					currentBrowser =launchPage.LaunchUrl();
					//assertEquals(currentBrowser, url);
					
					assertEquals(true, launchPage.isLoginDisplayed());
					
					System.out.println("LMSUI: Admin or user is on LMS website page");
				}

}

