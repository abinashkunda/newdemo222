package com.crm.vtiger.Genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/*
	 * author @  Abinash
	 */
	/**
	 * This method used to read data from excel by specifying sheet name,row number and cell number
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws  
	 * @throws Throwable
	 */

	public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable  {
	FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet(sheetName);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	return cell.getStringCellValue();


	}

}
