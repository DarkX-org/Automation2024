package com.orangeHRM.SuiteLevelListeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListenersClass extends BaseClass implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			captureSS(result.getName()+".jpg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
