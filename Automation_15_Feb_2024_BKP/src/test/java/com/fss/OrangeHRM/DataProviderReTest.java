package com.fss.OrangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderReTest 
{
	WebDriver driver;
	
	
	
  @Test( dataProvider="AkashData")
  public void Test1(String uid, String pass) throws Exception 
  {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com");
	  
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(uid);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		Thread.sleep(5000);
		driver.quit();
		
  }
	
	@DataProvider(name="AkashData")
	public Object[][] DPR()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="Admin";
		data[0][1]="admin123";
		data[1][0]="adminsdg";
		data[1][1]="admin123";
		
		return data;
	}
	
}
