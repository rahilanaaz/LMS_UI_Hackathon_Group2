package Page;

import base.Base;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePaginationPage extends Base {

	@FindBy(id = "btnSearch")
	WebElement searchBtn;

	@FindBy(id = "editIcon")
	WebElement iconEdit;

	@FindBy(id = "trashIcon")
	WebElement iconTrash;

	@FindBy(id = "eyeIcon")
	WebElement iconEye;

	@FindBy(id = "userHyperlink")
	WebElement hyperlinkUser;

	@FindBy(id = "unregisteredUserEditIcon")
	WebElement editIconUnregisteredUser;

	@FindBy(id = "unregisteredTrashIcon")
	WebElement trashIconUnregistered;

	@FindBy(id = "arrowButton")
	WebElement arrowButton;

	List<WebElement> userList;
	// WebElement tablerow;

	public ManagePaginationPage() {

		PageFactory.initElements(driver, this);
	}

	public int getTableRowCount() {
		return userList.size();
	}

	public boolean hasArrows() {
		return arrowButton != null;
	}

}
