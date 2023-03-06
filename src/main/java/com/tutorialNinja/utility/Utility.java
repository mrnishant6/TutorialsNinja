package com.tutorialNinja.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {
	
	public static Object[][] getTestdataFromExcel(String sheeetName) throws IOException {
		
		File f = new File(System.getProperty("user.dir")+ "//src//main//java//com//tutorialNinja//Testdata//TutorialNinjaTestData.xlsx");
		FileInputStream fp = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fp);
		XSSFSheet sheet = workbook.getSheet(sheeetName);
		
		int rows = sheet.getLastRowNum();
		int column = sheet.getRow(0).getLastCellNum();
		
		
		Object [] [] data = new Object [rows][column];
		
		for(int i = 0; i<rows; i++) {
			
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j = 0; j<column; j++) {
				XSSFCell cols = row.getCell(j);
				CellType cellType = cols.getCellType();
				
				
				switch(cellType) {
				
				case STRING:
					data[i][j] = cols.getStringCellValue();
					break;
					
				case NUMERIC:
					data[i][j] = Integer.toString((int)(cols.getNumericCellValue()));
					break;
				}
			}
			
		}
		
		workbook.close();
		
		return data;
		
	}
	

}
