package com.utilityfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.text.DateFormatter;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	static String excelPath = "C:\\Users\\tejas\\eclipse-workspace\\DataDriven\\excel\\Data.xlsx";
	static String data;

	public static String readParticularCellData(int row, int column) {
		File file = new File(excelPath);
		try {
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheet("Login");
			Row row1 = sheet.getRow(row);
			Cell cell = row1.getCell(column);

			DataFormatter df = new DataFormatter();
			data = df.formatCellValue(cell);

			System.out.println(data);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}

	public static void readMultipleData() {

		File file = new File(excelPath);
		try {
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheetAt(0);
			Row row = sheet.getRow(1);

			for (int i = 0; i < row.getLastCellNum(); i++) {
				Cell cell = row.getCell(i);
				DataFormatter dataFormat = new DataFormatter();
				String data = dataFormat.formatCellValue(cell);
				System.out.println(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void getAllData() {
		File file = new File(excelPath);
		try {
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheetAt(0);

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);

				for (int j = 0; j < row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
					DataFormatter dataFormat = new DataFormatter();
					String data = dataFormat.formatCellValue(cell);
					System.out.println(data);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void writeData() {
		

		try {
			File file = new File(excelPath);
			FileInputStream fileInput =  new FileInputStream(file);
			Workbook book = new XSSFWorkbook(fileInput);
			
			
			
			
			
			
			
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getAllData();
	}
}
