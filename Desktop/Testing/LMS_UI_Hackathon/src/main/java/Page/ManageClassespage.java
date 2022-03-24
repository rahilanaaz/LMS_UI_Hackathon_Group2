package Page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Base;

public class ManageClassespage extends Base {

	@FindBy(id = "ManageClasses")
	WebElement ManageClass;
	@FindBy(id = "AddClass")
	WebElement AddClass;
	@FindBy(id = "Add")
	WebElement Add;
	@FindBy(id = "ClassTopic")
	WebElement Topic;
	@FindBy(id = "ClassDate")
	WebElement Date;
	@FindBy(id = "ClassStaffName")
	WebElement select;
	@FindBy(id = "ClassDescription")
	WebElement ClassDescription;
	@FindBy(id = "Comments")
	WebElement Classcomments;
	@FindBy(xpath = "//button[contains,text()'Submit']")
	WebElement Submit;
	@FindBy(id = "EditClass")
	WebElement Edit;
	@FindBy(id = "DelClass")
	WebElement Delete;
	@FindBy(id = "ClassTopic")
	List<WebElement> row;
	WebElement tablerow;

	// Initializing th Page Object

	public ManageClassespage() {
		PageFactory.initElements(driver, this);

	}

	public void addclass() {
		ManageClass.click();
	}

	public void AddClassGiven() {
		AddClass.click();
		Add.click();
	}

	public void AddClassWhen(String ClassTopic, String StaffName, String ClassDescrp, String ClassComment) {
		Topic.sendKeys(ClassTopic);
		Select Staff = new Select(select);
		Staff.selectByVisibleText(StaffName);
		ClassDescription.sendKeys(ClassDescrp);
		Classcomments.sendKeys(ClassComment);
		Submit.click();
	}

	public String addclassnameThen() {
		String clsname = row.get(row.size()-1).getText();
		return clsname ;
	}
	

	public void EditClassGiven() {
		AddClass.click();
		Edit.click();
	}

	public void EditClassWhen(String ClassTopic, String StaffName, String ClassDescrp, String ClassComment) {
		Topic.clear();
		Topic.sendKeys(ClassTopic);
		Select Staff = new Select(select);
		Staff.selectByVisibleText(StaffName);
		ClassDescription.sendKeys(ClassDescrp);
		Classcomments.sendKeys(ClassComment);
		Submit.click();
	}

	public String EditClassThen() {
				row.size();
		if (row.size()>0) {
			tablerow = row.get(row.size()-1);
		}	
		return tablerow.getText();
	}

	public Integer DeleteClassGiven() {
		ManageClass.click();
		return row.size();

	}

	public void DeleteClassWhen() {
		Delete.click();
	}

	public Integer DeleteClassThen() {
		return row.size();

	}
	
	public String AddClassThen() {

		row.size();
		if (row.size() > 0) {
			tablerow = row.get(row.size() - 1);

		}
		return tablerow.getText();

	}

}
