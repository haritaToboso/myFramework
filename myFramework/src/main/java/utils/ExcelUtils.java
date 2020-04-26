package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {


	static String projPath = "";
	static XSSFWorkbook workbook = null;
	static XSSFSheet sheet;

	//Constructor to get path and sheet name
	ExcelUtils (String excelPath, String sheetName){
		try {
			workbook = new XSSFWorkbook (excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getRowCount() {

		int rowNum = 0;
		try {
			rowNum=sheet.getPhysicalNumberOfRows();
			System.out.println("No: of rows: "+rowNum);
		} 
		catch (Exception e) {
			e.getMessage();
			e.getCause();
			e.printStackTrace();
		}
		return rowNum;
	}

	public static int getColCount() {
		int colNum = 0;

		try { 
			colNum = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No: of rows: "+colNum);
		} catch (Exception e) {		
			e.getMessage();
			e.getCause();
			e.printStackTrace();
		}
		return colNum;
	}

	public static String getCellDataString(int rowNum,int colNum) {

		String cellData=null;
		try {
			cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println("Cell Data:"+cellData);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
			e.printStackTrace();
		}
		return cellData;
	}

	public static void getCellDataNumerical() {

		try {
			double cellData=sheet.getRow(2).getCell(0).getNumericCellValue();
			System.out.println("Cell Data:"+cellData);

		} catch (Exception e) {
			e.getMessage();
			e.getCause();
			e.printStackTrace();
		}
	}

}