package Omayo_Blogspot;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertyFile {
  @Test
  public void Test1() throws IOException {
	  Properties prop=new Properties();
	  FileInputStream configFile=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Automation_15_Feb_2024\\src\\main\\java\\config.properties");
	  prop.load(configFile);
	System.out.println(prop.getProperty("uid"));
	System.out.println(prop.getProperty("pwd"));
	    
  }
}
