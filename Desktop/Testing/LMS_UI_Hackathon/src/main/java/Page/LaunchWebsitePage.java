package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class LaunchWebsitePage extends Base {

	@FindBy(id = "Login")
	WebElement Login;

	public LaunchWebsitePage() {
		PageFactory.initElements(driver, this);
	}

	public String LaunchUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isLoginDisplayed() {
		return Login.isDisplayed();

	}

}
