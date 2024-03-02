package Omayo_Blogspot;

import java.net.HttpURLConnection;
import java.net.URL;
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

public class BrokenLinks {
	 
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
		driver.manage().window().minimize();
	}
	
	 @AfterMethod
	  public void CloseBrowser() throws InterruptedException
	  {
		  Thread.sleep(1000);
		 driver.quit();
	  }
	 
/*========================================================================================================*/
	 
  @Test(enabled=false)
  public void f() {
	  
	  List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println("All Link count:= "+allLinks.size());
		int count=0;
		for(int i=0;i<allLinks.size();i++)
		{
			String url=allLinks.get(i).getAttribute("href");
			if(url==null || url.isEmpty())
			{
				System.out.println(url +" is invalid XXXXXXXXXXXX");
				continue;
			}
			try {
				URL u=new URL(url);
				HttpURLConnection huc=(HttpURLConnection)u.openConnection();
				huc.connect();
				int ResponseCode=huc.getResponseCode();
				if(ResponseCode>=400)
				{
					System.out.println("This Brocken XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX "+ url);
					
					count++;
				}
				else
				System.out.println("Valid URL==> "+url);
			}
			catch(Exception e)
			{}
		}
		System.out.println("Brocken URL Count= "+count);
  	}
  
  @Test
  public void Test2_AllLinksOfWebSite()
  {
	  List<WebElement> links=driver.findElements(By.tagName("a"));
	  int linkSize=links.size();
	  System.out.println("All links count= "+linkSize);
	  
	   
	  
	  for(int i=0;i<linkSize;i++)
	  {
		  String str=links.get(i).getAttribute("href");
		  System.out.println(str);
	  }
	  
  }
}
