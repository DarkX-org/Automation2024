package com.fss.OrangeHRM;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataSupplierClassByUsingExcelFile 
{
  @DataProvider(name="excelDataProvider")
  public String[][] exceldp() throws Exception
  {
	  File excelFile=new File
		("C:\\Users\\Admin\\Pictures\\Selenium Screenshots\\OrangeHRMLoginTestData.xlsx");
	  
	  FileInputStream fis=new FileInputStream(excelFile);
	  XSSFWorkbook workbook=new XSSFWorkbook(fis);
	  XSSFSheet sheet=workbook.getSheet("Sheet1");
	  int noOfRows=sheet.getPhysicalNumberOfRows();
	  int noOfCols=sheet.getRow(0).getLastCellNum();
	  
	  String[][] data=new String[noOfRows-1][noOfCols];
	  for(int i=0;i<noOfRows-1;i++)
	  {
		  
		  for(int j=0;j<noOfCols;j++)
		  {
			  DataFormatter df=new DataFormatter();
			 data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j)); 
		  }
	  }
	  workbook.close();
	  fis.close();
	  return data;
  }
}
