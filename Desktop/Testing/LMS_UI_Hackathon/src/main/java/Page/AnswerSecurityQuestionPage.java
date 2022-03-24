package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.Base;

public class AnswerSecurityQuestionPage extends Base {

	@FindBy(id = "ForgotPassword")
	WebElement ForgotPassword;

	@FindBy(id = "UserLoginName")
	WebElement User;

	@FindBy(id = "nextButton")
	WebElement NextButton;

	@FindBy(id = "getQuestion")
	WebElement SecurityQuestion;

	@FindBy(id = "answerSecurtiy")
	WebElement ansSecurity;

	@FindBy(id = "resetLink")
	WebElement resetLink;

	@FindBy(id = "unregUser")
	WebElement unRegUser;

	public AnswerSecurityQuestionPage() {
		PageFactory.initElements(driver, this);
	}

	public void forgotPasswordClick() {
		// if this button got clicked ForgotPassword.click()
		ForgotPassword.click();
		// driver.navigate().to(prop.getProperty("ansSecurityPage"));
	}

	public String validateAnswerSecurityPage() {
		return driver.getTitle();
	}

	public String getPresentUrl() {
		return driver.getCurrentUrl();
	}

	public String securityPage(String UserName) {

		User.sendKeys(UserName);
		NextButton.click();

		return SecurityQuestion.getText();

	}

	public String responseToAnswer() {

		String Answer = ansSecurity.getText();
		return Answer;
		// if answer is correct send reset link(message)- registerd user
		// if answer is wrong send unregistered user message
	}

	public boolean getResetLinkeSentMessage() {
		resetLink.getText();
		return resetLink.isDisplayed();
	}

	public boolean getUnRegResetLinkeSentMessage() {
		unRegUser.getText();
		return unRegUser.isDisplayed();
	}
	// check close displayed

}
