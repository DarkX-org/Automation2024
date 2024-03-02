package fss.AllScreenshots.ExtentReportsUpdated;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

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
	public static Capabilities capabilities;
	
	@BeforeMethod
	public void startBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
//		 capabilities=((RemoteWebDriver)driver).getCapabilities();
		
		driver.get("https://demo.nopcommerce.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}
	
	public static ExtentReports configExtentReport()
	{
		extentReports=new ExtentReports();
		 sparkReporter=new ExtentSparkReporter("FailedSSReport.html");
		
		// sparkReporter.config().setTheme(Theme.DARK);
		 sparkReporter.config().setReportName("Weekly Status Report");
		 sparkReporter.config().setDocumentTitle("Final Report by Akash");
		
		 extentReports.attachReporter(sparkReporter);
		
		extentReports.setSystemInfo("OS",System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version",System.getProperty("java.version"));
		extentReports.setSystemInfo("App URL","www.orangeHRM.com");
		extentReports.setSystemInfo("User Name","akashn@fss.co.in");
		extentReports.setSystemInfo("Password","123458899");
		
	/*	extentReports.setSystemInfo("Browser",capabilities.getBrowserName()
				+capabilities.getBrowserVersion());   */
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
	
	@AfterMethod
	public  void closeBrowser() 
	{
		//Thread.sleep(2000);
		driver.quit();
	}
	


}
