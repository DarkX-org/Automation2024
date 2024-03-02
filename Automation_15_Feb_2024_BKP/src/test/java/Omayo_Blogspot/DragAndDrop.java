package Omayo_Blogspot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
 
	 
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
		 Thread.sleep(1000);
		  WebElement readOnlyText= driver.findElement(By.xpath("//input[@id='rotb']"));
		 
		
		  WebElement planText= driver.findElement(By.xpath("//textarea[@rows='10' and @cols='30']"));	  
		  
		  Actions act=new Actions(driver);
		  Thread.sleep(1000);
		  act.doubleClick(readOnlyText).perform();
		  
		  Thread.sleep(1000);
		  planText.click();
		  
		  Thread.sleep(1000);
		  act.keyDown(Keys.CONTROL).sendKeys("a").perform();
		  act.keyUp(Keys.CONTROL).perform();
		  WebElement TextBox1=driver.findElement(By.xpath("//textarea[@id='ta1']"));
		  Thread.sleep(1000);
		  act.dragAndDrop(planText, TextBox1).perform();
		  
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@id='textbox1']")).clear();
		//button[@id='but1']
		  
		System.out.println("1: isDisplayed: "+driver.findElement(By.xpath("//button[@id='but1']")).isDisplayed());  
		System.out.println("1: isEnabled: "+driver.findElement(By.xpath("//button[@id='but1']")).isEnabled()); 
		
		System.out.println("2: isDisplayed: "+driver.findElement(By.xpath("//button[@id='but2']")).isDisplayed()); 
		System.out.println("2: isEnabled: "+driver.findElement(By.xpath("//button[@id='but2']")).isEnabled()); 
		  
  }
}
