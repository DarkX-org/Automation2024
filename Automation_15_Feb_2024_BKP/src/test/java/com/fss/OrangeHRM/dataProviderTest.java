package com.fss.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class dataProviderTest 
{
	
	
  @Test(dataProvider = "dp")
  public void Test1(String uid, String pass) throws Exception 
  {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  WebElement userName= driver.findElement(By.xpath("//input[@placeholder='Username']"));
	  WebElement passWord= driver.findElement(By.xpath("//input[@placeholder='Password']"));
	  WebElement submit= driver.findElement(By.xpath("//button[@type='submit']"));
	  userName.sendKeys(uid);
	  passWord.sendKeys(pass);
	  submit.click();
	  
	  Thread.sleep(3000);
	  driver.quit();
	  
  }

  @DataProvider
  public Object[][] dp() 
    {
    	Object[][] data=new Object[3][2];
    	data[0][0]="Admin";
    	data[0][1]="admin123";
    	
    	data[1][0]="Adminnnn";
    	data[1][1]="admin123";
    	
    	data[2][0]="Admin";
    	data[2][1]="ADMIN123456";
    	
    	return data;
    }
}
