package com.fss.OrangeHRM;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataSupplierClass {
 
	@DataProvider(name="dp1")
	public String[] dp1()
	{
		String[] data=new String[] {
			"akash","Naykude","Akluj"	
		};
		return data;
	}
	
	@DataProvider(name="dp2")
	public String[] dp2()
	{
		String[] data=new String[] {
			"AKK","NNNN","AKKKLLLUUUJJJJ"	
		};
		return data;
	}
	
	@DataProvider(name="datByExcel")
	public String[] datByExcel()
	{
		String[] data=new String[] {
			"AKK","NNNN","AKKKLLLUUUJJJJ"	
		};
		return data;
	}
}
