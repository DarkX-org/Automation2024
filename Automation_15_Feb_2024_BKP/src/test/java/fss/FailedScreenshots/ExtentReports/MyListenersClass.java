package fss.FailedScreenshots.ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListenersClass extends BaseClass implements ITestListener
{
	   
	public  ExtentReports reports=configExtentReport();
	public ExtentTest eTest;
	@Override
	public void onTestStart(ITestResult result) 
	{
		String testName=result.getTestName();
		String methodName=result.getMethod().getMethodName();
		 eTest=reports.createTest(methodName);
		eTest.log(Status.INFO, methodName+" Method Execution Started")
				;
		 
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getTestName();
		String methodName=result.getMethod().getMethodName();
		
		eTest.log(Status.PASS, methodName+" method pass");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=result.getTestName();
		String methodName=result.getMethod().getMethodName();
		
		eTest.log(Status.SKIP, methodName+" method Skipped");
	}

	

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String methodName=result.getMethod().getMethodName();
		String SSUpdatedPath=configScrenshots(methodName);
		
		
		eTest.log(Status.FAIL, methodName+" is failed");
		eTest.addScreenCaptureFromPath(SSUpdatedPath, methodName);
		
	
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
		
		reports.flush();
		
		try {
			Desktop.getDesktop().browse(new File("FailedSSReport.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
