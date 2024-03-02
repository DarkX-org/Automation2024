package Omayo_Blogspot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertVerifiedOnPageText 
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
		WebElement text=driver.findElement(By.xpath("//div[@id='post-body-9023929218208337252']"));
		System.out.println(text.getText());
		
		String str=text.getText();
		//Hard Assert
		Assert.assertEquals(str, "This is a sample text in the Page One..","Hard assert Failed by AK.");
	
		
		System.out.println("Hard assert End");
	}
	
	@Test
	public void Test2()
	{
		WebElement text=driver.findElement(By.xpath("//div[@id='post-body-9023929218208337252']"));
		System.out.println(text.getText());
		
		String str=text.getText();
		
		//Soft Assert
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(str, "This is a sample text in the Page One..", "Soft assert failed by Ak");
		sa.assertAll();//if we comment this statement, this test case get pass no exception occurred for wrong result
		
		System.out.println("Soft Assert End");
	}
}
