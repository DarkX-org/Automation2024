package com.fss.OrangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromExcelFileUsingDataProvider 
{
	
	 @Test(dataProvider="excelDataProvider", 
			  dataProviderClass = DataSupplierClassByUsingExcelFile.class)
	  public void Test1(String uid, String pass) throws Exception 
	  {
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		  WebElement userName= driver.findElement(By.xpath("//input[@placeholder='Username']"));
		  WebElement passWord= driver.findElement(By.xpath("//input[@placeholder='Password']"));
		  WebElement submit= driver.findElement(By.xpath("//button[@type='submit']"));
		  userName.sendKeys(uid);
		  Thread.sleep(1000);
		  passWord.sendKeys(pass);
		  Thread.sleep(1000);
		  submit.click();
		  
		  Thread.sleep(3000);
		  driver.quit();
		  
	  }

}
