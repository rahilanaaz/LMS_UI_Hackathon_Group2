package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Base;

public class NotificationPage extends Base {
	
	@FindBy(xpath="//*[ contains (text(),'Notifications')]")
	public static WebElement notificationPgLink;
	
	@FindBy(id="selNotificationPgmName")
	public static WebElement pgmName;
	@FindBy(id="txtHackathonName")
	public static WebElement hackathonName;
	
	@FindBy(id="txtHackathonDesc")
	public static WebElement hackathonDesc;
	
	@FindBy(id="txtHackathonDate")
	public static WebElement hackathonDate;
	
	@FindBy(id="txtHackathonComments")
	public static WebElement hackathonComments;
	
	@FindBy(id="btnSaveNotification")
	public static WebElement submitBtn;
	
	@FindBy(xpath = "//*[@id='notification']")
	public static WebElement notificationMsg;
	
	public NotificationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void goToNotificationPg()
	{
		notificationPgLink.click();
	}
	
	public void sendProgramName(String progName)
	{
		Select selectProg = new Select(pgmName);
		selectProg.selectByVisibleText(progName);		
	}
	
	public void sendHackathonName(String hackathnName)
	{
		hackathonName.sendKeys(hackathnName);
	}
	
	public void sendHackathonDesc(String hackathnDesc)
	{
		hackathonDesc.sendKeys(hackathnDesc);
	}
	
	public void sendHackathonDate(String hackathonDt)
	{
		hackathonDate.sendKeys(hackathonDt);
	}
	
	public void sendHackathonComments(String comments)
	{
		hackathonComments.sendKeys(comments);
	}
	
	public void clickSubmit()
	{
		submitBtn.click();
	}
	
	public String getNotification()
	{
		return notificationMsg.getText();
	}

}
