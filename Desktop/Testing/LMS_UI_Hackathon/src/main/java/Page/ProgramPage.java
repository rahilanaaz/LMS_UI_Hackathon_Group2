package Page;

import base.Base;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgramPage extends Base {
	
	@FindBy(id = "btnAddProgram")
	WebElement addProgramBtn;
	
	@FindBy(id = "btnEditProgram")
	WebElement editIconLink;
	
	@FindBy(id = "btnDelProgram")
	WebElement trashIconLink;
	
	@FindBy(id = "txtProgramName")
	WebElement programNameTxt;
	
	@FindBy(id = "txtProgramDescription")
	WebElement ProgramDescriptionTxt;
	
	@FindBy(id = "radPrgmActiveStatus")
	WebElement activeRadioBtn;
	
	@FindBy(id = "radPrgmInActiveStatus")
	WebElement inActiveRadioBtn;
	
	@FindBy(id = "btnProgramSubmit")
	WebElement submitBtn;
	
	@FindBy(id = "programName")
	List<WebElement> listProgName;
	
	@FindBy(id = "ProgDesc")
	List<WebElement> listProgDesc;
	
	@FindBy(id = "ProgramStatus")
	List<WebElement> listProgStatus;
	
	@FindBy(id = "PgmCreationtime")
	List<WebElement> listProgCreationTime;
	
	@FindBy(id = "PgmModifiedtime")
	List<WebElement> listProgModifiedTime;
	
	
	public ProgramPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnAddProgramBtn() {
		
		addProgramBtn.click();
	}
	
	public void addProgram(String progName, String progDesc, String status) {
		
		programNameTxt.sendKeys(progName);
		ProgramDescriptionTxt.sendKeys(progDesc);
		if(status.equalsIgnoreCase("Active")) {
			
			if(!activeRadioBtn.isSelected())
				activeRadioBtn.click();
			}
		
		else if(status.equalsIgnoreCase("InActive")) {
			
			if(!inActiveRadioBtn.isSelected())
				inActiveRadioBtn.click();
			}
		
		submitBtn.click();
	}
	
	public String ProgNameListSize() {
		
		int progNameListSize = listProgName.size();
		return Integer.toString(progNameListSize);
	}
	
    public String ProgDescListSize() {
		
		int progDescListSize = listProgDesc.size();
		return Integer.toString(progDescListSize);
	}
   public String ProgStatusListSize() {
		
		int progStatusListSize = listProgStatus.size();
		return Integer.toString(progStatusListSize);
	}
   public String ProgCreationTimeListSize() {
		
		int progCreationTimeListSize = listProgCreationTime.size();
		return Integer.toString(progCreationTimeListSize);
	}
   public String ProgModifiedTimeListSize() {
		
		int progModifiedTimeListSize = listProgModifiedTime.size();
		return Integer.toString(progModifiedTimeListSize);
	}
	
	public String newAddedProgName() {
		
		String progName = listProgName.get(listProgName.size()-1).getText();
		return progName;
	}
	
    public String newAddedProgDesc() {
		
		String progDesc = listProgDesc.get(listProgDesc.size()-1).getText();
		return progDesc;
	}
    public String newAddedProgStatus() {
		
		String progStatus = listProgStatus.get(listProgStatus.size()-1).getText();
		return progStatus;
	}
public String updatedProgName() {
		
		String progName = listProgName.get(listProgName.size()-1).getText();
		return progName;
	}
	
    public String updatesProgDesc() {
		
		String progDesc = listProgDesc.get(listProgDesc.size()-1).getText();
		return progDesc;
	}
    public String updatedProgStatus() {
		
		String progStatus = listProgStatus.get(listProgStatus.size()-1).getText();
		return progStatus;
	}
   public String newAddedProgCreationTime() {
		
		String progCreationTime = listProgCreationTime.get(listProgCreationTime.size()-1).getText();
		return progCreationTime;
	}
   public String newAddedProgModifiedTime() {
		
		String progModifiedTime = listProgModifiedTime.get(listProgModifiedTime.size()-1).getText();
		return progModifiedTime;
	}
	
	public void clickOnEditIconLink() {
		
		editIconLink.click();
	}
	
	public void editProgram(String progName, String progDesc, String progStatus) {
		
		programNameTxt.clear();
		programNameTxt.sendKeys(progName);
		
		ProgramDescriptionTxt.clear();
		ProgramDescriptionTxt.sendKeys(progDesc);
		
        if(progStatus.equalsIgnoreCase("Active")) {
			
			if(!activeRadioBtn.isSelected())
				activeRadioBtn.click();
			}
		
		else if(progStatus.equalsIgnoreCase("InActive")) {
			
			if(!inActiveRadioBtn.isSelected())
				inActiveRadioBtn.click();
			}
		
		submitBtn.click();
	}
	
	public void deleteProgram() {
		
		trashIconLink.click();
	}
	
	

}
