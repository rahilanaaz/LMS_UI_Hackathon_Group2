package Page;

import base.Base;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class UserAssignmentPage extends Base {
	
		@FindBy(linkText = "manageSubmissionsUser")
		WebElement manageSubmissionsLinkUser;
		// @FindBy (id = "ManageAssigns") WebElement ManageAssigns;
		@FindBy(id = "AddAssignUser")
		WebElement addAssignUser;
		@FindBy(id = "AssignmentBatchUser")
		WebElement assignBatchUser;
		@FindBy(xpath = "//button[contains,text()'AssignmentNameUser']")
		WebElement assignNameUser;
		@FindBy(xpath = "//button[contains,text()'AssignmentDescUser']")
		WebElement assignDescUser;
		@FindBy(xpath = "//button[contains,text()'AssignmentDateUser']")
		WebElement assignDateUser;
		@FindBy(xpath = "//a[contains(text()='AssignmentFile1User')")
		WebElement uploadFileUser;
		@FindBy(xpath = "//button[contains,text()'AddAssignSubmitUser']")
		WebElement submitUser;
		@FindBy(id = "EditAssignmentUser")
		WebElement editAssignmentUser;
		@FindBy(id = "DelAssignmentUser")
		WebElement delAssignmentUser;
		@FindBy(xpath = "//div[@class='add_assignment']")
		List<WebElement> assignmentElementsUser;
		@FindBy(id = "ManageGradesUser")
		WebElement manageAssignUser;
		@FindBy(id = "GradeBatchUser")
		WebElement gradeBatchUser;
		@FindBy(id = "AssignmentNameUser")
		WebElement assignNamebtUser;

		private int currentAssignmentCountUser;
		private String assignmentDescriptionUser;

		public UserAssignmentPage() {
			PageFactory.initElements(driver, this);

		}

		public void manageAssignmentsUser() {
			manageSubmissionsLinkUser.click();

		}

		public void addAssignmentbtUser() {
			currentAssignmentCountUser();
			addAssignUser.click();
		}

		public void currentAssignmentCountUser() {
			this.currentAssignmentCountUser = assignmentElementsUser.size();

		}

		public void addAssignmentsUser(String batchId, String assignNamestr, String assignDescstr, String assignDate,
				String uploadassign) {
			Select batchNo = new Select(assignBatchUser);
			batchNo.selectByVisibleText(batchId);
			assignNameUser.sendKeys(assignNamestr);
			assignDescUser.sendKeys(assignDescstr);
			uploadFileUser.sendKeys(uploadassign);

			submitUser.click();
		}

		public void assertAddAssignmentsUser() {
			int assignmentNewCount = assignmentElementsUser.size();
			assertEquals(this.currentAssignmentCountUser++, assignmentNewCount);
//	    			
		}

		public void editAssignmentbtUser() {
			editAssignmentUser.click();
		}

		public void editAssignmentsUser(String batchId, String assignDescstr) {
			Select batchNo = new Select(assignBatchUser);
			batchNo.selectByVisibleText(batchId);
			assignDescUser.sendKeys(assignDescstr);
			this.assignmentDescriptionUser = assignDescstr;
			submitUser.click();
		}

		public void assertEditAssignmentsUser() {
			for (int j = 1; j <= assignmentElementsUser.size(); j++) {
				WebElement assignmentRow = assignmentElementsUser.get(j);
				WebElement assignmentDescElement = assignmentRow.findElement(By.xpath("//div[@class='assignment_desc']"));
				if (assignmentDescriptionUser.equals(assignmentDescElement.getText())) {
					assertTrue(true);

					return;
				}
			}
			assertTrue(false);
		}

		public void deleteAssignUser() {

			currentAssignmentCountUser();
			delAssignmentUser.click();
		}

		public void assertDeleteAssignmentsUser() {
			int assignmentNewCount = assignmentElementsUser.size();
			assertEquals(this.currentAssignmentCountUser--, assignmentNewCount);

		}

		public void manageAssignmentUser() {
			manageAssignUser.click();

		}

}
