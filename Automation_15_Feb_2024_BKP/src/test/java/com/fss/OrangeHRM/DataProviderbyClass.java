package com.fss.OrangeHRM;

import org.testng.annotations.Test;

public class DataProviderbyClass {
  @Test(dataProvider="dp2", dataProviderClass = DataSupplierClass.class)
  public void Test3(String s) 
  {
	  System.out.println(s);
  }
}
