package stepdefinition;


import org.junit.After;
import org.junit.Assert;

import Page.HomePage;
import Page.LoginPage;
import Page.ManageClassespage;
import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageClassesStep extends Base {

	String Createddetails;
	static String addClassString;
	ManageClassespage MCP;
	String Edittopic;
	String ClassTopic;
	LoginPage loginpage;
	HomePage homepage;
	
	public static int before;

//	public ManageClassesStep() {
//		super();
//	}

//	@Before("@Automate,@Classes")
//	public void beforeScenario() {
//		Base.initialize("chrome");
//		MCP = new ManageClassespage();
//		homepage = new HomePage();
//		loginpage = new LoginPage();
//		
//		}
//
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("Admin is on Add tab by clicking on Add Class in Manage Classes page\\(admin)")
	public void admin_is_on_add_tab_by_clicking_on_add_class_in_manage_classes_page_admin() {
		loginpage.loginClick();
		loginpage.signInPage(prop.getProperty("UserName"), prop.getProperty("Password"));
		homepage.clickOnManageAttendance();
		MCP.addclass();
		MCP.AddClassGiven();
	}

	@When("Admin clicks on submit button after enters {string} and {string} and {string} and {string}")
	public void admin_clicks_on_submit_button_after_enters_and_and_and(String ClassTopic, String StaffName,
			String ClassDescrp, String ClassComment) {

		
		addClassString = null;
		addClassString = ClassTopic + " " + StaffName + " " + ClassDescrp + " " + ClassComment;
		MCP.AddClassWhen(ClassTopic, StaffName, ClassDescrp, ClassComment);
	}

	@Then("Created Class will be displayed in Manage Classes Page\\(admin)")
	public void created_class_will_be_displayed_in_manage_classes_page_admin() {

		Createddetails = MCP.AddClassThen();
		Assert.assertEquals(Createddetails, addClassString);
	}

	@Given("Admin is on Edit tab by cliking on Edit icon in Manage Classes page\\(admin)")
	public void admin_is_on_edit_tab_by_cliking_on_edit_icon_in_manage_classes_page_admin() {

		MCP.EditClassGiven();
	}

	@When("Admin clicks on submit button after enters {string} and {string} and {string}")
	public void admin_clicks_on_submit_button_after_enters_and_and(String ClassTopic, String StaffName,
			String ClassDescrp, String ClassComment) {

		MCP.EditClassWhen(ClassTopic, StaffName, ClassDescrp, ClassComment);
	}

	@Then("Updated Class details will be displayed in Manage Classes Page\\(admin)")
	public void updated_class_details_will_be_displayed_in_manage_classes_page_admin() {
   
		Edittopic = MCP.EditClassThen();
		Assert.assertEquals(Edittopic, ClassTopic);
	}

	@Given("Admin is on Manage Classes Page\\(admin) by clicking on Manage Classes tab")
	public void admin_is_on_manage_classes_page_admin_by_clicking_on_manage_classes_tab() {

		int before = MCP.DeleteClassGiven();
		System.out.println("Print " + before);
	}

	@When("Admin clicks on Trash icon of existing Class for particular Batch")
	public void admin_clicks_on_trash_icon_of_existing_class_for_particular_batch() {

		MCP.DeleteClassWhen();
	}

	@Then("Deleted Class will be removed from Manage Classes Page\\(admin)")
	public void deleted_class_will_be_removed_from_manage_classes_page_admin() {

		int after = MCP.DeleteClassThen();
		Assert.assertNotEquals(after, before);
	}

}
