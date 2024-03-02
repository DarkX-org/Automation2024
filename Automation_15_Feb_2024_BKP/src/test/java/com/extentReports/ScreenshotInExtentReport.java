package com.extentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotInExtentReport {
  @Test
  public void Test1() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.saucedemo.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File src=ts.getScreenshotAs(OutputType.FILE);
	  File file=new File("C:\\Users\\Admin\\Pictures\\Selenium Screenshots\\SS.jpg");
	  String screenshotPath=file.getAbsolutePath();
	  FileUtils.copyFile(src, file);
	  
	  
	  ExtentSparkReporter sparkReporter=new ExtentSparkReporter("ScreenshotReport.html");
	  ExtentReports extentReports=new ExtentReports();
	  extentReports.attachReporter(sparkReporter);
	  
	  extentReports.createTest("Screenshot Test 1")
	  .info("Url opened successfully")
	  .info("This is logger")
	  .addScreenCaptureFromPath(screenshotPath, "Home Screen")
	  .log(Status.INFO,MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath, "LogLevel Home Screenshot").build());
	  
	  extentReports.flush();
	  driver.quit();
	  Desktop.getDesktop().browse(new File("ScreenshotReport.html").toURI());
  }
}
