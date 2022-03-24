package Page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class HomePage extends Base{
	
	
		
		@FindBy(linkText = "programs")
		WebElement programsLink;
		
		@FindBy(linkText = "batches")
		WebElement batchesLink;
		
		@FindBy(linkText = "users")
		WebElement usersLink;
		
		@FindBy(linkText = "eventCalendar")
		WebElement eventCalendarLink;
		
		@FindBy(linkText = "manageClasses")
		WebElement manageClassesLink;
		
		@FindBy(linkText = "manageRecordings")
		WebElement manageRecordingsLink;
		
		@FindBy(linkText = "manageAssignments")
		WebElement manageAssignmentsLink;
		
		@FindBy(linkText = "notifications")
		WebElement notificationsLink;
		
		@FindBy(linkText = "manageAttendance")
		WebElement manageAttendanceLink;
		
		@FindBy(linkText = "manageSubmissions")
		WebElement manageSubmissionsLink;
		
		public HomePage() {
			
			PageFactory.initElements(driver, this);
		}
		
		public void clickOnPrograms() {
			
			programsLink.click();
		}
		
		public void clickOnBatches() {
			
			batchesLink.click();
		}
		
		public void clickOnUsers() {
			
			usersLink.click();
		}
		
		public void eventCalendar() {
			
			eventCalendarLink.click();
		}
		
		public void clickOnManageClasses() {
			
			manageClassesLink.click();
		}
		
		public void clickOnManageRecordingsLink() {
			
			manageRecordingsLink.clear();
		}
		
		public void clickOnManageAssignments() {
			
			manageAssignmentsLink.click();
		}
		
		public void clickOnNotifications() {
			
			notificationsLink.click();
		}
		
		public void clickOnManageAttendance() {
			
			manageAttendanceLink.click();
		}
		
		public void clickOnMangeSubmissions() {
			
			manageSubmissionsLink.click();
		}
		

}
