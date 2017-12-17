package com.bwf.learning;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDemo {
	public static void main(String[] args) throws IOException {
		Workbook wb = new XSSFWorkbook(new FileInputStream(new File("D:\\workspace\\training\\src\\test\\resources\\loginTestData.xlsx")));
		Sheet sheet = wb.getSheet("Sheet1");
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(lastRowNum).getLastCellNum();
		System.out.println(lastRowNum);
		System.out.println(lastCellNum);
		for(int i = 0; i <= lastRowNum; i++) {
			for(int j = 0; j < lastCellNum; j++) {
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"\t");
			}
			System.out.println();
		}
		wb.close();
	}
}
