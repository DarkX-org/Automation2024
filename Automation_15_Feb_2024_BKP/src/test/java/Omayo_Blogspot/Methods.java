package Omayo_Blogspot;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Methods {
	 
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
		  Thread.sleep(1000);
		 driver.quit();
	  }
	 
/*========================================================================================================*/
	 
	 
  @Test
  public void Test1_Methods() 
  {
	  System.out.println();
	  System.out.println("Page Title: "+driver.getTitle());
	  System.out.println("Current page URL: "+driver.getCurrentUrl());
	  System.out.println("Current Page Source: "+driver.getPageSource());
	  
  }
}
