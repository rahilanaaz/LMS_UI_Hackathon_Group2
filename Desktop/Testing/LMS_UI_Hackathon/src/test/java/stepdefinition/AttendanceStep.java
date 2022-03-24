package stepdefinition;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Page.AttendancePage;
import Page.HomePage;
import Page.LoginPage;
import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AttendanceStep  extends Base {
	
	LoginPage loginpage = new LoginPage();
	HomePage homepage = new HomePage();
	AttendancePage AttendancePg;
	WebDriver driver;
//	
//	public AttendanceStep() {
//		super();
//			
//	}
//	
//	@Before
//	public void setUp(String browserName)
//	//public void setUp()
//	{
//		initialize(browserName);
//		//initialize("chrome");
//		System.out.println("inside attendance");
//		//****Code for signin
//	}
//	
//	@Before("@Automate,@Attendance")
//	public void setup (){
//		Base.initialize("chrome");
//		loginpage.loginClick();
//		loginpage.signInPage(prop.getProperty("UserName"), prop.getProperty("Password"));
//		homepage.clickOnManageAttendance();
//		AttendancePg = new AttendancePage();
//		System.out.println("opening");
//		}
//
	
	@After
	public void tearDown() {
		driver.quit();
		System.out.print("am closing");
		
	}
	
	@Given("Admin is on Manage Attendance page")
	public void admin_is_on_manage_attendance_page() {
		loginpage.loginClick();
		loginpage.signInPage(prop.getProperty("UserName"), prop.getProperty("Password"));
		homepage.clickOnManageAttendance();
		AttendancePg.goToAttendancePg();
	}
	@When("Admin Selects {string},{string} and {string}")
	public void admin_selects_batch_class_and_class_date(String batch, String className, String classDate) {
		AttendancePg.selectBatch(batch);
		AttendancePg.selectClass(className);
		AttendancePg.selectClassDate(classDate);
	}
	@Then("Student attendance can be viewed succesfully based on the selected criteria")
	public void student_attendance_can_be_viewed_succesfully_based_on_the_selected_criteria() {
	    Assert.assertNotEquals(AttendancePg.getStudents(),0);
	}
	@When("Admin clicks on save button after selecting {string}, {string} and {string} and marks the {string} as either {string}.")
	public void admin_clicks_on_save_button_after_selecting_batch_and_class_and_marks_the_student_as_either(String batch, String className, String classDate, String attendanceStatus) {
		AttendancePg.selectBatch(batch);
		AttendancePg.selectClass(className);
		AttendancePg.selectClassDate(classDate);
		AttendancePg.selectAttendanceStatus(attendanceStatus);
		AttendancePg.clickSave();
	}
	@Then("Student attendance details will be saved  succeesfully .")
	public void student_attendance_details_will_be_saved_succeesfully(String attendanceStatus) {
		
		Assert.assertTrue(AttendancePg.getAttendanceStatus(attendanceStatus));
	   
	}
	@When("Admin clicks on reset button after selecting {string} , {string} and {string}")
	public void admin_clicks_on_reset_button_after_selecting_batch_class_and_class_date(String batch, String className, String classDate) {
		AttendancePg.selectBatch(batch);
		AttendancePg.selectClass(className);
		AttendancePg.selectClassDate(classDate);
		AttendancePg.clickReset();
	}
	@Then("Default radio button {string} will be selected for all the displayed students.")
	public void default_radio_button_will_be_selected_for_all_the_displayed_students() {
	    Assert.assertTrue(AttendancePg.chkDefaultStatus());
	}
	

	

}
