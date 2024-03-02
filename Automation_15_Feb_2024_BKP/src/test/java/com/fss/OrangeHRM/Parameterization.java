package com.fss.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameterization 
{
  WebDriver driver;
  
	@Parameters({"urL","browserName"})
	@Test
  public void Test1(String urL, String browserName) throws Exception {
 
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		default:
			System.err.println("Browser Name is invalid");
			break;
		}
		
		driver.get(urL);
		driver.findElement(By.name("q")).sendKeys("TestNG Paramaeterizationss",Keys.ENTER);
		Thread.sleep(3000);
		driver.quit();
  }
}
