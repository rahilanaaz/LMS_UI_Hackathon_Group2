package Page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class BatchPage  extends Base{

	
	@FindBy(id = "linkBatches")
	WebElement batchesLink;
	
	@FindBy(id = "selBatchProgram")
	WebElement batchProgramDropdown;
	
	@FindBy(id = "btnEditBatch")
	WebElement editIconLink;
	
	@FindBy(id = "btnDelBatch")
	WebElement trashIconLink;
	
	@FindBy(id = "btnAddBatch")
	WebElement addBatchBtn;
	
	@FindBy(id = "txtBatchName")
	WebElement batchNameTxt;
	
	@FindBy(id = "txtBatchDescription")
	WebElement batchDescriptionTxt;
	
	@FindBy(id = "radBatchActiveStatus")
	WebElement activeRadioBtn;
	
	@FindBy(id = "radBatchInActiveStatus")
	WebElement inActiveRadioBtn;
	
	@FindBy(id = "txtBatchNoClasses")
	WebElement batchNoOfClassesTxt;
	
	@FindBy(id = "btnSubmit")
	WebElement submitBtn;
	
	@FindBy(id = "BatchID")
	List<WebElement> listBatchID;
	
	@FindBy(id = "BatchName")
	List<WebElement> listBatchName;
	
	@FindBy(id = "BatchDesc")
	List<WebElement> listBatchDesc;
	
	@FindBy(id = "BatchStatus")
	List<WebElement> listBatchStatus;
	
	@FindBy(id = "BatchClasses")
	List<WebElement> listBatchClasses;
	
	@FindBy(id = "BatchCreationtime")
	List<WebElement> listBatchCreationTime;
	
	@FindBy(id = "BatchModifiedtime")
	List<WebElement> listBatchModifiedTime;
	
	public BatchPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBatchesLink() {
		
		batchesLink.click();
	}
	
	public void clickOnAddBatchBtn() {
		
		addBatchBtn.click();
	}
	
	public void clickOnEditBatchIconBtn() {
		
		editIconLink.click();
	}
	
   public String batchIDListSize() {
		
	    int batchIDListSize = listBatchID.size();
		return Integer.toString(batchIDListSize);
	}
	
    public String batchNameListSize() {
		
		int batchNameListSize = listBatchName.size();
		return Integer.toString(batchNameListSize);
	}
	
    public String batchDescListSize() {
		
		int batchDescListSize = listBatchDesc.size();
		return Integer.toString(batchDescListSize);
	}
   public String batchStatusListSize() {
		
		int batchStatusListSize = listBatchStatus.size();
		return Integer.toString(batchStatusListSize);
	}
   public String batchClassesListSize() {
		
	    int batchClassesListSize = listBatchClasses.size();
		return Integer.toString(batchClassesListSize);
	}
   public String batchCreationTimeListSize() {
		
		int batchCreationTimeListSize = listBatchCreationTime.size();
		return Integer.toString(batchCreationTimeListSize);
	}
   public String batchModifiedTimeListSize() {
		
		int batchModifiedTimeListSize = listBatchModifiedTime.size();
		return Integer.toString(batchModifiedTimeListSize);
	}
   public String newAddedBatchID() {
		
		String batchID = listBatchID.get(listBatchID.size()-1).getText();
		return batchID;
	}
	
	public String newAddedBatchName() {
		
		String batchName = listBatchName.get(listBatchName.size()-1).getText();
		return batchName;
	}
	
    public String newAddedBatchDesc() {
		
		String batchDesc = listBatchDesc.get(listBatchDesc.size()-1).getText();
		return batchDesc;
	}
    public String newAddedBatchStatus() {
		
		String batchStatus = listBatchStatus.get(listBatchStatus.size()-1).getText();
		return batchStatus;
	}
   public String newAddedBatchClasses() {
		
		String batchClasses = listBatchClasses.get(listBatchClasses.size()-1).getText();
		return batchClasses;
	}
   public String newAddedBatchCreationTime() {
		
		String batchCreationTime = listBatchCreationTime.get(listBatchCreationTime.size()-1).getText();
		return batchCreationTime;
	}
   public String newAddedBatchModifiedTime() {
		
		String batchModifiedTime = listBatchModifiedTime.get(listBatchModifiedTime.size()-1).getText();
		return batchModifiedTime;
	}
   public String updatedBatchName() {
		
		String batchName = listBatchName.get(listBatchName.size()-1).getText();
		return batchName;
	}
	
   public String updatedBatchDesc() {
		
		String batchDesc = listBatchDesc.get(listBatchDesc.size()-1).getText();
		return batchDesc;
	}
   public String updatedBatchNoOfClasses() {
		
		String batchNoOfClasses = listBatchClasses.get(listBatchClasses.size()-1).getText();
		return batchNoOfClasses;
	}
	
	public void clickOnEditIconLink() {
		
		editIconLink.click();
	}
	
	public void addBatch(String batchName, String batchDesc, String batchStatus, String batchNoOfClasses) {
		
		batchNameTxt.sendKeys(batchName);
		batchDescriptionTxt.sendKeys(batchDesc);
		
		if(batchStatus.equalsIgnoreCase("Active")) {
			
			if(!activeRadioBtn.isSelected())
				activeRadioBtn.click();
		}
		
		else if(batchStatus.equalsIgnoreCase("InActive")) {
			
			if(!inActiveRadioBtn.isSelected())
				inActiveRadioBtn.click();
		}
		
		submitBtn.click();
	}
	
	public void editBatch(String batchName, String batchDesc, String noOfClasses) {
		
		batchNameTxt.clear();
		batchNameTxt.sendKeys(batchName);
		
		batchDescriptionTxt.clear();
		batchDescriptionTxt.sendKeys(batchDesc);
		
		batchNoOfClassesTxt.clear();
		batchNoOfClassesTxt.sendKeys(noOfClasses);
		
		submitBtn.click();
	}
	
	public void deleteBatch() {
		
		trashIconLink.click();
	}
	

}
