package Omayo_Blogspot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApachePOIReadData {
	 

/*========================================================================================================*/
	 
  @Test
  public void Test1_ReadDataFromExcelFile() throws EncryptedDocumentException, IOException {
	  File excelFile=new File("C:\\Users\\Admin\\Pictures\\Selenium Screenshots\\ApachePOIFile.xlsx");
	 System.out.println( excelFile.exists());
	 FileInputStream file=new FileInputStream(excelFile);
	 
  }
}
