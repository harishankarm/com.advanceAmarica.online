package com.advanceAmarica.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author 38283
 *
 */
public class SpreadSheetBaseFunc  extends SpreadsheetReader {
	
	private String excelPath;
	private String columnValues;
	private String rowValues;
	private int tableStartRowIndexNo;
	private int tableStartColIndexNo;
	private int tableEndRowIndexNo;
	private int tableEndColIndexNo;
	private int tablerow;
	private int tablecol;
	
	public String getExcelPath() {
		excelPath = PropertyFileReader.getPropertyValue("excel.Path");
		return excelPath;
	}

	public void printTableIndexCounts(String sheetName, String tableName)
	{
		excelPath(getExcelPath());
		tableStartRowIndexNo = getTableStartRowIndex(sheetName, tableName);
		tableStartColIndexNo = getTableStartColIndex(sheetName, tableName);
		tableEndRowIndexNo = getTableEndRowIndex(sheetName, tableName);
		tableEndColIndexNo = getTableEndColIndex(sheetName, tableName);
		System.out.println("tableStartRowIndexNo :"+tableStartRowIndexNo);
		System.out.println("tableStartColIndexNo  : "+ tableStartColIndexNo);
		System.out.println("tableEndRowIndexNo  : "+ tableEndRowIndexNo);
		System.out.println("tableEndColIndexNo  : "+ tableEndColIndexNo);
		workbookClose();
	}
	
	public List<String> getTableColumnValues(String sheetName, String tableName)
	{
		excelPath(getExcelPath());
		List<String> tableColVal = new LinkedList<String>();
		tableStartRowIndexNo = getTableStartRowIndex(sheetName, tableName);
		tableStartColIndexNo = getTableStartColIndex(sheetName, tableName);
		tableEndColIndexNo = getTableEndColIndex(sheetName, tableName);
		for(tablecol = tableStartColIndexNo; tablecol <= tableEndColIndexNo; tablecol++) {
			columnValues = excelSheetValues(sheetName, tableStartRowIndexNo, tablecol);		System.out.println(columnValues);
			tableColVal.add(columnValues);
		}
		workbookClose();
		return tableColVal;
	}
	/**
	 * 
	 * @param sheetName
	 * @param tableName
	 * @param columnName
	 * @return
	 */
	public List<String> getTableRowValues(String sheetName, String tableName, String columnName) {
		excelPath(getExcelPath());
		List<String> tableColVal = new LinkedList<String>();
		tableStartRowIndexNo = getTableStartRowIndex(sheetName, tableName);
		tableStartColIndexNo = getTableStartColIndex(sheetName, tableName);
		tableEndRowIndexNo = getTableEndRowIndex(sheetName, tableName);
		tableEndColIndexNo = getTableEndColIndex(sheetName, tableName);
		for (tablecol = tableStartColIndexNo; tablecol <= tableEndColIndexNo; tablecol++) {
			columnValues = excelSheetValues(sheetName, tableStartRowIndexNo, tablecol);
			if (columnValues.equalsIgnoreCase(columnName)) {
				for (tablerow = tableStartRowIndexNo + 1; tablerow <= tableEndRowIndexNo; tablerow++) {
					rowValues = excelSheetValues(sheetName, tablerow, tablecol);
					System.out.println(rowValues);
					tableColVal.add(rowValues);
				}
			}
		}
		workbookClose();
		return tableColVal;
	}
	
	public void getExcelRowColumn(String sheetName)
	{
		excelPath(getExcelPath());
		System.out.println("Row "+excelRowCounts(sheetName));
		System.out.println(excelColumnCounts(sheetName));
		workbookClose();
	}

	public void getExcelValues(String sheetName)
	{
		excelPath(getExcelPath());
		int row = excelRowCounts(sheetName);
		int col = excelColumnCounts(sheetName);
		for(int i=0;i<=row;i++)
		{
			for(int j=0;j<=col-1;j++)
			{
				rowValues = excelSheetValues(sheetName, i, j);
				System.out.println(rowValues);
			}
			System.out.println("------------------");
		}
		
		workbookClose();
	}
	
	//=========================
	
	/**
	 * 
	 * @param sheetName
	 * @param columnName
	 * @return
	 */
	
	public List<String> getRunnableTestCaseName(String sheetName, String columnName)
	{
		excelPath(getExcelPath());
		List<String> tcName = new LinkedList<String>();
		for(int row=1;row<=excelRowCounts(sheetName);row++)
		{
			System.out.println(getColumnNo(sheetName,columnName)+"Check");
				rowValues = excelSheetValues(sheetName, row, getColumnNo(sheetName,columnName));
				System.out.println("rowValues "+rowValues);
				if(rowValues.equalsIgnoreCase("Y"))
				{
					rowValues = excelSheetValues(sheetName, row, 0);
					System.out.println(rowValues+"rowValues");
					tcName.add(rowValues);	
				}
				
		}
		System.out.println(tcName);
		workbookClose();
		return tcName;
	}

	public int getColumnNo(String sheetName, String columnName)
	{
		int col=0;
		excelPath(getExcelPath());
		for(col=0;col<=excelColumnCounts(sheetName);col++)
		{
			rowValues = excelSheetValues(sheetName, 0, col);
			if(rowValues.equalsIgnoreCase(columnName))
			{
				break;
			}
		}
		return col;
	}
	
}
