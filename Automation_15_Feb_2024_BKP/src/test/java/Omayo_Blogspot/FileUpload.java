package Omayo_Blogspot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload 
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
		  driver.quit();
	  }
	 
/*========================================================================================================*/
	 
	
	 
  @Test
  public void Test1() throws InterruptedException 
  {
	  
	  driver.findElement(By.xpath("//button[text()='Try it']")).click();//random click for scroll down
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='uploadfile']"))
	  .sendKeys("C:\\Users\\Admin\\Pictures\\Screenshots\\EclipseScreenshots\\p1.png");
  }
}
