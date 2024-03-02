package com.extentReports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class NewTest 
{
	WebDriver driver;	
  @Test(testName = "Test1")
  public void Test1() throws Exception 
  {
	  System.out.println("Test1");
	  

		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("Adminsss");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin1234");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(false);
		sa.assertAll();
		
	  
  }
  
  @Test(testName = "Test2")
  public void Test2() throws Exception 
  {
	  
	  System.out.println("Test2");

		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("Adminsss");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin1234");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(false);
		sa.assertAll();
		
	  
  }
  
  @Test(testName = "Test3")
  public void Test3() throws Exception 
  {
	  
	  System.out.println("Test3");

		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("Adminsss");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin1234");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
	
		
	  
  }
}
