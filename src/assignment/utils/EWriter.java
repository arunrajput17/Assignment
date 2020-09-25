package assignment.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EWriter {
	
	public static void main(String[] args) throws Exception {
		
		int sheetNumber=0;
		int rowNumber=11;
		int cellNumber=1;
		String value="through dataset";
		
		
		
		File src = new File("D:\\Day Shift\\Selenium Practice\\File_Imp\\Time.xls");
		FileInputStream fis = new FileInputStream(src);
		
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		
		HSSFSheet sheet1= wb.getSheetAt(sheetNumber);
		
		//create row
		sheet1.createRow(rowNumber);
//		Row row= sheet1.createRow(7);
//		Cell cell= row.createCell(4);
		sheet1.getRow(rowNumber).createCell(cellNumber).setCellValue(value);
//		sheet1.getRow(5).createCell(2).setCellValue("Fail");
		
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);		
		
		wb.close();
		System.out.println("File write successfull");
		
	}
	

}
