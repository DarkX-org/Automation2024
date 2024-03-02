package com.orangeHRM.SuiteLevelListeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class NewTest2 extends BaseClass
{
  @Test
  public void Test1() 
  {
	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("dsfsdf");
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dsfsdf");
	  driver.findElement(By.xpath("//input[@id='login-button']")).click();
	  
	  Assert.assertTrue(false);
	  System.out.println("Test1 Executed");

  }
  
  @Test
  public void Test2() 
  {
	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("dsfsdf");
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dsfsdf");
	  driver.findElement(By.xpath("//input[@id='login-button']")).click();
	  
	  Assert.assertTrue(false);
	  System.out.println("Test2 Executed");

  }
}
