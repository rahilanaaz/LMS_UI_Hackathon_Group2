package Page;

import base.Base;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUsersPage extends Base{

	@FindBy(id = "Userbtn")
	WebElement btnUser;

	@FindBy(id = "btnSearch")
	WebElement searchBtn;

	@FindBy(id = "editIcon")
	List<WebElement> iconEdit;

	@FindBy(id = "trashIcon")
	List<WebElement> iconTrash;

	@FindBy(id = "eyeIcon")
	List<WebElement> iconEye;

	@FindBy(id = "userHyperlink")
	WebElement hyperlinkUser;

	@FindBy(id = "unregisteredUserEditIcon")
	List<WebElement> editIconUnregisteredUser;

	@FindBy(id = "unregisteredTrashIcon")
	List<WebElement> trashIconUnregistered;

	@FindBy(id = "saveBtn")
	WebElement btnSave;

	@FindBy(id = "txtEmail")
	WebElement emailTxt;

	@FindBy(id = "numberBatch")
	WebElement batchNumber;

	@FindBy(id = "txtSkill")
	WebElement skillTxt;

	@FindBy(id = "txtProgram")
	WebElement programTxt;

	@FindBy(id = "btnUnRegUser")
	WebElement unRegUserBtn;

	@FindBy(id = "txtTimeZone")
	WebElement timeZoneTxt;

	@FindBy(id = "txtroleUser")
	WebElement userRoleTxt;

	@FindBy(id = "txtBatch")
	WebElement batchTxt;

	@FindBy(id = "txtPrg")
	WebElement prgTxt;

	// List<WebElement> row;
	// WebElement tablerow;

	@FindBy(id = "RegEmail")
	WebElement listRegEmail;

	@FindBy(id = "RegBatch")
	WebElement listRegBatch;

	@FindBy(id = "RegSkill")
	WebElement listRegSkill;

	@FindBy(id = "RegProg")
	WebElement listRegProgram;

	@FindBy(id = "UnRegEmail")
	List<WebElement> listUnRegEmail;

	@FindBy(id = "UnRegUserName")
	List<WebElement> listUnRegUserName;

	// Following is for Manage user (admin) page

	@FindBy(id = "RegFirstName")
	WebElement listRegFirstName;

	@FindBy(id = "RegLastName")
	WebElement listRegLastName;

	@FindBy(id = "RegPhoneNum")
	WebElement listRegPhoneNum;

	@FindBy(id = "RegLocation")
	WebElement listRegLocation;

	@FindBy(id = "RegLinkedUrl")
	WebElement listRegLinkedUrl;

	@FindBy(id = "RegUgPrg")
	WebElement listRegUgPrg;

	@FindBy(id = "RegPgPrg")
	WebElement listRegPgPrg;

	@FindBy(id = "RegMonthsExperience")
	WebElement listRegMonthsExperience;

	@FindBy(id = "RegComments")
	WebElement listRegComments;

	public ManageUsersPage() {

		PageFactory.initElements(driver, this);
	}

	public void clickOnBtnRegUser() {

		btnUser.click();
	}

	public void clickOnbtnSearch(String email, String batch, String skill, String program) {

		emailTxt.sendKeys(email);
		batchNumber.sendKeys(batch);
		skillTxt.sendKeys(skill);
		programTxt.sendKeys(program);

		searchBtn.click();

	}

	public void clickOnEditIcon() {
		WebElement last = iconEdit.get(iconEdit.size() - 1);
		last.click();
	}

	public void clickOnLastTrashIcon() {
		WebElement last = iconTrash.get(iconTrash.size() - 1);
		last.click();
	}

	public void clickOnEyeIcon() {
		WebElement last = iconEye.get(iconEye.size() - 1);
		last.click();
	}

	public void clickOnNewUnassignedUserHyperlink() {

		hyperlinkUser.click();
	}

	public void clickOnEditIconUnregisteredUser() {

		WebElement last = editIconUnregisteredUser.get(editIconUnregisteredUser.size() - 1);
		last.click();
	}

	public void clickOnTrashIconUnregistered() {
		WebElement last = trashIconUnregistered.get(trashIconUnregistered.size() - 1);
		last.click();
	}

	public void editUsrDetails(String timeZomne, String userRole, String batch, String prg) {

		timeZoneTxt.sendKeys(timeZomne);
		userRoleTxt.sendKeys(userRole);
		batchTxt.sendKeys(batch);
		prgTxt.sendKeys(prg);

		btnSave.click();

	}

	public void clickOnUnRegUserBtn() {

		unRegUserBtn.click();
	}

	/*
	 * public Integer DeleteRegUserThen() {
	 * 
	 * return row.size();
	 * 
	 * }
	 */

	public Integer getUserCount() {
		return iconEye.size();

	}

	public String registeredEmail() {

		String regEmail = listRegEmail.getText();
		return regEmail;
	}

	public String registeredBatch() {

		String regBatch = listRegBatch.getText();
		return regBatch;
	}

	public String registeredSkill() {

		String regSkill = listRegSkill.getText();
		return regSkill;
	}

	public String registeredProgram() {
		String regProgram = listRegProgram.getText();
		return regProgram;
	}

	public String registeredFname() {
		String regFirstName = listRegFirstName.getText();
		return regFirstName;
	}

	public String registeredLname() {
		String regLastName = listRegLastName.getText();
		return regLastName;
	}

	public String registeredPhNum() {

		String regPhoneNum = listRegPhoneNum.getText();
		return regPhoneNum;
	}

	public String registeredLocation() {

		String regLocation = listRegLocation.getText();
		return regLocation;
	}

	public String registeredLinkedUrl() {

		String regLinkedUrl = listRegLinkedUrl.getText();
		return regLinkedUrl;
	}

	public String registeredUgPrg() {

		String regUgPrg = listRegUgPrg.getText();
		return regUgPrg;
	}

	public String registeredPgProg() {

		String regPgPrg = listRegPgPrg.getText();
		return regPgPrg;
	}

	public String registeredMonthsExperience() {

		String regMonthsExperience = listRegMonthsExperience.getText();
		return regMonthsExperience;
	}

	public String registeredComments() {

		String regComments = listRegComments.getText();
		return regComments;

	}

	public int UnregisteredUserCount() {

		return listUnRegEmail.size();
	}
	/*
	 * public String UnregisteredUserName() {
	 * 
	 * String unRegUserName =
	 * listUnRegUserName.get(listUnRegUserName.size()-1).getText(); return
	 * unRegUserName; }
	 */
}
