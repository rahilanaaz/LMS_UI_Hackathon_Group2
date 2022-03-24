package stepdefinition;

import org.junit.After;
import org.testng.Assert;

import Page.HomePage;
import Page.LoginPage;
import Page.ProgramPage;
import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramStep extends Base {

		
		String sizeOfProgNameBefore;
		String sizeOfProgDescBefore;
		String sizeOfProgStatusBefore;
		String sizeOfCreatedTimeBefore;
		String sizeOfModifiedTimeBefore;
		String programName;
		String programDesc;
		String programStatus;
		String updProgName;
		String updProgDesc;
		String updProgStatus;
		
		LoginPage loginpage;
		HomePage homePage;
		ProgramPage manageProgPage;
		
//		public ProgramStep(){
//						super();
//		}
//		
//		@Before("@Automate,@Program")
//		public void setUp() {
//			
//			initialize("chrome");
//			manageProgPage = new ProgramPage();
//			homePage = new HomePage();
//			loginpage.loginClick();
//			loginpage.signInPage(prop.getProperty("UserName"), prop.getProperty("Password"));
//			
//		}
		
		@After
		public void tearDown() {
			
			driver.quit();
		}
		
	@Given("Admin is on Add tab in Add\\/Edit Programs page by clicking Add Program in Manage Programs Page\\(admin)")
	public void admin_is_on_add_tab_in_add_edit_programs_page_by_clicking_add_program_in_manage_programs_page_admin() {
		loginpage.loginClick();
		loginpage.signInPage(prop.getProperty("UserName"), prop.getProperty("Password"));
		manageProgPage.clickOnAddProgramBtn();
		
	}
	@When("Admin clicks on submit button after entering the \"(.*)\" and \"(.*)\" and \"(.*)\"")
	public void admin_clicks_on_submit_button_after_entering_the_program_name_and_program_description_and_program_status(String progName,String progDesc, String progStatus) {
		
	   programName = progName;
	   programDesc = progDesc;
	   programStatus = progStatus;
	   manageProgPage.addProgram(progName, progDesc, progStatus);
		
	}
	@Then("All the program details will be added to Programs List in Manage Programs Page\\(admin) with auto generated same ProgramCreationtime and ProgramModifiedtime in   MM\\/DD\\/YY HH:MM format")
	public void all_the_program_details_will_be_added_to_programs_list_in_manage_programs_page_admin_with_auto_generated_same_program_creationtime_and_program_modifiedtime_in_mm_dd_yy_hh_mm_format() {
		Assert.assertEquals(manageProgPage.newAddedProgName(), programName);
		Assert.assertEquals(manageProgPage.newAddedProgDesc(), programDesc);
		Assert.assertEquals(manageProgPage.newAddedProgStatus(), programStatus);
		Assert.assertNotNull(manageProgPage.newAddedProgCreationTime());
		Assert.assertNotNull(manageProgPage.newAddedProgModifiedTime());
		Assert.assertEquals(manageProgPage.newAddedProgCreationTime(), manageProgPage.newAddedProgModifiedTime());
		
	}
	@Given("Admin is on Edit tab in Add\\/Edit Programs page by clicking Edit icon in Manage Programs Page\\(admin)")
	public void admin_is_on_edit_tab_in_add_edit_programs_page_by_clicking_edit_icon_in_manage_programs_page_admin() {
		manageProgPage.clickOnEditIconLink();
	}
	@When("Admin clicks on submit button after updating the required fields like \"(.*)\" and \"(.*)\" and \"(.*)\"")
	public void admin_clicks_on_submit_button_after_updating_the_required_fields_like_program_name_program_description_program_status(String progName, String progDesc, String progStatus) {
		updProgName = progName;
		updProgDesc = progDesc;
		updProgStatus = progStatus;
		
		manageProgPage.editProgram(progName, progDesc, progStatus);
	}
	@Then("All the updated program details will be added to Programs List in Manage Programs Page\\(admin) with auto generated same ProgramCreationtime and modified Programtime MM\\/DD\\/YY HH:MM format")
	public void all_the_updated_program_details_will_be_added_to_programs_list_in_manage_programs_page_admin_with_auto_generated_same_program_creationtime_and_modified_programtime_mm_dd_yy_hh_mm_format() {
		Assert.assertEquals(manageProgPage.updatedProgName(), updProgName);
		Assert.assertEquals(manageProgPage.updatesProgDesc(), updProgDesc);
		Assert.assertEquals(manageProgPage.updatedProgStatus(), updProgStatus);
		
	}
	@Given("Admin is on Manage Programs Page\\(admin) after clicking on Programs Tab")
	public void admin_is_on_manage_programs_page_admin_after_clicking_on_programs_tab() {
		homePage.clickOnPrograms();
		
		sizeOfProgNameBefore = manageProgPage.ProgNameListSize();
		sizeOfProgDescBefore = manageProgPage.ProgDescListSize();
		sizeOfProgStatusBefore = manageProgPage.ProgStatusListSize();
		sizeOfCreatedTimeBefore = manageProgPage.ProgCreationTimeListSize();
		sizeOfModifiedTimeBefore = manageProgPage.ProgModifiedTimeListSize();
		
	}
	@When("Admin clicks on Trash icon for any program in Programs List")
	public void admin_clicks_on_trash_icon_for_any_program_in_programs_list() {
		manageProgPage.deleteProgram();
	}
	@Then("Program will be deleted from the Programs List in Manage Programs Page\\(admin)")
	public void program_will_be_deleted_from_the_programs_list_in_manage_programs_page_admin() {
		String sizeOfProgNameAfter = manageProgPage.ProgNameListSize();
		String sizeOfProgDescAfter = manageProgPage.ProgDescListSize();
		String sizeOfProgStatusAfter = manageProgPage.ProgStatusListSize();
		String sizeOfCreatedTimeAfter = manageProgPage.ProgCreationTimeListSize();
		String sizeOfModifiedTimeAfter = manageProgPage.ProgModifiedTimeListSize();
		
		Assert.assertNotEquals(sizeOfProgNameAfter, sizeOfProgNameBefore);
		Assert.assertNotEquals(sizeOfProgDescAfter, sizeOfProgDescBefore);
		Assert.assertNotEquals(sizeOfProgStatusAfter, sizeOfProgStatusBefore);
		Assert.assertNotEquals(sizeOfCreatedTimeAfter, sizeOfCreatedTimeBefore);
		Assert.assertNotEquals(sizeOfModifiedTimeAfter, sizeOfModifiedTimeBefore);
	}

}
