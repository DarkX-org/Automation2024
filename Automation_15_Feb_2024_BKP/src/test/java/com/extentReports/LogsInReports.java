package com.extentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogsInReports {

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter("DemoReport.html");
		extentReports.attachReporter(sparkReporter);
		
		extentReports.createTest("Text Formatting")
		.log(Status.INFO, "<b><i><ins><mark>Information One</b></i></ins></mark>");
		
		extentReports.createTest("Highlight Text")
		.info(MarkupHelper.createLabel("Highlight this Text",ExtentColor.PINK));
		
		try {
			int i=5/0;
		}catch (Exception e) {
			extentReports.createTest("Exception Test 1").info(e);
			extentReports.createTest("Exception Test 2").info(e);
		}
		
		Throwable t=new RuntimeException("Exception MSG");
		extentReports.createTest("Exception Test 3").info(t);
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("DemoReport.html").toURI());
		
		
	}

}
