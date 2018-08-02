package com.advanceAmarica.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static LinkedHashMap<String, String> storeValues = new LinkedHashMap<String, String>();

	public static List<LinkedHashMap<String, String>> data(String filepath, String sheetName) {
		List<LinkedHashMap<String, String>> mydata = new ArrayList<LinkedHashMap<String, String>>();
		try {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row HeaderRow = sheet.getRow(0);
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				System.out.println(sheet.getPhysicalNumberOfRows());
				Row currentRow = sheet.getRow(i);
				System.out.println(currentRow.getPhysicalNumberOfCells());
				LinkedHashMap<String, String> currentHash = new LinkedHashMap<String, String>();
				for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
					
					Cell currentCell = currentRow.getCell(j);
					switch (currentCell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
						break;
					}
				}
				mydata.add(currentHash);
			}
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mydata;
	}
	
	public static void main(String args[])
	{
		List<LinkedHashMap<String, String>> configDetails = data("./src/test/java/ExcelFiles/Examples.xlsx", "Configuration");
		System.out.println(configDetails);
		LinkedHashMap<String, String> value = configDetails.get(1);
		System.out.println(value);
		String browser = configDetails.get(1).get("Browser");
		String url = configDetails.get(1).get("URL");

		System.out.println(browser);
		System.out.println(url);
	}

}
