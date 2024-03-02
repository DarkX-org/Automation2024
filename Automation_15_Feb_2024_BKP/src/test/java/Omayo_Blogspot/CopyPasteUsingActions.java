package Omayo_Blogspot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CopyPasteUsingActions {
	
	 
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
  public void Test1() 
  
  {
	  driver.findElement(By.xpath("//textarea[normalize-space()='The cat was playing in the garden.']")).click();
	  Actions act=new Actions(driver);
	  act.keyDown(Keys.CONTROL).sendKeys("a");
	  act.keyUp(Keys.CONTROL).perform();
	  
	  act.keyDown(Keys.CONTROL).sendKeys("c");
	  act.keyUp(Keys.CONTROL).perform();
	  driver.findElement(By.xpath("//textarea[@id='ta1']")).click();
	  act.keyDown(Keys.CONTROL).sendKeys("v");
	  act.keyUp(Keys.CONTROL).perform();
	  
  }
}
