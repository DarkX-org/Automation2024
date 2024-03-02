package Omayo_Blogspot;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class MultiSelectionBoxTest 
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
	  public void Test1() 
	  {
		  Select options=new Select(driver.findElement(By.xpath("//select[@id='multiselect1']")));
		  List<WebElement> list=options.getOptions();
		  int size=list.size();
		  for(int i=0;i<size;i++)
		  {
			  System.out.println(list.get(i).getText()); 
			  
		  }
		  options.selectByValue("volvox");
		  
		  Actions action=new Actions(driver);
		  action.keyDown(Keys.CONTROL);
		  options.selectByValue("swiftx");
		  action.keyUp(Keys.CONTROL);
	  }

}
