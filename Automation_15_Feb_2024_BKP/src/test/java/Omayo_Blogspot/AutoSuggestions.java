package Omayo_Blogspot;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestions {
	/*=================================Common Code=====================================================*/
	WebDriver driver;
		@BeforeMethod
		public void LaunchBrowser()
		{
			/*  System.setProperty("webdriver.chrome.driver", 
			"D:\\Softwares\\Testing Softwares\\chromedriver-win64\\chromedriver.exe"); */

			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			driver.get("https://google.com/");
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
  public void test1() throws InterruptedException 
  {
	  //driver.findElement(By.xpath("//textarea[@name='q']")).click();
	  driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("SDET");
	  Thread.sleep(1000);
	  List<WebElement> list=driver.findElements(By.xpath("//div[@jsname='erkvQe']/div/ul/li"));
	  int size=list.size();
	  System.out.println("Size= "+size);
	  for(int i=0;i<size;i++)
	  {
		  System.out.println(" "+ list.get(i).getText());
		  
	  }
	  list.get(2).click();
  }
}
