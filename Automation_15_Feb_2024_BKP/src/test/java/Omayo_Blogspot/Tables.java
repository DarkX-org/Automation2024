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

public class Tables 
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
		  //Thread.sleep(2000);
		  driver.quit();
	  }
	 
/*========================================================================================================*/
	 
  @Test
  public void Test1() 
  {
	  List<WebElement> Headings= driver.findElements(By.xpath("//table[@id='table1']/thead/tr"));
	  int size=Headings.size();
	  System.out.println(size);
	  for(int i=0;i<size;i++)
	  {
		  System.out.println("|"+Headings.get(i).getText()+"|");
		  
	  }
	  
	  List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
	  int size2=rows.size();
	  for(int i=0;i<size2;i++)
	  {
		  System.out.println("|"+rows.get(i).getText()+"|");
		  
	  }
	  
	  
  }
}
