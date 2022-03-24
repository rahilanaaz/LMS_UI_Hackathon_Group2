package stepdefinition;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Page.HomePage;
import Page.LoginPage;
import Page.ManagePaginationPage;
import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaginationStep extends Base {

	HomePage homePage;
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;

	ManagePaginationPage managePaginationPage = new ManagePaginationPage();

	int rowCount;

//    public PaginationSteps(){
//		
//		super();
//	}

//	@Before
//	public void setUp() {
//		driver = initialize("chrome");
//		
//	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("Admin is on Manage users\\(admin) page of User list\\(Unregistered)")
	public void admin_is_on_manage_users_admin_page_of_user_list_unregistered() {
		loginpage.loginClick();
		loginpage.signInPage(prop.getProperty("UserName"), prop.getProperty("Password"));
		homepage.clickOnUsers();
		homepage.clickOnUsers();
	}

	@When("result is containing many user records")
	public void result_is_containing_many_user_records() {

		rowCount = managePaginationPage.getTableRowCount();
	}

	@Then("Arrow buttons will appear, large number of user records will be divided into smaller discrete pages")
	public void arrow_buttons_will_appear_large_number_of_user_records_will_be_divided_into_smaller_discrete_pages() {

		if (rowCount >= 10) {
			Assert.assertEquals(managePaginationPage.hasArrows(), true);
		} else {
			Assert.assertEquals(managePaginationPage.hasArrows(), false);
		}

	}

	@Given("Admin is on  Manage Attendance\\(Admin and Class Staff) page of Manage Attendance\\(admin)")
	public void admin_is_on_manage_attendance_admin_and_class_staff_page_of_manage_attendance_admin() {

	}

	@When("result is containing many  Student records")
	public void result_is_containing_many_student_records() {

		rowCount = managePaginationPage.getTableRowCount();
	}

	@Then("Arrow buttons will appear, large number of Student records will be divided into smaller discrete pages")
	public void arrow_buttons_will_appear_large_number_of_student_records_will_be_divided_into_smaller_discrete_pages() {

		if (rowCount >= 10) {
			Assert.assertEquals(managePaginationPage.hasArrows(), true);
		} else {
			Assert.assertEquals(managePaginationPage.hasArrows(), false);
		}
	}

}
