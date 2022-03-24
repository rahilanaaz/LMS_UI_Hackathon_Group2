package stepdefinition;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Page.HomePage;
import Page.LoginPage;
import Page.NotificationPage;
import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.Constants;

public class NotificationStep extends Base {

	NotificationPage notificationPg = new NotificationPage();
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
//	
//
//	@Before
//	public void beforeScenario() {
//	driver=initialize("chrome");
//	
//		}
		
	@After
	public void tearDown()
	{
		this.driver.quit();
	}
		
	@Given("Admin is on  Notification page.")
	public void admin_is_on_notification_page() {
		loginpage.loginClick();
		loginpage.signInPage(prop.getProperty("UserName"), prop.getProperty("Password"));
		homepage.clickOnNotifications();
	}
	@When("Admin clicks on submit button after selecting {string} from dropdown and enter details  {string},{string},{string} and {string}")
	public void admin_clicks_on_submit_button_after_selecting_from_dropdown_and_enter_details_and(
			String program_name, String hackathon_name,String hackathon_description, String Hackathon_date,String hackathon_comments)
	{
		notificationPg.sendProgramName(program_name);
		notificationPg.sendHackathonName(hackathon_name);
		notificationPg.sendHackathonDesc(hackathon_description);
		notificationPg.sendHackathonDate(Hackathon_date);
		notificationPg.sendHackathonComments(hackathon_comments);
		notificationPg.clickSubmit();
	}
	@Then("Notifications will be submitted successfully")
	public void notifications_will_be_submitted_successfully() {
		 Assert.assertEquals(notificationPg.getNotification(),Constants.getNotificationSuccessMsg());
    }

}
