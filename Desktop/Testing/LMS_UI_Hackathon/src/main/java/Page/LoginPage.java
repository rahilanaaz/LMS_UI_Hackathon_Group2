package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class LoginPage extends Base{
	
	@FindBy(id = "Login") 
	WebElement Login;
	
	@FindBy(id ="UserLoginName") 
	WebElement User;
	
	@FindBy(id="UserPassword") 
	WebElement userPassInfo;
	
	@FindBy(id="Submit") 
	WebElement submit;
	
	@FindBy(id="Logout")
	WebElement Logout;
	
	@FindBy(id="errorMessage")
	WebElement ErrorMessage;
	
	@FindBy(id="ForgotPassword")
	WebElement ForgotPassword;
	
	
	
	//constructor
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
		//methods  to do actions on objects
	public void loginClick(){
		Login.click();
	}
	
	public String validateLoginPage(){
		return driver.getTitle();
		
	}
	
	public String signInPage(String UserName,String Password) {
		User.sendKeys(UserName);
		userPassInfo.sendKeys(Password);
		submit.click();
		
		return driver.getTitle();
		
	}	
	public boolean isLogoutDisplayed(){
			return Logout.isDisplayed();
		}
	
	public String getpresentUrl() {
		return driver.getCurrentUrl();
	}
		
	public String getInvalidCredentialErrorMessage() {
	  return	ErrorMessage.getText();
	}
	
	public AnswerSecurityQuestionPage forgotPasswordClick() {
		//if this button got clicked 
			ForgotPassword.click();
			//driver.navigate().to(prop.getProperty("ansSecurityPage"));
			return new AnswerSecurityQuestionPage();
	}
}
