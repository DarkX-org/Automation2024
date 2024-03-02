package com.extentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasicExtentReport {

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports=new ExtentReports();//engine
		ExtentSparkReporter sparkReporter=
				new ExtentSparkReporter("testReport.html");//reporter
		extentReports.attachReporter(sparkReporter);
		
		extentReports.createTest("Test 1");
		
		extentReports.flush();
		System.out.println("End");
		Desktop.getDesktop().browse(new File("testReport.html").toURI());
	}

}
