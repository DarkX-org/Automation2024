package com.swagLabs.ClassLevelListeners;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static  WebDriver driver;
	public static TakesScreenshot ts;
	public static String SubFolderName;
	
	@BeforeMethod
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.get("https://www.saucedemo.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}
	
	
	public void captureScreenshot(String screenshotName) throws Exception
	{
		LocalDateTime ldt=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("ddmmyy_HHmmss");
		 SubFolderName=dtf.format(ldt);
		
		ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File
				("./Screenshots/"+SubFolderName+"/"+screenshotName);
		FileUtils.copyFile(source, target);
		System.out.println("captureScreenshot from Base class");
	}
	
	@AfterMethod
	public void closeBrowser() throws Exception
	{
		//Thread.sleep(1000);
		driver.quit();
	}
}
