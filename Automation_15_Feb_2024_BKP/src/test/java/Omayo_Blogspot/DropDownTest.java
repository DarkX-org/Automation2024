package Omayo_Blogspot;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownTest {

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
  @Test
  public void DropDownTest1() throws InterruptedException 
  {

		
		Select dd=new Select(driver.findElement(By.xpath("//select[@id='drop1']")));
		dd.selectByIndex(3);
		Thread.sleep(1000);
		dd.selectByValue("mno");
		Thread.sleep(1000);
		dd.selectByVisibleText("doc 1");
		
		
		
  }
  
 
  
  @Test
  public void DropDownTest2()
  {
		Select dd=new Select(driver.findElement(By.xpath("//select[@id='drop1']")));

	  List<WebElement> ddList=dd.getOptions();
		int size=ddList.size();
		
		for(int i=0;i<size;i++)
		{
			System.out.println(ddList.get(i).getText()); 
		}
  }
  
  
  
}
