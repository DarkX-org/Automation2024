package Omayo_Blogspot;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	
	 
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
	 

  @Test(enabled=false)
  public void Test1() throws InterruptedException 
  {
	  WebElement button=driver.findElement(By.xpath("//input[@id='timerButton']"));
	  Thread.sleep(1000);
	  if(button.isEnabled())
	  {
		  driver.findElement(By.xpath("//input[@id='timerButton']")).click();
		  Alert alt=driver.switchTo().alert();
		  Thread.sleep(1000);
		  alt.accept();
		  	
	  }
	  else
	  {
		  Thread.sleep(5000);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.findElement(By.xpath("//input[@id='timerButton']")).click();
		  Alert alt=driver.switchTo().alert();
		  Thread.sleep(1000);
		  alt.accept();
	  }
	  
	  
  }
  @Test(enabled=false)
  public void Test2() throws InterruptedException
  {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='prompt']")).click();
	  Thread.sleep(1000);
	  Alert alt=driver.switchTo().alert();
	  Thread.sleep(1000);
	  alt.sendKeys("AKKKKK");
	  Thread.sleep(1000);
	  alt.accept();
	  
	//a[text()='onlytestingblog']
  }
  
  @Test(enabled=false)
  public void Test3() throws InterruptedException
  {
	  
	  driver.findElement(By.xpath("//a[text()='onlytestingblog']")).click();
	  
	  driver.findElement(By.xpath("//button[text()='Show Me Confirmation']")).click();
	 // Thread.sleep(1000);
	  Alert alt=driver.switchTo().alert();
	 // Thread.sleep(1000);
	  alt.accept();
	  
	  System.out.println(driver.findElement(By.xpath("//div[@id='demo']")).getText());
	  
	//  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[text()='Show Me Confirmation']")).click();
	//  Thread.sleep(1000);
	  alt=driver.switchTo().alert();
	 // 
	  alt.dismiss();
	  
	  System.out.println(driver.findElement(By.xpath("//div[@id='demo']")).getText());
	  
	  
	
  }
  
  @Test
  public void Test4() throws InterruptedException
  {
	  driver.findElement(By.xpath("//a[text()='onlytestingblog']")).click();  
	  driver.findElement(By.xpath("//button[text()='Show Me Prompt']")).click();
	  Alert alt=driver.switchTo().alert();
	  
	  Thread.sleep(1000);
	System.out.println(alt.getText());  
	  Thread.sleep(2000);
	  alt.accept();
  }
}
