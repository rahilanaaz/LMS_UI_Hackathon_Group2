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


public class AdminAssignmentsPage extends Base{
	
		@FindBy(linkText = "manageSubmissions")
		WebElement manageSubmissionsLink;
		// @FindBy (id = "ManageAssigns") WebElement ManageAssigns;
		@FindBy(id = "AddAssign")
		WebElement addAssign;
		@FindBy(id = "AssignmentBatch")
		WebElement assignBatch;
		@FindBy(xpath = "//button[contains,text()'AssignmentName']")
		WebElement assignName;
		@FindBy(xpath = "//button[contains,text()'AssignmentDesc']")
		WebElement assignDesc;
		@FindBy(xpath = "//button[contains,text()'AssignmentDate']")
		WebElement assignDate;
		@FindBy(xpath = "//a[contains(text()='AssignmentFile1')")
		WebElement uploadFile;
		@FindBy(xpath = "//button[contains,text()'AddAssignSubmit']")
		WebElement submit;
		@FindBy(id = "EditAssignment")
		WebElement editAssignment;
		@FindBy(id = "DelAssignment")
		WebElement delAssignment;
		@FindBy(xpath = "//div[@class='add_assignment']")
		List<WebElement> assignmentElements;
		@FindBy(id = "ManageGrades")
		WebElement manageAssign;
		@FindBy(id = "GradeBatch")
		WebElement gradeBatch;
		@FindBy(id = "AssignmentName")
		WebElement assignNamebt;
		@FindBy(id = "GradeBy")
		WebElement gradeBy;
		@FindBy(id = "Grade")
		WebElement grade;
		@FindBy(id = "GradesVisible")
		WebElement gradesVisible;
		@FindBy(id = "GradesSubmit")
		WebElement gradesSubmit;
		@FindBy(id = "ManagesubAdminLOGO")
		WebElement adminLOGO;
		@FindBy(id = "ManagesubUserLOGO")
		WebElement adminUser;

		private int currentAssignmentCount;
		private String assignmentDescription;

		public AdminAssignmentsPage() {
			PageFactory.initElements(driver, this);

		}

		public void manageAssignments() {
			manageSubmissionsLink.click(); // can be replaced with loginpage details

		}

		public void addAssignmentbt() {
			currentAssignmentCount();
			addAssign.click();
		}

		public void currentAssignmentCount() {
			this.currentAssignmentCount = assignmentElements.size();

		}

		public void addAssignments(String batchId, String assignNamestr, String assignDescstr, String assignDate,
				String uploadassign) {
			Select batchNo = new Select(assignBatch);
			batchNo.selectByVisibleText(batchId);
			assignName.sendKeys(assignNamestr);
			assignDesc.sendKeys(assignDescstr);
			uploadFile.sendKeys(uploadassign);

			submit.click();
		}

		public void assertAddAssignments() {
			int assignmentNewCount = assignmentElements.size();
			assertEquals(this.currentAssignmentCount++, assignmentNewCount);
//	    			
		}

		public void editAssignmentbt() {
			editAssignment.click();
		}

		public void editAssignments(String batchId, String assignDescstr) {
			Select batchNo = new Select(assignBatch);
			batchNo.selectByVisibleText(batchId);
			assignDesc.sendKeys(assignDescstr);
			this.assignmentDescription = assignDescstr;
			submit.click();
		}

		public void assertEditAssignments() {
			for (int j = 1; j <= assignmentElements.size(); j++) {
				WebElement assignmentRow = assignmentElements.get(j);
				WebElement assignmentDescElement = assignmentRow.findElement(By.xpath("//div[@class='assignment_desc']"));
				if (assignmentDescription.equals(assignmentDescElement.getText())) {
					assertTrue(true);

					return;
				}
			}
			assertTrue(false);
		}

		public void deleteAssign() {

			currentAssignmentCount();
			delAssignment.click();
		}

		public void assertDeleteAssignments() {
			int assignmentNewCount = assignmentElements.size();
			assertEquals(this.currentAssignmentCount--, assignmentNewCount);

		}

		public void manageAssignment() {
			manageAssign.click();

		}

		public void changeGrade() {
			manageAssign.click();

		}

		public void manageCheckgrade(String batchId, String assignNam, String gradeByuser, String gradeType) {
			Select batchNo = new Select(gradeBatch);
			batchNo.selectByVisibleText(batchId);
			Select assignNo = new Select(assignNamebt);
			assignNo.selectByVisibleText(assignNam);
			Select gradeby1 = new Select(gradeBy);
			gradeby1.selectByVisibleText(gradeByuser);
			Select gradesel = new Select(assignNamebt);
			gradesel.selectByVisibleText(gradeType);
			gradesVisible.click();
			gradesSubmit.click();

		}

		public void manageunCheckgrade(String batchId, String assignNam, String gradeByuser, String gradeType) {
			Select batchNo = new Select(gradeBatch);
			batchNo.selectByVisibleText(batchId);
			Select assignNo = new Select(assignNamebt);
			assignNo.selectByVisibleText(assignNam);
			Select gradeby1 = new Select(gradeBy);
			gradeby1.selectByVisibleText(gradeByuser);
			Select gradesel = new Select(assignNamebt);
			gradesel.selectByVisibleText(gradeType);
			gradesSubmit.click();

		}

		public void assertVisibility() {
			gradesVisible.click();
			if (gradesVisible != null) {
				adminLOGO.isDisplayed();

			} else {
				adminUser.isDisplayed();
			}

		}


	
	}
