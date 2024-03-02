package com.swagLabs.ClassLevelListeners;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListenersClass extends BaseClass implements ITestListener
{

	@Override
	public void onTestFailure(ITestResult result) 
	{
		try {
			captureScreenshot(result.getName()+".jpg");
			System.out.println("Screenshot Captured... from MyListenersClass");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
