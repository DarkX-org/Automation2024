package Omayo_Blogspot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iFrames {
	 
/*=================================Common Code=====================================================*/
WebDriver driver;
	@BeforeMethod
	public void LaunchBrowser()
	{
		/*  System.setProperty("webdriver.chrome.driver", 
		"D:\\Softwares\\Testing Softwares\\chromedriver-win64\\chromedriver.exe"); */

		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
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
  public void Test1() throws InterruptedException {
	 
	  driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
	  WebElement pframe=  driver.findElement(By.xpath("//div[@class='container iframes-page-container']"));
	  driver.switchTo().frame(pframe);
	  
	  WebElement cframe=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]"));
	  driver.switchTo().frame(cframe);
	  driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]")).sendKeys("Akashhh");
	  
	  
  }
}
