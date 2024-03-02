package Omayo_Blogspot;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowsHandled 
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
		  Thread.sleep(2000);
		//  driver.quit();
	  }
	 
/*========================================================================================================*/
	 
	
	
	@Test
  public void Test1() throws InterruptedException 
	
	{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@type='application/atom+xml']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@type='application/atom+xml']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@type='application/atom+xml']")).click();
			Thread.sleep(1000);
			
			
			
			Set<String> ids=driver.getWindowHandles();
			
		
			
			Iterator<String> itr=ids.iterator();
			
			
			String childWindow1=itr.next();
			driver.switchTo().window(childWindow1);
			Thread.sleep(2000);
			
			String childWindow2=itr.next();
			driver.switchTo().window(childWindow2);
			Thread.sleep(2000);
			
			String childWindow3=itr.next();
			driver.switchTo().window(childWindow3);
			Thread.sleep(2000);
			
			String childWindow4=itr.next();
			driver.switchTo().window(childWindow4);
			Thread.sleep(2000);
			
			driver.quit();
			
	}
}
