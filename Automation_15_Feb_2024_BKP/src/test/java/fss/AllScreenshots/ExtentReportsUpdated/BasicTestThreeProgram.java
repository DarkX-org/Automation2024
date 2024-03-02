package fss.AllScreenshots.ExtentReportsUpdated;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(fss.AllScreenshots.ExtentReportsUpdated.MyListenersClass.class)
public class BasicTestThreeProgram extends BaseClass
{
	
	SoftAssert sa;
	
  @Test(priority=1)
  public void pageTitle_Test1() 
  {
	  System.out.println("Test 1 running");
	  driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	  String actualTitle="nopCommerce demo store. Login";
	  String expectedTitle=driver.getTitle();
	  
		sa=new SoftAssert();
		sa.assertEquals(actualTitle, expectedTitle,"Title Mismatched");
		sa.assertAll();
		System.out.println("Test 1 Finished Successfully");
  }
  
  @Test(priority=2)
  public void loginTest_Test2() 
  {
	  System.out.println("Test 2 running");
	  driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("akashnaykude@gmail.com");
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Admin12345");
	  driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	  
	  String actualTitle="nopCommerce demo store. Welcome";
	  String expectedTitle=driver.getTitle();
	  
		sa=new SoftAssert();
		sa.assertEquals(actualTitle, expectedTitle,"Title Mismatched");
		sa.assertAll();
		System.out.println("Test 2 Finished Successfully");
  }
  
  @Test(priority=3, dependsOnMethods = {"loginTest_Test2"})
  public void dependentTest_Test3() 
  {
	  driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("akash2010nay@gmail.com");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(false);
		sa.assertAll();
  }
  @Test(priority=4)
  public void TitleTest2_Test4() 
  {
	  System.out.println("Test 4 running");
	  driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	  String actualTitle="nopCommerce demo store. Login";
	  String expectedTitle=driver.getTitle();
	  
		sa=new SoftAssert();
		sa.assertEquals(actualTitle, expectedTitle,"Title Mismatched");
		sa.assertAll();
		System.out.println("Test 4 Finished Successfully");
  }
  
  @Test(priority=5)
  public void loginTest2_Test5() 
  {
	  System.out.println("Test 5 running");
	  driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("dummyAccount12345@gmail.com");
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Admin12345");
	  driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	  
	  String actualTitle="nopCommerce demo store. Welcome";
	  String expectedTitle=driver.getTitle();
	  
		sa=new SoftAssert();
		sa.assertEquals(actualTitle, expectedTitle,"Title Mismatched");
		sa.assertAll();
		System.out.println("Test 5 Finished Successfully");
  }
  
}
