package com.fss.OrangeHRM;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoExcelFile 
{
	public static void main(String args[]) throws Exception
	{
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet();
		sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue("Akash");
		sheet.getRow(0).createCell(1).setCellValue("Naykude");
		
		sheet.createRow(1);
		sheet.getRow(1).createCell(0).setCellValue("FSS");
		sheet.getRow(1).createCell(1).setCellValue("CISS");
		
		File file=new File
				("C:\\Users\\Admin\\Pictures\\Selenium Screenshots\\CreateFile.xlsx");
		FileOutputStream fos=new FileOutputStream(file);
		workbook.write(fos);
		workbook.close();
		System.out.println("File Created");
	}
 
}
