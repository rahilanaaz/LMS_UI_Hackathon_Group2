package allurelistener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.Base;
import io.qameta.allure.Attachment;

public class allurelistener extends Base implements  ITestListener{
	private static String getTestMethodName(ITestResult iTestResult)
	{
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	@Attachment(value ="Page screenshot", type="image/png")
	public byte[] saveScreenshotPng(WebDriver driver)
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
	}
	
	@Attachment(value ="{0}", type="text/plain")
	public static String saveTextLog(String message)
	{
		return message;
		
	}
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestSuccess(ITestResult iTestResult) {
		
	}
		
	
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure" + getTestMethodName(iTestResult) + "failed");
		Object testClass = iTestResult.getInstance();
		WebDriver driver = Base.getDriver();
		System.out.println("inside the report code"+driver);
		if(driver instanceof WebDriver)
		{
			System.out.println("Screenshot captured"+ getTestMethodName(iTestResult) + "screenshotCaptured");
			saveScreenshotPng(driver);
		}
		saveTextLog(getTestMethodName(iTestResult)+"Failed and screenshot taken");
	
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
