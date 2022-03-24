package stepdefinition;

import org.junit.After;
import org.testng.Assert;

import Page.HomePage;
import Page.ManageUsersPage;
import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersSteps extends Base {

	String UserName;
	String Email;
	String Batch;
	String Skill;
	String Program;


	HomePage homePage;
	ManageUsersPage manageUsrPage;
	public static int before;

//	UsersSteps() {
//
//		super();
//
//	}
//
//	@Before ("@Automate,@Users")
//	public void setUp() {
//
//		driver = initialize("chrome");
//		manageUsrPage = new ManageUsersPage();
//		homePage = new HomePage();
//		
//		// homePage.clickOnUsers();
//	}

	@After
	public void tearDown() {

		driver.quit();

	} 

	@Given("Admin is on LMS Admin User Page, after clicking on User link")
	public void admin_is_on_lms_admin_user_page() {

		homePage.clickOnUsers();

	}


	@When("Admin clicks on search button after entering  \"(.*)\" or \"(.*)\" or \"(.*)\" or \"(.*)\"")
	public void admin_clicks_on_search_button_after_entering_email_or_batch_or_skill_or_program(String email,
			String batch, String skill, String program) {

		Email = email;
		Batch = batch;
		Skill = skill;
		Program = program;

		manageUsrPage.clickOnbtnSearch(email, batch, skill, program);
	}

	@Then("Admin will be navigated to Manage users\\(admin) page and Registered User list will be displayed.")
	public void admin_will_be_navigated_to_manage_users_admin_page_and_registered_user_list_will_be_displayed() {

		driver.navigate().to("https://www.LMS-UI.com/regUsrList");

		Assert.assertEquals(manageUsrPage.registeredEmail().equals(Email)
				|| manageUsrPage.registeredBatch().equals(Batch) || manageUsrPage.registeredSkill().equals(Skill)
				|| manageUsrPage.registeredProgram().equals(Program), true);

	}

	@Given("Admin is on Manage users\\(admin) page, Registered User list")
	public void admin_is_on_manage_users_admin_page_registered_user_list() {

		manageUsrPage.clickOnBtnRegUser();
	}

	@When("Admin clicks on edit icon, admin will be navigated to Manage users\\(admin) page")
	public void admin_clicks_on_edit_icon_admin_will_be_navigated_to_manage_users_admin_page() {

		manageUsrPage.clickOnEditIcon();

		
	}

	@Then("Admin able to edit User details like {string} and {string} and {string} and\"<Program>\"")
	public void admin_able_to_edit_user_details_like_time_zone_user_role_batch_program(String timeZomne,
			String userRole, String batch, String program) {

		manageUsrPage.editUsrDetails(timeZomne, userRole, batch, program);
	}

//	@Given("Admin is on Manage users\\(admin) page, Registered Users list")
//	public void admin_is_on_manage_users_admin_page_regitered_users_list() {
//
//		homePage.clickOnUsers();
//	}

	@When("Admin clicks on trash icon of particular registered user")
	public void admin_clicks_on_trash_icon_of_particular_registered_user() {

		before = manageUsrPage.getUserCount();
		manageUsrPage.clickOnLastTrashIcon();

	}

	@Then("Deleted registered user will be removed from Registered users list")
	public void deleted_registered_user_will_be_removed_from_registered_users_list() {

		int after = manageUsrPage.getUserCount();
		Assert.assertNotEquals(after, before);
	}

	@Given("Admin is on Manage users\\(admin) page, Registered Users list")
	public void admin_is_on_manage_users_admin_page_registered_users_list() {

		homePage.clickOnUsers();
	}

	@When("Admin clicks on eye icon for particular user")
	public void admin_clicks_on_eye_icon_for_particular_user() {

		manageUsrPage.clickOnEyeIcon();

	}

	@Then("Admin will be navigated to Admin Manage user page, view the User details only in read only format")
	public void admin_will_be_navigated_to_admin_manage_user_page_view_the_user_details_only_in_read_only_format() {

		// driver.navigate().to("https://www.LMS-UI.com/manageUsrPage");

		Assert.assertEquals(manageUsrPage.registeredEmail() != null && manageUsrPage.registeredFname() != null
				&& manageUsrPage.registeredLname() != null && manageUsrPage.registeredPhNum() != null
				&& manageUsrPage.registeredLocation() != null && manageUsrPage.registeredLinkedUrl() != null
				&& manageUsrPage.registeredUgPrg() != null && manageUsrPage.registeredPgProg() != null
				&& manageUsrPage.registeredSkill() != null && manageUsrPage.registeredMonthsExperience() != null
				&& manageUsrPage.registeredComments() != null, true);
	}

	@Given("Admin is on LMS Admin User Page")
	public void admin_is_on_lMS_admin_user_page() {

		homePage.clickOnUsers();
	}

	@When("Admin clicks on New Unassigned User hyperlink")
	public void admin_clicks_on_new_unassigned_user_hyperlink() {

		manageUsrPage.clickOnNewUnassignedUserHyperlink();

	}

	@Then("Admin will be navigated to  Manage user\\(admin) page, Unregistered User list will be displayed")
	public void admin_will_be_navigated_to_manage_user_admin_page_unregistered_user_list_will_be_displayed() {

		Assert.assertEquals(manageUsrPage.UnregisteredUserCount() >= 0, true);

	}

	@Given("Admin is on  Manage user\\(admin) page, Unregistered User list")
	public void admin_is_on_manage_user_admin_page_unregistered_user_list() {

		manageUsrPage.clickOnNewUnassignedUserHyperlink();
	}

	@When("Admin clicks on edit icon of particular unregistered user, admin will be navigated to manage users\\(admin) page")
	public void admin_clicks_on_edit_icon_of_particular_unregistered_user_admin_will_be_navigated_to_manage_users_admin_page() {

		manageUsrPage.clickOnEditIconUnregisteredUser();
		
	}

	@Then("Admin will be able to edit User details like {string} and {string} and {string} and {string}")
	// @Then("Admin will be able to edit User details like Time zone, User role
	// batch, Program, save")
	public void admin_will_clicks_on_save_button_after_entering_the_time_zone_user_role_batch_program(String timeZomne,
			String userRole, String batch, String program) {

		manageUsrPage.editUsrDetails(timeZomne, userRole, batch, program);

	}

	@Given("Admin is on  Manage user(admin) page, Unregistered User list after clicking on Unregistered Users Button")
	public void admin_is_on_manage_user_admin_page_unregsred_user_list() {

		manageUsrPage.clickOnNewUnassignedUserHyperlink();
	}

	@When("Admin clicks on trash icon of particular unregistered user")
	public void admin_clicks_on_trash_icon_of_particular_unregistered_user() {

		manageUsrPage.clickOnTrashIconUnregistered();
	}

	@Then("Deleted unregistered user will be removed from Unregistered users list")
	public void deleted_unregistered_user_will_be_removed_from_unregistered_users_list() {

		int after = manageUsrPage.getUserCount();
		Assert.assertNotEquals(after, before);

		
	}

}
