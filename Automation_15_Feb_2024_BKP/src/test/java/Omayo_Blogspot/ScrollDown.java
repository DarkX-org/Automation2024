package Omayo_Blogspot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollDown 
{
	WebDriver driver;
	
	@BeforeMethod
	public void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
	}
	
	@AfterMethod
	public void QuitBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
  @Test(enabled=false, priority=1)
  public void Test1_Screenshot() 
  {
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("window.scrollBy(0,1000)","");
  }
  
  @Test(enabled=false, priority=0)
  public void Test2_ScrollAndScreenshot() throws IOException
  {
	  WebElement element=driver.findElement(By.xpath("//button[text()='Check this']"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  //js.executeScript("window.scrollBy(0,1000)", "");
	  js.executeScript("arguments[0].scrollIntoView();",element );
	  
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File src=ts.getScreenshotAs(OutputType.FILE);
	  File trg=new File("C:\\Users\\Admin\\Pictures\\Selenium Screenshots\\D ScrollAndScreenshot.jpg");
	  FileUtils.copyFile(src, trg);
  }
  @Test
  public void Test3()
  {
	  driver.findElement(By.linkText("onlytestingblog")).click();
	 WebElement element= driver.findElement(By.xpath("//option[@id='country10']"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView();", element);
	 // js.executeScript("window.scrollBy(0,500)", element);
  }
}
