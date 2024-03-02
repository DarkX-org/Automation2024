package Omayo_Blogspot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot 
{
	 
/*=================================Common Code=====================================================*/
WebDriver driver;
	@BeforeMethod
	public void LaunchBrowser()
	{
		/*  System.setProperty("webdriver.chrome.driver", 
		"D:\\Softwares\\Testing Softwares\\chromedriver-win64\\chromedriver.exe"); */

		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	 @AfterMethod
	  public void CloseBrowser() throws InterruptedException
	  {
		 // Thread.sleep(2000);
		  driver.quit();
	  }
	 
/*========================================================================================================*/
	 
	
	
  @Test(enabled=true)
  public void Test1_common() throws IOException 
  {
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File src=ts.getScreenshotAs(OutputType.FILE);
	  File trg=new File("C:\\Users\\Admin\\Pictures\\Selenium Screenshots\\A randomTop.jpg");
	  FileUtils.copyFile(src, trg);
  }
  
  @Test(enabled=true)
  public void Test2_Element() throws IOException 
  {
	
	 WebElement element=driver.findElement(By.xpath("//div[@class='widget-content']/h1"));
	 File src=element.getScreenshotAs(OutputType.FILE);
	 File trg=new File("C:\\Users\\Admin\\Pictures\\Selenium Screenshots\\B Element.jpg");
	 FileUtils.copyFile(src, trg);
  }
  
  @Test(enabled=true)
  public void Test3_Portion() throws IOException 
  {
	
	  WebElement portion=driver.findElement(By.xpath("//div[@class='widget HTML' and @data-version='1' and @id='HTML30']"));
	 File src= portion.getScreenshotAs(OutputType.FILE);
	 File trg=new File("C:\\Users\\Admin\\Pictures\\Selenium Screenshots\\C SomePortion.jpg");
	  FileUtils.copyFile(src, trg);
  }
  
}
