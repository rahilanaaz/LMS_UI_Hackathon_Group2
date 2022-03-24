package stepdefinition;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

import org.junit.After;

import Page.HomePage;
import Page.LaunchWebsitePage;
import Page.LoginPage;
import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.Constants;

public class LoginStep extends Base {
	
	LoginPage loginPage = new LoginPage();
	LaunchWebsitePage launchPage = new LaunchWebsitePage();
	HomePage homePageObject = new HomePage();
	String GetTitle;
	//String reqUrl;
	String login;
	String launchpage;
	String homePage;
	
//	@Before
//	public void setup() {
//		WebDriver driver=initialize("chrome");
//		
//	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
		//@LoginPageValidation
		@Given("Admin or User is on LMS website page")
		public void admin_or_user_is_on_LMS_web_page() {
		    // Write code here that turns the phrase above into concrete actions
					
		    System.out.println("LMS:UI LMS website is viewed");
		}
		
		@When("Admin or User clicks Login Hyperlink")
		public void admin_or_user_clicks_login_hyperlink() {
		    // Write code here that turns the phrase above into concrete actions
			loginPage.loginClick();
			
		    System.out.println("LMSUI: when user clicks login HyperLink");
		}
		@Then("Admin or User lands on LoginPage.")
		public void admin_or_user_lands_on_login_page() {
		    // Write code here that turns the phrase above into concrete actions
			//assert login page here
			login =loginPage.getpresentUrl();
			
			assertEquals(login, prop.getProperty("loginpage"));
			
		    System.out.println("navaigated to LMS website");
		   
		}
			
		//@SubmitButton-PostiveScenario -use then of @loginpagevalidation as given here
		@Given("Admin or User is on Loginpage")
		public void admin_or_user_is_on_login_page() {
		    // Write code here that turns the phrase above into concrete actions
			System.out.println("LMS:UI Admin or User is on login Page");
		}
		
		@When("Admin or User enters (.*), (.*) clicks Login Button")
		public void admin_or_user_enters_user_name_password_clicks_login_button(String UserName, String Password) {
		    // Write code here that turns the phrase above into concrete actions
			GetTitle = loginPage.signInPage(UserName, Password);
			
		   System.out.println("LmsUI: admin or user enter username , password ,clicks Login Button");
		}

		@Then("Admin or User is navigated to Home Page.")
		public void admin_or_user_is_navigated_to_home_page() {
		    // Write code here that turns the phrase above into concrete actions
			assertEquals(true,loginPage.isLogoutDisplayed()); 
			
			assertEquals(GetTitle, Constants.getHomePageConstant());
			
			//assertEquals(loginPage.getpresentUrl(), prop.getProperty("homepage"));
			
		   System.out.println("LmsUI: admin or user is navigated to Home page");
		}
		
		//@SubmitButton-NegativeScenario
		
		//Given Admin or User is on Loginpage -Negative case
			@Given("Admin or User is on LoginPage")
			public void admin_or_user_is_on_login_Page() {
				
				
			    // Write code here that turns the phrase above into concrete actions
			   System.out.println("LmsUI: admin or user is on Login page");
			}
		
		@When("Admin or User enters (.*), (.*), clicks Login Button")
		public void admin_or_user_enters_invalid_user_name_invalid_password_clicks_login_button(String InvalidUserName ,String InvalidPassword) {
		    // Write code here that turns the phrase above into concrete actions
			loginPage.signInPage(InvalidUserName, InvalidPassword);
			
		   System.out.println("LmsUI: admin or user enters invalid username and password");
		}

		@Then("Admin or User is shown error message on same login page.")
		public void admin_or_user_is_shown_error_message_on_same_login_page() {
		    // Write code here that turns the phrase above into concrete actions
			
			assertEquals(false,loginPage.isLogoutDisplayed()); 
			
			assertNotEquals(loginPage.getpresentUrl(), prop.getProperty("homepage"));
			
			assertNotNull(loginPage.getInvalidCredentialErrorMessage());
			
			
			assertNotEquals(GetTitle, Constants.getAnswerSecurityPage());
			
			System.out.println("LmsUI:invalid credentials error message is shown");
		}
		
}
