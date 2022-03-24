package stepdefinition;



import org.junit.After;

import Page.HomePage;
import Page.LoginPage;
import Page.UserAssignmentPage;
import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserAssignmentSteps extends Base {

	UserAssignmentPage userAssignPg = new UserAssignmentPage();
	LoginPage loginpage;
	HomePage homepage;
//
//	@Before
//	public void setup() {
//		Base.initialize("chrome");
//		
//		
//	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("User is on Manage Submissions\\(user) page to submit assignment")
	public void user_is_on_manage_submissions_user_page_to_submit_assignment() {
		loginpage.loginClick();
		loginpage.signInPage(prop.getProperty("UserName"), prop.getProperty("Password"));
		userAssignPg.manageAssignmentsUser();
		userAssignPg.addAssignmentbtUser();

	}

	@When("User clicks on submit button after selecting Batch,Assignment Name,Assignment Date ,add comments")
	public void user_clicks_on_submit_button_after_selecting_batch_assignment_name_assignment_date_add_comments() {
		userAssignPg.addAssignmentsUser("String1", "String2", "String3", "String4", "String5");
	}

	@Then("Assignment will be submitted succesfully")
	public void assignment_will_be_submitted_succesfully() {
		userAssignPg.assertAddAssignmentsUser();

	}

	@Given("User is on Manage Submissions\\(user) page to edit submitted assignment")
	public void user_is_on_manage_submissions_user_page_to_edit_submitted_assignment() {
		userAssignPg.manageAssignmentsUser();
		userAssignPg.editAssignmentbtUser();

	}

	@When("User clicks on submit button after clicking on Edit icon to edit the required details")
	public void user_clicks_on_submit_button_after_clicking_on_edit_icon_to_edit_the_required_details() {
		userAssignPg.editAssignmentsUser("String1", "String2");

	}

	@Then("Updated Assignment will be submitted successfully")
	public void updated_assignment_will_be_submitted_successfully() {
		userAssignPg.assertEditAssignmentsUser();

	}

	@Given("User is on Manage Submissions\\(user) page to delete submitted assignment")
	public void user_is_on_manage_submissions_user_page_to_delete_submitted_assignment() {
		userAssignPg.manageAssignmentsUser();

	}

	@When("User clicks on Trash icon after the assignment")
	public void user_clicks_on_trash_icon_after_the_assignment() {
		userAssignPg.deleteAssignUser();
	}

	@Then("Assignment will be deleted successfully")
	public void assignment_will_be_deleted_successfully() {
		userAssignPg.assertDeleteAssignmentsUser();
		
	}


}
