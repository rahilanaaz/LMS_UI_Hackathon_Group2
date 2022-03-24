package Page;


import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Base;


public class AttendancePage extends Base {
	
	@FindBy(xpath="//*[contains(text(),'Attendance')]")
	public static WebElement attendancePgLink;
	@FindBy(id="selAttendanceBatch")
	public static WebElement batch;
	
	@FindBy(id="selAttendanceClass")
	public static WebElement classField;
	
	@FindBy(id="txtClassDate")
	public static WebElement classDate;
	
	@FindBy(id="radPresent")
	public static WebElement present;
	
	@FindBy(id="radAbsent")
	public static WebElement absent;
	
	@FindBy(id="radLate")
	public static WebElement late;
	
	@FindBy(id="radExcused")
	public static WebElement excused;
	
	@FindBy(id="radUnknown")
	public static WebElement unknown;
	
	@FindBy(id="btnSaveAttendance")
	public static WebElement save;
	
	@FindBy(id="btnResetAttendance")
	public static WebElement reset;
	
	@FindBy(id="StudentNames")
	public static List<WebElement> students;
	
	public AttendancePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void goToAttendancePg()
	{
		attendancePgLink.click();
	}
	
	public void selectBatch(String batchNme)
	{
		Select batchSelect = new Select(batch);
		batchSelect.selectByVisibleText(batchNme);
	}
	
	public void selectClass(String classNme)
	{
		Select ClassSelect = new Select(classField);
		ClassSelect.selectByVisibleText(classNme);
	}
	
	public void selectClassDate(String classDt)
	{
		classDate.sendKeys(classDt);
	}
	
	public void clickPresent()
	{
		present.click();
	}
	
	public void clickAbsent()
	{
		absent.click();
	}
	
	public void clickLate()
	{
		late.click();
	}
	
	public void clickExcused()
	{
		excused.click();
	}
	
	public void clickUnknown()
	{
		unknown.click();
	}
	
	public void selectAttendanceStatus(String attendanceStatus)
	{
		switch(attendanceStatus) {
	    case("Present"):
	    	clickPresent();
	    	break;
	    case("Absent"):
	    	clickAbsent();
	    	break;
	    case("Late"):
	    	clickLate();
	    	break;
	    case("Excused"):
	    	clickExcused();
	    	break;
	    case("Unknown"):
	    	clickUnknown();
	    	break;
	    default:
	    	break;
	    }
	}
		
	public boolean getAttendanceStatus(String attendanceStatus)
	{
		boolean status = false;
		switch(attendanceStatus) {
	    case("Present"):
	       if(present.isSelected())
	    	   {
	    	   	status = true;
	    	   }
	    	break;
	    case("Absent"):
	    	if(absent.isSelected())
	    	   {
	    	   	status = true;
	    	   }
	    	break;
	    case("Late"):
	    	if(late.isSelected())
	    	   {
	    	   	status = true;
	    	   }
	    	break;
	    case("Excused"):
	    	if(excused.isSelected())
	    	   {
	    	   	status = true;
	    	   }
	    	break;
	    case("Unknown"):
	    	if(unknown.isSelected())
	    	   {
	    	   	status = true;
	    	   }
	    	break;
	    default:
	    	break;
	    }
		return status;
	}
	
	public boolean chkDefaultStatus()
	{
		return unknown.isSelected();
	}
	
	public int getStudents()
	{
		return students.size();
	}
	
	public void clickSave()
	{
		save.click();
	}
	
	public void clickReset()
	{
		reset.click();
	}

}
