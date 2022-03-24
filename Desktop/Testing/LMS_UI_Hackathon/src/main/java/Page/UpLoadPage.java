package Page;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Base;


public class UpLoadPage extends Base {
	
		
		@FindBy(id = "ManageRecordings") WebElement Recording;
		@FindBy(id = "BatchRecording") WebElement batch;
		@FindBy(id = "RecordingTopic") WebElement Topic1;
		@FindBy(id = "UploadRecording") WebElement UPLOADRecording;
		@FindBy(id = "UploadResources") WebElement UPLOADResources;
		@FindBy(id= "alert") WebElement alert;
		@FindBy(id = "ClassRecording")List< WebElement> recording;
		WebElement record;
		
		public UpLoadPage() {
			PageFactory.initElements(driver,this);
			
		}
		
		public void ManageRecording() {
			Recording.click();
		}
		public void UploadRecordingGiven(String Batch,String Topic) {
			Select batchid = new Select(batch);
			batchid.selectByVisibleText(Batch);
			
			Select topic = new Select(Topic1);
			topic.selectByVisibleText(Topic);
			System.out.println("In Manage Recording Page");
				}
		
		public void UploadeRecordingWhen(String FilePath) {
			
			
			UPLOADRecording.sendKeys(FilePath);
		}
		
		
		public String CapturetextThen() {
			recording.size();
			if (recording.size()>0) {
				record = recording.get(recording.size()-1);
					}
		 		return record.getText();
		}
		public void UploadeResourceswhen(String FilePath) {
			
			UPLOADResources.sendKeys(FilePath);
		}
		
		public void UploadResourceGiven(String Batch,String Topic) {
		
			System.out.println("In Manage Recording Page");
			Select batchid = new Select(batch);
			batchid.selectByVisibleText(Batch);
			
			Select topic = new Select(Topic1);
			topic.selectByVisibleText(Topic);
			
		}
	


}
