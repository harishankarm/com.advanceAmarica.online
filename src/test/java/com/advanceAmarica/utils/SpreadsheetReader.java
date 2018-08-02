package com.advanceAmarica.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpreadsheetReader {
	public File file;
	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	private int excelColumnCount;
	private int excelRowCount;
	private int startRowIndex;
	private int startColumnIndex;
	private int endRowIndex;
	private int endColumnIndex;

	// Excel WorkBook declaration

	public void excelPath(String path) {
		try {
			file = new File(path);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {

		}
	}

	public Workbook getWorkbook() {
		return wb;
	}

	public XSSFSheet getSheet(String sheetName) {
		return wb.getSheet(sheetName);
	}

	// Fetching data from excel sheet

	public String excelSheetValues(int excelSheetIndexNo, int excelRowNo, int excelColumnNo) {
		String exceldata = "";
		wb.getSheetAt(excelSheetIndexNo);
		DataFormatter formatter = new DataFormatter();
		exceldata = formatter.formatCellValue(sheet.getRow(excelRowNo).getCell(excelColumnNo));
		return exceldata.trim();
	}

	// Fetching data from excel sheet

	public String excelSheetValues(String excelSheetName, int excelRowNo, int excelColumnNo) {
		String exceldata = "";
		sheet = wb.getSheet(excelSheetName);
		DataFormatter formatter = new DataFormatter();
		exceldata = formatter.formatCellValue(sheet.getRow(excelRowNo).getCell(excelColumnNo));
		return exceldata.trim();
	}

	// Excel Row Count

	public int excelRowCounts(String excelSheetName) {
		sheet = wb.getSheet(excelSheetName);
		excelRowCount = sheet.getLastRowNum();
		
		return excelRowCount;
	}

	// Excel Column count

	public int excelColumnCounts(String excelSheetName) {
		sheet = wb.getSheet(excelSheetName);
		excelColumnCount = sheet.getRow(0).getLastCellNum();
		return excelColumnCount;
	}

	// This function will take the parameter has excel sheet name and table name
	// @return start row index num for the perticular table

	public int getTableStartRowIndex(String excelSheetName, String tableName) {
		sheet = wb.getSheet(excelSheetName);
		List<XSSFTable> tables = sheet.getTables();
		for (XSSFTable table : tables) {
			if (table.getName().equalsIgnoreCase(tableName)) {
				startRowIndex = table.getStartRowIndex();
				break;
			}
		}
		return startRowIndex;
	}

	// This function will take the parameter has excel sheet name and table name
	// @return start col index num for the perticular table

	public int getTableStartColIndex(String excelSheetName, String tableName) {
		sheet = wb.getSheet(excelSheetName);
		List<XSSFTable> tables = sheet.getTables();
		for (XSSFTable table : tables) {
			if (table.getName().equalsIgnoreCase(tableName)) {
				startColumnIndex = table.getStartColIndex();
				break;
			}
		}
		return startColumnIndex;
	}

	// This function will take the parameter has excel sheet name and table name
	// @return end row index num for the perticular table

	public int getTableEndRowIndex(String excelSheetName, String tableName) {
		sheet = wb.getSheet(excelSheetName);
		List<XSSFTable> tables = sheet.getTables();
		for (XSSFTable table : tables) {
			if (table.getName().equalsIgnoreCase(tableName)) {
				endRowIndex = table.getEndRowIndex();
				break;
			}
		}
		return endRowIndex;
	}

	// This function will take the parameter has excel sheet name and table name
	// @return end col index num for the perticular table

	public int getTableEndColIndex(String excelSheetName, String tableName) {
		sheet = wb.getSheet(excelSheetName);
		List<XSSFTable> tables = sheet.getTables();
		for (XSSFTable table : tables) {
			if (table.getName().equalsIgnoreCase(tableName)) {
				endColumnIndex = table.getEndColIndex();
				break;
			}
		}
		return endColumnIndex;
	}

	// Closing the workbook

	public void workbookClose() {
		try {
			fis.close();
			wb.close();
			wb = null;
		} catch (Exception e) {
		}
	}

}
