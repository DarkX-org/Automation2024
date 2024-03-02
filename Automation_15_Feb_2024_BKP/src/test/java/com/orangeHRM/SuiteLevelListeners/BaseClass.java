package com.orangeHRM.SuiteLevelListeners;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	public static TakesScreenshot ts;
	public static String subFolderName;
	
	@BeforeMethod
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	
	
	public static void captureSS(String SSfileName) throws Exception
	{
		LocalDateTime ldt=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("ddmmyy_HHmmss");
		subFolderName=dtf.format(ldt);
		
		ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./Screenshots/"+subFolderName+"/"+SSfileName);
		FileUtils.copyFile(src, trg);
		System.out.println("captureSS in Base class");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
}
