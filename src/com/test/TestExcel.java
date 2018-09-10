package com.test;

import java.io.File;
import java.io.IOException;

import com.wangyang.dao.ExcelDaoFactory;
import com.wangyang.dao.IExcelDao;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestExcel {
	static IExcelDao ed = ExcelDaoFactory.createExcelDao();
	
	public static void main(String[] args) {
		
		System.out.println(ed.readColumn("D:\\test\\test.xls", 0)[2].getContents());
		
//		
//		File file = new File("D:\\\\test\\\\test.xls");
//		try {
//			Workbook workbokk = Workbook.getWorkbook(file);
//			
//			
//		} catch (BiffException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}
}
