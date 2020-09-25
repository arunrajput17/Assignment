package assignment.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import assignment.dto.AssignmentDTO;


public class ExcelReader {
	
//	public interface BundleReader {
//		ResourceBundle rb = ResourceBundle.getBundle("config");
//		public static String getValue(String key) {
//			return rb.getString(key);
//		}
//
//	}
//	
	
	static ResourceBundle readResourceBundle() {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		return rb;
	}
		
	static String getValue(String key){
		ResourceBundle rb = readResourceBundle();
		String value = rb.getString(key);
	return  value;
	}	
	
//	public static void main(String[] args) {
//		ExcelReader obj = new ExcelReader();
//		try {
//			ArrayList<CommandDTO> commands = obj.readXLS();
//			System.out.println(commands);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
	public  static ArrayList<AssignmentDTO> readXLS(int sheetNumber) throws IOException {
		sheetNumber=0;
		ArrayList<AssignmentDTO> commands = new ArrayList<>();
//		String filePath = BundleReader.getValue("xlspath");
		String filePath = getValue("xlspath");
		File file = new File(filePath);
		if(!file.exists()) {
			System.out.println("Invalid Path , File Not Exist");
			return null;
		}
		FileInputStream fs = new FileInputStream(file);
		// xlsx
		//XSSFWorkbook
		// xls
		HSSFWorkbook workBook = new HSSFWorkbook(fs);
		try {
			HSSFSheet workSheet =  workBook.getSheetAt(sheetNumber);
			Iterator<Row> rows = workSheet.rowIterator();
			int cellCounter = 0;
			boolean isFirstRowPass = false;
			while(rows.hasNext()) {
				Row row = rows.next();
//				/*To get row number*/
				int rowCount= row.getRowNum();
				if(!isFirstRowPass) {
					isFirstRowPass = true;
					continue;
				}
				AssignmentDTO commandDTO = new AssignmentDTO();
				Iterator<Cell> cells = row.cellIterator();
				cellCounter=1;
				while(cells.hasNext()) {
					Cell cell = cells.next();
					if(cell.getCellType()== CellType.STRING) {
						String value = cell.getStringCellValue();
//						System.out.println(value);
						switch(cellCounter) {
						case 1:
							commandDTO.setvalMon(value);;
							String mon=value;
							System.out.println("Mon " +mon);
							break;
						case 2:
							commandDTO.setvalTue(value);
							break;
						case 3:
							commandDTO.setvalWed(value);
							break;
						case 4:
							commandDTO.setvalThu(value);
							break;
						case 5:
							commandDTO.setvalFri(value);
							break;
						case 6:
							commandDTO.setvalSat(value);
							break;
						case 7:
							commandDTO.setvalSun(value);
							break;
							
						}
						String status= "Pass";
						ExcelWriter.writeXLS(sheetNumber,rowCount,7, status);
					}
					
					cellCounter++;
				} // Cell Loop ends
				commands.add(commandDTO);
			} // Row Loop Ends
			
		}finally {
			if(workBook!=null)
				workBook.close();
			fs.close();
		}
		
		
		
		//System.out.println(commands);
		return commands;
	}
}

	
	
