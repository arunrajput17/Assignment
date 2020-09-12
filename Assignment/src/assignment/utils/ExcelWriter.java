package assignment.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	
	static ResourceBundle readResourceBundle() {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		return rb;
	}
		
	static String getValue(String key){
		ResourceBundle rb = readResourceBundle();
		String value = rb.getString(key);
	return  value;
	}	
	
	public static  void writeXLS(int sheetNumber,int rowNumber,int cellNumber,String writeText) throws IOException{
//		sheetNumber=0;
		String filePath = getValue("xlspath");
		File file = new File(filePath);
		if(!file.exists()) {
			System.out.println("Invalid Path , File Not Exist");
			return;
		}
		
		FileInputStream fs = new FileInputStream(file);
		HSSFWorkbook workBook = new HSSFWorkbook(fs);
		
		HSSFSheet workSheet =  workBook.getSheetAt(sheetNumber);
		
//		workSheet.createRow(rowNumber);
		workSheet.getRow(rowNumber).createCell(cellNumber).setCellValue(writeText);
		
		FileOutputStream fout = new FileOutputStream(file);
		workBook.write(fout);
		workBook.close();
		
		
		
//		 System.out.println("END OF WRITING DATA IN EXCEL");
		 }


}
