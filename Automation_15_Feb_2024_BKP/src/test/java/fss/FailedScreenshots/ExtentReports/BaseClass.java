package fss.FailedScreenshots.ExtentReports;

import java.awt.Desktop;
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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static ExtentSparkReporter sparkReporter;
	public static TakesScreenshot ts;
	//public static String SSPath;
	public static String subFolderName;
	public static ExtentTest eTest;
	
	@BeforeMethod
	public void startBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}
	
	public static ExtentReports configExtentReport()
	{
		extentReports=new ExtentReports();
		 sparkReporter=new ExtentSparkReporter("FailedSSReport.html");
		extentReports.attachReporter(sparkReporter);
		//eTest=extentReports.createTest(name);
		return extentReports;
	}
	
	public String configScrenshots(String name)
	{
		LocalDateTime ldt=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("DDMMYY_HHMMSS");
		subFolderName=dtf.format(ldt);
		
		ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\Admin\\Pictures\\Selenium Screenshots\\Screenshots\\"+subFolderName+"\\"+name+".jpg");
		
		
		try { FileUtils.copyFile(src, trg); }
		catch (IOException e) { e.printStackTrace();}
		String SSPath=trg.getAbsolutePath();
			return SSPath;
		
	}
	
	
//	public static void screenshotAndExtentReportConfig(String name)
//	{
//		extentReports=new ExtentReports();
//		 sparkReporter=new ExtentSparkReporter("FailedSSReport.html");
//		extentReports.attachReporter(sparkReporter);
//		
//		LocalDateTime ldt=LocalDateTime.now();
//		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("DDMMYY_HHMMSS");
//		subFolderName=dtf.format(ldt);
//		
//		ts=(TakesScreenshot)driver;
//		File src=ts.getScreenshotAs(OutputType.FILE);
//		File trg=new File("C:\\Users\\Admin\\Pictures\\Selenium Screenshots\\"+subFolderName+"\\"+name+".jpg");
//		 SSPath=trg.getAbsolutePath();
//		
//		try { FileUtils.copyFile(src, trg); }
//		catch (IOException e) { e.printStackTrace();}
//		eTest=extentReports.createTest(name);
//	}
	
	@AfterMethod
	public  void closeBrowser() 
	{
		//Thread.sleep(2000);
		driver.quit();
	}
	


}
