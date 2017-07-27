package com.mystore.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetData {

	public static String fromExcel(String filename, String sheetname, int rIndex, int cIndex){
		
		String data = null;
		try
		{
		File f = new  File("./test-data/"+filename+".xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet st = wb.getSheet(sheetname);
		Row r = st.getRow(rIndex);
		Cell c = r.getCell(cIndex);
		data = c.toString();
		}
		catch(Exception e)
		{
			
		}
		return data;
	}
	
	public static String fromProperties(String filename, String key){
		
		String value = null;
		try
		{
		File f = new  File("./test-config/"+filename+".properties");
		FileInputStream fis = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fis);
		value = (String)prop.get(key);
		}
		catch(Exception e)
		{
			
		}
		return value;
	}
}
